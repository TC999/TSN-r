package com.qq.e.comm.plugin.d0.c;

import android.content.Context;
import com.qq.e.comm.plugin.util.b1;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42235a = b1.a("e_qq_com_plugin");

    /* renamed from: b  reason: collision with root package name */
    private static final String f42236b = b1.a("e_qq_com_plugin", com.qq.e.comm.plugin.d0.a.d().a().getPackageName());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(Context context) {
        return context.getDir(f42236b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File b(Context context) {
        return new File(a(context), "gdt_plugin.jar");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File c(Context context) {
        return new File(a(context), "gdt_plugin.jar.sig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File d(Context context) {
        return new File(f(context), "gdt_plugin.next");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File e(Context context) {
        return new File(f(context), "gdt_plugin.next.sig");
    }

    private static File f(Context context) {
        return context.getDir(f42235a, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File g(Context context) {
        return new File(f(context), "gdt_plugin.tmp");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File h(Context context) {
        return new File(f(context), "gdt_plugin.tmp.sig");
    }
}
