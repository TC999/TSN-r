package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UTDIdTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53643a = "utdid";

    /* renamed from: b  reason: collision with root package name */
    private Context f53644b;

    public j(Context context) {
        super("utdid");
        this.f53644b = context;
    }

    private String g() {
        try {
            return this.f53644b.getSharedPreferences("Alvin2", 0).getString("UTDID2", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String h() {
        try {
            return this.f53644b.getSharedPreferences("um_push_ut", 0).getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow("header_tracking_utdid")) {
                String h4 = h();
                return TextUtils.isEmpty(h4) ? g() : h4;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
