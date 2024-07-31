package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.framework.filedownloader.InterfaceC9561s;
import com.kwad.framework.filedownloader.InterfaceC9580x;
import com.kwad.framework.filedownloader.message.C9535f;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.p351d.C9462b;
import com.kwad.framework.filedownloader.p351d.C9466d;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* renamed from: com.kwad.framework.filedownloader.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9459d implements InterfaceC9427a.InterfaceC9430c, InterfaceC9580x, InterfaceC9580x.InterfaceC9581a, InterfaceC9580x.InterfaceC9582b {
    private final Object aeg;
    private InterfaceC9576t aek;
    private final InterfaceC9460a ael;
    private volatile long aen;
    private final InterfaceC9561s.InterfaceC9563b aep;
    private final InterfaceC9561s.InterfaceC9562a aeq;
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
    /* renamed from: com.kwad.framework.filedownloader.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9460a {
        /* renamed from: bb */
        void mo28710bb(String str);

        /* renamed from: uq */
        C9462b mo28708uq();

        /* renamed from: ur */
        InterfaceC9427a.InterfaceC9428a mo28707ur();

        /* renamed from: us */
        ArrayList<Object> mo28706us();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9459d(InterfaceC9460a interfaceC9460a, Object obj) {
        this.aeg = obj;
        this.ael = interfaceC9460a;
        C9439b c9439b = new C9439b();
        this.aep = c9439b;
        this.aeq = c9439b;
        this.aek = new C9510k(interfaceC9460a.mo28707ur(), this);
    }

    /* renamed from: e */
    private void m28714e(MessageSnapshot messageSnapshot) {
        InterfaceC9427a mo28731ud = this.ael.mo28707ur().mo28731ud();
        byte mo28442tV = messageSnapshot.mo28442tV();
        m28715b(mo28442tV);
        this.aeu = messageSnapshot.m28469ub();
        if (mo28442tV == -4) {
            this.aep.reset();
            int m28491aZ = C9503h.m28485uB().m28491aZ(mo28731ud.getId());
            if (m28491aZ + ((m28491aZ > 1 || !mo28731ud.mo28743tR()) ? 0 : C9503h.m28485uB().m28491aZ(C9501f.m28528A(mo28731ud.getUrl(), mo28731ud.getTargetFilePath()))) <= 1) {
                byte mo28336be = C9550n.m28440uM().mo28336be(mo28731ud.getId());
                C9498d.m28534d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(mo28731ud.getId()), Integer.valueOf(mo28336be));
                if (C9466d.m28675bG(mo28336be)) {
                    m28715b((byte) 1);
                    this.aes = messageSnapshot.mo28450wa();
                    long mo28449wc = messageSnapshot.mo28449wc();
                    this.aer = mo28449wc;
                    this.aep.start(mo28449wc);
                    this.aek.mo28353f(((MessageSnapshot.InterfaceC9515a) messageSnapshot).mo28441we());
                    return;
                }
            }
            C9503h.m28485uB().m28492a(this.ael.mo28707ur(), messageSnapshot);
        } else if (mo28442tV == -3) {
            this.aex = messageSnapshot.mo28448wb();
            this.aer = messageSnapshot.mo28450wa();
            this.aes = messageSnapshot.mo28450wa();
            C9503h.m28485uB().m28492a(this.ael.mo28707ur(), messageSnapshot);
        } else if (mo28442tV == -1) {
            this.aeo = messageSnapshot.mo28446wd();
            this.aer = messageSnapshot.mo28449wc();
            C9503h.m28485uB().m28492a(this.ael.mo28707ur(), messageSnapshot);
        } else if (mo28442tV == 1) {
            this.aer = messageSnapshot.mo28449wc();
            this.aes = messageSnapshot.mo28450wa();
            this.aek.mo28353f(messageSnapshot);
        } else if (mo28442tV == 2) {
            this.aes = messageSnapshot.mo28450wa();
            this.aev = messageSnapshot.mo28447vQ();
            this.aew = messageSnapshot.getEtag();
            String fileName = messageSnapshot.getFileName();
            if (fileName != null) {
                if (mo28731ud.getFilename() != null) {
                    C9498d.m28534d(this, "already has mFilename[%s], but assign mFilename[%s] again", mo28731ud.getFilename(), fileName);
                }
                this.ael.mo28710bb(fileName);
            }
            this.aep.start(this.aer);
            this.aek.mo28351h(messageSnapshot);
        } else if (mo28442tV == 3) {
            this.aer = messageSnapshot.mo28449wc();
            this.aep.mo28413N(messageSnapshot.mo28449wc());
            this.aek.mo28350i(messageSnapshot);
        } else if (mo28442tV != 5) {
            if (mo28442tV != 6) {
                return;
            }
            this.aek.mo28352g(messageSnapshot);
        } else {
            this.aer = messageSnapshot.mo28449wc();
            this.aeo = messageSnapshot.mo28446wd();
            this.aet = messageSnapshot.mo28443tZ();
            this.aep.reset();
            this.aek.mo28348k(messageSnapshot);
        }
    }

    private int getId() {
        return this.ael.mo28707ur().mo28731ud().getId();
    }

    private void prepare() {
        File file;
        InterfaceC9427a mo28731ud = this.ael.mo28707ur().mo28731ud();
        if (mo28731ud.getPath() == null) {
            mo28731ud.mo28756aZ(C9501f.m28510br(mo28731ud.getUrl()));
            if (C9498d.ail) {
                C9498d.m28535c(this, "save Path is null to %s", mo28731ud.getPath());
            }
        }
        if (mo28731ud.mo28743tR()) {
            file = new File(mo28731ud.getPath());
        } else {
            String m28505bw = C9501f.m28505bw(mo28731ud.getPath());
            if (m28505bw != null) {
                file = new File(m28505bw);
            } else {
                throw new InvalidParameterException(C9501f.m28515b("the provided mPath[%s] is invalid, can't find its directory", mo28731ud.getPath()));
            }
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(C9501f.m28515b("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x.InterfaceC9581a
    /* renamed from: a */
    public final boolean mo28324a(MessageSnapshot messageSnapshot) {
        if (!C9466d.m28673t(mo28330tV(), messageSnapshot.mo28442tV())) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.aem), Byte.valueOf(mo28330tV()), Integer.valueOf(getId()));
            }
            return false;
        }
        m28714e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x.InterfaceC9581a
    /* renamed from: b */
    public final boolean mo28323b(MessageSnapshot messageSnapshot) {
        byte mo28330tV = mo28330tV();
        byte mo28442tV = messageSnapshot.mo28442tV();
        if (-2 == mo28330tV && C9466d.m28675bG(mo28442tV)) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        } else if (!C9466d.m28672u(mo28330tV, mo28442tV)) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.aem), Byte.valueOf(mo28330tV()), Integer.valueOf(getId()));
            }
            return false;
        } else {
            m28714e(messageSnapshot);
            return true;
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x.InterfaceC9581a
    /* renamed from: c */
    public final boolean mo28322c(MessageSnapshot messageSnapshot) {
        if (C9466d.m28674f(this.ael.mo28707ur().mo28731ud())) {
            m28714e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x.InterfaceC9581a
    /* renamed from: d */
    public final boolean mo28321d(MessageSnapshot messageSnapshot) {
        if (this.ael.mo28707ur().mo28731ud().mo28743tR() && messageSnapshot.mo28442tV() == -4 && mo28330tV() == 2) {
            m28714e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    public final void free() {
        if (C9498d.ail) {
            C9498d.m28535c(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.aem));
        }
        m28715b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x.InterfaceC9581a
    /* renamed from: g */
    public final MessageSnapshot mo28320g(Throwable th) {
        m28715b((byte) -1);
        this.aeo = th;
        return C9535f.m28459a(getId(), mo28325uv(), th);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9561s.InterfaceC9562a
    public final int getSpeed() {
        return this.aeq.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    public final long getStatusUpdateTime() {
        return this.aen;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    public final long getTotalBytes() {
        return this.aes;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9430c
    public final void onBegin() {
        if (C9498d.ail) {
            C9498d.m28533e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(mo28330tV()));
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    public final boolean pause() {
        if (C9466d.m28676bF(mo28330tV())) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(mo28330tV()), Integer.valueOf(this.ael.mo28707ur().mo28731ud().getId()));
            }
            return false;
        }
        m28715b((byte) -2);
        InterfaceC9427a.InterfaceC9428a mo28707ur = this.ael.mo28707ur();
        InterfaceC9427a mo28731ud = mo28707ur.mo28731ud();
        C9555q.m28429uS().m28430b(this);
        if (C9498d.ail) {
            C9498d.m28533e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        C9559r.m28419uU();
        if (!C9559r.m28417uW()) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(mo28731ud.getId()));
            }
        } else {
            C9550n.m28440uM().mo28337bd(mo28731ud.getId());
        }
        C9503h.m28485uB().m28490b(mo28707ur);
        C9503h.m28485uB().m28492a(mo28707ur, C9535f.m28457e(mo28731ud));
        C9559r.m28419uU().m28415uY().mo28315e(mo28707ur);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
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
        if (C9466d.m28676bF(this.aem)) {
            this.aek.mo28340uK();
            this.aek = new C9510k(this.ael.mo28707ur(), this);
        } else {
            this.aek.mo28354b(this.ael.mo28707ur(), this);
        }
        m28715b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x.InterfaceC9582b
    public final void start() {
        if (this.aem != 10) {
            C9498d.m28534d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.aem));
            return;
        }
        InterfaceC9427a.InterfaceC9428a mo28707ur = this.ael.mo28707ur();
        InterfaceC9427a mo28731ud = mo28707ur.mo28731ud();
        InterfaceC9578v m28415uY = C9559r.m28419uU().m28415uY();
        try {
            if (m28415uY.mo28314f(mo28707ur)) {
                return;
            }
            synchronized (this.aeg) {
                if (this.aem != 10) {
                    C9498d.m28534d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.aem));
                    return;
                }
                m28715b((byte) 11);
                C9503h.m28485uB().m28490b(mo28707ur);
                if (C9492c.m28546a(mo28731ud.getId(), mo28731ud.getTargetFilePath(), mo28731ud.mo28738tW(), true)) {
                    return;
                }
                boolean mo28339a = C9550n.m28440uM().mo28339a(mo28731ud.getUrl(), mo28731ud.getPath(), mo28731ud.mo28743tR(), mo28731ud.mo28745tP(), mo28731ud.mo28744tQ(), mo28731ud.mo28736tY(), mo28731ud.mo28738tW(), this.ael.mo28708uq(), mo28731ud.mo28732uc());
                if (this.aem == -2) {
                    C9498d.m28534d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                    if (mo28339a) {
                        C9550n.m28440uM().mo28337bd(getId());
                    }
                } else if (!mo28339a) {
                    if (m28415uY.mo28314f(mo28707ur)) {
                        return;
                    }
                    MessageSnapshot mo28320g = mo28320g(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (C9503h.m28485uB().m28493a(mo28707ur)) {
                        m28415uY.mo28315e(mo28707ur);
                        C9503h.m28485uB().m28490b(mo28707ur);
                    }
                    C9503h.m28485uB().m28492a(mo28707ur, mo28320g);
                } else {
                    m28415uY.mo28315e(mo28707ur);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C9503h.m28485uB().m28492a(mo28707ur, mo28320g(th));
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    /* renamed from: tV */
    public final byte mo28330tV() {
        return this.aem;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    /* renamed from: tX */
    public final Throwable mo28329tX() {
        return this.aeo;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    /* renamed from: tZ */
    public final int mo28328tZ() {
        return this.aet;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    /* renamed from: ub */
    public final boolean mo28327ub() {
        return this.aeu;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9430c
    /* renamed from: um */
    public final void mo28713um() {
        if (C9498d.ail) {
            C9498d.m28533e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(mo28330tV()));
        }
        this.aep.end(this.aer);
        if (this.ael.mo28706us() != null) {
            ArrayList arrayList = (ArrayList) this.ael.mo28706us().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
        }
        C9559r.m28419uU().m28415uY().mo28315e(this.ael.mo28707ur());
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x.InterfaceC9581a
    /* renamed from: ut */
    public final InterfaceC9576t mo28319ut() {
        return this.aek;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    /* renamed from: uu */
    public final void mo28326uu() {
        boolean z;
        synchronized (this.aeg) {
            if (this.aem != 0) {
                C9498d.m28534d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.aem));
                return;
            }
            m28715b((byte) 10);
            InterfaceC9427a.InterfaceC9428a mo28707ur = this.ael.mo28707ur();
            InterfaceC9427a mo28731ud = mo28707ur.mo28731ud();
            if (C9498d.ail) {
                C9498d.m28533e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", mo28731ud.getUrl(), mo28731ud.getPath(), mo28731ud.mo28742tS(), mo28731ud.getTag());
            }
            try {
                prepare();
                z = true;
            } catch (Throwable th) {
                C9503h.m28485uB().m28490b(mo28707ur);
                C9503h.m28485uB().m28492a(mo28707ur, mo28320g(th));
                z = false;
            }
            if (z) {
                C9555q.m28429uS().m28431a(this);
            }
            if (C9498d.ail) {
                C9498d.m28533e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9580x
    /* renamed from: uv */
    public final long mo28325uv() {
        return this.aer;
    }

    /* renamed from: b */
    private void m28715b(byte b) {
        this.aem = b;
        this.aen = System.currentTimeMillis();
    }
}
