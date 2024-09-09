package com.bun.miitmdid.interfaces;

import androidx.annotation.Keep;

@Keep
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface IdSupplier {
    @Keep
    String getAAID();

    @Keep
    String getOAID();

    @Keep
    String getVAID();

    @Keep
    boolean isSupported();
}
