package com.java.CYJ_Board.board.entity;

import com.java.CYJ_Board.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Board extends Auditable {
/*
// ID, 제목, 본문, 생성날짜, 연관 게시글
// 생성날짜는 JPA 에서 제공하는 Auditing 사용
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<RelatedBoard> relatedBoards = new ArrayList<>();
}
