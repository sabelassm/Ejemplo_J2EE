package ejemplo.pruebacarga;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	public void init(FilterConfig arg0) throws ServletException { }
	
	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
				throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (filterableResource(httpRequest.getServletPath())) {
			if (httpRequest.getSession().getAttribute("UsuarioAppPruebasCarga") == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/pages/autherror.html");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	private boolean filterableResource (String resource) {
		if (resource.endsWith("login.jsf")) {
			return false;
		}
		return true;
	}
}
