package com.java.CYJ_Board.board.controller;

import com.java.CYJ_Board.board.dto.BoardPostDto;
import com.java.CYJ_Board.board.entity.Board;
import com.java.CYJ_Board.board.entity.RelatedBoard;
import com.java.CYJ_Board.board.mapper.BoardMapper;
import com.java.CYJ_Board.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardMapper boardMapper;

    // 게시글 작성
    @PostMapping()
    public ResponseEntity createBoard(@RequestBody BoardPostDto requestBody) {
        Board board = boardService.createBoard(
                boardMapper.boardPostDtoToBoard(requestBody));

        return new ResponseEntity<>(boardMapper.boardToBoardResponseDto(board), HttpStatus.CREATED);
    }

    // 게시글 목록 조회
    @GetMapping()
    public ResponseEntity getBoards() {
        List<Board> boards = boardService.findBoards();
        return new ResponseEntity<>(boardMapper.boardsToBoardResponseDto(boards), HttpStatus.OK);
    }

    // 연관 게시글 조회
    @GetMapping("/related/{boardId}")
    public ResponseEntity getRelatedBoards(@PathVariable("boardId") Long boardId) {
        Board board = boardService.findBoard(boardId);
        List<Board> relatedBoard = boardService.findRelatedBoards(board);

        return new ResponseEntity<>(boardMapper.boardsToRelatedBoardResponseDto(relatedBoard), HttpStatus.OK);
    }
}
