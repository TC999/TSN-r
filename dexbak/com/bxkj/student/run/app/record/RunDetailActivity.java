package com.bxkj.student.run.app.record;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.FragmentTabAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunApiService;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.p093vm.RunVM;
import com.google.android.material.tabs.TabLayout;
import com.umeng.socialize.UMShareAPI;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15280l;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunDetailActivity extends BaseActivity {

    /* renamed from: k */
    private TabLayout f19304k;

    /* renamed from: l */
    private TraceDetailFragment f19305l;

    /* renamed from: m */
    private RunVM f19306m;

    /* renamed from: com.bxkj.student.run.app.record.RunDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5319a extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ Bundle f19307a;

        C5319a(final Bundle val$args) {
            this.f19307a = val$args;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            this.f19307a.putString("latLngTimeSpeed", JsonParse.getString(data, "gitudeLatitude"));
            this.f19307a.putString("speed", JsonParse.getString(data, "avgspeed"));
            this.f19307a.putString("peisu", JsonParse.getString(data, "speed"));
            this.f19307a.putString(RtspHeaders.Values.TIME, JsonParse.getString(data, "sportTime"));
            this.f19307a.putString("distance", JsonParse.getString(data, "sportRange"));
            this.f19307a.putString("okPointList", JsonParse.getString(data, "okPointList"));
            this.f19307a.putString("step", JsonParse.getString(data, "stepNumbers"));
            this.f19307a.putString("geoFence", JsonParse.getString(data, "geofence"));
            this.f19307a.putString("punchCoordinate", JsonParse.getString(data, "punchCoordinate"));
            RunDetailActivity.this.m39855l0(this.f19307a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public void m39855l0(Bundle args) {
        ArrayList arrayList = new ArrayList();
        this.f19305l = new TraceDetailFragment();
        StepDetailFragment stepDetailFragment = new StepDetailFragment();
        this.f19305l.setArguments(args);
        stepDetailFragment.setArguments(args);
        arrayList.add(this.f19305l);
        arrayList.add(stepDetailFragment);
        new FragmentTabAdapter(getSupportFragmentManager(), arrayList, 2131232182, this.f19304k);
        if (getIntent().hasExtra("runType") && getIntent().getIntExtra("runType", 2) == 0) {
            this.f19304k.getTabAt(1).select();
        }
    }

    /* renamed from: m0 */
    private void m39854m0() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ Unit m39853n0(Bundle bundle, List list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        RunDb runDb = (RunDb) list.get(0);
        if (runDb != null) {
            bundle.putString("step", runDb.getStepList());
        }
        m39855l0(bundle);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m39852o0() {
        TraceDetailFragment traceDetailFragment = this.f19305l;
        if (traceDetailFragment != null) {
            traceDetailFragment.m39775q0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_run_details;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f19306m = (RunVM) new ViewModelProvider(this).get(RunVM.class);
        m39854m0();
        final Bundle bundle = new Bundle();
        if (getIntent().hasExtra("sportRecordId")) {
            String stringExtra = getIntent().getStringExtra("sportRecordId");
            bundle.putString("sportRecordId", stringExtra);
            Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40117d(stringExtra)).setDataListener(new C5319a(bundle));
        } else if (getIntent().hasExtra("latLngTimeSpeed")) {
            bundle.putString("latLngTimeSpeed", getIntent().getStringExtra("latLngTimeSpeed"));
            bundle.putString("speed", getIntent().getStringExtra("speed"));
            bundle.putString("peisu", getIntent().getStringExtra("peisu"));
            bundle.putString(RtspHeaders.Values.TIME, getIntent().getStringExtra(RtspHeaders.Values.TIME));
            bundle.putString("distance", getIntent().getStringExtra("distance"));
            bundle.putString("okPointList", getIntent().getStringExtra("okPointList"));
            bundle.putString("step", getIntent().getStringExtra("step"));
            bundle.putString("geoFence", getIntent().getStringExtra("geoFence"));
            m39855l0(bundle);
        } else if (getIntent().hasExtra("runDataDbId")) {
            bundle.putString("runDataDbId", getIntent().getStringExtra("runDataDbId"));
            this.f19306m.m39503v(getIntent().getStringExtra("runDataDbId"), new InterfaceC15280l() { // from class: com.bxkj.student.run.app.record.j
                @Override // p617l1.InterfaceC15280l
                public final Object invoke(Object obj) {
                    Unit m39853n0;
                    m39853n0 = RunDetailActivity.this.m39853n0(bundle, (List) obj);
                    return m39853n0;
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("跑步详情");
        m57923d0("分享", new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.run.app.record.i
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                RunDetailActivity.this.m39852o0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19304k = (TabLayout) findViewById(C4215R.C4219id.f16009tb);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this.f1669h).onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
