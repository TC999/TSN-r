package com.p521ss.android.downloadlib.addownload.p532s;

import android.content.Context;
import android.text.TextUtils;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.downloadlib.addownload.s.r */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12157r {

    /* renamed from: ok */
    private static C12157r f34391ok;

    /* renamed from: a */
    private List<InterfaceC12156q> f34392a;

    private C12157r() {
        ArrayList arrayList = new ArrayList();
        this.f34392a = arrayList;
        arrayList.add(new C12149k());
        this.f34392a.add(new C12148j());
        this.f34392a.add(new C12150kf());
        this.f34392a.add(new C12153ok());
    }

    /* renamed from: ok */
    public static C12157r m18881ok() {
        if (f34391ok == null) {
            synchronized (C12157r.class) {
                if (f34391ok == null) {
                    f34391ok = new C12157r();
                }
            }
        }
        return f34391ok;
    }

    /* renamed from: ok */
    public void m18880ok(C11998a c11998a, int i, InterfaceC12155p interfaceC12155p) {
        DownloadInfo m18578a;
        List<InterfaceC12156q> list = this.f34392a;
        if (list != null && list.size() != 0 && c11998a != null) {
            if (!TextUtils.isEmpty(c11998a.m19480ld())) {
                m18578a = C12257p.m18572ok((Context) null).m18563ok(c11998a.m19480ld(), null, true);
            } else {
                m18578a = C12257p.m18572ok((Context) null).m18578a(c11998a.mo19298ok());
            }
            if (m18578a != null && "application/vnd.android.package-archive".equals(m18578a.getMimeType())) {
                boolean z = C12534ok.m17599ok(c11998a.mo19285zz()).m17593ok("pause_optimise_switch", 0) == 1;
                for (InterfaceC12156q interfaceC12156q : this.f34392a) {
                    if (z || (interfaceC12156q instanceof C12148j)) {
                        if (interfaceC12156q.mo18882ok(c11998a, i, interfaceC12155p)) {
                            return;
                        }
                    }
                }
                interfaceC12155p.mo18883ok(c11998a);
                return;
            }
            interfaceC12155p.mo18883ok(c11998a);
            return;
        }
        interfaceC12155p.mo18883ok(c11998a);
    }
}
