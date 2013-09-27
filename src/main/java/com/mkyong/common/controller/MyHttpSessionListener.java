package com.mkyong.common.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
    
	  public void sessionCreated(HttpSessionEvent event) {
	      
	      
		System.out.println("sessionCreated - add one session into counter");
	    HttpSession session = event.getSession();
        ServletContext sc = session.getServletContext();
	    int timeout = Integer.parseInt(sc.getInitParameter("sessionMaxInactiveInterval"));
        session.setMaxInactiveInterval(timeout); //in seconds
	  }
	  public void sessionDestroyed(HttpSessionEvent event){}
	}