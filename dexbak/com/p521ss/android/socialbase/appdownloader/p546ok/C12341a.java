package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 26)
/* renamed from: com.ss.android.socialbase.appdownloader.ok.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12341a extends AbstractC12348ok {
    public C12341a(Context context) {
        super(context, null, null);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p546ok.InterfaceC12347n
    /* renamed from: a */
    public Intent mo18106a() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f34810ok.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
