package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.utils.UMConstant;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UTDIdTracker extends AbstractIdTracker {

    /* renamed from: a */
    private static final String f39008a = "utdid";

    /* renamed from: b */
    private Context f39009b;

    public UTDIdTracker(Context context) {
        super(f39008a);
        this.f39009b = context;
    }

    /* renamed from: g */
    private String m13689g() {
        try {
            return this.f39009b.getSharedPreferences("Alvin2", 0).getString("UTDID2", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: h */
    private String m13688h() {
        try {
            return this.f39009b.getSharedPreferences("um_push_ut", 0).getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractIdTracker
    /* renamed from: f */
    public String mo13690f() {
        try {
            if (FieldManager.allow(UMConstant.f39221u)) {
                String m13688h = m13688h();
                return TextUtils.isEmpty(m13688h) ? m13689g() : m13688h;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
