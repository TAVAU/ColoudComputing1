package org.yhwang.csye6225.courseservice5.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.xspec.S;
import javafx.scene.image.Image;

import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement
@DynamoDBTable(tableName ="student")
public class Student {
    private String name;
    private String studentId;
    private Image image;
    private List<String> courses;
    private String programName;

    public Student() {

    }

    public Student(String name, String programName) {
        this.name = name;
        this.programName = programName;
    }

    public Student(String name, String studentId, String programName) {
        this.name = name;
        this.studentId = studentId;
        this.programName = programName;
    }

    public Student(String name, String studentId, List<String> courses, String programName) {
        this.name = name;
        this.studentId = studentId;
        this.image = null;
        this.courses = courses;
        this.programName = programName;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBHashKey(attributeName = "studentId")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @DynamoDBIgnore
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @DynamoDBAttribute(attributeName = "programName")
    public String getProgramName() {
        return programName;
    }

    //@DynamoDBIgnore
    @DynamoDBAttribute(attributeName = "courses")
    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @DynamoDBIgnore
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", image=" + image +
                ", courses=" + courses +
                ", programName='" + programName + '\'' +
                '}';
    }
}
