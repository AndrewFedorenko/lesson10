package ua.levelup;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TransformerInputStream extends FilterInputStream {

    char from;
    char to;

    TransformerInputStream(InputStream in, char from, char to) {
        super(in);
        this.from = from;
        this.to = to;
    }

    private int exchChar(int ch){
        return ch == (int)this.from ? (int)this.to : ch;
    }

    @Override
    public int read() throws IOException {
        int chr = super.read();
        return chr == -1 ? chr : exchChar(chr);
    }

}
