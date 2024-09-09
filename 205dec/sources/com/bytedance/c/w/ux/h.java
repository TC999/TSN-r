package com.bytedance.c.w.ux;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.c.w.b;
import com.bytedance.c.w.xv;
import com.bytedance.sdk.openadsdk.api.plugin.w;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private Context f26637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str != null && str.endsWith(".npth");
        }
    }

    public h(Context context) {
        this.f26637a = context;
    }

    private xv a(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return xv.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return xv.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return xv.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return xv.JAVA;
            }
        }
        return null;
    }

    private void b() {
        try {
            SharedPreferences w3 = w.w(this.f26637a, "npth", 0);
            long j4 = w3.getLong("history_time", -1L);
            if (j4 < 0) {
                w3.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j4 > 86400000) {
                b.m.f(b.f.c(this.f26637a));
                w3.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Nullable
    private File[] d(File file, String str) {
        if (file.exists()) {
            if (TextUtils.isEmpty(str)) {
                return file.listFiles();
            }
            return file.listFiles(new a());
        }
        return null;
    }

    private void e() {
        File[] d4 = d(b.f.a(this.f26637a), ".npth");
        if (d4 == null) {
            return;
        }
        Arrays.sort(d4, Collections.reverseOrder());
        for (int i4 = 0; i4 < d4.length && i4 < 50; i4++) {
            File file = d4[i4];
            try {
                if (w0.a.a().d(file.getAbsolutePath())) {
                    b.m.f(file);
                } else {
                    com.bytedance.c.w.xv.c i5 = b.m.i(file.getAbsolutePath());
                    if (i5 != null && i5.e() != null) {
                        JSONObject e4 = i5.e();
                        a(file.getName(), e4);
                        i5.e().put("upload_scene", "launch_scan");
                        if (com.bytedance.c.w.r.w.d(i5.a(), e4.toString(), i5.g()).a() && !b.m.f(file)) {
                            w0.a.a().c(x0.a.a(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e5) {
                b.k.c(e5);
            }
        }
    }

    public void c(boolean z3) {
        b();
        if (z3) {
            e();
        }
    }
}
