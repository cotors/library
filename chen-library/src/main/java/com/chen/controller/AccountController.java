package com.chen.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.pojo.Reader;
import com.chen.pojo.User;
import com.chen.service.ReaderService;
import com.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {

    @Autowired
    private UserService userService;
    @Autowired
    private ReaderService readerService;
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "index";
    }

    @RequestMapping("login")
    public String login(String userName, String userPwd, Model model, HttpSession session){
        if (userName.equals("admin")){
            //管理员登录
            boolean i=userService.login(userName,userPwd);
            if (i){
                QueryWrapper<User>qw=new QueryWrapper<>();
                qw.eq("username",userName);
                User user = userService.getOne(qw);
                session.setAttribute("image",user.getImage());
                session.setAttribute("currentUser",userName);
                session.setAttribute("password",userPwd);
                session.setAttribute("email",user.getEmail());
                return "waterMainMenu";
            }else {
                model.addAttribute("msg","用户名或密码错误！");
                return "index";
            }
        }else {
            boolean i=readerService.login(userName,userPwd);
            if (i){
                //普通用户登录
                QueryWrapper<Reader>qw=new QueryWrapper<>();
                qw.eq("rname",userName);
                Reader one = readerService.getOne(qw);
                session.setAttribute("image",one.getRimage());
                session.setAttribute("currentUser",userName);
                session.setAttribute("password",userPwd);
                session.setAttribute("email",one.getEmail());
                session.setAttribute("userId",one.getId());
                return "waterMainMenu1";
            }else {
                model.addAttribute("msg","用户名或密码错误！");
                return "index";
            }
        }
    }

    @RequestMapping("count")
    public String count(){
        return "chart";
    }


    @RequestMapping("pwd")
    public String pwd(){
        return "modify";
    }


    @RequestMapping("pwdUser")
    public String pwdUser(String userPwd,String newPwd,HttpSession session,Model model){
        String currentUser = (String) session.getAttribute("currentUser");
        boolean login = userService.login(currentUser, userPwd);
        if (login){
            User user = new User();
            user.setUsername(currentUser);
            String s = DigestUtil.md5Hex(newPwd);
            user.setPassword(s);
            QueryWrapper<User>qw=new QueryWrapper<>();
            qw.eq("username",currentUser);
            boolean update = userService.update(user, qw);
            if (update){
                return "index";
            }else {
                model.addAttribute("loginFail","修改密码失败");
            }
        }else {
            model.addAttribute("loginFail","用户验证失败");
        }
        return "modify";
    }


    @RequestMapping("logout")
    public String logout(){
        return "index";
    }

    @RequestMapping("register")
    public String register(String userName,String userPwd,String confirmPwd,Model model){
        if (!userPwd.equals(confirmPwd)){
            model.addAttribute("msg","两次输入的密码不一致");
        }

        Reader reader = new Reader();
        reader.setRname(userName);
        String s = DigestUtil.md5Hex(userPwd);
        reader.setPassword(s);
        boolean save = readerService.save(reader);
        return "index";

    }

    @RequestMapping("profile")
    public String profile(HttpSession session,Model model ){
        String currentUser = (String) session.getAttribute("currentUser");
        String  password = (String) session.getAttribute("password");
        if (currentUser.equals("admin")){
            QueryWrapper<User>qw=new QueryWrapper<>();
            qw.eq("username",currentUser);
            User one = userService.getOne(qw);
            one.setPassword(password);
            model.addAttribute("user",one);
            return "profile-admin";
        }else {
            QueryWrapper<Reader>qw=new QueryWrapper<>();
            qw.eq("rname",currentUser);
            Reader one = readerService.getOne(qw);
            one.setPassword(password);
            model.addAttribute("user",one);
            return "profile-reader";
        }
    }

    @RequestMapping("updateAdminProfile")
    public String updateAdminProfile(User user){
        String s = DigestUtil.md5Hex(user.getPassword());
        user.setPassword(s);
        boolean b = userService.updateById(user);
        return "index";
    }

    @RequestMapping("updateReaderProfile")
    public String updateReaderProfile(Reader reader){
        String s = DigestUtil.md5Hex(reader.getPassword());
        reader.setPassword(s);
        boolean b = readerService.updateById(reader);
        return "index";
    }

    
}
