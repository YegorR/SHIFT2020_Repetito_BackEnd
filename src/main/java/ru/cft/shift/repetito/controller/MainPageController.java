package ru.cft.shift.repetito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainPageController {
    @RequestMapping("/")
    public void main(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
    }
}
