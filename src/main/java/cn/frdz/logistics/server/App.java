package cn.frdz.logistics.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动
 * 
 * @author sxc
 *
 */
@SpringBootApplication
@EnableSwagger2
//@Import(ApplicationConfiguration.class)	
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
