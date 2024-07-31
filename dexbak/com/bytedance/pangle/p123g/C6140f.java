package com.bytedance.pangle.p123g;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.pangle.g.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6140f {

    /* renamed from: a */
    static final HashMap<String, SparseArray<C6151m>> f22022a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.g.f$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6142a implements InterfaceC6148j {

        /* renamed from: a */
        private final MessageDigest[] f22023a;

        C6142a(MessageDigest[] messageDigestArr) {
            this.f22023a = messageDigestArr;
        }

        @Override // com.bytedance.pangle.p123g.InterfaceC6148j
        /* renamed from: a */
        public final void mo37100a(ByteBuffer byteBuffer) {
            MessageDigest[] messageDigestArr;
            ByteBuffer slice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.f22023a) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 21)
    /* renamed from: a */
    public static void m37120a(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, C6151m c6151m) {
        if (!map.isEmpty()) {
            ArrayMap arrayMap = new ArrayMap();
            boolean z = true;
            if (map.containsKey(1)) {
                arrayMap.put(1, map.get(1));
            }
            if (map.containsKey(2)) {
                arrayMap.put(2, map.get(2));
            }
            boolean z2 = false;
            if (!arrayMap.isEmpty()) {
                try {
                    m37121a(arrayMap, randomAccessFile.getFD(), c6151m);
                    z = false;
                } catch (IOException e) {
                    throw new SecurityException("Cannot get FD", e);
                }
            }
            if (map.containsKey(3)) {
                try {
                    if (!Arrays.equals(m37119a(map.get(3), randomAccessFile.length(), c6151m), AbstractC6143g.m37109a(randomAccessFile, c6151m, new InterfaceC6147i() { // from class: com.bytedance.pangle.g.f.1
                        @Override // com.bytedance.pangle.p123g.InterfaceC6147i
                        /* renamed from: a */
                        public final ByteBuffer mo37101a(int i) {
                            return ByteBuffer.allocate(i);
                        }
                    }).f22026b)) {
                        throw new SecurityException("APK verity digest of contents did not verify");
                    }
                } catch (IOException | DigestException | NoSuchAlgorithmException e2) {
                    throw new SecurityException("Error during verification", e2);
                }
            } else {
                z2 = z;
            }
            if (z2) {
                throw new SecurityException("No known digest exists for integrity check");
            }
            return;
        }
        throw new SecurityException("No digests provided");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m37117b(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "SHA-256";
                }
                throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
            }
            return "SHA-512";
        }
        return "SHA-256";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m37114c(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i != 769) {
            if (i != 1057) {
                if (i != 1059) {
                    if (i != 1061) {
                        switch (i) {
                            case 257:
                            case 258:
                            case 259:
                            case 260:
                                return "RSA";
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                        }
                    }
                    return "DSA";
                }
                return "EC";
            }
            return "RSA";
        }
        return "DSA";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static Pair<String, ? extends AlgorithmParameterSpec> m37113d(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i != 1057) {
                        if (i != 1059) {
                            if (i != 1061) {
                                switch (i) {
                                    case 257:
                                        return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                    case 258:
                                        return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                    case 259:
                                        break;
                                    case 260:
                                        return Pair.create("SHA512withRSA", null);
                                    default:
                                        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                                }
                            }
                        }
                    }
                    return Pair.create("SHA256withRSA", null);
                }
                return Pair.create("SHA256withDSA", null);
            }
            return Pair.create("SHA512withECDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    /* renamed from: e */
    private static int m37112e(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return 32;
                }
                throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
            }
            return 64;
        }
        return 32;
    }

    /* renamed from: b */
    private static ByteBuffer m37115b(ByteBuffer byteBuffer, int i) {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 >= position && i2 <= limit) {
                byteBuffer.limit(i2);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i2);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static byte[] m37116b(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    /* renamed from: a */
    private static void m37121a(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, C6151m c6151m) {
        C6150l c6150l = new C6150l(fileDescriptor, 0L, c6151m.f22038b);
        long j = c6151m.f22039c;
        C6150l c6150l2 = new C6150l(fileDescriptor, j, c6151m.f22040d - j);
        ByteBuffer duplicate = c6151m.f22041e.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        long j2 = c6151m.f22038b;
        AbstractC6157s.m37093a(duplicate);
        int position = duplicate.position() + 16;
        if (j2 >= 0 && j2 <= 4294967295L) {
            duplicate.putInt(duplicate.position() + position, (int) j2);
            C6146h c6146h = new C6146h(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i = 0;
            for (Integer num : map.keySet()) {
                iArr[i] = num.intValue();
                i++;
            }
            try {
                byte[][] m37118a = m37118a(iArr, new InterfaceC6149k[]{c6150l, c6150l2, c6146h});
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = iArr[i2];
                    if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), m37118a[i2])) {
                        throw new SecurityException(m37117b(i3) + " digest of contents did not verify");
                    }
                }
                return;
            } catch (DigestException e) {
                throw new SecurityException("Failed to compute digest(s) of contents", e);
            }
        }
        throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j2)));
    }

    /* renamed from: a */
    private static byte[][] m37118a(int[] iArr, InterfaceC6149k[] interfaceC6149kArr) {
        int i;
        long j;
        MessageDigest messageDigest;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        while (true) {
            i = 3;
            j = 1048576;
            if (i2 >= 3) {
                break;
            }
            j3 += ((interfaceC6149kArr[i2].mo37099a() + 1048576) - 1) / 1048576;
            i2++;
        }
        if (j3 < 2097151) {
            int i3 = (int) j3;
            byte[][] bArr = new byte[iArr.length];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                byte[] bArr2 = new byte[(m37112e(iArr[i4]) * i3) + 5];
                bArr2[0] = 90;
                m37125a(i3, bArr2);
                bArr[i4] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                String m37117b = m37117b(iArr[i5]);
                try {
                    messageDigestArr[i5] = MessageDigest.getInstance(m37117b);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(m37117b + " digest not supported", e);
                }
            }
            C6142a c6142a = new C6142a(messageDigestArr);
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i) {
                InterfaceC6149k interfaceC6149k = interfaceC6149kArr[i6];
                long j4 = j2;
                int i9 = i8;
                C6142a c6142a2 = c6142a;
                long mo37099a = interfaceC6149k.mo37099a();
                while (mo37099a > j2) {
                    int min = (int) Math.min(mo37099a, j);
                    m37125a(min, bArr3);
                    for (int i10 = 0; i10 < length; i10++) {
                        messageDigestArr[i10].update(bArr3);
                    }
                    C6142a c6142a3 = c6142a2;
                    long j5 = j4;
                    try {
                        interfaceC6149k.mo37098a(c6142a3, j5, min);
                        c6142a2 = c6142a3;
                        InterfaceC6149k interfaceC6149k2 = interfaceC6149k;
                        int i11 = 0;
                        while (i11 < iArr.length) {
                            int i12 = iArr[i11];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i11];
                            int m37112e = m37112e(i12);
                            int i13 = length;
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigestArr[i11].digest(bArr5, (i9 * m37112e) + 5, m37112e);
                            if (digest != m37112e) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                            i11++;
                            bArr3 = bArr4;
                            length = i13;
                            messageDigestArr = messageDigestArr2;
                        }
                        long j6 = min;
                        long j7 = j5 + j6;
                        mo37099a -= j6;
                        i9++;
                        j2 = 0;
                        j = 1048576;
                        interfaceC6149k = interfaceC6149k2;
                        bArr3 = bArr3;
                        j4 = j7;
                    } catch (IOException e2) {
                        throw new DigestException("Failed to digest chunk #" + i9 + " of section #" + i7, e2);
                    }
                }
                i7++;
                i6++;
                i8 = i9;
                c6142a = c6142a2;
                j2 = 0;
                i = 3;
                j = 1048576;
            }
            byte[][] bArr6 = new byte[iArr.length];
            for (int i14 = 0; i14 < iArr.length; i14++) {
                int i15 = iArr[i14];
                byte[] bArr7 = bArr[i14];
                String m37117b2 = m37117b(i15);
                try {
                    bArr6[i14] = MessageDigest.getInstance(m37117b2).digest(bArr7);
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(m37117b2 + " digest not supported", e3);
                }
            }
            return bArr6;
        }
        throw new DigestException("Too many chunks: ".concat(String.valueOf(j3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m37119a(byte[] bArr, long j, C6151m c6151m) {
        if (bArr.length == 40) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.position(32);
            if (order.getLong() == j - (c6151m.f22039c - c6151m.f22038b)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m37126a(int i, int i2) {
        int m37127a = m37127a(i);
        int m37127a2 = m37127a(i2);
        if (m37127a == 1) {
            if (m37127a2 != 1) {
                if (m37127a2 == 2 || m37127a2 == 3) {
                    return -1;
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(m37127a2)));
            }
            return 0;
        } else if (m37127a == 2) {
            if (m37127a2 != 1) {
                if (m37127a2 == 2) {
                    return 0;
                }
                if (m37127a2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(m37127a2)));
                }
            }
            return 1;
        } else if (m37127a == 3) {
            if (m37127a2 != 1) {
                if (m37127a2 != 2) {
                    if (m37127a2 == 3) {
                        return 0;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(m37127a2)));
                }
                return -1;
            }
            return 1;
        } else {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(m37127a)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m37127a(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i == 1057 || i == 1059 || i == 1061) {
                        return 3;
                    }
                    switch (i) {
                        case 257:
                        case 259:
                            return 1;
                        case 258:
                        case 260:
                            return 2;
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    /* renamed from: a */
    private static ByteBuffer m37122a(ByteBuffer byteBuffer, int i) {
        if (i >= 8) {
            int capacity = byteBuffer.capacity();
            if (i <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i + " < 8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static ByteBuffer m37123a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return m37115b(byteBuffer, i);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    /* renamed from: a */
    private static void m37125a(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) ((i >>> 24) & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0246  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m37124a(java.lang.String r24, java.io.RandomAccessFile r25, int... r26) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.p123g.C6140f.m37124a(java.lang.String, java.io.RandomAccessFile, int[]):void");
    }
}
