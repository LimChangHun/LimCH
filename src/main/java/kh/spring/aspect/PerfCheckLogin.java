package kh.spring.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfCheckLogin {
	
	@Autowired
	private HttpSession session;
	
	@Around("execution(* kh.spring.practice.HomeController.mypageProc(..))")
	public Object perfCheckLogin(ProceedingJoinPoint pjp) {
		Object retVal = null;
		String id = (String)session.getAttribute("id");
		if(id==null) {
			return "home";
		}else {
			try {
				retVal = pjp.proceed();
				
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return retVal;
	}
}
