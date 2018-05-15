package com.bluebik.car.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bluebik.car.CarApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CarApplication.class)
@SpringBootTest
public class MuscleCarControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void verifyListAllMuscleCar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/cars").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}

	@Test
	public void verifyGetMuscleCar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/get-car/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.carBrand").exists())
				.andExpect(jsonPath("$.carModel").exists())
				.andExpect(jsonPath("$.carBrand").exists())
				.andExpect(jsonPath("$.horsepower").exists())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.carBrand").value("carBrand"))
				.andExpect(jsonPath("$.carModel").value("carModel"))
				.andExpect(jsonPath("$.horsepower").value("horsepower"))
				.andExpect(jsonPath("$.carEngine").value("carEngine"))
				.andDo(print());
	}

	@Test
	public void verifyInvalidMuscleCarArgument() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/get-car/xyz").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.errorCode").value(400))
				.andExpect(jsonPath("$.message")
						.value("The request could not be understood by the server due to malformed syntax.!!!!"))
				.andDo(print());
	}

	@Test
	public void verifyNullMuscleCar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/get-car/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.errorCode").value(404))
				.andExpect(jsonPath("$.message").value("MuscleCar doesn't exist")).andDo(print());
	}

	@Test
	public void verifyDeleteMuscleCar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/cars/delete-car/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.status").value(200))
				.andExpect(jsonPath("$.message").value("MuscleCar has been deleted")).andDo(print());
	}

	@Test
	public void verifyInvalidDeleteMuscleCar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/cars/delete-car/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.errorCode").value(404))
				.andExpect(jsonPath("$.message").value("MuscleCar delete doesn't exist")).andDo(print());
	}

	@Test
	public void verifySaveMuscleCar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/cars/add-car/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"carBrand\" : \"carBrand2\", \"carModel\" : \"carModel2\", \"horsepower\" : \"horsepower2\", \"carEngine\" : \"carEngine2\" }")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.carBrand").exists())
				.andExpect(jsonPath("$.carModel").exists())
				.andExpect(jsonPath("$.carBrand").exists())
				.andExpect(jsonPath("$.horsepower").exists())
				.andExpect(jsonPath("$.id").value(2))
				.andExpect(jsonPath("$.carBrand").value("carBrand2"))
				.andExpect(jsonPath("$.carModel").value("carModel2"))
				.andExpect(jsonPath("$.horsepower").value("horsepower2"))
				.andExpect(jsonPath("$.carEngine").value("carEngine2")).andDo(print());
	}

	
	 @Test
	 public void verifyUpdateMuscleCar() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders.put("/api/cars/update-car/2")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{ \"id\": \"2\", \"carBrand\" : \"carBrand3\", \"carModel\" : \"carModel3\", \"horsepower\" : \"horsepower3\", \"carEngine\" : \"carEngine3\" }")
					.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id").exists())
					.andExpect(jsonPath("$.carBrand").exists())
					.andExpect(jsonPath("$.carModel").exists())
					.andExpect(jsonPath("$.carBrand").exists())
					.andExpect(jsonPath("$.horsepower").exists())
					.andExpect(jsonPath("$.id").value(2))
					.andExpect(jsonPath("$.carBrand").value("carBrand3"))
					.andExpect(jsonPath("$.carModel").value("carModel3"))
					.andExpect(jsonPath("$.horsepower").value("horsepower3"))
					.andExpect(jsonPath("$.carEngine").value("carEngine3")).andDo(print());
	 }
	
	 @Test
	 public void verifyInvalidMuscleCarUpdate() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders.put("/api/cars/update-car/2")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{ \"id\": \"2\", \"carBrandd\" : \"carBrand3\", \"carModel\" : \"carModel3\", \"horsepower\" : \"horsepower3\", \"carEngine\" : \"carEngine3\" }")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.errorCode").value(404))
					.andExpect(jsonPath("$.message").value("MuscleCar to update doesn't exist"))
					.andDo(print());
	 }
}
