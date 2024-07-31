package com.bxkj.student.personal.collect;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.FragmentTabAdapter;
import com.bxkj.student.C4215R;
import com.bxkj.student.life.InfoFragment;
import com.bxkj.student.life.mall.collect.CollectGoodsFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CollectActivity extends BaseActivity {

    /* renamed from: k */
    private ImageView f18809k;

    /* renamed from: l */
    private TabLayout f18810l;

    /* renamed from: m */
    private CollectGoodsFragment f18811m;

    /* renamed from: com.bxkj.student.personal.collect.CollectActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5139a implements BaseActivity.InterfaceC1107c {
        C5139a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            if (CollectActivity.this.f18810l.getSelectedTabPosition() != 2 || CollectActivity.this.f18811m == null) {
                return;
            }
            CollectActivity.this.f18811m.m40834a0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_collect;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InfoFragment());
        arrayList.add(new InfoFragment());
        CollectGoodsFragment collectGoodsFragment = new CollectGoodsFragment();
        this.f18811m = collectGoodsFragment;
        arrayList.add(collectGoodsFragment);
        new FragmentTabAdapter(getSupportFragmentManager(), arrayList, 2131232182, this.f18810l);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的收藏");
        m57923d0("清空", new C5139a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18809k = (ImageView) findViewById(C4215R.C4219id.f15999iv);
        this.f18810l = (TabLayout) findViewById(C4215R.C4219id.f16009tb);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
