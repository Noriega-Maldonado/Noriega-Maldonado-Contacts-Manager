
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;


public class Contacts_Manager {

    private static Scanner scanner;
    private String fullName;
    private int contactNumber;


    public Contacts_Manager(String fullName) {
        this.fullName = fullName;

    }

//    public void setContactNumber(int contactNumber){
//
//        this.contactNumber = contactNumber;
//
//    }

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
        Contacts_Manager contact1 = new Contacts_Manager(userInput);
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

    public static void main(String[] args) throws IOException {

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


//     List<String> Files.readAllLine(contactFile);

        System.out.println("1. View Contacts.");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5) :");
        int userInput1 = sc.nextInt();

//          View Contacts
        if (userInput1 == 1) {
            viewContacts();
//            add new contact
        } else if (userInput1 == 2){
            addContact();
        }else if(userInput1 == 3){
            findEntry();
        }




    }
}





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








