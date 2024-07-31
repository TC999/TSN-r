package com.p521ss.android.socialbase.appdownloader.p545n;

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
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.appdownloader.C12330n;
import com.p521ss.android.socialbase.appdownloader.C12360q;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12515s;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.AbstractC12645ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.stub.StubApp;

/* renamed from: com.ss.android.socialbase.appdownloader.n.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12335ok extends AbstractC12645ok {

    /* renamed from: a */
    private final Context f34791a;

    /* renamed from: bl */
    private final Resources f34792bl;

    /* renamed from: kf */
    private String f34793kf;

    /* renamed from: n */
    private String f34794n;

    /* renamed from: s */
    private String f34795s;

    public C12335ok(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.f34794n = str2;
        this.f34795s = str3;
        this.f34793kf = str4;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f34791a = origApplicationContext;
        this.f34792bl = origApplicationContext.getResources();
    }

    /* renamed from: a */
    private Notification m18127a(BaseException baseException, boolean z) {
        boolean z2;
        long j;
        int i;
        int m18088a;
        String string;
        String string2;
        String str;
        BaseException baseException2;
        String string3;
        int m18088a2;
        String string4;
        int i2;
        String str2;
        String str3;
        int m18088a3;
        String str4;
        int i3;
        int m16865n = m16865n();
        int m18432ok = C12293bl.m18432ok(m16865n);
        if (m18432ok == 0) {
            return null;
        }
        NotificationCompat.Builder m18126k = m18126k();
        m18126k.setWhen(m16866kf());
        int m16864ok = m16864ok();
        C12534ok m17599ok = C12534ok.m17599ok(m16864ok);
        if (Build.VERSION.SDK_INT >= 24 && m17599ok.m17593ok("set_notification_group", 0) == 1) {
            m18126k.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            m18126k.setGroupSummary(false);
        }
        int m18148o = C12330n.m18148o();
        if (m18148o != 0) {
            m18126k.setSmallIcon(m18148o);
            z2 = false;
        } else {
            z2 = true;
        }
        m18126k.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        int m18124ok = m18124ok(m18432ok, m16864ok);
        if (z2 && m18124ok != 0) {
            m18126k.setSmallIcon(m18124ok);
        }
        String str5 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (m18432ok == 1 || m18432ok == 4 || m18432ok == 2) {
            m18126k.setContentIntent(m18122ok("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", m18432ok, m16864ok));
            m18126k.setAutoCancel(false);
        } else if (m18432ok == 3) {
            m18126k.setAutoCancel(true);
            if (m16865n != -1 && m16865n != -4) {
                if (m16865n == -3 && m17599ok.m17593ok("notification_click_install_auto_cancel", 1) == 0) {
                    m18126k.setAutoCancel(false);
                }
                str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            m18126k.setContentIntent(m18122ok(str5, m18432ok, m16864ok));
            m18126k.setDeleteIntent(m18122ok("android.ss.intent.action.DOWNLOAD_HIDE", m18432ok, m16864ok));
        }
        long m16870a = m16870a();
        long m16868bl = m16868bl();
        if (m16868bl > 0) {
            j = m16870a;
            i = (int) ((100 * m16870a) / m16868bl);
        } else {
            j = m16870a;
            i = 0;
        }
        String m16855s = m16855s();
        if (TextUtils.isEmpty(m16855s)) {
            m16855s = this.f34792bl.getString(C12360q.m18088a("tt_appdownloader_download_unknown_title"));
        }
        RemoteViews m18121q = m18121q();
        int m18144r = C12330n.m18144r();
        if (C12534ok.m17599ok(m16864ok).m17607a("notification_opt_2") != 1) {
            m18121q.setOnClickPendingIntent(m18144r, m18122ok("android.ss.intent.action.DOWNLOAD_CLICK_BTN", m18432ok, m16864ok));
        }
        NotificationCompat.Builder builder = m18126k;
        if (C12534ok.m17599ok(m16864ok).m17607a("enable_notification_ui") >= 1) {
            m18121q.setInt(m18144r, "setBackgroundResource", C12330n.m18135zz());
            m18121q.setTextColor(m18144r, -1);
        }
        m18121q.setTextViewText(C12330n.m18136z(), m16855s);
        int m18125ok = m18125ok(m16864ok);
        m18121q.setViewVisibility(m18125ok, 0);
        m18121q.setProgressBar(m18125ok, 100, i, z);
        int m18152j = C12330n.m18152j();
        if (m18124ok != 0) {
            m18121q.setImageViewResource(m18152j, m18124ok);
        }
        if (C12534ok.m17599ok(m16864ok).m17607a("enable_notification_ui") >= 1) {
            Bitmap m18132ok = C12332bl.m18133ok().m18132ok(m16864ok);
            if (m18132ok != null) {
                m18121q.setInt(m18152j, "setBackgroundColor", 0);
                m18121q.setImageViewBitmap(m18152j, m18132ok);
            } else {
                m18121q.setInt(m18152j, "setBackgroundResource", C12330n.m18135zz());
            }
        }
        String str6 = "";
        if (m18432ok == 1 || m18432ok == 4) {
            str6 = C12293bl.m18430ok(j) + "/" + C12293bl.m18430ok(m16868bl);
            if (m18432ok == 1) {
                if (m16865n() == 11) {
                    m18088a = C12360q.m18088a("tt_appdownloader_notification_waiting_download_complete_handler");
                } else {
                    m18088a = C12360q.m18088a("tt_appdownloader_notification_downloading");
                }
            } else {
                m18088a = C12360q.m18088a("tt_appdownloader_notification_prepare");
            }
            string = this.f34791a.getResources().getString(m18088a);
            string2 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_download_pause"));
            m18121q.setViewVisibility(m18125ok(m16864ok), 0);
            m18121q.setViewVisibility(C12330n.m18145q(), 8);
            m18121q.setViewVisibility(C12330n.m18151k(), 0);
            int m18144r2 = C12330n.m18144r();
            if (C12293bl.m18408ok(this.f34793kf)) {
                m18121q.setViewVisibility(m18144r2, 8);
            } else {
                m18121q.setViewVisibility(m18144r2, 0);
            }
            if (m17599ok.m17607a("enable_notification_ui") >= 2) {
                m18121q.setViewVisibility(m18144r2, 8);
            }
        } else if (m18432ok == 2) {
            str6 = C12293bl.m18430ok(j) + "/" + C12293bl.m18430ok(m16868bl);
            String string5 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_pausing"));
            String string6 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_download_resume"));
            if (m17599ok.m17607a("notification_opt_2") == 1) {
                if (i >= m17599ok.m17593ok("noti_progress_show_th", 70)) {
                    m18121q.setViewVisibility(m18125ok(m16864ok), 0);
                    m18121q.setViewVisibility(C12330n.m18151k(), 0);
                    m18121q.setViewVisibility(C12330n.m18145q(), 8);
                } else {
                    m18121q.setViewVisibility(m18125ok(m16864ok), 8);
                    m18121q.setViewVisibility(C12330n.m18151k(), 8);
                    m18121q.setViewVisibility(C12330n.m18145q(), 0);
                    m18121q.setViewVisibility(C12330n.m18141t(), 8);
                    string5 = this.f34792bl.getString(C12360q.m18088a("tt_appdownloader_notification_download_continue"));
                }
            } else {
                m18121q.setViewVisibility(C12330n.m18151k(), 0);
                int m18125ok2 = m18125ok(m16864ok);
                if (m17599ok.m17607a("enable_notification_ui") >= 2) {
                    m18121q.setViewVisibility(m18125ok2, 0);
                } else {
                    m18121q.setViewVisibility(m18125ok2, 8);
                }
                m18121q.setViewVisibility(C12330n.m18145q(), 8);
            }
            int m18144r3 = C12330n.m18144r();
            if (C12293bl.m18408ok(this.f34793kf)) {
                m18121q.setViewVisibility(m18144r3, 8);
            } else {
                m18121q.setViewVisibility(m18144r3, 0);
                if (m17599ok.m17607a("enable_notification_ui") >= 2) {
                    str6 = C12293bl.m18427ok(j, false) + "/" + C12293bl.m18427ok(m16868bl, false);
                }
            }
            string = string5;
            string2 = string6;
        } else {
            long j2 = j;
            if (m18432ok == 3) {
                DownloadInfo downloadInfo = Downloader.getInstance(C12490bl.m17807l()).getDownloadInfo(m16864ok);
                if (m16865n() != -1 && m16865n() != -4) {
                    if (m16865n() == -3) {
                        String m18430ok = C12293bl.m18430ok(m16868bl);
                        if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                            if (C12293bl.m18413ok(this.f34791a, downloadInfo, false)) {
                                m18088a3 = C12360q.m18088a("tt_appdownloader_notification_install_finished_open");
                                i3 = C12360q.m18088a("tt_appdownloader_notification_download_open");
                            } else {
                                m18088a3 = C12360q.m18088a("tt_appdownloader_notification_download_complete_with_install");
                                i3 = C12360q.m18088a("tt_appdownloader_notification_download_install");
                            }
                            str4 = "";
                        } else {
                            m18088a3 = C12360q.m18088a("tt_appdownloader_notification_download_complete_without_install");
                            if (C12515s.m17660ok().m17634z(m16864ok) != null) {
                                m18088a3 = C12360q.m18088a("tt_appdownloader_notification_download_complete_open");
                            }
                            str4 = "";
                            i3 = 0;
                        }
                        String string7 = this.f34792bl.getString(m18088a3);
                        builder.setContentText(string7);
                        str3 = string7;
                        String string8 = i3 != 0 ? this.f34792bl.getString(i3) : str4;
                        if (m17599ok.m17607a("notification_opt_2") == 1) {
                            m18121q.setTextViewText(C12330n.m18144r(), string8);
                            m18121q.setViewVisibility(C12330n.m18141t(), 8);
                        } else {
                            m18121q.setViewVisibility(C12330n.m18144r(), 8);
                        }
                        string4 = string8;
                        str = m18430ok;
                        builder = builder;
                        i2 = 0;
                        baseException2 = baseException;
                    } else {
                        str = "";
                        baseException2 = baseException;
                        str3 = str;
                        string4 = str3;
                        i2 = 0;
                    }
                } else {
                    str = "";
                    if (m17599ok.m17607a("enable_notification_ui") >= 2 && m16865n() == -1 && (C12713kf.m16525q(baseException) || C12713kf.m16528p(baseException))) {
                        str = C12293bl.m18430ok(j2) + "/" + C12293bl.m18430ok(m16868bl);
                    }
                    m18121q.setViewVisibility(C12330n.m18141t(), 8);
                    baseException2 = baseException;
                    if (baseException2 != null && baseException.getErrorCode() == 1006) {
                        string3 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_download_space_failed"));
                    } else if (m18123ok(baseException2, m17599ok, downloadInfo)) {
                        if (downloadInfo != null && downloadInfo.isOnlyWifi()) {
                            m18088a2 = C12360q.m18088a("tt_appdownloader_notification_download_waiting_wifi");
                        } else {
                            m18088a2 = C12360q.m18088a("tt_appdownloader_notification_download_waiting_net");
                        }
                        string3 = this.f34791a.getResources().getString(m18088a2);
                    } else {
                        string3 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_download_failed"));
                    }
                    String str7 = string3;
                    string4 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_download_restart"));
                    m18121q.setViewVisibility(C12330n.m18144r(), 8);
                    if (m17599ok.m17607a("enable_notification_ui") >= 2 && m16865n() == -1) {
                        if (C12713kf.m16525q(baseException)) {
                            if (C12713kf.m16618a(baseException2, downloadInfo)) {
                                str2 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_no_wifi_and_in_net"));
                                builder = builder;
                                string4 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_download_resume"));
                            } else {
                                str2 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_no_internet_error"));
                                builder = builder;
                            }
                            i2 = 0;
                        } else if (C12713kf.m16528p(baseException)) {
                            builder = builder;
                            i2 = 0;
                            str2 = this.f34791a.getResources().getString(C12360q.m18088a("tt_appdownloader_notification_insufficient_space_error"), C12293bl.m18444a(m16868bl - j2));
                        }
                        str3 = str2;
                    }
                    builder = builder;
                    i2 = 0;
                    str2 = str7;
                    str3 = str2;
                }
                m18121q.setViewVisibility(m18125ok(m16864ok), 8);
                m18121q.setViewVisibility(C12330n.m18145q(), i2);
                m18121q.setViewVisibility(C12330n.m18151k(), 8);
                if (m17599ok.m17607a("enable_notification_ui") >= 2 && m16865n() == -1 && (C12713kf.m16525q(baseException) || C12713kf.m16528p(baseException))) {
                    m18121q.setViewVisibility(m18125ok(m16864ok), 0);
                    m18121q.setViewVisibility(C12330n.m18145q(), 8);
                    m18121q.setViewVisibility(C12330n.m18151k(), 0);
                    int m18144r4 = C12330n.m18144r();
                    if (C12713kf.m16618a(baseException2, downloadInfo)) {
                        m18121q.setViewVisibility(m18144r4, 0);
                        str6 = C12293bl.m18427ok(j2, false) + "/" + C12293bl.m18427ok(m16868bl, false);
                        string = str3;
                        string2 = string4;
                    } else {
                        m18121q.setViewVisibility(m18144r4, 8);
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
        m18121q.setTextViewText(C12330n.m18143rh(), str6);
        m18121q.setTextViewText(C12330n.m18154i(), string);
        m18121q.setTextViewText(C12330n.m18141t(), str6);
        m18121q.setTextViewText(C12330n.m18137x(), string);
        int m18144r5 = C12330n.m18144r();
        if (TextUtils.isEmpty(string2)) {
            m18121q.setViewVisibility(m18144r5, 8);
        } else {
            m18121q.setTextViewText(m18144r5, string2);
        }
        Notification build = builder.build();
        build.contentView = m18121q;
        return build;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0044 -> B:15:0x004b). Please submit an issue!!! */
    /* renamed from: k */
    private NotificationCompat.Builder m18126k() {
        NotificationCompat.Builder builder;
        String m18044q = C12361s.m18068k().m18044q();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.f34791a);
        }
        if (TextUtils.isEmpty(m18044q)) {
            m18044q = C12293bl.m18443a(this.f34791a);
        }
        try {
            if (C12361s.m18068k().m18036z() != null) {
                builder = C12361s.m18068k().m18036z().m18381ok(this.f34791a, m18044q);
            } else {
                builder = new NotificationCompat.Builder(this.f34791a, m18044q);
            }
        } catch (NoSuchMethodError unused) {
            builder = new NotificationCompat.Builder(this.f34791a);
        }
        return builder;
    }

    /* renamed from: q */
    private RemoteViews m18121q() {
        RemoteViews remoteViews = new RemoteViews(this.f34791a.getPackageName(), C12330n.m18147ok());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (C12293bl.m18425ok(this.f34791a)) {
                    remoteViews.setInt(C12330n.m18150kf(), "setBackgroundColor", this.f34791a.getResources().getColor(C12330n.m18140td()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    @Override // com.p521ss.android.socialbase.downloader.notification.AbstractC12645ok
    /* renamed from: ok */
    public void mo16857ok(DownloadInfo downloadInfo) {
        super.mo16857ok(downloadInfo);
        this.f34794n = downloadInfo.getSavePath();
        this.f34795s = downloadInfo.getName();
        this.f34793kf = downloadInfo.getExtra();
    }

    @Override // com.p521ss.android.socialbase.downloader.notification.AbstractC12645ok
    /* renamed from: ok */
    public void mo16858ok(BaseException baseException, boolean z) {
        if (this.f34791a == null) {
            return;
        }
        try {
            Notification m18127a = m18127a(baseException, z);
            this.f35649ok = m18127a;
            m16859ok(m18127a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ok */
    private boolean m18123ok(BaseException baseException, C12534ok c12534ok, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && c12534ok.m17593ok("notification_text_opt", 0) == 1;
    }

    /* renamed from: ok */
    private int m18124ok(int i, int i2) {
        if (C12534ok.m17599ok(i2).m17607a("notification_opt_2") == 1) {
            return C12330n.m18138ul();
        }
        if (i == 1 || i == 4) {
            return C12330n.m18139u();
        }
        if (i == 2) {
            return C12330n.m18153io();
        }
        if (i == 3) {
            return C12330n.m18138ul();
        }
        return 0;
    }

    /* renamed from: ok */
    private PendingIntent m18122ok(String str, int i, int i2) {
        Intent intent = new Intent(this.f34791a, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f34791a, i2, intent, 201326592);
    }

    /* renamed from: ok */
    private int m18125ok(int i) {
        if (C12534ok.m17599ok(i).m17607a("enable_notification_ui") >= 1) {
            return C12330n.m18146p();
        }
        return C12330n.m18155h();
    }
}
