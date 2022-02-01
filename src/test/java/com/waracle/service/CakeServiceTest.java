package com.waracle.service;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.waracle.model.Cake;
import com.waracle.model.CakeDTO;
import com.waracle.repository.CakeRepository;

@ExtendWith(MockitoExtension.class)
class CakeServiceTest {

	@Mock
	private CakeRepository cakeRepository;

	@InjectMocks
	private CakeService cakeService;

	@BeforeEach
	public void setUp() {
//		MockitoAnnotations.initMocks(this); // this is needed for inititalizytion of
		// mocks, if you use @Mock
	}

	@Test
	void shouldGetAllCakesCalledSuccessfully() {
		try {
			List<Cake> expectedValue = new ArrayList<>();

			// CakeService cakeService = new CakeService();
			Cake c1 = new Cake("chocolate", "chocolate cake description", "c1URL");
			Cake c2 = new Cake("lemon", "lemon cake description", "c2URL");
			Cake c3 = new Cake("strawberry", "strawberry cake description", "c3URL");
			expectedValue.add(c1);
			expectedValue.add(c2);
			expectedValue.add(c3);
			List<Cake> mockValues = Arrays.asList(c1, c2, c3);
			doReturn(mockValues).when(cakeRepository).findAll();
			List<Cake> actualValue = cakeService.getAllCakes();
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			Assertions.assertEquals(expectedValue, actualValue);

		} catch (Exception exception) {
			exception.printStackTrace();
			Assertions.assertFalse(false);
		}
	}

	@Test
	void getCakeById() {
		Cake expectedValue = new Cake("chocolate", "chocolate cake description", "c1URL");
		Integer id = 0;
		Cake mockValue = new Cake("chocolate", "chocolate cake description", "c1URL");
		doReturn(mockValue).when(cakeRepository).getById(id);
		Cake actualValue = cakeService.getCakeById(id);
		System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
		Assertions.assertEquals(expectedValue, actualValue);

	}

	@Test
	void save() {
		Cake expectedValue = new Cake("chocolate", "chocolate cake description", "c1URL");
		CakeDTO cakeDTO = new CakeDTO("chocolate", "chocolate cake description", "c1URL");
		Cake cake = new Cake("chocolate", "chocolate cake description", "c1URL");
		doReturn(cake).when(cakeRepository).save(cake);
		Cake actualValue = cakeService.save(cakeDTO);
		System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
		Assertions.assertEquals(expectedValue, actualValue);

	}
}
