package com.guilhermef.nasa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guilhermef.nasa.robot.Robonaut;

public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(SimpleServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out;

        try {
            out = resp.getWriter();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.toString(), e);
            return;
        }

        String path = req.getPathInfo().replace("/", "");
        Robonaut robot = new Robonaut();
        try {
            robot.move(path);
            out.println(robot.getFinalPosition());
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.toString(), e);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            out.close();
        }
    }
}
