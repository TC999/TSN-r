package com.yalantis.ucrop.util;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* compiled from: FileUtils.java */
/* renamed from: com.yalantis.ucrop.util.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13526e {

    /* renamed from: a */
    private static final String f39881a = "FileUtils";

    private C13526e() {
    }

    /* renamed from: a */
    public static void m13003a(@NonNull String str, @NonNull String str2) throws IOException {
        FileChannel fileChannel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(new File(str)).getChannel();
            try {
                fileChannel2 = new FileOutputStream(new File(str2)).getChannel();
                channel.transferTo(0L, channel.size(), fileChannel2);
                channel.close();
                channel.close();
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel3 = fileChannel2;
                fileChannel2 = channel;
                fileChannel = fileChannel3;
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r10 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r10 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m13002b(android.content.Context r10, android.net.Uri r11, java.lang.String r12, java.lang.String[] r13) {
        /*
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r7 = 0
            java.lang.String r8 = "_data"
            r3[r7] = r8
            r9 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33
            r6 = 0
            r2 = r11
            r4 = r12
            r5 = r13
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33
            if (r10 == 0) goto L2b
            boolean r11 = r10.moveToFirst()     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L50
            if (r11 == 0) goto L2b
            int r11 = r10.getColumnIndexOrThrow(r8)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L50
            java.lang.String r11 = r10.getString(r11)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L50
            r10.close()
            return r11
        L29:
            r11 = move-exception
            goto L35
        L2b:
            if (r10 == 0) goto L4f
        L2d:
            r10.close()
            goto L4f
        L31:
            r11 = move-exception
            goto L52
        L33:
            r11 = move-exception
            r10 = r9
        L35:
            java.lang.String r12 = "FileUtils"
            java.util.Locale r13 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = "getDataColumn: _data - [%s]"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L50
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> L50
            r0[r7] = r11     // Catch: java.lang.Throwable -> L50
            java.lang.String r11 = java.lang.String.format(r13, r1, r0)     // Catch: java.lang.Throwable -> L50
            android.util.Log.i(r12, r11)     // Catch: java.lang.Throwable -> L50
            if (r10 == 0) goto L4f
            goto L2d
        L4f:
            return r9
        L50:
            r11 = move-exception
            r9 = r10
        L52:
            if (r9 == 0) goto L57
            r9.close()
        L57:
            goto L59
        L58:
            throw r11
        L59:
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.C13526e.m13002b(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public static String m13001c(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (m12999e(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (m13000d(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return m13002b(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (NumberFormatException e) {
                        Log.i(f39881a, e.getMessage());
                        return null;
                    }
                }
            } else if (m12997g(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if (SocializeProtocolConstants.IMAGE.equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return m13002b(context, uri2, "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (m12998f(uri)) {
                return uri.getLastPathSegment();
            }
            return m13002b(context, uri, null, null);
        } else if (IDataSource.f43973c.equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    /* renamed from: d */
    public static boolean m13000d(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /* renamed from: e */
    public static boolean m12999e(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /* renamed from: f */
    public static boolean m12998f(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* renamed from: g */
    public static boolean m12997g(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
