package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.core.videocache.p413a.C10550b;
import com.kwad.sdk.utils.C11023ap;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.core.videocache.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10573g {
    private final C10561c aBZ;
    private final AtomicInteger aCd = new AtomicInteger(0);
    private volatile C10568e aCe;
    private final List<InterfaceC10558b> aCf;
    private final InterfaceC10558b aCg;
    private final String url;

    /* renamed from: com.kwad.sdk.core.videocache.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class HandlerC10574a extends Handler implements InterfaceC10558b {
        private final List<InterfaceC10558b> aCf;
        private final String url;

        public HandlerC10574a(String str, List<InterfaceC10558b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.aCf = list;
        }

        @Override // com.kwad.sdk.core.videocache.InterfaceC10558b
        /* renamed from: a */
        public final void mo25421a(File file, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            for (InterfaceC10558b interfaceC10558b : this.aCf) {
                interfaceC10558b.mo25421a((File) message.obj, message.arg1);
            }
        }
    }

    public C10573g(String str, C10561c c10561c) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.aCf = copyOnWriteArrayList;
        this.url = C11023ap.m24086gH(str);
        this.aBZ = (C10561c) C11023ap.checkNotNull(c10561c);
        this.aCg = new HandlerC10574a(str, copyOnWriteArrayList);
    }

    /* renamed from: Gt */
    private synchronized void m25426Gt() {
        if (this.aBZ.aBL == 1 && isOkHttpSupported()) {
            this.aCe = this.aCe == null ? m25423Gw() : this.aCe;
        } else {
            this.aCe = this.aCe == null ? m25424Gv() : this.aCe;
        }
    }

    /* renamed from: Gu */
    private synchronized void m25425Gu() {
        if (this.aCd.decrementAndGet() <= 0) {
            this.aCe.shutdown();
            this.aCe = null;
        }
    }

    /* renamed from: Gv */
    private C10568e m25424Gv() {
        String str = this.url;
        C10561c c10561c = this.aBZ;
        C10568e c10568e = new C10568e(new C10575h(str, c10561c.aBJ, c10561c.aBK), new C10550b(this.aBZ.m25470ex(this.url), this.aBZ.aBI));
        c10568e.m25458a(this.aCg);
        return c10568e;
    }

    /* renamed from: Gw */
    private C10568e m25423Gw() {
        String str = this.url;
        C10561c c10561c = this.aBZ;
        C10568e c10568e = new C10568e(new C10577j(str, c10561c.aBJ, c10561c.aBK), new C10550b(this.aBZ.m25470ex(this.url), this.aBZ.aBI));
        c10568e.m25458a(this.aCg);
        return c10568e;
    }

    private static boolean isOkHttpSupported() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: Gq */
    public final int m25427Gq() {
        return this.aCd.get();
    }

    /* renamed from: a */
    public final void m25422a(C10563d c10563d, Socket socket) {
        m25426Gt();
        try {
            this.aCd.incrementAndGet();
            this.aCe.m25456a(c10563d, socket);
        } finally {
            m25425Gu();
        }
    }

    public final void shutdown() {
        this.aCf.clear();
        C10568e c10568e = this.aCe;
        if (c10568e != null) {
            c10568e.m25458a((InterfaceC10558b) null);
            c10568e.shutdown();
        }
        this.aCe = null;
        this.aCd.set(0);
    }
}
