package com.autonavi.base.amap.mapcore;

import com.amap.api.maps.model.BitmapDescriptor;
import com.autonavi.base.p048ae.gmap.AMapAppRequestParam;
import com.autonavi.base.p048ae.gmap.MapPoi;
import com.autonavi.base.p048ae.gmap.bean.InitStorageParam;
import com.autonavi.base.p048ae.gmap.bean.TileProviderInner;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IAMapEngineCallback {
    void OnIndoorBuildingActivity(int i, byte[] bArr);

    void cancelRequireMapData(Object obj);

    int generateRequestId();

    BitmapDescriptor getDefaultTerrainImage();

    List<BitmapDescriptor> getSkyBoxImages();

    InitStorageParam getStorageInitParam();

    TileProviderInner getTerrainTileProvider();

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    void onMapBlandClick(double d, double d2);

    void onMapPOIClick(MapPoi mapPoi);

    void onMapRender(int i, int i2);

    void reloadMapResource(int i, String str, int i2);

    byte[] requireCharBitmap(int i, int i2, int i3);

    byte[] requireCharsWidths(int i, int[] iArr, int i2, int i3);

    void requireMapRender(int i, int i2, int i3);

    byte[] requireMapResource(int i, String str);
}
