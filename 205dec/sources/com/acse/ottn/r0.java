package com.acse.ottn;

import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public static r0 f6195a;

    public static r0 a() {
        if (f6195a == null) {
            synchronized (r0.class) {
                if (f6195a == null) {
                    f6195a = new r0();
                }
            }
        }
        return f6195a;
    }

    public final Object b() throws ObjectStreamException {
        return f6195a;
    }
}
