package baitapnha.jpa.hoangduy.blog.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import baitapnha.jpa.hoangduy.blog.config.JPAConfig;
import baitapnha.jpa.hoangduy.blog.config.WebMvcConfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
		@Override
		protected Class<?>[] getRootConfigClasses() {
			return new Class[] {JPAConfig.class };
			//return null;
		}
	 
		@Override
		protected Class<?>[] getServletConfigClasses() {
			return new Class[] { WebMvcConfig.class };
		}
	 
		@Override
		protected String[] getServletMappings() {
			return new String[] { "/" };
		}
	 
	}