package com.nci.filter;

import com.alibaba.fastjson.JSONObject;
import com.nci.pojo.Result;
import com.nci.utils.JwtUtils;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //1.get request url
        String url = req.getRequestURL().toString();
        log.info("require url: {}",url);

        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        //2。Determine whether login is included in the request url, if it is included, it means a login operation, and let it go.
        if(url.contains("login")){
            log.info("login operation, let go...");
            chain.doFilter(request,response);
            return;
        }

        //3.获取请求头中的令牌（token）。
        //3.Get the token in the request header.
        String jwt = req.getHeader("token");

        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）。
        //4.Determine whether the token exists, if not, return an error result (not logged in).
        if(!StringUtils.hasLength(jwt)){
            log.info("The request header token is empty, and the unlogged information is returned");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            //Manual conversion object --json --------> Alibaba fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //5.解析token，如果解析失败，返回错误结果（未登录）。
        //5.Parse the token, and return an error result (not logged in) if the parsing fails.
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//jwt解析失败
            e.printStackTrace();
            log.info("Failed to parse the token, return not logged in error message");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            //Manual conversion object --json --------> Alibaba fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //6.放行。Let go
        log.info("Token legal, release");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}