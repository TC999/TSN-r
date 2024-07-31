package com.bxkj.student.p094v2.common.view;

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
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.student.v2.common.view.TrackProgressView */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TrackProgressView extends View {

    /* renamed from: a */
    private int f20191a;

    /* renamed from: b */
    private int f20192b;

    /* renamed from: c */
    private int f20193c;

    /* renamed from: d */
    private int f20194d;

    /* renamed from: e */
    private int f20195e;

    /* renamed from: f */
    private int f20196f;

    /* renamed from: g */
    private int f20197g;

    /* renamed from: h */
    private int f20198h;

    /* renamed from: i */
    private int f20199i;

    /* renamed from: j */
    private int f20200j;

    /* renamed from: k */
    private String f20201k;

    /* renamed from: l */
    private boolean f20202l;

    /* renamed from: m */
    private boolean f20203m;

    /* renamed from: n */
    private float f20204n;

    /* renamed from: o */
    private int f20205o;

    /* renamed from: p */
    private Paint f20206p;

    /* renamed from: q */
    private Paint f20207q;

    /* renamed from: r */
    private Paint f20208r;

    /* renamed from: s */
    private Paint f20209s;

    /* renamed from: t */
    private List<C5556a> f20210t;

    /* renamed from: u */
    private Path f20211u;

    /* renamed from: v */
    private List<C5556a> f20212v;

    /* renamed from: w */
    private Path f20213w;

    /* renamed from: x */
    private Path f20214x;

    /* renamed from: y */
    private int f20215y;

    /* renamed from: z */
    private int f20216z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.v2.common.view.TrackProgressView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C5556a {

        /* renamed from: a */
        private float f20217a;

        /* renamed from: b */
        private float f20218b;

        public C5556a(float x, float y) {
            this.f20217a = x;
            this.f20218b = y;
        }

        /* renamed from: a */
        public float m39011a() {
            return this.f20217a;
        }

        /* renamed from: b */
        public float m39010b() {
            return this.f20218b;
        }
    }

    public TrackProgressView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m39015a() {
        for (int i = AMapEngineUtils.MIN_LONGITUDE_DEGREE; i <= 180; i++) {
            int i2 = this.f20192b;
            double d = this.f20193c + i2;
            double d2 = i2;
            double d3 = i;
            double cos = Math.cos(Math.toRadians(d3));
            Double.isNaN(d2);
            Double.isNaN(d);
            float f = (float) ((d2 * cos) + d);
            double d4 = this.f20192b;
            double sin = Math.sin(Math.toRadians(d3));
            Double.isNaN(d4);
            Double.isNaN(d);
            float f2 = (float) ((d4 * sin) + d);
            double d5 = this.f20192b + (this.f20193c / 2);
            double cos2 = Math.cos(Math.toRadians(d3));
            Double.isNaN(d5);
            Double.isNaN(d);
            float f3 = (float) ((d5 * cos2) + d);
            double d6 = this.f20192b + (this.f20193c / 2);
            double sin2 = Math.sin(Math.toRadians(d3));
            Double.isNaN(d6);
            Double.isNaN(d);
            float f4 = (float) (d + (d6 * sin2));
            if (i >= -180 && i <= -90) {
                if (i == -90) {
                    for (int i3 = 0; i3 <= this.f20191a; i3++) {
                        float f5 = i3;
                        this.f20210t.add(new C5556a(f + f5, f2));
                        this.f20212v.add(new C5556a(f5 + f3, f4));
                    }
                } else {
                    this.f20210t.add(new C5556a(f, f2));
                    this.f20212v.add(new C5556a(f3, f4));
                }
            }
            if (i >= -90 && i <= 0) {
                this.f20210t.add(new C5556a(this.f20191a + f, f2));
                this.f20212v.add(new C5556a(this.f20191a + f3, f4));
            }
            if (i >= 0 && i <= 90) {
                if (i == 90) {
                    for (int i4 = this.f20191a; i4 >= 0; i4--) {
                        float f6 = i4;
                        this.f20210t.add(new C5556a(f + f6, f2));
                        this.f20212v.add(new C5556a(f6 + f3, f4));
                    }
                } else {
                    this.f20210t.add(new C5556a(this.f20191a + f, f2));
                    this.f20212v.add(new C5556a(this.f20191a + f3, f4));
                }
            }
            if (i >= 90 && i <= 180) {
                this.f20210t.add(new C5556a(f, f2));
                this.f20212v.add(new C5556a(f3, f4));
            }
        }
    }

    /* renamed from: b */
    private void m39014b() {
        this.f20206p.setColor(this.f20194d);
        this.f20206p.setFlags(1);
        this.f20207q.setColor(this.f20195e);
        this.f20207q.setFlags(1);
        this.f20207q.setStyle(Paint.Style.STROKE);
        this.f20207q.setStrokeWidth(this.f20193c);
        this.f20208r.setColor(this.f20196f);
        this.f20208r.setFlags(1);
        this.f20208r.setStyle(Paint.Style.STROKE);
        this.f20208r.setStrokeWidth(this.f20193c);
        this.f20209s.setColor(this.f20197g);
        this.f20209s.setFlags(33);
        this.f20209s.setTextSize(this.f20200j);
    }

    /* renamed from: d */
    private void m39012d(int progress, boolean refresh) {
        int i = this.f20198h;
        if (progress > i) {
            this.f20199i = i;
        } else {
            this.f20199i = progress;
        }
        if (progress == 0) {
            m39013c();
            return;
        }
        this.f20208r.setColor(this.f20196f);
        int i2 = (int) (this.f20199i * this.f20204n);
        if (i2 >= this.f20212v.size()) {
            i2 = this.f20212v.size() - 1;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i3 = this.f20205o; i3 <= i2; i3++) {
            C5556a c5556a = this.f20212v.get(i3);
            if (i3 == this.f20205o) {
                f = c5556a.m39011a();
                f2 = c5556a.m39010b();
                this.f20214x.moveTo(f, f2);
            }
            this.f20214x.quadTo(f, f2, c5556a.m39011a(), c5556a.m39010b());
            f = c5556a.m39011a();
            f2 = c5556a.m39010b();
        }
        this.f20205o = i2;
        if (refresh) {
            invalidate();
        }
    }

    /* renamed from: c */
    public void m39013c() {
        this.f20205o = 0;
        this.f20199i = 0;
        this.f20214x = new Path();
        C5556a c5556a = this.f20212v.get(0);
        this.f20214x.moveTo(c5556a.m39011a(), c5556a.m39010b());
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        double d;
        super.onDraw(canvas);
        canvas.drawPath(this.f20211u, this.f20206p);
        canvas.drawPath(this.f20213w, this.f20207q);
        this.f20208r.setColor(this.f20196f);
        canvas.drawPath(this.f20214x, this.f20208r);
        if (this.f20202l) {
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder();
            double d2 = (this.f20199i * 1.0f) / this.f20198h;
            Double.isNaN(d2);
            sb.append(String.format("%.2f", Double.valueOf(d2 * 100.0d)));
            sb.append("%");
            String sb2 = sb.toString();
            this.f20209s.setTextSize(this.f20200j);
            this.f20209s.getTextBounds(sb2, 0, sb2.length(), rect);
            if (this.f20203m) {
                canvas.drawText(sb2, this.f20215y - (rect.width() / 2), this.f20216z, this.f20209s);
            } else {
                canvas.drawText(sb2, this.f20215y - (rect.width() / 2), this.f20216z + (rect.height() / 2), this.f20209s);
            }
        }
        if (this.f20203m) {
            this.f20209s.setTextSize(this.f20200j / 2);
            Rect rect2 = new Rect();
            Paint paint = this.f20209s;
            String str = this.f20201k;
            paint.getTextBounds(str, 0, str.length(), rect2);
            if (this.f20202l) {
                int i = this.f20216z;
                Double.isNaN(rect2.height());
                canvas.drawText(this.f20201k, this.f20215y - (rect2.width() / 2), i + ((int) (d * 1.5d)), this.f20209s);
                return;
            }
            canvas.drawText(this.f20201k, this.f20215y - (rect2.width() / 2), this.f20216z + (rect2.height() / 2), this.f20209s);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int i = this.f20192b + this.f20193c;
        if (mode != 1073741824) {
            size = getPaddingLeft() + this.f20191a + (i * 2) + getPaddingRight();
            this.f20215y = size / 2;
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingTop() + (i * 2) + getPaddingBottom();
            this.f20216z = size2 / 2;
        }
        setMeasuredDimension(size, size2);
    }

    public void setMaxProgress(int maxProgress) {
        this.f20198h = maxProgress;
        this.f20204n = ((this.f20212v.size() * 1.0f) / this.f20198h) * 1.0f;
        this.f20205o = 0;
    }

    public void setProgress(int progress) {
        m39012d(progress, true);
    }

    public void setShowText(boolean showText) {
        this.f20202l = showText;
        invalidate();
    }

    public void setShowTips(boolean showTips) {
        this.f20203m = showTips;
        invalidate();
    }

    public void setTipsText(String tipsText) {
        this.f20201k = tipsText;
        invalidate();
    }

    public TrackProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TrackProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f20191a = 100;
        this.f20192b = 50;
        this.f20193c = 20;
        this.f20194d = 0;
        this.f20195e = 0;
        this.f20196f = 0;
        this.f20197g = 0;
        this.f20198h = 100;
        this.f20199i = 10;
        this.f20200j = 0;
        this.f20201k = "未来3天预约率";
        this.f20202l = true;
        this.f20203m = true;
        float f = 0.0f;
        this.f20204n = 0.0f;
        this.f20205o = 0;
        this.f20206p = new Paint();
        this.f20207q = new Paint();
        this.f20208r = new Paint();
        this.f20209s = new Paint();
        this.f20210t = new ArrayList();
        this.f20211u = new Path();
        this.f20212v = new ArrayList();
        this.f20213w = new Path();
        this.f20214x = new Path();
        this.f20215y = 0;
        this.f20216z = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, C4215R.styleable.TrackProgressView, defStyleAttr, 0);
        this.f20194d = obtainStyledAttributes.getColor(0, getResources().getColor(2131034176));
        this.f20192b = obtainStyledAttributes.getDimensionPixelSize(6, 50);
        this.f20191a = obtainStyledAttributes.getDimensionPixelSize(2, 100);
        int i = getResources().getDisplayMetrics().widthPixels;
        this.f20193c = obtainStyledAttributes.getDimensionPixelSize(13, 20);
        this.f20191a = (i - ((this.f20192b + this.f20193c) * 2)) - obtainStyledAttributes.getDimensionPixelSize(3, 20);
        this.f20195e = obtainStyledAttributes.getColor(12, getResources().getColor(2131034193));
        this.f20196f = obtainStyledAttributes.getColor(5, getResources().getColor(2131034575));
        this.f20198h = obtainStyledAttributes.getInteger(4, 100);
        this.f20199i = obtainStyledAttributes.getInteger(1, 10);
        this.f20200j = obtainStyledAttributes.getDimensionPixelSize(10, 20);
        this.f20197g = obtainStyledAttributes.getColor(9, getResources().getColor(2131034575));
        this.f20202l = obtainStyledAttributes.getBoolean(7, true);
        this.f20203m = obtainStyledAttributes.getBoolean(8, true);
        String string = obtainStyledAttributes.getString(11);
        this.f20201k = string;
        if (TextUtils.isEmpty(string)) {
            this.f20201k = "未来3天预约率";
        }
        obtainStyledAttributes.recycle();
        m39014b();
        m39015a();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < this.f20210t.size(); i2++) {
            C5556a c5556a = this.f20210t.get(i2);
            if (i2 == 0) {
                f = c5556a.m39011a();
                f2 = c5556a.m39010b();
                this.f20211u.moveTo(f, f2);
            }
            this.f20211u.quadTo(f, f2, c5556a.m39011a(), c5556a.m39010b());
            f = c5556a.m39011a();
            f2 = c5556a.m39010b();
        }
        for (int i3 = 0; i3 < this.f20212v.size(); i3++) {
            C5556a c5556a2 = this.f20212v.get(i3);
            if (i3 == 0) {
                f = c5556a2.m39011a();
                f2 = c5556a2.m39010b();
                this.f20213w.moveTo(f, f2);
            }
            this.f20213w.quadTo(f, f2, c5556a2.m39011a(), c5556a2.m39010b());
            f = c5556a2.m39011a();
            f2 = c5556a2.m39010b();
        }
        setMaxProgress(this.f20198h);
        m39012d(this.f20199i, false);
    }
}
