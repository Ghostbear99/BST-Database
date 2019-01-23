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

public class AddController implements Initializable {

    @FXML
    private TextField business2;
    @FXML
    private TextField first2;
    @FXML
    private TextField last2;
    @FXML
    private TextField address2;
    @FXML
    private TextField website2;
    @FXML
    private TextField email2;
    @FXML
    private TextField phone2;
    @FXML
            private TextField message;

    Contacts<Contacts> master = new Contacts<>();
    Comparator<Contacts> comp;
    int limit;
    /*
    This is required data that is pulled from whatever class is calling this controller
     */
    public void data(Contacts<Contacts> a, Comparator<Contacts> b, int c){
        master = a;
        comp = b;
        limit = c;
    }
    /*
    When the user hits the 'Apply' button then this method is called. It reads in the user input from each text field
    and adds it to the database
     */
    public void add(ActionEvent event){
        String a = business2.getText();
        String b = first2.getText();
        String c = last2.getText();
        String d = address2.getText();
        String e = website2.getText();
        String f = email2.getText();
        String g = phone2.getText();

        Contacts one  = new Contacts(a,b,c,d,e,f,g);
        master.add(one);
        limit++;
        message.setText("Push 'Back' button to go back");
    }
    /*
    When the user hits the 'Back' button it goes back to the Encase scene
     */
    public void changeSceneEcomposing(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Encase.fxml"));
        Parent searchView = loader.load();
        System.out.println(limit);
        Encomposing a = loader.<Encomposing>getController();
        a.data(master, comp, limit);
        Scene searchScene = new Scene(searchView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    /*
    Initializable method for the AddController class
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        message.setEditable(false);
    }
}
