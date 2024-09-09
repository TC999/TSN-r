package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Blackberry {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Cif> f51927a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f51928b;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Blackberry$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Cif f51929c;

        public Cdo(Cif cif) {
            this.f51929c = cif;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            FileChannel fileChannel;
            RandomAccessFile randomAccessFile;
            System.currentTimeMillis();
            String cif = this.f51929c.toString();
            synchronized (Ctry.class) {
                context = Ctry.f52366a;
            }
            File file = new File(context.getDir("turingfd", 0), Damson.f52014f);
            int length = cif.length();
            synchronized (Blackberry.f51928b) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                FileLock fileLock = null;
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                    } catch (Throwable unused) {
                        fileChannel = null;
                    }
                } catch (Throwable unused2) {
                    fileChannel = null;
                    randomAccessFile = null;
                }
                try {
                    fileLock = fileChannel.lock();
                    if (randomAccessFile.length() != 0) {
                        ByteBuffer allocate = ByteBuffer.allocate(1024);
                        while (true) {
                            int read = fileChannel.read(allocate);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(allocate.array(), 0, read);
                            allocate.clear();
                        }
                        cif = byteArrayOutputStream + "," + cif;
                        if (cif.length() > (length + 1) * 50) {
                            cif = cif.substring(cif.indexOf(",") + 1);
                        }
                    }
                    fileChannel.position(0L);
                    ByteBuffer wrap = ByteBuffer.wrap(cif.getBytes());
                    while (wrap.hasRemaining()) {
                        fileChannel.write(wrap);
                    }
                    fileChannel.truncate(wrap.position());
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused3) {
                        }
                    }
                    Ara.a(fileChannel);
                } catch (Throwable unused4) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused5) {
                        }
                    }
                    Ara.a(fileChannel);
                    Ara.a(randomAccessFile);
                }
                Ara.a(randomAccessFile);
            }
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Blackberry$if  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class Cif {

        /* renamed from: a  reason: collision with root package name */
        public final long f51930a;

        /* renamed from: b  reason: collision with root package name */
        public final String f51931b;

        public Cif(long j4, String str) {
            this.f51930a = j4;
            this.f51931b = str;
        }

        public String toString() {
            return this.f51930a + ":" + this.f51931b;
        }
    }

    static {
        new AtomicBoolean(false);
        f51928b = new Object();
        new AtomicReference();
    }

    public static void a(long j4, String str) {
        int i4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Cif cif = new Cif(j4, str);
        byte[] bytes = str.getBytes();
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        int length = bytes.length;
        long j13 = (length * (-4132994306676758123L)) ^ 0;
        int i5 = length >> 3;
        int i6 = 0;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = i6 + (i7 << 3);
            long j14 = ((wrap.get(i8 + 0) & 255) + ((wrap.get(i8 + 1) & 255) << 8) + ((wrap.get(i8 + 2) & 255) << 16) + ((wrap.get(i8 + 3) & 255) << 24) + ((wrap.get(i8 + 4) & 255) << 32) + ((wrap.get(i8 + 5) & 255) << 40) + ((wrap.get(i8 + 6) & 255) << 48) + ((wrap.get(i8 + 7) & 255) << 56)) * (-4132994306676758123L);
            j13 = (j13 ^ ((j14 ^ (j14 >>> 47)) * (-4132994306676758123L))) * (-4132994306676758123L);
            i7++;
            i6 = 0;
        }
        long j15 = j13;
        int i9 = length & 7;
        switch (i9) {
            case 1:
                i4 = 0;
                j5 = j15;
                j11 = -4132994306676758123L;
                j12 = (wrap.get((i4 + length) - i9) ^ j5) * (-4132994306676758123L);
                break;
            case 2:
                i4 = 0;
                j6 = j15;
                j5 = j6 ^ (wrap.get(((i4 + length) - i9) + 1) << 8);
                j11 = -4132994306676758123L;
                j12 = (wrap.get((i4 + length) - i9) ^ j5) * (-4132994306676758123L);
                break;
            case 3:
                i4 = 0;
                j7 = j15;
                j6 = j7 ^ (wrap.get(((i4 + length) - i9) + 2) << 16);
                j5 = j6 ^ (wrap.get(((i4 + length) - i9) + 1) << 8);
                j11 = -4132994306676758123L;
                j12 = (wrap.get((i4 + length) - i9) ^ j5) * (-4132994306676758123L);
                break;
            case 4:
                i4 = 0;
                j8 = j15;
                j7 = j8 ^ (wrap.get(((i4 + length) - i9) + 3) << 24);
                j6 = j7 ^ (wrap.get(((i4 + length) - i9) + 2) << 16);
                j5 = j6 ^ (wrap.get(((i4 + length) - i9) + 1) << 8);
                j11 = -4132994306676758123L;
                j12 = (wrap.get((i4 + length) - i9) ^ j5) * (-4132994306676758123L);
                break;
            case 5:
                i4 = 0;
                j9 = j15;
                j8 = j9 ^ (wrap.get(((i4 + length) - i9) + 4) << 32);
                j7 = j8 ^ (wrap.get(((i4 + length) - i9) + 3) << 24);
                j6 = j7 ^ (wrap.get(((i4 + length) - i9) + 2) << 16);
                j5 = j6 ^ (wrap.get(((i4 + length) - i9) + 1) << 8);
                j11 = -4132994306676758123L;
                j12 = (wrap.get((i4 + length) - i9) ^ j5) * (-4132994306676758123L);
                break;
            case 6:
                j10 = j15;
                i4 = 0;
                j9 = j10 ^ (wrap.get(((0 + length) - i9) + 5) << 40);
                j8 = j9 ^ (wrap.get(((i4 + length) - i9) + 4) << 32);
                j7 = j8 ^ (wrap.get(((i4 + length) - i9) + 3) << 24);
                j6 = j7 ^ (wrap.get(((i4 + length) - i9) + 2) << 16);
                j5 = j6 ^ (wrap.get(((i4 + length) - i9) + 1) << 8);
                j11 = -4132994306676758123L;
                j12 = (wrap.get((i4 + length) - i9) ^ j5) * (-4132994306676758123L);
                break;
            case 7:
                j10 = j15 ^ (wrap.get(((length + 0) - i9) + 6) << 48);
                i4 = 0;
                j9 = j10 ^ (wrap.get(((0 + length) - i9) + 5) << 40);
                j8 = j9 ^ (wrap.get(((i4 + length) - i9) + 4) << 32);
                j7 = j8 ^ (wrap.get(((i4 + length) - i9) + 3) << 24);
                j6 = j7 ^ (wrap.get(((i4 + length) - i9) + 2) << 16);
                j5 = j6 ^ (wrap.get(((i4 + length) - i9) + 1) << 8);
                j11 = -4132994306676758123L;
                j12 = (wrap.get((i4 + length) - i9) ^ j5) * (-4132994306676758123L);
                break;
            default:
                j11 = -4132994306676758123L;
                j12 = j15;
                break;
        }
        long j16 = (j12 ^ (j12 >>> 47)) * j11;
        String valueOf = String.valueOf((j16 >>> 47) ^ j16);
        HashMap<String, Cif> hashMap = f51927a;
        synchronized (hashMap) {
            hashMap.put(valueOf, cif);
        }
        Cfinally.f52315a.submit(new Cdo(cif));
    }
}
