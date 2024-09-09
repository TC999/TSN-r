package com.bxkj.student.run.app.keep;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.h;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.utils.i;
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
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SyncKeepDataActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H\u0002J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0014J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0006\u0010\u0019\u001a\u00020\u0002R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R(\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070#0\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/bxkj/student/run/app/keep/SyncKeepDataActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Lkotlin/f1;", "y0", "", "", "", "", "geoPoints", "Lcom/bxkj/student/run/app/location/LatLngTimeSpeed;", "v0", "stepList", "", "u0", "w0", "Landroid/view/View;", "v", "onClick", "U", "P", "Landroid/os/Bundle;", "savedInstanceState", "V", "T", "N", "z0", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "tv_date", "l", "bt_sync", "m", "I", "index", "", "n", "Ljava/util/List;", "dataList", "Ljava/text/DateFormat;", "o", "Ljava/text/DateFormat;", "df", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SyncKeepDataActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f22393k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22394l;

    /* renamed from: m  reason: collision with root package name */
    private int f22395m;

    /* renamed from: n  reason: collision with root package name */
    private List<? extends Map<String, ? extends Object>> f22396n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final DateFormat f22397o = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SyncKeepDataActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/run/app/keep/SyncKeepDataActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@Nullable Map<String, Object> map) {
            List<Map<String, Object>> list = JsonParse.getList(map, "data");
            if (list != null && list.size() > 0) {
                SyncKeepDataActivity.this.f22395m = 0;
                SyncKeepDataActivity.this.f22396n = list;
                SyncKeepDataActivity.this.z0();
                return;
            }
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) SyncKeepDataActivity.this).f1656h);
            StringBuilder sb = new StringBuilder();
            TextView textView = SyncKeepDataActivity.this.f22393k;
            if (textView == null) {
                f0.S("tv_date");
                textView = null;
            }
            sb.append((Object) textView.getText());
            sb.append("\u5f53\u5929\u6ca1\u6709\u8dd1\u6b65\u6570\u636e");
            iosonebuttondialog.setMessage(sb.toString()).show();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SyncKeepDataActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/bxkj/student/run/app/keep/SyncKeepDataActivity$b", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "netOnFinish", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            SyncKeepDataActivity.this.f22395m++;
            SyncKeepDataActivity.this.z0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@Nullable Map<String, Object> map) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(SyncKeepDataActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(final SyncKeepDataActivity this$0, View view) {
        f0.p(this$0, "this$0");
        if (TextUtils.isEmpty(LoginUser.getLoginUser().getKeepToken())) {
            new iOSTwoButtonDialog(this$0.f1656h).setMessage("\u7cfb\u7edf\u68c0\u6d4b\u5230\u60a8\u8fd8\u672a\u7ed1\u5b9aKeep\u8d26\u53f7,\u8bf7\u5148\u7ed1\u5b9aKeep\u8d26\u53f7").setLeftButtonText("\u6682\u4e0d\u7ed1\u5b9a").setRightButtonText("\u53bb\u7ed1\u5b9a").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.keep.e
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    SyncKeepDataActivity.t0(SyncKeepDataActivity.this);
                }
            }).show();
        } else {
            this$0.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(SyncKeepDataActivity this$0) {
        f0.p(this$0, "this$0");
        this$0.f1656h.startActivity(new Intent(this$0.f1656h, KeepAuthH5Activity.class));
    }

    private final List<Integer> u0(List<? extends Map<String, Object>> list) {
        int i4;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 1;
        for (Map<String, Object> map : list) {
            double d4 = JsonParse.getDouble(map, "currentTotalDuration");
            int i7 = JsonParse.getInt(map, "currentTotalSteps");
            if (d4 > i6 * 60) {
                int i8 = i7 - i5;
                i5 += i8;
                i6++;
                arrayList.add(Integer.valueOf(i8));
            }
            System.out.println((Object) ("time:" + d4 + " step:" + i7));
        }
        if ((!list.isEmpty()) && (i4 = JsonParse.getInt(list.get(list.size() - 1), "currentTotalSteps") - i5) > 0) {
            arrayList.add(Integer.valueOf(i4));
        }
        return arrayList;
    }

    private final List<LatLngTimeSpeed> v0(List<? extends Map<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            LatLngTimeSpeed latLngTimeSpeed = new LatLngTimeSpeed();
            latLngTimeSpeed.setLatitude(JsonParse.getDouble(map, "latitude"));
            latLngTimeSpeed.setLongitude(JsonParse.getDouble(map, "longitude"));
            latLngTimeSpeed.setLocationType(JsonParse.getInt(map, "locationType"));
            latLngTimeSpeed.setSpeed(JsonParse.getFloat(map, "speed"));
            double d4 = JsonParse.getDouble(map, "currentTotalDuration");
            double d5 = 1000;
            Double.isNaN(d5);
            latLngTimeSpeed.setTime((long) (d4 * d5));
            latLngTimeSpeed.setPuase(false);
            arrayList.add(latLngTimeSpeed);
        }
        return arrayList;
    }

    private final void w0() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(new Date());
        new DatePickerDialog(this.f1656h, new DatePickerDialog.OnDateSetListener() { // from class: com.bxkj.student.run.app.keep.b
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                SyncKeepDataActivity.x0(SyncKeepDataActivity.this, datePicker, i4, i5, i6);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(SyncKeepDataActivity this$0, DatePicker datePicker, int i4, int i5, int i6) {
        f0.p(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append('-');
        sb.append(i5 + 1);
        sb.append('-');
        sb.append(i6);
        String sb2 = sb.toString();
        try {
            DateFormat dateFormat = this$0.f22397o;
            String format = dateFormat.format(dateFormat.parse(sb2));
            f0.o(format, "df.format(df.parse(selectDate))");
            sb2 = format;
        } catch (ParseException e4) {
            e4.printStackTrace();
        }
        TextView textView = this$0.f22393k;
        if (textView == null) {
            f0.S("tv_date");
            textView = null;
        }
        textView.setText(sb2);
    }

    private final void y0() {
        String k22;
        HttpRequest with = Http.with(this.f1656h);
        com.bxkj.student.run.app.a aVar = (com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class);
        String keepToken = LoginUser.getLoginUser().getKeepToken();
        TextView textView = this.f22393k;
        if (textView == null) {
            f0.S("tv_date");
            textView = null;
        }
        k22 = w.k2(textView.getText().toString(), "-", "", false, 4, null);
        with.setObservable(aVar.p(keepToken, k22)).setHttpJsonKey(new h()).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        TextView textView = this.f22393k;
        TextView textView2 = null;
        if (textView == null) {
            f0.S("tv_date");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.keep.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncKeepDataActivity.r0(SyncKeepDataActivity.this, view);
            }
        });
        TextView textView3 = this.f22394l;
        if (textView3 == null) {
            f0.S("bt_sync");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.keep.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncKeepDataActivity.s0(SyncKeepDataActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427498;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        TextView textView = this.f22393k;
        if (textView == null) {
            f0.S("tv_date");
            textView = null;
        }
        textView.setText(this.f22397o.format(new Date()));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u540c\u6b65keep\u8dd1\u6b65\u8bb0\u5f55");
        f0(ContextCompat.getColor(this.f1656h, 2131034196));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(@Nullable Bundle bundle) {
        View findViewById = findViewById(2131232926);
        f0.o(findViewById, "findViewById(R.id.tv_date)");
        this.f22393k = (TextView) findViewById;
        View findViewById2 = findViewById(2131231014);
        f0.o(findViewById2, "findViewById(R.id.bt_sync)");
        this.f22394l = (TextView) findViewById2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }

    public final void z0() {
        int i4 = this.f22395m;
        List<? extends Map<String, ? extends Object>> list = this.f22396n;
        List<? extends Map<String, ? extends Object>> list2 = null;
        if (list == null) {
            f0.S("dataList");
            list = null;
        }
        if (i4 >= list.size()) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u540c\u6b65Keep\u6570\u636e\u6210\u529f").show();
            return;
        }
        List<? extends Map<String, ? extends Object>> list3 = this.f22396n;
        if (list3 == null) {
            f0.S("dataList");
        } else {
            list2 = list3;
        }
        Map<String, ? extends Object> map = list2.get(this.f22395m);
        double d4 = JsonParse.getDouble(map, "doubtfulScore");
        if (!(d4 == 0.0d)) {
            if (!(d4 == 0.5d)) {
                this.f22395m++;
                z0();
                return;
            }
        }
        long j4 = (long) JsonParse.getDouble(map, "duration");
        String g4 = i.g(j4);
        double d5 = JsonParse.getDouble(map, "distance");
        String c4 = i.c(d5);
        String a4 = i.a(d5, j4);
        String b4 = i.b(d5, j4);
        List<Map<String, Object>> geoPoints = JsonParse.getList(map, "geoPoints");
        f0.o(geoPoints, "geoPoints");
        Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).q(LoginUser.getLoginUser().getUserId(), 2, JsonParse.getLong(map, "startTime"), JsonParse.getLong(map, "endTime"), JSON.toJSONString(v0(geoPoints)), UUID.randomUUID().toString(), g4, c4, a4, b4, null, null, null, null, null, null, JSON.toJSONString(u0(geoPoints)), null, null, 4, JsonParse.getString(map, "id"))).setDataListener(new b());
    }
}
