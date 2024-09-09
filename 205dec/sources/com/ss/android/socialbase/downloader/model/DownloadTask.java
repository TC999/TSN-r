package com.ss.android.socialbase.downloader.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.download.core.IDownloadTask;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.kf;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.downloader.zz;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloadTask {
    private boolean autoSetHashCodeForSameTask;
    private h chunkAdjustCalculator;
    private p chunkStrategy;
    private rh depend;
    private td diskSpaceHandler;
    private final List<z> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.ok downloadInfoBuilder;
    private IDownloadFileUriProvider fileUriProvider;
    private o forbiddenHandler;
    private int hashCodeForSameTask;
    private IDownloadInterceptor interceptor;
    private final SparseArray<IDownloadListener> mainThreadListeners;
    private y monitorDepend;
    private boolean needDelayForCacheSync;
    private v notificationClickCallback;
    private ep notificationEventListener;
    private final SparseArray<IDownloadListener> notificationListeners;
    private zz retryDelayTimeCalculator;
    private final SparseArray<kf> singleListenerHashCodeMap;
    private final Map<kf, IDownloadListener> singleListenerMap;
    private final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.ok();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            int keyAt = sparseArray.keyAt(i4);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
            int keyAt = sparseArray2.keyAt(i4);
            IDownloadListener iDownloadListener = sparseArray2.get(keyAt);
            if (iDownloadListener != null) {
                sparseArray.put(keyAt, iDownloadListener);
            }
        }
    }

    private void removeAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            sparseArray.remove(sparseArray2.keyAt(i4));
        }
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new p() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.2
                @Override // com.ss.android.socialbase.downloader.downloader.p
                public int ok(long j4) {
                    return 1;
                }
            });
        }
    }

    public DownloadTask addDownloadCompleteHandler(z zVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (zVar != null) {
                if (!this.downloadCompleteHandlers.contains(zVar)) {
                    this.downloadCompleteHandlers.add(zVar);
                    return this;
                }
            }
            return this;
        }
    }

    public void addDownloadListener(int i4, IDownloadListener iDownloadListener, kf kfVar, boolean z3) {
        Map<kf, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z3 && (map = this.singleListenerMap) != null) {
            map.put(kfVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i4, kfVar);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i4, iDownloadListener);
        }
    }

    public void addListenerToDownloadingSameTask() {
        com.ss.android.socialbase.downloader.bl.ok.a(IDownloadTask.TAG, "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(kf.MAIN);
        addListenerToDownloadingSameTask(kf.SUB);
        com.ss.android.socialbase.downloader.s.ok.ok(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public DownloadTask addListenerToSameTask(boolean z3) {
        this.downloadInfoBuilder.i(z3);
        return this;
    }

    public void asyncDownload(final i iVar) {
        com.ss.android.socialbase.downloader.p.s.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                int download = DownloadTask.this.download();
                i iVar2 = iVar;
                if (iVar2 != null) {
                    iVar2.ok(download);
                }
            }
        });
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        IDownloadListener singleDownloadListener = getSingleDownloadListener(kf.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(kf.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public DownloadTask autoResumed(boolean z3) {
        this.downloadInfoBuilder.kf(z3);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z3) {
        this.autoSetHashCodeForSameTask = z3;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i4) {
        this.downloadInfoBuilder.bl(i4);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.a(list);
        return this;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public DownloadTask chunkAdjustCalculator(h hVar) {
        this.chunkAdjustCalculator = hVar;
        return this;
    }

    public DownloadTask chunkStategy(p pVar) {
        this.chunkStrategy = pVar;
        return this;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
        this.chunkStrategy = downloadTask.chunkStrategy;
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        for (Map.Entry<kf, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z3) {
        this.downloadInfoBuilder.u(z3);
        return this;
    }

    public DownloadTask depend(rh rhVar) {
        this.depend = rhVar;
        return this;
    }

    public DownloadTask diskSpaceHandler(td tdVar) {
        this.diskSpaceHandler = tdVar;
        return this;
    }

    public DownloadTask distinctDirectory(boolean z3) {
        this.downloadInfoBuilder.io(z3);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.ok();
        DownloadInfo a4 = com.ss.android.socialbase.downloader.downloader.bl.m().a(this.downloadInfo.getId());
        if (a4 == null) {
            this.downloadInfo.generateTaskId();
            com.ss.android.socialbase.downloader.s.ok.ok(this, (BaseException) null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(a4);
        }
        setChunkCalculator();
        com.ss.android.socialbase.downloader.downloader.s.ok().ok(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.ok(jSONObject);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.ok(enqueueType);
        return this;
    }

    public DownloadTask executorGroup(int i4) {
        this.downloadInfoBuilder.kf(i4);
        return this;
    }

    public DownloadTask expectFileLength(long j4) {
        this.downloadInfoBuilder.ok(j4);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z3) {
        this.downloadInfoBuilder.zz(z3);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.h(str);
        return this;
    }

    public DownloadTask extraHeaders(List<bl> list) {
        this.downloadInfoBuilder.ok(list);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.a(iArr);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask forbiddenHandler(o oVar) {
        this.forbiddenHandler = oVar;
        return this;
    }

    public DownloadTask force(boolean z3) {
        this.downloadInfoBuilder.a(z3);
        return this;
    }

    public h getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public p getChunkStrategy() {
        return this.chunkStrategy;
    }

    public rh getDepend() {
        return this.depend;
    }

    public td getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public z getDownloadCompleteHandlerByIndex(int i4) {
        synchronized (this.downloadCompleteHandlers) {
            if (i4 < this.downloadCompleteHandlers.size()) {
                return this.downloadCompleteHandlers.get(i4);
            }
            return null;
        }
    }

    @NonNull
    public List<z> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public IDownloadListener getDownloadListenerByIndex(kf kfVar, int i4) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        if (downloadListeners == null || i4 < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            if (i4 < downloadListeners.size()) {
                return downloadListeners.get(downloadListeners.keyAt(i4));
            }
            return null;
        }
    }

    public int getDownloadListenerSize(kf kfVar) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public SparseArray<IDownloadListener> getDownloadListeners(kf kfVar) {
        if (kfVar == kf.MAIN) {
            return this.mainThreadListeners;
        }
        if (kfVar == kf.SUB) {
            return this.subThreadListeners;
        }
        if (kfVar == kf.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public o getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public y getMonitorDepend() {
        return this.monitorDepend;
    }

    public v getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ep getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public zz getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public IDownloadListener getSingleDownloadListener(kf kfVar) {
        return this.singleListenerMap.get(kfVar);
    }

    public DownloadTask hashCodeForSameTask(int i4) {
        this.hashCodeForSameTask = i4;
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z3) {
        this.downloadInfoBuilder.z(z3);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.z(str);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z3) {
        this.downloadInfoBuilder.rh(z3);
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public DownloadTask isOpenLimitSpeed(boolean z3) {
        this.downloadInfoBuilder.td(z3);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i4, iDownloadListener);
            }
            Map<kf, IDownloadListener> map = this.singleListenerMap;
            kf kfVar = kf.MAIN;
            map.put(kfVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i4, kfVar);
            }
        }
        return this;
    }

    public DownloadTask maxBytes(int i4) {
        this.downloadInfoBuilder.ok(i4);
        return this;
    }

    public DownloadTask maxProgressCount(int i4) {
        this.downloadInfoBuilder.s(i4);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.k(str);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.p(str);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i4) {
        this.downloadInfoBuilder.n(i4);
        return this;
    }

    public DownloadTask monitorDepend(y yVar) {
        this.monitorDepend = yVar;
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.j(str);
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.ok(str);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z3) {
        this.downloadInfoBuilder.t(z3);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z3) {
        this.downloadInfoBuilder.p(z3);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z3) {
        this.downloadInfoBuilder.s(z3);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z3) {
        this.downloadInfoBuilder.j(z3);
        return this;
    }

    public DownloadTask needPostProgress(boolean z3) {
        this.downloadInfoBuilder.bl(z3);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z3) {
        this.downloadInfoBuilder.k(z3);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z3) {
        this.downloadInfoBuilder.q(z3);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z3) {
        this.downloadInfoBuilder.r(z3);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z3) {
        this.downloadInfoBuilder.x(z3);
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z3) {
        return this;
    }

    public DownloadTask notificationClickCallback(v vVar) {
        this.notificationClickCallback = vVar;
        return this;
    }

    public DownloadTask notificationEventListener(ep epVar) {
        this.notificationEventListener = epVar;
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i4, iDownloadListener);
            }
            Map<kf, IDownloadListener> map = this.singleListenerMap;
            kf kfVar = kf.NOTIFICATION;
            map.put(kfVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i4, kfVar);
            }
        }
        return this;
    }

    public DownloadTask onlyWifi(boolean z3) {
        this.downloadInfoBuilder.ok(z3);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.ok(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.ok(iArr);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.q(str);
        return this;
    }

    public void removeDownloadListener(int i4, IDownloadListener iDownloadListener, kf kfVar, boolean z3) {
        int indexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        if (downloadListeners == null) {
            if (z3 && this.singleListenerMap.containsKey(kfVar)) {
                this.singleListenerMap.remove(kfVar);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            if (z3) {
                if (this.singleListenerMap.containsKey(kfVar)) {
                    iDownloadListener = this.singleListenerMap.get(kfVar);
                    this.singleListenerMap.remove(kfVar);
                }
                if (iDownloadListener != null && (indexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && indexOfValue < downloadListeners.size()) {
                    downloadListeners.removeAt(indexOfValue);
                }
            } else {
                downloadListeners.remove(i4);
                synchronized (this.singleListenerHashCodeMap) {
                    kf kfVar2 = this.singleListenerHashCodeMap.get(i4);
                    if (kfVar2 != null && this.singleListenerMap.containsKey(kfVar2)) {
                        this.singleListenerMap.remove(kfVar2);
                        this.singleListenerHashCodeMap.remove(i4);
                    }
                }
            }
        }
    }

    public DownloadTask retryCount(int i4) {
        this.downloadInfoBuilder.a(i4);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.r(str);
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(zz zzVar) {
        this.retryDelayTimeCalculator = zzVar;
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.n(str);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z3) {
        this.downloadInfoBuilder.ul(z3);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<z> list) {
        if (list != null && !list.isEmpty()) {
            for (z zVar : list) {
                addDownloadCompleteHandler(zVar);
            }
        }
        return this;
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, kf kfVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (kfVar == kf.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
            } else if (kfVar == kf.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
            } else if (kfVar == kf.NOTIFICATION) {
                synchronized (this.notificationListeners) {
                    copyListeners(this.notificationListeners, sparseArray);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setNeedDelayForCacheSync(boolean z3) {
        this.needDelayForCacheSync = z3;
    }

    public void setNotificationEventListener(ep epVar) {
        this.notificationEventListener = epVar;
    }

    public DownloadTask showNotification(boolean z3) {
        this.downloadInfoBuilder.n(z3);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z3) {
        this.downloadInfoBuilder.h(z3);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i4, iDownloadListener);
            }
            Map<kf, IDownloadListener> map = this.singleListenerMap;
            kf kfVar = kf.SUB;
            map.put(kfVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i4, kfVar);
            }
        }
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.s(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.kf(str);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j4) {
        this.downloadInfoBuilder.a(j4);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.a(str);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j4) {
        this.downloadInfoBuilder.bl(j4);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.bl(str);
        return this;
    }

    private void addListenerToDownloadingSameTask(kf kfVar) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        synchronized (downloadListeners) {
            for (int i4 = 0; i4 < downloadListeners.size(); i4++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i4));
                if (iDownloadListener != null) {
                    com.ss.android.socialbase.downloader.downloader.s.ok().a(getDownloadId(), iDownloadListener, kfVar, false);
                }
            }
        }
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }
}
