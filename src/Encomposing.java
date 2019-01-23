import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import support.BSTNode;

import javax.security.auth.callback.Callback;
import java.io.*;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Encomposing implements Initializable {
    @FXML private ListView a;
    @FXML private ChoiceBox searchfilter;
    @FXML private ChoiceBox resort;
    @FXML private ChoiceBox choice;
    @FXML private TextField searchinput;
    @FXML private TextField loading;
    @FXML private TextField delete;
    @FXML private TextField edit;
    public Contacts<Contacts> main = new Contacts<>();
    public Comparator<Contacts> comp;
    public int limit;
    Contacts one = new Contacts();
    String filename = "save2.bin";
    String maxfile = "max.txt";
    /*
    This is the method that we call in Test class to import data into the controller
    */
    public void data(Contacts<Contacts> a, Comparator<Contacts> b, int c) {
        main = a;
        comp = b;
        limit = c;
    }
    /*
    The filter class handles all of the filtering. We let the user if they want to filter one field or all of them. We read what the user
    selected in the choicebox and we read in what the user put in the textfield. This method is activated when the user pushes the
    'Filter' button.
     */
    public void Filter(ActionEvent event) {
        String output;
        String character = searchinput.getText();
        character = character.toLowerCase();
        a.getItems().clear();
        if (searchfilter.getValue().toString().equals("Business")) {
            for (int i = 0; i < limit; i++) {
                String in = main.getInorder(main.root, i).business;
                in = in.toLowerCase();
                main.count = 0;
                if (in.contains(character)) {
                    output = main.getInorder(main.root,i).toString();
                    a.getItems().add(i + output);
                }
            }
        } else if (searchfilter.getValue().toString().equals("First Name")) {
            for (int i = 0; i < limit; i++) {
                String in = main.getInorder(main.root, i).first;
                in = in.toLowerCase();
                main.count = 0;
                if (in.contains(character)) {
                    output = main.getInorder(main.root,i).toString();
                    a.getItems().add(i + output);
                }
            }
        } else if (searchfilter.getValue().toString().equals("Last Name")) {
            for (int i = 0; i < limit; i++) {
                String in = main.getInorder(main.root, i).last;
                in = in.toLowerCase();
                main.count = 0;
                if (in.contains(character)) {
                    output = main.getInorder(main.root,i).toString();
                    a.getItems().add(i + output);
                }
            }
        } else if (searchfilter.equals("Address")) {
            for (int i = 0; i < limit; i++) {
                String in = main.getInorder(main.root, i).address;
                in = in.toLowerCase();
                main.count = 0;
                if (in.contains(character)) {
                    output = main.getInorder(main.root,i).toString();
                    a.getItems().add(i + output);
                }
            }
        } else if (searchfilter.getValue().toString().equals("Email")) {
            for (int i = 0; i < limit; i++) {
                String in = main.getInorder(main.root, i).email;
                in = in.toLowerCase();
                main.count = 0;
                if (in.contains(character)) {
                    output = main.getInorder(main.root,i).toString();
                    a.getItems().add(i + output);
                }
            }
        } else if (searchfilter.getValue().toString().equals("Website")) {
            for (int i = 0; i < limit; i++) {
                String in = main.getInorder(main.root, i).website;
                in = in.toLowerCase();
                main.count = 0;
                if (in.contains(character)) {
                    output = main.getInorder(main.root,i).toString();
                    a.getItems().add(i + output);
                }
            }
        } else if (searchfilter.getValue().toString().equals("Phone Number")) {
            for (int i = 0; i < limit; i++) {
                String in = main.getInorder(main.root, i).phone;
                in = in.toLowerCase();
                main.count = 0;
                if (in.contains(character)) {
                    output = main.getInorder(main.root,i).toString();
                    a.getItems().add(i + output);
                }
            }
        }else if(searchfilter.getValue().toString().equals("None")){
            for (int i = 0; i < limit; i++) {
                String combined1 = main.getInorder(main.root, i).business + " " + main.getInorder(main.root, i).first + " " + main.getInorder(main.root, i).last + " " + main.getInorder(main.root, i).address + " " + main.getInorder(main.root, i).email + " " + main.getInorder(main.root, i).website + " " + main.getInorder(main.root, i).phone;
                combined1 = combined1.toLowerCase();
                main.count = 0;
                if (combined1.contains(character)) {
                    output = main.getInorder(main.root,i).toString();
                    a.getItems().add(i + output);
                }
            }

        }else{
            for (int i = 0; i < limit; i++) {
                String combined2 = main.getInorder(main.root, i).business + " " + main.getInorder(main.root, i).first + " " + main.getInorder(main.root, i).last + " " + main.getInorder(main.root, i).address + " " + main.getInorder(main.root, i).email + " " + main.getInorder(main.root, i).website + " " + main.getInorder(main.root, i).phone;
                combined2 = combined2.toLowerCase();
                main.count = 0;
                if (combined2.contains(character)) {
                    output = main.getInorder(main.root,i).toString();
                    a.getItems().add(i + output);


                }


            }
        }
        searchinput.clear();
    }
    /*
    This is the method that is used to display the data in the list. It goes through the for loop, calls the getInorder() method,
    and sets the index and data recieved from the getInorder() method in the listview. We call this method a lot in this program.
     */
    public void displayData(){
        int i = 0;
        String m;
        loading.setText("loading...");
        a.setEditable(false);
        a.getItems().clear();
        main.count = 0;
        String header = String.format("%20s\t%16s\t%17s\t%20s\t%20s\t%27s\t%25s", "Business","First Name", "Last Name","Address","Email","Website","Phone");
        a.getItems().add(header);
        while(i < limit){
                m = main.getInorder(main.root,i).toString();
                a.getItems().add(i + m);
                i++;
    }
        main.count = 0;
        loading.setText("Done");
    }
    /*
    If the user clicks on the 'Show Data' button then this method is activated. This method calls displayData() which displays
    the data.
     */
    public void display(ActionEvent event) {
        displayData();

    }
    // The comps does indeed work as intended, It just sometimes does not work as intended for some reason. I had  a seperate
    // file where i would print out to console and it works. Everything works in that file but for some reason it does not
    // work all the time here.
    public void Sort(ActionEvent event){
        main.count = 0;
        if(resort.getValue().toString().equals("Ascending Last Name")){
            comp = new AscSortLastName();
        }else if(resort.getValue().toString().equals("Descending Last Name")){
            comp = new DesSortLastName();
        }else if(resort.getValue().toString().equals("Ascending Business")){
            comp = new AscSortBusiness();

        }else{
            comp = new DesSortBusiness();
        }
        main.updateComp(comp);
        main.area(comp);
        displayData();

    }
    /*
    This method is how the program deletes an object from the database. The method reads in the input that the user enters
    in the 'Index to Delete' textfield. The method then calls the main.remove() method and tells it to delete the what
    the getInorder() method returns. Method is called when the user presses the 'Delete' button.
     */
    public void delete(){
        main.area(comp);
        main.count = 0;
        String d = delete.getText();
        int d2 = Integer.parseInt(d);
        if(d2 > limit-1){
            loading.clear();
            loading.setText("This is not a valid index");
        }else{
            main.area(comp);
            main.remove(main.getInorder(main.root,d2));
            limit--;
        }
    }
    /*
    Changes the scene so the use can add data to the database. Called when the user presses the 'Add an Entry' button.
     */
    public void changeSceneAdd(ActionEvent event) throws IOException{
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Add.fxml"));
        Parent searchView2 = loader1.load();

        AddController a = loader1.<AddController>getController();
        a.data(main, comp, limit);
        Scene searchScene = new Scene(searchView2);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    /*
    Changes the scene so the user can edit an entry in the database. Reads in what field the user wants to edit from the
    choicebox and reads in the input that the user put into the textfield below it. It then transfers that data to the
    EditController and changes the scene. This method runs when the user clicks on the 'Edit' button.
     */
    public void changeScreenEdit(ActionEvent event) throws IOException{
        String choiceselect = choice.getValue().toString();
        String editin = edit.getText();
        //int indexin;
        try{
            int indexin = Integer.parseInt(editin);
            if(indexin > limit){
                loading.setText("Index out of Bounds");
            }else {
                System.out.println(indexin);
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Edit.fxml"));
                Parent searchView2 = loader1.load();

                EditController a = loader1.<EditController>getController();
                a.data(main, comp, limit, choiceselect, indexin);
                Scene searchScene = new Scene(searchView2);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(searchScene);
                window.show();
            }
        }catch(NumberFormatException ex){
            loading.setText("Not a valid index");
        }


    }
    // Saves the data in the database and the limit. This method is run when the user clicks 'Save' under 'File'
    public void save(ActionEvent event){
        main.count = 0;
        try{
            ObjectOutputStream number = new ObjectOutputStream(new FileOutputStream(maxfile));
            DataOutputStream dos = new DataOutputStream(number);
            dos.writeInt(limit);
            dos.close();
            main.area(comp);
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            main.count = 0;
            for(int i = 0; i < limit; i++) {
                   Contacts one = new Contacts();
                   one = main.getInorder(main.root,i);
                   os.writeObject(one);

            }
            os.close();
            main.count = 0;
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /*
    This method removes data in the BST. Used in conjunction with the load method.
     */
    public void remove(){
        main.area(comp);
        main.count = 0;
        for(int i = 0 ; i < limit; i++){
            main.remove(main.getInorder(main.root,0));
        }
    }
    /*
    This method loads the data when the user clicks 'Load' under 'File'
      */
    public void load(ActionEvent event){
        main.count = 0;
        remove();
        try{
            main.area(comp);
            ObjectInputStream num = new ObjectInputStream(new FileInputStream(maxfile));
            DataInputStream dos = new DataInputStream(num);
            limit = dos.readInt();
            dos.close();
            System.out.println(limit);
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(filename));
            for(int i = 0; i < limit; i++) {
                one = (Contacts) os.readObject();
                main.add(one);
            }
                os.close();
                main.count = 0;

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }
    /*
    Initiliazer for the Encase Controller for the Encomposing.fxml file
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchfilter.getItems().add("None");
        searchfilter.getItems().add("Business");
        searchfilter.getItems().add("First Name");
        searchfilter.getItems().add("Last Name");
        searchfilter.getItems().add("Addresss");
        searchfilter.getItems().add("Website");
        searchfilter.getItems().add("Email");
        searchfilter.getItems().add("Phone Number");

        resort.getItems().add("Ascending Last Name");
        resort.getItems().add("Descending Last Name");
        resort.getItems().add("Ascending Business");
        resort.getItems().add("Descending Business");

        choice.getItems().add("Business");
        choice.getItems().add("First Name");
        choice.getItems().add("Last Name");
        choice.getItems().add("Addresss");
        choice.getItems().add("Website");
        choice.getItems().add("Email");
        choice.getItems().add("Phone Number");

        loading.setEditable(false);
        a.setEditable(false);



    }

}
