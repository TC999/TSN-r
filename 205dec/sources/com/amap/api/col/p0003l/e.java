package com.amap.api.col.p0003l;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ProjectionDelegateImp.java */
/* renamed from: com.amap.api.col.3l.e  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e implements IProjectionDelegate {

    /* renamed from: a  reason: collision with root package name */
    private IAMapDelegate f7476a;

    public e(IAMapDelegate iAMapDelegate) {
        this.f7476a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float calculateMapZoomer(LatLng latLng, int i4) {
        IAMapDelegate iAMapDelegate = this.f7476a;
        if (iAMapDelegate == null || latLng == null) {
            return 3.0f;
        }
        GLMapState mapProjection = iAMapDelegate.getMapProjection();
        MapConfig mapConfig = this.f7476a.getMapConfig();
        if (mapProjection == null || mapConfig == null) {
            return 3.0f;
        }
        return a3.e(mapProjection, (int) mapConfig.getSX(), (int) mapConfig.getSY(), latLng.latitude, latLng.longitude, i4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i4, int i5) throws RemoteException {
        if (latLngBounds == null || i4 < 0 || i4 > 20 || i5 <= 0) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        IAMapDelegate iAMapDelegate = this.f7476a;
        LatLng latLng = latLngBounds.southwest;
        iAMapDelegate.latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        IAMapDelegate iAMapDelegate2 = this.f7476a;
        LatLng latLng2 = latLngBounds.northeast;
        iAMapDelegate2.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        int i6 = ((Point) obtain).x;
        int i7 = 20 - i4;
        int i8 = (i6 >> i7) / i5;
        int i9 = (((Point) obtain).y >> i7) / i5;
        int i10 = (((Point) obtain2).x >> i7) / i5;
        int i11 = ((Point) obtain2).y;
        int i12 = (i11 >> i7) / i5;
        obtain.recycle();
        obtain2.recycle();
        return new TileProjection((i6 - ((i8 << i7) * i5)) >> i7, (i11 - ((i12 << i7) * i5)) >> i7, i8, i10, i12, i9);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final LatLng fromScreenLocation(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.f7476a.getPixel2LatLng(point.x, point.y, obtain);
        LatLng latLng = new LatLng(obtain.f11672y, obtain.f11671x);
        obtain.recycle();
        return latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final AMapCameraInfo getCameraInfo() {
        return this.f7476a.getCamerInfo();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final LatLngBounds getMapBounds(LatLng latLng, float f4) throws RemoteException {
        IAMapDelegate iAMapDelegate = this.f7476a;
        if (iAMapDelegate == null || latLng == null) {
            return null;
        }
        return iAMapDelegate.getMapBounds(latLng, f4, 0.0f, 0.0f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final VisibleRegion getVisibleRegion() throws RemoteException {
        int mapWidth = this.f7476a.getMapWidth();
        int mapHeight = this.f7476a.getMapHeight();
        LatLng fromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng fromScreenLocation2 = fromScreenLocation(new Point(mapWidth, 0));
        LatLng fromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
        LatLng fromScreenLocation4 = fromScreenLocation(new Point(mapWidth, mapHeight));
        return new VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float toMapLenWithWin(int i4) {
        if (i4 <= 0) {
            return 0.0f;
        }
        return this.f7476a.toMapLenWithWin(i4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final PointF toMapLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint obtain = FPoint.obtain();
        this.f7476a.getLatLng2Map(latLng.latitude, latLng.longitude, obtain);
        PointF pointF = new PointF(((PointF) obtain).x, ((PointF) obtain).y);
        obtain.recycle();
        return pointF;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        this.f7476a.getLatLng2Pixel(latLng.latitude, latLng.longitude, obtain);
        Point point = new Point(((Point) obtain).x, ((Point) obtain).y);
        obtain.recycle();
        return point;
    }
}
