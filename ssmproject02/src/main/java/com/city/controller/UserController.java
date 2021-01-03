package com.city.controller;

import com.city.pojo.UserModel;
import com.city.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    //创建Service层对象
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/insert")
    public String insert(){
        UserModel userModel=new UserModel();
        userModel.setUsername("罗志祥");
        userModel.setPassword("12345");
        int result = userService.insert(userModel);

        return result+"";
    }

    @RequestMapping(value = "/update")
    public String update(){
        UserModel userModel=new UserModel();
        userModel.setId(2);
        userModel.setUsername("蔡徐坤");
        userModel.setPassword("唱跳rap");
        int result = userService.update(userModel);

        System.out.println(result);
        return result+"";
    }

    @RequestMapping(value = "/delete")
    public String delete(){
        int id = 3;

        int result = userService.delete(id);
        System.out.println(result);
        return result+"";
    }

    @RequestMapping(value = "selectById")
    public String selectById(){
        UserModel user = userService.selectById(1);
        System.out.println(user.getId()+"\t"+user.getUsername()+"\t"+user.getPassword());
        return "success";
    }

    @RequestMapping(value = "userselectAll")
    public String selectAll(){
        List<UserModel> list = userService.selectAll();
        for (UserModel user:list){
            System.out.println(user.getId()+"\t"+user.getUsername()+"\t"+user.getPassword());
        }
        return "success";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        UserModel userModel = userService.login(username,password);
        if (userModel!=null){
            session.setAttribute("loginuser",username);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码输入错误!!!");
            return "index";
        }
    }

}
