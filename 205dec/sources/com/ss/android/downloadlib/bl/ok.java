package com.ss.android.downloadlib.bl;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok implements z {
    private boolean bl(DownloadInfo downloadInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(downloadInfo.getSavePath());
        String str = File.separator;
        sb.append(str);
        sb.append(downloadInfo.getName());
        String sb2 = sb.toString();
        File file = new File(sb2);
        String ok = com.ss.android.socialbase.appdownloader.kf.ok.n.ok(r.getContext(), com.ss.android.socialbase.appdownloader.bl.ok(downloadInfo, file), sb2);
        boolean z3 = false;
        if (!TextUtils.isEmpty(ok)) {
            String str2 = ok + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                z3 = file.renameTo(new File(downloadInfo.getSavePath() + str + str2));
                if (z3) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return z3;
    }

    @Override // com.ss.android.socialbase.downloader.depend.z
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.h.n.a(com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()));
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.z
    public void ok(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !bl(downloadInfo)) {
            return;
        }
        ok(r.getContext(), downloadInfo);
    }

    private void ok(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), query.getInt(query.getColumnIndex("_id"))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.bl.ok.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        com.ss.android.socialbase.downloader.downloader.bl.m().ok(downloadInfo);
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.q.kf.ok(query);
    }
}
