package DataStructure;

/**
 * @author pengh
 */
public class LinkNode {

    private int id;
    private LinkNode next;

    public LinkNode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public void printNode(){
        String s = "{id:"+id ;
        if (null != next) {
            s = s + "  , next:" + next.id ;
        }
        s = s +" }";
        System.out.println(s);
    }
}
