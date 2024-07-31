package com.p521ss.android.socialbase.downloader.p557s;

import android.net.Uri;
import android.text.TextUtils;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.p521ss.android.socialbase.downloader.constants.DownloadStatus;
import com.p521ss.android.socialbase.downloader.depend.AbstractC12420bl;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12469rh;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12521x;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.exception.C12527h;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p551kf.C12584q;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.s.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12723ok {
    /* renamed from: ok */
    public static void m16488ok(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            InterfaceC12483y monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!isMonitorStatus && !(isMonitorStatus = m16482ok(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof AbstractC12420bl)) {
                isMonitorStatus = m16482ok(((AbstractC12420bl) monitorDepend).mo16661ok(), i);
            }
            if (isMonitorStatus) {
                InterfaceC12469rh depend = downloadTask.getDepend();
                if (depend != null) {
                    depend.mo16663ok(downloadInfo, baseException, i);
                }
                m16492ok(monitorDepend, downloadInfo, baseException, i);
                m16486ok(C12490bl.m17816h(), downloadInfo, baseException, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: ok */
    private static boolean m16482ok(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static void m16492ok(InterfaceC12483y interfaceC12483y, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (interfaceC12483y == null) {
            return;
        }
        try {
            String mo16662a = interfaceC12483y.mo16662a();
            if (TextUtils.isEmpty(mo16662a)) {
                mo16662a = "default";
            }
            JSONObject m16483ok = m16483ok(mo16662a, downloadInfo, baseException, i);
            if (m16483ok == null) {
                m16483ok = new JSONObject();
            }
            interfaceC12483y.mo16660ok(m16483ok);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ok */
    public static void m16486ok(InterfaceC12721a interfaceC12721a, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (interfaceC12721a == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject m16483ok = m16483ok(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (m16483ok == null) {
                m16483ok = new JSONObject();
            }
            if (i == -1) {
                m16483ok.put("status", baseException.getErrorCode());
                interfaceC12721a.m16496ok("download_failed", m16483ok, null, null);
                return;
            }
            m16493ok(i, m16483ok, downloadInfo);
            interfaceC12721a.m16496ok("download_common", m16483ok, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: ok */
    private static void m16493ok(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= Utils.DOUBLE_EPSILON) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    /* renamed from: ok */
    public static String m16485ok(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: ok */
    private static JSONObject m16483ok(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
        }
        try {
            InterfaceC12521x m17763r = C12490bl.m17763r();
            if (m17763r != null) {
                str2 = m17763r.m17622a();
                str3 = m16485ok(str2);
                str4 = m17763r.m17620ok();
                i2 = m17763r.m17621bl();
            } else {
                str2 = "";
                str3 = str2;
                str4 = str3;
                i2 = 0;
            }
            String m17616ok = (baseException == null || !(baseException instanceof C12527h)) ? "" : ((C12527h) baseException).m17616ok();
            jSONObject.put("event_page", str);
            jSONObject.put("app_id", str4);
            jSONObject.put("device_id", str2);
            jSONObject.put("device_id_postfix", str3);
            jSONObject.put("update_version", i2);
            jSONObject.put("download_status", i);
            if (downloadInfo != null) {
                jSONObject.put("setting_tag", C12534ok.m17599ok(downloadInfo.getId()).m17603bl("setting_tag"));
                jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("url", downloadInfo.getUrl());
                jSONObject.put("save_path", downloadInfo.getSavePath());
                jSONObject.put("download_time", downloadInfo.getDownloadTime());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put(DownloadModel.TOTAL_BYTES, downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                int i3 = 1;
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
                    i3 = 0;
                }
                jSONObject.put("add_listener_to_same_task", i3);
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
            jSONObject.put("request_log", m17616ok);
            return jSONObject;
        } catch (JSONException e2) {
            e = e2;
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
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m16487ok(@androidx.annotation.Nullable com.p521ss.android.socialbase.downloader.network.InterfaceC12620h r14, java.lang.String r15, java.lang.String r16, long r17, java.lang.String r19, int r20, java.io.IOException r21, com.p521ss.android.socialbase.downloader.model.DownloadInfo r22) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p557s.C12723ok.m16487ok(com.ss.android.socialbase.downloader.network.h, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    /* renamed from: ok */
    public static void m16491ok(C12534ok c12534ok, DownloadInfo downloadInfo, String str, InterfaceC12635q interfaceC12635q, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        m16484ok("download_io", c12534ok.m17607a("monitor_download_io"), c12534ok, downloadInfo, str, null, null, interfaceC12635q, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    /* renamed from: ok */
    public static void m16490ok(C12534ok c12534ok, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, InterfaceC12635q interfaceC12635q, BaseException baseException, long j, long j2) {
        m16484ok("segment_io", c12534ok.m17607a("monitor_segment_io"), c12534ok, downloadInfo, str, str2, str3, interfaceC12635q, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
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
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m16484ok(java.lang.String r19, int r20, com.p521ss.android.socialbase.downloader.p550h.C12534ok r21, com.p521ss.android.socialbase.downloader.model.DownloadInfo r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.p521ss.android.socialbase.downloader.network.InterfaceC12635q r26, boolean r27, boolean r28, com.p521ss.android.socialbase.downloader.exception.BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, org.json.JSONObject r41) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p557s.C12723ok.m16484ok(java.lang.String, int, com.ss.android.socialbase.downloader.h.ok, com.ss.android.socialbase.downloader.model.DownloadInfo, java.lang.String, java.lang.String, java.lang.String, com.ss.android.socialbase.downloader.network.q, boolean, boolean, com.ss.android.socialbase.downloader.exception.BaseException, long, long, boolean, long, long, long, org.json.JSONObject):void");
    }

    /* renamed from: ok */
    public static void m16489ok(DownloadInfo downloadInfo, List<C12584q> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", C12584q.m17284ok(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put(DownloadModel.TOTAL_BYTES, downloadInfo.getTotalBytes());
            InterfaceC12722bl m17752vk = C12490bl.m17752vk();
            if (m17752vk != null) {
                m17752vk.mo16494ok(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
