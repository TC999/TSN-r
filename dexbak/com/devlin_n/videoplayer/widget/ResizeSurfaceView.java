package com.devlin_n.videoplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ResizeSurfaceView extends SurfaceView {

    /* renamed from: a */
    private int f23394a;

    /* renamed from: b */
    private int f23395b;

    /* renamed from: c */
    private int f23396c;

    public ResizeSurfaceView(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void m35668a(int i, int i2) {
        this.f23394a = i;
        this.f23395b = i2;
        getHolder().setFixedSize(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
        if (r1 > r7) goto L42;
     */
    @Override // android.view.SurfaceView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            int r0 = r6.f23394a
            int r0 = android.view.SurfaceView.getDefaultSize(r0, r7)
            int r1 = r6.f23395b
            int r1 = android.view.SurfaceView.getDefaultSize(r1, r8)
            int r2 = r6.f23396c
            r3 = 1
            if (r2 == r3) goto La1
            r3 = 2
            r4 = 4
            r5 = 3
            if (r2 == r3) goto L95
            if (r2 == r5) goto Lae
            if (r2 == r4) goto L90
            int r2 = r6.f23394a
            if (r2 <= 0) goto L8d
            int r2 = r6.f23395b
            if (r2 <= 0) goto L8d
            int r0 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.getSize(r8)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L54
            if (r1 != r2) goto L54
            int r0 = r6.f23394a
            int r1 = r0 * r8
            int r2 = r6.f23395b
            int r3 = r7 * r2
            if (r1 >= r3) goto L48
            int r0 = r0 * r8
            int r7 = r0 / r2
            goto Lae
        L48:
            int r1 = r0 * r8
            int r3 = r7 * r2
            if (r1 <= r3) goto Lae
            int r2 = r2 * r7
            int r8 = r2 / r0
            goto Lae
        L54:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L66
            int r0 = r6.f23395b
            int r0 = r0 * r7
            int r2 = r6.f23394a
            int r0 = r0 / r2
            if (r1 != r3) goto L64
            if (r0 <= r8) goto L64
            goto Lae
        L64:
            r8 = r0
            goto Lae
        L66:
            if (r1 != r2) goto L76
            int r1 = r6.f23394a
            int r1 = r1 * r8
            int r2 = r6.f23395b
            int r1 = r1 / r2
            if (r0 != r3) goto L74
            if (r1 <= r7) goto L74
            goto Lae
        L74:
            r7 = r1
            goto Lae
        L76:
            int r2 = r6.f23394a
            int r4 = r6.f23395b
            if (r1 != r3) goto L82
            if (r4 <= r8) goto L82
            int r1 = r8 * r2
            int r1 = r1 / r4
            goto L84
        L82:
            r1 = r2
            r8 = r4
        L84:
            if (r0 != r3) goto L74
            if (r1 <= r7) goto L74
            int r4 = r4 * r7
            int r8 = r4 / r2
            goto Lae
        L8d:
            r7 = r0
        L8e:
            r8 = r1
            goto Lae
        L90:
            int r7 = r6.f23394a
            int r8 = r6.f23395b
            goto Lae
        L95:
            int r7 = r0 / 4
            int r8 = r7 * 3
            if (r1 <= r8) goto L9c
            goto La7
        L9c:
            int r7 = r1 / 3
            int r7 = r7 * 4
            goto L8e
        La1:
            int r7 = r0 / 16
            int r8 = r7 * 9
            if (r1 <= r8) goto La9
        La7:
            r7 = r0
            goto Lae
        La9:
            int r7 = r1 / 9
            int r7 = r7 * 16
            goto L8e
        Lae:
            r6.setMeasuredDimension(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devlin_n.videoplayer.widget.ResizeSurfaceView.onMeasure(int, int):void");
    }

    public void setScreenScale(int i) {
        this.f23396c = i;
        requestLayout();
    }

    public ResizeSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
