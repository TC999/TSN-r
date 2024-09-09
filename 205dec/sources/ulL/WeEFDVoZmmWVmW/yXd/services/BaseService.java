package ulL.WeEFDVoZmmWVmW.yXd.services;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class BaseService {
    public static final int F_OK = 0;
    public static final int R_OK = 4;
    public static final int W_OK = 2;
    public static final int X_OK = 1;

    public static void ensureAbsolutePath(String str) {
        if (!str.startsWith(TTPathConst.sSeparator)) {
            throw new IllegalArgumentException("Only absolute filenames are allowed: ".concat(str));
        }
    }

    public static void throwCommonIOException(int i4, String str, String str2, String str3) {
        if (i4 != 1) {
            if (i4 == 2) {
                if (str == null) {
                    str = "No such file or directory: " + str2;
                }
                throw new FileNotFoundException(str);
            } else if (i4 == 12) {
                throw new OutOfMemoryError(str);
            } else {
                if (i4 != 13) {
                    if (i4 == 21) {
                        if (str == null) {
                            str = "Is a directory: " + str2;
                        }
                        throw new FileNotFoundException(str);
                    }
                    if (str == null) {
                        str = "Error " + i4 + str3 + str2;
                    }
                    throw new IOException(str);
                }
            }
        }
        if (str == null) {
            str = "Permission denied: " + str2;
        }
        throw new FileNotFoundException(str);
    }

    public abstract boolean checkFileAccess(String str, int i4);

    public boolean checkFileExists(String str) {
        return checkFileAccess(str, 0);
    }

    public InputStream getFileInputStream(String str) {
        return new ByteArrayInputStream(readFile(str));
    }

    public long getFileModificationTime(String str) {
        return statFile(str).mtime;
    }

    public long getFileSize(String str) {
        return statFile(str).size;
    }

    public boolean hasDirectFileAccess() {
        return false;
    }

    public abstract FileResult readFile(String str, int i4, int i5, long j4, long j5);

    public abstract FileResult readFile(String str, long j4, long j5);

    public abstract byte[] readFile(String str);

    public abstract FileResult statFile(String str);

    public FileResult getFileInputStream(String str, long j4, long j5) {
        FileResult readFile = readFile(str, j4, j5);
        return readFile.content == null ? readFile : new FileResult(new ByteArrayInputStream(readFile.content), readFile.size, readFile.mtime);
    }
}
