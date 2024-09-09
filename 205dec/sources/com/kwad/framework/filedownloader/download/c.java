package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.download.ConnectTask;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements Runnable {
    private final String VM;
    private final int afG;
    private final ConnectTask agC;
    private final f agD;
    private e agE;
    final int agF;
    private final boolean agd;
    private volatile boolean kH;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private String VM;
        private Boolean agA;
        private f agD;
        private final ConnectTask.a agG = new ConnectTask.a();
        private Integer agH;

        public final a a(f fVar) {
            this.agD = fVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.agG.a(aVar);
            return this;
        }

        public final a bd(boolean z3) {
            this.agA = Boolean.valueOf(z3);
            return this;
        }

        public final a bi(String str) {
            this.agG.bf(str);
            return this;
        }

        public final a bj(String str) {
            this.agG.bg(str);
            return this;
        }

        public final a bk(String str) {
            this.VM = str;
            return this;
        }

        public final a bt(int i4) {
            this.agG.bs(i4);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.agG.a(bVar);
            return this;
        }

        public final a d(Integer num) {
            this.agH = num;
            return this;
        }

        public final c vF() {
            if (this.agD != null && this.VM != null && this.agA != null && this.agH != null) {
                ConnectTask vn = this.agG.vn();
                return new c(vn.afG, this.agH.intValue(), vn, this.agD, this.agA.booleanValue(), this.VM, (byte) 0);
            }
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("%s %s %B", this.agD, this.VM, this.agA));
        }
    }

    /* synthetic */ c(int i4, int i5, ConnectTask connectTask, f fVar, boolean z3, String str, byte b4) {
        this(i4, i5, connectTask, fVar, z3, str);
    }

    public final void pause() {
        this.kH = true;
        e eVar = this.agE;
        if (eVar != null) {
            eVar.pause();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        Exception e4;
        Process.setThreadPriority(10);
        long j4 = this.agC.vm().afP;
        com.kwad.framework.filedownloader.a.b bVar = null;
        boolean z4 = false;
        while (!this.kH) {
            try {
                try {
                    bVar = this.agC.vj();
                    int responseCode = bVar.getResponseCode();
                    if (com.kwad.framework.filedownloader.f.d.ail) {
                        com.kwad.framework.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.agF), Integer.valueOf(this.afG), this.agC.vm(), Integer.valueOf(responseCode));
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new SocketException(com.kwad.framework.filedownloader.f.f.b("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.agC.getRequestHeader(), bVar.vd(), Integer.valueOf(responseCode), Integer.valueOf(this.afG), Integer.valueOf(this.agF)));
                        break;
                    }
                    try {
                        e.a aVar = new e.a();
                        if (this.kH) {
                            bVar.ve();
                            return;
                        }
                        e vS = aVar.bw(this.afG).bv(this.agF).b(this.agD).a(this).bf(this.agd).d(bVar).c(this.agC.vm()).bl(this.VM).vS();
                        this.agE = vS;
                        vS.run();
                        if (this.kH) {
                            this.agE.pause();
                        }
                        bVar.ve();
                        return;
                    } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e5) {
                        e4 = e5;
                        z3 = true;
                        try {
                            if (!this.agD.a(e4)) {
                                this.agD.b(e4);
                                if (bVar != null) {
                                    bVar.ve();
                                    return;
                                }
                                return;
                            }
                            if (!z3) {
                                this.agD.a(e4, 0L);
                            } else {
                                e eVar = this.agE;
                                if (eVar != null) {
                                    this.agD.a(e4, eVar.afP - j4);
                                } else {
                                    com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e4);
                                    this.agD.b(e4);
                                    if (bVar != null) {
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (bVar != null) {
                                bVar.ve();
                            }
                            z4 = z3;
                        } finally {
                            if (bVar != null) {
                                bVar.ve();
                            }
                        }
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e6) {
                    e4 = e6;
                    z3 = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e7) {
                z3 = z4;
                e4 = e7;
            }
        }
        if (bVar != null) {
            bVar.ve();
        }
    }

    public final void uK() {
        pause();
    }

    private c(int i4, int i5, ConnectTask connectTask, f fVar, boolean z3, String str) {
        this.afG = i4;
        this.agF = i5;
        this.kH = false;
        this.agD = fVar;
        this.VM = str;
        this.agC = connectTask;
        this.agd = z3;
    }
}
