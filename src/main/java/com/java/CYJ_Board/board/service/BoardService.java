package com.java.CYJ_Board.board.service;

import com.java.CYJ_Board.board.entity.Board;
import com.java.CYJ_Board.board.repository.BoardRepository;
import com.java.CYJ_Board.exception.BusinessLogicException;
import com.java.CYJ_Board.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시글 작성
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    // 게시글 리스트 조회
    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    // 연관 게시글 찾기
    public List<Board> findRelatedBoards(Board board) {
        List<Board> allBoards = findBoards();
        List<Board> relatedBoards = new ArrayList<>();
        List<String> words = splitWords(board);

        // 특정 게시글에서 단어들을 추출한 뒤
        // 모든 게시글을 순회하며 연관 단어 찾기
        // 순회하는 게시글에서 연관 단어 발견 시 commonWords 에 추가
        // commonWords.size() >= 2 일때 relatedBoards 에 게시글 담기
        for(Board b : allBoards) {
            // 자기 자신은 제외
            if(b.getBoardId().equals(board.getBoardId())) {
                continue;
            }
            List<String> wordsInRelatedBoard = splitWords(b);
            List<String> commonWords = new ArrayList<>(words);

            // 공통 단어 찾기
            commonWords.retainAll(wordsInRelatedBoard);

            if(commonWords.size() >= 2) { relatedBoards.add(b); }
        }

        return relatedBoards;
    }

    // 게시글 내용을 추출해서 공백 문자열을 기준으로 분리
    private List<String> splitWords(Board board) {
        return Arrays.asList(board.getContent().split("\\s+"));
    }

    // 게시글 존재 유무 확인
    public Board findBoard(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }
}
