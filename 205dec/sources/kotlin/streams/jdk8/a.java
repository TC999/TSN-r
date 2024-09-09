package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.o;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.sequences.m;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Streams.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002*\u00020\u0004H\u0007\u001a\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002*\u00020\u0007H\u0007\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002*\u00020\nH\u0007\u001a\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u001a\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\u0012\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e*\u00020\u0004H\u0007\u001a\u0012\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000e*\u00020\u0007H\u0007\u001a\u0012\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e*\u00020\nH\u0007\u00a8\u0006\u0013"}, d2 = {"T", "Ljava/util/stream/Stream;", "Lkotlin/sequences/m;", "d", "Ljava/util/stream/IntStream;", "", "b", "Ljava/util/stream/LongStream;", "", "c", "Ljava/util/stream/DoubleStream;", "", "a", "e", "", "i", "g", "h", "f", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 5, 1}, pn = "kotlin.streams")
@JvmName(name = "StreamsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* renamed from: kotlin.streams.jdk8.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1194a<T> implements m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Stream f58880a;

        public C1194a(Stream stream) {
            this.f58880a = stream;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<T> iterator() {
            Iterator<T> it = this.f58880a.iterator();
            f0.o(it, "iterator()");
            return it;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements m<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IntStream f58881a;

        public b(IntStream intStream) {
            this.f58881a = intStream;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Integer> iterator() {
            PrimitiveIterator.OfInt it = this.f58881a.iterator();
            f0.o(it, "iterator()");
            return it;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c implements m<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LongStream f58882a;

        public c(LongStream longStream) {
            this.f58882a = longStream;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Long> iterator() {
            PrimitiveIterator.OfLong it = this.f58882a.iterator();
            f0.o(it, "iterator()");
            return it;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d implements m<Double> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DoubleStream f58883a;

        public d(DoubleStream doubleStream) {
            this.f58883a = doubleStream;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Double> iterator() {
            PrimitiveIterator.OfDouble it = this.f58883a.iterator();
            f0.o(it, "iterator()");
            return it;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Streams.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Ljava/util/Spliterator;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Spliterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e<T> implements Supplier {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f58884a;

        e(m mVar) {
            this.f58884a = mVar;
        }

        @Override // java.util.function.Supplier
        /* renamed from: a */
        public final Spliterator<T> get() {
            return Spliterators.spliteratorUnknownSize(this.f58884a.iterator(), 16);
        }
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final m<Double> a(@NotNull DoubleStream asSequence) {
        f0.p(asSequence, "$this$asSequence");
        return new d(asSequence);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final m<Integer> b(@NotNull IntStream asSequence) {
        f0.p(asSequence, "$this$asSequence");
        return new b(asSequence);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final m<Long> c(@NotNull LongStream asSequence) {
        f0.p(asSequence, "$this$asSequence");
        return new c(asSequence);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> m<T> d(@NotNull Stream<T> asSequence) {
        f0.p(asSequence, "$this$asSequence");
        return new C1194a(asSequence);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Stream<T> e(@NotNull m<? extends T> asStream) {
        f0.p(asStream, "$this$asStream");
        Stream<T> stream = StreamSupport.stream(new e(asStream), 16, false);
        f0.o(stream, "StreamSupport.stream({ S\u2026literator.ORDERED, false)");
        return stream;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Double> f(@NotNull DoubleStream toList) {
        List<Double> p3;
        f0.p(toList, "$this$toList");
        double[] array = toList.toArray();
        f0.o(array, "toArray()");
        p3 = o.p(array);
        return p3;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Integer> g(@NotNull IntStream toList) {
        List<Integer> r3;
        f0.p(toList, "$this$toList");
        int[] array = toList.toArray();
        f0.o(array, "toArray()");
        r3 = o.r(array);
        return r3;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Long> h(@NotNull LongStream toList) {
        List<Long> s3;
        f0.p(toList, "$this$toList");
        long[] array = toList.toArray();
        f0.o(array, "toArray()");
        s3 = o.s(array);
        return s3;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> i(@NotNull Stream<T> toList) {
        f0.p(toList, "$this$toList");
        Object collect = toList.collect(Collectors.toList());
        f0.o(collect, "collect(Collectors.toList<T>())");
        return (List) collect;
    }
}
