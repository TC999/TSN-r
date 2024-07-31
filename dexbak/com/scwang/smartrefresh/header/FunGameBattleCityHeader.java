package com.scwang.smartrefresh.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.util.C11925c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FunGameBattleCityHeader extends FunGameView {

    /* renamed from: I0 */
    private static int f33074I0 = 3;

    /* renamed from: J0 */
    private static final float f33075J0 = 0.33333334f;

    /* renamed from: K0 */
    private static final int f33076K0 = 360;

    /* renamed from: L0 */
    private static final int f33077L0 = 60;

    /* renamed from: M0 */
    private static final int f33078M0 = 8;

    /* renamed from: A0 */
    private int f33079A0;

    /* renamed from: B0 */
    private int f33080B0;

    /* renamed from: C0 */
    private int f33081C0;

    /* renamed from: D0 */
    private int f33082D0;

    /* renamed from: E0 */
    private int f33083E0;

    /* renamed from: F0 */
    private int f33084F0;

    /* renamed from: G0 */
    private int f33085G0;

    /* renamed from: H0 */
    private boolean f33086H0;

    /* renamed from: Q */
    private SparseArray<Queue<RectF>> f33087Q;

    /* renamed from: R */
    private Queue<Point> f33088R;

    /* renamed from: S */
    private Point f33089S;

    /* renamed from: T */
    private Random f33090T;

    /* renamed from: U */
    private float f33091U;

    /* renamed from: V */
    private int f33092V;

    /* renamed from: W */
    private int f33093W;

    /* renamed from: p0 */
    private int f33094p0;

    public FunGameBattleCityHeader(Context context) {
        super(context);
        this.f33079A0 = 1;
        this.f33080B0 = 4;
        this.f33086H0 = true;
    }

    /* renamed from: W */
    private int m20209W() {
        return this.f33090T.nextInt(f33074I0);
    }

    /* renamed from: X */
    private boolean m20208X(int i, float f, float f2) {
        RectF peek = this.f33087Q.get(i).peek();
        return peek != null && peek.contains(f, f2);
    }

    /* renamed from: Y */
    private boolean m20207Y(Point point) {
        int m20201e0 = m20201e0(point.y);
        RectF peek = this.f33087Q.get(m20201e0).peek();
        if (peek == null || !peek.contains(point.x, point.y)) {
            return false;
        }
        int i = this.f33085G0 + 1;
        this.f33085G0 = i;
        if (i == this.f33084F0) {
            m20199g0();
        }
        this.f33087Q.get(m20201e0).poll();
        return true;
    }

    /* renamed from: Z */
    private void m20206Z(Canvas canvas, Point point) {
        int i = point.x - this.f33080B0;
        point.x = i;
        canvas.drawCircle(i, point.y, this.f33091U, this.f33330w);
    }

    /* renamed from: a0 */
    private void m20205a0(Canvas canvas, int i) {
        this.f33330w.setColor(this.f33325B);
        int i2 = this.f33081C0 + this.f33079A0;
        this.f33081C0 = i2;
        if (i2 / this.f33092V == 1 || this.f33086H0) {
            this.f33081C0 = 0;
            this.f33086H0 = false;
        }
        int m20209W = m20209W();
        boolean z = false;
        for (int i3 = 0; i3 < f33074I0; i3++) {
            Queue<RectF> queue = this.f33087Q.get(i3);
            if (this.f33081C0 == 0 && i3 == m20209W) {
                queue.offer(m20202d0(i3));
            }
            Iterator<RectF> it = queue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RectF next = it.next();
                if (next.left >= i) {
                    int i4 = this.f33083E0 + 1;
                    this.f33083E0 = i4;
                    if (i4 >= 8) {
                        this.f33324A = 2;
                        z = true;
                        break;
                    }
                    z = true;
                } else {
                    m20203c0(canvas, next);
                }
            }
            if (this.f33324A == 2) {
                break;
            }
            if (z) {
                queue.poll();
                z = false;
            }
        }
        invalidate();
    }

    /* renamed from: b0 */
    private void m20204b0(Canvas canvas, int i) {
        this.f33330w.setColor(this.f33326C);
        boolean m20208X = m20208X(m20201e0((int) this.f33332y), i - this.f33333z, this.f33332y);
        int m20201e0 = m20201e0((int) (this.f33332y + this.f33333z));
        int i2 = this.f33333z;
        boolean m20208X2 = m20208X(m20201e0, i - i2, this.f33332y + i2);
        if (m20208X || m20208X2) {
            this.f33324A = 2;
        }
        int i3 = this.f33333z;
        float f = this.f33332y;
        float f2 = this.f33302l;
        canvas.drawRect(i - i3, f + f2, i, f + i3 + f2, this.f33330w);
        int i4 = this.f33333z;
        int i5 = this.f33094p0;
        float f3 = this.f33332y;
        canvas.drawRect((i - i4) - i5, f3 + ((i4 - i5) * 0.5f), i - i4, f3 + ((i4 - i5) * 0.5f) + i5, this.f33330w);
    }

    /* renamed from: c0 */
    private void m20203c0(Canvas canvas, RectF rectF) {
        float f = rectF.left;
        int i = this.f33079A0;
        rectF.set(f + i, rectF.top, rectF.right + i, rectF.bottom);
        canvas.drawRect(rectF, this.f33330w);
        float f2 = rectF.top;
        int i2 = this.f33333z;
        int i3 = this.f33094p0;
        float f3 = f2 + ((i2 - i3) * 0.5f);
        float f4 = rectF.right;
        canvas.drawRect(f4, f3, f4 + i3, f3 + i3, this.f33330w);
    }

    /* renamed from: d0 */
    private RectF m20202d0(int i) {
        int i2;
        float f = -(this.f33094p0 + this.f33333z);
        float f2 = (i * i2) + this.f33302l;
        return new RectF(f, f2, (this.f33094p0 * 2.5f) + f, this.f33333z + f2);
    }

    /* renamed from: e0 */
    private int m20201e0(int i) {
        int i2 = this.f33292b;
        int i3 = f33074I0;
        int i4 = i / (i2 / i3);
        if (i4 >= i3) {
            i4 = i3 - 1;
        }
        if (i4 < 0) {
            return 0;
        }
        return i4;
    }

    /* renamed from: f0 */
    private void m20200f0(Canvas canvas, int i) {
        this.f33330w.setColor(this.f33327D);
        int i2 = this.f33082D0 + this.f33080B0;
        this.f33082D0 = i2;
        boolean z = false;
        if (i2 / this.f33093W == 1) {
            this.f33082D0 = 0;
        }
        if (this.f33082D0 == 0) {
            Point point = new Point();
            int i3 = this.f33333z;
            point.x = (i - i3) - this.f33094p0;
            point.y = (int) (this.f33332y + (i3 * 0.5f));
            this.f33088R.offer(point);
        }
        for (Point point2 : this.f33088R) {
            if (m20207Y(point2)) {
                this.f33089S = point2;
            } else {
                if (point2.x + this.f33091U <= 0.0f) {
                    z = true;
                }
                m20206Z(canvas, point2);
            }
        }
        if (z) {
            this.f33088R.poll();
        }
        this.f33088R.remove(this.f33089S);
        this.f33089S = null;
    }

    /* renamed from: g0 */
    private void m20199g0() {
        this.f33084F0 += 8;
        this.f33079A0 += C11925c.m19766b(1.0f);
        this.f33080B0 += C11925c.m19766b(1.0f);
        this.f33085G0 = 0;
        int i = this.f33092V;
        if (i > 12) {
            this.f33092V = i - 12;
        }
        int i2 = this.f33093W;
        if (i2 > 30) {
            this.f33093W = i2 - 30;
        }
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    /* renamed from: M */
    protected void mo20095M(Canvas canvas, int i, int i2) {
        m20204b0(canvas, i);
        int i3 = this.f33324A;
        if (i3 == 1 || i3 == 3 || i3 == 4) {
            m20205a0(canvas, i);
            m20200f0(canvas, i);
        }
        if (isInEditMode()) {
            int i4 = this.f33333z;
            m20203c0(canvas, new RectF(i4, 0.0f, i4 * 2, i4));
            int i5 = this.f33333z;
            m20203c0(canvas, new RectF(0.0f, i5, i5, i5 * 2));
            int i6 = this.f33333z;
            m20203c0(canvas, new RectF(i6 * 3, i6 * 2, i6 * 4, i6 * 3));
        }
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    /* renamed from: R */
    protected void mo20090R() {
        this.f33090T = new Random();
        int i = this.f33292b / f33074I0;
        this.f33333z = i;
        int floor = (int) Math.floor((i * f33075J0) + 0.5f);
        this.f33094p0 = floor;
        this.f33091U = (floor - (this.f33302l * 2.0f)) * 0.5f;
        mo20086V();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    /* renamed from: V */
    protected void mo20086V() {
        this.f33324A = 0;
        this.f33332y = this.f33302l;
        this.f33079A0 = C11925c.m19766b(1.0f);
        this.f33080B0 = C11925c.m19766b(4.0f);
        this.f33084F0 = 8;
        this.f33085G0 = 0;
        this.f33086H0 = true;
        this.f33092V = this.f33333z + this.f33094p0 + 60;
        this.f33093W = 360;
        this.f33087Q = new SparseArray<>();
        for (int i = 0; i < f33074I0; i++) {
            this.f33087Q.put(i, new LinkedList());
        }
        this.f33088R = new LinkedList();
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33079A0 = 1;
        this.f33080B0 = 4;
        this.f33086H0 = true;
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33079A0 = 1;
        this.f33080B0 = 4;
        this.f33086H0 = true;
    }

    @RequiresApi(21)
    public FunGameBattleCityHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33079A0 = 1;
        this.f33080B0 = 4;
        this.f33086H0 = true;
    }
}
