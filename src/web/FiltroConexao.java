package web;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import util.EMLocal;

public class FiltroConexao implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException {
		EntityManager em = EMLocal.getEntityManager();
		try {
			em.getTransaction().begin();

			chain.doFilter(request, response);
			
			em.getTransaction().commit();
		}
		catch (Throwable ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			}
			catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
		finally {
			EMLocal.cleanEntityManager();
		}
	}

	public void init(FilterConfig config) throws ServletException {
	}
	
	public void destroy() {
	}
}
