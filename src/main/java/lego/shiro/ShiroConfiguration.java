package lego.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//勿动！！！勿动！！！千万别动！！！
@Configuration
public class ShiroConfiguration {
	
	private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, 

			String>();  
	//引用realm
	@Bean(name = "AuthRealm")  
	public AuthRealm getShiroRealm() {  
		return new AuthRealm();  
	}  
	//缓存管理	  
	@Bean(name = "shiroEhcacheManager")  
	public EhCacheManager getEhCacheManager() {  
		EhCacheManager em = new EhCacheManager();  
		em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");  
		return em;  
	}  
			  
	@Bean(name = "lifecycleBeanPostProcessor")  
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {  
		return new LifecycleBeanPostProcessor();  
	}  
	//动态代理		  
	@Bean  
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {  
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();  
		daap.setProxyTargetClass(true);  
		return daap;  
	}  
	//	  
	@Bean(name = "securityManager")  
	public DefaultWebSecurityManager getDefaultWebSecurityManager() {  
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();  
		dwsm.setRealm(getShiroRealm());  
		dwsm.setCacheManager(getEhCacheManager());  
		return dwsm;  
	}  
	//权限认证	  
	@Bean  
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {  
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();  
		aasa.setSecurityManager(getDefaultWebSecurityManager());  
		return new AuthorizationAttributeSourceAdvisor();  
	}  
	//拦截器	  
	@Bean(name = "shiroFilter")  
	public ShiroFilterFactoryBean getShiroFilterFactoryBean() {  
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();  
		shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
		shiroFilterFactoryBean.setLoginUrl("/login");  
		shiroFilterFactoryBean.setSuccessUrl("/index.jsp");  
		filterChainDefinitionMap.put("/AmazeUI-2.4.2/**", "anon");  
		filterChainDefinitionMap.put("/basic/**", "anon");  
		filterChainDefinitionMap.put("/css/**", "anon");  
		filterChainDefinitionMap.put("/images/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/index.jsp", "anon");
		filterChainDefinitionMap.put("/home.action", "anon");

		filterChainDefinitionMap.put("/**", "authc");  
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);  
		return shiroFilterFactoryBean;  
	}
}
