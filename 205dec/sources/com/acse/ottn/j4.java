package com.acse.ottn;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.acse.ottn.i;
import java.util.WeakHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class j4 {

    /* renamed from: a  reason: collision with root package name */
    public static final WeakHashMap<View, j4> f5788a = new WeakHashMap<>(0);

    public static j4 a(View view) {
        WeakHashMap<View, j4> weakHashMap = f5788a;
        j4 j4Var = weakHashMap.get(view);
        if (j4Var == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            if (intValue >= 14) {
                j4Var = new l4(view);
            } else if (intValue >= 11) {
                j4Var = new k4(view);
            } else {
                j4Var = new m4(view);
            }
            weakHashMap.put(view, j4Var);
        }
        return j4Var;
    }

    public abstract j4 a(float f4);

    public abstract j4 a(long j4);

    public abstract j4 a(Interpolator interpolator);

    public abstract j4 a(i.a aVar);

    public abstract void a();

    public abstract long b();

    public abstract j4 b(float f4);

    public abstract j4 b(long j4);

    public abstract long c();

    public abstract j4 c(float f4);

    public abstract j4 d(float f4);

    public abstract void d();

    public abstract j4 e(float f4);

    public abstract j4 f(float f4);

    public abstract j4 g(float f4);

    public abstract j4 h(float f4);

    public abstract j4 i(float f4);

    public abstract j4 j(float f4);

    public abstract j4 k(float f4);

    public abstract j4 l(float f4);

    public abstract j4 m(float f4);

    public abstract j4 n(float f4);

    public abstract j4 o(float f4);

    public abstract j4 p(float f4);

    public abstract j4 q(float f4);

    public abstract j4 r(float f4);

    public abstract j4 s(float f4);

    public abstract j4 t(float f4);
}
