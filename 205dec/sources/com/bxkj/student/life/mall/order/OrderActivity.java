package com.bxkj.student.life.mall.order;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.b;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class OrderActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TabLayout f21727k;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427445;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < 8; i4++) {
            OrderFragment orderFragment = new OrderFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i4);
            orderFragment.setArguments(bundle);
            arrayList.add(orderFragment);
        }
        new b(getSupportFragmentManager(), arrayList, 2131232182, this.f21727k);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u8ba2\u5355");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21727k = (TabLayout) findViewById(2131232711);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
