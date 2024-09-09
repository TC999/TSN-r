package com.umeng.socialize.c.b;

import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: FileUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f53990a = new b();

    private b() {
    }

    public static b a() {
        return f53990a;
    }

    public File b() throws IOException {
        File file = new File(c(), d());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    public File c() {
        File file = new File(ContextUtil.getContext().getExternalFilesDir(null), "umeng_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public String d() {
        String hexdigest = SocializeUtils.hexdigest(String.valueOf(System.currentTimeMillis()));
        return hexdigest + ".jpg";
    }

    public byte[] a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    SLog.error(UmengText.IMAGE.CLOSE, e4);
                }
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                try {
                    SLog.error(UmengText.IMAGE.READ_IMAGE_ERROR, th);
                    if (fileInputStream != null) {
                        try {
                        } catch (IOException e5) {
                            return DefaultClass.getBytes();
                        }
                    }
                    return DefaultClass.getBytes();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e52) {
                            SLog.error(UmengText.IMAGE.CLOSE, e52);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }
}
