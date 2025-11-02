package problem3;

import java.util.Scanner;

public class TestLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter library capacity: ");
        int n = sc.nextInt();
        sc.nextLine();

        Library library = new Library(n);

        // Initialize with two documents
        library.add(new Novel("The Alchemist", "Paulo Coelho", 250, 12.99));
        library.add(new Magazine("Science Today", "October", 2025));

        int choice;
        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add a document");
            System.out.println("2. Display all documents");
            System.out.println("3. Delete a document");
            System.out.println("4. Search a document by record number");
            System.out.println("5. Display all authors");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Choose type: 1-Book 2-Novel 3-Textbook 4-Magazine 5-Dictionary");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    Document doc = null;

                    switch (type) {
                        case 1:
                            System.out.print("Author: ");
                            String author1 = sc.nextLine();
                            System.out.print("Pages: ");
                            int pages1 = sc.nextInt();
                            doc = new Book(title, author1, pages1);
                            break;

                        case 2:
                            System.out.print("Author: ");
                            String author2 = sc.nextLine();
                            System.out.print("Pages: ");
                            int pages2 = sc.nextInt();
                            System.out.print("Price: ");
                            double price = sc.nextDouble();
                            doc = new Novel(title, author2, pages2, price);
                            break;

                        case 3:
                            System.out.print("Author: ");
                            String author3 = sc.nextLine();
                            System.out.print("Pages: ");
                            int pages3 = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Level: ");
                            String level = sc.nextLine();
                            doc = new Textbook(title, author3, pages3, level);
                            break;

                        case 4:
                            System.out.print("Month: ");
                            String month = sc.nextLine();
                            System.out.print("Year: ");
                            int year = sc.nextInt();
                            doc = new Magazine(title, month, year);
                            break;

                        case 5:
                            System.out.print("Language: ");
                            String lang = sc.nextLine();
                            doc = new Dictionary(title, lang);
                            break;
                    }

                    if (doc != null && library.add(doc))
                        System.out.println("Document added successfully!");
                    else
                        System.out.println("Library full or error adding document.");
                    break;

                case 2:
                    library.displayDocuments();
                    break;

                case 3:
                    System.out.print("Enter record number to delete: ");
                    int num = sc.nextInt();
                    Document toDelete = library.document(num);
                    if (toDelete != null && library.delete(toDelete))
                        System.out.println("Document deleted successfully.");
                    else
                        System.out.println("Document not found.");
                    break;

                case 4:
                    System.out.print("Enter record number: ");
                    int num2 = sc.nextInt();
                    Document d = library.document(num2);
                    if (d != null)
                        System.out.println(d);
                    else
                        System.out.println("No document found.");
                    break;

                case 5:
                    library.displayAuthors();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
