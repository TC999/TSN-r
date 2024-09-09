package com.amap.api.col.p0003l;

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
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.AMapAppResourceItem;
import com.autonavi.base.ae.gmap.bean.MultiPointItemHitTest;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer;
import com.autonavi.base.amap.mapcore.FPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: GlOverlayLayer.java */
/* renamed from: com.amap.api.col.3l.b  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b implements IGlOverlayLayer, AMapNativeGlOverlayLayer.NativeFunCallListener {

    /* renamed from: a  reason: collision with root package name */
    IAMapDelegate f7155a;

    /* renamed from: b  reason: collision with root package name */
    private Context f7156b;

    /* renamed from: g  reason: collision with root package name */
    private q1 f7161g;

    /* renamed from: c  reason: collision with root package name */
    private int f7157c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final Object f7158d = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, BaseOverlay> f7160f = new ConcurrentHashMap();

    /* renamed from: h  reason: collision with root package name */
    private BitmapDescriptor f7162h = null;

    /* renamed from: i  reason: collision with root package name */
    private BitmapDescriptor f7163i = null;

    /* renamed from: j  reason: collision with root package name */
    private BitmapDescriptor f7164j = null;

    /* renamed from: k  reason: collision with root package name */
    private BitmapDescriptor f7165k = null;

    /* renamed from: l  reason: collision with root package name */
    private BitmapDescriptor f7166l = null;

    /* renamed from: m  reason: collision with root package name */
    private BitmapDescriptor f7167m = null;

    /* renamed from: n  reason: collision with root package name */
    private BitmapDescriptor f7168n = null;

    /* renamed from: o  reason: collision with root package name */
    private BitmapDescriptor f7169o = null;

    /* renamed from: p  reason: collision with root package name */
    boolean f7170p = false;

    /* renamed from: q  reason: collision with root package name */
    List<String> f7171q = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private AMapNativeGlOverlayLayer f7159e = new AMapNativeGlOverlayLayer();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: GlOverlayLayer.java */
    /* renamed from: com.amap.api.col.3l.b$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AMapAppRequestParam f7172a;

        a(AMapAppRequestParam aMapAppRequestParam) {
            this.f7172a = aMapAppRequestParam;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                byte[] makeHttpRequestWithInterrupted = new AMap3DModelTileProvider.AMap3DModelRequest(this.f7172a.getUrl()).makeHttpRequestWithInterrupted();
                AMapAppResourceItem aMapAppResourceItem = new AMapAppResourceItem();
                aMapAppResourceItem.setData(makeHttpRequestWithInterrupted);
                aMapAppResourceItem.setSize(makeHttpRequestWithInterrupted.length);
                aMapAppResourceItem.setResourceType(this.f7172a.getResourceType());
                this.f7172a.getCallback().callSuccess(aMapAppResourceItem);
            } catch (Exception e4) {
                e4.printStackTrace();
                this.f7172a.getCallback().callFailed(e4.getMessage());
            }
        }
    }

    public b(IAMapDelegate iAMapDelegate, Context context) {
        this.f7155a = iAMapDelegate;
        this.f7156b = context;
        this.f7161g = new q1(iAMapDelegate);
    }

    private BitmapDescriptor a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.f7156b != null) {
            LinearLayout linearLayout = new LinearLayout(this.f7156b);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return BitmapDescriptorFactory.fromBitmap(a3.n(view));
    }

    private void b(String str, BaseOptions baseOptions) {
        try {
            this.f7159e.createOverlay(str, baseOptions);
        } catch (Throwable th) {
            u5.p(th, "GlOverlayLayer", "addOverlay");
            th.printStackTrace();
            Log.d("amapApi", "GlOverlayLayer addOverlay error:" + th.getMessage());
        }
    }

    private void c(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        b(str, baseOptions);
        synchronized (this.f7160f) {
            this.f7160f.put(str, baseOverlay);
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
                            if (a3.K(baseHoleOptions, latLng)) {
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
                    if (a3.K(baseHoleOptions, latLng)) {
                        return false;
                    }
                }
            }
            return a3.M(latLng, polygonOptions.getPoints());
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay addOverlayObject(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        c(str, baseOverlay, baseOptions);
        return baseOverlay;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void changeOverlayIndex() {
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean checkInBounds(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
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
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
            if (aMapNativeGlOverlayLayer != null && strArr != null) {
                aMapNativeGlOverlayLayer.clear(strArr);
            }
            synchronized (this.f7160f) {
                if (strArr != null) {
                    Iterator<Map.Entry<String, BaseOverlay>> it = this.f7160f.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, BaseOverlay> next = it.next();
                        int length = strArr.length;
                        boolean z3 = false;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                String str = strArr[i4];
                                if (str != null && str.equals(next.getKey())) {
                                    z3 = true;
                                    break;
                                }
                                i4++;
                            } else {
                                break;
                            }
                        }
                        if (!z3) {
                            it.remove();
                        }
                    }
                } else {
                    this.f7160f.clear();
                }
            }
        } catch (Throwable th) {
            u5.p(th, "GlOverlayLayer", "clear");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearOverlayByType(String str) {
        synchronized (this.f7160f) {
            ArrayList<String> arrayList = new ArrayList();
            Iterator<Map.Entry<String, BaseOverlay>> it = this.f7160f.entrySet().iterator();
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
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "clearTileCache", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final String createId(String str) {
        String str2;
        synchronized (this.f7158d) {
            this.f7157c++;
            str2 = str + this.f7157c;
        }
        return str2;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void destroy() {
        try {
            if (this.f7159e == null) {
                return;
            }
            synchronized (this.f7160f) {
                this.f7160f.clear();
            }
            this.f7159e.clear("");
            this.f7159e.destroy();
            this.f7159e = null;
        } catch (Throwable th) {
            u5.p(th, "GlOverlayLayer", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized boolean draw(int i4, int i5, boolean z3) {
        boolean z4 = false;
        try {
            q1 q1Var = this.f7161g;
            if (q1Var != null) {
                q1Var.a();
            }
        } finally {
            return z4;
        }
        if (this.f7155a.getMapConfig() == null) {
            return false;
        }
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.render(i4, i5, z3);
        }
        z4 = true;
        return z4;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void getAMapResource(AMapAppRequestParam aMapAppRequestParam) {
        y2.a().b(new a(aMapAppRequestParam));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getBuildInImageData(int i4) {
        try {
            switch (i4) {
                case 0:
                    BitmapDescriptor bitmapDescriptor = this.f7162h;
                    if (bitmapDescriptor == null || bitmapDescriptor.getBitmap().isRecycled()) {
                        this.f7162h = BitmapDescriptorFactory.fromBitmap(a3.l(this.f7156b, "amap_sdk_lineTexture.png"));
                    }
                    return this.f7162h;
                case 1:
                    BitmapDescriptor bitmapDescriptor2 = this.f7165k;
                    if (bitmapDescriptor2 == null || bitmapDescriptor2.getBitmap().isRecycled()) {
                        this.f7165k = BitmapDescriptorFactory.fromBitmap(a3.l(this.f7156b, "amap_sdk_lineTexture.png"));
                    }
                    return this.f7165k;
                case 2:
                    BitmapDescriptor bitmapDescriptor3 = this.f7164j;
                    if (bitmapDescriptor3 == null || bitmapDescriptor3.getBitmap().isRecycled()) {
                        this.f7164j = BitmapDescriptorFactory.fromBitmap(a3.l(this.f7156b, "amap_sdk_lineDashTexture_circle.png"));
                    }
                    return this.f7164j;
                case 3:
                    BitmapDescriptor bitmapDescriptor4 = this.f7163i;
                    if (bitmapDescriptor4 == null || bitmapDescriptor4.getBitmap().isRecycled()) {
                        this.f7163i = BitmapDescriptorFactory.fromBitmap(a3.l(this.f7156b, "amap_sdk_lineDashTexture_square.png"));
                    }
                    return this.f7163i;
                case 4:
                    BitmapDescriptor bitmapDescriptor5 = this.f7166l;
                    if (bitmapDescriptor5 == null || bitmapDescriptor5.getBitmap().isRecycled()) {
                        this.f7166l = BitmapDescriptorFactory.defaultMarker();
                    }
                    return this.f7166l;
                case 5:
                    BitmapDescriptor bitmapDescriptor6 = this.f7167m;
                    if (bitmapDescriptor6 == null || bitmapDescriptor6.getBitmap().isRecycled()) {
                        this.f7167m = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
                    }
                    return this.f7167m;
                case 6:
                    BitmapDescriptor bitmapDescriptor7 = this.f7168n;
                    if (bitmapDescriptor7 == null || bitmapDescriptor7.getBitmap().isRecycled()) {
                        this.f7168n = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
                    }
                    return this.f7168n;
                case 7:
                    BitmapDescriptor bitmapDescriptor8 = this.f7169o;
                    if (bitmapDescriptor8 == null || bitmapDescriptor8.getBitmap().isRecycled()) {
                        this.f7169o = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
                    }
                    return this.f7169o;
                default:
                    return this.f7162h;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final int getCurrentParticleNum(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getCurrentParticleNum(str);
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getCustomImageData(ImageOptions imageOptions) {
        float f4;
        float f5;
        if (imageOptions == null) {
            return null;
        }
        if (imageOptions.type == ImageOptions.ShapeType.CIRCLE.value()) {
            if (imageOptions.radius == 0.0d) {
                return null;
            }
            float a4 = u2.a(this.f7156b, (int) f5);
            int i4 = ((int) a4) * 2;
            Bitmap createBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(createBitmap);
            Path path = new Path();
            path.addCircle(a4, a4, a4, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.drawColor(imageOptions.color);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
            return BitmapDescriptorFactory.fromBitmap(createBitmap);
        } else if (imageOptions.type == ImageOptions.ShapeType.TEXT.value()) {
            String str = imageOptions.content;
            int i5 = imageOptions.fontSize;
            if (str.isEmpty()) {
                return null;
            }
            Paint paint2 = new Paint();
            paint2.setTextSize(u2.a(this.f7156b, i5));
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
            if (imageOptions.radius == 0.0d) {
                return null;
            }
            float a5 = u2.a(this.f7156b, (int) f4);
            int i6 = (int) a5;
            Bitmap createBitmap3 = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_8888);
            Paint paint3 = new Paint();
            paint3.setAntiAlias(true);
            Canvas canvas3 = new Canvas(createBitmap3);
            Path path2 = new Path();
            path2.addRect(0.0f, 0.0f, a5, a5, Path.Direction.CW);
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
    public final synchronized BaseOverlay getHitBaseOverlay(LatLng latLng, int i4) {
        BaseOverlay baseOverlay;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
        if (aMapNativeGlOverlayLayer != null) {
            String contain = aMapNativeGlOverlayLayer.contain(latLng, i4);
            if (TextUtils.isEmpty(contain)) {
                return null;
            }
            synchronized (this.f7160f) {
                baseOverlay = this.f7160f.get(contain);
            }
            return baseOverlay;
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized Polyline getHitOverlay(LatLng latLng, int i4) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
        if (aMapNativeGlOverlayLayer != null) {
            String contain = aMapNativeGlOverlayLayer.contain(latLng, i4);
            if (TextUtils.isEmpty(contain)) {
                return null;
            }
            synchronized (this.f7160f) {
                BaseOverlay baseOverlay = this.f7160f.get(contain);
                r1 = baseOverlay instanceof Polyline ? (Polyline) baseOverlay : null;
            }
        }
        return r1;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoContents(String str) {
        z infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f7155a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f7160f.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.p((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindow(String str) {
        z infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f7155a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f7160f.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.d((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindowClick(String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final long getInfoWindowUpdateOffsetTime(String str) {
        z infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f7155a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return 0L;
        }
        BaseOverlay baseOverlay = this.f7160f.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return infoWindowDelegate.u((BasePointOverlay) baseOverlay);
        }
        return 0L;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final IAMapDelegate getMap() {
        return this.f7155a;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final List<Marker> getMapScreenMarkers() {
        if (this.f7159e != null) {
            this.f7171q.clear();
            this.f7159e.getNativeProperties("", "getMapScreenOverlays", new Object[]{this.f7171q});
            if (this.f7171q.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f7171q) {
                    if (str != null && str.contains("MARKER")) {
                        arrayList.add((Marker) this.f7160f.get(str));
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
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
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
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
            if (aMapNativeGlOverlayLayer != null) {
                Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties("", "getMultiPointItem", new LatLng[]{latLng});
                if (nativeProperties instanceof MultiPointItemHitTest) {
                    MultiPointItemHitTest multiPointItemHitTest = (MultiPointItemHitTest) nativeProperties;
                    if (multiPointItemHitTest.index != -1) {
                        BaseOverlay baseOverlay = this.f7160f.get(multiPointItemHitTest.overlayName);
                        if (!(baseOverlay instanceof MultiPointOverlay) || (items = ((MultiPointOverlay) baseOverlay).getItems()) == null) {
                            return null;
                        }
                        int size = items.size();
                        int i4 = multiPointItemHitTest.index;
                        if (size > i4) {
                            return items.get(i4);
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
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getNativeProperties(str, str2, objArr);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng) {
        List<LatLng> points;
        if (latLng != null && polylineOptions != null && (points = polylineOptions.getPoints()) != null && points.size() != 0) {
            float f4 = 0.0f;
            int i4 = 0;
            for (int i5 = 0; i5 < points.size(); i5++) {
                try {
                    if (i5 == 0) {
                        f4 = AMapUtils.calculateLineDistance(latLng, points.get(i5));
                    } else {
                        float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, points.get(i5));
                        if (f4 > calculateLineDistance) {
                            i4 = i5;
                            f4 = calculateLineDistance;
                        }
                    }
                } catch (Throwable th) {
                    u5.p(th, "PolylineDelegate", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return points.get(i4);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getOverlayScreenPos(String str, FPoint fPoint) {
        if (this.f7160f.get(str) instanceof BasePointOverlay) {
            Object nativeProperties = this.f7159e.getNativeProperties(str, "getMarkerScreenPos", null);
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
        if (this.f7159e != null) {
            this.f7155a.hideInfoWindow();
            this.f7159e.getNativeProperties(str, "setInfoWindowShown", new Object[]{Boolean.FALSE});
        }
        setRunLowFrame(false);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean isGLTFAnimated() {
        boolean z3;
        synchronized (this.f7160f) {
            Iterator<Map.Entry<String, BaseOverlay>> it = this.f7160f.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                Map.Entry<String, BaseOverlay> next = it.next();
                BaseOverlay value = next.getValue();
                if (next.getKey().contains("GLTFOVERLAY") && ((GLTFOverlay) value).isAnimated()) {
                    z3 = true;
                    break;
                }
            }
        }
        return z3;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void onCreateAMapInstance() {
        if (this.f7159e == null) {
            this.f7159e = new AMapNativeGlOverlayLayer();
        }
        this.f7159e.setEngineId(this.f7155a.getNativeEngineID());
        this.f7159e.createNative(this.f7155a.getGLMapEngine().getNativeInstance());
        this.f7159e.setNativeFunCallListener(this);
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onRedrawInfowindow() {
        IAMapDelegate iAMapDelegate = this.f7155a;
        if (iAMapDelegate != null) {
            iAMapDelegate.redrawInfoWindow();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onSetRunLowFrame(boolean z3) {
        setRunLowFrame(z3);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str) {
        boolean z3;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.removeOverlay(str);
            z3 = true;
        } else {
            z3 = false;
        }
        synchronized (this.f7160f) {
            this.f7160f.remove(str);
        }
        return z3;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str, boolean z3) {
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void set2Top(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties(str, "set2Top", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setFlingState(boolean z3) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f7159e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "setFlingState", new Object[]{Boolean.valueOf(z3)});
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setRunLowFrame(boolean z3) {
        IAMapDelegate iAMapDelegate = this.f7155a;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(z3);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void showInfoWindow(String str) {
        Map<String, BaseOverlay> map;
        if (this.f7159e == null || (map = this.f7160f) == null) {
            return;
        }
        try {
            this.f7155a.showInfoWindow(map.get(str));
            setRunLowFrame(false);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void updateOption(String str, BaseOptions baseOptions) {
        try {
            if (this.f7159e == null) {
                return;
            }
            setRunLowFrame(false);
            this.f7159e.updateOptions(str, baseOptions);
        } catch (Throwable th) {
            u5.p(th, "GlOverlayLayer", "updateOption");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay getHitBaseOverlay(MotionEvent motionEvent, int i4) {
        if (this.f7155a != null) {
            DPoint obtain = DPoint.obtain();
            this.f7155a.getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
            LatLng latLng = new LatLng(obtain.f11672y, obtain.f11671x);
            obtain.recycle();
            return getHitBaseOverlay(latLng, i4);
        }
        return null;
    }
}
