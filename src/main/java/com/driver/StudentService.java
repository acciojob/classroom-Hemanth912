package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    void addStudent(Student student)
    {
        studentRepository.addStudentToDb(student);
    }

    void addTeacher(Teacher teacher)
    {
        studentRepository.addTeacherToDb(teacher);
    }

    void addStudentTeacherPairToDb(String student,String teacher)
    {
        studentRepository.addStudentTeacherPairToDb(student,teacher);
    }

    Student getStudentByName(String sname)
    {
        return studentRepository.getStudentByNameFromDb(sname);
    }

    Teacher getTeacherByName(String sname)
    {
        return studentRepository.getTeacherByNameFromDb(sname);
    }

    ArrayList<String> getStudentsByTeacherName(String name)
    {
        return studentRepository.getStudentsByTeacherNameFromDb(name);
    }

    ArrayList<String> getAllStudents()
    {
        return studentRepository.getAllStudentsFromDb();
    }

    void deleteTeacherByName(String tname)
    {
        studentRepository.deleteTeacherByNameFromDb(tname);
    }

    void deleteAllTeachers()
    {
        studentRepository.deleteAllTeachersFromDb();
    }
}
