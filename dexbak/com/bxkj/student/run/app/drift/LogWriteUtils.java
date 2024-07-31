package com.bxkj.student.run.app.drift;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.bxkj.student.run.app.drift.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LogWriteUtils {

    /* renamed from: a */
    File f19085a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile();

    /* renamed from: b */
    String f19086b = "体适能跑步";

    /* renamed from: c */
    private String f19087c = new File(this.f19085a, this.f19086b).getPath();

    /* renamed from: d */
    private String f19088d;

    public LogWriteUtils(String fileName) {
        this.f19088d = fileName;
    }

    /* renamed from: a */
    private File m40070a(String filePath, String fileName) {
        m40069b(filePath);
        File file = null;
        try {
            File file2 = new File(filePath + fileName);
            try {
                if (file2.exists()) {
                    return file2;
                }
                file2.createNewFile();
                return file2;
            } catch (Exception e) {
                e = e;
                file = file2;
                e.printStackTrace();
                return file;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: b */
    private void m40069b(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        } catch (Exception e) {
            Log.i("error:", e + "");
        }
    }

    /* renamed from: c */
    public void m40068c(String textContent) {
        m40070a(this.f19087c, this.f19088d);
        String str = this.f19087c + "/" + this.f19088d;
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
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }
}
