package com.umeng.analytics.filter;

import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;

/* renamed from: com.umeng.analytics.filter.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class KeyFilter implements UMImprintChangeCallback, UMImprintPreProcessCallback {
    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
    }

    public boolean onPreProcessImprintKey(String str, String str2) {
        return false;
    }
}
