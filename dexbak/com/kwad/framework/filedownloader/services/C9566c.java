package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.p348a.C9431a;
import com.kwad.framework.filedownloader.p348a.C9433c;
import com.kwad.framework.filedownloader.p349b.C9445c;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p352e.C9481b;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9499e;
import com.kwad.framework.filedownloader.p353f.C9501f;

/* renamed from: com.kwad.framework.filedownloader.services.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9566c {
    private final C9568b ahP;

    /* renamed from: com.kwad.framework.filedownloader.services.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9567a {
        /* renamed from: vu */
        C9492c.InterfaceC9494b mo27783vu();
    }

    /* renamed from: com.kwad.framework.filedownloader.services.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9568b {
        C9492c.InterfaceC9495c ahQ;
        Integer ahR;
        C9492c.InterfaceC9497e ahS;
        C9492c.InterfaceC9494b ahT;
        InterfaceC9567a ahU;
        C9492c.InterfaceC9493a ahV;
        C9492c.InterfaceC9496d ahW;

        /* renamed from: a */
        public final C9568b m28393a(C9492c.InterfaceC9494b interfaceC9494b) {
            this.ahT = interfaceC9494b;
            return this;
        }

        /* renamed from: bH */
        public final C9568b m28391bH(int i) {
            this.ahR = Integer.MAX_VALUE;
            return this;
        }

        public final String toString() {
            return C9501f.m28515b("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.ahQ, this.ahR, this.ahS, this.ahT, this.ahV);
        }

        /* renamed from: a */
        public final C9568b m28392a(InterfaceC9567a interfaceC9567a) {
            this.ahU = interfaceC9567a;
            return this;
        }
    }

    public C9566c() {
        this.ahP = null;
    }

    /* renamed from: wA */
    private static C9492c.InterfaceC9493a m28403wA() {
        return new C9431a();
    }

    /* renamed from: ww */
    private static C9492c.InterfaceC9496d m28397ww() {
        return new C9565b();
    }

    /* renamed from: wx */
    private static int m28396wx() {
        return C9499e.m28530wN().aiq;
    }

    /* renamed from: wy */
    private static C9492c.InterfaceC9497e m28395wy() {
        return new C9481b.C9482a();
    }

    /* renamed from: wz */
    private static C9492c.InterfaceC9494b m28394wz() {
        return new C9433c.C9435b();
    }

    /* renamed from: vr */
    public final int m28404vr() {
        C9568b c9568b = this.ahP;
        if (c9568b == null) {
            return m28396wx();
        }
        Integer num = c9568b.ahR;
        if (num != null) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return C9499e.m28531bL(num.intValue());
        }
        return m28396wx();
    }

    /* renamed from: wr */
    public final InterfaceC9440a m28402wr() {
        C9492c.InterfaceC9495c interfaceC9495c;
        C9568b c9568b = this.ahP;
        if (c9568b != null && (interfaceC9495c = c9568b.ahQ) != null) {
            InterfaceC9440a m28542wM = interfaceC9495c.m28542wM();
            return m28542wM != null ? m28542wM : new C9445c();
        }
        return new C9445c();
    }

    /* renamed from: ws */
    public final C9492c.InterfaceC9497e m28401ws() {
        C9568b c9568b = this.ahP;
        if (c9568b == null) {
            return m28395wy();
        }
        C9492c.InterfaceC9497e interfaceC9497e = c9568b.ahS;
        if (interfaceC9497e != null) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "initial FileDownloader manager with the customize output stream: %s", interfaceC9497e);
            }
            return interfaceC9497e;
        }
        return m28395wy();
    }

    /* renamed from: wt */
    public final C9492c.InterfaceC9494b m28400wt() {
        C9492c.InterfaceC9494b mo27783vu;
        C9568b c9568b = this.ahP;
        if (c9568b == null) {
            return m28394wz();
        }
        InterfaceC9567a interfaceC9567a = c9568b.ahU;
        return (interfaceC9567a == null || (mo27783vu = interfaceC9567a.mo27783vu()) == null) ? m28394wz() : mo27783vu;
    }

    /* renamed from: wu */
    public final C9492c.InterfaceC9493a m28399wu() {
        C9568b c9568b = this.ahP;
        if (c9568b == null) {
            return m28403wA();
        }
        C9492c.InterfaceC9493a interfaceC9493a = c9568b.ahV;
        if (interfaceC9493a != null) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "initial FileDownloader manager with the customize connection count adapter: %s", interfaceC9493a);
            }
            return interfaceC9493a;
        }
        return m28403wA();
    }

    /* renamed from: wv */
    public final C9492c.InterfaceC9496d m28398wv() {
        C9568b c9568b = this.ahP;
        if (c9568b == null) {
            return m28397ww();
        }
        C9492c.InterfaceC9496d interfaceC9496d = c9568b.ahW;
        if (interfaceC9496d != null) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "initial FileDownloader manager with the customize id generator: %s", interfaceC9496d);
            }
            return interfaceC9496d;
        }
        return m28397ww();
    }

    public C9566c(C9568b c9568b) {
        this.ahP = c9568b;
    }
}
