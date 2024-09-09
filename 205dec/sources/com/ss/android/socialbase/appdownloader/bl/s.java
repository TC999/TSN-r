package com.ss.android.socialbase.appdownloader.bl;

import android.content.Context;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface s {
    void ok(int i4, int i5, String str, int i6, long j4);

    void ok(int i4, int i5, String str, String str2, String str3);

    void ok(Context context, String str);

    void ok(DownloadInfo downloadInfo);

    boolean ok();

    boolean ok(int i4, boolean z3);
}
