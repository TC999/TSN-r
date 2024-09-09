package pl.droidsonroids.relinker;

import android.content.Context;
import java.io.File;

/* compiled from: ReLinker.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class c {

    /* compiled from: ReLinker.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, pl.droidsonroids.relinker.d dVar);
    }

    /* compiled from: ReLinker.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public interface b {
        String a(String str);

        String b(String str);

        String[] c();

        void d(String str);

        void loadLibrary(String str);
    }

    /* compiled from: ReLinker.java */
    /* renamed from: pl.droidsonroids.relinker.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public interface InterfaceC1254c {
        void a(Throwable th);

        void success();
    }

    /* compiled from: ReLinker.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public interface d {
        void log(String str);
    }

    private c() {
    }

    public static pl.droidsonroids.relinker.d a() {
        return new pl.droidsonroids.relinker.d().c();
    }

    public static void b(Context context, String str) {
        d(context, str, null, null);
    }

    public static void c(Context context, String str, String str2) {
        d(context, str, str2, null);
    }

    public static void d(Context context, String str, String str2, InterfaceC1254c interfaceC1254c) {
        new pl.droidsonroids.relinker.d().h(context, str, str2, interfaceC1254c);
    }

    public static void e(Context context, String str, InterfaceC1254c interfaceC1254c) {
        d(context, str, null, interfaceC1254c);
    }

    public static pl.droidsonroids.relinker.d f(d dVar) {
        return new pl.droidsonroids.relinker.d().k(dVar);
    }

    public static pl.droidsonroids.relinker.d g() {
        return new pl.droidsonroids.relinker.d().n();
    }
}
