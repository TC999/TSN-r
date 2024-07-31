package com.bun.miitmdid.interfaces;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface InnerIdProvider extends IdSupplier {
    boolean isSync();

    void shutDown();

    void startAction(IIdentifierListener iIdentifierListener);
}
