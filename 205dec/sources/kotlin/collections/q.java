package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ArraysUtilJVM.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class q {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a<T> implements Iterable<T>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object[] f55419a;

        public a(Object[] objArr) {
            this.f55419a = objArr;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.h.a(this.f55419a);
        }
    }

    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a0 extends Lambda implements l1.a<Iterator<? extends Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean[] f55420a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a0(boolean[] zArr) {
            super(0);
            this.f55420a = zArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.s, java.util.Iterator<java.lang.Boolean>] */
        @NotNull
        /* renamed from: a */
        public final Iterator<Boolean> invoke() {
            return kotlin.jvm.internal.i.a(this.f55420a);
        }
    }

    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b implements Iterable<Byte>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f55421a;

        public b(byte[] bArr) {
            this.f55421a = bArr;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.i.b(this.f55421a);
        }
    }

    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class b0 extends Lambda implements l1.a<Iterator<? extends Character>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ char[] f55422a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0(char[] cArr) {
            super(0);
            this.f55422a = cArr;
        }

        @NotNull
        /* renamed from: a */
        public final Iterator<Character> invoke() {
            return kotlin.jvm.internal.i.c(this.f55422a);
        }
    }

    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c implements Iterable<Short>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ short[] f55423a;

        public c(short[] sArr) {
            this.f55423a = sArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator<java.lang.Short>, kotlin.collections.k1] */
        @Override // java.lang.Iterable
        @NotNull
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.i.h(this.f55423a);
        }
    }

    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class d implements Iterable<Integer>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f55424a;

        public d(int[] iArr) {
            this.f55424a = iArr;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.i.f(this.f55424a);
        }
    }

    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class e implements Iterable<Long>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long[] f55425a;

        public e(long[] jArr) {
            this.f55425a = jArr;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.i.g(this.f55425a);
        }
    }

    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class f implements Iterable<Float>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float[] f55426a;

        public f(float[] fArr) {
            this.f55426a = fArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator<java.lang.Float>, kotlin.collections.i0] */
        @Override // java.lang.Iterable
        @NotNull
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.i.e(this.f55426a);
        }
    }

    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class g implements Iterable<Double>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ double[] f55427a;

        public g(double[] dArr) {
            this.f55427a = dArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.f0, java.util.Iterator<java.lang.Double>] */
        @Override // java.lang.Iterable
        @NotNull
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.i.d(this.f55427a);
        }
    }

    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class h implements Iterable<Boolean>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean[] f55428a;

        public h(boolean[] zArr) {
            this.f55428a = zArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.s, java.util.Iterator<java.lang.Boolean>] */
        @Override // java.lang.Iterable
        @NotNull
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.i.a(this.f55428a);
        }
    }

    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class i implements Iterable<Character>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ char[] f55429a;

        public i(char[] cArr) {
            this.f55429a = cArr;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.i.c(this.f55429a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class j<T> implements kotlin.sequences.m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object[] f55430a;

        public j(Object[] objArr) {
            this.f55430a = objArr;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.h.a(this.f55430a);
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class k implements kotlin.sequences.m<Byte> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f55431a;

        public k(byte[] bArr) {
            this.f55431a = bArr;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.i.b(this.f55431a);
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class l implements kotlin.sequences.m<Short> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ short[] f55432a;

        public l(short[] sArr) {
            this.f55432a = sArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator<java.lang.Short>, kotlin.collections.k1] */
        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.i.h(this.f55432a);
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class m implements kotlin.sequences.m<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f55433a;

        public m(int[] iArr) {
            this.f55433a = iArr;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.i.f(this.f55433a);
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class n implements kotlin.sequences.m<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long[] f55434a;

        public n(long[] jArr) {
            this.f55434a = jArr;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.i.g(this.f55434a);
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class o implements kotlin.sequences.m<Float> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float[] f55435a;

        public o(float[] fArr) {
            this.f55435a = fArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator<java.lang.Float>, kotlin.collections.i0] */
        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.i.e(this.f55435a);
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class p implements kotlin.sequences.m<Double> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ double[] f55436a;

        public p(double[] dArr) {
            this.f55436a = dArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.f0, java.util.Iterator<java.lang.Double>] */
        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.i.d(this.f55436a);
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* renamed from: kotlin.collections.q$q  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class C1093q implements kotlin.sequences.m<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean[] f55437a;

        public C1093q(boolean[] zArr) {
            this.f55437a = zArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.s, java.util.Iterator<java.lang.Boolean>] */
        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.i.a(this.f55437a);
        }
    }

    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class r implements kotlin.sequences.m<Character> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ char[] f55438a;

        public r(char[] cArr) {
            this.f55438a = cArr;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.i.c(this.f55438a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"kotlin/collections/q$s", "Lkotlin/collections/j0;", "", "b", "element", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class s<K, T> implements j0<T, K> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object[] f55439a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.l f55440b;

        public s(T[] tArr, l1.l lVar) {
            this.f55439a = tArr;
            this.f55440b = lVar;
        }

        public K a(T t3) {
            return (K) this.f55440b.invoke(t3);
        }

        @NotNull
        public Iterator<T> b() {
            return kotlin.jvm.internal.h.a(this.f55439a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class t<T> extends Lambda implements l1.a<Iterator<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object[] f55441a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(Object[] objArr) {
            super(0);
            this.f55441a = objArr;
        }

        @NotNull
        /* renamed from: a */
        public final Iterator<T> invoke() {
            return kotlin.jvm.internal.h.a(this.f55441a);
        }
    }

    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\u0005\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class u extends Lambda implements l1.a<Iterator<? extends Byte>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f55442a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(byte[] bArr) {
            super(0);
            this.f55442a = bArr;
        }

        @NotNull
        /* renamed from: a */
        public final Iterator<Byte> invoke() {
            return kotlin.jvm.internal.i.b(this.f55442a);
        }
    }

    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\n\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class v extends Lambda implements l1.a<Iterator<? extends Short>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ short[] f55443a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(short[] sArr) {
            super(0);
            this.f55443a = sArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator<java.lang.Short>, kotlin.collections.k1] */
        @NotNull
        /* renamed from: a */
        public final Iterator<Short> invoke() {
            return kotlin.jvm.internal.i.h(this.f55443a);
        }
    }

    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class w extends Lambda implements l1.a<Iterator<? extends Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f55444a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(int[] iArr) {
            super(0);
            this.f55444a = iArr;
        }

        @NotNull
        /* renamed from: a */
        public final Iterator<Integer> invoke() {
            return kotlin.jvm.internal.i.f(this.f55444a);
        }
    }

    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class x extends Lambda implements l1.a<Iterator<? extends Long>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long[] f55445a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(long[] jArr) {
            super(0);
            this.f55445a = jArr;
        }

        @NotNull
        /* renamed from: a */
        public final Iterator<Long> invoke() {
            return kotlin.jvm.internal.i.g(this.f55445a);
        }
    }

    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class y extends Lambda implements l1.a<Iterator<? extends Float>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float[] f55446a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(float[] fArr) {
            super(0);
            this.f55446a = fArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator<java.lang.Float>, kotlin.collections.i0] */
        @NotNull
        /* renamed from: a */
        public final Iterator<Float> invoke() {
            return kotlin.jvm.internal.i.e(this.f55446a);
        }
    }

    /* compiled from: _Arrays.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class z extends Lambda implements l1.a<Iterator<? extends Double>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ double[] f55447a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(double[] dArr) {
            super(0);
            this.f55447a = dArr;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.f0, java.util.Iterator<java.lang.Double>] */
        @NotNull
        /* renamed from: a */
        public final Iterator<Double> invoke() {
            return kotlin.jvm.internal.i.d(this.f55447a);
        }
    }

    q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<T> a(T[] tArr) {
        return Arrays.asList(tArr);
    }
}
