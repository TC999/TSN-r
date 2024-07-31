package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.util.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ByteBufferUtil {

    /* renamed from: a */
    private static final int f14532a = 16384;

    /* renamed from: b */
    private static final AtomicReference<byte[]> f14533b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.util.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3766b {

        /* renamed from: a */
        final int f14537a;

        /* renamed from: b */
        final int f14538b;

        /* renamed from: c */
        final byte[] f14539c;

        C3766b(@NonNull byte[] bArr, int i, int i2) {
            this.f14539c = bArr;
            this.f14537a = i;
            this.f14538b = i2;
        }
    }

    private ByteBufferUtil() {
    }

    @NonNull
    /* renamed from: a */
    public static ByteBuffer m44431a(@NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length != 0) {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                        MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                        return load;
                    } catch (Throwable th) {
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                }
                throw new IOException("File unsuitable for memory mapping");
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @NonNull
    /* renamed from: b */
    public static ByteBuffer m44430b(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f14533b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                f14533b.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    @Nullable
    /* renamed from: c */
    private static C3766b m44429c(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new C3766b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    @NonNull
    /* renamed from: d */
    public static byte[] m44428d(@NonNull ByteBuffer byteBuffer) {
        C3766b m44429c = m44429c(byteBuffer);
        if (m44429c != null && m44429c.f14537a == 0 && m44429c.f14538b == m44429c.f14539c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    /* renamed from: e */
    public static void m44427e(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            fileChannel = randomAccessFile.getChannel();
            fileChannel.write(byteBuffer);
            fileChannel.force(false);
            fileChannel.close();
            randomAccessFile.close();
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @NonNull
    /* renamed from: f */
    public static InputStream m44426f(@NonNull ByteBuffer byteBuffer) {
        return new C3765a(byteBuffer);
    }

    /* renamed from: g */
    public static void m44425g(@NonNull ByteBuffer byteBuffer, @NonNull OutputStream outputStream) throws IOException {
        C3766b m44429c = m44429c(byteBuffer);
        if (m44429c != null) {
            byte[] bArr = m44429c.f14539c;
            int i = m44429c.f14537a;
            outputStream.write(bArr, i, m44429c.f14538b + i);
            return;
        }
        byte[] andSet = f14533b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, min);
            outputStream.write(andSet, 0, min);
        }
        f14533b.set(andSet);
    }

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.util.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3765a extends InputStream {

        /* renamed from: c */
        private static final int f14534c = -1;
        @NonNull

        /* renamed from: a */
        private final ByteBuffer f14535a;

        /* renamed from: b */
        private int f14536b = -1;

        C3765a(@NonNull ByteBuffer byteBuffer) {
            this.f14535a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f14535a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.f14536b = this.f14535a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f14535a.hasRemaining()) {
                return this.f14535a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i = this.f14536b;
            if (i != -1) {
                this.f14535a.position(i);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (this.f14535a.hasRemaining()) {
                long min = Math.min(j, available());
                ByteBuffer byteBuffer = this.f14535a;
                byteBuffer.position((int) (byteBuffer.position() + min));
                return min;
            }
            return -1L;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            if (this.f14535a.hasRemaining()) {
                int min = Math.min(i2, available());
                this.f14535a.get(bArr, i, min);
                return min;
            }
            return -1;
        }
    }
}
