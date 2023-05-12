package app;

import java.util.Map;

import javax.xml.crypto.Data;

import utils.DataAppender;
import utils.SystemClear;
import utils.Retrievers.PersonRetriever;
import utils.editors.PersonEditor;

import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.PrintWriter;

public class HumanResources extends Resources {
    private String name;
    private String lastname;
    private String ssn;
    private String age;
    private String address;
    private String job;
    private String sex;
    private String nation;

    public HumanResources(String name, String lastname, String ssn, String city, String age, String address,
            String job, String sex, String nation) {
        super(city);
        this.ssn = ssn;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.job = job;
        this.age = age;
        this.sex = sex;
        this.nation = nation;

    }

    public void submit() {

        Map<String, String> dataObject = new HashMap<String, String>();
        dataObject.put("ssn", this.ssn);
        dataObject.put("name", this.name);
        dataObject.put("lastname", this.lastname);
        dataObject.put("city", Resources.city);
        dataObject.put("age", this.age);
        dataObject.put("address", this.address);
        dataObject.put("job", this.job);
        dataObject.put("sex", this.sex);
        dataObject.put("nation", this.nation);

        String filePath = "database/user.txt";

        try {
            DataAppender files = new DataAppender(dataObject, filePath, "=");
        } catch (IOException e) {
            System.err.println("An error occurred while writing the map to a file: " + e.getMessage());
        }

    }

    public void edit() {

        Map<String, String> dataObject = new HashMap<String, String>();
        dataObject.put("ssn", this.ssn);
        dataObject.put("name", this.name);
        dataObject.put("lastname", this.lastname);
        dataObject.put("city", Resources.city);
        dataObject.put("age", this.age);
        dataObject.put("address", this.address);
        dataObject.put("job", this.job);
        dataObject.put("sex", this.sex);
        dataObject.put("nation", this.nation);

        try {
            PersonEditor.editPerson(ssn, dataObject);
            System.out.println("Person data updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating person data: " + e.getMessage());
        }

    }

}
