package com.bxkj.student.p094v2.common.utils;

import android.os.Debug;
import android.os.Process;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.orhanobut.logger.C11792j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.C14579x;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\t"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/c;", "", "", "d", "e", "Lkotlin/f1;", "b", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AppSecretUtils {
    @NotNull

    /* renamed from: a */
    public static final AppSecretUtils f20093a = new AppSecretUtils();

    private AppSecretUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static final void m39146c() {
        while (true) {
            try {
                Thread.sleep(100L);
                if (Debug.isDebuggerConnected()) {
                    C11792j.m20469d("非Debug 编译，反调试检测", new Object[0]);
                    System.exit(0);
                }
                if (f20093a.m39144e()) {
                    C11792j.m20469d("非Debug 编译，反调试检测", new Object[0]);
                    System.exit(0);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: d */
    private final boolean m39145d() {
        return (BaseApp.m44341b().getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: e */
    private final boolean m39144e() {
        boolean m6465V2;
        List m6471T4;
        String format = String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()));
        C14342f0.m8185o(format, "format(Locale.US, \"/proc…status\", Process.myPid())");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(format)));
            while (true) {
                String it = bufferedReader.readLine();
                C14342f0.m8185o(it, "it");
                if (it != null) {
                    m6465V2 = C14579x.m6465V2(it, "TracerPid", false, 2, null);
                    if (m6465V2) {
                        m6471T4 = C14579x.m6471T4(it, new String[]{":"}, false, 0, 6, null);
                        Object[] array = m6471T4.toArray(new String[0]);
                        if (array != null) {
                            String[] strArr = (String[]) array;
                            if (strArr.length == 2) {
                                String str = strArr[1];
                                int length = str.length() - 1;
                                int i = 0;
                                boolean z = false;
                                while (i <= length) {
                                    boolean z2 = C14342f0.m8180t(str.charAt(!z ? i : length), 32) <= 0;
                                    if (z) {
                                        if (!z2) {
                                            break;
                                        }
                                        length--;
                                    } else if (z2) {
                                        i++;
                                    } else {
                                        z = true;
                                    }
                                }
                                if (Integer.parseInt(str.subSequence(i, length + 1).toString()) != 0) {
                                    return true;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
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

    /* renamed from: b */
    public final void m39147b() {
        if (!m39145d()) {
            new Thread(new Runnable() { // from class: com.bxkj.student.v2.common.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    AppSecretUtils.m39146c();
                }
            }, "SafeGuardThread").start();
            if (!m39144e()) {
                TsnSecret tsnSecret = TsnSecret.f13210a;
                BaseApp m44341b = BaseApp.m44341b();
                C14342f0.m8185o(m44341b, "getApp()");
                if (tsnSecret.checkSignature(m44341b)) {
                    return;
                }
                C11792j.m20469d("反编译非正版应用", new Object[0]);
                System.exit(0);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            }
            C11792j.m20469d("非Debug 编译，反调试检测", new Object[0]);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        C11792j.m20469d("非Debug 编译，反调试检测", new Object[0]);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
