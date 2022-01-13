package com.battleship.utils;

@FunctionalInterface
public interface Checker {
    Boolean verify(int a, int b);
}
