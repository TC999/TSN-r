package com.bun.miitmdid.provider;

import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.InnerIdProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class BaseProvider implements InnerIdProvider {
    public IIdentifierListener mcallback;
    public String OAID = "";
    public String VAID = "";
    public String AAID = "";
    public boolean isSupport = false;

    /* renamed from: com.bun.miitmdid.provider.BaseProvider$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProvider.this.doStart();
        }
    }

    public abstract void doStart();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getAAID() {
        return (String) Utils.rL(new Object[]{this, 32, 1606976968504L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getOAID() {
        return (String) Utils.rL(new Object[]{this, 33, 1606976968505L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getVAID() {
        return (String) Utils.rL(new Object[]{this, 34, 1606976968506L});
    }

    @Override // com.bun.miitmdid.interfaces.InnerIdProvider
    public boolean isSync() {
        return ((Boolean) Utils.rL(new Object[]{this, 35, 1606976968507L})).booleanValue();
    }

    public void returnCallResult() {
        Utils.rL(new Object[]{this, 36, 1606976968508L});
    }

    @Override // com.bun.miitmdid.interfaces.InnerIdProvider
    public void shutDown() {
        Utils.rL(new Object[]{this, 37, 1606976968509L});
    }

    @Override // com.bun.miitmdid.interfaces.InnerIdProvider
    public void startAction(IIdentifierListener iIdentifierListener) {
        Utils.rL(new Object[]{this, iIdentifierListener, 38, 1606976968510L});
    }
}
