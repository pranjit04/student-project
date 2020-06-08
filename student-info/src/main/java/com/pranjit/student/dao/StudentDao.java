package com.pranjit.student.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranjit.student.vo.StudentVO;

@Repository
@Transactional
public class StudentDao {
	@Autowired
	private SessionFactory factory;

//for creating session for hibernate connection to mysql
	public Session getSession() {

		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}

	public void writeStudent(StudentVO s) {

		getSession().save(s);
	}

	public List<StudentVO> readAllStudent() {

		Query q = getSession().createQuery("FROM StudentVO");
		List<StudentVO> studata = q.list();
		return studata;
	}
	
	public StudentVO readOneStudent(int slno) {

		Query q = getSession().createQuery("FROM StudentVO where slno="+slno);
		StudentVO studata = (StudentVO) q.uniqueResult();
		return studata;
	}

	public void editStudent(StudentVO s) {

		getSession().update(s);
	}

}
