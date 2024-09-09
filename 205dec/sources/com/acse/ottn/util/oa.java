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

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class oa {

    /* renamed from: a  reason: collision with root package name */
    private static oa f6862a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6863b = "InstallUtils";

    private oa() {
    }

    public static oa a() {
        if (f6862a == null) {
            synchronized (oa.class) {
                if (f6862a == null) {
                    f6862a = new oa();
                }
            }
        }
        return f6862a;
    }

    private void a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                fileOutputStream = null;
            }
            try {
            } catch (Exception e5) {
                e5.printStackTrace();
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
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            throw th2;
        }
    }

    private Object b() throws ObjectStreamException {
        return f6862a;
    }

    public PlunInstallModel a(String str) {
        PlunInstallModel plunInstallModel = new PlunInstallModel();
        try {
        } catch (Exception e4) {
            plunInstallModel.setVersion("0");
            String str2 = f6863b;
            Log.v(str2, "e=" + e4.getMessage());
            e4.printStackTrace();
        }
        if (HelpShopAppUtil.getContext() == null) {
            Log.v(f6863b, "context is null");
            return plunInstallModel;
        }
        PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
        if (!TextUtils.isEmpty(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString())) {
            int i4 = packageInfo.versionCode;
            Log.v(f6863b, "context is not null");
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            sb.append("");
            plunInstallModel.setVersion(sb.toString());
        }
        return plunInstallModel;
    }

    @RequiresApi(api = 17)
    public void a(File file, Activity activity) {
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
            } catch (Exception e4) {
                Log.v("readAssets", "e=" + e4.getMessage());
                e4.printStackTrace();
            }
        }
    }

    public boolean a(Activity activity) {
        InputStream inputStream;
        try {
            inputStream = activity.getResources().getAssets().open("detn.mp3");
        } catch (IOException e4) {
            e4.printStackTrace();
            inputStream = null;
        }
        if (inputStream == null) {
            Log.v("readAssets", "no file");
            return false;
        }
        return true;
    }

    public void b(Activity activity) {
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
            a(open, file);
            a(file, activity);
        } catch (IOException e4) {
            Log.v("readAssets", "e = " + e4.getMessage());
            e4.printStackTrace();
        }
    }
}
