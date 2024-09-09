package com.bxkj.student.run.extraclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import cn.bluemobi.dylan.base.BaseActivity;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SignListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RadioGroup f23014k;

    /* renamed from: l  reason: collision with root package name */
    private String f23015l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0() {
        startActivity(new Intent(this.f1656h, SignTypeActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427467;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("termId")) {
            this.f23015l = getIntent().getStringExtra("termId");
        }
        ArrayList arrayList = new ArrayList();
        SignListFragment signListFragment = new SignListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", "effective");
        bundle.putString("termId", this.f23015l);
        signListFragment.setArguments(bundle);
        arrayList.add(signListFragment);
        SignListFragment signListFragment2 = new SignListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "all");
        bundle2.putString("termId", this.f23015l);
        signListFragment2.setArguments(bundle2);
        arrayList.add(signListFragment2);
        new cn.bluemobi.dylan.base.adapter.a(getSupportFragmentManager(), arrayList, 2131232182, this.f23014k);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u573a\u9986\u6253\u5361\u8bb0\u5f55");
        d0("\u626b\u7801\u7b7e\u5230", new BaseActivity.c() { // from class: com.bxkj.student.run.extraclass.c
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                SignListActivity.this.j0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f23014k = (RadioGroup) findViewById(2131232489);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
