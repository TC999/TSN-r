package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.r;
import com.kwad.framework.filedownloader.services.c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.j;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private com.kwad.sdk.a aku;
    private d akw;
    private Context mContext;
    private final Map<Integer, DownloadTask> aks = new ConcurrentHashMap();
    private final Map<String, Integer> akt = new ConcurrentHashMap();
    private boolean akv = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private static final c akz = new c();
    }

    private void bT(int i4) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i4));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    private void h(@NonNull DownloadTask downloadTask) {
        this.aks.remove(Integer.valueOf(downloadTask.getId()));
        this.akt.remove(downloadTask.getUrl());
    }

    public static c xL() {
        return a.akz;
    }

    public static boolean xO() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void xP() {
        j.a aVar;
        try {
            aVar = new j.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.vo().b(new c.b().bH(Integer.MAX_VALUE).a(aVar));
            this.akv = true;
        }
    }

    private static void xQ() {
        j.a aVar;
        try {
            aVar = new j.a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.vo().b(new c.b().bH(Integer.MAX_VALUE).a(aVar));
        }
    }

    public final int a(@NonNull DownloadTask.DownloadRequest downloadRequest, com.kwad.sdk.a aVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            xP();
        } else if (this.akv) {
            xQ();
        }
        if (this.aks.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            bT(downloadTask.getId());
        } else {
            this.aks.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.akt.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        a(downloadTask.getId(), null, this.aku);
        return downloadTask.getId();
    }

    public final DownloadTask bS(int i4) {
        return this.aks.get(Integer.valueOf(i4));
    }

    public final void bU(int i4) {
        DownloadTask bS = bS(i4);
        if (bS == null) {
            return;
        }
        if (bS.isUserPause()) {
            resume(i4);
        } else {
            pause(i4);
        }
    }

    public final void cancel(int i4) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i4));
        if (downloadTask != null) {
            downloadTask.cancel();
            h(downloadTask);
        }
    }

    public final void g(DownloadTask downloadTask) {
        final String bu = ad.bu(downloadTask.getUrl());
        ak.a(downloadTask.getTargetFilePath(), new ak.a() { // from class: com.kwad.sdk.c.2
            @Override // com.kwad.sdk.utils.ak.a
            public final void d(Throwable th) {
                com.kwad.sdk.core.download.b.De().f(bu, th);
            }

            @Override // com.kwad.sdk.utils.ak.a
            public final void ol() {
                com.kwad.sdk.core.download.b.De().dE(bu);
            }
        });
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void init(@NonNull Context context) {
        this.mContext = context;
        r.a(context, new c.b().bH(Integer.MAX_VALUE).a(new c.a() { // from class: com.kwad.sdk.c.1
            @Override // com.kwad.framework.filedownloader.services.c.a
            public final c.b vu() {
                try {
                    j.a aVar = new j.a(false);
                    aVar.be("");
                    return aVar;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }));
    }

    public final void pause(int i4) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i4));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public final void resume(int i4) {
        a(i4, (DownloadTask.DownloadRequest) null);
    }

    public final File xM() {
        return aw.cL(this.mContext);
    }

    public final d xN() {
        if (this.akw == null) {
            this.akw = new com.kwad.sdk.core.download.b.a();
        }
        return this.akw;
    }

    public final boolean xR() {
        while (true) {
            boolean z3 = false;
            for (Map.Entry<Integer, DownloadTask> entry : this.aks.entrySet()) {
                DownloadTask value = entry.getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > PolicyConfig.THREAD_BLOCK_TIMEOUT) {
                        z3 = true;
                    }
                }
            }
            return z3;
        }
    }

    public static void bS(String str) {
        if (str == null) {
            return;
        }
        q.delete(com.kwad.framework.filedownloader.f.f.bt(str));
        q.delete(str);
    }

    private void a(int i4, com.kwad.sdk.a... aVarArr) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i4));
        if (downloadTask != null) {
            for (int i5 = 0; i5 < 2; i5++) {
                com.kwad.sdk.a aVar = aVarArr[i5];
                if (aVar != null) {
                    aVar.setId(i4);
                    downloadTask.addListener(aVar);
                }
            }
        }
    }

    public final void a(com.kwad.sdk.a aVar) {
        this.aku = aVar;
    }

    private void a(int i4, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.aks.get(Integer.valueOf(i4));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }
}
