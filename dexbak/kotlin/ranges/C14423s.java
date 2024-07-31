package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedUtils;
import kotlin.collections.AbstractC14217s1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UIntRange.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u001c\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\r\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, m12616d2 = {"Lkotlin/ranges/s;", "Lkotlin/collections/s1;", "", "hasNext", "Lkotlin/r0;", "c", "()I", "a", "I", "finalElement", "b", "Z", "step", "d", "next", "first", "last", "", "<init>", "(IIILkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14423s extends AbstractC14217s1 {

    /* renamed from: a */
    private final int f41316a;

    /* renamed from: b */
    private boolean f41317b;

    /* renamed from: c */
    private final int f41318c;

    /* renamed from: d */
    private int f41319d;

    private C14423s(int i, int i2, int i3) {
        this.f41316a = i2;
        boolean z = true;
        int m8561c = UnsignedUtils.m8561c(i, i2);
        if (i3 <= 0 ? m8561c < 0 : m8561c > 0) {
            z = false;
        }
        this.f41317b = z;
        this.f41318c = UInt.m7678h(i3);
        this.f41319d = this.f41317b ? i : i2;
    }

    @Override // kotlin.collections.AbstractC14217s1
    /* renamed from: c */
    public int mo7274c() {
        int i = this.f41319d;
        if (i == this.f41316a) {
            if (this.f41317b) {
                this.f41317b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f41319d = UInt.m7678h(this.f41318c + i);
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f41317b;
    }

    public /* synthetic */ C14423s(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }
}
