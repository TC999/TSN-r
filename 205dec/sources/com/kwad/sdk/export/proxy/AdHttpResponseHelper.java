package com.kwad.sdk.export.proxy;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdHttpResponseHelper {
    public static void notifyResponseEnd(@Nullable final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.2
            @Override // java.lang.Runnable
            public final void run() {
                AdHttpResponseListener.this.onResponseEnd();
            }
        });
    }

    public static boolean notifyResponseProgress(@Nullable AdHttpResponseListener adHttpResponseListener, long j4, long j5) {
        if (adHttpResponseListener == null) {
            return false;
        }
        return adHttpResponseListener.onReadProgress(j4, j5);
    }

    public static void notifyResponseStart(@Nullable final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.1
            @Override // java.lang.Runnable
            public final void run() {
                AdHttpResponseListener.this.onResponseStart();
            }
        });
    }
}
