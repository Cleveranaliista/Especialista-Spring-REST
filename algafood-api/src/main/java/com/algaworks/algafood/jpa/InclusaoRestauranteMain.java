package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("PORCÃO da RAJA GABAGLIA");

		Restaurante estaurante2 = new Restaurante();
		estaurante2.setNome("Baby Beef");

		restaurante1 = restauranteRepository.adicionar(restaurante1);
		estaurante2 = restauranteRepository.adicionar(estaurante2);

		System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
		System.out.printf("%d - %s\n", estaurante2.getId(), estaurante2.getNome());
	}
}