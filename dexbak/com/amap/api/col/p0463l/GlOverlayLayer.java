package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.ImageOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileProvider;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.p048ae.gmap.AMapAppRequestParam;
import com.autonavi.base.p048ae.gmap.AMapAppResourceItem;
import com.autonavi.base.p048ae.gmap.bean.MultiPointItemHitTest;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.3l.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class GlOverlayLayer implements IGlOverlayLayer, AMapNativeGlOverlayLayer.NativeFunCallListener {

    /* renamed from: a */
    IAMapDelegate f3594a;

    /* renamed from: b */
    private Context f3595b;

    /* renamed from: g */
    private NativeBaseTileOverlay f3600g;

    /* renamed from: c */
    private int f3596c = 0;

    /* renamed from: d */
    private final Object f3597d = new Object();

    /* renamed from: f */
    private final Map<String, BaseOverlay> f3599f = new ConcurrentHashMap();

    /* renamed from: h */
    private BitmapDescriptor f3601h = null;

    /* renamed from: i */
    private BitmapDescriptor f3602i = null;

    /* renamed from: j */
    private BitmapDescriptor f3603j = null;

    /* renamed from: k */
    private BitmapDescriptor f3604k = null;

    /* renamed from: l */
    private BitmapDescriptor f3605l = null;

    /* renamed from: m */
    private BitmapDescriptor f3606m = null;

    /* renamed from: n */
    private BitmapDescriptor f3607n = null;

    /* renamed from: o */
    private BitmapDescriptor f3608o = null;

    /* renamed from: p */
    boolean f3609p = false;

    /* renamed from: q */
    List<String> f3610q = new ArrayList();

    /* renamed from: e */
    private AMapNativeGlOverlayLayer f3598e = new AMapNativeGlOverlayLayer();

    /* compiled from: GlOverlayLayer.java */
    /* renamed from: com.amap.api.col.3l.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1743a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ AMapAppRequestParam f3611a;

        C1743a(AMapAppRequestParam aMapAppRequestParam) {
            this.f3611a = aMapAppRequestParam;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                byte[] makeHttpRequestWithInterrupted = new AMap3DModelTileProvider.AMap3DModelRequest(this.f3611a.getUrl()).makeHttpRequestWithInterrupted();
                AMapAppResourceItem aMapAppResourceItem = new AMapAppResourceItem();
                aMapAppResourceItem.setData(makeHttpRequestWithInterrupted);
                aMapAppResourceItem.setSize(makeHttpRequestWithInterrupted.length);
                aMapAppResourceItem.setResourceType(this.f3611a.getResourceType());
                this.f3611a.getCallback().callSuccess(aMapAppResourceItem);
            } catch (Exception e) {
                e.printStackTrace();
                this.f3611a.getCallback().callFailed(e.getMessage());
            }
        }
    }

    public GlOverlayLayer(IAMapDelegate iAMapDelegate, Context context) {
        this.f3594a = iAMapDelegate;
        this.f3595b = context;
        this.f3600g = new NativeBaseTileOverlay(iAMapDelegate);
    }

    /* renamed from: a */
    private BitmapDescriptor m55613a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.f3595b != null) {
            LinearLayout linearLayout = new LinearLayout(this.f3595b);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return BitmapDescriptorFactory.fromBitmap(C1732a3.m55696n(view));
    }

    /* renamed from: b */
    private void m55612b(String str, BaseOptions baseOptions) {
        try {
            this.f3598e.createOverlay(str, baseOptions);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "GlOverlayLayer", "addOverlay");
            th.printStackTrace();
            Log.d("amapApi", "GlOverlayLayer addOverlay error:" + th.getMessage());
        }
    }

    /* renamed from: c */
    private void m55611c(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        m55612b(str, baseOptions);
        synchronized (this.f3599f) {
            this.f3599f.put(str, baseOverlay);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsCircleContainPoint(CircleOptions circleOptions, LatLng latLng) {
        if (latLng != null && circleOptions != null) {
            try {
                synchronized (circleOptions) {
                    List<BaseHoleOptions> holeOptions = circleOptions.getHoleOptions();
                    if (holeOptions != null && holeOptions.size() > 0) {
                        for (BaseHoleOptions baseHoleOptions : holeOptions) {
                            if (C1732a3.m55734K(baseHoleOptions, latLng)) {
                                return false;
                            }
                        }
                    }
                    return circleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleOptions.getCenter(), latLng));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsPolygonContainsPoint(PolygonOptions polygonOptions, LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        try {
            List<BaseHoleOptions> holeOptions = polygonOptions.getHoleOptions();
            if (holeOptions != null && holeOptions.size() > 0) {
                for (BaseHoleOptions baseHoleOptions : holeOptions) {
                    if (C1732a3.m55734K(baseHoleOptions, latLng)) {
                        return false;
                    }
                }
            }
            return C1732a3.m55732M(latLng, polygonOptions.getPoints());
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay addOverlayObject(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        m55611c(str, baseOverlay, baseOptions);
        return baseOverlay;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void changeOverlayIndex() {
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean checkInBounds(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "checkInBounds", new Object[]{str});
            if (nativeProperties instanceof Boolean) {
                return ((Boolean) nativeProperties).booleanValue();
            }
        }
        return true;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void clear(String... strArr) {
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
            if (aMapNativeGlOverlayLayer != null && strArr != null) {
                aMapNativeGlOverlayLayer.clear(strArr);
            }
            synchronized (this.f3599f) {
                if (strArr != null) {
                    Iterator<Map.Entry<String, BaseOverlay>> it = this.f3599f.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, BaseOverlay> next = it.next();
                        int length = strArr.length;
                        boolean z = false;
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                String str = strArr[i];
                                if (str != null && str.equals(next.getKey())) {
                                    z = true;
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                        if (!z) {
                            it.remove();
                        }
                    }
                } else {
                    this.f3599f.clear();
                }
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "GlOverlayLayer", "clear");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearOverlayByType(String str) {
        synchronized (this.f3599f) {
            ArrayList<String> arrayList = new ArrayList();
            Iterator<Map.Entry<String, BaseOverlay>> it = this.f3599f.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (key.contains(str)) {
                    it.remove();
                    arrayList.add(key);
                }
            }
            for (String str2 : arrayList) {
                removeOverlay(str2);
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearTileCache() {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "clearTileCache", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final String createId(String str) {
        String str2;
        synchronized (this.f3597d) {
            this.f3596c++;
            str2 = str + this.f3596c;
        }
        return str2;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void destroy() {
        try {
            if (this.f3598e == null) {
                return;
            }
            synchronized (this.f3599f) {
                this.f3599f.clear();
            }
            this.f3598e.clear("");
            this.f3598e.destroy();
            this.f3598e = null;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "GlOverlayLayer", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized boolean draw(int i, int i2, boolean z) {
        boolean z2 = false;
        try {
            NativeBaseTileOverlay nativeBaseTileOverlay = this.f3600g;
            if (nativeBaseTileOverlay != null) {
                nativeBaseTileOverlay.m54154a();
            }
        } finally {
            return z2;
        }
        if (this.f3594a.getMapConfig() == null) {
            return false;
        }
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.render(i, i2, z);
        }
        z2 = true;
        return z2;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void getAMapResource(AMapAppRequestParam aMapAppRequestParam) {
        ThreadUtil.m53406a().m53405b(new C1743a(aMapAppRequestParam));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getBuildInImageData(int i) {
        try {
            switch (i) {
                case 0:
                    BitmapDescriptor bitmapDescriptor = this.f3601h;
                    if (bitmapDescriptor == null || bitmapDescriptor.getBitmap().isRecycled()) {
                        this.f3601h = BitmapDescriptorFactory.fromBitmap(C1732a3.m55698l(this.f3595b, "amap_sdk_lineTexture.png"));
                    }
                    return this.f3601h;
                case 1:
                    BitmapDescriptor bitmapDescriptor2 = this.f3604k;
                    if (bitmapDescriptor2 == null || bitmapDescriptor2.getBitmap().isRecycled()) {
                        this.f3604k = BitmapDescriptorFactory.fromBitmap(C1732a3.m55698l(this.f3595b, "amap_sdk_lineTexture.png"));
                    }
                    return this.f3604k;
                case 2:
                    BitmapDescriptor bitmapDescriptor3 = this.f3603j;
                    if (bitmapDescriptor3 == null || bitmapDescriptor3.getBitmap().isRecycled()) {
                        this.f3603j = BitmapDescriptorFactory.fromBitmap(C1732a3.m55698l(this.f3595b, "amap_sdk_lineDashTexture_circle.png"));
                    }
                    return this.f3603j;
                case 3:
                    BitmapDescriptor bitmapDescriptor4 = this.f3602i;
                    if (bitmapDescriptor4 == null || bitmapDescriptor4.getBitmap().isRecycled()) {
                        this.f3602i = BitmapDescriptorFactory.fromBitmap(C1732a3.m55698l(this.f3595b, "amap_sdk_lineDashTexture_square.png"));
                    }
                    return this.f3602i;
                case 4:
                    BitmapDescriptor bitmapDescriptor5 = this.f3605l;
                    if (bitmapDescriptor5 == null || bitmapDescriptor5.getBitmap().isRecycled()) {
                        this.f3605l = BitmapDescriptorFactory.defaultMarker();
                    }
                    return this.f3605l;
                case 5:
                    BitmapDescriptor bitmapDescriptor6 = this.f3606m;
                    if (bitmapDescriptor6 == null || bitmapDescriptor6.getBitmap().isRecycled()) {
                        this.f3606m = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
                    }
                    return this.f3606m;
                case 6:
                    BitmapDescriptor bitmapDescriptor7 = this.f3607n;
                    if (bitmapDescriptor7 == null || bitmapDescriptor7.getBitmap().isRecycled()) {
                        this.f3607n = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
                    }
                    return this.f3607n;
                case 7:
                    BitmapDescriptor bitmapDescriptor8 = this.f3608o;
                    if (bitmapDescriptor8 == null || bitmapDescriptor8.getBitmap().isRecycled()) {
                        this.f3608o = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
                    }
                    return this.f3608o;
                default:
                    return this.f3601h;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final int getCurrentParticleNum(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getCurrentParticleNum(str);
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getCustomImageData(ImageOptions imageOptions) {
        float f;
        float f2;
        if (imageOptions == null) {
            return null;
        }
        if (imageOptions.type == ImageOptions.ShapeType.CIRCLE.value()) {
            if (imageOptions.radius == Utils.DOUBLE_EPSILON) {
                return null;
            }
            float m53806a = ResourcesUtil.m53806a(this.f3595b, (int) f2);
            int i = ((int) m53806a) * 2;
            Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(createBitmap);
            Path path = new Path();
            path.addCircle(m53806a, m53806a, m53806a, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.drawColor(imageOptions.color);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
            return BitmapDescriptorFactory.fromBitmap(createBitmap);
        } else if (imageOptions.type == ImageOptions.ShapeType.TEXT.value()) {
            String str = imageOptions.content;
            int i2 = imageOptions.fontSize;
            if (str.isEmpty()) {
                return null;
            }
            Paint paint2 = new Paint();
            paint2.setTextSize(ResourcesUtil.m53806a(this.f3595b, i2));
            paint2.setFakeBoldText(true);
            paint2.setColor(imageOptions.color);
            float measureText = paint2.measureText(str);
            Rect rect = new Rect();
            paint2.getTextBounds(str, 0, str.length(), rect);
            Bitmap createBitmap2 = Bitmap.createBitmap((int) measureText, rect.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            canvas2.save();
            canvas2.drawColor(0);
            canvas2.drawText(str, 0.0f, -rect.top, paint2);
            canvas2.restore();
            return BitmapDescriptorFactory.fromBitmap(createBitmap2);
        } else if (imageOptions.type == ImageOptions.ShapeType.DEFAULT.value()) {
            if (imageOptions.radius == Utils.DOUBLE_EPSILON) {
                return null;
            }
            float m53806a2 = ResourcesUtil.m53806a(this.f3595b, (int) f);
            int i3 = (int) m53806a2;
            Bitmap createBitmap3 = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
            Paint paint3 = new Paint();
            paint3.setAntiAlias(true);
            Canvas canvas3 = new Canvas(createBitmap3);
            Path path2 = new Path();
            path2.addRect(0.0f, 0.0f, m53806a2, m53806a2, Path.Direction.CW);
            canvas3.clipPath(path2);
            double[] dArr = imageOptions.rgba;
            canvas3.drawColor(Color.argb((float) dArr[3], (float) dArr[0], (float) dArr[1], (float) dArr[2]));
            canvas3.drawBitmap(createBitmap3, 0.0f, 0.0f, paint3);
            return BitmapDescriptorFactory.fromBitmap(createBitmap3);
        } else {
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized BaseOverlay getHitBaseOverlay(LatLng latLng, int i) {
        BaseOverlay baseOverlay;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            String contain = aMapNativeGlOverlayLayer.contain(latLng, i);
            if (TextUtils.isEmpty(contain)) {
                return null;
            }
            synchronized (this.f3599f) {
                baseOverlay = this.f3599f.get(contain);
            }
            return baseOverlay;
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized Polyline getHitOverlay(LatLng latLng, int i) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            String contain = aMapNativeGlOverlayLayer.contain(latLng, i);
            if (TextUtils.isEmpty(contain)) {
                return null;
            }
            synchronized (this.f3599f) {
                BaseOverlay baseOverlay = this.f3599f.get(contain);
                r1 = baseOverlay instanceof Polyline ? (Polyline) baseOverlay : null;
            }
        }
        return r1;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoContents(String str) {
        InfoWindowDelegate infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f3594a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f3599f.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return m55613a(infoWindowDelegate.m53363p((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindow(String str) {
        InfoWindowDelegate infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f3594a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f3599f.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return m55613a(infoWindowDelegate.m53375d((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindowClick(String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final long getInfoWindowUpdateOffsetTime(String str) {
        InfoWindowDelegate infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f3594a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return 0L;
        }
        BaseOverlay baseOverlay = this.f3599f.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return infoWindowDelegate.m53358u((BasePointOverlay) baseOverlay);
        }
        return 0L;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final IAMapDelegate getMap() {
        return this.f3594a;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final List<Marker> getMapScreenMarkers() {
        if (this.f3598e != null) {
            this.f3610q.clear();
            this.f3598e.getNativeProperties("", "getMapScreenOverlays", new Object[]{this.f3610q});
            if (this.f3610q.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f3610q) {
                    if (str != null && str.contains("MARKER")) {
                        arrayList.add((Marker) this.f3599f.get(str));
                    }
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getMarkerInfoWindowOffset(String str, FPoint fPoint) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "getMarkerInfoWindowOffset", null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                ((PointF) fPoint).x = point.x;
                ((PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final MultiPointItem getMultiPointItem(LatLng latLng) {
        List<MultiPointItem> items;
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
            if (aMapNativeGlOverlayLayer != null) {
                Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties("", "getMultiPointItem", new LatLng[]{latLng});
                if (nativeProperties instanceof MultiPointItemHitTest) {
                    MultiPointItemHitTest multiPointItemHitTest = (MultiPointItemHitTest) nativeProperties;
                    if (multiPointItemHitTest.index != -1) {
                        BaseOverlay baseOverlay = this.f3599f.get(multiPointItemHitTest.overlayName);
                        if (!(baseOverlay instanceof MultiPointOverlay) || (items = ((MultiPointOverlay) baseOverlay).getItems()) == null) {
                            return null;
                        }
                        int size = items.size();
                        int i = multiPointItemHitTest.index;
                        if (size > i) {
                            return items.get(i);
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final Object getNativeProperties(String str, String str2, Object[] objArr) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getNativeProperties(str, str2, objArr);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng) {
        List<LatLng> points;
        if (latLng != null && polylineOptions != null && (points = polylineOptions.getPoints()) != null && points.size() != 0) {
            float f = 0.0f;
            int i = 0;
            for (int i2 = 0; i2 < points.size(); i2++) {
                try {
                    if (i2 == 0) {
                        f = AMapUtils.calculateLineDistance(latLng, points.get(i2));
                    } else {
                        float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, points.get(i2));
                        if (f > calculateLineDistance) {
                            i = i2;
                            f = calculateLineDistance;
                        }
                    }
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "PolylineDelegate", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return points.get(i);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getOverlayScreenPos(String str, FPoint fPoint) {
        if (this.f3599f.get(str) instanceof BasePointOverlay) {
            Object nativeProperties = this.f3598e.getNativeProperties(str, "getMarkerScreenPos", null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                ((PointF) fPoint).x = point.x;
                ((PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getOverturnInfoWindow(String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getOverturnInfoWindowClick(String str) {
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void hideInfoWindow(String str) {
        if (this.f3598e != null) {
            this.f3594a.hideInfoWindow();
            this.f3598e.getNativeProperties(str, "setInfoWindowShown", new Object[]{Boolean.FALSE});
        }
        setRunLowFrame(false);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean isGLTFAnimated() {
        boolean z;
        synchronized (this.f3599f) {
            Iterator<Map.Entry<String, BaseOverlay>> it = this.f3599f.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Map.Entry<String, BaseOverlay> next = it.next();
                BaseOverlay value = next.getValue();
                if (next.getKey().contains("GLTFOVERLAY") && ((GLTFOverlay) value).isAnimated()) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void onCreateAMapInstance() {
        if (this.f3598e == null) {
            this.f3598e = new AMapNativeGlOverlayLayer();
        }
        this.f3598e.setEngineId(this.f3594a.getNativeEngineID());
        this.f3598e.createNative(this.f3594a.getGLMapEngine().getNativeInstance());
        this.f3598e.setNativeFunCallListener(this);
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onRedrawInfowindow() {
        IAMapDelegate iAMapDelegate = this.f3594a;
        if (iAMapDelegate != null) {
            iAMapDelegate.redrawInfoWindow();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onSetRunLowFrame(boolean z) {
        setRunLowFrame(z);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str) {
        boolean z;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.removeOverlay(str);
            z = true;
        } else {
            z = false;
        }
        synchronized (this.f3599f) {
            this.f3599f.remove(str);
        }
        return z;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str, boolean z) {
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void set2Top(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties(str, "set2Top", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setFlingState(boolean z) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f3598e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "setFlingState", new Object[]{Boolean.valueOf(z)});
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setRunLowFrame(boolean z) {
        IAMapDelegate iAMapDelegate = this.f3594a;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(z);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void showInfoWindow(String str) {
        Map<String, BaseOverlay> map;
        if (this.f3598e == null || (map = this.f3599f) == null) {
            return;
        }
        try {
            this.f3594a.showInfoWindow(map.get(str));
            setRunLowFrame(false);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void updateOption(String str, BaseOptions baseOptions) {
        try {
            if (this.f3598e == null) {
                return;
            }
            setRunLowFrame(false);
            this.f3598e.updateOptions(str, baseOptions);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "GlOverlayLayer", "updateOption");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay getHitBaseOverlay(MotionEvent motionEvent, int i) {
        if (this.f3594a != null) {
            DPoint obtain = DPoint.obtain();
            this.f3594a.getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
            LatLng latLng = new LatLng(obtain.f7978y, obtain.f7977x);
            obtain.recycle();
            return getHitBaseOverlay(latLng, i);
        }
        return null;
    }
}
