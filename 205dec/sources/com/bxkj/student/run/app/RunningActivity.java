package com.bxkj.student.run.app;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.dialog.DialogOnKeyListener;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceClient;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.common.view.LongPressToFinishButton;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.location.service.LocationService;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.ready.RunRoleSetBean;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.set.RunSettingActivity;
import com.bxkj.student.run.app.step.service.StepService;
import com.bxkj.student.run.app.vm.RunVM;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.f1;
import m.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunningActivity extends BaseActivity {
    public static final String L0 = "com.location.apis.geofencedemo.broadcast";
    public static final String M0 = "com.location.apis.geofenceBounds.broadcast";
    private Intent A;
    private int A0;
    private int B0;
    private RunRoleSetBean.DataBean C;
    private List<Double> D;
    private LatLng F;
    private ProgressDialog H0;
    private iOSOneButtonDialog I;
    private RunDb J;
    private com.bxkj.student.run.app.utils.g K;

    /* renamed from: L  reason: collision with root package name */
    private e f22227L;
    private LatLngBounds.Builder M;
    private GeoFenceClient O;
    private GeoFenceClient P;
    private Intent Q;
    private RunVM R;
    private iOSOneButtonDialog S;
    private long V;

    /* renamed from: k  reason: collision with root package name */
    private MapView f22228k;

    /* renamed from: l  reason: collision with root package name */
    private AMap f22229l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView f22230m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f22231n;

    /* renamed from: o  reason: collision with root package name */
    private MarqueeTextView f22232o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f22233p;

    /* renamed from: p0  reason: collision with root package name */
    private LatLng f22234p0;

    /* renamed from: q  reason: collision with root package name */
    private TextView f22235q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f22236r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f22237s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f22238t;

    /* renamed from: u  reason: collision with root package name */
    private LinearLayout f22239u;

    /* renamed from: v  reason: collision with root package name */
    private LongPressToFinishButton f22240v;

    /* renamed from: w  reason: collision with root package name */
    private Button f22241w;

    /* renamed from: x  reason: collision with root package name */
    private LatLngBounds.Builder f22242x;

    /* renamed from: y  reason: collision with root package name */
    private List<Map<String, Object>> f22243y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private List<Map<String, Object>> f22244z = new ArrayList();
    private int B = 0;
    private int E = 0;
    private boolean G = true;
    private boolean H = false;
    private List<Marker> N = new ArrayList();
    private long T = 0;
    private long U = System.currentTimeMillis();
    private long W = 0;
    private float X = 0.0f;
    private List<LatLngTimeSpeed> Y = new ArrayList();
    private boolean Z = false;
    private List<Integer> C0 = new ArrayList();
    private BroadcastReceiver D0 = new b();
    private Map<String, Boolean> E0 = new ArrayMap();
    private BroadcastReceiver F0 = new c();
    private Boolean G0 = Boolean.FALSE;
    private boolean I0 = false;
    private boolean J0 = false;
    private boolean K0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends TypeReference<ArrayMap<String, Object>> {
        a() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.location.apis.geofencedemo.broadcast")) {
                com.orhanobut.logger.j.c("\u8fdb\u5165\u7535\u5b50\u56f4\u680f");
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                extras.getInt("event");
                String string = extras.getString("customId");
                extras.getString("fenceid");
                GeoFence geoFence = (GeoFence) extras.getParcelable("fence");
                if (geoFence == null) {
                    return;
                }
                com.bxkj.student.run.app.utils.y.g(((BaseActivity) RunningActivity.this).f1656h, 2131755097);
                BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(2131558767);
                double latitude = geoFence.getCenter().getLatitude();
                double longitude = geoFence.getCenter().getLongitude();
                String str = string.split(",")[0];
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                HashMap hashMap = new HashMap();
                hashMap.put("id", str);
                hashMap.put("time", simpleDateFormat.format(new Date()));
                hashMap.put("latitude", Double.valueOf(latitude));
                hashMap.put("longitude", Double.valueOf(longitude));
                if (!RunningActivity.this.o2(hashMap)) {
                    RunningActivity.this.f22244z.add(hashMap);
                }
                MarkerOptions zIndex = new MarkerOptions().position(new LatLng(latitude, longitude)).icon(fromResource).zIndex(9.0f);
                MarkerOptions draggable = zIndex.title("\u4f60\u5df2\u7ecf\u901a\u8fc7\u5fc5\u7ecf\u70b9").draggable(false);
                for (Marker marker : RunningActivity.this.N) {
                    if (marker.getObject().toString().equals(string) && !marker.isRemoved()) {
                        draggable.title(draggable.getTitle() + marker.getTitle().substring(marker.getTitle().indexOf("\uff1a")));
                        marker.remove();
                    }
                }
                RunningActivity.this.f22229l.addMarker(draggable);
                RunningActivity.this.O.removeGeoFence(geoFence);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            if (!intent.getAction().equals("com.location.apis.geofenceBounds.broadcast") || (extras = intent.getExtras()) == null) {
                return;
            }
            int i4 = extras.getInt("event");
            boolean z3 = false;
            RunningActivity.this.E0.put(extras.getString("customId"), Boolean.valueOf(i4 == 1));
            com.orhanobut.logger.j.c("ActionStatus=" + i4);
            for (String str : RunningActivity.this.E0.keySet()) {
                if (((Boolean) RunningActivity.this.E0.get(str)).booleanValue()) {
                    z3 = true;
                }
            }
            RunningActivity.this.c3(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoadingDialog f22248a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f22249b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f22250c;

        d(final LoadingDialog val$loadingDialog, final int val$uploadType, final String val$stepNumbers) {
            this.f22248a = val$loadingDialog;
            this.f22249b = val$uploadType;
            this.f22250c = val$stepNumbers;
        }

        private void a() {
            RunningActivity.this.r2();
            RunningActivity.this.R.u(RunningActivity.this.J.getIdentify());
            Toast toast = new Toast(((BaseActivity) RunningActivity.this).f1656h);
            toast.setView(View.inflate(((BaseActivity) RunningActivity.this).f1656h, 2131428065, null));
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.show();
            RunningActivity.this.e3(this.f22250c);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            RunningActivity.this.S2(this.f22249b, this.f22250c);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            LoadingDialog loadingDialog = this.f22248a;
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 202) {
                a();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) RunningActivity.this).f1656h).setMessage(msg).show();
            RunningActivity.this.Y2(false);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnStart() {
            super.netOnStart();
            this.f22248a.showDefaultStyle("\u6b63\u5728\u4e0a\u4f20\u8dd1\u6b65\u6570\u636e\uff0c1\u5206\u949f\u5185\u5982\u679c\u4e0a\u4f20\u4e0d\u6210\u529f\uff0c\u4f1a\u5728\u672c\u5730\u4fdd\u5b58\u6570\u636e\uff0c\u8bf7\u9009\u62e9\u5176\u4ed6\u65f6\u95f4\u6bb5\uff0c\u9009\u62e9\u672c\u5730\u8bb0\u5f55\u8fdb\u884c\u4e0a\u4f20\u3002\u4e0a\u4f20\u6570\u636e\u8fd91\u5206\u949f\u5185\uff0c\u8bf7\u4e0d\u8981\u9000\u51fa\u6216\u5378\u8f7dAPP\uff0c\u5426\u5219\u6570\u636e\u5c06\u4e22\u5931\u3002");
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            a();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccessServerError(int code, String errorMessage) {
            super.netOnSuccessServerError(code, errorMessage);
            RunningActivity.this.S2(this.f22249b, this.f22250c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2() {
        s2(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B2() {
        Y2(true);
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        iostwobuttondialog.setTitle("\u63d0\u793a").setMessage("\u786e\u5b9a\u8981\u7ed3\u675f\u8dd1\u6b65\u5417\uff1f").setLeftButtonText("\u7ee7\u7eed").setRightButtonText("\u7ed3\u675f").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.r
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                RunningActivity.this.z2();
            }
        }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.c
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                RunningActivity.this.A2();
            }
        }).show();
        iostwobuttondialog.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D2(View view) {
        iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1656h);
        iosonebuttondialog.setTitle("\u8bf7\u5237\u7801");
        iosonebuttondialog.setCenterCustomView(2131427599);
        iosonebuttondialog.setOneButtonText("\u5173\u95ed");
        iosonebuttondialog.setMessageGrivity(17);
        ((ImageView) iosonebuttondialog.findViewById(2131231474)).setImageBitmap(com.bxkj.base.util.u.f(LoginUser.getLoginUser().getAccount(), cn.bluemobi.dylan.base.utils.u.a(260.0f, this.f1656h), BitmapFactory.decodeResource(getResources(), 2131558617)));
        iosonebuttondialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 E2(List list) {
        if (list != null && list.size() > 0) {
            int i4 = 0;
            RunDb runDb = (RunDb) list.get(0);
            this.J = runDb;
            this.C = (RunRoleSetBean.DataBean) JSON.parseObject(runDb.getSportsSet(), RunRoleSetBean.DataBean.class);
            if (Long.parseLong(this.J.getCountTime()) != 0) {
                try {
                    this.C0 = JSON.parseArray(this.J.getStepList(), Integer.class);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (this.C0 == null) {
                this.C0 = new ArrayList();
            }
            for (Integer num : this.C0) {
                i4 += num.intValue();
            }
            this.f22244z = JsonParse.jsonToListMap(this.J.getUserPassPointList());
            this.f22238t.setText(String.valueOf(i4));
            this.A0 = i4;
            this.B0 = i4;
            if (!TextUtils.isEmpty(this.J.getFaceDetectCount())) {
                this.E = Integer.parseInt(this.J.getFaceDetectCount());
            }
            u2();
            return null;
        }
        v2();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2() {
        startActivity(new Intent(this.f1656h, RunSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G2() {
        Y2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H2() {
        s2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I2() {
        Y2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2() {
        s2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f1 K2() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L2(String str, View view) {
        e3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M2(MotionEvent motionEvent) {
        this.T = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean N2(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
        if (i4 == 4 && keyEvent.getAction() == 1) {
            C2();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O2(int i4, int i5, Intent intent) {
        if (i5 == -1) {
            this.H = true;
            s2(i4);
        } else if (i5 == 170) {
            d3(i4);
        } else {
            Y2(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 P2(final int i4) {
        new m.b(this.f1657i).startActivityForResult(new Intent(this.f1656h, FaceDetectExpActivity.class).putExtra("identify", this.C.getIdentify())).c(new b.a() { // from class: com.bxkj.student.run.app.k
            @Override // m.b.a
            public final void a(int i5, Intent intent) {
                RunningActivity.this.O2(i4, i5, intent);
            }
        });
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    private void Q2() {
        this.f22227L = new e(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("GET_FIRST_LOCATION_SUCCESS");
        intentFilter.addAction("ADD_START_POINT");
        intentFilter.addAction("ADD_OLD_LINE");
        intentFilter.addAction("ADD_LINE");
        intentFilter.addAction("SAVE_LOCAL_DB");
        intentFilter.addAction("TIME_CHANGE");
        intentFilter.addAction("UPDATE_GPS_STATUS");
        intentFilter.addAction("UPDATE_STEP");
        intentFilter.addAction("CURRENT_LATLNG");
        registerReceiver(this.f22227L, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2() {
        this.J.setDistance(String.valueOf(this.X));
        this.J.setCountTime(String.valueOf(this.W));
        this.J.setStartTime(String.valueOf(this.U));
        this.J.setLatLngList(JSON.toJSONString(this.Y));
        this.J.setPassLatLngList(JSON.toJSONString(this.f22243y));
        this.J.setUserPassPointList(JSON.toJSONString(this.f22244z));
        this.J.setStepList(JSON.toJSONString(t2()));
        this.J.setFaceOut(this.G ? "0" : "1");
        this.J.setFaceDetectCount(String.valueOf(this.E));
        this.R.y(this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2(int uploadType, final String stepNumbers) {
        r2();
        this.J.setUploadType(String.valueOf(uploadType));
        this.R.B(this.J, new l1.a() { // from class: com.bxkj.student.run.app.i
            public final Object invoke() {
                f1 K2;
                K2 = RunningActivity.K2();
                return K2;
            }
        });
        iOSOneButtonDialog message = new iOSOneButtonDialog(this.f1656h).setMessage("\u63d0\u4ea4\u5f02\u5e38\uff0c\u5df2\u4e3a\u60a8\u6682\u5b58\u672c\u5730\uff0c\u8bf7\u7a0d\u540e\u5728\u672c\u5730\u8dd1\u6b65\u8bb0\u5f55\u4e2d\u91cd\u65b0\u4e0a\u4f20\uff01");
        message.setCancelable(false);
        message.setCanceledOnTouchOutside(false);
        message.show();
        message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunningActivity.this.L2(stepNumbers, view);
            }
        });
    }

    private void T2(boolean isPause) {
        this.J0 = isPause;
        W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2(boolean isPause) {
        this.I0 = isPause;
        W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2() {
        boolean z3 = this.I0 || this.J0 || this.K0;
        this.Z = z3;
        V2(z3);
    }

    private void X2() {
        this.f22242x = LatLngBounds.builder();
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(2131558820));
        myLocationStyle.strokeColor(-16777216);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        myLocationStyle.myLocationType(6);
        this.f22229l.setMyLocationStyle(myLocationStyle);
        this.f22229l.getUiSettings().setMyLocationButtonEnabled(true);
        this.f22229l.setMyLocationEnabled(true);
        this.f22229l.moveCamera(CameraUpdateFactory.zoomTo(18.0f));
        this.f22229l.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
        this.f22229l.setOnMapTouchListener(new AMap.OnMapTouchListener() { // from class: com.bxkj.student.run.app.f
            @Override // com.amap.api.maps.AMap.OnMapTouchListener
            public final void onTouch(MotionEvent motionEvent) {
                RunningActivity.this.M2(motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2(boolean isPause) {
        this.K0 = isPause;
        W2();
    }

    private void Z2() {
        Q2();
        if (com.bxkj.base.util.y.a(this.f1656h, LocationService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService---isRunning");
            stopService(new Intent(this.f1656h, LocationService.class));
        }
        Intent intent = new Intent(this, LocationService.class);
        intent.putExtra("runType", this.C.getRunType());
        intent.putExtra("runExceptionDataDB", this.J);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a3() {
        if (com.bxkj.base.util.y.a(this.f1656h, StepService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService---isRunning");
            stopService(new Intent(this.f1656h, StepService.class));
        }
        Intent intent = new Intent(this, StepService.class);
        intent.putExtra("runType", this.C.getRunType());
        intent.putExtra("isPause", this.Z);
        intent.putExtra("runExceptionDataDB", this.J);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c3(boolean isIn) {
        if (this.S == null) {
            this.S = new iOSOneButtonDialog(this.f1656h);
        }
        if (isIn && this.G0.booleanValue()) {
            if (this.I0) {
                String str = "\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728" + Double.valueOf(this.C.getFaceDistanceOut() * 1000.0d).intValue() + "\u7c73\u8303\u56f4\u5185\u8fdb\u884c\u4eba\u8138\u8bc6\u522b\uff01";
                this.S.setMessage(str).show();
                Intent intent = new Intent();
                intent.setAction("RUN_PAUSE_NOTIFICATION");
                intent.putExtra("message", str);
                sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            } else {
                Intent intent2 = new Intent();
                intent2.setAction("RUN_CONTINUE_NOTIFICATION");
                sendBroadcast(intent2, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            }
            T2(false);
            com.bxkj.student.run.app.utils.y.g(this.f1656h, 2131755021);
            com.orhanobut.logger.j.c("ActionStatus=\u5728\u5730\u7406\u56f4\u680f\u91cc\u9762");
            if (this.S.isShowing()) {
                this.S.dismiss();
            } else {
                this.S.setMessage("\u60a8\u5df2\u8fdb\u5165\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6062\u590d\uff0c\u8bf7\u7ee7\u7eed\u8fdb\u884c\u8dd1\u6b65\uff01").show();
            }
        } else if (!isIn) {
            if (this.S.isShowing()) {
                this.S.dismiss();
            }
            com.orhanobut.logger.j.c("ActionStatus=\u5728\u5730\u7406\u56f4\u680f\u5916\u9762");
            T2(true);
            com.bxkj.student.run.app.utils.y.g(this.f1656h, 2131755022);
            ((Vibrator) getSystemService("vibrator")).vibrate(2000L);
            String str2 = "\u60a8\u5df2\u504f\u79bb\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728\u89c4\u5b9a\u533a\u57df\u5185\u8fdb\u884c\u8dd1\u6b65\uff01";
            if (this.I0) {
                str2 = "\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728" + Double.valueOf(this.C.getFaceDistanceOut() * 1000.0d).intValue() + "\u7c73\u8303\u56f4\u5185\u8fdb\u884c\u4eba\u8138\u8bc6\u522b\uff01\n\u60a8\u5df2\u504f\u79bb\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728\u89c4\u5b9a\u533a\u57df\u5185\u8fdb\u884c\u8dd1\u6b65\uff01";
            }
            this.S.setMessage(str2).show();
            Intent intent3 = new Intent();
            intent3.setAction("RUN_PAUSE_NOTIFICATION");
            intent3.putExtra("message", str2);
            sendBroadcast(intent3, "com.bxkj.student.sports.permissions.MY_BROADCAST");
        }
        this.G0 = Boolean.valueOf(!isIn);
    }

    private void d3(final int uploadType) {
        com.bxkj.base.v2.common.ext.g.c(this.f1657i, "\u4eba\u8138\u8bc6\u522b", new l1.a() { // from class: com.bxkj.student.run.app.h
            public final Object invoke() {
                f1 P2;
                P2 = RunningActivity.this.P2(uploadType);
                return P2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(String stepNumbers) {
        StartRunActivity startRunActivity = (StartRunActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(StartRunActivity.class);
        if (startRunActivity != null) {
            startRunActivity.p1();
        }
        RunRecorderListActivity runRecorderListActivity = (RunRecorderListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(RunRecorderListActivity.class);
        if (runRecorderListActivity != null) {
            runRecorderListActivity.K0();
        }
        finish();
    }

    private void f3() {
        Intent intent = new Intent();
        intent.setAction("STOP_LOCATION");
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void g3(int uploadType) {
        Y2(true);
        R2();
        this.V = System.currentTimeMillis();
        String jSONString = JSON.toJSONString(t2());
        LoadingDialog loadingDialog = new LoadingDialog(this.f1656h);
        loadingDialog.setOnKeyListener(new DialogOnKeyListener(loadingDialog, false));
        String charSequence = this.f22233p.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = com.bxkj.student.run.app.utils.i.g(this.W);
        }
        String str = charSequence;
        String charSequence2 = this.f22235q.getText().toString();
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = com.bxkj.student.run.app.utils.i.d(this.X);
        }
        String str2 = charSequence2;
        String charSequence3 = this.f22236r.getText().toString();
        if (TextUtils.isEmpty(charSequence3)) {
            charSequence3 = com.bxkj.student.run.app.utils.i.a(this.X, this.W);
        }
        String str3 = charSequence3;
        String charSequence4 = this.f22237s.getText().toString();
        if (TextUtils.isEmpty(charSequence4)) {
            charSequence4 = com.bxkj.student.run.app.utils.i.b(this.X, this.W);
        }
        String str4 = charSequence4;
        try {
            List<LatLngTimeSpeed> list = this.Y;
            if (list != null && list.size() > 2) {
                this.Y = new com.bxkj.student.run.app.utils.o().k(this.Y);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Http.with(this.f1656h).hideLoadingDialog().setCanCancel(false).hideFailMessage().hideOtherStatusMessage().hideSuccessMessage().setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).q(LoginUser.getLoginUser().getUserId(), this.C.getRunType(), this.U, this.V, JSON.toJSONString(this.Y), this.C.getIdentify(), str, str2, str3, str4, JSON.toJSONString(this.f22243y), com.bxkj.base.util.z.d(), com.bxkj.base.util.z.e(), com.bxkj.base.util.z.f(), com.bxkj.base.util.z.c(), com.bxkj.base.util.z.h(this.f1656h), jSONString, this.G ? "0" : "1", JSON.toJSONString(this.f22244z), Integer.valueOf(uploadType), null)).setDataListener(new d(loadingDialog, uploadType, jSONString));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2() {
        List<RunRoleSetBean.DataBean.GeofenceBean> list;
        if (this.C.getGeofence() == null || this.C.getGeofence().isEmpty()) {
            return;
        }
        GeoFenceClient geoFenceClient = new GeoFenceClient(StubApp.getOrigApplicationContext(getApplicationContext()));
        this.P = geoFenceClient;
        geoFenceClient.setActivateAction(3);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.C.getGeofence().size() && (list = this.C.getGeofence().get(i4)) != null; i4++) {
            ArrayList arrayList2 = new ArrayList();
            for (RunRoleSetBean.DataBean.GeofenceBean geofenceBean : list) {
                arrayList2.add(new DPoint(Double.parseDouble(geofenceBean.getLat()), Double.parseDouble(geofenceBean.getLng())));
            }
            arrayList.add(arrayList2);
            String str = "runGeoFenceId" + i4;
            this.E0.put(str, Boolean.TRUE);
            this.P.addGeoFence(arrayList2, str);
        }
        q2(arrayList);
        this.P.setGeoFenceListener(new GeoFenceListener() { // from class: com.bxkj.student.run.app.e
            @Override // com.amap.api.fence.GeoFenceListener
            public final void onGeoFenceCreateFinished(List list2, int i5, String str2) {
                RunningActivity.x2(list2, i5, str2);
            }
        });
        this.P.createPendingIntent("com.location.apis.geofenceBounds.broadcast");
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("com.location.apis.geofenceBounds.broadcast");
        this.Q = registerReceiver(this.F0, intentFilter);
    }

    private void m2() {
        BitmapDescriptor fromResource;
        String str;
        List<Map<String, Object>> list = this.f22243y;
        if (list == null || list.size() == 0) {
            return;
        }
        GeoFenceClient geoFenceClient = new GeoFenceClient(StubApp.getOrigApplicationContext(getApplicationContext()));
        this.O = geoFenceClient;
        geoFenceClient.setActivateAction(1);
        for (Map<String, ? extends Object> map : this.f22243y) {
            double d4 = JsonParse.getDouble(map, "latitude");
            double d5 = JsonParse.getDouble(map, "longitude");
            int i4 = JsonParse.getInt(map, "isMustPoint");
            LatLng latLng = new LatLng(d4, d5);
            if (o2(map)) {
                this.f22229l.addMarker(new MarkerOptions().position(new LatLng(d4, d5)).icon(BitmapDescriptorFactory.fromResource(2131558767)).zIndex(9.0f).title("\u4f60\u5df2\u7ecf\u901a\u8fc7\u5fc5\u7ecf\u70b9:" + com.bxkj.base.v2.common.utils.l.f18624a.t(map, "content")).draggable(false));
            } else {
                if (i4 == 1) {
                    fromResource = BitmapDescriptorFactory.fromResource(2131558766);
                    str = "\u5fc5\u7ecf\u70b9\uff1a";
                } else {
                    fromResource = BitmapDescriptorFactory.fromResource(2131559190);
                    str = "\u9009\u7ecf\u70b9\uff1a";
                }
                String string = JsonParse.getString(map, "content");
                Marker addMarker = this.f22229l.addMarker(new MarkerOptions().position(latLng).icon(fromResource).zIndex(9.0f).title(str + string).draggable(false));
                String str2 = JsonParse.getString(map, "id") + "," + i4;
                addMarker.setObject(str2);
                this.N.add(addMarker);
                this.O.addGeoFence(new DPoint(d4, d5), JsonParse.getInt(map, "okRadius"), str2);
                this.M.include(latLng);
            }
        }
        this.f22229l.animateCamera(CameraUpdateFactory.newLatLngBounds(this.M.build(), cn.bluemobi.dylan.base.utils.u.a(10.0f, this.f1656h)), 2000L, null);
        this.O.setGeoFenceListener(new GeoFenceListener() { // from class: com.bxkj.student.run.app.d
            @Override // com.amap.api.fence.GeoFenceListener
            public final void onGeoFenceCreateFinished(List list2, int i5, String str3) {
                RunningActivity.y2(list2, i5, str3);
            }
        });
        this.O.createPendingIntent("com.location.apis.geofencedemo.broadcast");
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("com.location.apis.geofencedemo.broadcast");
        this.A = registerReceiver(this.D0, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(LatLng startLatLng) {
        this.f22229l.addMarker(new MarkerOptions().position(startLatLng).icon(BitmapDescriptorFactory.fromResource(2131558610)).zIndex(9.0f).draggable(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o2(Map<String, Object> stringObjectMap) {
        double d4 = JsonParse.getDouble(stringObjectMap, "latitude");
        double d5 = JsonParse.getDouble(stringObjectMap, "longitude");
        boolean z3 = false;
        for (Map<String, Object> map : this.f22244z) {
            double d6 = JsonParse.getDouble(map, "latitude");
            double d7 = JsonParse.getDouble(map, "longitude");
            if (d6 == d4 && d7 == d5) {
                z3 = true;
            }
        }
        return z3;
    }

    private void q2(List<List<DPoint>> pointList) {
        if (pointList == null || pointList.isEmpty()) {
            return;
        }
        for (List<DPoint> list : pointList) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                PolygonOptions polygonOptions = new PolygonOptions();
                for (DPoint dPoint : list) {
                    arrayList.add(new LatLng(dPoint.getLatitude(), dPoint.getLongitude()));
                }
                polygonOptions.addAll(arrayList);
                polygonOptions.fillColor(this.f1656h.getResources().getColor(2131034256));
                polygonOptions.strokeColor(this.f1656h.getResources().getColor(2131034478));
                polygonOptions.strokeWidth(4.0f);
                this.f22229l.addPolygon(polygonOptions);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2() {
        this.f22229l.getMyLocationStyle().myLocationType(7);
        f3();
        this.V = System.currentTimeMillis();
        List<LatLngTimeSpeed> list = this.Y;
        if (list != null && list.size() > 0) {
            BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(2131558609);
            com.orhanobut.logger.j.c("latLngList=" + this.Y.size());
            List<LatLngTimeSpeed> list2 = this.Y;
            LatLngTimeSpeed latLngTimeSpeed = list2.get(list2.size() - 1);
            this.f22229l.addMarker(new MarkerOptions().position(new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude())).icon(fromResource).zIndex(9.0f).draggable(true));
        }
        this.f22229l.animateCamera(CameraUpdateFactory.newLatLngBounds(this.f22242x.build(), cn.bluemobi.dylan.base.utils.u.a(50.0f, this.f1656h)), 2000L, null);
    }

    private void s2(int uploadType) {
        if (this.C.getRunType() == 4) {
            g3(uploadType);
        } else if (this.f22244z.size() < this.f22243y.size()) {
            Y2(false);
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1656h);
            iosonebuttondialog.setMessage("\u5fc5\u987b\u7ecf\u8fc7" + this.f22243y.size() + "\u4e2a\u5fc5\u7ecf\u70b9").show();
        } else if (this.C.getIsEndFace() > 0 && !this.H) {
            d3(uploadType);
        } else {
            g3(uploadType);
        }
    }

    static /* synthetic */ int u1(RunningActivity runningActivity) {
        int i4 = runningActivity.E;
        runningActivity.E = i4 + 1;
        return i4;
    }

    private void u2() {
        try {
            if (com.bxkj.base.util.y.a(this.f1656h, LocationService.class.getName())) {
                com.orhanobut.logger.j.c("LocationService----------isServiceRunning");
                stopService(new Intent(this.f1656h, LocationService.class));
            }
            if (com.bxkj.base.util.y.a(this.f1656h, StepService.class.getName())) {
                com.orhanobut.logger.j.c("StepService----------isServiceRunning");
                stopService(new Intent(this.f1656h, StepService.class));
            }
            X2();
            w2();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void v2() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        if (com.bxkj.base.util.y.a(this.f1656h, LocationService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService----------isServiceRunning");
            stopService(new Intent(this.f1656h, LocationService.class));
        }
        if (com.bxkj.base.util.y.a(this.f1656h, StepService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService----------isServiceRunning");
            stopService(new Intent(this.f1656h, StepService.class));
        }
        finish();
    }

    private void w2() {
        if (this.C == null) {
            v2();
        }
        for (Map<String, Object> map : JsonParse.getList((ArrayMap) JSON.parseObject(JSON.toJSONString(this.C), new a().getType(), new Feature[0]), "list")) {
            if (JsonParse.getInt(map, "isMustPoint") == 1) {
                this.f22243y.add(map);
            }
        }
        this.B = this.C.getSurplusNum();
        if (this.C.getIsClock() > 0) {
            this.f22241w.setVisibility(0);
        }
        this.D = this.C.getMiddleFaces();
        if (!this.C.getContext().isEmpty()) {
            this.f22232o.setVisibility(0);
            this.f22232o.setText(this.C.getContext());
        }
        this.M = LatLngBounds.builder();
        Z2();
        m2();
        b3("GPS\u4fe1\u53f7\u5f31\u6216\u4f4d\u7f6e\u7cbe\u786e\u5ea6\u8f83\u4f4e,\u8bf7\u5728\u5ba4\u5916\u7a7a\u65f7\u7684\u5730\u65b9\u8fdb\u884c\u8dd1\u6b65,\u5426\u5219\u5c06\u53ef\u80fd\u5f71\u54cd\u60a8\u7684\u8dd1\u6b65\u8f68\u8ff9\u8bb0\u5f55\u4e0d\u51c6\u786e\u3002\u5982\u679c\u957f\u65f6\u95f4\u4e0d\u80fd\u5b9a\u4f4d\uff0c\u8bf7\u91cd\u542f\u624b\u673a\u540e\u91cd\u8bd5\uff01");
        if (TextUtils.isEmpty(this.C.getContext())) {
            return;
        }
        new iOSOneButtonDialog(this.f1656h).setMessageGrivity(3).setMessage(this.C.getContext()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x2(List list, int i4, String str) {
        if (i4 == 0) {
            com.orhanobut.logger.j.c("\u6dfb\u52a0\u8dd1\u6b65\u8303\u56f4\u56f4\u680f\u6210\u529f!!");
        } else {
            com.orhanobut.logger.j.c("\u6dfb\u52a0\u8dd1\u6b65\u8303\u56f4\u56f4\u680f\u5931\u8d25!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y2(List list, int i4, String str) {
        if (i4 == 0) {
            com.orhanobut.logger.j.c("\u6dfb\u52a0\u56f4\u680f\u6210\u529f!!");
        } else {
            com.orhanobut.logger.j.c("\u6dfb\u52a0\u56f4\u680f\u5931\u8d25!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2() {
        Y2(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22240v.setOnFinishListener(new LongPressToFinishButton.OnFinishListener() { // from class: com.bxkj.student.run.app.g
            @Override // com.bxkj.student.common.view.LongPressToFinishButton.OnFinishListener
            public final void onFinish() {
                RunningActivity.this.B2();
            }
        });
        Z(new BaseActivity.c() { // from class: com.bxkj.student.run.app.n
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                RunningActivity.this.C2();
            }
        });
        this.f22241w.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunningActivity.this.D2(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427471;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.K = new com.bxkj.student.run.app.utils.g();
        if (getIntent().hasExtra("runExceptionDataDBId")) {
            String stringExtra = getIntent().getStringExtra("runExceptionDataDBId");
            if (TextUtils.isEmpty(stringExtra)) {
                v2();
            } else {
                this.R.v(stringExtra, new l1.l() { // from class: com.bxkj.student.run.app.j
                    @Override // l1.l
                    public final Object invoke(Object obj) {
                        f1 E2;
                        E2 = RunningActivity.this.E2((List) obj);
                        return E2;
                    }
                });
            }
        } else if (getIntent().hasExtra("dataBean")) {
            RunRoleSetBean.DataBean dataBean = (RunRoleSetBean.DataBean) getIntent().getParcelableExtra("dataBean");
            this.C = dataBean;
            if (dataBean != null && !TextUtils.isEmpty(dataBean.getIdentify())) {
                long currentTimeMillis = System.currentTimeMillis();
                if (getIntent().hasExtra("startTime")) {
                    currentTimeMillis = getIntent().getLongExtra("startTime", System.currentTimeMillis());
                    com.orhanobut.logger.j.c("\u8dd1\u6b65\u5f00\u59cb\u65f6\u95f4=" + com.bxkj.student.run.app.utils.i.h(currentTimeMillis, null));
                }
                RunDb runDb = new RunDb(this.C.getIdentify(), LoginUser.getLoginUser().getAccount(), String.valueOf(this.C.getRunType()), JSON.toJSONString(this.C), String.valueOf(currentTimeMillis), "", "0", "0", "", "", "", "", "0", "0", "-1");
                this.J = runDb;
                this.R.y(runDb);
                u2();
                return;
            }
            v2();
        } else {
            v2();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8dd1\u6b65\u4e2d");
        b0(2131558983, new BaseActivity.c() { // from class: com.bxkj.student.run.app.o
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                RunningActivity.this.F2();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        try {
            this.f1656h = this;
            MapView mapView = (MapView) findViewById(2131232258);
            this.f22228k = mapView;
            mapView.onCreate(savedInstanceState);
            this.f22229l = this.f22228k.getMap();
            this.f22230m = (ImageView) findViewById(2131231424);
            this.f22231n = (TextView) findViewById(2131232980);
            this.f22233p = (TextView) findViewById(2131233198);
            this.f22235q = (TextView) findViewById(2131232941);
            this.f22236r = (TextView) findViewById(2131233162);
            this.f22237s = (TextView) findViewById(2131233076);
            LinearLayout linearLayout = (LinearLayout) findViewById(2131232167);
            this.f22239u = linearLayout;
            linearLayout.setVisibility(4);
            this.f22240v = (LongPressToFinishButton) findViewById(2131231013);
            this.f22241w = (Button) findViewById(2131230960);
            this.f22232o = (MarqueeTextView) findViewById(2131232939);
            this.f22238t = (TextView) findViewById(2131233170);
            if (savedInstanceState != null && savedInstanceState.containsKey("runExceptionDataDBId")) {
                getIntent().putExtra("runExceptionDataDBId", savedInstanceState.getString("runExceptionDataDBId"));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.R = (RunVM) new ViewModelProvider(this).get(RunVM.class);
    }

    public void V2(boolean isPause) {
        Intent intent = new Intent();
        intent.setAction("SET_RUNNING_PAUSE");
        intent.putExtra("isPause", isPause);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    public void b3(String str) {
        if (this.H0 == null) {
            this.H0 = new ProgressDialog(this);
        }
        this.H0.setMessage(str);
        this.H0.setCanceledOnTouchOutside(false);
        this.H0.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.run.app.b
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                boolean N2;
                N2 = RunningActivity.this.N2(dialogInterface, i4, keyEvent);
                return N2;
            }
        });
        this.H0.show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void C2() {
        try {
            Y2(true);
            iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
            iostwobuttondialog.setCancelable(false);
            if (this.C.getRunType() == 3) {
                iostwobuttondialog.setTitle("\u63d0\u793a").setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u672c\u6b21\u8dd1\u6b65\u5417\uff1f").setLeftButtonText("\u7ee7\u7eed\u8dd1\u6b65").setRightButtonText("\u786e\u5b9a\u53d6\u6d88").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.p
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        RunningActivity.this.G2();
                    }
                }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.t
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        RunningActivity.this.H2();
                    }
                }).show();
            } else {
                iOSTwoButtonDialog title = iostwobuttondialog.setTitle("\u786e\u5b9a\u8981\u53d6\u6d88\u672c\u6b21\u8dd1\u6b65\u5417\uff1f");
                title.setMessage("\u4eca\u5929\u5269\u4f59\u53ef\u8dd1\u6b65\u6b21\u6570" + this.B + "\u6b21").setLeftButtonText("\u7ee7\u7eed\u8dd1\u6b65").setRightButtonText("\u786e\u5b9a\u53d6\u6d88").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.q
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        RunningActivity.this.I2();
                    }
                }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.s
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        RunningActivity.this.J2();
                    }
                }).show();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            ProgressDialog progressDialog = this.H0;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.H0.dismiss();
            }
            this.f22228k.onDestroy();
            GeoFenceClient geoFenceClient = this.O;
            if (geoFenceClient != null) {
                geoFenceClient.removeGeoFence();
            }
            if (this.A != null) {
                unregisterReceiver(this.D0);
            }
            GeoFenceClient geoFenceClient2 = this.P;
            if (geoFenceClient2 != null) {
                geoFenceClient2.removeGeoFence();
            }
            if (this.Q != null) {
                unregisterReceiver(this.F0);
            }
            e eVar = this.f22227L;
            if (eVar != null) {
                unregisterReceiver(eVar);
            }
            if (com.bxkj.base.util.y.a(this.f1656h, LocationService.class.getName())) {
                com.orhanobut.logger.j.c("stopService(new Intent(mContext, LocationService.class))");
                stopService(new Intent(this.f1656h, LocationService.class));
            }
            if (com.bxkj.base.util.y.a(this.f1656h, StepService.class.getName())) {
                com.orhanobut.logger.j.c("stopService(new Intent(mContext, StepService.class))");
                stopService(new Intent(this.f1656h, StepService.class));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.K.c();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            this.K.b(this);
            LatLng latLng = this.f22234p0;
            if (latLng != null) {
                this.f22229l.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng, 18.0f)), 1000L, null);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        this.f22228k.onSaveInstanceState(outState);
        RunDb runDb = this.J;
        if (runDb != null) {
            outState.putString("runExceptionDataDBId", runDb.getIdentify());
        }
        super.onSaveInstanceState(outState);
    }

    public String p2(long size) {
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

    public List<Integer> t2() {
        long j4 = this.W;
        long j5 = (j4 / 60) + (j4 % 60 == 0 ? 0 : 1);
        ArrayList arrayList = new ArrayList(this.C0);
        int i4 = this.A0;
        int i5 = i4 - this.B0;
        if (i4 < 0) {
            this.A0 = 0;
        }
        if (arrayList.size() < j5) {
            arrayList.add(Integer.valueOf(i5));
        } else if (arrayList.size() == 0) {
            arrayList.add(Integer.valueOf(i5));
        } else {
            arrayList.set(arrayList.size() - 1, Integer.valueOf(((Integer) arrayList.get(arrayList.size() - 1)).intValue() + i5));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private PolylineOptions f22252a;

        /* renamed from: b  reason: collision with root package name */
        private Polyline f22253b;

        /* renamed from: c  reason: collision with root package name */
        private List<Integer> f22254c;

        /* renamed from: d  reason: collision with root package name */
        private PolylineOptions f22255d;

        /* renamed from: e  reason: collision with root package name */
        private Polyline f22256e;

        /* renamed from: f  reason: collision with root package name */
        List<Polyline> f22257f;

        private e() {
            this.f22252a = new PolylineOptions();
            this.f22254c = new ArrayList();
            this.f22255d = new PolylineOptions();
            this.f22257f = new ArrayList();
        }

        private void d(double distance, LatLng latLng) {
            if (RunningActivity.this.D != null && RunningActivity.this.E < RunningActivity.this.D.size() && !RunningActivity.this.I0 && distance >= ((Double) RunningActivity.this.D.get(RunningActivity.this.E)).doubleValue()) {
                RunningActivity.this.F = latLng;
                ((Vibrator) RunningActivity.this.getSystemService("vibrator")).vibrate(2000L);
                RunningActivity.this.U2(true);
                com.bxkj.student.run.app.utils.y.g(((BaseActivity) RunningActivity.this).f1656h, 2131755098);
                if (RunningActivity.this.I == null) {
                    RunningActivity.this.I = new iOSOneButtonDialog(((BaseActivity) RunningActivity.this).f1656h);
                } else {
                    RunningActivity.this.I.dismiss();
                }
                RunningActivity.this.I.setClickAutoCancel(false);
                RunningActivity.this.I.setCancelable(false);
                RunningActivity.this.I.setCanceledOnTouchOutside(false);
                String str = "\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728" + Double.valueOf(RunningActivity.this.C.getFaceDistanceOut() * 1000.0d).intValue() + "\u7c73\u8303\u56f4\u5185\u8fdb\u884c\u4eba\u8138\u8bc6\u522b\uff01";
                Intent intent = new Intent();
                intent.setAction("RUN_PAUSE_NOTIFICATION");
                intent.putExtra("message", str);
                RunningActivity.this.sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
                RunningActivity.this.I.setMessage(str).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunningActivity.e.this.j(view);
                    }
                });
                RunningActivity.this.I.show();
            }
        }

        private void e(List<LatLng> latLngs) {
            this.f22257f.add(RunningActivity.this.f22229l.addPolyline(new PolylineOptions().addAll(latLngs).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)).setDottedLine(true).color(ContextCompat.getColor(((BaseActivity) RunningActivity.this).f1656h, 2131034173)).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h))));
        }

        private void f(LatLng newLatLng, LatLng lastLatLng, float speed, boolean isPause) {
            if (isPause) {
                Polyline polyline = this.f22256e;
                if (polyline == null) {
                    this.f22252a = null;
                    this.f22253b = null;
                    this.f22254c = new ArrayList();
                    this.f22255d = new PolylineOptions();
                    this.f22256e = RunningActivity.this.f22229l.addPolyline(this.f22255d.add(lastLatLng, newLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)).setDottedLine(true).color(ContextCompat.getColor(((BaseActivity) RunningActivity.this).f1656h, 2131034173)).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)));
                    return;
                }
                polyline.setOptions(this.f22255d.add(newLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)).setDottedLine(true).color(ContextCompat.getColor(((BaseActivity) RunningActivity.this).f1656h, 2131034173)).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)));
                return;
            }
            this.f22254c.add(Integer.valueOf(com.bxkj.student.run.app.utils.i.r(((BaseActivity) RunningActivity.this).f1656h, speed)));
            Polyline polyline2 = this.f22253b;
            if (polyline2 == null) {
                this.f22255d = null;
                this.f22256e = null;
                this.f22252a = new PolylineOptions();
                this.f22253b = RunningActivity.this.f22229l.addPolyline(this.f22252a.add(lastLatLng, newLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)).colorValues(this.f22254c).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)));
                return;
            }
            polyline2.setOptions(this.f22252a.add(newLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)).colorValues(this.f22254c).useGradient(true).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)).color(com.bxkj.student.run.app.utils.i.r(((BaseActivity) RunningActivity.this).f1656h, speed)));
        }

        private void g(List<LatLng> latLngs, boolean isPause, List<Integer> colorValues) {
            com.orhanobut.logger.j.c("\u753b\u7ebf");
            if (isPause) {
                e(latLngs);
            } else {
                h(latLngs, colorValues);
            }
        }

        private void h(List<LatLng> latLngs, List<Integer> colorValues) {
            this.f22257f.add(RunningActivity.this.f22229l.addPolyline(new PolylineOptions().addAll(latLngs).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)).colorValues(colorValues).useGradient(true).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h))));
        }

        private void i(LatLng startLatLng) {
            if (RunningActivity.this.isFinishing() || RunningActivity.this.isDestroyed()) {
                return;
            }
            if (RunningActivity.this.H0 != null && RunningActivity.this.H0.isShowing()) {
                RunningActivity.this.H0.dismiss();
            }
            if (RunningActivity.this.f22239u.getVisibility() != 0) {
                RunningActivity.this.f22239u.setVisibility(0);
            }
            RunningActivity.this.a3();
            RunningActivity.this.n2(startLatLng);
            RunningActivity.this.l2();
            this.f22254c.add(Integer.valueOf(ContextCompat.getColor(((BaseActivity) RunningActivity.this).f1656h, 2131034471)));
            try {
                if (this.f22252a == null) {
                    this.f22252a = new PolylineOptions();
                }
                this.f22253b = RunningActivity.this.f22229l.addPolyline(this.f22252a.add(startLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).f1656h)).colorValues(this.f22254c).useGradient(false).zIndex(10.0f));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            RunningActivity.this.f22242x.include(startLatLng).build();
            RunningActivity.this.f22229l.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(startLatLng, 18.0f)), 1000L, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(View view) {
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(int i4, Intent intent) {
            if (i4 != -1) {
                if (i4 == 170) {
                    n();
                    return;
                } else {
                    RunningActivity.this.W2();
                    return;
                }
            }
            if (RunningActivity.this.I != null && RunningActivity.this.I.isShowing()) {
                RunningActivity.this.I.dismiss();
            }
            RunningActivity.u1(RunningActivity.this);
            com.bxkj.student.run.app.utils.y.g(((BaseActivity) RunningActivity.this).f1656h, 2131755020);
            new iOSOneButtonDialog(((BaseActivity) RunningActivity.this).f1656h).setMessage("\u4eba\u8138\u8bc6\u522b\u6210\u529f\uff0c\u8bf7\u7ee7\u7eed\u8dd1\u6b65").show();
            if (RunningActivity.this.J0) {
                RunningActivity.this.S.setMessage("\u60a8\u5df2\u504f\u79bb\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728\u89c4\u5b9a\u533a\u57df\u5185\u8fdb\u884c\u8dd1\u6b65\uff01").show();
                Intent intent2 = new Intent();
                intent2.setAction("RUN_PAUSE_NOTIFICATION");
                intent2.putExtra("message", "\u60a8\u5df2\u504f\u79bb\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728\u89c4\u5b9a\u533a\u57df\u5185\u8fdb\u884c\u8dd1\u6b65\uff01");
                RunningActivity.this.sendBroadcast(intent2, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            } else {
                Intent intent3 = new Intent();
                intent3.setAction("RUN_CONTINUE_NOTIFICATION");
                RunningActivity.this.sendBroadcast(intent3, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            }
            RunningActivity.this.U2(false);
            if (RunningActivity.this.C.getFaceDistanceOut() != 0.0d && AMapUtils.calculateLineDistance(RunningActivity.this.f22234p0, RunningActivity.this.F) > RunningActivity.this.C.getFaceDistanceOut() * 1000.0d) {
                RunningActivity.this.G = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ f1 l() {
            Intent intent = RunningActivity.this.getIntent().setClass(((BaseActivity) RunningActivity.this).f1656h, FaceDetectExpActivity.class);
            intent.putExtra("identify", RunningActivity.this.C.getIdentify());
            new m.b(((BaseActivity) RunningActivity.this).f1657i).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.student.run.app.w
                @Override // m.b.a
                public final void a(int i4, Intent intent2) {
                    RunningActivity.e.this.k(i4, intent2);
                }
            });
            RunningActivity.this.overridePendingTransition(2130771987, 2130771986);
            return null;
        }

        private void m(long countTime) {
            if (countTime % 60 == 0) {
                long j4 = countTime / 60;
                int i4 = RunningActivity.this.A0 - RunningActivity.this.B0;
                if (i4 < 0) {
                    i4 = 0;
                }
                if (RunningActivity.this.C0.size() < j4) {
                    RunningActivity.this.C0.add(Integer.valueOf(i4));
                } else {
                    RunningActivity.this.C0.set(RunningActivity.this.C0.size() - 1, Integer.valueOf(((Integer) RunningActivity.this.C0.get(RunningActivity.this.C0.size() - 1)).intValue() + i4));
                }
                RunningActivity runningActivity = RunningActivity.this;
                runningActivity.B0 = runningActivity.A0;
            }
        }

        private void n() {
            com.bxkj.base.v2.common.ext.g.c(((BaseActivity) RunningActivity.this).f1657i, "\u4eba\u8138\u8bc6\u522b", new l1.a() { // from class: com.bxkj.student.run.app.v
                public final Object invoke() {
                    f1 l4;
                    l4 = RunningActivity.e.this.l();
                    return l4;
                }
            });
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("GET_FIRST_LOCATION_SUCCESS")) {
                if (intent.hasExtra("latLng")) {
                    LatLng latLng = (LatLng) intent.getParcelableExtra("latLng");
                    if (RunningActivity.this.M != null) {
                        RunningActivity.this.M.include(latLng);
                    }
                    RunningActivity.this.f22229l.animateCamera(CameraUpdateFactory.newLatLngBounds(RunningActivity.this.M.build(), cn.bluemobi.dylan.base.utils.u.a(50.0f, ((BaseActivity) RunningActivity.this).f1656h)), 1000L, null);
                }
            } else if (intent.getAction().equals("ADD_START_POINT")) {
                com.orhanobut.logger.j.c("\u8d77\u59cb\u70b9\u5b9a\u4f4d\u6210\u529f");
                if (intent.hasExtra("startTime")) {
                    RunningActivity.this.U = intent.getLongExtra("startTime", System.currentTimeMillis());
                }
                if (intent.hasExtra("latLngTimeSpeed")) {
                    RunningActivity.this.Y.add((LatLngTimeSpeed) intent.getParcelableExtra("latLngTimeSpeed"));
                }
                if (intent.hasExtra("latLng")) {
                    i((LatLng) intent.getParcelableExtra("latLng"));
                }
            } else if (intent.getAction().equals("ADD_OLD_LINE")) {
                if (intent.hasExtra("countTime")) {
                    RunningActivity.this.W = intent.getLongExtra("countTime", 0L);
                    RunningActivity.this.f22233p.setText(com.bxkj.student.run.app.utils.i.g(RunningActivity.this.W));
                }
                if (intent.hasExtra("distance")) {
                    RunningActivity.this.X = intent.getFloatExtra("distance", 0.0f);
                    RunningActivity.this.f22235q.setText(com.bxkj.student.run.app.utils.i.d(RunningActivity.this.X));
                }
                if (intent.hasExtra("avgSpeed")) {
                    RunningActivity.this.f22236r.setText(intent.getStringExtra("avgSpeed"));
                }
                if (intent.hasExtra("pace")) {
                    RunningActivity.this.f22237s.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("latLngTimeSpeedList")) {
                    RunningActivity.this.Y = intent.getParcelableArrayListExtra("latLngTimeSpeedList");
                    for (int i4 = 1; i4 < RunningActivity.this.Y.size(); i4++) {
                        LatLngTimeSpeed latLngTimeSpeed = (LatLngTimeSpeed) RunningActivity.this.Y.get(i4 - 1);
                        LatLngTimeSpeed latLngTimeSpeed2 = (LatLngTimeSpeed) RunningActivity.this.Y.get(i4);
                        f(new LatLng(latLngTimeSpeed2.getLatitude(), latLngTimeSpeed2.getLongitude()), new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude()), latLngTimeSpeed2.getSpeed(), latLngTimeSpeed2.isPuase());
                    }
                    i(new LatLng(((LatLngTimeSpeed) RunningActivity.this.Y.get(0)).getLatitude(), ((LatLngTimeSpeed) RunningActivity.this.Y.get(0)).getLongitude()));
                    this.f22253b = null;
                    this.f22256e = null;
                }
                if (intent.hasExtra("startTime")) {
                    RunningActivity.this.U = intent.getLongExtra("startTime", System.currentTimeMillis());
                }
            } else if (intent.getAction().equals("ADD_LINE")) {
                RunningActivity.this.R2();
                if (intent.hasExtra("latLngTimeSpeed")) {
                    RunningActivity.this.Y.add((LatLngTimeSpeed) intent.getParcelableExtra("latLngTimeSpeed"));
                }
                if (intent.hasExtra("distance")) {
                    RunningActivity.this.X = intent.getFloatExtra("distance", 0.0f);
                }
                String d4 = com.bxkj.student.run.app.utils.i.d(RunningActivity.this.X);
                RunningActivity.this.f22235q.setText(d4);
                if (intent.hasExtra("currentLatLng")) {
                    d(Double.parseDouble(d4), (LatLng) intent.getParcelableExtra("currentLatLng"));
                }
                if (intent.hasExtra("avgSpeed")) {
                    RunningActivity.this.f22236r.setText(intent.getStringExtra("avgSpeed"));
                }
                if (intent.hasExtra("pace")) {
                    RunningActivity.this.f22237s.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("currentLatLng") && intent.hasExtra("lastLatLng") && intent.hasExtra("speed") && intent.hasExtra("isPause")) {
                    LatLng latLng2 = (LatLng) intent.getParcelableExtra("currentLatLng");
                    f(latLng2, (LatLng) intent.getParcelableExtra("lastLatLng"), intent.getFloatExtra("speed", 0.0f), intent.getBooleanExtra("isPause", false));
                    RunningActivity.this.f22242x.include(latLng2).build();
                    if (System.currentTimeMillis() - RunningActivity.this.T > PolicyConfig.mServerBusyRetryBaseInternal) {
                        RunningActivity.this.f22229l.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng2, 18.0f)), 500L, null);
                    }
                }
            } else if (intent.getAction().equals("SAVE_LOCAL_DB")) {
                RunningActivity.this.R2();
            } else if (intent.getAction().equals("TIME_CHANGE")) {
                if (intent.hasExtra("countTime")) {
                    RunningActivity.this.W = intent.getLongExtra("countTime", 0L);
                    RunningActivity.this.f22233p.setText(com.bxkj.student.run.app.utils.i.g(RunningActivity.this.W));
                    m(RunningActivity.this.W);
                }
            } else if (intent.getAction().equals("UPDATE_GPS_STATUS")) {
                if (intent.hasExtra("gpsStatus") && intent.hasExtra("gpsStatusImage")) {
                    String stringExtra = intent.getStringExtra("gpsStatus");
                    RunningActivity.this.f22230m.setImageResource(intent.getIntExtra("gpsStatusImage", 0));
                    RunningActivity.this.f22231n.setText(stringExtra);
                }
            } else if (intent.getAction().equals("UPDATE_STEP")) {
                if (intent.hasExtra("stepCount")) {
                    RunningActivity.this.A0 = intent.getIntExtra("stepCount", 0);
                    RunningActivity.this.f22238t.setText(String.valueOf(RunningActivity.this.A0));
                }
            } else if (intent.getAction().equals("CURRENT_LATLNG")) {
                Bundle extras = intent.getExtras();
                if (extras.containsKey("latLng")) {
                    try {
                        RunningActivity.this.f22234p0 = (LatLng) extras.get("latLng");
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }

        /* synthetic */ e(RunningActivity runningActivity, a aVar) {
            this();
        }
    }
}
