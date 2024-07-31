package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformRandom.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0016R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u001b¨\u0006 "}, m12616d2 = {"Lkotlin/random/c;", "Ljava/util/Random;", "", "bits", "next", "nextInt", "bound", "", "nextBoolean", "", "nextLong", "", "nextFloat", "", "nextDouble", "", "bytes", "Lkotlin/f1;", "nextBytes", "seed", "setSeed", "a", "Z", "seedInitialized", "Lkotlin/random/Random;", "b", "Lkotlin/random/Random;", "()Lkotlin/random/Random;", "impl", "<init>", "(Lkotlin/random/Random;)V", "c", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.random.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14395c extends java.util.Random {
    @NotNull

    /* renamed from: c */
    private static final C14396a f41271c = new C14396a(null);
    @Deprecated
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private boolean f41272a;
    @NotNull

    /* renamed from: b */
    private final Random f41273b;

    /* compiled from: PlatformRandom.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lkotlin/random/c$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.random.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C14396a {
        private C14396a() {
        }

        public /* synthetic */ C14396a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public C14395c(@NotNull Random impl) {
        C14342f0.m8184p(impl, "impl");
        this.f41273b = impl;
    }

    @NotNull
    /* renamed from: a */
    public final Random m7657a() {
        return this.f41273b;
    }

    @Override // java.util.Random
    protected int next(int i) {
        return this.f41273b.nextBits(i);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.f41273b.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(@NotNull byte[] bytes) {
        C14342f0.m8184p(bytes, "bytes");
        this.f41273b.nextBytes(bytes);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.f41273b.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.f41273b.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.f41273b.nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.f41273b.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (!this.f41272a) {
            this.f41272a = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return this.f41273b.nextInt(i);
    }
}
