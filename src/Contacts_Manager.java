
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;




public class Contacts_Manager {

    private String contact;

    private int contactNumber;
    private String fullName;


    public void contactName(String fullName, int contactNumber) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
    }


//    public int getContactNumber() {
//        return contactNumber;
//    }
//
//    public void setContactNumber(int contactNumber) {
//        this.contactNumber = contactNumber;
//    }

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

//        List <String>contactList = Arrays.asList("ContactJuan");


//     List<String> Files.readAllLine(contactFile);

        System.out.println("1. View Contacts.");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
//        System.out.println("Enter an option (1, 2, 3, 4 or 5) :");
//        int userInput1 = sc.nextInt();
        System.out.println("Please enter a full name: ");
//        sc.nextLine();
        String userInput2 = sc.nextLine();
//
//        Add new contacts
//        try {
//            Files.write(contactFile, Arrays.asList(userInput2),StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (userInput == 1){

//      View all contacts
//       List<String> printContacts = Files.readAllLines(contactFile);

        List<String> printContacts = Files.readAllLines(contactFile);
//        List<String> newList = new ArrayList<>();
// searching though our contact list and finding match from user input
//        for (String line : printContacts) {
//            if (line.equals(userInput2)) {
//                System.out.println("true");
//            } else
//            {
//            }



//        Deleting a contact
        for (String line : printContacts) {
            if (line.equals(userInput2)) {
                System.out.println("true");
//                printContacts.remove(line);
//
            } else
            {
        }

//       System.out.println(printContacts.replaceAll("[","").replaceAll("]",""));
//
//        }else if(userInput ==2){


        }

    }
}


