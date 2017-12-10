package uz.ruslan.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * date 2/3/16.
 */

@Configuration
@EnableTransactionManagement
@PropertySources(value = {
        @PropertySource("classpath:hibernate.properties")
})
public class DatabaseConfiguration {

    @Resource
    private Environment environment;

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql:" + environment.getProperty("db.url")
                          + environment.getProperty("db.name"));
        dataSource.setUsername(environment.getProperty("db.user"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager getTansactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        transactionManager.setRollbackOnCommitFailure(true);
        transactionManager.setPersistenceUnitName("test");
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.FALSE);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL9Dialect");

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("uz.ruslan.domain");
        factory.setDataSource(getDataSource());
        factory.setJpaProperties(this.jpaProperties());
        factory.afterPropertiesSet();
        factory.setPersistenceXmlLocation("classpath:persistence.xml");
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory;
    }

    private Properties jpaProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("org.hibernate.envers.audit_table_suffix", "_AUDIT_LOG");
//        hibernateProperties.setProperty("org.hibernate.envers.auditTableSuffix", "_auditversions");
        hibernateProperties.setProperty("org.hibernate.envers.revisionFieldName", "audit_revision");
        hibernateProperties.setProperty("org.hibernate.envers.revisionTypeFieldName", "audit_rev_type");
        return hibernateProperties;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
}
