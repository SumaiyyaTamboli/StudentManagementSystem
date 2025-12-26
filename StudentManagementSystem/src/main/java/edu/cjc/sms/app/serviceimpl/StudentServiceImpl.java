package edu.cjc.sms.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repository.StudentRepository;
import edu.cjc.sms.app.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository sr;

	@Override
	public void saveStudentDatails(Student student) {
		sr.save(student);
		// TODO Auto-generated method stub
		
	}
	

}
