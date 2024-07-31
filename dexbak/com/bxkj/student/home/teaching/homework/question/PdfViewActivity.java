package com.bxkj.student.home.teaching.homework.question;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.detail.type.PdfFragment;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PdfViewActivity extends BaseActivity {
    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.pub_empty;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        PdfFragment pdfFragment = new PdfFragment();
        Bundle bundle = new Bundle();
        if (getIntent().hasExtra("url")) {
            bundle.putString("url", getIntent().getStringExtra("url"));
        } else if (getIntent().hasExtra(TTDownloadField.TT_FILE_PATH)) {
            bundle.putString(TTDownloadField.TT_FILE_PATH, getIntent().getStringExtra(TTDownloadField.TT_FILE_PATH));
        }
        pdfFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(2131232217, pdfFragment).commitAllowingStateLoss();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("预览PDF文件");
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
