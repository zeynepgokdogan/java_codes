//Zeynep Gokdogan

public class cms {
    private Node root;

    class Node {
        Contact contact;
        Node left, right;

        Node(Contact contact) {
            this.contact = contact;
            left = right = null;
        }
    }
    public Node getRoot() {
        return root;
    }

    public void insert(Contact contact) {
        if (root == null) {
            root = new Node(contact);
        } else {
            Node current = root;
            while (true) {
                if (contact.lastName.compareTo(current.contact.lastName) < 0) {
                    if (current.left == null) {
                        current.left = new Node(contact);
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = new Node(contact);
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public void displayPreorder(Node node) {
        if (node == null)
            return;
        System.out.println(node.contact);
        displayPreorder(node.left);
        displayPreorder(node.right);
    }

    public void displayInorder(Node node) {
        if (node == null)
            return;
        displayInorder(node.left);
        System.out.println(node.contact);
        displayInorder(node.right);
    }

    public void displayPostorder(Node node) {
        if (node == null)
            return;
        displayPostorder(node.left);
        displayPostorder(node.right);
        System.out.println(node.contact);
    }

    public Contact search(String lastName) {
        Node current = root;
        while (current != null) {
            if (lastName.compareTo(current.contact.lastName) == 0) {
                return current.contact;
            } else if (lastName.compareTo(current.contact.lastName) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void delete(String lastName) {
        root = deleteNode(root, lastName);
    }

    private Node deleteNode(Node root, String lastName) {
        if (root == null)
            return root;

        if (lastName.compareTo(root.contact.lastName) < 0) {
            root.left = deleteNode(root.left, lastName);
        } else if (lastName.compareTo(root.contact.lastName) > 0) {
            root.right = deleteNode(root.right, lastName);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.contact = minValueNode(root.right).contact;
                root.right = deleteNode(root.right, root.contact.lastName);
            }
        }
        return root;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}