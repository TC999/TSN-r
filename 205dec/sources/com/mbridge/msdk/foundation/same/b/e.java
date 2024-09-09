package com.mbridge.msdk.foundation.same.b;

import android.util.Log;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MBridgeDirManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    private static e f39438c;

    /* renamed from: a  reason: collision with root package name */
    private b f39439a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<a> f39440b = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MBridgeDirManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public c f39441a;

        /* renamed from: b  reason: collision with root package name */
        public File f39442b;

        public a(c cVar, File file) {
            this.f39441a = cVar;
            this.f39442b = file;
        }
    }

    private e(b bVar) {
        this.f39439a = bVar;
    }

    public static synchronized void a(b bVar) {
        synchronized (e.class) {
            if (f39438c == null) {
                f39438c = new e(bVar);
            }
        }
    }

    public static String b(c cVar) {
        File a4 = a(cVar);
        if (a4 != null) {
            return a4.getAbsolutePath();
        }
        return null;
    }

    public final boolean b() {
        return a(this.f39439a.a());
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f39438c == null && com.mbridge.msdk.foundation.controller.a.f().j() != null) {
                aa.a(com.mbridge.msdk.foundation.controller.a.f().j());
            }
            if (f39438c == null) {
                Log.e("MBridgeDirManager", "mDirectoryManager == null");
            }
            eVar = f39438c;
        }
        return eVar;
    }

    public static File a(c cVar) {
        try {
            if (a() != null) {
                Iterator<a> it = a().f39440b.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.f39441a.equals(cVar)) {
                        return next.f39442b;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            x.b("MBridgeDirManager", th.getMessage(), th);
            return null;
        }
    }

    private boolean a(com.mbridge.msdk.foundation.same.b.a aVar) {
        String str;
        com.mbridge.msdk.foundation.same.b.a c4 = aVar.c();
        if (c4 == null) {
            str = aVar.b();
        } else {
            File a4 = a(c4.a());
            str = a4.getAbsolutePath() + File.separator + aVar.b();
        }
        File file = new File(str);
        if (!file.exists() ? file.mkdirs() : true) {
            this.f39440b.add(new a(aVar.a(), file));
            List<com.mbridge.msdk.foundation.same.b.a> d4 = aVar.d();
            if (d4 != null) {
                for (com.mbridge.msdk.foundation.same.b.a aVar2 : d4) {
                    if (!a(aVar2)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
