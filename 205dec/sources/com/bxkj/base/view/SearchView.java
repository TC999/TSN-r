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
import com.bxkj.base.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SearchView extends LinearLayout implements TextWatcher, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private EditText f18810a;

    /* renamed from: b  reason: collision with root package name */
    private Button f18811b;

    /* renamed from: c  reason: collision with root package name */
    private a f18812c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface a {
        void a(String str);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.pub_searchview, (ViewGroup) this, true);
        this.f18810a = (EditText) findViewById(R.id.et_search);
        Button button = (Button) findViewById(R.id.bt_clear);
        this.f18811b = button;
        button.setVisibility(8);
        this.f18810a.addTextChangedListener(this);
        this.f18811b.setOnClickListener(this);
        this.f18810a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.bxkj.base.view.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                boolean b4;
                b4 = SearchView.this.b(textView, i4, keyEvent);
                return b4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(TextView textView, int i4, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            ((InputMethodManager) this.f18810a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f18810a.getWindowToken(), 0);
            a aVar = this.f18812c;
            if (aVar != null) {
                aVar.a(this.f18810a.getText().toString());
            }
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f18810a.getText().toString().trim().isEmpty()) {
            this.f18811b.setVisibility(8);
        } else {
            this.f18811b.setVisibility(0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f18810a.setText("");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        a aVar = this.f18812c;
        if (aVar != null) {
            aVar.a(charSequence.toString());
        }
    }

    public void setOnSearchListener(a aVar) {
        this.f18812c = aVar;
    }
}
