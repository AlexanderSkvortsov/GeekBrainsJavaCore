package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;



public class Controller {
    @FXML public TextArea messagesList;
    @FXML public Button sendButton;
    @FXML public TextField textMessage;

    private void showAlert (){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Input not valid");
        errorAlert.setContentText("The size of message is incorrect!");
        errorAlert.showAndWait();
    }

    protected  void  addMessage(){
        if (textMessage.getText().length() == 0) showAlert();
        else
            messagesList.appendText(textMessage.getText()+"\r\n");
    }

    public void onPressEnter(ActionEvent actionEvent){
        addMessage();

    };

    public void onSendButtonClick(MouseEvent mouseEvent){
        addMessage();

    }

}
