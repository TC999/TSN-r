package com.p521ss.android.downloadlib.p533bl;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.appdownloader.p543kf.p544ok.C12323n;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.umeng.analytics.pro.C13131bm;
import java.io.File;

/* renamed from: com.ss.android.downloadlib.bl.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12174ok implements InterfaceC12484z {
    /* renamed from: bl */
    private boolean m18859bl(DownloadInfo downloadInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(downloadInfo.getSavePath());
        String str = File.separator;
        sb.append(str);
        sb.append(downloadInfo.getName());
        String sb2 = sb.toString();
        File file = new File(sb2);
        String m18207ok = C12323n.m18207ok(C12128r.getContext(), C12293bl.m18412ok(downloadInfo, file), sb2);
        boolean z = false;
        if (!TextUtils.isEmpty(m18207ok)) {
            String str2 = m18207ok + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                z = file.renameTo(new File(downloadInfo.getSavePath() + str + str2));
                if (z) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z
    /* renamed from: a */
    public boolean mo16628a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return C12201n.m18749a(C12534ok.m17599ok(downloadInfo.getId()));
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z
    /* renamed from: ok */
    public void mo16627ok(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !m18859bl(downloadInfo)) {
            return;
        }
        m18858ok(C12128r.getContext(), downloadInfo);
    }

    /* renamed from: ok */
    private void m18858ok(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{C13131bm.f37927d}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), query.getInt(query.getColumnIndex(C13131bm.f37927d))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.bl.ok.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        C12490bl.m17806m().mo17488ok(downloadInfo);
                    }
                }
            });
        }
        C12713kf.m16532ok(query);
    }
}
