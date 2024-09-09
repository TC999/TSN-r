package com.qq.e.comm.plugin.util;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class p1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46566a = "p1";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements FileFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f46567a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f46568b;

        a(p1 p1Var, long j4, int i4) {
            this.f46567a = j4;
            this.f46568b = i4;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file.lastModified() < this.f46567a) {
                return true;
            }
            String str = p1.f46566a;
            d1.a(str, "this file was modified in " + this.f46568b + " hours , don't delete, path:" + file.getAbsolutePath());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Comparator<File> {
        b(p1 p1Var) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            int i4 = (file.lastModified() > file2.lastModified() ? 1 : (file.lastModified() == file2.lastModified() ? 0 : -1));
            if (i4 < 0) {
                return -1;
            }
            return i4 == 0 ? 0 : 1;
        }
    }

    List<File> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1.q());
        arrayList.add(b1.a());
        arrayList.add(b1.p());
        return arrayList;
    }

    public long c() {
        return a(b());
    }

    int d() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("vacmt", 72);
    }

    Comparator<File> e() {
        return new b(this);
    }

    long f() {
        return System.currentTimeMillis() - (((d() * 60) * 60) * 1000);
    }

    long g() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("vamcs", 500) * 1024 * 1024;
    }

    public void h() {
        d1.a(f46566a, CampaignEx.JSON_NATIVE_VIDEO_START);
        try {
            List<File> b4 = b();
            long a4 = a(b4);
            long g4 = g();
            if (a(a4, g4)) {
                a(b4, a4 - g4);
            } else {
                d1.a(f46566a, "don't need clear, cacheSize = %s, maxCacheSize = %s", v1.c(a4), v1.c(g4));
            }
        } catch (Exception e4) {
            d1.a(f46566a, "clear cache error", e4);
        }
    }

    long a(List<File> list) {
        long j4 = 0;
        if (list != null && !list.isEmpty()) {
            for (File file : list) {
                j4 += b1.b(file);
            }
        }
        return j4;
    }

    boolean a(long j4, long j5) {
        if (j5 > 0) {
            return j4 >= j5;
        }
        d1.a(f46566a, "don't clear, maxSize = %d", Long.valueOf(j5));
        return false;
    }

    public void a(long j4) {
        a(b(), j4);
    }

    void a(List<File> list, long j4) {
        if (list == null || list.isEmpty() || j4 <= 0) {
            return;
        }
        d1.a(f46566a, "totalDeleteSize is " + v1.c(j4));
        long f4 = f();
        int d4 = d();
        Comparator<File> e4 = e();
        a aVar = new a(this, f4, d4);
        long j5 = 0;
        for (File file : list) {
            if (j5 < j4) {
                j5 += a(file, j4, aVar, e4);
            }
        }
        d1.a(f46566a, "clear complete, size = %s", v1.c(j5));
    }

    long a(File file, long j4, FileFilter fileFilter, Comparator<File> comparator) {
        long j5 = 0;
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                if (file.listFiles().length == 0) {
                    d1.a(f46566a, "delete :" + file.getAbsolutePath());
                    file.delete();
                    return 0L;
                }
                File[] listFiles = file.listFiles(fileFilter);
                if (listFiles == null) {
                    return 0L;
                }
                Arrays.sort(listFiles, comparator);
                for (File file2 : listFiles) {
                    if (j5 < j4) {
                        j5 += a(file2, j4 - j5, fileFilter, comparator);
                    }
                }
                if (file.listFiles().length == 0) {
                    d1.a(f46566a, "delete :" + file.getAbsolutePath());
                    file.delete();
                }
                return j5;
            } else if (file.isFile()) {
                try {
                    long length = file.length();
                    if (file.delete()) {
                        d1.a(f46566a, "delete :" + file.getAbsolutePath());
                        return length;
                    }
                } catch (Exception e4) {
                    d1.a(f46566a, "delete fail, file path = " + file.getAbsolutePath(), e4);
                }
            }
        }
        return 0L;
    }
}
