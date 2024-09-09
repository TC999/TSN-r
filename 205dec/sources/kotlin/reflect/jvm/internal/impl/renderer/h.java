package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: RenderingUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull
    public static final String a(@NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        f0.p(dVar, "<this>");
        List<kotlin.reflect.jvm.internal.impl.name.f> h4 = dVar.h();
        f0.o(h4, "pathSegments()");
        return c(h4);
    }

    @NotNull
    public static final String b(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
        f0.p(fVar, "<this>");
        if (!d(fVar)) {
            String b4 = fVar.b();
            f0.o(b4, "asString()");
            return b4;
        }
        String b5 = fVar.b();
        f0.o(b5, "asString()");
        return f0.C('`' + b5, "`");
    }

    @NotNull
    public static final String c(@NotNull List<kotlin.reflect.jvm.internal.impl.name.f> pathSegments) {
        f0.p(pathSegments, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (kotlin.reflect.jvm.internal.impl.name.f fVar : pathSegments) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(b(fVar));
        }
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final boolean d(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        boolean z3;
        boolean z4;
        if (fVar.g()) {
            return false;
        }
        String b4 = fVar.b();
        f0.o(b4, "asString()");
        if (!g.f57792a.contains(b4)) {
            int i4 = 0;
            while (true) {
                if (i4 >= b4.length()) {
                    z3 = false;
                    break;
                }
                char charAt = b4.charAt(i4);
                i4++;
                if (Character.isLetterOrDigit(charAt) || charAt == '_') {
                    z4 = false;
                    continue;
                } else {
                    z4 = true;
                    continue;
                }
                if (z4) {
                    z3 = true;
                    break;
                }
            }
            if (!z3) {
                return false;
            }
        }
        return true;
    }
}
