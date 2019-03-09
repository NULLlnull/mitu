package com.basedata.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.basedata.annotation.NeedPage;
import com.basedata.vo.SystemContext;

/**
 * 拦截器
 */
public class PagerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			NeedPage needpage = findAnnotation((HandlerMethod) handler, NeedPage.class);
			// 没有声明需要分页
			if (needpage != null) {
				int offset = 0;
				try {
					offset = Integer.parseInt(request.getParameter("start"));
				} catch (NumberFormatException e) {
				}
				SystemContext.setOffset(offset);
				SystemContext.setSize(10);
			}
		}
		return true;
	}

	private <T extends Annotation> T findAnnotation(HandlerMethod handler, Class<T> annotationType) {
		T annotation = handler.getBeanType().getAnnotation(annotationType);
		if (annotation != null)
			return annotation;
		return handler.getMethodAnnotation(annotationType);
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}
}
