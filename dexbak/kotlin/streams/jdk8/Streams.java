package kotlin.streams.jdk8;

import androidx.exifinterface.media.ExifInterface;
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
import kotlin.collections._ArraysJvm;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002*\u00020\u0004H\u0007\u001a\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002*\u00020\u0007H\u0007\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002*\u00020\nH\u0007\u001a\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u001a\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\u0012\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e*\u00020\u0004H\u0007\u001a\u0012\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000e*\u00020\u0007H\u0007\u001a\u0012\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e*\u00020\nH\u0007¨\u0006\u0013"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/stream/Stream;", "Lkotlin/sequences/m;", "d", "Ljava/util/stream/IntStream;", "", "b", "Ljava/util/stream/LongStream;", "", "c", "Ljava/util/stream/DoubleStream;", "", "a", "e", "", "i", "g", "h", "f", "kotlin-stdlib-jdk8"}, m12615k = 2, m12614mv = {1, 5, 1}, m12613pn = "kotlin.streams")
@JvmName(name = "StreamsKt")
/* renamed from: kotlin.streams.jdk8.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Streams {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, m12616d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.streams.jdk8.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14543a<T> implements Sequence<T> {

        /* renamed from: a */
        final /* synthetic */ Stream f41529a;

        public C14543a(Stream stream) {
            this.f41529a = stream;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            Iterator<T> it = this.f41529a.iterator();
            C14342f0.m8185o(it, "iterator()");
            return it;
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, m12616d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.streams.jdk8.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14544b implements Sequence<Integer> {

        /* renamed from: a */
        final /* synthetic */ IntStream f41530a;

        public C14544b(IntStream intStream) {
            this.f41530a = intStream;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<Integer> iterator() {
            PrimitiveIterator.OfInt it = this.f41530a.iterator();
            C14342f0.m8185o(it, "iterator()");
            return it;
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, m12616d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.streams.jdk8.a$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14545c implements Sequence<Long> {

        /* renamed from: a */
        final /* synthetic */ LongStream f41531a;

        public C14545c(LongStream longStream) {
            this.f41531a = longStream;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<Long> iterator() {
            PrimitiveIterator.OfLong it = this.f41531a.iterator();
            C14342f0.m8185o(it, "iterator()");
            return it;
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, m12616d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.streams.jdk8.a$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14546d implements Sequence<Double> {

        /* renamed from: a */
        final /* synthetic */ DoubleStream f41532a;

        public C14546d(DoubleStream doubleStream) {
            this.f41532a = doubleStream;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<Double> iterator() {
            PrimitiveIterator.OfDouble it = this.f41532a.iterator();
            C14342f0.m8185o(it, "iterator()");
            return it;
        }
    }

    /* compiled from: Streams.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Spliterator;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Spliterator;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.streams.jdk8.a$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14547e<T> implements Supplier {

        /* renamed from: a */
        final /* synthetic */ Sequence f41533a;

        C14547e(Sequence sequence) {
            this.f41533a = sequence;
        }

        @Override // java.util.function.Supplier
        /* renamed from: a */
        public final Spliterator<T> get() {
            return Spliterators.spliteratorUnknownSize(this.f41533a.iterator(), 16);
        }
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: a */
    public static final Sequence<Double> m6934a(@NotNull DoubleStream asSequence) {
        C14342f0.m8184p(asSequence, "$this$asSequence");
        return new C14546d(asSequence);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: b */
    public static final Sequence<Integer> m6933b(@NotNull IntStream asSequence) {
        C14342f0.m8184p(asSequence, "$this$asSequence");
        return new C14544b(asSequence);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: c */
    public static final Sequence<Long> m6932c(@NotNull LongStream asSequence) {
        C14342f0.m8184p(asSequence, "$this$asSequence");
        return new C14545c(asSequence);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: d */
    public static final <T> Sequence<T> m6931d(@NotNull Stream<T> asSequence) {
        C14342f0.m8184p(asSequence, "$this$asSequence");
        return new C14543a(asSequence);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: e */
    public static final <T> Stream<T> m6930e(@NotNull Sequence<? extends T> asStream) {
        C14342f0.m8184p(asStream, "$this$asStream");
        Stream<T> stream = StreamSupport.stream(new C14547e(asStream), 16, false);
        C14342f0.m8185o(stream, "StreamSupport.stream({ S…literator.ORDERED, false)");
        return stream;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: f */
    public static final List<Double> m6929f(@NotNull DoubleStream toList) {
        List<Double> m11559p;
        C14342f0.m8184p(toList, "$this$toList");
        double[] array = toList.toArray();
        C14342f0.m8185o(array, "toArray()");
        m11559p = _ArraysJvm.m11559p(array);
        return m11559p;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: g */
    public static final List<Integer> m6928g(@NotNull IntStream toList) {
        List<Integer> m11547r;
        C14342f0.m8184p(toList, "$this$toList");
        int[] array = toList.toArray();
        C14342f0.m8185o(array, "toArray()");
        m11547r = _ArraysJvm.m11547r(array);
        return m11547r;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: h */
    public static final List<Long> m6927h(@NotNull LongStream toList) {
        List<Long> m11542s;
        C14342f0.m8184p(toList, "$this$toList");
        long[] array = toList.toArray();
        C14342f0.m8185o(array, "toArray()");
        m11542s = _ArraysJvm.m11542s(array);
        return m11542s;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: i */
    public static final <T> List<T> m6926i(@NotNull Stream<T> toList) {
        C14342f0.m8184p(toList, "$this$toList");
        Object collect = toList.collect(Collectors.toList());
        C14342f0.m8185o(collect, "collect(Collectors.toList<T>())");
        return (List) collect;
    }
}
