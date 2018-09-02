package org.sweetycode.designpattern.structural.decorator.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tiantian on 02/09/2018.
 */
public class LowerCaseInputStream extends FilterInputStream{
    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException{
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase(c));
    }

    public int read(byte[] b, int offset, int len) throws IOException{
        int c = super.read(b, offset, len);
        for(int i = offset; i < offset + c; i ++) {
            b[i] = (byte) Character.toLowerCase(b[i]);
        }
        return c;
    }
}
