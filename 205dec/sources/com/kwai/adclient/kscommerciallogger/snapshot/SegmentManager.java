package com.kwai.adclient.kscommerciallogger.snapshot;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum SegmentManager {
    Instance;
    
    private static final int expiredThresholds = 900000;
    private long lastAutoClearTime;
    private LruCache<String, Set<c>> mSnapshots;
    private boolean isDebug = false;
    private boolean hasInit = false;

    SegmentManager() {
    }

    private void autoClear() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null || lruCache.size() == 0 || System.currentTimeMillis() - this.lastAutoClearTime < 900000) {
            return;
        }
        this.lastAutoClearTime = System.currentTimeMillis();
        for (Map.Entry<String, Set<c>> entry : this.mSnapshots.snapshot().entrySet()) {
            String key = entry.getKey();
            Set<c> value = entry.getValue();
            if (value != null) {
                Iterator<c> it = value.iterator();
                this.mSnapshots.remove(key);
                while (it.hasNext()) {
                    if (this.lastAutoClearTime - it.next().Or() >= 900000) {
                        it.remove();
                    }
                }
                if (value.size() > 0) {
                    this.mSnapshots.put(key, value);
                }
            }
        }
    }

    public final int cacheLimit() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null) {
            return 0;
        }
        return lruCache.maxSize();
    }

    @Deprecated
    public final void clearBySegment(String str) {
        if (TextUtils.isEmpty(str) || this.mSnapshots == null) {
            return;
        }
        synchronized (this) {
            for (Map.Entry<String, Set<c>> entry : this.mSnapshots.snapshot().entrySet()) {
                clearBySegment(entry.getKey(), str);
            }
        }
    }

    public final void clearBySessionId(String str) {
        if (TextUtils.isEmpty(str) || this.mSnapshots == null) {
            return;
        }
        synchronized (this) {
            this.mSnapshots.remove(str);
            autoClear();
        }
    }

    public final synchronized void init(int i4, boolean z3) {
        if (!this.hasInit) {
            this.isDebug = z3;
            if (i4 > 0) {
                this.mSnapshots = new LruCache<String, Set<c>>(i4) { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.1
                    private static int f(Set<c> set) {
                        return set.size();
                    }

                    @Override // android.util.LruCache
                    protected final /* synthetic */ int sizeOf(String str, Set<c> set) {
                        return f(set);
                    }
                };
            }
            this.hasInit = true;
        }
    }

    public final synchronized boolean isOverThreshold() {
        if (cacheLimit() > 0 && segmentSize() != 0) {
            return BigDecimal.valueOf((double) (((float) segmentSize()) / ((float) cacheLimit()))).setScale(2, RoundingMode.HALF_UP).doubleValue() >= 0.7d;
        }
        return false;
    }

    public final JSONArray justLoadInfoBySessionId(String str) {
        JSONArray jSONArray = new JSONArray();
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null || lruCache.size() == 0) {
            return jSONArray;
        }
        synchronized (this) {
            Set<c> set = this.mSnapshots.get(str);
            if (set != null) {
                for (c cVar : set) {
                    jSONArray.put(cVar.ho(str));
                }
            }
        }
        return jSONArray;
    }

    public final JSONArray loadInfoBySessionId(String str) {
        JSONArray jSONArray = new JSONArray();
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null || lruCache.size() == 0) {
            return jSONArray;
        }
        synchronized (this) {
            Set<c> set = this.mSnapshots.get(str);
            if (set != null) {
                for (c cVar : set) {
                    jSONArray.put(cVar.ho(str));
                }
                this.mSnapshots.remove(str);
            }
        }
        return jSONArray;
    }

    public final c loadSegment(@NonNull String str, @NonNull String str2, int i4) {
        if (this.mSnapshots == null) {
            if (!this.hasInit && this.isDebug) {
                throw new IllegalStateException("you need init first");
            }
            return new a("empty");
        }
        synchronized (this) {
            Set<c> set = this.mSnapshots.get(str);
            if (set != null) {
                for (c cVar : set) {
                    if (cVar.getName().equals(str2)) {
                        return cVar;
                    }
                }
            }
            c cVar2 = new c(str2, i4);
            if (set != null) {
                this.mSnapshots.remove(str);
                set.add(cVar2);
                this.mSnapshots.put(str, set);
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(cVar2);
                this.mSnapshots.put(str, linkedHashSet);
            }
            autoClear();
            return cVar2;
        }
    }

    public final String loadSessionId() {
        return UUID.randomUUID().toString();
    }

    public final d loadSpan(@NonNull String str, @NonNull String str2) {
        return loadSpan(str, str2, "span");
    }

    public final synchronized Map.Entry<String, Integer> mostUsedSegmentInfo() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (Map.Entry<String, Set<c>> entry : this.mSnapshots.snapshot().entrySet()) {
            for (c cVar : entry.getValue()) {
                Integer num = (Integer) hashMap.get(cVar.getName());
                if (num == null) {
                    hashMap.put(cVar.getName(), 1);
                } else {
                    hashMap.put(cVar.getName(), Integer.valueOf(num.intValue() + 1));
                }
            }
        }
        return (Map.Entry) Collections.max(new ArrayList(hashMap.entrySet()), new Comparator<Map.Entry<String, Integer>>() { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.2
            private static int a(Map.Entry<String, Integer> entry2, Map.Entry<String, Integer> entry3) {
                return entry2.getValue().compareTo(entry3.getValue());
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Map.Entry<String, Integer> entry2, Map.Entry<String, Integer> entry3) {
                return a(entry2, entry3);
            }
        });
    }

    public final synchronized int segmentSize() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null) {
            return 0;
        }
        return lruCache.size();
    }

    public final synchronized int size() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null) {
            return 0;
        }
        return lruCache.snapshot().size();
    }

    public final d loadSpan(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return loadSegment(str, str2).hn(str3);
    }

    public final void clearBySegment(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mSnapshots == null) {
            return;
        }
        synchronized (this) {
            Set<c> set = this.mSnapshots.get(str);
            c cVar = new c(str2);
            if (set != null && set.contains(cVar)) {
                this.mSnapshots.remove(str);
                set.remove(cVar);
                if (set.size() > 0) {
                    this.mSnapshots.put(str, set);
                }
            }
            autoClear();
        }
    }

    public final c loadSegment(@NonNull String str, @NonNull String str2) {
        return loadSegment(str, str2, 10);
    }
}
