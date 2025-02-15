package demo.AvitoMerchShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import demo.Model.Merch;
import demo.Repository.MerchRepository;

@SpringBootApplication
@EnableJpaRepositories("test.Repository")
@EntityScan(basePackages = "test.Model")
public class AvitoMerchShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvitoMerchShopApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(MerchRepository merchRepository) {
		return args -> {
			if (merchRepository.count() == 0) {
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
			}
		};
	}

}

