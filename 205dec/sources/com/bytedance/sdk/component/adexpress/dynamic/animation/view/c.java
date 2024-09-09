package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    Paint f29084c;

    /* renamed from: f  reason: collision with root package name */
    private int f29085f;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    Path f29086w = new Path();
    Path xv = new Path();

    public c() {
        Paint paint = new Paint();
        this.f29084c = paint;
        paint.setAntiAlias(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.graphics.Canvas r23, com.bytedance.sdk.component.adexpress.dynamic.animation.view.w r24, android.view.View r25) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.animation.view.c.c(android.graphics.Canvas, com.bytedance.sdk.component.adexpress.dynamic.animation.view.w, android.view.View):void");
    }

    public void c(View view, float f4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i4 = this.f29085f;
        int i5 = (int) (i4 * f4);
        layoutParams.width = i5;
        view.setTranslationX((i4 - i5) / 2);
        if (view instanceof DynamicImageView) {
            int i6 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i6 >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i6).setTranslationX((-(this.f29085f - layoutParams.width)) / 2);
                i6++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.view.View r6, int r7, int r8) {
        /*
            r5 = this;
            int r0 = r7 / 2
            r5.sr = r0
            int r0 = r8 / 2
            r5.ux = r0
            java.lang.String r0 = ""
            int r1 = r5.f29085f
            if (r1 != 0) goto L1e
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            int r1 = r1.width
            if (r1 <= 0) goto L1e
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            int r1 = r1.width
            r5.f29085f = r1
        L1e:
            r1 = 2097610710(0x7d06ffd6, float:1.1215308E37)
            r2 = 0
            java.lang.Object r1 = r6.getTag(r1)     // Catch: java.lang.Exception -> L3e
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L3e
            android.graphics.RectF r0 = new android.graphics.RectF     // Catch: java.lang.Exception -> L3d
            float r7 = (float) r7     // Catch: java.lang.Exception -> L3d
            float r3 = (float) r8     // Catch: java.lang.Exception -> L3d
            r0.<init>(r2, r2, r7, r3)     // Catch: java.lang.Exception -> L3d
            android.graphics.Path r7 = r5.xv     // Catch: java.lang.Exception -> L3d
            int r3 = r8 / 2
            float r3 = (float) r3     // Catch: java.lang.Exception -> L3d
            int r8 = r8 / 2
            float r8 = (float) r8     // Catch: java.lang.Exception -> L3d
            android.graphics.Path$Direction r4 = android.graphics.Path.Direction.CW     // Catch: java.lang.Exception -> L3d
            r7.addRoundRect(r0, r3, r8, r4)     // Catch: java.lang.Exception -> L3d
            goto L3f
        L3d:
            r0 = r1
        L3e:
            r1 = r0
        L3f:
            java.lang.String r7 = "right"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L56
            int r7 = r5.sr
            int r7 = r7 * 2
            float r7 = (float) r7
            r6.setPivotX(r7)
            int r7 = r5.ux
            float r7 = (float) r7
            r6.setPivotY(r7)
            goto L74
        L56:
            java.lang.String r7 = "left"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L68
            r6.setPivotX(r2)
            int r7 = r5.ux
            float r7 = (float) r7
            r6.setPivotY(r7)
            goto L74
        L68:
            int r7 = r5.sr
            float r7 = (float) r7
            r6.setPivotX(r7)
            int r7 = r5.ux
            float r7 = (float) r7
            r6.setPivotY(r7)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.animation.view.c.c(android.view.View, int, int):void");
    }
}
