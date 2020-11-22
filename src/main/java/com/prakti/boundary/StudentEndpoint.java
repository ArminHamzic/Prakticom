package com.prakti.boundary;

import com.prakti.control.StudentDAO;
import com.prakti.model.Student;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentEndpoint {

    @Inject
    StudentDAO studentRepository;

    @GET
    public List<Student> getAllStudents(){
        return studentRepository.findAllStudents();
    }

    @GET
    @Path("/{id}")
    public Student getStudentById(@QueryParam("id")Long id){
        return studentRepository.findStudentById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStudent(@Context UriInfo info, Student student) {
        if (student == null) return Response.noContent().build();
        Student savedStudent = studentRepository.persistStudent(student);
        URI uri = info.getAbsolutePathBuilder().path("/" + savedStudent.id).build();
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
        return Response.noContent().build();
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
            return Response.ok(student).build();
        }
    }
}
