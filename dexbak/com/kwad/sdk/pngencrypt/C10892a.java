package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.kwad.sdk.pngencrypt.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10892a implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int aJP;
    private boolean aJQ;
    private long aJR;
    private byte[] buf;
    private boolean eof;
    private int offset;
    private InputStream stream;

    public C10892a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    /* renamed from: Jy */
    private void m24537Jy() {
        if (this.aJP > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int read = this.stream.read(this.buf);
            this.aJP = read;
            if (read == 0) {
                C10331c.printStackTrace(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.aJR += read;
            }
        } catch (IOException e) {
            C10331c.printStackTrace(new PngjException(e));
        }
    }

    /* renamed from: a */
    public final int m24536a(InterfaceC10925f interfaceC10925f) {
        return m24535a(interfaceC10925f, Integer.MAX_VALUE);
    }

    /* renamed from: b */
    public final int m24534b(InterfaceC10925f interfaceC10925f, int i) {
        int i2 = 36;
        while (i2 > 0) {
            int m24535a = m24535a(interfaceC10925f, i2);
            if (m24535a <= 0) {
                return m24535a;
            }
            i2 -= m24535a;
        }
        return 36;
    }

    /* renamed from: bF */
    public final void m24533bF(boolean z) {
        this.aJQ = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.aJP = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.aJQ) {
            C10738b.closeQuietly(inputStream);
        }
        this.stream = null;
    }

    private C10892a(InputStream inputStream, int i) {
        this.eof = false;
        this.aJQ = true;
        this.aJR = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
    }

    /* renamed from: a */
    private int m24535a(InterfaceC10925f interfaceC10925f, int i) {
        m24537Jy();
        if (i <= 0 || i >= this.aJP) {
            i = this.aJP;
        }
        if (i > 0) {
            int mo24441b = interfaceC10925f.mo24441b(this.buf, this.offset, i);
            if (mo24441b > 0) {
                this.offset += mo24441b;
                this.aJP -= mo24441b;
            }
            if (mo24441b > 0) {
                return mo24441b;
            }
            if (!interfaceC10925f.isDone()) {
                C10331c.printStackTrace(new PngjException("This should not happen!"));
            }
            return -1;
        }
        if (!this.eof) {
            C10331c.printStackTrace(new PngjException("This should not happen"));
        }
        return interfaceC10925f.isDone() ? -1 : 0;
    }
}
