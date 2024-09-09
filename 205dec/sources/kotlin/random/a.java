package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PlatformRandom.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lkotlin/random/a;", "Lkotlin/random/Random;", "", "bitCount", "nextBits", "nextInt", "until", "", "nextLong", "", "nextBoolean", "", "nextDouble", "", "nextFloat", "", "array", "nextBytes", "Ljava/util/Random;", "a", "()Ljava/util/Random;", "impl", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a extends Random {
    @NotNull
    public abstract java.util.Random a();

    @Override // kotlin.random.Random
    public int nextBits(int i4) {
        return f.j(a().nextInt(), i4);
    }

    @Override // kotlin.random.Random
    public boolean nextBoolean() {
        return a().nextBoolean();
    }

    @Override // kotlin.random.Random
    @NotNull
    public byte[] nextBytes(@NotNull byte[] array) {
        f0.p(array, "array");
        a().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public double nextDouble() {
        return a().nextDouble();
    }

    @Override // kotlin.random.Random
    public float nextFloat() {
        return a().nextFloat();
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        return a().nextInt();
    }

    @Override // kotlin.random.Random
    public long nextLong() {
        return a().nextLong();
    }

    @Override // kotlin.random.Random
    public int nextInt(int i4) {
        return a().nextInt(i4);
    }
}
