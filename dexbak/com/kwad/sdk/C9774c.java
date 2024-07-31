package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.C9559r;
import com.kwad.framework.filedownloader.download.C9470b;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9501f;
import com.kwad.framework.filedownloader.services.C9566c;
import com.kwad.sdk.C10817j;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.download.C10303b;
import com.kwad.sdk.core.download.p396b.C10319a;
import com.kwad.sdk.utils.C11010ad;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11031aw;
import com.kwad.sdk.utils.C11122q;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.kwad.sdk.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9774c {
    private AbstractC9667a aku;
    private InterfaceC10750d akw;
    private Context mContext;
    private final Map<Integer, DownloadTask> aks = new ConcurrentHashMap();
    private final Map<String, Integer> akt = new ConcurrentHashMap();
    private boolean akv = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9777a {
        private static final C9774c akz = new C9774c();
    }

    /* renamed from: bT */
    private void m27794bT(int i) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    /* renamed from: h */
    private void m27791h(@NonNull DownloadTask downloadTask) {
        this.aks.remove(Integer.valueOf(downloadTask.getId()));
        this.akt.remove(downloadTask.getUrl());
    }

    /* renamed from: xL */
    public static C9774c m27790xL() {
        return C9777a.akz;
    }

    /* renamed from: xO */
    public static boolean m27787xO() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: xP */
    private void m27786xP() {
        C10817j.C10818a c10818a;
        try {
            c10818a = new C10817j.C10818a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            c10818a = null;
        }
        if (c10818a != null) {
            C9470b.m28631vo().m28634b(new C9566c.C9568b().m28391bH(Integer.MAX_VALUE).m28393a(c10818a));
            this.akv = true;
        }
    }

    /* renamed from: xQ */
    private static void m27785xQ() {
        C10817j.C10818a c10818a;
        try {
            c10818a = new C10817j.C10818a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            c10818a = null;
        }
        if (c10818a != null) {
            C9470b.m28631vo().m28634b(new C9566c.C9568b().m28391bH(Integer.MAX_VALUE).m28393a(c10818a));
        }
    }

    /* renamed from: a */
    public final int m27798a(@NonNull DownloadTask.DownloadRequest downloadRequest, AbstractC9667a abstractC9667a) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            m27786xP();
        } else if (this.akv) {
            m27785xQ();
        }
        if (this.aks.get(Integer.valueOf(downloadTask.getId())) != null) {
            m27800a(downloadTask.getId(), downloadRequest);
            m27794bT(downloadTask.getId());
        } else {
            this.aks.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.akt.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        m27799a(downloadTask.getId(), null, this.aku);
        return downloadTask.getId();
    }

    /* renamed from: bS */
    public final DownloadTask m27796bS(int i) {
        return this.aks.get(Integer.valueOf(i));
    }

    /* renamed from: bU */
    public final void m27793bU(int i) {
        DownloadTask m27796bS = m27796bS(i);
        if (m27796bS == null) {
            return;
        }
        if (m27796bS.isUserPause()) {
            resume(i);
        } else {
            pause(i);
        }
    }

    public final void cancel(int i) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.cancel();
            m27791h(downloadTask);
        }
    }

    /* renamed from: g */
    public final void m27792g(DownloadTask downloadTask) {
        final String m24144bu = C11010ad.m24144bu(downloadTask.getUrl());
        C11017ak.m24115a(downloadTask.getTargetFilePath(), new C11017ak.InterfaceC11018a() { // from class: com.kwad.sdk.c.2
            @Override // com.kwad.sdk.utils.C11017ak.InterfaceC11018a
            /* renamed from: d */
            public final void mo24107d(Throwable th) {
                C10303b.m26364De().m26340f(m24144bu, th);
            }

            @Override // com.kwad.sdk.utils.C11017ak.InterfaceC11018a
            /* renamed from: ol */
            public final void mo24106ol() {
                C10303b.m26364De().m26344dE(m24144bu);
            }
        });
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void init(@NonNull Context context) {
        this.mContext = context;
        C9559r.m28425a(context, new C9566c.C9568b().m28391bH(Integer.MAX_VALUE).m28392a(new C9566c.InterfaceC9567a() { // from class: com.kwad.sdk.c.1
            @Override // com.kwad.framework.filedownloader.services.C9566c.InterfaceC9567a
            /* renamed from: vu */
            public final C9492c.InterfaceC9494b mo27783vu() {
                try {
                    C10817j.C10818a c10818a = new C10817j.C10818a(false);
                    c10818a.mo24736be("");
                    return c10818a;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }));
    }

    public final void pause(int i) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public final void resume(int i) {
        m27800a(i, (DownloadTask.DownloadRequest) null);
    }

    /* renamed from: xM */
    public final File m27789xM() {
        return C11031aw.m23995cL(this.mContext);
    }

    /* renamed from: xN */
    public final InterfaceC10750d m27788xN() {
        if (this.akw == null) {
            this.akw = new C10319a();
        }
        return this.akw;
    }

    /* renamed from: xR */
    public final boolean m27784xR() {
        while (true) {
            boolean z = false;
            for (Map.Entry<Integer, DownloadTask> entry : this.aks.entrySet()) {
                DownloadTask value = entry.getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > 120000) {
                        z = true;
                    }
                }
            }
            return z;
        }
    }

    /* renamed from: bS */
    public static void m27795bS(String str) {
        if (str == null) {
            return;
        }
        C11122q.delete(C9501f.m28508bt(str));
        C11122q.delete(str);
    }

    /* renamed from: a */
    private void m27799a(int i, AbstractC9667a... abstractC9667aArr) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i));
        if (downloadTask != null) {
            for (int i2 = 0; i2 < 2; i2++) {
                AbstractC9667a abstractC9667a = abstractC9667aArr[i2];
                if (abstractC9667a != null) {
                    abstractC9667a.setId(i);
                    downloadTask.addListener(abstractC9667a);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m27797a(AbstractC9667a abstractC9667a) {
        this.aku = abstractC9667a;
    }

    /* renamed from: a */
    private void m27800a(int i, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }
}
