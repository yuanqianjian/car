package com.car.controller;

import com.car.pojo.Funs;
import com.car.pojo.Menus;
import com.car.pojo.Users;
import com.car.service.intf.RolesServiceIntf;
import com.car.service.intf.UsersServiceIntf;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersServiceIntf usersService;
    @Autowired
    private RolesServiceIntf rolesService;

    @RequestMapping("/addUser.do")
    public String addUser(Users user) {
        //添加用户信息
        usersService.addUser(user);

        return "redirect:/tips.jsp";
    }

    @RequestMapping("/findName.do")
    @ResponseBody
    public Object FindName(String userName) {
        //添加用户时验证登录名是否重复
        if (userName == null || userName == "") {
            return true;
        }
        Users users = usersService.selectUser(userName);
        if (users != null) {
            return false;
        }
        return true;
    }

    @RequestMapping("/findIdentity.do")
    @ResponseBody
    public Object findIdentity(String identity) {
        //添加用户时验证登录名是否重复
        if (identity == null || identity == "") {
            return true;
        }
        Users users = usersService.selectByIdentity(identity);
        if (users != null) {
            return false;
        }
        return true;
    }

    @RequestMapping("/findUsers.do")
    public String findUsers(Users users, Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize) {
        // 查询用户信息（高级查询）（分页）
        PageInfo<Users> pi = usersService.findUsers(users, pageNum, pageSize);
        // 保存总记录数
        model.addAttribute("total", pi.getTotal());
        // 保存分页数据
        model.addAttribute("userList", pi.getList());
        // 一共多少页数
        model.addAttribute("pages", pi.getPages());
        // 当前是第几页
        model.addAttribute("pageNum", pi.getPageNum());
        // 查询条件
        model.addAttribute("oldUser", users);
        return "users/showUsers";
    }

    @RequestMapping("/DeleteUser.do")
    public String deleteUser(String userName, Model model) {
        //删除用户信息
        boolean flag = usersService.removeUser(userName);
        if (flag) {
            return "redirect:findUsers.do";
        }
        model.addAttribute("message", "用户操作过出租汽车功能或者汽车入库功能，因不能删除");
        return "error";
    }

    @RequestMapping("/SelectUser.do")
    public String selectUser(String userName, Model model) {
        //查询用户信息
        Users user = usersService.selectUser(userName);
        model.addAttribute("user", user);
        return "users/updateUser";
    }

    @RequestMapping("/ModifyUser.do")
    public String modifyUser(Users user, HttpSession session) {
        //修改用户信息
        usersService.modifyUser(user);
        Users user2 = (Users) session.getAttribute("user");
        //如果用户和修改的用户是同一用户，则退出系统，需重新登录
        if (user.getUserName() == user2.getUserName()) {
            return "redirect:logout.do";
        }
        return "redirect:/tips.jsp";
    }

    @RequestMapping("/login.do")
    public String login(Users user1, Model model, HttpServletRequest request) {
        //验证用户登录信息
        Users user2 = usersService.login(user1);
        if (user2 != null) {
            List<Menus> menuList = rolesService.selectByRoleId(user2.getUserLevel());
            List<Funs> funsList = new ArrayList<>();
            for (Menus menus : menuList) {
                List<Funs> funsList2 = rolesService.selectByMenuId(menus.getMenuId());
                funsList.addAll(funsList2);
            }
            request.getSession().setAttribute("menuList", menuList);
            request.getSession().setAttribute("funsList", funsList);
            request.getSession().setAttribute("user", user2);
            return "redirect:/index.jsp";
        }
        model.addAttribute("message", "用户名或密码错误！！");
        return "login";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest req) {
        //销毁Session
        req.getSession().invalidate();
        return "redirect:/login.jsp";
    }

    @RequestMapping("/validation.do")
    public String validationLogin(HttpServletRequest req) {
        // 验证是否登录
        Users user = (Users)req.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login.jsp";
        }
        return "index";
    }
}
