package com.bytedance.sdk.openadsdk.w;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.q.ux;
import com.bytedance.sdk.openadsdk.core.xv;
import com.bytedance.sdk.openadsdk.n.ev;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, com.bytedance.sdk.openadsdk.w.c> f36352c;

    /* renamed from: w  reason: collision with root package name */
    private ReentrantLock f36353w;
    private Set<String> xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        private static final w f36359c = new w();
    }

    private void delete(Map<String, com.bytedance.sdk.openadsdk.w.c> map) {
        for (String str : map.keySet()) {
            com.bytedance.sdk.openadsdk.w.c cVar = map.get(str);
            boolean w3 = cVar.w(ev.c());
            a.w("BrandVideoCacheManager", "try delete: " + cVar.w() + " ,result " + w3);
        }
    }

    private void sr() {
        JSONArray jSONArray = new JSONArray();
        for (String str : this.f36352c.keySet()) {
            com.bytedance.sdk.openadsdk.w.c cVar = this.f36352c.get(str);
            if (cVar != null) {
                jSONArray.put(cVar.ux());
            }
        }
        String jSONArray2 = jSONArray.toString();
        xv.c().c("sdk_brand_video_cahce", jSONArray2);
        a.w("BrandVideoCacheManager", "save video cache:" + jSONArray2);
    }

    private Map<String, com.bytedance.sdk.openadsdk.w.c> ux() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.sdk.openadsdk.w.c>> it = this.f36352c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, com.bytedance.sdk.openadsdk.w.c> next = it.next();
            if (next.getValue().sr()) {
                hashMap.put(next.getKey(), next.getValue());
                it.remove();
            } else {
                arrayList.add(next.getValue());
            }
        }
        int l4 = ls.w().l();
        a.w("BrandVideoCacheManager", "setting num:" + l4);
        int size = this.f36352c.size() - l4;
        if (size > 0) {
            Collections.sort(arrayList, new Comparator<com.bytedance.sdk.openadsdk.w.c>() { // from class: com.bytedance.sdk.openadsdk.w.w.3
                @Override // java.util.Comparator
                /* renamed from: c */
                public int compare(com.bytedance.sdk.openadsdk.w.c cVar, com.bytedance.sdk.openadsdk.w.c cVar2) {
                    long xv = cVar2.xv() - cVar.xv();
                    if (xv == 0) {
                        String c4 = ev.c();
                        xv = cVar.c(c4) - cVar2.c(c4);
                    }
                    return (int) xv;
                }
            });
            for (int i4 = 0; i4 < size; i4++) {
                com.bytedance.sdk.openadsdk.w.c cVar = (com.bytedance.sdk.openadsdk.w.c) arrayList.get(i4);
                this.f36352c.remove(cVar.w());
                hashMap.put(cVar.w(), cVar);
            }
        }
        return hashMap;
    }

    private com.bytedance.sdk.component.ev.c w() {
        return ux.c().w();
    }

    private JSONArray xv(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creatives");
        JSONArray jSONArray = new JSONArray();
        if (optJSONArray2 == null) {
            return jSONArray;
        }
        for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i4);
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("precache_brand_video")) != null) {
                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                    jSONArray.put(optJSONArray.opt(i5));
                }
            }
        }
        return jSONArray;
    }

    private w() {
        this.f36352c = new HashMap();
        this.f36353w = new ReentrantLock();
        this.xv = new HashSet();
        String w3 = xv.c().w("sdk_brand_video_cahce", "");
        if (TextUtils.isEmpty(w3)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(w3);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                w(jSONArray.optJSONObject(i4));
            }
        } catch (Throwable unused) {
        }
    }

    private void w(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.w.c cVar = new com.bytedance.sdk.openadsdk.w.c(jSONObject);
            this.f36352c.put(cVar.w(), cVar);
        }
    }

    public static w c() {
        return c.f36359c;
    }

    public void c(JSONObject jSONObject) {
        final JSONArray xv = xv(jSONObject);
        if (xv == null || xv.length() == 0) {
            return;
        }
        com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.w.w.1
            @Override // java.lang.Runnable
            public void run() {
                a.w("BrandVideoCacheManager", "onReceivedNewBrandCache start:" + xv.length());
                w.this.c(xv);
            }
        }, 20000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONArray jSONArray) {
        try {
            this.f36353w.lock();
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                w(jSONArray.optJSONObject(i4));
            }
            Map<String, com.bytedance.sdk.openadsdk.w.c> ux = ux();
            int xv = xv();
            sr();
            delete(ux);
            this.f36353w.unlock();
            c(xv);
        } catch (Throwable th) {
            this.f36353w.unlock();
            throw th;
        }
    }

    private int xv() {
        int i4 = 0;
        for (String str : this.f36352c.keySet()) {
            sr c4 = c(this.f36352c.get(str));
            if (c4 != null) {
                String ux = c4.ux();
                String ia = c4.ia();
                String fp = c4.fp();
                File file = new File(ux, ia);
                if (file.exists() && file.length() > 0) {
                    a.w("BrandVideoCacheManager", " file :" + ia + " exist!");
                } else {
                    i4++;
                    if (this.xv.contains(ia)) {
                        a.xv("BrandVideoCacheManager", " task :" + ia + " is running!");
                    } else {
                        this.xv.add(ia);
                        c(fp, ux, ia);
                    }
                }
            }
        }
        return i4;
    }

    private void c(int i4) {
        File[] listFiles = new File(ev.c()).listFiles();
        int l4 = ls.w().l();
        if (listFiles == null || listFiles.length <= l4 - i4) {
            return;
        }
        for (int i5 = 0; i5 < listFiles.length; i5++) {
            String c4 = c(listFiles[i5]);
            if (!this.f36352c.containsKey(c4) && listFiles[i5].exists()) {
                listFiles[i5].delete();
                a.sr("BrandVideoCacheManager", "delete not need:" + c4);
            }
        }
    }

    private String c(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        return lastIndexOf != -1 ? name.substring(0, lastIndexOf) : name;
    }

    private void c(final String str, String str2, final String str3) {
        com.bytedance.sdk.component.ev.w.c sr = w().sr();
        sr.c(str);
        sr.c(str2, str3);
        sr.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.w.w.2
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                a.w("BrandVideoCacheManager", "download " + str + " finish: code = " + wVar.c());
                w.this.c(str3);
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                a.sr("BrandVideoCacheManager", "download " + str + " failed: " + iOException);
                w.this.c(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        try {
            this.f36353w.lock();
            this.xv.remove(str);
        } finally {
            this.f36353w.unlock();
        }
    }

    private sr c(com.bytedance.sdk.openadsdk.w.c cVar) {
        if (cVar == null) {
            return null;
        }
        String w3 = cVar.w();
        if (TextUtils.isEmpty(w3)) {
            w3 = com.bytedance.sdk.component.utils.ux.w(cVar.c());
        }
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar = new com.bykv.vk.openvk.component.video.api.xv.xv();
        xvVar.xv(cVar.c());
        xvVar.ux(w3);
        xvVar.ux(0);
        sr srVar = new sr(ev.c(), xvVar, xvVar, 0, 0);
        srVar.c(ev.c());
        return srVar;
    }
}
