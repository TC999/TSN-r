package com.bxkj.student.run.app.record;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.amap.api.fence.GeoFence;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.record.TraceDetailFragment;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.bxkj.student.run.app.utils.p;
import com.bxkj.student.run.app.utils.q;
import com.bxkj.student.run.app.vm.RunVM;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TraceDetailFragment extends BaseFragment {
    private Polyline A;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f22572h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f22573i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f22574j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f22575k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22576l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f22577m;

    /* renamed from: n  reason: collision with root package name */
    private TextureMapView f22578n;

    /* renamed from: o  reason: collision with root package name */
    private AMap f22579o;

    /* renamed from: p  reason: collision with root package name */
    private RecordPathView f22580p;

    /* renamed from: q  reason: collision with root package name */
    private RunVM f22581q;

    /* renamed from: r  reason: collision with root package name */
    private String f22582r;

    /* renamed from: s  reason: collision with root package name */
    private String f22583s;

    /* renamed from: t  reason: collision with root package name */
    private List<List<Map<String, Object>>> f22584t;

    /* renamed from: u  reason: collision with root package name */
    private Bundle f22585u;

    /* renamed from: x  reason: collision with root package name */
    private Polyline f22588x;

    /* renamed from: v  reason: collision with root package name */
    private List<LatLng> f22586v = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private PolylineOptions f22587w = new PolylineOptions();

    /* renamed from: y  reason: collision with root package name */
    private List<Integer> f22589y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private PolylineOptions f22590z = new PolylineOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements AMap.OnMapScreenShotListener {
        a() {
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap) {
            TraceDetailFragment traceDetailFragment = TraceDetailFragment.this;
            TraceDetailFragment.this.r0(traceDetailFragment.e0(bitmap, traceDetailFragment.d0(traceDetailFragment.f22573i)));
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements ShareBoardlistener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bitmap f22592a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements UMShareListener {
            a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseFragment) TraceDetailFragment.this).f1665e, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t3) {
                t3.printStackTrace();
                Toast.makeText(((BaseFragment) TraceDetailFragment.this).f1665e, " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseFragment) TraceDetailFragment.this).f1665e, " \u5206\u4eab\u6210\u529f\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        b(final Bitmap val$bitmap) {
            this.f22592a = val$bitmap;
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            new ShareAction(TraceDetailFragment.this.getActivity()).setPlatform(share_media).setCallback(new a()).withMedia(new UMImage(((BaseFragment) TraceDetailFragment.this).f1665e, this.f22592a)).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends TypeReference<List<List<Map<String, Object>>>> {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends TypeReference<List<Map<String, Object>>> {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends TypeReference<List<Map<String, Object>>> {
        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f implements AMap.OnCameraChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f22598a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f22599b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f22600c;

        f(final List val$finalList, final List val$finalOkPointList) {
            this.f22599b = val$finalList;
            this.f22600c = val$finalOkPointList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(List list, List list2) {
            TraceDetailFragment.this.f22580p.e();
            TraceDetailFragment.this.f22580p.setVisibility(8);
            TraceDetailFragment.this.b0(list, list2);
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChangeFinish(CameraPosition cameraPosition) {
            if (this.f22598a) {
                return;
            }
            this.f22598a = true;
            q qVar = new q();
            for (int i4 = 1; i4 < TraceDetailFragment.this.f22586v.size(); i4++) {
                Point screenLocation = TraceDetailFragment.this.f22579o.getProjection().toScreenLocation((LatLng) TraceDetailFragment.this.f22586v.get(i4 - 1));
                Point screenLocation2 = TraceDetailFragment.this.f22579o.getProjection().toScreenLocation((LatLng) TraceDetailFragment.this.f22586v.get(i4));
                int color = ContextCompat.getColor(((BaseFragment) TraceDetailFragment.this).f1665e, 2131034489);
                qVar.a(screenLocation, screenLocation2, color, color);
            }
            TraceDetailFragment.this.f22580p.setPath(qVar);
            RecordPathView recordPathView = TraceDetailFragment.this.f22580p;
            final List list = this.f22599b;
            final List list2 = this.f22600c;
            recordPathView.setOnAnimEnd(new RecordPathView.d() { // from class: com.bxkj.student.run.app.record.o
                @Override // com.bxkj.student.run.app.utils.RecordPathView.d
                public final void a() {
                    TraceDetailFragment.f.this.b(list, list2);
                }
            });
        }
    }

    private void a0(String punchCoordinate) {
        ArrayMap<String, Object> jsonToMap = JsonParse.jsonToMap(punchCoordinate);
        Map<String, Object> map = JsonParse.getMap(jsonToMap, "first");
        Map<String, Object> map2 = JsonParse.getMap(jsonToMap, "success");
        if (map.containsKey("latitude") && map.containsKey("longitude")) {
            this.f22579o.addMarker(new MarkerOptions().position(new LatLng(JsonParse.getDouble(map, "latitude"), JsonParse.getDouble(map, "longitude"))).icon(BitmapDescriptorFactory.fromResource(2131558818)).zIndex(9.0f).title("\u5f00\u59cb\u6253\u5361\u70b9").draggable(false));
        }
        if (map2.containsKey("latitude") && map2.containsKey("longitude")) {
            this.f22579o.addMarker(new MarkerOptions().position(new LatLng(JsonParse.getDouble(map2, "latitude"), JsonParse.getDouble(map2, "longitude"))).icon(BitmapDescriptorFactory.fromResource(2131558818)).zIndex(9.0f).title("\u7ed3\u675f\u6253\u5361\u70b9").draggable(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(List<Map<String, Object>> list, List<Map<String, Object>> okPointList) {
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            arrayList.add(new LatLngTimeSpeed(JsonParse.getDouble(map, "latitude"), JsonParse.getDouble(map, "longitude"), JsonParse.getLong(map, "time"), JsonParse.getFloat(map, "speed"), JsonParse.getBoolean(map, "puase"), JsonParse.getInt(map, "locationType")));
        }
        float i02 = i0(arrayList);
        com.orhanobut.logger.j.c("\u4f18\u5316\u540e\u8ddd\u79bbcountDistance=" + i02);
        for (Map<String, Object> map2 : okPointList) {
            this.f22579o.addMarker(new MarkerOptions().position(new LatLng(JsonParse.getDouble(map2, "latitude"), JsonParse.getDouble(map2, "longitude"))).icon(BitmapDescriptorFactory.fromResource(2131558766)).zIndex(9.0f).draggable(false));
        }
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(2131558609);
        MarkerOptions markerOptions = new MarkerOptions();
        List<LatLng> list2 = this.f22586v;
        this.f22579o.addMarker(markerOptions.position(list2.get(list2.size() - 1)).icon(fromResource).zIndex(9.0f).draggable(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e0(Bitmap src, Bitmap watermark) {
        if (src == null) {
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        int width2 = watermark.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(width, watermark.getHeight() + height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRGB(255, 255, 255);
        canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(watermark, width - width2, height, (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        paint.setTextSize(u.a(20.0f, this.f1665e));
        Rect rect = new Rect();
        String string = getString(2131820604);
        paint.getTextBounds(string, 0, string.length(), rect);
        canvas.drawText(string, 50.0f, 50.0f, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private void f0(GeoFence fence) {
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.fillColor(this.f1665e.getResources().getColor(2131034256));
        circleOptions.strokeColor(this.f1665e.getResources().getColor(2131034478));
        circleOptions.strokeWidth(4.0f);
        circleOptions.radius(fence.getRadius());
        DPoint center = fence.getCenter();
        circleOptions.center(new LatLng(center.getLatitude(), center.getLongitude()));
        this.f22579o.addCircle(circleOptions);
    }

    private void g0(List<LatLng> latLngs) {
        this.f22579o.addPolyline(new PolylineOptions().addAll(latLngs).width(u.a(5.0f, this.f1665e)).setDottedLine(true).color(ContextCompat.getColor(this.f1665e, 2131034173)).zIndex(u.a(5.0f, this.f1665e)));
    }

    private void h0(GeoFence fence) {
        int type = fence.getType();
        if (type == 0 || type == 2) {
            f0(fence);
        }
    }

    private float i0(List<LatLngTimeSpeed> latLngTimeSpeedList) {
        com.orhanobut.logger.j.c("\u62bd\u7a00\u524dpathOptimize=" + latLngTimeSpeedList.size() + "    convertFileSize=" + c0(JSON.toJSONString(latLngTimeSpeedList).length()));
        if (latLngTimeSpeedList.size() > 2) {
            com.bxkj.student.run.app.utils.o oVar = new com.bxkj.student.run.app.utils.o();
            oVar.p(1);
            latLngTimeSpeedList = oVar.k(latLngTimeSpeedList);
        }
        com.orhanobut.logger.j.c("\u62bd\u7a00\u540epathOptimize=" + latLngTimeSpeedList.size() + "    convertFileSize=" + c0(JSON.toJSONString(latLngTimeSpeedList).length()));
        float f4 = 0.0f;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z3 = false;
        LatLng latLng = null;
        for (LatLngTimeSpeed latLngTimeSpeed : latLngTimeSpeedList) {
            LatLng latLng2 = new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude());
            arrayList.add(latLng2);
            boolean isPuase = latLngTimeSpeed.isPuase();
            int r3 = com.bxkj.student.run.app.utils.i.r(this.f1665e, latLngTimeSpeed.getSpeed());
            arrayList2.add(Integer.valueOf(r3));
            if (isPuase != z3) {
                k0(arrayList, z3, arrayList2);
                arrayList2.clear();
                arrayList.clear();
                arrayList.add(latLng2);
                arrayList2.add(Integer.valueOf(r3));
            }
            if (latLng != null && !z3) {
                f4 += AMapUtils.calculateLineDistance(latLng, latLng2);
            }
            latLng = latLng2;
            z3 = isPuase;
        }
        k0(arrayList, z3, arrayList2);
        return f4;
    }

    private void j0(LatLng newLatLng, LatLng lastLatLng, float speed, boolean isPause) {
        if (isPause) {
            Polyline polyline = this.A;
            if (polyline == null) {
                this.f22587w = null;
                this.f22588x = null;
                this.f22589y = new ArrayList();
                PolylineOptions polylineOptions = new PolylineOptions();
                this.f22590z = polylineOptions;
                this.A = this.f22579o.addPolyline(polylineOptions.add(lastLatLng, newLatLng).width(u.a(5.0f, this.f1665e)).setDottedLine(true).color(ContextCompat.getColor(this.f1665e, 2131034173)).zIndex(u.a(5.0f, this.f1665e)));
                return;
            }
            polyline.setOptions(this.f22590z.add(newLatLng).width(u.a(5.0f, this.f1665e)).setDottedLine(true).color(ContextCompat.getColor(this.f1665e, 2131034173)).zIndex(u.a(5.0f, this.f1665e)));
            return;
        }
        this.f22589y.add(Integer.valueOf(com.bxkj.student.run.app.utils.i.r(this.f1665e, speed)));
        Polyline polyline2 = this.f22588x;
        if (polyline2 == null) {
            this.f22590z = null;
            this.A = null;
            PolylineOptions polylineOptions2 = new PolylineOptions();
            this.f22587w = polylineOptions2;
            this.f22588x = this.f22579o.addPolyline(polylineOptions2.add(lastLatLng, newLatLng).width(u.a(5.0f, this.f1665e)).colorValues(this.f22589y).useGradient(true).zIndex(u.a(5.0f, this.f1665e)));
            return;
        }
        polyline2.setOptions(this.f22587w.add(newLatLng).width(u.a(5.0f, this.f1665e)).colorValues(this.f22589y).useGradient(true).zIndex(u.a(5.0f, this.f1665e)));
    }

    private void k0(List<LatLng> latLngs, boolean isPause, List<Integer> colorValues) {
        if (isPause) {
            g0(latLngs);
        } else {
            m0(latLngs, colorValues);
        }
    }

    private void l0(List<List<DPoint>> pointList) {
        if (pointList == null || pointList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<DPoint> list : pointList) {
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                PolygonOptions polygonOptions = new PolygonOptions();
                for (DPoint dPoint : list) {
                    arrayList2.add(new LatLng(dPoint.getLatitude(), dPoint.getLongitude()));
                }
                polygonOptions.addAll(arrayList2);
                polygonOptions.fillColor(this.f1665e.getResources().getColor(2131034256));
                polygonOptions.strokeColor(this.f1665e.getResources().getColor(2131034478));
                polygonOptions.strokeWidth(4.0f);
                arrayList.add(this.f22579o.addPolygon(polygonOptions));
            }
        }
    }

    private void m0(List<LatLng> latLngs, List<Integer> colorValues) {
        this.f22579o.addPolyline(new PolylineOptions().addAll(latLngs).width(u.a(5.0f, this.f1665e)).colorValues(colorValues).useGradient(true).zIndex(u.a(5.0f, this.f1665e)));
    }

    private void n0(String geoFenceJson) {
        if (!TextUtils.isEmpty(geoFenceJson)) {
            this.f22584t = (List) JSON.parseObject(geoFenceJson, new c().getType(), new Feature[0]);
        }
        List<List<Map<String, Object>>> list = this.f22584t;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<Map<String, Object>> list2 : this.f22584t) {
            ArrayList arrayList2 = new ArrayList();
            for (Map<String, Object> map : list2) {
                arrayList2.add(new DPoint(JsonParse.getDouble(map, "lat"), JsonParse.getDouble(map, "lng")));
            }
            arrayList.add(arrayList2);
        }
        l0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 p0(List list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        RunDb runDb = (RunDb) list.get(0);
        long parseLong = Long.parseLong(runDb.getCountTime());
        double parseFloat = Float.parseFloat(runDb.getDistance());
        String a4 = com.bxkj.student.run.app.utils.i.a(parseFloat, parseLong);
        String b4 = com.bxkj.student.run.app.utils.i.b(parseFloat, parseLong);
        this.f22572h.setVisibility(0);
        this.f22574j.setText(a4);
        this.f22576l.setText(b4);
        this.f22575k.setText(com.bxkj.student.run.app.utils.i.g(parseLong));
        this.f22577m.setText(com.bxkj.student.run.app.utils.i.d(parseFloat));
        this.f22583s = runDb.getPassLatLngList();
        this.f22582r = runDb.getLatLngList();
        o0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Bitmap bitmap) {
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new b(bitmap)).open();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    public String c0(long size) {
        if (size >= 1073741824) {
            return String.format("%.1f GB", Float.valueOf(((float) size) / ((float) 1073741824)));
        }
        if (size >= 1048576) {
            float f4 = ((float) size) / ((float) 1048576);
            return String.format(f4 > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f4));
        } else if (size >= 1024) {
            float f5 = ((float) size) / ((float) 1024);
            return String.format(f5 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f5));
        } else {
            return String.format("%d B", Long.valueOf(size));
        }
    }

    public Bitmap d0(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        this.f22581q = (RunVM) new ViewModelProvider(this).get(RunVM.class);
        this.f22572h.setVisibility(8);
        if (getArguments().containsKey("latLngTimeSpeed")) {
            this.f22572h.setVisibility(0);
            this.f22574j.setText(getArguments().getString("speed"));
            this.f22576l.setText(getArguments().getString("peisu"));
            this.f22575k.setText(getArguments().getString("time"));
            this.f22577m.setText(getArguments().getString("distance"));
            this.f22583s = getArguments().getString("okPointList");
            this.f22582r = getArguments().getString("latLngTimeSpeed");
            n0(getArguments().getString("geoFence"));
            o0();
            String string = getArguments().getString("punchCoordinate");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            a0(string);
        } else if (getArguments().containsKey("runDataDbId")) {
            this.f22581q.v(getArguments().getString("runDataDbId"), new l1.l() { // from class: com.bxkj.student.run.app.record.n
                @Override // l1.l
                public final Object invoke(Object obj) {
                    f1 p02;
                    p02 = TraceDetailFragment.this.p0((List) obj);
                    return p02;
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f22572h = (LinearLayout) c(2131232217);
        this.f22573i = (LinearLayout) c(2131232167);
        this.f22574j = (TextView) c(2131233162);
        this.f22575k = (TextView) c(2131233198);
        this.f22576l = (TextView) c(2131233076);
        this.f22577m = (TextView) c(2131232941);
        this.f22580p = (RecordPathView) c(2131232539);
        TextureMapView textureMapView = (TextureMapView) c(2131232258);
        this.f22578n = textureMapView;
        this.f22579o = textureMapView.getMap();
        this.f22578n.onCreate(this.f22585u);
        this.f22578n.setForeground(new ColorDrawable(ContextCompat.getColor(this.f1665e, 2131034470)));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427643;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.util.List] */
    public void o0() {
        ArrayList<Map> arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f22582r)) {
            return;
        }
        try {
            arrayList = (List) JSON.parseObject(this.f22582r, new d().getType(), new Feature[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (!TextUtils.isEmpty(this.f22583s)) {
                arrayList2 = (List) JSON.parseObject(this.f22583s, new e().getType(), new Feature[0]);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (Map map : arrayList) {
            this.f22586v.add(new LatLng(JsonParse.getDouble(map, "latitude"), JsonParse.getDouble(map, "longitude")));
        }
        List<LatLng> list = this.f22586v;
        if (list != null && list.size() > 2) {
            com.orhanobut.logger.j.c("\u4f18\u5316\u524dlatLngs=" + this.f22586v.size());
            p pVar = new p();
            pVar.p(1);
            List<LatLng> k4 = pVar.k(this.f22586v);
            if (k4 != null && k4.size() > 0) {
                this.f22586v = k4;
            }
            com.orhanobut.logger.j.c("\u4f18\u5316\u540elatLngs=" + this.f22586v.size());
        }
        if (this.f22586v.size() == 1) {
            List<LatLng> list2 = this.f22586v;
            list2.add(list2.get(0));
        }
        Marker addMarker = this.f22579o.addMarker(new MarkerOptions().position(this.f22586v.get(0)).icon(BitmapDescriptorFactory.fromResource(2131558610)).zIndex(9.0f).draggable(true));
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(1000L);
        addMarker.setAnimation(scaleAnimation);
        addMarker.startAnimation();
        this.f22579o.setOnCameraChangeListener(new f(arrayList, arrayList2));
        LatLngBounds.Builder builder = LatLngBounds.builder();
        LatLngBounds build = builder.build();
        for (LatLng latLng : this.f22586v) {
            build = builder.include(latLng).build();
        }
        this.f22579o.animateCamera(CameraUpdateFactory.newLatLngBounds(build, u.a(50.0f, this.f1665e)), 2000L, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f22585u = savedInstanceState;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f22578n.onDestroy();
        super.onDestroy();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f22578n.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f22578n.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        this.f22578n.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q0() {
        this.f22579o.getMapScreenShot(new a());
    }
}
