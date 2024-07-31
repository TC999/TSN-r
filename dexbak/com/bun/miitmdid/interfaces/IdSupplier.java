package com.bun.miitmdid.interfaces;

import androidx.annotation.Keep;

@Keep
/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
