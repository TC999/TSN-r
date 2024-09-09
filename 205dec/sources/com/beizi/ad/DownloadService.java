package com.beizi.ad;

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
import com.beizi.ad.internal.utilities.DownloadFactory;
import com.beizi.ad.internal.utilities.ReportEventUtil;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.h;
import com.beizi.ad.lance.a.l;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.stub.StubApp;
import java.io.File;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class DownloadService extends Service {

    /* renamed from: g  reason: collision with root package name */
    private static DownloadFactory.Download f13065g;

    /* renamed from: a  reason: collision with root package name */
    private long f13066a;

    /* renamed from: b  reason: collision with root package name */
    private String f13067b;

    /* renamed from: c  reason: collision with root package name */
    private DownloadManager f13068c;

    /* renamed from: d  reason: collision with root package name */
    private a f13069d;

    /* renamed from: e  reason: collision with root package name */
    private b f13070e;

    /* renamed from: f  reason: collision with root package name */
    private c f13071f;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, ApkBean> f13072h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap<String, Boolean> f13073i;

    /* renamed from: j  reason: collision with root package name */
    private HashMap<Long, String> f13074j;

    /* renamed from: k  reason: collision with root package name */
    private ApkBean f13075k;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            super.onChange(z3);
            int[] iArr = {0, 0, 0};
            Cursor cursor = null;
            try {
                try {
                    cursor = DownloadService.this.f13068c.query(new DownloadManager.Query().setFilterById(DownloadService.this.f13066a));
                    if (cursor != null && cursor.moveToFirst()) {
                        int i4 = cursor.getInt(cursor.getColumnIndex("status"));
                        l.a("DownloadService", "onChange status\uff1a" + i4);
                        if (i4 == 1) {
                            DownloadService downloadService = DownloadService.this;
                            downloadService.c(downloadService.f13075k);
                        }
                        iArr[0] = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                        iArr[1] = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                        iArr[2] = cursor.getInt(cursor.getColumnIndex("status"));
                        l.a("DownloadService", "progress\uff1a" + iArr[0] + TTPathConst.sSeparator + iArr[1] + "");
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                l.a("DownloadService", "onReceived...download finish...begin install\uff01");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                if (DownloadService.this.f13074j != null && DownloadService.this.f13072h != null) {
                    String str = (String) DownloadService.this.f13074j.get(Long.valueOf(longExtra));
                    if (DownloadService.this.f13073i != null) {
                        DownloadService.this.f13073i.put(str, Boolean.FALSE);
                    }
                    ApkBean apkBean = (ApkBean) DownloadService.this.f13072h.get(str);
                    if (apkBean != null) {
                        if (apkBean.getmFollowTrackExt() != null) {
                            ReportEventUtil.report(apkBean.getmFollowTrackExt().c());
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        } else if (!context.getPackageManager().canRequestPackageInstalls()) {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        } else {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        }
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    l.a("DownloadService", "Install Success:" + schemeSpecificPart);
                    if (DownloadService.this.f13072h == null) {
                        return;
                    }
                    ApkBean apkBean = (ApkBean) DownloadService.this.f13072h.get(schemeSpecificPart);
                    if (apkBean != null) {
                        File file = new File(apkBean.getDownloadPath(), apkBean.getApkName());
                        if (file.exists()) {
                            file.delete();
                        }
                        if (apkBean.getmFollowTrackExt() != null) {
                            ReportEventUtil.report(apkBean.getmFollowTrackExt().e());
                        }
                        DownloadService.this.f13072h.remove(schemeSpecificPart);
                    }
                }
                if (DownloadService.this.f13072h == null || !DownloadService.this.f13072h.isEmpty()) {
                    return;
                }
                DownloadService.this.stopSelf();
            } catch (Exception e4) {
                e4.printStackTrace();
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
        l.a("DownloadService", "DownloadService onCreate()");
        this.f13068c = (DownloadManager) getSystemService("download");
        this.f13069d = new a(new Handler());
        this.f13070e = new b();
        this.f13071f = new c();
        this.f13072h = new HashMap<>();
        this.f13073i = new HashMap<>();
        this.f13074j = new HashMap<>();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        l.a("DownloadService", "DownloadService onDestroy()");
        b();
        c();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        Bundle bundleExtra;
        if (intent == null) {
            return 1;
        }
        l.a("DownloadService", "DownloadService onStartCommand()");
        if (intent != null) {
            try {
                if (intent.getExtras() != null && (bundleExtra = intent.getBundleExtra("data")) != null && bundleExtra.containsKey("apkBean")) {
                    this.f13075k = (ApkBean) bundleExtra.getSerializable("apkBean");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        a(this.f13075k);
        return super.onStartCommand(intent, i4, i5);
    }

    private void b() {
        getContentResolver().unregisterContentObserver(this.f13069d);
        unregisterReceiver(this.f13070e);
        unregisterReceiver(this.f13071f);
        l.a("DownloadService", "unregister()");
    }

    private void c() {
        DownloadFactory.Download download = f13065g;
        if (download != null) {
            download.destroy();
        }
        if (this.f13073i != null) {
            this.f13073i = null;
        }
        if (this.f13072h != null) {
            this.f13072h = null;
        }
        if (this.f13074j != null) {
            this.f13074j = null;
        }
        l.a("DownloadService", "releaseResources()");
    }

    private void d(ApkBean apkBean) {
        l.a("DownloadService", "BEGIN_INSTALL!");
        if (apkBean.getmFollowTrackExt() != null) {
            ReportEventUtil.report(apkBean.getmFollowTrackExt().d());
        }
    }

    private void a() {
        getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.f13069d);
        registerReceiver(this.f13070e, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_INSTALL");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.f13071f, intentFilter);
    }

    private synchronized void b(ApkBean apkBean) {
        Uri uriForFile;
        HashMap<String, Boolean> hashMap = this.f13073i;
        if (hashMap != null && hashMap.get(apkBean.getPkgName()) != null && this.f13073i.get(apkBean.getPkgName()).booleanValue()) {
            l.a("DownloadService", "downloading..." + apkBean.getPkgName() + "...please not repeat click");
            Toast.makeText(this, "\u6b63\u5728\u4e0b\u8f7d\u2026\u8bf7\u52ff\u91cd\u590d\u70b9\u51fb", 0).show();
            return;
        }
        String downloadPath = apkBean.getDownloadPath();
        File file = new File(downloadPath, apkBean.getPkgName() + ".zip");
        if (file.exists()) {
            file.delete();
            l.a("DownloadService", "apkCacheFile......remove:" + file.exists());
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
                    d(apkBean);
                }
            } catch (Exception e4) {
                Log.d("lance", "apkFile.exists():" + e4);
            }
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(apkBean.getApkUrl()));
            request.setTitle(apkBean.getApkTittleName());
            request.setDescription(apkBean.getApkDesc());
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(file));
            request.setMimeType("application/vnd.android.package-archive");
            this.f13066a = this.f13068c.enqueue(request);
            l.b("DownloadService", "mReqId:" + this.f13066a);
            HashMap<Long, String> hashMap2 = this.f13074j;
            if (hashMap2 != null) {
                hashMap2.put(Long.valueOf(this.f13066a), apkBean.getPkgName());
            }
            HashMap<String, Boolean> hashMap3 = this.f13073i;
            if (hashMap3 != null) {
                hashMap3.put(apkBean.getPkgName(), Boolean.TRUE);
            }
            Toast.makeText(this, "\u5df2\u5f00\u59cb\u4e0b\u8f7d\u2026", 0).show();
            l.a("DownloadService", "BEGIN_DOWNLOAD!");
            if (apkBean.getmFollowTrackExt() != null) {
                ReportEventUtil.report(apkBean.getmFollowTrackExt().b());
            }
        } catch (Exception e5) {
            Log.d("lance", "DownloadManager download fail:" + e5);
            try {
                if (!TextUtils.isEmpty(apkBean.getApkUrl()) && apkBean.getApkUrl().contains("http")) {
                    HashMap<String, Boolean> hashMap4 = this.f13073i;
                    if (hashMap4 != null) {
                        hashMap4.put(apkBean.getPkgName(), Boolean.TRUE);
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(apkBean.getApkUrl()));
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                }
            } catch (Exception e6) {
                Log.d("lance", "skip browser fail:" + e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        l.a("DownloadService", "--appUpdate downloadApk start--");
        DownloadFactory.Download create = DownloadFactory.create();
        f13065g = create;
        create.register(new DownloadFactory.DownloadDelegate() { // from class: com.beizi.ad.DownloadService.1
            @Override // com.beizi.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public boolean onCheck(File file) {
                return true;
            }

            @Override // com.beizi.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onFail(int i4) {
                l.a("DownloadService", "--appUpdate downloadApk onFail--");
                try {
                    String apkUrl = apkBean.getApkUrl();
                    if (TextUtils.isEmpty(apkUrl) || !apkUrl.contains("http")) {
                        return;
                    }
                    if (DownloadService.this.f13073i != null) {
                        DownloadService.this.f13073i.put(apkBean.getPkgName(), Boolean.TRUE);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(apkUrl));
                    intent.setFlags(268435456);
                    DownloadService.this.startActivity(intent);
                } catch (Exception e4) {
                    l.a("DownloadService", "skip browser fail:" + e4);
                }
            }

            @Override // com.beizi.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onProgress(long j4, long j5) {
            }

            @Override // com.beizi.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onSuccess(File file) {
                l.a("DownloadService", "--appUpdate downloadApk onSuccess--");
                if (DownloadService.this.f13073i != null) {
                    DownloadService.this.f13073i.put(apkBean.getPkgName(), Boolean.FALSE);
                }
                DownloadService.this.a(StubApp.getOrigApplicationContext(DownloadService.this.getApplicationContext()), -1L, apkBean);
            }
        });
        f13065g.start(new DownloadFactory.Request(apkBean.getApkUrl(), apkBean.getDownloadPath(), apkBean.getApkName()));
    }

    private void a(ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        HashMap<String, ApkBean> hashMap = this.f13072h;
        if (hashMap != null) {
            hashMap.put(apkBean.getPkgName(), apkBean);
        }
        HashMap<String, Boolean> hashMap2 = this.f13073i;
        if (hashMap2 != null && hashMap2.get(apkBean.getPkgName()) == null) {
            l.a("DownloadService", "not have package status...");
            this.f13073i.put(apkBean.getPkgName(), Boolean.FALSE);
        }
        if (TextUtils.isEmpty(apkBean.getAuthorities())) {
            this.f13067b = getPackageName() + ".fileprovider";
        } else {
            this.f13067b = apkBean.getAuthorities();
        }
        h.a(apkBean.getDownloadPath());
        b(apkBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Long l4, ApkBean apkBean) {
        Uri uriForFile;
        try {
            String downloadPath = apkBean.getDownloadPath();
            File file = new File(downloadPath, apkBean.getPkgName() + ".zip");
            if (file.exists()) {
                File file2 = new File(apkBean.getDownloadPath(), apkBean.getApkName());
                file.renameTo(file2);
                l.a("DownloadService", "apkFile......raName:" + file2.exists());
            }
            Uri uri = null;
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 23) {
                uriForFile = this.f13068c.getUriForDownloadedFile(l4.longValue());
                if (uriForFile != null) {
                    uriForFile = Uri.parse(uriForFile.toString().replace(".zip", ".apk"));
                    l.a("DownloadService", "uri......" + uriForFile);
                }
            } else if (i4 < 24) {
                File a4 = a(context, l4.longValue());
                if (a4 != null && (uri = Uri.fromFile(a4)) != null) {
                    uri = Uri.parse(uri.toString().replace(".zip", ".apk"));
                    l.a("DownloadService", "uri......" + uri);
                }
                uriForFile = uri;
            } else {
                uriForFile = FileProvider.getUriForFile(context, this.f13067b, new File(apkBean.getDownloadPath(), apkBean.getApkName()));
                intent.addFlags(3);
            }
            if (uriForFile != null) {
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                context.startActivity(intent);
                d(apkBean);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static File a(Context context, long j4) {
        Cursor query;
        String path;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        File file = null;
        if (j4 != -1) {
            DownloadManager.Query query2 = new DownloadManager.Query();
            query2.setFilterById(j4);
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
