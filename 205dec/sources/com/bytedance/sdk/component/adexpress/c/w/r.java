package com.bytedance.sdk.component.adexpress.c.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static volatile r f29029c;

    /* renamed from: w  reason: collision with root package name */
    private AtomicBoolean f29030w = new AtomicBoolean(false);

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void w();
    }

    private r() {
    }

    private JSONObject xv(String str) {
        com.bytedance.sdk.component.adexpress.c.c.xv xv = com.bytedance.sdk.component.adexpress.c.c.c.c().xv();
        if (xv == null) {
            return null;
        }
        com.bytedance.sdk.component.ev.w.w f4 = xv.f();
        f4.c(str);
        com.bytedance.sdk.component.ev.w c4 = f4.c();
        if (c4 != null) {
            try {
                if (c4.ev() && c4.sr() != null) {
                    return new JSONObject(c4.sr());
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public Set<com.bytedance.sdk.component.adexpress.c.xv.w> w(String str) {
        return f.c().w(str);
    }

    public static r c() {
        if (f29029c == null) {
            synchronized (r.class) {
                if (f29029c == null) {
                    f29029c = new r();
                }
            }
        }
        return f29029c;
    }

    private void w() {
        if (com.bytedance.sdk.component.adexpress.c.c.c.c().xv() == null) {
            return;
        }
        int c4 = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().c();
        if (c4 <= 0) {
            c4 = 100;
        }
        List<com.bytedance.sdk.component.adexpress.c.xv.w> w3 = f.c().w();
        if (w3 != null && !w3.isEmpty() && c4 < w3.size()) {
            TreeMap treeMap = new TreeMap();
            for (com.bytedance.sdk.component.adexpress.c.xv.w wVar : w3) {
                treeMap.put(wVar.r(), wVar);
            }
            HashSet hashSet = new HashSet();
            int size = (int) (w3.size() - (c4 * 0.75f));
            int i4 = 0;
            for (Map.Entry entry : treeMap.entrySet()) {
                if (entry != null && i4 < size) {
                    i4++;
                    ((Long) entry.getKey()).longValue();
                    com.bytedance.sdk.component.adexpress.c.xv.w wVar2 = (com.bytedance.sdk.component.adexpress.c.xv.w) entry.getValue();
                    if (wVar2 != null) {
                        hashSet.add(wVar2.w());
                    }
                }
            }
            c(hashSet);
            this.f29030w.set(false);
            return;
        }
        int size2 = w3 != null ? w3.size() : 0;
        a.w("TmplDiffManager", "end doCheckAndDeleteTask maxTplCnt,local size" + c4 + ", Number of templates currently stored" + size2);
    }

    public com.bytedance.sdk.component.adexpress.c.xv.w c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f.c().c(str);
    }

    private JSONObject c(String str, c cVar) {
        if (com.bytedance.sdk.component.adexpress.c.c.c.c().xv() == null) {
            cVar.w();
            return null;
        }
        com.bytedance.sdk.component.ev.w.w f4 = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().f();
        f4.c(str);
        com.bytedance.sdk.component.ev.w c4 = f4.c();
        if (c4 != null) {
            try {
                if (c4.ev() && c4.sr() != null) {
                    return new JSONObject(c4.sr());
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        cVar.w();
        return null;
    }

    private void w(String str, String str2, String str3, String str4, String str5, String str6) {
        f.c().c(new com.bytedance.sdk.component.adexpress.c.xv.w().c(str).w(str2).xv(str3).sr(str4).ux(str5).f(str6).c(Long.valueOf(System.currentTimeMillis())), false);
        w();
    }

    public void c(com.bytedance.sdk.component.adexpress.c.xv.sr srVar, String str) {
        if (srVar == null) {
            a.f("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = srVar.f29052c;
        final String str3 = srVar.xv;
        final String str4 = srVar.f29054w;
        final String str5 = srVar.sr;
        final String str6 = srVar.ux;
        final String r3 = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.c.c.c.c().xv() != null ? com.bytedance.sdk.component.adexpress.c.c.c.c().xv().r() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            a.f("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.component.adexpress.sr.xv.c(new p("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.c.w.r.1
                @Override // java.lang.Runnable
                public void run() {
                    r.this.c(str2, str3, str4, str5, str6, r3);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (c(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                w(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4)) {
            c(str2, str6, str);
        } else if (TextUtils.isEmpty(str3)) {
            c(str2, str6, str);
        } else {
            w(str6, str, str3, str2, str4, str5);
        }
        boolean c4 = ev.c(str5);
        if (!w.ux() || c4) {
            ux.w().c(true);
        }
    }

    private void c(String str, String str2, String str3) {
        JSONObject xv;
        if (TextUtils.isEmpty(str) || (xv = xv(str)) == null) {
            return;
        }
        String optString = xv.optString("md5");
        String optString2 = xv.optString("version");
        String optString3 = xv.optString("data");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.c.xv.w c4 = new com.bytedance.sdk.component.adexpress.c.xv.w().c(str2).w(str3).xv(optString).sr(str).ux(optString3).f(optString2).c(Long.valueOf(System.currentTimeMillis()));
        f.c().c(c4, false);
        w();
        if (ev.c(optString2)) {
            c4.f(optString2);
            ux.w().c(true);
        }
    }

    public synchronized void c(String str, String str2, String str3, String str4, String str5, String str6, c cVar) {
        if (c(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                w(str6, str, str3, str2, str4, str5);
                cVar.c();
            }
            cVar.c();
            return;
        } else if (TextUtils.isEmpty(str4)) {
            c(str2, str6, str, cVar);
        } else if (TextUtils.isEmpty(str3)) {
            c(str2, str6, str, cVar);
        } else {
            w(str6, str, str3, str2, str4, str5);
            cVar.c();
        }
        boolean c4 = ev.c(str5);
        if (!w.ux() || c4) {
            ux.w().c(true);
        }
    }

    private void c(String str, String str2, String str3, c cVar) {
        if (TextUtils.isEmpty(str)) {
            cVar.w();
            return;
        }
        JSONObject c4 = c(str, cVar);
        if (c4 != null) {
            String optString = c4.optString("md5");
            String optString2 = c4.optString("version");
            String optString3 = c4.optString("data");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                com.bytedance.sdk.component.adexpress.c.xv.w c5 = new com.bytedance.sdk.component.adexpress.c.xv.w().c(str2).w(str3).xv(optString).sr(str).ux(optString3).f(optString2).c(Long.valueOf(System.currentTimeMillis()));
                if (c5 != null && com.bytedance.sdk.component.adexpress.c.c.c.c().w() != null) {
                    if (TextUtils.isEmpty(c5.w())) {
                        cVar.w();
                        return;
                    }
                    f.c().c(c5, false);
                    w();
                    if (ev.c(optString2)) {
                        c5.f(optString2);
                        ux.w().c(true);
                    }
                    cVar.c();
                    return;
                }
                cVar.w();
                return;
            }
            cVar.w();
        }
    }

    public void c(Set<String> set) {
        try {
            f.c().c(set);
        } catch (Throwable th) {
            a.w("TmplDiffManager", th.getMessage());
        }
    }
}
