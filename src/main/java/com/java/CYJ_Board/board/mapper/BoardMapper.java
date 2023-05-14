package com.java.CYJ_Board.board.mapper;

import com.java.CYJ_Board.board.dto.*;
import com.java.CYJ_Board.board.entity.Board;
import com.java.CYJ_Board.board.entity.RelatedBoard;
import com.java.CYJ_Board.board.repository.BoardRepository;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board boardPostDtoToBoard(BoardPostDto requestBody);
    BoardResponseDto boardToBoardResponseDto(Board board);
    default List<BoardListResponseDto> boardsToBoardResponseDto(List<Board> boards) {
        return boards.stream()
                .map(board -> BoardListResponseDto.builder()
                        .title(board.getTitle())
                        .createdAt(board.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
    default List<RelatedBoardListResponseDto> boardsToRelatedBoardResponseDto(List<Board> relatedBoards) {
        return relatedBoards.stream()
                .map(board -> RelatedBoardListResponseDto.builder()
                        .relatedId(board.getBoardId())
                        .title(board.getTitle())
                        .build())
                .collect(Collectors.toList());
    }

    default BoardAllResponseDto boardToBoardAllResponseDto(Board board,
                                                           List<Board> relatedBoard) {
        return BoardAllResponseDto.builder()
                .content(board.getContent())
                .relatedBoard(boardsToRelatedBoardResponseDto(relatedBoard))
                .build();
    }
}
