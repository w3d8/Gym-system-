package projectgymsystem;

/**
 *
 * @author ralha
 */
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI extends Application {

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        Text welcomeMsg = new Text("Welcome To Gym System");
        welcomeMsg.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        welcomeMsg.setFill(Color.BLUE);
        grid.add(welcomeMsg, 0, 0, 2, 1);

         Text gymInfo = new Text("We are all gathered here, ready to embark on an exciting fitness\njourney together.\n"
                 + "Here is our information as Trainers!");
        gymInfo.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 12));
        gymInfo.setFill(Color.BLACK);
        grid.add(gymInfo, 0, 1, 2, 1);

       

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        grid.add(textArea, 0, 2, 2, 1);

        Button displayBtn = new Button("Display Trainers");
        grid.add(displayBtn, 1, 3);
        displayBtn.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

        displayBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<Trainer> myList = Main.trainer;
                String s = "";
                for (Trainer trainer : myList) {
                    s += trainer + "\n------------------------------------\n";
                }
                textArea.setText(s);
            }

        });

        Scene scene = new Scene(grid, 400, 380);

        stage.setScene(scene);
        stage.setTitle("Gym System");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
