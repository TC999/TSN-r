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
import com.bxkj.base.C3801R;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* renamed from: com.bxkj.base.keyboard.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KeyboardHelper implements View.OnClickListener, View.OnFocusChangeListener, KeyboardView.OnKeyboardActionListener, PopupWindow.OnDismissListener {

    /* renamed from: g */
    private static final int f14811g = C3801R.C3805id.keyboard_view;

    /* renamed from: h */
    private static PopupWindow f14812h;

    /* renamed from: a */
    protected Keyboard f14813a;

    /* renamed from: b */
    private View f14814b;

    /* renamed from: c */
    protected KeyboardView f14815c;

    /* renamed from: d */
    private Activity f14816d;

    /* renamed from: e */
    private InterfaceC3879a f14817e;

    /* renamed from: f */
    protected boolean f14818f;

    /* compiled from: KeyboardHelper.java */
    /* renamed from: com.bxkj.base.keyboard.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3879a {
        /* renamed from: a */
        void m44171a();
    }

    public KeyboardHelper(Activity activity) {
        this(activity, null);
    }

    /* renamed from: d */
    protected static PopupWindow m44186d(Context context) {
        PopupWindow popupWindow = f14812h;
        if (popupWindow != null) {
            return popupWindow;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(context).inflate(C3801R.C3807layout.keyboard_layout, (ViewGroup) null), StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels, -2, true);
        popupWindow2.setInputMethodMode(1);
        popupWindow2.setSoftInputMode(16);
        popupWindow2.setFocusable(false);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(C3801R.C3803color.transparent)));
        popupWindow2.setAnimationStyle(C3801R.C3810style.keyboard_anim_style);
        return popupWindow2;
    }

    /* renamed from: e */
    public static Point m44185e(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    /* renamed from: g */
    public static Point m44183g(Context context) {
        Point m44185e = m44185e(context);
        Point m44182h = m44182h(context);
        if (m44185e.x < m44182h.x) {
            return new Point(m44182h.x - m44185e.x, m44185e.y);
        }
        if (m44185e.y < m44182h.y) {
            return new Point(m44185e.x, m44182h.y - m44185e.y);
        }
        return new Point();
    }

    /* renamed from: h */
    public static Point m44182h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return point;
    }

    /* renamed from: l */
    private static boolean m44178l(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    /* renamed from: a */
    public KeyboardHelper m44189a(EditText editText) {
        if (editText == null) {
            return this;
        }
        editText.setCursorVisible(true);
        editText.setSingleLine(false);
        editText.setOnClickListener(this);
        editText.setOnFocusChangeListener(this);
        if (m44178l(editText.getInputType())) {
            m44188b(editText, false);
        }
        return this;
    }

    /* renamed from: b */
    public KeyboardHelper m44188b(EditText editText, boolean z) {
        if (z) {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        return this;
    }

    /* renamed from: c */
    public KeyboardHelper m44187c(boolean z) {
        EditText m44184f = m44184f();
        return m44184f == null ? this : m44188b(m44184f, z);
    }

    @Nullable
    /* renamed from: f */
    protected EditText m44184f() {
        Object tag = this.f14815c.getTag(f14811g);
        if (tag == null || !(tag instanceof EditText)) {
            return null;
        }
        return (EditText) tag;
    }

    /* renamed from: i */
    public void m44181i(EditText editText) {
        int visibility = this.f14814b.getVisibility();
        if (visibility == 0 || visibility == 4) {
            f14812h.dismiss();
        }
    }

    /* renamed from: j */
    protected void m44180j(Activity activity) {
        Keyboard keyboard = new Keyboard(StubApp.getOrigApplicationContext(activity.getApplicationContext()), C3801R.C3811xml.keyboard_digs);
        this.f14813a = keyboard;
        this.f14815c.setKeyboard(keyboard);
        this.f14815c.setEnabled(true);
        this.f14815c.setPreviewEnabled(false);
        this.f14815c.setOnKeyboardActionListener(this);
    }

    /* renamed from: k */
    protected boolean m44179k(String str) {
        return "0123456789".indexOf(str) > -1;
    }

    /* renamed from: m */
    protected boolean m44177m(String str) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(str.toLowerCase()) > -1;
    }

    /* renamed from: n */
    protected boolean m44176n(View view) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            return ((ContextWrapper) context).getBaseContext() instanceof Activity;
        }
        return false;
    }

    /* renamed from: o */
    protected void m44175o() {
        List<Keyboard.Key> keys = this.f14813a.getKeys();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).label != null && m44179k(keys.get(i).label.toString())) {
                arrayList.add(keys.get(i));
            }
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < size; i2++) {
            Integer valueOf = Integer.valueOf(i2 + 48);
            linkedList.add(new KeyModel(valueOf, i2 + ""));
        }
        Random random = new Random();
        for (int i3 = 0; i3 < size; i3++) {
            int nextInt = random.nextInt(size - i3);
            arrayList2.add(new KeyModel(((KeyModel) linkedList.get(nextInt)).m44193a(), ((KeyModel) linkedList.get(nextInt)).m44192b()));
            linkedList.remove(nextInt);
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ((Keyboard.Key) arrayList.get(i4)).label = ((KeyModel) arrayList2.get(i4)).m44192b();
            ((Keyboard.Key) arrayList.get(i4)).codes[0] = ((KeyModel) arrayList2.get(i4)).m44193a().intValue();
        }
        this.f14815c.setKeyboard(this.f14813a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditText) {
            m44172r((EditText) view);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f14815c.setTag(f14811g, null);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (z) {
                try {
                    Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(editText, Boolean.FALSE);
                } catch (Exception unused) {
                }
                ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                m44172r(editText);
                return;
            }
            m44181i(editText);
        }
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onKey(int i, int[] iArr) {
        EditText m44184f = m44184f();
        if (m44184f == null) {
            return;
        }
        Editable text = m44184f.getText();
        int selectionStart = m44184f.getSelectionStart();
        int selectionEnd = m44184f.getSelectionEnd();
        if (i == -3) {
            m44181i(m44184f);
        } else if (i == -99999999) {
            m44184f.setText("");
        } else if (i == -5) {
            if (selectionStart == selectionEnd) {
                selectionStart--;
            }
            if (TextUtils.isEmpty(text) || selectionStart < 0 || selectionEnd > text.length()) {
                return;
            }
            text.delete(selectionStart, selectionEnd);
        } else {
            text.insert(selectionStart, Character.toString((char) i));
        }
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onPress(int i) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onRelease(int i) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onText(CharSequence charSequence) {
    }

    /* renamed from: p */
    public KeyboardHelper m44174p(InterfaceC3879a interfaceC3879a) {
        this.f14817e = interfaceC3879a;
        return this;
    }

    /* renamed from: q */
    public KeyboardHelper m44173q(boolean z) {
        this.f14818f = z;
        return this;
    }

    /* renamed from: r */
    public void m44172r(@NonNull EditText editText) {
        EditText m44184f = m44184f();
        if (editText == m44184f) {
            return;
        }
        m44181i(m44184f);
        this.f14815c.setTag(f14811g, editText);
        int visibility = this.f14814b.getVisibility();
        if (visibility == 8 || visibility == 4) {
            this.f14814b.setVisibility(0);
        }
        if (this.f14818f) {
            m44175o();
        }
        IBinder windowToken = editText.getWindowToken();
        if (windowToken == null || !windowToken.isBinderAlive()) {
            return;
        }
        editText.getRootView().getGlobalVisibleRect(new Rect());
        int i = StubApp.getOrigApplicationContext(editText.getContext().getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
        if (Build.VERSION.SDK_INT >= 22) {
            f14812h.setAttachedInDecor(m44176n(editText));
        }
        ((WindowManager) this.f14816d.getSystemService("window")).getDefaultDisplay().getWidth();
        f14812h.setTouchable(true);
        f14812h.getContentView().measure(0, 0);
        f14812h.showAtLocation(editText, 81, 0, -f14812h.getContentView().getMeasuredHeight());
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

    public KeyboardHelper(Activity activity, EditText editText) {
        this.f14818f = false;
        this.f14816d = activity;
        PopupWindow m44186d = m44186d(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        f14812h = m44186d;
        m44186d.setOnDismissListener(this);
        this.f14815c = (KeyboardView) f14812h.getContentView().findViewById(C3801R.C3805id.keyboard_view);
        this.f14814b = f14812h.getContentView().findViewById(C3801R.C3805id.keyboard_view_layout);
        f14812h.setOutsideTouchable(true);
        m44180j(activity);
        m44189a(editText);
    }
}
