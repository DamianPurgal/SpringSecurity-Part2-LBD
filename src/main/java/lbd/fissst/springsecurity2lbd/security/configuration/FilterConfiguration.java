package lbd.fissst.springsecurity2lbd.security.configuration;

import lbd.fissst.springsecurity2lbd.security.filter.SetDecimalFilter;
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
        filterBean.setOrder(1);

        return filterBean;
    }

}
