package problem3;

public class Textbook extends Book {
    private String level;

    public Textbook(String title, String author, int nbrPages, String level) {
        super(title, author, nbrPages);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Textbook -> " + super.toString() + " | Level: " + level;
    }
}
