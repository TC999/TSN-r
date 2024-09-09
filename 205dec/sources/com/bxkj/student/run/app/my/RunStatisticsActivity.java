package com.bxkj.student.run.app.my;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunStatisticsActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TabLayout f22472k;

    /* renamed from: l  reason: collision with root package name */
    private Map<String, Object> f22473l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunStatisticsActivity.this.f22473l = data;
            ArrayList arrayList = new ArrayList();
            RunStaticsFragment runStaticsFragment = new RunStaticsFragment();
            Bundle bundle = new Bundle();
            List list = JsonParse.getList(RunStatisticsActivity.this.f22473l, "week", Float.class);
            float[] fArr = new float[list.size()];
            for (int i4 = 0; i4 < list.size(); i4++) {
                fArr[i4] = ((Float) list.get(i4)).floatValue();
            }
            bundle.putInt("type", 1);
            bundle.putFloatArray("listData", fArr);
            runStaticsFragment.setArguments(bundle);
            arrayList.add(runStaticsFragment);
            RunStaticsFragment runStaticsFragment2 = new RunStaticsFragment();
            Bundle bundle2 = new Bundle();
            List list2 = JsonParse.getList(RunStatisticsActivity.this.f22473l, "month", Float.class);
            float[] fArr2 = new float[list2.size()];
            for (int i5 = 0; i5 < list2.size(); i5++) {
                fArr2[i5] = ((Float) list2.get(i5)).floatValue();
            }
            bundle2.putInt("type", 2);
            bundle2.putFloatArray("listData", fArr2);
            runStaticsFragment2.setArguments(bundle2);
            arrayList.add(runStaticsFragment2);
            RunStaticsFragment runStaticsFragment3 = new RunStaticsFragment();
            Bundle bundle3 = new Bundle();
            List list3 = JsonParse.getList(RunStatisticsActivity.this.f22473l, "sysTerm", Float.class);
            float[] fArr3 = new float[list3.size()];
            for (int i6 = 0; i6 < list3.size(); i6++) {
                fArr3[i6] = ((Float) list3.get(i6)).floatValue();
            }
            bundle3.putInt("type", 3);
            bundle3.putFloatArray("listData", fArr3);
            runStaticsFragment3.setArguments(bundle3);
            arrayList.add(runStaticsFragment3);
            new cn.bluemobi.dylan.base.adapter.b(RunStatisticsActivity.this.getSupportFragmentManager(), arrayList, 2131232182, RunStatisticsActivity.this.f22472k);
        }
    }

    private void l0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).n(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427479;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8dd1\u6b65\u7edf\u8ba1");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22472k = (TabLayout) findViewById(2131232721);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
