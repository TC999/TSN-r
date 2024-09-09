package com.bxkj.student.home.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.chat.ConversationListActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MessageActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f19722k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f19723l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        startActivity(new Intent(this.f1656h, ConversationListActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19722k.setOnClickListener(this);
        this.f19723l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.message.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageActivity.this.j0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427437;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6d88\u606f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19722k = (TextView) findViewById(2131233049);
        this.f19723l = (TextView) findViewById(2131232895);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131233049) {
            return;
        }
        startActivity(new Intent(this.f1656h, SystemMessageListActivity.class));
    }
}
