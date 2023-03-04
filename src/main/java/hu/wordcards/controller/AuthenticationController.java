package hu.wordcards.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {
/*
  private final AuthenticationManager authenticationManager;
  private final UserDao userDao;
  private final JwtUtils jwtUtils;*/

/*  @PostMapping("/auth")
  public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
  final UserDetails userDetails = userDao.findUserByEmail(request.getEmail());
  if(userDetails != null) {
    return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
  }
  return ResponseEntity.status(400).body("Some error has occured");
  }*/

}
