package com.boot.global.filter;

import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public String getQueryString() {
        String value = super.getQueryString();
        if(value != null) {
            value = HtmlUtils.htmlEscape(value);
        }

        return value;
    }

    public String getParameter(String name) {
        String value = super.getParameter(HtmlUtils.htmlEscape(name));
        if(value != null) {
            value = HtmlUtils.htmlEscape(value);
        }

        return value;
    }

    public String getHeader(String name) {
        String value = super.getHeader(HtmlUtils.htmlEscape(name));
        if(value != null) {
            value = HtmlUtils.htmlEscape(value);
        }

        return value;
    }

    public String getRequestURI() {
        return HtmlUtils.htmlEscape(super.getRequestURI());
    }

    public StringBuffer getRequestURL() {
        return new StringBuffer(HtmlUtils.htmlEscape(super.getRequestURL().toString()));
    }

    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if(values == null) {
            return super.getParameterValues(name);
        } else {
            int length = values.length;
            String[] escapseValues = new String[length];

            for(int i = 0; i < length; ++i) {
                escapseValues[i] = HtmlUtils.htmlEscape(values[i]);
            }

            return escapseValues;
        }
    }
}