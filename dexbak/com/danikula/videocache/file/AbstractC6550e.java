package com.danikula.videocache.file;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.InterfaceC15424c;
import org.slf4j.LoggerFactory;

/* compiled from: LruDiskUsage.java */
/* renamed from: com.danikula.videocache.file.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AbstractC6550e implements InterfaceC6544a {

    /* renamed from: b */
    private static final InterfaceC15424c f23074b = LoggerFactory.m2655j("LruDiskUsage");

    /* renamed from: a */
    private final ExecutorService f23075a = Executors.newSingleThreadExecutor();

    /* compiled from: LruDiskUsage.java */
    /* renamed from: com.danikula.videocache.file.e$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private class CallableC6551a implements Callable<Void> {

        /* renamed from: a */
        private final File f23076a;

        public CallableC6551a(File file) {
            this.f23076a = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            AbstractC6550e.this.m35929e(this.f23076a);
            return null;
        }
    }

    /* renamed from: d */
    private long m35930d(List<File> list) {
        long j = 0;
        for (File file : list) {
            j += file.length();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m35929e(File file) throws IOException {
        C6547d.m35934e(file);
        m35928f(C6547d.m35938a(file.getParentFile()));
    }

    /* renamed from: f */
    private void m35928f(List<File> list) {
        long m35930d = m35930d(list);
        int size = list.size();
        for (File file : list) {
            if (!mo35926b(file, m35930d, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    m35930d -= length;
                    f23074b.info("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    f23074b.error("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    @Override // com.danikula.videocache.file.InterfaceC6544a
    /* renamed from: a */
    public void mo35925a(File file) throws IOException {
        this.f23075a.submit(new CallableC6551a(file));
    }

    /* renamed from: b */
    protected abstract boolean mo35926b(File file, long j, int i);
}
