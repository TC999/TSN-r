package kotlin.reflect.jvm.internal.impl.types;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class m0 extends l1 implements r2.i, r2.k {
    public m0() {
        super(null);
    }

    @NotNull
    public abstract m0 O0(boolean z3);

    @NotNull
    public abstract m0 P0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar);

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            kotlin.text.t.j0(sb, "[", kotlin.reflect.jvm.internal.impl.renderer.b.u(kotlin.reflect.jvm.internal.impl.renderer.b.f57732j, it.next(), null, 2, null), "] ");
        }
        sb.append(H0());
        if (!G0().isEmpty()) {
            kotlin.collections.w.V2(G0(), sb, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (I0()) {
            sb.append("?");
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
