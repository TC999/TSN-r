package com.bxkj.student.common.view;

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
import com.bxkj.student.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class NumberButton extends LinearLayout implements View.OnClickListener, TextWatcher {
    private int mBuyMax;
    private EditText mCount;
    private int mInventory;
    private OnWarnListener mOnWarnListener;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface OnWarnListener {
        void onNumberChanged(int number);

        void onWarningForBuyMax(int max);

        void onWarningForInventory(int inventory);
    }

    public NumberButton(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(2131428011, this);
        TextView textView = (TextView) findViewById(2131231036);
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(2131231041);
        textView2.setOnClickListener(this);
        EditText editText = (EditText) findViewById(2131232748);
        this.mCount = editText;
        editText.setOnClickListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.NumberButton);
        boolean z3 = obtainStyledAttributes.getBoolean(1, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(4, -1);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        int color = obtainStyledAttributes.getColor(2, -10066330);
        obtainStyledAttributes.recycle();
        setEditable(z3);
        this.mCount.setTextColor(color);
        textView2.setTextColor(color);
        textView.setTextColor(color);
        if (dimensionPixelSize3 > 0) {
            this.mCount.setTextSize(dimensionPixelSize3);
        }
        if (dimensionPixelSize > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
            textView2.setLayoutParams(layoutParams);
            textView.setLayoutParams(layoutParams);
        }
        if (dimensionPixelSize2 > 0) {
            this.mCount.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize2, -1));
        }
    }

    private void onNumberChanged() {
        OnWarnListener onWarnListener = this.mOnWarnListener;
        if (onWarnListener != null) {
            onWarnListener.onNumberChanged(getNumber());
        }
    }

    private void onNumberInput() {
        int number = getNumber();
        if (number <= 0) {
            this.mCount.setText("1");
            return;
        }
        int min = Math.min(this.mBuyMax, this.mInventory);
        if (number > min) {
            EditText editText = this.mCount;
            editText.setText(min + "");
            if (this.mInventory < this.mBuyMax) {
                warningForInventory();
            } else {
                warningForBuyMax();
            }
        }
    }

    private void setEditable(boolean editable) {
        if (editable) {
            this.mCount.setFocusable(true);
            this.mCount.setKeyListener(new DigitsKeyListener());
            return;
        }
        this.mCount.setFocusable(false);
        this.mCount.setKeyListener(null);
    }

    private void warningForBuyMax() {
        OnWarnListener onWarnListener = this.mOnWarnListener;
        if (onWarnListener != null) {
            onWarnListener.onWarningForBuyMax(this.mBuyMax);
        }
    }

    private void warningForInventory() {
        OnWarnListener onWarnListener = this.mOnWarnListener;
        if (onWarnListener != null) {
            onWarnListener.onWarningForInventory(this.mInventory);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s3, int start, int count, int after) {
    }

    public int getBuyMax() {
        return this.mBuyMax;
    }

    public int getInventory() {
        return this.mInventory;
    }

    public int getNumber() {
        try {
            return Integer.parseInt(this.mCount.getText().toString());
        } catch (NumberFormatException unused) {
            this.mCount.setText("1");
            return 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        int number = getNumber();
        if (id == 2131231041) {
            if (number > 1) {
                EditText editText = this.mCount;
                editText.setText("" + (number - 1));
                onNumberChanged();
            }
        } else if (id != 2131231036) {
            if (id == 2131232748) {
                EditText editText2 = this.mCount;
                editText2.setSelection(editText2.getText().toString().length());
            }
        } else if (number < Math.min(this.mBuyMax, this.mInventory)) {
            EditText editText3 = this.mCount;
            editText3.setText("" + (number + 1));
            onNumberChanged();
        } else if (this.mInventory < this.mBuyMax) {
            warningForInventory();
        } else {
            warningForBuyMax();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s3, int start, int before, int count) {
        onNumberInput();
    }

    public NumberButton setBuyMax(int buyMax) {
        this.mBuyMax = buyMax;
        return this;
    }

    public NumberButton setCurrentNumber(int currentNumber) {
        if (currentNumber < 1) {
            this.mCount.setText("1");
        }
        EditText editText = this.mCount;
        editText.setText("" + Math.min(Math.min(this.mBuyMax, this.mInventory), currentNumber));
        return this;
    }

    public NumberButton setInventory(int inventory) {
        this.mInventory = inventory;
        return this;
    }

    public NumberButton setOnWarnListener(OnWarnListener onWarnListener) {
        this.mOnWarnListener = onWarnListener;
        return this;
    }

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mInventory = Integer.MAX_VALUE;
        this.mBuyMax = Integer.MAX_VALUE;
        init(context, attrs);
    }
}
