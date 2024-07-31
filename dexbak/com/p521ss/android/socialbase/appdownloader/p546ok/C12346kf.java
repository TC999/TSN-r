package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12346kf extends AbstractC12348ok {
    public C12346kf(Context context) {
        super(context, null, null);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p546ok.InterfaceC12347n
    /* renamed from: a */
    public Intent mo18106a() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
