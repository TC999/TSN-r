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
import p616l0.PagePart;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.github.barteksc.pdfviewer.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RenderingHandler extends Handler {

    /* renamed from: f */
    static final int f23702f = 1;

    /* renamed from: g */
    private static final String f23703g = RenderingHandler.class.getName();

    /* renamed from: a */
    private PDFView f23704a;

    /* renamed from: b */
    private RectF f23705b;

    /* renamed from: c */
    private Rect f23706c;

    /* renamed from: d */
    private Matrix f23707d;

    /* renamed from: e */
    private boolean f23708e;

    /* compiled from: RenderingHandler.java */
    /* renamed from: com.github.barteksc.pdfviewer.h$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6659a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ PagePart f23709a;

        RunnableC6659a(PagePart pagePart) {
            this.f23709a = pagePart;
        }

        @Override // java.lang.Runnable
        public void run() {
            RenderingHandler.this.f23704a.m35469d0(this.f23709a);
        }
    }

    /* compiled from: RenderingHandler.java */
    /* renamed from: com.github.barteksc.pdfviewer.h$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6660b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ PageRenderingException f23711a;

        RunnableC6660b(PageRenderingException pageRenderingException) {
            this.f23711a = pageRenderingException;
        }

        @Override // java.lang.Runnable
        public void run() {
            RenderingHandler.this.f23704a.m35467e0(this.f23711a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RenderingHandler.java */
    /* renamed from: com.github.barteksc.pdfviewer.h$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6661c {

        /* renamed from: a */
        float f23713a;

        /* renamed from: b */
        float f23714b;

        /* renamed from: c */
        RectF f23715c;

        /* renamed from: d */
        int f23716d;

        /* renamed from: e */
        boolean f23717e;

        /* renamed from: f */
        int f23718f;

        /* renamed from: g */
        boolean f23719g;

        /* renamed from: h */
        boolean f23720h;

        C6661c(float f, float f2, RectF rectF, int i, boolean z, int i2, boolean z2, boolean z3) {
            this.f23716d = i;
            this.f23713a = f;
            this.f23714b = f2;
            this.f23715c = rectF;
            this.f23717e = z;
            this.f23718f = i2;
            this.f23719g = z2;
            this.f23720h = z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderingHandler(Looper looper, PDFView pDFView) {
        super(looper);
        this.f23705b = new RectF();
        this.f23706c = new Rect();
        this.f23707d = new Matrix();
        this.f23708e = false;
        this.f23704a = pDFView;
    }

    /* renamed from: c */
    private void m35324c(int i, int i2, RectF rectF) {
        this.f23707d.reset();
        float f = i;
        float f2 = i2;
        this.f23707d.postTranslate((-rectF.left) * f, (-rectF.top) * f2);
        this.f23707d.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        this.f23705b.set(0.0f, 0.0f, f, f2);
        this.f23707d.mapRect(this.f23705b);
        this.f23705b.round(this.f23706c);
    }

    /* renamed from: d */
    private PagePart m35323d(C6661c c6661c) throws PageRenderingException {
        PdfFile pdfFile = this.f23704a.f23568h;
        pdfFile.m35333t(c6661c.f23716d);
        int round = Math.round(c6661c.f23713a);
        int round2 = Math.round(c6661c.f23714b);
        if (round != 0 && round2 != 0 && !pdfFile.m35332u(c6661c.f23716d)) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(round, round2, c6661c.f23719g ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                m35324c(round, round2, c6661c.f23715c);
                pdfFile.m35327z(createBitmap, c6661c.f23716d, this.f23706c, c6661c.f23720h);
                return new PagePart(c6661c.f23716d, createBitmap, c6661c.f23715c, c6661c.f23717e, c6661c.f23718f);
            } catch (IllegalArgumentException e) {
                Log.e(f23703g, "Cannot create bitmap", e);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m35325b(int i, float f, float f2, RectF rectF, boolean z, int i2, boolean z2, boolean z3) {
        sendMessage(obtainMessage(1, new C6661c(f, f2, rectF, i, z, i2, z2, z3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m35322e() {
        this.f23708e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public void m35321f() {
        this.f23708e = false;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            PagePart m35323d = m35323d((C6661c) message.obj);
            if (m35323d != null) {
                if (this.f23708e) {
                    this.f23704a.post(new RunnableC6659a(m35323d));
                } else {
                    m35323d.m3466d().recycle();
                }
            }
        } catch (PageRenderingException e) {
            this.f23704a.post(new RunnableC6660b(e));
        }
    }
}
