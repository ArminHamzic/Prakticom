package com.prakti.control;

import java.util.List;
import java.util.Optional;

import com.prakti.model.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class StudentDAO implements PanacheRepositoryBase<Student, Long> {

    public List<Student> findAllStudents(){
        return Student.findAll().list();
    }

    public Student findStudentById(Long id){
        Optional<Student> optionalStudent = Student.find("id", id).singleResultOptional();
        return optionalStudent.orElseThrow(NotFoundException::new);
    }

    public Student findStudentByUserName(String userName){
        Optional<Student> optionalStudent = find("user_name",userName).singleResultOptional();
        return optionalStudent.orElseThrow(NotFoundException::new);
    }

    public Student findStudentByEmail(String email){
        Optional<Student> optionalStudent = find("email",email).singleResultOptional();
        return optionalStudent.orElseThrow(NotFoundException::new);
    }

    /*  Not using this one so far
    public Student findStudentByPhoneNumber(String phoneNumber){
        Optional<Student> optionalStudent = find("phoneNumber",phoneNumber).singleResultOptional();
        return optionalStudent.orElseThrow(NotFoundException::new);
    }*/

    public Student persistStudent(Student student){
        return this.getEntityManager().merge(student);
    }

    public void updateStudent(Long id, Student student){
        Student updateStudent = findStudentById(id);
        updateStudent.CopyProperties(student);
        if(student.documents != null) updateStudent.documents = student.documents;
        if(student.jobApplications != null) updateStudent.jobApplications = student.jobApplications;
        if(student.skills != null) updateStudent.skills = student.skills;
        persistStudent(updateStudent);
    }

    public void deleteStudent(Long id){
        delete(findStudentById(id));
    }
}
