package com.mbridge.msdk.mbdownload;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbdownload.b;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40089a = "com.mbridge.msdk.mbdownload.e";

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<b> f40090b;

    /* renamed from: c  reason: collision with root package name */
    private Map<b.a, Messenger> f40091c;

    /* renamed from: d  reason: collision with root package name */
    private i f40092d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadTool.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        k f40098a;

        /* renamed from: b  reason: collision with root package name */
        a f40099b;

        /* renamed from: c  reason: collision with root package name */
        int f40100c;

        /* renamed from: d  reason: collision with root package name */
        int f40101d;

        /* renamed from: e  reason: collision with root package name */
        b.a f40102e;

        /* renamed from: f  reason: collision with root package name */
        long[] f40103f = new long[3];

        public b(b.a aVar, int i4) {
            this.f40100c = i4;
            this.f40102e = aVar;
        }
    }

    /* compiled from: DownloadTool.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class c extends AsyncTask<String, Void, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public int f40104a;

        /* renamed from: b  reason: collision with root package name */
        public String f40105b;

        /* renamed from: d  reason: collision with root package name */
        private b.a f40107d;

        /* renamed from: e  reason: collision with root package name */
        private Context f40108e;

        /* renamed from: f  reason: collision with root package name */
        private NotificationManager f40109f;

        public c(Context context, int i4, b.a aVar, String str) {
            Context applicationContext = context.getApplicationContext();
            this.f40108e = applicationContext;
            this.f40109f = (NotificationManager) applicationContext.getSystemService("notification");
            j.a();
            this.f40104a = i4;
            this.f40107d = aVar;
            this.f40105b = str;
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Integer doInBackground(String[] strArr) {
            return 1;
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Integer num) {
            Uri uriForFile;
            try {
                if (num.intValue() == 1) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    try {
                        if (t.w(this.f40108e) >= 24 && Build.VERSION.SDK_INT >= 24) {
                            Uri uri = null;
                            try {
                                if (!TextUtils.isEmpty(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH)) {
                                    Method method = Class.forName(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH).getMethod("getUriForFile", Context.class, String.class, File.class);
                                    uriForFile = (Uri) method.invoke(null, this.f40108e, this.f40108e.getApplicationContext().getPackageName() + ".mbFileProvider", new File(this.f40105b));
                                } else {
                                    Context context = this.f40108e;
                                    uriForFile = FileProvider.getUriForFile(context, this.f40108e.getApplicationContext().getPackageName() + ".mbFileProvider", new File(this.f40105b));
                                }
                                uri = uriForFile;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            if (uri != null) {
                                intent.setDataAndType(uri, "application/vnd.android.package-archive");
                                intent.addFlags(1);
                            }
                        } else {
                            intent.setDataAndType(Uri.fromFile(new File(this.f40105b)), "application/vnd.android.package-archive");
                        }
                    } catch (Exception unused) {
                        intent.setDataAndType(Uri.fromFile(new File(this.f40105b)), "application/vnd.android.package-archive");
                    }
                    PendingIntent activity = PendingIntent.getActivity(this.f40108e, 0, intent, 134217728);
                    Context context2 = this.f40108e;
                    Notification a4 = e.a(context2, g.g(context2), activity);
                    if (a4 != null) {
                        a4.flags = 16;
                        this.f40109f.notify(this.f40104a + 1, a4);
                    }
                    if (e.this.a(this.f40108e)) {
                        this.f40109f.cancel(this.f40104a + 1);
                        this.f40108e.startActivity(intent);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("filename", this.f40105b);
                    Message obtain = Message.obtain();
                    obtain.what = 5;
                    obtain.arg1 = 1;
                    obtain.arg2 = this.f40104a;
                    obtain.setData(bundle);
                    try {
                        if (e.this.f40091c.get(this.f40107d) != null) {
                            ((Messenger) e.this.f40091c.get(this.f40107d)).send(obtain);
                            return;
                        }
                        return;
                    } catch (RemoteException unused2) {
                        e.this.a(this.f40108e, this.f40104a);
                        return;
                    }
                }
                this.f40109f.cancel(this.f40104a + 1);
                Bundle bundle2 = new Bundle();
                bundle2.putString("filename", this.f40105b);
                Message obtain2 = Message.obtain();
                obtain2.what = 5;
                obtain2.arg1 = 3;
                obtain2.arg2 = this.f40104a;
                obtain2.setData(bundle2);
                try {
                    if (e.this.f40091c.get(this.f40107d) != null) {
                        ((Messenger) e.this.f40091c.get(this.f40107d)).send(obtain2);
                    }
                } catch (RemoteException unused3) {
                    e.this.a(this.f40108e, this.f40104a);
                }
            } catch (Throwable unused4) {
            }
        }

        @Override // android.os.AsyncTask
        protected final void onPreExecute() {
            super.onPreExecute();
        }
    }

    public e(SparseArray<b> sparseArray, Map<b.a, Messenger> map, i iVar) {
        this.f40090b = sparseArray;
        this.f40091c = map;
        this.f40092d = iVar;
    }

    private void b(Context context, int i4) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        NotificationManager notificationManager = (NotificationManager) origApplicationContext.getSystemService("notification");
        j.a();
        b bVar = this.f40090b.get(i4);
        bVar.f40099b.e();
        a(origApplicationContext, bVar.f40099b, i4, 1);
        bVar.f40099b.c(bVar.f40102e.f40052c).a(bVar.f40102e.f40057h).b(true);
        if (bVar.f40102e.f40058i) {
            bVar.f40099b.c();
        }
        notificationManager.notify(i4, bVar.f40099b.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a a(Context context, b.a aVar, int i4, int i5) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        a aVar2 = new a(origApplicationContext);
        PendingIntent.getActivity(origApplicationContext, 0, new Intent(), 134217728);
        if (aVar.f40066q) {
            aVar2.e();
            a(origApplicationContext, aVar2, i4, 2);
        }
        a(origApplicationContext, aVar2, i4, 3);
        aVar2.a(aVar.f40059j);
        g.f(origApplicationContext);
        aVar2.a(17301633).a(System.currentTimeMillis());
        if (aVar.f40058i) {
            aVar2.a();
        }
        a c4 = aVar2.c(aVar.f40052c);
        c4.a((CharSequence) (i5 + "%")).a(100, i5, false);
        aVar2.a(aVar.f40057h).b(true);
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadTool.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends h {

        /* renamed from: a  reason: collision with root package name */
        String f40093a;

        /* renamed from: b  reason: collision with root package name */
        String f40094b;

        /* renamed from: c  reason: collision with root package name */
        String f40095c;

        /* renamed from: d  reason: collision with root package name */
        Context f40096d;

        public a(Context context) {
            super(context);
            this.f40096d = context;
        }

        public final a a(CharSequence charSequence) {
            Context context = this.f40096d;
            int w3 = context != null ? t.w(context) : 0;
            if (!TextUtils.isEmpty(charSequence) && charSequence.toString().contains("%")) {
                this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_progress_status", "id"), 8);
            }
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_progress_progess", "id"), 0);
            if (w3 >= 26 && Build.VERSION.SDK_INT >= 26) {
                this.f40133j.setTextViewText(r.a(this.f40128e, "mbridge_download_notify_progress_progess", "id"), charSequence);
            } else {
                this.f40133j.setTextViewText(r.a(this.f40128e, "mbridge_download_notify_progress_progess", "id"), charSequence);
            }
            return this;
        }

        public final a b(CharSequence charSequence) {
            Context context = this.f40096d;
            int w3 = context != null ? t.w(context) : 0;
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_progress_status", "id"), 0);
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_progress_progess", "id"), 8);
            if (w3 >= 26 && Build.VERSION.SDK_INT >= 26) {
                this.f40133j.setTextViewText(r.a(this.f40128e, "mbridge_download_notify_progress_status", "id"), charSequence);
            } else {
                this.f40133j.setTextViewText(r.a(this.f40128e, "mbridge_download_notify_progress_status", "id"), charSequence);
            }
            return this;
        }

        public final a c(CharSequence charSequence) {
            Context context = this.f40096d;
            if ((context != null ? t.w(context) : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
                this.f40133j.setTextViewText(r.a(this.f40128e, "mbridge_download_notify_target_name", "id"), charSequence);
            } else {
                this.f40133j.setTextViewText(r.a(this.f40128e, "mbridge_download_notify_target_name", "id"), charSequence);
            }
            return this;
        }

        public final Notification d() {
            Context context = this.f40096d;
            if ((context != null ? t.w(context) : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
                return this.f40131h.build();
            }
            return this.f40130g.build();
        }

        public final a c() {
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_pause", "id"), 8);
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_continue", "id"), 0);
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_progress_status", "id"), 8);
            return this;
        }

        public final a b() {
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_pause", "id"), 8);
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_continue", "id"), 8);
            return this;
        }

        public final a a(String str) {
            Context context = this.f40096d;
            if (context != null) {
                t.w(context);
            }
            if (!TextUtils.isEmpty(str)) {
                com.mbridge.msdk.foundation.same.c.b.a(this.f40096d).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.mbdownload.e.a.1
                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public final void onFailedLoad(String str2, String str3) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public final void onSuccessLoad(Bitmap bitmap, String str2) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        a aVar = a.this;
                        aVar.f40133j.setImageViewBitmap(r.a(aVar.f40128e, "mbridge_download_notify_target_icon", "id"), bitmap);
                    }
                });
            }
            return this;
        }

        public final a a() {
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_pause", "id"), 0);
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_continue", "id"), 8);
            this.f40133j.setViewVisibility(r.a(this.f40096d, "mbridge_download_notify_progress_status", "id"), 8);
            return this;
        }

        public final a a(int i4, int i5, boolean z3) {
            try {
                this.f40133j.setProgressBar(r.a(this.f40128e, "mbridge_download_notify_progress", "id"), i4, i5, z3);
            } catch (Exception e4) {
                x.d(e.f40089a, e4.getMessage());
            }
            return this;
        }
    }

    public static boolean b(Context context) {
        return context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnectedOrConnecting();
    }

    private void a(Context context, a aVar, int i4, int i5) {
        PendingIntent a4 = j.a(context, j.a(i4, "continue"));
        PendingIntent a5 = j.a(context, j.a(i4, "install or active"));
        PendingIntent a6 = j.a(context, j.a(i4, "continue"));
        PendingIntent a7 = j.a(context, j.a(i4, "parent_view_click"));
        if (i5 == 1) {
            aVar.f40133j.setOnClickPendingIntent(r.a(context, "mbridge_download_notify_continue", "id"), a4);
        } else if (i5 == 2) {
            aVar.f40133j.setOnClickPendingIntent(r.a(context, "mbridge_download_notify_pause", "id"), a6);
        } else if (i5 == 3) {
            aVar.f40133j.setOnClickPendingIntent(r.a(context, "mbridge_download_notify_progress_status", "id"), a5);
        }
        aVar.f40133j.setOnClickPendingIntent(r.a(context, "mbridge_download_notify_parent_view", "id"), a7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(b.a aVar, boolean z3, Messenger messenger) {
        if (z3) {
            int nextInt = new Random().nextInt(1000);
            Map<b.a, Messenger> map = this.f40091c;
            if (map != null) {
                for (b.a aVar2 : map.keySet()) {
                    String str = f40089a;
                    x.a(str, "_" + nextInt + " downling  " + aVar2.f40052c + "   " + aVar2.f40053d);
                }
            } else {
                String str2 = f40089a;
                x.a(str2, "_" + nextInt + "downling  null");
            }
        }
        Map<b.a, Messenger> map2 = this.f40091c;
        if (map2 == null) {
            return false;
        }
        for (b.a aVar3 : map2.keySet()) {
            String str3 = aVar.f40055f;
            if (str3 != null && str3.equals(aVar3.f40055f)) {
                this.f40091c.put(aVar3, messenger);
                return true;
            } else if (aVar3.f40053d.equals(aVar.f40053d)) {
                this.f40091c.put(aVar3, messenger);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(b.a aVar) {
        for (int i4 = 0; i4 < this.f40090b.size(); i4++) {
            int keyAt = this.f40090b.keyAt(i4);
            String str = aVar.f40055f;
            if (str != null && str.equals(this.f40090b.get(keyAt).f40102e.f40055f)) {
                return this.f40090b.get(keyAt).f40100c;
            }
            if (this.f40090b.get(keyAt).f40102e.f40053d.equals(aVar.f40053d)) {
                return this.f40090b.get(keyAt).f40100c;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, int i4) {
        NotificationManager notificationManager = (NotificationManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("notification");
        b bVar = this.f40090b.get(i4);
        if (bVar != null) {
            String str = f40089a;
            x.a(str, "download service clear cache " + bVar.f40102e.f40052c);
            k kVar = bVar.f40098a;
            if (kVar != null) {
                kVar.a(2);
            }
            notificationManager.cancel(bVar.f40100c);
            if (this.f40091c.containsKey(bVar.f40102e)) {
                this.f40091c.remove(bVar.f40102e);
            }
            SparseArray<b> sparseArray = this.f40090b;
            if (sparseArray.indexOfKey(bVar.f40100c) >= 0) {
                sparseArray.remove(bVar.f40100c);
            }
            this.f40092d.b(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(com.mbridge.msdk.mbdownload.c cVar, Intent intent) {
        Context origApplicationContext;
        String string;
        try {
            origApplicationContext = StubApp.getOrigApplicationContext(cVar.c().getApplicationContext());
            string = intent.getExtras().getString("com.mbridge.msdk.broadcast.download.msg");
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
        if (string == null) {
            return false;
        }
        String[] split = string.split(":");
        int parseInt = Integer.parseInt(split[0]);
        String trim = split[1].trim();
        if (parseInt == 0 || TextUtils.isEmpty(trim) || this.f40090b.indexOfKey(parseInt) < 0) {
            return false;
        }
        b bVar = this.f40090b.get(parseInt);
        k kVar = bVar.f40098a;
        long[] jArr = bVar.f40103f;
        long j4 = jArr[0];
        long j5 = jArr[1];
        long j6 = jArr[2];
        if ("continue".equals(trim)) {
            if (kVar == null) {
                x.a(f40089a, "Receive action do play click new thread.");
                if (!b(origApplicationContext)) {
                    Toast.makeText(origApplicationContext, g.f40113d, 1).show();
                    return false;
                }
                k kVar2 = new k(cVar, bVar.f40102e, parseInt, bVar.f40101d);
                bVar.f40098a = kVar2;
                kVar2.start();
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.arg1 = 7;
                obtain.arg2 = parseInt;
                try {
                    if (this.f40091c.get(bVar.f40102e) != null) {
                        this.f40091c.get(bVar.f40102e).send(obtain);
                    }
                } catch (RemoteException e5) {
                    x.b(f40089a, "", e5);
                }
                return true;
            } else if (kVar.c() == k.f40139b) {
                x.a(f40089a, "Receive action do play click.");
                if (!b(origApplicationContext)) {
                    Toast.makeText(origApplicationContext, g.f40113d, 1).show();
                    return false;
                }
                kVar.b();
                Message obtain2 = Message.obtain();
                obtain2.what = 2;
                obtain2.arg1 = 7;
                obtain2.arg2 = parseInt;
                try {
                    if (this.f40091c.get(bVar.f40102e) != null) {
                        this.f40091c.get(bVar.f40102e).send(obtain2);
                    }
                } catch (RemoteException e6) {
                    x.b(f40089a, "", e6);
                }
                return true;
            } else {
                x.a(f40089a, "Receive action do pause click.");
                kVar.a();
                try {
                    kVar.interrupt();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
                b(origApplicationContext, parseInt);
                Message obtain3 = Message.obtain();
                obtain3.what = 2;
                obtain3.arg1 = 6;
                obtain3.arg2 = parseInt;
                try {
                    if (this.f40091c.get(bVar.f40102e) != null) {
                        this.f40091c.get(bVar.f40102e).send(obtain3);
                    }
                } catch (RemoteException e8) {
                    x.b(f40089a, "", e8);
                }
                return true;
            }
        } else if ("cancel".equals(trim)) {
            x.a(f40089a, "Receive action do stop click.");
            try {
                if (kVar != null) {
                    try {
                        kVar.a(2);
                    } catch (Exception unused) {
                        Message obtain4 = Message.obtain();
                        obtain4.what = 5;
                        obtain4.arg1 = 5;
                        obtain4.arg2 = parseInt;
                        if (this.f40091c.get(bVar.f40102e) != null) {
                            this.f40091c.get(bVar.f40102e).send(obtain4);
                        }
                    } catch (Throwable th) {
                        Message obtain5 = Message.obtain();
                        obtain5.what = 5;
                        obtain5.arg1 = 5;
                        obtain5.arg2 = parseInt;
                        try {
                            if (this.f40091c.get(bVar.f40102e) != null) {
                                this.f40091c.get(bVar.f40102e).send(obtain5);
                            }
                        } catch (RemoteException unused2) {
                            a(origApplicationContext, parseInt);
                        }
                        throw th;
                    }
                }
                Message obtain6 = Message.obtain();
                obtain6.what = 5;
                obtain6.arg1 = 5;
                obtain6.arg2 = parseInt;
                if (this.f40091c.get(bVar.f40102e) != null) {
                    this.f40091c.get(bVar.f40102e).send(obtain6);
                }
            } catch (RemoteException unused3) {
                a(origApplicationContext, parseInt);
            }
            return true;
        } else if ("install or active".equals(trim)) {
            if (kVar != null) {
                kVar.d();
                return false;
            }
            a(origApplicationContext, parseInt);
            return false;
        } else if ("parent_view_click".equals(trim)) {
            x.a("workthread", "clickParentView");
            int c4 = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.i.a(origApplicationContext)).c(bVar.f40102e.f40056g);
            if (c4 != 5 && c4 != 6) {
                if ((c4 == 1 || c4 == 9 || c4 == 10 || c4 == 11) && kVar != null) {
                    kVar.d();
                    return false;
                }
                return false;
            }
            String str = f40089a;
            x.a(str, "Receive action clickParentView to do play click.");
            if (kVar == null) {
                x.a(str, "Receive action do play click.");
                if (!b(origApplicationContext)) {
                    Toast.makeText(origApplicationContext, g.f40113d, 1).show();
                    return false;
                }
                k kVar3 = new k(cVar, bVar.f40102e, bVar.f40100c, bVar.f40101d);
                bVar.f40098a = kVar3;
                kVar3.start();
                Message obtain7 = Message.obtain();
                obtain7.what = 2;
                obtain7.arg1 = 7;
                obtain7.arg2 = bVar.f40100c;
                try {
                    if (this.f40091c.get(bVar.f40102e) != null) {
                        this.f40091c.get(bVar.f40102e).send(obtain7);
                        return false;
                    }
                    return false;
                } catch (RemoteException e9) {
                    x.b(f40089a, "", e9);
                    return false;
                }
            } else if (kVar.c() == k.f40139b) {
                x.a(str, "Receive action do play click.");
                if (!b(origApplicationContext)) {
                    Toast.makeText(origApplicationContext, g.f40113d, 1).show();
                    return false;
                }
                kVar.b();
                Message obtain8 = Message.obtain();
                obtain8.what = 2;
                obtain8.arg1 = 7;
                obtain8.arg2 = bVar.f40100c;
                try {
                    if (this.f40091c.get(bVar.f40102e) != null) {
                        this.f40091c.get(bVar.f40102e).send(obtain8);
                        return false;
                    }
                    return false;
                } catch (RemoteException e10) {
                    x.b(f40089a, "", e10);
                    return false;
                }
            } else {
                x.a(str, "Receive action do pause click.");
                kVar.a();
                b(origApplicationContext, bVar.f40100c);
                Message obtain9 = Message.obtain();
                obtain9.what = 2;
                obtain9.arg1 = 6;
                obtain9.arg2 = bVar.f40100c;
                try {
                    if (this.f40091c.get(bVar.f40102e) != null) {
                        this.f40091c.get(bVar.f40102e).send(obtain9);
                        return false;
                    }
                    return false;
                } catch (RemoteException e11) {
                    x.b(f40089a, "", e11);
                    return false;
                }
            }
        } else {
            return false;
        }
        e4.printStackTrace();
        return false;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i4 = 0; i4 < digest.length; i4++) {
                stringBuffer.append(String.format("%02X", Byte.valueOf(digest[i4])));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }

    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
    }

    private static boolean a(String str, int i4, int i5, int i6) {
        try {
            Class<?> cls = Class.forName("android.os.FileUtils");
            Class<?> cls2 = Integer.TYPE;
            cls.getMethod("setPermissions", String.class, cls2, cls2, cls2).invoke(null, str, Integer.valueOf(i4), -1, -1);
            return true;
        } catch (ClassNotFoundException e4) {
            x.a(f40089a, "error when set permissions:", e4);
            return false;
        } catch (IllegalAccessException e5) {
            x.a(f40089a, "error when set permissions:", e5);
            return false;
        } catch (IllegalArgumentException e6) {
            x.a(f40089a, "error when set permissions:", e6);
            return false;
        } catch (NoSuchMethodException e7) {
            x.a(f40089a, "error when set permissions:", e7);
            return false;
        } catch (InvocationTargetException e8) {
            x.a(f40089a, "error when set permissions:", e8);
            return false;
        }
    }

    public static Notification a(Context context, String str, PendingIntent pendingIntent) {
        Notification build;
        if ((context != null ? t.w(context) : 0) >= 26) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    Resources resources = context.getResources();
                    if (resources == null) {
                        build = new NotificationCompat.Builder(context, "download").setSmallIcon(17301634).setTicker(str).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).build();
                    } else {
                        build = new NotificationCompat.Builder(context, "download").setSmallIcon(17301634).setLargeIcon(BitmapFactory.decodeResource(resources, 17301634)).setTicker(str).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).build();
                    }
                    return build;
                }
            } catch (Throwable th) {
                x.a("DownloadTool", th.getMessage());
                return null;
            }
        }
        build = new Notification.Builder(context).setSmallIcon(17301633).setTicker(str).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).build();
        return build;
    }

    public static File a(String str, Context context, boolean[] zArr) throws IOException {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_APK) + "/download/.mb" + str);
            file.mkdirs();
            if (file.exists()) {
                zArr[0] = true;
                return file;
            }
        }
        String absolutePath = context.getCacheDir().getAbsolutePath();
        new File(absolutePath).mkdir();
        a(absolutePath, 505, -1, -1);
        String str2 = absolutePath + "/mbdownload";
        new File(str2).mkdir();
        a(str2, 505, -1, -1);
        File file2 = new File(str2);
        zArr[0] = false;
        return file2;
    }
}
