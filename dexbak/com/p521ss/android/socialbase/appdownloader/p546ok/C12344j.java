package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.content.Intent;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12315bl;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12344j extends AbstractC12348ok {
    public C12344j(Context context, C12534ok c12534ok, String str) {
        super(context, c12534ok, str);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p546ok.InterfaceC12347n
    /* renamed from: a */
    public Intent mo18106a() {
        String m17603bl = this.f34808a.m17603bl("s");
        String m18260ok = C12315bl.m18260ok(this.f34808a.m17603bl("ag"), m17603bl);
        String m18260ok2 = C12315bl.m18260ok(this.f34808a.m17603bl("ah"), m17603bl);
        String m18260ok3 = C12315bl.m18260ok(this.f34808a.m17603bl("ai"), m17603bl);
        String m18260ok4 = C12315bl.m18260ok(this.f34808a.m17603bl("aj"), m17603bl);
        Intent intent = new Intent();
        intent.putExtra(m18260ok, this.f34809bl);
        intent.putExtra(m18260ok2, "*/*");
        intent.putExtra(m18260ok3, true);
        intent.setAction(m18260ok4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
