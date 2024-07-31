package com.beizi.p051ad.internal.p058b.p059a;

import com.beizi.p051ad.internal.utilities.HaoboLog;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.ad.internal.b.a.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class LruDiskUsage implements DiskUsage {

    /* renamed from: a */
    private final ExecutorService f10003a = Executors.newSingleThreadExecutor();

    /* compiled from: LruDiskUsage.java */
    /* renamed from: com.beizi.ad.internal.b.a.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class CallableC2865a implements Callable<Void> {

        /* renamed from: b */
        private final File f10005b;

        public CallableC2865a(File file) {
            this.f10005b = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            LruDiskUsage.this.m49634b(this.f10005b);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m49634b(File file) throws IOException {
        Files.m49641c(file);
        m49635a(Files.m49642b(file.getParentFile()));
    }

    /* renamed from: a */
    protected abstract boolean mo49628a(File file, long j, int i);

    @Override // com.beizi.p051ad.internal.p058b.p059a.DiskUsage
    /* renamed from: a */
    public void mo49629a(File file) throws IOException {
        this.f10003a.submit(new CallableC2865a(file));
    }

    /* renamed from: a */
    private void m49635a(List<File> list) {
        long m49633b = m49633b(list);
        int size = list.size();
        for (File file : list) {
            if (!mo49628a(file, m49633b, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    m49633b -= length;
                    HaoboLog.m49288i(HaoboLog.lruDiskUsageLogTag, "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    HaoboLog.m49290e(HaoboLog.lruDiskUsageLogTag, "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    /* renamed from: b */
    private long m49633b(List<File> list) {
        long j = 0;
        for (File file : list) {
            j += file.length();
        }
        return j;
    }
}
