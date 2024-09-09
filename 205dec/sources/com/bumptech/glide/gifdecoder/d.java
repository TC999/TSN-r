package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GifHeaderParser.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    private static final String f16724e = "GifHeaderParser";

    /* renamed from: f  reason: collision with root package name */
    private static final int f16725f = 255;

    /* renamed from: g  reason: collision with root package name */
    private static final int f16726g = 44;

    /* renamed from: h  reason: collision with root package name */
    private static final int f16727h = 33;

    /* renamed from: i  reason: collision with root package name */
    private static final int f16728i = 59;

    /* renamed from: j  reason: collision with root package name */
    private static final int f16729j = 249;

    /* renamed from: k  reason: collision with root package name */
    private static final int f16730k = 255;

    /* renamed from: l  reason: collision with root package name */
    private static final int f16731l = 254;

    /* renamed from: m  reason: collision with root package name */
    private static final int f16732m = 1;

    /* renamed from: n  reason: collision with root package name */
    private static final int f16733n = 28;

    /* renamed from: o  reason: collision with root package name */
    private static final int f16734o = 2;

    /* renamed from: p  reason: collision with root package name */
    private static final int f16735p = 1;

    /* renamed from: q  reason: collision with root package name */
    private static final int f16736q = 128;

    /* renamed from: r  reason: collision with root package name */
    private static final int f16737r = 64;

    /* renamed from: s  reason: collision with root package name */
    private static final int f16738s = 7;

    /* renamed from: t  reason: collision with root package name */
    private static final int f16739t = 128;

    /* renamed from: u  reason: collision with root package name */
    private static final int f16740u = 7;

    /* renamed from: v  reason: collision with root package name */
    static final int f16741v = 2;

    /* renamed from: w  reason: collision with root package name */
    static final int f16742w = 10;

    /* renamed from: x  reason: collision with root package name */
    private static final int f16743x = 256;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f16745b;

    /* renamed from: c  reason: collision with root package name */
    private c f16746c;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f16744a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    private int f16747d = 0;

    private boolean b() {
        return this.f16746c.f16712b != 0;
    }

    private int e() {
        try {
            return this.f16745b.get() & 255;
        } catch (Exception unused) {
            this.f16746c.f16712b = 1;
            return 0;
        }
    }

    private void f() {
        this.f16746c.f16714d.f16698a = o();
        this.f16746c.f16714d.f16699b = o();
        this.f16746c.f16714d.f16700c = o();
        this.f16746c.f16714d.f16701d = o();
        int e4 = e();
        boolean z3 = (e4 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (e4 & 7) + 1);
        b bVar = this.f16746c.f16714d;
        bVar.f16702e = (e4 & 64) != 0;
        if (z3) {
            bVar.f16708k = h(pow);
        } else {
            bVar.f16708k = null;
        }
        this.f16746c.f16714d.f16707j = this.f16745b.position();
        t();
        if (b()) {
            return;
        }
        c cVar = this.f16746c;
        cVar.f16713c++;
        cVar.f16715e.add(cVar.f16714d);
    }

    private void g() {
        int e4 = e();
        this.f16747d = e4;
        if (e4 <= 0) {
            return;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            try {
                i5 = this.f16747d;
                if (i4 >= i5) {
                    return;
                }
                i5 -= i4;
                this.f16745b.get(this.f16744a, i4, i5);
                i4 += i5;
            } catch (Exception e5) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i4 + " count: " + i5 + " blockSize: " + this.f16747d, e5);
                }
                this.f16746c.f16712b = 1;
                return;
            }
        }
    }

    @Nullable
    private int[] h(int i4) {
        byte[] bArr = new byte[i4 * 3];
        int[] iArr = null;
        try {
            this.f16745b.get(bArr);
            iArr = new int[256];
            int i5 = 0;
            int i6 = 0;
            while (i5 < i4) {
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int i9 = i8 + 1;
                int i10 = i5 + 1;
                iArr[i5] = ((bArr[i6] & 255) << 16) | (-16777216) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
                i6 = i9;
                i5 = i10;
            }
        } catch (BufferUnderflowException e4) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e4);
            }
            this.f16746c.f16712b = 1;
        }
        return iArr;
    }

    private void i() {
        j(Integer.MAX_VALUE);
    }

    private void j(int i4) {
        boolean z3 = false;
        while (!z3 && !b() && this.f16746c.f16713c <= i4) {
            int e4 = e();
            if (e4 == 33) {
                int e5 = e();
                if (e5 == 1) {
                    s();
                } else if (e5 == 249) {
                    this.f16746c.f16714d = new b();
                    k();
                } else if (e5 == 254) {
                    s();
                } else if (e5 != 255) {
                    s();
                } else {
                    g();
                    StringBuilder sb = new StringBuilder();
                    for (int i5 = 0; i5 < 11; i5++) {
                        sb.append((char) this.f16744a[i5]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        n();
                    } else {
                        s();
                    }
                }
            } else if (e4 == 44) {
                c cVar = this.f16746c;
                if (cVar.f16714d == null) {
                    cVar.f16714d = new b();
                }
                f();
            } else if (e4 != 59) {
                this.f16746c.f16712b = 1;
            } else {
                z3 = true;
            }
        }
    }

    private void k() {
        e();
        int e4 = e();
        b bVar = this.f16746c.f16714d;
        int i4 = (e4 & 28) >> 2;
        bVar.f16704g = i4;
        if (i4 == 0) {
            bVar.f16704g = 1;
        }
        bVar.f16703f = (e4 & 1) != 0;
        int o4 = o();
        if (o4 < 2) {
            o4 = 10;
        }
        b bVar2 = this.f16746c.f16714d;
        bVar2.f16706i = o4 * 10;
        bVar2.f16705h = e();
        e();
    }

    private void l() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 6; i4++) {
            sb.append((char) e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f16746c.f16712b = 1;
            return;
        }
        m();
        if (!this.f16746c.f16718h || b()) {
            return;
        }
        c cVar = this.f16746c;
        cVar.f16711a = h(cVar.f16719i);
        c cVar2 = this.f16746c;
        cVar2.f16722l = cVar2.f16711a[cVar2.f16720j];
    }

    private void m() {
        this.f16746c.f16716f = o();
        this.f16746c.f16717g = o();
        int e4 = e();
        c cVar = this.f16746c;
        cVar.f16718h = (e4 & 128) != 0;
        cVar.f16719i = (int) Math.pow(2.0d, (e4 & 7) + 1);
        this.f16746c.f16720j = e();
        this.f16746c.f16721k = e();
    }

    private void n() {
        do {
            g();
            byte[] bArr = this.f16744a;
            if (bArr[0] == 1) {
                this.f16746c.f16723m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f16747d <= 0) {
                return;
            }
        } while (!b());
    }

    private int o() {
        return this.f16745b.getShort();
    }

    private void p() {
        this.f16745b = null;
        Arrays.fill(this.f16744a, (byte) 0);
        this.f16746c = new c();
        this.f16747d = 0;
    }

    private void s() {
        int e4;
        do {
            e4 = e();
            this.f16745b.position(Math.min(this.f16745b.position() + e4, this.f16745b.limit()));
        } while (e4 > 0);
    }

    private void t() {
        e();
        s();
    }

    public void a() {
        this.f16745b = null;
        this.f16746c = null;
    }

    public boolean c() {
        l();
        if (!b()) {
            j(2);
        }
        return this.f16746c.f16713c > 1;
    }

    @NonNull
    public c d() {
        if (this.f16745b != null) {
            if (b()) {
                return this.f16746c;
            }
            l();
            if (!b()) {
                i();
                c cVar = this.f16746c;
                if (cVar.f16713c < 0) {
                    cVar.f16712b = 1;
                }
            }
            return this.f16746c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public d q(@NonNull ByteBuffer byteBuffer) {
        p();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f16745b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f16745b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public d r(@Nullable byte[] bArr) {
        if (bArr != null) {
            q(ByteBuffer.wrap(bArr));
        } else {
            this.f16745b = null;
            this.f16746c.f16712b = 2;
        }
        return this;
    }
}
