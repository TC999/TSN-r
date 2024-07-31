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
import kotlin.UByte;

/* renamed from: com.bumptech.glide.gifdecoder.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class StandardGifDecoder implements GifDecoder {

    /* renamed from: A */
    private static final String f13404A = "e";

    /* renamed from: B */
    private static final int f13405B = 4096;

    /* renamed from: C */
    private static final int f13406C = -1;

    /* renamed from: D */
    private static final int f13407D = -1;

    /* renamed from: E */
    private static final int f13408E = 4;

    /* renamed from: F */
    private static final int f13409F = 255;
    @ColorInt

    /* renamed from: G */
    private static final int f13410G = 0;
    @ColorInt

    /* renamed from: f */
    private int[] f13411f;
    @ColorInt

    /* renamed from: g */
    private final int[] f13412g;

    /* renamed from: h */
    private final GifDecoder.InterfaceC3554a f13413h;

    /* renamed from: i */
    private ByteBuffer f13414i;

    /* renamed from: j */
    private byte[] f13415j;

    /* renamed from: k */
    private GifHeaderParser f13416k;

    /* renamed from: l */
    private short[] f13417l;

    /* renamed from: m */
    private byte[] f13418m;

    /* renamed from: n */
    private byte[] f13419n;

    /* renamed from: o */
    private byte[] f13420o;
    @ColorInt

    /* renamed from: p */
    private int[] f13421p;

    /* renamed from: q */
    private int f13422q;

    /* renamed from: r */
    private GifHeader f13423r;

    /* renamed from: s */
    private Bitmap f13424s;

    /* renamed from: t */
    private boolean f13425t;

    /* renamed from: u */
    private int f13426u;

    /* renamed from: v */
    private int f13427v;

    /* renamed from: w */
    private int f13428w;

    /* renamed from: x */
    private int f13429x;
    @Nullable

    /* renamed from: y */
    private Boolean f13430y;
    @NonNull

    /* renamed from: z */
    private Bitmap.Config f13431z;

    public StandardGifDecoder(@NonNull GifDecoder.InterfaceC3554a interfaceC3554a, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(interfaceC3554a, gifHeader, byteBuffer, 1);
    }

    @ColorInt
    /* renamed from: q */
    private int m45580q(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.f13427v + i; i9++) {
            byte[] bArr = this.f13420o;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f13411f[bArr[i9] & UByte.f41242c];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.f13427v + i11; i12++) {
            byte[] bArr2 = this.f13420o;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f13411f[bArr2[i12] & UByte.f41242c];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    /* renamed from: r */
    private void m45579r(GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.f13421p;
        int i6 = gifFrame.f13357d;
        int i7 = this.f13427v;
        int i8 = i6 / i7;
        int i9 = gifFrame.f13355b / i7;
        int i10 = gifFrame.f13356c / i7;
        int i11 = gifFrame.f13354a / i7;
        boolean z = this.f13422q == 0;
        int i12 = this.f13429x;
        int i13 = this.f13428w;
        byte[] bArr = this.f13420o;
        int[] iArr2 = this.f13411f;
        Boolean bool = this.f13430y;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i15 < i8) {
            Boolean bool2 = bool;
            if (gifFrame.f13358e) {
                if (i16 >= i8) {
                    i = i8;
                    int i18 = i17 + 1;
                    if (i18 == 2) {
                        i17 = i18;
                        i16 = 4;
                    } else if (i18 == 3) {
                        i17 = i18;
                        i16 = 2;
                        i14 = 4;
                    } else if (i18 != 4) {
                        i17 = i18;
                    } else {
                        i17 = i18;
                        i16 = 1;
                        i14 = 2;
                    }
                } else {
                    i = i8;
                }
                i2 = i16 + i14;
            } else {
                i = i8;
                i2 = i16;
                i16 = i15;
            }
            int i19 = i16 + i9;
            boolean z2 = i7 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i2;
                int i24 = i15 * i7 * gifFrame.f13356c;
                if (z2) {
                    int i25 = i21;
                    while (i25 < i22) {
                        int i26 = i9;
                        int i27 = iArr2[bArr[i24] & UByte.f41242c];
                        if (i27 != 0) {
                            iArr[i25] = i27;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i24 += i7;
                        i25++;
                        i9 = i26;
                    }
                } else {
                    i5 = i9;
                    int i28 = ((i22 - i21) * i7) + i24;
                    int i29 = i21;
                    while (true) {
                        i4 = i10;
                        if (i29 < i22) {
                            int m45580q = m45580q(i24, i28, gifFrame.f13356c);
                            if (m45580q != 0) {
                                iArr[i29] = m45580q;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i24 += i7;
                            i29++;
                            i10 = i4;
                        }
                    }
                    bool = bool2;
                    i15++;
                    i9 = i5;
                    i10 = i4;
                    i8 = i;
                    i16 = i3;
                }
            } else {
                i3 = i2;
            }
            i5 = i9;
            i4 = i10;
            bool = bool2;
            i15++;
            i9 = i5;
            i10 = i4;
            i8 = i;
            i16 = i3;
        }
        Boolean bool3 = bool;
        if (this.f13430y == null) {
            this.f13430y = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    /* renamed from: s */
    private void m45578s(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.f13421p;
        int i = gifFrame2.f13357d;
        int i2 = gifFrame2.f13355b;
        int i3 = gifFrame2.f13356c;
        int i4 = gifFrame2.f13354a;
        boolean z = this.f13422q == 0;
        int i5 = this.f13429x;
        byte[] bArr = this.f13420o;
        int[] iArr2 = this.f13411f;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = gifFrame2.f13356c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                int i14 = b2 & UByte.f41242c;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            gifFrame2 = gifFrame;
        }
        this.f13430y = Boolean.valueOf(this.f13430y == null && z && b != -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: t */
    private void m45577t(GifFrame gifFrame) {
        int i;
        int i2;
        short s;
        StandardGifDecoder standardGifDecoder = this;
        if (gifFrame != null) {
            standardGifDecoder.f13414i.position(gifFrame.f13363j);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = standardGifDecoder.f13423r;
            i = gifHeader.f13372f;
            i2 = gifHeader.f13373g;
        } else {
            i = gifFrame.f13356c;
            i2 = gifFrame.f13357d;
        }
        int i3 = i * i2;
        byte[] bArr = standardGifDecoder.f13420o;
        if (bArr == null || bArr.length < i3) {
            standardGifDecoder.f13420o = standardGifDecoder.f13413h.mo44832b(i3);
        }
        byte[] bArr2 = standardGifDecoder.f13420o;
        if (standardGifDecoder.f13417l == null) {
            standardGifDecoder.f13417l = new short[4096];
        }
        short[] sArr = standardGifDecoder.f13417l;
        if (standardGifDecoder.f13418m == null) {
            standardGifDecoder.f13418m = new byte[4096];
        }
        byte[] bArr3 = standardGifDecoder.f13418m;
        if (standardGifDecoder.f13419n == null) {
            standardGifDecoder.f13419n = new byte[4097];
        }
        byte[] bArr4 = standardGifDecoder.f13419n;
        int m45573x = m45573x();
        int i4 = 1 << m45573x;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = m45573x + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = standardGifDecoder.f13415j;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i9 >= i3) {
                break;
            }
            if (i14 == 0) {
                i14 = m45574w();
                if (i14 <= 0) {
                    standardGifDecoder.f13426u = 3;
                    break;
                }
                i15 = 0;
            }
            i17 += (bArr5[i15] & UByte.f41242c) << i16;
            i15++;
            i14--;
            int i22 = i16 + 8;
            int i23 = i12;
            int i24 = i11;
            int i25 = i19;
            int i26 = i7;
            int i27 = i20;
            while (true) {
                if (i22 < i24) {
                    i19 = i25;
                    i12 = i23;
                    i16 = i22;
                    standardGifDecoder = this;
                    i20 = i27;
                    i7 = i26;
                    i11 = i24;
                    break;
                }
                int i28 = i6;
                int i29 = i17 & i13;
                i17 >>= i24;
                i22 -= i24;
                if (i29 == i4) {
                    i13 = i8;
                    i24 = i26;
                    i23 = i28;
                    i6 = i23;
                    i25 = -1;
                } else if (i29 == i5) {
                    i16 = i22;
                    i20 = i27;
                    i12 = i23;
                    i7 = i26;
                    i6 = i28;
                    i19 = i25;
                    i11 = i24;
                    standardGifDecoder = this;
                    break;
                } else if (i25 == -1) {
                    bArr2[i18] = bArr3[i29];
                    i18++;
                    i9++;
                    i25 = i29;
                    i27 = i25;
                    i6 = i28;
                    i22 = i22;
                } else {
                    if (i29 >= i23) {
                        bArr4[i21] = (byte) i27;
                        i21++;
                        s = i25;
                    } else {
                        s = i29;
                    }
                    while (s >= i4) {
                        bArr4[i21] = bArr3[s];
                        i21++;
                        s = sArr[s];
                    }
                    i27 = bArr3[s] & UByte.f41242c;
                    byte b = (byte) i27;
                    bArr2[i18] = b;
                    while (true) {
                        i18++;
                        i9++;
                        if (i21 <= 0) {
                            break;
                        }
                        i21--;
                        bArr2[i18] = bArr4[i21];
                    }
                    byte[] bArr6 = bArr4;
                    if (i23 < 4096) {
                        sArr[i23] = (short) i25;
                        bArr3[i23] = b;
                        i23++;
                        if ((i23 & i13) == 0 && i23 < 4096) {
                            i24++;
                            i13 += i23;
                        }
                    }
                    i25 = i29;
                    i6 = i28;
                    i22 = i22;
                    bArr4 = bArr6;
                }
            }
        }
        Arrays.fill(bArr2, i18, i3, (byte) 0);
    }

    @NonNull
    /* renamed from: u */
    private GifHeaderParser m45576u() {
        if (this.f13416k == null) {
            this.f13416k = new GifHeaderParser();
        }
        return this.f13416k;
    }

    /* renamed from: v */
    private Bitmap m45575v() {
        Boolean bool = this.f13430y;
        Bitmap mo44831c = this.f13413h.mo44831c(this.f13429x, this.f13428w, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f13431z);
        mo44831c.setHasAlpha(true);
        return mo44831c;
    }

    /* renamed from: w */
    private int m45574w() {
        int m45573x = m45573x();
        if (m45573x <= 0) {
            return m45573x;
        }
        ByteBuffer byteBuffer = this.f13414i;
        byteBuffer.get(this.f13415j, 0, Math.min(m45573x, byteBuffer.remaining()));
        return m45573x;
    }

    /* renamed from: x */
    private int m45573x() {
        return this.f13414i.get() & UByte.f41242c;
    }

    /* renamed from: y */
    private Bitmap m45572y(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.f13421p;
        int i3 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.f13424s;
            if (bitmap2 != null) {
                this.f13413h.mo44833a(bitmap2);
            }
            this.f13424s = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.f13360g == 3 && this.f13424s == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i2 = gifFrame2.f13360g) > 0) {
            if (i2 == 2) {
                if (!gifFrame.f13359f) {
                    GifHeader gifHeader = this.f13423r;
                    int i4 = gifHeader.f13378l;
                    if (gifFrame.f13364k == null || gifHeader.f13376j != gifFrame.f13361h) {
                        i3 = i4;
                    }
                } else if (this.f13422q == 0) {
                    this.f13430y = Boolean.TRUE;
                }
                int i5 = gifFrame2.f13357d;
                int i6 = this.f13427v;
                int i7 = i5 / i6;
                int i8 = gifFrame2.f13355b / i6;
                int i9 = gifFrame2.f13356c / i6;
                int i10 = gifFrame2.f13354a / i6;
                int i11 = this.f13429x;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.f13429x;
                }
            } else if (i2 == 3 && (bitmap = this.f13424s) != null) {
                int i16 = this.f13429x;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.f13428w);
            }
        }
        m45577t(gifFrame);
        if (!gifFrame.f13358e && this.f13427v == 1) {
            m45578s(gifFrame);
        } else {
            m45579r(gifFrame);
        }
        if (this.f13425t && ((i = gifFrame.f13360g) == 0 || i == 1)) {
            if (this.f13424s == null) {
                this.f13424s = m45575v();
            }
            Bitmap bitmap3 = this.f13424s;
            int i17 = this.f13429x;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.f13428w);
        }
        Bitmap m45575v = m45575v();
        int i18 = this.f13429x;
        m45575v.setPixels(iArr, 0, i18, 0, 0, i18, this.f13428w);
        return m45575v;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    /* renamed from: a */
    public synchronized Bitmap mo45596a() {
        if (this.f13423r.f13369c <= 0 || this.f13422q < 0) {
            String str = f13404A;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.f13423r.f13369c + ", framePointer=" + this.f13422q);
            }
            this.f13426u = 1;
        }
        int i = this.f13426u;
        if (i != 1 && i != 2) {
            this.f13426u = 0;
            if (this.f13415j == null) {
                this.f13415j = this.f13413h.mo44832b(255);
            }
            GifFrame gifFrame = this.f13423r.f13371e.get(this.f13422q);
            int i2 = this.f13422q - 1;
            GifFrame gifFrame2 = i2 >= 0 ? this.f13423r.f13371e.get(i2) : null;
            int[] iArr = gifFrame.f13364k;
            if (iArr == null) {
                iArr = this.f13423r.f13367a;
            }
            this.f13411f = iArr;
            if (iArr == null) {
                String str2 = f13404A;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.f13422q);
                }
                this.f13426u = 1;
                return null;
            }
            if (gifFrame.f13359f) {
                System.arraycopy(iArr, 0, this.f13412g, 0, iArr.length);
                int[] iArr2 = this.f13412g;
                this.f13411f = iArr2;
                iArr2[gifFrame.f13361h] = 0;
            }
            return m45572y(gifFrame, gifFrame2);
        }
        String str3 = f13404A;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.f13426u);
        }
        return null;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: b */
    public void mo45595b() {
        this.f13422q = (this.f13422q + 1) % this.f13423r.f13369c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: c */
    public int mo45594c() {
        return this.f13423r.f13369c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.f13423r = null;
        byte[] bArr = this.f13420o;
        if (bArr != null) {
            this.f13413h.mo44829e(bArr);
        }
        int[] iArr = this.f13421p;
        if (iArr != null) {
            this.f13413h.mo44828f(iArr);
        }
        Bitmap bitmap = this.f13424s;
        if (bitmap != null) {
            this.f13413h.mo44833a(bitmap);
        }
        this.f13424s = null;
        this.f13414i = null;
        this.f13430y = null;
        byte[] bArr2 = this.f13415j;
        if (bArr2 != null) {
            this.f13413h.mo44829e(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: d */
    public void mo45593d(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.f13431z = config;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: e */
    public int mo45592e(int i) {
        if (i >= 0) {
            GifHeader gifHeader = this.f13423r;
            if (i < gifHeader.f13369c) {
                return gifHeader.f13371e.get(i).f13362i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: f */
    public int mo45591f() {
        int i = this.f13423r.f13379m;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    /* renamed from: g */
    public int mo45590g() {
        int i = this.f13423r.f13379m;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.f13414i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.f13423r.f13373g;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.f13426u;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.f13423r.f13372f;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: h */
    public synchronized void mo45589h(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        mo45586k(gifHeader, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: i */
    public int mo45588i() {
        int i;
        if (this.f13423r.f13369c <= 0 || (i = this.f13422q) < 0) {
            return 0;
        }
        return mo45592e(i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: j */
    public void mo45587j() {
        this.f13422q = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: k */
    public synchronized void mo45586k(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        mo45584m(gifHeader, byteBuffer, 1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: l */
    public int mo45585l() {
        return this.f13422q;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: m */
    public synchronized void mo45584m(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            this.f13426u = 0;
            this.f13423r = gifHeader;
            this.f13422q = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f13414i = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f13414i.order(ByteOrder.LITTLE_ENDIAN);
            this.f13425t = false;
            Iterator<GifFrame> it = gifHeader.f13371e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f13360g == 3) {
                    this.f13425t = true;
                    break;
                }
            }
            this.f13427v = highestOneBit;
            int i2 = gifHeader.f13372f;
            this.f13429x = i2 / highestOneBit;
            int i3 = gifHeader.f13373g;
            this.f13428w = i3 / highestOneBit;
            this.f13420o = this.f13413h.mo44832b(i2 * i3);
            this.f13421p = this.f13413h.mo44830d(this.f13429x * this.f13428w);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: n */
    public int mo45583n() {
        return this.f13423r.f13379m;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: o */
    public int mo45582o(@Nullable InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
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
            } catch (IOException e) {
                Log.w(f13404A, "Error reading data from stream", e);
            }
        } else {
            this.f13426u = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(f13404A, "Error closing stream", e2);
            }
        }
        return this.f13426u;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: p */
    public int mo45581p() {
        return this.f13414i.limit() + this.f13420o.length + (this.f13421p.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        GifHeader m45613d = m45576u().m45599r(bArr).m45613d();
        this.f13423r = m45613d;
        if (bArr != null) {
            mo45589h(m45613d, bArr);
        }
        return this.f13426u;
    }

    public StandardGifDecoder(@NonNull GifDecoder.InterfaceC3554a interfaceC3554a, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(interfaceC3554a);
        mo45584m(gifHeader, byteBuffer, i);
    }

    public StandardGifDecoder(@NonNull GifDecoder.InterfaceC3554a interfaceC3554a) {
        this.f13412g = new int[256];
        this.f13431z = Bitmap.Config.ARGB_8888;
        this.f13413h = interfaceC3554a;
        this.f13423r = new GifHeader();
    }
}
