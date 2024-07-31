package com.baidu.mobads.sdk.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.C2607aw;

/* renamed from: com.baidu.mobads.sdk.internal.at */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2604at extends C2607aw.AbstractC2608a {

    /* renamed from: a */
    public static final String f8613a = "debug";

    @Override // com.baidu.mobads.sdk.internal.C2607aw.AbstractC2608a
    @NonNull
    /* renamed from: a */
    String mo50887a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.C2607aw.AbstractC2608a
    /* renamed from: a */
    protected boolean mo50894a(String str, int i) {
        return C2607aw.f8630a.equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.C2607aw.AbstractC2608a
    /* renamed from: a */
    protected void mo50885a(int i, String str, String str2, Throwable th) {
        m50941a(i, str, str2);
    }

    /* renamed from: a */
    private static void m50941a(int i, String str, String str2) {
        try {
            if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
