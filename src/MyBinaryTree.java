import java.security.PublicKey;
import java.util.ArrayList;

public class MyBinaryTree<T extends Comparable<T>> {
    private MyBinaryTreeNode<T> root;

    public MyBinaryTree() {
        root = null;
    }

    public void add(T data) {
        if (root == null)
            root = new MyBinaryTreeNode<>(data);
        else
            addRecur(root, data);
        Balance();
    }
    public MyBinaryTree<T> Balance() {
        ArrayList<T>stuff=AinOrder();
        MyBinaryTree<T> boi = new MyBinaryTree<>();
        if(stuff.size()!=0) {
            root = new MyBinaryTreeNode<>(stuff.remove(stuff.size() / 2));
            while (stuff.size() > 0) {
                this.addRecur(root,stuff.remove(stuff.size() / 2));
            }
        }
        return this;
    }
    private void addRecur(MyBinaryTreeNode<T> root, T data) {
        if (data.compareTo(root.getData()) < 0) {
            if (root.getLeft() == null) {
                root.setLeft(new MyBinaryTreeNode<>(data));
            } else {
                addRecur(root.getLeft(), data);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new MyBinaryTreeNode<>(data));
            } else {
                addRecur(root.getRight(), data);
            }
        }
    }

    public void printInOrder() {
        printInOrderRecur(root);
    }

    public void printInOrderRecur(MyBinaryTreeNode<T> node) {
        if (node == null)
            return;
        printInOrderRecur(node.getLeft());
        System.out.println(node);
        printInOrderRecur(node.getRight());
    }
    public ArrayList<T> AinOrder(){
        ArrayList<T> bitch =new ArrayList<T>();
        return (AinOrderRecur(root, bitch));
    }
    private ArrayList<T>AinOrderRecur(MyBinaryTreeNode<T> node, ArrayList<T> lister){
        if (node == null)
            return lister;
        AinOrderRecur(node.getLeft(),lister);
        lister.add(node.getData());
        AinOrderRecur(node.getRight(),lister);
        return lister;
    }

    public boolean exists(T data) {
        return (searcher(data, root) >= 0);
    }

    public int searcher(T data, MyBinaryTreeNode<T> node) {
        int counter = 0;
        while (node != null) {
            if (node.getData().equals(data))
                return counter;
            counter++;
            if (data.compareTo(node.getData()) < 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return -1;
    }
    public MyBinaryTreeNode<T> finder(MyBinaryTreeNode<T> node, boolean firstPass){
        if (firstPass) {
            if (node.getLeft() == null || node.getRight() == null) {
                return node;
            } else if(node.getLeft().getRight()==null){
                return node;
            }else{
                return finder(node.getLeft(), false);
            }
        }
        else {
                if (node.getRight().getRight() == null) {
                    return node;
                } else {
                    return finder(node.getRight(), false);
                }
        }
    }

    public void sdelete(T tar){
        int count = searcher(tar, root);
        MyBinaryTreeNode<T> curr = root;
        MyBinaryTreeNode<T> prev = root;
        for (int i = 0; i < count; i++) {
            prev=curr;
            curr= (tar.compareTo(curr.getData()) < 0 ? curr.getLeft() : curr.getRight());
        }
        if(count!=0||root.getRight()!=null||root.getLeft()!=null) {
            MyBinaryTreeNode<T> temp = finder(curr, true);
            if (temp.getRight() != (null)) {
                curr.setData(temp.getRight().getData());
                cleanUp(searcher(temp.getData(), root), temp.getData());
            } else if (temp.getLeft() != null) {
                curr.setData(temp.getLeft().getData());
                cleanUp(searcher(temp.getData(), root), temp.getData());
            } else {
                if (prev.getData().compareTo(curr.getData()) < 0) {
                    prev.setRight(null);
                } else {
                    prev.setLeft(null);
                }
            }
        } else {
            root=null;
        }
        Balance();
    }
    public void cleanUp(int depth, T tar){
        MyBinaryTreeNode<T> curr = root;
        MyBinaryTreeNode<T> doubcheck = root;
        for (int i = 0; i < depth; i++) {
            doubcheck=curr;
            curr= (tar.compareTo(curr.getData()) < 0 ? curr.getLeft() : curr.getRight());
        }
        if(curr.getRight()!=null) {
            if (doubcheck.getData().compareTo(curr.getData()) < 0) {
                curr.setLeft(curr.getRight().getLeft());
                curr.setRight(curr.getRight().getRight());
            } else {
                curr.setRight(curr.getRight().getLeft());
            }
        } else {

        }
    }
    public void delete(T tar) {
        int count = searcher(tar, root);
        MyBinaryTreeNode<T> curr = root;
        MyBinaryTreeNode<T> prev = root;
        MyBinaryTreeNode<T> found;
        MyBinaryTreeNode<T> foundPrev;
        if (root.getData().equals(tar)) {
            if (exists(tar)) {
                for (int i = 0; i < count - 1; i++) {
                    root = (tar.compareTo(curr.getData()) < 0 ? curr.getLeft() : curr.getRight());
                    if (curr.getLeft() == (null)) {
                        root = curr.getRight();
                    } else {
                        curr = root.getLeft();
                        while (curr.getRight() != null) {
                            prev = curr;
                            curr = curr.getRight();
                        }
                        prev.setRight(curr.getLeft());
                        curr.setRight(root.getRight());
                        curr.setLeft(root.getLeft());
                        root = curr;
                    }
                }
            }
            } else {
                if (exists(tar)) {
                    for (int i = 0; i < count - 1; i++) {
                        curr = (tar.compareTo(curr.getData()) < 0 ? curr.getLeft() : curr.getRight());
                    }
                }
                if (tar.compareTo(curr.getData()) < 0) {
                    prev = curr.getLeft();
                    if (prev.getLeft() != null) {
                        curr.setLeft(prev.getLeft());
                    } else {
                        curr.setLeft(null);
                    }
                } else {
                    prev = curr.getRight();
                    if (prev.getRight() != null) {
                        curr.setRight(prev.getRight());
                    } else {
                        curr.setRight(null);
                    }
                }
            }
        }
    }

