package com.pranjit.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranjit.student.dao.StudentDao;
import com.pranjit.student.vo.StudentVO;

@Service
public class StudentService {
	@Autowired
	StudentDao dao;

	public List<StudentVO> readAll() {
		List<StudentVO> stulist = dao.readAllStudent();
		return (stulist);
	}
	 
	public StudentVO readOne(int slno) {
		StudentVO stu = dao.readOneStudent(slno);
		if(stu==null)
		{
			throw new RuntimeException("Serial Number is not valid.");
		}
		return (stu);
	
	}

	public void write(StudentVO s) {
		validateStudent(s);
		
		dao.writeStudent(s);
	}

	public void edit(StudentVO s) {
		validateStudent(s);
		validateslNO(s.getSlno());
		
		dao.editStudent(s);
	}
	private void validateStudent(StudentVO val)
	{
		if(val==null)
		{
			throw new RuntimeException("Student object cannot be null");	
		}
		else if(val.getFname()==null || val.getFname().isEmpty())
		{
			throw new RuntimeException("First Name should have a value");
		}
		else if(val.getLname()==null || val.getLname().isEmpty())
		{
			throw new RuntimeException("Last Name should have a value");
		}
		else if(val.getEmail()==null || val.getEmail().isEmpty())
		{
			throw new RuntimeException("Email should have a value");
		}
		else if(val.getGender()==null || val.getGender().isEmpty())
		{
			throw new RuntimeException("Gender must be mentioned");
		}
		else if(!val.getGender().equals("male") && !val.getGender().equals("female") && !val.getGender().equals("others"))
		{
			throw new RuntimeException("Gender can only be (male,female or others)");
		}
		else if(val.getRollNo()<=0)
		{
			throw new RuntimeException("Roll No should have a value and should be positive.");
		}
		else if(val.getPRN()<=0)
		{
			throw new RuntimeException("PRN should have a positive value");
		}else if(val.getDept()==null || val.getDept().isEmpty())
		{
			throw new RuntimeException("Department  should be mentioned");
		}
		else if(val.getSem()==null || val.getSem().isEmpty())
		{
			throw new RuntimeException("Semister should have a value");
		}
		
	}
private void validateslNO(int slno)
{
	if(slno<=0)
	{
		throw new RuntimeException("Serial Number should have a value and should be positive.");
	}
	StudentVO s=dao.readOneStudent(slno);
	if(s==null)
	{
		throw new RuntimeException("Serial Number is not valid.");
		
	}
	
}
}
