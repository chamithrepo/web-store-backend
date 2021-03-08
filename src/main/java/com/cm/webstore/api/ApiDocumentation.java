package com.cm.webstore.api;

import static com.cm.webstore.configuration.Constants.RequestMappings.API;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Chamith_Madusanka
 *
 * This generates API documentation for the exposed swagger endpoints.
 */
@Configuration
@EnableSwagger2
public class ApiDocumentation {
	private String title = "Web Store Backend API";

	private String description = "Web Store Backend API";

	private String version = "V1.0";

	/**
	 * Configuration for the exposed swagger endpoint.
	 *
	 * @return Docket.
	 */
	@Bean
	public Docket applicationApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant(API + "/**")).build().apiInfo(apiInfo());
	}

	/**
	 * Meta information for the API.
	 *
	 * @return API information object generated.
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(title).description(description).version(version).build();
	}
}
