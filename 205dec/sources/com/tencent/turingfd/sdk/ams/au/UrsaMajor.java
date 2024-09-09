package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileOutputStream;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class UrsaMajor {
    public static boolean a() {
        Context context;
        File file;
        byte[] decode = Base64.decode("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", 2);
        synchronized (Ctry.class) {
            context = Ctry.f52366a;
        }
        if (context != null) {
            file = context.getCodeCacheDir();
        } else {
            String property = System.getProperty("java.io.tmpdir");
            if (!TextUtils.isEmpty(property)) {
                File file2 = new File(property);
                if (file2.exists()) {
                    file = file2;
                }
            }
            file = null;
        }
        if (file == null) {
            return false;
        }
        File file3 = new File(file, System.currentTimeMillis() + ".dex");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            fileOutputStream.write(decode);
            fileOutputStream.close();
            boolean booleanValue = ((Boolean) new DexFile(file3).loadClass("com.turingfd.ref.a", null).getDeclaredMethod("a", new Class[0]).invoke(null, new Object[0])).booleanValue();
            if (file3.exists()) {
                file3.delete();
            }
            return booleanValue;
        } catch (Throwable unused) {
            if (file3.exists()) {
                file3.delete();
            }
            return false;
        }
    }
}
