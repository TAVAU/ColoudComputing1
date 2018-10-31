package org.yhwang.csye6225.courseservice5.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@DynamoDBTable(tableName ="lecture")
public class Lecture {
    private String lectureId;
    private String lectureName;
    private String notes;
    private String courseMaterial;

    public Lecture() {

    }

    public Lecture(String lectureId, String lectureName) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
    }

    public Lecture(String lectureId, String lectureName, String notes, String courseMaterial) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.notes = notes;
        this.courseMaterial = courseMaterial;
    }

    @DynamoDBHashKey(attributeName = "lectureId")
    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    @DynamoDBAttribute(attributeName = "lectureName")
    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    @DynamoDBAttribute(attributeName = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @DynamoDBAttribute(attributeName = "courseMaterial")
    public String getCourseMaterial() {
        return courseMaterial;
    }

    public void setCourseMaterial(String courseMaterial) {
        this.courseMaterial = courseMaterial;
    }
}
