package com.baizhi.boot.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/imgCode")
public class CaptchaController {
    @RequestMapping("/getImgCode")
    public void registCaptcha(HttpServletResponse resp) throws Exception {
        RequestAttributes attris = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attrs = (ServletRequestAttributes) attris;
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(80, 20,4,2);
        String code = captcha.getCode();
        attrs.setAttribute("code",code,RequestAttributes.SCOPE_SESSION);
        ServletOutputStream os = resp.getOutputStream();
        captcha.write(os);
    }
}
