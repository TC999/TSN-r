package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf extends ok {
    public kf(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
