package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.AbstractC9766b;
import com.kwad.sdk.C9774c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.InterfaceC10750d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p368b.C9768b;
import com.kwad.sdk.p368b.InterfaceC9767a;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.utils.C11010ad;
import com.kwad.sdk.utils.LruHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.kwad.sdk.core.download.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10303b {
    private static final Map<String, Integer> aun = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> auo = new LruHashMap(10);
    private final WeakHashMap<InterfaceC10325c, AdTemplate> aul;
    private final Map<InterfaceC10325c, AdTemplate> aum;
    private final InterfaceC9767a aup;
    private volatile boolean mHasInit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.download.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10318a {
        static final C10303b aux = new C10303b((byte) 0);
    }

    /* synthetic */ C10303b(byte b) {
        this();
    }

    /* renamed from: De */
    public static C10303b m26364De() {
        return C10318a.aux;
    }

    /* renamed from: N */
    private void m26361N(final String str) {
        final C10327e c10327e = new C10327e();
        m26351b(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                String mo26271nX = interfaceC10325c.mo26271nX();
                C10303b.aun.put(mo26271nX, 12);
                interfaceC10325c.mo26277b(mo26271nX, str, c10327e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ck */
    public void m26349ck(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m26360O(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dG */
    public void m26342dG(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m26361N(str);
        InterfaceC10750d m27788xN = C9774c.m27790xL().m27788xN();
        if (m27788xN != null) {
            m27788xN.mo24935bT(str);
        }
    }

    /* renamed from: dz */
    public static int m26341dz(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = aun.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: O */
    public final void m26359O(final String str, final String str2) {
        final C10327e c10327e = new C10327e();
        aun.put(str, 8);
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.9
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26280a(str, str2, c10327e);
            }
        });
    }

    /* renamed from: aX */
    public final synchronized void m26353aX(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        C9768b.m27830Ao().m27817b(this.aup);
        this.aum.clear();
        this.mHasInit = false;
    }

    /* renamed from: c */
    public final void m26350c(final String str, int i, final String str2) {
        aun.put(str, 7);
        final C10327e c10327e = new C10327e();
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.10
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26282a(str, r3, str2, c10327e);
            }
        });
    }

    /* renamed from: dA */
    public final void m26348dA(final String str) {
        aun.put(str, 1);
        final C10327e c10327e = new C10327e();
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.7
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26281a(str, c10327e);
            }
        });
    }

    /* renamed from: dB */
    public final void m26347dB(final String str) {
        final C10327e c10327e = new C10327e();
        aun.put(str, 4);
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.11
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26278b(str, c10327e);
            }
        });
    }

    /* renamed from: dC */
    public final void m26346dC(final String str) {
        final C10327e c10327e = new C10327e();
        aun.put(str, 1);
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26276c(str, c10327e);
            }
        });
    }

    /* renamed from: dD */
    public final void m26345dD(final String str) {
        final C10327e c10327e = new C10327e();
        aun.put(str, 5);
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.13
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26275d(str, c10327e);
            }
        });
    }

    /* renamed from: dE */
    public final void m26344dE(final String str) {
        final C10327e c10327e = new C10327e();
        aun.put(str, 9);
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.14
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26274e(str, c10327e);
            }
        });
    }

    /* renamed from: dF */
    public final void m26343dF(final String str) {
        final C10327e c10327e = new C10327e();
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26272g(str, c10327e);
            }
        });
    }

    /* renamed from: f */
    public final void m26340f(final String str, final Throwable th) {
        final C10327e c10327e = new C10327e();
        aun.put(str, 11);
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26279a(str, th, c10327e);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            C9774c.m27790xL().m27797a(new AbstractC9766b() { // from class: com.kwad.sdk.core.download.b.1
                /* renamed from: l */
                private static String m26330l(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) C10303b.auo.get(url);
                    if (TextUtils.isEmpty(str)) {
                        String m24144bu = C11010ad.m24144bu(downloadTask.getUrl());
                        C10303b.auo.put(url, m24144bu);
                        return m24144bu;
                    }
                    return str;
                }

                @Override // com.kwad.sdk.AbstractC9766b, com.kwad.sdk.AbstractC9667a
                /* renamed from: a */
                public final void mo26337a(DownloadTask downloadTask, int i, int i2) {
                    C10303b.this.m26355a(m26330l(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
                }

                @Override // com.kwad.sdk.AbstractC9766b, com.kwad.sdk.AbstractC9667a
                /* renamed from: b */
                public final void mo26335b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (C9425a.f29473md.booleanValue()) {
                            C10331c.m26254d("DownloadStatusManager", "onDownloadStart(), id=" + m26330l(downloadTask));
                        }
                        C10303b.this.m26348dA(m26330l(downloadTask));
                    }
                }

                @Override // com.kwad.sdk.AbstractC9766b, com.kwad.sdk.AbstractC9667a
                /* renamed from: c */
                public final void mo26334c(DownloadTask downloadTask) {
                    C10303b.this.m26347dB(m26330l(downloadTask));
                }

                @Override // com.kwad.sdk.AbstractC9766b, com.kwad.sdk.AbstractC9667a
                /* renamed from: d */
                public final void mo26333d(DownloadTask downloadTask) {
                    C10303b.this.m26345dD(m26330l(downloadTask));
                }

                @Override // com.kwad.sdk.AbstractC9766b, com.kwad.sdk.AbstractC9667a
                /* renamed from: e */
                public final void mo26332e(DownloadTask downloadTask) {
                    C10303b.this.m26346dC(m26330l(downloadTask));
                }

                @Override // com.kwad.sdk.AbstractC9766b, com.kwad.sdk.AbstractC9667a
                /* renamed from: f */
                public final void mo26331f(DownloadTask downloadTask) {
                    C10303b.this.m26343dF(m26330l(downloadTask));
                }

                @Override // com.kwad.sdk.AbstractC9766b, com.kwad.sdk.AbstractC9667a
                /* renamed from: a */
                public final void mo26338a(DownloadTask downloadTask) {
                    C10303b.this.m26359O(m26330l(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.kwad.sdk.AbstractC9766b, com.kwad.sdk.AbstractC9667a
                /* renamed from: a */
                public final void mo26336a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th == null || th.getStackTrace().length <= 0) {
                        str = "";
                    } else {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    }
                    C10303b.this.m26350c(m26330l(downloadTask), 0, str);
                }
            });
            C9768b.m27830Ao().m27824a(this.aup);
            this.mHasInit = true;
        }
    }

    /* renamed from: yv */
    public final List<AdTemplate> m26339yv() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aum) {
            for (AdTemplate adTemplate : this.aum.values()) {
                if (adTemplate != null) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    private C10303b() {
        WeakHashMap<InterfaceC10325c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.aul = weakHashMap;
        this.aum = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        this.aup = new InterfaceC9767a() { // from class: com.kwad.sdk.core.download.b.6
            @Override // com.kwad.sdk.p368b.InterfaceC9767a
            /* renamed from: N */
            public final void mo26320N(String str) {
                C10303b.this.m26342dG(str);
            }

            @Override // com.kwad.sdk.p368b.InterfaceC9767a
            /* renamed from: O */
            public final void mo26319O(String str) {
                C10303b.this.m26349ck(str);
            }
        };
    }

    /* renamed from: b */
    private void m26351b(String str, InterfaceC10761a<InterfaceC10325c> interfaceC10761a) {
        Set<InterfaceC10325c> keySet = this.aum.keySet();
        synchronized (this.aum) {
            for (InterfaceC10325c interfaceC10325c : keySet) {
                if (interfaceC10325c != null && TextUtils.equals(str, interfaceC10325c.mo26270nY())) {
                    try {
                        interfaceC10761a.accept(interfaceC10325c);
                    } catch (Exception e) {
                        C10331c.printStackTrace(e);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m26356a(InterfaceC10325c interfaceC10325c, AdTemplate adTemplate) {
        this.aum.put(interfaceC10325c, adTemplate);
    }

    /* renamed from: a */
    public final void m26357a(InterfaceC10325c interfaceC10325c) {
        this.aum.remove(interfaceC10325c);
    }

    /* renamed from: O */
    private void m26360O(final String str) {
        final C10327e c10327e = new C10327e();
        m26351b(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                String mo26271nX = interfaceC10325c.mo26271nX();
                C10303b.aun.put(mo26271nX, 0);
                interfaceC10325c.mo26273f(mo26271nX, c10327e);
            }
        });
    }

    /* renamed from: a */
    public final void m26355a(final String str, final int i, final int i2, final int i3) {
        aun.put(str, 2);
        m26354a(str, new InterfaceC10761a<InterfaceC10325c>() { // from class: com.kwad.sdk.core.download.b.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(InterfaceC10325c interfaceC10325c) {
                interfaceC10325c.mo26283a(str, i, i2, i3);
            }
        });
    }

    /* renamed from: a */
    private void m26354a(String str, InterfaceC10761a<InterfaceC10325c> interfaceC10761a) {
        Set<InterfaceC10325c> keySet = this.aum.keySet();
        synchronized (this.aum) {
            for (InterfaceC10325c interfaceC10325c : keySet) {
                if (interfaceC10325c != null && TextUtils.equals(interfaceC10325c.mo26271nX(), str)) {
                    try {
                        interfaceC10761a.accept(interfaceC10325c);
                    } catch (Exception e) {
                        C10331c.printStackTrace(e);
                    }
                }
            }
        }
    }
}
