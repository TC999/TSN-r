package com.acse.ottn.util;

import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class W {

    /* renamed from: a  reason: collision with root package name */
    private static W f6791a;

    private W() {
    }

    public static W a() {
        if (f6791a == null) {
            synchronized (W.class) {
                if (f6791a == null) {
                    f6791a = new W();
                }
            }
        }
        return f6791a;
    }

    private Object b() throws ObjectStreamException {
        return f6791a;
    }
}
