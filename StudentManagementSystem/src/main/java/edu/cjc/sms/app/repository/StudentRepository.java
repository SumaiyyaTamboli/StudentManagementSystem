package edu.cjc.sms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.sms.app.model.Student;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	public  List<Student> findAllByBatchNumberAndBatchMode(String batchNumber, String batchMode);

}
