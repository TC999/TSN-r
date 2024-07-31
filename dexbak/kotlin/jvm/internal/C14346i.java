package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.AbstractC14163i0;
import kotlin.collections.AbstractC14168k1;
import kotlin.collections.AbstractC14213q0;
import kotlin.collections.AbstractC14214r0;
import kotlin.collections.AbstractC14216s;
import kotlin.collections.AbstractC14218t;
import kotlin.collections.AbstractC14221u;
import kotlin.collections.Iterators;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000T\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0004\u001a\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0007\u001a\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\n\u001a\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\r\u001a\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0010\u001a\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u0013\u001a\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u0016¨\u0006\u0019"}, m12616d2 = {"", "array", "Lkotlin/collections/t;", "b", "", "Lkotlin/collections/u;", "c", "", "Lkotlin/collections/k1;", "h", "", "Lkotlin/collections/q0;", "f", "", "Lkotlin/collections/r0;", "g", "", "Lkotlin/collections/i0;", "e", "", "Lkotlin/collections/f0;", "d", "", "Lkotlin/collections/s;", "a", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14346i {
    @NotNull
    /* renamed from: a */
    public static final AbstractC14216s m8168a(@NotNull boolean[] array) {
        C14342f0.m8184p(array, "array");
        return new ArrayIterators(array);
    }

    @NotNull
    /* renamed from: b */
    public static final AbstractC14218t m8167b(@NotNull byte[] array) {
        C14342f0.m8184p(array, "array");
        return new C14337b(array);
    }

    @NotNull
    /* renamed from: c */
    public static final AbstractC14221u m8166c(@NotNull char[] array) {
        C14342f0.m8184p(array, "array");
        return new C14338c(array);
    }

    @NotNull
    /* renamed from: d */
    public static final Iterators m8165d(@NotNull double[] array) {
        C14342f0.m8184p(array, "array");
        return new C14339d(array);
    }

    @NotNull
    /* renamed from: e */
    public static final AbstractC14163i0 m8164e(@NotNull float[] array) {
        C14342f0.m8184p(array, "array");
        return new C14340e(array);
    }

    @NotNull
    /* renamed from: f */
    public static final AbstractC14213q0 m8163f(@NotNull int[] array) {
        C14342f0.m8184p(array, "array");
        return new C14341f(array);
    }

    @NotNull
    /* renamed from: g */
    public static final AbstractC14214r0 m8162g(@NotNull long[] array) {
        C14342f0.m8184p(array, "array");
        return new C14348j(array);
    }

    @NotNull
    /* renamed from: h */
    public static final AbstractC14168k1 m8161h(@NotNull short[] array) {
        C14342f0.m8184p(array, "array");
        return new C14350k(array);
    }
}
