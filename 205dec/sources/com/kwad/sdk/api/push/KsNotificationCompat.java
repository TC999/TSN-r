package com.kwad.sdk.api.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsNotificationCompat {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class Builder {
        private NotificationCompat.Builder mBuilder;

        public Builder(@NonNull Context context, @NonNull String str) {
            try {
                this.mBuilder = new NotificationCompat.Builder(context, str);
            } catch (Throwable unused) {
                this.mBuilder = new NotificationCompat.Builder(context);
            }
        }

        @KsAdSdkApi
        @Keep
        public final Builder addAction(int i4, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mBuilder.addAction(i4, charSequence, pendingIntent);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder addExtras(Bundle bundle) {
            this.mBuilder.addExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder addPerson(String str) {
            this.mBuilder.addPerson(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Notification build() {
            return this.mBuilder.build();
        }

        @KsAdSdkApi
        @Keep
        public final Bundle getExtras() {
            return this.mBuilder.getExtras();
        }

        @KsAdSdkApi
        @Keep
        public final Notification getNotification() {
            return build();
        }

        @KsAdSdkApi
        @Keep
        public final Builder setAutoCancel(boolean z3) {
            this.mBuilder.setAutoCancel(z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setBadgeIconType(int i4) {
            this.mBuilder.setBadgeIconType(i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setCategory(String str) {
            this.mBuilder.setCategory(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setChannelId(@NonNull String str) {
            this.mBuilder.setChannelId(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setColor(@ColorInt int i4) {
            this.mBuilder.setColor(i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setColorized(boolean z3) {
            this.mBuilder.setColorized(z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContent(RemoteViews remoteViews) {
            this.mBuilder.setContent(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContentInfo(CharSequence charSequence) {
            this.mBuilder.setContentInfo(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContentIntent(PendingIntent pendingIntent) {
            this.mBuilder.setContentIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContentText(CharSequence charSequence) {
            this.mBuilder.setContentText(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContentTitle(CharSequence charSequence) {
            this.mBuilder.setContentTitle(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomBigContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setCustomContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomHeadsUpContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setDecoratedCustomStyle() {
            this.mBuilder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setDefaults(int i4) {
            this.mBuilder.setDefaults(i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mBuilder.setDeleteIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setExtras(Bundle bundle) {
            this.mBuilder.setExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z3) {
            this.mBuilder.setFullScreenIntent(pendingIntent, z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setGroup(String str) {
            this.mBuilder.setGroup(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setGroupAlertBehavior(int i4) {
            this.mBuilder.setGroupAlertBehavior(i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setGroupSummary(boolean z3) {
            this.mBuilder.setGroupSummary(z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setLargeIcon(Bitmap bitmap) {
            this.mBuilder.setLargeIcon(bitmap);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setLights(@ColorInt int i4, int i5, int i6) {
            this.mBuilder.setLights(i4, i5, i6);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setLocalOnly(boolean z3) {
            this.mBuilder.setLocalOnly(z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setNumber(int i4) {
            this.mBuilder.setNumber(i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setOngoing(boolean z3) {
            this.mBuilder.setOngoing(z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setOnlyAlertOnce(boolean z3) {
            this.mBuilder.setOnlyAlertOnce(z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setPriority(int i4) {
            this.mBuilder.setPriority(i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setProgress(int i4, int i5, boolean z3) {
            this.mBuilder.setProgress(i4, i5, z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setPublicVersion(Notification notification) {
            this.mBuilder.setPublicVersion(notification);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.mBuilder.setRemoteInputHistory(charSequenceArr);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setShortcutId(String str) {
            this.mBuilder.setShortcutId(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setShowWhen(boolean z3) {
            this.mBuilder.setShowWhen(z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSmallIcon(int i4) {
            this.mBuilder.setSmallIcon(i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSortKey(String str) {
            this.mBuilder.setSortKey(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSound(Uri uri) {
            this.mBuilder.setSound(uri);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSubText(CharSequence charSequence) {
            this.mBuilder.setSubText(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setTicker(CharSequence charSequence) {
            this.mBuilder.setTicker(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setTimeoutAfter(long j4) {
            this.mBuilder.setTimeoutAfter(j4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setUsesChronometer(boolean z3) {
            this.mBuilder.setUsesChronometer(z3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setVibrate(long[] jArr) {
            this.mBuilder.setVibrate(jArr);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setVisibility(int i4) {
            this.mBuilder.setVisibility(i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setWhen(long j4) {
            this.mBuilder.setWhen(j4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSmallIcon(int i4, int i5) {
            this.mBuilder.setSmallIcon(i4, i5);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSound(Uri uri, int i4) {
            this.mBuilder.setSound(uri, i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mBuilder.setTicker(charSequence, remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder(Context context) {
            this(context, null);
        }
    }
}
