package com.epam.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {

    @Override
    public String readLine() throws IOException {
        String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.println(line);
        return line;
    }
}
