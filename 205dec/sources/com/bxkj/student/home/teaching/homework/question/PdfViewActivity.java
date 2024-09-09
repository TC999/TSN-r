package com.bxkj.student.home.teaching.homework.question;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.home.teaching.learning.detail.type.PdfFragment;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PdfViewActivity extends BaseActivity {
    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428019;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        PdfFragment pdfFragment = new PdfFragment();
        Bundle bundle = new Bundle();
        if (getIntent().hasExtra("url")) {
            bundle.putString("url", getIntent().getStringExtra("url"));
        } else if (getIntent().hasExtra("filePath")) {
            bundle.putString("filePath", getIntent().getStringExtra("filePath"));
        }
        pdfFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(2131232217, pdfFragment).commitAllowingStateLoss();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9884\u89c8PDF\u6587\u4ef6");
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
