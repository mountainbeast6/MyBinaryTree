public class MyBinaryTreeNode <T extends Comparable<T>>{
    private T data;
    private MyBinaryTreeNode<T> left;
    private MyBinaryTreeNode<T> right;

    public MyBinaryTreeNode(T data) {
        this.data = data;
    }

    public MyBinaryTreeNode(T data, MyBinaryTreeNode<T> left, MyBinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyBinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(MyBinaryTreeNode<T> left) {
        this.left = left;
    }

    public MyBinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(MyBinaryTreeNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString(){
        return data.toString();
    }
}
