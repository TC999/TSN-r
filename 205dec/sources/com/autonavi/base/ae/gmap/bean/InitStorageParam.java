package com.autonavi.base.ae.gmap.bean;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class InitStorageParam {
    private static final String DIR_NAME = "terrain_dem_files";
    private static final String INIT_STORAGE_DIR = "mapcache";
    @JBindingInclude
    private int maxFileCount;
    @JBindingInclude
    private long maxFileSize;
    @JBindingInclude
    private String path;
    @JBindingInclude
    private int version;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Holder {
        private static String sPath;

        public static void initPath(String str) {
            File file = new File(str);
            File file2 = new File(file, "mapcache");
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                File file3 = new File(file2, "terrain_dem_files");
                if (!file3.exists()) {
                    file3.mkdir();
                }
                sPath = file3.getAbsolutePath();
            }
        }
    }

    private InitStorageParam(int i4, String str, int i5, long j4) {
        this.version = i4;
        this.path = str;
        this.maxFileCount = i5;
        this.maxFileSize = j4;
    }

    @JBindingInclude
    public static InitStorageParam obtain() {
        return new InitStorageParam();
    }

    @JBindingInclude
    public int getMaxFileCount() {
        return this.maxFileCount;
    }

    @JBindingInclude
    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    @JBindingInclude
    public String getPath() {
        return this.path;
    }

    @JBindingInclude
    public int getVersion() {
        return this.version;
    }

    @JBindingInclude
    public void setMaxFileCount(int i4) {
        this.maxFileCount = i4;
    }

    @JBindingInclude
    public void setMaxFileSize(long j4) {
        this.maxFileSize = j4;
    }

    @JBindingInclude
    public void setPath(String str) {
        this.path = str;
    }

    @JBindingInclude
    public void setVersion(int i4) {
        this.version = i4;
    }

    public String toString() {
        return "InitStorageParam{version=" + this.version + ", maxFileCount=" + this.maxFileCount + ", maxFileSize=" + this.maxFileSize + ", path='" + this.path + "'}";
    }

    @JBindingInclude
    public static InitStorageParam obtain(int i4, String str, int i5, long j4) {
        return new InitStorageParam(i4, str, i5, j4);
    }

    private InitStorageParam() {
        this(1, Holder.sPath, 1000, 300000L);
    }
}
