
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;


public class Contacts_Manager {

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
//        System.out.println("Enter an option (1, 2, 3, 4 or 5) :");
//        int userInput1 = sc.nextInt();
//        System.out.println("Please enter a full name: ");
//        sc.nextLine();
//        String userInput2 = sc.nextLine();
//        Contacts_Manager contact1 = new Contacts_Manager("Jose","Maldonado",2109118925);
//        Add new contacts
//        try {
//            Files.write(contactFile, Arrays.asList(userInput2),StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (userInput == 1){

//      View all contacts
        List<String> printContacts = Files.readAllLines(contactFile);
        System.out.println(printContacts);

//        List<String> printContacts = Files.readAllLines(contactFile);
//        List<String> newList = new ArrayList<>();
// searching though our contact list and finding match from user input
//        for (String line : printContacts) {
//            if (line.equals(userInput2)) {
//                System.out.println("true");
//            } else
//            {
//            }

//        Patric's code of printing/viewing contact info list:
//        List<String> printContacts = Files.readAllLines(contactFile);
//        List<String> newList = new ArrayList<>();
//        for (String line : printContacts) {
//            if (line.equals(userInput2)) {
//                    System.out.println("You have " + contacts.length() + " contacts.");
//                    for (int i = 0; i < contacts.length(); i++) {
////                        System.out.println((i + 1) + ". " + printContacts);
//                    }
//                }
//            }
//above code is printing 5 times with 16 contacts. and adding another print every time code runs
        System.out.println("Which contact did you want to delete?");
        String userInputDelete = sc.nextLine();

//        Deleting a contact
//        https://crunchify.com/in-java-how-to-remove-elements-while-iterating-a-list-arraylist-5-different-ways/


        ListIterator<String> contactList = printContacts.listIterator();
        while (contactList.hasNext()) {

            if (userInputDelete.equals(contactList.next())) {
//                System.out.println("true");
                contactList.remove();


            }


        }
        System.out.println(contactList);


//       System.out.println(printContacts.replaceAll("[","").replaceAll("]",""));
//
//        }else if(userInput ==2){


    }

}



