package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String hello = request.getParameter("hello");
		System.out.println("-----"+hello);
		//返回到index页面
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("helloworld", "hello"+hello);
		return mav;
	}

}
