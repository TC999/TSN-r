package com.bxkj.student.v2.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TrackProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f23495a;

    /* renamed from: b  reason: collision with root package name */
    private int f23496b;

    /* renamed from: c  reason: collision with root package name */
    private int f23497c;

    /* renamed from: d  reason: collision with root package name */
    private int f23498d;

    /* renamed from: e  reason: collision with root package name */
    private int f23499e;

    /* renamed from: f  reason: collision with root package name */
    private int f23500f;

    /* renamed from: g  reason: collision with root package name */
    private int f23501g;

    /* renamed from: h  reason: collision with root package name */
    private int f23502h;

    /* renamed from: i  reason: collision with root package name */
    private int f23503i;

    /* renamed from: j  reason: collision with root package name */
    private int f23504j;

    /* renamed from: k  reason: collision with root package name */
    private String f23505k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f23506l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23507m;

    /* renamed from: n  reason: collision with root package name */
    private float f23508n;

    /* renamed from: o  reason: collision with root package name */
    private int f23509o;

    /* renamed from: p  reason: collision with root package name */
    private Paint f23510p;

    /* renamed from: q  reason: collision with root package name */
    private Paint f23511q;

    /* renamed from: r  reason: collision with root package name */
    private Paint f23512r;

    /* renamed from: s  reason: collision with root package name */
    private Paint f23513s;

    /* renamed from: t  reason: collision with root package name */
    private List<a> f23514t;

    /* renamed from: u  reason: collision with root package name */
    private Path f23515u;

    /* renamed from: v  reason: collision with root package name */
    private List<a> f23516v;

    /* renamed from: w  reason: collision with root package name */
    private Path f23517w;

    /* renamed from: x  reason: collision with root package name */
    private Path f23518x;

    /* renamed from: y  reason: collision with root package name */
    private int f23519y;

    /* renamed from: z  reason: collision with root package name */
    private int f23520z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private float f23521a;

        /* renamed from: b  reason: collision with root package name */
        private float f23522b;

        public a(float x3, float y3) {
            this.f23521a = x3;
            this.f23522b = y3;
        }

        public float a() {
            return this.f23521a;
        }

        public float b() {
            return this.f23522b;
        }
    }

    public TrackProgressView(Context context) {
        this(context, null);
    }

    private void a() {
        for (int i4 = -180; i4 <= 180; i4++) {
            int i5 = this.f23496b;
            double d4 = this.f23497c + i5;
            double d5 = i5;
            double d6 = i4;
            double cos = Math.cos(Math.toRadians(d6));
            Double.isNaN(d5);
            Double.isNaN(d4);
            float f4 = (float) ((d5 * cos) + d4);
            double d7 = this.f23496b;
            double sin = Math.sin(Math.toRadians(d6));
            Double.isNaN(d7);
            Double.isNaN(d4);
            float f5 = (float) ((d7 * sin) + d4);
            double d8 = this.f23496b + (this.f23497c / 2);
            double cos2 = Math.cos(Math.toRadians(d6));
            Double.isNaN(d8);
            Double.isNaN(d4);
            float f6 = (float) ((d8 * cos2) + d4);
            double d9 = this.f23496b + (this.f23497c / 2);
            double sin2 = Math.sin(Math.toRadians(d6));
            Double.isNaN(d9);
            Double.isNaN(d4);
            float f7 = (float) (d4 + (d9 * sin2));
            if (i4 >= -180 && i4 <= -90) {
                if (i4 == -90) {
                    for (int i6 = 0; i6 <= this.f23495a; i6++) {
                        float f8 = i6;
                        this.f23514t.add(new a(f4 + f8, f5));
                        this.f23516v.add(new a(f8 + f6, f7));
                    }
                } else {
                    this.f23514t.add(new a(f4, f5));
                    this.f23516v.add(new a(f6, f7));
                }
            }
            if (i4 >= -90 && i4 <= 0) {
                this.f23514t.add(new a(this.f23495a + f4, f5));
                this.f23516v.add(new a(this.f23495a + f6, f7));
            }
            if (i4 >= 0 && i4 <= 90) {
                if (i4 == 90) {
                    for (int i7 = this.f23495a; i7 >= 0; i7--) {
                        float f9 = i7;
                        this.f23514t.add(new a(f4 + f9, f5));
                        this.f23516v.add(new a(f9 + f6, f7));
                    }
                } else {
                    this.f23514t.add(new a(this.f23495a + f4, f5));
                    this.f23516v.add(new a(this.f23495a + f6, f7));
                }
            }
            if (i4 >= 90 && i4 <= 180) {
                this.f23514t.add(new a(f4, f5));
                this.f23516v.add(new a(f6, f7));
            }
        }
    }

    private void b() {
        this.f23510p.setColor(this.f23498d);
        this.f23510p.setFlags(1);
        this.f23511q.setColor(this.f23499e);
        this.f23511q.setFlags(1);
        this.f23511q.setStyle(Paint.Style.STROKE);
        this.f23511q.setStrokeWidth(this.f23497c);
        this.f23512r.setColor(this.f23500f);
        this.f23512r.setFlags(1);
        this.f23512r.setStyle(Paint.Style.STROKE);
        this.f23512r.setStrokeWidth(this.f23497c);
        this.f23513s.setColor(this.f23501g);
        this.f23513s.setFlags(33);
        this.f23513s.setTextSize(this.f23504j);
    }

    private void d(int progress, boolean refresh) {
        int i4 = this.f23502h;
        if (progress > i4) {
            this.f23503i = i4;
        } else {
            this.f23503i = progress;
        }
        if (progress == 0) {
            c();
            return;
        }
        this.f23512r.setColor(this.f23500f);
        int i5 = (int) (this.f23503i * this.f23508n);
        if (i5 >= this.f23516v.size()) {
            i5 = this.f23516v.size() - 1;
        }
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i6 = this.f23509o; i6 <= i5; i6++) {
            a aVar = this.f23516v.get(i6);
            if (i6 == this.f23509o) {
                f4 = aVar.a();
                f5 = aVar.b();
                this.f23518x.moveTo(f4, f5);
            }
            this.f23518x.quadTo(f4, f5, aVar.a(), aVar.b());
            f4 = aVar.a();
            f5 = aVar.b();
        }
        this.f23509o = i5;
        if (refresh) {
            invalidate();
        }
    }

    public void c() {
        this.f23509o = 0;
        this.f23503i = 0;
        this.f23518x = new Path();
        a aVar = this.f23516v.get(0);
        this.f23518x.moveTo(aVar.a(), aVar.b());
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        double d4;
        super.onDraw(canvas);
        canvas.drawPath(this.f23515u, this.f23510p);
        canvas.drawPath(this.f23517w, this.f23511q);
        this.f23512r.setColor(this.f23500f);
        canvas.drawPath(this.f23518x, this.f23512r);
        if (this.f23506l) {
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder();
            double d5 = (this.f23503i * 1.0f) / this.f23502h;
            Double.isNaN(d5);
            sb.append(String.format("%.2f", Double.valueOf(d5 * 100.0d)));
            sb.append("%");
            String sb2 = sb.toString();
            this.f23513s.setTextSize(this.f23504j);
            this.f23513s.getTextBounds(sb2, 0, sb2.length(), rect);
            if (this.f23507m) {
                canvas.drawText(sb2, this.f23519y - (rect.width() / 2), this.f23520z, this.f23513s);
            } else {
                canvas.drawText(sb2, this.f23519y - (rect.width() / 2), this.f23520z + (rect.height() / 2), this.f23513s);
            }
        }
        if (this.f23507m) {
            this.f23513s.setTextSize(this.f23504j / 2);
            Rect rect2 = new Rect();
            Paint paint = this.f23513s;
            String str = this.f23505k;
            paint.getTextBounds(str, 0, str.length(), rect2);
            if (this.f23506l) {
                int i4 = this.f23520z;
                Double.isNaN(rect2.height());
                canvas.drawText(this.f23505k, this.f23519y - (rect2.width() / 2), i4 + ((int) (d4 * 1.5d)), this.f23513s);
                return;
            }
            canvas.drawText(this.f23505k, this.f23519y - (rect2.width() / 2), this.f23520z + (rect2.height() / 2), this.f23513s);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int i4 = this.f23496b + this.f23497c;
        if (mode != 1073741824) {
            size = getPaddingLeft() + this.f23495a + (i4 * 2) + getPaddingRight();
            this.f23519y = size / 2;
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingTop() + (i4 * 2) + getPaddingBottom();
            this.f23520z = size2 / 2;
        }
        setMeasuredDimension(size, size2);
    }

    public void setMaxProgress(int maxProgress) {
        this.f23502h = maxProgress;
        this.f23508n = ((this.f23516v.size() * 1.0f) / this.f23502h) * 1.0f;
        this.f23509o = 0;
    }

    public void setProgress(int progress) {
        d(progress, true);
    }

    public void setShowText(boolean showText) {
        this.f23506l = showText;
        invalidate();
    }

    public void setShowTips(boolean showTips) {
        this.f23507m = showTips;
        invalidate();
    }

    public void setTipsText(String tipsText) {
        this.f23505k = tipsText;
        invalidate();
    }

    public TrackProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TrackProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f23495a = 100;
        this.f23496b = 50;
        this.f23497c = 20;
        this.f23498d = 0;
        this.f23499e = 0;
        this.f23500f = 0;
        this.f23501g = 0;
        this.f23502h = 100;
        this.f23503i = 10;
        this.f23504j = 0;
        this.f23505k = "\u672a\u67653\u5929\u9884\u7ea6\u7387";
        this.f23506l = true;
        this.f23507m = true;
        float f4 = 0.0f;
        this.f23508n = 0.0f;
        this.f23509o = 0;
        this.f23510p = new Paint();
        this.f23511q = new Paint();
        this.f23512r = new Paint();
        this.f23513s = new Paint();
        this.f23514t = new ArrayList();
        this.f23515u = new Path();
        this.f23516v = new ArrayList();
        this.f23517w = new Path();
        this.f23518x = new Path();
        this.f23519y = 0;
        this.f23520z = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.TrackProgressView, defStyleAttr, 0);
        this.f23498d = obtainStyledAttributes.getColor(0, getResources().getColor(2131034180));
        this.f23496b = obtainStyledAttributes.getDimensionPixelSize(6, 50);
        this.f23495a = obtainStyledAttributes.getDimensionPixelSize(2, 100);
        int i4 = getResources().getDisplayMetrics().widthPixels;
        this.f23497c = obtainStyledAttributes.getDimensionPixelSize(13, 20);
        this.f23495a = (i4 - ((this.f23496b + this.f23497c) * 2)) - obtainStyledAttributes.getDimensionPixelSize(3, 20);
        this.f23499e = obtainStyledAttributes.getColor(12, getResources().getColor(2131034197));
        this.f23500f = obtainStyledAttributes.getColor(5, getResources().getColor(2131034608));
        this.f23502h = obtainStyledAttributes.getInteger(4, 100);
        this.f23503i = obtainStyledAttributes.getInteger(1, 10);
        this.f23504j = obtainStyledAttributes.getDimensionPixelSize(10, 20);
        this.f23501g = obtainStyledAttributes.getColor(9, getResources().getColor(2131034608));
        this.f23506l = obtainStyledAttributes.getBoolean(7, true);
        this.f23507m = obtainStyledAttributes.getBoolean(8, true);
        String string = obtainStyledAttributes.getString(11);
        this.f23505k = string;
        if (TextUtils.isEmpty(string)) {
            this.f23505k = "\u672a\u67653\u5929\u9884\u7ea6\u7387";
        }
        obtainStyledAttributes.recycle();
        b();
        a();
        float f5 = 0.0f;
        for (int i5 = 0; i5 < this.f23514t.size(); i5++) {
            a aVar = this.f23514t.get(i5);
            if (i5 == 0) {
                f4 = aVar.a();
                f5 = aVar.b();
                this.f23515u.moveTo(f4, f5);
            }
            this.f23515u.quadTo(f4, f5, aVar.a(), aVar.b());
            f4 = aVar.a();
            f5 = aVar.b();
        }
        for (int i6 = 0; i6 < this.f23516v.size(); i6++) {
            a aVar2 = this.f23516v.get(i6);
            if (i6 == 0) {
                f4 = aVar2.a();
                f5 = aVar2.b();
                this.f23517w.moveTo(f4, f5);
            }
            this.f23517w.quadTo(f4, f5, aVar2.a(), aVar2.b());
            f4 = aVar2.a();
            f5 = aVar2.b();
        }
        setMaxProgress(this.f23502h);
        d(this.f23503i, false);
    }
}
