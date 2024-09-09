package com.bxkj.student.run.punchcard;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.a;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RecorderListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RadioGroup f23045k;

    /* renamed from: l  reason: collision with root package name */
    private String f23046l;

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
            this.f23046l = getIntent().getStringExtra("termId");
        }
        ArrayList arrayList = new ArrayList();
        RecordListFragment recordListFragment = new RecordListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", "effective");
        bundle.putString("termId", this.f23046l);
        recordListFragment.setArguments(bundle);
        arrayList.add(recordListFragment);
        RecordListFragment recordListFragment2 = new RecordListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "all");
        bundle2.putString("termId", this.f23046l);
        recordListFragment2.setArguments(bundle2);
        arrayList.add(recordListFragment2);
        new a(getSupportFragmentManager(), arrayList, 2131232182, this.f23045k);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5237\u8138\u7edf\u8ba1");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f23045k = (RadioGroup) findViewById(2131232489);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
