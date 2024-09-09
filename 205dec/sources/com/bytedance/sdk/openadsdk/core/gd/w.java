package com.bytedance.sdk.openadsdk.core.gd;

import com.bytedance.sdk.component.utils.a;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {

    /* renamed from: c  reason: collision with root package name */
    private int f33720c;

    /* renamed from: w  reason: collision with root package name */
    private int f33721w;
    private volatile boolean xv;

    public w(int i4, int i5) {
        this.f33720c = 15;
        this.f33721w = 3;
        if (i4 > 0) {
            this.f33720c = i4;
            this.f33721w = i5;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    private void sr(List<File> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                long w3 = w(list);
                int size = list.size();
                boolean c4 = c(w3, size);
                if (c4) {
                    a.xv("splashLoadAd", "\u4e0d\u6ee1\u8db3\u5220\u9664\u6761\u4ef6\uff0c\u4e0d\u6267\u884c\u5220\u9664\u64cd\u4f5c(true)" + c4);
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !c4) {
                        a.f("splashLoadAd", "LRUDeleteFile deleting fileTime " + ((Long) entry.getKey()).longValue());
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            w3 -= length;
                            a.xv("splashLoadAd", "\u5220\u9664 \u4e00\u4e2a Cache file \u5f53\u524d\u603b\u4e2a\u6570\uff1a" + size);
                        } else {
                            a.f("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (c(file2, w3, size)) {
                            a.xv("splashLoadAd", "\u505c\u6b62\u5220\u9664 \u5f53\u524d\u603b\u4e2a\u6570 totalCount\uff1a" + size + " \u6700\u5927\u503c\u5b58\u50a8\u4e0a\u9650\u4e2a\u6570 maxCount " + this.f33720c + " \u6700\u5c0f\u4e2a\u6570 " + this.f33721w);
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void xv(List<File> list) {
        long w3 = w(list);
        int size = list.size();
        if (c(w3, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                w3 -= length;
                a.xv("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
            } else {
                a.xv("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
            }
            if (c(file, w3, size)) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.gd.c
    public boolean c(long j4, int i4) {
        return i4 <= this.f33720c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.gd.c
    public boolean c(File file, long j4, int i4) {
        return i4 <= this.f33721w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gd.c
    protected void c(List<File> list) {
        if (this.xv) {
            sr(list);
            this.xv = false;
            return;
        }
        xv(list);
    }
}
