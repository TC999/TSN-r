package com.p521ss.android.downloadlib.p535kf;

import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12300k;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12305q;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.downloadlib.kf.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12222bl implements InterfaceC12300k {

    /* renamed from: ok */
    private static volatile C12222bl f34498ok;

    /* renamed from: a */
    private List<InterfaceC12300k> f34499a;

    private C12222bl() {
        ArrayList arrayList = new ArrayList();
        this.f34499a = arrayList;
        arrayList.add(new C12221a());
        this.f34499a.add(new C12224ok());
    }

    /* renamed from: ok */
    public static C12222bl m18668ok() {
        if (f34498ok == null) {
            synchronized (C12222bl.class) {
                if (f34498ok == null) {
                    f34498ok = new C12222bl();
                }
            }
        }
        return f34498ok;
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12300k
    /* renamed from: ok */
    public void mo18400ok(DownloadInfo downloadInfo, InterfaceC12305q interfaceC12305q) {
        if (downloadInfo != null && this.f34499a.size() != 0) {
            m18666ok(downloadInfo, 0, interfaceC12305q);
        } else if (interfaceC12305q != null) {
            interfaceC12305q.mo18388ok();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m18666ok(final DownloadInfo downloadInfo, final int i, final InterfaceC12305q interfaceC12305q) {
        if (i != this.f34499a.size() && i >= 0) {
            this.f34499a.get(i).mo18400ok(downloadInfo, new InterfaceC12305q() { // from class: com.ss.android.downloadlib.kf.bl.1
                @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12305q
                /* renamed from: ok */
                public void mo18388ok() {
                    C12222bl.this.m18666ok(downloadInfo, i + 1, interfaceC12305q);
                }
            });
        } else {
            interfaceC12305q.mo18388ok();
        }
    }
}
