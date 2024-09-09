package com.qq.e.lib.a.b.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.qq.e.lib.a.c.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.lib.a.c.b<com.qq.e.lib.a.b.c.a, com.qq.e.lib.a.b.c.b> {

    /* renamed from: w  reason: collision with root package name */
    private com.qq.e.lib.a.b.c.b f47268w;

    /* renamed from: x  reason: collision with root package name */
    private int f47269x;

    /* renamed from: y  reason: collision with root package name */
    private final Paint f47270y;

    /* renamed from: z  reason: collision with root package name */
    private final C0922b f47271z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* renamed from: com.qq.e.lib.a.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class C0922b {

        /* renamed from: a  reason: collision with root package name */
        byte f47272a;

        /* renamed from: b  reason: collision with root package name */
        Rect f47273b;

        /* renamed from: c  reason: collision with root package name */
        ByteBuffer f47274c;

        private C0922b() {
            this.f47273b = new Rect();
        }
    }

    public b(com.qq.e.lib.a.f.b bVar, b.j jVar) {
        super(bVar, jVar);
        this.f47270y = new Paint();
        this.f47271z = new C0922b();
        this.f47270y.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.lib.a.c.b
    /* renamed from: c */
    public com.qq.e.lib.a.b.c.a a(com.qq.e.lib.a.e.d dVar) {
        return new com.qq.e.lib.a.b.c.a(dVar);
    }

    @Override // com.qq.e.lib.a.c.b
    protected int f() {
        return this.f47269x;
    }

    @Override // com.qq.e.lib.a.c.b
    protected void m() {
        this.f47271z.f47274c = null;
        this.f47268w = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.lib.a.c.b
    /* renamed from: s */
    public com.qq.e.lib.a.b.c.b i() {
        if (this.f47268w == null) {
            this.f47268w = new com.qq.e.lib.a.b.c.b();
        }
        return this.f47268w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.lib.a.c.b
    /* renamed from: a */
    public Rect b(com.qq.e.lib.a.b.c.a aVar) throws IOException {
        List<e> a4 = d.a(aVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<e> it = a4.iterator();
        c cVar = null;
        boolean z3 = false;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            e next = it.next();
            if (next instanceof com.qq.e.lib.a.b.b.a) {
                this.f47269x = ((com.qq.e.lib.a.b.b.a) next).f47267c;
                z3 = true;
            } else if (next instanceof f) {
                cVar = new c(aVar, (f) next);
                cVar.f47283m = arrayList;
                cVar.f47281k = bArr;
                this.f47317d.add(cVar);
            } else if (next instanceof g) {
                if (cVar != null) {
                    cVar.f47282l.add(next);
                }
            } else if (next instanceof h) {
                if (!z3) {
                    k kVar = new k(aVar);
                    kVar.f47305b = i5;
                    kVar.f47306c = i4;
                    this.f47317d.add(kVar);
                    this.f47269x = 1;
                    break;
                } else if (cVar != null) {
                    cVar.f47282l.add(next);
                }
            } else if (next instanceof j) {
                j jVar = (j) next;
                i5 = jVar.f47299c;
                i4 = jVar.f47300d;
                bArr = jVar.f47301e;
            } else if (!(next instanceof i)) {
                arrayList.add(next);
            }
        }
        int i6 = i5 * i4;
        int i7 = this.f47324k;
        this.f47328o = ByteBuffer.allocate(((i6 / (i7 * i7)) + 1) * 4);
        C0922b c0922b = this.f47271z;
        int i8 = this.f47324k;
        c0922b.f47274c = ByteBuffer.allocate(((i6 / (i8 * i8)) + 1) * 4);
        return new Rect(0, 0, i5, i4);
    }

    @Override // com.qq.e.lib.a.c.b
    protected void a(com.qq.e.lib.a.c.a<com.qq.e.lib.a.b.c.a, com.qq.e.lib.a.b.c.b> aVar) {
        if (aVar == null || this.f47329p == null) {
            return;
        }
        try {
            Bitmap b4 = b(this.f47329p.width() / this.f47324k, this.f47329p.height() / this.f47324k);
            Canvas canvas = this.f47327n.get(b4);
            if (canvas == null) {
                canvas = new Canvas(b4);
                this.f47327n.put(b4, canvas);
            }
            Canvas canvas2 = canvas;
            if (aVar instanceof c) {
                this.f47328o.rewind();
                b4.copyPixelsFromBuffer(this.f47328o);
                if (this.f47318e == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.f47271z.f47273b);
                    byte b5 = this.f47271z.f47272a;
                    if (b5 == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b5 == 2) {
                        this.f47271z.f47274c.rewind();
                        b4.copyPixelsFromBuffer(this.f47271z.f47274c);
                    }
                    canvas2.restore();
                }
                if (((c) aVar).f47280j == 2 && this.f47271z.f47272a != 2) {
                    this.f47271z.f47274c.rewind();
                    b4.copyPixelsToBuffer(this.f47271z.f47274c);
                }
                this.f47271z.f47272a = ((c) aVar).f47280j;
                canvas2.save();
                if (((c) aVar).f47279i == 0) {
                    canvas2.clipRect(aVar.f47307d / this.f47324k, aVar.f47308e / this.f47324k, (aVar.f47307d + aVar.f47305b) / this.f47324k, (aVar.f47308e + aVar.f47306c) / this.f47324k);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                this.f47271z.f47273b.set(aVar.f47307d / this.f47324k, aVar.f47308e / this.f47324k, (aVar.f47307d + aVar.f47305b) / this.f47324k, (aVar.f47308e + aVar.f47306c) / this.f47324k);
                canvas2.restore();
            }
            Bitmap b6 = b(aVar.f47305b, aVar.f47306c);
            a(aVar.a(canvas2, this.f47270y, this.f47324k, b6, i()));
            a(b6);
            this.f47328o.rewind();
            b4.copyPixelsToBuffer(this.f47328o);
            a(b4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
