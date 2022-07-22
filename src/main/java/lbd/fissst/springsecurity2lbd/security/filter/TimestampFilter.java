package lbd.fissst.springsecurity2lbd.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

public class TimestampFilter extends OncePerRequestFilter {

    private static final Logger LOG = LoggerFactory.getLogger(TimestampFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LocalTime initialTime = LocalTime.now();
        try{
            filterChain.doFilter(request, response);
        }finally{
            String elapsedTime =  Duration.between(initialTime, LocalTime.now()).toString();
            LOG.info("Request time: " + elapsedTime);
        }
    }
}
