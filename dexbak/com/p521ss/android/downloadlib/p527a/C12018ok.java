package com.p521ss.android.downloadlib.p527a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.p521ss.android.download.api.config.InterfaceC11954bl;
import com.p521ss.android.download.api.config.InterfaceC11973zz;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.model.DeepLink;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.addownload.C12127q;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12031h;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12200kf;
import com.p521ss.android.downloadlib.p534h.C12215q;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p539s.C12269bl;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12018ok {
    /* renamed from: a */
    public static void m19385a(C11998a c11998a) {
        if (c11998a == null) {
            return;
        }
        String mo19302kf = C12534ok.m17605bl().m17607a("app_link_opt") == 1 ? c11998a.mo19302kf() : null;
        JSONObject m18754ok = C12200kf.m18754ok(new JSONObject(), c11998a);
        C12197j.m18778ok(m18754ok, "applink_source", "dialog_click_by_sdk");
        C12270ok.m18539ok().m18540a("applink_click", m18754ok, c11998a);
        C12031h m18678ok = C12215q.m18678ok(mo19302kf, c11998a);
        if (m18678ok.getType() == 2) {
            if (!TextUtils.isEmpty(mo19302kf)) {
                m19384a("dialog_by_url", m18678ok, m18754ok, c11998a);
            }
            m18678ok = C12215q.m18680ok(C12128r.getContext(), c11998a.mo19300n(), c11998a);
        }
        int type = m18678ok.getType();
        if (type == 1) {
            m19383a("dialog_by_url", m18754ok, c11998a);
        } else if (type == 3) {
            m19375ok("dialog_by_package", m18754ok, c11998a);
        } else if (type != 4) {
            C12235bl.m18640ok().m18643a("AppLinkClickDialog default");
        } else {
            m19376ok("dialog_by_package", m18678ok, m18754ok, c11998a);
        }
    }

    /* renamed from: ok */
    public static boolean m19379ok(@NonNull C12035n c12035n) {
        boolean z;
        DeepLink deepLink = c12035n.f34076a.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject m18754ok = C12200kf.m18754ok(new JSONObject(), c12035n);
        C12197j.m18778ok(m18754ok, "applink_source", "click_by_sdk");
        C12270ok.m18539ok().m18540a("applink_click", m18754ok, c12035n);
        C12031h m18678ok = C12215q.m18678ok(openUrl, c12035n);
        if (m18678ok.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                m19384a("by_url", m18678ok, m18754ok, c12035n);
            }
            m18678ok = C12215q.m18680ok(C12128r.getContext(), c12035n.f34076a.getPackageName(), c12035n);
        }
        boolean z2 = false;
        if (m19382ok(c12035n.f34079ok) && C12128r.m18946q().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = c12035n.f34076a;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            C12270ok.m18539ok().m18537ok(c12035n.f34079ok, 0);
            z = true;
        } else {
            z = false;
        }
        int type = m18678ok.getType();
        if (type == 1) {
            m19383a("by_url", m18754ok, c12035n);
        } else if (type == 3) {
            m19375ok("by_package", m18754ok, c12035n);
        } else {
            if (type != 4) {
                C12235bl.m18640ok().m18643a("AppLinkClick default");
            } else {
                m19376ok("by_package", m18678ok, m18754ok, c12035n);
            }
            if (z2 && !z && ((C12269bl.m18545ok().m18549a() && !C12269bl.m18545ok().m18548a(c12035n.f34079ok, c12035n.f34076a.getLogExtra())) || C12269bl.m18545ok().m18547bl())) {
                C12270ok.m18539ok().m18537ok(c12035n.f34079ok, 2);
            }
            return z2;
        }
        z2 = true;
        if (z2) {
            C12270ok.m18539ok().m18537ok(c12035n.f34079ok, 2);
        }
        return z2;
    }

    /* renamed from: a */
    public static void m19383a(String str, @NonNull final JSONObject jSONObject, @NonNull final InterfaceC11999ok interfaceC11999ok) {
        C12197j.m18778ok(jSONObject, "applink_source", str);
        C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(interfaceC11999ok.mo19290u()));
        C12270ok.m18539ok().m18540a("deeplink_url_open", jSONObject, interfaceC11999ok);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1721882089:
                if (str.equals("auto_by_url")) {
                    c = 0;
                    break;
                }
                break;
            case -1374618233:
                if (str.equals("by_url")) {
                    c = 1;
                    break;
                }
                break;
            case -129544387:
                if (str.equals("notify_by_url")) {
                    c = 2;
                    break;
                }
                break;
            case 829750366:
                if (str.equals("dialog_by_url")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                if ((C12128r.m18946q().optInt("check_applink_mode") & 1) != 0) {
                    C12197j.m18778ok(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    C12015n.m19390ok().m19388ok(new InterfaceC12024s() { // from class: com.ss.android.downloadlib.a.ok.2
                        @Override // com.p521ss.android.downloadlib.p527a.InterfaceC12024s
                        /* renamed from: ok */
                        public void mo18606ok(boolean z) {
                            C12270ok.m18539ok().m18540a(z ? "deeplink_success" : "deeplink_failed", jSONObject, interfaceC11999ok);
                            if (z) {
                                C12128r.m18965io().mo18932ok(C12128r.getContext(), interfaceC11999ok.mo19305io(), interfaceC11999ok.mo19299o(), interfaceC11999ok.mo19289ul(), interfaceC11999ok.mo19300n(), 0);
                            }
                        }
                    });
                    return;
                }
                C12128r.m18970a().mo18934ok(C12128r.getContext(), interfaceC11999ok.mo19305io(), interfaceC11999ok.mo19299o(), interfaceC11999ok.mo19289ul(), interfaceC11999ok.mo19300n(), str);
                return;
            default:
                return;
        }
    }

    /* renamed from: ok */
    public static void m19381ok(@NonNull C11998a c11998a) {
        String mo19302kf = c11998a.mo19302kf();
        JSONObject m18754ok = C12200kf.m18754ok(new JSONObject(), c11998a);
        C12197j.m18778ok(m18754ok, "applink_source", "notify_click_by_sdk");
        C12270ok.m18539ok().m18540a("applink_click", m18754ok, c11998a);
        C12031h m18678ok = C12215q.m18678ok(mo19302kf, c11998a);
        if (m18678ok.getType() == 2) {
            if (!TextUtils.isEmpty(mo19302kf)) {
                m19384a("notify_by_url", m18678ok, m18754ok, c11998a);
            }
            m18678ok = C12215q.m18680ok(C12128r.getContext(), c11998a.mo19300n(), c11998a);
        }
        int type = m18678ok.getType();
        if (type == 1) {
            m19383a("notify_by_url", m18754ok, c11998a);
        } else if (type == 3) {
            m19375ok("notify_by_package", m18754ok, c11998a);
        } else if (type != 4) {
            C12235bl.m18640ok().m18643a("AppLinkClickNotification default");
        } else {
            m19376ok("notify_by_package", m18678ok, m18754ok, c11998a);
        }
    }

    /* renamed from: a */
    public static void m19384a(String str, @NonNull C12031h c12031h, @NonNull JSONObject jSONObject, @NonNull InterfaceC11999ok interfaceC11999ok) {
        C12197j.m18778ok(jSONObject, "applink_source", str);
        C12197j.m18778ok(jSONObject, "error_code", Integer.valueOf(c12031h.m19334ok()));
        C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(interfaceC11999ok.mo19290u()));
        C12270ok.m18539ok().m18540a("deeplink_url_open_fail", jSONObject, interfaceC11999ok);
    }

    /* renamed from: ok */
    public static boolean m19377ok(String str, @NonNull C11998a c11998a) {
        if (C12127q.m18980a(c11998a.m19481l())) {
            if (TextUtils.isEmpty(c11998a.mo19302kf()) && TextUtils.isEmpty(str)) {
                return false;
            }
            C12644a.m16876ok().m16878kf(c11998a.mo19285zz());
            JSONObject jSONObject = new JSONObject();
            C12200kf.m18754ok(jSONObject, c11998a);
            C12197j.m18778ok(jSONObject, "applink_source", "auto_click");
            C12270ok.m18539ok().m18541a("applink_click", c11998a);
            C12031h m18679ok = C12215q.m18679ok(c11998a, c11998a.mo19302kf(), c11998a.mo19300n());
            int type = m18679ok.getType();
            if (type == 1) {
                m19383a("auto_by_url", jSONObject, c11998a);
                return true;
            } else if (type == 2) {
                m19384a("auto_by_url", m18679ok, jSONObject, c11998a);
                return false;
            } else if (type == 3) {
                m19375ok("auto_by_package", jSONObject, c11998a);
                return true;
            } else if (type != 4) {
                return false;
            } else {
                m19376ok("auto_by_package", m18679ok, jSONObject, c11998a);
                return false;
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static void m19375ok(String str, @NonNull final JSONObject jSONObject, @NonNull final InterfaceC11999ok interfaceC11999ok) {
        C12197j.m18778ok(jSONObject, "applink_source", str);
        C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(interfaceC11999ok.mo19290u()));
        C12270ok.m18539ok().m18540a("deeplink_app_open", jSONObject, interfaceC11999ok);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1282070764:
                if (str.equals("notify_by_package")) {
                    c = 0;
                    break;
                }
                break;
            case -441514770:
                if (str.equals("auto_by_package")) {
                    c = 1;
                    break;
                }
                break;
            case -185950114:
                if (str.equals("by_package")) {
                    c = 2;
                    break;
                }
                break;
            case 368401333:
                if (str.equals("dialog_by_package")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                if ((C12128r.m18946q().optInt("check_applink_mode") & 1) != 0) {
                    C12197j.m18778ok(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    C12015n.m19390ok().m19388ok(new InterfaceC12024s() { // from class: com.ss.android.downloadlib.a.ok.1
                        @Override // com.p521ss.android.downloadlib.p527a.InterfaceC12024s
                        /* renamed from: ok */
                        public void mo18606ok(boolean z) {
                            C12270ok.m18539ok().m18540a(z ? "deeplink_success" : "deeplink_failed", jSONObject, interfaceC11999ok);
                            if (z) {
                                C12128r.m18965io().mo18932ok(C12128r.getContext(), interfaceC11999ok.mo19305io(), interfaceC11999ok.mo19299o(), interfaceC11999ok.mo19289ul(), interfaceC11999ok.mo19300n(), 0);
                            }
                        }
                    });
                    return;
                }
                C12128r.m18970a().mo18934ok(C12128r.getContext(), interfaceC11999ok.mo19305io(), interfaceC11999ok.mo19299o(), interfaceC11999ok.mo19289ul(), interfaceC11999ok.mo19300n(), str);
                return;
            default:
                return;
        }
    }

    /* renamed from: ok */
    public static void m19376ok(String str, @NonNull C12031h c12031h, @NonNull JSONObject jSONObject, @NonNull InterfaceC11999ok interfaceC11999ok) {
        C12197j.m18778ok(jSONObject, "applink_source", str);
        C12197j.m18778ok(jSONObject, "error_code", Integer.valueOf(c12031h.m19334ok()));
        C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(interfaceC11999ok.mo19290u()));
        C12270ok.m18539ok().m18540a("deeplink_app_open_fail", jSONObject, interfaceC11999ok);
    }

    /* renamed from: ok */
    public static boolean m19378ok(@NonNull C12035n c12035n, int i) {
        JSONObject jSONObject = new JSONObject();
        C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(c12035n.mo19290u()));
        C12270ok.m18539ok().m18540a("market_click_open", jSONObject, c12035n);
        C12031h m18682ok = C12215q.m18682ok(C12128r.getContext(), c12035n, c12035n.f34076a.getPackageName());
        String m18774ok = C12197j.m18774ok(m18682ok.m19335a(), "open_market");
        int type = m18682ok.getType();
        if (type == 5) {
            m19374ok(m18774ok, jSONObject, c12035n, true);
        } else if (type == 6) {
            C12197j.m18778ok(jSONObject, "error_code", Integer.valueOf(m18682ok.m19334ok()));
            C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(c12035n.mo19290u()));
            C12270ok.m18539ok().m18540a("market_open_failed", jSONObject, c12035n);
            return false;
        } else if (type != 7) {
            return false;
        }
        C12270ok.m18539ok().m18537ok(c12035n.f34079ok, i);
        return true;
    }

    /* renamed from: ok */
    public static void m19374ok(final String str, @Nullable final JSONObject jSONObject, final C12035n c12035n, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                C12235bl.m18640ok().mo18637ok(e, "onMarketSuccess");
                return;
            }
        }
        C12197j.m18778ok(jSONObject, "applink_source", str);
        C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(c12035n.mo19290u()));
        if (z) {
            C12270ok.m18539ok().m18540a("market_open_success", jSONObject, c12035n);
        }
        if ((C12128r.m18946q().optInt("check_applink_mode") & 4) != 0) {
            C12015n.m19390ok().m19391a(new InterfaceC12024s() { // from class: com.ss.android.downloadlib.a.ok.3
                @Override // com.p521ss.android.downloadlib.p527a.InterfaceC12024s
                /* renamed from: ok */
                public void mo18606ok(boolean z2) {
                    if (!z2 && !"open_market".equals(str)) {
                        Context context = C12128r.getContext();
                        C12018ok.m19380ok(C12215q.m18683ok(context, Uri.parse("market://details?id=" + c12035n.mo19300n())), c12035n, false);
                    }
                    C12270ok.m18539ok().m18521ok(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, c12035n);
                    if (z2) {
                        InterfaceC11973zz m18965io = C12128r.m18965io();
                        Context context2 = C12128r.getContext();
                        C12035n c12035n2 = c12035n;
                        DownloadModel downloadModel = c12035n2.f34076a;
                        m18965io.mo18932ok(context2, downloadModel, c12035n2.f34080s, c12035n2.f34077bl, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            InterfaceC11954bl m18970a = C12128r.m18970a();
            Context context = C12128r.getContext();
            DownloadModel downloadModel = c12035n.f34076a;
            m18970a.mo18934ok(context, downloadModel, c12035n.f34080s, c12035n.f34077bl, downloadModel.getPackageName(), str);
        }
        C11998a c11998a = new C11998a(c12035n.f34076a, c12035n.f34077bl, c12035n.f34080s);
        c11998a.m19478n(2);
        c11998a.m19485kf(System.currentTimeMillis());
        c11998a.m19469p(4);
        c11998a.m19465q(2);
        C12032kf.m19324ok().m19318ok(c11998a);
    }

    /* renamed from: ok */
    public static void m19380ok(C12031h c12031h, C12035n c12035n, boolean z) {
        String m18774ok = C12197j.m18774ok(c12031h.m19335a(), "open_market");
        JSONObject jSONObject = new JSONObject();
        C12197j.m18778ok(jSONObject, "ttdownloader_type", "backup");
        int type = c12031h.getType();
        if (type == 5) {
            m19374ok(m18774ok, jSONObject, c12035n, z);
        } else if (type != 6) {
        } else {
            C12197j.m18778ok(jSONObject, "error_code", Integer.valueOf(c12031h.m19334ok()));
            C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(c12035n.mo19290u()));
            C12270ok.m18539ok().m18540a("market_open_failed", jSONObject, c12035n);
        }
    }

    /* renamed from: ok */
    public static boolean m19382ok(long j) {
        return C12032kf.m19324ok().m19311s(j) == null;
    }
}
