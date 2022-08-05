import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name ="Name";
        String phoneNumber="XXXXXXXXXX";
        Contact contact = new Contact(name,phoneNumber);
        MobilePhone mobilePhone = new MobilePhone();

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        printInstructions();

        while (!quit) {
            System.out.println("Give Choice:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice) {
                case 1:
                    printInstructions();
                    break;
                case 2:
                    mobilePhone.printContacts();
                    break;
                case 3:
                    System.out.println("Give a name:");
                    name= scanner.nextLine();
                    System.out.println("Give a phone number");
                    phoneNumber = scanner.nextLine();
                    Contact contactNew = contact.createContact(name,phoneNumber);
                    mobilePhone.addNewContact(contactNew);
                    System.out.println("contact added");
                    break;
                case 4:
                    System.out.println("Give name of the contact whose number you want to update: ");
                    name = scanner.nextLine();
                    int indexOfContact = mobilePhone.findContact(name);
                    if(indexOfContact >= 0) {
                        System.out.println("Give new number: ");
                        phoneNumber = scanner.nextLine();
                        Contact updatedContact = Contact.createContact(name,phoneNumber);
                        mobilePhone.updateContact(indexOfContact,updatedContact);
                        System.out.println("Contact Updated.");
                    }
                    else
                        System.out.println("Contact does not exist.");
                    break;
                case 5:
                    System.out.println("Give name of the contact whose contact you want to delete: ");
                    name = scanner.nextLine();
                    indexOfContact= mobilePhone.findContact(name);
                    if(indexOfContact >=0) {
                        mobilePhone.removeContact(indexOfContact);
                        System.out.println("Contact removed.");
                    }
                    else
                        System.out.println("Contact does not exist");
                    break;

                case 6:
                    System.out.println("Give contact name you want to find about: ");
                    name= scanner.nextLine();
                    contact = mobilePhone.queryContact(name);
                    if(contact != null)
                        System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
                    else
                        System.out.println("Contact does not exist.");
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice try again");
                    printInstructions();
                    break;
            }
        }
    }
    public static void printInstructions() {
        System.out.println("1.\tPrint Instructions.");
        System.out.println("2.\tPrint Contact List");
        System.out.println("3.\tAdd Contact");
        System.out.println("4.\tUpdate Contact");
        System.out.println("5.\tRemove Contact");
        System.out.println("6.\tQuery Contact");
        System.out.println("6.\tQuit Contact List");
    }
}
