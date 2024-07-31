package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class QDecoderStream extends QPDecoderStream {
    public QDecoderStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.sun.mail.util.QPDecoderStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (read == 95) {
            return 32;
        }
        if (read == 61) {
            this.f36236ba[0] = (byte) ((FilterInputStream) this).in.read();
            this.f36236ba[1] = (byte) ((FilterInputStream) this).in.read();
            try {
                return ASCIIUtility.parseInt(this.f36236ba, 0, 2, 16);
            } catch (NumberFormatException e) {
                throw new IOException("Error in QP stream " + e.getMessage());
            }
        }
        return read;
    }
}
