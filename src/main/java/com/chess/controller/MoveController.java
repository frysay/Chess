package com.chess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.chess.controller.response.CountResponse;
import com.chess.controller.response.ExceptionResponse;
import com.chess.model.PieceType;
import com.chess.service.MoveService;

@RestController
@RequestMapping("/chess")
public class MoveController {
	
	@Autowired
	private MoveService service;
	
	@RequestMapping(value = "/moves-needed", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public CountResponse moveNeededRequest(
			@RequestParam(defaultValue = PieceType.DEFAULT_PIECE_TYPE) PieceType pieceType,
			@RequestParam(required = true) int boardSize,
			@RequestParam(required = true) int piecePositionX,
			@RequestParam(required = true) int piecePositionY,
			@RequestParam(required = true) int targetPositionX,
			@RequestParam(required = true) int targetPositionY) throws Exception {
		int count = service.moveNeeded(pieceType, boardSize, piecePositionX, piecePositionY, targetPositionX, targetPositionY);
		return new CountResponse(count);
	}

	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class})
	public ExceptionResponse handleBadRequest(Exception e) {
		return new ExceptionResponse(e.getMessage());
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ExceptionResponse handleInternalServerEror(Exception e) {
		return new ExceptionResponse(e.getMessage());
	}
}
