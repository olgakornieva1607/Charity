package pl.coderslab.charity.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.model.CurrentUser;

import java.io.IOException;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

          CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
          String redirectURL = request.getContextPath();
          if(currentUser.getUser().hasRole("ROLE_ADMIN")){
              redirectURL = "/admin";
          }else if(currentUser.getUser().hasRole("ROLE_USER")){
              redirectURL = "/donation";
          }

          response.sendRedirect(redirectURL);


    }
}
