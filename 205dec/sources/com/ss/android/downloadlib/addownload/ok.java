package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.h.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok implements z.ok {

    /* renamed from: a  reason: collision with root package name */
    private static ok f48562a = null;
    private static final String ok = "ok";
    private com.ss.android.downloadlib.h.z bl = new com.ss.android.downloadlib.h.z(Looper.getMainLooper(), this);

    /* renamed from: s  reason: collision with root package name */
    private long f48563s;

    private ok() {
    }

    public static ok ok() {
        if (f48562a == null) {
            synchronized (ok.class) {
                if (f48562a == null) {
                    f48562a = new ok();
                }
            }
        }
        return f48562a;
    }

    public void ok(@NonNull DownloadInfo downloadInfo, long j4, long j5, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.a.ok okVar = new com.ss.android.downloadlib.addownload.a.ok(downloadInfo.getId(), j4, j5, str, str2, str3, str4);
        com.ss.android.socialbase.downloader.h.ok ok2 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
        if (ok2.ok("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.kf.n.z() || com.ss.android.socialbase.appdownloader.kf.n.rh()) && com.ss.android.socialbase.downloader.q.k.ok(r.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.bl.obtainMessage(200, okVar);
                obtainMessage.arg1 = 2;
                this.bl.sendMessageDelayed(obtainMessage, ok2.ok("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.downloadad.api.ok.a s3 = com.ss.android.downloadlib.addownload.a.kf.ok().s(okVar.f48374a);
            JSONObject jSONObject = new JSONObject();
            int i4 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i4 = 5;
            } catch (Exception unused) {
            }
            r.kf().ok(null, new BaseException(i4, jSONObject.toString()), i4);
            com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "ah_result", jSONObject, s3);
        }
        if (com.ss.android.downloadlib.h.n.bl()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f48563s;
            long s4 = com.ss.android.downloadlib.h.n.s();
            if (currentTimeMillis < com.ss.android.downloadlib.h.n.n()) {
                long n4 = com.ss.android.downloadlib.h.n.n() - currentTimeMillis;
                s4 += n4;
                this.f48563s = System.currentTimeMillis() + n4;
            } else {
                this.f48563s = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.h.z zVar = this.bl;
            zVar.sendMessageDelayed(zVar.obtainMessage(200, okVar), s4);
        }
    }

    private void ok(com.ss.android.downloadlib.addownload.a.ok okVar, int i4) {
        if (r.j() == null || r.j().ok() || okVar == null) {
            return;
        }
        if (2 == i4) {
            com.ss.android.downloadad.api.ok.a s3 = com.ss.android.downloadlib.addownload.a.kf.ok().s(okVar.f48374a);
            JSONObject jSONObject = new JSONObject();
            int i5 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.h.j.n(r.getContext(), okVar.f48378s)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i5 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i5 = 5;
                }
            } catch (Exception unused) {
            }
            r.kf().ok(null, new BaseException(i5, jSONObject.toString()), i5);
            com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "ah_result", jSONObject, s3);
        }
        if (com.ss.android.downloadlib.h.j.n(r.getContext(), okVar.f48378s)) {
            com.ss.android.downloadlib.s.ok.ok().ok("delayinstall_installed", okVar.f48374a);
        } else if (!com.ss.android.downloadlib.h.j.ok(okVar.f48375h)) {
            com.ss.android.downloadlib.s.ok.ok().ok("delayinstall_file_lost", okVar.f48374a);
        } else if (com.ss.android.downloadlib.addownload.ok.ok.ok().ok(okVar.f48378s)) {
            com.ss.android.downloadlib.s.ok.ok().ok("delayinstall_conflict_with_back_dialog", okVar.f48374a);
        } else {
            com.ss.android.downloadlib.s.ok.ok().ok("delayinstall_install_start", okVar.f48374a);
            com.ss.android.socialbase.appdownloader.s.ok(r.getContext(), (int) okVar.ok);
        }
    }

    @Override // com.ss.android.downloadlib.h.z.ok
    public void ok(Message message) {
        if (message.what != 200) {
            return;
        }
        ok((com.ss.android.downloadlib.addownload.a.ok) message.obj, message.arg1);
    }
}
