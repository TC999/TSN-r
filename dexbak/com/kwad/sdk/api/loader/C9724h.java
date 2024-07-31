package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.C9698a;
import com.kwad.sdk.api.p367a.AbstractRunnableC9699a;
import com.kwad.sdk.api.p367a.C9700b;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.api.loader.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9724h {
    private static File amn;

    /* renamed from: aC */
    private static File m27929aC(Context context) {
        if (amn == null) {
            amn = m27927i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return amn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static void m27928h(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                m27928h(file2);
            }
        }
        file.delete();
    }

    /* renamed from: i */
    private static File m27927i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!(file.exists() && file.isDirectory()) && C9698a.f29505md.booleanValue()) {
            throw new RuntimeException("Can not ensureDir:" + file);
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static void m27926j(File file) {
        try {
            m27928h(file);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static File m27925p(Context context, String str) {
        File m27929aC = m27929aC(context);
        return new File(m27929aC, "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static String m27924q(Context context, String str) {
        File m27929aC = m27929aC(context);
        return m27927i(new File(m27929aC, "apk-" + str)).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static File m27923r(Context context, String str) {
        File m27929aC = m27929aC(context);
        return m27927i(new File(m27929aC, "apk-" + str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public static String m27922s(Context context, String str) {
        return new File(m27924q(context, str), "dynamic.apk").getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public static String m27921t(Context context, String str) {
        return m27927i(new File(m27924q(context, str), "dex")).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public static String m27920u(Context context, String str) {
        return m27927i(new File(m27924q(context, str), "libs")).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public static void m27919v(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C9700b.m28021a(new AbstractRunnableC9699a() { // from class: com.kwad.sdk.api.loader.h.1
            @Override // com.kwad.sdk.api.p367a.AbstractRunnableC9699a
            public final void doTask() {
                try {
                    File[] listFiles = C9724h.m27923r(context, str).getParentFile().listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        return;
                    }
                    for (File file : listFiles) {
                        if (C9723g.m27937K(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            C9724h.m27928h(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
