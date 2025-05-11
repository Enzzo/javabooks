package ru.vasilev.cip.notthreadsafe;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ru.vasilev.cip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet{
	private long count = 0;
	
	public long getCount() { return count; }
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		++count;
		encodeIntoResponse(res, factors);
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	private BigInteger extractFromRequest(ServletRequest req) {
		return BigInteger.valueOf(0);
	}
	
	private BigInteger[] factor(BigInteger i) {
		return null;
	}
	
	private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
		
	}

}
