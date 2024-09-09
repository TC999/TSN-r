package com.bxkj.student.personal.collect;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.b;
import com.bxkj.student.life.InfoFragment;
import com.bxkj.student.life.mall.collect.CollectGoodsFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CollectActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private ImageView f22093k;

    /* renamed from: l  reason: collision with root package name */
    private TabLayout f22094l;

    /* renamed from: m  reason: collision with root package name */
    private CollectGoodsFragment f22095m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            if (CollectActivity.this.f22094l.getSelectedTabPosition() != 2 || CollectActivity.this.f22095m == null) {
                return;
            }
            CollectActivity.this.f22095m.a0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427383;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InfoFragment());
        arrayList.add(new InfoFragment());
        CollectGoodsFragment collectGoodsFragment = new CollectGoodsFragment();
        this.f22095m = collectGoodsFragment;
        arrayList.add(collectGoodsFragment);
        new b(getSupportFragmentManager(), arrayList, 2131232182, this.f22094l);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u6536\u85cf");
        d0("\u6e05\u7a7a", new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22093k = (ImageView) findViewById(2131231382);
        this.f22094l = (TabLayout) findViewById(2131232711);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
