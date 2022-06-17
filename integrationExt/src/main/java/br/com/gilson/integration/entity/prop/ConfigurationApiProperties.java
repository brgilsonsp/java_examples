package br.com.gilson.integration.entity.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="prop.configurationapi")
public class ConfigurationApiProperties {
	
	private String token;
	
	private String key;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isTokenValid(String tokenSent) {
		
		if(tokenSent == null || tokenSent.isEmpty())
			return false;
		
		return this.token.equals(tokenSent);
	}
	

}
