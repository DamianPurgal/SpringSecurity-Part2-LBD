package lbd.fissst.springsecurity2lbd.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lbd.fissst.springsecurity2lbd.security.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class SetDecimalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if(request.getMethod().equalsIgnoreCase("POST")){
            String headerValue = request.getHeader("decimalPlaces");

            if(headerValue != null){
                if(headerValue.equals("1") || headerValue.equals("2") || headerValue.equals("3") || headerValue.equals("4")){
                    filterChain.doFilter(request, response);
                    return;
                }
            }

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(),
                    new ErrorResponse(
                            "decimalPlaces value invalid!"
                    )
            );
            return;

        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
