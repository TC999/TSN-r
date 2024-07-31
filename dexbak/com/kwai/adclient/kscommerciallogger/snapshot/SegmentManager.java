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

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum SegmentManager {
    Instance;
    
    private static final int expiredThresholds = 900000;
    private long lastAutoClearTime;
    private LruCache<String, Set<C11169c>> mSnapshots;
    private boolean isDebug = false;
    private boolean hasInit = false;

    SegmentManager() {
    }

    private void autoClear() {
        LruCache<String, Set<C11169c>> lruCache = this.mSnapshots;
        if (lruCache == null || lruCache.size() == 0 || System.currentTimeMillis() - this.lastAutoClearTime < 900000) {
            return;
        }
        this.lastAutoClearTime = System.currentTimeMillis();
        for (Map.Entry<String, Set<C11169c>> entry : this.mSnapshots.snapshot().entrySet()) {
            String key = entry.getKey();
            Set<C11169c> value = entry.getValue();
            if (value != null) {
                Iterator<C11169c> it = value.iterator();
                this.mSnapshots.remove(key);
                while (it.hasNext()) {
                    if (this.lastAutoClearTime - it.next().m23490Or() >= 900000) {
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
        LruCache<String, Set<C11169c>> lruCache = this.mSnapshots;
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
            for (Map.Entry<String, Set<C11169c>> entry : this.mSnapshots.snapshot().entrySet()) {
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

    public final synchronized void init(int i, boolean z) {
        if (!this.hasInit) {
            this.isDebug = z;
            if (i > 0) {
                this.mSnapshots = new LruCache<String, Set<C11169c>>(i) { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.1
                    /* renamed from: f */
                    private static int m23492f(Set<C11169c> set) {
                        return set.size();
                    }

                    @Override // android.util.LruCache
                    protected final /* synthetic */ int sizeOf(String str, Set<C11169c> set) {
                        return m23492f(set);
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
        LruCache<String, Set<C11169c>> lruCache = this.mSnapshots;
        if (lruCache == null || lruCache.size() == 0) {
            return jSONArray;
        }
        synchronized (this) {
            Set<C11169c> set = this.mSnapshots.get(str);
            if (set != null) {
                for (C11169c c11169c : set) {
                    jSONArray.put(c11169c.mo23488ho(str));
                }
            }
        }
        return jSONArray;
    }

    public final JSONArray loadInfoBySessionId(String str) {
        JSONArray jSONArray = new JSONArray();
        LruCache<String, Set<C11169c>> lruCache = this.mSnapshots;
        if (lruCache == null || lruCache.size() == 0) {
            return jSONArray;
        }
        synchronized (this) {
            Set<C11169c> set = this.mSnapshots.get(str);
            if (set != null) {
                for (C11169c c11169c : set) {
                    jSONArray.put(c11169c.mo23488ho(str));
                }
                this.mSnapshots.remove(str);
            }
        }
        return jSONArray;
    }

    public final C11169c loadSegment(@NonNull String str, @NonNull String str2, int i) {
        if (this.mSnapshots == null) {
            if (!this.hasInit && this.isDebug) {
                throw new IllegalStateException("you need init first");
            }
            return new C11167a("empty");
        }
        synchronized (this) {
            Set<C11169c> set = this.mSnapshots.get(str);
            if (set != null) {
                for (C11169c c11169c : set) {
                    if (c11169c.getName().equals(str2)) {
                        return c11169c;
                    }
                }
            }
            C11169c c11169c2 = new C11169c(str2, i);
            if (set != null) {
                this.mSnapshots.remove(str);
                set.add(c11169c2);
                this.mSnapshots.put(str, set);
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(c11169c2);
                this.mSnapshots.put(str, linkedHashSet);
            }
            autoClear();
            return c11169c2;
        }
    }

    public final String loadSessionId() {
        return UUID.randomUUID().toString();
    }

    public final C11170d loadSpan(@NonNull String str, @NonNull String str2) {
        return loadSpan(str, str2, "span");
    }

    public final synchronized Map.Entry<String, Integer> mostUsedSegmentInfo() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (Map.Entry<String, Set<C11169c>> entry : this.mSnapshots.snapshot().entrySet()) {
            for (C11169c c11169c : entry.getValue()) {
                Integer num = (Integer) hashMap.get(c11169c.getName());
                if (num == null) {
                    hashMap.put(c11169c.getName(), 1);
                } else {
                    hashMap.put(c11169c.getName(), Integer.valueOf(num.intValue() + 1));
                }
            }
        }
        return (Map.Entry) Collections.max(new ArrayList(hashMap.entrySet()), new Comparator<Map.Entry<String, Integer>>() { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.2
            /* renamed from: a */
            private static int m23491a(Map.Entry<String, Integer> entry2, Map.Entry<String, Integer> entry3) {
                return entry2.getValue().compareTo(entry3.getValue());
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Map.Entry<String, Integer> entry2, Map.Entry<String, Integer> entry3) {
                return m23491a(entry2, entry3);
            }
        });
    }

    public final synchronized int segmentSize() {
        LruCache<String, Set<C11169c>> lruCache = this.mSnapshots;
        if (lruCache == null) {
            return 0;
        }
        return lruCache.size();
    }

    public final synchronized int size() {
        LruCache<String, Set<C11169c>> lruCache = this.mSnapshots;
        if (lruCache == null) {
            return 0;
        }
        return lruCache.snapshot().size();
    }

    public final C11170d loadSpan(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return loadSegment(str, str2).mo23489hn(str3);
    }

    public final void clearBySegment(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mSnapshots == null) {
            return;
        }
        synchronized (this) {
            Set<C11169c> set = this.mSnapshots.get(str);
            C11169c c11169c = new C11169c(str2);
            if (set != null && set.contains(c11169c)) {
                this.mSnapshots.remove(str);
                set.remove(c11169c);
                if (set.size() > 0) {
                    this.mSnapshots.put(str, set);
                }
            }
            autoClear();
        }
    }

    public final C11169c loadSegment(@NonNull String str, @NonNull String str2) {
        return loadSegment(str, str2, 10);
    }
}
