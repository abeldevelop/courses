package com.abeldevelop.courses.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PostFilter extends ZuulFilter {
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		Long timeEnd = System.currentTimeMillis();
		Long timeStart = Long.parseLong((String) request.getAttribute("timeStart"));
		log.info("Time spend => {} seconds", (timeEnd - timeStart)/1000);
		log.info("Time spend => {} miliseconds", (timeEnd - timeStart));
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
