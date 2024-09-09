package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.Intent;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class r extends c {
    public r(Context context, com.ss.android.socialbase.downloader.r.c cVar, String str) {
        super(context, cVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.ux
    public Intent w() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.constants.ux.xv + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.xv);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
