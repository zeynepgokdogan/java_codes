//Zeynep Gokdogan
class Node {

    public Country data;
    public Node next;
    public Node previous;

    public Node(Country country) {
        data = country;
    }

    public void displayNode() {
        data.displayCountry();
    }
}

class DoublyLinkedList {

    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertLast(Country country) {
        Node newNode = new Node(country);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void insertFirst(Country country) {
        Node newNode = new Node(country);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next= head;
            head = newNode;
        }
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
