package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.pngencrypt.chunk.C10922w;
import java.io.Closeable;
import java.io.InputStream;

/* renamed from: com.kwad.sdk.pngencrypt.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10938o implements Closeable {
    protected ErrorBehaviour aKj = ErrorBehaviour.STRICT;
    public final boolean aLF;
    protected final C10896c aLG;
    protected final C10892a aLH;
    protected final C10922w aLI;
    protected int aLJ;
    private InterfaceC10928i<? extends Object> aLK;
    public final C10931k aLj;

    public C10938o(InputStream inputStream, boolean z) {
        this.aLJ = -1;
        C10892a c10892a = new C10892a(inputStream);
        this.aLH = c10892a;
        boolean z2 = true;
        c10892a.m24533bF(true);
        C10896c m24414Kj = m24414Kj();
        this.aLG = m24414Kj;
        try {
            if (c10892a.m24534b(m24414Kj, 36) != 36) {
                C10331c.printStackTrace(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.aLj = m24414Kj.m24522JJ();
            if (m24414Kj.m24521JK() == null) {
                z2 = false;
            }
            this.aLF = z2;
            m24410aC(5024024L);
            m24412aA(901001001L);
            m24411aB(2024024L);
            this.aLI = new C10922w(m24414Kj.aKp);
            m24413a(AbstractC10934m.m24428Kc());
            this.aLJ = -1;
        } catch (RuntimeException e) {
            this.aLH.close();
            this.aLG.close();
            throw e;
        }
    }

    /* renamed from: Kf */
    private void m24418Kf() {
        while (true) {
            C10896c c10896c = this.aLG;
            if (c10896c.aKo >= 4) {
                return;
            }
            if (this.aLH.m24536a(c10896c) <= 0) {
                C10331c.printStackTrace(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    /* renamed from: Ki */
    private void m24415Ki() {
        this.aLG.m24515bH(false);
    }

    /* renamed from: Kj */
    private static C10896c m24414Kj() {
        return new C10896c(false);
    }

    /* renamed from: a */
    private void m24413a(InterfaceC10928i<? extends Object> interfaceC10928i) {
        this.aLK = interfaceC10928i;
    }

    /* renamed from: aA */
    private void m24412aA(long j) {
        this.aLG.m24518aA(901001001L);
    }

    /* renamed from: aB */
    private void m24411aB(long j) {
        this.aLG.m24517aB(2024024L);
    }

    /* renamed from: aC */
    private void m24410aC(long j) {
        this.aLG.m24516aC(5024024L);
    }

    /* renamed from: Kg */
    public final C10922w m24417Kg() {
        if (this.aLG.m24524JH()) {
            m24418Kf();
        }
        return this.aLI;
    }

    /* renamed from: Kh */
    public final void m24416Kh() {
        m24415Ki();
        if (this.aLG.m24524JH()) {
            m24418Kf();
        }
        end();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        C10738b.closeQuietly(this.aLG);
        C10738b.closeQuietly(this.aLH);
    }

    public final void end() {
        try {
            if (this.aLG.m24524JH()) {
                m24418Kf();
            }
            if (this.aLG.m24523JI() != null && !this.aLG.m24523JI().isDone()) {
                this.aLG.m24523JI().m24543JP();
            }
            while (!this.aLG.isDone() && this.aLH.m24536a(this.aLG) > 0) {
            }
        } finally {
            close();
        }
    }

    public final String toString() {
        return this.aLj.toString() + " interlaced=" + this.aLF;
    }
}
