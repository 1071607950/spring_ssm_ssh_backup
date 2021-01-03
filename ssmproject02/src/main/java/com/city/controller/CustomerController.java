package com.city.controller;

import com.city.config.Iden;
import com.city.pojo.CustomerModel;
import com.city.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping(value = "/addCus")
    public String addCus(@RequestParam("imgName") String imgName){
        List list = Iden.sample(imgName);
        String address = null;
        String identify = null;

        if (list.size()==5){
            address = list.get(3).toString().substring(2);
            identify = list.get(4).toString().substring(6);
        }else if (list.size()==6){
            address = list.get(3).toString().substring(2)+list.get(4).toString();
            identify = list.get(5).toString().substring(6);
        }
        String truename = list.get(0).toString().substring(2);
        String gender = list.get(1).toString().substring(2,3);
        String nation = list.get(1).toString().substring(5);
        String birth = list.get(2).toString().substring(2);

        CustomerModel customerModel = new CustomerModel();
        customerModel.setTruename(truename);
        customerModel.setGender(gender);
        customerModel.setNation(nation);
        customerModel.setBirth(birth);
        customerModel.setIdentify(identify);
        customerModel.setAddress(address);
        customerModel.setInfo("D:\\workspace\\images\\sound1.mp3");
        customerService.addCus(customerModel);
        return "redirect:/customerSelectAll";
    }

    @RequestMapping(value = "/deleteCus")
    public String deleteCus(@RequestParam("id") String id){
        int cusId = Integer.parseInt(id);
        int i = customerService.deleteCus(cusId);
        return "redirect:/customerSelectAll";
    }

    @RequestMapping(value = "/modifyCus")
    public String modify(CustomerModel customerModel){
        int i = customerService.modifyCus(customerModel);
        return "redirect:/customerSelectAll";
    }

    @RequestMapping(value = "/selectCusById")
    public String selectCusById(@RequestParam("id") String id,Model model){
        int cusId = Integer.parseInt(id);
        CustomerModel customerModel = customerService.selectCusById(cusId);
        model.addAttribute("customer",customerModel);
        return "updateCus";
    }

    @RequestMapping(value = "/customerSelectAll")
    public String selectAll(Model model){
        List<CustomerModel> list = customerService.selectAll();

        model.addAttribute("customerlist",list);

        return "list";
    }

    @RequestMapping(value = "/jump")
    public String jump(){
        return "shibie";
    }

}
