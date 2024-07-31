package com.bxkj.student.run.app.p092my;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.FragmentTabAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunApiService;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.bxkj.student.run.app.my.RunStatisticsActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunStatisticsActivity extends BaseActivity {

    /* renamed from: k */
    private TabLayout f19235k;

    /* renamed from: l */
    private Map<String, Object> f19236l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.my.RunStatisticsActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5274a extends HttpCallBack {
        C5274a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunStatisticsActivity.this.f19236l = data;
            ArrayList arrayList = new ArrayList();
            RunStaticsFragment runStaticsFragment = new RunStaticsFragment();
            Bundle bundle = new Bundle();
            List list = JsonParse.getList(RunStatisticsActivity.this.f19236l, "week", Float.class);
            float[] fArr = new float[list.size()];
            for (int i = 0; i < list.size(); i++) {
                fArr[i] = ((Float) list.get(i)).floatValue();
            }
            bundle.putInt("type", 1);
            bundle.putFloatArray("listData", fArr);
            runStaticsFragment.setArguments(bundle);
            arrayList.add(runStaticsFragment);
            RunStaticsFragment runStaticsFragment2 = new RunStaticsFragment();
            Bundle bundle2 = new Bundle();
            List list2 = JsonParse.getList(RunStatisticsActivity.this.f19236l, "month", Float.class);
            float[] fArr2 = new float[list2.size()];
            for (int i2 = 0; i2 < list2.size(); i2++) {
                fArr2[i2] = ((Float) list2.get(i2)).floatValue();
            }
            bundle2.putInt("type", 2);
            bundle2.putFloatArray("listData", fArr2);
            runStaticsFragment2.setArguments(bundle2);
            arrayList.add(runStaticsFragment2);
            RunStaticsFragment runStaticsFragment3 = new RunStaticsFragment();
            Bundle bundle3 = new Bundle();
            List list3 = JsonParse.getList(RunStatisticsActivity.this.f19236l, "sysTerm", Float.class);
            float[] fArr3 = new float[list3.size()];
            for (int i3 = 0; i3 < list3.size(); i3++) {
                fArr3[i3] = ((Float) list3.get(i3)).floatValue();
            }
            bundle3.putInt("type", 3);
            bundle3.putFloatArray("listData", fArr3);
            runStaticsFragment3.setArguments(bundle3);
            arrayList.add(runStaticsFragment3);
            new FragmentTabAdapter(RunStatisticsActivity.this.getSupportFragmentManager(), arrayList, 2131232182, RunStatisticsActivity.this.f19235k);
        }
    }

    /* renamed from: l0 */
    private void m39927l0() {
        Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40107n(LoginUser.getLoginUser().getUserId())).setDataListener(new C5274a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_run_statistics;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m39927l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("跑步统计");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19235k = (TabLayout) findViewById(C4215R.C4219id.tb_type);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
