package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.content.Intent;
import com.p521ss.android.socialbase.downloader.constants.C12415n;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12343h extends AbstractC12348ok {
    public C12343h(Context context, C12534ok c12534ok, String str) {
        super(context, c12534ok, str);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p546ok.InterfaceC12347n
    /* renamed from: a */
    public Intent mo18106a() {
        Intent intent = new Intent(C12415n.f34986bl + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.f34809bl);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
