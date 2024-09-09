package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import i2.a;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectJavaModifierListOwner.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface v extends m2.s {

    /* compiled from: ReflectJavaModifierListOwner.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull
        public static i1 a(@NotNull v vVar) {
            f0.p(vVar, "this");
            int F = vVar.F();
            if (Modifier.isPublic(F)) {
                return h1.h.f56285c;
            }
            if (Modifier.isPrivate(F)) {
                return h1.e.f56282c;
            }
            if (Modifier.isProtected(F)) {
                return Modifier.isStatic(F) ? a.c.f54764c : a.b.f54763c;
            }
            return a.C1079a.f54762c;
        }

        public static boolean b(@NotNull v vVar) {
            f0.p(vVar, "this");
            return Modifier.isAbstract(vVar.F());
        }

        public static boolean c(@NotNull v vVar) {
            f0.p(vVar, "this");
            return Modifier.isFinal(vVar.F());
        }

        public static boolean d(@NotNull v vVar) {
            f0.p(vVar, "this");
            return Modifier.isStatic(vVar.F());
        }
    }

    int F();
}
