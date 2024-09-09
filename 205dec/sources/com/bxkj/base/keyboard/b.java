package com.bxkj.base.keyboard;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bxkj.base.R;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: KeyboardHelper.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b implements View.OnClickListener, View.OnFocusChangeListener, KeyboardView.OnKeyboardActionListener, PopupWindow.OnDismissListener {

    /* renamed from: g  reason: collision with root package name */
    private static final int f18296g = R.id.keyboard_view;

    /* renamed from: h  reason: collision with root package name */
    private static PopupWindow f18297h;

    /* renamed from: a  reason: collision with root package name */
    protected Keyboard f18298a;

    /* renamed from: b  reason: collision with root package name */
    private View f18299b;

    /* renamed from: c  reason: collision with root package name */
    protected KeyboardView f18300c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f18301d;

    /* renamed from: e  reason: collision with root package name */
    private a f18302e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f18303f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: KeyboardHelper.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a();
    }

    public b(Activity activity) {
        this(activity, null);
    }

    protected static PopupWindow d(Context context) {
        PopupWindow popupWindow = f18297h;
        if (popupWindow != null) {
            return popupWindow;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(context).inflate(R.layout.keyboard_layout, (ViewGroup) null), StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels, -2, true);
        popupWindow2.setInputMethodMode(1);
        popupWindow2.setSoftInputMode(16);
        popupWindow2.setFocusable(false);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.transparent)));
        popupWindow2.setAnimationStyle(R.style.keyboard_anim_style);
        return popupWindow2;
    }

    public static Point e(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static Point g(Context context) {
        Point e4 = e(context);
        Point h4 = h(context);
        if (e4.x < h4.x) {
            return new Point(h4.x - e4.x, e4.y);
        }
        if (e4.y < h4.y) {
            return new Point(e4.x, h4.y - e4.y);
        }
        return new Point();
    }

    public static Point h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return point;
    }

    private static boolean l(int i4) {
        int i5 = i4 & 4095;
        return i5 == 129 || i5 == 225 || i5 == 18;
    }

    public b a(EditText editText) {
        if (editText == null) {
            return this;
        }
        editText.setCursorVisible(true);
        editText.setSingleLine(false);
        editText.setOnClickListener(this);
        editText.setOnFocusChangeListener(this);
        if (l(editText.getInputType())) {
            b(editText, false);
        }
        return this;
    }

    public b b(EditText editText, boolean z3) {
        if (z3) {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        return this;
    }

    public b c(boolean z3) {
        EditText f4 = f();
        return f4 == null ? this : b(f4, z3);
    }

    @Nullable
    protected EditText f() {
        Object tag = this.f18300c.getTag(f18296g);
        if (tag == null || !(tag instanceof EditText)) {
            return null;
        }
        return (EditText) tag;
    }

    public void i(EditText editText) {
        int visibility = this.f18299b.getVisibility();
        if (visibility == 0 || visibility == 4) {
            f18297h.dismiss();
        }
    }

    protected void j(Activity activity) {
        Keyboard keyboard = new Keyboard(StubApp.getOrigApplicationContext(activity.getApplicationContext()), R.xml.keyboard_digs);
        this.f18298a = keyboard;
        this.f18300c.setKeyboard(keyboard);
        this.f18300c.setEnabled(true);
        this.f18300c.setPreviewEnabled(false);
        this.f18300c.setOnKeyboardActionListener(this);
    }

    protected boolean k(String str) {
        return "0123456789".indexOf(str) > -1;
    }

    protected boolean m(String str) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(str.toLowerCase()) > -1;
    }

    protected boolean n(View view) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            return ((ContextWrapper) context).getBaseContext() instanceof Activity;
        }
        return false;
    }

    protected void o() {
        List<Keyboard.Key> keys = this.f18298a.getKeys();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < keys.size(); i4++) {
            if (keys.get(i4).label != null && k(keys.get(i4).label.toString())) {
                arrayList.add(keys.get(i4));
            }
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        LinkedList linkedList = new LinkedList();
        for (int i5 = 0; i5 < size; i5++) {
            Integer valueOf = Integer.valueOf(i5 + 48);
            linkedList.add(new com.bxkj.base.keyboard.a(valueOf, i5 + ""));
        }
        Random random = new Random();
        for (int i6 = 0; i6 < size; i6++) {
            int nextInt = random.nextInt(size - i6);
            arrayList2.add(new com.bxkj.base.keyboard.a(((com.bxkj.base.keyboard.a) linkedList.get(nextInt)).a(), ((com.bxkj.base.keyboard.a) linkedList.get(nextInt)).b()));
            linkedList.remove(nextInt);
        }
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            ((Keyboard.Key) arrayList.get(i7)).label = ((com.bxkj.base.keyboard.a) arrayList2.get(i7)).b();
            ((Keyboard.Key) arrayList.get(i7)).codes[0] = ((com.bxkj.base.keyboard.a) arrayList2.get(i7)).a().intValue();
        }
        this.f18300c.setKeyboard(this.f18298a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditText) {
            r((EditText) view);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f18300c.setTag(f18296g, null);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z3) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (z3) {
                try {
                    Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(editText, Boolean.FALSE);
                } catch (Exception unused) {
                }
                ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                r(editText);
                return;
            }
            i(editText);
        }
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onKey(int i4, int[] iArr) {
        EditText f4 = f();
        if (f4 == null) {
            return;
        }
        Editable text = f4.getText();
        int selectionStart = f4.getSelectionStart();
        int selectionEnd = f4.getSelectionEnd();
        if (i4 == -3) {
            i(f4);
        } else if (i4 == -99999999) {
            f4.setText("");
        } else if (i4 == -5) {
            if (selectionStart == selectionEnd) {
                selectionStart--;
            }
            if (TextUtils.isEmpty(text) || selectionStart < 0 || selectionEnd > text.length()) {
                return;
            }
            text.delete(selectionStart, selectionEnd);
        } else {
            text.insert(selectionStart, Character.toString((char) i4));
        }
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onPress(int i4) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onRelease(int i4) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onText(CharSequence charSequence) {
    }

    public b p(a aVar) {
        this.f18302e = aVar;
        return this;
    }

    public b q(boolean z3) {
        this.f18303f = z3;
        return this;
    }

    public void r(@NonNull EditText editText) {
        EditText f4 = f();
        if (editText == f4) {
            return;
        }
        i(f4);
        this.f18300c.setTag(f18296g, editText);
        int visibility = this.f18299b.getVisibility();
        if (visibility == 8 || visibility == 4) {
            this.f18299b.setVisibility(0);
        }
        if (this.f18303f) {
            o();
        }
        IBinder windowToken = editText.getWindowToken();
        if (windowToken == null || !windowToken.isBinderAlive()) {
            return;
        }
        editText.getRootView().getGlobalVisibleRect(new Rect());
        int i4 = StubApp.getOrigApplicationContext(editText.getContext().getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
        if (Build.VERSION.SDK_INT >= 22) {
            f18297h.setAttachedInDecor(n(editText));
        }
        ((WindowManager) this.f18301d.getSystemService("window")).getDefaultDisplay().getWidth();
        f18297h.setTouchable(true);
        f18297h.getContentView().measure(0, 0);
        f18297h.showAtLocation(editText, 81, 0, -f18297h.getContentView().getMeasuredHeight());
        editText.requestFocus();
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeUp() {
    }

    public b(Activity activity, EditText editText) {
        this.f18303f = false;
        this.f18301d = activity;
        PopupWindow d4 = d(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        f18297h = d4;
        d4.setOnDismissListener(this);
        this.f18300c = (KeyboardView) f18297h.getContentView().findViewById(R.id.keyboard_view);
        this.f18299b = f18297h.getContentView().findViewById(R.id.keyboard_view_layout);
        f18297h.setOutsideTouchable(true);
        j(activity);
        a(editText);
    }
}
