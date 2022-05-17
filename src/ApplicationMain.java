/*
 * @(#)ApplicationMain.java
 *
 * Copyright (c) BANCO DE CHILE (Chile). All rights reserved.
 *
 * All rights to this product are owned by BANCO DE CHILE and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by BANCO DE CHILE.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * ApplicationMain.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 17-05-2022
 */
public class ApplicationMain {

    public static void main(String[] args) {
        final var inputText = "ARLEQUIN";
        final var blocks = new ArrayList<String[]>();
        blocks.add(new String[]{"B", "O"});
        blocks.add(new String[]{"H", "U"});
        blocks.add(new String[]{"X", "K"});
        blocks.add(new String[]{"V", "I"});
        blocks.add(new String[]{"D", "Q"});
        blocks.add(new String[]{"A", "T"});
        blocks.add(new String[]{"C", "P"});
        blocks.add(new String[]{"O", "B"});
        blocks.add(new String[]{"N", "A"});
        blocks.add(new String[]{"E", "R"});
        blocks.add(new String[]{"G", "T"});
        blocks.add(new String[]{"F", "S"});
        blocks.add(new String[]{"R", "E"});
        blocks.add(new String[]{"L", "Y"});
        blocks.add(new String[]{"T", "G"});
        blocks.add(new String[]{"P", "C"});
        blocks.add(new String[]{"Q", "D"});
        blocks.add(new String[]{"Z", "M"});
        blocks.add(new String[]{"F", "S"});
        blocks.add(new String[]{"J", "W"});
        final var blocksTemp = new ArrayList<>(blocks);
        final var text = inputText.toCharArray();
        final AtomicInteger countFound = new AtomicInteger();
        final AtomicBoolean isFound = new AtomicBoolean();
        for (char a : text) {
            isFound.set(false);
            IntStream.range(0, blocksTemp.size())
                .forEach(index -> {
                    final var t = String.valueOf(a);
                    if (!isFound.get()) {
                        if (t.equalsIgnoreCase(blocksTemp.get(index)[0]) || t.equalsIgnoreCase(blocksTemp.get(index)[1])) {
                            blocksTemp.remove(index);
                            isFound.set(true);
                            countFound.getAndIncrement();
                        }
                    }
                });
        }


        if(inputText.length() == countFound.get()) {
            System.out.print(inputText + ":" + "True");
        }else {
            System.out.print(inputText + ":" + "False");
        }
    }
}