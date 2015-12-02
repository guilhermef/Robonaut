package com.guilhermef.NasaRobot.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guilhermef.NasaRobot.OutOfBoundaries;
import com.guilhermef.NasaRobot.Robonaut;

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String path = req.getPathInfo().replace("/", "");
		Robonaut robot = new Robonaut();
		try {
			robot.move(path);
			out.println(robot.getFinalPosition());
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		out.close();
	}
}
