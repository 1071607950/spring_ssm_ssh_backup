package com.city.oa.factory;

import com.city.oa.service.IDepartmentService;
import com.city.oa.service.IEmployeeService;
import com.city.oa.service.impl.DepartmentServiceImplWithHibernate;
import com.city.oa.service.impl.EmployeeServiceImplWithHibernate;

public class ServiceFactory {
	public static IDepartmentService createDepartmentService() {
		return new DepartmentServiceImplWithHibernate();
	}
	public IDepartmentService createDepartmentServiceDynamic() {
		return new DepartmentServiceImplWithHibernate();
	}
}
