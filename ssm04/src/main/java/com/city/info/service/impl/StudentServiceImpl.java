package com.city.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.info.dao.IStudentDao;
import com.city.info.model.CourseModel;
import com.city.info.model.StudentModel;
import com.city.info.service.IStudentService;

@Service("StudentService")
@Transactional
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao=null;

	@Override
	public void add(StudentModel em) throws Exception {
		studentDao.insert(em);
	}

	@Override
	public void addCourse(int studentNo, int[] courseNos) throws Exception {
		studentDao.insertCourse(studentNo, courseNos);
	}

	@Override
	public List<CourseModel> getCoursesByStudent(int studentNo) throws Exception {
		return studentDao.selectCoursesByStudent(studentNo);
	}

	@Override
	public List<CourseModel> getCoursesWithoutSelected() throws Exception {
		return studentDao.selectCoursesWithoutSelected();
	}

	@Override
	public int getStudentCountBySexAndCourse(String sex, int courseNo) throws Exception {
		return studentDao.selectStudentCountBySexAndCourse(sex, courseNo);
	}

	@Override
	public List<StudentModel> getListBySearchCondition(String sex, String nameKeyword, int lowAge, int highAge)
			throws Exception {
		return studentDao.selectListBySearchCondition(sex, nameKeyword, lowAge, highAge);
	}

	@Override
	public List<StudentModel> getListBySearchCondition01(String sex, String nameKeyword, int lowAge, int highAge)
			throws Exception {
		return studentDao.selectListBySearchCondition01(sex, nameKeyword, lowAge, highAge);
	}

}
