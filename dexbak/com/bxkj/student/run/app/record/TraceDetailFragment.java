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
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.Tools;
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
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.p093vm.RunVM;
import com.bxkj.student.run.app.record.TraceDetailFragment;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.bxkj.student.run.app.utils.PathSmoothTool;
import com.bxkj.student.run.app.utils.PathSmoothToolOrigin;
import com.bxkj.student.run.app.utils.RecordPathAnimUtil;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UContent;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15280l;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TraceDetailFragment extends BaseFragment {

    /* renamed from: A */
    private Polyline f19340A;

    /* renamed from: h */
    private LinearLayout f19341h;

    /* renamed from: i */
    private LinearLayout f19342i;

    /* renamed from: j */
    private TextView f19343j;

    /* renamed from: k */
    private TextView f19344k;

    /* renamed from: l */
    private TextView f19345l;

    /* renamed from: m */
    private TextView f19346m;

    /* renamed from: n */
    private TextureMapView f19347n;

    /* renamed from: o */
    private AMap f19348o;

    /* renamed from: p */
    private RecordPathView f19349p;

    /* renamed from: q */
    private RunVM f19350q;

    /* renamed from: r */
    private String f19351r;

    /* renamed from: s */
    private String f19352s;

    /* renamed from: t */
    private List<List<Map<String, Object>>> f19353t;

    /* renamed from: u */
    private Bundle f19354u;

    /* renamed from: x */
    private Polyline f19357x;

    /* renamed from: v */
    private List<LatLng> f19355v = new ArrayList();

    /* renamed from: w */
    private PolylineOptions f19356w = new PolylineOptions();

    /* renamed from: y */
    private List<Integer> f19358y = new ArrayList();

    /* renamed from: z */
    private PolylineOptions f19359z = new PolylineOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.TraceDetailFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5329a implements AMap.OnMapScreenShotListener {
        C5329a() {
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap) {
            TraceDetailFragment traceDetailFragment = TraceDetailFragment.this;
            TraceDetailFragment.this.m39774r0(traceDetailFragment.m39787e0(bitmap, traceDetailFragment.m39788d0(traceDetailFragment.f19342i)));
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.TraceDetailFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5330b implements ShareBoardlistener {

        /* renamed from: a */
        final /* synthetic */ Bitmap f19361a;

        /* renamed from: com.bxkj.student.run.app.record.TraceDetailFragment$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5331a implements UMShareListener {
            C5331a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseFragment) TraceDetailFragment.this).f1678e, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t) {
                t.printStackTrace();
                Toast.makeText(((BaseFragment) TraceDetailFragment.this).f1678e, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseFragment) TraceDetailFragment.this).f1678e, " 分享成功啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        C5330b(final Bitmap val$bitmap) {
            this.f19361a = val$bitmap;
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            new ShareAction(TraceDetailFragment.this.getActivity()).setPlatform(share_media).setCallback(new C5331a()).withMedia(new UMImage(((BaseFragment) TraceDetailFragment.this).f1678e, this.f19361a)).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.TraceDetailFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5332c extends TypeReference<List<List<Map<String, Object>>>> {
        C5332c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.TraceDetailFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5333d extends TypeReference<List<Map<String, Object>>> {
        C5333d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.TraceDetailFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5334e extends TypeReference<List<Map<String, Object>>> {
        C5334e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.TraceDetailFragment$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5335f implements AMap.OnCameraChangeListener {

        /* renamed from: a */
        private boolean f19367a = false;

        /* renamed from: b */
        final /* synthetic */ List f19368b;

        /* renamed from: c */
        final /* synthetic */ List f19369c;

        C5335f(final List val$finalList, final List val$finalOkPointList) {
            this.f19368b = val$finalList;
            this.f19369c = val$finalOkPointList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m39772b(List list, List list2) {
            TraceDetailFragment.this.f19349p.m39702e();
            TraceDetailFragment.this.f19349p.setVisibility(8);
            TraceDetailFragment.this.m39790b0(list, list2);
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChangeFinish(CameraPosition cameraPosition) {
            if (this.f19367a) {
                return;
            }
            this.f19367a = true;
            RecordPathAnimUtil recordPathAnimUtil = new RecordPathAnimUtil();
            for (int i = 1; i < TraceDetailFragment.this.f19355v.size(); i++) {
                Point screenLocation = TraceDetailFragment.this.f19348o.getProjection().toScreenLocation((LatLng) TraceDetailFragment.this.f19355v.get(i - 1));
                Point screenLocation2 = TraceDetailFragment.this.f19348o.getProjection().toScreenLocation((LatLng) TraceDetailFragment.this.f19355v.get(i));
                int color = ContextCompat.getColor(((BaseFragment) TraceDetailFragment.this).f1678e, 2131034489);
                recordPathAnimUtil.m39554a(screenLocation, screenLocation2, color, color);
            }
            TraceDetailFragment.this.f19349p.setPath(recordPathAnimUtil);
            RecordPathView recordPathView = TraceDetailFragment.this.f19349p;
            final List list = this.f19368b;
            final List list2 = this.f19369c;
            recordPathView.setOnAnimEnd(new RecordPathView.InterfaceC5375d() { // from class: com.bxkj.student.run.app.record.o
                @Override // com.bxkj.student.run.app.utils.RecordPathView.InterfaceC5375d
                /* renamed from: a */
                public final void mo38387a() {
                    TraceDetailFragment.C5335f.this.m39772b(list, list2);
                }
            });
        }
    }

    /* renamed from: a0 */
    private void m39791a0(String punchCoordinate) {
        ArrayMap<String, Object> jsonToMap = JsonParse.jsonToMap(punchCoordinate);
        Map<String, Object> map = JsonParse.getMap(jsonToMap, "first");
        Map<String, Object> map2 = JsonParse.getMap(jsonToMap, "success");
        if (map.containsKey("latitude") && map.containsKey("longitude")) {
            this.f19348o.addMarker(new MarkerOptions().position(new LatLng(JsonParse.getDouble(map, "latitude"), JsonParse.getDouble(map, "longitude"))).icon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.location_dkj)).zIndex(9.0f).title("开始打卡点").draggable(false));
        }
        if (map2.containsKey("latitude") && map2.containsKey("longitude")) {
            this.f19348o.addMarker(new MarkerOptions().position(new LatLng(JsonParse.getDouble(map2, "latitude"), JsonParse.getDouble(map2, "longitude"))).icon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.location_dkj)).zIndex(9.0f).title("结束打卡点").draggable(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public void m39790b0(List<Map<String, Object>> list, List<Map<String, Object>> okPointList) {
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            arrayList.add(new LatLngTimeSpeed(JsonParse.getDouble(map, "latitude"), JsonParse.getDouble(map, "longitude"), JsonParse.getLong(map, RtspHeaders.Values.TIME), JsonParse.getFloat(map, "speed"), JsonParse.getBoolean(map, "puase"), JsonParse.getInt(map, MyLocationStyle.LOCATION_TYPE)));
        }
        float m39783i0 = m39783i0(arrayList);
        C11792j.m20470c("优化后距离countDistance=" + m39783i0);
        for (Map<String, Object> map2 : okPointList) {
            this.f19348o.addMarker(new MarkerOptions().position(new LatLng(JsonParse.getDouble(map2, "latitude"), JsonParse.getDouble(map2, "longitude"))).icon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.img_point_must_normal)).zIndex(9.0f).draggable(false));
        }
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(C4215R.mipmap.ic_marker_end);
        MarkerOptions markerOptions = new MarkerOptions();
        List<LatLng> list2 = this.f19355v;
        this.f19348o.addMarker(markerOptions.position(list2.get(list2.size() - 1)).icon(fromResource).zIndex(9.0f).draggable(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public Bitmap m39787e0(Bitmap src, Bitmap watermark) {
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
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setTextSize(Tools.m57620a(20.0f, this.f1678e));
        Rect rect = new Rect();
        String string = getString(2131820604);
        paint.getTextBounds(string, 0, string.length(), rect);
        canvas.drawText(string, 50.0f, 50.0f, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    /* renamed from: f0 */
    private void m39786f0(GeoFence fence) {
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.fillColor(this.f1678e.getResources().getColor(C4215R.C4217color.fill));
        circleOptions.strokeColor(this.f1678e.getResources().getColor(C4215R.C4217color.stroke));
        circleOptions.strokeWidth(4.0f);
        circleOptions.radius(fence.getRadius());
        DPoint center = fence.getCenter();
        circleOptions.center(new LatLng(center.getLatitude(), center.getLongitude()));
        this.f19348o.addCircle(circleOptions);
    }

    /* renamed from: g0 */
    private void m39785g0(List<LatLng> latLngs) {
        this.f19348o.addPolyline(new PolylineOptions().addAll(latLngs).width(Tools.m57620a(5.0f, this.f1678e)).setDottedLine(true).color(ContextCompat.getColor(this.f1678e, 2131034173)).zIndex(Tools.m57620a(5.0f, this.f1678e)));
    }

    /* renamed from: h0 */
    private void m39784h0(GeoFence fence) {
        int type = fence.getType();
        if (type == 0 || type == 2) {
            m39786f0(fence);
        }
    }

    /* renamed from: i0 */
    private float m39783i0(List<LatLngTimeSpeed> latLngTimeSpeedList) {
        C11792j.m20470c("抽稀前pathOptimize=" + latLngTimeSpeedList.size() + "    convertFileSize=" + m39789c0(JSON.toJSONString(latLngTimeSpeedList).length()));
        if (latLngTimeSpeedList.size() > 2) {
            PathSmoothTool pathSmoothTool = new PathSmoothTool();
            pathSmoothTool.m39575p(1);
            latLngTimeSpeedList = pathSmoothTool.m39580k(latLngTimeSpeedList);
        }
        C11792j.m20470c("抽稀后pathOptimize=" + latLngTimeSpeedList.size() + "    convertFileSize=" + m39789c0(JSON.toJSONString(latLngTimeSpeedList).length()));
        float f = 0.0f;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        LatLng latLng = null;
        for (LatLngTimeSpeed latLngTimeSpeed : latLngTimeSpeedList) {
            LatLng latLng2 = new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude());
            arrayList.add(latLng2);
            boolean isPuase = latLngTimeSpeed.isPuase();
            int m39619r = FormatUtils.m39619r(this.f1678e, latLngTimeSpeed.getSpeed());
            arrayList2.add(Integer.valueOf(m39619r));
            if (isPuase != z) {
                m39781k0(arrayList, z, arrayList2);
                arrayList2.clear();
                arrayList.clear();
                arrayList.add(latLng2);
                arrayList2.add(Integer.valueOf(m39619r));
            }
            if (latLng != null && !z) {
                f += AMapUtils.calculateLineDistance(latLng, latLng2);
            }
            latLng = latLng2;
            z = isPuase;
        }
        m39781k0(arrayList, z, arrayList2);
        return f;
    }

    /* renamed from: j0 */
    private void m39782j0(LatLng newLatLng, LatLng lastLatLng, float speed, boolean isPause) {
        if (isPause) {
            Polyline polyline = this.f19340A;
            if (polyline == null) {
                this.f19356w = null;
                this.f19357x = null;
                this.f19358y = new ArrayList();
                PolylineOptions polylineOptions = new PolylineOptions();
                this.f19359z = polylineOptions;
                this.f19340A = this.f19348o.addPolyline(polylineOptions.add(lastLatLng, newLatLng).width(Tools.m57620a(5.0f, this.f1678e)).setDottedLine(true).color(ContextCompat.getColor(this.f1678e, 2131034173)).zIndex(Tools.m57620a(5.0f, this.f1678e)));
                return;
            }
            polyline.setOptions(this.f19359z.add(newLatLng).width(Tools.m57620a(5.0f, this.f1678e)).setDottedLine(true).color(ContextCompat.getColor(this.f1678e, 2131034173)).zIndex(Tools.m57620a(5.0f, this.f1678e)));
            return;
        }
        this.f19358y.add(Integer.valueOf(FormatUtils.m39619r(this.f1678e, speed)));
        Polyline polyline2 = this.f19357x;
        if (polyline2 == null) {
            this.f19359z = null;
            this.f19340A = null;
            PolylineOptions polylineOptions2 = new PolylineOptions();
            this.f19356w = polylineOptions2;
            this.f19357x = this.f19348o.addPolyline(polylineOptions2.add(lastLatLng, newLatLng).width(Tools.m57620a(5.0f, this.f1678e)).colorValues(this.f19358y).useGradient(true).zIndex(Tools.m57620a(5.0f, this.f1678e)));
            return;
        }
        polyline2.setOptions(this.f19356w.add(newLatLng).width(Tools.m57620a(5.0f, this.f1678e)).colorValues(this.f19358y).useGradient(true).zIndex(Tools.m57620a(5.0f, this.f1678e)));
    }

    /* renamed from: k0 */
    private void m39781k0(List<LatLng> latLngs, boolean isPause, List<Integer> colorValues) {
        if (isPause) {
            m39785g0(latLngs);
        } else {
            m39779m0(latLngs, colorValues);
        }
    }

    /* renamed from: l0 */
    private void m39780l0(List<List<DPoint>> pointList) {
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
                polygonOptions.fillColor(this.f1678e.getResources().getColor(C4215R.C4217color.fill));
                polygonOptions.strokeColor(this.f1678e.getResources().getColor(C4215R.C4217color.stroke));
                polygonOptions.strokeWidth(4.0f);
                arrayList.add(this.f19348o.addPolygon(polygonOptions));
            }
        }
    }

    /* renamed from: m0 */
    private void m39779m0(List<LatLng> latLngs, List<Integer> colorValues) {
        this.f19348o.addPolyline(new PolylineOptions().addAll(latLngs).width(Tools.m57620a(5.0f, this.f1678e)).colorValues(colorValues).useGradient(true).zIndex(Tools.m57620a(5.0f, this.f1678e)));
    }

    /* renamed from: n0 */
    private void m39778n0(String geoFenceJson) {
        if (!TextUtils.isEmpty(geoFenceJson)) {
            this.f19353t = (List) JSON.parseObject(geoFenceJson, new C5332c().getType(), new Feature[0]);
        }
        List<List<Map<String, Object>>> list = this.f19353t;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<Map<String, Object>> list2 : this.f19353t) {
            ArrayList arrayList2 = new ArrayList();
            for (Map<String, Object> map : list2) {
                arrayList2.add(new DPoint(JsonParse.getDouble(map, UContent.f38072C), JsonParse.getDouble(map, UContent.f38073D)));
            }
            arrayList.add(arrayList2);
        }
        m39780l0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ Unit m39776p0(List list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        RunDb runDb = (RunDb) list.get(0);
        long parseLong = Long.parseLong(runDb.getCountTime());
        double parseFloat = Float.parseFloat(runDb.getDistance());
        String m39636a = FormatUtils.m39636a(parseFloat, parseLong);
        String m39635b = FormatUtils.m39635b(parseFloat, parseLong);
        this.f19341h.setVisibility(0);
        this.f19343j.setText(m39636a);
        this.f19345l.setText(m39635b);
        this.f19344k.setText(FormatUtils.m39630g(parseLong));
        this.f19346m.setText(FormatUtils.m39633d(parseFloat));
        this.f19352s = runDb.getPassLatLngList();
        this.f19351r = runDb.getLatLngList();
        m39777o0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public void m39774r0(Bitmap bitmap) {
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new C5330b(bitmap)).open();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    /* renamed from: c0 */
    public String m39789c0(long size) {
        if (size >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return String.format("%.1f GB", Float.valueOf(((float) size) / ((float) IjkMediaMeta.AV_CH_STEREO_RIGHT)));
        }
        if (size >= 1048576) {
            float f = ((float) size) / ((float) 1048576);
            return String.format(f > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f));
        } else if (size >= 1024) {
            float f2 = ((float) size) / ((float) 1024);
            return String.format(f2 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f2));
        } else {
            return String.format("%d B", Long.valueOf(size));
        }
    }

    /* renamed from: d0 */
    public Bitmap m39788d0(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    public void mo39444e() {
        this.f19350q = (RunVM) new ViewModelProvider(this).get(RunVM.class);
        this.f19341h.setVisibility(8);
        if (getArguments().containsKey("latLngTimeSpeed")) {
            this.f19341h.setVisibility(0);
            this.f19343j.setText(getArguments().getString("speed"));
            this.f19345l.setText(getArguments().getString("peisu"));
            this.f19344k.setText(getArguments().getString(RtspHeaders.Values.TIME));
            this.f19346m.setText(getArguments().getString("distance"));
            this.f19352s = getArguments().getString("okPointList");
            this.f19351r = getArguments().getString("latLngTimeSpeed");
            m39778n0(getArguments().getString("geoFence"));
            m39777o0();
            String string = getArguments().getString("punchCoordinate");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            m39791a0(string);
        } else if (getArguments().containsKey("runDataDbId")) {
            this.f19350q.m39503v(getArguments().getString("runDataDbId"), new InterfaceC15280l() { // from class: com.bxkj.student.run.app.record.n
                @Override // p617l1.InterfaceC15280l
                public final Object invoke(Object obj) {
                    Unit m39776p0;
                    m39776p0 = TraceDetailFragment.this.m39776p0((List) obj);
                    return m39776p0;
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f19341h = (LinearLayout) m57916c(2131232217);
        this.f19342i = (LinearLayout) m57916c(2131232167);
        this.f19343j = (TextView) m57916c(C4215R.C4219id.tv_speed);
        this.f19344k = (TextView) m57916c(2131233198);
        this.f19345l = (TextView) m57916c(C4215R.C4219id.tv_peisu);
        this.f19346m = (TextView) m57916c(2131232941);
        this.f19349p = (RecordPathView) m57916c(C4215R.C4219id.rpv);
        TextureMapView textureMapView = (TextureMapView) m57916c(C4215R.C4219id.map);
        this.f19347n = textureMapView;
        this.f19348o = textureMapView.getMap();
        this.f19347n.onCreate(this.f19354u);
        this.f19347n.setForeground(new ColorDrawable(ContextCompat.getColor(this.f1678e, 2131034470)));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_run_trace;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.util.List] */
    /* renamed from: o0 */
    public void m39777o0() {
        ArrayList<Map> arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f19351r)) {
            return;
        }
        try {
            arrayList = (List) JSON.parseObject(this.f19351r, new C5333d().getType(), new Feature[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (!TextUtils.isEmpty(this.f19352s)) {
                arrayList2 = (List) JSON.parseObject(this.f19352s, new C5334e().getType(), new Feature[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (Map map : arrayList) {
            this.f19355v.add(new LatLng(JsonParse.getDouble(map, "latitude"), JsonParse.getDouble(map, "longitude")));
        }
        List<LatLng> list = this.f19355v;
        if (list != null && list.size() > 2) {
            C11792j.m20470c("优化前latLngs=" + this.f19355v.size());
            PathSmoothToolOrigin pathSmoothToolOrigin = new PathSmoothToolOrigin();
            pathSmoothToolOrigin.m39557p(1);
            List<LatLng> m39562k = pathSmoothToolOrigin.m39562k(this.f19355v);
            if (m39562k != null && m39562k.size() > 0) {
                this.f19355v = m39562k;
            }
            C11792j.m20470c("优化后latLngs=" + this.f19355v.size());
        }
        if (this.f19355v.size() == 1) {
            List<LatLng> list2 = this.f19355v;
            list2.add(list2.get(0));
        }
        Marker addMarker = this.f19348o.addMarker(new MarkerOptions().position(this.f19355v.get(0)).icon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.ic_marker_start)).zIndex(9.0f).draggable(true));
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(1000L);
        addMarker.setAnimation(scaleAnimation);
        addMarker.startAnimation();
        this.f19348o.setOnCameraChangeListener(new C5335f(arrayList, arrayList2));
        LatLngBounds.Builder builder = LatLngBounds.builder();
        LatLngBounds build = builder.build();
        for (LatLng latLng : this.f19355v) {
            build = builder.include(latLng).build();
        }
        this.f19348o.animateCamera(CameraUpdateFactory.newLatLngBounds(build, Tools.m57620a(50.0f, this.f1678e)), 2000L, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f19354u = savedInstanceState;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f19347n.onDestroy();
        super.onDestroy();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f19347n.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f19347n.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        this.f19347n.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q0 */
    public void m39775q0() {
        this.f19348o.getMapScreenShot(new C5329a());
    }
}
