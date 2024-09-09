package com.ss.android.socialbase.appdownloader.f.c;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {
    public static final void c(sr srVar, int i4) throws IOException {
        int w3 = srVar.w();
        if (w3 == i4) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i4) + ", read 0x" + Integer.toHexString(w3) + ".");
    }
}
