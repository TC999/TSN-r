package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.bytedance.sdk.component.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class FlowLightView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Xfermode f29541a;
    private PorterDuff.Mode bk;

    /* renamed from: c  reason: collision with root package name */
    Rect f29542c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f29543f;
    private int[] gd;

    /* renamed from: k  reason: collision with root package name */
    private Paint f29544k;

    /* renamed from: p  reason: collision with root package name */
    private Bitmap f29545p;

    /* renamed from: r  reason: collision with root package name */
    private int f29546r;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private LinearGradient f29547t;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    Rect f29548w;
    private int xv;
    private final List<c> ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private final int f29549c;

        /* renamed from: w  reason: collision with root package name */
        private int f29550w = 0;

        public c(int i4) {
            this.f29549c = i4;
        }

        public void c() {
            this.f29550w += this.f29549c;
        }
    }

    public FlowLightView(Context context) {
        super(context);
        this.bk = PorterDuff.Mode.DST_IN;
        this.ys = new ArrayList();
        c();
    }

    private void c() {
        this.xv = i.sr(getContext(), "tt_splash_unlock_image_arrow");
        this.sr = Color.parseColor("#00ffffff");
        this.ux = Color.parseColor("#ffffffff");
        int parseColor = Color.parseColor("#00ffffff");
        this.f29543f = parseColor;
        this.f29546r = 10;
        this.ev = 40;
        this.gd = new int[]{this.sr, this.ux, parseColor};
        setLayerType(1, null);
        this.f29544k = new Paint(1);
        this.f29545p = BitmapFactory.decodeResource(getResources(), this.xv);
        this.f29541a = new PorterDuffXfermode(this.bk);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f29545p, this.f29542c, this.f29548w, this.f29544k);
        canvas.save();
        Iterator<c> it = this.ys.iterator();
        while (it.hasNext()) {
            c next = it.next();
            this.f29547t = new LinearGradient(next.f29550w, 0.0f, next.f29550w + this.ev, this.f29546r, this.gd, (float[]) null, Shader.TileMode.CLAMP);
            this.f29544k.setColor(-1);
            this.f29544k.setShader(this.f29547t);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f29544k);
            this.f29544k.setShader(null);
            next.c();
            if (next.f29550w > getWidth()) {
                it.remove();
            }
        }
        this.f29544k.setXfermode(this.f29541a);
        canvas.drawBitmap(this.f29545p, this.f29542c, this.f29548w, this.f29544k);
        this.f29544k.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (this.f29545p == null) {
            return;
        }
        this.f29542c = new Rect(0, 0, this.f29545p.getWidth(), this.f29545p.getHeight());
        this.f29548w = new Rect(0, 0, getWidth(), getHeight());
    }

    public void c(int i4) {
        this.ys.add(new c(i4));
        postInvalidate();
    }
}
