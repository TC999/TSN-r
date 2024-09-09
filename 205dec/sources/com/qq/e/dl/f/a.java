package com.qq.e.dl.f;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.qq.e.dl.f.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a extends h.a {

    /* renamed from: b  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, Float> f46826b = new C0913a(this, Float.class, "alpha");

    /* compiled from: A */
    /* renamed from: com.qq.e.dl.f.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0913a extends Property<com.qq.e.dl.l.h, Float> {
        C0913a(a aVar, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            hVar.a(f4.floatValue());
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            View m4 = hVar.m();
            return Float.valueOf(m4 == null ? 1.0f : m4.getAlpha());
        }
    }

    @Override // com.qq.e.dl.f.h.a
    PropertyValuesHolder[] a(com.qq.e.dl.i.a aVar) {
        if (aVar.f46910c.length() < 2) {
            return null;
        }
        double d4 = -1;
        float optDouble = (float) aVar.f46910c.optDouble(0, d4);
        if (optDouble > 1.0f || optDouble < 0.0f) {
            return null;
        }
        float optDouble2 = (float) aVar.f46910c.optDouble(1, d4);
        if (optDouble2 > 1.0f || optDouble2 < 0.0f) {
            return null;
        }
        return new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(this.f46826b, optDouble, optDouble2)};
    }
}
