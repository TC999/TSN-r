package com.ss.android.socialbase.downloader.sr;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.ls;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.downloader.ia;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.gd;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {
    public static void c(DownloadTask downloadTask, BaseException baseException, int i4) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            ls monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i4);
            if (!isMonitorStatus && !(isMonitorStatus = c(downloadInfo.getExtraMonitorStatus(), i4)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.xv)) {
                isMonitorStatus = c(((com.ss.android.socialbase.downloader.depend.xv) monitorDepend).c(), i4);
            }
            if (isMonitorStatus) {
                t depend = downloadTask.getDepend();
                if (depend != null) {
                    depend.c(downloadInfo, baseException, i4);
                }
                c(monitorDepend, downloadInfo, baseException, i4);
                c(com.ss.android.socialbase.downloader.downloader.xv.r(), downloadInfo, baseException, i4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean c(int[] iArr, int i4) {
        if (iArr != null && iArr.length > 0) {
            for (int i5 : iArr) {
                if (i4 == i5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void c(ls lsVar, DownloadInfo downloadInfo, BaseException baseException, int i4) {
        if (lsVar == null) {
            return;
        }
        try {
            String w3 = lsVar.w();
            if (TextUtils.isEmpty(w3)) {
                w3 = "default";
            }
            JSONObject c4 = c(w3, downloadInfo, baseException, i4);
            if (c4 == null) {
                c4 = new JSONObject();
            }
            lsVar.c(c4);
        } catch (Throwable unused) {
        }
    }

    public static void c(w wVar, DownloadInfo downloadInfo, BaseException baseException, int i4) {
        if (wVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject c4 = c(downloadInfo.getMonitorScene(), downloadInfo, baseException, i4);
            if (c4 == null) {
                c4 = new JSONObject();
            }
            if (i4 == -1) {
                c4.put("status", baseException.getErrorCode());
                wVar.c("download_failed", c4, null, null);
                return;
            }
            c(i4, c4, downloadInfo);
            wVar.c("download_common", c4, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void c(int i4, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i4 == -5) {
            str = "download_uncomplete";
        } else if (i4 == -4) {
            str = "download_cancel";
        } else if (i4 != -3) {
            str = i4 != -2 ? i4 != 0 ? i4 != 2 ? i4 != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    public static String c(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    private static JSONObject c(String str, DownloadInfo downloadInfo, BaseException baseException, int i4) {
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        int i5;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e4) {
            e = e4;
        }
        try {
            ia k4 = com.ss.android.socialbase.downloader.downloader.xv.k();
            if (k4 != null) {
                str2 = k4.w();
                str3 = c(str2);
                str4 = k4.c();
                i5 = k4.xv();
            } else {
                str2 = "";
                str3 = str2;
                str4 = str3;
                i5 = 0;
            }
            String c4 = (baseException == null || !(baseException instanceof r)) ? "" : ((r) baseException).c();
            jSONObject.put("event_page", str);
            jSONObject.put("app_id", str4);
            jSONObject.put("device_id", str2);
            jSONObject.put("device_id_postfix", str3);
            jSONObject.put("update_version", i5);
            jSONObject.put("download_status", i4);
            if (downloadInfo != null) {
                jSONObject.put("setting_tag", com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).xv("setting_tag"));
                jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("url", downloadInfo.getUrl());
                jSONObject.put("save_path", downloadInfo.getSavePath());
                jSONObject.put("download_time", downloadInfo.getDownloadTime());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put(DownloadModel.TOTAL_BYTES, downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                int i6 = 1;
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("is_force", downloadInfo.isForce() ? 1 : 0);
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                jSONObject.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                jSONObject.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                jSONObject.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                if (!downloadInfo.isAddListenerToSameTask()) {
                    i6 = 0;
                }
                jSONObject.put("add_listener_to_same_task", i6);
                jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                jSONObject.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                jSONObject.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                jSONObject.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                String url = downloadInfo.getUrl();
                if (TextUtils.isEmpty(url)) {
                    str5 = "";
                    str6 = str5;
                    str7 = str6;
                } else {
                    Uri parse = Uri.parse(url);
                    str6 = parse.getHost();
                    str7 = parse.getPath();
                    str5 = parse.getLastPathSegment();
                    if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str5)) {
                        try {
                            str7 = str7.substring(0, str7.length() - str5.length());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                jSONObject.put("url_host", str6);
                jSONObject.put("url_path", str7);
                jSONObject.put("url_last_path_segment", str5);
            }
            jSONObject.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
            jSONObject.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
            jSONObject.put("request_log", c4);
            return jSONObject;
        } catch (JSONException e5) {
            e = e5;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:11|(4:68|69|70|(16:72|73|14|(2:49|(1:(2:57|(1:59)(2:60|61)))(1:54))|17|18|(2:22|23)|26|27|28|(1:30)|31|32|(1:44)|35|(2:39|41)(1:38)))|13|14|(0)|49|(1:51)|(0)|17|18|(3:20|22|23)|26|27|28|(0)|31|32|(0)|42|44|35|(0)|39|41) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0114, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0115, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[Catch: all -> 0x013a, TRY_LEAVE, TryCatch #3 {all -> 0x013a, blocks: (B:18:0x002f, B:20:0x0033, B:44:0x007f, B:46:0x0095, B:49:0x00a8, B:50:0x00ad, B:52:0x00e9, B:53:0x00fa, B:66:0x012e, B:60:0x0120, B:62:0x0126, B:56:0x0115, B:26:0x0047, B:28:0x004d, B:33:0x0058, B:36:0x0065, B:40:0x006b, B:42:0x0077, B:13:0x0025), top: B:76:0x0025, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9 A[Catch: JSONException -> 0x0114, all -> 0x013a, TryCatch #0 {JSONException -> 0x0114, blocks: (B:50:0x00ad, B:52:0x00e9, B:53:0x00fa), top: B:72:0x00ad, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.network.r r14, java.lang.String r15, java.lang.String r16, long r17, java.lang.String r19, int r20, java.io.IOException r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.sr.c.c(com.ss.android.socialbase.downloader.network.r, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void c(com.ss.android.socialbase.downloader.r.c cVar, DownloadInfo downloadInfo, String str, gd gdVar, boolean z3, boolean z4, BaseException baseException, long j4, long j5, boolean z5, long j6, long j7, long j8, JSONObject jSONObject) {
        c("download_io", cVar.w("monitor_download_io"), cVar, downloadInfo, str, null, null, gdVar, z3, z4, baseException, j4, j5, z5, j6, j7, j8, null);
    }

    public static void c(com.ss.android.socialbase.downloader.r.c cVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z3, gd gdVar, BaseException baseException, long j4, long j5) {
        c("segment_io", cVar.w("monitor_segment_io"), cVar, downloadInfo, str, str2, str3, gdVar, z3, false, baseException, j4, j5, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[Catch: all -> 0x01a9, TryCatch #1 {all -> 0x01a9, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:48:0x00c4, B:50:0x00d7, B:52:0x0111, B:53:0x0122, B:55:0x0134, B:59:0x0149, B:61:0x0158, B:63:0x0167, B:64:0x016a, B:76:0x019d, B:69:0x0189, B:71:0x018f, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0111 A[Catch: all -> 0x01a9, TryCatch #1 {all -> 0x01a9, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:48:0x00c4, B:50:0x00d7, B:52:0x0111, B:53:0x0122, B:55:0x0134, B:59:0x0149, B:61:0x0158, B:63:0x0167, B:64:0x016a, B:76:0x019d, B:69:0x0189, B:71:0x018f, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0134 A[Catch: all -> 0x01a9, TryCatch #1 {all -> 0x01a9, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:48:0x00c4, B:50:0x00d7, B:52:0x0111, B:53:0x0122, B:55:0x0134, B:59:0x0149, B:61:0x0158, B:63:0x0167, B:64:0x016a, B:76:0x019d, B:69:0x0189, B:71:0x018f, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018f A[Catch: all -> 0x01a9, TryCatch #1 {all -> 0x01a9, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:48:0x00c4, B:50:0x00d7, B:52:0x0111, B:53:0x0122, B:55:0x0134, B:59:0x0149, B:61:0x0158, B:63:0x0167, B:64:0x016a, B:76:0x019d, B:69:0x0189, B:71:0x018f, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019b A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(java.lang.String r19, int r20, com.ss.android.socialbase.downloader.r.c r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.ss.android.socialbase.downloader.network.gd r26, boolean r27, boolean r28, com.ss.android.socialbase.downloader.exception.BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, org.json.JSONObject r41) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.sr.c.c(java.lang.String, int, com.ss.android.socialbase.downloader.r.c, com.ss.android.socialbase.downloader.model.DownloadInfo, java.lang.String, java.lang.String, java.lang.String, com.ss.android.socialbase.downloader.network.gd, boolean, boolean, com.ss.android.socialbase.downloader.exception.BaseException, long, long, boolean, long, long, long, org.json.JSONObject):void");
    }

    public static void c(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.f.gd> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.f.gd.c(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put(DownloadModel.TOTAL_BYTES, downloadInfo.getTotalBytes());
            xv up = com.ss.android.socialbase.downloader.downloader.xv.up();
            if (up != null) {
                up.c(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}