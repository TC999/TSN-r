package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.content.Intent;
import com.p521ss.android.socialbase.downloader.constants.C12415n;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12349p extends AbstractC12348ok {
    public C12349p(Context context, C12534ok c12534ok, String str) {
        super(context, c12534ok, str);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p546ok.InterfaceC12347n
    /* renamed from: a */
    public Intent mo18106a() {
        Intent intent = new Intent(C12415n.f34986bl + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.f34809bl);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
