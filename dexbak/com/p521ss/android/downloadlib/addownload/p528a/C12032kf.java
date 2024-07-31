package com.p521ss.android.downloadlib.addownload.p528a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.download.api.download.C11974a;
import com.p521ss.android.download.api.download.C11975bl;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12265s;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.a.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12032kf {

    /* renamed from: a */
    private final ConcurrentHashMap<Long, DownloadModel> f34069a;

    /* renamed from: bl */
    private final ConcurrentHashMap<Long, DownloadEventConfig> f34070bl;

    /* renamed from: n */
    private final ConcurrentHashMap<Long, C11998a> f34071n;

    /* renamed from: ok */
    private volatile boolean f34072ok;

    /* renamed from: s */
    private final ConcurrentHashMap<Long, DownloadController> f34073s;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.addownload.a.kf$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12034ok {

        /* renamed from: ok */
        private static C12032kf f34075ok = new C12032kf();
    }

    /* renamed from: bl */
    public DownloadController m19327bl(long j) {
        return this.f34073s.get(Long.valueOf(j));
    }

    /* renamed from: kf */
    public void m19326kf(long j) {
        this.f34069a.remove(Long.valueOf(j));
        this.f34070bl.remove(Long.valueOf(j));
        this.f34073s.remove(Long.valueOf(j));
    }

    @NonNull
    /* renamed from: n */
    public C12035n m19325n(long j) {
        C12035n c12035n = new C12035n();
        c12035n.f34079ok = j;
        c12035n.f34076a = m19322ok(j);
        DownloadEventConfig m19332a = m19332a(j);
        c12035n.f34077bl = m19332a;
        if (m19332a == null) {
            c12035n.f34077bl = new C11975bl();
        }
        DownloadController m19327bl = m19327bl(j);
        c12035n.f34080s = m19327bl;
        if (m19327bl == null) {
            c12035n.f34080s = new C11974a();
        }
        return c12035n;
    }

    /* renamed from: s */
    public C11998a m19311s(long j) {
        return this.f34071n.get(Long.valueOf(j));
    }

    private C12032kf() {
        this.f34072ok = false;
        this.f34069a = new ConcurrentHashMap<>();
        this.f34070bl = new ConcurrentHashMap<>();
        this.f34073s = new ConcurrentHashMap<>();
        this.f34071n = new ConcurrentHashMap<>();
    }

    /* renamed from: a */
    public void m19333a() {
        C12265s.m18554ok().m18551ok(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.kf.1
            @Override // java.lang.Runnable
            public void run() {
                if (C12032kf.this.f34072ok) {
                    return;
                }
                synchronized (C12032kf.class) {
                    if (!C12032kf.this.f34072ok) {
                        C12032kf.this.f34071n.putAll(C12038q.m19278ok().m19280a());
                        C12032kf.this.f34072ok = true;
                    }
                }
            }
        }, true);
    }

    /* renamed from: bl */
    public ConcurrentHashMap<Long, C11998a> m19328bl() {
        return this.f34071n;
    }

    /* renamed from: ok */
    public static C12032kf m19324ok() {
        return C12034ok.f34075ok;
    }

    /* renamed from: a */
    public DownloadEventConfig m19332a(long j) {
        return this.f34070bl.get(Long.valueOf(j));
    }

    /* renamed from: a */
    public C11998a m19330a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (C11998a c11998a : this.f34071n.values()) {
            if (c11998a != null && str.equals(c11998a.mo19298ok())) {
                return c11998a;
            }
        }
        return null;
    }

    /* renamed from: ok */
    public void m19319ok(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.f34069a.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    /* renamed from: a */
    public void m19329a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.f34069a.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    /* renamed from: ok */
    public void m19320ok(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.f34070bl.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    /* renamed from: ok */
    public void m19321ok(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.f34073s.put(Long.valueOf(j), downloadController);
        }
    }

    /* renamed from: ok */
    public synchronized void m19318ok(C11998a c11998a) {
        if (c11998a == null) {
            return;
        }
        this.f34071n.put(Long.valueOf(c11998a.mo19309a()), c11998a);
        C12038q.m19278ok().m19277ok(c11998a);
    }

    /* renamed from: ok */
    public DownloadModel m19322ok(long j) {
        return this.f34069a.get(Long.valueOf(j));
    }

    /* renamed from: ok */
    public C11998a m19314ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (C11998a c11998a : this.f34071n.values()) {
            if (c11998a != null && str.equals(c11998a.mo19300n())) {
                return c11998a;
            }
        }
        return null;
    }

    /* renamed from: ok */
    public C11998a m19315ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (C11998a c11998a : this.f34071n.values()) {
            if (c11998a != null && c11998a.mo19285zz() == downloadInfo.getId()) {
                return c11998a;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long m18779ok = C12197j.m18779ok(new JSONObject(downloadInfo.getExtra()), "extra");
                if (m18779ok != 0) {
                    for (C11998a c11998a2 : this.f34071n.values()) {
                        if (c11998a2 != null && c11998a2.mo19309a() == m18779ok) {
                            return c11998a2;
                        }
                    }
                    C12235bl.m18640ok().m18639ok("getNativeModelByInfo");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (C11998a c11998a3 : this.f34071n.values()) {
            if (c11998a3 != null && TextUtils.equals(c11998a3.mo19298ok(), downloadInfo.getUrl())) {
                return c11998a3;
            }
        }
        return null;
    }

    /* renamed from: ok */
    public C11998a m19323ok(int i) {
        for (C11998a c11998a : this.f34071n.values()) {
            if (c11998a != null && c11998a.mo19285zz() == i) {
                return c11998a;
            }
        }
        return null;
    }

    @NonNull
    /* renamed from: ok */
    public Map<Long, C11998a> m19313ok(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (C11998a c11998a : this.f34071n.values()) {
                if (c11998a != null && TextUtils.equals(c11998a.mo19298ok(), str)) {
                    c11998a.m19524a(str2);
                    hashMap.put(Long.valueOf(c11998a.mo19309a()), c11998a);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: ok */
    public synchronized void m19312ok(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (Long l : list) {
            long longValue = l.longValue();
            arrayList.add(String.valueOf(longValue));
            this.f34071n.remove(Long.valueOf(longValue));
        }
        C12038q.m19278ok().m19274ok((List<String>) arrayList);
    }
}
