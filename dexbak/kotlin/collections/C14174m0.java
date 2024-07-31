package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p617l1.InterfaceC15286r;

/* compiled from: Grouping.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u009e\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032b\u0010\f\u001a^\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00020\u0004H\u0087\bø\u0001\u0000\u001a¹\u0001\u0010\u0012\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u00032b\u0010\f\u001a^\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a¿\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u00142K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0016H\u0087\bø\u0001\u0000\u001aÚ\u0001\u0010\u0018\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u00142K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0081\u0001\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u001a\u001a\u00028\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0095\u0001\u0010\u001d\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u00032\u0006\u0010\u001a\u001a\u00028\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u008b\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u001f\"\b\b\u0001\u0010\u0000*\u00028\u0000\"\u0004\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0016H\u0087\bø\u0001\u0000\u001a¦\u0001\u0010!\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u001f\"\b\b\u0001\u0010\u0000*\u00028\u0000\"\u0004\b\u0002\u0010\u0001\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u000f*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032\u0006\u0010\u0011\u001a\u00028\u00032K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aK\u0010$\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00020#0\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u0002H\u0007¢\u0006\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "K", "R", "Lkotlin/collections/j0;", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_KEY, "accumulator", "element", "", "first", "operation", "", "c", "", "M", RtspHeaders.Values.DESTINATION, "d", "(Lkotlin/collections/j0;Ljava/util/Map;Ll1/r;)Ljava/util/Map;", "Lkotlin/Function2;", "initialValueSelector", "Lkotlin/Function3;", "g", "i", "(Lkotlin/collections/j0;Ljava/util/Map;Ll1/p;Ll1/q;)Ljava/util/Map;", "initialValue", "f", "(Lkotlin/collections/j0;Ljava/lang/Object;Ll1/p;)Ljava/util/Map;", "h", "(Lkotlin/collections/j0;Ljava/util/Map;Ljava/lang/Object;Ll1/p;)Ljava/util/Map;", ExifInterface.LATITUDE_SOUTH, "j", "k", "(Lkotlin/collections/j0;Ljava/util/Map;Ll1/q;)Ljava/util/Map;", "", "e", "(Lkotlin/collections/j0;Ljava/util/Map;)Ljava/util/Map;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/GroupingKt")
/* renamed from: kotlin.collections.m0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14174m0 extends GroupingJVM {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: c */
    public static final <T, K, R> Map<K, R> m11812c(@NotNull Grouping<T, ? extends K> aggregate, @NotNull InterfaceC15286r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        C14342f0.m8184p(aggregate, "$this$aggregate");
        C14342f0.m8184p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> mo6188b = aggregate.mo6188b();
        while (mo6188b.hasNext()) {
            ?? next = mo6188b.next();
            Object obj = (K) aggregate.mo6189a(next);
            Object obj2 = (Object) linkedHashMap.get(obj);
            linkedHashMap.put(obj, operation.invoke(obj, obj2, next, Boolean.valueOf(obj2 == 0 && !linkedHashMap.containsKey(obj))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: d */
    public static final <T, K, R, M extends Map<? super K, R>> M m11811d(@NotNull Grouping<T, ? extends K> aggregateTo, @NotNull M destination, @NotNull InterfaceC15286r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        C14342f0.m8184p(aggregateTo, "$this$aggregateTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(operation, "operation");
        Iterator<T> mo6188b = aggregateTo.mo6188b();
        while (mo6188b.hasNext()) {
            ?? next = mo6188b.next();
            Object mo6189a = aggregateTo.mo6189a(next);
            Object obj = (Object) destination.get(mo6189a);
            destination.put(mo6189a, operation.invoke(mo6189a, obj, next, Boolean.valueOf(obj == 0 && !destination.containsKey(mo6189a))));
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: e */
    public static final <T, K, M extends Map<? super K, Integer>> M m11810e(@NotNull Grouping<T, ? extends K> eachCountTo, @NotNull M destination) {
        C14342f0.m8184p(eachCountTo, "$this$eachCountTo");
        C14342f0.m8184p(destination, "destination");
        Iterator<T> mo6188b = eachCountTo.mo6188b();
        while (mo6188b.hasNext()) {
            K mo6189a = eachCountTo.mo6189a(mo6188b.next());
            Object obj = destination.get(mo6189a);
            if (obj == null && !destination.containsKey(mo6189a)) {
                obj = 0;
            }
            destination.put(mo6189a, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: f */
    public static final <T, K, R> Map<K, R> m11809f(@NotNull Grouping<T, ? extends K> fold, R r, @NotNull InterfaceC15284p<? super R, ? super T, ? extends R> operation) {
        C14342f0.m8184p(fold, "$this$fold");
        C14342f0.m8184p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> mo6188b = fold.mo6188b();
        while (mo6188b.hasNext()) {
            ?? next = mo6188b.next();
            K mo6189a = fold.mo6189a(next);
            Object obj = (Object) linkedHashMap.get(mo6189a);
            if (obj == null && !linkedHashMap.containsKey(mo6189a)) {
                obj = (Object) r;
            }
            linkedHashMap.put(mo6189a, operation.invoke(obj, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: g */
    public static final <T, K, R> Map<K, R> m11808g(@NotNull Grouping<T, ? extends K> fold, @NotNull InterfaceC15284p<? super K, ? super T, ? extends R> initialValueSelector, @NotNull InterfaceC15285q<? super K, ? super R, ? super T, ? extends R> operation) {
        C14342f0.m8184p(fold, "$this$fold");
        C14342f0.m8184p(initialValueSelector, "initialValueSelector");
        C14342f0.m8184p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> mo6188b = fold.mo6188b();
        while (mo6188b.hasNext()) {
            ?? next = mo6188b.next();
            Object obj = (K) fold.mo6189a(next);
            R r = (Object) linkedHashMap.get(obj);
            if (r == null && !linkedHashMap.containsKey(obj)) {
                r = initialValueSelector.invoke(obj, next);
            }
            linkedHashMap.put(obj, operation.invoke(obj, r, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: h */
    public static final <T, K, R, M extends Map<? super K, R>> M m11807h(@NotNull Grouping<T, ? extends K> foldTo, @NotNull M destination, R r, @NotNull InterfaceC15284p<? super R, ? super T, ? extends R> operation) {
        C14342f0.m8184p(foldTo, "$this$foldTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(operation, "operation");
        Iterator<T> mo6188b = foldTo.mo6188b();
        while (mo6188b.hasNext()) {
            ?? next = mo6188b.next();
            K mo6189a = foldTo.mo6189a(next);
            Object obj = (Object) destination.get(mo6189a);
            if (obj == null && !destination.containsKey(mo6189a)) {
                obj = (Object) r;
            }
            destination.put(mo6189a, operation.invoke(obj, next));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: i */
    public static final <T, K, R, M extends Map<? super K, R>> M m11806i(@NotNull Grouping<T, ? extends K> foldTo, @NotNull M destination, @NotNull InterfaceC15284p<? super K, ? super T, ? extends R> initialValueSelector, @NotNull InterfaceC15285q<? super K, ? super R, ? super T, ? extends R> operation) {
        C14342f0.m8184p(foldTo, "$this$foldTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(initialValueSelector, "initialValueSelector");
        C14342f0.m8184p(operation, "operation");
        Iterator<T> mo6188b = foldTo.mo6188b();
        while (mo6188b.hasNext()) {
            ?? next = mo6188b.next();
            Object mo6189a = foldTo.mo6189a(next);
            R r = (Object) destination.get(mo6189a);
            if (r == null && !destination.containsKey(mo6189a)) {
                r = initialValueSelector.invoke(mo6189a, next);
            }
            destination.put(mo6189a, operation.invoke(mo6189a, r, next));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: j */
    public static final <S, T extends S, K> Map<K, S> m11805j(@NotNull Grouping<T, ? extends K> reduce, @NotNull InterfaceC15285q<? super K, ? super S, ? super T, ? extends S> operation) {
        C14342f0.m8184p(reduce, "$this$reduce");
        C14342f0.m8184p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator mo6188b = reduce.mo6188b();
        while (mo6188b.hasNext()) {
            S s = (Object) mo6188b.next();
            Object obj = (Object) reduce.mo6189a(s);
            Object obj2 = (Object) linkedHashMap.get(obj);
            if (!(obj2 == 0 && !linkedHashMap.containsKey(obj))) {
                s = operation.invoke(obj, obj2, s);
            }
            linkedHashMap.put(obj, s);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: k */
    public static final <S, T extends S, K, M extends Map<? super K, S>> M m11804k(@NotNull Grouping<T, ? extends K> reduceTo, @NotNull M destination, @NotNull InterfaceC15285q<? super K, ? super S, ? super T, ? extends S> operation) {
        C14342f0.m8184p(reduceTo, "$this$reduceTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(operation, "operation");
        Iterator mo6188b = reduceTo.mo6188b();
        while (mo6188b.hasNext()) {
            S s = (Object) mo6188b.next();
            Object obj = (Object) reduceTo.mo6189a(s);
            Object obj2 = (Object) destination.get(obj);
            if (!(obj2 == 0 && !destination.containsKey(obj))) {
                s = operation.invoke(obj, obj2, s);
            }
            destination.put(obj, s);
        }
        return destination;
    }
}
