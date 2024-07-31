package com.kwad.sdk.export.proxy;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.C11064bn;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdHttpResponseHelper {
    public static void notifyResponseEnd(@Nullable final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.2
            @Override // java.lang.Runnable
            public final void run() {
                AdHttpResponseListener.this.onResponseEnd();
            }
        });
    }

    public static boolean notifyResponseProgress(@Nullable AdHttpResponseListener adHttpResponseListener, long j, long j2) {
        if (adHttpResponseListener == null) {
            return false;
        }
        return adHttpResponseListener.onReadProgress(j, j2);
    }

    public static void notifyResponseStart(@Nullable final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.1
            @Override // java.lang.Runnable
            public final void run() {
                AdHttpResponseListener.this.onResponseStart();
            }
        });
    }
}
