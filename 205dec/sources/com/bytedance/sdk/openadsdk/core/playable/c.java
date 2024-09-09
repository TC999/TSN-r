package com.bytedance.sdk.openadsdk.core.playable;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.z;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wx;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f34409c;

    /* renamed from: w  reason: collision with root package name */
    private String f34412w;
    private Map<me, w> xv = Collections.synchronizedMap(new HashMap());
    private Map<String, JSONObject> sr = Collections.synchronizedMap(new HashMap());
    private AtomicBoolean ux = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private Set<String> f34410f = Collections.synchronizedSet(new HashSet());

    /* renamed from: r  reason: collision with root package name */
    private Handler f34411r = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.playable.c$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class AnonymousClass1 extends p {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f34413c;

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            try {
                String w3 = this.f34413c.w();
                if (!TextUtils.isEmpty(w3)) {
                    File file = new File(w3);
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                        for (File file2 : listFiles) {
                            try {
                                this.f34413c.c(this.f34413c.c(file2), true);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            this.f34413c.ux.set(true);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.playable.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0502c {
        void c(boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        long f34422c;
        long sr;

        /* renamed from: w  reason: collision with root package name */
        long f34423w;
        long xv;

        private w() {
        }

        public long c() {
            return this.f34423w - this.f34422c;
        }

        public w sr(long j4) {
            this.sr = j4;
            return this;
        }

        public long w() {
            return this.sr - this.xv;
        }

        public w xv(long j4) {
            this.xv = j4;
            return this;
        }

        /* synthetic */ w(AnonymousClass1 anonymousClass1) {
            this();
        }

        public w c(long j4) {
            this.f34422c = j4;
            return this;
        }

        public w w(long j4) {
            this.f34423w = j4;
            return this;
        }
    }

    private c() {
    }

    private boolean ux(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return false;
        }
        return Arrays.asList(list).contains("index.html");
    }

    private void sr(File file) {
        try {
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(currentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < currentTimeMillis) {
                    a.sr("PlayableCache", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(File file) {
        sr(file);
        try {
            k.sr().q().c(file);
        } catch (Throwable unused) {
        }
    }

    private boolean w(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w() {
        File file = new File(xv(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String xv() {
        File xv;
        if (TextUtils.isEmpty(this.f34412w)) {
            try {
                if (("mounted".equals(com.bytedance.sdk.openadsdk.n.xv.c()) || !Environment.isExternalStorageRemovable()) && com.bytedance.sdk.openadsdk.api.plugin.w.xv(ls.getContext()) != null) {
                    xv = com.bytedance.sdk.openadsdk.api.plugin.w.xv(ls.getContext());
                } else {
                    xv = com.bytedance.sdk.openadsdk.api.plugin.w.w(ls.getContext());
                }
                File file = new File(xv, "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f34412w = file.getAbsolutePath();
            } catch (Throwable th) {
                a.f("PlayableCache", "init root path error: " + th);
            }
        }
        return this.f34412w;
    }

    public static c c() {
        if (f34409c == null) {
            synchronized (c.class) {
                if (f34409c == null) {
                    f34409c = new c();
                }
            }
        }
        return f34409c;
    }

    public boolean c(me meVar) {
        if (this.ux.get() && !TextUtils.isEmpty(wx.f(meVar))) {
            try {
                String w3 = com.bytedance.sdk.component.utils.ux.w(wx.f(meVar));
                if (this.sr.get(w3) == null) {
                    return false;
                }
                return ux(new File(w(), w3));
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c(File file, boolean z3) {
        byte[] sr;
        String c4;
        try {
            if (!w(file) || (sr = com.bytedance.sdk.component.utils.f.sr(file)) == null || sr.length <= 0) {
                return null;
            }
            if (TextUtils.equals(file.getName(), "new_tt_open_ad_sdk_check_res.dat")) {
                c4 = com.bytedance.sdk.component.utils.c.xv(new String(sr));
            } else {
                c4 = com.bytedance.sdk.component.sr.c.c(new String(sr), com.bytedance.sdk.openadsdk.core.c.c());
            }
            if (TextUtils.isEmpty(c4)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(c4);
            if (z3 && jSONObject.length() > 0) {
                this.sr.put(file.getParentFile().getName(), jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File c(File file) {
        File file2 = new File(file, "new_tt_open_ad_sdk_check_res.dat");
        return w(file2) ? file2 : new File(file, "tt_open_ad_sdk_check_res.dat");
    }

    public WebResourceResponse c(String str, String str2, String str3) {
        try {
        } catch (Throwable th) {
            a.xv("PlayableCache", "playable intercept error: ", th);
        }
        if (!this.ux.get() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            if (str3.startsWith("http") && str3.contains("?")) {
                str3 = str3.split("\\?")[0];
                if (str3.endsWith(TTPathConst.sSeparator)) {
                    str3 = str3.substring(0, str3.length() - 1);
                }
            }
        } catch (Throwable unused) {
        }
        String c4 = t.c(ls.getContext(), str3);
        if (TextUtils.isEmpty(c4)) {
            return null;
        }
        String w3 = com.bytedance.sdk.component.utils.ux.w(str);
        if (TextUtils.isEmpty(w3)) {
            return null;
        }
        File file = new File(w(), w3);
        if (ux(file)) {
            String c5 = c(str2);
            if (TextUtils.isEmpty(c5)) {
                return null;
            }
            String replace = str3.replace(c5, "");
            if (TextUtils.isEmpty(replace)) {
                return null;
            }
            File file2 = new File(file, replace);
            if (c(w3, replace, file2) && file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                return new WebResourceResponse(c4, "utf-8", new FileInputStream(file2));
            }
        }
        return null;
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        if (split != null && split.length == 2) {
            if (split[0] != null && split[0].endsWith(TTPathConst.sSeparator)) {
                str = str.substring(0, split.length - 1);
            }
            if (split[0] != null && split[0].endsWith("index.html")) {
                str = split[0];
            }
        }
        return str.replace("index.html", "");
    }

    private boolean c(String str, String str2, File file) {
        JSONObject jSONObject;
        String optString;
        return (file == null || !file.exists() || (jSONObject = this.sr.get(str)) == null || (optString = jSONObject.optString(str2)) == null || !optString.equalsIgnoreCase(com.bytedance.sdk.component.utils.ux.c(file))) ? false : true;
    }

    public void c(final me meVar, final InterfaceC0502c interfaceC0502c) {
        if (TextUtils.isEmpty(wx.f(meVar))) {
            com.bytedance.sdk.openadsdk.core.playable.w.c(ls.getContext(), meVar, -701, (String) null);
            c(interfaceC0502c, false);
            return;
        }
        final String f4 = wx.f(meVar);
        if (this.f34410f.contains(f4)) {
            return;
        }
        this.xv.put(meVar, new w(null).c(System.currentTimeMillis()));
        com.bytedance.sdk.openadsdk.core.playable.w.c(ls.getContext(), meVar);
        String w3 = com.bytedance.sdk.component.utils.ux.w(f4);
        final File file = new File(w(), w3);
        if (ux(file)) {
            com.bytedance.sdk.openadsdk.core.playable.w.c(ls.getContext(), meVar, -702, (String) null);
            sr(file);
            this.xv.remove(meVar);
            c(interfaceC0502c, true);
            return;
        }
        try {
            com.bytedance.sdk.component.utils.f.xv(file);
        } catch (Throwable unused) {
        }
        this.f34410f.add(f4);
        String xv = xv();
        File file2 = new File(xv, w3 + ".zip");
        com.bytedance.sdk.component.ev.w.c sr = com.bytedance.sdk.openadsdk.core.q.ux.c().w().sr();
        sr.c(f4);
        sr.c(file2.getParent(), file2.getName());
        sr.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.playable.c.2
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, final com.bytedance.sdk.component.ev.w wVar) {
                c.this.f34410f.remove(f4);
                final w wVar2 = (w) c.this.xv.remove(meVar);
                if (wVar2 != null) {
                    wVar2.w(System.currentTimeMillis());
                }
                if (wVar.ev() && wVar.r() != null && wVar.r().exists()) {
                    a.xv("PlayableCache", "onResponse: Playable zip download success");
                    com.bytedance.sdk.component.gd.ev.c(new p("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.playable.c.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long j4;
                            long j5;
                            boolean z3 = true;
                            try {
                                w wVar3 = wVar2;
                                if (wVar3 != null) {
                                    wVar3.xv(System.currentTimeMillis());
                                }
                                z.c(wVar.r().getAbsolutePath(), c.this.w());
                                w wVar4 = wVar2;
                                if (wVar4 != null) {
                                    wVar4.sr(System.currentTimeMillis());
                                }
                                w wVar5 = wVar2;
                                if (wVar5 != null) {
                                    long c4 = wVar5.c();
                                    j4 = wVar2.w();
                                    j5 = c4;
                                } else {
                                    j4 = 0;
                                    j5 = 0;
                                }
                                com.bytedance.sdk.openadsdk.core.playable.w.c(ls.getContext(), meVar, j5, j4);
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                c.this.xv(file);
                                try {
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    c.this.c(c.this.c(file), true);
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable th) {
                                a.xv("PlayableCache", "unzip error: ", th);
                                com.bytedance.sdk.openadsdk.core.playable.w.c(ls.getContext(), meVar, -704, th.getMessage());
                                z3 = false;
                            }
                            try {
                                wVar.r().delete();
                            } catch (Throwable unused3) {
                            }
                            AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                            c.this.c(interfaceC0502c, z3);
                        }
                    }, 5);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.playable.w.c(ls.getContext(), meVar, wVar.c() != 0 ? wVar.c() : -700, (String) null);
                a.xv("PlayableCache", "onResponse: Playable zip download fail");
                c.this.c(interfaceC0502c, false);
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                c.this.f34410f.remove(f4);
                c.this.xv.remove(meVar);
                com.bytedance.sdk.openadsdk.core.playable.w.c(ls.getContext(), meVar, -700, iOException.getMessage());
                c.this.c(interfaceC0502c, false);
                a.xv("PlayableCache", "onFailure: Playable zip download fail");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final InterfaceC0502c interfaceC0502c, final boolean z3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (interfaceC0502c != null) {
                interfaceC0502c.c(z3);
            }
        } else if (interfaceC0502c != null) {
            this.f34411r.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.c.3
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0502c interfaceC0502c2 = interfaceC0502c;
                    if (interfaceC0502c2 != null) {
                        interfaceC0502c2.c(z3);
                    }
                }
            });
        }
    }
}
