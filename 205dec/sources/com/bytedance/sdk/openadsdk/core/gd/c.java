package com.bytedance.sdk.openadsdk.core.gd;

import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.gd;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.f;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {

    /* renamed from: com.bytedance.sdk.openadsdk.core.gd.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class CallableC0496c implements Callable<Void> {

        /* renamed from: w  reason: collision with root package name */
        private final File f33719w;

        private CallableC0496c(File file) {
            this.f33719w = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            c.this.w(this.f33719w);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(File file) throws IOException {
        try {
            f.w(file);
        } catch (Throwable th) {
            a.c("LruDiskFile", "setLastModifiedNowError", th);
        }
        List<File> c4 = f.c(file.getParentFile());
        a.f("splashLoadAd", "LruDiskFile touchInBackground files.size() " + c4.size());
        c(c4);
    }

    protected abstract void c(List<File> list);

    protected abstract boolean c(long j4, int i4);

    protected abstract boolean c(File file, long j4, int i4);

    public void c(File file) throws IOException {
        final gd gdVar = new gd(new CallableC0496c(file), 1, 2);
        ev.w(new p("touch", gdVar.c()) { // from class: com.bytedance.sdk.openadsdk.core.gd.c.1
            @Override // java.lang.Runnable
            public void run() {
                gdVar.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long w(List<File> list) {
        long j4 = 0;
        for (File file : list) {
            j4 += file.length();
        }
        return j4;
    }
}
