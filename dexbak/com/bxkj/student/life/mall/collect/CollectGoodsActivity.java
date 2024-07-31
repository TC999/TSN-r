package com.bxkj.student.life.mall.collect;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CollectGoodsActivity extends BaseActivity {

    /* renamed from: k */
    private CollectGoodsFragment f18368k;

    /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5000a implements BaseActivity.InterfaceC1107c {
        C5000a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            CollectGoodsActivity.this.f18368k.m40834a0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_home_fragment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18368k = new CollectGoodsFragment();
        getSupportFragmentManager().beginTransaction().add(2131232182, this.f18368k).commit();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的收藏");
        m57923d0("清空", new C5000a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
