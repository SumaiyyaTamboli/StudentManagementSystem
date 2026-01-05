package edu.cjc.sms.app.serviceimpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public void deleteStudent(int rollno) {
		sr.deleteById(rollno);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> searchStudentByBatch(String batchNumber, String batchMode) {
		
		// TODO Auto-generated method stub
		return sr.findAllByBatchNumberAndBatchMode(batchNumber, batchMode);
	}

	@Override
	public Student getSingleStudent(int id) {
		Optional<Student> opStudent=sr.findById(id);
		// TODO Auto-generated method stub
		return opStudent.get();
	}

	@Override
	public void updateStudentFees(int studentid, double ammount) {
		Optional<Student> opStudent=sr.findById(studentid);
		if(opStudent.isPresent()) {
		Student st=opStudent.get();
		st.setFeesPaid(st.getFeesPaid()+ammount);
		sr.save(st);
		// TODO Auto-generated method stub
		}
		else {
			throw new ArithmeticException("No Student id Found");
		}
	}

	@Override
	public void updateBatch(int studentid, String batchNumber) {
		Optional<Student> op=sr.findById(studentid);
		if(op.isPresent()) {
			Student s=op.get();
			s.setBatchNumber(batchNumber);
			
			sr.save(s);
			
		}
		else {
			throw new ArithmeticException("No student id foune");
		}
		// TODO Auto-generated method stub
		
	}
	

}
