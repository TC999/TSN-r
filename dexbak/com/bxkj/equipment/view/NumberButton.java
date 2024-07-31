package com.bxkj.equipment.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bxkj.equipment.C4133R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class NumberButton extends LinearLayout implements View.OnClickListener, TextWatcher {

    /* renamed from: a */
    private int f15765a;

    /* renamed from: b */
    private int f15766b;

    /* renamed from: c */
    private EditText f15767c;

    /* renamed from: d */
    private InterfaceC4158a f15768d;

    /* renamed from: com.bxkj.equipment.view.NumberButton$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC4158a {
        void onNumberChanged(int number);

        void onWarningForBuyMax(int max);

        void onWarningForInventory(int inventory);
    }

    public NumberButton(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m43094a(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(C4133R.C4139layout.number_layout, this);
        TextView textView = (TextView) findViewById(C4133R.C4137id.button_add);
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(C4133R.C4137id.button_sub);
        textView2.setOnClickListener(this);
        EditText editText = (EditText) findViewById(C4133R.C4137id.text_count);
        this.f15767c = editText;
        editText.setOnClickListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, C4133R.styleable.NumberButton);
        boolean z = obtainStyledAttributes.getBoolean(C4133R.styleable.NumberButton_editable, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C4133R.styleable.NumberButton_buttonWidth, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(C4133R.styleable.NumberButton_textWidth, -1);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(C4133R.styleable.NumberButton_textSize, -1);
        int color = obtainStyledAttributes.getColor(C4133R.styleable.NumberButton_textColor, -10066330);
        obtainStyledAttributes.recycle();
        setEditable(z);
        this.f15767c.setTextColor(color);
        textView2.setTextColor(color);
        textView.setTextColor(color);
        if (dimensionPixelSize3 > 0) {
            this.f15767c.setTextSize(dimensionPixelSize3);
        }
        if (dimensionPixelSize > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
            textView2.setLayoutParams(layoutParams);
            textView.setLayoutParams(layoutParams);
        }
        if (dimensionPixelSize2 > 0) {
            this.f15767c.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize2, -1));
        }
    }

    /* renamed from: b */
    private void m43093b() {
        InterfaceC4158a interfaceC4158a = this.f15768d;
        if (interfaceC4158a != null) {
            interfaceC4158a.onNumberChanged(getNumber());
        }
    }

    /* renamed from: c */
    private void m43092c() {
        int number = getNumber();
        if (number <= 0) {
            this.f15767c.setText("1");
            return;
        }
        int min = Math.min(this.f15766b, this.f15765a);
        if (number > min) {
            EditText editText = this.f15767c;
            editText.setText(min + "");
            if (this.f15765a < this.f15766b) {
                m43086i();
            } else {
                m43087h();
            }
        }
    }

    /* renamed from: h */
    private void m43087h() {
        InterfaceC4158a interfaceC4158a = this.f15768d;
        if (interfaceC4158a != null) {
            interfaceC4158a.onWarningForBuyMax(this.f15766b);
        }
    }

    /* renamed from: i */
    private void m43086i() {
        InterfaceC4158a interfaceC4158a = this.f15768d;
        if (interfaceC4158a != null) {
            interfaceC4158a.onWarningForInventory(this.f15765a);
        }
    }

    private void setEditable(boolean editable) {
        if (editable) {
            this.f15767c.setFocusable(true);
            this.f15767c.setKeyListener(new DigitsKeyListener());
            return;
        }
        this.f15767c.setFocusable(false);
        this.f15767c.setKeyListener(null);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    /* renamed from: d */
    public NumberButton m43091d(int buyMax) {
        this.f15766b = buyMax;
        return this;
    }

    /* renamed from: e */
    public NumberButton m43090e(int currentNumber) {
        if (currentNumber < 1) {
            this.f15767c.setText("1");
        }
        EditText editText = this.f15767c;
        editText.setText("" + Math.min(Math.min(this.f15766b, this.f15765a), currentNumber));
        return this;
    }

    /* renamed from: f */
    public NumberButton m43089f(int inventory) {
        this.f15765a = inventory;
        return this;
    }

    /* renamed from: g */
    public NumberButton m43088g(InterfaceC4158a onWarnListener) {
        this.f15768d = onWarnListener;
        return this;
    }

    public int getBuyMax() {
        return this.f15766b;
    }

    public int getInventory() {
        return this.f15765a;
    }

    public int getNumber() {
        try {
            return Integer.parseInt(this.f15767c.getText().toString());
        } catch (NumberFormatException unused) {
            this.f15767c.setText("1");
            return 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        int number = getNumber();
        if (id == C4133R.C4137id.button_sub) {
            if (number > 1) {
                EditText editText = this.f15767c;
                editText.setText("" + (number - 1));
                m43093b();
            }
        } else if (id == C4133R.C4137id.button_add) {
            if (number < Math.min(this.f15766b, this.f15765a)) {
                EditText editText2 = this.f15767c;
                editText2.setText("" + (number + 1));
                m43093b();
            } else if (this.f15765a < this.f15766b) {
                m43086i();
            } else {
                m43087h();
            }
        } else if (id == C4133R.C4137id.text_count) {
            EditText editText3 = this.f15767c;
            editText3.setSelection(editText3.getText().toString().length());
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        m43092c();
    }

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f15765a = Integer.MAX_VALUE;
        this.f15766b = Integer.MAX_VALUE;
        m43094a(context, attrs);
    }
}
