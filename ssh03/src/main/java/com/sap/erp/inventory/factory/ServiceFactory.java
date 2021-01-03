package com.sap.erp.inventory.factory;

import com.sap.erp.inventory.service.IProductService;
import com.sap.erp.inventory.service.impl.ProductServiceImpl;

public class ServiceFactory {
	public static IProductService createProductservice() {
		return new ProductServiceImpl();
	}
}
