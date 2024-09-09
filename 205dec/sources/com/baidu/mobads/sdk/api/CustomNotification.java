package com.baidu.mobads.sdk.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.internal.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CustomNotification {
    private static String mChannel = "down";
    @DrawableRes
    private static int mSmallIcon = 17301634;
    private NotificationCompat.Style mStyle = new NotificationCompat.DecoratedCustomViewStyle();

    public static void initNotification(@DrawableRes int i4, String str) {
        mSmallIcon = i4;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mChannel = str;
    }

    public static void setNotificationChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mChannel = str;
    }

    public static void setNotificationIcon(@DrawableRes int i4) {
        mSmallIcon = i4;
    }

    private void setRemoteViewText(RemoteViews remoteViews, int i4, String str) {
        if (remoteViews != null) {
            if (!TextUtils.isEmpty(str)) {
                remoteViews.setTextViewText(i4, str);
                remoteViews.setViewVisibility(i4, 0);
                return;
            }
            remoteViews.setViewVisibility(i4, 8);
        }
    }

    @TargetApi(16)
    public Notification getCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z3, int i4, int i5, String str6, PendingIntent pendingIntent) {
        NotificationCompat.Builder builder;
        if (bn.a(context).a() < 26) {
            builder = new NotificationCompat.Builder(context);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "down";
            }
            try {
                builder = new NotificationCompat.Builder(context, str);
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(context);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mobads_cutom_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.left_icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.left_icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.notification_title, str3);
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.content_layout, 8);
        } else {
            remoteViews.setViewVisibility(R.id.content_layout, 0);
            setRemoteViewText(remoteViews, R.id.content_text, str4);
            setRemoteViewText(remoteViews, R.id.content_status, str5);
        }
        if (i4 >= 0 && i4 <= 100) {
            int i6 = R.id.progress_bar;
            remoteViews.setProgressBar(i6, 100, i4, false);
            remoteViews.setViewVisibility(i6, 0);
        } else {
            remoteViews.setViewVisibility(R.id.progress_bar, 8);
        }
        int i7 = R.id.btn_action;
        remoteViews.setTextViewText(i7, str6);
        remoteViews.setOnClickPendingIntent(i7, pendingIntent);
        return builder.setSmallIcon(i5).setOngoing(false).setTicker(str2).setAutoCancel(z3).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }

    @TargetApi(16)
    public Notification getNewNotification(Context context, String str, boolean z3, Bitmap bitmap, String str2, String str3, int i4, boolean z4, String str4, PendingIntent pendingIntent, String str5, PendingIntent pendingIntent2) {
        NotificationCompat.Builder builder;
        if (bn.a(context).a() < 26) {
            builder = new NotificationCompat.Builder(context);
        } else {
            try {
                builder = new NotificationCompat.Builder(context, mChannel);
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(context);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.baidu_mobads_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.title, str2);
        setRemoteViewText(remoteViews, R.id.desc, str3);
        if (i4 >= 0 && i4 <= 100) {
            int i5 = R.id.progress;
            remoteViews.setProgressBar(i5, 100, i4, z4);
            remoteViews.setViewVisibility(i5, 0);
        } else {
            remoteViews.setViewVisibility(R.id.progress, 8);
        }
        int i6 = R.id.button1;
        remoteViews.setTextViewText(i6, str4);
        remoteViews.setOnClickPendingIntent(i6, pendingIntent);
        if (TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.button2, 8);
        } else {
            int i7 = R.id.button2;
            remoteViews.setViewVisibility(i7, 0);
            remoteViews.setTextViewText(i7, str5);
            remoteViews.setOnClickPendingIntent(i7, pendingIntent2);
        }
        return builder.setStyle(this.mStyle).setSmallIcon(mSmallIcon).setOngoing(false).setTicker(str).setAutoCancel(z3).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }
}
