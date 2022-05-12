/*
package com.qdc.demoeurekaprovider1.config;

import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

//ResourceServerConfigurerAdapter（资源服务配置类），在该类中对服务提供者程序的OAuth2.0认证服务属性进行配置。
public class Oauth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String URL="http://localhost:8081/oauth/check_token";

    public void configure(ResourceServerSecurityConfigurer resources)throws Exception{
        //设置验证token的方法，级使用test和123456的客户端身份去URL验证token
        RemoteTokenServices tokenServices=new RemoteTokenServices();
        tokenServices.setClientId("test");
        tokenServices.setClientSecret("123456");
        resources.tokenServices(tokenServices);
        //设置当前资源服务器的resource——id位userall
        resources.resourceId("userall").stateless(true);

    }
}
*/
