package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C13061g {

    /* renamed from: a */
    private static Context f37427a;

    /* renamed from: a */
    public static final Context m15027a() {
        Context context = f37427a;
        if (context == null) {
            return null;
        }
        return context;
    }

    /* renamed from: b */
    public static final String m15024b() {
        return m15027a() == null ? "" : m15027a().getPackageName();
    }

    /* renamed from: c */
    public static final File m15023c() {
        if (m15027a() == null) {
            return null;
        }
        return m15027a().getFilesDir();
    }

    /* renamed from: d */
    public static final File m15022d() {
        Context m15027a = m15027a();
        if (m15027a != null) {
            return m15027a.getCacheDir();
        }
        return null;
    }

    /* renamed from: e */
    public static final File m15021e() {
        return m15025a((String) null);
    }

    /* renamed from: a */
    public static final void m15026a(Context context) {
        f37427a = context;
    }

    /* renamed from: a */
    public static final File m15025a(String str) {
        return C13071m.m14923h(m15027a(), str);
    }
}
