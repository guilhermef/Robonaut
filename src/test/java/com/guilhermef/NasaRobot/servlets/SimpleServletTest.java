package com.guilhermef.NasaRobot.servlets;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;



public class SimpleServletTest extends Mockito {

	@Test
    public void testOnSuccess() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        when(request.getPathInfo()).thenReturn("/MMRMMRMM");
        StringWriter result = new StringWriter();
        PrintWriter writer = new PrintWriter(result);
        when(response.getWriter()).thenReturn(writer);
        new SimpleServlet().doPost(request, response);
        Assert.assertEquals("(2, 0, S)", result.toString().trim());
        
	}
	
	@Test
    public void testOnError() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        StringWriter result = new StringWriter();
        PrintWriter writer = new PrintWriter(result);
        
        when(response.getWriter()).thenReturn(writer);
        when(request.getPathInfo()).thenReturn("/AAAMRL");
        
        new SimpleServlet().doPost(request, response);
        verify(response, atLeast(1)).setStatus(400);
        
	}

}
