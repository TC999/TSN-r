package com.autonavi.base.ae.gmap.bean;

import android.text.TextUtils;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.y2;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TileProviderInner {
    @JBindingExclude
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    @JBindingInclude
    private List<TileOverlaySource> mTileSource;
    @JBindingExclude
    private String overlayName;
    @JBindingExclude
    private final HashMap<String, a8> reqTaskHandleHashMap = new HashMap<>();
    @JBindingExclude
    private final TileProvider tileProvider;

    @JBindingExclude
    public TileProviderInner(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JBindingExclude
    public Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @JBindingExclude
    private String createKey(int i4, int i5, int i6, long j4) {
        return i4 + " " + i5 + " " + i6 + "-" + j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDownload(final Tile tile, final TileReqTaskHandle tileReqTaskHandle, final String str) {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.getMap().queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.bean.TileProviderInner.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z3;
                synchronized (TileProviderInner.this.reqTaskHandleHashMap) {
                    if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(str)) {
                        if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(str)) {
                            TileProviderInner.this.reqTaskHandleHashMap.remove(str);
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            tileReqTaskHandle.finish(tile);
                            TileProviderInner.this.callNativeFunction("finishTileReqTask", new Object[]{tileReqTaskHandle});
                        }
                    }
                }
            }
        });
    }

    @JBindingInclude
    public void cancelTile(TileSourceReq tileSourceReq, TileReqTaskHandle tileReqTaskHandle) {
        String createKey = createKey(tileSourceReq.f12054x, tileSourceReq.f12055y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                a8 a8Var = this.reqTaskHandleHashMap.get(createKey);
                if (a8Var != null) {
                    y2.a();
                    y2.d(a8Var);
                }
                tileReqTaskHandle.status = 1;
                finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, createKey);
                try {
                    TileProvider tileProvider = this.tileProvider;
                    if (tileProvider instanceof TileSourceProvider) {
                        ((TileSourceProvider) tileProvider).cancel(tileSourceReq);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @JBindingInclude
    public void getTile(final TileSourceReq tileSourceReq, final TileReqTaskHandle tileReqTaskHandle) {
        final String createKey = createKey(tileSourceReq.f12054x, tileSourceReq.f12055y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        a8 a8Var = new a8() { // from class: com.autonavi.base.ae.gmap.bean.TileProviderInner.1
            @Override // com.amap.api.col.p0003l.a8
            public void runTask() {
                Tile tile;
                try {
                    synchronized (TileProviderInner.this.reqTaskHandleHashMap) {
                        if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(createKey)) {
                            if (TileProviderInner.this.tileProvider != null) {
                                Tile tile2 = TileProvider.NO_TILE;
                                try {
                                    if (TileProviderInner.this.tileProvider instanceof TileSourceProvider) {
                                        tile = ((TileSourceProvider) TileProviderInner.this.tileProvider).getTile(tileSourceReq);
                                    } else {
                                        TileProvider tileProvider = TileProviderInner.this.tileProvider;
                                        TileSourceReq tileSourceReq2 = tileSourceReq;
                                        tile = tileProvider.getTile(tileSourceReq2.f12054x, tileSourceReq2.f12055y, tileSourceReq2.zoom);
                                    }
                                } catch (Throwable unused) {
                                }
                                TileProviderInner.this.finishDownload(tile, tileReqTaskHandle, createKey);
                            }
                        }
                    }
                } catch (Throwable th) {
                    TileProviderInner.this.finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, createKey);
                    th.printStackTrace();
                }
            }
        };
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                return;
            }
            this.reqTaskHandleHashMap.put(createKey, a8Var);
            y2.a().b(a8Var);
        }
    }

    @JBindingInclude
    public int getTileHeight() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileHeight();
        }
        return 0;
    }

    @JBindingInclude
    public int getTileWidth() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileWidth();
        }
        return 0;
    }

    @JBindingExclude
    public void init(IGlOverlayLayer iGlOverlayLayer, String str) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.overlayName = str;
    }

    public void setTileSource(List<TileOverlaySource> list) {
        this.mTileSource = list;
    }
}
