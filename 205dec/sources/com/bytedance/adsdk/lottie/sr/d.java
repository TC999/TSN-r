package com.bytedance.adsdk.lottie.sr;

import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final f f25745a;

    public d(f fVar) {
        this.f25745a = fVar;
    }

    private File b() {
        File c4 = this.f25745a.c();
        if (c4.isFile()) {
            c4.delete();
        }
        if (!c4.exists()) {
            c4.mkdirs();
        }
        return c4;
    }

    private static String d(String str, xv xvVar, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z3 ? xvVar.c() : xvVar.xv);
        return sb.toString();
    }

    private File f(String str) throws FileNotFoundException {
        File file = new File(b(), d(str, xv.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(b(), d(str, xv.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public Pair<xv, InputStream> a(String str) {
        xv xvVar;
        try {
            File f4 = f(str);
            if (f4 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(f4);
            if (f4.getAbsolutePath().endsWith(".zip")) {
                xvVar = xv.ZIP;
            } else {
                xvVar = xv.JSON;
            }
            com.bytedance.adsdk.lottie.f.e.a("Cache hit for " + str + " at " + f4.getAbsolutePath());
            return new Pair<>(xvVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c(String str, InputStream inputStream, xv xvVar) throws IOException {
        File file = new File(b(), d(str, xvVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
            }
        } finally {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, xv xvVar) {
        File file = new File(b(), d(str, xvVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        com.bytedance.adsdk.lottie.f.e.a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        com.bytedance.adsdk.lottie.f.e.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }
}
