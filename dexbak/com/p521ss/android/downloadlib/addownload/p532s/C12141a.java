package com.p521ss.android.downloadlib.addownload.p532s;

import android.text.TextUtils;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.downloadlib.activity.TTDelegateActivity;
import com.p521ss.android.downloadlib.addownload.C12091k;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12111bl;
import com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.s.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12141a implements InterfaceC12147h {

    /* renamed from: a */
    private static InterfaceC12111bl f34357a;

    /* renamed from: ok */
    private static InterfaceC12120s f34358ok;

    /* renamed from: a */
    public static InterfaceC12111bl m18910a() {
        return f34357a;
    }

    /* renamed from: ok */
    public static InterfaceC12120s m18909ok() {
        return f34358ok;
    }

    /* renamed from: ok */
    public static void m18905ok(InterfaceC12111bl interfaceC12111bl) {
        f34357a = interfaceC12111bl;
    }

    @Override // com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12147h
    /* renamed from: ok */
    public boolean mo18888ok(final C11998a c11998a, int i, final InterfaceC12155p interfaceC12155p, final InterfaceC12111bl interfaceC12111bl) {
        DownloadInfo m18578a;
        if (c11998a != null && m18906ok(c11998a)) {
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
            if (m19120ok >= 0 && totalBytes > 0) {
                if (totalBytes <= m18908ok(c11998a.mo19285zz())) {
                    final int i2 = (int) (m19120ok / 1048576);
                    f34358ok = new InterfaceC12120s() { // from class: com.ss.android.downloadlib.addownload.s.a.1
                        @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s
                        /* renamed from: a */
                        public void mo18871a() {
                            InterfaceC12120s unused = C12141a.f34358ok = null;
                            C12141a.this.m18907ok(i2, i2, c11998a, "apk_size_cancel", CommonNetImpl.CANCEL);
                            interfaceC12155p.mo18883ok(c11998a);
                        }

                        @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s
                        /* renamed from: ok */
                        public void mo18870ok() {
                            InterfaceC12120s unused = C12141a.f34358ok = null;
                            C12141a.this.m18907ok(i2, i2, c11998a, "apk_size_cancel", "confirm");
                        }
                    };
                    String format = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", C12197j.m18793ok(totalBytes - m19120ok));
                    if (interfaceC12111bl != null) {
                        m18905ok(new InterfaceC12111bl() { // from class: com.ss.android.downloadlib.addownload.s.a.2
                            @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12111bl
                            public void delete() {
                                InterfaceC12120s unused = C12141a.f34358ok = null;
                                C12141a.this.m18907ok(i2, i2, c11998a, "apk_size_cancel", "delete");
                                interfaceC12111bl.delete();
                            }
                        });
                    }
                    TTDelegateActivity.m19351ok(c11998a, format, "继续", "暂停", "删除");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: ok */
    private int m18908ok(int i) {
        return C12534ok.m17599ok(i).m17593ok("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    /* renamed from: ok */
    private boolean m18906ok(InterfaceC11999ok interfaceC11999ok) {
        return C12201n.m18737ok(interfaceC11999ok).m17593ok("cancel_pause_optimise_apk_retain_switch", 0) == 1 && interfaceC11999ok.mo19288x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m18907ok(int i, int i2, C11998a c11998a, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18521ok("pause_cancel_optimise", jSONObject, c11998a);
    }
}
