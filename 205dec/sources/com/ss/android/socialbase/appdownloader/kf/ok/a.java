package com.ss.android.socialbase.appdownloader.kf.ok;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public static final void ok(s sVar, int i4) throws IOException {
        int a4 = sVar.a();
        if (a4 == i4) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i4) + ", read 0x" + Integer.toHexString(a4) + ".");
    }
}
