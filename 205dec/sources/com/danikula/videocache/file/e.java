package com.danikula.videocache.file;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: LruDiskUsage.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class e implements com.danikula.videocache.file.a {

    /* renamed from: b  reason: collision with root package name */
    private static final org.slf4j.c f36741b = org.slf4j.d.j("LruDiskUsage");

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f36742a = Executors.newSingleThreadExecutor();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: LruDiskUsage.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        private final File f36743a;

        public a(File file) {
            this.f36743a = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            e.this.e(this.f36743a);
            return null;
        }
    }

    private long d(List<File> list) {
        long j4 = 0;
        for (File file : list) {
            j4 += file.length();
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(File file) throws IOException {
        d.e(file);
        f(d.a(file.getParentFile()));
    }

    private void f(List<File> list) {
        long d4 = d(list);
        int size = list.size();
        for (File file : list) {
            if (!b(file, d4, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    d4 -= length;
                    f36741b.info("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    f36741b.error("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    @Override // com.danikula.videocache.file.a
    public void a(File file) throws IOException {
        this.f36742a.submit(new a(file));
    }

    protected abstract boolean b(File file, long j4, int i4);
}
