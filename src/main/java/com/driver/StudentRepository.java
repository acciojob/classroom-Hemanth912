package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;
@Repository

public class StudentRepository {

    HashMap<String, Student> studentDb = new HashMap<>();

    HashMap<String, Teacher> teacherDb = new HashMap<>();

    HashMap<String, ArrayList<String>> pairDb = new HashMap<>();

    void addStudentToDb(Student student) {
        String name = student.getName();
        studentDb.put(name, student);
    }

    void addTeacherToDb(Teacher teacher) {
        String name = teacher.getName();
        teacherDb.put(name, teacher);
    }

    void addStudentTeacherPairToDb(String student, String teacher) {
        if (studentDb.containsKey(student) && teacherDb.containsKey(teacher)) {
            if (pairDb.containsKey(teacher))
                pairDb.get(teacher).add(student);
            else {
                ArrayList<String> newmv = new ArrayList<>();
                newmv.add(student);
                pairDb.put(teacher, newmv);
            }
        }
    }

    Student getStudentByNameFromDb(String sname) {
        return studentDb.get(sname);
    }

    Teacher getTeacherByNameFromDb(String sname) {
        return teacherDb.get(sname);
    }

    ArrayList<String> getStudentsByTeacherNameFromDb(String name) {
        ArrayList<String> res = new ArrayList<>();
        if (pairDb.containsKey(name))
            res = pairDb.get(name);

        return res;
    }

    ArrayList<String> getAllStudentsFromDb() {
        ArrayList<String> studentlist = new ArrayList<>();
        for (String s : studentDb.keySet())
            studentlist.add(s);

        return studentlist;
    }

    void deleteTeacherByNameFromDb(String name) {
        if (teacherDb.containsKey(name)) {
            if (pairDb.containsKey(name)) {
                ArrayList<String> m1 = pairDb.get(name);
                for (String s : m1)
                    studentDb.remove(s);

                pairDb.remove(name);
            }
            teacherDb.remove(name);
        }
    }

    void deleteAllTeachersFromDb()
    {
        ArrayList<String> list = new ArrayList<>();
        for(String s:pairDb.keySet())
        {
            for(String m:pairDb.get(s))
            {
                list.add(m);
            }
        }
        for(String i:list)
            studentDb.remove(i);
    }

}
