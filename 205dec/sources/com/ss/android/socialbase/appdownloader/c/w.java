package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 26)
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w extends c {
    public w(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.ux
    public Intent w() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f49037c.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
