package com.bun.miitmdid.provider.huawei;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HWProvider extends BaseProvider {
    private static final String TAG = "SDK call Huawei: ";
    private Context context;

    public HWProvider(Context context) {
        this.context = context;
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.m20485rL(new Object[]{this, 61, 1606976968533L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.m20485rL(new Object[]{this, 62, 1606976968534L})).booleanValue();
    }
}
