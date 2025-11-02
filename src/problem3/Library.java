package problem3;

import java.util.ArrayList;

public class Library {
    private int capacity;
    private ArrayList<Document> documents;

    public Library(int capacity) {
        this.capacity = capacity;
        this.documents = new ArrayList<>();
    }

    public boolean add(Document doc) {
        if (documents.size() < capacity) {
            documents.add(doc);
            return true;
        }
        return false;
    }

    public boolean delete(Document doc) {
        return documents.remove(doc);
    }

    public Document document(int numEnrg) {
        for (Document d : documents) {
            if (d.getNumRec() == numEnrg)
                return d;
        }
        return null;
    }

    public void displayDocuments() {
        if (documents.isEmpty()) {
            System.out.println("No documents in the library.");
            return;
        }
        for (Document d : documents)
            System.out.println(d);
    }

    public void displayAuthors() {
        System.out.println("Authors in the library:");
        for (Document d : documents) {
            if (d instanceof Book) {
                System.out.println(((Book) d).getAuthor());
            }
        }
    }
}
