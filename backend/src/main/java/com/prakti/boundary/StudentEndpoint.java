package com.prakti.boundary;

import com.prakti.control.StudentDAO;
import com.prakti.control.StudentDocumentDAO;
import com.prakti.model.*;
import com.prakti.model.DocumentEntities.StudentDocument;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/api/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentEndpoint {

    @Inject
    StudentDAO studentRepository;

    @Inject
    StudentDocumentDAO studentDocumentRepository;

    @GET
    public List<Student> getAllStudents(){
        return studentRepository.findAllStudents();
    }

    @GET
    @Path("/{id}")
    public Student getStudentById(@PathParam("id") Long id){

        return studentRepository.findStudentById(id);
    }

    @GET
    @Path("/username/{userName}")
    public Student getStudentByUserName(@PathParam("userName")String userName){
        return studentRepository.findStudentByUserName(userName);
    }

    @GET
    @Path("/email/{email}")
    public Student getStudentByEmail(@PathParam("email")String email){
        return studentRepository.findStudentByEmail(email);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStudent(@Context UriInfo info, Student student) {
        if (student == null) return Response.noContent().build();
        Student newStudent = new Student();
        newStudent.CopyProperties(student);
        Student savedStudent = studentRepository.persistStudent(newStudent);
        URI uri = info.getAbsolutePathBuilder().path("/" + savedStudent.getId()).build();
        return Response.created(uri).build();
    }


    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteStudent(@PathParam("id") Long id) {
        try {
            studentRepository.deleteStudent(id);
        } catch (EntityNotFoundException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Student with id " + id + " does not exist")
                    .build();
        }
        return Response
                .status(Response.Status.OK)
                .header("Reason", "Student with id " + id + " has been deleted")
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") Long id, Student student) {
        Student s = studentRepository.findById(id);
        if (s == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Student with id " + id + " does not exist")
                    .build();
        } else {
            studentRepository.updateStudent(id,student);
            return Response
                    .status(Response.Status.ACCEPTED)
                    .header("Reason", "Student with id " + id + " has been updated")
                    .build();
        }
    }
}
