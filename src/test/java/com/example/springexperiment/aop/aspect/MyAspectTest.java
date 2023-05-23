package com.example.springexperiment.aop.aspect;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springexperiment.SpringExperimentApplication;

@SpringBootTest
class MyAspectTest {

	@Autowired
	private OrderService orderService;

	private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			SpringExperimentApplication.class);

	/*
	*
	* */
	@Test
	void AOP_적용_및_내부_메소드_호출_확인() {

		/*
		* order() 메소드는 프록시 객체를 통해 호출되는 메소드이지만
		* init() 메소드는 order() 메소드 내부에서 호출되기 때문에
		* 프록시 객체가 아닌 원본 타겟 객체를 통해 호출된다. 따라서 aop 가 적용되지 않음.
		* << 출력 >>
		* before - aop
		* order : 10
  	* init method called
		* */
		orderService.order(10);
	}

	/*
	* MyAspect 클래스에서 OrderService 를 포인트컷으로 지정했기 때문에
	* OrderService 가 스프링 빈으로 등록될 때 빈 후처리기가 동작하여 CGLIB 프록시 객체로 바꿔치기한다.
	* 따라서 OrderService 가 등록된 빈을 확인해보면 다음 결과가 나온다.
	* object: class com.example.springexperiment.aop.aspect.OrderServiceImpl$$SpringCGLIB$$0
	* */
	@Test
	void 등록된_빈_확인() {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = applicationContext.getBean(beanName);

				System.out.println("object: " + bean.getClass());
			}
		}

		orderService.init();
	}
}