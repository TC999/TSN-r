package xyz.adscope.ad.tool.download.service;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.R;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.tool.request.AdScopeHttpRequest;
import xyz.adscope.ad.tool.request.inter.DownloadProgress;
import xyz.adscope.ad.tool.request.inter.IDownloadRequest;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.MD5Util;
import xyz.adscope.common.tool.utils.FileUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AppDownloadService {
    private static final AppDownloadService INSTANCE = new AppDownloadService();
    public static boolean isUpdate;
    private String PATH_APP_DOWNLOAD;
    private String PATH_APP_ROOT;
    private Notification.Builder builder;
    public Context context;
    private boolean flag = false;
    private IDownloadRequest iHttpRequest;
    private ITrackEventStatus iTrackEventStatus;
    private Notification notification;
    private NotificationManager notificationManager;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class LazyHolder {
        private LazyHolder() {
        }

        public static AppDownloadService getThis(Context context) {
            AppDownloadService.INSTANCE.context = context;
            return AppDownloadService.INSTANCE;
        }
    }

    private AppDownloadService() {
        if (AdScopeSDK.getContext() != null) {
            this.PATH_APP_ROOT = FileUtils.getExternalFileDirectory(AdScopeSDK.getContext()).getAbsolutePath() + File.separator;
            this.PATH_APP_DOWNLOAD = this.PATH_APP_ROOT + "ASNP/download";
        }
    }

    public static AppDownloadService getInstance(Context context) {
        return LazyHolder.getThis(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNotification() {
        if (AdScopeSDK.getContext() != null) {
            this.notificationManager = (NotificationManager) AdScopeSDK.getContext().getSystemService("notification");
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            Context context = INSTANCE.context;
            this.builder = new Notification.Builder(context, context.getPackageName());
        } else {
            this.builder = new Notification.Builder(INSTANCE.context);
        }
        Notification.Builder autoCancel = this.builder.setContentTitle(this.context.getString(R.string.adscope_now_downloading)).setSmallIcon(R.mipmap.asnp_download_icon).setDefaults(4).setPriority(2).setAutoCancel(false);
        autoCancel.setContentText(this.context.getString(R.string.adscope_download_progress) + "0%").setProgress(100, 0, false);
        if (i4 >= 26) {
            AppDownloadService appDownloadService = INSTANCE;
            NotificationChannel notificationChannel = new NotificationChannel(appDownloadService.context.getPackageName(), appDownloadService.context.getPackageName(), 3);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-16711936);
            notificationChannel.setShowBadge(false);
            NotificationManager notificationManager = this.notificationManager;
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        this.notification = this.builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void installApk(String str) {
        try {
            File file = new File(str);
            String str2 = Constants.TAG;
            LogUtil.i(str2, "installApk() file.toString : " + file.toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setFlags(1);
                if (AdScopeSDK.getContext() != null) {
                    Context context = AdScopeSDK.getContext();
                    intent.setDataAndType(FileProvider.getUriForFile(context, AdScopeSDK.getContext().getPackageName() + ".fileprovider", file), "application/vnd.android.package-archive");
                }
            } else {
                intent.setDataAndType(Uri.parse("file://" + str), "application/vnd.android.package-archive");
            }
            this.context.startActivity(intent);
        } catch (Exception e4) {
            String str3 = Constants.TAG;
            LogUtil.i(str3, "e : " + e4);
        }
        NotificationManager notificationManager = this.notificationManager;
        if (notificationManager != null) {
            notificationManager.cancel(1);
        }
        ITrackEventStatus iTrackEventStatus = this.iTrackEventStatus;
        if (iTrackEventStatus != null) {
            iTrackEventStatus.installComplete();
        }
    }

    public void download(String str) {
        this.iHttpRequest = new AdScopeHttpRequest();
        String str2 = this.PATH_APP_DOWNLOAD;
        LogUtil.i(Constants.TAG, "urlPath : " + str + " , localPath : " + str2);
        this.iHttpRequest.downloadFile(str, str2, MD5Util.md5(str) + ".apk", new DownloadProgress() { // from class: xyz.adscope.ad.tool.download.service.AppDownloadService.1
            @Override // xyz.adscope.ad.tool.request.inter.DownloadProgress
            public void onException(Exception exc) {
                String str3 = Constants.TAG;
                LogUtil.i(str3, "onException() e  : " + exc.toString());
                Context context = AppDownloadService.this.context;
                Toast.makeText(context, context.getString(R.string.adscope_download_error), 0).show();
            }

            @Override // xyz.adscope.ad.tool.request.inter.DownloadProgress
            public void onFinish(String str3) {
                PendingIntent activity;
                String str4 = Constants.TAG;
                LogUtil.i(str4, "onFinish() path  : " + str3);
                if (AppDownloadService.this.iTrackEventStatus != null) {
                    AppDownloadService.this.iTrackEventStatus.downloadComplete();
                }
                AppDownloadService.this.builder.setContentTitle(AppDownloadService.this.context.getString(R.string.adscope_download_complete)).setContentText(AppDownloadService.this.context.getString(R.string.adscope_click_install)).setAutoCancel(true);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(str3), "application/vnd.android.package-archive");
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 31) {
                    activity = PendingIntent.getActivity(AppDownloadService.this.context, 0, intent, TTAdConstant.KEY_CLICK_AREA);
                } else {
                    activity = PendingIntent.getActivity(AppDownloadService.this.context, 0, intent, 1073741824);
                }
                AppDownloadService appDownloadService = AppDownloadService.this;
                appDownloadService.notification = appDownloadService.builder.setContentIntent(activity).build();
                if (AppDownloadService.this.notificationManager != null) {
                    AppDownloadService.this.notificationManager.notify(1, AppDownloadService.this.notification);
                }
                if (AppDownloadService.this.iTrackEventStatus != null) {
                    AppDownloadService.this.iTrackEventStatus.installStart();
                }
                if (i4 >= 26) {
                    if (!AppDownloadService.this.context.getPackageManager().canRequestPackageInstalls()) {
                        Intent intent2 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                        intent2.setData(Uri.parse("package:" + AppDownloadService.this.context.getPackageName()));
                        ActivityCompat.startActivityForResult((Activity) AppDownloadService.this.context, intent2, Constants.REQUEST_INSTALL_PERMISSION, null);
                        return;
                    }
                    AppDownloadService.this.installApk(str3);
                    return;
                }
                AppDownloadService.this.installApk(str3);
            }

            @Override // xyz.adscope.ad.tool.request.inter.DownloadProgress
            public void onProgress(int i4, long j4, long j5) {
                String str3 = Constants.TAG;
                LogUtil.i(str3, "onProgress() progress : " + i4 + " , byteCount : " + j4 + " , speed : " + j5);
                AppDownloadService.this.builder.setProgress(100, i4, false);
                Notification.Builder builder = AppDownloadService.this.builder;
                StringBuilder sb = new StringBuilder();
                sb.append(AppDownloadService.this.context.getString(R.string.adscope_download_progress));
                sb.append(i4);
                sb.append("%");
                builder.setContentText(sb.toString());
                AppDownloadService appDownloadService = AppDownloadService.this;
                appDownloadService.notification = appDownloadService.builder.build();
                if (AppDownloadService.this.notificationManager != null) {
                    AppDownloadService.this.notificationManager.notify(1, AppDownloadService.this.notification);
                }
            }

            @Override // xyz.adscope.ad.tool.request.inter.DownloadProgress
            public void onStart() {
                if (AppDownloadService.this.iTrackEventStatus != null) {
                    AppDownloadService.this.iTrackEventStatus.startDownload();
                }
                AppDownloadService.this.initNotification();
            }
        });
    }
}
