package com.boot.global.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/**
 * @author by sunhao11 on 2017/9/18.
 */
@Component
@WebFilter(urlPatterns = {"/*"}, filterName = "csrfFilter")
public class CsrfFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //只允许jd域访问
        String referer = httpServletRequest.getHeader("referer");
        if (StringUtils.isNotBlank(referer)) {
            URL url = new URL(referer);
            referer = url.getHost();
        }

        if (StringUtils.isNotEmpty(referer) && !StringUtils.endsWith(referer, ".jd.com")
                && !StringUtils.endsWith(referer, ".jd.hk")
                && !StringUtils.endsWith(referer, ".jd.cn")) {
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }

}
