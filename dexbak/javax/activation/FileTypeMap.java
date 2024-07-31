package javax.activation;

import java.io.File;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
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
            } catch (SecurityException e) {
                if (FileTypeMap.class.getClassLoader() != fileTypeMap.getClass().getClassLoader()) {
                    throw e;
                }
            }
        }
        defaultMap = fileTypeMap;
    }

    public abstract String getContentType(File file);

    public abstract String getContentType(String str);
}
