package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import javax.mail.MessagingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
        } catch (Exception e4) {
            throw new MessagingException("IOException", e4);
        }
    }

    public void writeln() throws MessagingException {
        try {
            ((FilterOutputStream) this).out.write(newline);
        } catch (Exception e4) {
            throw new MessagingException("IOException", e4);
        }
    }
}
