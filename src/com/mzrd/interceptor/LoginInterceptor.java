package com.mzrd.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;

public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception
    {
       // logger.info("afterCompletion:{}", request.getRequestURI());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
            throws Exception
    {
       // logger.info("postHandle:{}", request.getRequestURI());
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception
    {
        //��ȡsession
        HttpSession session = request.getSession();
        Object username = session.getAttribute("userInfo");
        //�û����Ϊnull �� �ض��� loginҳ�� ���������
        if(null == username)
        {
        	
            //�ض���login.html
             redirect(request, response); 
             return false;
        }
        return true;
    }

	private void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 //��ȡ��ǰ�����·��
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"  + request.getServerPort()+request.getContextPath();
        //���request.getHeader("X-Requested-With") ���ص���"XMLHttpRequest"˵������ajax������Ҫ���⴦�� ����ֱ���ض���Ϳ�����
        if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
            //����ajax�����ض���
            response.setHeader("REDIRECT", "REDIRECT");
            //����ajax���ض����·��
            response.setHeader("CONTENTPATH", basePath+"/index.html");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }else{
            response.sendRedirect(basePath + "/login.html");
        }
	}
	
} 
