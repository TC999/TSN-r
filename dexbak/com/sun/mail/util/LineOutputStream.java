package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import javax.mail.MessagingException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class LineOutputStream extends FilterOutputStream {
    private static byte[] newline;

    static {
        newline = r0;
        byte[] bArr = {13, 10};
    }

    public LineOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void writeln(String str) throws MessagingException {
        try {
            ((FilterOutputStream) this).out.write(ASCIIUtility.getBytes(str));
            ((FilterOutputStream) this).out.write(newline);
        } catch (Exception e) {
            throw new MessagingException("IOException", e);
        }
    }

    public void writeln() throws MessagingException {
        try {
            ((FilterOutputStream) this).out.write(newline);
        } catch (Exception e) {
            throw new MessagingException("IOException", e);
        }
    }
}
