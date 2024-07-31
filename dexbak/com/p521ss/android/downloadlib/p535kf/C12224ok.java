package com.p521ss.android.downloadlib.p535kf;

import androidx.annotation.NonNull;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.activity.TTDelegateActivity;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.guide.install.InterfaceC12183ok;
import com.p521ss.android.downloadlib.p527a.C12007bl;
import com.p521ss.android.downloadlib.p527a.C12011kf;
import com.p521ss.android.downloadlib.p527a.C12023q;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12300k;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12305q;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.downloadlib.kf.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12224ok implements InterfaceC12300k {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18665a(DownloadInfo downloadInfo, @NonNull final InterfaceC12183ok interfaceC12183ok) {
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        boolean m19397ok = C12011kf.m19397ok(m19315ok);
        boolean m19404a = C12011kf.m19404a(m19315ok);
        if (m19397ok && m19404a) {
            C12007bl.m19406ok(m19315ok, new InterfaceC12183ok() { // from class: com.ss.android.downloadlib.kf.ok.3
                @Override // com.p521ss.android.downloadlib.guide.install.InterfaceC12183ok
                /* renamed from: ok */
                public void mo18662ok() {
                    interfaceC12183ok.mo18662ok();
                }
            });
        } else {
            interfaceC12183ok.mo18662ok();
        }
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12300k
    /* renamed from: ok */
    public void mo18400ok(DownloadInfo downloadInfo, final InterfaceC12305q interfaceC12305q) {
        m18663ok(downloadInfo, new InterfaceC12183ok() { // from class: com.ss.android.downloadlib.kf.ok.1
            @Override // com.p521ss.android.downloadlib.guide.install.InterfaceC12183ok
            /* renamed from: ok */
            public void mo18662ok() {
                interfaceC12305q.mo18388ok();
            }
        });
    }

    /* renamed from: ok */
    public void m18663ok(final DownloadInfo downloadInfo, @NonNull final InterfaceC12183ok interfaceC12183ok) {
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        if (m19315ok != null && C12023q.m19372ok(m19315ok)) {
            TTDelegateActivity.m19354ok(m19315ok, new InterfaceC12183ok() { // from class: com.ss.android.downloadlib.kf.ok.2
                @Override // com.p521ss.android.downloadlib.guide.install.InterfaceC12183ok
                /* renamed from: ok */
                public void mo18662ok() {
                    C12224ok.this.m18665a(downloadInfo, interfaceC12183ok);
                }
            });
        } else {
            m18665a(downloadInfo, interfaceC12183ok);
        }
    }
}
