package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.Intent;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev extends c {
    public ev(Context context, com.ss.android.socialbase.downloader.r.c cVar, String str) {
        super(context, cVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.ux
    public Intent w() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.constants.ux.xv + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.xv);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
