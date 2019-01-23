import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class EditController implements Initializable {

    @FXML private TextField info;

    Contacts<Contacts> main = new Contacts<>();
    Comparator<Contacts> comp;
    int limit;
    int index;
    String field;
    /*
    Imports this data from whichever class calls this class. This is required data.
     */
    public void data(Contacts<Contacts> a, Comparator<Contacts> b, int c, String d, int e){
        main = a;
        comp = b;
        limit = c;
        field = d;
        index = e;
    }
    /*
    When user clicks the apply button then it gets String field and compares them to strings to figure out which field
    the user wants to edit. Then gets the String input and edits that objects with the new info. It then goes back to
    the Encase Scene.
     */
    public void Apply(ActionEvent event) throws IOException{
        main.area(comp);
        String input = info.getText();
        if(field.equals("Business")){
            main.getInorder(main.root, index).business = input;
        }else if(field.equals("First Name")){
            main.getInorder(main.root, index).first = input;
        }else if(field.equals("Last Name")){
            main.getInorder(main.root, index).last = input;
        }else if(field.equals("Addresss")){
            main.getInorder(main.root, index).address = input;
        }else if(field.equals("Website")){
            main.getInorder(main.root, index).website = input;
        }else if(field.equals("Email")){
            main.getInorder(main.root, index).email = input;
        }else{
            main.getInorder(main.root, index).phone = input;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Encase.fxml"));
        Parent searchView = loader.load();

        Encomposing a = loader.<Encomposing>getController();
        a.data(main, comp, limit);
        Scene searchScene = new Scene(searchView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    /*
    Goes back to the Encase scene when the 'Back' button is pushed.
     */
    public void changeSceneEncomposing(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Encase.fxml"));
        Parent searchView = loader.load();

        Encomposing a = loader.<Encomposing>getController();
        a.data(main, comp, limit);
        Scene searchScene = new Scene(searchView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    /*
    Initializable method for the EditController class
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
