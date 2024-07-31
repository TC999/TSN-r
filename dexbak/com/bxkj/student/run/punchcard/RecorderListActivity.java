package com.bxkj.student.run.punchcard;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.FragmentRadioAdapter;
import com.bxkj.student.C4215R;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RecorderListActivity extends BaseActivity {

    /* renamed from: k */
    private RadioGroup f19815k;

    /* renamed from: l */
    private String f19816l;

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
            this.f19816l = getIntent().getStringExtra("termId");
        }
        ArrayList arrayList = new ArrayList();
        RecordListFragment recordListFragment = new RecordListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", "effective");
        bundle.putString("termId", this.f19816l);
        recordListFragment.setArguments(bundle);
        arrayList.add(recordListFragment);
        RecordListFragment recordListFragment2 = new RecordListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "all");
        bundle2.putString("termId", this.f19816l);
        recordListFragment2.setArguments(bundle2);
        arrayList.add(recordListFragment2);
        new FragmentRadioAdapter(getSupportFragmentManager(), arrayList, 2131232182, this.f19815k);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("刷脸统计");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19815k = (RadioGroup) findViewById(2131232489);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
