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

/* renamed from: com.ss.android.downloadlib.addownload.s.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12144bl implements InterfaceC12147h {

    /* renamed from: a */
    private static InterfaceC12111bl f34369a;

    /* renamed from: ok */
    private static InterfaceC12120s f34370ok;

    /* renamed from: a */
    public static InterfaceC12111bl m18902a() {
        return f34369a;
    }

    /* renamed from: ok */
    public static InterfaceC12120s m18901ok() {
        return f34370ok;
    }

    /* renamed from: ok */
    public static void m18897ok(InterfaceC12111bl interfaceC12111bl) {
        f34369a = interfaceC12111bl;
    }

    @Override // com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12147h
    /* renamed from: ok */
    public boolean mo18888ok(final C11998a c11998a, int i, final InterfaceC12155p interfaceC12155p, final InterfaceC12111bl interfaceC12111bl) {
        DownloadInfo m18578a;
        String format;
        if (c11998a != null && m18898ok(c11998a)) {
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
            if (curBytes < 0 || totalBytes <= 0) {
                return false;
            }
            final int m19121ok = C12091k.m19121ok(m18578a.getId(), (int) ((100 * curBytes) / totalBytes));
            final int i2 = (int) (curBytes / 1048576);
            boolean z = m19121ok > m18900ok(c11998a.mo19285zz());
            f34370ok = new InterfaceC12120s() { // from class: com.ss.android.downloadlib.addownload.s.bl.1
                @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s
                /* renamed from: a */
                public void mo18871a() {
                    InterfaceC12120s unused = C12144bl.f34370ok = null;
                    C12144bl.this.m18899ok(m19121ok, i2, i2, c11998a, "download_percent_cancel", CommonNetImpl.CANCEL);
                    interfaceC12155p.mo18883ok(c11998a);
                }

                @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s
                /* renamed from: ok */
                public void mo18870ok() {
                    InterfaceC12120s unused = C12144bl.f34370ok = null;
                    C12144bl.this.m18899ok(m19121ok, i2, i2, c11998a, "download_percent_cancel", "confirm");
                }
            };
            String m18793ok = C12197j.m18793ok(C12091k.m19120ok(c11998a.mo19285zz(), curBytes, totalBytes));
            if (z) {
                format = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", m18793ok, C12197j.m18793ok(totalBytes - curBytes));
            } else {
                format = String.format("该任务已下载%s，即将下载完成，是否继续下载？", m18793ok);
            }
            String str = format;
            if (interfaceC12111bl != null) {
                m18897ok(new InterfaceC12111bl() { // from class: com.ss.android.downloadlib.addownload.s.bl.2
                    @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12111bl
                    public void delete() {
                        InterfaceC12120s unused = C12144bl.f34370ok = null;
                        C12144bl.this.m18899ok(m19121ok, i2, i2, c11998a, "download_percent_cancel", "delete");
                        interfaceC12111bl.delete();
                    }
                });
            }
            TTDelegateActivity.m19367a(c11998a, str, "继续", "暂停", "删除");
            return true;
        }
        return false;
    }

    /* renamed from: ok */
    private int m18900ok(int i) {
        return C12534ok.m17599ok(i).m17593ok("cancel_pause_optimise_download_percent_value", 50);
    }

    /* renamed from: ok */
    private boolean m18898ok(InterfaceC11999ok interfaceC11999ok) {
        return C12201n.m18737ok(interfaceC11999ok).m17593ok("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && interfaceC11999ok.mo19288x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m18899ok(int i, int i2, int i3, C11998a c11998a, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18521ok("pause_cancel_optimise", jSONObject, c11998a);
    }
}
