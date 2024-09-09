package io.netty.handler.ssl.util;

import io.netty.util.internal.PlatformDependent;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ThreadLocalInsecureRandom extends SecureRandom {
    private static final SecureRandom INSTANCE = new ThreadLocalInsecureRandom();
    private static final long serialVersionUID = -8209473337192526191L;

    private ThreadLocalInsecureRandom() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SecureRandom current() {
        return INSTANCE;
    }

    private static Random random() {
        return PlatformDependent.threadLocalRandom();
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i4) {
        byte[] bArr = new byte[i4];
        random().nextBytes(bArr);
        return bArr;
    }

    @Override // java.security.SecureRandom
    public String getAlgorithm() {
        return "insecure";
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return random().nextBoolean();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        random().nextBytes(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return random().nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return random().nextFloat();
    }

    @Override // java.util.Random
    public double nextGaussian() {
        return random().nextGaussian();
    }

    @Override // java.util.Random
    public int nextInt() {
        return random().nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return random().nextLong();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long j4) {
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] bArr) {
    }

    @Override // java.util.Random
    public int nextInt(int i4) {
        return random().nextInt(i4);
    }
}
