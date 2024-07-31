package com.mbridge.msdk.foundation.tools;

import android.os.Build;
import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.nio.charset.StandardCharsets;
import kotlin.UByte;
import okio.Utf8;

/* renamed from: com.mbridge.msdk.foundation.tools.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class FastBuffer {

    /* renamed from: a */
    public byte[] f31084a;

    /* renamed from: b */
    public int f31085b;

    /* renamed from: c */
    private char[] f31086c;

    public FastBuffer(int i) {
        this(new byte[i], 0);
    }

    /* renamed from: a */
    public final byte m21863a() {
        byte[] bArr = this.f31084a;
        int i = this.f31085b;
        this.f31085b = i + 1;
        return bArr[i];
    }

    /* renamed from: b */
    public final short m21854b() {
        byte[] bArr = this.f31084a;
        int i = this.f31085b;
        int i2 = i + 1;
        this.f31085b = i2;
        int i3 = bArr[i] & UByte.f41242c;
        this.f31085b = i2 + 1;
        return (short) ((bArr[i2] << 8) | i3);
    }

    /* renamed from: c */
    public final int m21850c() {
        byte[] bArr = this.f31084a;
        int i = this.f31085b;
        int i2 = i + 1;
        this.f31085b = i2;
        int i3 = bArr[i] & UByte.f41242c;
        int i4 = i2 + 1;
        this.f31085b = i4;
        int i5 = i3 | ((bArr[i2] & UByte.f41242c) << 8);
        int i6 = i4 + 1;
        this.f31085b = i6;
        int i7 = i5 | ((bArr[i4] & UByte.f41242c) << 16);
        this.f31085b = i6 + 1;
        return (bArr[i6] << BinaryMemcacheOpcodes.FLUSHQ) | i7;
    }

    /* renamed from: d */
    public final long m21848d() {
        long m21849c = m21849c(this.f31085b);
        this.f31085b += 8;
        return m21849c;
    }

    public FastBuffer(byte[] bArr) {
        this(bArr, 0);
    }

    /* renamed from: b */
    public static int m21851b(String str) {
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
                i3++;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    /* renamed from: c */
    private long m21849c(int i) {
        byte[] bArr = this.f31084a;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        return (bArr[i7 + 1] << 56) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 40) | ((255 & bArr[i7]) << 48);
    }

    /* renamed from: a */
    public final void m21862a(byte b) {
        byte[] bArr = this.f31084a;
        int i = this.f31085b;
        this.f31085b = i + 1;
        bArr[i] = b;
    }

    public FastBuffer(byte[] bArr, int i) {
        this.f31086c = null;
        this.f31084a = bArr;
        this.f31085b = i;
    }

    /* renamed from: a */
    public final void m21856a(short s) {
        byte[] bArr = this.f31084a;
        int i = this.f31085b;
        int i2 = i + 1;
        this.f31085b = i2;
        bArr[i] = (byte) s;
        this.f31085b = i2 + 1;
        bArr[i2] = (byte) (s >> 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final long m21852b(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= m21849c(i6);
            i6 += 8;
        }
        int i8 = i4 << 3;
        while (i5 < i8) {
            j ^= (this.f31084a[i6] & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i9 = (i & 7) << 3;
        return (j >>> (64 - i9)) | (j << i9);
    }

    /* renamed from: a */
    public final void m21861a(int i) {
        byte[] bArr = this.f31084a;
        int i2 = this.f31085b;
        int i3 = i2 + 1;
        this.f31085b = i3;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        this.f31085b = i4;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i4 + 1;
        this.f31085b = i5;
        bArr[i4] = (byte) (i >> 16);
        this.f31085b = i5 + 1;
        bArr[i5] = (byte) (i >> 24);
    }

    /* renamed from: b */
    public final String m21853b(int i) {
        String str;
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        if (i > 2048) {
            if (Build.VERSION.SDK_INT >= 19) {
                str = new String(this.f31084a, this.f31085b, i, StandardCharsets.UTF_8);
            } else {
                str = new String(this.f31084a, this.f31085b, i);
            }
        } else {
            char[] cArr = this.f31086c;
            if (cArr == null) {
                if (i <= 256) {
                    this.f31086c = new char[256];
                } else {
                    this.f31086c = new char[2048];
                }
            } else if (cArr.length < i) {
                this.f31086c = new char[2048];
            }
            char[] cArr2 = this.f31086c;
            byte[] bArr = this.f31084a;
            int i2 = this.f31085b;
            int i3 = i2 + i;
            int i4 = 0;
            while (i2 < i3) {
                int i5 = i2 + 1;
                byte b = bArr[i2];
                if (b > 0) {
                    cArr2[i4] = (char) b;
                    i2 = i5;
                    i4++;
                } else if (b < -32) {
                    cArr2[i4] = (char) (((b & 31) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                    i2 = i5 + 1;
                    i4++;
                } else if (b < -16) {
                    int i6 = i5 + 1;
                    cArr2[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                    i2 = i6 + 1;
                    i4++;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i7 + 1;
                    int i9 = ((b & 7) << 18) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i8] & Utf8.REPLACEMENT_BYTE);
                    int i10 = i4 + 1;
                    cArr2[i4] = (char) ((i9 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                    i4 = i10 + 1;
                    cArr2[i10] = (char) ((i9 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                    i2 = i8 + 1;
                }
            }
            if (i2 <= i3) {
                str = new String(cArr2, 0, i4);
            } else {
                throw new IllegalArgumentException("Invalid String");
            }
        }
        this.f31085b += i;
        return str;
    }

    /* renamed from: a */
    public final void m21860a(int i, int i2) {
        byte[] bArr = this.f31084a;
        int i3 = i + 1;
        bArr[i] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >> 8);
        bArr[i4] = (byte) (i2 >> 16);
        bArr[i4 + 1] = (byte) (i2 >> 24);
    }

    /* renamed from: a */
    public final void m21859a(int i, long j) {
        byte[] bArr = this.f31084a;
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

    /* renamed from: a */
    public final void m21858a(long j) {
        m21859a(this.f31085b, j);
        this.f31085b += 8;
    }

    /* renamed from: a */
    public final void m21855a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.f31084a, this.f31085b, length);
            this.f31085b += length;
        }
    }

    /* renamed from: a */
    public final void m21857a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        byte[] bArr = this.f31084a;
        int i = this.f31085b;
        int i2 = 0;
        int length = str.length();
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                bArr[i] = (byte) charAt;
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
        this.f31085b = i;
    }
}
