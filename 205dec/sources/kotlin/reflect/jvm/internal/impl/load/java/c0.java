package kotlin.reflect.jvm.internal.impl.load.java;

import com.acse.ottn.f3;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: propertiesConventionUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c0 {
    @NotNull
    public static final List<kotlin.reflect.jvm.internal.impl.name.f> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        List<kotlin.reflect.jvm.internal.impl.name.f> N;
        f0.p(name, "name");
        String b4 = name.b();
        f0.o(b4, "name.asString()");
        if (x.c(b4)) {
            N = CollectionsKt__CollectionsKt.N(b(name));
            return N;
        } else if (x.d(b4)) {
            return f(name);
        } else {
            return f.f56733a.b(name);
        }
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.name.f b(@NotNull kotlin.reflect.jvm.internal.impl.name.f methodName) {
        f0.p(methodName, "methodName");
        kotlin.reflect.jvm.internal.impl.name.f e4 = e(methodName, f3.f5657f, false, null, 12, null);
        return e4 == null ? e(methodName, "is", false, null, 8, null) : e4;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.name.f c(@NotNull kotlin.reflect.jvm.internal.impl.name.f methodName, boolean z3) {
        f0.p(methodName, "methodName");
        return e(methodName, f3.f5659h, false, z3 ? "is" : null, 4, null);
    }

    private static final kotlin.reflect.jvm.internal.impl.name.f d(kotlin.reflect.jvm.internal.impl.name.f fVar, String str, boolean z3, String str2) {
        boolean u22;
        String c4;
        String c42;
        if (fVar.g()) {
            return null;
        }
        String identifier = fVar.getIdentifier();
        f0.o(identifier, "methodName.identifier");
        boolean z4 = false;
        u22 = kotlin.text.w.u2(identifier, str, false, 2, null);
        if (u22 && identifier.length() != str.length()) {
            char charAt = identifier.charAt(str.length());
            if ('a' <= charAt && charAt < '{') {
                z4 = true;
            }
            if (z4) {
                return null;
            }
            if (str2 != null) {
                c42 = kotlin.text.x.c4(identifier, str);
                return kotlin.reflect.jvm.internal.impl.name.f.f(f0.C(str2, c42));
            } else if (z3) {
                c4 = kotlin.text.x.c4(identifier, str);
                String c5 = s2.a.c(c4, true);
                if (kotlin.reflect.jvm.internal.impl.name.f.h(c5)) {
                    return kotlin.reflect.jvm.internal.impl.name.f.f(c5);
                }
                return null;
            } else {
                return fVar;
            }
        }
        return null;
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f e(kotlin.reflect.jvm.internal.impl.name.f fVar, String str, boolean z3, String str2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = true;
        }
        if ((i4 & 8) != 0) {
            str2 = null;
        }
        return d(fVar, str, z3, str2);
    }

    @NotNull
    public static final List<kotlin.reflect.jvm.internal.impl.name.f> f(@NotNull kotlin.reflect.jvm.internal.impl.name.f methodName) {
        List<kotlin.reflect.jvm.internal.impl.name.f> O;
        f0.p(methodName, "methodName");
        O = CollectionsKt__CollectionsKt.O(c(methodName, false), c(methodName, true));
        return O;
    }
}
