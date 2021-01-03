package com.city.erp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Application Lifecycle Listener implementation class ServerStartAndStopListener
 *
 */
@WebListener
public class ServerStartAndStopListener implements ServletContextListener {

    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    	 System.out.println("服务器停止了");
    }

	/**
     * 监听服务器启动方法
     */
    public void contextInitialized(ServletContextEvent event)  { 
         System.out.println("服务器启动了");
    }
	
}
