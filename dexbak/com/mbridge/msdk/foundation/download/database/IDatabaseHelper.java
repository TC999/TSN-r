package com.mbridge.msdk.foundation.download.database;

import android.database.Cursor;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IDatabaseHelper {
    public static final String TAG = "DatabaseHelper";

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface IDatabaseListener {
        void onDatabase(DownloadModel downloadModel);
    }

    void clear();

    void find(String str, String str2, IDatabaseListener iDatabaseListener);

    List<DownloadModel> findAll();

    void findByDownloadUrl(String str, IDatabaseListener iDatabaseListener);

    List<DownloadModel> getUnwantedModels(long j);

    void insert(DownloadModel downloadModel);

    Cursor rawQuery(String str, String[] strArr);

    void remove(String str);

    void remove(String str, String str2);

    void update(DownloadModel downloadModel, String str);

    void updateProgress(String str, String str2, DownloadModel downloadModel);

    void updateUnzipResource(String str, String str2, long j);
}
