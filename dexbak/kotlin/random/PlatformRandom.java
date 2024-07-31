package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, m12616d2 = {"Lkotlin/random/a;", "Lkotlin/random/Random;", "", "bitCount", "nextBits", "nextInt", "until", "", "nextLong", "", "nextBoolean", "", "nextDouble", "", "nextFloat", "", "array", "nextBytes", "Ljava/util/Random;", "a", "()Ljava/util/Random;", "impl", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.random.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class PlatformRandom extends Random {
    @NotNull
    /* renamed from: a */
    public abstract java.util.Random mo2810a();

    @Override // kotlin.random.Random
    public int nextBits(int i) {
        return C14400f.m7643j(mo2810a().nextInt(), i);
    }

    @Override // kotlin.random.Random
    public boolean nextBoolean() {
        return mo2810a().nextBoolean();
    }

    @Override // kotlin.random.Random
    @NotNull
    public byte[] nextBytes(@NotNull byte[] array) {
        C14342f0.m8184p(array, "array");
        mo2810a().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public double nextDouble() {
        return mo2810a().nextDouble();
    }

    @Override // kotlin.random.Random
    public float nextFloat() {
        return mo2810a().nextFloat();
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        return mo2810a().nextInt();
    }

    @Override // kotlin.random.Random
    public long nextLong() {
        return mo2810a().nextLong();
    }

    @Override // kotlin.random.Random
    public int nextInt(int i) {
        return mo2810a().nextInt(i);
    }
}
