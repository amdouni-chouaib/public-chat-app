package com.example.websocketdemo.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.websocketdemo.userRepository;
import com.example.websocketdemo.Model.users;
@Component
public class MySuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	userRepository repo;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		updateUser(authentication);
		DefaultRedirectStrategy str = new DefaultRedirectStrategy();
		str.sendRedirect(request, response, "http://localhost:8080");
	}

	private void updateUser(Authentication authentication) {
		DefaultOidcUser userDetails = (DefaultOidcUser) authentication.getPrincipal();
		users user = new users();
		user.setEmail(userDetails.getEmail());
		user.setUsername(userDetails.getPreferredUsername());
		repo.save(user);
	}

}
