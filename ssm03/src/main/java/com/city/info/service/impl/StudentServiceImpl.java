package com.city.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.info.dao.IStudentDao;
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
	public List<StudentModel> getListByClass(int classNo) throws Exception {
		return studentDao.selectListByClass(classNo);
	}

	@Override
	public double getAvgAgeByClass(int classNo) throws Exception {
		return studentDao.selectAvgAgeByClass(classNo);
	}

	@Override
	public List<StudentModel> getListByAll() throws Exception {
		return studentDao.selectListByAll();
	}

	@Override
	public List<StudentModel> getListByAllWithPage(int start, int rows) throws Exception {
		return studentDao.selectListByAllWithPage(rows*(start-1), rows);
	}

	@Override
	public List<StudentModel> getListByCondition(int classNo, String sex, int lowAge, int highAge) throws Exception {
		return studentDao.selectListByCondition(classNo, sex, lowAge, highAge);
	}

	@Override
	public double getAvgAgeByCondition(int classNo, String sex, int lowAge, int highAge) throws Exception {
		return studentDao.selectAvgAgeByCondition(classNo, sex, lowAge, highAge);
	}

}
