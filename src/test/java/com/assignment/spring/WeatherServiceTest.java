package com.assignment.spring;

import com.assignment.spring.constants.Constants;
import com.assignment.spring.converter.WeatherMapper;
import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.repository.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.service.impl.WeatherServiceImpl;
import org.apache.coyote.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest extends BaseControllerServicesTest {

	private static final String TEST_CITY_CODE = "lon";
	private static final String API_KEY_FIELD_NAME = "apiKey";
	private static final String MOCK_API_KEY = "12345";
	@InjectMocks
	private WeatherServiceImpl uut;

	@Mock
	private WeatherRepository weatherRepository;

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private WeatherMapper mapper;

	@Before
	public void init() {
		ReflectionTestUtils.setField(uut, API_KEY_FIELD_NAME, MOCK_API_KEY);
	}

	@Test
	public void processWeatherResult_success() {
		//Arrange
		WeatherEntity expectedEntity = new WeatherEntity();
		expectedEntity.setCity(TEST_CITY_CODE);
		ResponseEntity<WeatherResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(restTemplate.getForEntity(Mockito.anyString(), Mockito.eq(WeatherResponse.class))).thenReturn(responseEntity);
		when(weatherRepository.save(Mockito.any())).thenReturn(expectedEntity);

		//Act
		WeatherEntity result = uut.processWeatherResult(TEST_CITY_CODE);

		//Assert
		assertEquals(TEST_CITY_CODE, result.getCity());
	}
}
