package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static Context f51827a;

    public static final Context a() {
        Context context = f51827a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final File d() {
        Context a4 = a();
        if (a4 != null) {
            return a4.getCacheDir();
        }
        return null;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final void a(Context context) {
        f51827a = context;
    }

    public static final File a(String str) {
        return m.h(a(), str);
    }
}
