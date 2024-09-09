package com.kwad.framework.filedownloader.download;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ConnectTask {
    final int afG;
    final com.kwad.framework.filedownloader.d.b afH;
    private com.kwad.framework.filedownloader.download.a afI;
    private String afJ;
    private Map<String, List<String>> afK;
    private List<String> afL;
    final String url;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        Reconnect() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private com.kwad.framework.filedownloader.d.b afH;
        private String afJ;
        private Integer afM;
        private com.kwad.framework.filedownloader.download.a afN;
        private String url;

        public final a a(com.kwad.framework.filedownloader.d.b bVar) {
            this.afH = bVar;
            return this;
        }

        public final a bf(String str) {
            this.url = str;
            return this;
        }

        public final a bg(String str) {
            this.afJ = str;
            return this;
        }

        public final a bs(int i4) {
            this.afM = Integer.valueOf(i4);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final ConnectTask vn() {
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num = this.afM;
            if (num != null && (aVar = this.afN) != null && this.url != null) {
                return new ConnectTask(aVar, num.intValue(), this.url, this.afJ, this.afH, (byte) 0);
            }
            throw new IllegalArgumentException();
        }

        public final a a(com.kwad.framework.filedownloader.download.a aVar) {
            this.afN = aVar;
            return this;
        }
    }

    /* synthetic */ ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i4, String str, String str2, com.kwad.framework.filedownloader.d.b bVar, byte b4) {
        this(aVar, i4, str, str2, bVar);
    }

    private void a(com.kwad.framework.filedownloader.a.b bVar) {
        HashMap<String, List<String>> wk;
        com.kwad.framework.filedownloader.d.b bVar2 = this.afH;
        if (bVar2 == null || (wk = bVar2.wk()) == null) {
            return;
        }
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.afG), wk);
        }
        for (Map.Entry<String, List<String>> entry : wk.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str : value) {
                    bVar.addHeader(key, str);
                }
            }
        }
    }

    private void b(com.kwad.framework.filedownloader.a.b bVar) {
        if (!TextUtils.isEmpty(this.afJ)) {
            bVar.addHeader("If-Match", this.afJ);
        }
        com.kwad.framework.filedownloader.download.a aVar = this.afI;
        bVar.addHeader("Range", aVar.afQ == 0 ? com.kwad.framework.filedownloader.f.f.b("bytes=%d-", Long.valueOf(aVar.afP)) : com.kwad.framework.filedownloader.f.f.b("bytes=%d-%d", Long.valueOf(aVar.afP), Long.valueOf(this.afI.afQ)));
    }

    private void c(com.kwad.framework.filedownloader.a.b bVar) {
        com.kwad.framework.filedownloader.d.b bVar2 = this.afH;
        if (bVar2 == null || bVar2.wk().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwad.framework.filedownloader.f.f.wT());
        }
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.afK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.kwad.framework.filedownloader.a.b vj() {
        com.kwad.framework.filedownloader.a.b bh = b.vo().bh(this.url);
        a(bh);
        b(bh);
        c(bh);
        this.afK = bh.vc();
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.afG), this.afK);
        }
        bh.execute();
        ArrayList arrayList = new ArrayList();
        this.afL = arrayList;
        return com.kwad.framework.filedownloader.a.d.a(this.afK, bh, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean vk() {
        return this.afI.afP > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String vl() {
        List<String> list = this.afL;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.afL;
        return list2.get(list2.size() - 1);
    }

    public final com.kwad.framework.filedownloader.download.a vm() {
        return this.afI;
    }

    private ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i4, String str, String str2, com.kwad.framework.filedownloader.d.b bVar) {
        this.afG = i4;
        this.url = str;
        this.afJ = str2;
        this.afH = bVar;
        this.afI = aVar;
    }
}
