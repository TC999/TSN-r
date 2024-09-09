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
import com.bxkj.equipment.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class NumberButton extends LinearLayout implements View.OnClickListener, TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private int f19272a;

    /* renamed from: b  reason: collision with root package name */
    private int f19273b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f19274c;

    /* renamed from: d  reason: collision with root package name */
    private a f19275d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface a {
        void onNumberChanged(int number);

        void onWarningForBuyMax(int max);

        void onWarningForInventory(int inventory);
    }

    public NumberButton(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.number_layout, this);
        TextView textView = (TextView) findViewById(R.id.button_add);
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.button_sub);
        textView2.setOnClickListener(this);
        EditText editText = (EditText) findViewById(R.id.text_count);
        this.f19274c = editText;
        editText.setOnClickListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.NumberButton);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.NumberButton_editable, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberButton_buttonWidth, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberButton_textWidth, -1);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberButton_textSize, -1);
        int color = obtainStyledAttributes.getColor(R.styleable.NumberButton_textColor, -10066330);
        obtainStyledAttributes.recycle();
        setEditable(z3);
        this.f19274c.setTextColor(color);
        textView2.setTextColor(color);
        textView.setTextColor(color);
        if (dimensionPixelSize3 > 0) {
            this.f19274c.setTextSize(dimensionPixelSize3);
        }
        if (dimensionPixelSize > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
            textView2.setLayoutParams(layoutParams);
            textView.setLayoutParams(layoutParams);
        }
        if (dimensionPixelSize2 > 0) {
            this.f19274c.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize2, -1));
        }
    }

    private void b() {
        a aVar = this.f19275d;
        if (aVar != null) {
            aVar.onNumberChanged(getNumber());
        }
    }

    private void c() {
        int number = getNumber();
        if (number <= 0) {
            this.f19274c.setText("1");
            return;
        }
        int min = Math.min(this.f19273b, this.f19272a);
        if (number > min) {
            EditText editText = this.f19274c;
            editText.setText(min + "");
            if (this.f19272a < this.f19273b) {
                i();
            } else {
                h();
            }
        }
    }

    private void h() {
        a aVar = this.f19275d;
        if (aVar != null) {
            aVar.onWarningForBuyMax(this.f19273b);
        }
    }

    private void i() {
        a aVar = this.f19275d;
        if (aVar != null) {
            aVar.onWarningForInventory(this.f19272a);
        }
    }

    private void setEditable(boolean editable) {
        if (editable) {
            this.f19274c.setFocusable(true);
            this.f19274c.setKeyListener(new DigitsKeyListener());
            return;
        }
        this.f19274c.setFocusable(false);
        this.f19274c.setKeyListener(null);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s3, int start, int count, int after) {
    }

    public NumberButton d(int buyMax) {
        this.f19273b = buyMax;
        return this;
    }

    public NumberButton e(int currentNumber) {
        if (currentNumber < 1) {
            this.f19274c.setText("1");
        }
        EditText editText = this.f19274c;
        editText.setText("" + Math.min(Math.min(this.f19273b, this.f19272a), currentNumber));
        return this;
    }

    public NumberButton f(int inventory) {
        this.f19272a = inventory;
        return this;
    }

    public NumberButton g(a onWarnListener) {
        this.f19275d = onWarnListener;
        return this;
    }

    public int getBuyMax() {
        return this.f19273b;
    }

    public int getInventory() {
        return this.f19272a;
    }

    public int getNumber() {
        try {
            return Integer.parseInt(this.f19274c.getText().toString());
        } catch (NumberFormatException unused) {
            this.f19274c.setText("1");
            return 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        int number = getNumber();
        if (id == R.id.button_sub) {
            if (number > 1) {
                EditText editText = this.f19274c;
                editText.setText("" + (number - 1));
                b();
            }
        } else if (id == R.id.button_add) {
            if (number < Math.min(this.f19273b, this.f19272a)) {
                EditText editText2 = this.f19274c;
                editText2.setText("" + (number + 1));
                b();
            } else if (this.f19272a < this.f19273b) {
                i();
            } else {
                h();
            }
        } else if (id == R.id.text_count) {
            EditText editText3 = this.f19274c;
            editText3.setSelection(editText3.getText().toString().length());
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s3, int start, int before, int count) {
        c();
    }

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f19272a = Integer.MAX_VALUE;
        this.f19273b = Integer.MAX_VALUE;
        a(context, attrs);
    }
}
