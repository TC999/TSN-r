package com.bytedance.sdk.openadsdk.core.fz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.ls;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class c implements com.bytedance.sdk.component.r.c.ev {

    /* renamed from: c  reason: collision with root package name */
    public static final c f33662c = new c();
    private String sr;

    /* renamed from: w  reason: collision with root package name */
    private long f33663w;
    private int xv;

    private c() {
    }

    private String c(int i4) {
        return i4 != 120 ? i4 != 160 ? i4 != 240 ? i4 != 320 ? i4 != 480 ? i4 != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    private int t() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public int a() {
        return k();
    }

    public String bk() {
        StringBuilder sb = new StringBuilder();
        try {
            if (ls.w()) {
                sb.append("MIUI-");
            } else if (ls.f()) {
                sb.append("FLYME-");
            } else {
                String r3 = ls.r();
                if (ls.c(r3)) {
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

    public String c(Context context) {
        try {
            return com.bytedance.sdk.openadsdk.core.eq.gd.xv(context) ? "tv" : com.bytedance.sdk.openadsdk.core.eq.gd.w(context) ? "android_pad" : "android";
        } catch (Throwable unused) {
            return "android";
        }
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public void c(int i4, List<com.bytedance.sdk.component.r.c.w> list) {
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public boolean ev() {
        return eq.c();
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public String f() {
        return wv.fz();
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public boolean gd() {
        return com.bytedance.sdk.openadsdk.core.ls.w().eu();
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public int k() {
        return com.bytedance.sdk.openadsdk.core.ls.w().eu() ? 4 : 3;
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", i.xv());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public String r() {
        return wv.ev("/api/ad/union/sdk/stats/batch/");
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public int sr() {
        int ys = com.bytedance.sdk.openadsdk.core.ls.w().ys();
        if (ys < 0 || ys == Integer.MAX_VALUE) {
            return 10;
        }
        return ys;
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public com.bytedance.sdk.component.r.c.c.f ux() {
        return new p(com.bytedance.sdk.openadsdk.core.q.ux.c().w().w());
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public byte[] w(JSONObject jSONObject, int i4) {
        byte[] w3 = w(jSONObject);
        if (w3 == null || !com.bytedance.sdk.component.panglearmor.ev.w()) {
            return null;
        }
        return com.bytedance.sdk.component.panglearmor.ev.c().c(w3);
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public long xv() {
        long t3 = com.bytedance.sdk.openadsdk.core.ls.w().t();
        if (t3 < 0 || t3 == 2147483647L) {
            return 5000L;
        }
        return t3;
    }

    @SuppressLint({"HardwareIds"})
    private JSONObject c(List<com.bytedance.sdk.component.r.c.w> list, boolean z3, boolean z4) {
        JSONObject jSONObject = new JSONObject();
        Context context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        int i4 = 0;
        if (z3) {
            try {
                jSONObject.put("sdk_version", eq.xv);
                jSONObject.put("display_name", com.bytedance.sdk.openadsdk.core.r.c.ux());
                jSONObject.put("app_version", com.bytedance.sdk.openadsdk.core.r.c.sr());
                jSONObject.put("package", wv.ev());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
                jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                ArrayList<String> c4 = com.bytedance.sdk.component.utils.xv.c(context, "MD5");
                if (c4 != null && !c4.isEmpty()) {
                    jSONObject.put("sig_hash", c4.get(0));
                }
                jSONObject.put("version_code", wv.gd());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.f("log_net", th.getMessage());
            }
        }
        jSONObject.put("ua", wv.f());
        com.bytedance.sdk.openadsdk.t.c.xv(context, jSONObject);
        jSONObject.put("openudid", i.ux());
        jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, com.bytedance.sdk.openadsdk.core.eq.i.c());
        jSONObject.put("ad_sdk_version", eq.xv);
        jSONObject.put("plugin_version", "6.1.0.6");
        jSONObject.put("is_plugin", eq.c());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.eq.gd.c((String) null));
        jSONObject2.put("client_ipv6", com.bytedance.sdk.openadsdk.core.eq.gd.ev());
        jSONObject.put("custom", jSONObject2);
        jSONObject.put("sim_op", i.bk());
        jSONObject.put("root", z4 ? 1 : 0);
        jSONObject.put("timezone", t());
        jSONObject.put("access", ys.r(context));
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        if (TextUtils.isEmpty(this.sr)) {
            this.sr = c(context);
        }
        jSONObject.put("device_type", this.sr);
        jSONObject.put("device_model", i.u());
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("language", Locale.getDefault().getLanguage());
        jSONObject.put("resolution", xk.ux(context) + "x" + xk.sr(context));
        jSONObject.put("display_density", c(xk.ev(context)));
        jSONObject.put("density_dpi", xk.ev(context));
        jSONObject.put("device_id", i.xv());
        int c5 = com.bytedance.sdk.component.r.w.xv.c.c(list, com.bytedance.sdk.component.r.w.c.r("csj"));
        if (c5 != 0) {
            jSONObject.put("aid", String.valueOf(c5));
        } else {
            jSONObject.put("aid", "1371");
        }
        jSONObject.put("rom", bk());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", i.p());
        jSONObject.put("ut", this.xv);
        jSONObject.put("uid", this.f33663w);
        jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.eq.gd.gd());
        jSONObject.put("screen_bright", Math.ceil(com.bytedance.sdk.openadsdk.core.eq.gd.p() * 10.0f) / 10.0d);
        if (!com.bytedance.sdk.openadsdk.core.eq.gd.c()) {
            i4 = 1;
        }
        jSONObject.put("is_screen_off", i4);
        if (context != null) {
            jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.core.r.c.c(context));
        }
        if (y.xv() > 0) {
            jSONObject.put("screenshot_time", String.valueOf(y.xv()));
        }
        jSONObject.put("mnc", i.ia());
        jSONObject.put("mcc", i.ys());
        jSONObject.put("pan_code_serial", "1000");
        return jSONObject;
    }

    private byte[] w(JSONObject jSONObject) {
        GZIPOutputStream gZIPOutputStream = null;
        if (jSONObject == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(jSONObject.toString().getBytes());
                    gZIPOutputStream2.close();
                } catch (Exception e5) {
                    e = e5;
                    gZIPOutputStream = gZIPOutputStream2;
                    e.printStackTrace();
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public String w() {
        return wv.u();
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public JSONObject c(List<com.bytedance.sdk.component.r.c.w> list, boolean z3) {
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            boolean z4 = false;
            try {
                c(list.get(0));
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.component.r.c.w wVar : list) {
                    JSONObject r3 = wVar.r();
                    if (TextUtils.equals("pangle_live_sdk_monitor", r3.optString("event"))) {
                        if (!z4) {
                            z4 = true;
                        }
                        r3.putOpt("nt", Integer.valueOf(ys.xv(com.bytedance.sdk.openadsdk.core.ls.getContext())));
                    }
                    jSONArray.put(r3);
                }
                jSONObject.put("header", c(list, z4, z3));
                jSONObject.put("event_v3", jSONArray);
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put("_gen_time", System.currentTimeMillis());
                return jSONObject;
            } catch (JSONException e4) {
                com.bytedance.sdk.component.utils.a.xv(e4.getMessage());
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public byte[] c(JSONObject jSONObject, int i4) {
        byte[] w3 = w(jSONObject);
        if (w3 == null) {
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.ls.w().eu()) {
            return com.bytedance.sdk.component.panglearmor.ev.c().c(w3);
        }
        return TTEncryptUtils.a(w3, w3.length);
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public boolean c() {
        return com.bytedance.sdk.openadsdk.core.k.sr().ba();
    }

    @Override // com.bytedance.sdk.component.r.c.ev
    public JSONObject c(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.c.c(jSONObject);
    }

    private void c(com.bytedance.sdk.component.r.c.w wVar) {
        String optString;
        if (wVar == null) {
            return;
        }
        JSONObject r3 = wVar.r();
        JSONObject optJSONObject = r3.optJSONObject(EventMonitor.V3_PARAMS);
        if (optJSONObject != null) {
            optString = optJSONObject.optString("log_extra", "");
        } else {
            optString = r3.optString("log_extra", "");
        }
        long xv = wv.xv(optString);
        int sr = wv.sr(optString);
        if (xv == 0) {
            xv = this.f33663w;
        }
        this.f33663w = xv;
        if (sr == 0) {
            sr = this.xv;
        }
        this.xv = sr;
    }
}
