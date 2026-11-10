package prw3.avaliacao2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode =
		EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class Avaliacao2Application {
	//user: user@gmail.com
	//senha: 12345678
	public static void main(String[] args) {
		SpringApplication.run(Avaliacao2Application.class, args);
	}

}
