package com.bxkj.student.home.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.chat.ConversationListActivity;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MessageActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f16332k;

    /* renamed from: l */
    private TextView f16333l;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void m42709j0(View view) {
        startActivity(new Intent(this.f1669h, ConversationListActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16332k.setOnClickListener(this);
        this.f16333l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.message.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageActivity.this.m42709j0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_message;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("消息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16332k = (TextView) findViewById(C4215R.C4219id.tv_notice_message);
        this.f16333l = (TextView) findViewById(C4215R.C4219id.tv_chat_message);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131233049) {
            return;
        }
        startActivity(new Intent(this.f1669h, SystemMessageListActivity.class));
    }
}
