package com.p521ss.android.downloadad.api;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import com.p521ss.android.download.api.config.IDownloadButtonClickListener;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.download.DownloadStatusChangeListener;

/* renamed from: com.ss.android.downloadad.api.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC11996a {
    /* renamed from: ok */
    Dialog mo19416ok(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i);

    /* renamed from: ok */
    Dialog mo19415ok(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener);

    /* renamed from: ok */
    boolean mo19422ok(long j);

    /* renamed from: ok */
    boolean mo19421ok(long j, int i);

    /* renamed from: ok */
    boolean mo19419ok(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i);

    /* renamed from: ok */
    boolean mo19418ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController);

    /* renamed from: ok */
    boolean mo19417ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener);
}
