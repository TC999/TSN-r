package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TraceInputStream extends FilterInputStream {
    private boolean quote;
    private boolean trace;
    private OutputStream traceOut;

    public TraceInputStream(InputStream inputStream, OutputStream outputStream) {
        super(inputStream);
        this.trace = false;
        this.quote = false;
        this.traceOut = outputStream;
    }

    private final void writeByte(int i) throws IOException {
        int i2 = i & 255;
        if (i2 > 127) {
            this.traceOut.write(77);
            this.traceOut.write(45);
            i2 &= 127;
        }
        if (i2 == 13) {
            this.traceOut.write(92);
            this.traceOut.write(114);
        } else if (i2 == 10) {
            this.traceOut.write(92);
            this.traceOut.write(110);
            this.traceOut.write(10);
        } else if (i2 == 9) {
            this.traceOut.write(92);
            this.traceOut.write(116);
        } else if (i2 < 32) {
            this.traceOut.write(94);
            this.traceOut.write(i2 + 64);
        } else {
            this.traceOut.write(i2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (this.trace && read != -1) {
            if (this.quote) {
                writeByte(read);
            } else {
                this.traceOut.write(read);
            }
        }
        return read;
    }

    public void setQuote(boolean z) {
        this.quote = z;
    }

    public void setTrace(boolean z) {
        this.trace = z;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (this.trace && read != -1) {
            if (this.quote) {
                for (int i3 = 0; i3 < read; i3++) {
                    writeByte(bArr[i + i3]);
                }
            } else {
                this.traceOut.write(bArr, i, read);
            }
        }
        return read;
    }
}
