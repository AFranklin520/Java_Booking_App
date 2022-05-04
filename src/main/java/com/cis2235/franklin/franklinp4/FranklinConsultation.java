//Anthony Franklin afranklin18@cnm.edu
//FranklinP4 - GUI By IntelliJ
//03/04/2022

package com.cis2235.franklin.franklinp4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

public class FranklinConsultation
{
    //Variables for Form
    private String firstName;
    private String lastName;
    private String programmingLanguage;
    private String timeline;
    private String urgency;
    public Vector<String> supportedPlatforms = new Vector<String>();
    private LocalDate bookingDate;
    private LocalDate consultationDate;
    private Double price = 0.00;


    //Number Formatter for price
    DecimalFormat currencyFormatter = new DecimalFormat("$0.00");


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public Vector<String> getSupportedPlatforms() {
        return supportedPlatforms;
    }

    public void setSupportedPlatforms(String platform) {
        this.supportedPlatforms.add(platform);
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    private void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //Text Box
    @Override
    public String toString()
    {
        String platforms = new String();
        for(int i = 0; i < supportedPlatforms.size(); i ++)
        {
            platforms += "\n" + supportedPlatforms.get(i);
        }
        return "Booking Date: " + bookingDate.toString() +
                "\nName: " + firstName + " " +  lastName +
                "\nDate of Consultation: " + consultationDate.toString() +
                "\nUrgency: " + urgency +
                "\nProjected Start Time: " + timeline +
                "\nProjected Budget: " + currencyFormatter.format(price) +
                "\nProgramming Language: " + programmingLanguage +
                "\n\nSupported Platforms: " + platforms;
    }



    //Constructors


    public FranklinConsultation()
    {
        this.bookingDate = LocalDate.now();
    }


    public FranklinConsultation(String firstName, String lastName, String programmingLanguage, Vector<String> supportedPlatforms, LocalDate consultationDate, Double price)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.programmingLanguage = programmingLanguage;
        this.supportedPlatforms = supportedPlatforms;
        this.consultationDate = consultationDate;
        this.price = price;
        this.bookingDate = LocalDate.now();

    }
    public void writeFile(File file)
    {
        try
        {
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(this.toString());
            out.close();
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
