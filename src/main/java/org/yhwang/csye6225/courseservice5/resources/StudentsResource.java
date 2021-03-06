package org.yhwang.csye6225.courseservice5.resources;

import org.yhwang.csye6225.courseservice5.datamodel.Course;
import org.yhwang.csye6225.courseservice5.datamodel.Student;
import org.yhwang.csye6225.courseservice5.service.StudentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("students")
public class StudentsResource {
    StudentsService studentsService = new StudentsService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return studentsService.getAllStudents();
    }

//    //query by program
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Student> getStudentsByProgram(@QueryParam ("program") String program
//    ) {
//        if (program == null) {
//            return studentsService.getAllStudents();
//        } else {
//            return studentsService.getStudentsByProgram(program);
//        }
//    }

    //...webapi/students/ciera.wang
    @GET
    @Path("/{studentId}")//
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudent(@PathParam("studentId")String stuId) {
        return studentsService.getStudent(stuId);
    }

    @POST
    // @Path()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student stu) {
        studentsService.addStudent(stu);
        return stu;
    }

    @POST
    @Path("/{studentId}/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Course> registerCourses(@PathParam("studentId")String stuId, List<Course> courses) {
        studentsService.registerCourses(stuId, courses);
        return courses;
    }

    @PUT
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML)
    public List<Student> updateStudent(@PathParam("studentId")String stuId, Student stu) {
        return studentsService.updateStudentInformation(stuId, stu);

    }

    @DELETE
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> deleteStudent(@PathParam("studentId")String stuId) {
        return studentsService.deleteStudent(stuId);
    }
}
