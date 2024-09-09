package com.bytedance.pangle.sdk.component.log.impl.cache;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventMonitorUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class CacheManager extends AbsCache {
    private final DBCacheStrategy mDBCache;
    private final ICache mMemoryCache;
    private final Queue<String> sendingQueue;

    public CacheManager() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.sendingQueue = concurrentLinkedQueue;
        this.mMemoryCache = new RealTimeMemoryCacheStrategy(concurrentLinkedQueue);
        this.mDBCache = new DBCacheStrategy();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public synchronized void add(AdLogEventFace adLogEventFace, int i4) {
        ICache iCache;
        if (i4 != 5) {
            if (LogInternalManager.getInstance().getAdLogDepend().isAvailableNet(LogInternalManager.getInstance().getContext()) && (iCache = this.mMemoryCache) != null && adLogEventFace != null) {
                iCache.add(adLogEventFace, i4);
            }
        }
        DBCacheStrategy dBCacheStrategy = this.mDBCache;
        if (dBCacheStrategy != null && adLogEventFace != null) {
            dBCacheStrategy.add(adLogEventFace, i4);
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public synchronized boolean checkNeedUpload(int i4, boolean z3) {
        if (this.mMemoryCache.checkNeedUpload(i4, z3)) {
            LDebug.w("memory meet");
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getMemory_available_count(), 1);
            return true;
        } else if ((i4 == 1 || i4 == 2) && this.mDBCache.checkNeedUpload(i4, z3)) {
            LDebug.w("db meet");
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getDb_available_count(), 1);
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r10v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public synchronized List<AdLogEventFace> get(int i4, int i5) {
        List<AdLogEventFace> reminderEvents;
        boolean z3;
        List<AdLogEventFace> list = this.mMemoryCache.get(i4, i5);
        if (list != null && list.size() != 0) {
            LDebug.d("memory get " + list.size());
            if ((i4 == 1 || i4 == 2) && (reminderEvents = this.mDBCache.getReminderEvents(list.get(0), list.size())) != null && reminderEvents.size() != 0) {
                LDebug.d("db get " + reminderEvents.size());
                HashMap hashMap = new HashMap();
                for (AdLogEventFace adLogEventFace : reminderEvents) {
                    hashMap.put(adLogEventFace.getLocalId(), adLogEventFace);
                }
                ArrayList arrayList = new ArrayList(this.sendingQueue);
                for (AdLogEventFace adLogEventFace2 : reminderEvents) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (TextUtils.equals(adLogEventFace2.getLocalId(), (String) it.next())) {
                                LDebug.d(" duplicate delete ");
                                z3 = true;
                                break;
                            }
                        } else {
                            z3 = false;
                            break;
                        }
                    }
                    if (z3) {
                        hashMap.remove(adLogEventFace2.getLocalId());
                    }
                }
                for (AdLogEventFace adLogEventFace3 : list) {
                    hashMap.put(adLogEventFace3.getLocalId(), adLogEventFace3);
                }
                list.clear();
                for (String str : hashMap.keySet()) {
                    list.add(hashMap.get(str));
                }
            }
        } else {
            list = this.mDBCache.get(i4, i5);
            if (list != null && list.size() != 0) {
                HashMap hashMap2 = new HashMap();
                for (AdLogEventFace adLogEventFace4 : list) {
                    hashMap2.put(adLogEventFace4.getLocalId(), adLogEventFace4);
                }
                ArrayList<String> arrayList2 = new ArrayList(this.sendingQueue);
                LDebug.d("allSendingQueue:" + arrayList2.size());
                if (arrayList2.size() != 0) {
                    for (String str2 : arrayList2) {
                        if (hashMap2.get(str2) != null) {
                            LDebug.d("db duplicate delete");
                            hashMap2.remove(str2);
                        }
                    }
                }
                list.clear();
                for (String str3 : hashMap2.keySet()) {
                    list.add(hashMap2.get(str3));
                }
            }
        }
        if (list != null && !list.isEmpty()) {
            for (AdLogEventFace adLogEventFace5 : list) {
                this.sendingQueue.offer(adLogEventFace5.getLocalId());
            }
            return list;
        }
        return new ArrayList();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public synchronized void handleResult(int i4, List<AdLogEventFace> list) {
        ArrayList<String> arrayList = new ArrayList(this.sendingQueue.size());
        arrayList.addAll(this.sendingQueue);
        for (String str : arrayList) {
            for (AdLogEventFace adLogEventFace : list) {
                if (TextUtils.equals(str, adLogEventFace.getLocalId())) {
                    this.sendingQueue.remove(str);
                }
            }
        }
        ICache iCache = this.mMemoryCache;
        if (iCache != null) {
            iCache.handleResult(i4, list);
        }
        DBCacheStrategy dBCacheStrategy = this.mDBCache;
        if (dBCacheStrategy != null) {
            dBCacheStrategy.handleResult(i4, list);
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.AbsCache, com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printBatchEvent() {
        return this.mMemoryCache.printBatchEvent() + "\n" + this.mDBCache.printBatchEvent();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.AbsCache, com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printHighEvent() {
        return this.mMemoryCache.printHighEvent() + "\n" + this.mDBCache.printHighEvent();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.AbsCache, com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printRealAdEvent() {
        return this.mMemoryCache.printRealAdEvent() + "\n" + this.mDBCache.printRealAdEvent();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.AbsCache, com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printRealStatsEvent() {
        return this.mMemoryCache.printRealStatsEvent() + "\n" + this.mDBCache.printRealStatsEvent();
    }
}
