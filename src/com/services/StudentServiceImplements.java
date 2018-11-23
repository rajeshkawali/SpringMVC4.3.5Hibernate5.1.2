package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentDao;
import com.entity.Student;

@Service
public class StudentServiceImplements implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}

	@Transactional
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}

	@Transactional
	public Student getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Transactional
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	@Transactional
	public void deleteStudent(int studentId) {
		studentDao.deleteStudent(studentId);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
