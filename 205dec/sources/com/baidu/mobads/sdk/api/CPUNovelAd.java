package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.de;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CPUNovelAd {
    private de mCpuNovelProd;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j4);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        de deVar = new de(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = deVar;
        deVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public void destory() {
        de deVar = this.mCpuNovelProd;
        if (deVar != null) {
            deVar.y();
        }
    }

    public View getNovelView() {
        return this.mCpuNovelProd.w();
    }
}
