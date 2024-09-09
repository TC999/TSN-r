package com.qq.e.dl.f;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import com.qq.e.dl.f.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f extends h.a {

    /* renamed from: b  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, Integer> f46836b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends f {

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a extends Property<com.qq.e.dl.l.h, Integer> {
            a(Class cls, String str) {
                super(cls, str);
            }

            @Override // android.util.Property
            /* renamed from: a */
            public void set(com.qq.e.dl.l.h hVar, Integer num) {
                hVar.e(num.intValue());
            }

            @Override // android.util.Property
            /* renamed from: a */
            public Integer get(com.qq.e.dl.l.h hVar) {
                View m4 = hVar.m();
                if (m4 == null) {
                    return 0;
                }
                Drawable background = m4.getBackground();
                if (!(background instanceof ColorDrawable)) {
                    return 0;
                }
                return Integer.valueOf(((ColorDrawable) background).getColor());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
            super(new a(Integer.class, "backgroundColor"));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends f {

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a extends Property<com.qq.e.dl.l.h, Integer> {
            a(Class cls, String str) {
                super(cls, str);
            }

            @Override // android.util.Property
            /* renamed from: a */
            public void set(com.qq.e.dl.l.h hVar, Integer num) {
                hVar.f(num.intValue());
            }

            @Override // android.util.Property
            /* renamed from: a */
            public Integer get(com.qq.e.dl.l.h hVar) {
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            super(new a(Integer.class, "borderColor"));
        }
    }

    @Override // com.qq.e.dl.f.h.a
    PropertyValuesHolder[] a(com.qq.e.dl.i.a aVar) {
        if (aVar.f46910c.length() < 2) {
            return null;
        }
        try {
            String optString = aVar.f46910c.optString(0);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            int parseColor = Color.parseColor(optString);
            try {
                String optString2 = aVar.f46910c.optString(1);
                if (TextUtils.isEmpty(optString2)) {
                    return null;
                }
                PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(this.f46836b, parseColor, Color.parseColor(optString2));
                ofInt.setEvaluator(new ArgbEvaluator());
                return new PropertyValuesHolder[]{ofInt};
            } catch (IllegalArgumentException e4) {
                com.qq.e.dl.j.e.a(this.f46846a, e4.toString());
                return null;
            }
        } catch (IllegalArgumentException e5) {
            com.qq.e.dl.j.e.a(this.f46846a, e5.toString());
            return null;
        }
    }

    private f(Property<com.qq.e.dl.l.h, Integer> property) {
        this.f46836b = property;
    }
}
