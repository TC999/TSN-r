package com.bxkj.student.run.app.drift;

import android.os.Environment;
import android.util.Log;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LogWriteUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    File f22331a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile();

    /* renamed from: b  reason: collision with root package name */
    String f22332b = "\u4f53\u9002\u80fd\u8dd1\u6b65";

    /* renamed from: c  reason: collision with root package name */
    private String f22333c = new File(this.f22331a, this.f22332b).getPath();

    /* renamed from: d  reason: collision with root package name */
    private String f22334d;

    public b(String fileName) {
        this.f22334d = fileName;
    }

    private File a(String filePath, String fileName) {
        b(filePath);
        File file = null;
        try {
            File file2 = new File(filePath + fileName);
            try {
                if (file2.exists()) {
                    return file2;
                }
                file2.createNewFile();
                return file2;
            } catch (Exception e4) {
                e = e4;
                file = file2;
                e.printStackTrace();
                return file;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    private void b(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        } catch (Exception e4) {
            Log.i("error:", e4 + "");
        }
    }

    public void c(String textContent) {
        a(this.f22333c, this.f22334d);
        String str = this.f22333c + TTPathConst.sSeparator + this.f22334d;
        String str2 = textContent + "\r\n";
        try {
            File file = new File(str);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + str);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            randomAccessFile.seek(file.length());
            randomAccessFile.write(str2.getBytes());
            randomAccessFile.close();
        } catch (Exception e4) {
            Log.e("TestFile", "Error on write File:" + e4);
        }
    }
}
