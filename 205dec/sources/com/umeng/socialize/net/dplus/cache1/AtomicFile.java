package com.umeng.socialize.net.dplus.cache1;

import android.util.Log;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AtomicFile {

    /* renamed from: a  reason: collision with root package name */
    private final File f54113a;

    /* renamed from: b  reason: collision with root package name */
    private final File f54114b;

    public AtomicFile(File file) {
        this.f54113a = file;
        this.f54114b = new File(file.getPath() + ".bak");
    }

    private static void a(File file, File file2) throws IOException {
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
        this.f54113a.delete();
        this.f54114b.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f54113a.delete();
                this.f54114b.renameTo(this.f54113a);
            } catch (IOException e4) {
                SLog.error(UmengText.CACHE.CACHEFILE, e4);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f54114b.delete();
            } catch (IOException e4) {
                SLog.error(UmengText.CACHE.CACHEFILE, e4);
            }
        }
    }

    public File getBaseFile() {
        return this.f54113a;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f54114b.exists()) {
            this.f54113a.delete();
            this.f54114b.renameTo(this.f54113a);
        }
        return new FileInputStream(this.f54113a);
    }

    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i4 = 0;
            while (true) {
                int read = openRead.read(bArr, i4, bArr.length - i4);
                if (read <= 0) {
                    return bArr;
                }
                i4 += read;
                int available = openRead.available();
                if (available > bArr.length - i4) {
                    byte[] bArr2 = new byte[available + i4];
                    System.arraycopy(bArr, 0, bArr2, 0, i4);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    public FileOutputStream startWrite(boolean z3) throws IOException {
        if (this.f54113a.exists()) {
            if (!this.f54114b.exists()) {
                if (!this.f54113a.renameTo(this.f54114b)) {
                    Log.w("AtomicFile", "Couldn't rename file " + this.f54113a + " to backup file " + this.f54114b);
                } else {
                    a(this.f54114b, this.f54113a);
                }
            } else {
                this.f54113a.delete();
            }
        }
        try {
            return new FileOutputStream(this.f54113a, z3);
        } catch (FileNotFoundException e4) {
            if (!this.f54113a.getParentFile().mkdirs()) {
                SLog.error(UmengText.CACHE.CACHEFILE, e4);
            }
            try {
                return new FileOutputStream(this.f54113a, z3);
            } catch (FileNotFoundException unused) {
                SLog.error(UmengText.CACHE.CACHEFILE, e4);
                return null;
            }
        }
    }

    static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
                return true;
            } catch (IOException e4) {
                SLog.error(UmengText.CACHE.CACHEFILE, e4);
                return false;
            }
        }
        return true;
    }
}
