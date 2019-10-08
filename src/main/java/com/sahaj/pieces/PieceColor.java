package com.sahaj.pieces;

import lombok.Getter;

@Getter
public enum PieceColor {
    BLACK("black"),
    RED("red"),
    GREEN("green"),
    WHITE("white"),
    NONE("");
    private String color;

    PieceColor(String color) {
        this.color = color;
    }
}