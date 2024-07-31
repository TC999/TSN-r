package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.download.C9476e;
import com.kwad.framework.filedownloader.download.ConnectTask;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.p348a.InterfaceC9432b;
import com.kwad.framework.filedownloader.p351d.C9462b;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.io.IOException;
import java.net.SocketException;

/* renamed from: com.kwad.framework.filedownloader.download.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RunnableC9472c implements Runnable {

    /* renamed from: VM */
    private final String f29479VM;
    private final int afG;
    private final ConnectTask agC;
    private final InterfaceC9478f agD;
    private C9476e agE;
    final int agF;
    private final boolean agd;

    /* renamed from: kH */
    private volatile boolean f29480kH;

    /* renamed from: com.kwad.framework.filedownloader.download.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9473a {

        /* renamed from: VM */
        private String f29481VM;
        private Boolean agA;
        private InterfaceC9478f agD;
        private final ConnectTask.C9467a agG = new ConnectTask.C9467a();
        private Integer agH;

        /* renamed from: a */
        public final C9473a m28620a(InterfaceC9478f interfaceC9478f) {
            this.agD = interfaceC9478f;
            return this;
        }

        /* renamed from: b */
        public final C9473a m28619b(C9469a c9469a) {
            this.agG.m28663a(c9469a);
            return this;
        }

        /* renamed from: bd */
        public final C9473a m28618bd(boolean z) {
            this.agA = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: bi */
        public final C9473a m28617bi(String str) {
            this.agG.m28662bf(str);
            return this;
        }

        /* renamed from: bj */
        public final C9473a m28616bj(String str) {
            this.agG.m28661bg(str);
            return this;
        }

        /* renamed from: bk */
        public final C9473a m28615bk(String str) {
            this.f29481VM = str;
            return this;
        }

        /* renamed from: bt */
        public final C9473a m28614bt(int i) {
            this.agG.m28660bs(i);
            return this;
        }

        /* renamed from: c */
        public final C9473a m28613c(C9462b c9462b) {
            this.agG.m28664a(c9462b);
            return this;
        }

        /* renamed from: d */
        public final C9473a m28612d(Integer num) {
            this.agH = num;
            return this;
        }

        /* renamed from: vF */
        public final RunnableC9472c m28611vF() {
            if (this.agD != null && this.f29481VM != null && this.agA != null && this.agH != null) {
                ConnectTask m28659vn = this.agG.m28659vn();
                return new RunnableC9472c(m28659vn.afG, this.agH.intValue(), m28659vn, this.agD, this.agA.booleanValue(), this.f29481VM, (byte) 0);
            }
            throw new IllegalArgumentException(C9501f.m28515b("%s %s %B", this.agD, this.f29481VM, this.agA));
        }
    }

    /* synthetic */ RunnableC9472c(int i, int i2, ConnectTask connectTask, InterfaceC9478f interfaceC9478f, boolean z, String str, byte b) {
        this(i, i2, connectTask, interfaceC9478f, z, str);
    }

    public final void pause() {
        this.f29480kH = true;
        C9476e c9476e = this.agE;
        if (c9476e != null) {
            c9476e.pause();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Exception e;
        Process.setThreadPriority(10);
        long j = this.agC.m28665vm().afP;
        InterfaceC9432b interfaceC9432b = null;
        boolean z2 = false;
        while (!this.f29480kH) {
            try {
                try {
                    interfaceC9432b = this.agC.m28668vj();
                    int responseCode = interfaceC9432b.getResponseCode();
                    if (C9498d.ail) {
                        C9498d.m28535c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.agF), Integer.valueOf(this.afG), this.agC.m28665vm(), Integer.valueOf(responseCode));
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new SocketException(C9501f.m28515b("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.agC.getRequestHeader(), interfaceC9432b.mo24748vd(), Integer.valueOf(responseCode), Integer.valueOf(this.afG), Integer.valueOf(this.agF)));
                        break;
                    }
                    try {
                        C9476e.C9477a c9477a = new C9476e.C9477a();
                        if (this.f29480kH) {
                            interfaceC9432b.mo24747ve();
                            return;
                        }
                        C9476e m28574vS = c9477a.m28577bw(this.afG).m28578bv(this.agF).m28581b(this.agD).m28582a(this).m28580bf(this.agd).m28575d(interfaceC9432b).m28576c(this.agC.m28665vm()).m28579bl(this.f29479VM).m28574vS();
                        this.agE = m28574vS;
                        m28574vS.run();
                        if (this.f29480kH) {
                            this.agE.pause();
                        }
                        interfaceC9432b.mo24747ve();
                        return;
                    } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e2) {
                        e = e2;
                        z = true;
                        try {
                            if (!this.agD.mo28572a(e)) {
                                this.agD.mo28570b(e);
                                if (interfaceC9432b != null) {
                                    interfaceC9432b.mo24747ve();
                                    return;
                                }
                                return;
                            }
                            if (!z) {
                                this.agD.mo28571a(e, 0L);
                            } else {
                                C9476e c9476e = this.agE;
                                if (c9476e != null) {
                                    this.agD.mo28571a(e, c9476e.afP - j);
                                } else {
                                    C9498d.m28534d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                    this.agD.mo28570b(e);
                                    if (interfaceC9432b != null) {
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (interfaceC9432b != null) {
                                interfaceC9432b.mo24747ve();
                            }
                            z2 = z;
                        } finally {
                            if (interfaceC9432b != null) {
                                interfaceC9432b.mo24747ve();
                            }
                        }
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e3) {
                    e = e3;
                    z = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e4) {
                z = z2;
                e = e4;
            }
        }
        if (interfaceC9432b != null) {
            interfaceC9432b.mo24747ve();
        }
    }

    /* renamed from: uK */
    public final void m28621uK() {
        pause();
    }

    private RunnableC9472c(int i, int i2, ConnectTask connectTask, InterfaceC9478f interfaceC9478f, boolean z, String str) {
        this.afG = i;
        this.agF = i2;
        this.f29480kH = false;
        this.agD = interfaceC9478f;
        this.f29479VM = str;
        this.agC = connectTask;
        this.agd = z;
    }
}
