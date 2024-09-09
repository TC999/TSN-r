package com.bxkj.student.v2.common.utils;

import android.os.Debug;
import android.os.Process;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AppSecretUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/student/v2/common/utils/c;", "", "", "d", "e", "Lkotlin/f1;", "b", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f23337a = new c();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        while (true) {
            try {
                Thread.sleep(100L);
                if (Debug.isDebuggerConnected()) {
                    com.orhanobut.logger.j.d("\u975eDebug \u7f16\u8bd1\uff0c\u53cd\u8c03\u8bd5\u68c0\u6d4b", new Object[0]);
                    System.exit(0);
                }
                if (f23337a.e()) {
                    com.orhanobut.logger.j.d("\u975eDebug \u7f16\u8bd1\uff0c\u53cd\u8c03\u8bd5\u68c0\u6d4b", new Object[0]);
                    System.exit(0);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    private final boolean d() {
        return (BaseApp.b().getApplicationInfo().flags & 2) != 0;
    }

    private final boolean e() {
        boolean V2;
        List T4;
        String format = String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()));
        f0.o(format, "format(Locale.US, \"/proc\u2026status\", Process.myPid())");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(format)));
            while (true) {
                String it = bufferedReader.readLine();
                f0.o(it, "it");
                if (it != null) {
                    V2 = x.V2(it, "TracerPid", false, 2, null);
                    if (V2) {
                        T4 = x.T4(it, new String[]{":"}, false, 0, 6, null);
                        Object[] array = T4.toArray(new String[0]);
                        if (array != null) {
                            String[] strArr = (String[]) array;
                            if (strArr.length == 2) {
                                String str = strArr[1];
                                int length = str.length() - 1;
                                int i4 = 0;
                                boolean z3 = false;
                                while (i4 <= length) {
                                    boolean z4 = f0.t(str.charAt(!z3 ? i4 : length), 32) <= 0;
                                    if (z3) {
                                        if (!z4) {
                                            break;
                                        }
                                        length--;
                                    } else if (z4) {
                                        i4++;
                                    } else {
                                        z3 = true;
                                    }
                                }
                                if (Integer.parseInt(str.subSequence(i4, length + 1).toString()) != 0) {
                                    return true;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        }
                    }
                } else {
                    bufferedReader.close();
                    break;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final void b() {
        if (!d()) {
            new Thread(new Runnable() { // from class: com.bxkj.student.v2.common.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.c();
                }
            }, "SafeGuardThread").start();
            if (!e()) {
                if (!l.f23373a.d()) {
                    TsnSecret tsnSecret = TsnSecret.f16433a;
                    BaseApp b4 = BaseApp.b();
                    f0.o(b4, "getApp()");
                    if (tsnSecret.checkSignature(b4)) {
                        return;
                    }
                    com.orhanobut.logger.j.d("\u53cd\u7f16\u8bd1\u975e\u6b63\u7248\u5e94\u7528", new Object[0]);
                    System.exit(0);
                    throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
                }
                com.orhanobut.logger.j.d("root\u8bbe\u5907\uff0c\u53cd\u8c03\u8bd5\u68c0\u6d4b", new Object[0]);
                System.exit(0);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            }
            com.orhanobut.logger.j.d("\u975eDebug \u7f16\u8bd1\uff0c\u53cd\u8c03\u8bd5\u68c0\u6d4b", new Object[0]);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        com.orhanobut.logger.j.d("\u975eDebug \u7f16\u8bd1\uff0c\u53cd\u8c03\u8bd5\u68c0\u6d4b", new Object[0]);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
