package com.acse.ottn.animator.c;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.acse.ottn.animator.a.AbstractC1361a;
import java.util.WeakHashMap;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final WeakHashMap<View, b> f4976a = new WeakHashMap<>(0);

    public static b a(View view) {
        WeakHashMap<View, b> weakHashMap = f4976a;
        b bVar = weakHashMap.get(view);
        if (bVar == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            bVar = intValue >= 14 ? new f(view) : intValue >= 11 ? new d(view) : new h(view);
            weakHashMap.put(view, bVar);
        }
        return bVar;
    }

    public abstract b a(float f4);

    public abstract b a(long j4);

    public abstract b a(Interpolator interpolator);

    public abstract b a(AbstractC1361a.InterfaceC0082a interfaceC0082a);

    public abstract void a();

    public abstract long b();

    public abstract b b(float f4);

    public abstract b b(long j4);

    public abstract long c();

    public abstract b c(float f4);

    public abstract b d(float f4);

    public abstract void d();

    public abstract b e(float f4);

    public abstract b f(float f4);

    public abstract b g(float f4);

    public abstract b h(float f4);

    public abstract b i(float f4);

    public abstract b j(float f4);

    public abstract b k(float f4);

    public abstract b l(float f4);

    public abstract b m(float f4);

    public abstract b n(float f4);

    public abstract b o(float f4);

    public abstract b p(float f4);

    public abstract b q(float f4);

    public abstract b r(float f4);

    public abstract b s(float f4);

    public abstract b t(float f4);
}
