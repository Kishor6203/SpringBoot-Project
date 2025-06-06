package com.car;/*
    @author Dasun
*/

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.car.config.WebAppConfig;
import com.car.config.WebRootConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration){
        registration.setMultipartConfig(new MultipartConfigElement(System.getProperty("java.io.tmpdir")));
    }
}
