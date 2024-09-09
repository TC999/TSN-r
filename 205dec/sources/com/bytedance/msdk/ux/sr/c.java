package com.bytedance.msdk.ux.sr;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.c.sr;
import com.bytedance.msdk.core.gd.a;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.core.gd.k;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.ux.c.w;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f28445c;

    /* renamed from: w  reason: collision with root package name */
    private wv f28448w;
    private Map<String, com.bytedance.msdk.core.k.c> xv = new ConcurrentHashMap();
    private Map<String, com.bytedance.msdk.core.k.c> sr = new ConcurrentHashMap();
    private Map<String, com.bytedance.msdk.core.k.w> ux = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private int f28446f = 100;

    /* renamed from: r  reason: collision with root package name */
    private long f28447r = PolicyConfig.THREAD_BLOCK_TIMEOUT;
    private int ev = 0;

    private c() {
    }

    private void a() {
        this.xv.clear();
        this.sr.clear();
    }

    private void bk() {
        f.sr(new Runnable() { // from class: com.bytedance.msdk.ux.sr.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    for (com.bytedance.msdk.core.k.w wVar : c.this.ux.values()) {
                        if (wVar != null && wVar.xk() != null) {
                            if (wVar.p()) {
                                if (bk.c().c(wVar.gd())) {
                                    bk.c().w(wVar.gd());
                                }
                                if (bk.c().c(wVar.ev())) {
                                    bk.c().w(wVar.ev());
                                }
                            } else {
                                bk c4 = bk.c();
                                c4.sr(wVar.xk() + "");
                                bk c5 = bk.c();
                                c5.gd(wVar.xk() + "");
                            }
                            for (p pVar : wVar.up()) {
                                if (pVar.xv()) {
                                    if (a.c().c(pVar.w())) {
                                        a.c().w(pVar.w());
                                    }
                                    if (k.c().c(pVar.c())) {
                                        k.c().w(pVar.c());
                                    }
                                } else {
                                    a c6 = a.c();
                                    c6.delete(wVar.xk() + "", pVar.ia());
                                    k c7 = k.c();
                                    c7.delete(wVar.xk() + "", pVar.ia());
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void fp() throws JSONException {
        wv wvVar = this.f28448w;
        if (wvVar != null) {
            String w3 = wvVar.w("rit_conf");
            if (TextUtils.isEmpty(w3)) {
                return;
            }
            if (!w3.startsWith("[") && !w3.startsWith("{")) {
                w3 = com.bytedance.msdk.f.c.w(w3, com.bytedance.msdk.f.w.c());
            }
            if (TextUtils.isEmpty(w3)) {
                w(new JSONArray(w3));
            }
        }
    }

    public static c p() {
        if (f28445c == null) {
            synchronized (c.class) {
                if (f28445c == null) {
                    f28445c = new c();
                }
            }
        }
        return f28445c;
    }

    private void t() throws JSONException {
        wv wvVar = this.f28448w;
        if (wvVar != null) {
            String w3 = wvVar.w("tt_app_common_config");
            if (TextUtils.isEmpty(w3)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(w3);
            int optInt = jSONObject.optInt("event_batch_size", 100);
            this.f28446f = optInt;
            if (optInt <= 0 || optInt > 1000) {
                this.f28446f = 100;
            }
            long optLong = jSONObject.optLong("event_routine_interval", PolicyConfig.THREAD_BLOCK_TIMEOUT);
            this.f28447r = optLong;
            if (optLong < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT || optLong > 300000) {
                this.f28447r = PolicyConfig.THREAD_BLOCK_TIMEOUT;
            }
            int optInt2 = jSONObject.optInt("dynamic_adapter_type", 0);
            this.ev = optInt2;
            if (optInt2 != 0 && optInt2 != 1) {
                this.ev = 0;
            }
            com.bytedance.msdk.core.ux.w.w.c().c(jSONObject.optInt("pre_fetch_count", 20));
        }
    }

    private void ys() throws JSONException {
        wv wvVar = this.f28448w;
        if (wvVar != null) {
            String w3 = wvVar.w("adn_init_conf");
            if (TextUtils.isEmpty(w3)) {
                return;
            }
            if (!w3.startsWith("[") && !w3.startsWith("{")) {
                w3 = com.bytedance.msdk.f.c.w(w3, com.bytedance.msdk.f.w.c());
            }
            xv(new JSONObject(w3));
        }
    }

    @Override // com.bytedance.msdk.ux.sr
    public boolean ev() {
        wv wvVar = this.f28448w;
        if ((wvVar != null ? wvVar.w("prime_rit_count", -1) : 0) > 0) {
            return false;
        }
        try {
            fp();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this.ux.isEmpty();
    }

    @Override // com.bytedance.msdk.ux.xv
    public int f() {
        return this.ev;
    }

    @Override // com.bytedance.msdk.ux.ux
    public wv gd() {
        return com.bytedance.msdk.ux.f.f();
    }

    public void k() throws JSONException {
        ys();
        t();
    }

    @Override // com.bytedance.msdk.ux.sr
    public void r() {
        Map<String, com.bytedance.msdk.core.k.w> map = this.ux;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.bytedance.msdk.ux.xv
    public int sr() {
        return this.f28446f;
    }

    @Override // com.bytedance.msdk.ux.xv
    public long ux() {
        return this.f28447r;
    }

    @Override // com.bytedance.msdk.ux.w
    public List<com.bytedance.msdk.core.k.c> w() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.bytedance.msdk.core.k.c> entry : this.sr.entrySet()) {
            com.bytedance.msdk.core.k.c value = entry.getValue();
            if (value != null && value.sr()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.msdk.ux.w
    public boolean xv() {
        return this.xv.isEmpty() && this.sr.isEmpty();
    }

    private String xv(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            a();
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject2.optJSONObject(next);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("app_id");
                        String optString2 = optJSONObject.optString("app_key");
                        String optString3 = optJSONObject.optString("custom_type");
                        if (!TextUtils.equals(optString3, "1")) {
                            com.bytedance.msdk.core.k.c cVar = new com.bytedance.msdk.core.k.c(optString, optString2);
                            if (TextUtils.equals(next, "pangle") && com.bytedance.msdk.core.w.k().wx()) {
                                this.xv.put("pangle_custom", cVar);
                            }
                            this.xv.put(next, cVar);
                        } else {
                            this.sr.put(next, new com.bytedance.msdk.core.k.c(next, optString, optString2, optJSONObject.optString("init_class_name"), optJSONObject.optString("banner_class_name"), optJSONObject.optString("interstitial_class_name"), optJSONObject.optString("reward_class_name"), optJSONObject.optString("full_video_class_name"), optJSONObject.optString("splash_class_name"), optJSONObject.optString("feed_class_name"), optJSONObject.optString("draw_class_name"), optString3));
                        }
                    }
                    jSONObject2 = jSONObject;
                }
            }
            return jSONObject.toString();
        }
        return null;
    }

    @Override // com.bytedance.msdk.ux.c.w
    public void c(String str, boolean z3) {
        if (this.f28448w == null) {
            this.f28448w = gd();
        }
    }

    @Override // com.bytedance.msdk.ux.w
    public void c(JSONObject jSONObject) {
        String xv;
        String c4;
        if (this.f28448w == null || (xv = xv(jSONObject)) == null || (c4 = com.bytedance.msdk.f.c.c(xv, com.bytedance.msdk.f.w.c())) == null) {
            return;
        }
        this.f28448w.c("adn_init_conf", c4);
    }

    private void w(JSONArray jSONArray) {
        if (jSONArray == null || this.f28448w == null) {
            return;
        }
        this.ux.clear();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                com.bytedance.msdk.core.k.w w3 = com.bytedance.msdk.core.k.w.w(jSONObject);
                if (w3 != null) {
                    this.ux.put(w3.xk(), w3);
                    String c4 = com.bytedance.msdk.f.c.c(jSONObject.toString(), com.bytedance.msdk.f.w.c());
                    if (c4 != null) {
                        this.f28448w.c(w3.xk(), c4);
                    }
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
                return;
            }
        }
        bk();
        this.f28448w.c("prime_rit_count", length);
    }

    @Override // com.bytedance.msdk.ux.w
    public void c() {
        Map<String, com.bytedance.msdk.core.k.c> map;
        List<String> c4;
        Context context = com.bytedance.msdk.core.c.getContext();
        if (context == null || (map = this.xv) == null) {
            return;
        }
        int i4 = context.getApplicationInfo().targetSdkVersion;
        xv.w("TTMediationSDK_SDK_Init", "------------------ \u805a\u5408 \u63a5\u5165\u4fe1\u606f start ---------------------");
        xv.c("TTMediationSDK_SDK_Init", "\u5f53\u524d\u63a5\u5165\u7684\u805a\u5408 SDK\u7248\u672c\u662f\uff1a" + sr.w());
        if ((Build.VERSION.SDK_INT >= 24 || i4 >= 24) && (c4 = c(context)) != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!"unity".equals(next) && !"pangle_custom".equals(next)) {
                    if ("pangle".equals(next) && com.bytedance.msdk.core.w.k().wx()) {
                        next = "pangle_custom";
                    }
                    if (c4.contains(next)) {
                        xv.w("TTMediationSDK_SDK_Init", "\u5df2\u6309\u8981\u6c42\u63a5\u5165\u4e09\u65b9\u5e7f\u544asdk\u3010" + next + "\u3011");
                    } else {
                        xv.sr("TTMediationSDK_SDK_Init", "\u672a\u6309\u8981\u6c42\u63a5\u5165\u4e09\u65b9\u5e7f\u544asdk\u3010" + next + "\u3011\uff0c\u8bf7\u68c0\u67e5\u63a5\u5165\u914d\u7f6e");
                    }
                }
            }
        }
        xv.w("TTMediationSDK_SDK_Init", "------------------ GroMore \u63a5\u5165\u4fe1\u606f end ---------------------");
        xv.w("TTMediationSDK_SDK_Init", "------------------ GroMore \u7248\u672c\u4fe1\u606f start ---------------------");
        Map<String, com.bytedance.msdk.core.k.c> map2 = this.xv;
        if (map2 != null) {
            for (String str : map2.keySet()) {
                if (!TextUtils.equals(str, "pangle")) {
                    com.bytedance.msdk.adapter.c.xv c5 = com.bytedance.msdk.sr.w.w.c().c(str);
                    if (c5 != null) {
                        c5.sr();
                    } else {
                        xv.sr("TTMediationSDK_InitChecker", "\u6ca1\u6709\u5f15\u5165" + str + "Adapter,\u8bf7\u68c0\u67e5\u76f8\u5173\u5f15\u5165\u60c5\u51b5");
                    }
                }
            }
        }
        xv.w("TTMediationSDK_SDK_Init", "------------------ GroMore \u7248\u672c\u4fe1\u606f end ---------------------");
    }

    @Override // com.bytedance.msdk.ux.xv
    public void w(JSONObject jSONObject) {
        if (jSONObject == null || this.f28448w == null) {
            return;
        }
        int optInt = jSONObject.optInt("event_batch_size", 100);
        this.f28446f = optInt;
        if (optInt <= 0 || optInt > 1000) {
            this.f28446f = 100;
        }
        long optLong = jSONObject.optLong("event_routine_interval", PolicyConfig.THREAD_BLOCK_TIMEOUT);
        this.f28447r = optLong;
        if (optLong < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT || optLong > 300000) {
            this.f28447r = PolicyConfig.THREAD_BLOCK_TIMEOUT;
        }
        int optInt2 = jSONObject.optInt("dynamic_adapter_type", 0);
        this.ev = optInt2;
        if (optInt2 != 0 && optInt2 != 1) {
            this.ev = 0;
        }
        com.bytedance.msdk.core.ux.w.w.c().c(jSONObject.optInt("pre_fetch_count", 20));
        xv.sr("TTSETTING", "save--mEventBatchSize=" + this.f28446f + ", routineInterval=" + this.f28447r);
        this.f28448w.c("tt_app_common_config", jSONObject.toString());
    }

    @Override // com.bytedance.msdk.ux.w
    public com.bytedance.msdk.core.k.c c(String str) {
        com.bytedance.msdk.core.k.c cVar = this.xv.get(str);
        return cVar != null ? cVar : this.sr.get(str);
    }

    @Override // com.bytedance.msdk.ux.sr
    public void c(JSONArray jSONArray) {
        w(jSONArray);
    }

    @Override // com.bytedance.msdk.ux.sr
    public com.bytedance.msdk.core.k.w c(String str, int i4, int i5) {
        com.bytedance.msdk.core.k.w c4;
        if (TextUtils.isEmpty(str) || this.f28448w == null) {
            return null;
        }
        com.bytedance.msdk.core.k.w wVar = this.ux.get(str);
        if (wVar == null && (wVar = com.bytedance.msdk.core.k.w.r(com.bytedance.msdk.f.c.w(this.f28448w.w(str), com.bytedance.msdk.f.w.c()))) != null) {
            this.ux.put(str, wVar);
        }
        return (i5 == 102 || (c4 = com.bytedance.msdk.core.p.sr.c(wVar, i5)) == null) ? wVar : c4;
    }

    private static List<String> c(Context context) {
        List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (queryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        for (ProviderInfo providerInfo : queryContentProviders) {
            String str = providerInfo.name;
            str.hashCode();
            char c4 = '\uffff';
            switch (str.hashCode()) {
                case -2132028139:
                    if (str.equals("com.baidu.mobads.sdk.api.BdFileProvider")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1630533804:
                    if (str.equals("com.mbridge.msdk.foundation.tools.MBFileProvider")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1097984862:
                    if (str.equals("com.sigmob.sdk.SigmobFileProvider")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 8917003:
                    if (str.equals("com.tencent.klevin.utils.FileProvider")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 405711305:
                    if (str.equals("com.google.android.gms.ads.MobileAdsInitProvider")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 787345346:
                    if (str.equals("com.bykv.vk.openvk.TTFileProvider")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 980611709:
                    if (str.equals("com.kwad.sdk.api.proxy.app.AdSdkFileProvider")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 1010345138:
                    if (str.equals("com.bytedance.sdk.openadsdk.TTFileProvider")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 1011081416:
                    if (str.equals("com.unity")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case 1719438508:
                    if (str.equals("com.qq.e.comm.GDTFileProvider")) {
                        c4 = '\t';
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    arrayList.add("baidu");
                    break;
                case 1:
                    arrayList.add("mintegral");
                    break;
                case 2:
                    arrayList.add("sigmob");
                    break;
                case 3:
                    arrayList.add("klevin");
                    break;
                case 4:
                    arrayList.add("admob");
                    break;
                case 5:
                    arrayList.add("pangle_custom");
                    break;
                case 6:
                    arrayList.add("ks");
                    break;
                case 7:
                    arrayList.add("pangle");
                    break;
                case '\b':
                    arrayList.add("unity");
                    break;
                case '\t':
                    arrayList.add("gdt");
                    break;
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.msdk.ux.ux
    public void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        runnable.run();
    }
}
