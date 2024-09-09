package com.bxkj.base.util;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.f3;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: HarmonyUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\f"}, d2 = {"Lcom/bxkj/base/util/k;", "", "", "property", "defaultValue", "c", "", "d", "b", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final k f18408a = new k();

    private k() {
    }

    private final String c(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method declaredMethod = cls.getDeclaredMethod(f3.f5657f, String.class);
            f0.o(declaredMethod, "spClz.getDeclaredMethod(\"get\", String::class.java)");
            Object invoke = declaredMethod.invoke(cls, str);
            if (invoke != null) {
                String str3 = (String) invoke;
                return TextUtils.isEmpty(str3) ? str2 : str3;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    @Nullable
    public final String a() {
        return Build.DISPLAY;
    }

    @Nullable
    public final String b() {
        return c("hw_sc.build.platform.version", "");
    }

    public final boolean d() {
        boolean K1;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            K1 = kotlin.text.w.K1("Harmony", cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString(), true);
            return K1;
        } catch (Throwable unused) {
            return false;
        }
    }
}
