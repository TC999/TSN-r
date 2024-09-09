package com.acse.ottn;

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
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class p1 {

    /* renamed from: a  reason: collision with root package name */
    public static p1 f6131a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f6132b = "InstallUtils";

    public static p1 a() {
        if (f6131a == null) {
            synchronized (p1.class) {
                if (f6131a == null) {
                    f6131a = new p1();
                }
            }
        }
        return f6131a;
    }

    public final Object b() throws ObjectStreamException {
        return f6131a;
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
            File file = new File(activity.getExternalFilesDir("apk").getAbsoluteFile().getPath() + "/text.apk");
            file.createNewFile();
            a(open, file);
            a(file, activity);
        } catch (IOException e4) {
            Log.v("readAssets", "e = " + e4.getMessage());
            e4.printStackTrace();
        }
    }

    public final void a(InputStream inputStream, File file) {
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

    @RequiresApi(api = 17)
    public void a(File file, Activity activity) {
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.addFlags(1);
                    intent.addFlags(2);
                    intent.setDataAndType(FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", file), "application/vnd.android.package-archive");
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

    public PlunInstallModel a(String str) {
        PlunInstallModel plunInstallModel = new PlunInstallModel();
        try {
        } catch (Exception e4) {
            plunInstallModel.setVersion("0");
            String str2 = f6132b;
            Log.v(str2, "e=" + e4.getMessage());
            e4.printStackTrace();
        }
        if (HelpShopAppUtil.getContext() == null) {
            Log.v(f6132b, "context is null");
            return plunInstallModel;
        }
        PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
        if (!TextUtils.isEmpty(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString())) {
            int i4 = packageInfo.versionCode;
            Log.v(f6132b, "context is not null");
            plunInstallModel.setVersion(i4 + "");
        }
        return plunInstallModel;
    }
}
