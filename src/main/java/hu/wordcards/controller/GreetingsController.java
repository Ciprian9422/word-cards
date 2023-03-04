package hu.wordcards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/custom_home")
@RestController
public class GreetingsController {

  @GetMapping("/greetings")
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from our API");
  }

  @GetMapping("/say-good-bye")
  public ResponseEntity<String> sayGoodBye() {
    return ResponseEntity.ok("Good bye and see you later");
  }
}
