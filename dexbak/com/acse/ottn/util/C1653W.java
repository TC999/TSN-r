package com.acse.ottn.util;

import java.io.ObjectStreamException;

/* renamed from: com.acse.ottn.util.W */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1653W {

    /* renamed from: a */
    private static C1653W f3281a;

    private C1653W() {
    }

    /* renamed from: a */
    public static C1653W m56120a() {
        if (f3281a == null) {
            synchronized (C1653W.class) {
                if (f3281a == null) {
                    f3281a = new C1653W();
                }
            }
        }
        return f3281a;
    }

    /* renamed from: b */
    private Object m56119b() throws ObjectStreamException {
        return f3281a;
    }
}
