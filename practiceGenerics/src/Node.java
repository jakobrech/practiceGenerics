public interface Node <E>{

    E getData();

    void setData(E data);

    Node<E> getNext();

    void setNext(Node<E> next);

    Node<E> getPrev();

    void setPrev(Node<E> prev);

}
