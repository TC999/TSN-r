package com.p521ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.download.api.InterfaceC11990ok;
import com.p521ss.android.download.api.config.InterfaceC11953a;
import com.p521ss.android.download.api.config.InterfaceC11955h;
import com.p521ss.android.download.api.config.InterfaceC11957io;
import com.p521ss.android.download.api.config.InterfaceC11958j;
import com.p521ss.android.download.api.config.InterfaceC11959k;
import com.p521ss.android.download.api.config.InterfaceC11963p;
import com.p521ss.android.download.api.config.InterfaceC11964q;
import com.p521ss.android.download.api.config.InterfaceC11971x;
import com.p521ss.android.download.api.model.C11986ok;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12127q;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.p527a.C12018ok;
import com.p521ss.android.downloadlib.p533bl.C12167bl;
import com.p521ss.android.downloadlib.p534h.C12215q;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12316kf;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ss.android.downloadlib.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12228n implements InterfaceC11990ok {
    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18655ok(@NonNull InterfaceC11964q interfaceC11964q) {
        C12128r.m18951ok(interfaceC11964q);
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18659ok(@NonNull InterfaceC11955h interfaceC11955h) {
        C12128r.m18955ok(interfaceC11955h);
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18658ok(@NonNull InterfaceC11958j interfaceC11958j) {
        C12128r.m18954ok(interfaceC11958j);
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18656ok(@NonNull InterfaceC11963p interfaceC11963p) {
        C12128r.m18952ok(interfaceC11963p);
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18657ok(@NonNull InterfaceC11959k interfaceC11959k) {
        C12128r.m18953ok(interfaceC11959k);
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18653ok(@NonNull C11986ok c11986ok) {
        C12128r.m18949ok(c11986ok);
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18651ok(String str) {
        C12128r.m18948ok(str);
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18660ok(@NonNull final InterfaceC11953a interfaceC11953a) {
        C12128r.m18956ok(interfaceC11953a);
        C12646ok.m16846ok().m16844ok(new C12646ok.InterfaceC12649bl() { // from class: com.ss.android.downloadlib.n.1
        });
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18652ok(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new InterfaceC12480v() { // from class: com.ss.android.downloadlib.n.2
                /* renamed from: s */
                private boolean m18650s(DownloadInfo downloadInfo) {
                    String m18971ok;
                    InterfaceC11957io m18936zz = C12128r.m18936zz();
                    if (m18936zz != null) {
                        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
                        if (m19315ok != null && m19315ok.mo19308bl()) {
                            m18971ok = C12534ok.m17599ok(downloadInfo.getId()).m17591ok("ad_notification_jump_url", (String) null);
                        } else {
                            m18971ok = C12127q.m18971ok(downloadInfo);
                        }
                        if (TextUtils.isEmpty(m18971ok)) {
                            return false;
                        }
                        return m18936zz.m19653ok(C12128r.getContext(), m18971ok);
                    }
                    return false;
                }

                @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v
                /* renamed from: a */
                public boolean mo16680a(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v
                /* renamed from: bl */
                public boolean mo16679bl(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
                    if (m19315ok != null) {
                        C12018ok.m19381ok(m19315ok);
                    } else {
                        C12215q.m18685a(C12128r.getContext(), downloadInfo.getPackageName());
                    }
                    C12644a.m16876ok().m16878kf(downloadInfo.getId());
                    return true;
                }

                @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v
                /* renamed from: ok */
                public boolean mo16678ok(DownloadInfo downloadInfo) {
                    C12534ok m17599ok = C12534ok.m17599ok(downloadInfo.getId());
                    if (m17599ok.m17607a("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.m18488ok(C12128r.getContext(), downloadInfo, C12361s.m18068k().m18079a(), Downloader.getInstance(C12128r.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean m18650s = m18650s(downloadInfo);
                    if (m17599ok.m17593ok("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return m18650s;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new C12167bl());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public InterfaceC11990ok mo18654ok(InterfaceC11971x interfaceC11971x) {
        C12128r.m18950ok(interfaceC11971x);
        return this;
    }

    @Override // com.p521ss.android.download.api.InterfaceC11990ok
    /* renamed from: ok */
    public void mo18661ok() {
        if (!C12128r.m18960o()) {
            C12235bl.m18640ok().m18639ok("ttdownloader init error");
        }
        C12128r.m18957ok(C12235bl.m18640ok());
        try {
            C12361s.m18068k().m18075a(C12128r.m18939ul());
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12361s.m18068k().m18051ok(C12238ok.m18626ok());
        C12265s.m18554ok().m18558a(new Runnable() { // from class: com.ss.android.downloadlib.n.3
            @Override // java.lang.Runnable
            public void run() {
                C12317n.m18235ok("");
                if (C12317n.m18228t()) {
                    C12490bl.m17771ok(true);
                }
                if (C12534ok.m17605bl().m17593ok("disable_security_init", 1) == 1) {
                    C12316kf.m18250ok(C12128r.getContext());
                }
            }
        });
    }
}
