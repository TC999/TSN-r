package com.bun.miitmdid.provider.oppo;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;
import p000XI.p005XI.p006K0.C0012XI;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OppoProvider extends BaseProvider {
    private static final String TAG = "SDK call Oppo: ";
    private Context context;

    public OppoProvider(Context context) {
        C0012XI.m60061xo(context);
        this.context = context;
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.m20485rL(new Object[]{this, 83, 1606976968555L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.m20485rL(new Object[]{this, 84, 1606976968556L})).booleanValue();
    }
}
