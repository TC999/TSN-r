package com.baidu.liantian;

import android.content.Context;
import com.amap.api.col.p0003l.f4;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileDeleteObserverUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, d> f12153a = new HashMap();

    public static void a(Context context, int i4, File file, File file2) {
        try {
            if (com.baidu.liantian.b.e.a(file)) {
                if (!com.baidu.liantian.b.e.a(file2)) {
                    com.baidu.liantian.b.e.a(file, file2);
                }
                f4.a(file);
                f4.a(file2);
                b.a();
                if (f12153a.containsKey(file.getAbsolutePath())) {
                    return;
                }
                d dVar = new d(context, i4, file.getAbsolutePath(), file2.getAbsolutePath());
                dVar.startWatching();
                f12153a.put(file.getAbsolutePath(), dVar);
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public static void a(File file) {
        if (file == null) {
            return;
        }
        try {
            file.getAbsolutePath();
            b.a();
            d dVar = f12153a.get(file.getAbsolutePath());
            if (dVar != null) {
                dVar.stopWatching();
                f12153a.remove(file.getAbsolutePath());
                dVar.a();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }
}
