package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

import static javafx.scene.paint.Color.color;


public class Controller extends SqlCon {



    @FXML
    public TextField nameEntry;

    @FXML
    private TextField surnameEntry;

    @FXML
    private TextField emailEntry;

    @FXML
    private Button saveButton;

    @FXML
    private TextField company1;

    @FXML
    private TextField workDone1;

    @FXML
    private TextField company2;

    @FXML
    private TextField workDone2;

    @FXML
    private TextField skill2;

    @FXML
    private TextField skill4;

    @FXML
    private TextField skill1;

    @FXML
    private TextField skill3;

    @FXML
    public void save(ActionEvent event) {
            Alert a = new Alert(Alert.AlertType.NONE);
            SqlCon mySql = new SqlCon();
            CreateDOCX docx = new CreateDOCX();

                String name = nameEntry.getText();
                String surname =  surnameEntry.getText();
                String email = emailEntry.getText();
                if(validateString(name) && validateString(surname)){
                    mySql.makeJDBCConnection();
                    mySql.addDataToDB(name,surname,email);
                    mySql.getDataFromDB();
                    docx.creatDOCX(name);
                    }
                else{
                    a.setAlertType(Alert.AlertType.ERROR);

                    // set content text
                    a.setContentText("Invalid input! Please,try again.");

                    // show the dialog
                    a.show();
                    nameEntry.clear();
                    surnameEntry.clear();
                    nameEntry.setText("INVALID INPUT");
                    //nameEntry.setFill(color(0, 0, 255));   setfill does not work..why???
                    surnameEntry.setText("INVALID INPUT");
                }

    }

    private boolean validateString (String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
    }
    public String getName(){
        String name = nameEntry.getText();
        return name;
    }



}
