package com.ss.android.socialbase.appdownloader.n;

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
import com.ss.android.socialbase.appdownloader.n;
import com.ss.android.socialbase.appdownloader.q;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.q.kf;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok extends com.ss.android.socialbase.downloader.notification.ok {

    /* renamed from: a  reason: collision with root package name */
    private final Context f49153a;
    private final Resources bl;
    private String kf;

    /* renamed from: n  reason: collision with root package name */
    private String f49154n;

    /* renamed from: s  reason: collision with root package name */
    private String f49155s;

    public ok(Context context, int i4, String str, String str2, String str3, String str4) {
        super(i4, str);
        this.f49154n = str2;
        this.f49155s = str3;
        this.kf = str4;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f49153a = origApplicationContext;
        this.bl = origApplicationContext.getResources();
    }

    private Notification a(BaseException baseException, boolean z3) {
        boolean z4;
        long j4;
        int i4;
        int a4;
        String string;
        String string2;
        String str;
        BaseException baseException2;
        String string3;
        int a5;
        String string4;
        int i5;
        String str2;
        String str3;
        int a6;
        String str4;
        int i6;
        int n4 = n();
        int ok = com.ss.android.socialbase.appdownloader.bl.ok(n4);
        if (ok == 0) {
            return null;
        }
        NotificationCompat.Builder k4 = k();
        k4.setWhen(kf());
        int ok2 = ok();
        com.ss.android.socialbase.downloader.h.ok ok3 = com.ss.android.socialbase.downloader.h.ok.ok(ok2);
        if (Build.VERSION.SDK_INT >= 24 && ok3.ok("set_notification_group", 0) == 1) {
            k4.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            k4.setGroupSummary(false);
        }
        int o4 = n.o();
        if (o4 != 0) {
            k4.setSmallIcon(o4);
            z4 = false;
        } else {
            z4 = true;
        }
        k4.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        int ok4 = ok(ok, ok2);
        if (z4 && ok4 != 0) {
            k4.setSmallIcon(ok4);
        }
        String str5 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (ok == 1 || ok == 4 || ok == 2) {
            k4.setContentIntent(ok("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", ok, ok2));
            k4.setAutoCancel(false);
        } else if (ok == 3) {
            k4.setAutoCancel(true);
            if (n4 != -1 && n4 != -4) {
                if (n4 == -3 && ok3.ok("notification_click_install_auto_cancel", 1) == 0) {
                    k4.setAutoCancel(false);
                }
                str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            k4.setContentIntent(ok(str5, ok, ok2));
            k4.setDeleteIntent(ok("android.ss.intent.action.DOWNLOAD_HIDE", ok, ok2));
        }
        long a7 = a();
        long bl = bl();
        if (bl > 0) {
            j4 = a7;
            i4 = (int) ((100 * a7) / bl);
        } else {
            j4 = a7;
            i4 = 0;
        }
        String s3 = s();
        if (TextUtils.isEmpty(s3)) {
            s3 = this.bl.getString(q.a("tt_appdownloader_download_unknown_title"));
        }
        RemoteViews q3 = q();
        int r3 = n.r();
        if (com.ss.android.socialbase.downloader.h.ok.ok(ok2).a("notification_opt_2") != 1) {
            q3.setOnClickPendingIntent(r3, ok("android.ss.intent.action.DOWNLOAD_CLICK_BTN", ok, ok2));
        }
        NotificationCompat.Builder builder = k4;
        if (com.ss.android.socialbase.downloader.h.ok.ok(ok2).a("enable_notification_ui") >= 1) {
            q3.setInt(r3, "setBackgroundResource", n.zz());
            q3.setTextColor(r3, -1);
        }
        q3.setTextViewText(n.z(), s3);
        int ok5 = ok(ok2);
        q3.setViewVisibility(ok5, 0);
        q3.setProgressBar(ok5, 100, i4, z3);
        int j5 = n.j();
        if (ok4 != 0) {
            q3.setImageViewResource(j5, ok4);
        }
        if (com.ss.android.socialbase.downloader.h.ok.ok(ok2).a("enable_notification_ui") >= 1) {
            Bitmap ok6 = bl.ok().ok(ok2);
            if (ok6 != null) {
                q3.setInt(j5, "setBackgroundColor", 0);
                q3.setImageViewBitmap(j5, ok6);
            } else {
                q3.setInt(j5, "setBackgroundResource", n.zz());
            }
        }
        String str6 = "";
        if (ok == 1 || ok == 4) {
            str6 = com.ss.android.socialbase.appdownloader.bl.ok(j4) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.bl.ok(bl);
            if (ok == 1) {
                if (n() == 11) {
                    a4 = q.a("tt_appdownloader_notification_waiting_download_complete_handler");
                } else {
                    a4 = q.a("tt_appdownloader_notification_downloading");
                }
            } else {
                a4 = q.a("tt_appdownloader_notification_prepare");
            }
            string = this.f49153a.getResources().getString(a4);
            string2 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_download_pause"));
            q3.setViewVisibility(ok(ok2), 0);
            q3.setViewVisibility(n.q(), 8);
            q3.setViewVisibility(n.k(), 0);
            int r4 = n.r();
            if (com.ss.android.socialbase.appdownloader.bl.ok(this.kf)) {
                q3.setViewVisibility(r4, 8);
            } else {
                q3.setViewVisibility(r4, 0);
            }
            if (ok3.a("enable_notification_ui") >= 2) {
                q3.setViewVisibility(r4, 8);
            }
        } else if (ok == 2) {
            str6 = com.ss.android.socialbase.appdownloader.bl.ok(j4) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.bl.ok(bl);
            String string5 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_pausing"));
            String string6 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_download_resume"));
            if (ok3.a("notification_opt_2") == 1) {
                if (i4 >= ok3.ok("noti_progress_show_th", 70)) {
                    q3.setViewVisibility(ok(ok2), 0);
                    q3.setViewVisibility(n.k(), 0);
                    q3.setViewVisibility(n.q(), 8);
                } else {
                    q3.setViewVisibility(ok(ok2), 8);
                    q3.setViewVisibility(n.k(), 8);
                    q3.setViewVisibility(n.q(), 0);
                    q3.setViewVisibility(n.t(), 8);
                    string5 = this.bl.getString(q.a("tt_appdownloader_notification_download_continue"));
                }
            } else {
                q3.setViewVisibility(n.k(), 0);
                int ok7 = ok(ok2);
                if (ok3.a("enable_notification_ui") >= 2) {
                    q3.setViewVisibility(ok7, 0);
                } else {
                    q3.setViewVisibility(ok7, 8);
                }
                q3.setViewVisibility(n.q(), 8);
            }
            int r5 = n.r();
            if (com.ss.android.socialbase.appdownloader.bl.ok(this.kf)) {
                q3.setViewVisibility(r5, 8);
            } else {
                q3.setViewVisibility(r5, 0);
                if (ok3.a("enable_notification_ui") >= 2) {
                    str6 = com.ss.android.socialbase.appdownloader.bl.ok(j4, false) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.bl.ok(bl, false);
                }
            }
            string = string5;
            string2 = string6;
        } else {
            long j6 = j4;
            if (ok == 3) {
                DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getDownloadInfo(ok2);
                if (n() != -1 && n() != -4) {
                    if (n() == -3) {
                        String ok8 = com.ss.android.socialbase.appdownloader.bl.ok(bl);
                        if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                            if (com.ss.android.socialbase.appdownloader.bl.ok(this.f49153a, downloadInfo, false)) {
                                a6 = q.a("tt_appdownloader_notification_install_finished_open");
                                i6 = q.a("tt_appdownloader_notification_download_open");
                            } else {
                                a6 = q.a("tt_appdownloader_notification_download_complete_with_install");
                                i6 = q.a("tt_appdownloader_notification_download_install");
                            }
                            str4 = "";
                        } else {
                            a6 = q.a("tt_appdownloader_notification_download_complete_without_install");
                            if (com.ss.android.socialbase.downloader.downloader.s.ok().z(ok2) != null) {
                                a6 = q.a("tt_appdownloader_notification_download_complete_open");
                            }
                            str4 = "";
                            i6 = 0;
                        }
                        String string7 = this.bl.getString(a6);
                        builder.setContentText(string7);
                        str3 = string7;
                        String string8 = i6 != 0 ? this.bl.getString(i6) : str4;
                        if (ok3.a("notification_opt_2") == 1) {
                            q3.setTextViewText(n.r(), string8);
                            q3.setViewVisibility(n.t(), 8);
                        } else {
                            q3.setViewVisibility(n.r(), 8);
                        }
                        string4 = string8;
                        str = ok8;
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
                    if (ok3.a("enable_notification_ui") >= 2 && n() == -1 && (kf.q(baseException) || kf.p(baseException))) {
                        str = com.ss.android.socialbase.appdownloader.bl.ok(j6) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.bl.ok(bl);
                    }
                    q3.setViewVisibility(n.t(), 8);
                    baseException2 = baseException;
                    if (baseException2 != null && baseException.getErrorCode() == 1006) {
                        string3 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_download_space_failed"));
                    } else if (ok(baseException2, ok3, downloadInfo)) {
                        if (downloadInfo != null && downloadInfo.isOnlyWifi()) {
                            a5 = q.a("tt_appdownloader_notification_download_waiting_wifi");
                        } else {
                            a5 = q.a("tt_appdownloader_notification_download_waiting_net");
                        }
                        string3 = this.f49153a.getResources().getString(a5);
                    } else {
                        string3 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_download_failed"));
                    }
                    String str7 = string3;
                    string4 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_download_restart"));
                    q3.setViewVisibility(n.r(), 8);
                    if (ok3.a("enable_notification_ui") >= 2 && n() == -1) {
                        if (kf.q(baseException)) {
                            if (kf.a(baseException2, downloadInfo)) {
                                str2 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_no_wifi_and_in_net"));
                                builder = builder;
                                string4 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_download_resume"));
                            } else {
                                str2 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_no_internet_error"));
                                builder = builder;
                            }
                            i5 = 0;
                        } else if (kf.p(baseException)) {
                            builder = builder;
                            i5 = 0;
                            str2 = this.f49153a.getResources().getString(q.a("tt_appdownloader_notification_insufficient_space_error"), com.ss.android.socialbase.appdownloader.bl.a(bl - j6));
                        }
                        str3 = str2;
                    }
                    builder = builder;
                    i5 = 0;
                    str2 = str7;
                    str3 = str2;
                }
                q3.setViewVisibility(ok(ok2), 8);
                q3.setViewVisibility(n.q(), i5);
                q3.setViewVisibility(n.k(), 8);
                if (ok3.a("enable_notification_ui") >= 2 && n() == -1 && (kf.q(baseException) || kf.p(baseException))) {
                    q3.setViewVisibility(ok(ok2), 0);
                    q3.setViewVisibility(n.q(), 8);
                    q3.setViewVisibility(n.k(), 0);
                    int r6 = n.r();
                    if (kf.a(baseException2, downloadInfo)) {
                        q3.setViewVisibility(r6, 0);
                        str6 = com.ss.android.socialbase.appdownloader.bl.ok(j6, false) + TTPathConst.sSeparator + com.ss.android.socialbase.appdownloader.bl.ok(bl, false);
                        string = str3;
                        string2 = string4;
                    } else {
                        q3.setViewVisibility(r6, 8);
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
        q3.setTextViewText(n.rh(), str6);
        q3.setTextViewText(n.i(), string);
        q3.setTextViewText(n.t(), str6);
        q3.setTextViewText(n.x(), string);
        int r7 = n.r();
        if (TextUtils.isEmpty(string2)) {
            q3.setViewVisibility(r7, 8);
        } else {
            q3.setTextViewText(r7, string2);
        }
        Notification build = builder.build();
        build.contentView = q3;
        return build;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0044 -> B:15:0x004b). Please submit an issue!!! */
    private NotificationCompat.Builder k() {
        NotificationCompat.Builder builder;
        String q3 = com.ss.android.socialbase.appdownloader.s.k().q();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.f49153a);
        }
        if (TextUtils.isEmpty(q3)) {
            q3 = com.ss.android.socialbase.appdownloader.bl.a(this.f49153a);
        }
        try {
            if (com.ss.android.socialbase.appdownloader.s.k().z() != null) {
                builder = com.ss.android.socialbase.appdownloader.s.k().z().ok(this.f49153a, q3);
            } else {
                builder = new NotificationCompat.Builder(this.f49153a, q3);
            }
        } catch (NoSuchMethodError unused) {
            builder = new NotificationCompat.Builder(this.f49153a);
        }
        return builder;
    }

    private RemoteViews q() {
        RemoteViews remoteViews = new RemoteViews(this.f49153a.getPackageName(), n.ok());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.bl.ok(this.f49153a)) {
                    remoteViews.setInt(n.kf(), "setBackgroundColor", this.f49153a.getResources().getColor(n.td()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    @Override // com.ss.android.socialbase.downloader.notification.ok
    public void ok(DownloadInfo downloadInfo) {
        super.ok(downloadInfo);
        this.f49154n = downloadInfo.getSavePath();
        this.f49155s = downloadInfo.getName();
        this.kf = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.ok
    public void ok(BaseException baseException, boolean z3) {
        if (this.f49153a == null) {
            return;
        }
        try {
            Notification a4 = a(baseException, z3);
            this.ok = a4;
            ok(a4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean ok(BaseException baseException, com.ss.android.socialbase.downloader.h.ok okVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && okVar.ok("notification_text_opt", 0) == 1;
    }

    private int ok(int i4, int i5) {
        if (com.ss.android.socialbase.downloader.h.ok.ok(i5).a("notification_opt_2") == 1) {
            return n.ul();
        }
        if (i4 == 1 || i4 == 4) {
            return n.u();
        }
        if (i4 == 2) {
            return n.io();
        }
        if (i4 == 3) {
            return n.ul();
        }
        return 0;
    }

    private PendingIntent ok(String str, int i4, int i5) {
        Intent intent = new Intent(this.f49153a, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i5);
        intent.putExtra("extra_click_download_type", i4);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f49153a, i5, intent, 201326592);
    }

    private int ok(int i4) {
        if (com.ss.android.socialbase.downloader.h.ok.ok(i4).a("enable_notification_ui") >= 1) {
            return n.p();
        }
        return n.h();
    }
}
