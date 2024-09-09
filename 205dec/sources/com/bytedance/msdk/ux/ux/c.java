package com.bytedance.msdk.ux.ux;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.ux.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.msdk.ux.w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f28450c;
    private Map<String, com.bytedance.msdk.core.k.c> xv = new ConcurrentHashMap();

    /* renamed from: w  reason: collision with root package name */
    private wv f28451w = f.xv();

    private c() {
    }

    private Set<String> f() {
        HashSet hashSet = new HashSet();
        if (this.xv.size() != 0) {
            for (Map.Entry<String, com.bytedance.msdk.core.k.c> entry : this.xv.entrySet()) {
                com.bytedance.msdk.core.k.c value = entry.getValue();
                if (value != null && !value.sr()) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    public static c sr() {
        if (f28450c == null) {
            synchronized (c.class) {
                if (f28450c == null) {
                    f28450c = new c();
                }
            }
        }
        return f28450c;
    }

    private void ux() {
        String w3 = this.f28451w.w("adn_init_config");
        if (TextUtils.isEmpty(w3)) {
            return;
        }
        if (!w3.startsWith("[") && !w3.startsWith("{")) {
            w3 = com.bytedance.msdk.f.c.w(w3, com.bytedance.msdk.f.w.c());
        }
        if (TextUtils.isEmpty(w3)) {
            return;
        }
        try {
            w(new JSONObject(w3));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void w(JSONObject jSONObject) {
        this.xv.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            com.bytedance.msdk.core.k.c c4 = com.bytedance.msdk.core.k.c.c(next, optJSONObject);
            if (optJSONObject != null && c4 != null) {
                if (TextUtils.equals(next, "pangle") && com.bytedance.msdk.core.w.k().wx()) {
                    this.xv.put("pangle_custom", c4);
                } else {
                    this.xv.put(next, c4);
                }
            }
        }
    }

    @Override // com.bytedance.msdk.ux.w
    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            w(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                this.f28451w.c("adn_init_config", jSONObject2);
            }
            com.bytedance.msdk.ux.sr.c.p().c(jSONObject);
        }
    }

    @Override // com.bytedance.msdk.ux.w
    public boolean xv() {
        if (this.xv.size() == 0) {
            ux();
        }
        return this.xv.isEmpty();
    }

    @Override // com.bytedance.msdk.ux.w
    public com.bytedance.msdk.core.k.c c(String str) {
        if (this.xv.size() == 0) {
            ux();
        }
        return this.xv.get(str);
    }

    @Override // com.bytedance.msdk.ux.w
    public synchronized void c() {
        List<String> c4;
        Context context = com.bytedance.msdk.core.c.getContext();
        if (context == null) {
            return;
        }
        Set<String> f4 = f();
        if (f4.size() == 0) {
            return;
        }
        int i4 = context.getApplicationInfo().targetSdkVersion;
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK_SDK_Init", "------------------ \u805a\u5408 \u63a5\u5165\u4fe1\u606f start ---------------------");
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_SDK_Init", "\u5f53\u524d\u63a5\u5165\u7684\u805a\u5408 SDK\u7248\u672c\u662f\uff1a" + com.bytedance.msdk.c.sr.w());
        if ((Build.VERSION.SDK_INT >= 24 || i4 >= 24) && (c4 = c(context)) != null) {
            Iterator<String> it = f4.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!"unity".equals(next) && !"pangle_custom".equals(next)) {
                    if ("pangle".equals(next) && com.bytedance.msdk.core.w.k().wx()) {
                        next = "pangle_custom";
                    }
                    if (c4.contains(next)) {
                        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK_SDK_Init", "\u5df2\u6309\u8981\u6c42\u63a5\u5165\u4e09\u65b9\u5e7f\u544asdk\u3010" + next + "\u3011");
                    } else {
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", "\u672a\u6309\u8981\u6c42\u63a5\u5165\u4e09\u65b9\u5e7f\u544asdk\u3010" + next + "\u3011\uff0c\u8bf7\u68c0\u67e5\u63a5\u5165\u914d\u7f6e");
                    }
                }
            }
        }
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK_SDK_Init", "------------------ GroMore \u63a5\u5165\u4fe1\u606f end ---------------------");
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK_SDK_Init", "------------------ GroMore \u7248\u672c\u4fe1\u606f start ---------------------");
        for (String str : f4) {
            if (!TextUtils.equals(str, "pangle")) {
                com.bytedance.msdk.adapter.c.xv c5 = com.bytedance.msdk.sr.w.w.c().c(str);
                if (c5 != null) {
                    c5.sr();
                } else {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_InitChecker", "\u6ca1\u6709\u5f15\u5165" + str + "Adapter,\u8bf7\u68c0\u67e5\u76f8\u5173\u5f15\u5165\u60c5\u51b5");
                }
            }
        }
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK_SDK_Init", "------------------ GroMore \u7248\u672c\u4fe1\u606f end ---------------------");
    }

    @Override // com.bytedance.msdk.ux.w
    public List<com.bytedance.msdk.core.k.c> w() {
        if (this.xv.size() == 0) {
            ux();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.bytedance.msdk.core.k.c> entry : this.xv.entrySet()) {
            com.bytedance.msdk.core.k.c value = entry.getValue();
            if (value != null && value.sr()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    private List<String> c(Context context) {
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
}
