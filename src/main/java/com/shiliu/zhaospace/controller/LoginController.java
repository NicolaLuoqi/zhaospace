package com.shiliu.zhaospace.controller;

import com.shiliu.zhaospace.api.dto.LoginDto;
import com.shiliu.zhaospace.common.utils.CommonUtils;
import com.shiliu.zhaospace.jpa.entity.UserEntity;
import com.shiliu.zhaospace.service.UserService;
import com.shiliu.zhaospace.tran.UserTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 页面初始化
     * @param userInfo
     * @return
     */
    @RequestMapping("/index")
    public String login(@ModelAttribute("userInfo") LoginDto userInfo){
        return "login";
    }


    /**
     * 登陆验证
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submit(@ModelAttribute("userInfo") @Validated LoginDto userInfo,
                         BindingResult rs,Model model) {
        String loginName=userInfo.getUserName();
        String pass=userInfo.getPassWard();
        UserEntity userEntity=userService.findUserByName(loginName);
        if(rs.hasErrors()) {
            return "login";
        }
        String dp="";
        if (userEntity!=null){
            dp=userEntity.getPassword();
        }else {
            userInfo.setMessage("该用户尚未注册，请点击注册按钮注册！");
            return "login";
        }
        //加密密码
        pass= CommonUtils.encode(pass);
        if (dp.equals(pass)){
            model.addAttribute("user", UserTrans.tranInfo(userEntity));
            return "/user/detail";
        }else {
            userInfo.setMessage("用户名或密码错误！");
        }

        return "login";
    }
}
