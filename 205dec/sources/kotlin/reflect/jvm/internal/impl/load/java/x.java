package kotlin.reflect.jvm.internal.impl.load.java;

import com.acse.ottn.f3;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: JvmAbi.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final x f57101a = new x();
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.name.c f57102b = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.JvmField");
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f57103c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f57104d;

    static {
        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        f0.o(m4, "topLevel(FqName(\"kotlin.\u2026.ReflectionFactoryImpl\"))");
        f57103c = m4;
        kotlin.reflect.jvm.internal.impl.name.b e4 = kotlin.reflect.jvm.internal.impl.name.b.e("kotlin/jvm/internal/RepeatableContainer");
        f0.o(e4, "fromString(\"kotlin/jvm/i\u2026nal/RepeatableContainer\")");
        f57104d = e4;
    }

    private x() {
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String propertyName) {
        f0.p(propertyName, "propertyName");
        return f(propertyName) ? propertyName : f0.C(f3.f5657f, s2.a.a(propertyName));
    }

    @JvmStatic
    public static final boolean c(@NotNull String name) {
        boolean u22;
        boolean u23;
        f0.p(name, "name");
        u22 = kotlin.text.w.u2(name, f3.f5657f, false, 2, null);
        if (!u22) {
            u23 = kotlin.text.w.u2(name, "is", false, 2, null);
            if (!u23) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final boolean d(@NotNull String name) {
        boolean u22;
        f0.p(name, "name");
        u22 = kotlin.text.w.u2(name, f3.f5659h, false, 2, null);
        return u22;
    }

    @JvmStatic
    @NotNull
    public static final String e(@NotNull String propertyName) {
        String a4;
        f0.p(propertyName, "propertyName");
        if (f(propertyName)) {
            a4 = propertyName.substring(2);
            f0.o(a4, "this as java.lang.String).substring(startIndex)");
        } else {
            a4 = s2.a.a(propertyName);
        }
        return f0.C(f3.f5659h, a4);
    }

    @JvmStatic
    public static final boolean f(@NotNull String name) {
        boolean u22;
        f0.p(name, "name");
        u22 = kotlin.text.w.u2(name, "is", false, 2, null);
        if (u22 && name.length() != 2) {
            char charAt = name.charAt(2);
            return f0.t(97, charAt) > 0 || f0.t(charAt, 122) > 0;
        }
        return false;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b a() {
        return f57104d;
    }
}
