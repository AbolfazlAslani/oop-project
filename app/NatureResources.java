package app;

import java.util.Map;

import javax.xml.crypto.Data;

import utils.DataAppender;
import utils.editors.NatureEditor;
import utils.editors.PersonEditor;

import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.PrintWriter;

public class NatureResources extends Resources {
    private String animal_type;
    private String plant_type;
    private String lands;
    private String country;
    private String area;
    private String ssn;
    private String city;

    public NatureResources(String animal_type, String plant_type, String lands, String country, String area,
            String ssn,
            String city) {
        super(city);
        this.animal_type = animal_type;
        this.plant_type = plant_type;
        this.lands = lands;
        this.country = country;
        this.area = area;
        this.ssn = ssn;
    }

    public void submit() {

        Map<String, String> dataObject = new HashMap<String, String>();
        dataObject.put("ssn", this.ssn);
        dataObject.put("animal_type", this.animal_type);
        dataObject.put("plant_type", this.plant_type);
        dataObject.put("city", Resources.city);
        dataObject.put("land", this.lands);
        dataObject.put("country", this.country);
        dataObject.put("area", this.area);

        String filePath = "database/lands.txt";

        try {
            DataAppender files = new DataAppender(dataObject, filePath, "=");
        } catch (IOException e) {
            System.err.println("An error occurred while writing the map to a file: " + e.getMessage());
        }

    }

    public void edit() {

        Map<String, String> dataObject = new HashMap<String, String>();
        dataObject.put("ssn", this.ssn);
        dataObject.put("animal_type", this.animal_type);
        dataObject.put("plant_type", this.plant_type);
        dataObject.put("city", Resources.city);
        dataObject.put("land", this.lands);
        dataObject.put("country", this.country);
        dataObject.put("area", this.area);

        String filePath = "database/lands.txt";

        try {
            NatureEditor.editNature(ssn, dataObject);
            System.out.println("Person data updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating person data: " + e.getMessage());
        }

    }

}
