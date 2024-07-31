package com.bxkj.student.life.lost;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AddQuestionActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f18045k;

    /* renamed from: l */
    private EditText f18046l;

    /* renamed from: m */
    private Button f18047m;

    /* renamed from: com.bxkj.student.life.lost.AddQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC4890a implements View.OnClickListener {
        View$OnClickListenerC4890a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            AddQuestionActivity.this.m41094j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public void m41094j0() {
        String trim = this.f18045k.getText().toString().trim();
        String trim2 = this.f18046l.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            m57919h0("请填写问题");
        } else if (TextUtils.isEmpty(trim2)) {
            m57919h0("请填写答案");
        } else {
            Intent intent = new Intent();
            intent.putExtra("question", trim);
            intent.putExtra("answer", trim2);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18047m.setOnClickListener(new View$OnClickListenerC4890a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_add_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("添加问题");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18045k = (EditText) findViewById(C4215R.C4219id.et_question);
        this.f18046l = (EditText) findViewById(C4215R.C4219id.et_answer);
        this.f18047m = (Button) findViewById(C4215R.C4219id.bt_save);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
