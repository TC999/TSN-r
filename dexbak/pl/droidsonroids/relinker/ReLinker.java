package pl.droidsonroids.relinker;

import android.content.Context;
import java.io.File;

/* renamed from: pl.droidsonroids.relinker.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ReLinker {

    /* compiled from: ReLinker.java */
    /* renamed from: pl.droidsonroids.relinker.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15462a {
        /* renamed from: a */
        void mo2351a(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance);
    }

    /* compiled from: ReLinker.java */
    /* renamed from: pl.droidsonroids.relinker.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15463b {
        /* renamed from: a */
        String mo2335a(String str);

        /* renamed from: b */
        String mo2334b(String str);

        /* renamed from: c */
        String[] mo2333c();

        /* renamed from: d */
        void mo2332d(String str);

        void loadLibrary(String str);
    }

    /* compiled from: ReLinker.java */
    /* renamed from: pl.droidsonroids.relinker.c$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15464c {
        /* renamed from: a */
        void m2350a(Throwable th);

        void success();
    }

    /* compiled from: ReLinker.java */
    /* renamed from: pl.droidsonroids.relinker.c$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15465d {
        void log(String str);
    }

    private ReLinker() {
    }

    /* renamed from: a */
    public static ReLinkerInstance m2358a() {
        return new ReLinkerInstance().m2347c();
    }

    /* renamed from: b */
    public static void m2357b(Context context, String str) {
        m2355d(context, str, null, null);
    }

    /* renamed from: c */
    public static void m2356c(Context context, String str, String str2) {
        m2355d(context, str, str2, null);
    }

    /* renamed from: d */
    public static void m2355d(Context context, String str, String str2, InterfaceC15464c interfaceC15464c) {
        new ReLinkerInstance().m2342h(context, str, str2, interfaceC15464c);
    }

    /* renamed from: e */
    public static void m2354e(Context context, String str, InterfaceC15464c interfaceC15464c) {
        m2355d(context, str, null, interfaceC15464c);
    }

    /* renamed from: f */
    public static ReLinkerInstance m2353f(InterfaceC15465d interfaceC15465d) {
        return new ReLinkerInstance().m2339k(interfaceC15465d);
    }

    /* renamed from: g */
    public static ReLinkerInstance m2352g() {
        return new ReLinkerInstance().m2336n();
    }
}
