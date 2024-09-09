package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: XorWowRandom.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0000\u0018\u0000 \u00142\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0015B9\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "nextInt", "bitCount", "nextBits", "x", "I", "y", "z", "w", "v", "addend", "<init>", "(IIIIII)V", "seed1", "seed2", "(II)V", "Companion", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class XorWowRandom extends Random implements Serializable {
    @NotNull
    private static final a Companion = new a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private int addend;

    /* renamed from: v  reason: collision with root package name */
    private int f55765v;

    /* renamed from: w  reason: collision with root package name */
    private int f55766w;

    /* renamed from: x  reason: collision with root package name */
    private int f55767x;

    /* renamed from: y  reason: collision with root package name */
    private int f55768y;

    /* renamed from: z  reason: collision with root package name */
    private int f55769z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: XorWowRandom.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lkotlin/random/XorWowRandom$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public XorWowRandom(int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f55767x = i4;
        this.f55768y = i5;
        this.f55769z = i6;
        this.f55766w = i7;
        this.f55765v = i8;
        this.addend = i9;
        int i10 = i4 | i5 | i6 | i7 | i8;
        int i11 = 0;
        if (!(i10 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        while (i11 < 64) {
            i11++;
            nextInt();
        }
    }

    @Override // kotlin.random.Random
    public int nextBits(int i4) {
        return f.j(nextInt(), i4);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int i4 = this.f55767x;
        int i5 = i4 ^ (i4 >>> 2);
        this.f55767x = this.f55768y;
        this.f55768y = this.f55769z;
        this.f55769z = this.f55766w;
        int i6 = this.f55765v;
        this.f55766w = i6;
        int i7 = ((i5 ^ (i5 << 1)) ^ i6) ^ (i6 << 4);
        this.f55765v = i7;
        int i8 = this.addend + 362437;
        this.addend = i8;
        return i7 + i8;
    }

    public XorWowRandom(int i4, int i5) {
        this(i4, i5, 0, 0, i4 ^ (-1), (i4 << 10) ^ (i5 >>> 4));
    }
}
