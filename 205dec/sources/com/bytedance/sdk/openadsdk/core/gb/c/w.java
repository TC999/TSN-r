package com.bytedance.sdk.openadsdk.core.gb.c;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ux;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.stub.StubApp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static final String f33693c;
    private static long ev;
    private static long gd;

    /* renamed from: r  reason: collision with root package name */
    private static final HashMap<String, String> f33694r;
    private static final w ux;

    /* renamed from: w  reason: collision with root package name */
    private static final String f33695w;
    private static final String xv;

    /* renamed from: f  reason: collision with root package name */
    private EventListener f33696f;
    private FileOutputStream sr;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public String f33702c;
        public int ev;

        /* renamed from: f  reason: collision with root package name */
        public String f33703f;
        public int gd;

        /* renamed from: k  reason: collision with root package name */
        public String f33704k;

        /* renamed from: p  reason: collision with root package name */
        public int f33705p;

        /* renamed from: r  reason: collision with root package name */
        public boolean f33706r;
        public String sr;
        public String ux;

        /* renamed from: w  reason: collision with root package name */
        public int f33707w;
        public String xv;

        private c() {
        }

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.f33702c).put("version_code", this.f33707w).put("sign", this.ux).put("max_version", this.gd).put("min_version", this.ev).put("is_revert", this.f33706r).put("md5", this.f33703f).put("plugin_file", this.f33704k).toString();
            } catch (JSONException unused) {
                return "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.gb.c.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class C0495w extends Exception {

        /* renamed from: c  reason: collision with root package name */
        private int f33708c;

        public C0495w(int i4, String str) {
            super(str);
            this.f33708c = i4;
        }

        int c() {
            return this.f33708c;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append("next");
        f33693c = sb.toString();
        f33695w = str + "tmp";
        xv = str + "conf";
        ux = new w();
        f33694r = new HashMap<>();
    }

    private w() {
    }

    private static File f(Context context) {
        return new File(xv(context), xv);
    }

    private static File sr(Context context) {
        return new File(xv(context), f33695w);
    }

    private static File ux(Context context) {
        return new File(xv(context), f33693c);
    }

    private static File xv(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.w.c(context, "tt_pangle_bykv_file", 0);
    }

    private static int sr(c cVar) {
        JSONObject optJSONObject;
        if (c(cVar)) {
            return 6106;
        }
        if (!k.sr().fz().has(cVar.f33702c) || (optJSONObject = k.sr().fz().optJSONObject(cVar.f33702c)) == null) {
            return 0;
        }
        return w(optJSONObject.optString("plugin_version"));
    }

    private void w(Context context) {
        File[] listFiles;
        FileOutputStream fileOutputStream = this.sr;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        File sr = sr(context);
        if (sr.exists()) {
            for (File file : sr.listFiles()) {
                try {
                    if (!"update.lock".equals(file.getName())) {
                        file.delete();
                    }
                } catch (Exception e5) {
                    a.w("PluginUpdater", "delete file failed: " + e5);
                }
            }
        }
    }

    private static boolean xv(c cVar) {
        if (c(cVar)) {
            return 6106 == cVar.f33707w;
        }
        JSONObject optJSONObject = k.sr().fz().optJSONObject(cVar.f33702c);
        return (optJSONObject != null ? w(optJSONObject.optString("plugin_version")) : 0) == cVar.f33707w;
    }

    public static w c() {
        return ux;
    }

    public void c(final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(ls.getContext().getApplicationContext());
        ev.w(new p("updatePlugin") { // from class: com.bytedance.sdk.openadsdk.core.gb.c.w.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    w.this.c(origApplicationContext, w.xv(jSONArray));
                } catch (Throwable th) {
                    a.w("PluginUpdater", "Unexpected error when update: " + th);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(android.content.Context r7, int r8, java.lang.String r9) {
        /*
            r6 = this;
            com.bytedance.sdk.openadsdk.core.k r0 = com.bytedance.sdk.openadsdk.core.k.sr()
            com.bytedance.sdk.openadsdk.core.gb.c r0 = r0.a()
            int r9 = r0.c(r9)
            r0 = -1
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 0
            r5 = 1
            if (r8 == r0) goto L24
            if (r8 == r5) goto L25
            r0 = 2
            if (r8 == r0) goto L25
            if (r8 == r3) goto L25
            if (r8 == r2) goto L23
            if (r8 == r1) goto L23
            if (r9 != r3) goto L24
            r8 = 1
            goto L25
        L23:
            return r4
        L24:
            r8 = r9
        L25:
            if (r8 == r5) goto L2f
            if (r8 == r3) goto L2e
            if (r8 == r2) goto L2e
            if (r8 == r1) goto L2e
            goto L36
        L2e:
            return r4
        L2f:
            boolean r7 = com.bytedance.sdk.component.utils.ys.sr(r7)
            if (r7 != 0) goto L36
            return r4
        L36:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.gb.c.w.c(android.content.Context, int, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> xv(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                c cVar = new c();
                cVar.f33702c = c(optJSONObject.optString("package_name"));
                cVar.f33707w = optJSONObject.optInt("version_code");
                cVar.xv = optJSONObject.optString("version_name");
                cVar.sr = optJSONObject.optString(DownloadModel.DOWNLOAD_URL);
                cVar.ux = optJSONObject.optString("sign");
                cVar.ev = w(optJSONObject.optString("min_version"));
                cVar.gd = w(optJSONObject.optString("max_version"));
                cVar.f33705p = optJSONObject.optInt("plugin_update_network", -2);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void c(EventListener eventListener) {
        this.f33696f = eventListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Context context, List<c> list) {
        a.w("PluginUpdater", "Prepare to download");
        synchronized ("__tt_pl_up_lock__") {
            try {
            } catch (Exception e4) {
                com.bytedance.sdk.openadsdk.core.fz.a.c().c("", 6106, 0, "", 14, e4.getMessage(), 0L);
                a.sr("PluginUpdater", "Handle file error: " + e4);
            }
            if (!c(context)) {
                a.w("PluginUpdater", "Download quit, maybe other process is downloading");
                w(context);
                return;
            }
            a.w("PluginUpdater", "Start download: " + list.size());
            final CountDownLatch countDownLatch = new CountDownLatch(list.size());
            for (final c cVar : list) {
                ev.w(new p("pl download") { // from class: com.bytedance.sdk.openadsdk.core.gb.c.w.2
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.c(context, cVar);
                        countDownLatch.countDown();
                    }
                });
            }
            countDownLatch.await();
            a.w("PluginUpdater", "End download");
            w(context);
        }
    }

    private boolean w(c cVar, int i4) {
        c(cVar);
        return (i4 == 16 || i4 == 21 || i4 == 18) ? false : true;
    }

    private static boolean w(c cVar) {
        int w3;
        JSONObject optJSONObject;
        if (c(cVar)) {
            w3 = eq.f33190w;
        } else {
            w3 = (!k.sr().fz().has(cVar.f33702c) || (optJSONObject = k.sr().fz().optJSONObject(cVar.f33702c)) == null) ? 0 : w(optJSONObject.optString("sdk_version"));
        }
        return w3 >= cVar.ev && w3 <= cVar.gd;
    }

    public static String w() {
        String str;
        String c4 = com.bytedance.sdk.openadsdk.core.gb.w.w.c();
        if ("arm64-v8a".equals(c4)) {
            str = "@64";
        } else if ("armeabi-v7a".equals(c4)) {
            str = "@32";
        } else {
            str = "armeabi".equals(c4) ? "@armeabi" : "";
        }
        return "com.byted.live.lite" + str;
    }

    private static int w(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str.replace(".", ""));
            } catch (Exception unused) {
                return 0;
            }
        }
        return 0;
    }

    private boolean c(Context context) {
        try {
            File sr = sr(context);
            if (!sr.exists()) {
                sr.mkdirs();
            }
            File file = new File(sr, "update.lock");
            if (!file.exists()) {
                a.w("PluginUpdater", "create lock file");
                file.createNewFile();
            }
            if (!file.exists()) {
                a.sr("PluginUpdater", "create lock file failed");
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.sr = fileOutputStream;
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock != null && tryLock.isValid()) {
                return true;
            }
            a.sr("PluginUpdater", "Acquire file lock failed");
            this.sr.close();
            return false;
        } catch (Throwable th) {
            FileOutputStream fileOutputStream2 = this.sr;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            }
            a.sr("PluginUpdater", "Try get file lock failed:" + th);
            return false;
        }
    }

    private static boolean c(c cVar) {
        return "com.byted.pangle".equals(cVar.f33702c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, c cVar) {
        String str;
        int i4;
        int c4;
        String str2;
        try {
            if (!c(context, cVar.f33705p, cVar.f33702c)) {
                c4 = 20;
                str2 = k.sr().a() + ":" + cVar.f33705p;
            } else {
                c4 = c(context, sr(context), cVar);
                c(cVar, c4);
                str2 = "";
            }
            i4 = c4;
            str = str2;
        } catch (C0495w e4) {
            int c5 = e4.c();
            String message = e4.getMessage();
            c(cVar.f33702c, 1004);
            str = message;
            i4 = c5;
        }
        a.w("PluginUpdater", "Download (" + cVar.f33702c + "," + cVar.f33707w + "): " + i4 + ", " + str);
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(cVar.f33702c, c(cVar) ? 6106 : 0, cVar.f33707w, cVar.sr, i4, str, gd - ev);
    }

    private void c(c cVar, int i4) {
        if (this.f33696f == null || !w(cVar, i4)) {
            return;
        }
        ValueSet l4 = b.a().i(2, cVar.toString()).i(3, cVar.f33702c).l();
        boolean z3 = i4 == 6 || i4 == 10;
        try {
            ValueSet onEvent = this.f33696f.onEvent(1, com.bykv.c.c.c.c.a.a().e(z3).b(z3 ? 0 : 1004).c(l4).f());
            if (onEvent == null || !onEvent.booleanValue(4) || cVar.f33704k == null) {
                return;
            }
            HashMap<String, String> hashMap = f33694r;
            hashMap.put(cVar.f33702c, new File(cVar.f33704k).getName());
            c(cVar.f33702c, cVar.xv);
            a.w("PluginUpdater", "Add installed pkg: " + hashMap.values());
        } catch (Exception e4) {
            a.ux("PluginUpdater", "Download pl done, but install error:" + e4.getMessage());
        }
    }

    private static void c(String str, String str2) {
        if (str == null) {
            return;
        }
        k.sr().c(str, str2);
    }

    private static int c(Context context, File file, c cVar) throws C0495w {
        String str;
        if (cVar != null) {
            try {
                if (TextUtils.isEmpty(cVar.sr)) {
                    return 2;
                }
                if (TextUtils.isEmpty(cVar.f33702c)) {
                    return 12;
                }
                if (c(cVar) || k.sr().fz().has(cVar.f33702c)) {
                    if (xv(cVar)) {
                        return 18;
                    }
                    if (c(cVar.f33707w)) {
                        return 21;
                    }
                    if (w(cVar)) {
                        File f4 = f(context);
                        if (!f4.exists()) {
                            f4.mkdirs();
                        }
                        boolean z3 = true;
                        if (c(cVar) && eq.f33190w >= cVar.f33707w) {
                            int i4 = eq.f33190w;
                            cVar.gd = i4;
                            cVar.ev = i4;
                            cVar.f33706r = true;
                            c(new File(f4, ("-" + ux.w(cVar.f33702c) + "-" + eq.f33190w + "-" + eq.f33190w) + ".conf"), cVar);
                            return 10;
                        } else if (TextUtils.isEmpty(cVar.ux)) {
                            return 1;
                        } else {
                            String w3 = ux.w(cVar.f33702c);
                            String str2 = ux.w(cVar.ux) + "-" + w3 + "-" + cVar.ev + "-" + cVar.gd;
                            File ux2 = ux(context);
                            if (!ux2.exists()) {
                                ux2.mkdirs();
                            }
                            File file2 = new File(ux2, str2 + ".apk");
                            if (file2.exists()) {
                                cVar.f33703f = ux.c(file2);
                                cVar.f33704k = file2.getAbsolutePath();
                                return 16;
                            } else if (file2.getName().equals(f33694r.get(cVar.f33702c))) {
                                return 21;
                            } else {
                                com.bytedance.sdk.openadsdk.core.fz.a.c().c(cVar.f33702c, c(cVar) ? 6106 : 0, cVar.f33707w, cVar.sr, 7, "", 0L);
                                File file3 = new File(file, str2);
                                com.bytedance.sdk.component.ev.w.c sr = com.bytedance.sdk.openadsdk.core.q.ux.c().w().sr();
                                sr.c(cVar.sr);
                                sr.c(file.getAbsolutePath(), str2);
                                ev = System.currentTimeMillis();
                                com.bytedance.sdk.component.ev.w c4 = sr.c();
                                if (c4 != null && c4.ev()) {
                                    gd = System.currentTimeMillis();
                                    if (file3.exists()) {
                                        c(ux2, w3);
                                        c(f4, w3);
                                        if (file3.renameTo(file2)) {
                                            File file4 = new File(f4, file3.getName() + ".conf");
                                            cVar.f33703f = ux.c(file2);
                                            cVar.f33704k = file2.getAbsolutePath();
                                            if (cVar.f33707w >= sr(cVar)) {
                                                z3 = false;
                                            }
                                            cVar.f33706r = z3;
                                            return c(file4, cVar) ? 6 : 15;
                                        }
                                        return 5;
                                    }
                                    return 13;
                                }
                                if (c4 != null) {
                                    str = c4.c() + " : " + c4.w();
                                } else {
                                    str = "no response";
                                }
                                throw new C0495w(9, str);
                            }
                        }
                    }
                    return 19;
                }
                return 17;
            } catch (Exception e4) {
                a.sr("PluginUpdater", "Download file error: " + e4);
                if (e4 instanceof C0495w) {
                    throw e4;
                }
                throw new C0495w(14, e4.getMessage());
            }
        }
        return 2;
    }

    private static boolean c(int i4) {
        File c4 = com.bytedance.sdk.openadsdk.api.plugin.w.c(ls.getContext());
        if (c4 == null) {
            return false;
        }
        return new File(c4.getParent() + "/pangle_p/com.byted.pangle/version-" + i4).exists();
    }

    private static boolean c(File file, c cVar) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(cVar.toString());
            fileWriter.close();
            return true;
        } catch (IOException unused) {
            a.sr("PluginUpdater", "Write config failed;");
            return false;
        }
    }

    private static void c(File file, final String str) {
        file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.core.gb.c.w.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                if (str2 == null || !str2.contains(str)) {
                    return false;
                }
                new File(file2, str2).delete();
                a.sr("PluginUpdater", "Delete file: " + str2);
                return false;
            }
        });
    }

    public static String c(String str) {
        return ("com.byted.live.lite@64".equals(str) || "com.byted.live.lite@32".equals(str) || "com.byted.live.lite@armeabi".equals(str)) ? "com.byted.live.lite" : str;
    }

    public void c(String str, int i4) {
        if (this.f33696f == null) {
            return;
        }
        this.f33696f.onEvent(1, com.bykv.c.c.c.c.a.a().e(false).b(i4).c(b.a().i(3, str).l()).f());
    }
}
