package com.bytedance.msdk.ux.ux;

import android.text.TextUtils;
import com.bytedance.msdk.core.gd.a;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.core.gd.k;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.ux.f;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements com.bytedance.msdk.ux.sr {

    /* renamed from: c  reason: collision with root package name */
    private static volatile sr f28452c;

    /* renamed from: w  reason: collision with root package name */
    private volatile Map<Integer, wv> f28453w = new ConcurrentHashMap();
    private Map<String, com.bytedance.msdk.core.k.w> xv = new ConcurrentHashMap();

    private sr() {
    }

    private synchronized void w(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (jSONArray.length() > 0) {
                try {
                    this.xv.clear();
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i4);
                        com.bytedance.msdk.core.k.w w3 = com.bytedance.msdk.core.k.w.w(jSONObject);
                        if (w3 != null && !TextUtils.isEmpty(w3.xk())) {
                            this.xv.put(w3.xk(), w3);
                            concurrentHashMap.put(w3.xk(), jSONObject.toString());
                        }
                    }
                    c(concurrentHashMap);
                    w.p().gd().c("prime_rit_count", jSONArray.length());
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    @Override // com.bytedance.msdk.ux.sr
    public synchronized boolean ev() {
        if (w.p().gd().w("prime_rit_count", -1) > 0) {
            return false;
        }
        w();
        return this.xv.isEmpty();
    }

    @Override // com.bytedance.msdk.ux.sr
    public synchronized void r() {
        Map<String, com.bytedance.msdk.core.k.w> map = this.xv;
        if (map != null) {
            map.clear();
        }
    }

    public static sr c() {
        if (f28452c == null) {
            synchronized (sr.class) {
                if (f28452c == null) {
                    f28452c = new sr();
                }
            }
        }
        return f28452c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized wv c(int i4) {
        wv wvVar;
        wvVar = this.f28453w.get(Integer.valueOf(i4));
        if (wvVar == null) {
            wvVar = f.c(i4);
            this.f28453w.put(Integer.valueOf(i4), wvVar);
        }
        return wvVar;
    }

    private synchronized void w() {
        String w3 = com.bytedance.msdk.f.c.w(f.sr().w("rit_config"), com.bytedance.msdk.f.w.c());
        if (w3 != null && !TextUtils.isEmpty(w3)) {
            w(new JSONArray(w3));
        }
    }

    @Override // com.bytedance.msdk.ux.sr
    public synchronized void c(JSONArray jSONArray) {
        w(jSONArray);
    }

    @Override // com.bytedance.msdk.ux.sr
    public synchronized com.bytedance.msdk.core.k.w c(String str, int i4, int i5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.msdk.core.k.w wVar = this.xv.get(str);
        if (wVar == null && (wVar = com.bytedance.msdk.core.k.w.r(c(i4, str))) != null) {
            this.xv.put(str, wVar);
        }
        if (i5 == 102) {
            return wVar;
        }
        com.bytedance.msdk.core.k.w c4 = com.bytedance.msdk.core.p.sr.c(wVar, i5);
        return c4 != null ? c4 : wVar;
    }

    private String c(int i4, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        if (i4 == 0) {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(5);
            arrayList.add(7);
            arrayList.add(8);
            arrayList.add(9);
            arrayList.add(10);
        } else {
            arrayList.add(Integer.valueOf(i4));
        }
        for (Integer num : arrayList) {
            String w3 = c(num.intValue()).w(str);
            if (!TextUtils.isEmpty(w3)) {
                return w3;
            }
        }
        return null;
    }

    private synchronized void c(final Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                com.bytedance.msdk.adapter.sr.f.sr(new Runnable() { // from class: com.bytedance.msdk.ux.ux.sr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Map.Entry entry : map.entrySet()) {
                            try {
                                String str = (String) entry.getKey();
                                String str2 = (String) entry.getValue();
                                com.bytedance.msdk.core.k.w wVar = (com.bytedance.msdk.core.k.w) sr.this.xv.get(str);
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && wVar != null) {
                                    sr.this.c(wVar.yu()).c(str, str2);
                                    sr.this.c(wVar);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        map.clear();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(com.bytedance.msdk.core.k.w wVar) {
        if (wVar != null) {
            if (wVar.xk() != null) {
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
    }
}
