package kh.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvices {

	@Before("execution(* kh.spring.practice.HomeController.*(..))")
	public void printlog(JoinPoint jp) {
		Signature sn = jp.getSignature();
		System.out.println(sn.getName()+"에서 실행");
	}
}
