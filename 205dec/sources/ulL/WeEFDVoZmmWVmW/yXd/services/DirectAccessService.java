package ulL.WeEFDVoZmmWVmW.yXd.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class DirectAccessService extends BaseService {
    @Override // ulL.WeEFDVoZmmWVmW.yXd.services.BaseService
    public boolean checkFileAccess(String str, int i4) {
        File file = new File(str);
        if (i4 != 0 || file.exists()) {
            if ((i4 & 4) == 0 || file.canRead()) {
                if ((i4 & 2) == 0 || file.canWrite()) {
                    return (i4 & 1) == 0 || file.canExecute();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.services.BaseService
    public boolean checkFileExists(String str) {
        return new File(str).exists();
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.services.BaseService
    public InputStream getFileInputStream(String str) {
        return new BufferedInputStream(new FileInputStream(str), 16384);
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.services.BaseService
    public boolean hasDirectFileAccess() {
        return true;
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.services.BaseService
    public byte[] readFile(String str) {
        File file = new File(str);
        byte[] bArr = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bArr);
        fileInputStream.close();
        return bArr;
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.services.BaseService
    public FileResult statFile(String str) {
        File file = new File(str);
        return new FileResult(file.length(), file.lastModified());
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.services.BaseService
    public FileResult getFileInputStream(String str, long j4, long j5) {
        File file = new File(str);
        long length = file.length();
        long lastModified = file.lastModified();
        if (j4 == length && j5 == lastModified) {
            return new FileResult(length, lastModified);
        }
        return new FileResult(new BufferedInputStream(new FileInputStream(str), 16384), length, lastModified);
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.services.BaseService
    public FileResult readFile(String str, long j4, long j5) {
        File file = new File(str);
        long length = file.length();
        long lastModified = file.lastModified();
        if (j4 == length && j5 == lastModified) {
            return new FileResult(length, lastModified);
        }
        return new FileResult(readFile(str), length, lastModified);
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.services.BaseService
    public FileResult readFile(String str, int i4, int i5, long j4, long j5) {
        File file = new File(str);
        long length = file.length();
        long lastModified = file.lastModified();
        if (j4 == length && j5 == lastModified) {
            return new FileResult(length, lastModified);
        }
        if (i4 > 0 || i5 > 0) {
            if (i4 > 0 && i4 >= length) {
                throw new IllegalArgumentException("Offset " + i4 + " is out of range for " + str);
            }
            if (i4 < 0) {
                i4 = 0;
            }
            if (i5 > 0 && i4 + i5 > length) {
                throw new IllegalArgumentException("Length " + i5 + " is out of range for " + str);
            }
            if (i5 <= 0) {
                i5 = (int) (length - i4);
            }
            byte[] bArr = new byte[i5];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.skip(i4);
            fileInputStream.read(bArr);
            fileInputStream.close();
            return new FileResult(bArr, length, lastModified);
        }
        return new FileResult(readFile(str), length, lastModified);
    }
}
