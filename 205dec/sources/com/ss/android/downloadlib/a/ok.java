package com.ss.android.downloadlib.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.ss.android.download.api.config.zz;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {
    public static void a(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return;
        }
        String kf = com.ss.android.socialbase.downloader.h.ok.bl().a("app_link_opt") == 1 ? aVar.kf() : null;
        JSONObject ok = com.ss.android.downloadlib.h.kf.ok(new JSONObject(), aVar);
        j.ok(ok, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.s.ok.ok().a("applink_click", ok, aVar);
        com.ss.android.downloadlib.addownload.a.h ok2 = com.ss.android.downloadlib.h.q.ok(kf, aVar);
        if (ok2.getType() == 2) {
            if (!TextUtils.isEmpty(kf)) {
                a("dialog_by_url", ok2, ok, aVar);
            }
            ok2 = com.ss.android.downloadlib.h.q.ok(r.getContext(), aVar.n(), aVar);
        }
        int type = ok2.getType();
        if (type == 1) {
            a("dialog_by_url", ok, aVar);
        } else if (type == 3) {
            ok("dialog_by_package", ok, aVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.n.bl.ok().a("AppLinkClickDialog default");
        } else {
            ok("dialog_by_package", ok2, ok, aVar);
        }
    }

    public static boolean ok(@NonNull com.ss.android.downloadlib.addownload.a.n nVar) {
        boolean z3;
        DeepLink deepLink = nVar.f48371a.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject ok = com.ss.android.downloadlib.h.kf.ok(new JSONObject(), nVar);
        j.ok(ok, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.s.ok.ok().a("applink_click", ok, nVar);
        com.ss.android.downloadlib.addownload.a.h ok2 = com.ss.android.downloadlib.h.q.ok(openUrl, nVar);
        if (ok2.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                a("by_url", ok2, ok, nVar);
            }
            ok2 = com.ss.android.downloadlib.h.q.ok(r.getContext(), nVar.f48371a.getPackageName(), nVar);
        }
        boolean z4 = false;
        if (ok(nVar.ok) && r.q().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = nVar.f48371a;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.s.ok.ok().ok(nVar.ok, 0);
            z3 = true;
        } else {
            z3 = false;
        }
        int type = ok2.getType();
        if (type == 1) {
            a("by_url", ok, nVar);
        } else if (type == 3) {
            ok("by_package", ok, nVar);
        } else {
            if (type != 4) {
                com.ss.android.downloadlib.n.bl.ok().a("AppLinkClick default");
            } else {
                ok("by_package", ok2, ok, nVar);
            }
            if (z4 && !z3 && ((com.ss.android.downloadlib.s.bl.ok().a() && !com.ss.android.downloadlib.s.bl.ok().a(nVar.ok, nVar.f48371a.getLogExtra())) || com.ss.android.downloadlib.s.bl.ok().bl())) {
                com.ss.android.downloadlib.s.ok.ok().ok(nVar.ok, 2);
            }
            return z4;
        }
        z4 = true;
        if (z4) {
            com.ss.android.downloadlib.s.ok.ok().ok(nVar.ok, 2);
        }
        return z4;
    }

    public static void a(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "download_scene", Integer.valueOf(okVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("deeplink_url_open", jSONObject, okVar);
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1721882089:
                if (str.equals("auto_by_url")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1374618233:
                if (str.equals("by_url")) {
                    c4 = 1;
                    break;
                }
                break;
            case -129544387:
                if (str.equals("notify_by_url")) {
                    c4 = 2;
                    break;
                }
                break;
            case 829750366:
                if (str.equals("dialog_by_url")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
                if ((r.q().optInt("check_applink_mode") & 1) != 0) {
                    j.ok(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    n.ok().ok(new s() { // from class: com.ss.android.downloadlib.a.ok.2
                        @Override // com.ss.android.downloadlib.a.s
                        public void ok(boolean z3) {
                            com.ss.android.downloadlib.s.ok.ok().a(z3 ? "deeplink_success" : "deeplink_failed", jSONObject, okVar);
                            if (z3) {
                                r.io().ok(r.getContext(), okVar.io(), okVar.o(), okVar.ul(), okVar.n(), 0);
                            }
                        }
                    });
                    return;
                }
                r.a().ok(r.getContext(), okVar.io(), okVar.o(), okVar.ul(), okVar.n(), str);
                return;
            default:
                return;
        }
    }

    public static void ok(@NonNull com.ss.android.downloadad.api.ok.a aVar) {
        String kf = aVar.kf();
        JSONObject ok = com.ss.android.downloadlib.h.kf.ok(new JSONObject(), aVar);
        j.ok(ok, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.s.ok.ok().a("applink_click", ok, aVar);
        com.ss.android.downloadlib.addownload.a.h ok2 = com.ss.android.downloadlib.h.q.ok(kf, aVar);
        if (ok2.getType() == 2) {
            if (!TextUtils.isEmpty(kf)) {
                a("notify_by_url", ok2, ok, aVar);
            }
            ok2 = com.ss.android.downloadlib.h.q.ok(r.getContext(), aVar.n(), aVar);
        }
        int type = ok2.getType();
        if (type == 1) {
            a("notify_by_url", ok, aVar);
        } else if (type == 3) {
            ok("notify_by_package", ok, aVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.n.bl.ok().a("AppLinkClickNotification default");
        } else {
            ok("notify_by_package", ok2, ok, aVar);
        }
    }

    public static void a(String str, @NonNull com.ss.android.downloadlib.addownload.a.h hVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "error_code", Integer.valueOf(hVar.ok()));
        j.ok(jSONObject, "download_scene", Integer.valueOf(okVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("deeplink_url_open_fail", jSONObject, okVar);
    }

    public static boolean ok(String str, @NonNull com.ss.android.downloadad.api.ok.a aVar) {
        if (com.ss.android.downloadlib.addownload.q.a(aVar.l())) {
            if (TextUtils.isEmpty(aVar.kf()) && TextUtils.isEmpty(str)) {
                return false;
            }
            com.ss.android.socialbase.downloader.notification.a.ok().kf(aVar.zz());
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.h.kf.ok(jSONObject, aVar);
            j.ok(jSONObject, "applink_source", "auto_click");
            com.ss.android.downloadlib.s.ok.ok().a("applink_click", aVar);
            com.ss.android.downloadlib.addownload.a.h ok = com.ss.android.downloadlib.h.q.ok(aVar, aVar.kf(), aVar.n());
            int type = ok.getType();
            if (type == 1) {
                a("auto_by_url", jSONObject, aVar);
                return true;
            } else if (type == 2) {
                a("auto_by_url", ok, jSONObject, aVar);
                return false;
            } else if (type == 3) {
                ok("auto_by_package", jSONObject, aVar);
                return true;
            } else if (type != 4) {
                return false;
            } else {
                ok("auto_by_package", ok, jSONObject, aVar);
                return false;
            }
        }
        return false;
    }

    public static void ok(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "download_scene", Integer.valueOf(okVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("deeplink_app_open", jSONObject, okVar);
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1282070764:
                if (str.equals("notify_by_package")) {
                    c4 = 0;
                    break;
                }
                break;
            case -441514770:
                if (str.equals("auto_by_package")) {
                    c4 = 1;
                    break;
                }
                break;
            case -185950114:
                if (str.equals("by_package")) {
                    c4 = 2;
                    break;
                }
                break;
            case 368401333:
                if (str.equals("dialog_by_package")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
                if ((r.q().optInt("check_applink_mode") & 1) != 0) {
                    j.ok(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    n.ok().ok(new s() { // from class: com.ss.android.downloadlib.a.ok.1
                        @Override // com.ss.android.downloadlib.a.s
                        public void ok(boolean z3) {
                            com.ss.android.downloadlib.s.ok.ok().a(z3 ? "deeplink_success" : "deeplink_failed", jSONObject, okVar);
                            if (z3) {
                                r.io().ok(r.getContext(), okVar.io(), okVar.o(), okVar.ul(), okVar.n(), 0);
                            }
                        }
                    });
                    return;
                }
                r.a().ok(r.getContext(), okVar.io(), okVar.o(), okVar.ul(), okVar.n(), str);
                return;
            default:
                return;
        }
    }

    public static void ok(String str, @NonNull com.ss.android.downloadlib.addownload.a.h hVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "error_code", Integer.valueOf(hVar.ok()));
        j.ok(jSONObject, "download_scene", Integer.valueOf(okVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("deeplink_app_open_fail", jSONObject, okVar);
    }

    public static boolean ok(@NonNull com.ss.android.downloadlib.addownload.a.n nVar, int i4) {
        JSONObject jSONObject = new JSONObject();
        j.ok(jSONObject, "download_scene", Integer.valueOf(nVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("market_click_open", jSONObject, nVar);
        com.ss.android.downloadlib.addownload.a.h ok = com.ss.android.downloadlib.h.q.ok(r.getContext(), nVar, nVar.f48371a.getPackageName());
        String ok2 = j.ok(ok.a(), "open_market");
        int type = ok.getType();
        if (type == 5) {
            ok(ok2, jSONObject, nVar, true);
        } else if (type == 6) {
            j.ok(jSONObject, "error_code", Integer.valueOf(ok.ok()));
            j.ok(jSONObject, "download_scene", Integer.valueOf(nVar.u()));
            com.ss.android.downloadlib.s.ok.ok().a("market_open_failed", jSONObject, nVar);
            return false;
        } else if (type != 7) {
            return false;
        }
        com.ss.android.downloadlib.s.ok.ok().ok(nVar.ok, i4);
        return true;
    }

    public static void ok(final String str, @Nullable final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.a.n nVar, boolean z3) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e4) {
                com.ss.android.downloadlib.n.bl.ok().ok(e4, "onMarketSuccess");
                return;
            }
        }
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "download_scene", Integer.valueOf(nVar.u()));
        if (z3) {
            com.ss.android.downloadlib.s.ok.ok().a("market_open_success", jSONObject, nVar);
        }
        if ((r.q().optInt("check_applink_mode") & 4) != 0) {
            n.ok().a(new s() { // from class: com.ss.android.downloadlib.a.ok.3
                @Override // com.ss.android.downloadlib.a.s
                public void ok(boolean z4) {
                    if (!z4 && !"open_market".equals(str)) {
                        Context context = r.getContext();
                        ok.ok(com.ss.android.downloadlib.h.q.ok(context, Uri.parse("market://details?id=" + nVar.n())), nVar, false);
                    }
                    com.ss.android.downloadlib.s.ok.ok().ok(z4 ? "market_delay_success" : "market_delay_failed", jSONObject, nVar);
                    if (z4) {
                        zz io2 = r.io();
                        Context context2 = r.getContext();
                        com.ss.android.downloadlib.addownload.a.n nVar2 = nVar;
                        DownloadModel downloadModel = nVar2.f48371a;
                        io2.ok(context2, downloadModel, nVar2.f48373s, nVar2.bl, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.ss.android.download.api.config.bl a4 = r.a();
            Context context = r.getContext();
            DownloadModel downloadModel = nVar.f48371a;
            a4.ok(context, downloadModel, nVar.f48373s, nVar.bl, downloadModel.getPackageName(), str);
        }
        com.ss.android.downloadad.api.ok.a aVar = new com.ss.android.downloadad.api.ok.a(nVar.f48371a, nVar.bl, nVar.f48373s);
        aVar.n(2);
        aVar.kf(System.currentTimeMillis());
        aVar.p(4);
        aVar.q(2);
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(aVar);
    }

    public static void ok(com.ss.android.downloadlib.addownload.a.h hVar, com.ss.android.downloadlib.addownload.a.n nVar, boolean z3) {
        String ok = j.ok(hVar.a(), "open_market");
        JSONObject jSONObject = new JSONObject();
        j.ok(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        int type = hVar.getType();
        if (type == 5) {
            ok(ok, jSONObject, nVar, z3);
        } else if (type != 6) {
        } else {
            j.ok(jSONObject, "error_code", Integer.valueOf(hVar.ok()));
            j.ok(jSONObject, "download_scene", Integer.valueOf(nVar.u()));
            com.ss.android.downloadlib.s.ok.ok().a("market_open_failed", jSONObject, nVar);
        }
    }

    public static boolean ok(long j4) {
        return com.ss.android.downloadlib.addownload.a.kf.ok().s(j4) == null;
    }
}
