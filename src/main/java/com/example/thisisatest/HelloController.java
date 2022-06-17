package com.example.thisisatest;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class HelloController {

    @FXML private RadioButton boldRadioButton;
    @FXML private Button copyToClipboardButton;
    @FXML private ColorPicker colorPicker;
    @FXML private TextField inputText;
    @FXML private RadioButton italicRadioButton;
    @FXML private Label resultText;
    @FXML private RadioButton underlinedRadioButton;

    @FXML void customizeButtonAction() {
        String myText = inputText.getText();
        resultText.setText(myText);
        resultText.setTextFill(colorPicker.getValue());
        if(italicRadioButton.isSelected() && boldRadioButton.isSelected()){
            resultText.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
        }else if(italicRadioButton.isSelected()){
            resultText.setFont(Font.font("System", FontWeight.NORMAL, FontPosture.ITALIC, 24));
        }else if(boldRadioButton.isSelected()){
            resultText.setFont(Font.font("System", FontWeight.BOLD, FontPosture.REGULAR, 24));
        }else{
            resultText.setFont(Font.font("System", FontWeight.NORMAL, FontPosture.REGULAR, 24));
        }
        resultText.setUnderline(underlinedRadioButton.isSelected());
        resultText.setVisible(true);
        copyToClipboardButton.setVisible(true);
    }

    @FXML void copyToClipboardButtonAction(){
        StringSelection stringSelection = new StringSelection(resultText.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        alertCopySuccessful();
    }

    private void alertCopySuccessful() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("DONE");
        alert.setHeaderText("Text successfully copied to clipboard!");
        alert.setContentText(null);
        alert.showAndWait();
    }

}

