package com.bxkj.base.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0002¨\u0006\f"}, m12616d2 = {"Lcom/bxkj/base/util/k;", "", "", "property", "defaultValue", "c", "", "d", "b", "a", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.util.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class HarmonyUtils {
    @NotNull

    /* renamed from: a */
    public static final HarmonyUtils f14924a = new HarmonyUtils();

    private HarmonyUtils() {
    }

    /* renamed from: c */
    private final String m44072c(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method declaredMethod = cls.getDeclaredMethod("get", String.class);
            C14342f0.m8185o(declaredMethod, "spClz.getDeclaredMethod(\"get\", String::class.java)");
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
    /* renamed from: a */
    public final String m44074a() {
        return Build.DISPLAY;
    }

    @Nullable
    /* renamed from: b */
    public final String m44073b() {
        return m44072c("hw_sc.build.platform.version", "");
    }

    /* renamed from: d */
    public final boolean m44071d() {
        boolean m6604K1;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            m6604K1 = StringsJVM.m6604K1("Harmony", cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString(), true);
            return m6604K1;
        } catch (Throwable unused) {
            return false;
        }
    }
}
