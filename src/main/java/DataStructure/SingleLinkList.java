package DataStructure;

/**
 * @author pengh
 */
public class SingleLinkList {
    private LinkNode firstNode;



    public void insertFirst(int d){
        LinkNode newNode = new LinkNode(d);
        newNode.setNext(firstNode);
        firstNode  = newNode;
    }
    public LinkNode removeFirst(){
        LinkNode temp = firstNode;
        firstNode = firstNode.getNext();
        return  temp;
    }

    public LinkNode findById(int d){
        LinkNode temp = firstNode;
        while(temp.getId() != d){
            if(temp.getNext() == null){
                return null;
            }
            else{
                temp = temp.getNext();
            }
        }
        return temp;
    }

    public LinkNode removeById(int d){
      LinkNode prenode = firstNode;
      LinkNode tempnode = firstNode;
      while (tempnode.getId() != d){
          prenode = tempnode;
          if(tempnode.getNext() == null){
              return null;
          }
          else{

              tempnode = tempnode.getNext();


          }
      }
      if (tempnode.equals(firstNode)){
          firstNode = firstNode.getNext();
      }
      else{
          prenode.setNext(tempnode.getNext());
      }

      return tempnode;

    }

    public void Display(){
        System.out.println("========================");
        LinkNode tempnode = firstNode;
        while (tempnode != null){
            tempnode.printNode();
            tempnode = tempnode.getNext();
        }
    }

    public static void main(String[] args) {
        SingleLinkList t = new SingleLinkList();
        t.insertFirst(2);
        t.insertFirst(6);
        t.insertFirst(3);
        t.insertFirst(9);
        t.Display();
//        t.removeFirst();
//        t.Display();
        t.removeById(6);
        t.Display();

    }

}
