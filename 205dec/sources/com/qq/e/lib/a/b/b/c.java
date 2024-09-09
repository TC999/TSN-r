package com.qq.e.lib.a.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.qq.e.comm.plugin.n0.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends com.qq.e.lib.a.c.a<com.qq.e.lib.a.b.c.a, com.qq.e.lib.a.b.c.b> {

    /* renamed from: i  reason: collision with root package name */
    public final byte f47279i;

    /* renamed from: j  reason: collision with root package name */
    public final byte f47280j;

    /* renamed from: k  reason: collision with root package name */
    byte[] f47281k;

    /* renamed from: l  reason: collision with root package name */
    List<e> f47282l;

    /* renamed from: m  reason: collision with root package name */
    List<e> f47283m;

    /* renamed from: q  reason: collision with root package name */
    static final /* synthetic */ boolean f47278q = !c.class.desiredAssertionStatus();

    /* renamed from: n  reason: collision with root package name */
    private static final byte[] f47275n = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: o  reason: collision with root package name */
    private static final byte[] f47276o = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

    /* renamed from: p  reason: collision with root package name */
    private static final ThreadLocal<CRC32> f47277p = new ThreadLocal<>();

    public c(com.qq.e.lib.a.b.c.a aVar, f fVar) {
        super(aVar);
        this.f47282l = new ArrayList();
        this.f47283m = new ArrayList();
        this.f47279i = fVar.f47294j;
        this.f47280j = fVar.f47293i;
        int i4 = fVar.f47291g * 1000;
        short s3 = fVar.f47292h;
        int i5 = i4 / (s3 == 0 ? (short) 100 : s3);
        this.f47309f = i5;
        if (i5 < 10) {
            this.f47309f = 100;
        }
        this.f47305b = fVar.f47287c;
        this.f47306c = fVar.f47288d;
        this.f47307d = fVar.f47289e;
        this.f47308e = fVar.f47290f;
    }

    private com.qq.e.comm.plugin.n0.d b() {
        R r3 = this.f47304a;
        if (r3 == 0) {
            return null;
        }
        com.qq.e.lib.a.b.c.a aVar = (com.qq.e.lib.a.b.c.a) r3;
        com.qq.e.lib.a.e.b bVar = aVar.f47359c instanceof com.qq.e.lib.a.e.b ? (com.qq.e.lib.a.e.b) aVar.f47359c : null;
        if (bVar == null) {
            return null;
        }
        String str = bVar.f47358e;
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("url", str);
        return dVar;
    }

    private CRC32 a() {
        CRC32 crc32 = f47277p.get();
        if (crc32 == null) {
            CRC32 crc322 = new CRC32();
            f47277p.set(crc322);
            return crc322;
        }
        return crc32;
    }

    private int a(com.qq.e.lib.a.b.c.b bVar) throws IOException {
        int i4;
        int i5 = 33;
        for (e eVar : this.f47283m) {
            i5 += eVar.f47284a + 12;
        }
        for (e eVar2 : this.f47282l) {
            if (eVar2 instanceof h) {
                i4 = eVar2.f47284a + 12;
            } else if (eVar2 instanceof g) {
                i4 = eVar2.f47284a + 8;
            }
            i5 += i4;
        }
        int length = i5 + f47276o.length;
        a(length);
        bVar.a(length);
        bVar.a(f47275n);
        bVar.d(13);
        int a4 = bVar.a();
        bVar.c(j.f47298f);
        bVar.d(this.f47305b);
        bVar.d(this.f47306c);
        bVar.a(this.f47281k);
        CRC32 a5 = a();
        a5.reset();
        a5.update(bVar.b(), a4, 17);
        bVar.d((int) a5.getValue());
        for (e eVar3 : this.f47283m) {
            if (!(eVar3 instanceof i)) {
                ((com.qq.e.lib.a.b.c.a) this.f47304a).reset();
                ((com.qq.e.lib.a.b.c.a) this.f47304a).skip(eVar3.f47285b);
                ((com.qq.e.lib.a.b.c.a) this.f47304a).read(bVar.b(), bVar.a(), eVar3.f47284a + 12);
                bVar.b(eVar3.f47284a + 12);
            }
        }
        for (e eVar4 : this.f47282l) {
            if (eVar4 instanceof h) {
                ((com.qq.e.lib.a.b.c.a) this.f47304a).reset();
                ((com.qq.e.lib.a.b.c.a) this.f47304a).skip(eVar4.f47285b);
                ((com.qq.e.lib.a.b.c.a) this.f47304a).read(bVar.b(), bVar.a(), eVar4.f47284a + 12);
                bVar.b(eVar4.f47284a + 12);
            } else if (eVar4 instanceof g) {
                bVar.d(eVar4.f47284a - 4);
                int a6 = bVar.a();
                bVar.c(h.f47296c);
                ((com.qq.e.lib.a.b.c.a) this.f47304a).reset();
                ((com.qq.e.lib.a.b.c.a) this.f47304a).skip(eVar4.f47285b + 4 + 4 + 4);
                ((com.qq.e.lib.a.b.c.a) this.f47304a).read(bVar.b(), bVar.a(), eVar4.f47284a - 4);
                bVar.b(eVar4.f47284a - 4);
                a5.reset();
                a5.update(bVar.b(), a6, eVar4.f47284a);
                bVar.d((int) a5.getValue());
            }
        }
        bVar.a(f47276o);
        return length;
    }

    private void a(int i4) {
        com.qq.e.comm.plugin.n0.d b4;
        if (i4 >= 10485760 && (b4 = b()) != null) {
            b4.a("data", Integer.valueOf(i4));
            v.a(9700001, null, 1, null, b4);
        }
    }

    @Override // com.qq.e.lib.a.c.a
    public Bitmap a(Canvas canvas, Paint paint, int i4, Bitmap bitmap, com.qq.e.lib.a.b.c.b bVar) {
        byte[] bArr;
        Bitmap decodeByteArray;
        try {
            int a4 = a(bVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i4;
            options.inMutable = true;
            options.inBitmap = bitmap;
            try {
                decodeByteArray = BitmapFactory.decodeByteArray(bVar.b(), 0, a4, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i4;
                options2.inMutable = true;
                decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, a4, options2);
            }
            if (!f47278q && decodeByteArray == null) {
                throw new AssertionError();
            }
            this.f47310g.left = 0;
            this.f47310g.top = 0;
            this.f47310g.right = decodeByteArray.getWidth();
            this.f47310g.bottom = decodeByteArray.getHeight();
            float f4 = i4;
            this.f47311h.left = (int) (this.f47307d / f4);
            this.f47311h.top = (int) (this.f47308e / f4);
            this.f47311h.right = (int) ((this.f47307d / f4) + decodeByteArray.getWidth());
            this.f47311h.bottom = (int) ((this.f47308e / f4) + decodeByteArray.getHeight());
            canvas.drawBitmap(decodeByteArray, this.f47310g, this.f47311h, paint);
            return decodeByteArray;
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        } catch (OutOfMemoryError e5) {
            e5.printStackTrace();
            v.a(9700001, null, 2, null, b());
            return null;
        }
    }
}
