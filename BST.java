
class BST {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    Node root;

    // Insertion
    Node insert(Node r, int d) {
        if (r == null)
            return new Node(d);

        if (d < r.data)
            r.left = insert(r.left, d);
        else if (d > r.data)
            r.right = insert(r.right, d);

        return r;
    }

    // Searching
    boolean search(Node r, int d) {
        if (r == null)
            return false;
        if (r.data == d)
            return true;
        if (d < r.data)
            return search(r.left, d);
        return search(r.right, d);
    }

    // Deletion (simplified)
    Node delete(Node r, int d) {
        if (r == null)
            return null;

        if (d < r.data)
            r.left = delete(r.left, d);
        else if (d > r.data)
            r.right = delete(r.right, d);
        else {
            if (r.left == null)
                return r.right;
            if (r.right == null)
                return r.left;

            Node t = r.right;
            while (t.left != null)
                t = t.left;

            r.data = t.data;
            r.right = delete(r.right, t.data);
        }
        return r;
    }

    // Traversal
    void inorder(Node r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + " ");
            inorder(r.right);
        }
    }

    public static void main(String[] args) {
        BST b = new BST();

        b.root = b.insert(b.root, 40);
        b.root = b.insert(b.root, 20);
        b.root = b.insert(b.root, 60);
        b.root = b.insert(b.root, 10);
        b.root = b.insert(b.root, 30);

        System.out.print("BST: ");
        b.inorder(b.root);

        System.out.println("\nSearch 30: " + b.search(b.root, 30));

        b.root = b.delete(b.root, 20);

        System.out.print("After deletion: ");
        b.inorder(b.root);
    }
}
