package com.ss.android.socialbase.downloader.impls;

import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.ss.android.socialbase.downloader.downloader.zz;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class k implements zz {
    @Override // com.ss.android.socialbase.downloader.downloader.zz
    public long ok(int i4, int i5) {
        if (i4 == 1) {
            return 3000L;
        }
        if (i4 == 2) {
            return 15000L;
        }
        return i4 == 3 ? PolicyConfig.mServerBusyRetryBaseInternal : i4 > 3 ? 300000L : 0L;
    }
}
