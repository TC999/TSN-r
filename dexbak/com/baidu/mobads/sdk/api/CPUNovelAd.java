package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.C2684db;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CPUNovelAd {
    private C2684db mCpuNovelProd;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        C2684db c2684db = new C2684db(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = c2684db;
        c2684db.m50566a(cpuNovelListener);
        this.mCpuNovelProd.mo50356a();
    }

    public void destory() {
        C2684db c2684db = this.mCpuNovelProd;
        if (c2684db != null) {
            c2684db.m50555y();
        }
    }

    public View getNovelView() {
        return this.mCpuNovelProd.mo50557w();
    }
}
