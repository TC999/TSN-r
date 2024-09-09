package cn.bluemobi.dylan.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Toolbar f1649a;

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f1650b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f1651c;

    /* renamed from: d  reason: collision with root package name */
    private c f1652d;

    /* renamed from: e  reason: collision with root package name */
    private c f1653e;

    /* renamed from: f  reason: collision with root package name */
    private int f1654f;

    /* renamed from: g  reason: collision with root package name */
    private String f1655g;

    /* renamed from: h  reason: collision with root package name */
    protected Context f1656h;

    /* renamed from: i  reason: collision with root package name */
    protected FragmentActivity f1657i;

    /* renamed from: j  reason: collision with root package name */
    private Toast f1658j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            BaseActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements c {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            BaseActivity.this.finish();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface c {
        void onClick();
    }

    private CharSequence Q() {
        return this.f1651c.getText();
    }

    private void S(IBinder iBinder) {
        if (iBinder != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 2);
        }
    }

    private boolean W(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        return motionEvent.getX() <= ((float) i4) || motionEvent.getX() >= ((float) (view.getWidth() + i4)) || motionEvent.getY() <= ((float) i5) || motionEvent.getY() >= ((float) (view.getHeight() + i5));
    }

    private BaseActivity X() {
        if (cn.bluemobi.dylan.base.a.a() != null) {
            Y(cn.bluemobi.dylan.base.a.a().intValue()).Z(new a());
        } else {
            Y(R.drawable.ic_return_white_24dp).Z(new b());
        }
        return this;
    }

    public abstract void N();

    /* JADX INFO: Access modifiers changed from: protected */
    public void O() {
    }

    protected abstract int P();

    public FrameLayout R() {
        return this.f1650b;
    }

    public abstract void T();

    public abstract void U();

    public abstract void V(Bundle bundle);

    protected BaseActivity Y(int i4) {
        this.f1649a.setNavigationIcon(i4);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseActivity Z(c cVar) {
        this.f1652d = cVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseActivity a0(boolean z3) {
        if (!z3) {
            this.f1649a.setNavigationIcon((Drawable) null);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseActivity b0(int i4, c cVar) {
        this.f1654f = i4;
        this.f1653e = cVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseActivity c0(String str, int i4, c cVar) {
        this.f1654f = i4;
        this.f1655g = str;
        this.f1653e = cVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseActivity d0(String str, c cVar) {
        this.f1653e = cVar;
        this.f1655g = str;
        return this;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (W(currentFocus, motionEvent)) {
                S(currentFocus.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseActivity e0(boolean z3) {
        this.f1649a.setVisibility(z3 ? 0 : 8);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseActivity f0(int i4) {
        this.f1651c.setTextColor(i4);
        return this;
    }

    protected BaseActivity g0(float f4) {
        this.f1651c.setTextSize(f4);
        return this;
    }

    public void h0(CharSequence charSequence) {
        Toast toast = this.f1658j;
        if (toast == null) {
            Toast makeText = Toast.makeText(this.f1656h, charSequence, 0);
            this.f1658j = makeText;
            makeText.setGravity(17, 0, 0);
        } else {
            toast.setText(charSequence);
        }
        this.f1658j.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1657i = this;
        this.f1656h = this;
        O();
        setContentView(R.layout.ac_base_title_bar);
        cn.bluemobi.dylan.base.utils.a.n().c(this);
        this.f1649a = (Toolbar) findViewById(R.id.toolbar);
        this.f1650b = (FrameLayout) findViewById(R.id.viewContent);
        this.f1651c = (TextView) findViewById(R.id.tvTitle);
        setRequestedOrientation(1);
        setSupportActionBar(this.f1649a);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        X();
        U();
        LayoutInflater.from(this).inflate(P(), this.f1650b);
        V(bundle);
        T();
        N();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f1654f == 0 && TextUtils.isEmpty(this.f1655g)) {
            return true;
        }
        getMenuInflater().inflate(R.menu.menu_base_title_bar, menu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        cn.bluemobi.dylan.base.utils.a.n().h(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        c cVar;
        if (menuItem.getItemId() == 16908332) {
            c cVar2 = this.f1652d;
            if (cVar2 != null) {
                cVar2.onClick();
                return true;
            }
            return true;
        } else if (menuItem.getItemId() != R.id.menu_1 || (cVar = this.f1653e) == null) {
            return true;
        } else {
            cVar.onClick();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Toast toast = this.f1658j;
        if (toast != null) {
            toast.cancel();
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem = menu.findItem(R.id.menu_1);
        int i4 = this.f1654f;
        if (i4 != 0) {
            findItem.setIcon(i4);
        }
        if (!TextUtils.isEmpty(this.f1655g)) {
            findItem.setTitle(this.f1655g);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f1651c.setText(charSequence);
    }
}
