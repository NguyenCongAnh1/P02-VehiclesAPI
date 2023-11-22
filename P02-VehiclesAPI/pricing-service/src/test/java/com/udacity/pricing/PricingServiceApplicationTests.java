package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PricingService pricingService; // Mocking PricingService


	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetPrice_Success() throws Exception {
		// Arrange
		Long vehicleId = 1L;
//		Price expectedPrice = new Price("USD", BigDecimal.valueOf(100.00), vehicleId);
//
//		// Mocking the behavior of PricingService
//		when(PricingService.getPrice(vehicleId)).thenReturn(expectedPrice);

		// Act and Assert
		mockMvc.perform(get("/services/price")
						.param("vehicleId", String.valueOf(vehicleId)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.currency").value("USD"))
				.andExpect(jsonPath("$.vehicleId").value(vehicleId));

		// Optionally, you can verify that the pricingService.getPrice() method was called with the correct parameter
//		verify(pricingService, times(1)).getPrice(vehicleId);
	}

}

