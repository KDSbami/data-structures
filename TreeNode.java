public class TreeNode {

    TreeNode left = null;
    TreeNode right = null;
    int value = 0;

    TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    private static void addNode(TreeNode temp, int value){
        if(value>temp.value) {
            if(temp.right == null) {
                temp.right = new TreeNode(null,null,value);
                return;
            }
            
            addNode(temp.right, value);
            
        } else {
            if(temp.left == null) {
                
                temp.left = new TreeNode(null,null,value);
                return;
            }
            
            addNode(temp.left, value);
            
        }

    }

    static TreeNode bstFromArray(int[] value) {

        TreeNode root = new TreeNode(null,null,value[0]);
        for(int i=1;i < value.length;i++) {
   
        addNode(root,value[i]);
        }    
        
        return root;

    }

    static void printTreeInorder(TreeNode root) {

        if(root == null) return;
    
        printTreeInorder(root.left);

        System.out.print(root.value+" ");
        
        printTreeInorder(root.right);

    }

    public static void main(String args[]) {
        int[] array = {3,56,76,4,2,1,6,8};

        TreeNode head = bstFromArray(array);

        printTreeInorder(head);

    }
}
