package com.sorting.dozer;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Dozer utility class
 */
@Configuration
public class DozerUtils {

	/**
	 * Initializes the Dozer bean and loads configuration file
	 * @return
	 */
    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        
    	List<String> mappingFiles = Arrays.asList("dozer-configration-mapping.xml");
        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

}