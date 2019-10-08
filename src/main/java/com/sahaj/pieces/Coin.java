package com.sahaj.pieces;

import lombok.Getter;

@Getter
public enum Coin {
    BLACK(PieceColor.BLACK),
    RED(PieceColor.RED),
    GREEN(PieceColor.GREEN),
    WHITE(PieceColor.WHITE),
    NONE(PieceColor.NONE);
    private PieceColor color;

    Coin(PieceColor color) {
        this.color = color;
    }
}