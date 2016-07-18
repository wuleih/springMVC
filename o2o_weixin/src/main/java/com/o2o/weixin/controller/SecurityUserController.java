package com.o2o.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.o2o.ao.Message;
import com.o2o.dto.AccountDto;
import com.o2o.enums.AssertInfo;
import com.o2o.security.MD5;
import com.o2o.soa.service.AccountSoaService;

@Controller
@RequestMapping("com/o2o/weixin")
public class SecurityUserController extends BaseController {
	
	@Autowired
	private AccountSoaService accountSoaService;
	
	@RequestMapping("login")
	public String securityUserLogin(String phone , String password,RedirectAttributes redirectAttributes,ModelMap model){
		Assert.isNull(phone,AssertInfo.phone_isnull.toString());
		Assert.isNull(password,AssertInfo.password_isnull.toString());
		Message message = new Message();
		AccountDto accountDto = accountSoaService.findSUByPhone(phone);
		if(accountDto != null && MD5.getMD5ofStr(password).equals(accountDto.getPassword())){
			//账号密码符合
		}else if(accountDto == null){
			//跳到注册页面
			/*redirectAttributes.addAttribute("phone", phone);
			redirectAttributes.addAttribute("password", password);
			return "redirect:com/o2o/weixin/register.do";*/
			model.addAttribute("phone", phone);
			model.addAttribute("password", password);
			return "production/example/register.jsp";
		}
		return null;
	}
	
	@RequestMapping("register")
	public Message register(String phone , String password){
		Message message = new Message();
		message.setType(Message.Type.success);
		return message;
	}

}
