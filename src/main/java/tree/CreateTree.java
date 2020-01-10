package tree;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CreateTree {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        List<BillData> bills = DataUtil.getData(2500000);
        LocalDateTime timeStart1 = LocalDateTime.now();
        Map<String, List<BillData>> collect = bills.stream().collect(groupingBy(e -> fetchGroupKey(e)));
        for ( Map.Entry<String,List<BillData>> c:collect.entrySet()) {
            System.out.println(c.getKey()+"==="+c.getValue());
            List<BillData> value = c.getValue();
            System.out.println(value.get(0));
        }
        LocalDateTime timeEnd1 = LocalDateTime.now();
        System.out.println(Duration.between(timeStart1,timeEnd1).toMillis());




        CreateTree createTree = new CreateTree();
        TreeNode treeNode = new TreeNode();
        System.out.println("=========================================================");
        LocalDateTime timeStart = LocalDateTime.now();
        System.out.println(LocalDateTime.now());

        List<Integer> nodeIds = createTree.groupSettlementDetailBills(bills, treeNode);
        System.out.println(nodeIds);
        nodeIds.parallelStream().forEach(nodeId -> {
            List<BillData> data = (List<BillData>)treeNode.findTreeNodeById(nodeId).getData();
            List<TreeNode> juniors = treeNode.getJuniors();
            System.out.println(nodeId+"***"+data.get(0));
//            data.stream().forEach(item -> System.out.println(item));
        });
        LocalDateTime timeEnd = LocalDateTime.now();
        System.out.println(Duration.between(timeStart,timeEnd).toMillis());
    }
    private static  String fetchGroupKey(BillData billData){
        return billData.getCorCode()+ "+"+billData.getCusCode()+"+"+billData.getSourceCode()+"+"+billData.getType();
    }
    /**
     * 汇总订单数据
     * */
    private List<Integer> groupSettlementDetailBills(List<BillData> bills, TreeNode treeNode) {

        // 组装分组条件，List初始化容量为4
        //  Function<T, R>接收T对象，返回R对象
        List<Function<BillData, String>> functions = new ArrayList<>(4);
        // BillData::getCorCode就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
        // 数据分组【组织】 获取corCode 值
        functions.add(BillData::getCorCode);

        // 第二次数据分组【客商】
        functions.add(BillData::getCusCode);

        // 第三次数据分组【来源系统】
        functions.add(BillData::getSourceCode);

        // 如果数据集存在两种类型的数据，则进行分组处理
        functions.add(BillData::getType);

        List<Integer> nodeIds = processData(functions, bills, treeNode);

        return nodeIds;
    }

    /**
     * 处理Map数据，将数据对象存入多叉树中，并返回多叉树节点id
     * */
    private List<Integer> processData(List<Function<BillData, String>> functions, List<BillData> data, TreeNode treeNode) {
        final List<Integer> nodeIds = new ArrayList<>(24);
        functions.forEach(function -> {
            if (nodeIds == null || nodeIds.size() == 0) {
                nodeIds.addAll(process(data, treeNode, function, treeNode.getSelfId()));
            } else {
                List<Integer> tempNodeIds = new ArrayList<>(nodeIds);
                // 清理数据
                nodeIds.clear();
                tempNodeIds.stream().forEach(id -> {
                    List<BillData> treeData = (List<BillData>) treeNode.findTreeNodeById(id).getData();
                    nodeIds.addAll(process(treeData, treeNode, function, id));
                });
            }
        });
        return nodeIds;
    }

    private List<Integer> process(List<BillData> data, TreeNode treeNode, Function<BillData, String> function, Integer nodeId) {
        List<Integer> nodeIds = new ArrayList<>(16);
        //  .collect(groupingBy(...)) 需要指定一个属性才能使用，通过该属性执行分组。
        //  我们通过提供功能接口的实现来实现这一点 ,通常通过传递lambda表达式。
        // groupingBy(function) 根据data中每个BillData对象的corCode值进行分组
        Map<String, List<BillData>> groupDate = data.parallelStream().collect(groupingBy(function));
        groupDate.entrySet().parallelStream().forEach(entry -> {
            String key = entry.getKey();
            List<BillData> value = entry.getValue();
            TreeNode childNode = new TreeNode();
            Integer selfId = atomicInteger.addAndGet(1);
            nodeIds.add(selfId);
            childNode.setSelfId(selfId);
            childNode.setData(value);
            childNode.setNodeName(key);
            treeNode.findTreeNodeById(nodeId).addChildNode(childNode);
        });
        return nodeIds;
    }
}
