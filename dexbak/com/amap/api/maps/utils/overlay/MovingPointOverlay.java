package com.amap.api.maps.utils.overlay;

import android.graphics.Point;
import com.amap.api.col.p0463l.ThreadPool;
import com.amap.api.col.p0463l.ThreadTask;
import com.amap.api.col.p0463l.ThreadUtilPoolFactory;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.github.mikephil.charting.utils.Utils;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MovingPointOverlay {
    private BasePointOverlay baseOverlay;
    private AMap mAMap;
    private ThreadPool mThreadPools;
    private MoveListener moveListener;
    private long pauseMillis;
    private long duration = 10000;
    private long mStepDuration = 20;
    private LinkedList<LatLng> points = new LinkedList<>();
    private LinkedList<Double> eachDistance = new LinkedList<>();
    private double totalDistance = Utils.DOUBLE_EPSILON;
    private double remainDistance = Utils.DOUBLE_EPSILON;
    private Object mLock = new Object();
    private int index = 0;
    private boolean useDefaultDescriptor = false;
    AtomicBoolean exitFlag = new AtomicBoolean(false);
    private EnumC2286a STATUS = EnumC2286a.ACTION_UNKNOWN;
    private long mAnimationBeginTime = System.currentTimeMillis();

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface MoveListener {
        void move(double d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.maps.utils.overlay.MovingPointOverlay$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2286a {
        ACTION_UNKNOWN,
        ACTION_START,
        ACTION_RUNNING,
        ACTION_PAUSE,
        ACTION_STOP
    }

    /* renamed from: com.amap.api.maps.utils.overlay.MovingPointOverlay$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C2287b extends ThreadTask {
        private C2287b() {
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                MovingPointOverlay.this.mAnimationBeginTime = System.currentTimeMillis();
                MovingPointOverlay.this.STATUS = EnumC2286a.ACTION_START;
                MovingPointOverlay.this.exitFlag.set(false);
                while (!MovingPointOverlay.this.exitFlag.get() && MovingPointOverlay.this.index <= MovingPointOverlay.this.points.size() - 1) {
                    synchronized (MovingPointOverlay.this.mLock) {
                        if (MovingPointOverlay.this.exitFlag.get()) {
                            return;
                        }
                        if (MovingPointOverlay.this.STATUS != EnumC2286a.ACTION_PAUSE) {
                            MovingPointOverlay.this.baseOverlay.setGeoPoint(MovingPointOverlay.this.getCurPosition(System.currentTimeMillis() - MovingPointOverlay.this.mAnimationBeginTime));
                            MovingPointOverlay.this.STATUS = EnumC2286a.ACTION_RUNNING;
                        }
                    }
                    Thread.sleep(MovingPointOverlay.this.mStepDuration);
                }
                MovingPointOverlay.this.STATUS = EnumC2286a.ACTION_STOP;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* synthetic */ C2287b(MovingPointOverlay movingPointOverlay, byte b) {
            this();
        }
    }

    public MovingPointOverlay(AMap aMap, BasePointOverlay basePointOverlay) {
        this.baseOverlay = null;
        if (aMap == null || basePointOverlay == null) {
            return;
        }
        this.mAMap = aMap;
        this.mThreadPools = ThreadUtilPoolFactory.m53336b("AMapMoveSmoothThread");
        this.baseOverlay = basePointOverlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IPoint getCurPosition(long j) {
        CameraPosition cameraPosition;
        MoveListener moveListener;
        long j2 = this.duration;
        int i = 0;
        if (j > j2) {
            this.exitFlag.set(true);
            IPoint iPoint = new IPoint();
            int size = this.points.size() - 1;
            this.index = size;
            LatLng latLng = this.points.get(size);
            int i2 = this.index - 1;
            this.index = i2;
            this.index = Math.max(i2, 0);
            this.remainDistance = Utils.DOUBLE_EPSILON;
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MoveListener moveListener2 = this.moveListener;
            if (moveListener2 != null) {
                moveListener2.move(this.remainDistance);
            }
            return iPoint;
        }
        double d = j;
        double d2 = this.totalDistance;
        Double.isNaN(d);
        double d3 = j2;
        Double.isNaN(d3);
        double d4 = (d * d2) / d3;
        this.remainDistance = d2 - d4;
        int i3 = 0;
        while (true) {
            if (i3 >= this.eachDistance.size()) {
                break;
            }
            double doubleValue = this.eachDistance.get(i3).doubleValue();
            if (d4 > doubleValue) {
                d4 -= doubleValue;
                i3++;
            } else {
                r0 = doubleValue > Utils.DOUBLE_EPSILON ? d4 / doubleValue : 1.0d;
                i = i3;
            }
        }
        if (i != this.index && (moveListener = this.moveListener) != null) {
            moveListener.move(this.remainDistance);
        }
        this.index = i;
        LatLng latLng2 = this.points.get(i);
        LatLng latLng3 = this.points.get(i + 1);
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        MapProjection.lonlat2Geo(latLng3.longitude, latLng3.latitude, iPoint3);
        int i4 = ((Point) iPoint3).x - ((Point) iPoint2).x;
        int i5 = ((Point) iPoint3).y - ((Point) iPoint2).y;
        if (AMapUtils.calculateLineDistance(latLng2, latLng3) > 1.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            AMap aMap = this.mAMap;
            if (aMap != null && (cameraPosition = aMap.getCameraPosition()) != null) {
                this.baseOverlay.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
            }
        }
        double d5 = ((Point) iPoint2).x;
        double d6 = i4;
        Double.isNaN(d6);
        Double.isNaN(d5);
        double d7 = ((Point) iPoint2).y;
        double d8 = i5;
        Double.isNaN(d8);
        Double.isNaN(d7);
        return new IPoint((int) (d5 + (d6 * r0)), (int) (d7 + (d8 * r0)));
    }

    private float getRotate(IPoint iPoint, IPoint iPoint2) {
        if (iPoint == null || iPoint2 == null) {
            return 0.0f;
        }
        double d = ((Point) iPoint2).y;
        double d2 = ((Point) iPoint).y;
        double d3 = ((Point) iPoint).x;
        double d4 = ((Point) iPoint2).x;
        Double.isNaN(d4);
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) ((Math.atan2(d4 - d3, d2 - d) / 3.141592653589793d) * 180.0d);
    }

    private void reset() {
        try {
            EnumC2286a enumC2286a = this.STATUS;
            if (enumC2286a == EnumC2286a.ACTION_RUNNING || enumC2286a == EnumC2286a.ACTION_PAUSE) {
                this.exitFlag.set(true);
                this.mThreadPools.m55655a(this.mStepDuration + 20, TimeUnit.MILLISECONDS);
                this.baseOverlay.setAnimation(null);
                this.STATUS = EnumC2286a.ACTION_UNKNOWN;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            removeMarker();
            this.mThreadPools.m55649g();
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

    public BasePointOverlay getObject() {
        return this.baseOverlay;
    }

    public LatLng getPosition() {
        BasePointOverlay basePointOverlay = this.baseOverlay;
        if (basePointOverlay != null) {
            return basePointOverlay.getPosition();
        }
        return null;
    }

    public void removeMarker() {
        try {
            reset();
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.remove();
                this.baseOverlay = null;
            }
            this.points.clear();
            this.eachDistance.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void resetIndex() {
        this.index = 0;
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
                        this.totalDistance = Utils.DOUBLE_EPSILON;
                        int i = 0;
                        while (i < this.points.size() - 1) {
                            i++;
                            double calculateLineDistance = AMapUtils.calculateLineDistance(this.points.get(i), this.points.get(i));
                            this.eachDistance.add(Double.valueOf(calculateLineDistance));
                            double d = this.totalDistance;
                            Double.isNaN(calculateLineDistance);
                            this.totalDistance = d + calculateLineDistance;
                        }
                        this.remainDistance = this.totalDistance;
                        this.baseOverlay.setPosition(this.points.get(0));
                        reset();
                    }
                }
            }
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.setPosition(latLng);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRotate(float f) {
        AMap aMap;
        CameraPosition cameraPosition;
        try {
            if (this.baseOverlay == null || (aMap = this.mAMap) == null || (cameraPosition = aMap.getCameraPosition()) == null) {
                return;
            }
            this.baseOverlay.setRotateAngle((360.0f - f) + cameraPosition.bearing);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTotalDuration(int i) {
        this.duration = i * 1000;
    }

    public void setVisible(boolean z) {
        try {
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.setVisible(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startSmoothMove() {
        EnumC2286a enumC2286a = this.STATUS;
        if (enumC2286a == EnumC2286a.ACTION_PAUSE) {
            this.STATUS = EnumC2286a.ACTION_RUNNING;
            this.mAnimationBeginTime += System.currentTimeMillis() - this.pauseMillis;
        } else if ((enumC2286a == EnumC2286a.ACTION_UNKNOWN || enumC2286a == EnumC2286a.ACTION_STOP) && this.points.size() > 0) {
            this.index = 0;
            try {
                this.mThreadPools.m55654b(new C2287b(this, (byte) 0));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void stopMove() {
        synchronized (this.mLock) {
            if (this.STATUS == EnumC2286a.ACTION_RUNNING) {
                this.STATUS = EnumC2286a.ACTION_PAUSE;
                this.pauseMillis = System.currentTimeMillis();
            }
        }
    }
}
