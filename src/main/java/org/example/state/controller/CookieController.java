package org.example.state.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[Cookie]");
        System.out.println(req.getHeader("cookie"));
        Cookie[] cookies = req.getCookies(); // ";" -> 나눠준다음에 '=' Key, Value
        int counterValue = 1; // 첫번째 방문의 경우에는 어차피 req, header -> Cookie X. -> null
        for (Cookie c : cookies) {
            if (c.getName().equals("counter")) {
//                 counterValue = c.getValue();
                // Cookie의 데이터는 모두 String.
                 counterValue = Integer.parseInt(c.getValue());
            }
        }
        // 쿠키를 추가한다
        Cookie cookie = new Cookie("visited", "방문했음"); // key, value -> 텍스트 뭉치
        Cookie counterCookie = new Cookie("counter",
                Integer.toString(counterValue + 1)); // key, value -> 텍스트 뭉치
        // domain (모든 url에서, 특정 url에서 사용하게 만드는...)
        // secure (https, localhost 등의 특정 상황에서만 사용가능한 쿠키)
        // httpOnly (js 편집을 막음...) -> cookie를 어느 범위 내에서 어떤 보안 상황
        // maxAge => 초 단위로 쿠키를 유지 기한을 정해놓는 것.
//        cookie.setMaxAge(24 * 60 * 60); // 하루를 유지
        cookie.setMaxAge(5); // 5초 유지
        resp.addCookie(cookie);
        // addCookie만 있고 delete 쿠키가 없음
        // 내가 삭제하고 싶은 쿠키가 있다
        counterCookie.setMaxAge(0); // 만료를 0초로 만들어버리거나...
        counterCookie.setAttribute("counter", ""); // 빈값을 덮어씌워서 삭제
        resp.addCookie(counterCookie); // 여러 개의 쿠키가 가능하다 -> 이름이 겹치면 덮어씌워짐
        // req -> attribute. -> redirect?
        req.getRequestDispatcher("/WEB-INF/views/cookie.jsp").forward(req, resp);
    }
}
