package com.p521ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12036ok;
import com.p521ss.android.downloadlib.addownload.p531ok.C12117ok;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p534h.HandlerC12218z;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12712k;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12109ok implements HandlerC12218z.InterfaceC12219ok {

    /* renamed from: a */
    private static C12109ok f34264a = null;

    /* renamed from: ok */
    private static final String f34265ok = "ok";

    /* renamed from: bl */
    private HandlerC12218z f34266bl = new HandlerC12218z(Looper.getMainLooper(), this);

    /* renamed from: s */
    private long f34267s;

    private C12109ok() {
    }

    /* renamed from: ok */
    public static C12109ok m19046ok() {
        if (f34264a == null) {
            synchronized (C12109ok.class) {
                if (f34264a == null) {
                    f34264a = new C12109ok();
                }
            }
        }
        return f34264a;
    }

    /* renamed from: ok */
    public void m19044ok(@NonNull DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        C12036ok c12036ok = new C12036ok(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        C12534ok m17599ok = C12534ok.m17599ok(downloadInfo.getId());
        if (m17599ok.m17593ok("back_miui_silent_install", 1) == 0 && ((C12317n.m18225z() || C12317n.m18231rh()) && C12712k.m16624ok(C12128r.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (C12713kf.m16547ok(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.f34266bl.obtainMessage(200, c12036ok);
                obtainMessage.arg1 = 2;
                this.f34266bl.sendMessageDelayed(obtainMessage, m17599ok.m17593ok("check_silent_install_interval", 60000));
                return;
            }
            C11998a m19311s = C12032kf.m19324ok().m19311s(c12036ok.f34081a);
            JSONObject jSONObject = new JSONObject();
            int i = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
            }
            C12128r.m18962kf().mo18389ok(null, new BaseException(i, jSONObject.toString()), i);
            C12270ok.m18539ok().m18523ok("embeded_ad", "ah_result", jSONObject, m19311s);
        }
        if (C12201n.m18748bl()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f34267s;
            long m18735s = C12201n.m18735s();
            if (currentTimeMillis < C12201n.m18742n()) {
                long m18742n = C12201n.m18742n() - currentTimeMillis;
                m18735s += m18742n;
                this.f34267s = System.currentTimeMillis() + m18742n;
            } else {
                this.f34267s = System.currentTimeMillis();
            }
            HandlerC12218z handlerC12218z = this.f34266bl;
            handlerC12218z.sendMessageDelayed(handlerC12218z.obtainMessage(200, c12036ok), m18735s);
        }
    }

    /* renamed from: ok */
    private void m19045ok(C12036ok c12036ok, int i) {
        if (C12128r.m18964j() == null || C12128r.m18964j().mo19656ok() || c12036ok == null) {
            return;
        }
        if (2 == i) {
            C11998a m19311s = C12032kf.m19324ok().m19311s(c12036ok.f34081a);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (C12197j.m18796n(C12128r.getContext(), c12036ok.f34088s)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception unused) {
            }
            C12128r.m18962kf().mo18389ok(null, new BaseException(i2, jSONObject.toString()), i2);
            C12270ok.m18539ok().m18523ok("embeded_ad", "ah_result", jSONObject, m19311s);
        }
        if (C12197j.m18796n(C12128r.getContext(), c12036ok.f34088s)) {
            C12270ok.m18539ok().m18528ok("delayinstall_installed", c12036ok.f34081a);
        } else if (!C12197j.m18784ok(c12036ok.f34083h)) {
            C12270ok.m18539ok().m18528ok("delayinstall_file_lost", c12036ok.f34081a);
        } else if (C12117ok.m19022ok().m19014ok(c12036ok.f34088s)) {
            C12270ok.m18539ok().m18528ok("delayinstall_conflict_with_back_dialog", c12036ok.f34081a);
        } else {
            C12270ok.m18539ok().m18528ok("delayinstall_install_start", c12036ok.f34081a);
            C12361s.m18063ok(C12128r.getContext(), (int) c12036ok.f34086ok);
        }
    }

    @Override // com.p521ss.android.downloadlib.p534h.HandlerC12218z.InterfaceC12219ok
    /* renamed from: ok */
    public void mo18671ok(Message message) {
        if (message.what != 200) {
            return;
        }
        m19045ok((C12036ok) message.obj, message.arg1);
    }
}
