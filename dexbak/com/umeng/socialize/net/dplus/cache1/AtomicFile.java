package com.umeng.socialize.net.dplus.cache1;

import android.util.Log;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AtomicFile {

    /* renamed from: a */
    private final File f39538a;

    /* renamed from: b */
    private final File f39539b;

    public AtomicFile(File file) {
        this.f39538a = file;
        this.f39539b = new File(file.getPath() + ".bak");
    }

    /* renamed from: a */
    private static void m13257a(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        long currentTimeMillis = System.currentTimeMillis();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                    Log.d("AtomicFile", read + "");
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    Log.d("AtomicFile", "comsum time:" + (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public void delete() {
        this.f39538a.delete();
        this.f39539b.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            m13256a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f39538a.delete();
                this.f39539b.renameTo(this.f39538a);
            } catch (IOException e) {
                SLog.error(UmengText.CACHE.CACHEFILE, e);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            m13256a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f39539b.delete();
            } catch (IOException e) {
                SLog.error(UmengText.CACHE.CACHEFILE, e);
            }
        }
    }

    public File getBaseFile() {
        return this.f39538a;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f39539b.exists()) {
            this.f39538a.delete();
            this.f39539b.renameTo(this.f39538a);
        }
        return new FileInputStream(this.f39538a);
    }

    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i = 0;
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    return bArr;
                }
                i += read;
                int available = openRead.available();
                if (available > bArr.length - i) {
                    byte[] bArr2 = new byte[available + i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    public FileOutputStream startWrite(boolean z) throws IOException {
        if (this.f39538a.exists()) {
            if (!this.f39539b.exists()) {
                if (!this.f39538a.renameTo(this.f39539b)) {
                    Log.w("AtomicFile", "Couldn't rename file " + this.f39538a + " to backup file " + this.f39539b);
                } else {
                    m13257a(this.f39539b, this.f39538a);
                }
            } else {
                this.f39538a.delete();
            }
        }
        try {
            return new FileOutputStream(this.f39538a, z);
        } catch (FileNotFoundException e) {
            if (!this.f39538a.getParentFile().mkdirs()) {
                SLog.error(UmengText.CACHE.CACHEFILE, e);
            }
            try {
                return new FileOutputStream(this.f39538a, z);
            } catch (FileNotFoundException unused) {
                SLog.error(UmengText.CACHE.CACHEFILE, e);
                return null;
            }
        }
    }

    /* renamed from: a */
    static boolean m13256a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
                return true;
            } catch (IOException e) {
                SLog.error(UmengText.CACHE.CACHEFILE, e);
                return false;
            }
        }
        return true;
    }
}
