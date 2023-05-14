package com.java.CYJ_Board.board.mapper;

import com.java.CYJ_Board.board.dto.BoardListResponseDto;
import com.java.CYJ_Board.board.dto.BoardPostDto;
import com.java.CYJ_Board.board.dto.BoardResponseDto;
import com.java.CYJ_Board.board.entity.Board;
import com.java.CYJ_Board.board.entity.RelatedBoard;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board boardPostDtoToBoard(BoardPostDto requestBody);
    BoardResponseDto boardToBoardResponseDto(Board board);
    List<BoardListResponseDto> boardsToBoardResponseDto(List<Board> boards);
    List<RelatedBoard> boardsToRelatedBoardResponseDto(List<Board> relatedBoards);
}
