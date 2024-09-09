package com.iab.omid.library.mmadbridge.d;

import android.text.TextUtils;
import com.iab.omid.library.mmadbridge.adsession.CreativeType;
import com.iab.omid.library.mmadbridge.adsession.ImpressionType;
import com.iab.omid.library.mmadbridge.adsession.Owner;
import com.iab.omid.library.mmadbridge.adsession.h;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e {
    public static void a() {
        if (!com.iab.omid.library.mmadbridge.a.c()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    public static void b(Owner owner, CreativeType creativeType, ImpressionType impressionType) {
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

    public static void c(h hVar) {
        if (hVar.y()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void e(String str, int i4, String str2) {
        if (str.length() > i4) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void g(h hVar) {
        if (hVar.z()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void h(h hVar) {
        m(hVar);
        g(hVar);
    }

    public static void i(h hVar) {
        if (hVar.f().q() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    public static void j(h hVar) {
        if (hVar.f().r() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    public static void k(h hVar) {
        if (!hVar.A()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    public static void l(h hVar) {
        if (!hVar.B()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    private static void m(h hVar) {
        if (!hVar.y()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
