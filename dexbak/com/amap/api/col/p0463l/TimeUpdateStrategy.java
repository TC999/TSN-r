package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.amap.api.col.3l.u7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TimeUpdateStrategy extends UpdateStrategy {

    /* renamed from: b */
    protected int f5517b;

    /* renamed from: c */
    protected long f5518c;

    /* renamed from: d */
    private String f5519d;

    /* renamed from: e */
    private Context f5520e;

    public TimeUpdateStrategy(Context context, int i, String str, UpdateStrategy updateStrategy) {
        super(updateStrategy);
        this.f5517b = i;
        this.f5519d = str;
        this.f5520e = context;
    }

    @Override // com.amap.api.col.p0463l.UpdateStrategy
    /* renamed from: c */
    public final void mo53644c(boolean z) {
        super.mo53644c(z);
        if (z) {
            String str = this.f5519d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f5518c = currentTimeMillis;
            Log.m54111d(this.f5520e, str, String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.amap.api.col.p0463l.UpdateStrategy
    /* renamed from: d */
    protected final boolean mo53576d() {
        if (this.f5518c == 0) {
            String m54114a = Log.m54114a(this.f5520e, this.f5519d);
            this.f5518c = TextUtils.isEmpty(m54114a) ? 0L : Long.parseLong(m54114a);
        }
        return System.currentTimeMillis() - this.f5518c >= ((long) this.f5517b);
    }
}
