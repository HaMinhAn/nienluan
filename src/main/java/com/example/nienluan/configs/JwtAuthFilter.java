package com.example.nienluan.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

  private final UserAuthProvider userAuthProvider;
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String header = request.getHeader(HttpHeaders.AUTHORIZATION);

    if(header != null){
      String[] elements = header.split(" ");

      if(elements.length == 2 && "Bearer".equals(elements[0])){
        try{
          System.out.println(elements[1]+ " "+ header);
          SecurityContextHolder.getContext().setAuthentication(
                  userAuthProvider.validateToken(elements[1])
          );
        } catch (RuntimeException e) {
          SecurityContextHolder.clearContext();
          throw e;
        }
      }
    }
    filterChain.doFilter(request,response);
  }
}