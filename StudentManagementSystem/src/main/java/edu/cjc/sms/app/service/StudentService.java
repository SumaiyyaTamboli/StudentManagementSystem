package edu.cjc.sms.app.service;

import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentService {

public	void saveStudentDatails(Student student);
public List<Student> getAllStudent();
public void deleteStudent(int rollno);

}
