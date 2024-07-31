package com.bxkj.student.life.mall.order;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.FragmentTabAdapter;
import com.bxkj.student.C4215R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OrderActivity extends BaseActivity {

    /* renamed from: k */
    private TabLayout f18414k;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_order;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            OrderFragment orderFragment = new OrderFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            orderFragment.setArguments(bundle);
            arrayList.add(orderFragment);
        }
        new FragmentTabAdapter(getSupportFragmentManager(), arrayList, 2131232182, this.f18414k);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的订单");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18414k = (TabLayout) findViewById(C4215R.C4219id.f16009tb);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
