package xyz.adscope.ad.tool.download;

import android.content.Context;
import xyz.adscope.ad.tool.download.service.AppDownloadService;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DownloadManager {
    public void startDownload(Context context, String str) {
        AppDownloadService.getInstance(context).download(str);
    }
}
