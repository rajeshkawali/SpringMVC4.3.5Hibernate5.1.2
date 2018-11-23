package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Student;

@Repository
public class StudentDaoImplements implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveStudent(Student student) {
		System.out.println("-----------|saveStudent|----------");
		this.sessionFactory.getCurrentSession().save(student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		System.out.println("-----------|getAllStudent|----------");
		return this.sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

	public Student getStudentById(int studentId) {
		System.out.println("-----------|getStudentById|----------");
		Student student = (Student) sessionFactory.getCurrentSession().get(Student.class, studentId);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		System.out.println("-----------|updateStudent|----------");
		if (null != student) {
			this.sessionFactory.getCurrentSession().update(student);
		}
	}

	@Override
	public void deleteStudent(int studentId) {
		System.out.println("-----------|deleteStudent|----------");
		Student student = (Student) sessionFactory.getCurrentSession().load(Student.class, studentId);
		if (null != student) {
			this.sessionFactory.getCurrentSession().delete(student);
		}
	}

}
