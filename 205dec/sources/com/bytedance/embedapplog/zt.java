package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.xv;
import com.bytedance.embedapplog.yh;
import com.bytedance.embedapplog.zg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class zt implements zg {

    /* renamed from: w  reason: collision with root package name */
    private static final oh<Boolean> f26864w = new oh<Boolean>() { // from class: com.bytedance.embedapplog.zt.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.oh
        /* renamed from: xv */
        public Boolean c(Object... objArr) {
            return Boolean.valueOf(zr.c((Context) objArr[0]));
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private String f26865c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends zg.c {

        /* renamed from: c  reason: collision with root package name */
        long f26867c = 0;

        c() {
        }
    }

    @Nullable
    private Pair<String, Boolean> f(Context context) {
        if (TextUtils.isEmpty(this.f26865c)) {
            return null;
        }
        return (Pair) new xv(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.f26865c), new xv.w<yh, Pair<String, Boolean>>() { // from class: com.bytedance.embedapplog.zt.2
            @Override // com.bytedance.embedapplog.xv.w
            /* renamed from: w */
            public yh c(IBinder iBinder) {
                return yh.c.c(iBinder);
            }

            @Override // com.bytedance.embedapplog.xv.w
            public Pair<String, Boolean> c(yh yhVar) {
                if (yhVar == null) {
                    return null;
                }
                return new Pair<>(yhVar.c(), Boolean.valueOf(yhVar.w()));
            }
        }).c();
    }

    private boolean ux(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f26865c = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f26865c = "com.huawei.hwid.tv";
            } else {
                this.f26865c = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean xv(Context context) {
        if (context == null) {
            return false;
        }
        return f26864w.w(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.zg
    public boolean c(Context context) {
        return ux(context);
    }

    @Override // com.bytedance.embedapplog.zg
    @Nullable
    @WorkerThread
    /* renamed from: sr */
    public c w(Context context) {
        c cVar = new c();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    cVar.f26861w = string;
                    cVar.xv = Boolean.parseBoolean(string2);
                    cVar.f26867c = 202003021704L;
                    return cVar;
                }
            } catch (Throwable th) {
                be.c(th);
            }
        }
        Pair<String, Boolean> f4 = f(context);
        if (f4 != null) {
            cVar.f26861w = (String) f4.first;
            cVar.xv = ((Boolean) f4.second).booleanValue();
            cVar.f26867c = c(context, this.f26865c);
        }
        return cVar;
    }

    private static int c(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e4) {
            be.c(e4);
            return 0;
        }
    }
}
