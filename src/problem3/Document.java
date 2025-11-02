package problem3;

public class Document {
    private static int counter = 0;  // for auto-increment
    private int numRec;
    private String title;

    public Document(String title) {
        this.title = title;
        this.numRec = ++counter; // auto-incremental
    }

    public int getNumRec() {
        return numRec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document #" + numRec + " - Title: " + title;
    }
}
