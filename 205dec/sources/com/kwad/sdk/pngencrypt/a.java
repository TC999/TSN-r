package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int aJP;
    private boolean aJQ;
    private long aJR;
    private byte[] buf;
    private boolean eof;
    private int offset;
    private InputStream stream;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    private void Jy() {
        if (this.aJP > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int read = this.stream.read(this.buf);
            this.aJP = read;
            if (read == 0) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.aJR += read;
            }
        } catch (IOException e4) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException(e4));
        }
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public final int b(f fVar, int i4) {
        int i5 = 36;
        while (i5 > 0) {
            int a4 = a(fVar, i5);
            if (a4 <= 0) {
                return a4;
            }
            i5 -= a4;
        }
        return 36;
    }

    public final void bF(boolean z3) {
        this.aJQ = z3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.aJP = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.aJQ) {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
        this.stream = null;
    }

    private a(InputStream inputStream, int i4) {
        this.eof = false;
        this.aJQ = true;
        this.aJR = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
    }

    private int a(f fVar, int i4) {
        Jy();
        if (i4 <= 0 || i4 >= this.aJP) {
            i4 = this.aJP;
        }
        if (i4 > 0) {
            int b4 = fVar.b(this.buf, this.offset, i4);
            if (b4 > 0) {
                this.offset += b4;
                this.aJP -= b4;
            }
            if (b4 > 0) {
                return b4;
            }
            if (!fVar.isDone()) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen!"));
            }
            return -1;
        }
        if (!this.eof) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen"));
        }
        return fVar.isDone() ? -1 : 0;
    }
}
