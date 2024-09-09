package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class pr {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f34485c;

    public static void c(boolean z3) {
        f34485c = z3;
    }

    private static boolean w(String str) {
        return !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page");
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.w.c.c.ux uxVar, String str, boolean z3, boolean z4) {
        String pu;
        boolean z5 = false;
        if (uxVar == null) {
            return false;
        }
        Context context = uxVar.getContext();
        com.bytedance.sdk.openadsdk.core.u.me w3 = uxVar.w();
        int gd = uxVar.gd();
        Object bk = uxVar.bk();
        com.bytedance.sdk.openadsdk.core.p.w.xv ev = uxVar.ev();
        Map<String, Object> p3 = uxVar.p();
        boolean a4 = uxVar.a();
        if (context == null || w3 == null || gd == -1) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.u.ys qu = w3.qu();
        if (c(str) && !w(str) && !z3 && qu == null && TTMiddlePageActivity.c(context, w3)) {
            return false;
        }
        if (uxVar.s() == null || !uxVar.s().c()) {
            if (com.bytedance.sdk.openadsdk.core.u.wx.y(w3) && z4 && c(w3, bk)) {
                z5 = true;
            }
            if (qu != null && !z5) {
                com.bytedance.sdk.openadsdk.core.p.w wVar = new com.bytedance.sdk.openadsdk.core.p.w(w3, str, context);
                Boolean c4 = wVar.c(gd, p3);
                if (c4 != null) {
                    return c4.booleanValue();
                }
                if (wVar.c(ev, z3)) {
                    return true;
                }
                pu = wVar.c();
            } else {
                pu = w3.pu();
            }
            return c(context, w3, gd, bk, str, p3, a4, z4, pu);
        }
        return true;
    }

    private static boolean c(Context context, com.bytedance.sdk.openadsdk.core.u.me meVar, int i4, Object obj, String str, Map<String, Object> map, boolean z3, boolean z4, String str2) {
        if (z4 && c(meVar, obj)) {
            com.bytedance.sdk.component.utils.w.c(context, c(context, meVar, i4, str, obj), null);
            f34485c = false;
            return true;
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        } else {
            if (meVar.v() != 2) {
                com.bytedance.sdk.component.utils.w.c(context, c(context, str2, meVar, i4, obj, str, map, z3), null);
                f34485c = false;
                return true;
            } else if (com.bytedance.sdk.component.utils.ys.c(str2)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                try {
                    intent.setData(Uri.parse(str2));
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    com.bytedance.sdk.component.utils.w.c(context, intent, null);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static boolean c(Context context, String str, com.bytedance.sdk.openadsdk.core.u.me meVar, int i4, String str2, Map<String, Object> map) {
        try {
            return com.bytedance.sdk.component.utils.w.c(context, c(context, str, meVar, i4, null, str2, map, false), null);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("embeded_ad") || str.equals("embeded_ad_landingpage");
    }

    private static boolean c(Object obj) {
        if (obj != null && (obj instanceof c.InterfaceC0499c)) {
            try {
                return ((c.InterfaceC0499c) obj).ba();
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private static Intent c(Context context, String str, com.bytedance.sdk.openadsdk.core.u.me meVar, int i4, Object obj, String str2, Map<String, Object> map, boolean z3) {
        Intent intent;
        Intent intent2;
        if (obj instanceof com.bytedance.sdk.openadsdk.ys.w.w.p) {
            if (com.bytedance.sdk.openadsdk.core.ugeno.f.f(meVar)) {
                intent = new Intent(context, TTNativePageActivity.class);
            } else {
                intent = new Intent(context, TTWebPageActivity.class);
            }
        } else if (com.bytedance.sdk.openadsdk.core.u.me.w(meVar) && !f34485c && !c(obj) && com.bytedance.sdk.openadsdk.core.eq.wv.xv(meVar) && !meVar.xv()) {
            if (com.bytedance.sdk.openadsdk.core.ugeno.f.f(meVar)) {
                intent2 = new Intent(context, TTNativePageActivity.class);
            } else {
                intent2 = new Intent(context, TTVideoWebPageActivity.class);
            }
            c(context, meVar, obj, map, z3, intent2);
            intent = intent2;
        } else if (com.bytedance.sdk.openadsdk.core.ugeno.f.f(meVar)) {
            intent = new Intent(context, TTNativePageActivity.class);
        } else {
            intent = new Intent(context, TTWebPageActivity.class);
        }
        c(context, str, meVar, i4, str2, intent);
        return intent;
    }

    private static Intent c(Context context, com.bytedance.sdk.openadsdk.core.u.me meVar, int i4, String str, Object obj) {
        com.bytedance.sdk.openadsdk.core.multipro.w.c p3;
        Intent intent = new Intent(context, TTPlayableWebPageActivity.class);
        if (com.bytedance.sdk.openadsdk.core.u.me.w(meVar)) {
            if (obj != null) {
                com.bytedance.sdk.openadsdk.core.multipro.w.c eq = obj instanceof c.InterfaceC0499c ? ((c.InterfaceC0499c) obj).eq() : null;
                if (eq != null) {
                    intent.putExtra("multi_process_data", eq.c().toString());
                }
            }
            if ((obj instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.w) && (p3 = ((com.bytedance.sdk.openadsdk.core.nativeexpress.w) obj).p()) != null) {
                intent.putExtra("multi_process_data", p3.c().toString());
            }
        }
        c(context, com.bytedance.sdk.openadsdk.core.eq.u.w(meVar), meVar, i4, str, intent);
        return intent;
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.u.me meVar, Object obj) {
        return com.bytedance.sdk.openadsdk.core.eq.u.sr(meVar) && !(obj == null && meVar.yx() == 100.0f) && com.bytedance.sdk.openadsdk.core.u.wx.i(meVar);
    }

    private static void c(Context context, com.bytedance.sdk.openadsdk.core.u.me meVar, Object obj, Map<String, Object> map, boolean z3, Intent intent) {
        int i4;
        if (com.bytedance.sdk.openadsdk.core.u.me.w(meVar)) {
            if (obj != null) {
                r1 = obj instanceof c.InterfaceC0499c ? ((c.InterfaceC0499c) obj).eq() : null;
                if (r1 != null) {
                    intent.putExtra("multi_process_data", r1.c().toString());
                }
            }
            if ((obj instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.w) && (r1 = ((com.bytedance.sdk.openadsdk.core.nativeexpress.w) obj).p()) != null) {
                intent.putExtra("multi_process_data", r1.c().toString());
            }
            if (r1 != null) {
                intent.putExtra("video_is_auto_play", r1.sr);
                com.bytedance.sdk.component.utils.a.xv("videoDataModel", "videoDataModel=" + r1.c().toString());
            }
            if (TTVideoWebPageActivity.c(intent)) {
                if (r1 != null || z3) {
                    try {
                        if (r1 != null) {
                            i4 = (int) ((((float) r1.f33979r) / ((float) r1.ux)) * 100.0f);
                        } else {
                            i4 = 100;
                            com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = new com.bytedance.sdk.openadsdk.core.multipro.w.c();
                            cVar.f33979r = 100L;
                            cVar.f33977c = true;
                            cVar.sr = com.bytedance.sdk.openadsdk.core.eq.wv.s(meVar);
                            intent.putExtra("multi_process_data", cVar.c().toString());
                        }
                        if (map == null) {
                            map = new HashMap<>();
                        }
                        map.put("play_percent", Integer.valueOf(i4));
                        if (meVar.pb() == 0) {
                            intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                        } else if (meVar.pb() <= 0 || i4 <= meVar.pb() || !com.bytedance.sdk.openadsdk.core.eq.wv.s(meVar)) {
                        } else {
                            intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private static void c(Context context, String str, com.bytedance.sdk.openadsdk.core.u.me meVar, int i4, String str2, Intent intent) {
        if (!new com.bytedance.sdk.openadsdk.core.p.xv.xv.xv(context, meVar).c()) {
            meVar.c(true);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", meVar.jd());
        intent.putExtra("title", meVar.ny());
        intent.putExtra("sdk_version", eq.f33190w);
        intent.putExtra("ad_id", meVar.jr());
        intent.putExtra("log_extra", meVar.cf());
        intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, meVar.kr() == null ? null : meVar.kr().c());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i4);
        intent.putExtra("is_outer_click", true);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.bytedance.sdk.openadsdk.core.eq.wv.c(intent, meVar);
    }

    public static boolean c(Context context, com.bytedance.sdk.openadsdk.core.u.me meVar, int i4, String str, String str2) {
        try {
            Intent intent = new Intent(context, TTNativePageActivity.class);
            intent.putExtra("is_replace_dialog", true);
            c(context, (String) null, meVar, i4, str, intent);
            if (com.bytedance.sdk.openadsdk.core.u.me.w(meVar) && !TextUtils.isEmpty(str2)) {
                intent.putExtra("multi_process_data", str2);
            }
            return com.bytedance.sdk.component.utils.w.c(context, intent, null);
        } catch (Throwable unused) {
            return false;
        }
    }
}
