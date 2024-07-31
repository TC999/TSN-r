package com.bun.miitmdid.provider.xiaomi;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class XMProvider extends BaseProvider {
    private static final String TAG = "SDK call Xiaomi: ";
    private Context mCxt;

    public XMProvider(Context context) {
        this.mCxt = context;
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.m20485rL(new Object[]{this, 105, 1606976968577L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.m20485rL(new Object[]{this, 106, 1606976968578L})).booleanValue();
    }
}
