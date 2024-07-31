package com.bxkj.student.run.app.keep;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.model.MyLocationStyle;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.NewHttpJsonKey;
import com.bxkj.student.run.app.RunApiService;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.umeng.analytics.AnalyticsConfig;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SyncKeepDataActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H\u0002J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0014J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0006\u0010\u0019\u001a\u00020\u0002R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R(\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070#0\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, m12616d2 = {"Lcom/bxkj/student/run/app/keep/SyncKeepDataActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Lkotlin/f1;", "y0", "", "", "", "", "geoPoints", "Lcom/bxkj/student/run/app/location/LatLngTimeSpeed;", "v0", "stepList", "", "u0", "w0", "Landroid/view/View;", "v", "onClick", "U", "P", "Landroid/os/Bundle;", "savedInstanceState", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "N", "z0", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "tv_date", C7304t.f25048d, "bt_sync", "m", "I", "index", "", "n", "Ljava/util/List;", "dataList", "Ljava/text/DateFormat;", "o", "Ljava/text/DateFormat;", "df", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SyncKeepDataActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f19147k;

    /* renamed from: l */
    private TextView f19148l;

    /* renamed from: m */
    private int f19149m;

    /* renamed from: n */
    private List<? extends Map<String, ? extends Object>> f19150n;
    @NotNull

    /* renamed from: o */
    private final DateFormat f19151o = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

    /* compiled from: SyncKeepDataActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/run/app/keep/SyncKeepDataActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.app.keep.SyncKeepDataActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5253a extends HttpCallBack {
        C5253a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@Nullable Map<String, Object> map) {
            List<Map<String, Object>> list = JsonParse.getList(map, "data");
            if (list != null && list.size() > 0) {
                SyncKeepDataActivity.this.f19149m = 0;
                SyncKeepDataActivity.this.f19150n = list;
                SyncKeepDataActivity.this.m40000z0();
                return;
            }
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) SyncKeepDataActivity.this).f1669h);
            StringBuilder sb = new StringBuilder();
            TextView textView = SyncKeepDataActivity.this.f19147k;
            if (textView == null) {
                C14342f0.m8200S("tv_date");
                textView = null;
            }
            sb.append((Object) textView.getText());
            sb.append("当天没有跑步数据");
            iosonebuttondialog.setMessage(sb.toString()).show();
        }
    }

    /* compiled from: SyncKeepDataActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\t"}, m12616d2 = {"com/bxkj/student/run/app/keep/SyncKeepDataActivity$b", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "netOnFinish", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.app.keep.SyncKeepDataActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5254b extends HttpCallBack {
        C5254b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            SyncKeepDataActivity.this.f19149m++;
            SyncKeepDataActivity.this.m40000z0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@Nullable Map<String, Object> map) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public static final void m40008r0(SyncKeepDataActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m40003w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public static final void m40007s0(final SyncKeepDataActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        if (TextUtils.isEmpty(LoginUser.getLoginUser().getKeepToken())) {
            new iOSTwoButtonDialog(this$0.f1669h).setMessage("系统检测到您还未绑定Keep账号,请先绑定Keep账号").setLeftButtonText("暂不绑定").setRightButtonText("去绑定").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.keep.e
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    SyncKeepDataActivity.m40006t0(SyncKeepDataActivity.this);
                }
            }).show();
        } else {
            this$0.m40001y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public static final void m40006t0(SyncKeepDataActivity this$0) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.f1669h.startActivity(new Intent(this$0.f1669h, KeepAuthH5Activity.class));
    }

    /* renamed from: u0 */
    private final List<Integer> m40005u0(List<? extends Map<String, Object>> list) {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 1;
        for (Map<String, Object> map : list) {
            double d = JsonParse.getDouble(map, "currentTotalDuration");
            int i4 = JsonParse.getInt(map, "currentTotalSteps");
            if (d > i3 * 60) {
                int i5 = i4 - i2;
                i2 += i5;
                i3++;
                arrayList.add(Integer.valueOf(i5));
            }
            System.out.println((Object) ("time:" + d + " step:" + i4));
        }
        if ((!list.isEmpty()) && (i = JsonParse.getInt(list.get(list.size() - 1), "currentTotalSteps") - i2) > 0) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    /* renamed from: v0 */
    private final List<LatLngTimeSpeed> m40004v0(List<? extends Map<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            LatLngTimeSpeed latLngTimeSpeed = new LatLngTimeSpeed();
            latLngTimeSpeed.setLatitude(JsonParse.getDouble(map, "latitude"));
            latLngTimeSpeed.setLongitude(JsonParse.getDouble(map, "longitude"));
            latLngTimeSpeed.setLocationType(JsonParse.getInt(map, MyLocationStyle.LOCATION_TYPE));
            latLngTimeSpeed.setSpeed(JsonParse.getFloat(map, "speed"));
            double d = JsonParse.getDouble(map, "currentTotalDuration");
            double d2 = 1000;
            Double.isNaN(d2);
            latLngTimeSpeed.setTime((long) (d * d2));
            latLngTimeSpeed.setPuase(false);
            arrayList.add(latLngTimeSpeed);
        }
        return arrayList;
    }

    /* renamed from: w0 */
    private final void m40003w0() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(new Date());
        new DatePickerDialog(this.f1669h, new DatePickerDialog.OnDateSetListener() { // from class: com.bxkj.student.run.app.keep.b
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                SyncKeepDataActivity.m40002x0(SyncKeepDataActivity.this, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public static final void m40002x0(SyncKeepDataActivity this$0, DatePicker datePicker, int i, int i2, int i3) {
        C14342f0.m8184p(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('-');
        sb.append(i2 + 1);
        sb.append('-');
        sb.append(i3);
        String sb2 = sb.toString();
        try {
            DateFormat dateFormat = this$0.f19151o;
            String format = dateFormat.format(dateFormat.parse(sb2));
            C14342f0.m8185o(format, "df.format(df.parse(selectDate))");
            sb2 = format;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TextView textView = this$0.f19147k;
        if (textView == null) {
            C14342f0.m8200S("tv_date");
            textView = null;
        }
        textView.setText(sb2);
    }

    /* renamed from: y0 */
    private final void m40001y0() {
        String m6568k2;
        HttpRequest with = Http.with(this.f1669h);
        RunApiService runApiService = (RunApiService) Http.getApiService(RunApiService.class);
        String keepToken = LoginUser.getLoginUser().getKeepToken();
        TextView textView = this.f19147k;
        if (textView == null) {
            C14342f0.m8200S("tv_date");
            textView = null;
        }
        m6568k2 = StringsJVM.m6568k2(textView.getText().toString(), "-", "", false, 4, null);
        with.setObservable(runApiService.m40105p(keepToken, m6568k2)).setHttpJsonKey(new NewHttpJsonKey()).setDataListener(new C5253a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        TextView textView = this.f19147k;
        TextView textView2 = null;
        if (textView == null) {
            C14342f0.m8200S("tv_date");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.keep.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncKeepDataActivity.m40008r0(SyncKeepDataActivity.this, view);
            }
        });
        TextView textView3 = this.f19148l;
        if (textView3 == null) {
            C14342f0.m8200S("bt_sync");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.keep.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncKeepDataActivity.m40007s0(SyncKeepDataActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_sync_keep_data;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        TextView textView = this.f19147k;
        if (textView == null) {
            C14342f0.m8200S("tv_date");
            textView = null;
        }
        textView.setText(this.f19151o.format(new Date()));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("同步keep跑步记录");
        m57921f0(ContextCompat.getColor(this.f1669h, 2131034196));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(@Nullable Bundle bundle) {
        View findViewById = findViewById(2131232926);
        C14342f0.m8185o(findViewById, "findViewById(R.id.tv_date)");
        this.f19147k = (TextView) findViewById;
        View findViewById2 = findViewById(C4215R.C4219id.bt_sync);
        C14342f0.m8185o(findViewById2, "findViewById(R.id.bt_sync)");
        this.f19148l = (TextView) findViewById2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }

    /* renamed from: z0 */
    public final void m40000z0() {
        int i = this.f19149m;
        List<? extends Map<String, ? extends Object>> list = this.f19150n;
        List<? extends Map<String, ? extends Object>> list2 = null;
        if (list == null) {
            C14342f0.m8200S("dataList");
            list = null;
        }
        if (i >= list.size()) {
            new iOSOneButtonDialog(this.f1669h).setMessage("同步Keep数据成功").show();
            return;
        }
        List<? extends Map<String, ? extends Object>> list3 = this.f19150n;
        if (list3 == null) {
            C14342f0.m8200S("dataList");
        } else {
            list2 = list3;
        }
        Map<String, ? extends Object> map = list2.get(this.f19149m);
        double d = JsonParse.getDouble(map, "doubtfulScore");
        if (!(d == Utils.DOUBLE_EPSILON)) {
            if (!(d == 0.5d)) {
                this.f19149m++;
                m40000z0();
                return;
            }
        }
        long j = (long) JsonParse.getDouble(map, "duration");
        String m39630g = FormatUtils.m39630g(j);
        double d2 = JsonParse.getDouble(map, "distance");
        String m39634c = FormatUtils.m39634c(d2);
        String m39636a = FormatUtils.m39636a(d2, j);
        String m39635b = FormatUtils.m39635b(d2, j);
        List<Map<String, Object>> geoPoints = JsonParse.getList(map, "geoPoints");
        C14342f0.m8185o(geoPoints, "geoPoints");
        Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40104q(LoginUser.getLoginUser().getUserId(), 2, JsonParse.getLong(map, AnalyticsConfig.RTD_START_TIME), JsonParse.getLong(map, "endTime"), JSON.toJSONString(m40004v0(geoPoints)), UUID.randomUUID().toString(), m39630g, m39634c, m39636a, m39635b, null, null, null, null, null, null, JSON.toJSONString(m40005u0(geoPoints)), null, null, 4, JsonParse.getString(map, "id"))).setDataListener(new C5254b());
    }
}
