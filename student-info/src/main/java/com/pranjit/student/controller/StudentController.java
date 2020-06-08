package com.pranjit.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranjit.student.service.StudentService;
import com.pranjit.student.vo.StudentVO;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/read/all")
	public List<StudentVO> read() {
		return service.readAll();
	}
	
	@GetMapping("/read/{slno}")
	public StudentVO readOne(@PathVariable int slno) {
		return service.readOne(slno);
	}

	@PostMapping("/write")
	public String write(@RequestBody StudentVO student) {
		
		service.write(student);
		return ("successfully written");
	}

	@PostMapping("/edit")

	public String edit(@RequestBody StudentVO student) {
		service.edit(student);
		return ("edited");
	}
}
