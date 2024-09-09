package com.ss.android.socialbase.appdownloader.ux;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.gd;
import com.ss.android.socialbase.appdownloader.ux;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.gd.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c extends com.ss.android.socialbase.downloader.notification.c {

    /* renamed from: f  reason: collision with root package name */
    private String f49224f;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private final Context f49225w;
    private final Resources xv;

    public c(Context context, int i4, String str, String str2, String str3, String str4) {
        super(i4, str);
        this.ux = str2;
        this.sr = str3;
        this.f49224f = str4;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f49225w = origApplicationContext;
        this.xv = origApplicationContext.getResources();
    }

    private RemoteViews gd() {
        RemoteViews remoteViews = new RemoteViews(this.f49225w.getPackageName(), ux.c());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.xv.c(this.f49225w)) {
                    remoteViews.setInt(ux.f(), "setBackgroundColor", this.f49225w.getResources().getColor(ux.s()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0044 -> B:15:0x004b). Please submit an issue!!! */
    private NotificationCompat.Builder p() {
        NotificationCompat.Builder builder;
        String gd = com.ss.android.socialbase.appdownloader.sr.p().gd();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.f49225w);
        }
        if (TextUtils.isEmpty(gd)) {
            gd = com.ss.android.socialbase.appdownloader.xv.w(this.f49225w);
        }
        try {
            if (com.ss.android.socialbase.appdownloader.sr.p().bk() != null) {
                builder = com.ss.android.socialbase.appdownloader.sr.p().bk().c(this.f49225w, gd);
            } else {
                builder = new NotificationCompat.Builder(this.f49225w, gd);
            }
        } catch (NoSuchMethodError unused) {
            builder = new NotificationCompat.Builder(this.f49225w);
        }
        return builder;
    }

    private Notification w(BaseException baseException, boolean z3) {
        boolean z4;
        long j4;
        int i4;
        int w3;
        String string;
        String string2;
        String str;
        BaseException baseException2;
        String string3;
        int w4;
        String string4;
        int i5;
        String str2;
        String str3;
        int w5;
        String str4;
        int i6;
        int ux = ux();
        int c4 = com.ss.android.socialbase.appdownloader.xv.c(ux);
        if (c4 == 0) {
            return null;
        }
        NotificationCompat.Builder p3 = p();
        p3.setWhen(f());
        int c5 = c();
        com.ss.android.socialbase.downloader.r.c c6 = com.ss.android.socialbase.downloader.r.c.c(c5);
        if (Build.VERSION.SDK_INT >= 24 && c6.c("set_notification_group", 0) == 1) {
            p3.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            p3.setGroupSummary(false);
        }
        int j5 = ux.j();
        if (j5 != 0) {
            p3.setSmallIcon(j5);
            z4 = false;
        } else {
            z4 = true;
        }
        p3.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        int c7 = c(c4, c5);
        if (z4 && c7 != 0) {
            p3.setSmallIcon(c7);
        }
        String str5 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (c4 == 1 || c4 == 4 || c4 == 2) {
            p3.setContentIntent(c("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", c4, c5));
            p3.setAutoCancel(false);
        } else if (c4 == 3) {
            p3.setAutoCancel(true);
            if (ux != -1 && ux != -4) {
                if (ux == -3 && c6.c("notification_click_install_auto_cancel", 1) == 0) {
                    p3.setAutoCancel(false);
                }
                str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            p3.setContentIntent(c(str5, c4, c5));
            p3.setDeleteIntent(c("android.ss.intent.action.DOWNLOAD_HIDE", c4, c5));
        }
        long w6 = w();
        long xv = xv();
        if (xv > 0) {
            j4 = w6;
            i4 = (int) ((100 * w6) / xv);
        } else {
            j4 = w6;
            i4 = 0;
        }
        String sr = sr();
        if (TextUtils.isEmpty(sr)) {
            sr = this.xv.getString(gd.w("tt_appdownloader_download_unknown_title"));
        }
        RemoteViews gd = gd();
        int k4 = ux.k();
        if (com.ss.android.socialbase.downloader.r.c.c(c5).w("notification_opt_2") != 1) {
            gd.setOnClickPendingIntent(k4, c("android.ss.intent.action.DOWNLOAD_CLICK_BTN", c4, c5));
        }
        NotificationCompat.Builder builder = p3;
        if (com.ss.android.socialbase.downloader.r.c.c(c5).w("enable_notification_ui") >= 1) {
            gd.setInt(k4, "setBackgroundResource", ux.fz());
            gd.setTextColor(k4, -1);
        }
        gd.setTextViewText(ux.bk(), sr);
        int c8 = c(c5);
        gd.setViewVisibility(c8, 0);
        gd.setProgressBar(c8, 100, i4, z3);
        int a4 = ux.a();
        if (c7 != 0) {
            gd.setImageViewResource(a4, c7);
        }
        if (com.ss.android.socialbase.downloader.r.c.c(c5).w("enable_notification_ui") >= 1) {
            Bitmap c9 = xv.c().c(c5);
            if (c9 != null) {
                gd.setInt(a4, "setBackgroundColor", 0);
                gd.setImageViewBitmap(a4, c9);
            } else {
                gd.setInt(a4, "setBackgroundResource", ux.fz());
            }
        }
        String str6 = "";
        if (c4 == 1 || c4 == 4) {
            str6 = com.ss.android.socialbase.appdownloader.xv.c(j4) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.xv.c(xv);
            if (c4 == 1) {
                if (ux() == 11) {
                    w3 = gd.w("tt_appdownloader_notification_waiting_download_complete_handler");
                } else {
                    w3 = gd.w("tt_appdownloader_notification_downloading");
                }
            } else {
                w3 = gd.w("tt_appdownloader_notification_prepare");
            }
            string = this.f49225w.getResources().getString(w3);
            string2 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_download_pause"));
            gd.setViewVisibility(c(c5), 0);
            gd.setViewVisibility(ux.gd(), 8);
            gd.setViewVisibility(ux.p(), 0);
            int k5 = ux.k();
            if (com.ss.android.socialbase.appdownloader.xv.c(this.f49224f)) {
                gd.setViewVisibility(k5, 8);
            } else {
                gd.setViewVisibility(k5, 0);
            }
            if (c6.w("enable_notification_ui") >= 2) {
                gd.setViewVisibility(k5, 8);
            }
        } else if (c4 == 2) {
            str6 = com.ss.android.socialbase.appdownloader.xv.c(j4) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.xv.c(xv);
            String string5 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_pausing"));
            String string6 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_download_resume"));
            if (c6.w("notification_opt_2") == 1) {
                if (i4 >= c6.c("noti_progress_show_th", 70)) {
                    gd.setViewVisibility(c(c5), 0);
                    gd.setViewVisibility(ux.p(), 0);
                    gd.setViewVisibility(ux.gd(), 8);
                } else {
                    gd.setViewVisibility(c(c5), 8);
                    gd.setViewVisibility(ux.p(), 8);
                    gd.setViewVisibility(ux.gd(), 0);
                    gd.setViewVisibility(ux.ys(), 8);
                    string5 = this.xv.getString(gd.w("tt_appdownloader_notification_download_continue"));
                }
            } else {
                gd.setViewVisibility(ux.p(), 0);
                int c10 = c(c5);
                if (c6.w("enable_notification_ui") >= 2) {
                    gd.setViewVisibility(c10, 0);
                } else {
                    gd.setViewVisibility(c10, 8);
                }
                gd.setViewVisibility(ux.gd(), 8);
            }
            int k6 = ux.k();
            if (com.ss.android.socialbase.appdownloader.xv.c(this.f49224f)) {
                gd.setViewVisibility(k6, 8);
            } else {
                gd.setViewVisibility(k6, 0);
                if (c6.w("enable_notification_ui") >= 2) {
                    str6 = com.ss.android.socialbase.appdownloader.xv.c(j4, false) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.xv.c(xv, false);
                }
            }
            string = string5;
            string2 = string6;
        } else {
            long j6 = j4;
            if (c4 == 3) {
                DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).getDownloadInfo(c5);
                if (ux() != -1 && ux() != -4) {
                    if (ux() == -3) {
                        String c11 = com.ss.android.socialbase.appdownloader.xv.c(xv);
                        if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                            if (com.ss.android.socialbase.appdownloader.xv.c(this.f49225w, downloadInfo, false)) {
                                w5 = gd.w("tt_appdownloader_notification_install_finished_open");
                                i6 = gd.w("tt_appdownloader_notification_download_open");
                            } else {
                                w5 = gd.w("tt_appdownloader_notification_download_complete_with_install");
                                i6 = gd.w("tt_appdownloader_notification_download_install");
                            }
                            str4 = "";
                        } else {
                            w5 = gd.w("tt_appdownloader_notification_download_complete_without_install");
                            if (com.ss.android.socialbase.downloader.downloader.sr.c().bk(c5) != null) {
                                w5 = gd.w("tt_appdownloader_notification_download_complete_open");
                            }
                            str4 = "";
                            i6 = 0;
                        }
                        String string7 = this.xv.getString(w5);
                        builder.setContentText(string7);
                        str3 = string7;
                        String string8 = i6 != 0 ? this.xv.getString(i6) : str4;
                        if (c6.w("notification_opt_2") == 1) {
                            gd.setTextViewText(ux.k(), string8);
                            gd.setViewVisibility(ux.ys(), 8);
                        } else {
                            gd.setViewVisibility(ux.k(), 8);
                        }
                        string4 = string8;
                        str = c11;
                        builder = builder;
                        i5 = 0;
                        baseException2 = baseException;
                    } else {
                        str = "";
                        baseException2 = baseException;
                        str3 = str;
                        string4 = str3;
                        i5 = 0;
                    }
                } else {
                    str = "";
                    if (c6.w("enable_notification_ui") >= 2 && ux() == -1 && (f.gd(baseException) || f.ev(baseException))) {
                        str = com.ss.android.socialbase.appdownloader.xv.c(j6) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.xv.c(xv);
                    }
                    gd.setViewVisibility(ux.ys(), 8);
                    baseException2 = baseException;
                    if (baseException2 != null && baseException.getErrorCode() == 1006) {
                        string3 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_download_space_failed"));
                    } else if (c(baseException2, c6, downloadInfo)) {
                        if (downloadInfo != null && downloadInfo.isOnlyWifi()) {
                            w4 = gd.w("tt_appdownloader_notification_download_waiting_wifi");
                        } else {
                            w4 = gd.w("tt_appdownloader_notification_download_waiting_net");
                        }
                        string3 = this.f49225w.getResources().getString(w4);
                    } else {
                        string3 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_download_failed"));
                    }
                    String str7 = string3;
                    string4 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_download_restart"));
                    gd.setViewVisibility(ux.k(), 8);
                    if (c6.w("enable_notification_ui") >= 2 && ux() == -1) {
                        if (f.gd(baseException)) {
                            if (f.w(baseException2, downloadInfo)) {
                                str2 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_no_wifi_and_in_net"));
                                builder = builder;
                                string4 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_download_resume"));
                            } else {
                                str2 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_no_internet_error"));
                                builder = builder;
                            }
                            i5 = 0;
                        } else if (f.ev(baseException)) {
                            builder = builder;
                            i5 = 0;
                            str2 = this.f49225w.getResources().getString(gd.w("tt_appdownloader_notification_insufficient_space_error"), com.ss.android.socialbase.appdownloader.xv.w(xv - j6));
                        }
                        str3 = str2;
                    }
                    builder = builder;
                    i5 = 0;
                    str2 = str7;
                    str3 = str2;
                }
                gd.setViewVisibility(c(c5), 8);
                gd.setViewVisibility(ux.gd(), i5);
                gd.setViewVisibility(ux.p(), 8);
                if (c6.w("enable_notification_ui") >= 2 && ux() == -1 && (f.gd(baseException) || f.ev(baseException))) {
                    gd.setViewVisibility(c(c5), 0);
                    gd.setViewVisibility(ux.gd(), 8);
                    gd.setViewVisibility(ux.p(), 0);
                    int k7 = ux.k();
                    if (f.w(baseException2, downloadInfo)) {
                        gd.setViewVisibility(k7, 0);
                        str6 = com.ss.android.socialbase.appdownloader.xv.c(j6, false) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.xv.c(xv, false);
                        string = str3;
                        string2 = string4;
                    } else {
                        gd.setViewVisibility(k7, 8);
                    }
                }
                str6 = str;
                string = str3;
                string2 = string4;
            } else {
                string = "";
                string2 = string;
            }
        }
        gd.setTextViewText(ux.t(), str6);
        gd.setTextViewText(ux.fp(), string);
        gd.setTextViewText(ux.ys(), str6);
        gd.setTextViewText(ux.ia(), string);
        int k8 = ux.k();
        if (TextUtils.isEmpty(string2)) {
            gd.setViewVisibility(k8, 8);
        } else {
            gd.setTextViewText(k8, string2);
        }
        Notification build = builder.build();
        build.contentView = gd;
        return build;
    }

    @Override // com.ss.android.socialbase.downloader.notification.c
    public void c(DownloadInfo downloadInfo) {
        super.c(downloadInfo);
        this.ux = downloadInfo.getSavePath();
        this.sr = downloadInfo.getName();
        this.f49224f = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.c
    public void c(BaseException baseException, boolean z3) {
        if (this.f49225w == null) {
            return;
        }
        try {
            Notification w3 = w(baseException, z3);
            this.f50088c = w3;
            c(w3);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean c(BaseException baseException, com.ss.android.socialbase.downloader.r.c cVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && cVar.c("notification_text_opt", 0) == 1;
    }

    private int c(int i4, int i5) {
        if (com.ss.android.socialbase.downloader.r.c.c(i5).w("notification_opt_2") == 1) {
            return ux.q();
        }
        if (i4 == 1 || i4 == 4) {
            return ux.u();
        }
        if (i4 == 2) {
            return ux.i();
        }
        if (i4 == 3) {
            return ux.q();
        }
        return 0;
    }

    private PendingIntent c(String str, int i4, int i5) {
        Intent intent = new Intent(this.f49225w, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i5);
        intent.putExtra("extra_click_download_type", i4);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f49225w, i5, intent, 201326592);
    }

    private int c(int i4) {
        if (com.ss.android.socialbase.downloader.r.c.c(i4).w("enable_notification_ui") >= 1) {
            return ux.ev();
        }
        return ux.r();
    }
}
