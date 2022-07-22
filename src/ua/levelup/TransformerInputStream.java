package ua.levelup;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TransformerInputStream extends FilterInputStream {

    private char from;
    private char to;

    protected TransformerInputStream(InputStream in, char from, char to) {
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

    public static void main(String[] args) {
        try (TransformerInputStream tsr =
                     new TransformerInputStream(
                     new TransformerInputStream(System.in, 'a', 't'), 't', 'q'))
        {
            int read;
            while ((read = tsr.read()) != -1){
                System.out.print((char) read);
            }
        }
        catch (Exception error){
            System.err.println(error.getMessage());
        }

    }
}
