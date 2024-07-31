package com.kwad.framework.filedownloader.download;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.p348a.C9436d;
import com.kwad.framework.filedownloader.p348a.InterfaceC9432b;
import com.kwad.framework.filedownloader.p351d.C9462b;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ConnectTask {
    final int afG;
    final C9462b afH;
    private C9469a afI;
    private String afJ;
    private Map<String, List<String>> afK;
    private List<String> afL;
    final String url;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        Reconnect() {
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.download.ConnectTask$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9467a {
        private C9462b afH;
        private String afJ;
        private Integer afM;
        private C9469a afN;
        private String url;

        /* renamed from: a */
        public final C9467a m28664a(C9462b c9462b) {
            this.afH = c9462b;
            return this;
        }

        /* renamed from: bf */
        public final C9467a m28662bf(String str) {
            this.url = str;
            return this;
        }

        /* renamed from: bg */
        public final C9467a m28661bg(String str) {
            this.afJ = str;
            return this;
        }

        /* renamed from: bs */
        public final C9467a m28660bs(int i) {
            this.afM = Integer.valueOf(i);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: vn */
        public final ConnectTask m28659vn() {
            C9469a c9469a;
            Integer num = this.afM;
            if (num != null && (c9469a = this.afN) != null && this.url != null) {
                return new ConnectTask(c9469a, num.intValue(), this.url, this.afJ, this.afH, (byte) 0);
            }
            throw new IllegalArgumentException();
        }

        /* renamed from: a */
        public final C9467a m28663a(C9469a c9469a) {
            this.afN = c9469a;
            return this;
        }
    }

    /* synthetic */ ConnectTask(C9469a c9469a, int i, String str, String str2, C9462b c9462b, byte b) {
        this(c9469a, i, str, str2, c9462b);
    }

    /* renamed from: a */
    private void m28671a(InterfaceC9432b interfaceC9432b) {
        HashMap<String, List<String>> m28701wk;
        C9462b c9462b = this.afH;
        if (c9462b == null || (m28701wk = c9462b.m28701wk()) == null) {
            return;
        }
        if (C9498d.ail) {
            C9498d.m28533e(this, "%d add outside header: %s", Integer.valueOf(this.afG), m28701wk);
        }
        for (Map.Entry<String, List<String>> entry : m28701wk.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str : value) {
                    interfaceC9432b.addHeader(key, str);
                }
            }
        }
    }

    /* renamed from: b */
    private void m28670b(InterfaceC9432b interfaceC9432b) {
        if (!TextUtils.isEmpty(this.afJ)) {
            interfaceC9432b.addHeader("If-Match", this.afJ);
        }
        C9469a c9469a = this.afI;
        interfaceC9432b.addHeader("Range", c9469a.afQ == 0 ? C9501f.m28515b("bytes=%d-", Long.valueOf(c9469a.afP)) : C9501f.m28515b("bytes=%d-%d", Long.valueOf(c9469a.afP), Long.valueOf(this.afI.afQ)));
    }

    /* renamed from: c */
    private void m28669c(InterfaceC9432b interfaceC9432b) {
        C9462b c9462b = this.afH;
        if (c9462b == null || c9462b.m28701wk().get("User-Agent") == null) {
            interfaceC9432b.addHeader("User-Agent", C9501f.m28495wT());
        }
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.afK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: vj */
    public final InterfaceC9432b m28668vj() {
        InterfaceC9432b m28632bh = C9470b.m28631vo().m28632bh(this.url);
        m28671a(m28632bh);
        m28670b(m28632bh);
        m28669c(m28632bh);
        this.afK = m28632bh.mo24749vc();
        if (C9498d.ail) {
            C9498d.m28535c(this, "%s request header %s", Integer.valueOf(this.afG), this.afK);
        }
        m28632bh.execute();
        ArrayList arrayList = new ArrayList();
        this.afL = arrayList;
        return C9436d.m28810a(this.afK, m28632bh, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: vk */
    public final boolean m28667vk() {
        return this.afI.afP > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: vl */
    public final String m28666vl() {
        List<String> list = this.afL;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.afL;
        return list2.get(list2.size() - 1);
    }

    /* renamed from: vm */
    public final C9469a m28665vm() {
        return this.afI;
    }

    private ConnectTask(C9469a c9469a, int i, String str, String str2, C9462b c9462b) {
        this.afG = i;
        this.url = str;
        this.afJ = str2;
        this.afH = c9462b;
        this.afI = c9469a;
    }
}
