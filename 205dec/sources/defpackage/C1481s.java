package defpackage;

import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.AfterInvocation;
import io.github.libxposed.api.annotations.XposedHooker;

@XposedHooker
/* renamed from: s  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1481s implements XposedInterface.Hooker {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ClassLoader f64365a;

    @AfterInvocation
    public static void a() {
        AbstractC1457e.d("ZygoteInit#handleSystemServerProcess() starts");
        try {
            f64365a = Thread.currentThread().getContextClassLoader();
            AbstractC1457e.a("system_server", f64365a);
            AbstractC1457e.c(H0.class, Class.forName("com.android.server.SystemServer", false, f64365a), "startBootstrapServices");
        } catch (Throwable th) {
            AbstractC1457e.e("error when hooking systemMain", th);
        }
    }
}
