package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.s;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d implements a.c, x, x.a, x.b {
    private final Object aeg;
    private t aek;
    private final a ael;
    private volatile long aen;
    private final s.b aep;
    private final s.a aeq;
    private long aer;
    private long aes;
    private int aet;
    private boolean aeu;
    private boolean aev;
    private String aew;
    private volatile byte aem = 0;
    private Throwable aeo = null;
    private boolean aex = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void bb(String str);

        com.kwad.framework.filedownloader.d.b uq();

        a.InterfaceC0666a ur();

        ArrayList<Object> us();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Object obj) {
        this.aeg = obj;
        this.ael = aVar;
        b bVar = new b();
        this.aep = bVar;
        this.aeq = bVar;
        this.aek = new k(aVar.ur(), this);
    }

    private void e(MessageSnapshot messageSnapshot) {
        com.kwad.framework.filedownloader.a ud = this.ael.ur().ud();
        byte tV = messageSnapshot.tV();
        b(tV);
        this.aeu = messageSnapshot.ub();
        if (tV == -4) {
            this.aep.reset();
            int aZ = h.uB().aZ(ud.getId());
            if (aZ + ((aZ > 1 || !ud.tR()) ? 0 : h.uB().aZ(com.kwad.framework.filedownloader.f.f.A(ud.getUrl(), ud.getTargetFilePath()))) <= 1) {
                byte be = n.uM().be(ud.getId());
                com.kwad.framework.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(ud.getId()), Integer.valueOf(be));
                if (com.kwad.framework.filedownloader.d.d.bG(be)) {
                    b((byte) 1);
                    this.aes = messageSnapshot.wa();
                    long wc = messageSnapshot.wc();
                    this.aer = wc;
                    this.aep.start(wc);
                    this.aek.f(((MessageSnapshot.a) messageSnapshot).we());
                    return;
                }
            }
            h.uB().a(this.ael.ur(), messageSnapshot);
        } else if (tV == -3) {
            this.aex = messageSnapshot.wb();
            this.aer = messageSnapshot.wa();
            this.aes = messageSnapshot.wa();
            h.uB().a(this.ael.ur(), messageSnapshot);
        } else if (tV == -1) {
            this.aeo = messageSnapshot.wd();
            this.aer = messageSnapshot.wc();
            h.uB().a(this.ael.ur(), messageSnapshot);
        } else if (tV == 1) {
            this.aer = messageSnapshot.wc();
            this.aes = messageSnapshot.wa();
            this.aek.f(messageSnapshot);
        } else if (tV == 2) {
            this.aes = messageSnapshot.wa();
            this.aev = messageSnapshot.vQ();
            this.aew = messageSnapshot.getEtag();
            String fileName = messageSnapshot.getFileName();
            if (fileName != null) {
                if (ud.getFilename() != null) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", ud.getFilename(), fileName);
                }
                this.ael.bb(fileName);
            }
            this.aep.start(this.aer);
            this.aek.h(messageSnapshot);
        } else if (tV == 3) {
            this.aer = messageSnapshot.wc();
            this.aep.N(messageSnapshot.wc());
            this.aek.i(messageSnapshot);
        } else if (tV != 5) {
            if (tV != 6) {
                return;
            }
            this.aek.g(messageSnapshot);
        } else {
            this.aer = messageSnapshot.wc();
            this.aeo = messageSnapshot.wd();
            this.aet = messageSnapshot.tZ();
            this.aep.reset();
            this.aek.k(messageSnapshot);
        }
    }

    private int getId() {
        return this.ael.ur().ud().getId();
    }

    private void prepare() {
        File file;
        com.kwad.framework.filedownloader.a ud = this.ael.ur().ud();
        if (ud.getPath() == null) {
            ud.aZ(com.kwad.framework.filedownloader.f.f.br(ud.getUrl()));
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "save Path is null to %s", ud.getPath());
            }
        }
        if (ud.tR()) {
            file = new File(ud.getPath());
        } else {
            String bw = com.kwad.framework.filedownloader.f.f.bw(ud.getPath());
            if (bw != null) {
                file = new File(bw);
            } else {
                throw new InvalidParameterException(com.kwad.framework.filedownloader.f.f.b("the provided mPath[%s] is invalid, can't find its directory", ud.getPath()));
            }
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwad.framework.filedownloader.f.f.b("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.t(tV(), messageSnapshot.tV())) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.aem), Byte.valueOf(tV()), Integer.valueOf(getId()));
            }
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte tV = tV();
        byte tV2 = messageSnapshot.tV();
        if (-2 == tV && com.kwad.framework.filedownloader.d.d.bG(tV2)) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        } else if (!com.kwad.framework.filedownloader.d.d.u(tV, tV2)) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.aem), Byte.valueOf(tV()), Integer.valueOf(getId()));
            }
            return false;
        } else {
            e(messageSnapshot);
            return true;
        }
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.d.d.f(this.ael.ur().ud())) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (this.ael.ur().ud().tR() && messageSnapshot.tV() == -4 && tV() == 2) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void free() {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.aem));
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final MessageSnapshot g(Throwable th) {
        b((byte) -1);
        this.aeo = th;
        return com.kwad.framework.filedownloader.message.f.a(getId(), uv(), th);
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.aeq.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.aen;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getTotalBytes() {
        return this.aes;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void onBegin() {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(tV()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean pause() {
        if (com.kwad.framework.filedownloader.d.d.bF(tV())) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(tV()), Integer.valueOf(this.ael.ur().ud().getId()));
            }
            return false;
        }
        b((byte) -2);
        a.InterfaceC0666a ur = this.ael.ur();
        com.kwad.framework.filedownloader.a ud = ur.ud();
        q.uS().b(this);
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.uU();
        if (!r.uW()) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(ud.getId()));
            }
        } else {
            n.uM().bd(ud.getId());
        }
        h.uB().b(ur);
        h.uB().a(ur, com.kwad.framework.filedownloader.message.f.e(ud));
        r.uU().uY().e(ur);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void reset() {
        this.aeo = null;
        this.aew = null;
        this.aev = false;
        this.aet = 0;
        this.aex = false;
        this.aeu = false;
        this.aer = 0L;
        this.aes = 0L;
        this.aep.reset();
        if (com.kwad.framework.filedownloader.d.d.bF(this.aem)) {
            this.aek.uK();
            this.aek = new k(this.ael.ur(), this);
        } else {
            this.aek.b(this.ael.ur(), this);
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.x.b
    public final void start() {
        if (this.aem != 10) {
            com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.aem));
            return;
        }
        a.InterfaceC0666a ur = this.ael.ur();
        com.kwad.framework.filedownloader.a ud = ur.ud();
        v uY = r.uU().uY();
        try {
            if (uY.f(ur)) {
                return;
            }
            synchronized (this.aeg) {
                if (this.aem != 10) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.aem));
                    return;
                }
                b((byte) 11);
                h.uB().b(ur);
                if (com.kwad.framework.filedownloader.f.c.a(ud.getId(), ud.getTargetFilePath(), ud.tW(), true)) {
                    return;
                }
                boolean a4 = n.uM().a(ud.getUrl(), ud.getPath(), ud.tR(), ud.tP(), ud.tQ(), ud.tY(), ud.tW(), this.ael.uq(), ud.uc());
                if (this.aem == -2) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                    if (a4) {
                        n.uM().bd(getId());
                    }
                } else if (!a4) {
                    if (uY.f(ur)) {
                        return;
                    }
                    MessageSnapshot g4 = g(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (h.uB().a(ur)) {
                        uY.e(ur);
                        h.uB().b(ur);
                    }
                    h.uB().a(ur, g4);
                } else {
                    uY.e(ur);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.uB().a(ur, g(th));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final byte tV() {
        return this.aem;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final Throwable tX() {
        return this.aeo;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final int tZ() {
        return this.aet;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean ub() {
        return this.aeu;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void um() {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(tV()));
        }
        this.aep.end(this.aer);
        if (this.ael.us() != null) {
            ArrayList arrayList = (ArrayList) this.ael.us().clone();
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                arrayList.get(i4);
            }
        }
        r.uU().uY().e(this.ael.ur());
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final t ut() {
        return this.aek;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void uu() {
        boolean z3;
        synchronized (this.aeg) {
            if (this.aem != 0) {
                com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.aem));
                return;
            }
            b((byte) 10);
            a.InterfaceC0666a ur = this.ael.ur();
            com.kwad.framework.filedownloader.a ud = ur.ud();
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", ud.getUrl(), ud.getPath(), ud.tS(), ud.getTag());
            }
            try {
                prepare();
                z3 = true;
            } catch (Throwable th) {
                h.uB().b(ur);
                h.uB().a(ur, g(th));
                z3 = false;
            }
            if (z3) {
                q.uS().a(this);
            }
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long uv() {
        return this.aer;
    }

    private void b(byte b4) {
        this.aem = b4;
        this.aen = System.currentTimeMillis();
    }
}
