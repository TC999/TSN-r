package com.kwad.sdk.core.videocache.p413a;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* renamed from: com.kwad.sdk.core.videocache.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10554e implements InterfaceC10549a {
    private final ExecutorService aCA = GlobalThreadPools.m25607FB();

    /* renamed from: com.kwad.sdk.core.videocache.a.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class CallableC10555a implements Callable<Void> {
        private final File file;

        public CallableC10555a(File file) {
            this.file = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: CS */
        public Void call() {
            AbstractC10554e.this.m25475z(this.file);
            return null;
        }
    }

    /* renamed from: B */
    private void m25479B(List<File> list) {
        long m25478C = m25478C(list);
        list.size();
        for (File file : list) {
            if (!mo25472au(m25478C)) {
                long length = file.length();
                if (file.delete()) {
                    m25478C -= length;
                } else {
                    C10331c.m26250e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    /* renamed from: C */
    private static long m25478C(List<File> list) {
        long j = 0;
        for (File file : list) {
            j += file.length();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m25475z(File file) {
        C10552d.m25483w(file);
        m25479B(C10552d.m25484v(file.getParentFile()));
    }

    /* renamed from: au */
    protected abstract boolean mo25472au(long j);

    @Override // com.kwad.sdk.core.videocache.p413a.InterfaceC10549a
    /* renamed from: s */
    public final void mo25476s(File file) {
        this.aCA.submit(new CallableC10555a(file));
    }
}
