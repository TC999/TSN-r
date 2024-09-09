package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aw;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ApkCacheManager {
    private Future ajj;
    private final ExecutorService atA;
    private final Callable<Void> atB;
    private File atz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum Holder {
        INSTANCE;
        
        private ApkCacheManager mInstance = new ApkCacheManager((byte) 0);

        Holder() {
        }

        final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    /* synthetic */ ApkCacheManager(byte b4) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean CQ() {
        File file = this.atz;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.atz.listFiles();
        if (listFiles.length > 5) {
            return listFiles.length <= 10 && l(this.atz) <= 400;
        }
        return true;
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        h(file2);
                    }
                    file.delete();
                } else if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    private int l(File file) {
        return (int) ((((float) m(file)) / 1000.0f) / 1000.0f);
    }

    private long m(File file) {
        long length;
        File[] listFiles = file.listFiles();
        long j4 = 0;
        if (listFiles != null) {
            int length2 = listFiles.length;
            for (int i4 = 0; i4 < length2; i4++) {
                if (listFiles[i4].isDirectory()) {
                    length = m(listFiles[i4]);
                } else {
                    length = listFiles[i4].length();
                }
                j4 += length;
            }
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        v(arrayList);
        return arrayList;
    }

    private void v(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            private static int c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return c(file, file2);
            }
        });
    }

    public final void CR() {
        File file = this.atz;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.ajj;
        if (future == null || future.isDone()) {
            this.ajj = this.atA.submit(this.atB);
        }
    }

    private ApkCacheManager() {
        this.atA = GlobalThreadPools.FK();
        this.atB = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: CS */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.atz != null && ApkCacheManager.this.atz.exists() && !ApkCacheManager.this.CQ()) {
                        ApkCacheManager apkCacheManager = ApkCacheManager.this;
                        for (File file : apkCacheManager.n(apkCacheManager.atz)) {
                            if (file.getName().endsWith(".apk")) {
                                ApkCacheManager.this.h(file);
                                if (ApkCacheManager.this.CQ()) {
                                    return null;
                                }
                            }
                        }
                        return null;
                    }
                    return null;
                }
            }
        };
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        try {
            this.atz = aw.cL(((f) ServiceProvider.get(f.class)).getContext());
        } catch (Throwable unused) {
        }
    }
}
