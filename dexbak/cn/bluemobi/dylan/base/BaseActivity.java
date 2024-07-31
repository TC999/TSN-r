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
import cn.bluemobi.dylan.base.utils.AppManager;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: a */
    private Toolbar f1662a;

    /* renamed from: b */
    private FrameLayout f1663b;

    /* renamed from: c */
    private TextView f1664c;

    /* renamed from: d */
    private InterfaceC1107c f1665d;

    /* renamed from: e */
    private InterfaceC1107c f1666e;

    /* renamed from: f */
    private int f1667f;

    /* renamed from: g */
    private String f1668g;

    /* renamed from: h */
    protected Context f1669h;

    /* renamed from: i */
    protected FragmentActivity f1670i;

    /* renamed from: j */
    private Toast f1671j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bluemobi.dylan.base.BaseActivity$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1105a implements InterfaceC1107c {
        C1105a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            BaseActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bluemobi.dylan.base.BaseActivity$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1106b implements InterfaceC1107c {
        C1106b() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            BaseActivity.this.finish();
        }
    }

    /* renamed from: cn.bluemobi.dylan.base.BaseActivity$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1107c {
        void onClick();
    }

    /* renamed from: Q */
    private CharSequence m57933Q() {
        return this.f1664c.getText();
    }

    /* renamed from: S */
    private void m57931S(IBinder iBinder) {
        if (iBinder != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 2);
        }
    }

    /* renamed from: W */
    private boolean m57930W(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }

    /* renamed from: X */
    private BaseActivity m57929X() {
        if (C1117a.m57908a() != null) {
            m57928Y(C1117a.m57908a().intValue()).m57927Z(new C1105a());
        } else {
            m57928Y(C1108R.C1111drawable.ic_return_white_24dp).m57927Z(new C1106b());
        }
        return this;
    }

    /* renamed from: N */
    public abstract void mo39376N();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: O */
    public void mo39959O() {
    }

    /* renamed from: P */
    protected abstract int mo39375P();

    /* renamed from: R */
    public FrameLayout m57932R() {
        return this.f1663b;
    }

    /* renamed from: T */
    public abstract void mo39374T();

    /* renamed from: U */
    public abstract void mo39373U();

    /* renamed from: V */
    public abstract void mo39372V(Bundle bundle);

    /* renamed from: Y */
    protected BaseActivity m57928Y(int i) {
        this.f1662a.setNavigationIcon(i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Z */
    public BaseActivity m57927Z(InterfaceC1107c interfaceC1107c) {
        this.f1665d = interfaceC1107c;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a0 */
    public BaseActivity m57926a0(boolean z) {
        if (!z) {
            this.f1662a.setNavigationIcon((Drawable) null);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b0 */
    public BaseActivity m57925b0(int i, InterfaceC1107c interfaceC1107c) {
        this.f1667f = i;
        this.f1666e = interfaceC1107c;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c0 */
    public BaseActivity m57924c0(String str, int i, InterfaceC1107c interfaceC1107c) {
        this.f1667f = i;
        this.f1668g = str;
        this.f1666e = interfaceC1107c;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d0 */
    public BaseActivity m57923d0(String str, InterfaceC1107c interfaceC1107c) {
        this.f1666e = interfaceC1107c;
        this.f1668g = str;
        return this;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (m57930W(currentFocus, motionEvent)) {
                m57931S(currentFocus.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e0 */
    public BaseActivity m57922e0(boolean z) {
        this.f1662a.setVisibility(z ? 0 : 8);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f0 */
    public BaseActivity m57921f0(int i) {
        this.f1664c.setTextColor(i);
        return this;
    }

    /* renamed from: g0 */
    protected BaseActivity m57920g0(float f) {
        this.f1664c.setTextSize(f);
        return this;
    }

    /* renamed from: h0 */
    public void m57919h0(CharSequence charSequence) {
        Toast toast = this.f1671j;
        if (toast == null) {
            Toast makeText = Toast.makeText(this.f1669h, charSequence, 0);
            this.f1671j = makeText;
            makeText.setGravity(17, 0, 0);
        } else {
            toast.setText(charSequence);
        }
        this.f1671j.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1670i = this;
        this.f1669h = this;
        mo39959O();
        setContentView(C1108R.C1113layout.ac_base_title_bar);
        AppManager.m57776n().m57787c(this);
        this.f1662a = (Toolbar) findViewById(C1108R.C1112id.toolbar);
        this.f1663b = (FrameLayout) findViewById(C1108R.C1112id.viewContent);
        this.f1664c = (TextView) findViewById(C1108R.C1112id.tvTitle);
        setRequestedOrientation(1);
        setSupportActionBar(this.f1662a);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        m57929X();
        mo39373U();
        LayoutInflater.from(this).inflate(mo39375P(), this.f1663b);
        mo39372V(bundle);
        mo39374T();
        mo39376N();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f1667f == 0 && TextUtils.isEmpty(this.f1668g)) {
            return true;
        }
        getMenuInflater().inflate(C1108R.C1114menu.menu_base_title_bar, menu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AppManager.m57776n().m57782h(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterfaceC1107c interfaceC1107c;
        if (menuItem.getItemId() == 16908332) {
            InterfaceC1107c interfaceC1107c2 = this.f1665d;
            if (interfaceC1107c2 != null) {
                interfaceC1107c2.onClick();
                return true;
            }
            return true;
        } else if (menuItem.getItemId() != C1108R.C1112id.menu_1 || (interfaceC1107c = this.f1666e) == null) {
            return true;
        } else {
            interfaceC1107c.onClick();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Toast toast = this.f1671j;
        if (toast != null) {
            toast.cancel();
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem = menu.findItem(C1108R.C1112id.menu_1);
        int i = this.f1667f;
        if (i != 0) {
            findItem.setIcon(i);
        }
        if (!TextUtils.isEmpty(this.f1668g)) {
            findItem.setTitle(this.f1668g);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f1664c.setText(charSequence);
    }
}
