package com.p521ss.android.downloadlib.addownload.p532s;

import android.text.TextUtils;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.downloadlib.activity.TTDelegateActivity;
import com.p521ss.android.downloadlib.addownload.C12091k;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.s.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12150kf implements InterfaceC12156q {

    /* renamed from: ok */
    private static InterfaceC12120s f34383ok;

    /* renamed from: ok */
    public static InterfaceC12120s m18892ok() {
        return f34383ok;
    }

    @Override // com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12156q
    /* renamed from: ok */
    public boolean mo18882ok(final C11998a c11998a, int i, final InterfaceC12155p interfaceC12155p) {
        DownloadInfo m18578a;
        if (c11998a == null || c11998a.m19511dn() || !m18890ok(c11998a)) {
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
        long curBytes = m18578a.getCurBytes();
        long totalBytes = m18578a.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int m19121ok = C12091k.m19121ok(m18578a.getId(), (int) ((curBytes * 100) / totalBytes));
            if (m19121ok > m18891ok(c11998a.mo19285zz())) {
                f34383ok = new InterfaceC12120s() { // from class: com.ss.android.downloadlib.addownload.s.kf.1
                    @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s
                    /* renamed from: a */
                    public void mo18871a() {
                        InterfaceC12120s unused = C12150kf.f34383ok = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
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
                        InterfaceC12120s unused = C12150kf.f34383ok = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        C12270ok.m18539ok().m18521ok("pause_optimise", jSONObject, c11998a);
                    }
                };
                TTDelegateActivity.m19368a(c11998a, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(m19121ok)), "继续", "暂停");
                c11998a.m19447t(true);
                return true;
            }
        }
        return false;
    }

    /* renamed from: ok */
    private int m18891ok(int i) {
        return C12534ok.m17599ok(i).m17593ok("pause_optimise_download_percent", 50);
    }

    /* renamed from: ok */
    private boolean m18890ok(InterfaceC11999ok interfaceC11999ok) {
        return C12201n.m18737ok(interfaceC11999ok).m17593ok("pause_optimise_download_percent_switch", 0) == 1 && interfaceC11999ok.mo19288x();
    }
}
