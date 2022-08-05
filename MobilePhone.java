import java.util.ArrayList;

public class MobilePhone {
    ArrayList<Contact> myContacts;

    public MobilePhone() {
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact) < 0) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }
    public void updateContact(int index,Contact contact) {
            myContacts.set(index,contact);
    }
    /*public boolean removeContact(Contact contact) {
        if(findContact(contact) >=0) {
            myContacts.remove(findContact(contact));
            return true;
        }
        return false;
    }*/

    public void removeContact(int index) {
            myContacts.remove(index);
    }

    public int findContact(Contact contact) {
        if(myContacts.contains(contact)) {
            return (myContacts.indexOf(contact));
        }
        return -1;
    }
    public int findContact(String name) {
        for(int i=0 ; i < myContacts.size() ; i++) {
            if( name.equals(myContacts.get(i).getName()) )
                return i;
        }
        return -1;
    }
    public Contact queryContact(String name) {
        int val = findContact(name);
        if(val >=0)
            return myContacts.get(val);
        return null;
    }
    public void printContacts() {
        for(int i=0;i < myContacts.size() ; i++){
            System.out.println( (i+1) + ". "+ myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}
