//Anthony Franklin afranklin18@cnm.edu
//FranklinP4 - GUI By IntelliJ
//03/04/2022

package com.cis2235.franklin.franklinp4;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDate;


public class HelloController {
    FranklinConsultation consult = new FranklinConsultation();
    @FXML
    private VBox boxLang;

    @FXML
    private VBox boxPlatform;

    @FXML
    private VBox boxTimeline;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSummary;
    @FXML
    private CheckBox chkLinux;

    @FXML
    private CheckBox chkMac;

    @FXML
    private CheckBox chkOthers;

    @FXML
    private CheckBox chkWindows;

    @FXML
    private ComboBox<String> cmbUrgency;

    @FXML
    private DatePicker dateAppt;

    @FXML
    private ToggleGroup langGroup;


    @FXML
    private Label lblBudget;

    @FXML
    private RadioButton rdbCPP;

    @FXML
    private RadioButton rdbGTYear;

    @FXML
    private RadioButton rdbJava;

    @FXML
    private RadioButton rdbLTYear;

    @FXML
    private RadioButton rdbNet;

    @FXML
    private RadioButton rdbNow;

    @FXML
    private RadioButton rdbPython;

    @FXML
    private Slider sldBudget;

    @FXML
    private TextField txbFirstName;

    @FXML
    private TextField txbLastName;

    @FXML
    private Label lblSummary;

    @FXML
    private ToggleGroup urgencyGroup;

    DecimalFormat dm = new DecimalFormat("$0,000.00");
    @FXML
    void onBudgetClicked(MouseEvent event)
    {
        lblBudget.setText(dm.format( sldBudget.getValue() ));
    }

    @FXML
    void onBudgetDrag(MouseEvent event)
    {
        lblBudget.setText(dm.format( sldBudget.getValue() ));
    }

    @FXML
    void onActionSave(ActionEvent event)
    {
        //Setting in all class variables
        if(dateAppt.getValue() == null)
        {
            dateAppt.setValue(LocalDate.now());
            consult.setConsultationDate(LocalDate.now());
        }
        else consult.setConsultationDate(dateAppt.getValue());
        consult.setPrice(sldBudget.getValue());
        if(chkWindows.isSelected()) consult.supportedPlatforms.add("Windows");
        if(chkMac.isSelected()) consult.supportedPlatforms.add("macOS");
        if(chkLinux.isSelected()) consult.supportedPlatforms.add("Linux");
        if(chkOthers.isSelected()) consult.supportedPlatforms.add("Others");
        consult.setFirstName(txbFirstName.getText());
        consult.setLastName(txbLastName.getText());
        RadioButton rb = (RadioButton) langGroup.getSelectedToggle();
        consult.setProgrammingLanguage(rb.getText());
        rb = (RadioButton) urgencyGroup.getSelectedToggle();
        consult.setTimeline(rb.getText());
        consult.setUrgency(cmbUrgency.getValue());

        //File save dialog with current folder as default
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setTitle("Save your data.");
        FileChooser.ExtensionFilter extensionFilter =
                new FileChooser.ExtensionFilter("text files(*.txt)", "*.txt");
        File file = fileChooser.showSaveDialog(null);

        //Writing to file if ok
        if(file != null)
        {
            consult.writeFile(file);
        }

    }

    @FXML
    void onMouseEnteredSave(MouseEvent event) {
        btnSave.setFont(Font.font("Arial Bold", FontWeight.BOLD, 15));
    }

    @FXML
    void onMouseEnteredSummary(MouseEvent event) {
        btnSummary.setFont(Font.font("Arial Bold", FontWeight.BOLD, 15));
    }

    @FXML
    void onMouseExitedSave(MouseEvent event) {
        btnSave.setFont(Font.font("Arial Bold", FontWeight.BOLD, 12));
    }

    @FXML
    void onMouseExitedSummary(MouseEvent event) {
        btnSummary.setFont(Font.font("Arial Bold", FontWeight.BOLD, 12));
    }

    @FXML
    void onActionSummary(ActionEvent event) {
        //Setting in all class variables
        if(dateAppt.getValue() == null)
        {
            dateAppt.setValue(LocalDate.now());
            consult.setConsultationDate(LocalDate.now());
        }
        else consult.setConsultationDate(dateAppt.getValue());
        consult.setPrice(sldBudget.getValue());
        if(chkWindows.isSelected()) consult.supportedPlatforms.add("Windows");
        if(chkMac.isSelected()) consult.supportedPlatforms.add("macOS");
        if(chkLinux.isSelected()) consult.supportedPlatforms.add("Linux");
        if(chkOthers.isSelected()) consult.supportedPlatforms.add("Others");
        consult.setFirstName(txbFirstName.getText());
        consult.setLastName(txbLastName.getText());
        RadioButton rb = (RadioButton) langGroup.getSelectedToggle();
        consult.setProgrammingLanguage(rb.getText());
        rb = (RadioButton) urgencyGroup.getSelectedToggle();
        consult.setTimeline(rb.getText());
        consult.setUrgency(cmbUrgency.getValue());
        lblSummary.setVisible(true);
        lblSummary.setText(consult.toString());

    }


    //Initializer
    @FXML
    public void initialize()
    {
        cmbUrgency.getItems().removeAll(cmbUrgency.getItems());
        cmbUrgency.getItems().addAll("Start ASAP", "Start in next year", "Over a year","TBD");
        cmbUrgency.getSelectionModel().select("Start ASAP");
        lblBudget.setText(dm.format( sldBudget.getValue() ));
        lblSummary.setText("Booking Date: " + consult.getBookingDate().toString());

    }
}
