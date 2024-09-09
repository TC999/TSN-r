package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PlatformRandom.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0016R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lkotlin/random/c;", "Ljava/util/Random;", "", "bits", "next", "nextInt", "bound", "", "nextBoolean", "", "nextLong", "", "nextFloat", "", "nextDouble", "", "bytes", "Lkotlin/f1;", "nextBytes", "seed", "setSeed", "Lkotlin/random/Random;", "a", "Lkotlin/random/Random;", "()Lkotlin/random/Random;", "impl", "b", "Z", "seedInitialized", "<init>", "(Lkotlin/random/Random;)V", "c", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class c extends java.util.Random {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final a f55771c = new a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Random f55772a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f55773b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: PlatformRandom.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lkotlin/random/c$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public c(@NotNull Random impl) {
        f0.p(impl, "impl");
        this.f55772a = impl;
    }

    @NotNull
    public final Random a() {
        return this.f55772a;
    }

    @Override // java.util.Random
    protected int next(int i4) {
        return this.f55772a.nextBits(i4);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.f55772a.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(@NotNull byte[] bytes) {
        f0.p(bytes, "bytes");
        this.f55772a.nextBytes(bytes);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.f55772a.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.f55772a.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.f55772a.nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.f55772a.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j4) {
        if (!this.f55773b) {
            this.f55773b = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Override // java.util.Random
    public int nextInt(int i4) {
        return this.f55772a.nextInt(i4);
    }
}
