package com.bxkj.student.life.mall.collect;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CollectGoodsActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private CollectGoodsFragment f21683k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            CollectGoodsActivity.this.f21683k.a0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427409;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21683k = new CollectGoodsFragment();
        getSupportFragmentManager().beginTransaction().add(2131232182, this.f21683k).commit();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u6536\u85cf");
        d0("\u6e05\u7a7a", new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
