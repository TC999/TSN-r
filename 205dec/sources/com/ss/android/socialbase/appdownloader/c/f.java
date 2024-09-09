package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.Intent;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f extends c {
    public f(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.ux
    public Intent w() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
