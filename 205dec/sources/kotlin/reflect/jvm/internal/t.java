package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.calls.d;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KPropertyImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0005H\u0002\"\"\u0010\n\u001a\u0004\u0018\u00010\u0007*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/s$a;", "", "isGetter", "Lkotlin/reflect/jvm/internal/calls/c;", "b", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "g", "", "f", "(Lkotlin/reflect/jvm/internal/s$a;)Ljava/lang/Object;", "boundReceiver", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.calls.c<?> b(kotlin.reflect.jvm.internal.s.a<?, ?> r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.t.b(kotlin.reflect.jvm.internal.s$a, boolean):kotlin.reflect.jvm.internal.calls.c");
    }

    private static final kotlin.reflect.jvm.internal.calls.d<Field> c(s.a<?, ?> aVar, boolean z3, Field field) {
        kotlin.reflect.jvm.internal.calls.d<Field> aVar2;
        if (g(aVar.M().I()) || !Modifier.isStatic(field.getModifiers())) {
            if (z3) {
                if (!aVar.K()) {
                    return new d.f.c(field);
                }
                aVar2 = new d.f.a(field, f(aVar));
            } else {
                aVar2 = aVar.K() ? new d.g.a(field, e(aVar), f(aVar)) : new d.g.c(field, e(aVar));
            }
        } else if (d(aVar)) {
            if (z3) {
                return aVar.K() ? new d.f.b(field) : new d.f.C1110d(field);
            }
            aVar2 = aVar.K() ? new d.g.b(field, e(aVar)) : new d.g.C1111d(field, e(aVar));
        } else if (z3) {
            return new d.f.e(field);
        } else {
            aVar2 = new d.g.e(field, e(aVar));
        }
        return aVar2;
    }

    private static final boolean d(s.a<?, ?> aVar) {
        return aVar.M().I().getAnnotations().i(f0.j());
    }

    private static final boolean e(s.a<?, ?> aVar) {
        return !h1.m(aVar.M().I().getType());
    }

    @Nullable
    public static final Object f(@NotNull s.a<?, ?> aVar) {
        kotlin.jvm.internal.f0.p(aVar, "<this>");
        return aVar.M().N();
    }

    private static final boolean g(p0 p0Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration = p0Var.b();
        kotlin.jvm.internal.f0.o(containingDeclaration, "containingDeclaration");
        if (kotlin.reflect.jvm.internal.impl.resolve.d.x(containingDeclaration)) {
            kotlin.reflect.jvm.internal.impl.descriptors.k b4 = containingDeclaration.b();
            return !(kotlin.reflect.jvm.internal.impl.resolve.d.C(b4) || kotlin.reflect.jvm.internal.impl.resolve.d.t(b4)) || ((p0Var instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i) && kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f(((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i) p0Var).d0()));
        }
        return false;
    }
}
