package com.bxkj.student.run.extraclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.FragmentRadioAdapter;
import com.bxkj.student.C4215R;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SignListActivity extends BaseActivity {

    /* renamed from: k */
    private RadioGroup f19784k;

    /* renamed from: l */
    private String f19785l;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void m39475j0() {
        startActivity(new Intent(this.f1669h, SignTypeActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_recorder_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("termId")) {
            this.f19785l = getIntent().getStringExtra("termId");
        }
        ArrayList arrayList = new ArrayList();
        SignListFragment signListFragment = new SignListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", "effective");
        bundle.putString("termId", this.f19785l);
        signListFragment.setArguments(bundle);
        arrayList.add(signListFragment);
        SignListFragment signListFragment2 = new SignListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "all");
        bundle2.putString("termId", this.f19785l);
        signListFragment2.setArguments(bundle2);
        arrayList.add(signListFragment2);
        new FragmentRadioAdapter(getSupportFragmentManager(), arrayList, 2131232182, this.f19784k);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("场馆打卡记录");
        m57923d0("扫码签到", new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.run.extraclass.c
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                SignListActivity.this.m39475j0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19784k = (RadioGroup) findViewById(2131232489);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
