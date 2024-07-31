package com.beizi.p051ad;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import com.beizi.p051ad.internal.utilities.DownloadFactory;
import com.beizi.p051ad.internal.utilities.ReportEventUtil;
import com.beizi.p051ad.lance.ApkBean;
import com.beizi.p051ad.lance.p062a.FileUtil;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.stub.StubApp;
import java.io.File;
import java.util.HashMap;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.beizi.ad.DownloadService */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DownloadService extends Service {

    /* renamed from: g */
    private static DownloadFactory.Download f9348g;

    /* renamed from: a */
    private long f9349a;

    /* renamed from: b */
    private String f9350b;

    /* renamed from: c */
    private DownloadManager f9351c;

    /* renamed from: d */
    private C2745a f9352d;

    /* renamed from: e */
    private C2746b f9353e;

    /* renamed from: f */
    private C2747c f9354f;

    /* renamed from: h */
    private HashMap<String, ApkBean> f9355h;

    /* renamed from: i */
    private HashMap<String, Boolean> f9356i;

    /* renamed from: j */
    private HashMap<Long, String> f9357j;

    /* renamed from: k */
    private ApkBean f9358k;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.beizi.ad.DownloadService$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2745a extends ContentObserver {
        C2745a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            int[] iArr = {0, 0, 0};
            Cursor cursor = null;
            try {
                try {
                    cursor = DownloadService.this.f9351c.query(new DownloadManager.Query().setFilterById(DownloadService.this.f9349a));
                    if (cursor != null && cursor.moveToFirst()) {
                        int i = cursor.getInt(cursor.getColumnIndex("status"));
                        LogUtil.m49046a("DownloadService", "onChange status：" + i);
                        if (i == 1) {
                            DownloadService downloadService = DownloadService.this;
                            downloadService.m50197c(downloadService.f9358k);
                        }
                        iArr[0] = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                        iArr[1] = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                        iArr[2] = cursor.getInt(cursor.getColumnIndex("status"));
                        LogUtil.m49046a("DownloadService", "progress：" + iArr[0] + "/" + iArr[1] + "");
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.beizi.ad.DownloadService$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2746b extends BroadcastReceiver {
        C2746b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                LogUtil.m49046a("DownloadService", "onReceived...download finish...begin install！");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                if (DownloadService.this.f9357j != null && DownloadService.this.f9355h != null) {
                    String str = (String) DownloadService.this.f9357j.get(Long.valueOf(longExtra));
                    if (DownloadService.this.f9356i != null) {
                        DownloadService.this.f9356i.put(str, Boolean.FALSE);
                    }
                    ApkBean apkBean = (ApkBean) DownloadService.this.f9355h.get(str);
                    if (apkBean != null) {
                        if (apkBean.getmFollowTrackExt() != null) {
                            ReportEventUtil.report(apkBean.getmFollowTrackExt().m49995c());
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                            DownloadService.this.m50207a(context, Long.valueOf(longExtra), apkBean);
                        } else if (!context.getPackageManager().canRequestPackageInstalls()) {
                            DownloadService.this.m50207a(context, Long.valueOf(longExtra), apkBean);
                        } else {
                            DownloadService.this.m50207a(context, Long.valueOf(longExtra), apkBean);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.beizi.ad.DownloadService$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2747c extends BroadcastReceiver {
        C2747c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    LogUtil.m49046a("DownloadService", "Install Success:" + schemeSpecificPart);
                    if (DownloadService.this.f9355h == null) {
                        return;
                    }
                    ApkBean apkBean = (ApkBean) DownloadService.this.f9355h.get(schemeSpecificPart);
                    if (apkBean != null) {
                        File file = new File(apkBean.getDownloadPath(), apkBean.getApkName());
                        if (file.exists()) {
                            file.delete();
                        }
                        if (apkBean.getmFollowTrackExt() != null) {
                            ReportEventUtil.report(apkBean.getmFollowTrackExt().m49991e());
                        }
                        DownloadService.this.f9355h.remove(schemeSpecificPart);
                    }
                }
                if (DownloadService.this.f9355h == null || !DownloadService.this.f9355h.isEmpty()) {
                    return;
                }
                DownloadService.this.stopSelf();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtil.m49046a("DownloadService", "DownloadService onCreate()");
        this.f9351c = (DownloadManager) getSystemService("download");
        this.f9352d = new C2745a(new Handler());
        this.f9353e = new C2746b();
        this.f9354f = new C2747c();
        this.f9355h = new HashMap<>();
        this.f9356i = new HashMap<>();
        this.f9357j = new HashMap<>();
        m50209a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LogUtil.m49046a("DownloadService", "DownloadService onDestroy()");
        m50202b();
        m50199c();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Bundle bundleExtra;
        if (intent == null) {
            return 1;
        }
        LogUtil.m49046a("DownloadService", "DownloadService onStartCommand()");
        if (intent != null) {
            try {
                if (intent.getExtras() != null && (bundleExtra = intent.getBundleExtra("data")) != null && bundleExtra.containsKey("apkBean")) {
                    this.f9358k = (ApkBean) bundleExtra.getSerializable("apkBean");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        m50203a(this.f9358k);
        return super.onStartCommand(intent, i, i2);
    }

    /* renamed from: b */
    private void m50202b() {
        getContentResolver().unregisterContentObserver(this.f9352d);
        unregisterReceiver(this.f9353e);
        unregisterReceiver(this.f9354f);
        LogUtil.m49046a("DownloadService", "unregister()");
    }

    /* renamed from: c */
    private void m50199c() {
        DownloadFactory.Download download = f9348g;
        if (download != null) {
            download.destroy();
        }
        if (this.f9356i != null) {
            this.f9356i = null;
        }
        if (this.f9355h != null) {
            this.f9355h = null;
        }
        if (this.f9357j != null) {
            this.f9357j = null;
        }
        LogUtil.m49046a("DownloadService", "releaseResources()");
    }

    /* renamed from: d */
    private void m50195d(ApkBean apkBean) {
        LogUtil.m49046a("DownloadService", "BEGIN_INSTALL!");
        if (apkBean.getmFollowTrackExt() != null) {
            ReportEventUtil.report(apkBean.getmFollowTrackExt().m49993d());
        }
    }

    /* renamed from: a */
    private void m50209a() {
        getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.f9352d);
        registerReceiver(this.f9353e, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_INSTALL");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.f9354f, intentFilter);
    }

    /* renamed from: b */
    private synchronized void m50200b(ApkBean apkBean) {
        Uri uriForFile;
        HashMap<String, Boolean> hashMap = this.f9356i;
        if (hashMap != null && hashMap.get(apkBean.getPkgName()) != null && this.f9356i.get(apkBean.getPkgName()).booleanValue()) {
            LogUtil.m49046a("DownloadService", "downloading..." + apkBean.getPkgName() + "...please not repeat click");
            Toast.makeText(this, "正在下载…请勿重复点击", 0).show();
            return;
        }
        String downloadPath = apkBean.getDownloadPath();
        File file = new File(downloadPath, apkBean.getPkgName() + ".zip");
        if (file.exists()) {
            file.delete();
            LogUtil.m49046a("DownloadService", "apkCacheFile......remove:" + file.exists());
        }
        File file2 = new File(apkBean.getDownloadPath(), apkBean.getApkName());
        if (file2.exists()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                if (Build.VERSION.SDK_INT < 24) {
                    uriForFile = Uri.fromFile(file2);
                } else {
                    uriForFile = FileProvider.getUriForFile(this, apkBean.getAuthorities(), file2);
                    intent.addFlags(3);
                }
                if (uriForFile != null) {
                    intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                    startActivity(intent);
                    m50195d(apkBean);
                }
            } catch (Exception e) {
                Log.d("lance", "apkFile.exists():" + e);
            }
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(apkBean.getApkUrl()));
            request.setTitle(apkBean.getApkTittleName());
            request.setDescription(apkBean.getApkDesc());
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(file));
            request.setMimeType("application/vnd.android.package-archive");
            this.f9349a = this.f9351c.enqueue(request);
            LogUtil.m49045b("DownloadService", "mReqId:" + this.f9349a);
            HashMap<Long, String> hashMap2 = this.f9357j;
            if (hashMap2 != null) {
                hashMap2.put(Long.valueOf(this.f9349a), apkBean.getPkgName());
            }
            HashMap<String, Boolean> hashMap3 = this.f9356i;
            if (hashMap3 != null) {
                hashMap3.put(apkBean.getPkgName(), Boolean.TRUE);
            }
            Toast.makeText(this, "已开始下载…", 0).show();
            LogUtil.m49046a("DownloadService", "BEGIN_DOWNLOAD!");
            if (apkBean.getmFollowTrackExt() != null) {
                ReportEventUtil.report(apkBean.getmFollowTrackExt().m49997b());
            }
        } catch (Exception e2) {
            Log.d("lance", "DownloadManager download fail:" + e2);
            try {
                if (!TextUtils.isEmpty(apkBean.getApkUrl()) && apkBean.getApkUrl().contains(IDataSource.f43971a)) {
                    HashMap<String, Boolean> hashMap4 = this.f9356i;
                    if (hashMap4 != null) {
                        hashMap4.put(apkBean.getPkgName(), Boolean.TRUE);
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(apkBean.getApkUrl()));
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                }
            } catch (Exception e3) {
                Log.d("lance", "skip browser fail:" + e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m50197c(final ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        LogUtil.m49046a("DownloadService", "--appUpdate downloadApk start--");
        DownloadFactory.Download create = DownloadFactory.create();
        f9348g = create;
        create.register(new DownloadFactory.DownloadDelegate() { // from class: com.beizi.ad.DownloadService.1
            @Override // com.beizi.p051ad.internal.utilities.DownloadFactory.DownloadDelegate
            public boolean onCheck(File file) {
                return true;
            }

            @Override // com.beizi.p051ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onFail(int i) {
                LogUtil.m49046a("DownloadService", "--appUpdate downloadApk onFail--");
                try {
                    String apkUrl = apkBean.getApkUrl();
                    if (TextUtils.isEmpty(apkUrl) || !apkUrl.contains(IDataSource.f43971a)) {
                        return;
                    }
                    if (DownloadService.this.f9356i != null) {
                        DownloadService.this.f9356i.put(apkBean.getPkgName(), Boolean.TRUE);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(apkUrl));
                    intent.setFlags(268435456);
                    DownloadService.this.startActivity(intent);
                } catch (Exception e) {
                    LogUtil.m49046a("DownloadService", "skip browser fail:" + e);
                }
            }

            @Override // com.beizi.p051ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onProgress(long j, long j2) {
            }

            @Override // com.beizi.p051ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onSuccess(File file) {
                LogUtil.m49046a("DownloadService", "--appUpdate downloadApk onSuccess--");
                if (DownloadService.this.f9356i != null) {
                    DownloadService.this.f9356i.put(apkBean.getPkgName(), Boolean.FALSE);
                }
                DownloadService.this.m50207a(StubApp.getOrigApplicationContext(DownloadService.this.getApplicationContext()), -1L, apkBean);
            }
        });
        f9348g.start(new DownloadFactory.Request(apkBean.getApkUrl(), apkBean.getDownloadPath(), apkBean.getApkName()));
    }

    /* renamed from: a */
    private void m50203a(ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        HashMap<String, ApkBean> hashMap = this.f9355h;
        if (hashMap != null) {
            hashMap.put(apkBean.getPkgName(), apkBean);
        }
        HashMap<String, Boolean> hashMap2 = this.f9356i;
        if (hashMap2 != null && hashMap2.get(apkBean.getPkgName()) == null) {
            LogUtil.m49046a("DownloadService", "not have package status...");
            this.f9356i.put(apkBean.getPkgName(), Boolean.FALSE);
        }
        if (TextUtils.isEmpty(apkBean.getAuthorities())) {
            this.f9350b = getPackageName() + ".fileprovider";
        } else {
            this.f9350b = apkBean.getAuthorities();
        }
        FileUtil.m49058a(apkBean.getDownloadPath());
        m50200b(apkBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50207a(Context context, Long l, ApkBean apkBean) {
        Uri uriForFile;
        try {
            String downloadPath = apkBean.getDownloadPath();
            File file = new File(downloadPath, apkBean.getPkgName() + ".zip");
            if (file.exists()) {
                File file2 = new File(apkBean.getDownloadPath(), apkBean.getApkName());
                file.renameTo(file2);
                LogUtil.m49046a("DownloadService", "apkFile......raName:" + file2.exists());
            }
            Uri uri = null;
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            int i = Build.VERSION.SDK_INT;
            if (i < 23) {
                uriForFile = this.f9351c.getUriForDownloadedFile(l.longValue());
                if (uriForFile != null) {
                    uriForFile = Uri.parse(uriForFile.toString().replace(".zip", ".apk"));
                    LogUtil.m49046a("DownloadService", "uri......" + uriForFile);
                }
            } else if (i < 24) {
                File m50208a = m50208a(context, l.longValue());
                if (m50208a != null && (uri = Uri.fromFile(m50208a)) != null) {
                    uri = Uri.parse(uri.toString().replace(".zip", ".apk"));
                    LogUtil.m49046a("DownloadService", "uri......" + uri);
                }
                uriForFile = uri;
            } else {
                uriForFile = FileProvider.getUriForFile(context, this.f9350b, new File(apkBean.getDownloadPath(), apkBean.getApkName()));
                intent.addFlags(3);
            }
            if (uriForFile != null) {
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                context.startActivity(intent);
                m50195d(apkBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static File m50208a(Context context, long j) {
        Cursor query;
        String path;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        File file = null;
        if (j != -1) {
            DownloadManager.Query query2 = new DownloadManager.Query();
            query2.setFilterById(j);
            query2.setFilterByStatus(8);
            if (downloadManager != null && (query = downloadManager.query(query2)) != null) {
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndex("local_uri"));
                    if (!TextUtils.isEmpty(string) && (path = Uri.parse(string).getPath()) != null) {
                        file = new File(path);
                    }
                }
                query.close();
            }
        }
        return file;
    }
}
