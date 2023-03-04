package hu.wordcards.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UserDao {

  private static final List<UserDetails> APPLICATION_USERS = Arrays.asList(
      new User("admin", "password", Collections.singleton(new SimpleGrantedAuthority("ROlE_ADMIN"))),
      new User("user", "password", Collections.singleton(new SimpleGrantedAuthority("ROlE_USER")))
  );

  public UserDetails findUserByUsername(String username) {
    return APPLICATION_USERS
        .stream()
        .filter(u -> u.getUsername().equals(username))
        .findFirst()
        .orElseThrow(() -> new UsernameNotFoundException("User was not found"));
  }
}
