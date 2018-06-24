package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import repositories.DummyConferenceApplicationRepository;

@WebFilter({"/" ,"/add"})
public class RegistrationClosedFilter implements Filter{
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
		
		if(new DummyConferenceApplicationRepository().count()>5){
			response.getWriter().print("Rejestracja na konferencje zakonczyla sie.");
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
