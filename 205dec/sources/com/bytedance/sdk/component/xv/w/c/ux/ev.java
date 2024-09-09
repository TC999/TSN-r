package com.bytedance.sdk.component.xv.w.c.ux;

import com.bytedance.sdk.component.xv.c.fz;
import com.bytedance.sdk.component.xv.c.u;
import com.bytedance.sdk.component.xv.w.c.ux.sr;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ev implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    static final Logger f30819c = Logger.getLogger(ux.class.getName());
    private final c sr;
    private final boolean ux;

    /* renamed from: w  reason: collision with root package name */
    final sr.c f30820w;
    private final com.bytedance.sdk.component.xv.c.ux xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c();

        void c(int i4, int i5, int i6, boolean z3);

        void c(int i4, int i5, List<xv> list) throws IOException;

        void c(int i4, long j4);

        void c(int i4, com.bytedance.sdk.component.xv.w.c.ux.w wVar);

        void c(int i4, com.bytedance.sdk.component.xv.w.c.ux.w wVar, com.bytedance.sdk.component.xv.c.f fVar);

        void c(boolean z3, int i4, int i5);

        void c(boolean z3, int i4, int i5, List<xv> list);

        void c(boolean z3, int i4, com.bytedance.sdk.component.xv.c.ux uxVar, int i5) throws IOException;

        void c(boolean z3, t tVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(com.bytedance.sdk.component.xv.c.ux uxVar, boolean z3) {
        this.xv = uxVar;
        this.ux = z3;
        c cVar = new c(uxVar);
        this.sr = cVar;
        this.f30820w = new sr.c(4096, cVar);
    }

    private void ev(w wVar, int i4, byte b4, int i5) throws IOException {
        if (i4 < 8) {
            throw ux.w("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i4));
        }
        if (i5 == 0) {
            int p3 = this.xv.p();
            int p4 = this.xv.p();
            int i6 = i4 - 8;
            com.bytedance.sdk.component.xv.w.c.ux.w c4 = com.bytedance.sdk.component.xv.w.c.ux.w.c(p4);
            if (c4 == null) {
                throw ux.w("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(p4));
            }
            com.bytedance.sdk.component.xv.c.f fVar = com.bytedance.sdk.component.xv.c.f.f30681w;
            if (i6 > 0) {
                fVar = this.xv.xv(i6);
            }
            wVar.c(p3, c4, fVar);
            return;
        }
        throw ux.w("TYPE_GOAWAY streamId != 0", new Object[0]);
    }

    private void f(w wVar, int i4, byte b4, int i5) throws IOException {
        if (i5 != 0) {
            short ev = (b4 & 8) != 0 ? (short) (this.xv.ev() & 255) : (short) 0;
            wVar.c(i5, this.xv.p() & Integer.MAX_VALUE, c(c(i4 - 4, b4, ev), ev, b4, i5));
            return;
        }
        throw ux.w("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void gd(w wVar, int i4, byte b4, int i5) throws IOException {
        if (i4 != 4) {
            throw ux.w("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i4));
        }
        long p3 = this.xv.p() & 2147483647L;
        if (p3 == 0) {
            throw ux.w("windowSizeIncrement was 0", Long.valueOf(p3));
        }
        wVar.c(i5, p3);
    }

    private void r(w wVar, int i4, byte b4, int i5) throws IOException {
        if (i4 != 8) {
            throw ux.w("TYPE_PING length != 8: %s", Integer.valueOf(i4));
        }
        if (i5 == 0) {
            wVar.c((b4 & 1) != 0, this.xv.p(), this.xv.p());
            return;
        }
        throw ux.w("TYPE_PING streamId != 0", new Object[0]);
    }

    private void sr(w wVar, int i4, byte b4, int i5) throws IOException {
        if (i4 != 4) {
            throw ux.w("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i4));
        }
        if (i5 != 0) {
            int p3 = this.xv.p();
            com.bytedance.sdk.component.xv.w.c.ux.w c4 = com.bytedance.sdk.component.xv.w.c.ux.w.c(p3);
            if (c4 == null) {
                throw ux.w("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(p3));
            }
            wVar.c(i5, c4);
            return;
        }
        throw ux.w("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }

    private void ux(w wVar, int i4, byte b4, int i5) throws IOException {
        if (i5 != 0) {
            throw ux.w("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b4 & 1) != 0) {
            if (i4 == 0) {
                wVar.c();
                return;
            }
            throw ux.w("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i4 % 6 != 0) {
            throw ux.w("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i4));
        } else {
            t tVar = new t();
            for (int i6 = 0; i6 < i4; i6 += 6) {
                short gd = this.xv.gd();
                int p3 = this.xv.p();
                if (gd != 2) {
                    if (gd == 3) {
                        gd = 4;
                    } else if (gd == 4) {
                        gd = 7;
                        if (p3 < 0) {
                            throw ux.w("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (gd == 5 && (p3 < 16384 || p3 > 16777215)) {
                        throw ux.w("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(p3));
                    }
                } else if (p3 != 0 && p3 != 1) {
                    throw ux.w("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                tVar.c(gd, p3);
            }
            wVar.c(false, tVar);
        }
    }

    private void w(w wVar, int i4, byte b4, int i5) throws IOException {
        if (i5 == 0) {
            throw ux.w("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z3 = (b4 & 1) != 0;
        if (!((b4 & 32) != 0)) {
            short ev = (b4 & 8) != 0 ? (short) (this.xv.ev() & 255) : (short) 0;
            wVar.c(z3, i5, this.xv, c(i4, b4, ev));
            this.xv.ev(ev);
            return;
        }
        throw ux.w("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }

    private void xv(w wVar, int i4, byte b4, int i5) throws IOException {
        if (i4 != 5) {
            throw ux.w("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i4));
        }
        if (i5 != 0) {
            c(wVar, i5);
            return;
        }
        throw ux.w("TYPE_PRIORITY streamId == 0", new Object[0]);
    }

    public void c(w wVar) throws IOException {
        if (this.ux) {
            if (!c(true, wVar)) {
                throw ux.w("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.bytedance.sdk.component.xv.c.ux uxVar = this.xv;
        com.bytedance.sdk.component.xv.c.f fVar = ux.f30899c;
        com.bytedance.sdk.component.xv.c.f xv = uxVar.xv(fVar.r());
        Logger logger = f30819c;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.bytedance.sdk.component.xv.w.c.xv.c("<< CONNECTION %s", xv.ux()));
        }
        if (!fVar.equals(xv)) {
            throw ux.w("Expected a connection header but was %s", xv.c());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.xv.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c implements fz {

        /* renamed from: c  reason: collision with root package name */
        int f30821c;

        /* renamed from: f  reason: collision with root package name */
        private final com.bytedance.sdk.component.xv.c.ux f30822f;
        int sr;
        short ux;

        /* renamed from: w  reason: collision with root package name */
        byte f30823w;
        int xv;

        c(com.bytedance.sdk.component.xv.c.ux uxVar) {
            this.f30822f = uxVar;
        }

        private void w() throws IOException {
            int i4 = this.xv;
            int c4 = ev.c(this.f30822f);
            this.sr = c4;
            this.f30821c = c4;
            byte ev = (byte) (this.f30822f.ev() & 255);
            this.f30823w = (byte) (this.f30822f.ev() & 255);
            Logger logger = ev.f30819c;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(ux.c(true, this.xv, this.f30821c, ev, this.f30823w));
            }
            int p3 = this.f30822f.p() & Integer.MAX_VALUE;
            this.xv = p3;
            if (ev != 9) {
                throw ux.w("%s != TYPE_CONTINUATION", Byte.valueOf(ev));
            }
            if (p3 != i4) {
                throw ux.w("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.bytedance.sdk.component.xv.c.fz
        public long c(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            while (true) {
                int i4 = this.sr;
                if (i4 == 0) {
                    this.f30822f.ev(this.ux);
                    this.ux = (short) 0;
                    if ((this.f30823w & 4) != 0) {
                        return -1L;
                    }
                    w();
                } else {
                    long c4 = this.f30822f.c(xvVar, Math.min(j4, i4));
                    if (c4 == -1) {
                        return -1L;
                    }
                    this.sr = (int) (this.sr - c4);
                    return c4;
                }
            }
        }

        @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.bytedance.sdk.component.xv.c.fz
        public u c() {
            return this.f30822f.c();
        }
    }

    public boolean c(boolean z3, w wVar) throws IOException {
        try {
            this.xv.c(9L);
            int c4 = c(this.xv);
            if (c4 < 0 || c4 > 16384) {
                throw ux.w("FRAME_SIZE_ERROR: %s", Integer.valueOf(c4));
            }
            byte ev = (byte) (this.xv.ev() & 255);
            if (!z3 || ev == 4) {
                byte ev2 = (byte) (this.xv.ev() & 255);
                int p3 = this.xv.p() & Integer.MAX_VALUE;
                Logger logger = f30819c;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(ux.c(true, p3, c4, ev, ev2));
                }
                switch (ev) {
                    case 0:
                        w(wVar, c4, ev2, p3);
                        break;
                    case 1:
                        c(wVar, c4, ev2, p3);
                        break;
                    case 2:
                        xv(wVar, c4, ev2, p3);
                        break;
                    case 3:
                        sr(wVar, c4, ev2, p3);
                        break;
                    case 4:
                        ux(wVar, c4, ev2, p3);
                        break;
                    case 5:
                        f(wVar, c4, ev2, p3);
                        break;
                    case 6:
                        r(wVar, c4, ev2, p3);
                        break;
                    case 7:
                        ev(wVar, c4, ev2, p3);
                        break;
                    case 8:
                        gd(wVar, c4, ev2, p3);
                        break;
                    default:
                        this.xv.ev(c4);
                        break;
                }
                return true;
            }
            throw ux.w("Expected a SETTINGS frame but was %s", Byte.valueOf(ev));
        } catch (IOException unused) {
            return false;
        }
    }

    private void c(w wVar, int i4, byte b4, int i5) throws IOException {
        if (i5 != 0) {
            boolean z3 = (b4 & 1) != 0;
            short ev = (b4 & 8) != 0 ? (short) (this.xv.ev() & 255) : (short) 0;
            if ((b4 & 32) != 0) {
                c(wVar, i5);
                i4 -= 5;
            }
            wVar.c(z3, i5, -1, c(c(i4, b4, ev), ev, b4, i5));
            return;
        }
        throw ux.w("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<xv> c(int i4, short s3, byte b4, int i5) throws IOException {
        c cVar = this.sr;
        cVar.sr = i4;
        cVar.f30821c = i4;
        cVar.ux = s3;
        cVar.f30823w = b4;
        cVar.xv = i5;
        this.f30820w.c();
        return this.f30820w.w();
    }

    private void c(w wVar, int i4) throws IOException {
        int p3 = this.xv.p();
        wVar.c(i4, p3 & Integer.MAX_VALUE, (this.xv.ev() & 255) + 1, (Integer.MIN_VALUE & p3) != 0);
    }

    static int c(com.bytedance.sdk.component.xv.c.ux uxVar) throws IOException {
        return (uxVar.ev() & 255) | ((uxVar.ev() & 255) << 16) | ((uxVar.ev() & 255) << 8);
    }

    static int c(int i4, byte b4, short s3) throws IOException {
        if ((b4 & 8) != 0) {
            i4--;
        }
        if (s3 <= i4) {
            return (short) (i4 - s3);
        }
        throw ux.w("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s3), Integer.valueOf(i4));
    }
}
