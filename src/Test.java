import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Comparator<Contacts> comp = new AscSortLastName();
        Contacts one = new Contacts();

        Contacts<Contacts> main1 = new Contacts<Contacts>(comp);
        Iterator<Contacts> iter, iter2;
        String maxfile = "max.txt";
        int limit;
        String filename = "save2.bin";
        limit = 10000;
        Random ran = new Random();
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i <= limit; i++) {


            StringBuilder business = new StringBuilder(10);
            StringBuilder first = new StringBuilder(6);
            StringBuilder last = new StringBuilder(10);
            StringBuilder address = new StringBuilder(10);
            StringBuilder website = new StringBuilder(5);
            StringBuilder email = new StringBuilder(4);
            StringBuilder phone = new StringBuilder(4);
            StringBuilder phone1 = new StringBuilder(3);
            StringBuilder phone2 = new StringBuilder(3);
            StringBuilder phone3 = new StringBuilder(4);
            for (int i1 = 0; i1 < 10; i1++) {
                business.append(chars[ran.nextInt(chars.length)]);
            }
            for (int i2 = 0; i2 < 6; i2++) {
                first.append(chars[ran.nextInt(chars.length)]);
            }
            for (int i3 = 0; i3 < 10; i3++) {
                last.append(chars[ran.nextInt(chars.length)]);
            }
            for (int i4 = 0; i4 < 10; i4++) {
                address.append(chars[ran.nextInt(chars.length)]);
            }
            for (int i5 = 0; i5 < 5; i5++) {
                website.append(chars[ran.nextInt(chars.length)]);
            }
            website.append(".com");
            for (int i6 = 0; i6 < 4; i6++) {
                email.append(chars[ran.nextInt(chars.length)]);
            }
            email.append("@gmail.com");
            phone1.append(ran.nextInt(10));
            phone2.append(ran.nextInt(10));
            phone3.append(ran.nextInt(10));
            for (int i9 = 0; i9 < 3; i9++) {
                phone.append(phone1);
            }
            phone.append("-");
            for (int n = 0; n < 3; n++) {
                phone.append(phone2);
            }
            phone.append("-");
            for (int m = 0; m < 4; m++) {
                phone.append(phone3);
            }

            String b = business.toString();
            String f = first.toString();
            String l = last.toString();
            String a = address.toString();
            String w = website.toString();
            String e = email.toString();
            String p = phone.toString();

            one = new Contacts(b, f, l, a, w,e, p);
            main1.add(one);
        }

            primaryStage.setTitle("Contacts Database");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Encase.fxml"));
            Parent root = loader.load();
            Encomposing lo = loader.<Encomposing>getController();
            lo.data(main1, comp, limit);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            primaryStage.show();

        }
    }
