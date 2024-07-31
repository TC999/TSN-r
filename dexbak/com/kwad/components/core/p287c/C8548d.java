package com.kwad.components.core.p287c;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.sdk.components.C9865f;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;

/* renamed from: com.kwad.components.core.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8548d {

    /* renamed from: IT */
    private static volatile C8548d f28086IT = null;

    /* renamed from: IU */
    private static boolean f28087IU = true;
    @NonNull

    /* renamed from: IS */
    private final SparseArray<InterfaceC8547c> f28088IS;

    private C8548d() {
        SparseArray<InterfaceC8547c> sparseArray = new SparseArray<>();
        this.f28088IS = sparseArray;
        sparseArray.append(0, new C8569n());
        sparseArray.append(1, new C8562m());
        sparseArray.append(2, new C8560l());
    }

    /* renamed from: a */
    static /* synthetic */ void m30394a(C8548d c8548d, C8927a c8927a, InterfaceC8547c interfaceC8547c) {
        m30393a(c8927a, interfaceC8547c);
    }

    /* renamed from: b */
    static /* synthetic */ SparseArray m30392b(C8548d c8548d) {
        return c8548d.f28088IS;
    }

    /* renamed from: mx */
    public static C8548d m30390mx() {
        if (f28086IT == null) {
            synchronized (C8548d.class) {
                if (f28086IT == null) {
                    f28086IT = new C8548d();
                }
            }
        }
        return f28086IT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: my */
    public static boolean m30389my() {
        if (f28087IU) {
            try {
            } catch (ClassNotFoundException unused) {
                f28087IU = false;
            }
            if (C9865f.m27498cQ("KEY_ENABLE_FORCE_ENABLE_AD_CACHE")) {
                return false;
            }
            Class.forName("com.kwad.devTools.PosConfigFetcher");
            f28087IU = true;
            return f28087IU;
        }
        return false;
    }

    /* renamed from: c */
    public final void m30391c(final C8927a c8927a) {
        GlobalThreadPools.m25601FH().submit(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.c.d.1
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.components.core.c.d.a(com.kwad.components.core.c.d):boolean
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4588)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                /*
                    r3 = this;
                    com.kwad.components.core.request.model.a r0 = r2
                    long r0 = r0.getPosId()
                    com.kwad.components.core.c.e r0 = com.kwad.components.core.p287c.C8551e.m30381s(r0)
                    com.kwad.components.core.c.d$1$1 r1 = new com.kwad.components.core.c.d$1$1
                    r1.<init>()
                    com.kwad.sdk.utils.C11064bn.runOnUiThread(r1)
                    com.kwad.components.core.c.d r1 = com.kwad.components.core.p287c.C8548d.this
                    boolean r1 = com.kwad.components.core.p287c.C8548d.m30395a(r1)
                    if (r1 != 0) goto L38
                    boolean r1 = r0.isDefault()
                    if (r1 != 0) goto L27
                    boolean r1 = r0.isEnable()
                    if (r1 != 0) goto L27
                    goto L38
                L27:
                    com.kwad.components.core.c.d r1 = com.kwad.components.core.p287c.C8548d.this
                    android.util.SparseArray r1 = com.kwad.components.core.p287c.C8548d.m30392b(r1)
                    int r0 = r0.m30385mA()
                    java.lang.Object r0 = r1.get(r0)
                    com.kwad.components.core.c.c r0 = (com.kwad.components.core.p287c.InterfaceC8547c) r0
                    goto L45
                L38:
                    com.kwad.components.core.c.d r0 = com.kwad.components.core.p287c.C8548d.this
                    android.util.SparseArray r0 = com.kwad.components.core.p287c.C8548d.m30392b(r0)
                    r1 = 0
                    java.lang.Object r0 = r0.get(r1)
                    com.kwad.components.core.c.c r0 = (com.kwad.components.core.p287c.InterfaceC8547c) r0
                L45:
                    if (r0 != 0) goto L54
                    com.kwad.components.core.c.d r0 = com.kwad.components.core.p287c.C8548d.this
                    android.util.SparseArray r0 = com.kwad.components.core.p287c.C8548d.m30392b(r0)
                    r1 = 1
                    java.lang.Object r0 = r0.get(r1)
                    com.kwad.components.core.c.c r0 = (com.kwad.components.core.p287c.InterfaceC8547c) r0
                L54:
                    com.kwad.components.core.request.model.a r1 = r2
                    com.kwad.components.core.request.i r1 = r1.m29591qw()
                    if (r1 == 0) goto L62
                    r0.getName()
                    r1.mo29596bK()
                L62:
                    com.kwad.components.core.c.d r1 = com.kwad.components.core.p287c.C8548d.this
                    com.kwad.components.core.request.model.a r2 = r2
                    com.kwad.components.core.p287c.C8548d.m30394a(r1, r2, r0)
                    com.kwad.components.core.request.model.a r1 = r2
                    com.kwad.components.core.request.model.ImpInfo r2 = r1.f28803Mv
                    com.kwad.sdk.internal.api.SceneImpl r2 = r2.adScene
                    java.lang.String r1 = r1.m29590qx()
                    com.kwad.sdk.commercial.p375d.C9829d.m27582b(r2, r1)
                    com.kwad.components.core.request.model.a r1 = r2
                    r0.mo30345c(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.p287c.C8548d.C85491.doTask():void");
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ boolean m30395a(C8548d c8548d) {
        return m30389my();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m30393a(C8927a c8927a, InterfaceC8547c interfaceC8547c) {
        String name = interfaceC8547c.getName();
        name.hashCode();
        if (name.equals("StrategyNetworkFirst")) {
            c8927a.m29592ax("network_first");
        } else if (!name.equals("StrategyLocalCacheFirst")) {
            c8927a.m29592ax("network_only");
        } else {
            c8927a.m29592ax("cache_first");
        }
    }
}
