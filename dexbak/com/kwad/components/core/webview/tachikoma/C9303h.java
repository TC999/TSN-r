package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* renamed from: com.kwad.components.core.webview.tachikoma.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9303h {

    /* renamed from: YE */
    private final Map<String, HashMap<Integer, String>> f29354YE = new ConcurrentHashMap();

    /* renamed from: YF */
    private Map<String, Integer> f29355YF = new ConcurrentSkipListMap();

    /* renamed from: YG */
    private int f29356YG = 0;

    /* renamed from: com.kwad.components.core.webview.tachikoma.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9304a {

        /* renamed from: YH */
        private static final C9303h f29357YH = new C9303h();
    }

    /* renamed from: aO */
    private static int m29082aO(String str) {
        return ((((str.length() * 2) + 12) + 16) + 16) / 1024;
    }

    /* renamed from: aR */
    private void m29081aR(int i) {
        if (this.f29356YG + i > C10251d.m26524a(C10250c.asZ)) {
            ArrayList<String> arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> it = this.f29355YF.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                arrayList.add(next.getKey());
                this.f29356YG -= next.getValue().intValue();
                it.remove();
                if (this.f29356YG <= C10251d.m26524a(C10250c.asZ) - i) {
                    break;
                }
            }
            for (String str : arrayList) {
                this.f29354YE.remove(str);
            }
        }
    }

    /* renamed from: q */
    private void m29078q(String str, String str2) {
        int m29082aO = m29082aO(str2);
        this.f29356YG += m29082aO;
        this.f29355YF.put(str, Integer.valueOf(m29082aO));
    }

    /* renamed from: sB */
    public static C9303h m29077sB() {
        return C9304a.f29357YH;
    }

    /* renamed from: b */
    public final void m29080b(String str, int i, String str2) {
        if (TextUtils.isEmpty(str2) || C10251d.m26524a(C10250c.asZ) == 0) {
            return;
        }
        if (this.f29354YE.containsKey(str)) {
            if (this.f29354YE.get(str).containsKey(Integer.valueOf(i))) {
                return;
            }
            this.f29354YE.remove(str);
        }
        m29081aR(m29082aO(str2));
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(i), str2);
        this.f29354YE.put(str, hashMap);
        m29078q(str, str2);
    }

    /* renamed from: o */
    public final String m29079o(String str, int i) {
        if (C10251d.m26524a(C10250c.asZ) != 0 && this.f29354YE.containsKey(str)) {
            HashMap<Integer, String> hashMap = this.f29354YE.get(str);
            if (hashMap.containsKey(Integer.valueOf(i))) {
                return hashMap.get(Integer.valueOf(i));
            }
        }
        return "";
    }
}
