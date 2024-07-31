package com.p521ss.android.downloadlib.addownload.p532s;

import android.text.TextUtils;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.downloadlib.activity.TTDelegateActivity;
import com.p521ss.android.downloadlib.addownload.C12091k;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.s.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12153ok implements InterfaceC12156q {

    /* renamed from: ok */
    private static InterfaceC12120s f34387ok;

    /* renamed from: ok */
    public static InterfaceC12120s m18887ok() {
        return f34387ok;
    }

    @Override // com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12156q
    /* renamed from: ok */
    public boolean mo18882ok(final C11998a c11998a, int i, final InterfaceC12155p interfaceC12155p) {
        DownloadInfo m18578a;
        if (c11998a == null || c11998a.m19512de() || !m18885ok(c11998a)) {
            return false;
        }
        if (!TextUtils.isEmpty(c11998a.m19480ld())) {
            m18578a = C12257p.m18572ok(C12128r.getContext()).m18563ok(c11998a.m19480ld(), null, true);
        } else {
            m18578a = C12257p.m18572ok(C12128r.getContext()).m18578a(c11998a.mo19298ok());
        }
        if (m18578a == null) {
            return false;
        }
        long m19120ok = C12091k.m19120ok(m18578a.getId(), m18578a.getCurBytes(), m18578a.getTotalBytes());
        long totalBytes = m18578a.getTotalBytes();
        if (m19120ok <= 0 || totalBytes <= 0 || totalBytes > m18886ok(c11998a.mo19285zz())) {
            return false;
        }
        f34387ok = new InterfaceC12120s() { // from class: com.ss.android.downloadlib.addownload.s.ok.1
            @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s
            /* renamed from: a */
            public void mo18871a() {
                InterfaceC12120s unused = C12153ok.f34387ok = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", CommonNetImpl.CANCEL);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                C12270ok.m18539ok().m18521ok("pause_optimise", jSONObject, c11998a);
                interfaceC12155p.mo18883ok(c11998a);
            }

            @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s
            /* renamed from: ok */
            public void mo18870ok() {
                InterfaceC12120s unused = C12153ok.f34387ok = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                C12270ok.m18539ok().m18521ok("pause_optimise", jSONObject, c11998a);
            }
        };
        TTDelegateActivity.m19352ok(c11998a, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", C12197j.m18793ok(totalBytes - m19120ok)), "继续", "暂停");
        c11998a.m19455rh(true);
        return true;
    }

    /* renamed from: ok */
    private int m18886ok(int i) {
        return C12534ok.m17599ok(i).m17593ok("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    /* renamed from: ok */
    private boolean m18885ok(InterfaceC11999ok interfaceC11999ok) {
        return C12201n.m18737ok(interfaceC11999ok).m17593ok("pause_optimise_apk_size_switch", 0) == 1 && interfaceC11999ok.mo19288x();
    }
}
