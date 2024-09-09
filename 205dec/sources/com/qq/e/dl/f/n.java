package com.qq.e.dl.f;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.qq.e.dl.f.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class n extends h.a {

    /* renamed from: c  reason: collision with root package name */
    static final Property<com.qq.e.dl.l.h, Float> f46875c = new a(Float.class, "rotation");

    /* renamed from: d  reason: collision with root package name */
    static final Property<com.qq.e.dl.l.h, Float> f46876d = new b(Float.class, "rotationX");

    /* renamed from: e  reason: collision with root package name */
    static final Property<com.qq.e.dl.l.h, Float> f46877e = new c(Float.class, "rotationY");

    /* renamed from: b  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, Float> f46878b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a extends Property<com.qq.e.dl.l.h, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            hVar.b(f4.floatValue());
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            View m4 = hVar.m();
            return Float.valueOf(m4 == null ? 0.0f : m4.getRotation());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Property<com.qq.e.dl.l.h, Float> property) {
        this.f46878b = property;
    }

    @Override // com.qq.e.dl.f.h.a
    PropertyValuesHolder[] a(com.qq.e.dl.i.a aVar) {
        if (aVar.f46910c.length() < 2) {
            return null;
        }
        return new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(this.f46878b, aVar.f46910c.optInt(0), aVar.f46910c.optInt(1))};
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b extends Property<com.qq.e.dl.l.h, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            View m4 = hVar.m();
            return Float.valueOf(m4 == null ? 0.0f : m4.getRotationX());
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            hVar.c(f4.floatValue());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class c extends Property<com.qq.e.dl.l.h, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            View m4 = hVar.m();
            return Float.valueOf(m4 == null ? 0.0f : m4.getRotationY());
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            hVar.d(f4.floatValue());
        }
    }
}
