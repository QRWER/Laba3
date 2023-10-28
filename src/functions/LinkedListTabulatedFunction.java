package functions;

public class LinkedListTabulatedFunction {

    private static class FunctionNode {
        FunctionPoint data;
        FunctionNode next;
        FunctionNode prev;

        FunctionNode(){
            this.data = null;
            this.next = null;
            this.prev = null;
        }

        FunctionNode(FunctionNode prev, FunctionNode next, FunctionPoint data){
            this.data = new FunctionPoint(data);
            this.next = next;
            this.prev = prev;
        }

        FunctionNode(FunctionNode node) {
            this.data = new FunctionPoint(node.data);
            this.next = node.next;
            this.prev = node.prev;
        }
    }

    private FunctionNode head;

    private int countOfNodes;

    private FunctionNode getNodeByIndex(int index){
        FunctionNode tmp = head.next;
        for(int i = 0; i<index; i++){
            tmp = tmp.next;
        }
        return tmp;
    }

    private FunctionNode FunctionNodeaddNodeToTail(){
        FunctionNode tmp = getNodeByIndex(countOfNodes-1);
        tmp.next = new FunctionNode();
        countOfNodes++;
        return tmp.next;
    }

    private FunctionNode addNodeByIndex(int index){
        FunctionNode oldNode = getNodeByIndex(index);
        FunctionNode newNode = new FunctionNode(oldNode.prev, oldNode, new FunctionPoint());
        oldNode.prev.next = newNode;
        oldNode.prev = newNode;
        countOfNodes++;
        return newNode;
    }

    private FunctionNode deleteNodeByIndex(int index){
        FunctionNode deleteNode = getNodeByIndex(index);
        deleteNode.prev.next = deleteNode.next;
        deleteNode.next.prev = deleteNode.prev;
        countOfNodes--;
        return deleteNode;
    }

}
