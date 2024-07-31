package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.content.Intent;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12345k extends AbstractC12348ok {
    public C12345k(Context context, C12534ok c12534ok, String str) {
        super(context, c12534ok, str);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p546ok.InterfaceC12347n
    /* renamed from: a */
    public Intent mo18106a() {
        Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
        intent.putExtra("FilePathToBeOpenAfterScan", this.f34809bl);
        intent.putExtra("com.iqoo.secure", true);
        intent.putExtra("OpenParentAndLocationDestFile", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
