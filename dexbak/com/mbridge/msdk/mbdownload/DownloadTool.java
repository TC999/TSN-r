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
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7282g;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.p472db.CampaignDAIDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbdownload.DownloadAgent;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
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
/* renamed from: com.mbridge.msdk.mbdownload.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadTool {

    /* renamed from: a */
    private static final String f31317a = "com.mbridge.msdk.mbdownload.e";

    /* renamed from: b */
    private SparseArray<C11469b> f31318b;

    /* renamed from: c */
    private Map<DownloadAgent.C11460a, Messenger> f31319c;

    /* renamed from: d */
    private NotificationRuntimeCache f31320d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadTool.java */
    /* renamed from: com.mbridge.msdk.mbdownload.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11469b {

        /* renamed from: a */
        WorkThread f31326a;

        /* renamed from: b */
        C11467a f31327b;

        /* renamed from: c */
        int f31328c;

        /* renamed from: d */
        int f31329d;

        /* renamed from: e */
        DownloadAgent.C11460a f31330e;

        /* renamed from: f */
        long[] f31331f = new long[3];

        public C11469b(DownloadAgent.C11460a c11460a, int i) {
            this.f31328c = i;
            this.f31330e = c11460a;
        }
    }

    /* compiled from: DownloadTool.java */
    /* renamed from: com.mbridge.msdk.mbdownload.e$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class AsyncTaskC11470c extends AsyncTask<String, Void, Integer> {

        /* renamed from: a */
        public int f31332a;

        /* renamed from: b */
        public String f31333b;

        /* renamed from: d */
        private DownloadAgent.C11460a f31335d;

        /* renamed from: e */
        private Context f31336e;

        /* renamed from: f */
        private NotificationManager f31337f;

        public AsyncTaskC11470c(Context context, int i, DownloadAgent.C11460a c11460a, String str) {
            Context applicationContext = context.getApplicationContext();
            this.f31336e = applicationContext;
            this.f31337f = (NotificationManager) applicationContext.getSystemService("notification");
            NotificationUtils.m21590a();
            this.f31332a = i;
            this.f31335d = c11460a;
            this.f31333b = str;
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
                        if (SameDiTool.m21767w(this.f31336e) >= 24 && Build.VERSION.SDK_INT >= 24) {
                            Uri uri = null;
                            try {
                                if (!TextUtils.isEmpty(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH)) {
                                    Method method = Class.forName(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH).getMethod("getUriForFile", Context.class, String.class, File.class);
                                    uriForFile = (Uri) method.invoke(null, this.f31336e, this.f31336e.getApplicationContext().getPackageName() + ".mbFileProvider", new File(this.f31333b));
                                } else {
                                    Context context = this.f31336e;
                                    uriForFile = FileProvider.getUriForFile(context, this.f31336e.getApplicationContext().getPackageName() + ".mbFileProvider", new File(this.f31333b));
                                }
                                uri = uriForFile;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (uri != null) {
                                intent.setDataAndType(uri, "application/vnd.android.package-archive");
                                intent.addFlags(1);
                            }
                        } else {
                            intent.setDataAndType(Uri.fromFile(new File(this.f31333b)), "application/vnd.android.package-archive");
                        }
                    } catch (Exception unused) {
                        intent.setDataAndType(Uri.fromFile(new File(this.f31333b)), "application/vnd.android.package-archive");
                    }
                    PendingIntent activity = PendingIntent.getActivity(this.f31336e, 0, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
                    Context context2 = this.f31336e;
                    Notification m21630a = DownloadTool.m21630a(context2, MSGMapper.m21604g(context2), activity);
                    if (m21630a != null) {
                        m21630a.flags = 16;
                        this.f31337f.notify(this.f31332a + 1, m21630a);
                    }
                    if (DownloadTool.this.m21634a(this.f31336e)) {
                        this.f31337f.cancel(this.f31332a + 1);
                        this.f31336e.startActivity(intent);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("filename", this.f31333b);
                    Message obtain = Message.obtain();
                    obtain.what = 5;
                    obtain.arg1 = 1;
                    obtain.arg2 = this.f31332a;
                    obtain.setData(bundle);
                    try {
                        if (DownloadTool.this.f31319c.get(this.f31335d) != null) {
                            ((Messenger) DownloadTool.this.f31319c.get(this.f31335d)).send(obtain);
                            return;
                        }
                        return;
                    } catch (RemoteException unused2) {
                        DownloadTool.this.m21633a(this.f31336e, this.f31332a);
                        return;
                    }
                }
                this.f31337f.cancel(this.f31332a + 1);
                Bundle bundle2 = new Bundle();
                bundle2.putString("filename", this.f31333b);
                Message obtain2 = Message.obtain();
                obtain2.what = 5;
                obtain2.arg1 = 3;
                obtain2.arg2 = this.f31332a;
                obtain2.setData(bundle2);
                try {
                    if (DownloadTool.this.f31319c.get(this.f31335d) != null) {
                        ((Messenger) DownloadTool.this.f31319c.get(this.f31335d)).send(obtain2);
                    }
                } catch (RemoteException unused3) {
                    DownloadTool.this.m21633a(this.f31336e, this.f31332a);
                }
            } catch (Throwable unused4) {
            }
        }

        @Override // android.os.AsyncTask
        protected final void onPreExecute() {
            super.onPreExecute();
        }
    }

    public DownloadTool(SparseArray<C11469b> sparseArray, Map<DownloadAgent.C11460a, Messenger> map, NotificationRuntimeCache notificationRuntimeCache) {
        this.f31318b = sparseArray;
        this.f31319c = map;
        this.f31320d = notificationRuntimeCache;
    }

    /* renamed from: b */
    private void m21620b(Context context, int i) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        NotificationManager notificationManager = (NotificationManager) origApplicationContext.getSystemService("notification");
        NotificationUtils.m21590a();
        C11469b c11469b = this.f31318b.get(i);
        c11469b.f31327b.m21595e();
        m21631a(origApplicationContext, c11469b.f31327b, i, 1);
        c11469b.f31327b.m21612c(c11469b.f31330e.f31280c).m21597a(c11469b.f31330e.f31285h).m21596b(true);
        if (c11469b.f31330e.f31286i) {
            c11469b.f31327b.m21613c();
        }
        notificationManager.notify(i, c11469b.f31327b.m21611d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final C11467a m21632a(Context context, DownloadAgent.C11460a c11460a, int i, int i2) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        C11467a c11467a = new C11467a(origApplicationContext);
        PendingIntent.getActivity(origApplicationContext, 0, new Intent(), AMapEngineUtils.HALF_MAX_P20_WIDTH);
        if (c11460a.f31294q) {
            c11467a.m21595e();
            m21631a(origApplicationContext, c11467a, i, 2);
        }
        m21631a(origApplicationContext, c11467a, i, 3);
        c11467a.m21616a(c11460a.f31287j);
        MSGMapper.m21605f(origApplicationContext);
        c11467a.m21599a(17301633).m21598a(System.currentTimeMillis());
        if (c11460a.f31286i) {
            c11467a.m21619a();
        }
        C11467a m21612c = c11467a.m21612c(c11460a.f31280c);
        m21612c.m21617a((CharSequence) (i2 + "%")).m21618a(100, i2, false);
        c11467a.m21597a(c11460a.f31285h).m21596b(true);
        return c11467a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadTool.java */
    /* renamed from: com.mbridge.msdk.mbdownload.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11467a extends NotificationBuilder {

        /* renamed from: a */
        String f31321a;

        /* renamed from: b */
        String f31322b;

        /* renamed from: c */
        String f31323c;

        /* renamed from: d */
        Context f31324d;

        public C11467a(Context context) {
            super(context);
            this.f31324d = context;
        }

        /* renamed from: a */
        public final C11467a m21617a(CharSequence charSequence) {
            Context context = this.f31324d;
            int m21767w = context != null ? SameDiTool.m21767w(context) : 0;
            if (!TextUtils.isEmpty(charSequence) && charSequence.toString().contains("%")) {
                this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_progress_status", "id"), 8);
            }
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_progress_progess", "id"), 0);
            if (m21767w >= 26 && Build.VERSION.SDK_INT >= 26) {
                this.f31361j.setTextViewText(ResourceUtil.m21814a(this.f31356e, "mbridge_download_notify_progress_progess", "id"), charSequence);
            } else {
                this.f31361j.setTextViewText(ResourceUtil.m21814a(this.f31356e, "mbridge_download_notify_progress_progess", "id"), charSequence);
            }
            return this;
        }

        /* renamed from: b */
        public final C11467a m21614b(CharSequence charSequence) {
            Context context = this.f31324d;
            int m21767w = context != null ? SameDiTool.m21767w(context) : 0;
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_progress_status", "id"), 0);
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_progress_progess", "id"), 8);
            if (m21767w >= 26 && Build.VERSION.SDK_INT >= 26) {
                this.f31361j.setTextViewText(ResourceUtil.m21814a(this.f31356e, "mbridge_download_notify_progress_status", "id"), charSequence);
            } else {
                this.f31361j.setTextViewText(ResourceUtil.m21814a(this.f31356e, "mbridge_download_notify_progress_status", "id"), charSequence);
            }
            return this;
        }

        /* renamed from: c */
        public final C11467a m21612c(CharSequence charSequence) {
            Context context = this.f31324d;
            if ((context != null ? SameDiTool.m21767w(context) : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
                this.f31361j.setTextViewText(ResourceUtil.m21814a(this.f31356e, "mbridge_download_notify_target_name", "id"), charSequence);
            } else {
                this.f31361j.setTextViewText(ResourceUtil.m21814a(this.f31356e, "mbridge_download_notify_target_name", "id"), charSequence);
            }
            return this;
        }

        /* renamed from: d */
        public final Notification m21611d() {
            Context context = this.f31324d;
            if ((context != null ? SameDiTool.m21767w(context) : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
                return this.f31359h.build();
            }
            return this.f31358g.build();
        }

        /* renamed from: c */
        public final C11467a m21613c() {
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_pause", "id"), 8);
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_continue", "id"), 0);
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_progress_status", "id"), 8);
            return this;
        }

        /* renamed from: b */
        public final C11467a m21615b() {
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_pause", "id"), 8);
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_continue", "id"), 8);
            return this;
        }

        /* renamed from: a */
        public final C11467a m21616a(String str) {
            Context context = this.f31324d;
            if (context != null) {
                SameDiTool.m21767w(context);
            }
            if (!TextUtils.isEmpty(str)) {
                CommonImageLoader.m22343a(this.f31324d).m22339a(str, new CommonImageLoaderListener() { // from class: com.mbridge.msdk.mbdownload.e.a.1
                    @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
                    public final void onFailedLoad(String str2, String str3) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
                    public final void onSuccessLoad(Bitmap bitmap, String str2) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        C11467a c11467a = C11467a.this;
                        c11467a.f31361j.setImageViewBitmap(ResourceUtil.m21814a(c11467a.f31356e, "mbridge_download_notify_target_icon", "id"), bitmap);
                    }
                });
            }
            return this;
        }

        /* renamed from: a */
        public final C11467a m21619a() {
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_pause", "id"), 0);
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_continue", "id"), 8);
            this.f31361j.setViewVisibility(ResourceUtil.m21814a(this.f31324d, "mbridge_download_notify_progress_status", "id"), 8);
            return this;
        }

        /* renamed from: a */
        public final C11467a m21618a(int i, int i2, boolean z) {
            try {
                this.f31361j.setProgressBar(ResourceUtil.m21814a(this.f31356e, "mbridge_download_notify_progress", "id"), i, i2, z);
            } catch (Exception e) {
                SameLogTool.m21733d(DownloadTool.f31317a, e.getMessage());
            }
            return this;
        }
    }

    /* renamed from: b */
    public static boolean m21621b(Context context) {
        return context.getPackageManager().checkPermission(C7282g.f24944b, context.getPackageName()) == 0 && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnectedOrConnecting();
    }

    /* renamed from: a */
    private void m21631a(Context context, C11467a c11467a, int i, int i2) {
        PendingIntent m21588a = NotificationUtils.m21588a(context, NotificationUtils.m21589a(i, "continue"));
        PendingIntent m21588a2 = NotificationUtils.m21588a(context, NotificationUtils.m21589a(i, "install or active"));
        PendingIntent m21588a3 = NotificationUtils.m21588a(context, NotificationUtils.m21589a(i, "continue"));
        PendingIntent m21588a4 = NotificationUtils.m21588a(context, NotificationUtils.m21589a(i, "parent_view_click"));
        if (i2 == 1) {
            c11467a.f31361j.setOnClickPendingIntent(ResourceUtil.m21814a(context, "mbridge_download_notify_continue", "id"), m21588a);
        } else if (i2 == 2) {
            c11467a.f31361j.setOnClickPendingIntent(ResourceUtil.m21814a(context, "mbridge_download_notify_pause", "id"), m21588a3);
        } else if (i2 == 3) {
            c11467a.f31361j.setOnClickPendingIntent(ResourceUtil.m21814a(context, "mbridge_download_notify_progress_status", "id"), m21588a2);
        }
        c11467a.f31361j.setOnClickPendingIntent(ResourceUtil.m21814a(context, "mbridge_download_notify_parent_view", "id"), m21588a4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m21634a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
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
    /* renamed from: a */
    public final boolean m21628a(DownloadAgent.C11460a c11460a, boolean z, Messenger messenger) {
        if (z) {
            int nextInt = new Random().nextInt(1000);
            Map<DownloadAgent.C11460a, Messenger> map = this.f31319c;
            if (map != null) {
                for (DownloadAgent.C11460a c11460a2 : map.keySet()) {
                    String str = f31317a;
                    SameLogTool.m21738a(str, "_" + nextInt + " downling  " + c11460a2.f31280c + "   " + c11460a2.f31281d);
                }
            } else {
                String str2 = f31317a;
                SameLogTool.m21738a(str2, "_" + nextInt + "downling  null");
            }
        }
        Map<DownloadAgent.C11460a, Messenger> map2 = this.f31319c;
        if (map2 == null) {
            return false;
        }
        for (DownloadAgent.C11460a c11460a3 : map2.keySet()) {
            String str3 = c11460a.f31283f;
            if (str3 != null && str3.equals(c11460a3.f31283f)) {
                this.f31319c.put(c11460a3, messenger);
                return true;
            } else if (c11460a3.f31281d.equals(c11460a.f31281d)) {
                this.f31319c.put(c11460a3, messenger);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m21629a(DownloadAgent.C11460a c11460a) {
        for (int i = 0; i < this.f31318b.size(); i++) {
            int keyAt = this.f31318b.keyAt(i);
            String str = c11460a.f31283f;
            if (str != null && str.equals(this.f31318b.get(keyAt).f31330e.f31283f)) {
                return this.f31318b.get(keyAt).f31328c;
            }
            if (this.f31318b.get(keyAt).f31330e.f31281d.equals(c11460a.f31281d)) {
                return this.f31318b.get(keyAt).f31328c;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m21633a(Context context, int i) {
        NotificationManager notificationManager = (NotificationManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("notification");
        C11469b c11469b = this.f31318b.get(i);
        if (c11469b != null) {
            String str = f31317a;
            SameLogTool.m21738a(str, "download service clear cache " + c11469b.f31330e.f31280c);
            WorkThread workThread = c11469b.f31326a;
            if (workThread != null) {
                workThread.m21586a(2);
            }
            notificationManager.cancel(c11469b.f31328c);
            if (this.f31319c.containsKey(c11469b.f31330e)) {
                this.f31319c.remove(c11469b.f31330e);
            }
            SparseArray<C11469b> sparseArray = this.f31318b;
            if (sparseArray.indexOfKey(c11469b.f31328c) >= 0) {
                sparseArray.remove(c11469b.f31328c);
            }
            this.f31320d.m21591b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m21627a(DownloadProvider downloadProvider, Intent intent) {
        Context origApplicationContext;
        String string;
        try {
            origApplicationContext = StubApp.getOrigApplicationContext(downloadProvider.m21642c().getApplicationContext());
            string = intent.getExtras().getString("com.mbridge.msdk.broadcast.download.msg");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (string == null) {
            return false;
        }
        String[] split = string.split(":");
        int parseInt = Integer.parseInt(split[0]);
        String trim = split[1].trim();
        if (parseInt == 0 || TextUtils.isEmpty(trim) || this.f31318b.indexOfKey(parseInt) < 0) {
            return false;
        }
        C11469b c11469b = this.f31318b.get(parseInt);
        WorkThread workThread = c11469b.f31326a;
        long[] jArr = c11469b.f31331f;
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        if ("continue".equals(trim)) {
            if (workThread == null) {
                SameLogTool.m21738a(f31317a, "Receive action do play click new thread.");
                if (!m21621b(origApplicationContext)) {
                    Toast.makeText(origApplicationContext, MSGMapper.f31341d, 1).show();
                    return false;
                }
                WorkThread workThread2 = new WorkThread(downloadProvider, c11469b.f31330e, parseInt, c11469b.f31329d);
                c11469b.f31326a = workThread2;
                workThread2.start();
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.arg1 = 7;
                obtain.arg2 = parseInt;
                try {
                    if (this.f31319c.get(c11469b.f31330e) != null) {
                        this.f31319c.get(c11469b.f31330e).send(obtain);
                    }
                } catch (RemoteException e2) {
                    SameLogTool.m21735b(f31317a, "", e2);
                }
                return true;
            } else if (workThread.m21579c() == WorkThread.f31367b) {
                SameLogTool.m21738a(f31317a, "Receive action do play click.");
                if (!m21621b(origApplicationContext)) {
                    Toast.makeText(origApplicationContext, MSGMapper.f31341d, 1).show();
                    return false;
                }
                workThread.m21581b();
                Message obtain2 = Message.obtain();
                obtain2.what = 2;
                obtain2.arg1 = 7;
                obtain2.arg2 = parseInt;
                try {
                    if (this.f31319c.get(c11469b.f31330e) != null) {
                        this.f31319c.get(c11469b.f31330e).send(obtain2);
                    }
                } catch (RemoteException e3) {
                    SameLogTool.m21735b(f31317a, "", e3);
                }
                return true;
            } else {
                SameLogTool.m21738a(f31317a, "Receive action do pause click.");
                workThread.m21587a();
                try {
                    workThread.interrupt();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                m21620b(origApplicationContext, parseInt);
                Message obtain3 = Message.obtain();
                obtain3.what = 2;
                obtain3.arg1 = 6;
                obtain3.arg2 = parseInt;
                try {
                    if (this.f31319c.get(c11469b.f31330e) != null) {
                        this.f31319c.get(c11469b.f31330e).send(obtain3);
                    }
                } catch (RemoteException e5) {
                    SameLogTool.m21735b(f31317a, "", e5);
                }
                return true;
            }
        } else if (CommonNetImpl.CANCEL.equals(trim)) {
            SameLogTool.m21738a(f31317a, "Receive action do stop click.");
            try {
                if (workThread != null) {
                    try {
                        workThread.m21586a(2);
                    } catch (Exception unused) {
                        Message obtain4 = Message.obtain();
                        obtain4.what = 5;
                        obtain4.arg1 = 5;
                        obtain4.arg2 = parseInt;
                        if (this.f31319c.get(c11469b.f31330e) != null) {
                            this.f31319c.get(c11469b.f31330e).send(obtain4);
                        }
                    } catch (Throwable th) {
                        Message obtain5 = Message.obtain();
                        obtain5.what = 5;
                        obtain5.arg1 = 5;
                        obtain5.arg2 = parseInt;
                        try {
                            if (this.f31319c.get(c11469b.f31330e) != null) {
                                this.f31319c.get(c11469b.f31330e).send(obtain5);
                            }
                        } catch (RemoteException unused2) {
                            m21633a(origApplicationContext, parseInt);
                        }
                        throw th;
                    }
                }
                Message obtain6 = Message.obtain();
                obtain6.what = 5;
                obtain6.arg1 = 5;
                obtain6.arg2 = parseInt;
                if (this.f31319c.get(c11469b.f31330e) != null) {
                    this.f31319c.get(c11469b.f31330e).send(obtain6);
                }
            } catch (RemoteException unused3) {
                m21633a(origApplicationContext, parseInt);
            }
            return true;
        } else if ("install or active".equals(trim)) {
            if (workThread != null) {
                workThread.m21577d();
                return false;
            }
            m21633a(origApplicationContext, parseInt);
            return false;
        } else if ("parent_view_click".equals(trim)) {
            SameLogTool.m21738a("workthread", "clickParentView");
            int m22781c = CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(origApplicationContext)).m22781c(c11469b.f31330e.f31284g);
            if (m22781c != 5 && m22781c != 6) {
                if ((m22781c == 1 || m22781c == 9 || m22781c == 10 || m22781c == 11) && workThread != null) {
                    workThread.m21577d();
                    return false;
                }
                return false;
            }
            String str = f31317a;
            SameLogTool.m21738a(str, "Receive action clickParentView to do play click.");
            if (workThread == null) {
                SameLogTool.m21738a(str, "Receive action do play click.");
                if (!m21621b(origApplicationContext)) {
                    Toast.makeText(origApplicationContext, MSGMapper.f31341d, 1).show();
                    return false;
                }
                WorkThread workThread3 = new WorkThread(downloadProvider, c11469b.f31330e, c11469b.f31328c, c11469b.f31329d);
                c11469b.f31326a = workThread3;
                workThread3.start();
                Message obtain7 = Message.obtain();
                obtain7.what = 2;
                obtain7.arg1 = 7;
                obtain7.arg2 = c11469b.f31328c;
                try {
                    if (this.f31319c.get(c11469b.f31330e) != null) {
                        this.f31319c.get(c11469b.f31330e).send(obtain7);
                        return false;
                    }
                    return false;
                } catch (RemoteException e6) {
                    SameLogTool.m21735b(f31317a, "", e6);
                    return false;
                }
            } else if (workThread.m21579c() == WorkThread.f31367b) {
                SameLogTool.m21738a(str, "Receive action do play click.");
                if (!m21621b(origApplicationContext)) {
                    Toast.makeText(origApplicationContext, MSGMapper.f31341d, 1).show();
                    return false;
                }
                workThread.m21581b();
                Message obtain8 = Message.obtain();
                obtain8.what = 2;
                obtain8.arg1 = 7;
                obtain8.arg2 = c11469b.f31328c;
                try {
                    if (this.f31319c.get(c11469b.f31330e) != null) {
                        this.f31319c.get(c11469b.f31330e).send(obtain8);
                        return false;
                    }
                    return false;
                } catch (RemoteException e7) {
                    SameLogTool.m21735b(f31317a, "", e7);
                    return false;
                }
            } else {
                SameLogTool.m21738a(str, "Receive action do pause click.");
                workThread.m21587a();
                m21620b(origApplicationContext, c11469b.f31328c);
                Message obtain9 = Message.obtain();
                obtain9.what = 2;
                obtain9.arg1 = 6;
                obtain9.arg2 = c11469b.f31328c;
                try {
                    if (this.f31319c.get(c11469b.f31330e) != null) {
                        this.f31319c.get(c11469b.f31330e).send(obtain9);
                        return false;
                    }
                    return false;
                } catch (RemoteException e8) {
                    SameLogTool.m21735b(f31317a, "", e8);
                    return false;
                }
            }
        } else {
            return false;
        }
        e.printStackTrace();
        return false;
    }

    /* renamed from: a */
    public static String m21625a(String str) {
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
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(String.format("%02X", Byte.valueOf(digest[i])));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }

    /* renamed from: a */
    public static String m21635a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
    }

    /* renamed from: a */
    private static boolean m21624a(String str, int i, int i2, int i3) {
        try {
            Class<?> cls = Class.forName("android.os.FileUtils");
            Class<?> cls2 = Integer.TYPE;
            cls.getMethod("setPermissions", String.class, cls2, cls2, cls2).invoke(null, str, Integer.valueOf(i), -1, -1);
            return true;
        } catch (ClassNotFoundException e) {
            SameLogTool.m21737a(f31317a, "error when set permissions:", e);
            return false;
        } catch (IllegalAccessException e2) {
            SameLogTool.m21737a(f31317a, "error when set permissions:", e2);
            return false;
        } catch (IllegalArgumentException e3) {
            SameLogTool.m21737a(f31317a, "error when set permissions:", e3);
            return false;
        } catch (NoSuchMethodException e4) {
            SameLogTool.m21737a(f31317a, "error when set permissions:", e4);
            return false;
        } catch (InvocationTargetException e5) {
            SameLogTool.m21737a(f31317a, "error when set permissions:", e5);
            return false;
        }
    }

    /* renamed from: a */
    public static Notification m21630a(Context context, String str, PendingIntent pendingIntent) {
        Notification build;
        if ((context != null ? SameDiTool.m21767w(context) : 0) >= 26) {
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
                SameLogTool.m21738a("DownloadTool", th.getMessage());
                return null;
            }
        }
        build = new Notification.Builder(context).setSmallIcon(17301633).setTicker(str).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).build();
        return build;
    }

    /* renamed from: a */
    public static File m21623a(String str, Context context, boolean[] zArr) throws IOException {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_APK) + "/download/.mb" + str);
            file.mkdirs();
            if (file.exists()) {
                zArr[0] = true;
                return file;
            }
        }
        String absolutePath = context.getCacheDir().getAbsolutePath();
        new File(absolutePath).mkdir();
        m21624a(absolutePath, 505, -1, -1);
        String str2 = absolutePath + "/mbdownload";
        new File(str2).mkdir();
        m21624a(str2, 505, -1, -1);
        File file2 = new File(str2);
        zArr[0] = false;
        return file2;
    }
}
