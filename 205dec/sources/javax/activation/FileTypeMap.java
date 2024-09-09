package javax.activation;

import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class FileTypeMap {
    private static FileTypeMap defaultMap;

    public static FileTypeMap getDefaultFileTypeMap() {
        if (defaultMap == null) {
            defaultMap = new MimetypesFileTypeMap();
        }
        return defaultMap;
    }

    public static void setDefaultFileTypeMap(FileTypeMap fileTypeMap) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            try {
                securityManager.checkSetFactory();
            } catch (SecurityException e4) {
                if (FileTypeMap.class.getClassLoader() != fileTypeMap.getClass().getClassLoader()) {
                    throw e4;
                }
            }
        }
        defaultMap = fileTypeMap;
    }

    public abstract String getContentType(File file);

    public abstract String getContentType(String str);
}
