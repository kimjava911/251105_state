package org.example.state.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // main -> java, webapp, resources -> 최상단으로 각각 인식됨
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
        // 외부의 URL은 그대로인 상태에서 뒤에 리소스만 연결 (servlet, jsp)
    }
}
