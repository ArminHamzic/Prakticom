package com.prakti.control;

import java.util.List;
import java.util.Optional;

import com.prakti.model.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class StudentDAO implements PanacheRepository<Student> {

    public List<Student> findAllStudents(){
        return Student.findAll().list();
    }

    public Student findStudentById(Long id){
        Optional<Student> optionalStudent = Student.findByIdOptional(id);
        return optionalStudent.orElseThrow(NotFoundException::new);
    }

    public Student findStudentByEmail(String email){
        Optional<Student> optionalStudent = find("email",email).singleResultOptional();
        return optionalStudent.orElseThrow(NotFoundException::new);
    }

    public Student findStudentByPhoneNumber(String phoneNumber){
        Optional<Student> optionalStudent = find("phoneNumber",phoneNumber).singleResultOptional();
        return optionalStudent.orElseThrow(NotFoundException::new);
    }

    public Student persistStudent(Student student){
        persist(student);
        return student;
    }

    public void updateStudent(Long id, Student student){
        Student updateStudent = findStudentById(id);
        updateStudent.CopyProperties(student);
        persist(updateStudent);
    }

    public void deleteStudent(Long id){
        delete(findStudentById(id));
    }
}
