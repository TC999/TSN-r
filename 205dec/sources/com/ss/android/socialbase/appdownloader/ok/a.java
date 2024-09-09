package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 26)
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends ok {
    public a(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.ok.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
