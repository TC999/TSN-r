package com.kwad.framework.filedownloader;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.C9459d;
import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.framework.filedownloader.InterfaceC9580x;
import com.kwad.framework.filedownloader.p351d.C9462b;
import com.kwad.framework.filedownloader.p351d.C9466d;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.kwad.framework.filedownloader.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9451c implements InterfaceC9427a, InterfaceC9427a.InterfaceC9428a, C9459d.InterfaceC9460a {
    private final InterfaceC9580x adO;
    private final InterfaceC9580x.InterfaceC9581a adP;
    private int adQ;
    private ArrayList<Object> adR;
    private String adS;
    private String adT;
    private boolean adU;
    private C9462b adV;
    private AbstractC9505i adW;
    private Object adX;
    private final Object aeg;
    private final String mUrl;
    private int adY = 0;
    private boolean adZ = false;
    private boolean aea = false;
    private int aeb = 100;
    private int aec = 10;
    private boolean aed = false;
    volatile int aee = 0;
    private boolean aef = false;
    private final Object aeh = new Object();
    private volatile boolean aei = false;

    /* renamed from: com.kwad.framework.filedownloader.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C9452a implements InterfaceC9427a.InterfaceC9429b {
        private final C9451c aej;

        /* synthetic */ C9452a(C9451c c9451c, byte b) {
            this(c9451c);
        }

        @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9429b
        /* renamed from: ul */
        public final int mo28720ul() {
            int id = this.aej.getId();
            if (C9498d.ail) {
                C9498d.m28535c(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            C9503h.m28485uB().m28487c(this.aej);
            return id;
        }

        private C9452a(C9451c c9451c) {
            this.aej = c9451c;
            C9451c.m28760a(c9451c, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9451c(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.aeg = obj;
        C9459d c9459d = new C9459d(this, obj);
        this.adO = c9459d;
        this.adP = c9459d;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m28760a(C9451c c9451c, boolean z) {
        c9451c.aef = true;
        return true;
    }

    /* renamed from: un */
    private boolean m28723un() {
        return this.adO.mo28330tV() != 0;
    }

    /* renamed from: uo */
    private int m28722uo() {
        if (m28723un()) {
            if (isRunning()) {
                throw new IllegalStateException(C9501f.m28515b("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.adO.toString());
        }
        if (!mo28746tO()) {
            mo28728ug();
        }
        this.adO.mo28326uu();
        return getId();
    }

    /* renamed from: up */
    private void m28721up() {
        if (this.adV == null) {
            synchronized (this.aeh) {
                if (this.adV == null) {
                    this.adV = new C9462b();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: aX */
    public final InterfaceC9427a mo28758aX(int i) {
        this.adY = 3;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    /* renamed from: aY */
    public final boolean mo28757aY(int i) {
        return getId() == i;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: aZ */
    public final InterfaceC9427a mo28756aZ(String str) {
        return mo28751c(str, false);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: ba */
    public final InterfaceC9427a mo28754ba(boolean z) {
        this.aed = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: bb */
    public final InterfaceC9427a mo28753bb(boolean z) {
        this.adZ = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: bc */
    public final InterfaceC9427a mo28752bc(boolean z) {
        this.aea = z;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: c */
    public final InterfaceC9427a mo28751c(String str, boolean z) {
        this.adS = str;
        if (C9498d.ail) {
            C9498d.m28535c(this, "setPath %s", str);
        }
        this.adU = z;
        if (z) {
            this.adT = null;
        } else {
            this.adT = new File(str).getName();
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: e */
    public final InterfaceC9427a mo28750e(Object obj) {
        this.adX = obj;
        if (C9498d.ail) {
            C9498d.m28535c(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    public final void free() {
        this.adO.free();
        if (C9503h.m28485uB().m28493a(this)) {
            this.aei = false;
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final String getFilename() {
        return this.adT;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final int getId() {
        int i = this.adQ;
        if (i != 0) {
            return i;
        }
        if (TextUtils.isEmpty(this.adS) || TextUtils.isEmpty(this.mUrl)) {
            return 0;
        }
        int m28501g = C9501f.m28501g(this.mUrl, this.adS, this.adU);
        this.adQ = m28501g;
        return m28501g;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final String getPath() {
        return this.adS;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final int getSmallFileSoFarBytes() {
        if (this.adO.mo28325uv() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.adO.mo28325uv();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final int getSmallFileTotalBytes() {
        if (this.adO.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.adO.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final int getSpeed() {
        return this.adO.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final long getStatusUpdateTime() {
        return this.adO.getStatusUpdateTime();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final Object getTag() {
        return this.adX;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final String getTargetFilePath() {
        return C9501f.m28521a(getPath(), mo28743tR(), getFilename());
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    public final boolean isOver() {
        return C9466d.m28676bF(mo28739tV());
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final boolean isRunning() {
        if (C9559r.m28419uU().m28415uY().mo28316d(this)) {
            return true;
        }
        return C9466d.m28675bG(mo28739tV());
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final boolean pause() {
        boolean pause;
        synchronized (this.aeg) {
            pause = this.adO.pause();
        }
        return pause;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    public final int start() {
        if (!this.aef) {
            return m28722uo();
        }
        throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: t */
    public final InterfaceC9427a mo28749t(String str, String str2) {
        m28721up();
        this.adV.m28700x(str, str2);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tM */
    public final InterfaceC9427a.InterfaceC9429b mo28748tM() {
        return new C9452a(this, (byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tN */
    public final boolean mo28747tN() {
        if (isRunning()) {
            C9498d.m28534d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.aee = 0;
        this.aef = false;
        this.aei = false;
        this.adO.reset();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tO */
    public final boolean mo28746tO() {
        return this.aee != 0;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tP */
    public final int mo28745tP() {
        return this.aeb;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tQ */
    public final int mo28744tQ() {
        return this.aec;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tR */
    public final boolean mo28743tR() {
        return this.adU;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tS */
    public final AbstractC9505i mo28742tS() {
        return this.adW;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tT */
    public final long mo28741tT() {
        return this.adO.mo28325uv();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tU */
    public final long mo28740tU() {
        return this.adO.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tV */
    public final byte mo28739tV() {
        return this.adO.mo28330tV();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tW */
    public final boolean mo28738tW() {
        return this.aed;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tX */
    public final Throwable mo28737tX() {
        return this.adO.mo28329tX();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tY */
    public final int mo28736tY() {
        return this.adY;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: tZ */
    public final int mo28735tZ() {
        return this.adO.mo28328tZ();
    }

    public final String toString() {
        return C9501f.m28515b("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: ua */
    public final boolean mo28734ua() {
        return this.adZ;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: ub */
    public final boolean mo28733ub() {
        return this.adO.mo28327ub();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: uc */
    public final boolean mo28732uc() {
        return this.aea;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    /* renamed from: ud */
    public final InterfaceC9427a mo28731ud() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    /* renamed from: ue */
    public final InterfaceC9580x.InterfaceC9581a mo28730ue() {
        return this.adP;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    /* renamed from: uf */
    public final int mo28729uf() {
        return this.aee;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    /* renamed from: ug */
    public final void mo28728ug() {
        int hashCode;
        if (mo28742tS() != null) {
            hashCode = mo28742tS().hashCode();
        } else {
            hashCode = hashCode();
        }
        this.aee = hashCode;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    /* renamed from: uh */
    public final boolean mo28727uh() {
        return this.aei;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    /* renamed from: ui */
    public final void mo28726ui() {
        this.aei = true;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    /* renamed from: uj */
    public final void mo28725uj() {
        m28722uo();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a.InterfaceC9428a
    /* renamed from: uk */
    public final boolean mo28724uk() {
        ArrayList<Object> arrayList = this.adR;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.kwad.framework.filedownloader.C9459d.InterfaceC9460a
    /* renamed from: uq */
    public final C9462b mo28708uq() {
        return this.adV;
    }

    @Override // com.kwad.framework.filedownloader.C9459d.InterfaceC9460a
    /* renamed from: ur */
    public final InterfaceC9427a.InterfaceC9428a mo28707ur() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.C9459d.InterfaceC9460a
    /* renamed from: us */
    public final ArrayList<Object> mo28706us() {
        return this.adR;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: a */
    public final InterfaceC9427a mo28759a(AbstractC9505i abstractC9505i) {
        this.adW = abstractC9505i;
        if (C9498d.ail) {
            C9498d.m28535c(this, "setListener %s", abstractC9505i);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9427a
    /* renamed from: ba */
    public final InterfaceC9427a mo28755ba(String str) {
        if (this.adV == null) {
            synchronized (this.aeh) {
                if (this.adV == null) {
                    return this;
                }
            }
        }
        this.adV.m28702bm(str);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.C9459d.InterfaceC9460a
    /* renamed from: bb */
    public final void mo28710bb(String str) {
        this.adT = str;
    }
}
