package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        stack = new LinkedList<>();
    }

    public void push(Book book) {
        stack.addFirst(book);  // push → addFirst
    }

    public Book pop() {
        if (!stack.isEmpty()) {
            return stack.removeFirst();  // pop → removeFirst
        }
        return null; // or throw exception
    }

    public Book peek() {
        if (!stack.isEmpty()) {
            return stack.getFirst();  // peek → getFirst
        }
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        for (Book book : stack) {
            System.out.println(" - " + book);
        }
    }
}
