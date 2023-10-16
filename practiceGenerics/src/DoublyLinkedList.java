import java.util.Random;
public class DoublyLinkedList <E> {

    private Node<E> head;
    private Node<E> tail;

    public void add(E data){

        Node<E> newNode = new SingleNode<E>(data);

        if(head == null){

            head = newNode;
            tail = newNode;

        }
        else{

            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;

        }

    }

    public E displayLast(){

        Node<E> current = head;

        while(current.getNext() != null){

            current = current.getNext();

        }

        return current.getData();

    }

    public E search(E data){

        Node<E> current = head;

        while(current.getNext() != null){

            if(current.getData() == data){

                return current.getData();

            }

            current = current.getNext();

        }

        return null;

    }

    public void remove(){

        Node<E> current = head;

        while(current.getNext().getNext() != null){

            current = current.getNext();

        }

        current.setNext(null);

    }

    public void remove(E data){

        Node<E> current = head;
        Node<E> prev;

        while(current.getNext() != null){

            if(current.getNext().getData() == data && current.getNext().getNext() != null){

                current.setNext(current.getNext().getNext());
                current = current.getNext();
                current = current.getPrev().getPrev();

            }

            if(current.getNext().getData() == data && current.getNext().getNext() == null){

                remove();

            }

        }


    }

    public String displayForward(){

        Node<E> current = head;
        String result = "";

        while(current.getNext() != null){

            result += current.getData().toString();

        }
        result += current.getData().toString();

        return result;

    }

    public String displayBackwards(){

        Node<E> current = tail;
        String result = "";

        while(current.getPrev() != null){

            result += current.getData().toString();
            current = current.getPrev();

        }
        result += current.getData().toString();

        return result;

    }

    //3.2
    public void removeRandomlyUntilEmpty() {

        Random rand = new Random();

        while (head != null) {

            int randomIndex = rand.nextInt(size()); // Generate a random index within the current list size

            // Traverse to the randomly selected node
            Node<E> current = head;

            for (int i = 0; i < randomIndex; i++) {

                current = current.getNext();

            }

            // Remove the selected node
            if (current == head) {

                // If the selected node is the head
                head = head.getNext();

                if (head != null) {

                    head.setPrev(null);

                }
            } else if (current == tail) {

                // If the selected node is the tail
                tail = tail.getPrev();

                if (tail != null) {

                    tail.setNext(null);

                }
            } else {

                // If the selected node is in the middle
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());

            }
        }
    }

    //3.9/3.11 - self-explanatory
    private int size() {

        int size = 0;
        Node<E> current = head;

        while (current != null) {

            size++;
            current = current.getNext();

        }

        return size;

    }

    //3.3 answer - use google translate API

    //3.6 answer - copied and edited from search()
    public Node<E> getSecondLast(){

        Node<E> current = head;

        while(current.getNext().getNext() != null){

            current = current.getNext();

        }

        return current;

    }

}
