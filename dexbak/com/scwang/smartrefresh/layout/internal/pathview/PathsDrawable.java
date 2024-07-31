package com.scwang.smartrefresh.layout.internal.pathview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.scwang.smartrefresh.layout.internal.pathview.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PathsDrawable extends Drawable {

    /* renamed from: n */
    protected static final Region f33720n = new Region();

    /* renamed from: o */
    protected static final Region f33721o = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: a */
    protected Paint f33722a;

    /* renamed from: b */
    protected List<Path> f33723b;

    /* renamed from: c */
    protected List<Integer> f33724c;

    /* renamed from: d */
    protected int f33725d = 1;

    /* renamed from: e */
    protected int f33726e = 1;

    /* renamed from: f */
    protected int f33727f = 0;

    /* renamed from: g */
    protected int f33728g = 0;

    /* renamed from: h */
    protected int f33729h;

    /* renamed from: i */
    protected int f33730i;

    /* renamed from: j */
    protected List<Path> f33731j;

    /* renamed from: k */
    protected List<String> f33732k;

    /* renamed from: l */
    private Bitmap f33733l;

    /* renamed from: m */
    private boolean f33734m;

    public PathsDrawable() {
        Paint paint = new Paint();
        this.f33722a = paint;
        paint.setColor(-15614977);
        this.f33722a.setStyle(Paint.Style.FILL);
        this.f33722a.setAntiAlias(true);
    }

    /* renamed from: d */
    private void m19805d(Canvas canvas) {
        canvas.translate(-this.f33727f, -this.f33728g);
        if (this.f33723b != null) {
            for (int i = 0; i < this.f33723b.size(); i++) {
                List<Integer> list = this.f33724c;
                if (list != null && i < list.size()) {
                    this.f33722a.setColor(this.f33724c.get(i).intValue());
                }
                canvas.drawPath(this.f33723b.get(i), this.f33722a);
            }
        }
    }

    /* renamed from: a */
    public boolean m19808a(int i, int i2) {
        return i == this.f33733l.getWidth() && i2 == this.f33733l.getHeight();
    }

    /* renamed from: b */
    public boolean m19807b() {
        return !this.f33734m;
    }

    /* renamed from: c */
    public void m19806c(int i, int i2) {
        if (this.f33733l == null || !m19808a(i, i2)) {
            this.f33733l = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.f33734m = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.f33722a.getAlpha() == 255) {
            canvas.save();
            canvas.translate(bounds.left - this.f33727f, bounds.top - this.f33728g);
            if (this.f33723b != null) {
                for (int i = 0; i < this.f33723b.size(); i++) {
                    List<Integer> list = this.f33724c;
                    if (list != null && i < list.size()) {
                        this.f33722a.setColor(this.f33724c.get(i).intValue());
                    }
                    canvas.drawPath(this.f33723b.get(i), this.f33722a);
                }
                this.f33722a.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        m19806c(width, height);
        if (!m19807b()) {
            m19796m(width, height);
            m19797l();
        }
        canvas.drawBitmap(this.f33733l, bounds.left, bounds.top, this.f33722a);
    }

    /* renamed from: e */
    public Paint m19804e() {
        return this.f33722a;
    }

    /* renamed from: f */
    public int m19803f() {
        return getBounds().height();
    }

    /* renamed from: g */
    protected void m19802g() {
        Integer num;
        Integer num2;
        Integer num3;
        List<Path> list = this.f33723b;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num3 = null;
            for (Path path : list) {
                Region region = f33720n;
                region.setPath(path, f33721o);
                Rect bounds = region.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num3 = Integer.valueOf(Math.max(num3 == null ? bounds.bottom : num3.intValue(), bounds.bottom));
            }
            num = num4;
            num4 = num5;
        } else {
            num = null;
            num2 = null;
            num3 = null;
        }
        this.f33727f = num4 == null ? 0 : num4.intValue();
        this.f33728g = num == null ? 0 : num.intValue();
        this.f33725d = num2 == null ? 0 : num2.intValue() - this.f33727f;
        int intValue = num3 != null ? num3.intValue() - this.f33728g : 0;
        this.f33726e = intValue;
        if (this.f33729h == 0) {
            this.f33729h = this.f33725d;
        }
        if (this.f33730i == 0) {
            this.f33730i = intValue;
        }
        Rect bounds2 = getBounds();
        int i = bounds2.left;
        int i2 = bounds2.top;
        super.setBounds(i, i2, this.f33725d + i, this.f33726e + i2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* renamed from: h */
    public void m19801h(int... iArr) {
        this.f33724c = new ArrayList();
        for (int i : iArr) {
            this.f33724c.add(Integer.valueOf(i));
        }
    }

    /* renamed from: i */
    public void m19800i(String... strArr) {
        this.f33730i = 0;
        this.f33729h = 0;
        this.f33732k = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f33731j = arrayList;
        this.f33723b = arrayList;
        for (String str : strArr) {
            this.f33732k.add(str);
            this.f33731j.add(PathParser.m19822e(str));
        }
        m19802g();
    }

    /* renamed from: j */
    public void m19799j(int i) {
        Rect bounds = getBounds();
        float height = (i * 1.0f) / bounds.height();
        setBounds((int) (bounds.left * height), (int) (bounds.top * height), (int) (bounds.right * height), (int) (bounds.bottom * height));
    }

    /* renamed from: k */
    public void m19798k(int i) {
        Rect bounds = getBounds();
        float width = (i * 1.0f) / bounds.width();
        setBounds((int) (bounds.left * width), (int) (bounds.top * width), (int) (bounds.right * width), (int) (bounds.bottom * width));
    }

    /* renamed from: l */
    public void m19797l() {
        this.f33734m = false;
    }

    /* renamed from: m */
    public void m19796m(int i, int i2) {
        this.f33733l.eraseColor(0);
        m19805d(new Canvas(this.f33733l));
    }

    /* renamed from: n */
    public int m19795n() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f33722a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        List<Path> list = this.f33731j;
        if (list != null && list.size() > 0 && (i5 != this.f33725d || i6 != this.f33726e)) {
            this.f33723b = PathParser.m19817j((i5 * 1.0f) / this.f33729h, (i6 * 1.0f) / this.f33730i, this.f33731j, this.f33732k);
            m19802g();
            return;
        }
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f33722a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
