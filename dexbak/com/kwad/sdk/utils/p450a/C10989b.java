package com.kwad.sdk.utils.p450a;

import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.jvm.internal.C14354n;
import okio.Utf8;

/* renamed from: com.kwad.sdk.utils.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10989b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] aRn;
    public byte[] aRo;
    public int position;

    public C10989b(int i) {
        this(new byte[i], 0);
    }

    /* renamed from: C */
    private int m24263C(int i, int i2) {
        while ((i2 & (-128)) != 0) {
            this.aRo[i] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i++;
        }
        int i3 = i + 1;
        this.aRo[i] = (byte) i2;
        return i3;
    }

    /* renamed from: eg */
    public static int m24255eg(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    /* renamed from: ei */
    private char[] m24253ei(int i) {
        char[] cArr = this.aRn;
        if (cArr == null) {
            if (i <= 256) {
                this.aRn = new char[256];
            } else {
                this.aRn = new char[2048];
            }
        } else if (cArr.length < i) {
            this.aRn = new char[2048];
        }
        return this.aRn;
    }

    /* renamed from: ej */
    private String m24252ej(int i) {
        if (i > 2048) {
            return new String(this.aRo, this.position, i, UTF_8);
        }
        char[] m24253ei = m24253ei(i);
        byte[] bArr = this.aRo;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                m24253ei[i4] = (char) (b ^ 1);
                i2 = i5;
                i4++;
            } else if (b < -32) {
                m24253ei[i4] = (char) (((b & 31) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                m24253ei[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i2 = i7;
                i4++;
            } else {
                int i8 = i5 + 1;
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                int i11 = ((b & 7) << 18) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i8] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i9] & Utf8.REPLACEMENT_BYTE);
                int i12 = i4 + 1;
                m24253ei[i4] = (char) ((i11 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 = i12 + 1;
                m24253ei[i12] = (char) ((i11 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i2 = i10;
            }
        }
        if (i2 <= i3) {
            return new String(m24253ei, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    /* renamed from: ek */
    private String m24251ek(int i) {
        if (i > 2048) {
            return new String(this.aRo, this.position, i, UTF_8);
        }
        char[] m24253ei = m24253ei(i);
        byte[] bArr = this.aRo;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                m24253ei[i4] = (char) b;
                i2 = i5;
                i4++;
            } else if (b < -32) {
                m24253ei[i4] = (char) (((b & 31) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                m24253ei[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i2 = i7;
                i4++;
            } else {
                int i8 = i5 + 1;
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                int i11 = ((b & 7) << 18) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i8] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i9] & Utf8.REPLACEMENT_BYTE);
                int i12 = i4 + 1;
                m24253ei[i4] = (char) ((i11 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 = i12 + 1;
                m24253ei[i12] = (char) ((i11 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i2 = i10;
            }
        }
        if (i2 <= i3) {
            return new String(m24253ei, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private long getLong(int i) {
        byte[] bArr = this.aRo;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        return (bArr[i7 + 1] << 56) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 40) | ((255 & bArr[i7]) << 48);
    }

    /* renamed from: he */
    public static int m24248he(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                i2++;
            } else if (charAt < 2048) {
                i2 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i2 += 3;
            } else {
                i = i3 + 1;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    /* renamed from: hf */
    private void m24247hf(String str) {
        byte[] bArr = this.aRo;
        int i = this.position;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                bArr[i] = (byte) (charAt ^ 1);
                i2 = i3;
                i++;
            } else if (charAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((charAt >>> 6) | Opcodes.CHECKCAST);
                i = i4 + 1;
                bArr[i4] = (byte) ((charAt & '?') | 128);
                i2 = i3;
            } else if (charAt >= 55296 && charAt <= 57343) {
                int i5 = i3 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                int i6 = i + 1;
                bArr[i] = (byte) ((charAt2 >>> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i = i8 + 1;
                bArr[i8] = (byte) ((charAt2 & 63) | 128);
                i2 = i5;
            } else {
                int i9 = i + 1;
                bArr[i] = (byte) ((charAt >>> '\f') | 224);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i10] = (byte) ((charAt & '?') | 128);
                i2 = i3;
                i = i10 + 1;
            }
        }
        this.position = i;
    }

    /* renamed from: hg */
    public static byte[] m24246hg(String str) {
        byte[] bArr = new byte[m24248he(str)];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                bArr[i2] = (byte) (charAt ^ 1);
                i = i3;
                i2++;
            } else if (charAt < 2048) {
                int i4 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> 6) | Opcodes.CHECKCAST);
                i2 = i4 + 1;
                bArr[i4] = (byte) ((charAt & '?') | 128);
                i = i3;
            } else if (charAt >= 55296 && charAt <= 57343) {
                int i5 = i3 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                int i6 = i2 + 1;
                bArr[i2] = (byte) ((charAt2 >>> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i2 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 & 63) | 128);
                i = i5;
            } else {
                int i9 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> '\f') | 224);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i10] = (byte) ((charAt & '?') | 128);
                i = i3;
                i2 = i10 + 1;
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static String m24245j(byte[] bArr, int i) {
        char[] cArr = new char[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArr[i3] = (char) (b ^ 1);
                i2 = i4;
                i3++;
            } else if (b < -32) {
                cArr[i3] = (char) (((b & 31) << 6) | (bArr[i4] & Utf8.REPLACEMENT_BYTE));
                i2 = i4 + 1;
                i3++;
            } else if (b < -16) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                cArr[i3] = (char) (((b & 15) << 12) | ((bArr[i4] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i2 = i6;
                i3++;
            } else {
                int i7 = i4 + 1;
                int i8 = i7 + 1;
                int i9 = i8 + 1;
                int i10 = ((b & 7) << 18) | ((bArr[i4] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i8] & Utf8.REPLACEMENT_BYTE);
                int i11 = i3 + 1;
                cArr[i3] = (char) ((i10 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i3 = i11 + 1;
                cArr[i11] = (char) ((i10 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i2 = i9;
            }
        }
        if (i2 <= i) {
            return new String(cArr, 0, i3);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    /* renamed from: B */
    public final void m24264B(int i, int i2) {
        byte[] bArr = this.aRo;
        int i3 = i + 1;
        bArr[i] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >> 8);
        bArr[i4] = (byte) (i2 >> 16);
        bArr[i4 + 1] = (byte) (i2 >> 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: D */
    public final long m24262D(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= getLong(i6);
            i6 += 8;
        }
        int i8 = i4 << 3;
        while (i5 < i8) {
            j ^= (this.aRo[i6] & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i9 = (i & 7) << 3;
        return (j >>> (64 - i9)) | (j << i9);
    }

    /* renamed from: Nt */
    public final int m24261Nt() {
        byte[] bArr = this.aRo;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = b & C14354n.f41155b;
        int i4 = i2 + 1;
        this.position = i4;
        int i5 = i3 | (bArr[i2] << 7);
        if ((i5 >> 14) == 0) {
            return i5;
        }
        int i6 = i4 + 1;
        this.position = i6;
        int i7 = (i5 & 16383) | (bArr[i4] << 14);
        if ((i7 >> 21) == 0) {
            return i7;
        }
        int i8 = i6 + 1;
        this.position = i8;
        int i9 = (i7 & 2097151) | (bArr[i6] << BinaryMemcacheOpcodes.INCREMENTQ);
        if ((i9 >> 28) == 0) {
            return i9;
        }
        this.position = i8 + 1;
        return (bArr[i8] << BinaryMemcacheOpcodes.TOUCH) | (i9 & 268435455);
    }

    /* renamed from: a */
    public final void m24260a(short s) {
        byte[] bArr = this.aRo;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) s;
        this.position = i2 + 1;
        bArr[i2] = (byte) (s >> 8);
    }

    /* renamed from: aH */
    public final void m24259aH(long j) {
        m24250f(this.position, j);
        this.position += 8;
    }

    /* renamed from: e */
    public final void m24258e(byte b) {
        byte[] bArr = this.aRo;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    /* renamed from: ee */
    public final void m24257ee(int i) {
        byte[] bArr = this.aRo;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) (i >> 16);
        this.position = i5 + 1;
        bArr[i5] = (byte) (i >> 24);
    }

    /* renamed from: ef */
    public final void m24256ef(int i) {
        this.position = m24263C(this.position, i);
    }

    /* renamed from: eh */
    public final String m24254eh(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String m24251ek = m24251ek(i);
        this.position += i;
        return m24251ek;
    }

    /* renamed from: f */
    public final void m24250f(int i, long j) {
        byte[] bArr = this.aRo;
        int i2 = i + 1;
        bArr[i] = (byte) j;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j >> 8);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >> 24);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >> 32);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >> 40);
        bArr[i7] = (byte) (j >> 48);
        bArr[i7 + 1] = (byte) (j >> 56);
    }

    public final byte get() {
        byte[] bArr = this.aRo;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public final byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.aRo, this.position, bArr, 0, i);
        this.position += i;
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final int getInt() {
        byte[] bArr = this.aRo;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & UByte.f41242c;
        int i4 = i2 + 1;
        this.position = i4;
        int i5 = i3 | ((bArr[i2] & UByte.f41242c) << 8);
        int i6 = i4 + 1;
        this.position = i6;
        int i7 = i5 | ((bArr[i4] & UByte.f41242c) << 16);
        this.position = i6 + 1;
        return (bArr[i6] << BinaryMemcacheOpcodes.FLUSHQ) | i7;
    }

    public final short getShort() {
        byte[] bArr = this.aRo;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & UByte.f41242c;
        this.position = i2 + 1;
        return (short) ((bArr[i2] << 8) | i3);
    }

    public final String getString(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String m24252ej = m24252ej(i);
        this.position += i;
        return m24252ej;
    }

    /* renamed from: hd */
    public final void m24249hd(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        m24247hf(str);
    }

    /* renamed from: n */
    public final void m24244n(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.aRo, this.position, length);
            this.position += length;
        }
    }

    public C10989b(byte[] bArr) {
        this(bArr, 0);
    }

    public final long getLong() {
        long j = getLong(this.position);
        this.position += 8;
        return j;
    }

    public C10989b(byte[] bArr, int i) {
        this.aRn = null;
        this.aRo = bArr;
        this.position = i;
    }
}
