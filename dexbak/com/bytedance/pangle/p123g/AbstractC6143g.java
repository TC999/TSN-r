package com.bytedance.pangle.p123g;

import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.ArrayList;

/* renamed from: com.bytedance.pangle.g.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
abstract class AbstractC6143g {

    /* renamed from: a */
    private static final byte[] f22024a = new byte[8];

    /* renamed from: com.bytedance.pangle.g.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6144a {

        /* renamed from: a */
        public final ByteBuffer f22025a;

        /* renamed from: b */
        public final byte[] f22026b;

        C6144a(ByteBuffer byteBuffer, byte[] bArr) {
            this.f22025a = byteBuffer;
            this.f22026b = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.g.g$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6145b implements InterfaceC6148j {

        /* renamed from: a */
        private int f22027a;

        /* renamed from: b */
        private final ByteBuffer f22028b;

        /* renamed from: c */
        private final MessageDigest f22029c;

        /* renamed from: d */
        private final byte[] f22030d;

        /* renamed from: e */
        private final byte[] f22031e;

        /* synthetic */ C6145b(byte[] bArr, ByteBuffer byteBuffer, byte b) {
            this(bArr, byteBuffer);
        }

        @Override // com.bytedance.pangle.p123g.InterfaceC6148j
        /* renamed from: a */
        public final void mo37100a(ByteBuffer byteBuffer) {
            byteBuffer.position();
            int remaining = byteBuffer.remaining();
            while (remaining > 0) {
                int min = Math.min(remaining, 4096 - this.f22027a);
                byteBuffer.limit(byteBuffer.position() + min);
                this.f22029c.update(byteBuffer);
                remaining -= min;
                int i = this.f22027a + min;
                this.f22027a = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.f22029c;
                    byte[] bArr = this.f22030d;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.f22028b.put(this.f22030d);
                    this.f22029c.update(this.f22031e);
                    this.f22027a = 0;
                }
            }
        }

        /* renamed from: b */
        final void m37102b() {
            int position = this.f22028b.position() % 4096;
            if (position == 0) {
                return;
            }
            this.f22028b.put(ByteBuffer.allocate(4096 - position));
        }

        private C6145b(byte[] bArr, ByteBuffer byteBuffer) {
            this.f22030d = new byte[32];
            this.f22031e = bArr;
            this.f22028b = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.f22029c = messageDigest;
            messageDigest.update(bArr);
            this.f22027a = 0;
        }

        /* renamed from: a */
        public final void m37103a() {
            if (this.f22027a == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.f22027a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C6144a m37109a(RandomAccessFile randomAccessFile, C6151m c6151m, InterfaceC6147i interfaceC6147i) {
        int[] m37111a = m37111a(randomAccessFile.length() - (c6151m.f22039c - c6151m.f22038b));
        int i = m37111a[m37111a.length - 1];
        int i2 = i + 4096;
        ByteBuffer mo37101a = interfaceC6147i.mo37101a(i2);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        mo37101a.order(byteOrder);
        ByteBuffer m37106a = m37106a(mo37101a, 0, i);
        int i3 = i + 64;
        ByteBuffer m37106a2 = m37106a(mo37101a, i, i3);
        ByteBuffer m37106a3 = m37106a(mo37101a, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(byteOrder);
        long j = c6151m.f22038b;
        if (j % 4096 == 0) {
            long j2 = c6151m.f22039c;
            if ((j2 - j) % 4096 == 0) {
                long j3 = j2 - j;
                int[] m37111a2 = m37111a(randomAccessFile.length() - j3);
                if (m37106a != null) {
                    wrap.put(m37108a(randomAccessFile, c6151m, f22024a, m37111a2, m37106a));
                    wrap.flip();
                }
                if (m37106a2 != null) {
                    m37106a2.order(byteOrder);
                    long length = randomAccessFile.length();
                    byte[] bArr2 = f22024a;
                    if (bArr2.length == 8) {
                        m37106a2.put("TrueBrew".getBytes());
                        m37106a2.put((byte) 1);
                        m37106a2.put((byte) 0);
                        m37106a2.put((byte) 12);
                        m37106a2.put((byte) 7);
                        m37106a2.putShort((short) 1);
                        m37106a2.putShort((short) 1);
                        m37106a2.putInt(0);
                        m37106a2.putInt(0);
                        m37106a2.putLong(length);
                        m37106a2.put((byte) 2);
                        m37106a2.put((byte) 0);
                        m37106a2.put(bArr2);
                        m37107a(m37106a2, 22);
                        m37106a2.flip();
                    } else {
                        throw new IllegalArgumentException("salt is not 8 bytes long");
                    }
                }
                if (m37106a3 != null) {
                    m37106a3.order(byteOrder);
                    long j4 = c6151m.f22038b;
                    long j5 = c6151m.f22040d;
                    m37106a3.putInt(24);
                    m37106a3.putShort((short) 1);
                    m37107a(m37106a3, 2);
                    m37106a3.putLong(j4);
                    m37106a3.putLong(j3);
                    m37106a3.putInt(20);
                    m37106a3.putShort((short) 2);
                    m37107a(m37106a3, 2);
                    m37106a3.putLong(j5 + 16);
                    m37106a3.putInt(m37104c(j4));
                    m37107a(m37106a3, 4);
                    m37106a3.flip();
                }
                mo37101a.position(i3 + m37106a3.limit());
                mo37101a.putInt(m37106a3.limit() + 64 + 4);
                mo37101a.flip();
                return new C6144a(mo37101a, bArr);
            }
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (c6151m.f22039c - c6151m.f22038b));
        }
        throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + c6151m.f22038b);
    }

    /* renamed from: b */
    private static long m37105b(long j) {
        return ((j + 4096) - 1) / 4096;
    }

    /* renamed from: c */
    private static int m37104c(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* renamed from: a */
    private static void m37110a(InterfaceC6148j interfaceC6148j, InterfaceC6149k interfaceC6149k, int i) {
        long mo37099a = interfaceC6149k.mo37099a();
        long j = 0;
        while (mo37099a > 0) {
            int min = (int) Math.min(mo37099a, i);
            interfaceC6149k.mo37098a(interfaceC6148j, j, min);
            long j2 = min;
            j += j2;
            mo37099a -= j2;
        }
    }

    /* renamed from: a */
    private static byte[] m37108a(RandomAccessFile randomAccessFile, C6151m c6151m, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) {
        C6145b c6145b = new C6145b(bArr, m37106a(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]), (byte) 0);
        m37110a(c6145b, new C6150l(randomAccessFile.getFD(), 0L, c6151m.f22038b), 1048576);
        long j = c6151m.f22040d + 16;
        FileDescriptor fd = randomAccessFile.getFD();
        long j2 = c6151m.f22039c;
        m37110a(c6145b, new C6150l(fd, j2, j - j2), 1048576);
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(m37104c(c6151m.f22038b));
        order.flip();
        c6145b.mo37100a(order);
        long j3 = j + 4;
        m37110a(c6145b, new C6150l(randomAccessFile.getFD(), j3, randomAccessFile.length() - j3), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            c6145b.mo37100a(ByteBuffer.allocate(4096 - length));
        }
        c6145b.m37103a();
        c6145b.m37102b();
        for (int length2 = iArr.length - 3; length2 >= 0; length2--) {
            int i = length2 + 1;
            ByteBuffer m37106a = m37106a(byteBuffer, iArr[i], iArr[length2 + 2]);
            ByteBuffer m37106a2 = m37106a(byteBuffer, iArr[length2], iArr[i]);
            C6146h c6146h = new C6146h(m37106a);
            C6145b c6145b2 = new C6145b(bArr, m37106a2, (byte) 0);
            m37110a(c6145b2, c6146h, 4096);
            c6145b2.m37103a();
            c6145b2.m37102b();
        }
        byte[] bArr2 = new byte[32];
        C6145b c6145b3 = new C6145b(bArr, ByteBuffer.wrap(bArr2), (byte) 0);
        c6145b3.mo37100a(m37106a(byteBuffer, 0, 4096));
        c6145b3.m37103a();
        return bArr2;
    }

    /* renamed from: a */
    private static int[] m37111a(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = m37105b(j) * 32;
            arrayList.add(Long.valueOf(m37105b(j) * 4096));
        } while (j > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + m37104c(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    /* renamed from: a */
    private static ByteBuffer m37106a(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i2);
        duplicate.position(i);
        return duplicate.slice();
    }

    /* renamed from: a */
    private static void m37107a(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }
}
