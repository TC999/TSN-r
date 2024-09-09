package com.mbridge.msdk.foundation.download.download;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DownLoadUtils {
    private static final int DOWNLOAD_CONNECTION_TIME_OUT = 20000;
    private static final int DOWNLOAD_READ_TIME_OUT = 30000;
    public static final String END_TAG = "<mbridgeloadend></mbridgeloadend>";
    private static final String TAG = "DownLoadUtils";

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
        r3.onFailed("url is error");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void getSourceCodeFromNetUrl(final java.lang.String r2, final com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source r3, final boolean r4) {
        /*
            boolean r0 = com.mbridge.msdk.foundation.tools.ag.a(r2)     // Catch: java.lang.Throwable -> L22
            if (r0 != 0) goto L1a
            boolean r0 = android.webkit.URLUtil.isNetworkUrl(r2)     // Catch: java.lang.Throwable -> L22
            if (r0 != 0) goto Ld
            goto L1a
        Ld:
            com.mbridge.msdk.foundation.download.download.DownloadTask r0 = com.mbridge.msdk.foundation.download.download.DownloadTask.getInstance()     // Catch: java.lang.Throwable -> L22
            com.mbridge.msdk.foundation.download.download.DownLoadUtils$1 r1 = new com.mbridge.msdk.foundation.download.download.DownLoadUtils$1     // Catch: java.lang.Throwable -> L22
            r1.<init>()     // Catch: java.lang.Throwable -> L22
            r0.runTask(r1)     // Catch: java.lang.Throwable -> L22
            goto L2a
        L1a:
            if (r3 == 0) goto L21
            java.lang.String r2 = "url is error"
            r3.onFailed(r2)     // Catch: java.lang.Throwable -> L22
        L21:
            return
        L22:
            r2 = move-exception
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L2a
            r2.printStackTrace()
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.download.DownLoadUtils.getSourceCodeFromNetUrl(java.lang.String, com.mbridge.msdk.foundation.download.download.H5DownLoadManager$IOnDownLoadH5Source, boolean):void");
    }
}
