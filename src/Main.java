import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree tree= treeFiller();
//        checkAll(tree.AinOrder());
        tree.delete(100);
        tree.printInOrder();
    }
    public static void checkAll(ArrayList<Integer> nums){
        MyBinaryTree<Integer>redo;
        for(int i =0; i<nums.size();i++){
            redo=treeFiller();
            redo.sdelete(nums.get(i));
            System.out.println(redo.exists(nums.get(i)));
            System.out.println(nums.get(i));
        }
        redo=treeFiller();
        for(int i =0; i<nums.size();i++) {
            redo.sdelete(nums.get(i));
            System.out.println(redo.exists(nums.get(i)));
            System.out.println(nums.get(i));
        }
        redo.printInOrder();
    }
    public static MyBinaryTree treeFiller(){
        MyBinaryTree<Integer> toBeFilled = new MyBinaryTree<>();
        toBeFilled.add(100);
        toBeFilled.add(23);
        toBeFilled.add(230);
        toBeFilled.add(105);
        toBeFilled.add(15);
        toBeFilled.add(26);
        toBeFilled.add(235);
        toBeFilled.add(290);
        toBeFilled.add(215);
        toBeFilled.add(245);
        toBeFilled.add(220);
        return toBeFilled;
    }
}