package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.g;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.u;
import kotlin.reflect.r;
import kotlin.reflect.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: KTypesJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\"\"\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00078@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lkotlin/reflect/r;", "Lkotlin/reflect/d;", "b", "(Lkotlin/reflect/r;)Lkotlin/reflect/d;", "getJvmErasure$annotations", "(Lkotlin/reflect/r;)V", "jvmErasure", "Lkotlin/reflect/g;", "a", "(Lkotlin/reflect/g;)Lkotlin/reflect/d;", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KTypesJvm")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final kotlin.reflect.d<?> a(@NotNull g gVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
        Object r22;
        boolean z3;
        f0.p(gVar, "<this>");
        if (gVar instanceof kotlin.reflect.d) {
            return (kotlin.reflect.d) gVar;
        }
        if (gVar instanceof s) {
            List<r> upperBounds = ((s) gVar).getUpperBounds();
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                f b4 = ((u) ((r) next)).getType().H0().b();
                dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
                if (dVar == null || dVar.i() == ClassKind.INTERFACE || dVar.i() == ClassKind.ANNOTATION_CLASS) {
                    z3 = false;
                    continue;
                } else {
                    z3 = true;
                    continue;
                }
                if (z3) {
                    dVar = next;
                    break;
                }
            }
            r rVar = (r) dVar;
            if (rVar == null) {
                r22 = kotlin.collections.f0.r2(upperBounds);
                rVar = (r) r22;
            }
            return rVar == null ? n0.d(Object.class) : b(rVar);
        }
        throw new KotlinReflectionInternalError(f0.C("Cannot calculate JVM erasure for type: ", gVar));
    }

    @NotNull
    public static final kotlin.reflect.d<?> b(@NotNull r rVar) {
        f0.p(rVar, "<this>");
        g a4 = rVar.a();
        if (a4 != null) {
            return a(a4);
        }
        throw new KotlinReflectionInternalError(f0.C("Cannot calculate JVM erasure for type: ", rVar));
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void c(r rVar) {
    }
}
