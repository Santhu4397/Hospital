package com.ty.Hospital.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class HospitalConfiguration {

	@Bean
	public Docket getDocket() {

		Contact contact = new Contact("Alpha team", "http://testyantra.com/", "alpha@ty");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("Hospital API documnet", "API to track the hospitals",
				"TYP_Hospital snapshot 1.0.1", "https://testyantra.com", contact, "Licence 1172",
				"http://jsonbeautifier.org/", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.Hospital")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}

}
