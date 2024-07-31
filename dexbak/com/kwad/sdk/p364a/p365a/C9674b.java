package com.kwad.sdk.p364a.p365a;

import android.content.Context;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.kwad.sdk.core.download.C10296a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11031aw;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11122q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Stack;

/* renamed from: com.kwad.sdk.a.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9674b {
    private static volatile C9674b alt;
    private Stack<AdTemplate> alr = new Stack<>();
    private File als;
    private boolean mHasInit;

    /* renamed from: com.kwad.sdk.a.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9678a {
        /* renamed from: go */
        void mo28034go();

        /* renamed from: zL */
        void mo28033zL();
    }

    private C9674b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public synchronized void m28074aG(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        boolean z = false;
        Iterator<AdTemplate> it = this.alr.iterator();
        while (it.hasNext()) {
            if (C10487e.m25631ea(it.next()) == C10487e.m25631ea(adTemplate)) {
                it.remove();
                z = true;
            }
        }
        if (z) {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.als));
            } catch (Exception e2) {
                objectOutputStream = null;
                e = e2;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
                C10738b.closeQuietly(objectOutputStream);
                throw th;
            }
            try {
                try {
                    objectOutputStream.writeObject(this.alr);
                    C10738b.closeQuietly(objectOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    C10738b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                C10331c.m26254d("InstallTipsDataManager", " removeApkDownloadedData e" + e);
                C10738b.closeQuietly(objectOutputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aH */
    public synchronized void m28073aH(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        this.alr.add(adTemplate);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(m28066zI()));
        } catch (Exception e2) {
            objectOutputStream = null;
            e = e2;
        } catch (Throwable th2) {
            objectOutputStream = null;
            th = th2;
            C10738b.closeQuietly(objectOutputStream);
            throw th;
        }
        try {
            try {
                objectOutputStream.writeObject(this.alr);
                C10738b.closeQuietly(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                C10738b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            C10331c.printStackTrace(e);
            C10738b.closeQuietly(objectOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aK */
    public static File m28070aK(AdTemplate adTemplate) {
        File file = new File(C10296a.m26382H(C10487e.m25641dQ(adTemplate)));
        if (C11122q.m23750L(file)) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zI */
    public synchronized File m28066zI() {
        File file = this.als;
        if (file != null) {
            return file;
        }
        String m23992cO = C11031aw.m23992cO(ServiceProvider.getContext());
        File file2 = new File(m23992cO);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(m23992cO + File.separator + "uninstall_ad");
        this.als = file3;
        if (!file3.exists()) {
            try {
                this.als.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.als;
    }

    /* renamed from: zJ */
    public static C9674b m28065zJ() {
        if (alt == null) {
            synchronized (C9674b.class) {
                if (alt == null) {
                    alt = new C9674b();
                }
            }
        }
        return alt;
    }

    /* renamed from: aI */
    public final void m28072aI(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.b.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9674b.this.m28073aH(adTemplate);
            }
        });
    }

    /* renamed from: aJ */
    public final void m28071aJ(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.b.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9674b.this.m28074aG(adTemplate);
            }
        });
    }

    /* renamed from: zK */
    public final synchronized AdTemplate m28064zK() {
        AdTemplate adTemplate;
        adTemplate = null;
        Stack stack = (Stack) this.alr.clone();
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            AdTemplate adTemplate2 = (AdTemplate) stack.pop();
            if (adTemplate2 != null) {
                String str = C10487e.m25641dQ(adTemplate2).adBaseInfo.appPackageName;
                Context context = ServiceProvider.getContext();
                File m28070aK = m28070aK(adTemplate2);
                if (m28070aK != null && m28070aK.exists() && m28070aK.lastModified() + C2624bk.f8680d > System.currentTimeMillis() && !C11017ak.m24114an(context, str)) {
                    adTemplate = adTemplate2;
                    break;
                }
            }
        }
        return adTemplate;
    }

    /* renamed from: a */
    public final synchronized void m28078a(final InterfaceC9678a interfaceC9678a) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.b.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0115 A[Catch: all -> 0x0123, TryCatch #0 {all -> 0x0123, blocks: (B:3:0x0002, B:6:0x0009, B:9:0x0010, B:34:0x00b4, B:49:0x00f0, B:64:0x0111, B:66:0x0115, B:68:0x0119, B:69:0x011c, B:61:0x010a, B:63:0x010e, B:45:0x00d9, B:72:0x011f, B:73:0x0122), top: B:77:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void doTask() {
                /*
                    Method dump skipped, instructions count: 296
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.p364a.p365a.C9674b.C96751.doTask():void");
            }
        });
    }
}
