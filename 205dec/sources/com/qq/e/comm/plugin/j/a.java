package com.qq.e.comm.plugin.j;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.GDTFileProvider;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class f44491a;

    /* renamed from: b  reason: collision with root package name */
    private static Class f44492b;

    /* renamed from: c  reason: collision with root package name */
    private static Class f44493c;

    static {
        try {
            f44491a = Class.forName("androidx.core.content.FileProvider");
        } catch (ClassNotFoundException unused) {
            f44491a = null;
        }
        try {
            f44492b = Class.forName("android.support.v4.content.FileProvider");
        } catch (ClassNotFoundException unused2) {
            f44492b = null;
        }
        try {
            f44493c = Class.forName("com.qq.e.comm.GDTFileProvider");
        } catch (ClassNotFoundException unused3) {
            f44493c = null;
        }
    }

    public static Uri a(Context context, File file) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 29 && (i4 < 24 || context.getApplicationInfo().targetSdkVersion < 24)) {
            return Uri.fromFile(file);
        }
        String packageName = context.getPackageName();
        Uri a4 = a(context, packageName + ".fileprovider", file);
        if (a4 == null || TextUtils.isEmpty(a4.getPath())) {
            a4 = a(context, packageName + ".gdt.fileprovider", file);
        }
        if (a4 == null || (TextUtils.isEmpty(a4.getPath()) && f44493c != null)) {
            return GDTFileProvider.getUriForFile(context, packageName + ".gdt.fileprovider", file);
        }
        return a4;
    }

    private static Uri a(Context context, String str, File file) {
        Method method;
        Uri uri = Uri.EMPTY;
        try {
            if (f44491a != null) {
                method = f44491a.getMethod("getUriForFile", Context.class, String.class, File.class);
                d1.a("FileProvider androidx support->androidx", new Object[0]);
            } else if (f44492b != null) {
                method = f44492b.getMethod("getUriForFile", Context.class, String.class, File.class);
                d1.a("FileProvider support support->androidx", new Object[0]);
            } else {
                method = null;
            }
            return method != null ? (Uri) method.invoke(null, context, str, file) : uri;
        } catch (Throwable th) {
            d1.a(th.getMessage(), th);
            return uri;
        }
    }
}
