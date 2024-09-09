package com.qq.e.dl.f;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Build;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h {

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f46841e;

    /* renamed from: a  reason: collision with root package name */
    public final com.qq.e.dl.i.a f46842a;

    /* renamed from: b  reason: collision with root package name */
    public final ValueAnimator f46843b;

    /* renamed from: c  reason: collision with root package name */
    private float f46844c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    boolean f46845d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        String f46846a = "DL-Animation-Builder";

        /* JADX INFO: Access modifiers changed from: package-private */
        public h a(com.qq.e.dl.i.a aVar, com.qq.e.dl.l.h hVar) {
            PropertyValuesHolder[] a4;
            if (aVar == null || hVar == null || (a4 = a(aVar)) == null || a4.length <= 0) {
                return null;
            }
            if (g.f46837c) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setValues(a4);
                objectAnimator.setTarget(hVar);
                objectAnimator.setDuration(aVar.f46912e);
                objectAnimator.setRepeatCount(aVar.f46914g);
                objectAnimator.setRepeatMode(aVar.f46915h);
                objectAnimator.setInterpolator(q.a(aVar));
                return new h(aVar, objectAnimator);
            }
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setValues(a4);
            objectAnimator2.setTarget(hVar);
            objectAnimator2.setStartDelay(aVar.f46911d);
            objectAnimator2.setDuration(aVar.f46912e);
            objectAnimator2.setInterpolator(q.a(aVar));
            if (aVar.f46913f > 0 && aVar.f46914g > 0) {
                objectAnimator2.addListener(new m(aVar));
            } else {
                int i4 = aVar.f46914g;
                if (i4 < 0) {
                    i4 = -1;
                }
                objectAnimator2.setRepeatCount(i4);
                if (aVar.c()) {
                    objectAnimator2.setRepeatMode(2);
                }
            }
            return new h(aVar, objectAnimator2);
        }

        abstract PropertyValuesHolder[] a(com.qq.e.dl.i.a aVar);
    }

    static {
        f46841e = Build.VERSION.SDK_INT < 24;
    }

    public h(com.qq.e.dl.i.a aVar, ValueAnimator valueAnimator) {
        this.f46842a = aVar;
        this.f46843b = valueAnimator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f4) {
        if (this.f46844c == f4) {
            return;
        }
        this.f46844c = f4;
        if (f46841e && f4 > 1.0f) {
            int i4 = (int) f4;
            if (f4 == i4 && (this.f46842a.b() || i4 % 2 == 1)) {
                f4 = 1.0f;
            }
        }
        this.f46843b.setCurrentFraction(f4);
    }
}
