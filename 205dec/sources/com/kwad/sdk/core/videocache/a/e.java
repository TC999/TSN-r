package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    private final ExecutorService aCA = GlobalThreadPools.FB();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a implements Callable<Void> {
        private final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: CS */
        public Void call() {
            e.this.z(this.file);
            return null;
        }
    }

    private void B(List<File> list) {
        long C = C(list);
        list.size();
        for (File file : list) {
            if (!au(C)) {
                long length = file.length();
                if (file.delete()) {
                    C -= length;
                } else {
                    com.kwad.sdk.core.e.c.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private static long C(List<File> list) {
        long j4 = 0;
        for (File file : list) {
            j4 += file.length();
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file) {
        d.w(file);
        B(d.v(file.getParentFile()));
    }

    protected abstract boolean au(long j4);

    @Override // com.kwad.sdk.core.videocache.a.a
    public final void s(File file) {
        this.aCA.submit(new a(file));
    }
}
