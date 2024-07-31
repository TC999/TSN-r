package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.p348a.C9433c;
import com.kwad.framework.filedownloader.p348a.InterfaceC9432b;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p352e.InterfaceC9480a;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.services.C9566c;
import java.io.File;

/* renamed from: com.kwad.framework.filedownloader.download.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9470b {
    private C9566c afR;
    private C9492c.InterfaceC9493a afS;
    private C9492c.InterfaceC9494b afT;
    private C9492c.InterfaceC9497e afU;
    private volatile InterfaceC9440a afV;
    private C9492c.InterfaceC9496d afW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.framework.filedownloader.download.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9471a {
        private static final C9470b afX = new C9470b();
    }

    /* renamed from: vo */
    public static C9470b m28631vo() {
        return C9471a.afX;
    }

    /* renamed from: vt */
    private C9492c.InterfaceC9493a m28626vt() {
        C9492c.InterfaceC9493a interfaceC9493a = this.afS;
        if (interfaceC9493a != null) {
            return interfaceC9493a;
        }
        synchronized (this) {
            if (this.afS == null) {
                this.afS = m28623vw().m28399wu();
            }
        }
        return this.afS;
    }

    /* renamed from: vu */
    private C9492c.InterfaceC9494b m28625vu() {
        C9492c.InterfaceC9494b interfaceC9494b = this.afT;
        if (interfaceC9494b != null) {
            return interfaceC9494b;
        }
        synchronized (this) {
            if (this.afT == null) {
                this.afT = m28623vw().m28400wt();
            }
        }
        return this.afT;
    }

    /* renamed from: vv */
    private C9492c.InterfaceC9497e m28624vv() {
        C9492c.InterfaceC9497e interfaceC9497e = this.afU;
        if (interfaceC9497e != null) {
            return interfaceC9497e;
        }
        synchronized (this) {
            if (this.afU == null) {
                this.afU = m28623vw().m28401ws();
            }
        }
        return this.afU;
    }

    /* renamed from: vw */
    private C9566c m28623vw() {
        C9566c c9566c = this.afR;
        if (c9566c != null) {
            return c9566c;
        }
        synchronized (this) {
            if (this.afR == null) {
                this.afR = new C9566c();
            }
        }
        return this.afR;
    }

    /* renamed from: a */
    public final void m28635a(C9566c.C9568b c9568b) {
        synchronized (this) {
            this.afR = new C9566c(c9568b);
            this.afT = null;
            this.afU = null;
            this.afV = null;
            this.afW = null;
        }
    }

    /* renamed from: b */
    public final void m28634b(C9566c.C9568b c9568b) {
        synchronized (this) {
            this.afR = new C9566c(c9568b);
        }
    }

    /* renamed from: bh */
    public final InterfaceC9432b m28632bh(String str) {
        try {
            return m28625vu().mo24736be(str);
        } catch (Throwable unused) {
            C9433c.C9435b c9435b = new C9433c.C9435b();
            this.afT = c9435b;
            return c9435b.mo24736be(str);
        }
    }

    /* renamed from: vp */
    public final C9492c.InterfaceC9496d m28630vp() {
        C9492c.InterfaceC9496d interfaceC9496d = this.afW;
        if (interfaceC9496d != null) {
            return interfaceC9496d;
        }
        synchronized (this) {
            if (this.afW == null) {
                this.afW = m28623vw().m28398wv();
            }
        }
        return this.afW;
    }

    /* renamed from: vq */
    public final synchronized InterfaceC9440a m28629vq() {
        if (this.afV != null) {
            return this.afV;
        }
        this.afV = m28623vw().m28402wr();
        m28636a(this.afV.mo28767vf());
        return this.afV;
    }

    /* renamed from: vr */
    public final int m28628vr() {
        return m28623vw().m28404vr();
    }

    /* renamed from: vs */
    public final boolean m28627vs() {
        m28624vv();
        return true;
    }

    /* renamed from: b */
    public final InterfaceC9480a m28633b(File file) {
        return m28624vv().mo28541c(file);
    }

    /* renamed from: a */
    public final int m28637a(int i, String str, String str2, long j) {
        return m28626vt().mo28543O(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r8.m28683wl() <= 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
        if (r8.m28683wl() > 0) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[Catch: all -> 0x0143, TryCatch #1 {all -> 0x0143, blocks: (B:9:0x0034, B:11:0x003b, B:13:0x0042, B:15:0x0049, B:18:0x0056, B:21:0x0065, B:23:0x0070, B:17:0x0053), top: B:84:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:55:0x00f1, B:56:0x00fd, B:58:0x0113, B:60:0x0117, B:61:0x012f, B:62:0x0136, B:35:0x00a3, B:40:0x00c5, B:42:0x00cc, B:46:0x00da, B:49:0x00e5), top: B:82:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fd A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m28636a(com.kwad.framework.filedownloader.p349b.InterfaceC9440a.InterfaceC9441a r26) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.C9470b.m28636a(com.kwad.framework.filedownloader.b.a$a):void");
    }
}
