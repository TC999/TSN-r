package com.ss.android.downloadlib.w;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.ss.android.download.api.config.fz;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.r.a;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {
    public static boolean c(@NonNull com.ss.android.downloadlib.addownload.w.ux uxVar) {
        boolean z3;
        DeepLink deepLink = uxVar.f48723w.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject c4 = com.ss.android.downloadlib.r.f.c(new JSONObject(), uxVar);
        a.c(c4, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.sr.c.c().w("applink_click", c4, uxVar);
        com.ss.android.downloadlib.addownload.w.r c5 = com.ss.android.downloadlib.r.gd.c(openUrl, uxVar);
        if (c5.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                w("by_url", c5, c4, uxVar);
            }
            c5 = com.ss.android.downloadlib.r.gd.c(k.getContext(), uxVar.f48723w.getPackageName(), uxVar);
        }
        boolean z4 = false;
        if (c(uxVar.f48722c) && k.gd().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = uxVar.f48723w;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.sr.c.c().c(uxVar.f48722c, 0);
            z3 = true;
        } else {
            z3 = false;
        }
        int type = c5.getType();
        if (type == 1) {
            w("by_url", c4, uxVar);
        } else if (type == 3) {
            c("by_package", c4, uxVar);
        } else {
            if (type != 4) {
                com.ss.android.downloadlib.ux.xv.c().w("AppLinkClick default");
            } else {
                c("by_package", c5, c4, uxVar);
            }
            if (z4 && !z3 && ((com.ss.android.downloadlib.sr.xv.c().w() && !com.ss.android.downloadlib.sr.xv.c().w(uxVar.f48722c, uxVar.f48723w.getLogExtra())) || com.ss.android.downloadlib.sr.xv.c().xv())) {
                com.ss.android.downloadlib.sr.c.c().c(uxVar.f48722c, 2);
            }
            return z4;
        }
        z4 = true;
        if (z4) {
            com.ss.android.downloadlib.sr.c.c().c(uxVar.f48722c, 2);
        }
        return z4;
    }

    public static void w(com.ss.android.downloadad.api.c.w wVar) {
        if (wVar == null) {
            return;
        }
        String f4 = com.ss.android.socialbase.downloader.r.c.xv().w("app_link_opt") == 1 ? wVar.f() : null;
        JSONObject c4 = com.ss.android.downloadlib.r.f.c(new JSONObject(), wVar);
        a.c(c4, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.sr.c.c().w("applink_click", c4, wVar);
        com.ss.android.downloadlib.addownload.w.r c5 = com.ss.android.downloadlib.r.gd.c(f4, wVar);
        if (c5.getType() == 2) {
            if (!TextUtils.isEmpty(f4)) {
                w("dialog_by_url", c5, c4, wVar);
            }
            c5 = com.ss.android.downloadlib.r.gd.c(k.getContext(), wVar.ux(), wVar);
        }
        int type = c5.getType();
        if (type == 1) {
            w("dialog_by_url", c4, wVar);
        } else if (type == 3) {
            c("dialog_by_package", c4, wVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.ux.xv.c().w("AppLinkClickDialog default");
        } else {
            c("dialog_by_package", c5, c4, wVar);
        }
    }

    public static void w(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.c.c cVar) {
        a.c(jSONObject, "applink_source", str);
        a.c(jSONObject, "download_scene", Integer.valueOf(cVar.u()));
        com.ss.android.downloadlib.sr.c.c().w("deeplink_url_open", jSONObject, cVar);
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
                if ((k.gd().optInt("check_applink_mode") & 1) != 0) {
                    a.c(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    ux.c().c(new sr() { // from class: com.ss.android.downloadlib.w.c.2
                        @Override // com.ss.android.downloadlib.w.sr
                        public void c(boolean z3) {
                            com.ss.android.downloadlib.sr.c.c().w(z3 ? "deeplink_success" : "deeplink_failed", jSONObject, cVar);
                            if (z3) {
                                k.i().c(k.getContext(), cVar.i(), cVar.j(), cVar.q(), cVar.ux(), 0);
                            }
                        }
                    });
                    return;
                }
                k.w().c(k.getContext(), cVar.i(), cVar.j(), cVar.q(), cVar.ux(), str);
                return;
            default:
                return;
        }
    }

    public static void c(@NonNull com.ss.android.downloadad.api.c.w wVar) {
        String f4 = wVar.f();
        JSONObject c4 = com.ss.android.downloadlib.r.f.c(new JSONObject(), wVar);
        a.c(c4, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.sr.c.c().w("applink_click", c4, wVar);
        com.ss.android.downloadlib.addownload.w.r c5 = com.ss.android.downloadlib.r.gd.c(f4, wVar);
        if (c5.getType() == 2) {
            if (!TextUtils.isEmpty(f4)) {
                w("notify_by_url", c5, c4, wVar);
            }
            c5 = com.ss.android.downloadlib.r.gd.c(k.getContext(), wVar.ux(), wVar);
        }
        int type = c5.getType();
        if (type == 1) {
            w("notify_by_url", c4, wVar);
        } else if (type == 3) {
            c("notify_by_package", c4, wVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.ux.xv.c().w("AppLinkClickNotification default");
        } else {
            c("notify_by_package", c5, c4, wVar);
        }
    }

    public static void w(String str, @NonNull com.ss.android.downloadlib.addownload.w.r rVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.c.c cVar) {
        a.c(jSONObject, "applink_source", str);
        a.c(jSONObject, "error_code", Integer.valueOf(rVar.c()));
        a.c(jSONObject, "download_scene", Integer.valueOf(cVar.u()));
        com.ss.android.downloadlib.sr.c.c().w("deeplink_url_open_fail", jSONObject, cVar);
    }

    public static boolean c(String str, @NonNull com.ss.android.downloadad.api.c.w wVar) {
        if (com.ss.android.downloadlib.addownload.gd.w(wVar.gw())) {
            if (TextUtils.isEmpty(wVar.f()) && TextUtils.isEmpty(str)) {
                return false;
            }
            com.ss.android.socialbase.downloader.notification.w.c().f(wVar.fz());
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.r.f.c(jSONObject, wVar);
            a.c(jSONObject, "applink_source", "auto_click");
            com.ss.android.downloadlib.sr.c.c().w("applink_click", wVar);
            com.ss.android.downloadlib.addownload.w.r c4 = com.ss.android.downloadlib.r.gd.c(wVar, wVar.f(), wVar.ux());
            int type = c4.getType();
            if (type == 1) {
                w("auto_by_url", jSONObject, wVar);
                return true;
            } else if (type == 2) {
                w("auto_by_url", c4, jSONObject, wVar);
                return false;
            } else if (type == 3) {
                c("auto_by_package", jSONObject, wVar);
                return true;
            } else if (type != 4) {
                return false;
            } else {
                c("auto_by_package", c4, jSONObject, wVar);
                return false;
            }
        }
        return false;
    }

    public static void c(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.c.c cVar) {
        a.c(jSONObject, "applink_source", str);
        a.c(jSONObject, "download_scene", Integer.valueOf(cVar.u()));
        com.ss.android.downloadlib.sr.c.c().w("deeplink_app_open", jSONObject, cVar);
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
                if ((k.gd().optInt("check_applink_mode") & 1) != 0) {
                    a.c(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    ux.c().c(new sr() { // from class: com.ss.android.downloadlib.w.c.1
                        @Override // com.ss.android.downloadlib.w.sr
                        public void c(boolean z3) {
                            com.ss.android.downloadlib.sr.c.c().w(z3 ? "deeplink_success" : "deeplink_failed", jSONObject, cVar);
                            if (z3) {
                                k.i().c(k.getContext(), cVar.i(), cVar.j(), cVar.q(), cVar.ux(), 0);
                            }
                        }
                    });
                    return;
                }
                k.w().c(k.getContext(), cVar.i(), cVar.j(), cVar.q(), cVar.ux(), str);
                return;
            default:
                return;
        }
    }

    public static void c(String str, @NonNull com.ss.android.downloadlib.addownload.w.r rVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.c.c cVar) {
        a.c(jSONObject, "applink_source", str);
        a.c(jSONObject, "error_code", Integer.valueOf(rVar.c()));
        a.c(jSONObject, "download_scene", Integer.valueOf(cVar.u()));
        com.ss.android.downloadlib.sr.c.c().w("deeplink_app_open_fail", jSONObject, cVar);
    }

    public static boolean c(@NonNull com.ss.android.downloadlib.addownload.w.ux uxVar, int i4) {
        JSONObject jSONObject = new JSONObject();
        a.c(jSONObject, "download_scene", Integer.valueOf(uxVar.u()));
        com.ss.android.downloadlib.sr.c.c().w("market_click_open", jSONObject, uxVar);
        com.ss.android.downloadlib.addownload.w.r c4 = com.ss.android.downloadlib.r.gd.c(k.getContext(), uxVar, uxVar.f48723w.getPackageName());
        String c5 = a.c(c4.w(), "open_market");
        int type = c4.getType();
        if (type == 5) {
            c(c5, jSONObject, uxVar, true);
        } else if (type == 6) {
            a.c(jSONObject, "error_code", Integer.valueOf(c4.c()));
            a.c(jSONObject, "download_scene", Integer.valueOf(uxVar.u()));
            com.ss.android.downloadlib.sr.c.c().w("market_open_failed", jSONObject, uxVar);
            return false;
        } else if (type != 7) {
            return false;
        }
        com.ss.android.downloadlib.sr.c.c().c(uxVar.f48722c, i4);
        return true;
    }

    public static void c(final String str, @Nullable final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.w.ux uxVar, boolean z3) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e4) {
                com.ss.android.downloadlib.ux.xv.c().c(e4, "onMarketSuccess");
                return;
            }
        }
        a.c(jSONObject, "applink_source", str);
        a.c(jSONObject, "download_scene", Integer.valueOf(uxVar.u()));
        if (z3) {
            com.ss.android.downloadlib.sr.c.c().w("market_open_success", jSONObject, uxVar);
        }
        if ((k.gd().optInt("check_applink_mode") & 4) != 0) {
            ux.c().w(new sr() { // from class: com.ss.android.downloadlib.w.c.3
                @Override // com.ss.android.downloadlib.w.sr
                public void c(boolean z4) {
                    if (!z4 && !"open_market".equals(str)) {
                        Context context = k.getContext();
                        c.c(com.ss.android.downloadlib.r.gd.c(context, Uri.parse("market://details?id=" + uxVar.ux())), uxVar, false);
                    }
                    com.ss.android.downloadlib.sr.c.c().c(z4 ? "market_delay_success" : "market_delay_failed", jSONObject, uxVar);
                    if (z4) {
                        fz i4 = k.i();
                        Context context2 = k.getContext();
                        com.ss.android.downloadlib.addownload.w.ux uxVar2 = uxVar;
                        DownloadModel downloadModel = uxVar2.f48723w;
                        i4.c(context2, downloadModel, uxVar2.sr, uxVar2.xv, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.ss.android.download.api.config.xv w3 = k.w();
            Context context = k.getContext();
            DownloadModel downloadModel = uxVar.f48723w;
            w3.c(context, downloadModel, uxVar.sr, uxVar.xv, downloadModel.getPackageName(), str);
        }
        com.ss.android.downloadad.api.c.w wVar = new com.ss.android.downloadad.api.c.w(uxVar.f48723w, uxVar.xv, uxVar.sr);
        wVar.ux(2);
        wVar.f(System.currentTimeMillis());
        wVar.ev(4);
        wVar.gd(2);
        com.ss.android.downloadlib.addownload.w.f.c().c(wVar);
    }

    public static void c(com.ss.android.downloadlib.addownload.w.r rVar, com.ss.android.downloadlib.addownload.w.ux uxVar, boolean z3) {
        String c4 = a.c(rVar.w(), "open_market");
        JSONObject jSONObject = new JSONObject();
        a.c(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        int type = rVar.getType();
        if (type == 5) {
            c(c4, jSONObject, uxVar, z3);
        } else if (type != 6) {
        } else {
            a.c(jSONObject, "error_code", Integer.valueOf(rVar.c()));
            a.c(jSONObject, "download_scene", Integer.valueOf(uxVar.u()));
            com.ss.android.downloadlib.sr.c.c().w("market_open_failed", jSONObject, uxVar);
        }
    }

    public static boolean c(long j4) {
        return com.ss.android.downloadlib.addownload.w.f.c().sr(j4) == null;
    }
}
