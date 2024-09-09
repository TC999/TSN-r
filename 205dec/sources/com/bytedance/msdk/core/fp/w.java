package com.bytedance.msdk.core.fp;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.sr.ev;
import com.bytedance.msdk.api.sr.ux;
import com.bytedance.msdk.c.sr;
import com.bytedance.msdk.f.ck;
import com.bytedance.msdk.f.eq;
import com.bytedance.msdk.f.ia;
import com.bytedance.msdk.f.ls;
import com.bytedance.msdk.f.m;
import com.bytedance.msdk.f.n;
import com.bytedance.msdk.f.t;
import com.bytedance.msdk.f.xk;
import com.bytedance.msdk.f.z;
import com.bytedance.msdk.ux.f;
import com.bytedance.msdk.xv.r;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements ev.c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f27926c;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile w sr;
    private final ev ev;

    /* renamed from: w  reason: collision with root package name */
    private final com.bytedance.msdk.core.fp.c f27930w;
    private final Context xv;
    private final AtomicInteger ux = new AtomicInteger(0);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f27927f = new AtomicBoolean(false);

    /* renamed from: r  reason: collision with root package name */
    private final AtomicBoolean f27929r = new AtomicBoolean(false);
    private final AtomicBoolean gd = new AtomicBoolean(false);

    /* renamed from: p  reason: collision with root package name */
    private int f27928p = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {

        /* renamed from: c  reason: collision with root package name */
        public static final String f27943c = m.c() + ".openadsdk.permission.TT_PANGOLIN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.msdk.core.fp.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class RunnableC0417w implements Runnable {

        /* renamed from: w  reason: collision with root package name */
        private final ux f27945w;
        private int xv;

        RunnableC0417w(ux uxVar, int i4) {
            this.f27945w = uxVar;
            this.xv = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ck.c(w.this.xv)) {
                try {
                    w.this.f27930w.c(false);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            w.this.f27927f.set(true);
            boolean j4 = com.bytedance.msdk.core.c.w().j();
            if (!w.f27926c) {
                boolean unused2 = w.f27926c = true;
                r.c(j4);
            }
            if (com.bytedance.msdk.f.sr.c.c()) {
                return;
            }
            w.this.c(j4, this.f27945w, this.xv);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class xv extends BroadcastReceiver {
        private xv() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.c("SdkSettingsHelper", "--==-- settings receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (!TextUtils.equals(intent.getStringExtra("b_msg_process_name"), eq.w(w.this.xv))) {
                        if (w.this.f27930w != null) {
                            com.bytedance.msdk.adapter.sr.xv.c("SdkSettingsHelper", "--==-- settings receiver loadData");
                            w.this.f27930w.c(false);
                            com.bytedance.msdk.ux.c.c.p().r();
                            com.bytedance.msdk.adapter.sr.xv.c("SdkSettingsHelper", "--==-- settings receiver loadData end");
                            return;
                        }
                        return;
                    }
                    com.bytedance.msdk.adapter.sr.xv.c("SdkSettingsHelper", "--==-- settings receiver, same process, return");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private w(com.bytedance.msdk.core.fp.c cVar) {
        this.f27930w = cVar == null ? com.bytedance.msdk.core.c.w() : cVar;
        Context context = com.bytedance.msdk.core.c.getContext();
        this.xv = context;
        this.ev = new ev(Looper.getMainLooper(), this);
        if (com.bytedance.msdk.core.w.k().bk()) {
            try {
                context.registerReceiver(new xv(), new IntentFilter("com.bytedance.msdk.core.setting.SettingsReceiver"), c.f27943c, null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private JSONObject ev() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.sr.w.w.c().w();
        List<String> gd = gd();
        if (gd != null) {
            for (String str : gd) {
                com.bytedance.msdk.adapter.c.xv c4 = com.bytedance.msdk.sr.w.w.c().c(str);
                if (c4 != null) {
                    try {
                        jSONObject.put(str, c4.w());
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    private static List<String> gd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("pangle");
        arrayList.add("gdt");
        arrayList.add("admob");
        arrayList.add("unity");
        arrayList.add("baidu");
        arrayList.add("sigmob");
        arrayList.add("mintegral");
        arrayList.add("ks");
        arrayList.add("klevin");
        return arrayList;
    }

    private boolean r() {
        long w3 = f.c().w("max_expire_time", 0L);
        if (this.f27929r.get() && System.currentTimeMillis() > w3) {
            com.bytedance.msdk.adapter.sr.xv.w("SdkSettingsHelper", "setting \u7f13\u5b58\u8fc7\u671f\uff0c\u518d\u6b21\u53d1\u8d77\u8bf7\u6c42...");
            this.f27929r.set(false);
            c();
        }
        return System.currentTimeMillis() > w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        if (com.bytedance.msdk.core.c.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(m.c());
                intent.setAction("com.bytedance.msdk.core.setting.SettingsReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_process_name", eq.w(com.bytedance.msdk.core.c.getContext()));
                com.bytedance.msdk.core.c.getContext().sendBroadcast(intent, c.f27943c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void w(int i4) {
        if (this.gd.get()) {
            com.bytedance.msdk.adapter.sr.xv.sr("SdkSettingsHelper", "setting \u6b63\u5728\u5c1d\u8bd5\u62c9\u53d6\u914d\u7f6e\u4e2d...");
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("SdkSettingsHelper", "setting \u5c1d\u8bd5\u62c9\u53d6\u914d\u7f6e...");
        c();
        xv(i4);
    }

    public void xv(int i4) {
        ls.c(this.xv);
        try {
            if (!r()) {
                com.bytedance.msdk.adapter.sr.xv.w("SdkSettingsHelper", "setting \u7f13\u5b58\u672a\u8fc7\u671f\uff0c\u65e0\u9700\u518d\u6b21\u53d1\u8d77\u8bf7\u6c42...");
            } else if (this.f27927f.get()) {
                com.bytedance.msdk.adapter.sr.xv.w("SdkSettingsHelper", "setting \u6b63\u5728\u52a0\u8f7d\uff0c\u65e0\u9700\u518d\u6b21\u53d1\u8d77\u8bf7\u6c42...");
            } else {
                com.bytedance.msdk.adapter.sr.f.sr(new RunnableC0417w(null, i4));
            }
        } catch (Throwable th) {
            com.bytedance.msdk.adapter.sr.xv.c("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public static w c(com.bytedance.msdk.core.fp.c cVar) {
        if (sr == null) {
            synchronized (w.class) {
                if (sr == null) {
                    sr = new w(cVar);
                }
            }
        }
        return sr;
    }

    private JSONObject w(JSONObject jSONObject) {
        String str;
        com.bytedance.msdk.f.ux c4;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ts", System.currentTimeMillis());
            jSONObject2.put("media_sdk_version", sr.w());
            jSONObject2.put("plugin_version", sr.sr());
            jSONObject2.put("is_fusion", 1);
            jSONObject2.put("app_id", com.bytedance.msdk.core.w.k().a());
            jSONObject2.put("package_name", m.c());
            jSONObject2.put("app_version", m.xv());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("android_id", ls.xv(this.xv));
            jSONObject3.put("imei", ls.ux(this.xv));
            jSONObject3.put("imei_md5", n.c(ls.ux(this.xv)));
            jSONObject3.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, z.c());
            jSONObject3.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, com.bytedance.msdk.f.ev.c().w());
            jSONObject3.put("applog_did", ls.c(this.xv));
            jSONObject3.put("publisher_did", com.bytedance.msdk.core.w.k().s());
            jSONObject3.put("conn_type", ck.xv(this.xv));
            jSONObject3.put("os", 1);
            jSONObject3.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("device_model", Build.MODEL);
            jSONObject3.put("mcc", xk.w());
            jSONObject3.put("mnc", xk.xv());
            jSONObject3.put("time_zone", TimeZone.getDefault().getDisplayName(false, 0));
            jSONObject3.put("ip", t.w());
            jSONObject3.put("locale_language", t.ev());
            jSONObject3.put("total_space", "" + t.f());
            jSONObject3.put("carrier_name", xk.c());
            jSONObject3.put("device_name", Settings.Global.getString(this.xv.getContentResolver(), "device_name"));
            jSONObject3.put("pb", "");
            double currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            Double.isNaN(currentTimeMillis);
            double d4 = currentTimeMillis / 1000.0d;
            try {
                str = new Formatter().format("%.6f", Double.valueOf(d4)).toString();
            } catch (Exception unused) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                try {
                    str = new DecimalFormat("#0.000000").format(d4);
                } catch (Exception unused2) {
                }
            }
            jSONObject3.put("boot", str);
            jSONObject3.put("device_city", "");
            jSONObject3.put("country_code", com.bytedance.msdk.core.c.w().sr());
            jSONObject3.put("total_mem", "" + t.ux());
            jSONObject3.put("device_type", Build.MODEL);
            jSONObject3.put("language", Locale.getDefault().getLanguage());
            jSONObject3.put("android_os_version_int", Build.VERSION.SDK_INT);
            jSONObject2.put("device", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("init_time", com.bytedance.msdk.core.w.k().xv());
            jSONObject2.put("app", jSONObject4);
            jSONObject2.put("grouping_params", w());
            JSONObject xv2 = xv();
            if (xv2 != null) {
                jSONObject2.put("user_defined_grouping_params", xv2);
            }
            if (!com.bytedance.msdk.core.w.k().r()) {
                jSONObject2.put(DownloadModel.ETAG, com.bytedance.msdk.core.c.w().f());
            }
            if (com.bytedance.msdk.f.f.c(this.xv) != null) {
                jSONObject2.put("latitude", c4.f28362c);
                jSONObject2.put("longitude", c4.f28363w);
            }
            jSONObject2.put("adn_version_list", ev());
            com.bytedance.msdk.core.p.ux.sr().c(jSONObject2, jSONObject);
            com.bytedance.msdk.core.p.ux.sr().c(jSONObject2);
            List<String> xk = com.bytedance.msdk.core.w.k().xk();
            if (xk != null && xk.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : xk) {
                    jSONArray.put(str2);
                }
                jSONObject2.put("primerit_list", jSONArray);
            }
            if (!ia.xv()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("err_type", 1);
                jSONObject5.put("err_msg", "applog so\u52a0\u8f7d\u5931\u8d25");
                jSONObject2.put("monitor_alarm", jSONObject5);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject2;
    }

    public static JSONObject xv() {
        Map<String, String> c4;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.sr.f ba = com.bytedance.msdk.core.w.k().ba();
        if (ba != null && (c4 = ba.c()) != null) {
            try {
                for (String str : c4.keySet()) {
                    jSONObject.put(str, c4.get(str));
                }
                return jSONObject;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public w c() {
        com.bytedance.msdk.adapter.sr.xv.sr("SdkSettingsHelper", "setting resetRetryCount...");
        this.ux.set(0);
        this.gd.set(false);
        ev evVar = this.ev;
        if (evVar != null) {
            evVar.removeCallbacksAndMessages(null);
        }
        return this;
    }

    private String xv(JSONObject jSONObject) {
        JSONObject c4 = m.c(jSONObject);
        if (c4 != null) {
            return c4.toString();
        }
        return null;
    }

    public void c(int i4) {
        try {
            if (this.f27927f.get()) {
                this.f27928p = i4;
                com.bytedance.msdk.adapter.sr.xv.w("SdkSettingsHelper", "setting \u6b63\u5728\u52a0\u8f7d\uff0c\u65e0\u9700\u518d\u6b21\u53d1\u8d77\u8bf7\u6c42...");
                return;
            }
            com.bytedance.msdk.adapter.sr.f.sr(new RunnableC0417w(null, i4));
        } catch (Throwable th) {
            com.bytedance.msdk.adapter.sr.xv.c("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ux uxVar, com.bytedance.msdk.api.c cVar, int i4) throws Throwable {
        long j4;
        f.c().f("server_dist_host");
        c(uxVar, cVar);
        com.bytedance.msdk.sr.xv.ux();
        com.bytedance.msdk.adapter.sr.xv.sr("SdkSettingsHelper", "setting \u914d\u7f6e\u62c9\u53d6\u5931\u8d25\uff0c\u5c1d\u8bd5\u518d\u6b21\u62c9\u53d6... mLoadingSuccess:" + this.f27929r.get() + " mRetryCount:" + (this.ux.get() + 1));
        this.f27927f.set(false);
        if (this.f27929r.get()) {
            this.gd.set(false);
            this.ev.removeCallbacksAndMessages(null);
        } else if (this.ux.get() > 3) {
            com.bytedance.msdk.adapter.sr.xv.sr("SdkSettingsHelper", "setting \u6700\u591a\u5c1d\u8bd5\u56db\u6b21\u62c9\u53d6... ");
        } else {
            this.gd.set(true);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = this.ux.get();
            obtain.arg2 = i4;
            int i5 = this.ux.get();
            if (i5 < 3) {
                long j5 = 1;
                for (int i6 = 0; i6 <= i5; i6++) {
                    j5 *= 3;
                }
                j4 = j5 * 1000;
            } else {
                j4 = PolicyConfig.THREAD_BLOCK_TIMEOUT;
            }
            this.ux.incrementAndGet();
            this.ev.removeCallbacksAndMessages(null);
            this.ev.sendMessageDelayed(obtain, j4);
            com.bytedance.msdk.adapter.sr.xv.w("SdkSettingsHelper", "setting \u91cd\u8bd5\u6b21\u6570:" + (i5 + 1) + "  \u91cd\u8bd5\u95f4\u9694\uff1a" + j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> c(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str.toLowerCase(), map.get(str));
            }
        }
        return hashMap;
    }

    private void c(final ux uxVar, final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.fp.w.1
            @Override // java.lang.Runnable
            public void run() {
                ux uxVar2 = uxVar;
                if (uxVar2 != null) {
                    uxVar2.c(cVar);
                }
            }
        });
    }

    public void c(final ux uxVar) {
        int i4 = this.f27928p;
        if (i4 == 2 || i4 == 3) {
            this.f27928p = -1;
            c(i4);
        }
        if (uxVar != null) {
            final List<String> xk = com.bytedance.msdk.core.w.k().xk();
            com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.fp.w.2
                @Override // java.lang.Runnable
                public void run() {
                    uxVar.c(com.bytedance.msdk.core.c.w().c(xk));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z3, final ux uxVar, final int i4) {
        final int[] iArr = {0};
        final int[] iArr2 = new int[1];
        final long currentTimeMillis = System.currentTimeMillis();
        Map<String, JSONObject> w3 = com.bytedance.msdk.core.p.ux.sr().w(i4);
        final JSONObject jSONObject = w3.get("event_label_value_root");
        JSONObject jSONObject2 = w3.get("config_req_label_value_root");
        com.bytedance.sdk.component.ev.w.sr w4 = com.bytedance.msdk.w.w.c().w().w();
        w4.c(com.bytedance.msdk.core.xv.c());
        String ev = com.bytedance.msdk.core.w.k().ev();
        if (!TextUtils.isEmpty(ev)) {
            w4.w("X-Tt-Env", ev);
            w4.w("x-use-ppe", "1");
        }
        w4.w("User-Agent", sr.f27665c);
        w4.xv(xv(w(jSONObject2)));
        w4.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.msdk.core.fp.w.3
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, final com.bytedance.sdk.component.ev.w wVar) {
                com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.fp.w.3.1
                    /* JADX WARN: Removed duplicated region for block: B:36:0x012b A[Catch: all -> 0x0290, TRY_LEAVE, TryCatch #7 {all -> 0x0290, blocks: (B:6:0x0018, B:8:0x0028, B:10:0x0047, B:13:0x0074, B:29:0x00e9, B:31:0x0110, B:33:0x0116, B:34:0x011d, B:36:0x012b, B:20:0x00a5, B:27:0x00de, B:22:0x00b7, B:15:0x0082), top: B:100:0x0018 }] */
                    /* JADX WARN: Removed duplicated region for block: B:50:0x019f  */
                    /* JADX WARN: Removed duplicated region for block: B:75:0x02db A[Catch: all -> 0x0340, TRY_LEAVE, TryCatch #8 {all -> 0x0340, blocks: (B:73:0x029c, B:75:0x02db), top: B:98:0x029c }] */
                    /* JADX WARN: Removed duplicated region for block: B:86:0x035b  */
                    /* JADX WARN: Removed duplicated region for block: B:87:0x035d  */
                    /* JADX WARN: Removed duplicated region for block: B:91:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void run() {
                        /*
                            Method dump skipped, instructions count: 869
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.fp.w.AnonymousClass3.AnonymousClass1.run():void");
                    }
                });
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, final IOException iOException) {
                com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.fp.w.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.adapter.sr.xv.sr("SdkSettingsHelper", "----\u7f51\u7edc\u9519\u8bef\uff0c\u670d\u52a1\u5668\u65e0\u54cd\u5e94\uff0c\u7a0d\u540e\u4f1a\u5c1d\u8bd5\u91cd\u65b0\u62c9\u53d6\u914d\u7f6e----\uff0csetting request failed..." + iOException.getMessage());
                        try {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            w.this.c(uxVar, new com.bytedance.msdk.api.c(-2, com.bytedance.msdk.api.c.c(-2)), i4);
                            com.bytedance.msdk.adapter.sr.xv.sr("SdkSettingsHelper", "----\u7f51\u7edc\u9519\u8bef\uff0c\u91cd\u65b0\u62c9\u53d6\u914d\u7f6e\u5931\u8d25----\uff0c>>>>> retryLoadSettingData");
                        } catch (Throwable unused) {
                        }
                        w.this.f27927f.set(false);
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        iArr[0] = 0;
                        iArr2[0] = -2;
                        if (!com.bytedance.msdk.core.c.w().j()) {
                            com.bytedance.msdk.core.bk.c.c().c(iArr2[0], "\u805a\u5408config\u8bf7\u6c42\u5931\u8d25");
                        }
                        AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                        int i5 = iArr[0];
                        int i6 = iArr2[0];
                        long currentTimeMillis2 = System.currentTimeMillis();
                        AnonymousClass3 anonymousClass34 = AnonymousClass3.this;
                        r.c(i5, i6, currentTimeMillis2 - currentTimeMillis, z3, i4 == 0, jSONObject, -1L, (JSONObject) null);
                    }
                });
            }
        });
    }

    public static String c(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                String stringWriter2 = stringWriter.toString();
                try {
                    stringWriter.close();
                } catch (IOException unused) {
                }
                printWriter.close();
                return stringWriter2;
            } catch (Exception unused2) {
                stringWriter.close();
                printWriter.close();
                return null;
            } catch (Throwable th2) {
                try {
                    stringWriter.close();
                } catch (IOException unused3) {
                }
                printWriter.close();
                throw th2;
            }
        } catch (IOException unused4) {
            printWriter.close();
            return null;
        }
    }

    public static JSONObject w() {
        String w3;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.sr.f ba = com.bytedance.msdk.core.w.k().ba();
        if (ba != null) {
            try {
                w3 = ba.w();
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        } else {
            w3 = "";
        }
        jSONObject.put("user_id", w3);
        jSONObject.put("channel", ba != null ? ba.xv() : "");
        jSONObject.put("sub_channel", ba != null ? ba.sr() : "");
        jSONObject.put("age", ba != null ? ba.ux() : 0);
        jSONObject.put("gender", ba != null ? ba.f() : "");
        jSONObject.put("user_value_group", ba != null ? ba.r() : "");
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optBoolean("remote_log_enabled")) {
                com.bytedance.msdk.adapter.sr.xv.c();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.msdk.adapter.sr.ev.c
    public void c(Message message) {
        if (message.what != 1) {
            return;
        }
        int i4 = message.arg1;
        int i5 = message.arg2;
        if (i4 == 3) {
            this.gd.set(false);
        }
        com.bytedance.msdk.adapter.sr.xv.sr("SdkSettingsHelper", "setting \u53d1\u8d77\u5c1d\u8bd5\u62c9\u53d6\u914d\u7f6e\u8bf7\u6c42... mLoadingSuccess:" + this.f27929r.get() + "tryCount:" + (i4 + 1));
        try {
            if (this.f27929r.get()) {
                return;
            }
            xv(i5);
        } catch (Throwable unused) {
        }
    }
}
