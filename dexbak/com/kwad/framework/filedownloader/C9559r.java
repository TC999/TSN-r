package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.framework.filedownloader.download.C9470b;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import com.kwad.framework.filedownloader.services.C9566c;
import com.stub.StubApp;
import java.io.File;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9559r {
    private static final Object afb = new Object();
    private static final Object afd = new Object();
    private InterfaceC9579w afc;
    private volatile InterfaceC9578v afe;

    /* renamed from: com.kwad.framework.filedownloader.r$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C9560a {
        private static final C9559r aff = new C9559r();
    }

    /* renamed from: a */
    public static void m28425a(Context context, C9566c.C9568b c9568b) {
        if (C9498d.ail) {
            C9498d.m28535c(C9559r.class, "init Downloader with params: %s %s", context, c9568b);
        }
        if (context != null) {
            C9492c.m28545am(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            C9470b.m28631vo().m28635a(c9568b);
            return;
        }
        throw new IllegalArgumentException("the provided context must not be null!");
    }

    /* renamed from: al */
    public static void m28423al(Context context) {
        C9492c.m28545am(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    /* renamed from: bc */
    public static InterfaceC9427a m28422bc(String str) {
        return new C9451c(str);
    }

    /* renamed from: bg */
    private int m28421bg(int i) {
        List<InterfaceC9427a.InterfaceC9428a> m28488bb = C9503h.m28485uB().m28488bb(i);
        if (m28488bb.isEmpty()) {
            C9498d.m28534d(this, "request pause but not exist %d", Integer.valueOf(i));
            return 0;
        }
        for (InterfaceC9427a.InterfaceC9428a interfaceC9428a : m28488bb) {
            interfaceC9428a.mo28731ud().pause();
        }
        return m28488bb.size();
    }

    /* renamed from: uU */
    public static C9559r m28419uU() {
        return C9560a.aff;
    }

    /* renamed from: uW */
    public static boolean m28417uW() {
        return C9550n.m28440uM().isConnected();
    }

    /* renamed from: n */
    public final boolean m28420n(int i, String str) {
        m28421bg(i);
        if (C9550n.m28440uM().mo28335bf(i)) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            File file = new File(C9501f.m28508bt(str));
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

    /* renamed from: uV */
    public final void m28418uV() {
        if (m28417uW()) {
            return;
        }
        C9550n.m28440uM().mo28338ak(C9492c.m28544wL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: uX */
    public final InterfaceC9579w m28416uX() {
        if (this.afc == null) {
            synchronized (afb) {
                if (this.afc == null) {
                    this.afc = new C9438ab();
                }
            }
        }
        return this.afc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: uY */
    public final InterfaceC9578v m28415uY() {
        if (this.afe == null) {
            synchronized (afd) {
                if (this.afe == null) {
                    this.afe = new C9584z();
                    m28424a((AbstractC9479e) this.afe);
                }
            }
        }
        return this.afe;
    }

    /* renamed from: a */
    private static void m28424a(AbstractC9479e abstractC9479e) {
        C9487f.m28560uz().m28565a("event.service.connect.changed", abstractC9479e);
    }
}
