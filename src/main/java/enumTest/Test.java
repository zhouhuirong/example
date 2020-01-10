package enumTest;

import com.google.gson.Gson;

import static enumTest.commom.ResourceType.BILL_R;

public class Test {
    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.setId(1);
        bill.setBillType(2);
        bill.setStatus(1);
        bill.setResourceType(BILL_R);
        System.out.println(bill.getBillType()+"=="+bill.getStatus());
        System.out.println(new Gson().toJson(bill));
        String s = new Gson().toJson(bill);
        Bill bill1 = new Gson().fromJson(s, Bill.class);

    }
}
