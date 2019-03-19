package com.chess.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoveControllerTest {

	@Autowired
	public WebApplicationContext wac;

	public MockMvc mockMvc;

	@Before
	public void setUpMockMvc() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void moveControllerTest_pieceTypeDefault_ok() throws Exception {
		mockMvc.perform(get("/chess/moves-needed")
				.param("boardSize", "8")
				.param("piecePositionX", "0")
				.param("piecePositionY", "7")
				.param("targetPositionX", "7")
				.param("targetPositionY", "7")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("count").value(5));
	}
	
	@Test
	public void moveControllerTest_pieceTypeSpecific_ok() throws Exception {
		mockMvc.perform(get("/chess/moves-needed")
				.param("pieceType", "KNIGHT")
				.param("boardSize", "8")
				.param("piecePositionX", "0")
				.param("piecePositionY", "7")
				.param("targetPositionX", "7")
				.param("targetPositionY", "7")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("count").value(5));
	}

	@Test
	public void moveControllerTest_wrongPieceType_400() throws Exception {
		mockMvc.perform(get("/chess/moves-needed")
				.param("pieceType", "wrong_one")
				.param("boardSize", "8")
				.param("piecePositionX", "0")
				.param("piecePositionY", "7")
				.param("targetPositionX", "7")
				.param("targetPositionY", "7")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("count").doesNotExist())
		.andExpect(jsonPath("errorMessage").exists());
	}

	@Test
	public void moveControllerTest_missingInput_400() throws Exception {
		mockMvc.perform(get("/chess/moves-needed")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("count").doesNotExist())
		.andExpect(jsonPath("errorMessage").exists());
	}
}
