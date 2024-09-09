package com.qq.e.lib.a.b.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a extends IOException {
        a() {
            super("APNG Format error");
        }
    }

    public static boolean a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean a4 = a(new com.qq.e.lib.a.e.e(fileInputStream));
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return a4;
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static e b(com.qq.e.lib.a.b.c.a aVar) throws IOException {
        e eVar;
        int position = aVar.position();
        int d4 = aVar.d();
        int c4 = aVar.c();
        if (c4 == com.qq.e.lib.a.b.b.a.f47266d) {
            eVar = new com.qq.e.lib.a.b.b.a();
        } else if (c4 == f.f47286k) {
            eVar = new f();
        } else if (c4 == g.f47295c) {
            eVar = new g();
        } else if (c4 == h.f47296c) {
            eVar = new h();
        } else if (c4 == i.f47297c) {
            eVar = new i();
        } else if (c4 == j.f47298f) {
            eVar = new j();
        } else {
            eVar = new e();
        }
        eVar.f47285b = position;
        eVar.f47284a = d4;
        eVar.b(aVar);
        aVar.d();
        return eVar;
    }

    public static boolean a(com.qq.e.lib.a.e.d dVar) {
        com.qq.e.lib.a.b.c.a aVar = dVar instanceof com.qq.e.lib.a.b.c.a ? (com.qq.e.lib.a.b.c.a) dVar : new com.qq.e.lib.a.b.c.a(dVar);
        try {
            if (aVar.a("\u0089PNG") && aVar.a("\r\n\u001a\n")) {
                while (aVar.available() > 0) {
                    if (b(aVar) instanceof com.qq.e.lib.a.b.b.a) {
                        return true;
                    }
                }
                return false;
            }
            throw new a();
        } catch (IOException e4) {
            if (e4 instanceof a) {
                return false;
            }
            e4.printStackTrace();
            return false;
        }
    }

    public static List<e> a(com.qq.e.lib.a.b.c.a aVar) throws IOException {
        if (aVar.a("\u0089PNG") && aVar.a("\r\n\u001a\n")) {
            ArrayList arrayList = new ArrayList();
            while (aVar.available() > 0) {
                arrayList.add(b(aVar));
            }
            return arrayList;
        }
        throw new a();
    }
}
