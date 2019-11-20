package deloitte.forecastsystem_bih.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpresponse = (HttpServletResponse) res;
        HttpServletRequest httpRequest = (HttpServletRequest) req;

        httpresponse.setHeader("Access-Control-Allow-Origin", "*");
        httpresponse.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
        httpresponse.setHeader("Access-Control-Max-Age", "3600");
//        httpresponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, ADRESAR-TOKEN");
        httpresponse.setHeader("Access-Control-Expose-Headers", "access_token");
        httpresponse.setHeader("Access-Control-Allow-Headers", "*");//x-requested-with
        httpresponse.setHeader("Access-Control-Allow-Credentials", "true");        

        if (!"OPTIONS".equals(httpRequest.getMethod())) {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
    
}
