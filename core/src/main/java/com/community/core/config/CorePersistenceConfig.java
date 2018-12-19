package com.community.core.config;

import org.broadleafcommerce.common.demo.AutoImportPersistenceUnit;
import org.broadleafcommerce.common.demo.AutoImportSql;
import org.broadleafcommerce.common.demo.AutoImportStage;
import org.broadleafcommerce.common.extensibility.context.merge.Merge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MapFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * 
 * 
 * @author Phillip Verheyden (phillipuniverse)
 */
@Configuration
public class CorePersistenceConfig {

    @Autowired
    @Qualifier("webDS")
    DataSource webDS;

    @Autowired
    @Qualifier("webSecureDS")
    DataSource webSecureDS;

    @Autowired
    @Qualifier("webStorageDS")
    DataSource webStorageDS;

    @Bean
    public MapFactoryBean blMergedDataSources() throws Exception {
        MapFactoryBean mapFactoryBean = new MapFactoryBean();
        Map<String, DataSource> sourceMap = new HashMap<>();
        sourceMap.put("jdbc/web", webDS);
        sourceMap.put("jdbc/webSecure", webSecureDS);
        sourceMap.put("jdbc/cmsStorage", webStorageDS);
        mapFactoryBean.setSourceMap(sourceMap);

        return mapFactoryBean;
    }
    
    @Merge(targetRef = "blMergedPersistenceXmlLocations", early = true)
    public List<String> corePersistenceXmlLocations() {
        return Arrays.asList("classpath*:/META-INF/persistence-core.xml");
    }
    
    @Merge(targetRef = "blMergedEntityContexts", early = true)
    public List<String> entityConfigurationLocations() {
        return Arrays.asList("classpath:applicationContext-entity.xml");
    }
    
    @Bean
    @ConditionalOnResource(resources = "classpath:/sql/prepopulate_customers.sql")
    public AutoImportSql blPrivateDemoCustomerData() {
    	return new AutoImportSql(AutoImportPersistenceUnit.BL_PU,"/sql/prepopulate_customers.sql", AutoImportStage.PRIMARY_LATE);
    }
    
    @Bean
    @ConditionalOnBean(name={"blEmbeddedDatabase"})
    @ConditionalOnResource(resources = "classpath:/sql/prepare_persistent_logins_table.sql")
    public AutoImportSql blPersistentLoginData() {
    	return new AutoImportSql(AutoImportPersistenceUnit.BL_PU,"/sql/prepare_persistent_logins_table.sql", AutoImportStage.PRIMARY_LATE);
    }
}
