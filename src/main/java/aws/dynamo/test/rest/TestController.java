package aws.dynamo.test.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/hello/{name}")
  public String hello(@PathVariable String name) {
    return "Hello %s!".formatted(name);
  }

}
