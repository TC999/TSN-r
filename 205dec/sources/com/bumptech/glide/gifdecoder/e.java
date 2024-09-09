package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StandardGifDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e implements GifDecoder {
    private static final String A = "e";
    private static final int B = 4096;
    private static final int C = -1;
    private static final int D = -1;
    private static final int E = 4;
    private static final int F = 255;
    @ColorInt
    private static final int G = 0;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    private int[] f16748f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    private final int[] f16749g;

    /* renamed from: h  reason: collision with root package name */
    private final GifDecoder.a f16750h;

    /* renamed from: i  reason: collision with root package name */
    private ByteBuffer f16751i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f16752j;

    /* renamed from: k  reason: collision with root package name */
    private d f16753k;

    /* renamed from: l  reason: collision with root package name */
    private short[] f16754l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f16755m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f16756n;

    /* renamed from: o  reason: collision with root package name */
    private byte[] f16757o;
    @ColorInt

    /* renamed from: p  reason: collision with root package name */
    private int[] f16758p;

    /* renamed from: q  reason: collision with root package name */
    private int f16759q;

    /* renamed from: r  reason: collision with root package name */
    private c f16760r;

    /* renamed from: s  reason: collision with root package name */
    private Bitmap f16761s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f16762t;

    /* renamed from: u  reason: collision with root package name */
    private int f16763u;

    /* renamed from: v  reason: collision with root package name */
    private int f16764v;

    /* renamed from: w  reason: collision with root package name */
    private int f16765w;

    /* renamed from: x  reason: collision with root package name */
    private int f16766x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private Boolean f16767y;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    private Bitmap.Config f16768z;

    public e(@NonNull GifDecoder.a aVar, c cVar, ByteBuffer byteBuffer) {
        this(aVar, cVar, byteBuffer, 1);
    }

    @ColorInt
    private int q(int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = i4; i12 < this.f16764v + i4; i12++) {
            byte[] bArr = this.f16757o;
            if (i12 >= bArr.length || i12 >= i5) {
                break;
            }
            int i13 = this.f16748f[bArr[i12] & 255];
            if (i13 != 0) {
                i7 += (i13 >> 24) & 255;
                i8 += (i13 >> 16) & 255;
                i9 += (i13 >> 8) & 255;
                i10 += i13 & 255;
                i11++;
            }
        }
        int i14 = i4 + i6;
        for (int i15 = i14; i15 < this.f16764v + i14; i15++) {
            byte[] bArr2 = this.f16757o;
            if (i15 >= bArr2.length || i15 >= i5) {
                break;
            }
            int i16 = this.f16748f[bArr2[i15] & 255];
            if (i16 != 0) {
                i7 += (i16 >> 24) & 255;
                i8 += (i16 >> 16) & 255;
                i9 += (i16 >> 8) & 255;
                i10 += i16 & 255;
                i11++;
            }
        }
        if (i11 == 0) {
            return 0;
        }
        return ((i7 / i11) << 24) | ((i8 / i11) << 16) | ((i9 / i11) << 8) | (i10 / i11);
    }

    private void r(b bVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr = this.f16758p;
        int i9 = bVar.f16701d;
        int i10 = this.f16764v;
        int i11 = i9 / i10;
        int i12 = bVar.f16699b / i10;
        int i13 = bVar.f16700c / i10;
        int i14 = bVar.f16698a / i10;
        boolean z3 = this.f16759q == 0;
        int i15 = this.f16766x;
        int i16 = this.f16765w;
        byte[] bArr = this.f16757o;
        int[] iArr2 = this.f16748f;
        Boolean bool = this.f16767y;
        int i17 = 8;
        int i18 = 0;
        int i19 = 0;
        int i20 = 1;
        while (i18 < i11) {
            Boolean bool2 = bool;
            if (bVar.f16702e) {
                if (i19 >= i11) {
                    i4 = i11;
                    int i21 = i20 + 1;
                    if (i21 == 2) {
                        i20 = i21;
                        i19 = 4;
                    } else if (i21 == 3) {
                        i20 = i21;
                        i19 = 2;
                        i17 = 4;
                    } else if (i21 != 4) {
                        i20 = i21;
                    } else {
                        i20 = i21;
                        i19 = 1;
                        i17 = 2;
                    }
                } else {
                    i4 = i11;
                }
                i5 = i19 + i17;
            } else {
                i4 = i11;
                i5 = i19;
                i19 = i18;
            }
            int i22 = i19 + i12;
            boolean z4 = i10 == 1;
            if (i22 < i16) {
                int i23 = i22 * i15;
                int i24 = i23 + i14;
                int i25 = i24 + i13;
                int i26 = i23 + i15;
                if (i26 < i25) {
                    i25 = i26;
                }
                i6 = i5;
                int i27 = i18 * i10 * bVar.f16700c;
                if (z4) {
                    int i28 = i24;
                    while (i28 < i25) {
                        int i29 = i12;
                        int i30 = iArr2[bArr[i27] & 255];
                        if (i30 != 0) {
                            iArr[i28] = i30;
                        } else if (z3 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i27 += i10;
                        i28++;
                        i12 = i29;
                    }
                } else {
                    i8 = i12;
                    int i31 = ((i25 - i24) * i10) + i27;
                    int i32 = i24;
                    while (true) {
                        i7 = i13;
                        if (i32 < i25) {
                            int q3 = q(i27, i31, bVar.f16700c);
                            if (q3 != 0) {
                                iArr[i32] = q3;
                            } else if (z3 && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i27 += i10;
                            i32++;
                            i13 = i7;
                        }
                    }
                    bool = bool2;
                    i18++;
                    i12 = i8;
                    i13 = i7;
                    i11 = i4;
                    i19 = i6;
                }
            } else {
                i6 = i5;
            }
            i8 = i12;
            i7 = i13;
            bool = bool2;
            i18++;
            i12 = i8;
            i13 = i7;
            i11 = i4;
            i19 = i6;
        }
        Boolean bool3 = bool;
        if (this.f16767y == null) {
            this.f16767y = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private void s(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f16758p;
        int i4 = bVar2.f16701d;
        int i5 = bVar2.f16699b;
        int i6 = bVar2.f16700c;
        int i7 = bVar2.f16698a;
        boolean z3 = this.f16759q == 0;
        int i8 = this.f16766x;
        byte[] bArr = this.f16757o;
        int[] iArr2 = this.f16748f;
        int i9 = 0;
        byte b4 = -1;
        while (i9 < i4) {
            int i10 = (i9 + i5) * i8;
            int i11 = i10 + i7;
            int i12 = i11 + i6;
            int i13 = i10 + i8;
            if (i13 < i12) {
                i12 = i13;
            }
            int i14 = bVar2.f16700c * i9;
            int i15 = i11;
            while (i15 < i12) {
                byte b5 = bArr[i14];
                int i16 = i4;
                int i17 = b5 & 255;
                if (i17 != b4) {
                    int i18 = iArr2[i17];
                    if (i18 != 0) {
                        iArr[i15] = i18;
                    } else {
                        b4 = b5;
                    }
                }
                i14++;
                i15++;
                i4 = i16;
            }
            i9++;
            bVar2 = bVar;
        }
        this.f16767y = Boolean.valueOf(this.f16767y == null && z3 && b4 != -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(b bVar) {
        int i4;
        int i5;
        short s3;
        e eVar = this;
        if (bVar != null) {
            eVar.f16751i.position(bVar.f16707j);
        }
        if (bVar == null) {
            c cVar = eVar.f16760r;
            i4 = cVar.f16716f;
            i5 = cVar.f16717g;
        } else {
            i4 = bVar.f16700c;
            i5 = bVar.f16701d;
        }
        int i6 = i4 * i5;
        byte[] bArr = eVar.f16757o;
        if (bArr == null || bArr.length < i6) {
            eVar.f16757o = eVar.f16750h.b(i6);
        }
        byte[] bArr2 = eVar.f16757o;
        if (eVar.f16754l == null) {
            eVar.f16754l = new short[4096];
        }
        short[] sArr = eVar.f16754l;
        if (eVar.f16755m == null) {
            eVar.f16755m = new byte[4096];
        }
        byte[] bArr3 = eVar.f16755m;
        if (eVar.f16756n == null) {
            eVar.f16756n = new byte[4097];
        }
        byte[] bArr4 = eVar.f16756n;
        int x3 = x();
        int i7 = 1 << x3;
        int i8 = i7 + 1;
        int i9 = i7 + 2;
        int i10 = x3 + 1;
        int i11 = (1 << i10) - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < i7; i13++) {
            sArr[i13] = 0;
            bArr3[i13] = (byte) i13;
        }
        byte[] bArr5 = eVar.f16752j;
        int i14 = i10;
        int i15 = i9;
        int i16 = i11;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        while (true) {
            if (i12 >= i6) {
                break;
            }
            if (i17 == 0) {
                i17 = w();
                if (i17 <= 0) {
                    eVar.f16763u = 3;
                    break;
                }
                i18 = 0;
            }
            i20 += (bArr5[i18] & 255) << i19;
            i18++;
            i17--;
            int i25 = i19 + 8;
            int i26 = i15;
            int i27 = i14;
            int i28 = i22;
            int i29 = i10;
            int i30 = i23;
            while (true) {
                if (i25 < i27) {
                    i22 = i28;
                    i15 = i26;
                    i19 = i25;
                    eVar = this;
                    i23 = i30;
                    i10 = i29;
                    i14 = i27;
                    break;
                }
                int i31 = i9;
                int i32 = i20 & i16;
                i20 >>= i27;
                i25 -= i27;
                if (i32 == i7) {
                    i16 = i11;
                    i27 = i29;
                    i26 = i31;
                    i9 = i26;
                    i28 = -1;
                } else if (i32 == i8) {
                    i19 = i25;
                    i23 = i30;
                    i15 = i26;
                    i10 = i29;
                    i9 = i31;
                    i22 = i28;
                    i14 = i27;
                    eVar = this;
                    break;
                } else if (i28 == -1) {
                    bArr2[i21] = bArr3[i32];
                    i21++;
                    i12++;
                    i28 = i32;
                    i30 = i28;
                    i9 = i31;
                    i25 = i25;
                } else {
                    if (i32 >= i26) {
                        bArr4[i24] = (byte) i30;
                        i24++;
                        s3 = i28;
                    } else {
                        s3 = i32;
                    }
                    while (s3 >= i7) {
                        bArr4[i24] = bArr3[s3];
                        i24++;
                        s3 = sArr[s3];
                    }
                    i30 = bArr3[s3] & 255;
                    byte b4 = (byte) i30;
                    bArr2[i21] = b4;
                    while (true) {
                        i21++;
                        i12++;
                        if (i24 <= 0) {
                            break;
                        }
                        i24--;
                        bArr2[i21] = bArr4[i24];
                    }
                    byte[] bArr6 = bArr4;
                    if (i26 < 4096) {
                        sArr[i26] = (short) i28;
                        bArr3[i26] = b4;
                        i26++;
                        if ((i26 & i16) == 0 && i26 < 4096) {
                            i27++;
                            i16 += i26;
                        }
                    }
                    i28 = i32;
                    i9 = i31;
                    i25 = i25;
                    bArr4 = bArr6;
                }
            }
        }
        Arrays.fill(bArr2, i21, i6, (byte) 0);
    }

    @NonNull
    private d u() {
        if (this.f16753k == null) {
            this.f16753k = new d();
        }
        return this.f16753k;
    }

    private Bitmap v() {
        Boolean bool = this.f16767y;
        Bitmap c4 = this.f16750h.c(this.f16766x, this.f16765w, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f16768z);
        c4.setHasAlpha(true);
        return c4;
    }

    private int w() {
        int x3 = x();
        if (x3 <= 0) {
            return x3;
        }
        ByteBuffer byteBuffer = this.f16751i;
        byteBuffer.get(this.f16752j, 0, Math.min(x3, byteBuffer.remaining()));
        return x3;
    }

    private int x() {
        return this.f16751i.get() & 255;
    }

    private Bitmap y(b bVar, b bVar2) {
        int i4;
        int i5;
        Bitmap bitmap;
        int[] iArr = this.f16758p;
        int i6 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f16761s;
            if (bitmap2 != null) {
                this.f16750h.a(bitmap2);
            }
            this.f16761s = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f16704g == 3 && this.f16761s == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i5 = bVar2.f16704g) > 0) {
            if (i5 == 2) {
                if (!bVar.f16703f) {
                    c cVar = this.f16760r;
                    int i7 = cVar.f16722l;
                    if (bVar.f16708k == null || cVar.f16720j != bVar.f16705h) {
                        i6 = i7;
                    }
                } else if (this.f16759q == 0) {
                    this.f16767y = Boolean.TRUE;
                }
                int i8 = bVar2.f16701d;
                int i9 = this.f16764v;
                int i10 = i8 / i9;
                int i11 = bVar2.f16699b / i9;
                int i12 = bVar2.f16700c / i9;
                int i13 = bVar2.f16698a / i9;
                int i14 = this.f16766x;
                int i15 = (i11 * i14) + i13;
                int i16 = (i10 * i14) + i15;
                while (i15 < i16) {
                    int i17 = i15 + i12;
                    for (int i18 = i15; i18 < i17; i18++) {
                        iArr[i18] = i6;
                    }
                    i15 += this.f16766x;
                }
            } else if (i5 == 3 && (bitmap = this.f16761s) != null) {
                int i19 = this.f16766x;
                bitmap.getPixels(iArr, 0, i19, 0, 0, i19, this.f16765w);
            }
        }
        t(bVar);
        if (!bVar.f16702e && this.f16764v == 1) {
            s(bVar);
        } else {
            r(bVar);
        }
        if (this.f16762t && ((i4 = bVar.f16704g) == 0 || i4 == 1)) {
            if (this.f16761s == null) {
                this.f16761s = v();
            }
            Bitmap bitmap3 = this.f16761s;
            int i20 = this.f16766x;
            bitmap3.setPixels(iArr, 0, i20, 0, 0, i20, this.f16765w);
        }
        Bitmap v3 = v();
        int i21 = this.f16766x;
        v3.setPixels(iArr, 0, i21, 0, 0, i21, this.f16765w);
        return v3;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap a() {
        if (this.f16760r.f16713c <= 0 || this.f16759q < 0) {
            String str = A;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.f16760r.f16713c + ", framePointer=" + this.f16759q);
            }
            this.f16763u = 1;
        }
        int i4 = this.f16763u;
        if (i4 != 1 && i4 != 2) {
            this.f16763u = 0;
            if (this.f16752j == null) {
                this.f16752j = this.f16750h.b(255);
            }
            b bVar = this.f16760r.f16715e.get(this.f16759q);
            int i5 = this.f16759q - 1;
            b bVar2 = i5 >= 0 ? this.f16760r.f16715e.get(i5) : null;
            int[] iArr = bVar.f16708k;
            if (iArr == null) {
                iArr = this.f16760r.f16711a;
            }
            this.f16748f = iArr;
            if (iArr == null) {
                String str2 = A;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.f16759q);
                }
                this.f16763u = 1;
                return null;
            }
            if (bVar.f16703f) {
                System.arraycopy(iArr, 0, this.f16749g, 0, iArr.length);
                int[] iArr2 = this.f16749g;
                this.f16748f = iArr2;
                iArr2[bVar.f16705h] = 0;
            }
            return y(bVar, bVar2);
        }
        String str3 = A;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.f16763u);
        }
        return null;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void b() {
        this.f16759q = (this.f16759q + 1) % this.f16760r.f16713c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int c() {
        return this.f16760r.f16713c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.f16760r = null;
        byte[] bArr = this.f16757o;
        if (bArr != null) {
            this.f16750h.e(bArr);
        }
        int[] iArr = this.f16758p;
        if (iArr != null) {
            this.f16750h.f(iArr);
        }
        Bitmap bitmap = this.f16761s;
        if (bitmap != null) {
            this.f16750h.a(bitmap);
        }
        this.f16761s = null;
        this.f16751i = null;
        this.f16767y = null;
        byte[] bArr2 = this.f16752j;
        if (bArr2 != null) {
            this.f16750h.e(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void d(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.f16768z = config;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int e(int i4) {
        if (i4 >= 0) {
            c cVar = this.f16760r;
            if (i4 < cVar.f16713c) {
                return cVar.f16715e.get(i4).f16706i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int f() {
        int i4 = this.f16760r.f16723m;
        if (i4 == -1) {
            return 1;
        }
        if (i4 == 0) {
            return 0;
        }
        return i4 + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int g() {
        int i4 = this.f16760r.f16723m;
        if (i4 == -1) {
            return 1;
        }
        return i4;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.f16751i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.f16760r.f16717g;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.f16763u;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.f16760r.f16716f;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void h(@NonNull c cVar, @NonNull byte[] bArr) {
        k(cVar, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int i() {
        int i4;
        if (this.f16760r.f16713c <= 0 || (i4 = this.f16759q) < 0) {
            return 0;
        }
        return e(i4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void j() {
        this.f16759q = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void k(@NonNull c cVar, @NonNull ByteBuffer byteBuffer) {
        m(cVar, byteBuffer, 1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int l() {
        return this.f16759q;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void m(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i4) {
        if (i4 > 0) {
            int highestOneBit = Integer.highestOneBit(i4);
            this.f16763u = 0;
            this.f16760r = cVar;
            this.f16759q = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f16751i = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f16751i.order(ByteOrder.LITTLE_ENDIAN);
            this.f16762t = false;
            Iterator<b> it = cVar.f16715e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f16704g == 3) {
                    this.f16762t = true;
                    break;
                }
            }
            this.f16764v = highestOneBit;
            int i5 = cVar.f16716f;
            this.f16766x = i5 / highestOneBit;
            int i6 = cVar.f16717g;
            this.f16765w = i6 / highestOneBit;
            this.f16757o = this.f16750h.b(i5 * i6);
            this.f16758p = this.f16750h.d(this.f16766x * this.f16765w);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i4);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int n() {
        return this.f16760r.f16723m;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int o(@Nullable InputStream inputStream, int i4) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i4 > 0 ? i4 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e4) {
                Log.w(A, "Error reading data from stream", e4);
            }
        } else {
            this.f16763u = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                Log.w(A, "Error closing stream", e5);
            }
        }
        return this.f16763u;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int p() {
        return this.f16751i.limit() + this.f16757o.length + (this.f16758p.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        c d4 = u().r(bArr).d();
        this.f16760r = d4;
        if (bArr != null) {
            h(d4, bArr);
        }
        return this.f16763u;
    }

    public e(@NonNull GifDecoder.a aVar, c cVar, ByteBuffer byteBuffer, int i4) {
        this(aVar);
        m(cVar, byteBuffer, i4);
    }

    public e(@NonNull GifDecoder.a aVar) {
        this.f16749g = new int[256];
        this.f16768z = Bitmap.Config.ARGB_8888;
        this.f16750h = aVar;
        this.f16760r = new c();
    }
}
