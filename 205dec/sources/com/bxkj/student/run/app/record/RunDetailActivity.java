package com.bxkj.student.run.app.record;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.vm.RunVM;
import com.google.android.material.tabs.TabLayout;
import com.umeng.socialize.UMShareAPI;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TabLayout f22540k;

    /* renamed from: l  reason: collision with root package name */
    private TraceDetailFragment f22541l;

    /* renamed from: m  reason: collision with root package name */
    private RunVM f22542m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f22543a;

        a(final Bundle val$args) {
            this.f22543a = val$args;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            this.f22543a.putString("latLngTimeSpeed", JsonParse.getString(data, "gitudeLatitude"));
            this.f22543a.putString("speed", JsonParse.getString(data, "avgspeed"));
            this.f22543a.putString("peisu", JsonParse.getString(data, "speed"));
            this.f22543a.putString("time", JsonParse.getString(data, "sportTime"));
            this.f22543a.putString("distance", JsonParse.getString(data, "sportRange"));
            this.f22543a.putString("okPointList", JsonParse.getString(data, "okPointList"));
            this.f22543a.putString("step", JsonParse.getString(data, "stepNumbers"));
            this.f22543a.putString("geoFence", JsonParse.getString(data, "geofence"));
            this.f22543a.putString("punchCoordinate", JsonParse.getString(data, "punchCoordinate"));
            RunDetailActivity.this.l0(this.f22543a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(Bundle args) {
        ArrayList arrayList = new ArrayList();
        this.f22541l = new TraceDetailFragment();
        StepDetailFragment stepDetailFragment = new StepDetailFragment();
        this.f22541l.setArguments(args);
        stepDetailFragment.setArguments(args);
        arrayList.add(this.f22541l);
        arrayList.add(stepDetailFragment);
        new cn.bluemobi.dylan.base.adapter.b(getSupportFragmentManager(), arrayList, 2131232182, this.f22540k);
        if (getIntent().hasExtra("runType") && getIntent().getIntExtra("runType", 2) == 0) {
            this.f22540k.getTabAt(1).select();
        }
    }

    private void m0() {
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
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 n0(Bundle bundle, List list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        RunDb runDb = (RunDb) list.get(0);
        if (runDb != null) {
            bundle.putString("step", runDb.getStepList());
        }
        l0(bundle);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0() {
        TraceDetailFragment traceDetailFragment = this.f22541l;
        if (traceDetailFragment != null) {
            traceDetailFragment.q0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427473;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f22542m = (RunVM) new ViewModelProvider(this).get(RunVM.class);
        m0();
        final Bundle bundle = new Bundle();
        if (getIntent().hasExtra("sportRecordId")) {
            String stringExtra = getIntent().getStringExtra("sportRecordId");
            bundle.putString("sportRecordId", stringExtra);
            Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).d(stringExtra)).setDataListener(new a(bundle));
        } else if (getIntent().hasExtra("latLngTimeSpeed")) {
            bundle.putString("latLngTimeSpeed", getIntent().getStringExtra("latLngTimeSpeed"));
            bundle.putString("speed", getIntent().getStringExtra("speed"));
            bundle.putString("peisu", getIntent().getStringExtra("peisu"));
            bundle.putString("time", getIntent().getStringExtra("time"));
            bundle.putString("distance", getIntent().getStringExtra("distance"));
            bundle.putString("okPointList", getIntent().getStringExtra("okPointList"));
            bundle.putString("step", getIntent().getStringExtra("step"));
            bundle.putString("geoFence", getIntent().getStringExtra("geoFence"));
            l0(bundle);
        } else if (getIntent().hasExtra("runDataDbId")) {
            bundle.putString("runDataDbId", getIntent().getStringExtra("runDataDbId"));
            this.f22542m.v(getIntent().getStringExtra("runDataDbId"), new l1.l() { // from class: com.bxkj.student.run.app.record.j
                @Override // l1.l
                public final Object invoke(Object obj) {
                    f1 n02;
                    n02 = RunDetailActivity.this.n0(bundle, (List) obj);
                    return n02;
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8dd1\u6b65\u8be6\u60c5");
        d0("\u5206\u4eab", new BaseActivity.c() { // from class: com.bxkj.student.run.app.record.i
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                RunDetailActivity.this.o0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22540k = (TabLayout) findViewById(2131232711);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this.f1656h).onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
