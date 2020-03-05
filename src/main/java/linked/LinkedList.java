
package linked;

public class LinkedList {
    private Node head ;

    public void add(int index,Object obj){
        Node newNode = new Node(obj);
        Node temporary = head;
        Node node = findNode(index);
        newNode.setNext(node);
        if (index ==0){
            this.head = newNode;
            return;
        }
        Node n = temporary.getNext();
        int i = 1;
        while (n !=null){
            if (index ==i){
                temporary.setNext(newNode);
                return;
            }
            temporary = n;
            n = n.getNext();
            i++;
        }

    }
    public void add(Object obj){
        Node newNode = new Node(obj);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temporary = head;
        while (temporary.getNext() !=null){
            temporary = temporary.getNext();
        }
        temporary.setNext(newNode);
    }
    public Node findNode(int i) {
        Node temporary = head;
        if (i==0){
            return first();
        }
        if (i == size()){
            return last();
        }
        int num = 0;
        while (temporary.getNext() !=null){
            if (num == i) {
                return temporary;
            }
            temporary = temporary.getNext();
            num++;
        }
        return null;
    }
    public Object get(int i){
        Node node = findNode(i);
        return node==null ? null : node.getData();
    }

    public Boolean remove(int i){
        Node node = findNode(i);
        if (node == null){
            return false;
        }
        Node temporary = head;
        if (i==0){
            temporary = temporary.getNext();
            this.head = temporary;
            return true;
        }
        Node n = temporary.getNext();
        int num = 1;
        while (n!=null){
            if (num == i){
                temporary.setNext(n.getNext());
                return true;
            }
            temporary = n;
            n = n.getNext();
            num++;

        }
        return false;
    }

    public Node first(){
        return head;
    }

    public Node last(){
        Node temporary = head;
        while (temporary.getNext() !=null){
            temporary = temporary.getNext();
        }
        return temporary;
    }

    public int size(){
        Node temporary = head;
        int size = 0;
        while (temporary.getNext() !=null){
            temporary = temporary.getNext();
            size++;
        }
        return size;
    }
    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }
}
