package com.bxkj.base.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bxkj.base.C3801R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SearchView extends LinearLayout implements TextWatcher, View.OnClickListener {

    /* renamed from: a */
    private EditText f15240a;

    /* renamed from: b */
    private Button f15241b;

    /* renamed from: c */
    private InterfaceC3998a f15242c;

    /* renamed from: com.bxkj.base.view.SearchView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC3998a {
        /* renamed from: a */
        void mo39377a(String str);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(C3801R.C3807layout.pub_searchview, (ViewGroup) this, true);
        this.f15240a = (EditText) findViewById(C3801R.C3805id.et_search);
        Button button = (Button) findViewById(C3801R.C3805id.bt_clear);
        this.f15241b = button;
        button.setVisibility(8);
        this.f15240a.addTextChangedListener(this);
        this.f15241b.setOnClickListener(this);
        this.f15240a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.bxkj.base.view.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean m43527b;
                m43527b = SearchView.this.m43527b(textView, i, keyEvent);
                return m43527b;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ boolean m43527b(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            ((InputMethodManager) this.f15240a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f15240a.getWindowToken(), 0);
            InterfaceC3998a interfaceC3998a = this.f15242c;
            if (interfaceC3998a != null) {
                interfaceC3998a.mo39377a(this.f15240a.getText().toString());
            }
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f15240a.getText().toString().trim().isEmpty()) {
            this.f15241b.setVisibility(8);
        } else {
            this.f15241b.setVisibility(0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f15240a.setText("");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        InterfaceC3998a interfaceC3998a = this.f15242c;
        if (interfaceC3998a != null) {
            interfaceC3998a.mo39377a(charSequence.toString());
        }
    }

    public void setOnSearchListener(InterfaceC3998a interfaceC3998a) {
        this.f15242c = interfaceC3998a;
    }
}
