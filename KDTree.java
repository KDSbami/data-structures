public class KDTree {

    class kdTreeNode {

        kdTreeNode left = null;
        kdTreeNode right = null;
        int[] coordinates;

        kdTreeNode(int[] coordinates) {
            this.coordinates = coordinates; 
        }
    }

    kdTreeNode root = null;
    int dimension;

    KDTree(int[] coordinates,int dimension) {
        if(dimension<=0) {
            System.out.print("dimension cant be -ve or 0.");
        } else {
            this.root = new kdTreeNode(coordinates);
            this.dimension = dimension;
        }
        
    }

    void __addNode(kdTreeNode currentNode, int[] coordinates, int currentLevel) {
        if(currentNode == null) return;
        int currentDimension = (currentLevel-1) % this.dimension;
        if(currentNode.coordinates[currentDimension]>=coordinates[currentDimension]) {
            if(currentNode.right == null) {
                currentNode.right = new kdTreeNode(coordinates);
                return;
            } else {
                __addNode(currentNode.right,coordinates,currentLevel+1);
            }  
        } 
        else {
            if(currentNode.left == null) {
                currentNode.left = new kdTreeNode(coordinates);
                return;
            } else {
                __addNode(currentNode.left,coordinates,currentLevel+1);
            }
        }
    }
    
    void addNode(int[] coordinates){
        __addNode(this.root, coordinates, 1);
    }
    
    public static void main(String[] args) {

    }
}
