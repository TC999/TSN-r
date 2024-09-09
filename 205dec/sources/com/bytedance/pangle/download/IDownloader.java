package com.bytedance.pangle.download;

import android.content.Context;
import androidx.annotation.Keep;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IDownloader {
    void downloader(Context context, String str, String str2, boolean z3, String str3, int i4, String str4, List<String> list, IZeusDownloadListener iZeusDownloadListener, IZeusDownloadInterceptor iZeusDownloadInterceptor);
}
