package com.bytedance.adsdk.w.w.sr;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p0.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum xv implements a {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION(TTPathConst.sSeparator, 4),
    MOD("%", 4);
    
    private final int fz;

    /* renamed from: s  reason: collision with root package name */
    private final String f26447s;
    private static final Map<String, xv> fp = new HashMap(128);
    private static final Set<xv> ia = new HashSet();

    static {
        xv[] values;
        for (xv xvVar : values()) {
            fp.put(xvVar.c(), xvVar);
            ia.add(xvVar);
        }
    }

    xv(String str, int i4) {
        this.f26447s = str;
        this.fz = i4;
    }

    public static xv c(String str) {
        return fp.get(str);
    }

    public int w() {
        return this.fz;
    }

    public static boolean c(a aVar) {
        return aVar instanceof xv;
    }

    public String c() {
        return this.f26447s;
    }
}
