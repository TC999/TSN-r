package com.p521ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.p521ss.android.download.api.config.InterfaceC11969td;
import com.p521ss.android.downloadlib.C12184h;
import com.p521ss.android.downloadlib.C12265s;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.compliance.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12067kf {

    /* renamed from: ok */
    private final AtomicInteger f34148ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.addownload.compliance.kf$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12071ok {

        /* renamed from: ok */
        private static C12067kf f34159ok = new C12067kf();
    }

    private C12067kf() {
        this.f34148ok = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m19207a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f34148ok.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com");
        sb.append("/customer/api/app/deep_link");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19206a(@NonNull final C12035n c12035n, final String str, final byte[] bArr, final InterfaceC12083p interfaceC12083p) {
        C12128r.m18943s().mo19647ok(str, bArr, "application/json; charset=utf-8", 0, new InterfaceC11969td() { // from class: com.ss.android.downloadlib.addownload.compliance.kf.2
            @Override // com.p521ss.android.download.api.config.InterfaceC11969td
            /* renamed from: ok */
            public void mo18687ok(String str2) {
                C12067kf.this.m19200ok(c12035n, str2, interfaceC12083p);
            }

            @Override // com.p521ss.android.download.api.config.InterfaceC11969td
            /* renamed from: ok */
            public void mo18686ok(Throwable th) {
                C12067kf.this.m19199ok(c12035n, str, bArr, interfaceC12083p);
            }
        });
    }

    /* renamed from: ok */
    public static C12067kf m19204ok() {
        return C12071ok.f34159ok;
    }

    /* renamed from: ok */
    public void m19201ok(final C12035n c12035n, final InterfaceC12083p interfaceC12083p) {
        if (C12128r.m18943s() == null) {
            C12235bl.m18640ok().m18639ok("getDownloadNetworkFactory == NULL");
            m19203ok(401, c12035n);
            return;
        }
        C12265s.m18554ok().m18553ok(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.kf.1
            @Override // java.lang.Runnable
            public void run() {
                C12067kf c12067kf = C12067kf.this;
                c12067kf.m19206a(c12035n, c12067kf.m19207a(), C12067kf.this.m19198ok(c12035n, true, 4), interfaceC12083p);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m19199ok(C12035n c12035n, String str, byte[] bArr, InterfaceC12083p interfaceC12083p) {
        if (this.f34148ok.get() < 6) {
            this.f34148ok.incrementAndGet();
            m19206a(c12035n, str, bArr, interfaceC12083p);
            return;
        }
        m19193ok("当前网络不佳，请稍后再试");
        this.f34148ok.set(0);
        m19203ok(402, c12035n);
    }

    /* renamed from: ok */
    private void m19193ok(final String str) {
        C12184h.m18835ok().m18841a().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.kf.3
            @Override // java.lang.Runnable
            public void run() {
                C12128r.m18968bl().mo19528ok(6, C12128r.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public byte[] m19198ok(C12035n c12035n, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadModel.DOWNLOAD_URL, c12035n.mo19298ok());
            jSONObject.put("package_name", c12035n.mo19300n());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", C12128r.getContext().getPackageName());
                jSONObject.put("sender_version", C12128r.m18963k().f33908n);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", String.valueOf(c12035n.mo19309a()));
                if (c12035n.mo19305io().getDeepLink() != null) {
                    if (TextUtils.isEmpty(c12035n.mo19305io().getDeepLink().getWebUrl())) {
                        C12235bl.m18640ok().m18639ok("web_url is null");
                    }
                    jSONObject.put("web_url", c12035n.mo19305io().getDeepLink().getWebUrl());
                } else {
                    C12235bl.m18640ok().m18639ok("deeplink is null");
                }
            }
        } catch (Exception unused) {
            C12235bl.m18640ok().m18639ok("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m19200ok(@NonNull C12035n c12035n, String str, InterfaceC12083p interfaceC12083p) {
        try {
            if (TextUtils.isEmpty(str)) {
                C12235bl.m18640ok().m18639ok("response content is null");
                m19203ok(404, c12035n);
                interfaceC12083p.mo19052ok();
                return;
            }
            this.f34148ok.set(0);
            C12072n m19182h = C12072n.m19182h(str);
            if (m19182h.m19178ok() != 0) {
                m19203ok(403, c12035n);
                interfaceC12083p.mo19052ok();
            } else if (TextUtils.isEmpty(m19182h.m19191a())) {
                m19203ok(405, c12035n);
                interfaceC12083p.mo19052ok();
            } else {
                interfaceC12083p.mo19051ok(m19182h.m19191a());
            }
        } catch (Exception e) {
            C12235bl.m18640ok().mo18637ok(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    /* renamed from: ok */
    public void m19203ok(int i, C12035n c12035n) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18521ok("get_miui_market_compliance_error", jSONObject, c12035n);
    }

    /* renamed from: ok */
    public void m19202ok(int i, C12035n c12035n, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18521ok("get_miui_market_compliance_success", jSONObject, c12035n);
    }
}
