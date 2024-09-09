package kotlin.collections;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Grouping.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u009e\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032b\u0010\f\u001a^\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00020\u0004H\u0087\b\u00f8\u0001\u0000\u001a\u00b9\u0001\u0010\u0012\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u00032b\u0010\f\u001a^\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00020\u0004H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u00bf\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u00142K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u001a\u00da\u0001\u0010\u0018\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u00142K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a\u0081\u0001\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u001a\u001a\u00028\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00118\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\u0095\u0001\u0010\u001d\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u00032\u0006\u0010\u001a\u001a\u00028\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00118\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\u008b\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u001f\"\b\b\u0001\u0010\u0000*\u00028\u0000\"\u0004\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0016H\u0087\b\u00f8\u0001\u0000\u001a\u00a6\u0001\u0010!\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u001f\"\b\b\u0001\u0010\u0000*\u00028\u0000\"\u0004\b\u0002\u0010\u0001\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u000f*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032\u0006\u0010\u0011\u001a\u00028\u00032K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u001aK\u0010$\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00020#0\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u0002H\u0007\u00a2\u0006\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006&"}, d2 = {"T", "K", "R", "Lkotlin/collections/k0;", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_KEY, "accumulator", "element", "", "first", "operation", "", "c", "", "M", "destination", "d", "(Lkotlin/collections/k0;Ljava/util/Map;Ld2/r;)Ljava/util/Map;", "Lkotlin/Function2;", "initialValueSelector", "Lkotlin/Function3;", "f", "h", "(Lkotlin/collections/k0;Ljava/util/Map;Ld2/p;Ld2/q;)Ljava/util/Map;", "initialValue", "g", "(Lkotlin/collections/k0;Ljava/lang/Object;Ld2/p;)Ljava/util/Map;", "i", "(Lkotlin/collections/k0;Ljava/util/Map;Ljava/lang/Object;Ld2/p;)Ljava/util/Map;", "S", "j", "k", "(Lkotlin/collections/k0;Ljava/util/Map;Ld2/q;)Ljava/util/Map;", "", "e", "(Lkotlin/collections/k0;Ljava/util/Map;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/GroupingKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class n0 extends m0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> c(@NotNull k0<T, ? extends K> k0Var, @NotNull d2.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b4 = k0Var.b();
        while (b4.hasNext()) {
            ?? next = b4.next();
            Object obj = (K) k0Var.a(next);
            Object obj2 = (Object) linkedHashMap.get(obj);
            linkedHashMap.put(obj, operation.invoke(obj, obj2, next, Boolean.valueOf(obj2 == 0 && !linkedHashMap.containsKey(obj))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M d(@NotNull k0<T, ? extends K> k0Var, @NotNull M destination, @NotNull d2.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<T> b4 = k0Var.b();
        while (b4.hasNext()) {
            ?? next = b4.next();
            Object a4 = k0Var.a(next);
            Object obj = (Object) destination.get(a4);
            destination.put(a4, operation.invoke(a4, obj, next, Boolean.valueOf(obj == 0 && !destination.containsKey(a4))));
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, M extends Map<? super K, Integer>> M e(@NotNull k0<T, ? extends K> k0Var, @NotNull M destination) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        Iterator<T> b4 = k0Var.b();
        while (b4.hasNext()) {
            K a4 = k0Var.a(b4.next());
            Object obj = destination.get(a4);
            if (obj == null && !destination.containsKey(a4)) {
                obj = 0;
            }
            destination.put(a4, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> f(@NotNull k0<T, ? extends K> k0Var, @NotNull d2.p<? super K, ? super T, ? extends R> initialValueSelector, @NotNull d2.q<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        kotlin.jvm.internal.f0.p(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.f0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b4 = k0Var.b();
        while (b4.hasNext()) {
            ?? next = b4.next();
            Object obj = (K) k0Var.a(next);
            R r3 = (Object) linkedHashMap.get(obj);
            if (r3 == null && !linkedHashMap.containsKey(obj)) {
                r3 = initialValueSelector.invoke(obj, next);
            }
            linkedHashMap.put(obj, operation.invoke(obj, r3, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> g(@NotNull k0<T, ? extends K> k0Var, R r3, @NotNull d2.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b4 = k0Var.b();
        while (b4.hasNext()) {
            ?? next = b4.next();
            K a4 = k0Var.a(next);
            Object obj = (Object) linkedHashMap.get(a4);
            if (obj == null && !linkedHashMap.containsKey(a4)) {
                obj = (Object) r3;
            }
            linkedHashMap.put(a4, operation.invoke(obj, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M h(@NotNull k0<T, ? extends K> k0Var, @NotNull M destination, @NotNull d2.p<? super K, ? super T, ? extends R> initialValueSelector, @NotNull d2.q<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<T> b4 = k0Var.b();
        while (b4.hasNext()) {
            ?? next = b4.next();
            Object a4 = k0Var.a(next);
            R r3 = (Object) destination.get(a4);
            if (r3 == null && !destination.containsKey(a4)) {
                r3 = initialValueSelector.invoke(a4, next);
            }
            destination.put(a4, operation.invoke(a4, r3, next));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M i(@NotNull k0<T, ? extends K> k0Var, @NotNull M destination, R r3, @NotNull d2.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<T> b4 = k0Var.b();
        while (b4.hasNext()) {
            ?? next = b4.next();
            K a4 = k0Var.a(next);
            Object obj = (Object) destination.get(a4);
            if (obj == null && !destination.containsKey(a4)) {
                obj = (Object) r3;
            }
            destination.put(a4, operation.invoke(obj, next));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S, T extends S, K> Map<K, S> j(@NotNull k0<T, ? extends K> k0Var, @NotNull d2.q<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator b4 = k0Var.b();
        while (b4.hasNext()) {
            Object obj = (Object) b4.next();
            Object obj2 = (Object) k0Var.a(obj);
            Object obj3 = (Object) linkedHashMap.get(obj2);
            if (!(obj3 == 0 && !linkedHashMap.containsKey(obj2))) {
                obj = (S) operation.invoke(obj2, obj3, obj);
            }
            linkedHashMap.put(obj2, obj);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S, T extends S, K, M extends Map<? super K, S>> M k(@NotNull k0<T, ? extends K> k0Var, @NotNull M destination, @NotNull d2.q<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator b4 = k0Var.b();
        while (b4.hasNext()) {
            Object obj = (Object) b4.next();
            Object obj2 = (Object) k0Var.a(obj);
            Object obj3 = (Object) destination.get(obj2);
            if (!(obj3 == 0 && !destination.containsKey(obj2))) {
                obj = (S) operation.invoke(obj2, obj3, obj);
            }
            destination.put(obj2, obj);
        }
        return destination;
    }
}
