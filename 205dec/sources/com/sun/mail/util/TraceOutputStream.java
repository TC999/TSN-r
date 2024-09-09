package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class TraceOutputStream extends FilterOutputStream {
    private boolean quote;
    private boolean trace;
    private OutputStream traceOut;

    public TraceOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.trace = false;
        this.quote = false;
        this.traceOut = outputStream2;
    }

    private final void writeByte(int i4) throws IOException {
        int i5 = i4 & 255;
        if (i5 > 127) {
            this.traceOut.write(77);
            this.traceOut.write(45);
            i5 &= 127;
        }
        if (i5 == 13) {
            this.traceOut.write(92);
            this.traceOut.write(114);
        } else if (i5 == 10) {
            this.traceOut.write(92);
            this.traceOut.write(110);
            this.traceOut.write(10);
        } else if (i5 == 9) {
            this.traceOut.write(92);
            this.traceOut.write(116);
        } else if (i5 < 32) {
            this.traceOut.write(94);
            this.traceOut.write(i5 + 64);
        } else {
            this.traceOut.write(i5);
        }
    }

    public void setQuote(boolean z3) {
        this.quote = z3;
    }

    public void setTrace(boolean z3) {
        this.trace = z3;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        if (this.trace) {
            if (this.quote) {
                writeByte(i4);
            } else {
                this.traceOut.write(i4);
            }
        }
        ((FilterOutputStream) this).out.write(i4);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        if (this.trace) {
            if (this.quote) {
                for (int i6 = 0; i6 < i5; i6++) {
                    writeByte(bArr[i4 + i6]);
                }
            } else {
                this.traceOut.write(bArr, i4, i5);
            }
        }
        ((FilterOutputStream) this).out.write(bArr, i4, i5);
    }
}
