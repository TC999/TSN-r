package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11031aw;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ApkCacheManager {
    private Future ajj;
    private final ExecutorService atA;
    private final Callable<Void> atB;
    private File atz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum Holder {
        INSTANCE;
        
        private ApkCacheManager mInstance = new ApkCacheManager((byte) 0);

        Holder() {
        }

        final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    /* synthetic */ ApkCacheManager(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CQ */
    public boolean m26463CQ() {
        File file = this.atz;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.atz.listFiles();
        if (listFiles.length > 5) {
            return listFiles.length <= 10 && m26456l(this.atz) <= 400;
        }
        return true;
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m26457h(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        m26457h(file2);
                    }
                    file.delete();
                } else if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: l */
    private int m26456l(File file) {
        return (int) ((((float) m26455m(file)) / 1000.0f) / 1000.0f);
    }

    /* renamed from: m */
    private long m26455m(File file) {
        long length;
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            int length2 = listFiles.length;
            for (int i = 0; i < length2; i++) {
                if (listFiles[i].isDirectory()) {
                    length = m26455m(listFiles[i]);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public List<File> m26454n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        m26453v(arrayList);
        return arrayList;
    }

    /* renamed from: v */
    private void m26453v(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            /* renamed from: c */
            private static int m26451c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return m26451c(file, file2);
            }
        });
    }

    /* renamed from: CR */
    public final void m26462CR() {
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
        this.atA = GlobalThreadPools.m25598FK();
        this.atB = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: CS */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.atz != null && ApkCacheManager.this.atz.exists() && !ApkCacheManager.this.m26463CQ()) {
                        ApkCacheManager apkCacheManager = ApkCacheManager.this;
                        for (File file : apkCacheManager.m26454n(apkCacheManager.atz)) {
                            if (file.getName().endsWith(".apk")) {
                                ApkCacheManager.this.m26457h(file);
                                if (ApkCacheManager.this.m26463CQ()) {
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
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return;
        }
        try {
            this.atz = C11031aw.m23995cL(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext());
        } catch (Throwable unused) {
        }
    }
}
