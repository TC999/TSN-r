package com.bytedance.adsdk.ugeno.w;

import android.animation.AnimatorSet;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private c f26366a;

    /* renamed from: b  reason: collision with root package name */
    private AnimatorSet f26367b = new AnimatorSet();

    /* renamed from: c  reason: collision with root package name */
    private View f26368c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f26368c.setPivotX(d.this.f26368c.getWidth() / 2.0f);
            d.this.f26368c.setPivotY(d.this.f26368c.getHeight());
        }
    }

    public d(View view, c cVar) {
        this.f26368c = view;
        this.f26366a = cVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0163, code lost:
        if (r2.equals("accelerate") == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.w.d.b():void");
    }

    public void c() {
        AnimatorSet animatorSet = this.f26367b;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
