package learn.restservices.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private ResourceBundleMessageSource messageSource;

//	@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	@GetMapping("/helloworld1")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/helloworld-bean")
	public UserDetails HelloWorldBean() {
		return new UserDetails("fName", "lName", "citival");
	}

	@GetMapping("/hello-int")
	public String getMessageInI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String locale) {
		return messageSource.getMessage("lable.hello", null, new Locale(locale));
	}

	@GetMapping("/hello-int2")
	public String getMessageInI18NFormat() {
		return messageSource.getMessage("lable.hello", null, LocaleContextHolder.getLocale());
	}
}
