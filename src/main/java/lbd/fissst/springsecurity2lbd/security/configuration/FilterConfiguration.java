package lbd.fissst.springsecurity2lbd.security.configuration;

import lbd.fissst.springsecurity2lbd.security.filter.SetDecimalFilter;
import lbd.fissst.springsecurity2lbd.security.filter.TimestampFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<SetDecimalFilter> setDecimalFilter(){
        FilterRegistrationBean<SetDecimalFilter> filterBean
                = new FilterRegistrationBean<>();

        filterBean.setName("SetDecimalFilter");
        filterBean.addUrlPatterns("/api/decimal");
        filterBean.setFilter(new SetDecimalFilter());
        filterBean.setOrder(2);

        return filterBean;
    }

    @Bean
    public FilterRegistrationBean<TimestampFilter> timestampFilter(){
        FilterRegistrationBean<TimestampFilter> filterBean
                = new FilterRegistrationBean<>();

        filterBean.setName("TimestampFilter");
        filterBean.addUrlPatterns("/api/number");
        filterBean.setFilter(new TimestampFilter());
        filterBean.setOrder(1);

        return filterBean;
    }

}
