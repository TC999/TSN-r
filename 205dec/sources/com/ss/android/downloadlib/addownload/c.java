package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.r.bk;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c implements bk.c {

    /* renamed from: c  reason: collision with root package name */
    private static final String f48399c = "c";

    /* renamed from: w  reason: collision with root package name */
    private static c f48400w;
    private long sr;
    private com.ss.android.downloadlib.r.bk xv = new com.ss.android.downloadlib.r.bk(Looper.getMainLooper(), this);

    private c() {
    }

    public static c c() {
        if (f48400w == null) {
            synchronized (c.class) {
                if (f48400w == null) {
                    f48400w = new c();
                }
            }
        }
        return f48400w;
    }

    public void c(@NonNull DownloadInfo downloadInfo, long j4, long j5, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.w.c cVar = new com.ss.android.downloadlib.addownload.w.c(downloadInfo.getId(), j4, j5, str, str2, str3, str4);
        com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId());
        if (c4.c("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.f.ux.bk() || com.ss.android.socialbase.appdownloader.f.ux.t()) && com.ss.android.socialbase.downloader.gd.p.c(k.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.gd.f.c(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.xv.obtainMessage(200, cVar);
                obtainMessage.arg1 = 2;
                this.xv.sendMessageDelayed(obtainMessage, c4.c("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.downloadad.api.c.w sr = com.ss.android.downloadlib.addownload.w.f.c().sr(cVar.f48705w);
            JSONObject jSONObject = new JSONObject();
            int i4 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i4 = 5;
            } catch (Exception unused) {
            }
            k.f().c(null, new BaseException(i4, jSONObject.toString()), i4);
            com.ss.android.downloadlib.sr.c.c().c("embeded_ad", "ah_result", jSONObject, sr);
        }
        if (com.ss.android.downloadlib.r.ux.xv()) {
            long currentTimeMillis = System.currentTimeMillis() - this.sr;
            long sr2 = com.ss.android.downloadlib.r.ux.sr();
            if (currentTimeMillis < com.ss.android.downloadlib.r.ux.ux()) {
                long ux = com.ss.android.downloadlib.r.ux.ux() - currentTimeMillis;
                sr2 += ux;
                this.sr = System.currentTimeMillis() + ux;
            } else {
                this.sr = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.r.bk bkVar = this.xv;
            bkVar.sendMessageDelayed(bkVar.obtainMessage(200, cVar), sr2);
        }
    }

    private void c(com.ss.android.downloadlib.addownload.w.c cVar, int i4) {
        if (k.a() == null || k.a().c() || cVar == null) {
            return;
        }
        if (2 == i4) {
            com.ss.android.downloadad.api.c.w sr = com.ss.android.downloadlib.addownload.w.f.c().sr(cVar.f48705w);
            JSONObject jSONObject = new JSONObject();
            int i5 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.r.a.ux(k.getContext(), cVar.sr)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i5 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i5 = 5;
                }
            } catch (Exception unused) {
            }
            k.f().c(null, new BaseException(i5, jSONObject.toString()), i5);
            com.ss.android.downloadlib.sr.c.c().c("embeded_ad", "ah_result", jSONObject, sr);
        }
        if (com.ss.android.downloadlib.r.a.ux(k.getContext(), cVar.sr)) {
            com.ss.android.downloadlib.sr.c.c().c("delayinstall_installed", cVar.f48705w);
        } else if (!com.ss.android.downloadlib.r.a.c(cVar.f48704r)) {
            com.ss.android.downloadlib.sr.c.c().c("delayinstall_file_lost", cVar.f48705w);
        } else if (com.ss.android.downloadlib.addownload.c.c.c().c(cVar.sr)) {
            com.ss.android.downloadlib.sr.c.c().c("delayinstall_conflict_with_back_dialog", cVar.f48705w);
        } else {
            com.ss.android.downloadlib.sr.c.c().c("delayinstall_install_start", cVar.f48705w);
            com.ss.android.socialbase.appdownloader.sr.c(k.getContext(), (int) cVar.f48702c);
        }
    }

    @Override // com.ss.android.downloadlib.r.bk.c
    public void c(Message message) {
        if (message.what != 200) {
            return;
        }
        c((com.ss.android.downloadlib.addownload.w.c) message.obj, message.arg1);
    }
}
