package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.services.c;
import com.stub.StubApp;
import java.io.File;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class r {
    private static final Object afb = new Object();
    private static final Object afd = new Object();
    private w afc;
    private volatile v afe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private static final r aff = new r();
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context != null) {
            com.kwad.framework.filedownloader.f.c.am(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            com.kwad.framework.filedownloader.download.b.vo().a(bVar);
            return;
        }
        throw new IllegalArgumentException("the provided context must not be null!");
    }

    public static void al(Context context) {
        com.kwad.framework.filedownloader.f.c.am(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static com.kwad.framework.filedownloader.a bc(String str) {
        return new c(str);
    }

    private int bg(int i4) {
        List<a.InterfaceC0666a> bb = h.uB().bb(i4);
        if (bb.isEmpty()) {
            com.kwad.framework.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i4));
            return 0;
        }
        for (a.InterfaceC0666a interfaceC0666a : bb) {
            interfaceC0666a.ud().pause();
        }
        return bb.size();
    }

    public static r uU() {
        return a.aff;
    }

    public static boolean uW() {
        return n.uM().isConnected();
    }

    public final boolean n(int i4, String str) {
        bg(i4);
        if (n.uM().bf(i4)) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            File file = new File(com.kwad.framework.filedownloader.f.f.bt(str));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
            return true;
        }
        return false;
    }

    public final void uV() {
        if (uW()) {
            return;
        }
        n.uM().ak(com.kwad.framework.filedownloader.f.c.wL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w uX() {
        if (this.afc == null) {
            synchronized (afb) {
                if (this.afc == null) {
                    this.afc = new ab();
                }
            }
        }
        return this.afc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final v uY() {
        if (this.afe == null) {
            synchronized (afd) {
                if (this.afe == null) {
                    this.afe = new z();
                    a((e) this.afe);
                }
            }
        }
        return this.afe;
    }

    private static void a(e eVar) {
        f.uz().a("event.service.connect.changed", eVar);
    }
}
