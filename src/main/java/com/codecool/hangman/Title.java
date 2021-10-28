package com.codecool.hangman;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Console;

public class Title {
    public static void title() {
        int width = 180;
        int heigth = 15;
        BufferedImage bufferedImage = new BufferedImage(
                width, heigth, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setFont(new Font("Noto Sans", Font.BOLD, 12));

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.drawString("H A N G M A N", 6, 10);

        for (int y = 0; y < heigth; y++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int x = 0; x < width; x++) {
                stringBuilder.append(bufferedImage.getRGB(x, y) == -16777216 ?
                        " " : "7");
            }

            if (stringBuilder.toString().trim().isEmpty()) {
                continue;
            }
            System.err.println(stringBuilder);
        }
    }
}
