package com.qq.e.comm.plugin.b0;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.plugin.n0.v;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f42049b;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f42050a = Executors.newFixedThreadPool(5, new a(this));

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements ThreadFactory {
        a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_IMAGE_LOADER_THREAD");
        }
    }

    private b() {
    }

    public static b a() {
        if (f42049b == null) {
            synchronized (b.class) {
                if (f42049b == null) {
                    f42049b = new b();
                }
            }
        }
        return f42049b;
    }

    private String b() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            int size = allStackTraces.size();
            HashMap hashMap = new HashMap();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                Thread key = entry.getKey();
                if (key != null) {
                    String name = key.getName();
                    Object obj = hashMap.get(name);
                    if (obj != null) {
                        hashMap.put(name, Integer.valueOf(((Integer) obj).intValue() + 1));
                    } else {
                        hashMap.put(name, 1);
                    }
                }
            }
            if (hashMap.size() <= 0) {
                return "none";
            }
            int i4 = 0;
            String str = "";
            for (Map.Entry entry2 : hashMap.entrySet()) {
                if (((Integer) entry2.getValue()).intValue() > i4) {
                    i4 = ((Integer) entry2.getValue()).intValue();
                    str = (String) entry2.getKey();
                }
            }
            return str + "," + i4 + "," + size;
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public void a(File file, ImageView imageView, c cVar) {
        if (file != null && file.exists()) {
            a(new e(file, imageView, cVar, false, null), "", cVar);
        } else if (cVar != null) {
            cVar.a("", 32768, new Exception());
        }
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, null, false, false, null, null);
    }

    public void a(String str, ImageView imageView, c cVar, Bitmap bitmap) {
        a(str, imageView, cVar, false, false, bitmap, null);
    }

    public void a(String str, ImageView imageView, c cVar) {
        a(str, imageView, cVar, false, false, null, null);
    }

    private void a(String str, ImageView imageView, c cVar, boolean z3, boolean z4, Bitmap bitmap, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(new e(str, imageView, new d(cVar), z3, z4, bitmap, str2), str, cVar);
        } else if (cVar != null) {
            cVar.a(str, 4, new Exception("UrlIsEmpty"));
        }
    }

    private void a(e eVar, String str, c cVar) {
        try {
            this.f42050a.submit(eVar);
        } catch (OutOfMemoryError e4) {
            if (cVar != null) {
                cVar.a(str, 8388608, new Exception(e4));
            }
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("msg", b());
            v.a(9200008, null, 0, 0, dVar);
        }
    }

    public void b(String str, c cVar) {
        a(str, null, cVar, true, true, null, null);
    }

    public void a(String str, c cVar, String str2) {
        a(str, null, cVar, true, false, null, str2);
    }

    public void a(String str, c cVar) {
        a(str, cVar, (String) null);
    }

    public void a(String str, c cVar, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.a(str, 4, new Exception("UrlIsEmpty"));
                return;
            }
            return;
        }
        e eVar = new e(str, null, new d(cVar), true, false, null, null);
        eVar.a(z3);
        a(eVar, str, cVar);
    }
}
