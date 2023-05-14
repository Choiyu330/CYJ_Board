package com.java.CYJ_Board.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BoardAllResponseDto {
    // 게시글 내용 + 연관 게시글 제목 ResponseDto
    private String content;
    private List<RelatedBoardListResponseDto> relatedBoard;
}
