package Utils.AlgoExpert;

public class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;

    public BinaryTree(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                '}';
    }
}
