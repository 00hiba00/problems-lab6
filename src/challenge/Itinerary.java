package challenge;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Itinerary {
    public static void main(String[] args) {
        LinkedList<Place> itinerary = new LinkedList<>();

        // Add places in order of distance from Sydney
        addPlace(itinerary, new Place("Sydney", 0));
        addPlace(itinerary, new Place("Brisbane", 917));
        addPlace(itinerary, new Place("Adelaide", 1374));
        addPlace(itinerary, new Place("Melbourne", 877));
        addPlace(itinerary, new Place("Perth", 3923));
        addPlace(itinerary, new Place("Darwin", 2771));
        addPlace(itinerary, new Place("Alice Springs", 2771));

        // Interactive menu
        navigateItinerary(itinerary);
    }

    // Add place in order of distance, no duplicates
    private static void addPlace(LinkedList<Place> list, Place newPlace) {
        ListIterator<Place> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Place current = iterator.next();
            if (current.getName().equalsIgnoreCase(newPlace.getName())) {
                return; // duplicate
            }
            if (newPlace.getDistanceFromStart() < current.getDistanceFromStart()) {
                iterator.previous();
                iterator.add(newPlace);
                return;
            }
        }
        list.addLast(newPlace); // add at end if larger than all
    }

    private static void navigateItinerary(LinkedList<Place> list) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Place> iterator = list.listIterator();
        boolean quit = false;
        boolean goingForward = true;

        printMenu();

        while (!quit) {
            System.out.print("\nSelect action: ");
            String action = scanner.nextLine().toUpperCase();

            switch (action) {
                case "F":
                case "FORWARD":
                    if (!goingForward && iterator.hasNext()) {
                        iterator.next(); // adjust cursor when changing direction
                    }
                    goingForward = true;

                    if (iterator.hasNext()) {
                        System.out.println("Now visiting: " + iterator.next());
                    } else {
                        System.out.println("Reached the end of the itinerary.");
                    }
                    break;

                case "B":
                case "BACKWARD":
                    if (goingForward && iterator.hasPrevious()) {
                        iterator.previous(); // adjust cursor when changing direction
                    }
                    goingForward = false;

                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting: " + iterator.previous());
                    } else {
                        System.out.println("At the start of the itinerary.");
                    }
                    break;

                case "L":
                case "LIST":
                    System.out.println("\n--- Places in itinerary ---");
                    for (Place p : list) {
                        System.out.println(" - " + p);
                    }
                    break;

                case "M":
                case "MENU":
                    printMenu();
                    break;

                case "Q":
                case "QUIT":
                    quit = true;
                    System.out.println("Exiting itinerary navigation.");
                    break;

                default:
                    System.out.println("Unknown action. Enter M to see menu.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nAvailable actions (type letter or word):");
        System.out.println("(F)orward, (B)ackward, (L)ist Places, (M)enu, (Q)uit");
    }
}
