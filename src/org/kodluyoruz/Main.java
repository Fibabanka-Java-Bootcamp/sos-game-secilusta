package org.kodluyoruz;

import java.util.Scanner;

public class Main {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        game.play();
    }
}