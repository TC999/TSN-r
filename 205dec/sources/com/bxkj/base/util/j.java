package com.bxkj.base.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FileUtil.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class j {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String b(String str) {
        return cn.bluemobi.dylan.base.utils.b.b(d(str));
    }

    public static String c(Context context, Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if ("file".equalsIgnoreCase(scheme)) {
            return uri.getPath();
        }
        if (!"content".equalsIgnoreCase(scheme) || (query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
            str = query.getString(columnIndex);
        }
        query.close();
        return str;
    }

    public static byte[] d(String str) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(str, "r").getChannel();
        } catch (IOException e4) {
            e = e4;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            try {
                fileChannel.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                com.orhanobut.logger.j.c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileChannel.close();
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            e.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            return null;
        }
    }
}
