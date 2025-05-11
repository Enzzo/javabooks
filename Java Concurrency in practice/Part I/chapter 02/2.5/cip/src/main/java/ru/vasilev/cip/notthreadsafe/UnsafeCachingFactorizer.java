package ru.vasilev.cip.notthreadsafe;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ru.vasilev.cip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {
	private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();

	private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

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
		if (i.equals(lastNumber.get())) {
			encodeIntoResponse(res, lastFactors.get());
		} else {
			BigInteger[] factors = factor(i);
			lastNumber.set(i);
			lastFactors.set(factors);
			encodeIntoResponse(res, factors);
		}
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