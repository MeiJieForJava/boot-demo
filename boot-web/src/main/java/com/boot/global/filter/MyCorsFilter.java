package com.boot.global.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * local测试时实现基本的允许跨域请求
 * Created by huquanbo on 2018/12/6.
 */
@Component
@WebFilter(urlPatterns = {"/*"}, filterName = "myCorsFilter")
public class MyCorsFilter implements Filter {

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(CorsUtils.isPreFlightRequest(request)) {
            response.setStatus(204);
            response.addHeader("Access-Control-Allow-Origin", "http://admin.jan.jd.com"); //确保host绑定此域名
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Max-Age", "3600");
            response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Requested-With, Accept, X-Custom-Header, Authorization");
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Connection", "keep-alive");
            response.addIntHeader("Content-Length", 0);
            response.addHeader("Content-Type", "text/html;charset=UTF-8");
            response.addDateHeader("Date", System.currentTimeMillis());
            response.addDateHeader("Expires", System.currentTimeMillis());
            return;
        }
        response.addHeader("Access-Control-Allow-Origin", "http://admin.jan.jd.com"); //确保host绑定此域名
        response.addHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //用判断有没有做nginx代理，判断需不需要此filter处理跨域
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip)){
            //未做代理
            doFilterInternal(request, (HttpServletResponse)servletResponse, filterChain);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
