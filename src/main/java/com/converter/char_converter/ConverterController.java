package com.converter.char_converter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.commons.codec.DecoderException;
import com.common.CharSetConstants;
import com.util.CodecUtil;
import com.util.FileUtil;
import com.util.MessageUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class ConverterController implements Initializable {

    @FXML
    private TextArea SourceText;

    @FXML
    private ComboBox<String> ConvertCharacterSet;

    @FXML
    private TextArea ConvertedText;

    @FXML
    private TextField ExportPath;

    @FXML
    private TextField ExportFileName;

    @FXML
    private TextField SystemMessage;

    @FXML
    private ProgressBar ProgressBar;

    public void convertText() {
        ProgressBar.setProgress(0);
        this.SystemMessage.setTextFormatter(null);
        ProgressBar.setProgress(20);
        if (this.SourceText.getText() == null || this.SourceText.getText().equals("")) {
            this.SystemMessage.setText("Please Input Source Text");
            ProgressBar.setProgress(0);
            return;
        }
        if (this.ConvertCharacterSet.getValue() == null) {
            this.SystemMessage.setText("Please Select Encode / Decode Set");
            ProgressBar.setProgress(0);
            return;
        }
        String encText = "";
        ProgressBar.setProgress(50);
        try {
            encText = CodecUtil.convertString(this.SourceText.getText(),
                    this.ConvertCharacterSet.getValue());
            ProgressBar.setProgress(80);
        } catch (DecoderException e) {
            this.SystemMessage.setText(MessageUtil.createResultMessage("Encode / Decode", false,
                    this.ConvertCharacterSet.getValue()));
            ProgressBar.setProgress(0);
            return;
        }
        this.ConvertedText.setText(encText);
        this.SystemMessage.setText(MessageUtil.createResultMessage("Encode / Decode", true,
                this.ConvertCharacterSet.getValue()));
        ProgressBar.setProgress(100);
    }

    public void exportFile() {
        ProgressBar.setProgress(0);
        this.SystemMessage.setTextFormatter(null);
        if (this.SourceText.getText() == null || this.SourceText.getText().equals("")) {
            this.SystemMessage.setText("Please Input Source Text.");
            ProgressBar.setProgress(0);
            return;
        }
        ProgressBar.setProgress(10);
        if (this.ConvertedText.getText() == null || this.ConvertedText.getText().equals("")) {
            this.SystemMessage.setText("Please Convert The Input Source Text.");
            ProgressBar.setProgress(0);
            return;
        }
        ProgressBar.setProgress(20);
        if (this.ExportPath.getText() == null || this.ExportPath.getText().equals("")) {
            this.SystemMessage.setText("Please Input Export Path.");
            ProgressBar.setProgress(0);
            return;
        }
        ProgressBar.setProgress(30);
        if (this.ExportFileName.getText() == null || this.ExportFileName.getText().equals("")) {
            this.SystemMessage.setText("Please Input Export File Name.");
            ProgressBar.setProgress(0);
            return;
        }
        ProgressBar.setProgress(40);
        try {
            FileUtil.exportFile(this.ExportPath.getText(), this.ExportFileName.getText(),
                    this.SourceText.getText(), this.ConvertedText.getText());
            ProgressBar.setProgress(80);
        } catch (IOException e) {
            this.SystemMessage.setText(MessageUtil.createResultMessage("Export File", false));
            ProgressBar.setProgress(0);
            return;
        }
        this.SystemMessage.setText(MessageUtil.createResultMessage("Export File", true));
        ProgressBar.setProgress(100);
    }

    public void selectDirectory() {
        DirectoryChooser dirChooser = new DirectoryChooser();

        dirChooser.setTitle("Select Directory.");

        File file = dirChooser.showDialog(null);
        if (file != null) {
            this.ExportPath.setText(file.getPath());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // コンボボックスに項目を追加
        for (CharSetConstants cc : CharSetConstants.values()) {
            ConvertCharacterSet.getItems().add(cc.getValue());
        }
    }

}
