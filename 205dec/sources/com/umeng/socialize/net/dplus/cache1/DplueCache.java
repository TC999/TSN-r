package com.umeng.socialize.net.dplus.cache1;

import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DplueCache {
    private static JSONObject a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("content")) != null) {
            return optJSONObject.optJSONObject("share");
        }
        return new JSONObject();
    }

    public static boolean deleteFile(File file) {
        return file.delete();
    }

    public static String getFileName() {
        return "dpluscache";
    }

    public static File getFilePath(String str) {
        if (ContextUtil.getContext() == null) {
            return null;
        }
        String packageName = ContextUtil.getContext().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = File.separator;
        sb.append(str2);
        sb.append("data");
        sb.append(str2);
        sb.append("data");
        sb.append(str2);
        sb.append(packageName);
        sb.append(str2);
        sb.append("files");
        sb.append(str2);
        sb.append(str);
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return null;
        }
        File file = new File(sb2);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readFile(java.io.File r5) {
        /*
            boolean r0 = r5.exists()
            java.lang.String r1 = ""
            if (r0 != 0) goto L9
            return r1
        L9:
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L45
            r2.<init>()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L45
            android.content.Context r3 = com.umeng.socialize.utils.ContextUtil.getContext()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L45
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L45
            java.io.FileInputStream r5 = r3.openFileInput(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L45
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L45
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L45
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L45
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L45
        L25:
            java.lang.String r0 = r5.readLine()     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> L5b
            if (r0 == 0) goto L2f
            r2.append(r0)     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> L5b
            goto L25
        L2f:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> L5b
            r5.close()     // Catch: java.lang.Exception -> L37
            goto L3d
        L37:
            r5 = move-exception
            java.lang.String r1 = com.umeng.socialize.utils.UmengText.CACHE.CACHEFILE
            com.umeng.socialize.utils.SLog.error(r1, r5)
        L3d:
            return r0
        L3e:
            r0 = move-exception
            goto L49
        L40:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L5c
        L45:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
        L49:
            java.lang.String r2 = com.umeng.socialize.utils.UmengText.CACHE.CACHEFILE     // Catch: java.lang.Throwable -> L5b
            com.umeng.socialize.utils.SLog.error(r2, r0)     // Catch: java.lang.Throwable -> L5b
            if (r5 == 0) goto L5a
            r5.close()     // Catch: java.lang.Exception -> L54
            goto L5a
        L54:
            r5 = move-exception
            java.lang.String r0 = com.umeng.socialize.utils.UmengText.CACHE.CACHEFILE
            com.umeng.socialize.utils.SLog.error(r0, r5)
        L5a:
            return r1
        L5b:
            r0 = move-exception
        L5c:
            if (r5 == 0) goto L68
            r5.close()     // Catch: java.lang.Exception -> L62
            goto L68
        L62:
            r5 = move-exception
            java.lang.String r1 = com.umeng.socialize.utils.UmengText.CACHE.CACHEFILE
            com.umeng.socialize.utils.SLog.error(r1, r5)
        L68:
            goto L6a
        L69:
            throw r0
        L6a:
            goto L69
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache1.DplueCache.readFile(java.io.File):java.lang.String");
    }

    public static boolean save(JSONObject jSONObject, File file) throws JSONException, IOException {
        if (file.exists()) {
            String readFile = readFile(file);
            return a(readFile + "," + jSONObject, file);
        }
        file.createNewFile();
        return a(jSONObject.toString(), file);
    }

    private static boolean a(String str, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(ContextUtil.getContext().openFileOutput(file.getName(), 0)));
                try {
                    bufferedWriter2.write(str);
                    try {
                        bufferedWriter2.close();
                    } catch (Exception e4) {
                        SLog.error(UmengText.CACHE.CLOSE, e4);
                    }
                    return true;
                } catch (Exception e5) {
                    e = e5;
                    bufferedWriter = bufferedWriter2;
                    SLog.error(UmengText.CACHE.CACHEFILE, e);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e6) {
                            SLog.error(UmengText.CACHE.CLOSE, e6);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e7) {
                            SLog.error(UmengText.CACHE.CLOSE, e7);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }
}
