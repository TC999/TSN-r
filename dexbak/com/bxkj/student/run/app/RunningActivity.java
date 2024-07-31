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
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
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
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3919y;
import com.bxkj.base.util.QRCode;
import com.bxkj.base.util.SystemUtils;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.view.LongPressToFinishButton;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.location.service.LocationService;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.p093vm.RunVM;
import com.bxkj.student.run.app.ready.RunRoleSetBean;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.set.RunSettingActivity;
import com.bxkj.student.run.app.step.service.StepService;
import com.bxkj.student.run.app.utils.CpuWakeLock;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.bxkj.student.run.app.utils.PathSmoothTool;
import com.bxkj.student.run.app.utils.SoundManagerUtil;
import com.github.mikephil.charting.utils.Utils;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p618m.StartActivityForResult;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunningActivity extends BaseActivity {

    /* renamed from: L0 */
    public static final String f18943L0 = "com.location.apis.geofencedemo.broadcast";

    /* renamed from: M0 */
    public static final String f18944M0 = "com.location.apis.geofenceBounds.broadcast";

    /* renamed from: A */
    private Intent f18945A;

    /* renamed from: A0 */
    private int f18946A0;

    /* renamed from: B0 */
    private int f18948B0;

    /* renamed from: C */
    private RunRoleSetBean.DataBean f18949C;

    /* renamed from: D */
    private List<Double> f18951D;

    /* renamed from: F */
    private LatLng f18955F;

    /* renamed from: H0 */
    private ProgressDialog f18960H0;

    /* renamed from: I */
    private iOSOneButtonDialog f18961I;

    /* renamed from: J */
    private RunDb f18963J;

    /* renamed from: K */
    private CpuWakeLock f18965K;

    /* renamed from: L */
    private C5193e f18967L;

    /* renamed from: M */
    private LatLngBounds.Builder f18968M;

    /* renamed from: O */
    private GeoFenceClient f18970O;

    /* renamed from: P */
    private GeoFenceClient f18971P;

    /* renamed from: Q */
    private Intent f18972Q;

    /* renamed from: R */
    private RunVM f18973R;

    /* renamed from: S */
    private iOSOneButtonDialog f18974S;

    /* renamed from: V */
    private long f18977V;

    /* renamed from: k */
    private MapView f18982k;

    /* renamed from: l */
    private AMap f18983l;

    /* renamed from: m */
    private ImageView f18984m;

    /* renamed from: n */
    private TextView f18985n;

    /* renamed from: o */
    private MarqueeTextView f18986o;

    /* renamed from: p */
    private TextView f18987p;

    /* renamed from: p0 */
    private LatLng f18988p0;

    /* renamed from: q */
    private TextView f18989q;

    /* renamed from: r */
    private TextView f18990r;

    /* renamed from: s */
    private TextView f18991s;

    /* renamed from: t */
    private TextView f18992t;

    /* renamed from: u */
    private LinearLayout f18993u;

    /* renamed from: v */
    private LongPressToFinishButton f18994v;

    /* renamed from: w */
    private Button f18995w;

    /* renamed from: x */
    private LatLngBounds.Builder f18996x;

    /* renamed from: y */
    private List<Map<String, Object>> f18997y = new ArrayList();

    /* renamed from: z */
    private List<Map<String, Object>> f18998z = new ArrayList();

    /* renamed from: B */
    private int f18947B = 0;

    /* renamed from: E */
    private int f18953E = 0;

    /* renamed from: G */
    private boolean f18957G = true;

    /* renamed from: H */
    private boolean f18959H = false;

    /* renamed from: N */
    private List<Marker> f18969N = new ArrayList();

    /* renamed from: T */
    private long f18975T = 0;

    /* renamed from: U */
    private long f18976U = System.currentTimeMillis();

    /* renamed from: W */
    private long f18978W = 0;

    /* renamed from: X */
    private float f18979X = 0.0f;

    /* renamed from: Y */
    private List<LatLngTimeSpeed> f18980Y = new ArrayList();

    /* renamed from: Z */
    private boolean f18981Z = false;

    /* renamed from: C0 */
    private List<Integer> f18950C0 = new ArrayList();

    /* renamed from: D0 */
    private BroadcastReceiver f18952D0 = new C5190b();

    /* renamed from: E0 */
    private Map<String, Boolean> f18954E0 = new ArrayMap();

    /* renamed from: F0 */
    private BroadcastReceiver f18956F0 = new C5191c();

    /* renamed from: G0 */
    private Boolean f18958G0 = Boolean.FALSE;

    /* renamed from: I0 */
    private boolean f18962I0 = false;

    /* renamed from: J0 */
    private boolean f18964J0 = false;

    /* renamed from: K0 */
    private boolean f18966K0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.RunningActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5189a extends TypeReference<ArrayMap<String, Object>> {
        C5189a() {
        }
    }

    /* renamed from: com.bxkj.student.run.app.RunningActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5190b extends BroadcastReceiver {
        C5190b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunningActivity.f18943L0)) {
                C11792j.m20470c("进入电子围栏");
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                extras.getInt("event");
                String string = extras.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                extras.getString(GeoFence.BUNDLE_KEY_FENCEID);
                GeoFence geoFence = (GeoFence) extras.getParcelable(GeoFence.BUNDLE_KEY_FENCE);
                if (geoFence == null) {
                    return;
                }
                SoundManagerUtil.m39512g(((BaseActivity) RunningActivity.this).f1669h, C4215R.raw.pass_asses);
                BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(C4215R.mipmap.img_point_must_pass);
                double latitude = geoFence.getCenter().getLatitude();
                double longitude = geoFence.getCenter().getLongitude();
                String str = string.split(",")[0];
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                HashMap hashMap = new HashMap();
                hashMap.put("id", str);
                hashMap.put(RtspHeaders.Values.TIME, simpleDateFormat.format(new Date()));
                hashMap.put("latitude", Double.valueOf(latitude));
                hashMap.put("longitude", Double.valueOf(longitude));
                if (!RunningActivity.this.m40249o2(hashMap)) {
                    RunningActivity.this.f18998z.add(hashMap);
                }
                MarkerOptions zIndex = new MarkerOptions().position(new LatLng(latitude, longitude)).icon(fromResource).zIndex(9.0f);
                MarkerOptions draggable = zIndex.title("你已经通过必经点").draggable(false);
                for (Marker marker : RunningActivity.this.f18969N) {
                    if (marker.getObject().toString().equals(string) && !marker.isRemoved()) {
                        draggable.title(draggable.getTitle() + marker.getTitle().substring(marker.getTitle().indexOf("：")));
                        marker.remove();
                    }
                }
                RunningActivity.this.f18983l.addMarker(draggable);
                RunningActivity.this.f18970O.removeGeoFence(geoFence);
            }
        }
    }

    /* renamed from: com.bxkj.student.run.app.RunningActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5191c extends BroadcastReceiver {
        C5191c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            if (!intent.getAction().equals(RunningActivity.f18944M0) || (extras = intent.getExtras()) == null) {
                return;
            }
            int i = extras.getInt("event");
            boolean z = false;
            RunningActivity.this.f18954E0.put(extras.getString(GeoFence.BUNDLE_KEY_CUSTOMID), Boolean.valueOf(i == 1));
            C11792j.m20470c("ActionStatus=" + i);
            for (String str : RunningActivity.this.f18954E0.keySet()) {
                if (((Boolean) RunningActivity.this.f18954E0.get(str)).booleanValue()) {
                    z = true;
                }
            }
            RunningActivity.this.m40284c3(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.RunningActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5192d extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ LoadingDialog f19002a;

        /* renamed from: b */
        final /* synthetic */ int f19003b;

        /* renamed from: c */
        final /* synthetic */ String f19004c;

        C5192d(final LoadingDialog val$loadingDialog, final int val$uploadType, final String val$stepNumbers) {
            this.f19002a = val$loadingDialog;
            this.f19003b = val$uploadType;
            this.f19004c = val$stepNumbers;
        }

        /* renamed from: a */
        private void m40215a() {
            RunningActivity.this.m40240r2();
            RunningActivity.this.f18973R.m39504u(RunningActivity.this.f18963J.getIdentify());
            Toast toast = new Toast(((BaseActivity) RunningActivity.this).f1669h);
            toast.setView(View.inflate(((BaseActivity) RunningActivity.this).f1669h, C4215R.C4221layout.toast_upload, null));
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.show();
            RunningActivity.this.m40278e3(this.f19004c);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            RunningActivity.this.m40314S2(this.f19003b, this.f19004c);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            LoadingDialog loadingDialog = this.f19002a;
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 202) {
                m40215a();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) RunningActivity.this).f1669h).setMessage(msg).show();
            RunningActivity.this.m40296Y2(false);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnStart() {
            super.netOnStart();
            this.f19002a.showDefaultStyle("正在上传跑步数据，1分钟内如果上传不成功，会在本地保存数据，请选择其他时间段，选择本地记录进行上传。上传数据这1分钟内，请不要退出或卸载APP，否则数据将丢失。");
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            m40215a();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccessServerError(int code, String errorMessage) {
            super.netOnSuccessServerError(code, errorMessage);
            RunningActivity.this.m40314S2(this.f19003b, this.f19004c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A2 */
    public /* synthetic */ void m40368A2() {
        m40237s2(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B2 */
    public /* synthetic */ void m40365B2() {
        m40296Y2(true);
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        iostwobuttondialog.setTitle("提示").setMessage("确定要结束跑步吗？").setLeftButtonText("继续").setRightButtonText("结束").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.r
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                RunningActivity.this.m40216z2();
            }
        }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.c
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                RunningActivity.this.m40368A2();
            }
        }).show();
        iostwobuttondialog.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D2 */
    public /* synthetic */ void m40359D2(View view) {
        iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1669h);
        iosonebuttondialog.setTitle("请刷码");
        iosonebuttondialog.setCenterCustomView(C4215R.C4221layout.dialog_qr_code);
        iosonebuttondialog.setOneButtonText("关闭");
        iosonebuttondialog.setMessageGrivity(17);
        ((ImageView) iosonebuttondialog.findViewById(C4215R.C4219id.iv_qr)).setImageBitmap(QRCode.m44024f(LoginUser.getLoginUser().getAccount(), Tools.m57620a(260.0f, this.f1669h), BitmapFactory.decodeResource(getResources(), 2131558617)));
        iosonebuttondialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E2 */
    public /* synthetic */ Unit m40356E2(List list) {
        if (list != null && list.size() > 0) {
            int i = 0;
            RunDb runDb = (RunDb) list.get(0);
            this.f18963J = runDb;
            this.f18949C = (RunRoleSetBean.DataBean) JSON.parseObject(runDb.getSportsSet(), RunRoleSetBean.DataBean.class);
            if (Long.parseLong(this.f18963J.getCountTime()) != 0) {
                try {
                    this.f18950C0 = JSON.parseArray(this.f18963J.getStepList(), Integer.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.f18950C0 == null) {
                this.f18950C0 = new ArrayList();
            }
            for (Integer num : this.f18950C0) {
                i += num.intValue();
            }
            this.f18998z = JsonParse.jsonToListMap(this.f18963J.getUserPassPointList());
            this.f18992t.setText(String.valueOf(i));
            this.f18946A0 = i;
            this.f18948B0 = i;
            if (!TextUtils.isEmpty(this.f18963J.getFaceDetectCount())) {
                this.f18953E = Integer.parseInt(this.f18963J.getFaceDetectCount());
            }
            m40231u2();
            return null;
        }
        m40228v2();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F2 */
    public /* synthetic */ void m40353F2() {
        startActivity(new Intent(this.f1669h, RunSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G2 */
    public /* synthetic */ void m40350G2() {
        m40296Y2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H2 */
    public /* synthetic */ void m40347H2() {
        m40237s2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I2 */
    public /* synthetic */ void m40344I2() {
        m40296Y2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J2 */
    public /* synthetic */ void m40341J2() {
        m40237s2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K2 */
    public static /* synthetic */ Unit m40338K2() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L2 */
    public /* synthetic */ void m40335L2(String str, View view) {
        m40278e3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M2 */
    public /* synthetic */ void m40332M2(MotionEvent motionEvent) {
        this.f18975T = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N2 */
    public /* synthetic */ boolean m40329N2(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            m40362C2();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O2 */
    public /* synthetic */ void m40326O2(int i, int i2, Intent intent) {
        if (i2 == -1) {
            this.f18959H = true;
            m40237s2(i);
        } else if (i2 == 170) {
            m40281d3(i);
        } else {
            m40296Y2(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P2 */
    public /* synthetic */ Unit m40323P2(final int i) {
        new StartActivityForResult(this.f1670i).startActivityForResult(new Intent(this.f1669h, FaceDetectExpActivity.class).putExtra("identify", this.f18949C.getIdentify())).m3460c(new StartActivityForResult.InterfaceC15293a() { // from class: com.bxkj.student.run.app.k
            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public final void mo3459a(int i2, Intent intent) {
                RunningActivity.this.m40326O2(i, i2, intent);
            }
        });
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* renamed from: Q2 */
    private void m40320Q2() {
        this.f18967L = new C5193e(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RunBroadcastActionType.GET_FIRST_LOCATION_SUCCESS);
        intentFilter.addAction(RunBroadcastActionType.ADD_START_POINT);
        intentFilter.addAction(RunBroadcastActionType.ADD_OLD_LINE);
        intentFilter.addAction(RunBroadcastActionType.ADD_LINE);
        intentFilter.addAction(RunBroadcastActionType.SAVE_LOCAL_DB);
        intentFilter.addAction(RunBroadcastActionType.TIME_CHANGE);
        intentFilter.addAction(RunBroadcastActionType.UPDATE_GPS_STATUS);
        intentFilter.addAction(RunBroadcastActionType.UPDATE_STEP);
        intentFilter.addAction(RunBroadcastActionType.CURRENT_LATLNG);
        registerReceiver(this.f18967L, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R2 */
    public void m40317R2() {
        this.f18963J.setDistance(String.valueOf(this.f18979X));
        this.f18963J.setCountTime(String.valueOf(this.f18978W));
        this.f18963J.setStartTime(String.valueOf(this.f18976U));
        this.f18963J.setLatLngList(JSON.toJSONString(this.f18980Y));
        this.f18963J.setPassLatLngList(JSON.toJSONString(this.f18997y));
        this.f18963J.setUserPassPointList(JSON.toJSONString(this.f18998z));
        this.f18963J.setStepList(JSON.toJSONString(m40234t2()));
        this.f18963J.setFaceOut(this.f18957G ? "0" : "1");
        this.f18963J.setFaceDetectCount(String.valueOf(this.f18953E));
        this.f18973R.m39500y(this.f18963J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S2 */
    public void m40314S2(int uploadType, final String stepNumbers) {
        m40240r2();
        this.f18963J.setUploadType(String.valueOf(uploadType));
        this.f18973R.m39507B(this.f18963J, new InterfaceC15269a() { // from class: com.bxkj.student.run.app.i
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m40338K2;
                m40338K2 = RunningActivity.m40338K2();
                return m40338K2;
            }
        });
        iOSOneButtonDialog message = new iOSOneButtonDialog(this.f1669h).setMessage("提交异常，已为您暂存本地，请稍后在本地跑步记录中重新上传！");
        message.setCancelable(false);
        message.setCanceledOnTouchOutside(false);
        message.show();
        message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunningActivity.this.m40335L2(stepNumbers, view);
            }
        });
    }

    /* renamed from: T2 */
    private void m40311T2(boolean isPause) {
        this.f18964J0 = isPause;
        m40302W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U2 */
    public void m40308U2(boolean isPause) {
        this.f18962I0 = isPause;
        m40302W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W2 */
    public void m40302W2() {
        boolean z = this.f18962I0 || this.f18964J0 || this.f18966K0;
        this.f18981Z = z;
        m40305V2(z);
    }

    /* renamed from: X2 */
    private void m40299X2() {
        this.f18996x = LatLngBounds.builder();
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.location_marker));
        myLocationStyle.strokeColor(ViewCompat.MEASURED_STATE_MASK);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        myLocationStyle.myLocationType(6);
        this.f18983l.setMyLocationStyle(myLocationStyle);
        this.f18983l.getUiSettings().setMyLocationButtonEnabled(true);
        this.f18983l.setMyLocationEnabled(true);
        this.f18983l.moveCamera(CameraUpdateFactory.zoomTo(18.0f));
        this.f18983l.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
        this.f18983l.setOnMapTouchListener(new AMap.OnMapTouchListener() { // from class: com.bxkj.student.run.app.f
            @Override // com.amap.api.maps.AMap.OnMapTouchListener
            public final void onTouch(MotionEvent motionEvent) {
                RunningActivity.this.m40332M2(motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y2 */
    public void m40296Y2(boolean isPause) {
        this.f18966K0 = isPause;
        m40302W2();
    }

    /* renamed from: Z2 */
    private void m40293Z2() {
        m40320Q2();
        if (C3919y.m44006a(this.f1669h, LocationService.class.getName())) {
            C11792j.m20470c("LocationService---isRunning");
            stopService(new Intent(this.f1669h, LocationService.class));
        }
        Intent intent = new Intent(this, LocationService.class);
        intent.putExtra("runType", this.f18949C.getRunType());
        intent.putExtra("runExceptionDataDB", this.f18963J);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a3 */
    public void m40290a3() {
        if (C3919y.m44006a(this.f1669h, StepService.class.getName())) {
            C11792j.m20470c("LocationService---isRunning");
            stopService(new Intent(this.f1669h, StepService.class));
        }
        Intent intent = new Intent(this, StepService.class);
        intent.putExtra("runType", this.f18949C.getRunType());
        intent.putExtra("isPause", this.f18981Z);
        intent.putExtra("runExceptionDataDB", this.f18963J);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c3 */
    public void m40284c3(boolean isIn) {
        if (this.f18974S == null) {
            this.f18974S = new iOSOneButtonDialog(this.f1669h);
        }
        if (isIn && this.f18958G0.booleanValue()) {
            if (this.f18962I0) {
                String str = "跑步已暂停，请在" + Double.valueOf(this.f18949C.getFaceDistanceOut() * 1000.0d).intValue() + "米范围内进行人脸识别！";
                this.f18974S.setMessage(str).show();
                Intent intent = new Intent();
                intent.setAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
                intent.putExtra("message", str);
                sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            } else {
                Intent intent2 = new Intent();
                intent2.setAction(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION);
                sendBroadcast(intent2, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            }
            m40311T2(false);
            SoundManagerUtil.m39512g(this.f1669h, C4215R.raw.geofence_in);
            C11792j.m20470c("ActionStatus=在地理围栏里面");
            if (this.f18974S.isShowing()) {
                this.f18974S.dismiss();
            } else {
                this.f18974S.setMessage("您已进入跑步规定区域，跑步已恢复，请继续进行跑步！").show();
            }
        } else if (!isIn) {
            if (this.f18974S.isShowing()) {
                this.f18974S.dismiss();
            }
            C11792j.m20470c("ActionStatus=在地理围栏外面");
            m40311T2(true);
            SoundManagerUtil.m39512g(this.f1669h, C4215R.raw.geofence_out);
            ((Vibrator) getSystemService("vibrator")).vibrate(2000L);
            String str2 = "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！";
            if (this.f18962I0) {
                str2 = "跑步已暂停，请在" + Double.valueOf(this.f18949C.getFaceDistanceOut() * 1000.0d).intValue() + "米范围内进行人脸识别！\n您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！";
            }
            this.f18974S.setMessage(str2).show();
            Intent intent3 = new Intent();
            intent3.setAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
            intent3.putExtra("message", str2);
            sendBroadcast(intent3, "com.bxkj.student.sports.permissions.MY_BROADCAST");
        }
        this.f18958G0 = Boolean.valueOf(!isIn);
    }

    /* renamed from: d3 */
    private void m40281d3(final int uploadType) {
        PermissionExt.m43841c(this.f1670i, "人脸识别", new InterfaceC15269a() { // from class: com.bxkj.student.run.app.h
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m40323P2;
                m40323P2 = RunningActivity.this.m40323P2(uploadType);
                return m40323P2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e3 */
    public void m40278e3(String stepNumbers) {
        StartRunActivity startRunActivity = (StartRunActivity) AppManager.m57776n().getActivity(StartRunActivity.class);
        if (startRunActivity != null) {
            startRunActivity.m40151p1();
        }
        RunRecorderListActivity runRecorderListActivity = (RunRecorderListActivity) AppManager.m57776n().getActivity(RunRecorderListActivity.class);
        if (runRecorderListActivity != null) {
            runRecorderListActivity.m39841K0();
        }
        finish();
    }

    /* renamed from: f3 */
    private void m40275f3() {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.STOP_LOCATION);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* renamed from: g3 */
    private void m40272g3(int uploadType) {
        m40296Y2(true);
        m40317R2();
        this.f18977V = System.currentTimeMillis();
        String jSONString = JSON.toJSONString(m40234t2());
        LoadingDialog loadingDialog = new LoadingDialog(this.f1669h);
        loadingDialog.setOnKeyListener(new DialogOnKeyListener(loadingDialog, false));
        String charSequence = this.f18987p.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = FormatUtils.m39630g(this.f18978W);
        }
        String str = charSequence;
        String charSequence2 = this.f18989q.getText().toString();
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = FormatUtils.m39633d(this.f18979X);
        }
        String str2 = charSequence2;
        String charSequence3 = this.f18990r.getText().toString();
        if (TextUtils.isEmpty(charSequence3)) {
            charSequence3 = FormatUtils.m39636a(this.f18979X, this.f18978W);
        }
        String str3 = charSequence3;
        String charSequence4 = this.f18991s.getText().toString();
        if (TextUtils.isEmpty(charSequence4)) {
            charSequence4 = FormatUtils.m39635b(this.f18979X, this.f18978W);
        }
        String str4 = charSequence4;
        try {
            List<LatLngTimeSpeed> list = this.f18980Y;
            if (list != null && list.size() > 2) {
                this.f18980Y = new PathSmoothTool().m39580k(this.f18980Y);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Http.with(this.f1669h).hideLoadingDialog().setCanCancel(false).hideFailMessage().hideOtherStatusMessage().hideSuccessMessage().setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40104q(LoginUser.getLoginUser().getUserId(), this.f18949C.getRunType(), this.f18976U, this.f18977V, JSON.toJSONString(this.f18980Y), this.f18949C.getIdentify(), str, str2, str3, str4, JSON.toJSONString(this.f18997y), SystemUtils.m44002d(), SystemUtils.m44001e(), SystemUtils.m44000f(), SystemUtils.m44003c(), SystemUtils.m43998h(this.f1669h), jSONString, this.f18957G ? "0" : "1", JSON.toJSONString(this.f18998z), Integer.valueOf(uploadType), null)).setDataListener(new C5192d(loadingDialog, uploadType, jSONString));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l2 */
    public void m40258l2() {
        List<RunRoleSetBean.DataBean.GeofenceBean> list;
        if (this.f18949C.getGeofence() == null || this.f18949C.getGeofence().isEmpty()) {
            return;
        }
        GeoFenceClient geoFenceClient = new GeoFenceClient(StubApp.getOrigApplicationContext(getApplicationContext()));
        this.f18971P = geoFenceClient;
        geoFenceClient.setActivateAction(3);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f18949C.getGeofence().size() && (list = this.f18949C.getGeofence().get(i)) != null; i++) {
            ArrayList arrayList2 = new ArrayList();
            for (RunRoleSetBean.DataBean.GeofenceBean geofenceBean : list) {
                arrayList2.add(new DPoint(Double.parseDouble(geofenceBean.getLat()), Double.parseDouble(geofenceBean.getLng())));
            }
            arrayList.add(arrayList2);
            String str = "runGeoFenceId" + i;
            this.f18954E0.put(str, Boolean.TRUE);
            this.f18971P.addGeoFence(arrayList2, str);
        }
        m40243q2(arrayList);
        this.f18971P.setGeoFenceListener(new GeoFenceListener() { // from class: com.bxkj.student.run.app.e
            @Override // com.amap.api.fence.GeoFenceListener
            public final void onGeoFenceCreateFinished(List list2, int i2, String str2) {
                RunningActivity.m40222x2(list2, i2, str2);
            }
        });
        this.f18971P.createPendingIntent(f18944M0);
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(f18944M0);
        this.f18972Q = registerReceiver(this.f18956F0, intentFilter);
    }

    /* renamed from: m2 */
    private void m40255m2() {
        BitmapDescriptor fromResource;
        String str;
        List<Map<String, Object>> list = this.f18997y;
        if (list == null || list.size() == 0) {
            return;
        }
        GeoFenceClient geoFenceClient = new GeoFenceClient(StubApp.getOrigApplicationContext(getApplicationContext()));
        this.f18970O = geoFenceClient;
        geoFenceClient.setActivateAction(1);
        for (Map<String, ? extends Object> map : this.f18997y) {
            double d = JsonParse.getDouble(map, "latitude");
            double d2 = JsonParse.getDouble(map, "longitude");
            int i = JsonParse.getInt(map, "isMustPoint");
            LatLng latLng = new LatLng(d, d2);
            if (m40249o2(map)) {
                this.f18983l.addMarker(new MarkerOptions().position(new LatLng(d, d2)).icon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.img_point_must_pass)).zIndex(9.0f).title("你已经通过必经点:" + JsonGet.f15134a.m43760t(map, "content")).draggable(false));
            } else {
                if (i == 1) {
                    fromResource = BitmapDescriptorFactory.fromResource(C4215R.mipmap.img_point_must_normal);
                    str = "必经点：";
                } else {
                    fromResource = BitmapDescriptorFactory.fromResource(C4215R.mipmap.xjd_location);
                    str = "选经点：";
                }
                String string = JsonParse.getString(map, "content");
                Marker addMarker = this.f18983l.addMarker(new MarkerOptions().position(latLng).icon(fromResource).zIndex(9.0f).title(str + string).draggable(false));
                String str2 = JsonParse.getString(map, "id") + "," + i;
                addMarker.setObject(str2);
                this.f18969N.add(addMarker);
                this.f18970O.addGeoFence(new DPoint(d, d2), JsonParse.getInt(map, "okRadius"), str2);
                this.f18968M.include(latLng);
            }
        }
        this.f18983l.animateCamera(CameraUpdateFactory.newLatLngBounds(this.f18968M.build(), Tools.m57620a(10.0f, this.f1669h)), 2000L, null);
        this.f18970O.setGeoFenceListener(new GeoFenceListener() { // from class: com.bxkj.student.run.app.d
            @Override // com.amap.api.fence.GeoFenceListener
            public final void onGeoFenceCreateFinished(List list2, int i2, String str3) {
                RunningActivity.m40219y2(list2, i2, str3);
            }
        });
        this.f18970O.createPendingIntent(f18943L0);
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(f18943L0);
        this.f18945A = registerReceiver(this.f18952D0, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n2 */
    public void m40252n2(LatLng startLatLng) {
        this.f18983l.addMarker(new MarkerOptions().position(startLatLng).icon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.ic_marker_start)).zIndex(9.0f).draggable(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o2 */
    public boolean m40249o2(Map<String, Object> stringObjectMap) {
        double d = JsonParse.getDouble(stringObjectMap, "latitude");
        double d2 = JsonParse.getDouble(stringObjectMap, "longitude");
        boolean z = false;
        for (Map<String, Object> map : this.f18998z) {
            double d3 = JsonParse.getDouble(map, "latitude");
            double d4 = JsonParse.getDouble(map, "longitude");
            if (d3 == d && d4 == d2) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: q2 */
    private void m40243q2(List<List<DPoint>> pointList) {
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
                polygonOptions.fillColor(this.f1669h.getResources().getColor(C4215R.C4217color.fill));
                polygonOptions.strokeColor(this.f1669h.getResources().getColor(C4215R.C4217color.stroke));
                polygonOptions.strokeWidth(4.0f);
                this.f18983l.addPolygon(polygonOptions);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r2 */
    public void m40240r2() {
        this.f18983l.getMyLocationStyle().myLocationType(7);
        m40275f3();
        this.f18977V = System.currentTimeMillis();
        List<LatLngTimeSpeed> list = this.f18980Y;
        if (list != null && list.size() > 0) {
            BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(C4215R.mipmap.ic_marker_end);
            C11792j.m20470c("latLngList=" + this.f18980Y.size());
            List<LatLngTimeSpeed> list2 = this.f18980Y;
            LatLngTimeSpeed latLngTimeSpeed = list2.get(list2.size() - 1);
            this.f18983l.addMarker(new MarkerOptions().position(new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude())).icon(fromResource).zIndex(9.0f).draggable(true));
        }
        this.f18983l.animateCamera(CameraUpdateFactory.newLatLngBounds(this.f18996x.build(), Tools.m57620a(50.0f, this.f1669h)), 2000L, null);
    }

    /* renamed from: s2 */
    private void m40237s2(int uploadType) {
        if (this.f18949C.getRunType() == 4) {
            m40272g3(uploadType);
        } else if (this.f18998z.size() < this.f18997y.size()) {
            m40296Y2(false);
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1669h);
            iosonebuttondialog.setMessage("必须经过" + this.f18997y.size() + "个必经点").show();
        } else if (this.f18949C.getIsEndFace() > 0 && !this.f18959H) {
            m40281d3(uploadType);
        } else {
            m40272g3(uploadType);
        }
    }

    /* renamed from: u1 */
    static /* synthetic */ int m40232u1(RunningActivity runningActivity) {
        int i = runningActivity.f18953E;
        runningActivity.f18953E = i + 1;
        return i;
    }

    /* renamed from: u2 */
    private void m40231u2() {
        try {
            if (C3919y.m44006a(this.f1669h, LocationService.class.getName())) {
                C11792j.m20470c("LocationService----------isServiceRunning");
                stopService(new Intent(this.f1669h, LocationService.class));
            }
            if (C3919y.m44006a(this.f1669h, StepService.class.getName())) {
                C11792j.m20470c("StepService----------isServiceRunning");
                stopService(new Intent(this.f1669h, StepService.class));
            }
            m40299X2();
            m40225w2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: v2 */
    private void m40228v2() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        if (C3919y.m44006a(this.f1669h, LocationService.class.getName())) {
            C11792j.m20470c("LocationService----------isServiceRunning");
            stopService(new Intent(this.f1669h, LocationService.class));
        }
        if (C3919y.m44006a(this.f1669h, StepService.class.getName())) {
            C11792j.m20470c("LocationService----------isServiceRunning");
            stopService(new Intent(this.f1669h, StepService.class));
        }
        finish();
    }

    /* renamed from: w2 */
    private void m40225w2() {
        if (this.f18949C == null) {
            m40228v2();
        }
        for (Map<String, Object> map : JsonParse.getList((ArrayMap) JSON.parseObject(JSON.toJSONString(this.f18949C), new C5189a().getType(), new Feature[0]), "list")) {
            if (JsonParse.getInt(map, "isMustPoint") == 1) {
                this.f18997y.add(map);
            }
        }
        this.f18947B = this.f18949C.getSurplusNum();
        if (this.f18949C.getIsClock() > 0) {
            this.f18995w.setVisibility(0);
        }
        this.f18951D = this.f18949C.getMiddleFaces();
        if (!this.f18949C.getContext().isEmpty()) {
            this.f18986o.setVisibility(0);
            this.f18986o.setText(this.f18949C.getContext());
        }
        this.f18968M = LatLngBounds.builder();
        m40293Z2();
        m40255m2();
        m40287b3("GPS信号弱或位置精确度较低,请在室外空旷的地方进行跑步,否则将可能影响您的跑步轨迹记录不准确。如果长时间不能定位，请重启手机后重试！");
        if (TextUtils.isEmpty(this.f18949C.getContext())) {
            return;
        }
        new iOSOneButtonDialog(this.f1669h).setMessageGrivity(3).setMessage(this.f18949C.getContext()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x2 */
    public static /* synthetic */ void m40222x2(List list, int i, String str) {
        if (i == 0) {
            C11792j.m20470c("添加跑步范围围栏成功!!");
        } else {
            C11792j.m20470c("添加跑步范围围栏失败!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y2 */
    public static /* synthetic */ void m40219y2(List list, int i, String str) {
        if (i == 0) {
            C11792j.m20470c("添加围栏成功!!");
        } else {
            C11792j.m20470c("添加围栏失败!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z2 */
    public /* synthetic */ void m40216z2() {
        m40296Y2(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18994v.setOnFinishListener(new LongPressToFinishButton.OnFinishListener() { // from class: com.bxkj.student.run.app.g
            @Override // com.bxkj.student.common.view.LongPressToFinishButton.OnFinishListener
            public final void onFinish() {
                RunningActivity.this.m40365B2();
            }
        });
        m57927Z(new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.run.app.n
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                RunningActivity.this.m40362C2();
            }
        });
        this.f18995w.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunningActivity.this.m40359D2(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_run;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18965K = new CpuWakeLock();
        if (getIntent().hasExtra("runExceptionDataDBId")) {
            String stringExtra = getIntent().getStringExtra("runExceptionDataDBId");
            if (TextUtils.isEmpty(stringExtra)) {
                m40228v2();
            } else {
                this.f18973R.m39503v(stringExtra, new InterfaceC15280l() { // from class: com.bxkj.student.run.app.j
                    @Override // p617l1.InterfaceC15280l
                    public final Object invoke(Object obj) {
                        Unit m40356E2;
                        m40356E2 = RunningActivity.this.m40356E2((List) obj);
                        return m40356E2;
                    }
                });
            }
        } else if (getIntent().hasExtra("dataBean")) {
            RunRoleSetBean.DataBean dataBean = (RunRoleSetBean.DataBean) getIntent().getParcelableExtra("dataBean");
            this.f18949C = dataBean;
            if (dataBean != null && !TextUtils.isEmpty(dataBean.getIdentify())) {
                long currentTimeMillis = System.currentTimeMillis();
                if (getIntent().hasExtra(AnalyticsConfig.RTD_START_TIME)) {
                    currentTimeMillis = getIntent().getLongExtra(AnalyticsConfig.RTD_START_TIME, System.currentTimeMillis());
                    C11792j.m20470c("跑步开始时间=" + FormatUtils.m39629h(currentTimeMillis, null));
                }
                RunDb runDb = new RunDb(this.f18949C.getIdentify(), LoginUser.getLoginUser().getAccount(), String.valueOf(this.f18949C.getRunType()), JSON.toJSONString(this.f18949C), String.valueOf(currentTimeMillis), "", "0", "0", "", "", "", "", "0", "0", "-1");
                this.f18963J = runDb;
                this.f18973R.m39500y(runDb);
                m40231u2();
                return;
            }
            m40228v2();
        } else {
            m40228v2();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("跑步中");
        m57925b0(2131558983, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.run.app.o
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                RunningActivity.this.m40353F2();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        try {
            this.f1669h = this;
            MapView mapView = (MapView) findViewById(C4215R.C4219id.map);
            this.f18982k = mapView;
            mapView.onCreate(savedInstanceState);
            this.f18983l = this.f18982k.getMap();
            this.f18984m = (ImageView) findViewById(C4215R.C4219id.iv_gps_state);
            this.f18985n = (TextView) findViewById(C4215R.C4219id.tv_gps_tips);
            this.f18987p = (TextView) findViewById(2131233198);
            this.f18989q = (TextView) findViewById(2131232941);
            this.f18990r = (TextView) findViewById(C4215R.C4219id.tv_speed);
            this.f18991s = (TextView) findViewById(C4215R.C4219id.tv_peisu);
            LinearLayout linearLayout = (LinearLayout) findViewById(2131232167);
            this.f18993u = linearLayout;
            linearLayout.setVisibility(4);
            this.f18994v = (LongPressToFinishButton) findViewById(C4215R.C4219id.bt_stop);
            this.f18995w = (Button) findViewById(C4215R.C4219id.bt_card);
            this.f18986o = (MarqueeTextView) findViewById(2131232939);
            this.f18992t = (TextView) findViewById(2131233170);
            if (savedInstanceState != null && savedInstanceState.containsKey("runExceptionDataDBId")) {
                getIntent().putExtra("runExceptionDataDBId", savedInstanceState.getString("runExceptionDataDBId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f18973R = (RunVM) new ViewModelProvider(this).get(RunVM.class);
    }

    /* renamed from: V2 */
    public void m40305V2(boolean isPause) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.SET_RUNNING_PAUSE);
        intent.putExtra("isPause", isPause);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* renamed from: b3 */
    public void m40287b3(String str) {
        if (this.f18960H0 == null) {
            this.f18960H0 = new ProgressDialog(this);
        }
        this.f18960H0.setMessage(str);
        this.f18960H0.setCanceledOnTouchOutside(false);
        this.f18960H0.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.run.app.b
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean m40329N2;
                m40329N2 = RunningActivity.this.m40329N2(dialogInterface, i, keyEvent);
                return m40329N2;
            }
        });
        this.f18960H0.show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void m40362C2() {
        try {
            m40296Y2(true);
            iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
            iostwobuttondialog.setCancelable(false);
            if (this.f18949C.getRunType() == 3) {
                iostwobuttondialog.setTitle("提示").setMessage("确定要取消本次跑步吗？").setLeftButtonText("继续跑步").setRightButtonText("确定取消").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.p
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        RunningActivity.this.m40350G2();
                    }
                }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.t
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        RunningActivity.this.m40347H2();
                    }
                }).show();
            } else {
                iOSTwoButtonDialog title = iostwobuttondialog.setTitle("确定要取消本次跑步吗？");
                title.setMessage("今天剩余可跑步次数" + this.f18947B + "次").setLeftButtonText("继续跑步").setRightButtonText("确定取消").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.q
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        RunningActivity.this.m40344I2();
                    }
                }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.s
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        RunningActivity.this.m40341J2();
                    }
                }).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            ProgressDialog progressDialog = this.f18960H0;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f18960H0.dismiss();
            }
            this.f18982k.onDestroy();
            GeoFenceClient geoFenceClient = this.f18970O;
            if (geoFenceClient != null) {
                geoFenceClient.removeGeoFence();
            }
            if (this.f18945A != null) {
                unregisterReceiver(this.f18952D0);
            }
            GeoFenceClient geoFenceClient2 = this.f18971P;
            if (geoFenceClient2 != null) {
                geoFenceClient2.removeGeoFence();
            }
            if (this.f18972Q != null) {
                unregisterReceiver(this.f18956F0);
            }
            C5193e c5193e = this.f18967L;
            if (c5193e != null) {
                unregisterReceiver(c5193e);
            }
            if (C3919y.m44006a(this.f1669h, LocationService.class.getName())) {
                C11792j.m20470c("stopService(new Intent(mContext, LocationService.class))");
                stopService(new Intent(this.f1669h, LocationService.class));
            }
            if (C3919y.m44006a(this.f1669h, StepService.class.getName())) {
                C11792j.m20470c("stopService(new Intent(mContext, StepService.class))");
                stopService(new Intent(this.f1669h, StepService.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.f18965K.m39641c();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            this.f18965K.m39642b(this);
            LatLng latLng = this.f18988p0;
            if (latLng != null) {
                this.f18983l.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng, 18.0f)), 1000L, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        this.f18982k.onSaveInstanceState(outState);
        RunDb runDb = this.f18963J;
        if (runDb != null) {
            outState.putString("runExceptionDataDBId", runDb.getIdentify());
        }
        super.onSaveInstanceState(outState);
    }

    /* renamed from: p2 */
    public String m40246p2(long size) {
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

    /* renamed from: t2 */
    public List<Integer> m40234t2() {
        long j = this.f18978W;
        long j2 = (j / 60) + (j % 60 == 0 ? 0 : 1);
        ArrayList arrayList = new ArrayList(this.f18950C0);
        int i = this.f18946A0;
        int i2 = i - this.f18948B0;
        if (i < 0) {
            this.f18946A0 = 0;
        }
        if (arrayList.size() < j2) {
            arrayList.add(Integer.valueOf(i2));
        } else if (arrayList.size() == 0) {
            arrayList.add(Integer.valueOf(i2));
        } else {
            arrayList.set(arrayList.size() - 1, Integer.valueOf(((Integer) arrayList.get(arrayList.size() - 1)).intValue() + i2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bxkj.student.run.app.RunningActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5193e extends BroadcastReceiver {

        /* renamed from: a */
        private PolylineOptions f19006a;

        /* renamed from: b */
        private Polyline f19007b;

        /* renamed from: c */
        private List<Integer> f19008c;

        /* renamed from: d */
        private PolylineOptions f19009d;

        /* renamed from: e */
        private Polyline f19010e;

        /* renamed from: f */
        List<Polyline> f19011f;

        private C5193e() {
            this.f19006a = new PolylineOptions();
            this.f19008c = new ArrayList();
            this.f19009d = new PolylineOptions();
            this.f19011f = new ArrayList();
        }

        /* renamed from: d */
        private void m40211d(double distance, LatLng latLng) {
            if (RunningActivity.this.f18951D != null && RunningActivity.this.f18953E < RunningActivity.this.f18951D.size() && !RunningActivity.this.f18962I0 && distance >= ((Double) RunningActivity.this.f18951D.get(RunningActivity.this.f18953E)).doubleValue()) {
                RunningActivity.this.f18955F = latLng;
                ((Vibrator) RunningActivity.this.getSystemService("vibrator")).vibrate(2000L);
                RunningActivity.this.m40308U2(true);
                SoundManagerUtil.m39512g(((BaseActivity) RunningActivity.this).f1669h, C4215R.raw.run_pause_face_live);
                if (RunningActivity.this.f18961I == null) {
                    RunningActivity.this.f18961I = new iOSOneButtonDialog(((BaseActivity) RunningActivity.this).f1669h);
                } else {
                    RunningActivity.this.f18961I.dismiss();
                }
                RunningActivity.this.f18961I.setClickAutoCancel(false);
                RunningActivity.this.f18961I.setCancelable(false);
                RunningActivity.this.f18961I.setCanceledOnTouchOutside(false);
                String str = "跑步已暂停，请在" + Double.valueOf(RunningActivity.this.f18949C.getFaceDistanceOut() * 1000.0d).intValue() + "米范围内进行人脸识别！";
                Intent intent = new Intent();
                intent.setAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
                intent.putExtra("message", str);
                RunningActivity.this.sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
                RunningActivity.this.f18961I.setMessage(str).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunningActivity.C5193e.this.m40205j(view);
                    }
                });
                RunningActivity.this.f18961I.show();
            }
        }

        /* renamed from: e */
        private void m40210e(List<LatLng> latLngs) {
            this.f19011f.add(RunningActivity.this.f18983l.addPolyline(new PolylineOptions().addAll(latLngs).width(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)).setDottedLine(true).color(ContextCompat.getColor(((BaseActivity) RunningActivity.this).f1669h, 2131034173)).zIndex(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h))));
        }

        /* renamed from: f */
        private void m40209f(LatLng newLatLng, LatLng lastLatLng, float speed, boolean isPause) {
            if (isPause) {
                Polyline polyline = this.f19010e;
                if (polyline == null) {
                    this.f19006a = null;
                    this.f19007b = null;
                    this.f19008c = new ArrayList();
                    this.f19009d = new PolylineOptions();
                    this.f19010e = RunningActivity.this.f18983l.addPolyline(this.f19009d.add(lastLatLng, newLatLng).width(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)).setDottedLine(true).color(ContextCompat.getColor(((BaseActivity) RunningActivity.this).f1669h, 2131034173)).zIndex(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)));
                    return;
                }
                polyline.setOptions(this.f19009d.add(newLatLng).width(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)).setDottedLine(true).color(ContextCompat.getColor(((BaseActivity) RunningActivity.this).f1669h, 2131034173)).zIndex(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)));
                return;
            }
            this.f19008c.add(Integer.valueOf(FormatUtils.m39619r(((BaseActivity) RunningActivity.this).f1669h, speed)));
            Polyline polyline2 = this.f19007b;
            if (polyline2 == null) {
                this.f19009d = null;
                this.f19010e = null;
                this.f19006a = new PolylineOptions();
                this.f19007b = RunningActivity.this.f18983l.addPolyline(this.f19006a.add(lastLatLng, newLatLng).width(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)).colorValues(this.f19008c).zIndex(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)));
                return;
            }
            polyline2.setOptions(this.f19006a.add(newLatLng).width(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)).colorValues(this.f19008c).useGradient(true).zIndex(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)).color(FormatUtils.m39619r(((BaseActivity) RunningActivity.this).f1669h, speed)));
        }

        /* renamed from: g */
        private void m40208g(List<LatLng> latLngs, boolean isPause, List<Integer> colorValues) {
            C11792j.m20470c("画线");
            if (isPause) {
                m40210e(latLngs);
            } else {
                m40207h(latLngs, colorValues);
            }
        }

        /* renamed from: h */
        private void m40207h(List<LatLng> latLngs, List<Integer> colorValues) {
            this.f19011f.add(RunningActivity.this.f18983l.addPolyline(new PolylineOptions().addAll(latLngs).width(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)).colorValues(colorValues).useGradient(true).zIndex(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h))));
        }

        /* renamed from: i */
        private void m40206i(LatLng startLatLng) {
            if (RunningActivity.this.isFinishing() || RunningActivity.this.isDestroyed()) {
                return;
            }
            if (RunningActivity.this.f18960H0 != null && RunningActivity.this.f18960H0.isShowing()) {
                RunningActivity.this.f18960H0.dismiss();
            }
            if (RunningActivity.this.f18993u.getVisibility() != 0) {
                RunningActivity.this.f18993u.setVisibility(0);
            }
            RunningActivity.this.m40290a3();
            RunningActivity.this.m40252n2(startLatLng);
            RunningActivity.this.m40258l2();
            this.f19008c.add(Integer.valueOf(ContextCompat.getColor(((BaseActivity) RunningActivity.this).f1669h, C4215R.C4217color.speed1)));
            try {
                if (this.f19006a == null) {
                    this.f19006a = new PolylineOptions();
                }
                this.f19007b = RunningActivity.this.f18983l.addPolyline(this.f19006a.add(startLatLng).width(Tools.m57620a(5.0f, ((BaseActivity) RunningActivity.this).f1669h)).colorValues(this.f19008c).useGradient(false).zIndex(10.0f));
            } catch (Exception e) {
                e.printStackTrace();
            }
            RunningActivity.this.f18996x.include(startLatLng).build();
            RunningActivity.this.f18983l.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(startLatLng, 18.0f)), 1000L, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j */
        public /* synthetic */ void m40205j(View view) {
            m40201n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: k */
        public /* synthetic */ void m40204k(int i, Intent intent) {
            if (i != -1) {
                if (i == 170) {
                    m40201n();
                    return;
                } else {
                    RunningActivity.this.m40302W2();
                    return;
                }
            }
            if (RunningActivity.this.f18961I != null && RunningActivity.this.f18961I.isShowing()) {
                RunningActivity.this.f18961I.dismiss();
            }
            RunningActivity.m40232u1(RunningActivity.this);
            SoundManagerUtil.m39512g(((BaseActivity) RunningActivity.this).f1669h, C4215R.raw.face_live_success_run_continue);
            new iOSOneButtonDialog(((BaseActivity) RunningActivity.this).f1669h).setMessage("人脸识别成功，请继续跑步").show();
            if (RunningActivity.this.f18964J0) {
                RunningActivity.this.f18974S.setMessage("您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！").show();
                Intent intent2 = new Intent();
                intent2.setAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
                intent2.putExtra("message", "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！");
                RunningActivity.this.sendBroadcast(intent2, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            } else {
                Intent intent3 = new Intent();
                intent3.setAction(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION);
                RunningActivity.this.sendBroadcast(intent3, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            }
            RunningActivity.this.m40308U2(false);
            if (RunningActivity.this.f18949C.getFaceDistanceOut() != Utils.DOUBLE_EPSILON && AMapUtils.calculateLineDistance(RunningActivity.this.f18988p0, RunningActivity.this.f18955F) > RunningActivity.this.f18949C.getFaceDistanceOut() * 1000.0d) {
                RunningActivity.this.f18957G = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ Unit m40203l() {
            Intent intent = RunningActivity.this.getIntent().setClass(((BaseActivity) RunningActivity.this).f1669h, FaceDetectExpActivity.class);
            intent.putExtra("identify", RunningActivity.this.f18949C.getIdentify());
            new StartActivityForResult(((BaseActivity) RunningActivity.this).f1670i).startActivityForResult(intent).m3460c(new StartActivityForResult.InterfaceC15293a() { // from class: com.bxkj.student.run.app.w
                @Override // p618m.StartActivityForResult.InterfaceC15293a
                /* renamed from: a */
                public final void mo3459a(int i, Intent intent2) {
                    RunningActivity.C5193e.this.m40204k(i, intent2);
                }
            });
            RunningActivity.this.overridePendingTransition(2130771987, 2130771986);
            return null;
        }

        /* renamed from: m */
        private void m40202m(long countTime) {
            if (countTime % 60 == 0) {
                long j = countTime / 60;
                int i = RunningActivity.this.f18946A0 - RunningActivity.this.f18948B0;
                if (i < 0) {
                    i = 0;
                }
                if (RunningActivity.this.f18950C0.size() < j) {
                    RunningActivity.this.f18950C0.add(Integer.valueOf(i));
                } else {
                    RunningActivity.this.f18950C0.set(RunningActivity.this.f18950C0.size() - 1, Integer.valueOf(((Integer) RunningActivity.this.f18950C0.get(RunningActivity.this.f18950C0.size() - 1)).intValue() + i));
                }
                RunningActivity runningActivity = RunningActivity.this;
                runningActivity.f18948B0 = runningActivity.f18946A0;
            }
        }

        /* renamed from: n */
        private void m40201n() {
            PermissionExt.m43841c(((BaseActivity) RunningActivity.this).f1670i, "人脸识别", new InterfaceC15269a() { // from class: com.bxkj.student.run.app.v
                @Override // p617l1.InterfaceC15269a
                public final Object invoke() {
                    Unit m40203l;
                    m40203l = RunningActivity.C5193e.this.m40203l();
                    return m40203l;
                }
            });
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunBroadcastActionType.GET_FIRST_LOCATION_SUCCESS)) {
                if (intent.hasExtra("latLng")) {
                    LatLng latLng = (LatLng) intent.getParcelableExtra("latLng");
                    if (RunningActivity.this.f18968M != null) {
                        RunningActivity.this.f18968M.include(latLng);
                    }
                    RunningActivity.this.f18983l.animateCamera(CameraUpdateFactory.newLatLngBounds(RunningActivity.this.f18968M.build(), Tools.m57620a(50.0f, ((BaseActivity) RunningActivity.this).f1669h)), 1000L, null);
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.ADD_START_POINT)) {
                C11792j.m20470c("起始点定位成功");
                if (intent.hasExtra(AnalyticsConfig.RTD_START_TIME)) {
                    RunningActivity.this.f18976U = intent.getLongExtra(AnalyticsConfig.RTD_START_TIME, System.currentTimeMillis());
                }
                if (intent.hasExtra("latLngTimeSpeed")) {
                    RunningActivity.this.f18980Y.add((LatLngTimeSpeed) intent.getParcelableExtra("latLngTimeSpeed"));
                }
                if (intent.hasExtra("latLng")) {
                    m40206i((LatLng) intent.getParcelableExtra("latLng"));
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.ADD_OLD_LINE)) {
                if (intent.hasExtra("countTime")) {
                    RunningActivity.this.f18978W = intent.getLongExtra("countTime", 0L);
                    RunningActivity.this.f18987p.setText(FormatUtils.m39630g(RunningActivity.this.f18978W));
                }
                if (intent.hasExtra("distance")) {
                    RunningActivity.this.f18979X = intent.getFloatExtra("distance", 0.0f);
                    RunningActivity.this.f18989q.setText(FormatUtils.m39633d(RunningActivity.this.f18979X));
                }
                if (intent.hasExtra("avgSpeed")) {
                    RunningActivity.this.f18990r.setText(intent.getStringExtra("avgSpeed"));
                }
                if (intent.hasExtra("pace")) {
                    RunningActivity.this.f18991s.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("latLngTimeSpeedList")) {
                    RunningActivity.this.f18980Y = intent.getParcelableArrayListExtra("latLngTimeSpeedList");
                    for (int i = 1; i < RunningActivity.this.f18980Y.size(); i++) {
                        LatLngTimeSpeed latLngTimeSpeed = (LatLngTimeSpeed) RunningActivity.this.f18980Y.get(i - 1);
                        LatLngTimeSpeed latLngTimeSpeed2 = (LatLngTimeSpeed) RunningActivity.this.f18980Y.get(i);
                        m40209f(new LatLng(latLngTimeSpeed2.getLatitude(), latLngTimeSpeed2.getLongitude()), new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude()), latLngTimeSpeed2.getSpeed(), latLngTimeSpeed2.isPuase());
                    }
                    m40206i(new LatLng(((LatLngTimeSpeed) RunningActivity.this.f18980Y.get(0)).getLatitude(), ((LatLngTimeSpeed) RunningActivity.this.f18980Y.get(0)).getLongitude()));
                    this.f19007b = null;
                    this.f19010e = null;
                }
                if (intent.hasExtra(AnalyticsConfig.RTD_START_TIME)) {
                    RunningActivity.this.f18976U = intent.getLongExtra(AnalyticsConfig.RTD_START_TIME, System.currentTimeMillis());
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.ADD_LINE)) {
                RunningActivity.this.m40317R2();
                if (intent.hasExtra("latLngTimeSpeed")) {
                    RunningActivity.this.f18980Y.add((LatLngTimeSpeed) intent.getParcelableExtra("latLngTimeSpeed"));
                }
                if (intent.hasExtra("distance")) {
                    RunningActivity.this.f18979X = intent.getFloatExtra("distance", 0.0f);
                }
                String m39633d = FormatUtils.m39633d(RunningActivity.this.f18979X);
                RunningActivity.this.f18989q.setText(m39633d);
                if (intent.hasExtra("currentLatLng")) {
                    m40211d(Double.parseDouble(m39633d), (LatLng) intent.getParcelableExtra("currentLatLng"));
                }
                if (intent.hasExtra("avgSpeed")) {
                    RunningActivity.this.f18990r.setText(intent.getStringExtra("avgSpeed"));
                }
                if (intent.hasExtra("pace")) {
                    RunningActivity.this.f18991s.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("currentLatLng") && intent.hasExtra("lastLatLng") && intent.hasExtra("speed") && intent.hasExtra("isPause")) {
                    LatLng latLng2 = (LatLng) intent.getParcelableExtra("currentLatLng");
                    m40209f(latLng2, (LatLng) intent.getParcelableExtra("lastLatLng"), intent.getFloatExtra("speed", 0.0f), intent.getBooleanExtra("isPause", false));
                    RunningActivity.this.f18996x.include(latLng2).build();
                    if (System.currentTimeMillis() - RunningActivity.this.f18975T > 30000) {
                        RunningActivity.this.f18983l.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng2, 18.0f)), 500L, null);
                    }
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.SAVE_LOCAL_DB)) {
                RunningActivity.this.m40317R2();
            } else if (intent.getAction().equals(RunBroadcastActionType.TIME_CHANGE)) {
                if (intent.hasExtra("countTime")) {
                    RunningActivity.this.f18978W = intent.getLongExtra("countTime", 0L);
                    RunningActivity.this.f18987p.setText(FormatUtils.m39630g(RunningActivity.this.f18978W));
                    m40202m(RunningActivity.this.f18978W);
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.UPDATE_GPS_STATUS)) {
                if (intent.hasExtra("gpsStatus") && intent.hasExtra("gpsStatusImage")) {
                    String stringExtra = intent.getStringExtra("gpsStatus");
                    RunningActivity.this.f18984m.setImageResource(intent.getIntExtra("gpsStatusImage", 0));
                    RunningActivity.this.f18985n.setText(stringExtra);
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.UPDATE_STEP)) {
                if (intent.hasExtra("stepCount")) {
                    RunningActivity.this.f18946A0 = intent.getIntExtra("stepCount", 0);
                    RunningActivity.this.f18992t.setText(String.valueOf(RunningActivity.this.f18946A0));
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.CURRENT_LATLNG)) {
                Bundle extras = intent.getExtras();
                if (extras.containsKey("latLng")) {
                    try {
                        RunningActivity.this.f18988p0 = (LatLng) extras.get("latLng");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* synthetic */ C5193e(RunningActivity runningActivity, C5189a c5189a) {
            this();
        }
    }
}
