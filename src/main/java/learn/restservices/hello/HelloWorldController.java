package learn.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//	@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	@GetMapping("/helloworld1")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/helloworld-bean")
	public UserDetails HelloWorldBean() {
		return new UserDetails("fName", "lName", "citival");
	}
}
