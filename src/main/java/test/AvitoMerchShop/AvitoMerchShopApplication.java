package test.AvitoMerchShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import test.Repository.MerchRepository;

@SpringBootApplication
@EnableJpaRepositories("test.Repository")
public class AvitoMerchShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvitoMerchShopApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(MerchRepository merchRepository) {
		return args -> {
			merchRepository.save(new Merch("t-shirt", 80L));
			merchRepository.save(new Merch("cup", 20L));
			merchRepository.save(new Merch("book", 50L));
			merchRepository.save(new Merch("pen", 10L));
			merchRepository.save(new Merch("powerbank", 200L));
			merchRepository.save(new Merch("hoody", 300L));
			merchRepository.save(new Merch("umbrella", 200L));
			merchRepository.save(new Merch("socks", 10L));
			merchRepository.save(new Merch("wallet", 50L));
			merchRepository.save(new Merch("pink-hoody", 500L));
		};
	}

}
