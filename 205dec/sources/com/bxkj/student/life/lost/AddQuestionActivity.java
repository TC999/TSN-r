package com.bxkj.student.life.lost;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AddQuestionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f21383k;

    /* renamed from: l  reason: collision with root package name */
    private EditText f21384l;

    /* renamed from: m  reason: collision with root package name */
    private Button f21385m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            AddQuestionActivity.this.j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        String trim = this.f21383k.getText().toString().trim();
        String trim2 = this.f21384l.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            h0("\u8bf7\u586b\u5199\u95ee\u9898");
        } else if (TextUtils.isEmpty(trim2)) {
            h0("\u8bf7\u586b\u5199\u7b54\u6848");
        } else {
            Intent intent = new Intent();
            intent.putExtra("question", trim);
            intent.putExtra("answer", trim2);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21385m.setOnClickListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427358;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6dfb\u52a0\u95ee\u9898");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21383k = (EditText) findViewById(2131231270);
        this.f21384l = (EditText) findViewById(2131231252);
        this.f21385m = (Button) findViewById(2131231008);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
