package com.city.oa.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.oa.model.CourseModel;
import com.city.oa.model.StudentModel;
import com.city.oa.service.IStudentService;

@Service("studentService")
@Transactional
public class StudentBusinessImpl implements IStudentService {
	@Autowired
	private SessionFactory sessionFactory=null;
	//增加学生
	@Override
	public void add(String id, String name, String sex, int age) throws Exception {
		StudentModel sm=new StudentModel();
		sm.setId(id);
		sm.setName(name);
		sm.setSex(sex);
		sm.setAge(age);
		sessionFactory.getCurrentSession().save(sm);
	}
	
	//给指定学生增加多个课程.
	@Override
	public void addCourse(String id, int[] courses) throws Exception {
		StudentModel sm=sessionFactory.getCurrentSession().get(StudentModel.class, id);
		sm.getCourses().clear();
		for(int course:courses) {
			CourseModel cm=sessionFactory.getCurrentSession().get(CourseModel.class, course);
			sm.getCourses().add(cm);
		}
	}
	
	//取得指定学生的选修课程列表，要求使用关联查询
	@Override
	public List<CourseModel> getCourseListByStudent(String id) throws Exception {
		String hql="select cm from CourseModel cm inner join cm.students sm where sm.id=:id";
		Query<CourseModel> query=sessionFactory.getCurrentSession().createQuery(hql,CourseModel.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	//取得没有被选修的课程列表。
	@Override
	public List<CourseModel> getCourseListWithoutSelected() throws Exception {
		String hql="select cm from CourseModel cm where cm.students is empty";
		Query<CourseModel> query=sessionFactory.getCurrentSession().createQuery(hql,CourseModel.class);
		return query.getResultList();
	}

	//取得指定同学的选修课程个数
	@Override
	public int getCourseNumByStudent(String id) throws Exception {
		String hql="select count(cm.no) from StudentModel sm inner join sm.courses cm where sm.id=:id";
		Query<Long> query=sessionFactory.getCurrentSession().createQuery(hql,Long.class);
		query.setParameter("id", id);
		return query.getSingleResult().intValue();
	}
	
	//取得选修指定课程的学生人数。
	@Override
	public int getStudentNumByCourse(int courseNo) throws Exception {
		String hql="select count(sm.id) from CourseModel cm inner join cm.students sm where cm.no=:no";
		Query<Long> query=sessionFactory.getCurrentSession().createQuery(hql, Long.class);
		query.setParameter("no", courseNo);
		return query.getSingleResult().intValue();
	}
	
	//取得没有选修任何课程的学生列表。
	@Override
	public List<StudentModel> getStudentListWithoutCourse() throws Exception {
		String hql="from StudentModel sm where not exists(from CourseModel cm inner join cm.students sm1 where sm1=sm)";
		Query<StudentModel> query=sessionFactory.getCurrentSession().createQuery(hql,StudentModel.class);
		return query.getResultList();
	}

	//取得选修指定课程的学生的平均年龄。
	@Override
	public int getStudentAvgAgeBySelectedCourse(int courseNo) throws Exception {
		String hql="select avg(sm.age) from StudentModel sm inner join sm.courses cm where cm.no=:no";
		Query<Double> query=sessionFactory.getCurrentSession().createQuery(hql,Double.class);
		query.setParameter("no", courseNo);
		return query.getSingleResult().intValue();
	}
	
}
