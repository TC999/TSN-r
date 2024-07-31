package com.p521ss.android.socialbase.downloader.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.download.core.IDownloadTask;
import com.p521ss.android.socialbase.downloader.constants.EnqueueType;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12460o;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12469rh;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12475td;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12515s;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12496h;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12497i;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12509p;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12523zz;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p555p.C12665s;
import com.p521ss.android.socialbase.downloader.p557s.C12723ok;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.model.DownloadTask */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadTask {
    private boolean autoSetHashCodeForSameTask;
    private InterfaceC12496h chunkAdjustCalculator;
    private InterfaceC12509p chunkStrategy;
    private InterfaceC12469rh depend;
    private InterfaceC12475td diskSpaceHandler;
    private final List<InterfaceC12484z> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.C12595ok downloadInfoBuilder;
    private IDownloadFileUriProvider fileUriProvider;
    private InterfaceC12460o forbiddenHandler;
    private int hashCodeForSameTask;
    private IDownloadInterceptor interceptor;
    private final SparseArray<IDownloadListener> mainThreadListeners;
    private InterfaceC12483y monitorDepend;
    private boolean needDelayForCacheSync;
    private InterfaceC12480v notificationClickCallback;
    private InterfaceC12427ep notificationEventListener;
    private final SparseArray<IDownloadListener> notificationListeners;
    private InterfaceC12523zz retryDelayTimeCalculator;
    private final SparseArray<EnumC12414kf> singleListenerHashCodeMap;
    private final Map<EnumC12414kf, IDownloadListener> singleListenerMap;
    private final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.C12595ok();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int keyAt = sparseArray2.keyAt(i);
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
        for (int i = 0; i < size; i++) {
            sparseArray.remove(sparseArray2.keyAt(i));
        }
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new InterfaceC12509p() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.2
                @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12509p
                /* renamed from: ok */
                public int mo16677ok(long j) {
                    return 1;
                }
            });
        }
    }

    public DownloadTask addDownloadCompleteHandler(InterfaceC12484z interfaceC12484z) {
        synchronized (this.downloadCompleteHandlers) {
            if (interfaceC12484z != null) {
                if (!this.downloadCompleteHandlers.contains(interfaceC12484z)) {
                    this.downloadCompleteHandlers.add(interfaceC12484z);
                    return this;
                }
            }
            return this;
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        Map<EnumC12414kf, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(enumC12414kf, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, enumC12414kf);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(enumC12414kf);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i, iDownloadListener);
        }
    }

    public void addListenerToDownloadingSameTask() {
        C12409ok.m17904a(IDownloadTask.TAG, "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(EnumC12414kf.MAIN);
        addListenerToDownloadingSameTask(EnumC12414kf.SUB);
        C12723ok.m16492ok(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.m17125i(z);
        return this;
    }

    public void asyncDownload(final InterfaceC12497i interfaceC12497i) {
        C12665s.m16734ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                int download = DownloadTask.this.download();
                InterfaceC12497i interfaceC12497i2 = interfaceC12497i;
                if (interfaceC12497i2 != null) {
                    interfaceC12497i2.m17743ok(download);
                }
            }
        });
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        IDownloadListener singleDownloadListener = getSingleDownloadListener(EnumC12414kf.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(EnumC12414kf.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.m17113kf(z);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z) {
        this.autoSetHashCodeForSameTask = z;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.m17145bl(i);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.m17149a(list);
        return this;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public DownloadTask chunkAdjustCalculator(InterfaceC12496h interfaceC12496h) {
        this.chunkAdjustCalculator = interfaceC12496h;
        return this;
    }

    public DownloadTask chunkStategy(InterfaceC12509p interfaceC12509p) {
        this.chunkStrategy = interfaceC12509p;
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
        for (Map.Entry<EnumC12414kf, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
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

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.m17068u(z);
        return this;
    }

    public DownloadTask depend(InterfaceC12469rh interfaceC12469rh) {
        this.depend = interfaceC12469rh;
        return this;
    }

    public DownloadTask diskSpaceHandler(InterfaceC12475td interfaceC12475td) {
        this.diskSpaceHandler = interfaceC12475td;
        return this;
    }

    public DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.m17123io(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.m17104ok();
        DownloadInfo mo17520a = C12490bl.m17806m().mo17520a(this.downloadInfo.getId());
        if (mo17520a == null) {
            this.downloadInfo.generateTaskId();
            C12723ok.m16488ok(this, (BaseException) null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(mo17520a);
        }
        setChunkCalculator();
        C12515s.m17660ok().m17650ok(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.m17097ok(jSONObject);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.m17101ok(enqueueType);
        return this;
    }

    public DownloadTask executorGroup(int i) {
        this.downloadInfoBuilder.m17116kf(i);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.m17102ok(j);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.m17051zz(z);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.m17128h(str);
        return this;
    }

    public DownloadTask extraHeaders(List<C12601bl> list) {
        this.downloadInfoBuilder.m17098ok(list);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.m17147a(iArr);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask forbiddenHandler(InterfaceC12460o interfaceC12460o) {
        this.forbiddenHandler = interfaceC12460o;
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.m17148a(z);
        return this;
    }

    public InterfaceC12496h getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public InterfaceC12509p getChunkStrategy() {
        return this.chunkStrategy;
    }

    public InterfaceC12469rh getDepend() {
        return this.depend;
    }

    public InterfaceC12475td getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public InterfaceC12484z getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            if (i < this.downloadCompleteHandlers.size()) {
                return this.downloadCompleteHandlers.get(i);
            }
            return null;
        }
    }

    @NonNull
    public List<InterfaceC12484z> getDownloadCompleteHandlers() {
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

    public IDownloadListener getDownloadListenerByIndex(EnumC12414kf enumC12414kf, int i) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(enumC12414kf);
        if (downloadListeners == null || i < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            if (i < downloadListeners.size()) {
                return downloadListeners.get(downloadListeners.keyAt(i));
            }
            return null;
        }
    }

    public int getDownloadListenerSize(EnumC12414kf enumC12414kf) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(enumC12414kf);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public SparseArray<IDownloadListener> getDownloadListeners(EnumC12414kf enumC12414kf) {
        if (enumC12414kf == EnumC12414kf.MAIN) {
            return this.mainThreadListeners;
        }
        if (enumC12414kf == EnumC12414kf.SUB) {
            return this.subThreadListeners;
        }
        if (enumC12414kf == EnumC12414kf.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public InterfaceC12460o getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public InterfaceC12483y getMonitorDepend() {
        return this.monitorDepend;
    }

    public InterfaceC12480v getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public InterfaceC12427ep getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public InterfaceC12523zz getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public IDownloadListener getSingleDownloadListener(EnumC12414kf enumC12414kf) {
        return this.singleListenerMap.get(enumC12414kf);
    }

    public DownloadTask hashCodeForSameTask(int i) {
        this.hashCodeForSameTask = i;
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.m17053z(z);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.m17054z(str);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.m17081rh(z);
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

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.m17072td(z);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i, iDownloadListener);
            }
            Map<EnumC12414kf, IDownloadListener> map = this.singleListenerMap;
            EnumC12414kf enumC12414kf = EnumC12414kf.MAIN;
            map.put(enumC12414kf, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, enumC12414kf);
            }
        }
        return this;
    }

    public DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.m17103ok(i);
        return this;
    }

    public DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.m17080s(i);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.m17118k(str);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.m17092p(str);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.m17109n(i);
        return this;
    }

    public DownloadTask monitorDepend(InterfaceC12483y interfaceC12483y) {
        this.monitorDepend = interfaceC12483y;
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.m17121j(str);
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.m17099ok(str);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.m17074t(z);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.m17091p(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.m17077s(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.m17120j(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.m17141bl(z);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.m17117k(z);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.m17088q(z);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.m17083r(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.m17059x(z);
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z) {
        return this;
    }

    public DownloadTask notificationClickCallback(InterfaceC12480v interfaceC12480v) {
        this.notificationClickCallback = interfaceC12480v;
        return this;
    }

    public DownloadTask notificationEventListener(InterfaceC12427ep interfaceC12427ep) {
        this.notificationEventListener = interfaceC12427ep;
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i, iDownloadListener);
            }
            Map<EnumC12414kf, IDownloadListener> map = this.singleListenerMap;
            EnumC12414kf enumC12414kf = EnumC12414kf.NOTIFICATION;
            map.put(enumC12414kf, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, enumC12414kf);
            }
        }
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.m17096ok(z);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.m17094ok(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.m17095ok(iArr);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.m17089q(str);
        return this;
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        int indexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(enumC12414kf);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(enumC12414kf)) {
                this.singleListenerMap.remove(enumC12414kf);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            if (z) {
                if (this.singleListenerMap.containsKey(enumC12414kf)) {
                    iDownloadListener = this.singleListenerMap.get(enumC12414kf);
                    this.singleListenerMap.remove(enumC12414kf);
                }
                if (iDownloadListener != null && (indexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && indexOfValue < downloadListeners.size()) {
                    downloadListeners.removeAt(indexOfValue);
                }
            } else {
                downloadListeners.remove(i);
                synchronized (this.singleListenerHashCodeMap) {
                    EnumC12414kf enumC12414kf2 = this.singleListenerHashCodeMap.get(i);
                    if (enumC12414kf2 != null && this.singleListenerMap.containsKey(enumC12414kf2)) {
                        this.singleListenerMap.remove(enumC12414kf2);
                        this.singleListenerHashCodeMap.remove(i);
                    }
                }
            }
        }
    }

    public DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.m17153a(i);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.m17084r(str);
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(InterfaceC12523zz interfaceC12523zz) {
        this.retryDelayTimeCalculator = interfaceC12523zz;
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.m17107n(str);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.m17066ul(z);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<InterfaceC12484z> list) {
        if (list != null && !list.isEmpty()) {
            for (InterfaceC12484z interfaceC12484z : list) {
                addDownloadCompleteHandler(interfaceC12484z);
            }
        }
        return this;
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, EnumC12414kf enumC12414kf) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (enumC12414kf == EnumC12414kf.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
            } else if (enumC12414kf == EnumC12414kf.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
            } else if (enumC12414kf == EnumC12414kf.NOTIFICATION) {
                synchronized (this.notificationListeners) {
                    copyListeners(this.notificationListeners, sparseArray);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setNeedDelayForCacheSync(boolean z) {
        this.needDelayForCacheSync = z;
    }

    public void setNotificationEventListener(InterfaceC12427ep interfaceC12427ep) {
        this.notificationEventListener = interfaceC12427ep;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.m17106n(z);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.m17127h(z);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i, iDownloadListener);
            }
            Map<EnumC12414kf, IDownloadListener> map = this.singleListenerMap;
            EnumC12414kf enumC12414kf = EnumC12414kf.SUB;
            map.put(enumC12414kf, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, enumC12414kf);
            }
        }
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.m17078s(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.m17114kf(str);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.m17152a(j);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.m17150a(str);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.m17144bl(j);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.m17142bl(str);
        return this;
    }

    private void addListenerToDownloadingSameTask(EnumC12414kf enumC12414kf) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(enumC12414kf);
        synchronized (downloadListeners) {
            for (int i = 0; i < downloadListeners.size(); i++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                if (iDownloadListener != null) {
                    C12515s.m17660ok().m17681a(getDownloadId(), iDownloadListener, enumC12414kf, false);
                }
            }
        }
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }
}
