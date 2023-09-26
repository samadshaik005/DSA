class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAtfront(int data) {
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
    }

    public void insertAtEnd(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
    }

    public void insertAfter(Node prev_node, int data) {
        Node newnode = new Node(data);
        if (prev_node == null) {
            System.out.println("prev node cannot be null");
            return;
        }
        newnode.next = prev_node.next;
        prev_node.next = newnode;
    }

    public void deletetAtfront() {
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    public void deletetAtEnd() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deletetAtmiddle(int position) {
        Node temp = head;
        if (head == null)
            return;
        if (position == 0) {
            head = head.next;
            return;
        }
        int i = 2;
        while (i < position) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node nextt = null;

        while (curr != null) {
            nextt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextt;
        }
        head = prev;
    }

    public void middleElement() {
        Node slowpointer = head;
        Node fastpointer = head;
        while (fastpointer != null && fastpointer.next != null) {
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;
        }
        System.out.println(slowpointer.data);
    }

    public void nthElementFronEndOfTheList(int n) {
        Node first = head;
        Node second = head;
        int i = 0;
        while (i < n) {
            first = first.next;
            i++;
        }
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        System.out.println(second.data);
    }

    public void detectLoopinList() {
        Node slowpointer = head;
        Node fastpointer = head;

        boolean isLoop = false;
        while (fastpointer != null && fastpointer.next != null) {
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;

            if (slowpointer == fastpointer) {
                isLoop = true;
                break;
            }
        }
        System.out.println(isLoop);

        // If loop exists. Start slow from head and fast from meeting point
        slowpointer = head;
        while (slowpointer != fastpointer) {
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next;
        }
        System.out.println(slowpointer.data);
    }

    public boolean checkListIsPalindrome() {
        Node slowpointer = head;
        Node fastpointer = head;

        while (fastpointer != null && fastpointer.next != null) {
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;
        }
        Node reversedListFirstElement = reversedList(slowpointer.next);
        Node first = head;
        Node second = reversedListFirstElement;

        while (second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public Node reversedList(Node head) {
        Node prev = null;
        Node curr = head;
        Node nextt = null;
        while (curr != null) {
            nextt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextt;
        }
        return prev;
    }

    public Node intersectionPointOfTwoLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null) {
            while (temp2 != null) {
                if (temp2.data == temp1.data) {
                    return temp2;
                }
                temp2 = temp2.next;
            }
            temp2 = head2; // Reset temp2 to the beginning of the second list
            temp1 = temp1.next;
        }
        return null;
    }

    public void rotateListByKpositions(int k) {
        Node temp = head;
        int n = 0;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        temp.next = head;
        //case 1 : n=5 ,k=2 then jumps=n-k works
        //case 2: n=5 ,k=8 here k>n then case 1 not works so we should use k=k%n i.e k=8%5=3 .
        k = k % (n + 1); //n is started with 0 previously ,so size count 1 lesser
        int jumps = n - k;
        Node temp1 = head;

        while (jumps > 0) {
            temp1 = temp1.next;
            jumps--;
        }
        head = temp1.next;
        temp1.next = null;
    }

    public void removeDuplicateElementsFromSortedList() {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    public Node mergeTwoLinkedListsinAlternativePositions(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            Node curr1 = temp1.next;
            Node curr2 = temp2.next;

            temp1.next = temp2;
            temp2.next = curr1;
            temp1 = curr1;
            temp2 = curr2;
        }
        return head1;
    }

    public void removeNodeWithoutUsingHead(Node tempnode) {
        //check node is not lastnode
        if (tempnode != null && tempnode.next != null) {
            System.out.println("we cannot delete lastnode without header");
        }
        tempnode.data = tempnode.next.data;
        tempnode.next = tempnode.next.next;
    }

    public void countNodesinCircularList() {
        //here we know that its alredy circularlist ,so no need to use fastpointer and slowpointer
        Node temp = head.next;
        int count = 1;
        while (temp!=null && temp != head) {
            temp = temp.next;
            count++;
        }
        System.out.println(count);
    }
}


public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        //  list.insertAtfront(1);
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.printList();
        System.out.println("-----");
        list.removeDuplicateElementsFromSortedList();
        list.printList();
        //      list.middleElement();
        // list.nthElementFronEndOfTheList(0);
        // System.out.println(list.checkListIsPalindrome());
    }
}
