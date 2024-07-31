package com.acse.ottn.animator.p033c;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.acse.ottn.animator.p031a.AbstractC1334a;
import java.util.WeakHashMap;

/* renamed from: com.acse.ottn.animator.c.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1379b {

    /* renamed from: a */
    private static final WeakHashMap<View, AbstractC1379b> f2434a = new WeakHashMap<>(0);

    /* renamed from: a */
    public static AbstractC1379b m56911a(View view) {
        WeakHashMap<View, AbstractC1379b> weakHashMap = f2434a;
        AbstractC1379b abstractC1379b = weakHashMap.get(view);
        if (abstractC1379b == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            abstractC1379b = intValue >= 14 ? new C1386f(view) : intValue >= 11 ? new C1381d(view) : new C1388h(view);
            weakHashMap.put(view, abstractC1379b);
        }
        return abstractC1379b;
    }

    /* renamed from: a */
    public abstract AbstractC1379b mo56896a(float f);

    /* renamed from: a */
    public abstract AbstractC1379b mo56892a(long j);

    /* renamed from: a */
    public abstract AbstractC1379b mo56891a(Interpolator interpolator);

    /* renamed from: a */
    public abstract AbstractC1379b mo56890a(AbstractC1334a.InterfaceC1335a interfaceC1335a);

    /* renamed from: a */
    public abstract void mo56897a();

    /* renamed from: b */
    public abstract long mo56886b();

    /* renamed from: b */
    public abstract AbstractC1379b mo56885b(float f);

    /* renamed from: b */
    public abstract AbstractC1379b mo56883b(long j);

    /* renamed from: c */
    public abstract long mo56881c();

    /* renamed from: c */
    public abstract AbstractC1379b mo56880c(float f);

    /* renamed from: d */
    public abstract AbstractC1379b mo56876d(float f);

    /* renamed from: d */
    public abstract void mo56877d();

    /* renamed from: e */
    public abstract AbstractC1379b mo56873e(float f);

    /* renamed from: f */
    public abstract AbstractC1379b mo56872f(float f);

    /* renamed from: g */
    public abstract AbstractC1379b mo56871g(float f);

    /* renamed from: h */
    public abstract AbstractC1379b mo56870h(float f);

    /* renamed from: i */
    public abstract AbstractC1379b mo56869i(float f);

    /* renamed from: j */
    public abstract AbstractC1379b mo56868j(float f);

    /* renamed from: k */
    public abstract AbstractC1379b mo56867k(float f);

    /* renamed from: l */
    public abstract AbstractC1379b mo56866l(float f);

    /* renamed from: m */
    public abstract AbstractC1379b mo56865m(float f);

    /* renamed from: n */
    public abstract AbstractC1379b mo56864n(float f);

    /* renamed from: o */
    public abstract AbstractC1379b mo56863o(float f);

    /* renamed from: p */
    public abstract AbstractC1379b mo56862p(float f);

    /* renamed from: q */
    public abstract AbstractC1379b mo56861q(float f);

    /* renamed from: r */
    public abstract AbstractC1379b mo56860r(float f);

    /* renamed from: s */
    public abstract AbstractC1379b mo56859s(float f);

    /* renamed from: t */
    public abstract AbstractC1379b mo56858t(float f);
}
