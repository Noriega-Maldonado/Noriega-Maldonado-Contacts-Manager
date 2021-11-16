
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Contacts_Manager {

    private static Scanner scanner;
    private String fullName;
    private int contactNumber;


    public Contacts_Manager(String fullName, int contactNumber) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;

    }


    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getContactNumber() {

        return contactNumber;

    }

    public void setContactNumber(int contactNumber) {

        this.contactNumber = contactNumber;
    }

//    public void deleteContact(int index){
//        printlist.remove(index);
//    }

    public static void viewContacts() throws IOException {

        String directory = "./src/contacts.txt";

        String contacts = "contact.info.txt";

        Path dataDirectory = Paths.get(directory);

        Path contactFile = Paths.get(directory, contacts);


        if (Files.notExists(dataDirectory)) {

            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!Files.exists(contactFile)) {
            try {
                Files.createFile(contactFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        List<String> printContacts = Files.readAllLines(contactFile);

        for (int i = 0; i < printContacts.size(); i++) {

            System.out.println((i + 1) + ". " + printContacts.get(i));


        }
    }

    public static void addContact() throws IOException {

        Scanner sc = new Scanner(System.in);

        String directory = "./src/contacts.txt";

        String contacts = "contact.info.txt";
        Path contactFile = Paths.get(directory, contacts);
        System.out.println("Enter first and last name of contact");
        String userInput = sc.nextLine();
        System.out.println("Enter contact number");
        int userInputNum = sc.nextInt();

        Contacts_Manager contact1 = new Contacts_Manager(userInput, userInputNum);
//        System.out.println("Enter contact number");

        try {
            Path write = Files.write(contactFile, Arrays.asList(contact1.fullName), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void addContactNumber() throws IOException {
//        Scanner sc = new Scanner(System.in);
//
//        String directory = "./src/contacts.txt";
//
//        String contacts = "contact.info.txt";
//        Path contactFile = Paths.get(directory, contacts);
//
//        System.out.println("Enter contact number");
//        int userInputNum = sc.nextInt();
//        contact1.addContact(userInputNum);
//        try {
//           Path write = Files.write(contactFile, Arrays.asList(contact1.contactNumber), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////
////
//    }


    public static void findEntry() {

        Scanner scan = new Scanner(System.in);

        String search;

        String directory = "./src/contacts.txt";

        String contacts = "contact.info.txt";

        Path contactFile = Paths.get(directory, contacts);

        System.out.print("Who would you like to search for: ");
        search = scan.nextLine();

        List<String> printContacts = Collections.singletonList(search);
        try {
            printContacts = Files.readAllLines(contactFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String printContact : printContacts) {

            if (search.equals(printContact)) {

                System.out.print(printContact);

            }
        }
    }

    public static void deleteContact() throws IOException {

        Scanner sc = new Scanner(System.in);

        String directory = "./src/contacts.txt";

        String contacts = "contact.info.txt";

        Path dataDirectory = Paths.get(directory);

        Path contactFile = Paths.get(directory, contacts);


        if (Files.notExists(dataDirectory)) {

            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!Files.exists(contactFile)) {
            try {
                Files.createFile(contactFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        List<String> printContacts = Files.readAllLines(contactFile);

        for (int i = 0; i < printContacts.size(); i++) {

            System.out.println((i + 1) + ". " + printContacts.get(i));

        }
        System.out.println("Which contact would you like to delete?");
        String userInput = sc.nextLine();
        ArrayList<String> updateList = new ArrayList<>();
        for (String line : printContacts) {
            if (line.toLowerCase().contains(userInput.toLowerCase())) {
                continue;
            }
            updateList.add(line);
            Files.write(contactFile, updateList);
//            Files.write(contactFile, updateList);
        }

        printContacts.remove(userInput);
        System.out.println(printContacts.remove(userInput));


        if (printContacts.contains(userInput)) {
            printContacts.remove(userInput);
        }

        ListIterator<String> contactsIterator = printContacts.listIterator();

        while (contactsIterator.hasNext()) {

            if (userInput.equals(contactsIterator.next()))
                contactsIterator.remove();
        }
    }

    // got loop to work just needs refactoring/ cleaning up:
    public static void menu() {

        Scanner sc = new Scanner(System.in);

        String directory = "./src/contacts.txt";

        String contacts = "contact.info.txt";

        Path dataDirectory = Paths.get(directory);

        Path contactFile = Paths.get(directory, contacts);
        if (Files.notExists(dataDirectory)) {

            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!Files.exists(contactFile)) {
            try {
                Files.createFile(contactFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int userInput = 0;
        boolean exit = true;
        userInput = -1;
        while (userInput != 5) {

            do {
                System.out.println("1. View Contacts.");
                System.out.println("2. Add a new contact");
                System.out.println("3. Search a contact by name.");
                System.out.println("4. Delete an existing contact.");
                System.out.println("5. Exit.");
                System.out.println("----------");
                System.out.println("Enter an option (1, 2, 3, 4 or 5) :");
                userInput = sc.nextInt();

//          View Contact:
                if (userInput == 1) {
                    try {
                        viewContacts();
                        System.out.println("----------");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//            add new contact:
                } else if (userInput == 2) {

                    try {
                        addContact();
                        System.out.println("----------");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("You just added a new contact!");

                    try {
                        viewContacts();
                        System.out.println("----------");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//             find contact:
                } else if (userInput == 3) {
                    findEntry();
                    System.out.println("\n----------");
//             delete contact:
                } else if (userInput == 4) {
                    try {
                        deleteContact();
                        System.out.println("----------");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        viewContacts();
                        System.out.println("----------");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//              exit program:
                } else if (userInput == 5) {
                    System.out.println("Goodbye");
                }
                break;
            } while (exit);
        }
    }

    public static void main(String[] args) {
        menu();
    }
}


//
//        Scanner sc = new Scanner(System.in);
//
//        String directory = "./src/contacts.txt";
//
//        String contacts = "contact.info.txt";
//
//        Path dataDirectory = Paths.get(directory);
//
//        Path contactFile = Paths.get(directory, contacts);
//
//
//        if (Files.notExists(dataDirectory)) {
//
//            try {
//                Files.createDirectories(dataDirectory);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (!Files.exists(contactFile)) {
//            try {
//                Files.createFile(contactFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }


//        int userInput = 0;
//        boolean exit = true;
//
//        do {
//            System.out.println("1. View Contacts.");
//            System.out.println("2. Add a new contact");
//            System.out.println("3. Search a contact by name.");
//            System.out.println("4. Delete an existing contact.");
//            System.out.println("5. Exit.");
//            System.out.println("Enter an option (1, 2, 3, 4 or 5) :");
//            userInput = sc.nextInt();
//
////          View Contacts
//
//            if (userInput == 1) {
//                viewContacts();
////
////            add new contact
//
//            } else if (userInput == 2) {
//
//                addContact();
//                System.out.println("You just added a new contact!");
//
//                viewContacts();
//
//            } else if (userInput == 3) {
//
//                findEntry();
//            } else if (userInput == 4) {
//                deleteContact();
//                viewContacts();
//            } else if (userInput == 5) {
//
//                System.out.println("Goodbye");
//
//            }
//            break;
//        } while (exit);
//
//
//    }
//}


//        System.out.println("Which contact did you want to delete?");
//        String userInputDelete = sc.nextLine();

//        Deleting a contact
//        https://crunchify.com/in-java-how-to-remove-elements-while-iterating-a-list-arraylist-5-different-ways/


//        ListIterator<String> contactList = printContacts.listIterator();
//        while (contactList.hasNext()) {
//
//            if (userInputDelete.equals(contactList.next())) {
//                System.out.println("true");
//                contactList.remove(userInputDelete);


//       System.out.println(printContacts.replaceAll("[","").replaceAll("]",""));
//
//        }else if(userInput ==2){








