package com.bytedance.sdk.component.adexpress.c.w;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.c.xv.c;
import com.bytedance.sdk.component.adexpress.sr.r;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    static Object f29042c = new Object();

    @Deprecated
    private static String f() {
        com.bytedance.sdk.component.adexpress.c.xv.c sr = sr();
        if (sr == null) {
            return null;
        }
        return sr.sr();
    }

    public static com.bytedance.sdk.component.adexpress.c.xv.c sr() {
        return ux.w().ux();
    }

    public static boolean ux() {
        return ux.w().sr();
    }

    public static void w() {
        try {
            ev.sr();
            File r3 = ux.r();
            if (r3 != null && r3.exists()) {
                if (r3.getParentFile() != null) {
                    com.bytedance.sdk.component.utils.f.xv(r3.getParentFile());
                } else {
                    com.bytedance.sdk.component.utils.f.xv(r3);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String xv() {
        return f.xv();
    }

    public static void c() {
        ux.w();
    }

    private static boolean sr(String str) {
        com.bytedance.sdk.component.adexpress.c.xv.c sr;
        List<c.C0435c> resources;
        if (!ux() || (sr = sr()) == null || (resources = sr.getResources()) == null) {
            return false;
        }
        for (c.C0435c c0435c : resources) {
            if (c0435c != null && TextUtils.equals(str, c0435c.c())) {
                return true;
            }
        }
        return false;
    }

    private static File ux(String str) {
        if (ux()) {
            for (c.C0435c c0435c : sr().getResources()) {
                if (c0435c.c() != null && c0435c.c().equals(str)) {
                    File file = new File(ux.r(), com.bytedance.sdk.component.utils.ux.w(c0435c.c()));
                    String c4 = com.bytedance.sdk.component.utils.ux.c(file);
                    if (c0435c.w() == null || !c0435c.w().equals(c4)) {
                        return null;
                    }
                    return file;
                }
            }
            return null;
        }
        return null;
    }

    public static String xv(String str) {
        com.bytedance.sdk.component.adexpress.c.xv.c cVar;
        com.bytedance.sdk.component.adexpress.c.xv.c sr = sr();
        if (sr == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> c4 = sr.c();
            if (c4 == null || c4.size() <= 0 || (cVar = c4.get(str)) == null) {
                return null;
            }
            return cVar.sr();
        }
        return f();
    }

    public static void c(com.bytedance.sdk.component.adexpress.c.xv.sr srVar) {
        r.c().c(srVar, srVar.f29053f);
    }

    private static File f(String str) {
        List<Pair<String, String>> w3;
        c.w ux = sr().ux();
        if (ux == null || (w3 = ux.w()) == null || w3.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : w3) {
            Object obj = pair.second;
            if (obj != null && ((String) obj).equals(str)) {
                return new File(ux.r(), (String) pair.first);
            }
        }
        return null;
    }

    public static Set<com.bytedance.sdk.component.adexpress.c.xv.w> c(String str, boolean z3) {
        final Set<com.bytedance.sdk.component.adexpress.c.xv.w> w3 = r.c().w(str);
        if (w3 != null && w3.size() > 0) {
            if (z3) {
                com.bytedance.sdk.component.adexpress.sr.xv.c(new p("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.c.w.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        w.w(w3);
                    }
                }, 5);
            } else {
                w(w3);
            }
        }
        return w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Set<com.bytedance.sdk.component.adexpress.c.xv.w> set) {
        try {
            for (com.bytedance.sdk.component.adexpress.c.xv.w wVar : set) {
                wVar.c(Long.valueOf(System.currentTimeMillis()));
                f.c().c(wVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.component.adexpress.c.xv.w c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.c.xv.w c4 = r.c().c(str);
        if (c4 != null) {
            c4.c(Long.valueOf(System.currentTimeMillis()));
            c(c4);
        }
        return c4;
    }

    public static com.bytedance.sdk.component.adexpress.c.xv.w w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.c.xv.w c4 = r.c().c(str);
        if (c4 != null) {
            c4.c(Long.valueOf(System.currentTimeMillis()));
            c(c4);
        }
        return c4;
    }

    private static void c(final com.bytedance.sdk.component.adexpress.c.xv.w wVar) {
        com.bytedance.sdk.component.adexpress.sr.xv.c(new p("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.c.w.w.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (w.f29042c) {
                    f.c().c(wVar, true);
                }
            }
        }, 10);
    }

    public static c c(String str, r.c cVar, String str2, String str3) {
        File file;
        c cVar2 = new c();
        if (TextUtils.isEmpty(str3)) {
            file = null;
        } else {
            file = w(str3, str);
            if (file != null) {
                cVar2.c(1);
            }
        }
        if (file == null && (file = f(str)) != null) {
            cVar2.c(3);
        }
        if (file == null && (file = ux(str)) != null) {
            cVar2.c(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!c(str, str3)) {
                cVar2.c(4);
            }
        } else if (!sr(str)) {
            cVar2.c(6);
        }
        a.w("TTDynamic", "final type:" + cVar2.getType());
        if (file != null) {
            try {
                cVar2.c(new WebResourceResponse(cVar.getType(), "utf-8", new FileInputStream(file)));
            } catch (Throwable th) {
                a.xv("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return cVar2;
    }

    private static File w(String str, String str2) {
        com.bytedance.sdk.component.adexpress.c.xv.c sr = sr();
        if (sr != null && ux()) {
            Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> c4 = sr.c();
            if (c4.size() == 0) {
                a.w("TTDynamic", "map is empty");
                return null;
            }
            com.bytedance.sdk.component.adexpress.c.xv.c cVar = c4.get(str);
            if (cVar != null) {
                for (c.C0435c c0435c : cVar.getResources()) {
                    if (c0435c.c() != null && c0435c.c().equals(str2)) {
                        File file = new File(ux.r(), com.bytedance.sdk.component.utils.ux.w(c0435c.c()));
                        String c5 = com.bytedance.sdk.component.utils.ux.c(file);
                        if (c0435c.w() == null || !c0435c.w().equals(c5)) {
                            return null;
                        }
                        return file;
                    }
                }
                return null;
            }
            return null;
        }
        a.w("TTDynamic", "is null");
        return null;
    }

    public static boolean w(JSONObject jSONObject) {
        Object opt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    if (optJSONObject == null || (opt = optJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean c(String str, String str2) {
        com.bytedance.sdk.component.adexpress.c.xv.c sr;
        com.bytedance.sdk.component.adexpress.c.xv.c cVar;
        if (!ux() || (sr = sr()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> c4 = sr.c();
        if (c4.size() == 0 || (cVar = c4.get(str2)) == null) {
            return false;
        }
        for (c.C0435c c0435c : cVar.getResources()) {
            if (c0435c != null && TextUtils.equals(str, c0435c.c())) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(JSONObject jSONObject) {
        Object opt;
        return (jSONObject == null || (opt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) ? false : true;
    }
}
