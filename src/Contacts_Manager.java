
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;


public class Contacts_Manager {




    public static void main(String[] args) {

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

        try {
            Files.write(contactFile, Arrays.asList("Contact1"),StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

