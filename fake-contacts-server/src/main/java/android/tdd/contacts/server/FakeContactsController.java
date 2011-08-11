package android.tdd.contacts.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contact")
public class FakeContactsController {
	@RequestMapping("/list")
	public @ResponseBody List list() {
		return new ArrayList();
	}
}
