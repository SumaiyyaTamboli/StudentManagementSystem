package edu.cjc.sms.app.service;

import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentService {

public	void saveStudentDatails(Student student);
public List<Student> getAllStudent();
public void deleteStudent(int rollno);
public List<Student> searchStudentByBatch(String batchNumber, String batchMode);
public Student getSingleStudent(int id);
public void updateStudentFees(int studentid, double ammount);
public void updateBatch(int studentid, String batchNumber);

}
