package com.bykv.vk.openvk.component.video.c.w.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.openvk.component.video.c.w.sr;
import com.bykv.vk.openvk.component.video.c.w.ux;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bykv.vk.openvk.component.video.c.w.c.c {

    /* renamed from: c  reason: collision with root package name */
    public final File f25057c;
    private volatile float ev;

    /* renamed from: f  reason: collision with root package name */
    private final Set<c> f25058f;
    private final w gd;

    /* renamed from: k  reason: collision with root package name */
    private final Handler f25059k;

    /* renamed from: p  reason: collision with root package name */
    private final Runnable f25060p;

    /* renamed from: r  reason: collision with root package name */
    private volatile long f25061r;
    private final ReentrantReadWriteLock.ReadLock sr;
    private final ReentrantReadWriteLock.WriteLock ux;

    /* renamed from: w  reason: collision with root package name */
    private final LinkedHashMap<String, File> f25062w = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(String str);

        void c(Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w {

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, Integer> f25071c;

        private w() {
            this.f25071c = new HashMap();
        }

        synchronized void c(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.f25071c.get(str);
                if (num == null) {
                    this.f25071c.put(str, 1);
                } else {
                    this.f25071c.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        synchronized void w(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.f25071c.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.f25071c.remove(str);
                } else {
                    this.f25071c.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        synchronized boolean xv(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f25071c.containsKey(str);
        }
    }

    public xv(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.xv = reentrantReadWriteLock;
        this.sr = reentrantReadWriteLock.readLock();
        this.ux = reentrantReadWriteLock.writeLock();
        this.f25058f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f25061r = 104857600L;
        this.ev = 0.5f;
        this.gd = new w();
        this.f25060p = new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.w.c.xv.1
            @Override // java.lang.Runnable
            public void run() {
                ev.w(new p("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.component.video.c.w.c.xv.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xv xvVar = xv.this;
                        xvVar.w(xvVar.f25061r);
                    }
                });
            }
        };
        this.f25059k = new Handler(Looper.getMainLooper());
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.f25057c = file;
            ev.w(new p("DiskLruCache", 5) { // from class: com.bykv.vk.openvk.component.video.c.w.c.xv.2
                @Override // java.lang.Runnable
                public void run() {
                    xv.this.w();
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  " + str);
    }

    private void xv() {
        this.f25059k.removeCallbacks(this.f25060p);
        this.f25059k.postDelayed(this.f25060p, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.c.c
    public File sr(String str) {
        if (this.sr.tryLock()) {
            File file = this.f25062w.get(str);
            this.sr.unlock();
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.ux.lock();
        try {
            File[] listFiles = this.f25057c.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.c.w.c.xv.3
                    @Override // java.util.Comparator
                    /* renamed from: c */
                    public int compare(File file2, File file3) {
                        long longValue = ((Long) hashMap.get(file2)).longValue() - ((Long) hashMap.get(file3)).longValue();
                        if (longValue < 0) {
                            return -1;
                        }
                        return longValue > 0 ? 1 : 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.f25062w.put(c(file2), file2);
                }
            }
            this.ux.unlock();
            xv();
        } catch (Throwable th) {
            this.ux.unlock();
            throw th;
        }
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.f25058f.add(cVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.c.c
    public File xv(String str) {
        this.sr.lock();
        File file = this.f25062w.get(str);
        this.sr.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.f25057c, str);
        this.ux.lock();
        this.f25062w.put(str, file2);
        this.ux.unlock();
        for (c cVar : this.f25058f) {
            cVar.c(str);
        }
        xv();
        return file2;
    }

    public void c(long j4) {
        this.f25061r = j4;
        xv();
    }

    public void c() {
        sr.xv().sr();
        Context context = ux.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.c.w.w.xv.c(context).c(0);
        }
        this.f25059k.removeCallbacks(this.f25060p);
        ev.w(new p("clear", 1) { // from class: com.bykv.vk.openvk.component.video.c.w.c.xv.4
            @Override // java.lang.Runnable
            public void run() {
                xv.this.w(0L);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.c.c
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.gd.c(str);
    }

    private String c(File file) {
        return file.getName();
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.c.c
    public void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.gd.w(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4 A[LOOP:3: B:41:0x00de->B:43:0x00e4, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void w(long r13) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.c.w.c.xv.w(long):void");
    }
}
