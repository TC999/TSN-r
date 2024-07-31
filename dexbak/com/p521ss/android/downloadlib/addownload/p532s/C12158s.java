package com.p521ss.android.downloadlib.addownload.p532s;

import android.text.TextUtils;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12111bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.downloadlib.addownload.s.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12158s {

    /* renamed from: ok */
    private static C12158s f34393ok;

    /* renamed from: a */
    private List<InterfaceC12147h> f34394a;

    private C12158s() {
        ArrayList arrayList = new ArrayList();
        this.f34394a = arrayList;
        arrayList.add(new C12152n());
        this.f34394a.add(new C12141a());
        this.f34394a.add(new C12144bl());
    }

    /* renamed from: ok */
    public static C12158s m18879ok() {
        if (f34393ok == null) {
            synchronized (C12157r.class) {
                if (f34393ok == null) {
                    f34393ok = new C12158s();
                }
            }
        }
        return f34393ok;
    }

    /* renamed from: ok */
    public void m18878ok(C11998a c11998a, int i, InterfaceC12155p interfaceC12155p, InterfaceC12111bl interfaceC12111bl) {
        DownloadInfo m18578a;
        List<InterfaceC12147h> list = this.f34394a;
        if (list == null || list.size() == 0 || c11998a == null) {
            interfaceC12155p.mo18883ok(c11998a);
        }
        if (!TextUtils.isEmpty(c11998a.m19480ld())) {
            m18578a = C12257p.m18572ok(C12128r.getContext()).m18563ok(c11998a.m19480ld(), null, true);
        } else {
            m18578a = C12257p.m18572ok(C12128r.getContext()).m18578a(c11998a.mo19298ok());
        }
        if (m18578a == null) {
            m18578a = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(c11998a.mo19285zz());
        }
        if (m18578a != null && "application/vnd.android.package-archive".equals(m18578a.getMimeType())) {
            if (new C12149k().mo18882ok(c11998a, i, interfaceC12155p)) {
                return;
            }
            for (InterfaceC12147h interfaceC12147h : this.f34394a) {
                if (interfaceC12147h.mo18888ok(c11998a, i, interfaceC12155p, interfaceC12111bl)) {
                    return;
                }
            }
            interfaceC12155p.mo18883ok(c11998a);
            return;
        }
        interfaceC12155p.mo18883ok(c11998a);
    }
}
