package com.services;

import java.util.List;
import com.entity.Student;

public interface StudentService {

	public void saveStudent(Student student);
    public List<Student> getAllStudent();
    public void deleteStudent(int studentId);
    public Student getStudentById(int studentId);
    public void updateStudent(Student student);
}
