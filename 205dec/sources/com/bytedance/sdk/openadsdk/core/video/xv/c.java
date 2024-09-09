package com.bytedance.sdk.openadsdk.core.video.xv;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.xv;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.z;
import com.bytedance.sdk.openadsdk.n.f;
import com.bytedance.sdk.openadsdk.r.w;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;
import u0.a;
import u0.b;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static void c(final String str, final me meVar, final long j4) {
        f.w(new p("csj_live_log_event") { // from class: com.bytedance.sdk.openadsdk.core.video.xv.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    z ed = meVar.ed();
                    String yw = meVar.yw();
                    if (TextUtils.isEmpty(yw) && ed != null) {
                        yw = ed.w();
                    }
                    if (TextUtils.isEmpty(yw)) {
                        return;
                    }
                    String f4 = ed != null ? ed.f() : null;
                    if (TextUtils.isEmpty(f4)) {
                        f4 = meVar.xq();
                    }
                    JSONObject c4 = a.c(new b().h(Long.parseLong(yw)).b(ed != null ? ed.c() : "").g(f4).e(c.w(wv.ev(meVar))).f(c.c(wv.ev(meVar))).a(ActionType.CLICK).d(j4).c(), c.c(ls.getContext()));
                    c4.put("tob_extra", meVar.cf());
                    r.w(str, c4);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.a.xv("TTLiveVideoUtil", "Throwable : ", th);
                }
            }
        });
    }

    public static EnterFromMerge w(int i4) {
        if (i4 == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION;
        }
        if (i4 == 8) {
            return EnterFromMerge.AD_UNION_INSERT;
        }
        if (i4 == 5) {
            return EnterFromMerge.AD_UNION_FEED;
        }
        if (i4 == 9) {
            return EnterFromMerge.AD_UNION_DRAW;
        }
        return EnterFromMerge.NO_VALUE;
    }

    private static String xv(int i4) {
        return i4 != 120 ? i4 != 160 ? i4 != 240 ? i4 != 320 ? i4 != 480 ? i4 != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    public static Map<String, String> c(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("device_id", i.xv());
        hashMap.put("sdk_version", eq.xv);
        hashMap.put("os", "Android");
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("device_model", i.u());
        hashMap.put("resolution", xk.ux(context) + "x" + xk.sr(context));
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("timezone", String.valueOf(w()));
        hashMap.put("access", ys.r(context));
        hashMap.put("openudid", i.ux());
        hashMap.put("aid", "1371");
        hashMap.put("display_name", com.bytedance.sdk.openadsdk.core.r.c.ux());
        hashMap.put("app_version", com.bytedance.sdk.openadsdk.core.r.c.sr());
        hashMap.put("package", wv.ev());
        hashMap.put("region", Locale.getDefault().getCountry());
        hashMap.put("tz_name", Calendar.getInstance().getTimeZone().getID());
        hashMap.put("tz_offset", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000));
        hashMap.put("rom", c());
        String str = Build.MANUFACTURER;
        hashMap.put("device_manufacturer", str);
        ArrayList<String> c4 = xv.c(context, "MD5");
        if (c4 != null && !c4.isEmpty()) {
            hashMap.put("sig_hash", str);
        }
        hashMap.put("display_density", xv(xk.ev(context)));
        hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("density_dpi", String.valueOf(xk.ev(context)));
        hashMap.put("device_brand", Build.BRAND);
        hashMap.put("build_serial", i.p());
        hashMap.put("version_code", wv.gd());
        hashMap.put("udid", i.f());
        hashMap.put("cpu_abi", Build.CPU_ABI);
        hashMap.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, com.bytedance.sdk.openadsdk.core.eq.i.c());
        return hashMap;
    }

    public static void w(me meVar) {
        if (meVar != null && c(meVar)) {
            String ev = ba.ev(meVar);
            String gd = ba.gd(meVar);
            if (!TextUtils.isEmpty(ev)) {
                w.c(ev).c(new fp() { // from class: com.bytedance.sdk.openadsdk.core.video.xv.c.2
                    @Override // com.bytedance.sdk.component.ux.fp
                    @ATSMethod(2)
                    public void c(int i4, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.ux.fp
                    @ATSMethod(1)
                    public void c(k kVar) {
                    }
                });
            }
            if (TextUtils.isEmpty(gd)) {
                return;
            }
            w.c(gd).c(new fp() { // from class: com.bytedance.sdk.openadsdk.core.video.xv.c.3
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(k kVar) {
                }
            });
        }
    }

    private static int w() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static EnterMethod c(int i4) {
        if (i4 != 5) {
            if (i4 != 7 && i4 != 8 && i4 != 9) {
                return EnterMethod.NO_VALUE;
            }
            return EnterMethod.LIVE_CELL;
        }
        return EnterMethod.LIVE_CARD;
    }

    public static boolean c(me meVar) {
        return eq.w() && ba.c(meVar);
    }

    private static String c() {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.sdk.openadsdk.core.eq.ls.w()) {
                sb.append("MIUI-");
            } else if (com.bytedance.sdk.openadsdk.core.eq.ls.f()) {
                sb.append("FLYME-");
            } else {
                String r3 = com.bytedance.sdk.openadsdk.core.eq.ls.r();
                if (com.bytedance.sdk.openadsdk.core.eq.ls.c(r3)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(r3)) {
                    sb.append(r3);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
