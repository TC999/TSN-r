package m2;

import java.util.Iterator;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: javaElements.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface d0 extends d {

    /* compiled from: javaElements.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable
        public static m2.a a(@NotNull d0 d0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            Object obj;
            f0.p(d0Var, "this");
            f0.p(fqName, "fqName");
            Iterator<T> it = d0Var.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                kotlin.reflect.jvm.internal.impl.name.b c4 = ((m2.a) next).c();
                if (f0.g(c4 != null ? c4.b() : null, fqName)) {
                    obj = next;
                    break;
                }
            }
            return (m2.a) obj;
        }
    }
}
