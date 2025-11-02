package problem5;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book b2 = new Book("1984", "George Orwell", 1949);
        Book b3 = new Book("Clean Code", "Robert C. Martin", 2008);

        // --- Stack Test ---
        System.out.println("=== Stack Test ===");
        BookStack stack = new BookStack();
        stack.push(b1);
        stack.push(b2);
        stack.push(b3);

        stack.display();

        System.out.println("Popped: " + stack.pop());
        System.out.println("Top: " + stack.peek());

        stack.display();

        // --- Queue Test ---
        System.out.println("\n=== Queue Test ===");
        BookQueue queue = new BookQueue();
        queue.enqueue(b1);
        queue.enqueue(b2);
        queue.enqueue(b3);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());

        queue.display();
    }
}
