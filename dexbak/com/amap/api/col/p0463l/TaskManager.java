package com.amap.api.col.p0463l;

import android.content.Context;
import com.stub.StubApp;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.l0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class TaskManager {

    /* renamed from: d */
    private static TaskManager f4654d;

    /* renamed from: a */
    private ThreadPool f4655a;

    /* renamed from: b */
    private LinkedHashMap<String, ThreadTask> f4656b = new LinkedHashMap<>();

    /* renamed from: c */
    private boolean f4657c = true;

    private TaskManager() {
        try {
            if (this.f4655a == null) {
                this.f4655a = ThreadPool.m53395k();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static TaskManager m54594a() {
        return m54589f();
    }

    /* renamed from: f */
    private static synchronized TaskManager m54589f() {
        TaskManager taskManager;
        synchronized (TaskManager.class) {
            try {
                TaskManager taskManager2 = f4654d;
                if (taskManager2 == null) {
                    f4654d = new TaskManager();
                } else if (taskManager2.f4655a == null) {
                    taskManager2.f4655a = ThreadPool.m53396j();
                }
                taskManager = f4654d;
            }
        }
        return taskManager;
    }

    /* renamed from: g */
    private void m54588g() {
        synchronized (this.f4656b) {
            if (this.f4656b.size() <= 0) {
                return;
            }
            for (Map.Entry<String, ThreadTask> entry : this.f4656b.entrySet()) {
                entry.getKey();
                ((OfflineMapDownloadTask) entry.getValue()).m54861a();
            }
            this.f4656b.clear();
        }
    }

    /* renamed from: h */
    private static void m54587h() {
        f4654d = null;
    }

    /* renamed from: b */
    public final void m54593b(TaskItem taskItem) {
        synchronized (this.f4656b) {
            OfflineMapDownloadTask offlineMapDownloadTask = (OfflineMapDownloadTask) this.f4656b.get(taskItem.mo54643b());
            if (offlineMapDownloadTask == null) {
                return;
            }
            offlineMapDownloadTask.m54861a();
            this.f4656b.remove(taskItem.mo54643b());
        }
    }

    /* renamed from: c */
    public final void m54592c(TaskItem taskItem, Context context) throws AMapCoreException {
        if (!this.f4656b.containsKey(taskItem.mo54643b())) {
            OfflineMapDownloadTask offlineMapDownloadTask = new OfflineMapDownloadTask((IDownloadItem) taskItem, StubApp.getOrigApplicationContext(context.getApplicationContext()), (byte) 0);
            synchronized (this.f4656b) {
                this.f4656b.put(taskItem.mo54643b(), offlineMapDownloadTask);
            }
        }
        this.f4655a.m55654b(this.f4656b.get(taskItem.mo54643b()));
    }

    /* renamed from: d */
    public final void m54591d() {
        m54588g();
        this.f4655a.m55649g();
        this.f4655a = null;
        m54587h();
    }

    /* renamed from: e */
    public final void m54590e(TaskItem taskItem) {
        OfflineMapDownloadTask offlineMapDownloadTask = (OfflineMapDownloadTask) this.f4656b.get(taskItem.mo54643b());
        if (offlineMapDownloadTask != null) {
            synchronized (this.f4656b) {
                offlineMapDownloadTask.m54860b();
                this.f4656b.remove(taskItem.mo54643b());
            }
        }
    }
}
