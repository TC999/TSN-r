package com.kwad.sdk.core.download.p396b;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9774c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.InterfaceC10750d;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.C9882a;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.C10974c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10966d;
import com.kwad.sdk.utils.C11019al;
import com.kwad.sdk.utils.C11026as;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.kwad.sdk.core.download.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10319a implements InterfaceC10750d {
    private static C10322c auA;
    private static HashMap<String, WeakReference<Bitmap>> auz = new HashMap<>();
    private static final Handler auB = new HandlerC10320a();

    /* renamed from: com.kwad.sdk.core.download.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class HandlerC10320a extends Handler {
        private final SparseArray<Long> auC;

        HandlerC10320a() {
            super(Looper.getMainLooper());
            this.auC = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = message.arg1 == 1;
            int i = message.arg2;
            boolean z2 = i == 1;
            boolean z3 = i == 2;
            Long l = this.auC.get(message.what);
            NotificationManager notificationManager = (NotificationManager) C9774c.m27790xL().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (C9774c.m27790xL().m27796bS(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else if (!z && l != null && System.currentTimeMillis() - l.longValue() < 110) {
                sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
            } else {
                if (z2) {
                    notificationManager.cancel(message.what);
                }
                C10319a.m26313a(message.what, (Notification) message.obj);
                this.auC.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.download.b.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10321b {
        private static String auD = "ksad_notification_default_icon";
        private String aaw;
        private String auE;
        private String auF;
        private String auH;
        private String name;
        private int progress;
        private File auG = null;
        private boolean auI = false;

        private C10321b() {
        }

        /* renamed from: Dk */
        public static String m26299Dk() {
            return auD;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static C10321b m26292a(DownloadTask downloadTask, String str, String str2) {
            C10321b c10321b = new C10321b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File mo24348bV = ((InterfaceC10966d) ServiceProvider.get(InterfaceC10966d.class)).mo24348bV(downloadParams.mAppIcon);
                if (mo24348bV != null && mo24348bV.exists()) {
                    c10321b.auG = mo24348bV;
                }
                c10321b.name = downloadParams.mAppName;
            }
            c10321b.auI = downloadTask.isPaused();
            c10321b.aaw = str;
            c10321b.auH = str2;
            c10321b.auE = C10319a.m26304ai(downloadTask.getSmallFileSoFarBytes()) + " / " + C10319a.m26304ai(downloadTask.getSmallFileTotalBytes());
            c10321b.auF = C10319a.m26304ai((long) downloadTask.getSmallFileTotalBytes());
            c10321b.progress = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return c10321b;
        }

        /* renamed from: Dl */
        public final String m26298Dl() {
            return this.auE;
        }

        /* renamed from: Dm */
        public final String m26297Dm() {
            return this.auF;
        }

        /* renamed from: Dn */
        public final String m26296Dn() {
            return this.aaw;
        }

        /* renamed from: Do */
        public final File m26295Do() {
            return this.auG;
        }

        /* renamed from: Dp */
        public final String m26294Dp() {
            return "正在下载 " + this.progress + "%";
        }

        /* renamed from: Dq */
        public final String m26293Dq() {
            return this.auH;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.auI;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static C10321b m26291a(DownloadParams downloadParams, String str, String str2) {
            File mo24348bV;
            C10321b c10321b = new C10321b();
            c10321b.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (mo24348bV = ((InterfaceC10966d) ServiceProvider.get(InterfaceC10966d.class)).mo24348bV(downloadParams.mAppIcon)) != null && mo24348bV.exists()) {
                c10321b.auG = mo24348bV;
            }
            c10321b.aaw = str;
            c10321b.auF = C10319a.m26304ai(downloadParams.mAppSize);
            c10321b.auH = str2;
            return c10321b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.download.b.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10322c extends BroadcastReceiver {
        /* renamed from: d */
        private static void m26288d(@NonNull Intent intent) {
            DownloadTask m26286f = m26286f(intent);
            if (m26286f == null) {
                return;
            }
            C9774c.m27790xL().m27793bU(m26286f.getId());
        }

        /* renamed from: e */
        private static void m26287e(@NonNull Intent intent) {
            DownloadTask m26286f = m26286f(intent);
            if (m26286f == null) {
                return;
            }
            m26286f.setNotificationRemoved(true);
        }

        @Nullable
        /* renamed from: f */
        private static DownloadTask m26286f(Intent intent) {
            int i = intent.getExtras().getInt("taskId", 0);
            if (i == 0) {
                return null;
            }
            return C9774c.m27790xL().m27796bS(i);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                m26288d(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                m26287e(intent);
            }
        }
    }

    /* renamed from: Dj */
    private static void m26315Dj() {
        if (auA != null) {
            return;
        }
        auA = new C10322c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        if (Build.VERSION.SDK_INT >= 33) {
            ServiceProvider.m24363KO().registerReceiver(auA, intentFilter, 2);
        } else {
            ServiceProvider.m24363KO().registerReceiver(auA, intentFilter);
        }
    }

    /* renamed from: E */
    private static Bitmap m26314E(Context context, String str) {
        WeakReference<Bitmap> weakReference = auz.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(C11026as.m24081cu(context), C11026as.m24082at(context, str));
            auz.put(str, new WeakReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m26313a(int i, Notification notification) {
        m26315Dj();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.m24363KO().getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(i, notification);
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: ai */
    public static String m26304ai(long j) {
        return String.format("%.2fMB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f));
    }

    /* renamed from: m */
    private static DownloadParams m26301m(DownloadTask downloadTask) {
        DownloadParams downloadParams;
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            downloadParams = (DownloadParams) tag;
        } else {
            downloadParams = new DownloadParams();
        }
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    /* renamed from: q */
    private static Bitmap m26300q(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = auz.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
            auz.put(absolutePath, new WeakReference<>(decodeFile));
            return decodeFile;
        }
        return bitmap;
    }

    @Override // com.kwad.sdk.InterfaceC10750d
    /* renamed from: bT */
    public final void mo24935bT(String str) {
        Context m24363KO = ServiceProvider.m24363KO();
        DownloadParams m27458cT = C9882a.m27460Bc().m27458cT(str);
        C9882a.m27460Bc().m27457cU(str);
        if (m24363KO == null || m27458cT == null) {
            return;
        }
        C9882a.m27460Bc().m27457cU(m27458cT.filePath);
        C10321b m26291a = C10321b.m26291a(m27458cT, "安装完成", "立刻打开");
        C10323b m26285aY = C10323b.m26285aY(m24363KO);
        if (m26285aY == null) {
            return;
        }
        m26311a(m24363KO, m26285aY, m26291a);
        m26312a(m24363KO, m26285aY.build(), false, false, C11019al.m24101d(m24363KO, m27458cT.mPkgname, m27458cT.mTaskId), m27458cT.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.InterfaceC10750d
    /* renamed from: bV */
    public final void mo24934bV(int i) {
        Context m24363KO = ServiceProvider.m24363KO();
        if (m24363KO == null) {
            return;
        }
        ((NotificationManager) m24363KO.getSystemService("notification")).cancel(i);
    }

    @Override // com.kwad.sdk.InterfaceC10750d
    /* renamed from: g */
    public final void mo24933g(File file) {
        Context m24363KO = ServiceProvider.m24363KO();
        if (m24363KO == null) {
            return;
        }
        DownloadParams m27458cT = C9882a.m27460Bc().m27458cT(file.getAbsolutePath());
        C9882a.m27460Bc().m27457cU(file.getAbsolutePath());
        if (m27458cT == null) {
            return;
        }
        AdTemplate m27456cV = C9882a.m27460Bc().m27456cV(m27458cT.mDownloadid);
        if (m27456cV != null) {
            m27456cV.installFrom = "recall";
        }
        C10321b m26291a = C10321b.m26291a(m27458cT, "下载完成", "立即安装");
        C10323b m26285aY = C10323b.m26285aY(m24363KO);
        if (m26285aY == null) {
            return;
        }
        m26311a(m24363KO, m26285aY, m26291a);
        m26312a(m24363KO, m26285aY.build(), false, false, C11019al.m24104a(m24363KO, file, m27458cT.mTaskId, m27458cT.requestInstallPermission), m27458cT.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.InterfaceC10750d
    /* renamed from: i */
    public final void mo24932i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File mo24348bV = ((InterfaceC10966d) ServiceProvider.get(InterfaceC10966d.class)).mo24348bV(str);
            if (mo24348bV == null || !mo24348bV.exists()) {
                ((InterfaceC10966d) ServiceProvider.get(InterfaceC10966d.class)).mo24349a(true, str, "", "");
            }
        }
    }

    @Override // com.kwad.sdk.InterfaceC10750d
    /* renamed from: j */
    public final void mo24931j(DownloadTask downloadTask) {
        Context m24363KO = ServiceProvider.m24363KO();
        if (m24363KO == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        C10321b m26292a = C10321b.m26292a(downloadTask, downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载", (String) null);
        C10324c m26284a = C10324c.m26284a(m24363KO, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (m26284a == null) {
            return;
        }
        m26309a(m24363KO, m26284a, m26292a);
        m26312a(m24363KO, m26284a.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.InterfaceC10750d
    /* renamed from: k */
    public final void mo24930k(DownloadTask downloadTask) {
        DownloadParams m26301m;
        C10323b m26285aY;
        Context m24363KO = ServiceProvider.m24363KO();
        if (m24363KO == null || (m26301m = m26301m(downloadTask)) == null || (m26285aY = C10323b.m26285aY(m24363KO)) == null) {
            return;
        }
        m26311a(m24363KO, m26285aY, C10321b.m26292a(downloadTask, "下载完成", "立即安装"));
        C9882a.m27460Bc().m27459a(downloadTask.getTargetFilePath(), m26301m);
        C9882a.m27460Bc().m27459a(m26301m.mPkgname, m26301m);
        m26312a(m24363KO, m26285aY.build(), false, false, C11019al.m24104a(m24363KO, new File(downloadTask.getTargetFilePath()), m26301m.mTaskId, m26301m.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    @Override // com.kwad.sdk.InterfaceC10750d
    /* renamed from: a */
    public final void mo24936a(DownloadTask downloadTask, boolean z) {
        C10324c m26284a;
        Context m24363KO = ServiceProvider.m24363KO();
        if (m24363KO == null || downloadTask.isNotificationRemoved() || (m26284a = C10324c.m26284a(m24363KO, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        m26309a(m24363KO, m26284a, C10321b.m26292a(downloadTask, "正在下载", (String) null));
        m26312a(m24363KO, m26284a.build(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    /* renamed from: a */
    private boolean m26305a(C10324c c10324c, File file) {
        try {
            c10324c.setIcon(m26300q(file));
            return true;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            C10974c.gatherException(e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m26308a(Context context, C10324c c10324c, String str) {
        try {
            c10324c.setIcon(m26314E(context, str));
            return true;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            C10974c.gatherException(e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m26306a(C10323b c10323b, File file) {
        try {
            c10323b.setIcon(m26300q(file));
            return true;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            C10974c.gatherException(e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m26310a(Context context, C10323b c10323b, String str) {
        try {
            c10323b.setIcon(m26314E(context, str));
            return true;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            C10974c.gatherException(e);
            return false;
        }
    }

    /* renamed from: a */
    private void m26312a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(C11026as.getAppIconId(context));
        m26307a(builder, remoteViews);
        if (z2) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra("taskId", i);
            builder.setDeleteIntent(C11019al.m24105a(context, i, intent));
        }
        Handler handler = auB;
        handler.removeMessages(i);
        handler.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    /* renamed from: a */
    private static void m26307a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    /* renamed from: a */
    private void m26309a(Context context, C10324c c10324c, C10321b c10321b) {
        c10324c.setName(c10321b.getName());
        File m26295Do = c10321b.m26295Do();
        if (!((m26295Do == null || !m26295Do.exists()) ? false : m26305a(c10324c, m26295Do))) {
            m26308a(context, c10324c, C10321b.m26299Dk());
        }
        c10324c.setStatus(c10321b.m26296Dn());
        c10324c.setSize(c10321b.m26298Dl());
        c10324c.setPercentNum(c10321b.m26294Dp());
        c10324c.setProgress(100, c10321b.getProgress(), false);
        c10324c.setControlBtnPaused(c10321b.isPaused());
    }

    /* renamed from: a */
    private void m26311a(Context context, C10323b c10323b, C10321b c10321b) {
        c10323b.setName(c10321b.getName());
        File m26295Do = c10321b.m26295Do();
        if (!((m26295Do == null || !m26295Do.exists()) ? false : m26306a(c10323b, m26295Do))) {
            m26310a(context, c10323b, C10321b.m26299Dk());
        }
        c10323b.setStatus(c10321b.m26296Dn());
        c10323b.setSize(c10321b.m26297Dm());
        c10323b.setInstallText(c10321b.m26293Dq());
    }
}
