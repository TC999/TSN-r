package com.acse.ottn.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.acse.ottn.model.PlunInstallModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

/* renamed from: com.acse.ottn.util.oa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1688oa {

    /* renamed from: a */
    private static C1688oa f3352a = null;

    /* renamed from: b */
    private static String f3353b = "InstallUtils";

    private C1688oa() {
    }

    /* renamed from: a */
    public static C1688oa m55939a() {
        if (f3352a == null) {
            synchronized (C1688oa.class) {
                if (f3352a == null) {
                    f3352a = new C1688oa();
                }
            }
        }
        return f3352a;
    }

    /* renamed from: a */
    private void m55936a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                fileOutputStream = null;
            }
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th2;
        }
    }

    /* renamed from: b */
    private Object m55934b() throws ObjectStreamException {
        return f3352a;
    }

    /* renamed from: a */
    public PlunInstallModel m55935a(String str) {
        PlunInstallModel plunInstallModel = new PlunInstallModel();
        try {
        } catch (Exception e) {
            plunInstallModel.setVersion("0");
            String str2 = f3353b;
            Log.v(str2, "e=" + e.getMessage());
            e.printStackTrace();
        }
        if (HelpShopAppUtil.getContext() == null) {
            Log.v(f3353b, "context is null");
            return plunInstallModel;
        }
        PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
        if (!TextUtils.isEmpty(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString())) {
            int i = packageInfo.versionCode;
            Log.v(f3353b, "context is not null");
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            plunInstallModel.setVersion(sb.toString());
        }
        return plunInstallModel;
    }

    @RequiresApi(api = 17)
    /* renamed from: a */
    public void m55937a(File file, Activity activity) {
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.addFlags(1);
                    intent.addFlags(2);
                    StringBuilder sb = new StringBuilder();
                    sb.append(activity.getPackageName());
                    sb.append(".provider");
                    intent.setDataAndType(FileProvider.getUriForFile(activity, sb.toString(), file), "application/vnd.android.package-archive");
                } else {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(268435456);
                }
                if (activity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                    activity.startActivityForResult(intent, 10010);
                }
            } catch (Exception e) {
                Log.v("readAssets", "e=" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public boolean m55938a(Activity activity) {
        InputStream inputStream;
        try {
            inputStream = activity.getResources().getAssets().open("detn.mp3");
        } catch (IOException e) {
            e.printStackTrace();
            inputStream = null;
        }
        if (inputStream == null) {
            Log.v("readAssets", "no file");
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public void m55933b(Activity activity) {
        try {
            InputStream open = activity.getResources().getAssets().open("detn.mp3");
            if (open == null) {
                Log.v("readAssets", "no file");
                return;
            }
            File absoluteFile = activity.getExternalFilesDir("apk").getAbsoluteFile();
            if (!absoluteFile.exists()) {
                absoluteFile.mkdir();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(activity.getExternalFilesDir("apk").getAbsoluteFile().getPath());
            sb.append("/text.apk");
            File file = new File(sb.toString());
            file.createNewFile();
            m55936a(open, file);
            m55937a(file, activity);
        } catch (IOException e) {
            Log.v("readAssets", "e = " + e.getMessage());
            e.printStackTrace();
        }
    }
}
