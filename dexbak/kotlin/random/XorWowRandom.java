package kotlin.random;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.analytics.pro.UMCommonContent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: XorWowRandom.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0000\u0018\u0000 \u00142\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0015B9\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\t¨\u0006\u0016"}, m12616d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "nextInt", "bitCount", "nextBits", "x", "I", "y", UMCommonContent.f37777aG, IAdInterListener.AdReqParam.WIDTH, "v", "addend", "<init>", "(IIIIII)V", "seed1", "seed2", "(II)V", "Companion", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class XorWowRandom extends Random implements Serializable {
    @NotNull
    private static final C14392a Companion = new C14392a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private int addend;

    /* renamed from: v */
    private int f41265v;

    /* renamed from: w */
    private int f41266w;

    /* renamed from: x */
    private int f41267x;

    /* renamed from: y */
    private int f41268y;

    /* renamed from: z */
    private int f41269z;

    /* compiled from: XorWowRandom.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lkotlin/random/XorWowRandom$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.random.XorWowRandom$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C14392a {
        private C14392a() {
        }

        public /* synthetic */ C14392a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public XorWowRandom(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f41267x = i;
        this.f41268y = i2;
        this.f41269z = i3;
        this.f41266w = i4;
        this.f41265v = i5;
        this.addend = i6;
        int i7 = i | i2 | i3 | i4 | i5;
        if (!(i7 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i8 = 0; i8 < 64; i8++) {
            nextInt();
        }
    }

    @Override // kotlin.random.Random
    public int nextBits(int i) {
        return C14400f.m7643j(nextInt(), i);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int i = this.f41267x;
        int i2 = i ^ (i >>> 2);
        this.f41267x = this.f41268y;
        this.f41268y = this.f41269z;
        this.f41269z = this.f41266w;
        int i3 = this.f41265v;
        this.f41266w = i3;
        int i4 = ((i2 ^ (i2 << 1)) ^ i3) ^ (i3 << 4);
        this.f41265v = i4;
        int i5 = this.addend + 362437;
        this.addend = i5;
        return i4 + i5;
    }

    public XorWowRandom(int i, int i2) {
        this(i, i2, 0, 0, i ^ (-1), (i << 10) ^ (i2 >>> 4));
    }
}
