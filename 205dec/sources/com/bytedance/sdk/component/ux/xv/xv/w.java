package com.bytedance.sdk.component.ux.xv.xv;

import java.io.Closeable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }
}
