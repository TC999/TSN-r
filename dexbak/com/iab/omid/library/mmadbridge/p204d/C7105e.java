package com.iab.omid.library.mmadbridge.p204d;

import android.text.TextUtils;
import com.iab.omid.library.mmadbridge.C7073a;
import com.iab.omid.library.mmadbridge.adsession.C7081h;
import com.iab.omid.library.mmadbridge.adsession.CreativeType;
import com.iab.omid.library.mmadbridge.adsession.ImpressionType;
import com.iab.omid.library.mmadbridge.adsession.Owner;

/* renamed from: com.iab.omid.library.mmadbridge.d.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7105e {
    /* renamed from: a */
    public static void m34674a() {
        if (!C7073a.m34840c()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    /* renamed from: b */
    public static void m34673b(Owner owner, CreativeType creativeType, ImpressionType impressionType) {
        if (owner == Owner.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (creativeType == CreativeType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (impressionType == ImpressionType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    /* renamed from: c */
    public static void m34672c(C7081h c7081h) {
        if (c7081h.m34783y()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: d */
    public static void m34671d(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: e */
    public static void m34670e(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: f */
    public static void m34669f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: g */
    public static void m34668g(C7081h c7081h) {
        if (c7081h.m34782z()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: h */
    public static void m34667h(C7081h c7081h) {
        m34662m(c7081h);
        m34668g(c7081h);
    }

    /* renamed from: i */
    public static void m34666i(C7081h c7081h) {
        if (c7081h.mo34802f().m34637q() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    /* renamed from: j */
    public static void m34665j(C7081h c7081h) {
        if (c7081h.mo34802f().m34636r() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    /* renamed from: k */
    public static void m34664k(C7081h c7081h) {
        if (!c7081h.m34810A()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    /* renamed from: l */
    public static void m34663l(C7081h c7081h) {
        if (!c7081h.m34809B()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    /* renamed from: m */
    private static void m34662m(C7081h c7081h) {
        if (!c7081h.m34783y()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
