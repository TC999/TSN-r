package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: RenderingHandler.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class h extends Handler {

    /* renamed from: f  reason: collision with root package name */
    static final int f37271f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final String f37272g = h.class.getName();

    /* renamed from: a  reason: collision with root package name */
    private PDFView f37273a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f37274b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f37275c;

    /* renamed from: d  reason: collision with root package name */
    private Matrix f37276d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f37277e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: RenderingHandler.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f1.b f37278a;

        a(f1.b bVar) {
            this.f37278a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f37273a.d0(this.f37278a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: RenderingHandler.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PageRenderingException f37280a;

        b(PageRenderingException pageRenderingException) {
            this.f37280a = pageRenderingException;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f37273a.e0(this.f37280a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: RenderingHandler.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        float f37282a;

        /* renamed from: b  reason: collision with root package name */
        float f37283b;

        /* renamed from: c  reason: collision with root package name */
        RectF f37284c;

        /* renamed from: d  reason: collision with root package name */
        int f37285d;

        /* renamed from: e  reason: collision with root package name */
        boolean f37286e;

        /* renamed from: f  reason: collision with root package name */
        int f37287f;

        /* renamed from: g  reason: collision with root package name */
        boolean f37288g;

        /* renamed from: h  reason: collision with root package name */
        boolean f37289h;

        c(float f4, float f5, RectF rectF, int i4, boolean z3, int i5, boolean z4, boolean z5) {
            this.f37285d = i4;
            this.f37282a = f4;
            this.f37283b = f5;
            this.f37284c = rectF;
            this.f37286e = z3;
            this.f37287f = i5;
            this.f37288g = z4;
            this.f37289h = z5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Looper looper, PDFView pDFView) {
        super(looper);
        this.f37274b = new RectF();
        this.f37275c = new Rect();
        this.f37276d = new Matrix();
        this.f37277e = false;
        this.f37273a = pDFView;
    }

    private void c(int i4, int i5, RectF rectF) {
        this.f37276d.reset();
        float f4 = i4;
        float f5 = i5;
        this.f37276d.postTranslate((-rectF.left) * f4, (-rectF.top) * f5);
        this.f37276d.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        this.f37274b.set(0.0f, 0.0f, f4, f5);
        this.f37276d.mapRect(this.f37274b);
        this.f37274b.round(this.f37275c);
    }

    private f1.b d(c cVar) throws PageRenderingException {
        g gVar = this.f37273a.f37140h;
        gVar.t(cVar.f37285d);
        int round = Math.round(cVar.f37282a);
        int round2 = Math.round(cVar.f37283b);
        if (round != 0 && round2 != 0 && !gVar.u(cVar.f37285d)) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(round, round2, cVar.f37288g ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                c(round, round2, cVar.f37284c);
                gVar.z(createBitmap, cVar.f37285d, this.f37275c, cVar.f37289h);
                return new f1.b(cVar.f37285d, createBitmap, cVar.f37284c, cVar.f37286e, cVar.f37287f);
            } catch (IllegalArgumentException e4) {
                Log.e(f37272g, "Cannot create bitmap", e4);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4, float f4, float f5, RectF rectF, boolean z3, int i5, boolean z4, boolean z5) {
        sendMessage(obtainMessage(1, new c(f4, f5, rectF, i4, z3, i5, z4, z5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f37277e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f37277e = false;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            f1.b d4 = d((c) message.obj);
            if (d4 != null) {
                if (this.f37277e) {
                    this.f37273a.post(new a(d4));
                } else {
                    d4.d().recycle();
                }
            }
        } catch (PageRenderingException e4) {
            this.f37273a.post(new b(e4));
        }
    }
}
