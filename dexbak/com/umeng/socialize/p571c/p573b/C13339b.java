package com.umeng.socialize.p571c.p573b;

import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: FileUtil.java */
/* renamed from: com.umeng.socialize.c.b.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13339b {

    /* renamed from: a */
    private static final C13339b f39403a = new C13339b();

    private C13339b() {
    }

    /* renamed from: a */
    public static C13339b m13296a() {
        return f39403a;
    }

    /* renamed from: b */
    public File m13294b() throws IOException {
        File file = new File(m13293c(), m13292d());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    /* renamed from: c */
    public File m13293c() {
        File file = new File(ContextUtil.getContext().getExternalFilesDir(null), ImageConstants.f39404a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: d */
    public String m13292d() {
        String hexdigest = SocializeUtils.hexdigest(String.valueOf(System.currentTimeMillis()));
        return hexdigest + ".jpg";
    }

    /* renamed from: a */
    public byte[] m13295a(File file) {
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
                } catch (IOException e) {
                    SLog.error(UmengText.IMAGE.CLOSE, e);
                }
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                try {
                    SLog.error(UmengText.IMAGE.READ_IMAGE_ERROR, th);
                    if (fileInputStream != null) {
                        try {
                        } catch (IOException e2) {
                            return DefaultClass.getBytes();
                        }
                    }
                    return DefaultClass.getBytes();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            SLog.error(UmengText.IMAGE.CLOSE, e22);
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
