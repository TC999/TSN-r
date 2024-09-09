package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface h {
    h a(int i4, DownloadStatusChangeListener downloadStatusChangeListener);

    h a(Context context);

    h a(DownloadController downloadController);

    h a(DownloadEventConfig downloadEventConfig);

    h a(DownloadModel downloadModel);

    void a(int i4);

    boolean a();

    h ok(long j4);

    h ok(IDownloadButtonClickListener iDownloadButtonClickListener);

    h ok(OnItemClickListener onItemClickListener);

    h ok(String str);

    void ok();

    void ok(boolean z3);

    boolean ok(int i4);

    void p();

    long s();
}
