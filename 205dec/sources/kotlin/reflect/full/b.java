package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.e0;
import kotlin.collections.o;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import org.jetbrains.annotations.NotNull;

/* compiled from: KAnnotatedElements.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0087\b\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0087\b\u001a\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0087\b\u001a*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0007\u00a8\u0006\f"}, d2 = {"", "T", "Lkotlin/reflect/b;", "a", "(Lkotlin/reflect/b;)Ljava/lang/annotation/Annotation;", "", "d", "", "b", "Lkotlin/reflect/d;", "klass", "c", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KAnnotatedElements")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    @SinceKotlin(version = "1.1")
    public static final /* synthetic */ <T extends Annotation> T a(kotlin.reflect.b bVar) {
        Object obj;
        f0.p(bVar, "<this>");
        Iterator<T> it = bVar.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            f0.y(3, "T");
            if (((Annotation) obj) instanceof Annotation) {
                break;
            }
        }
        f0.y(1, "T?");
        return (T) obj;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalStdlibApi
    public static final /* synthetic */ <T extends Annotation> List<T> b(kotlin.reflect.b bVar) {
        f0.p(bVar, "<this>");
        f0.y(4, "T");
        return c(bVar, n0.d(Annotation.class));
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalStdlibApi
    @NotNull
    public static final <T extends Annotation> List<T> c(@NotNull kotlin.reflect.b bVar, @NotNull kotlin.reflect.d<T> klass) {
        List<T> a12;
        List<T> F;
        Object obj;
        List<T> t3;
        f0.p(bVar, "<this>");
        f0.p(klass, "klass");
        a12 = e0.a1(bVar.getAnnotations(), c2.a.c(klass));
        if (!a12.isEmpty()) {
            return a12;
        }
        Class<? extends Annotation> c4 = a.f55838a.c(c2.a.c(klass));
        if (c4 != null) {
            Iterator<T> it = bVar.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (f0.g(c2.a.c(c2.a.a((Annotation) obj)), c4)) {
                    break;
                }
            }
            Annotation annotation = (Annotation) obj;
            if (annotation != null) {
                Object invoke = annotation.getClass().getMethod("value", new Class[0]).invoke(annotation, new Object[0]);
                if (invoke != null) {
                    t3 = o.t((Annotation[]) invoke);
                    return t3;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
            }
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final /* synthetic */ <T extends Annotation> boolean d(kotlin.reflect.b bVar) {
        Object obj;
        f0.p(bVar, "<this>");
        Iterator<T> it = bVar.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            f0.y(3, "T");
            if (((Annotation) obj) instanceof Annotation) {
                break;
            }
        }
        f0.y(1, "T?");
        return ((Annotation) obj) != null;
    }
}
