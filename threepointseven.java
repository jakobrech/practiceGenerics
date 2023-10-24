public class threepointseven {

    private String name;
    private int score;

    public void GameEntry(String name, int score) {

        this.name = name;
        this.score = score;

    }

    public String getName() {

        return name;

    }

    public int getScore() {

        return score;

    }

    public String toString() {

        return "(" + name + ", " + score + ")";

    }

}

public class TopTenScores {

    private GameEntry[] topScores;
    private int size;

    public TopTenScores() {

        topScores = new GameEntry[10];
        size = 0;

    }

    public void add(GameEntry entry) {

        if (size < topScores.length || entry.getScore() > topScores[size - 1].getScore()) {

            if (size < topScores.length) {

                size++;

            }

            int i = size - 1;

            while (i > 0 && entry.getScore() > topScores[i - 1].getScore()) {

                topScores[i] = topScores[i - 1];
                i--;

            }

            topScores[i] = entry;

        }

    }

    public void remove(int index) {
        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("Invalid index");

        }

        for (int i = index; i < size - 1; i++) {

            topScores[i] = topScores[i + 1];

        }

        topScores[size - 1] = null;
        size--;

    }

    public String toString() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {

            result.append(topScores[i].toString());

            if (i < size - 1) {

                result.append(", ");

            }

        }

        return result.toString();

    }

}

