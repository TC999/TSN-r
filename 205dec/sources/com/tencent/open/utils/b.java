package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final n f51810a = new n(101010256);

    /* renamed from: b  reason: collision with root package name */
    private static final o f51811b = new o(38651);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Properties f51812a;

        /* renamed from: b  reason: collision with root package name */
        byte[] f51813b;

        private a() {
            this.f51812a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = b.f51811b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (b.f51811b.equals(new o(bArr2))) {
                if (bArr.length - length <= 2) {
                    return;
                }
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int b4 = new o(bArr3).b();
                if ((bArr.length - length) - 2 < b4) {
                    return;
                }
                byte[] bArr4 = new byte[b4];
                wrap.get(bArr4);
                this.f51812a.load(new ByteArrayInputStream(bArr4));
                int length2 = ((bArr.length - length) - b4) - 2;
                if (length2 > 0) {
                    byte[] bArr5 = new byte[length2];
                    this.f51813b = bArr5;
                    wrap.get(bArr5);
                    return;
                }
                return;
            }
            throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f51812a + ", otherData=" + Arrays.toString(this.f51813b) + "]";
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] a4 = a(randomAccessFile);
            if (a4 == null) {
                randomAccessFile.close();
                return null;
            }
            a aVar = new a();
            aVar.a(a4);
            String property = aVar.f51812a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z3;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a4 = f51810a.a();
        int read = randomAccessFile.read();
        while (true) {
            z3 = true;
            if (read == -1) {
                z3 = false;
                break;
            } else if (read == a4[0] && randomAccessFile.read() == a4[1] && randomAccessFile.read() == a4[2] && randomAccessFile.read() == a4[3]) {
                break;
            } else {
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            }
        }
        if (z3) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int b4 = new o(bArr).b();
            if (b4 == 0) {
                return null;
            }
            byte[] bArr2 = new byte[b4];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
