package com.bytedance.sdk.openadsdk.core.ugeno.ux;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.c.w.sr;
import com.bytedance.sdk.component.adexpress.c.w.xv;
import com.bytedance.sdk.component.adexpress.c.xv.c;
import com.bytedance.sdk.component.adexpress.sr.r;
import com.bytedance.sdk.component.adexpress.ux.ux;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.f.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f35036c;
    private static AtomicReference<w> ux = new AtomicReference<>(null);
    private static volatile File xv;

    /* renamed from: w  reason: collision with root package name */
    private AtomicBoolean f35037w = new AtomicBoolean(false);
    private AtomicBoolean sr = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void gd() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
            }
            if (ux.get() != null) {
                return;
            }
            File file = new File(c(), "package_ugen_temp.json");
            Long valueOf = Long.valueOf(file.length());
            if (valueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[valueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    ux.set(w.w(new JSONObject(new String(bArr, "utf-8"))));
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        a.xv("PlayComponentEngineCacheManager", "version init error", th);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return;
                    } catch (Throwable th4) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th4;
                    }
                }
            } else {
                a.w("PlayComponentEngineCacheManager", "fne");
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static c w() {
        if (f35036c == null) {
            synchronized (c.class) {
                if (f35036c == null) {
                    f35036c = new c();
                }
            }
        }
        return f35036c;
    }

    public boolean ev() {
        AtomicBoolean atomicBoolean = this.sr;
        return atomicBoolean != null && atomicBoolean.get();
    }

    public void f() {
        try {
            ux();
            File c4 = c();
            if (c4 != null && c4.exists()) {
                if (c4.getParentFile() != null) {
                    f.xv(c4.getParentFile());
                } else {
                    f.xv(c4);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void r() {
        a.w("PlayComponentEngineCacheManager", "check template usable1");
        w wVar = ux.get();
        if (wVar != null && wVar.f()) {
            boolean c4 = c(wVar.getResources());
            if (!c4) {
                ux();
            }
            this.sr.set(c4);
            return;
        }
        a.w("PlayComponentEngineCacheManager", "check template usable2");
    }

    public void sr() {
        try {
            if (this.f35037w.get()) {
                a.w("PlayComponentEngineCacheManager", "loadTemplate error2: ");
                return;
            }
            boolean z3 = true;
            this.f35037w.set(true);
            w wVar = new w(ls.c().c(2));
            w wVar2 = ux.get();
            if (!wVar.f()) {
                this.f35037w.set(false);
                a.w("PlayComponentEngineCacheManager", "loadTemplate error3");
            } else if (!xv.c(wVar2, wVar.xv())) {
                this.f35037w.set(false);
                a.w("PlayComponentEngineCacheManager", "loadTemplate error4");
            } else {
                q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ux.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ux.c().w();
                    }
                });
                List<c.C0435c> w3 = w(wVar, wVar2);
                if (w3 == null) {
                    z3 = false;
                }
                if (w3 == null) {
                    this.f35037w.set(false);
                }
                if (z3 && c(wVar.getResources())) {
                    ux.set(wVar);
                    xv.c(c(), ux.get(), "package_ugen_temp.json");
                    w(w3);
                }
                r();
                this.f35037w.set(false);
            }
        } catch (Throwable th) {
            a.c("PlayComponentEngineCacheManager", "loadTemplate error: ", th);
        }
    }

    public void ux() {
        xv.w(c(), ux.get(), "package_ugen_temp.json");
        ux.set(null);
    }

    public void xv() {
        ev.c(new p("enginecache-init") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ux.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.gd();
                    c.this.r();
                    c.this.sr();
                    a.w("PlayComponentEngineCacheManager", "uc-if");
                } catch (Throwable unused) {
                    a.w("PlayComponentEngineCacheManager", "uc-ie");
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.c.w.xv
    public File c() {
        if (xv == null) {
            try {
                File file = new File(new File(sr.c(), "tt_ugen_pkg"), "engine");
                file.mkdirs();
                xv = file;
            } catch (Throwable th) {
                a.xv("PlayComponentEngineCacheManager", "ge", th);
            }
        }
        return xv;
    }

    private File w(String str) {
        w wVar;
        if (!ev() || (wVar = ux.get()) == null) {
            return null;
        }
        for (c.C0435c c0435c : wVar.getResources()) {
            if (c0435c.c() != null && c0435c.c().equals(str)) {
                File file = new File(c(), com.bytedance.sdk.component.utils.ux.w(c0435c.c()));
                String c4 = com.bytedance.sdk.component.utils.ux.c(file);
                if (c0435c.w() == null || !c0435c.w().equals(c4)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public WebResourceResponse c(WebView webView, r.c cVar, String str) {
        File w3;
        try {
            if (TextUtils.isEmpty(str) || cVar == r.c.IMAGE || (w3 = w(str)) == null) {
                return null;
            }
            return new WebResourceResponse(cVar.getType(), "utf-8", new FileInputStream(w3));
        } catch (Throwable th) {
            a.xv("PlayComponentEngineCacheManager", "grwe", th);
            return null;
        }
    }
}
