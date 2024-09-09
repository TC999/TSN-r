package com.bun.miitmdid.interfaces;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface InnerIdProvider extends IdSupplier {
    boolean isSync();

    void shutDown();

    void startAction(IIdentifierListener iIdentifierListener);
}
