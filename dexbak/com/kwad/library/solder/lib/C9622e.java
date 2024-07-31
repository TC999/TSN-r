package com.kwad.library.solder.lib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.C9628a;
import com.kwad.library.solder.lib.ext.C9633c;
import com.kwad.library.solder.lib.p360a.AbstractC9608e;
import com.kwad.library.solder.lib.p360a.InterfaceC9605b;
import com.kwad.library.solder.lib.p360a.InterfaceC9606c;
import com.kwad.library.solder.lib.p360a.InterfaceC9607d;
import com.kwad.library.solder.lib.p360a.InterfaceC9609f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* renamed from: com.kwad.library.solder.lib.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9622e implements InterfaceC9607d {
    private final C9633c aiX;
    private final InterfaceC9606c aiZ;
    private final InterfaceC9609f aja;
    private final InterfaceC9605b ajb;
    private final C9628a ajc;
    private Map<String, C9627b> ajd;

    /* renamed from: com.kwad.library.solder.lib.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractC9624a {
        final InterfaceC9607d ajh;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kwad.library.solder.lib.e$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C9625a extends AbstractC9624a {
            C9625a(InterfaceC9607d interfaceC9607d) {
                super(interfaceC9607d);
            }

            @Override // com.kwad.library.solder.lib.C9622e.AbstractC9624a
            /* renamed from: j */
            public final void mo28170j(AbstractC9608e abstractC9608e) {
                this.ajh.mo28176wZ().mo28190g(abstractC9608e);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kwad.library.solder.lib.e$a$b */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C9626b extends AbstractC9624a {
            C9626b(InterfaceC9607d interfaceC9607d) {
                super(interfaceC9607d);
            }

            @Override // com.kwad.library.solder.lib.C9622e.AbstractC9624a
            /* renamed from: j */
            public final void mo28170j(AbstractC9608e abstractC9608e) {
                this.ajh.mo28175xa().mo28120k(abstractC9608e);
            }
        }

        public AbstractC9624a(InterfaceC9607d interfaceC9607d) {
            this.ajh = interfaceC9607d;
        }

        /* renamed from: a */
        public static AbstractC9624a m28171a(InterfaceC9607d interfaceC9607d, int i) {
            if (i != 1) {
                return new C9625a(interfaceC9607d);
            }
            return new C9626b(interfaceC9607d);
        }

        /* renamed from: j */
        public abstract void mo28170j(AbstractC9608e abstractC9608e);
    }

    /* renamed from: com.kwad.library.solder.lib.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9627b {
        private final AbstractC9608e aji;
        private final Future<AbstractC9608e> ajj;

        public C9627b(AbstractC9608e abstractC9608e, Future<AbstractC9608e> future) {
            this.aji = abstractC9608e;
            this.ajj = future;
        }

        public final void cancel() {
            this.aji.cancel();
            this.ajj.cancel(true);
        }
    }

    public C9622e(InterfaceC9606c interfaceC9606c, InterfaceC9609f interfaceC9609f, InterfaceC9605b interfaceC9605b, C9633c c9633c, C9628a c9628a) {
        this.aiZ = interfaceC9606c;
        this.aja = interfaceC9609f;
        this.ajb = interfaceC9605b;
        this.aiX = c9633c;
        this.ajc = c9628a;
    }

    /* renamed from: b */
    private C9627b m28181b(@NonNull final AbstractC9608e abstractC9608e, @NonNull final AbstractC9624a abstractC9624a) {
        C9627b m28180bH = m28180bH(abstractC9608e.m28225xp());
        if (m28180bH != null) {
            m28180bH.cancel();
        }
        abstractC9608e.m28240a(this);
        C9627b c9627b = new C9627b(abstractC9608e, this.aiX.m28148xI().submit(new Callable<AbstractC9608e>() { // from class: com.kwad.library.solder.lib.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: xd */
            public AbstractC9608e call() {
                return C9622e.this.m28183a(abstractC9608e, abstractC9624a);
            }
        }));
        m28182a(abstractC9608e.m28225xp(), c9627b);
        return c9627b;
    }

    @Nullable
    /* renamed from: bH */
    private synchronized C9627b m28180bH(String str) {
        Map<String, C9627b> m28179c = m28179c(this.ajd);
        this.ajd = m28179c;
        if (str != null) {
            return m28179c.get(str);
        }
        return null;
    }

    /* renamed from: c */
    private static Map<String, C9627b> m28179c(Map<String, C9627b> map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    /* renamed from: a */
    public final AbstractC9608e m28183a(@NonNull AbstractC9608e abstractC9608e, @NonNull AbstractC9624a abstractC9624a) {
        if (abstractC9608e.m28229xl() == null) {
            abstractC9608e.m28240a(this);
        }
        abstractC9608e.m28225xp();
        abstractC9608e.m28228xm();
        abstractC9624a.mo28170j(abstractC9608e);
        return abstractC9608e;
    }

    /* renamed from: i */
    public final void m28178i(@NonNull AbstractC9608e abstractC9608e) {
        C9627b m28180bH = m28180bH(abstractC9608e.m28225xp());
        if (m28180bH != null) {
            m28180bH.cancel();
        }
        m28182a(abstractC9608e.m28225xp(), (C9627b) null);
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9607d
    /* renamed from: wY */
    public final C9633c mo28177wY() {
        return this.aiX;
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9607d
    /* renamed from: wZ */
    public final InterfaceC9606c mo28176wZ() {
        return this.aiZ;
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9607d
    /* renamed from: xa */
    public final InterfaceC9609f mo28175xa() {
        return this.aja;
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9607d
    /* renamed from: xb */
    public final InterfaceC9605b mo28174xb() {
        return this.ajb;
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9607d
    /* renamed from: xc */
    public final C9628a mo28173xc() {
        return this.ajc;
    }

    /* renamed from: a */
    public final C9627b m28184a(@NonNull AbstractC9608e abstractC9608e, @NonNull int i) {
        return m28181b(abstractC9608e, AbstractC9624a.m28171a(this, 16));
    }

    /* renamed from: a */
    private synchronized void m28182a(String str, C9627b c9627b) {
        Map<String, C9627b> m28179c = m28179c(this.ajd);
        this.ajd = m28179c;
        if (str != null) {
            m28179c.put(str, c9627b);
        }
    }
}
