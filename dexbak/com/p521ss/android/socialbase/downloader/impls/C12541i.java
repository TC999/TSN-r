package com.p521ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12471sg;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12515s;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import com.p521ss.android.socialbase.downloader.p557s.C12723ok;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.impls.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12541i implements InterfaceC12522z {

    /* renamed from: a */
    private final InterfaceC12501k f35213a;

    /* renamed from: bl */
    private final InterfaceC12517t f35214bl;

    /* renamed from: ok */
    private final AbstractC12547ok f35215ok;

    /* renamed from: s */
    private final boolean f35216s;

    public C12541i() {
        this(false);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public boolean mo17471a(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            return abstractC12547ok.m17537rh(i);
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public void mo17461bl(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17562kf(i);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: h */
    public boolean mo17456h(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            return abstractC12547ok.mo17558ok(i);
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: i */
    public boolean mo17455i(int i) {
        return this.f35213a.mo17502kf(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: j */
    public boolean mo17454j(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            return abstractC12547ok.m17538r(i);
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: k */
    public void mo17453k(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17533z(i);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: kf */
    public int mo17451kf(int i) {
        DownloadInfo m17536s;
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok == null || (m17536s = abstractC12547ok.m17536s(i)) == null) {
            return 0;
        }
        return m17536s.getStatus();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: n */
    public long mo17449n(int i) {
        DownloadInfo mo17520a;
        InterfaceC12501k interfaceC12501k = this.f35213a;
        if (interfaceC12501k == null || (mo17520a = interfaceC12501k.mo17520a(i)) == null) {
            return 0L;
        }
        int chunkCount = mo17520a.getChunkCount();
        if (chunkCount <= 1) {
            return mo17520a.getCurBytes();
        }
        List<C12598a> mo17512bl = this.f35213a.mo17512bl(i);
        if (mo17512bl == null || mo17512bl.size() != chunkCount) {
            return 0L;
        }
        return C12713kf.m16607a(mo17512bl);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17446ok(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17561n(i);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: p */
    public DownloadInfo mo17424p(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            return abstractC12547ok.m17536s(i);
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: q */
    public List<C12598a> mo17423q(int i) {
        return this.f35213a.mo17512bl(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: r */
    public void mo17422r(int i) {
        C12409ok.m17898ok(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: rh */
    public boolean mo17421rh(int i) {
        return this.f35213a.mo17500n(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: s */
    public void mo17419s(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17566h(i);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    public void startService() {
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: t */
    public void mo17417t(int i) {
        this.f35213a.mo17478s(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: td */
    public InterfaceC12480v mo17416td(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        InterfaceC12480v m17540p = abstractC12547ok != null ? abstractC12547ok.m17540p(i) : null;
        return m17540p == null ? C12490bl.m17759sg() : m17540p;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: x */
    public InterfaceC12427ep mo17415x(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            return abstractC12547ok.m17539q(i);
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: z */
    public int mo17414z(int i) {
        return C12515s.m17660ok().m17659ok(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: zz */
    public IDownloadFileUriProvider mo17413zz(int i) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            return abstractC12547ok.m17563k(i);
        }
        return null;
    }

    public C12541i(boolean z) {
        this.f35215ok = C12490bl.m17820fb();
        this.f35213a = C12490bl.m17806m();
        if (!z) {
            this.f35214bl = C12490bl.m17822ep();
        } else {
            this.f35214bl = C12490bl.m17751vz();
        }
        this.f35216s = C12534ok.m17605bl().m17606a("service_alive", false);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public List<DownloadInfo> mo17465a(String str) {
        InterfaceC12501k interfaceC12501k = this.f35213a;
        if (interfaceC12501k != null) {
            return interfaceC12501k.mo17514a(str);
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public List<DownloadInfo> mo17458bl(String str) {
        InterfaceC12501k interfaceC12501k = this.f35213a;
        if (interfaceC12501k != null) {
            return interfaceC12501k.mo17509bl(str);
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: h */
    public boolean mo17457h() {
        InterfaceC12517t interfaceC12517t;
        return this.f35216s && (interfaceC12517t = this.f35214bl) != null && interfaceC12517t.mo17632ok();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17435ok(int i, boolean z) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17549ok(i, z);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: s */
    public List<DownloadInfo> mo17420s() {
        InterfaceC12501k interfaceC12501k = this.f35213a;
        if (interfaceC12501k != null) {
            return interfaceC12501k.mo17521a();
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: kf */
    public void mo17452kf() {
        this.f35213a.mo17513bl();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17463a(List<String> list) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17570a(list);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public boolean mo17462bl() {
        return C12490bl.m17750wv();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17447ok() {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17579a();
        }
    }

    /* renamed from: s */
    public void m17584s(int i, boolean z) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17568bl(i, z);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public void mo17460bl(int i, boolean z) {
        C12515s.m17660ok().m17654ok(i, z);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public DownloadInfo mo17464a(String str, String str2) {
        return mo17424p(C12490bl.m17776ok(str, str2));
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public boolean mo17459bl(DownloadInfo downloadInfo) {
        return this.f35213a.mo17488ok(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17427ok(List<String> list) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17541ok(list);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: s */
    public List<DownloadInfo> mo17418s(String str) {
        InterfaceC12501k interfaceC12501k = this.f35213a;
        if (interfaceC12501k != null) {
            return interfaceC12501k.mo17476s(str);
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: n */
    public List<DownloadInfo> mo17448n(String str) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            return abstractC12547ok.m17571a(str);
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17468a(int i, boolean z) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17575a(i, z);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public List<DownloadInfo> mo17429ok(String str) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            return abstractC12547ok.m17542ok(str);
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: n */
    public boolean mo17450n() {
        return this.f35213a.mo17479s();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17470a(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17555ok(i, i2, iDownloadListener, enumC12414kf, z);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public int mo17428ok(String str, String str2) {
        return C12490bl.m17776ok(str, str2);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17441ok(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17577a(i, i2, iDownloadListener, enumC12414kf, z);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public boolean mo17472a() {
        InterfaceC12517t interfaceC12517t = this.f35214bl;
        if (interfaceC12517t != null) {
            return interfaceC12517t.mo17633a();
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17440ok(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z, boolean z2) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17554ok(i, i2, iDownloadListener, enumC12414kf, z, z2);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17466a(DownloadTask downloadTask) {
        InterfaceC12517t interfaceC12517t = this.f35214bl;
        if (interfaceC12517t != null) {
            interfaceC12517t.mo17526bl(downloadTask);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public boolean mo17432ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean m16572ok = C12713kf.m16572ok(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (m16572ok) {
            if (C12717ok.m16510ok(CommonNetImpl.FLAG_SHARE_JUMP)) {
                mo17468a(downloadInfo.getId(), true);
            } else {
                m17584s(downloadInfo.getId(), true);
            }
        }
        return m16572ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17467a(DownloadInfo downloadInfo) {
        this.f35213a.mo17516a(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17469a(int i, List<C12598a> list) {
        this.f35213a.mo17518a(i, list);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17438ok(int i, Notification notification) {
        InterfaceC12517t interfaceC12517t = this.f35214bl;
        if (interfaceC12517t != null) {
            interfaceC12517t.mo17631ok(i, notification);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17426ok(boolean z, boolean z2) {
        InterfaceC12517t interfaceC12517t = this.f35214bl;
        if (interfaceC12517t != null) {
            interfaceC12517t.mo17629ok(z2);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17431ok(DownloadTask downloadTask) {
        InterfaceC12517t interfaceC12517t = this.f35214bl;
        if (interfaceC12517t != null) {
            interfaceC12517t.mo17527a(downloadTask);
        } else if (downloadTask != null) {
            C12723ok.m16492ok(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17436ok(int i, List<C12598a> list) {
        this.f35213a.mo17492ok(i, list);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17430ok(C12598a c12598a) {
        this.f35213a.mo17486ok(c12598a);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17442ok(int i, int i2, long j) {
        this.f35213a.mo17495ok(i, i2, j);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17443ok(int i, int i2, int i3, long j) {
        this.f35213a.mo17496ok(i, i2, i3, j);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17444ok(int i, int i2, int i3, int i4) {
        this.f35213a.mo17497ok(i, i2, i3, i4);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17433ok(InterfaceC12471sg interfaceC12471sg) {
        C12490bl.m17796ok(interfaceC12471sg);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17445ok(int i, int i2) {
        if (C12490bl.m17805n() != null) {
            for (InterfaceC12471sg interfaceC12471sg : C12490bl.m17805n()) {
                if (interfaceC12471sg != null) {
                    interfaceC12471sg.mo16655ok(i2, i);
                }
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17437ok(int i, InterfaceC12427ep interfaceC12427ep) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17552ok(i, interfaceC12427ep);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17439ok(int i, long j) {
        AbstractC12547ok abstractC12547ok = this.f35215ok;
        if (abstractC12547ok != null) {
            abstractC12547ok.m17576a(i, j);
        }
    }
}
