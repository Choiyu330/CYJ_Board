package com.java.CYJ_Board.board.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class RelatedBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relatedId;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
