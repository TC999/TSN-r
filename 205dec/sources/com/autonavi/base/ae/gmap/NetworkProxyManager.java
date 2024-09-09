package com.autonavi.base.ae.gmap;

import android.content.Context;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.u5;
import com.amap.api.col.p0003l.y2;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NetworkProxyManager {
    private static NetworkProxyManager sInstance;
    private Context context;
    private NetworkProxy networkProxy;
    private NetworkState networkState;
    private String userAgent;
    private boolean isNetworkConnected = false;
    private Map<Long, AMapLoader> aMapLoaderHashtable = new ConcurrentHashMap();
    private Map<Long, GLMapEngine> engines = new ConcurrentHashMap();
    private NetworkState.NetworkChangeListener networkChangeListener = new NetworkState.NetworkChangeListener() { // from class: com.autonavi.base.ae.gmap.NetworkProxyManager.1
        @Override // com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener
        public void networkStateChanged(Context context) {
            NetworkProxyManager.this.isNetworkConnected = NetworkState.isNetworkConnected(context);
            for (Map.Entry entry : NetworkProxyManager.this.engines.entrySet()) {
                ((GLMapEngine) entry.getValue()).setNetStatus(NetworkProxyManager.this.isNetworkConnected);
            }
        }
    };

    private NetworkProxyManager() {
    }

    private synchronized void cancelAllAMapDownload() {
        try {
            for (Map.Entry entry : new ConcurrentHashMap(this.aMapLoaderHashtable).entrySet()) {
                ((AMapLoader) entry.getValue()).doCancelAndNotify();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static NetworkProxyManager getInstance() {
        if (sInstance == null) {
            sInstance = new NetworkProxyManager();
        }
        return sInstance;
    }

    private void initNetworkState() {
        this.userAgent = System.getProperty("http.agent") + " amap/" + GlMapUtil.getAppVersionName(this.context);
        NetworkState networkState = new NetworkState();
        this.networkState = networkState;
        networkState.setNetworkListener(this.networkChangeListener);
        this.networkState.registerNetChangeReceiver(StubApp.getOrigApplicationContext(this.context.getApplicationContext()), true);
        this.isNetworkConnected = NetworkState.isNetworkConnected(StubApp.getOrigApplicationContext(this.context.getApplicationContext()));
    }

    private static native void nativeCancelDownLoad(long j4);

    private static native long nativeCreateNetworkProxy(Object obj);

    private static native void nativeDestroyNetworkProxy(long j4);

    private static native void nativeFailedDownLoad(long j4, int i4);

    private static native void nativeFinishDownLoad(long j4);

    private static native void nativeInitNetworkProxy(long j4);

    private static native void nativeReceiveNetData(byte[] bArr, long j4, int i4);

    private void releaseNetworkState() {
        NetworkState networkState = this.networkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(StubApp.getOrigApplicationContext(this.context.getApplicationContext()), false);
            this.networkState.setNetworkListener(null);
            this.networkState = null;
        }
    }

    public NetworkProxy createNetworkProxy() {
        return new NetworkProxy(nativeCreateNetworkProxy(this));
    }

    public void destroy() {
        NetworkProxy networkProxy = this.networkProxy;
        if (networkProxy != null) {
            destroyNetworkProxy(networkProxy);
            this.networkProxy = null;
        }
        releaseNetworkState();
        this.context = null;
    }

    public void destroyNetworkProxy(NetworkProxy networkProxy) {
        nativeDestroyNetworkProxy(networkProxy.networkProxyInstance);
    }

    public synchronized void finishDownLoad(long j4) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeFinishDownLoad(j4);
            this.aMapLoaderHashtable.remove(Long.valueOf(j4));
        }
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void init() {
        NetworkProxy createNetworkProxy = createNetworkProxy();
        this.networkProxy = createNetworkProxy;
        initNetworkProxy(createNetworkProxy);
        initNetworkState();
    }

    public void initContext(Context context) {
        if (context == null) {
            return;
        }
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public void initNetworkProxy(NetworkProxy networkProxy) {
        nativeInitNetworkProxy(networkProxy.networkProxyInstance);
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    public boolean isReady() {
        return (this.context == null || this.networkProxy == null || this.networkState == null) ? false : true;
    }

    public synchronized void netCancel(long j4, int i4) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeFailedDownLoad(j4, -1);
            this.aMapLoaderHashtable.remove(Long.valueOf(j4));
        }
    }

    public synchronized void netError(long j4, int i4, int i5) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeFailedDownLoad(j4, i5);
            this.aMapLoaderHashtable.remove(Long.valueOf(j4));
            try {
                if (MapsInitializer.getExceptionLogger() != null) {
                    MapsInitializer.getExceptionLogger().onDownloaderException(i4, i5);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void netStop(long j4, int i4) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeFailedDownLoad(j4, -1);
            this.aMapLoaderHashtable.remove(Long.valueOf(j4));
        }
    }

    public void notifyMapEngineCreated(long j4, GLMapEngine gLMapEngine) {
        this.engines.put(Long.valueOf(j4), gLMapEngine);
    }

    public void notifyMapEngineDestroyed(long j4) {
        this.engines.remove(Long.valueOf(j4));
        cancelAllAMapDownload();
    }

    public synchronized void receiveNetData(long j4, byte[] bArr, int i4) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeReceiveNetData(bArr, j4, i4);
        }
    }

    @JBindingInclude
    public synchronized int requireMapDataAsyn(int i4, byte[] bArr) {
        if (bArr != null) {
            AMapLoader.ADataRequestParam aDataRequestParam = new AMapLoader.ADataRequestParam();
            int i5 = GLConvertUtil.getInt(bArr, 0);
            aDataRequestParam.requestBaseUrl = GLConvertUtil.getString(bArr, 4, i5);
            int i6 = i5 + 4;
            int i7 = GLConvertUtil.getInt(bArr, i6);
            int i8 = i6 + 4;
            aDataRequestParam.requestUrl = GLConvertUtil.getString(bArr, i8, i7);
            int i9 = i8 + i7;
            aDataRequestParam.handler = GLConvertUtil.getLong(bArr, i9);
            int i10 = i9 + 8;
            aDataRequestParam.nRequestType = GLConvertUtil.getInt(bArr, i10);
            int i11 = i10 + 4;
            int i12 = GLConvertUtil.getInt(bArr, i11);
            int i13 = i11 + 4;
            aDataRequestParam.enCodeString = GLConvertUtil.getSubBytes(bArr, i13, i12);
            aDataRequestParam.nCompress = GLConvertUtil.getInt(bArr, i13 + i12);
            final AMapLoader aMapLoader = new AMapLoader(this.context, aDataRequestParam);
            this.aMapLoaderHashtable.put(Long.valueOf(aDataRequestParam.handler), aMapLoader);
            y2.a().b(new a8() { // from class: com.autonavi.base.ae.gmap.NetworkProxyManager.2
                @Override // com.amap.api.col.p0003l.a8
                public void runTask() {
                    try {
                        aMapLoader.doRequest();
                    } catch (Throwable th) {
                        u5.p(th, "download Thread", "AMapLoader doRequest");
                        a3.D(th);
                    }
                }
            });
        }
        return 0;
    }
}
