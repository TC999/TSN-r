package io.netty.util.internal;

import com.github.mikephil.charting.utils.Utils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ThreadLocalRandom extends Random {
    private static final long addend = 11;
    private static volatile long initialSeedUniquifier = 0;
    private static final long mask = 281474976710655L;
    private static final long multiplier = 25214903917L;
    private static volatile long seedGeneratorEndTime = 0;
    private static final long seedGeneratorStartTime;
    private static final Thread seedGeneratorThread;
    private static final BlockingQueue<Long> seedQueue;
    private static final long serialVersionUID = -5851777807851030925L;
    boolean initialized;
    private long pad0;
    private long pad1;
    private long pad2;
    private long pad3;
    private long pad4;
    private long pad5;
    private long pad6;
    private long pad7;
    private long rnd;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadLocalRandom.class);
    private static final AtomicLong seedUniquifier = new AtomicLong();

    static {
        initialSeedUniquifier = ((Long) AccessController.doPrivileged(new PrivilegedAction<Long>() { // from class: io.netty.util.internal.ThreadLocalRandom.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Long run() {
                return Long.getLong("io.netty.initialSeedUniquifier", 0L);
            }
        })).longValue();
        if (initialSeedUniquifier == 0) {
            if (((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: io.netty.util.internal.ThreadLocalRandom.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public Boolean run() {
                    return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
                }
            })).booleanValue()) {
                seedQueue = new LinkedBlockingQueue();
                seedGeneratorStartTime = System.nanoTime();
                Thread thread = new Thread("initialSeedUniquifierGenerator") { // from class: io.netty.util.internal.ThreadLocalRandom.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        byte[] generateSeed = new SecureRandom().generateSeed(8);
                        long unused = ThreadLocalRandom.seedGeneratorEndTime = System.nanoTime();
                        ThreadLocalRandom.seedQueue.add(Long.valueOf((generateSeed[7] & 255) | ((generateSeed[0] & 255) << 56) | ((generateSeed[1] & 255) << 48) | ((generateSeed[2] & 255) << 40) | ((generateSeed[3] & 255) << 32) | ((generateSeed[4] & 255) << 24) | ((generateSeed[5] & 255) << 16) | ((generateSeed[6] & 255) << 8)));
                    }
                };
                seedGeneratorThread = thread;
                thread.setDaemon(true);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.netty.util.internal.ThreadLocalRandom.4
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread2, Throwable th) {
                        ThreadLocalRandom.logger.debug("An exception has been raised by {}", thread2.getName(), th);
                    }
                });
                thread.start();
                return;
            }
            initialSeedUniquifier = mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime());
            seedGeneratorThread = null;
            seedQueue = null;
            seedGeneratorStartTime = 0L;
            return;
        }
        seedGeneratorThread = null;
        seedQueue = null;
        seedGeneratorStartTime = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadLocalRandom() {
        super(newSeed());
        this.initialized = true;
    }

    public static ThreadLocalRandom current() {
        return InternalThreadLocalMap.get().random();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        r4 = r12.longValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getInitialSeedUniquifier() {
        /*
            long r0 = io.netty.util.internal.ThreadLocalRandom.initialSeedUniquifier
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L9
            return r0
        L9:
            java.lang.Class<io.netty.util.internal.ThreadLocalRandom> r0 = io.netty.util.internal.ThreadLocalRandom.class
            monitor-enter(r0)
            long r4 = io.netty.util.internal.ThreadLocalRandom.initialSeedUniquifier     // Catch: java.lang.Throwable -> L8e
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L14
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8e
            return r4
        L14:
            long r6 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorStartTime     // Catch: java.lang.Throwable -> L8e
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L8e
            r8 = 3
            long r10 = r1.toNanos(r8)     // Catch: java.lang.Throwable -> L8e
            long r6 = r6 + r10
            r1 = 0
        L20:
            long r10 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L8e
            long r10 = r6 - r10
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 > 0) goto L33
            java.util.concurrent.BlockingQueue<java.lang.Long> r12 = io.netty.util.internal.ThreadLocalRandom.seedQueue     // Catch: java.lang.InterruptedException -> L59 java.lang.Throwable -> L8e
            java.lang.Object r12 = r12.poll()     // Catch: java.lang.InterruptedException -> L59 java.lang.Throwable -> L8e
            java.lang.Long r12 = (java.lang.Long) r12     // Catch: java.lang.InterruptedException -> L59 java.lang.Throwable -> L8e
            goto L3d
        L33:
            java.util.concurrent.BlockingQueue<java.lang.Long> r12 = io.netty.util.internal.ThreadLocalRandom.seedQueue     // Catch: java.lang.InterruptedException -> L59 java.lang.Throwable -> L8e
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.InterruptedException -> L59 java.lang.Throwable -> L8e
            java.lang.Object r12 = r12.poll(r10, r13)     // Catch: java.lang.InterruptedException -> L59 java.lang.Throwable -> L8e
            java.lang.Long r12 = (java.lang.Long) r12     // Catch: java.lang.InterruptedException -> L59 java.lang.Throwable -> L8e
        L3d:
            if (r12 == 0) goto L44
            long r4 = r12.longValue()     // Catch: java.lang.InterruptedException -> L59 java.lang.Throwable -> L8e
            goto L61
        L44:
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 > 0) goto L20
            java.lang.Thread r6 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorThread     // Catch: java.lang.Throwable -> L8e
            r6.interrupt()     // Catch: java.lang.Throwable -> L8e
            io.netty.util.internal.logging.InternalLogger r6 = io.netty.util.internal.ThreadLocalRandom.logger     // Catch: java.lang.Throwable -> L8e
            java.lang.String r7 = "Failed to generate a seed from SecureRandom within {} seconds. Not enough entropy?"
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L8e
            r6.warn(r7, r8)     // Catch: java.lang.Throwable -> L8e
            goto L61
        L59:
            r1 = 1
            io.netty.util.internal.logging.InternalLogger r6 = io.netty.util.internal.ThreadLocalRandom.logger     // Catch: java.lang.Throwable -> L8e
            java.lang.String r7 = "Failed to generate a seed from SecureRandom due to an InterruptedException."
            r6.warn(r7)     // Catch: java.lang.Throwable -> L8e
        L61:
            r6 = 3627065505421648153(0x3255ecdc33bae119, double:3.253008663204319E-66)
            long r4 = r4 ^ r6
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L8e
            long r6 = java.lang.Long.reverse(r6)     // Catch: java.lang.Throwable -> L8e
            long r4 = r4 ^ r6
            io.netty.util.internal.ThreadLocalRandom.initialSeedUniquifier = r4     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto L80
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L8e
            r1.interrupt()     // Catch: java.lang.Throwable -> L8e
            java.lang.Thread r1 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorThread     // Catch: java.lang.Throwable -> L8e
            r1.interrupt()     // Catch: java.lang.Throwable -> L8e
        L80:
            long r6 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorEndTime     // Catch: java.lang.Throwable -> L8e
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L8c
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L8e
            io.netty.util.internal.ThreadLocalRandom.seedGeneratorEndTime = r1     // Catch: java.lang.Throwable -> L8e
        L8c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8e
            return r4
        L8e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8e
            goto L92
        L91:
            throw r1
        L92:
            goto L91
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.ThreadLocalRandom.getInitialSeedUniquifier():long");
    }

    private static long mix64(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    private static long newSeed() {
        AtomicLong atomicLong;
        long j;
        long initialSeedUniquifier2;
        long j2;
        do {
            atomicLong = seedUniquifier;
            j = atomicLong.get();
            initialSeedUniquifier2 = j != 0 ? j : getInitialSeedUniquifier();
            j2 = 181783497276652981L * initialSeedUniquifier2;
        } while (!atomicLong.compareAndSet(j, j2));
        if (j == 0) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                if (seedGeneratorEndTime != 0) {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", Long.valueOf(initialSeedUniquifier2), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(seedGeneratorEndTime - seedGeneratorStartTime))));
                } else {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x", Long.valueOf(initialSeedUniquifier2)));
                }
            }
        }
        return System.nanoTime() ^ j2;
    }

    public static void setInitialSeedUniquifier(long j) {
        initialSeedUniquifier = j;
    }

    @Override // java.util.Random
    protected int next(int i) {
        long j = ((this.rnd * multiplier) + 11) & mask;
        this.rnd = j;
        return (int) (j >>> (48 - i));
    }

    public double nextDouble(double d) {
        if (d > Utils.DOUBLE_EPSILON) {
            return nextDouble() * d;
        }
        throw new IllegalArgumentException("n must be positive");
    }

    public int nextInt(int i, int i2) {
        if (i < i2) {
            return nextInt(i2 - i) + i;
        }
        throw new IllegalArgumentException();
    }

    public long nextLong(long j) {
        long j2 = 0;
        if (j > 0) {
            while (j >= 2147483647L) {
                int next = next(2);
                long j3 = j >>> 1;
                if ((next & 2) != 0) {
                    j3 = j - j3;
                }
                if ((next & 1) == 0) {
                    j2 += j - j3;
                }
                j = j3;
            }
            return j2 + nextInt((int) j);
        }
        throw new IllegalArgumentException("n must be positive");
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (!this.initialized) {
            this.rnd = (j ^ multiplier) & mask;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public double nextDouble(double d, double d2) {
        if (d < d2) {
            return (nextDouble() * (d2 - d)) + d;
        }
        throw new IllegalArgumentException();
    }

    public long nextLong(long j, long j2) {
        if (j < j2) {
            return nextLong(j2 - j) + j;
        }
        throw new IllegalArgumentException();
    }
}
