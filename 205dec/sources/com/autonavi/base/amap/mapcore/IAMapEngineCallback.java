package com.autonavi.base.amap.mapcore;

import com.amap.api.maps.model.BitmapDescriptor;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IAMapEngineCallback {
    void OnIndoorBuildingActivity(int i4, byte[] bArr);

    void cancelRequireMapData(Object obj);

    int generateRequestId();

    BitmapDescriptor getDefaultTerrainImage();

    List<BitmapDescriptor> getSkyBoxImages();

    InitStorageParam getStorageInitParam();

    TileProviderInner getTerrainTileProvider();

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    void onMapBlandClick(double d4, double d5);

    void onMapPOIClick(MapPoi mapPoi);

    void onMapRender(int i4, int i5);

    void reloadMapResource(int i4, String str, int i5);

    byte[] requireCharBitmap(int i4, int i5, int i6);

    byte[] requireCharsWidths(int i4, int[] iArr, int i5, int i6);

    void requireMapRender(int i4, int i5, int i6);

    byte[] requireMapResource(int i4, String str);
}
