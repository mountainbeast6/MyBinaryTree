public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer>tree= new MyBinaryTree<>();
        tree.add(100);
        tree.add(23);
        tree.add(230);
        tree.add(105);
        tree.add(15);
        tree.add(26);
        tree.add(235);
        tree.add(290);
        tree.add(215);


        tree.printInOrder();
        System.out.println(tree.exists(15));
        tree.sdelete(105);
        tree.printInOrder();

    }
}