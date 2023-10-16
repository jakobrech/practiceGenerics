public class SingleNode <E> implements Node <E>{

    private E data;
    private Node<E> next;
    private Node<E> prev;

    public SingleNode(E data){

        this.data = data;
        this.next = null;
        this.prev = null;

    }

    @Override
    public E getData() {

        return this.data;

    }

    @Override
    public void setData(E data) {

        this.data = data;

    }

    @Override
    public Node<E> getNext() {

        return next;

    }

    @Override
    public void setNext(Node<E> next) {

        this.next = next;

    }

    @Override
    public Node<E> getPrev() {

        return prev;

    }

    @Override
    public void setPrev(Node<E> prev) {

        this.prev = prev;

    }

}