package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.Intent;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class p extends c {
    public p(Context context, com.ss.android.socialbase.downloader.r.c cVar, String str) {
        super(context, cVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.ux
    public Intent w() {
        Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
        intent.putExtra("FilePathToBeOpenAfterScan", this.xv);
        intent.putExtra("com.iqoo.secure", true);
        intent.putExtra("OpenParentAndLocationDestFile", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
