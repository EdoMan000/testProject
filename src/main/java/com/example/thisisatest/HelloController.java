package com.example.thisisatest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.font.TextAttribute;
import java.util.Map;

public class HelloController {

    @FXML private RadioButton boldRadioButton;
    @FXML private Button copyToClipboardButton;
    @FXML private ColorPicker colorPicker;
    @FXML private TextField inputText;
    @FXML private RadioButton italicRadioButton;
    @FXML private Label resultText;
    @FXML private RadioButton underlinedRadioButton;

    @FXML void customizeButtonAction(ActionEvent event) {
        Color textColor = colorPicker.getValue();
        String myText = inputText.getText();
        resultText.setText(myText);
        Font startFont = resultText.getFont();
        Map attributes = startFont.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        resultText.setFont(startFont.deriveFont(attributes));
        resultText.setStyle(String.format("-fx-text-fill: %s", textColor));
        resultText.setVisible(true);
        copyToClipboardButton.setVisible(true);
    }

    @FXML void copyToClipboardButtonAction(){
        StringSelection stringSelection = new StringSelection(resultText.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("DONE");
        alert.setHeaderText("Text successfully copied to clipboard!");
        alert.setContentText(null);
        alert.showAndWait();
    }

}

