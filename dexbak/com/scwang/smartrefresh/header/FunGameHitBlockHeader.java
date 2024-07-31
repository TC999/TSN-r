package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.util.C11925c;
import com.scwang.smartrefresh.layout.util.ColorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FunGameHitBlockHeader extends FunGameView {

    /* renamed from: F0 */
    private static final int f33095F0 = 5;

    /* renamed from: G0 */
    private static final int f33096G0 = 3;

    /* renamed from: H0 */
    private static final float f33097H0 = 0.01806f;

    /* renamed from: I0 */
    private static final float f33098I0 = 0.8f;

    /* renamed from: J0 */
    private static final float f33099J0 = 0.08f;

    /* renamed from: K0 */
    private static final int f33100K0 = 30;

    /* renamed from: L0 */
    static final float f33101L0 = 1.0f;

    /* renamed from: M0 */
    private static final int f33102M0 = 3;

    /* renamed from: A0 */
    private List<Point> f33103A0;

    /* renamed from: B0 */
    private boolean f33104B0;

    /* renamed from: C0 */
    private int f33105C0;

    /* renamed from: D0 */
    private int f33106D0;

    /* renamed from: E0 */
    private int f33107E0;

    /* renamed from: Q */
    private float f33108Q;

    /* renamed from: R */
    private float f33109R;

    /* renamed from: S */
    private float f33110S;

    /* renamed from: T */
    private Paint f33111T;

    /* renamed from: U */
    private float f33112U;

    /* renamed from: V */
    private float f33113V;

    /* renamed from: W */
    private float f33114W;

    /* renamed from: p0 */
    private float f33115p0;

    public FunGameHitBlockHeader(Context context) {
        super(context);
        m20198H(context, null);
    }

    /* renamed from: H */
    private void m20198H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11852R.styleable.FunGameHitBlockHeader);
        this.f33106D0 = obtainStyledAttributes.getInt(C11852R.styleable.FunGameHitBlockHeader_fgvBlockHorizontalNum, 3);
        this.f33107E0 = obtainStyledAttributes.getInt(C11852R.styleable.FunGameHitBlockHeader_fgvBallSpeed, C11925c.m19766b(3.0f));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f33111T = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f33110S = C11925c.m19766b(4.0f);
    }

    /* renamed from: W */
    private boolean m20197W(float f, float f2) {
        int i = (int) ((((f - this.f33112U) - this.f33110S) - this.f33107E0) / this.f33109R);
        if (i == this.f33106D0) {
            i--;
        }
        int i2 = (int) (f2 / this.f33108Q);
        if (i2 == 5) {
            i2--;
        }
        Point point = new Point();
        point.set(i, i2);
        boolean z = false;
        Iterator<Point> it = this.f33103A0.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().equals(point.x, point.y)) {
                z = true;
                break;
            }
        }
        if (!z) {
            this.f33103A0.add(point);
        }
        return !z;
    }

    /* renamed from: X */
    private boolean m20196X(float f) {
        float f2 = f - this.f33332y;
        return f2 >= 0.0f && f2 <= ((float) this.f33333z);
    }

    /* renamed from: Y */
    private void m20195Y(Canvas canvas) {
        boolean z;
        int i = 0;
        while (true) {
            int i2 = this.f33106D0;
            if (i >= i2 * 5) {
                return;
            }
            int i3 = i / i2;
            int i4 = i % i2;
            Iterator<Point> it = this.f33103A0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().equals(i4, i3)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.f33111T.setColor(ColorUtils.m19794A(this.f33325B, 255 / (i4 + 1)));
                float f = this.f33112U;
                float f2 = this.f33109R;
                float f3 = f + (i4 * (f2 + 1.0f));
                float f4 = i3;
                float f5 = this.f33108Q;
                float f6 = (f4 * (f5 + 1.0f)) + 1.0f;
                canvas.drawRect(f3, f6, f3 + f2, f6 + f5, this.f33111T);
            }
            i++;
        }
    }

    /* renamed from: Z */
    private void m20194Z(Canvas canvas) {
        this.f33330w.setColor(this.f33326C);
        float f = this.f33113V;
        float f2 = this.f33332y;
        canvas.drawRect(f, f2, f + this.f33109R, f2 + this.f33333z, this.f33330w);
    }

    /* renamed from: a0 */
    private void m20193a0(Canvas canvas, int i) {
        int i2;
        this.f33330w.setColor(this.f33327D);
        float f = this.f33114W;
        if (f <= this.f33112U + (this.f33106D0 * this.f33109R) + ((i2 - 1) * 1.0f) + this.f33110S && m20197W(f, this.f33115p0)) {
            this.f33104B0 = false;
        }
        float f2 = this.f33114W;
        float f3 = this.f33112U;
        float f4 = this.f33110S;
        if (f2 <= f3 + f4) {
            this.f33104B0 = false;
        }
        float f5 = this.f33113V;
        if (f2 + f4 < f5 || f2 - f4 >= f5 + this.f33109R) {
            if (f2 > i) {
                this.f33324A = 2;
            }
        } else if (m20196X(this.f33115p0)) {
            if (this.f33103A0.size() == this.f33106D0 * 5) {
                this.f33324A = 2;
                return;
            }
            this.f33104B0 = true;
        }
        float f6 = this.f33115p0;
        float f7 = this.f33110S;
        if (f6 <= f7 + 1.0f) {
            this.f33105C0 = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        } else if (f6 >= (this.f33292b - f7) - 1.0f) {
            this.f33105C0 = AdEventType.VIDEO_READY;
        }
        if (this.f33104B0) {
            this.f33114W -= this.f33107E0;
        } else {
            this.f33114W += this.f33107E0;
        }
        float tan = f6 - (((float) Math.tan(Math.toRadians(this.f33105C0))) * this.f33107E0);
        this.f33115p0 = tan;
        canvas.drawCircle(this.f33114W, tan, this.f33110S, this.f33330w);
        invalidate();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    /* renamed from: M */
    protected void mo20095M(Canvas canvas, int i, int i2) {
        m20195Y(canvas);
        m20194Z(canvas);
        int i3 = this.f33324A;
        if (i3 == 1 || i3 == 3 || i3 == 4 || isInEditMode()) {
            m20193a0(canvas, i);
        }
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    /* renamed from: R */
    protected void mo20090R() {
        int measuredWidth = getMeasuredWidth();
        this.f33333z = (int) (this.f33108Q * 1.6f);
        float f = (this.f33292b / 5) - 1.0f;
        this.f33108Q = f;
        float f2 = measuredWidth;
        this.f33109R = f33097H0 * f2;
        this.f33112U = f33099J0 * f2;
        this.f33113V = f2 * f33098I0;
        this.f33333z = (int) (f * 1.6f);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    /* renamed from: V */
    protected void mo20086V() {
        this.f33114W = this.f33113V - (this.f33110S * 3.0f);
        this.f33115p0 = (int) (this.f33292b * 0.5f);
        this.f33332y = 1.0f;
        this.f33105C0 = 30;
        this.f33104B0 = true;
        List<Point> list = this.f33103A0;
        if (list == null) {
            this.f33103A0 = new ArrayList();
        } else {
            list.clear();
        }
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20198H(context, attributeSet);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20198H(context, attributeSet);
    }

    @RequiresApi(21)
    public FunGameHitBlockHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20198H(context, attributeSet);
    }
}
