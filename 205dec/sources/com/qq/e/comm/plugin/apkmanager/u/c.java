package com.qq.e.comm.plugin.apkmanager.u;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.qq.e.comm.plugin.util.d1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class c {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b extends c {

        /* renamed from: a  reason: collision with root package name */
        private Notification.Builder f41925a;

        @Override // com.qq.e.comm.plugin.apkmanager.u.c
        public c a(String str) {
            this.f41925a.setContentText(str);
            return this;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.u.c
        public c b(String str) {
            this.f41925a.setContentTitle(str);
            return this;
        }

        private b(Context context) {
            Notification.Builder builder = new Notification.Builder(context);
            this.f41925a = builder;
            com.qq.e.comm.plugin.j.b.a(context, builder);
            this.f41925a.setSmallIcon(17301634);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.u.c
        public c a(Bitmap bitmap) {
            this.f41925a.setLargeIcon(bitmap);
            return this;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.u.c
        public c a(boolean z3) {
            this.f41925a.setAutoCancel(z3);
            return this;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.u.c
        public c a(int i4, int i5, boolean z3) {
            this.f41925a.setProgress(i4, i5, z3);
            return this;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.u.c
        public c a(PendingIntent pendingIntent) {
            this.f41925a.setContentIntent(pendingIntent);
            return this;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.u.c
        public Notification a() {
            try {
                try {
                    return this.f41925a.build();
                } catch (Throwable unused) {
                    return null;
                }
            } catch (Throwable unused2) {
                return this.f41925a.getNotification();
            }
        }
    }

    c() {
    }

    public static c a(Context context) {
        try {
            return new b(context);
        } catch (Throwable unused) {
            d1.a("Fail to init NotificationBuilder");
            return null;
        }
    }

    public abstract Notification a();

    public abstract c a(int i4, int i5, boolean z3);

    public abstract c a(PendingIntent pendingIntent);

    public abstract c a(Bitmap bitmap);

    public abstract c a(String str);

    public abstract c a(boolean z3);

    public abstract c b(String str);
}
