package com.bytedance.pangle.download;

import androidx.annotation.Keep;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IZeusDownloadListener {
    void onFailed(Throwable th, int i4, String str);

    void onProgress(long j4, long j5);

    void onStart();

    void onSuccess(String str, String str2, long j4);
}
