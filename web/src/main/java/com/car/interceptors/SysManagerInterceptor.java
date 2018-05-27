package com.car.interceptors;

import com.car.pojo.Funs;
import com.car.pojo.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SysManagerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果是登录页面或登录动作放行
        String uri = request.getRequestURI();
        if (uri.indexOf("login.jsp") != -1 || uri.indexOf("user/login.do") != -1 || "/car/".equals(uri)) {
            return true;
        }
        // 判断用户是否登录
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        // 得到该用户所拥有的权限List
        List<Funs> funsList = (List<Funs>) request.getSession().getAttribute("funsList");
        // 判断该用户是否有权限访问
        for (Funs funs : funsList) {
            if (uri.indexOf(funs.getFunUrl()) != -1) {

                return true;
            }
        }
        request.setAttribute("message", "您无权访问该页面");
        request.getRequestDispatcher("/error.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
