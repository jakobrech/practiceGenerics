public class threepointeight {

    private String name;
    private int score;
    private GameEntry prev;
    private GameEntry next;

    public GameEntry(String name, int score) {

        this.name = name;
        this.score = score;

    }

    public String getName() {

        return name;

    }

    public int getScore() {

        return score;

    }

    public GameEntry getPrev() {

        return prev;

    }

    public void setPrev(GameEntry prev) {

        this.prev = prev;

    }

    public GameEntry getNext() {

        return next;

    }

    public void setNext(GameEntry next) {

        this.next = next;

    }

    public String toString() {

        return "(" + name + ", " + score + ")";

    }

}

public class TopTenScores {

    private GameEntry head;
    private GameEntry tail;
    private int size;

    public TopTenScores() {

        head = null;
        tail = null;
        size = 0;

    }

    public void add(GameEntry entry) {

        if (size == 0) {

            head = entry;
            tail = entry;

        } else if (size < 10 || entry.getScore() > tail.getScore()) {

            entry.setPrev(tail);
            tail.setNext(entry);
            tail = entry;

            if (size < 10) {

                size++;

            }

        }

    }

    public void remove(int index) {

        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("Invalid index");

        }

        GameEntry entry = head;

        for (int i = 0; i < index; i++) {

            entry = entry.getNext();

        }

        if (entry == head) {

            head = entry.getNext();

            if (head != null) {

                head.setPrev(null);

            }

        } else if (entry == tail) {

            tail = entry.getPrev();

            if (tail != null) {

                tail.setNext(null);

            }
        } else {

            GameEntry prev = entry.getPrev();
            GameEntry next = entry.getNext();
            prev.setNext(next);
            next.setPrev(prev);

        }

        size--;

    }

    public String toString() {

        StringBuilder result = new StringBuilder();
        GameEntry entry = head;

        while (entry != null) {

            result.append(entry.toString());

            if (entry.getNext() != null) {

                result.append(", ");

            }

            entry = entry.getNext();

        }

        return result.toString();

    }

}

