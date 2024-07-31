package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.amap.api.col.3l.s7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MobileUpdateStrategy extends UpdateStrategy {

    /* renamed from: c */
    private Context f5292c;

    /* renamed from: d */
    private boolean f5293d;

    /* renamed from: e */
    private int f5294e;

    /* renamed from: f */
    private int f5295f;

    /* renamed from: b */
    private String f5291b = "iKey";

    /* renamed from: g */
    private int f5296g = 0;

    public MobileUpdateStrategy(Context context, boolean z, int i, int i2, String str) {
        m53926f(context, z, i, i2, str, 0);
    }

    /* renamed from: f */
    private void m53926f(Context context, boolean z, int i, int i2, String str, int i3) {
        this.f5292c = context;
        this.f5293d = z;
        this.f5294e = i;
        this.f5295f = i2;
        this.f5291b = str;
        this.f5296g = i3;
    }

    @Override // com.amap.api.col.p0463l.UpdateStrategy
    /* renamed from: a */
    public final int mo53646a() {
        int i;
        int i2 = Integer.MAX_VALUE;
        if ((DeviceInfo.m54809M(this.f5292c) != 1 && (i = this.f5294e) > 0) || ((i = this.f5296g) > 0 && i < Integer.MAX_VALUE)) {
            i2 = i;
        }
        UpdateStrategy updateStrategy = this.f5568a;
        return updateStrategy != null ? Math.max(i2, updateStrategy.mo53646a()) : i2;
    }

    @Override // com.amap.api.col.p0463l.UpdateStrategy
    /* renamed from: b */
    public final void mo53645b(int i) {
        if (DeviceInfo.m54809M(this.f5292c) == 1) {
            return;
        }
        String m54201c = C1925p4.m54201c(System.currentTimeMillis(), "yyyyMMdd");
        String m54114a = Log.m54114a(this.f5292c, this.f5291b);
        if (!TextUtils.isEmpty(m54114a)) {
            String[] split = m54114a.split("\\|");
            if (split != null && split.length >= 2) {
                if (m54201c.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            } else {
                Log.m54108g(this.f5292c, this.f5291b);
            }
        }
        Context context = this.f5292c;
        String str = this.f5291b;
        Log.m54111d(context, str, m54201c + "|" + i);
    }

    @Override // com.amap.api.col.p0463l.UpdateStrategy
    /* renamed from: d */
    protected final boolean mo53576d() {
        if (DeviceInfo.m54809M(this.f5292c) == 1) {
            return true;
        }
        if (this.f5293d) {
            String m54114a = Log.m54114a(this.f5292c, this.f5291b);
            if (TextUtils.isEmpty(m54114a)) {
                return true;
            }
            String[] split = m54114a.split("\\|");
            if (split != null && split.length >= 2) {
                return !C1925p4.m54201c(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f5295f;
            }
            Log.m54108g(this.f5292c, this.f5291b);
            return true;
        }
        return false;
    }

    public MobileUpdateStrategy(Context context, boolean z, int i, int i2, String str, int i3) {
        m53926f(context, z, i, i2, str, i3);
    }
}
