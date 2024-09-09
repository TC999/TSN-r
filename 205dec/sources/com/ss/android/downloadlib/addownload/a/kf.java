package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<Long, DownloadModel> f48368a;
    private final ConcurrentHashMap<Long, DownloadEventConfig> bl;

    /* renamed from: n  reason: collision with root package name */
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> f48369n;
    private volatile boolean ok;

    /* renamed from: s  reason: collision with root package name */
    private final ConcurrentHashMap<Long, DownloadController> f48370s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {
        private static kf ok = new kf();
    }

    public DownloadController bl(long j4) {
        return this.f48370s.get(Long.valueOf(j4));
    }

    public void kf(long j4) {
        this.f48368a.remove(Long.valueOf(j4));
        this.bl.remove(Long.valueOf(j4));
        this.f48370s.remove(Long.valueOf(j4));
    }

    @NonNull
    public n n(long j4) {
        n nVar = new n();
        nVar.ok = j4;
        nVar.f48371a = ok(j4);
        DownloadEventConfig a4 = a(j4);
        nVar.bl = a4;
        if (a4 == null) {
            nVar.bl = new com.ss.android.download.api.download.bl();
        }
        DownloadController bl = bl(j4);
        nVar.f48373s = bl;
        if (bl == null) {
            nVar.f48373s = new com.ss.android.download.api.download.a();
        }
        return nVar;
    }

    public com.ss.android.downloadad.api.ok.a s(long j4) {
        return this.f48369n.get(Long.valueOf(j4));
    }

    private kf() {
        this.ok = false;
        this.f48368a = new ConcurrentHashMap<>();
        this.bl = new ConcurrentHashMap<>();
        this.f48370s = new ConcurrentHashMap<>();
        this.f48369n = new ConcurrentHashMap<>();
    }

    public void a() {
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.kf.1
            @Override // java.lang.Runnable
            public void run() {
                if (kf.this.ok) {
                    return;
                }
                synchronized (kf.class) {
                    if (!kf.this.ok) {
                        kf.this.f48369n.putAll(q.ok().a());
                        kf.this.ok = true;
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> bl() {
        return this.f48369n;
    }

    public static kf ok() {
        return ok.ok;
    }

    public DownloadEventConfig a(long j4) {
        return this.bl.get(Long.valueOf(j4));
    }

    public com.ss.android.downloadad.api.ok.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.ok.a aVar : this.f48369n.values()) {
            if (aVar != null && str.equals(aVar.ok())) {
                return aVar;
            }
        }
        return null;
    }

    public void ok(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.f48368a.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.f48368a.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void ok(long j4, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.bl.put(Long.valueOf(j4), downloadEventConfig);
        }
    }

    public void ok(long j4, DownloadController downloadController) {
        if (downloadController != null) {
            this.f48370s.put(Long.valueOf(j4), downloadController);
        }
    }

    public synchronized void ok(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f48369n.put(Long.valueOf(aVar.a()), aVar);
        q.ok().ok(aVar);
    }

    public DownloadModel ok(long j4) {
        return this.f48368a.get(Long.valueOf(j4));
    }

    public com.ss.android.downloadad.api.ok.a ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.ok.a aVar : this.f48369n.values()) {
            if (aVar != null && str.equals(aVar.n())) {
                return aVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.ok.a ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.ok.a aVar : this.f48369n.values()) {
            if (aVar != null && aVar.zz() == downloadInfo.getId()) {
                return aVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long ok2 = j.ok(new JSONObject(downloadInfo.getExtra()), "extra");
                if (ok2 != 0) {
                    for (com.ss.android.downloadad.api.ok.a aVar2 : this.f48369n.values()) {
                        if (aVar2 != null && aVar2.a() == ok2) {
                            return aVar2;
                        }
                    }
                    com.ss.android.downloadlib.n.bl.ok().ok("getNativeModelByInfo");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.ok.a aVar3 : this.f48369n.values()) {
            if (aVar3 != null && TextUtils.equals(aVar3.ok(), downloadInfo.getUrl())) {
                return aVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.ok.a ok(int i4) {
        for (com.ss.android.downloadad.api.ok.a aVar : this.f48369n.values()) {
            if (aVar != null && aVar.zz() == i4) {
                return aVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.ok.a> ok(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.ok.a aVar : this.f48369n.values()) {
                if (aVar != null && TextUtils.equals(aVar.ok(), str)) {
                    aVar.a(str2);
                    hashMap.put(Long.valueOf(aVar.a()), aVar);
                }
            }
        }
        return hashMap;
    }

    public synchronized void ok(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (Long l4 : list) {
            long longValue = l4.longValue();
            arrayList.add(String.valueOf(longValue));
            this.f48369n.remove(Long.valueOf(longValue));
        }
        q.ok().ok((List<String>) arrayList);
    }
}
