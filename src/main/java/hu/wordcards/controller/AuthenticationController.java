package hu.wordcards.controller;

import hu.wordcards.config.JwtUtils;
import hu.wordcards.dao.UserDao;
import hu.wordcards.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthenticationController {
  private final AuthenticationManager authenticationManager;
  private final UserDao userDao;
  private final JwtUtils jwtUtils;

  @PostMapping("/authentication")
  public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    final UserDetails userDetails = userDao.findUserByUsername(request.getUsername());
    if (userDetails != null) {
      return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
    }
    return ResponseEntity.status(400).body("Some error has occured");
  }

}
