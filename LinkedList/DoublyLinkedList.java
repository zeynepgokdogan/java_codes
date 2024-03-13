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

    public void insertFirst(Country country) {
        Node newNode = new Node(country);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public boolean delete(String country) {
        Node current = head;
        boolean deleted = false;
    
        while (current != null) {
            if (current.data.getCountryName().equalsIgnoreCase(country)) {
                if (current.previous != null) {
                    current.previous.next = current.next;
                } else {
                    head = current.next;
                }
    
                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    tail = current.previous;
                }
    
                deleted = true;
    
                if (deleted) {
                    System.out.println("Delete " + country + ": Removes the country from the list.");
                } else {
                    System.out.println("Country not found: " + country);
                }
    
                break;
            }
    
            current = current.next;
        }
    
        return deleted;
    }
    

    public void displayList() {
        Node current = head;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
    }

    public boolean containsCountry(String countryName) {
        Node current = head;
        while (current != null) {
            if (current.data.getCountryName().equalsIgnoreCase(countryName)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

}
