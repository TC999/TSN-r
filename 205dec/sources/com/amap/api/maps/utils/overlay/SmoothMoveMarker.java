package com.amap.api.maps.utils.overlay;

import android.graphics.Point;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.z2;
import com.amap.api.col.p0003l.z7;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SmoothMoveMarker {
    public static final float MIN_OFFSET_DISTANCE = 5.0f;
    private BitmapDescriptor descriptor;
    private AMap mAMap;
    private MoveListener moveListener;
    private long pauseMillis;
    private long duration = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
    private long mStepDuration = 20;
    private LinkedList<LatLng> points = new LinkedList<>();
    private LinkedList<Double> eachDistance = new LinkedList<>();
    private double totalDistance = 0.0d;
    private double remainDistance = 0.0d;
    private Object mLock = new Object();
    private Marker marker = null;
    private int index = 0;
    private boolean useDefaultDescriptor = false;
    AtomicBoolean exitFlag = new AtomicBoolean(false);
    private a moveStatus = a.ACTION_UNKNOWN;
    private long mAnimationBeginTime = System.currentTimeMillis();
    private z7 mThreadPools = z2.b("AMapSmoothMoveMarkerThread");

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface MoveListener {
        void move(double d4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        ACTION_UNKNOWN,
        ACTION_START,
        ACTION_RUNNING,
        ACTION_PAUSE,
        ACTION_STOP
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class b extends a8 {
        private b() {
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                SmoothMoveMarker.this.mAnimationBeginTime = System.currentTimeMillis();
                SmoothMoveMarker.this.moveStatus = a.ACTION_START;
                SmoothMoveMarker.this.exitFlag.set(false);
                while (!SmoothMoveMarker.this.exitFlag.get() && SmoothMoveMarker.this.index <= SmoothMoveMarker.this.points.size() - 1) {
                    synchronized (SmoothMoveMarker.this.mLock) {
                        if (SmoothMoveMarker.this.exitFlag.get()) {
                            return;
                        }
                        if (SmoothMoveMarker.this.moveStatus != a.ACTION_PAUSE) {
                            IPoint curPosition = SmoothMoveMarker.this.getCurPosition(System.currentTimeMillis() - SmoothMoveMarker.this.mAnimationBeginTime);
                            if (SmoothMoveMarker.this.marker != null) {
                                SmoothMoveMarker.this.marker.setGeoPoint(curPosition);
                            }
                            SmoothMoveMarker.this.moveStatus = a.ACTION_RUNNING;
                        }
                    }
                    Thread.sleep(SmoothMoveMarker.this.mStepDuration);
                }
                SmoothMoveMarker.this.moveStatus = a.ACTION_STOP;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* synthetic */ b(SmoothMoveMarker smoothMoveMarker, byte b4) {
            this();
        }
    }

    public SmoothMoveMarker(AMap aMap) {
        this.mAMap = aMap;
    }

    private void checkMarkerIcon() {
        if (this.useDefaultDescriptor) {
            BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor == null) {
                this.useDefaultDescriptor = true;
                return;
            }
            this.marker.setIcon(bitmapDescriptor);
            this.useDefaultDescriptor = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IPoint getCurPosition(long j4) {
        CameraPosition cameraPosition;
        MoveListener moveListener;
        long j5 = this.duration;
        int i4 = 0;
        if (j4 > j5) {
            this.exitFlag.set(true);
            IPoint iPoint = new IPoint();
            int size = this.points.size() - 1;
            this.index = size;
            LatLng latLng = this.points.get(size);
            int i5 = this.index - 1;
            this.index = i5;
            this.index = Math.max(i5, 0);
            this.remainDistance = 0.0d;
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MoveListener moveListener2 = this.moveListener;
            if (moveListener2 != null) {
                moveListener2.move(this.remainDistance);
            }
            return iPoint;
        }
        double d4 = j4;
        double d5 = this.totalDistance;
        Double.isNaN(d4);
        double d6 = j5;
        Double.isNaN(d6);
        double d7 = (d4 * d5) / d6;
        this.remainDistance = d5 - d7;
        int i6 = 0;
        while (true) {
            if (i6 >= this.eachDistance.size()) {
                break;
            }
            double doubleValue = this.eachDistance.get(i6).doubleValue();
            if (d7 > doubleValue) {
                d7 -= doubleValue;
                i6++;
            } else {
                r0 = doubleValue > 0.0d ? d7 / doubleValue : 1.0d;
                i4 = i6;
            }
        }
        if (i4 != this.index && (moveListener = this.moveListener) != null) {
            moveListener.move(this.remainDistance);
        }
        this.index = i4;
        LatLng latLng2 = this.points.get(i4);
        LatLng latLng3 = this.points.get(i4 + 1);
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        MapProjection.lonlat2Geo(latLng3.longitude, latLng3.latitude, iPoint3);
        int i7 = ((Point) iPoint3).x - ((Point) iPoint2).x;
        int i8 = ((Point) iPoint3).y - ((Point) iPoint2).y;
        if (AMapUtils.calculateLineDistance(latLng2, latLng3) > 5.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            AMap aMap = this.mAMap;
            if (aMap != null && (cameraPosition = aMap.getCameraPosition()) != null) {
                this.marker.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
            }
        }
        double d8 = ((Point) iPoint2).x;
        double d9 = i7;
        Double.isNaN(d9);
        Double.isNaN(d8);
        double d10 = ((Point) iPoint2).y;
        double d11 = i8;
        Double.isNaN(d11);
        Double.isNaN(d10);
        return new IPoint((int) (d8 + (d9 * r0)), (int) (d10 + (d11 * r0)));
    }

    private float getRotate(IPoint iPoint, IPoint iPoint2) {
        if (iPoint == null || iPoint2 == null) {
            return 0.0f;
        }
        double d4 = ((Point) iPoint2).y;
        double d5 = ((Point) iPoint).y;
        double d6 = ((Point) iPoint).x;
        double d7 = ((Point) iPoint2).x;
        Double.isNaN(d7);
        Double.isNaN(d6);
        Double.isNaN(d5);
        Double.isNaN(d4);
        return (float) ((Math.atan2(d7 - d6, d5 - d4) / 3.141592653589793d) * 180.0d);
    }

    private void reset() {
        try {
            a aVar = this.moveStatus;
            if (aVar == a.ACTION_RUNNING || aVar == a.ACTION_PAUSE) {
                this.exitFlag.set(true);
                this.mThreadPools.a(this.mStepDuration + 20, TimeUnit.MILLISECONDS);
                Marker marker = this.marker;
                if (marker != null) {
                    marker.setAnimation(null);
                }
                this.moveStatus = a.ACTION_UNKNOWN;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void destroy() {
        try {
            reset();
            this.mThreadPools.g();
            BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor != null) {
                bitmapDescriptor.recycle();
            }
            Marker marker = this.marker;
            if (marker != null) {
                marker.destroy();
                this.marker = null;
            }
            synchronized (this.mLock) {
                this.points.clear();
                this.eachDistance.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getIndex() {
        return this.index;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getPosition() {
        Marker marker = this.marker;
        if (marker == null) {
            return null;
        }
        return marker.getPosition();
    }

    public void removeMarker() {
        Marker marker = this.marker;
        if (marker != null) {
            marker.remove();
            this.marker = null;
        }
        this.points.clear();
        this.eachDistance.clear();
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setDescriptor(BitmapDescriptor bitmapDescriptor) {
        BitmapDescriptor bitmapDescriptor2 = this.descriptor;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
        }
        this.descriptor = bitmapDescriptor;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setIcon(bitmapDescriptor);
        }
    }

    public void setMoveListener(MoveListener moveListener) {
        this.moveListener = moveListener;
    }

    public void setPoints(List<LatLng> list) {
        synchronized (this.mLock) {
            if (list != null) {
                try {
                    if (list.size() >= 2) {
                        stopMove();
                        this.points.clear();
                        for (LatLng latLng : list) {
                            if (latLng != null) {
                                this.points.add(latLng);
                            }
                        }
                        this.eachDistance.clear();
                        this.totalDistance = 0.0d;
                        int i4 = 0;
                        while (i4 < this.points.size() - 1) {
                            i4++;
                            double calculateLineDistance = AMapUtils.calculateLineDistance(this.points.get(i4), this.points.get(i4));
                            this.eachDistance.add(Double.valueOf(calculateLineDistance));
                            double d4 = this.totalDistance;
                            Double.isNaN(calculateLineDistance);
                            this.totalDistance = d4 + calculateLineDistance;
                        }
                        this.remainDistance = this.totalDistance;
                        LatLng latLng2 = this.points.get(0);
                        Marker marker = this.marker;
                        if (marker != null) {
                            marker.setPosition(latLng2);
                            checkMarkerIcon();
                        } else {
                            if (this.descriptor == null) {
                                this.useDefaultDescriptor = true;
                            }
                            this.marker = this.mAMap.addMarker(new MarkerOptions().belowMaskLayer(true).position(latLng2).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
                        }
                        reset();
                    }
                }
            }
        }
    }

    public void setPosition(LatLng latLng) {
        Marker marker = this.marker;
        if (marker != null) {
            marker.setPosition(latLng);
            checkMarkerIcon();
            return;
        }
        if (this.descriptor == null) {
            this.useDefaultDescriptor = true;
        }
        this.marker = this.mAMap.addMarker(new MarkerOptions().belowMaskLayer(true).position(latLng).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
    }

    public void setRotate(float f4) {
        AMap aMap;
        CameraPosition cameraPosition;
        if (this.marker == null || (aMap = this.mAMap) == null || aMap == null || (cameraPosition = aMap.getCameraPosition()) == null) {
            return;
        }
        this.marker.setRotateAngle((360.0f - f4) + cameraPosition.bearing);
    }

    public void setTotalDuration(int i4) {
        this.duration = i4 * 1000;
    }

    public void setVisible(boolean z3) {
        Marker marker = this.marker;
        if (marker != null) {
            marker.setVisible(z3);
        }
    }

    public void startSmoothMove() {
        a aVar = this.moveStatus;
        if (aVar == a.ACTION_PAUSE) {
            this.moveStatus = a.ACTION_RUNNING;
            this.mAnimationBeginTime += System.currentTimeMillis() - this.pauseMillis;
        } else if ((aVar == a.ACTION_UNKNOWN || aVar == a.ACTION_STOP) && this.points.size() > 0) {
            this.index = 0;
            try {
                this.mThreadPools.b(new b(this, (byte) 0));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void stopMove() {
        if (this.moveStatus == a.ACTION_RUNNING) {
            this.moveStatus = a.ACTION_PAUSE;
            this.pauseMillis = System.currentTimeMillis();
        }
    }
}
