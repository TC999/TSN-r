package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.stub.StubApp;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p028c1.BitmapCropCallback;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UCropActivity extends AppCompatActivity {

    /* renamed from: F */
    public static final int f39676F = 90;

    /* renamed from: G */
    public static final Bitmap.CompressFormat f39677G;

    /* renamed from: H */
    public static final int f39678H = 0;

    /* renamed from: I */
    public static final int f39679I = 1;

    /* renamed from: J */
    public static final int f39680J = 2;

    /* renamed from: K */
    public static final int f39681K = 3;

    /* renamed from: L */
    private static final String f39682L = "UCropActivity";

    /* renamed from: M */
    private static final long f39683M = 50;

    /* renamed from: N */
    private static final int f39684N = 3;

    /* renamed from: O */
    private static final int f39685O = 15000;

    /* renamed from: P */
    private static final int f39686P = 42;

    /* renamed from: a */
    private String f39692a;

    /* renamed from: b */
    private int f39693b;

    /* renamed from: c */
    private int f39694c;

    /* renamed from: d */
    private int f39695d;

    /* renamed from: e */
    private int f39696e;

    /* renamed from: f */
    private int f39697f;
    @ColorInt

    /* renamed from: g */
    private int f39698g;
    @DrawableRes

    /* renamed from: h */
    private int f39699h;
    @DrawableRes

    /* renamed from: i */
    private int f39700i;

    /* renamed from: j */
    private int f39701j;

    /* renamed from: k */
    private boolean f39702k;

    /* renamed from: m */
    private UCropView f39704m;

    /* renamed from: n */
    private GestureCropImageView f39705n;

    /* renamed from: o */
    private OverlayView f39706o;

    /* renamed from: p */
    private ViewGroup f39707p;

    /* renamed from: q */
    private ViewGroup f39708q;

    /* renamed from: r */
    private ViewGroup f39709r;

    /* renamed from: s */
    private ViewGroup f39710s;

    /* renamed from: t */
    private ViewGroup f39711t;

    /* renamed from: u */
    private ViewGroup f39712u;

    /* renamed from: w */
    private TextView f39714w;

    /* renamed from: x */
    private TextView f39715x;

    /* renamed from: y */
    private View f39716y;

    /* renamed from: z */
    private Transition f39717z;

    /* renamed from: l */
    private boolean f39703l = true;

    /* renamed from: v */
    private List<ViewGroup> f39713v = new ArrayList();

    /* renamed from: A */
    private Bitmap.CompressFormat f39687A = f39677G;

    /* renamed from: B */
    private int f39688B = 90;

    /* renamed from: C */
    private int[] f39689C = {1, 2, 3};

    /* renamed from: D */
    private TransformImageView.InterfaceC13539b f39690D = new C13505a();

    /* renamed from: E */
    private final View.OnClickListener f39691E = new View$OnClickListenerC13511g();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface GestureTypes {
    }

    /* renamed from: com.yalantis.ucrop.UCropActivity$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C13505a implements TransformImageView.InterfaceC13539b {
        C13505a() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.InterfaceC13539b
        /* renamed from: a */
        public void mo12924a() {
            UCropActivity.this.f39704m.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.f39716y.setClickable(false);
            UCropActivity.this.f39703l = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.InterfaceC13539b
        /* renamed from: b */
        public void mo12923b(@NonNull Exception exc) {
            UCropActivity.this.m13161Y(exc);
            UCropActivity.this.finish();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.InterfaceC13539b
        /* renamed from: c */
        public void mo12922c(float f) {
            UCropActivity.this.m13159a0(f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.InterfaceC13539b
        /* renamed from: d */
        public void mo12921d(float f) {
            UCropActivity.this.m13164V(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropActivity$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class View$OnClickListenerC13506b implements View.OnClickListener {
        View$OnClickListenerC13506b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.f39705n.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).m12913b(view.isSelected()));
            UCropActivity.this.f39705n.m12959y();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropActivity.this.f39713v) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropActivity$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13507c implements HorizontalProgressWheelView.InterfaceC13542a {
        C13507c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        /* renamed from: a */
        public void mo12907a() {
            UCropActivity.this.f39705n.m12959y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        /* renamed from: b */
        public void mo12906b() {
            UCropActivity.this.f39705n.m12965s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        public void onScroll(float f, float f2) {
            UCropActivity.this.f39705n.m12961w(f / 42.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropActivity$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class View$OnClickListenerC13508d implements View.OnClickListener {
        View$OnClickListenerC13508d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.m13167S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropActivity$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class View$OnClickListenerC13509e implements View.OnClickListener {
        View$OnClickListenerC13509e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.m13166T(90);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropActivity$f */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13510f implements HorizontalProgressWheelView.InterfaceC13542a {
        C13510f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        /* renamed from: a */
        public void mo12907a() {
            UCropActivity.this.f39705n.m12959y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        /* renamed from: b */
        public void mo12906b() {
            UCropActivity.this.f39705n.m12965s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        public void onScroll(float f, float f2) {
            if (f > 0.0f) {
                UCropActivity.this.f39705n.m12973B(UCropActivity.this.f39705n.getCurrentScale() + (f * ((UCropActivity.this.f39705n.getMaxScale() - UCropActivity.this.f39705n.getMinScale()) / 15000.0f)));
            } else {
                UCropActivity.this.f39705n.m12971D(UCropActivity.this.f39705n.getCurrentScale() + (f * ((UCropActivity.this.f39705n.getMaxScale() - UCropActivity.this.f39705n.getMinScale()) / 15000.0f)));
            }
        }
    }

    /* renamed from: com.yalantis.ucrop.UCropActivity$g */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class View$OnClickListenerC13511g implements View.OnClickListener {
        View$OnClickListenerC13511g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropActivity.this.m13156c0(view.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropActivity$h */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13512h implements BitmapCropCallback {
        C13512h() {
        }

        @Override // p028c1.BitmapCropCallback
        /* renamed from: a */
        public void mo13108a(@NonNull Uri uri, int i, int i2, int i3, int i4) {
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.m13160Z(uri, uCropActivity.f39705n.getTargetAspectRatio(), i, i2, i3, i4);
            UCropActivity.this.finish();
        }

        @Override // p028c1.BitmapCropCallback
        /* renamed from: b */
        public void mo13107b(@NonNull Throwable th) {
            UCropActivity.this.m13161Y(th);
            UCropActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(24972);
        f39677G = Bitmap.CompressFormat.JPEG;
    }

    /* renamed from: N */
    private void m13172N() {
        if (this.f39716y == null) {
            this.f39716y = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, C13495R.C13499id.toolbar);
            this.f39716y.setLayoutParams(layoutParams);
            this.f39716y.setClickable(true);
        }
        ((RelativeLayout) findViewById(C13495R.C13499id.ucrop_photobox)).addView(this.f39716y);
    }

    /* renamed from: O */
    private void m13171O(int i) {
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(C13495R.C13499id.ucrop_photobox), this.f39717z);
        this.f39709r.findViewById(C13495R.C13499id.text_view_scale).setVisibility(i == C13495R.C13499id.state_scale ? 0 : 8);
        this.f39707p.findViewById(C13495R.C13499id.text_view_crop).setVisibility(i == C13495R.C13499id.state_aspect_ratio ? 0 : 8);
        this.f39708q.findViewById(C13495R.C13499id.text_view_rotate).setVisibility(i != C13495R.C13499id.state_rotate ? 8 : 0);
    }

    /* renamed from: Q */
    private void m13169Q() {
        UCropView uCropView = (UCropView) findViewById(C13495R.C13499id.ucrop);
        this.f39704m = uCropView;
        this.f39705n = uCropView.getCropImageView();
        this.f39706o = this.f39704m.getOverlayView();
        this.f39705n.setTransformImageListener(this.f39690D);
        ((ImageView) findViewById(C13495R.C13499id.image_view_logo)).setColorFilter(this.f39701j, PorterDuff.Mode.SRC_ATOP);
        findViewById(C13495R.C13499id.ucrop_frame).setBackgroundColor(this.f39698g);
    }

    /* renamed from: R */
    private void m13168R(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra(UCrop.C13523a.f39802b);
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (valueOf == null) {
            valueOf = f39677G;
        }
        this.f39687A = valueOf;
        this.f39688B = intent.getIntExtra(UCrop.C13523a.f39803c, 90);
        int[] intArrayExtra = intent.getIntArrayExtra(UCrop.C13523a.f39804d);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.f39689C = intArrayExtra;
        }
        this.f39705n.setMaxBitmapSize(intent.getIntExtra(UCrop.C13523a.f39805e, 0));
        this.f39705n.setMaxScaleMultiplier(intent.getFloatExtra(UCrop.C13523a.f39806f, 10.0f));
        this.f39705n.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra(UCrop.C13523a.f39807g, 500));
        this.f39706o.setFreestyleCropEnabled(intent.getBooleanExtra(UCrop.C13523a.f39798B, false));
        this.f39706o.setDimmedColor(intent.getIntExtra(UCrop.C13523a.f39808h, getResources().getColor(C13495R.C13497color.ucrop_color_default_dimmed)));
        this.f39706o.setCircleDimmedLayer(intent.getBooleanExtra(UCrop.C13523a.f39809i, false));
        this.f39706o.setShowCropFrame(intent.getBooleanExtra(UCrop.C13523a.f39810j, true));
        this.f39706o.setCropFrameColor(intent.getIntExtra(UCrop.C13523a.f39811k, getResources().getColor(C13495R.C13497color.ucrop_color_default_crop_frame)));
        this.f39706o.setCropFrameStrokeWidth(intent.getIntExtra(UCrop.C13523a.f39812l, getResources().getDimensionPixelSize(C13495R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f39706o.setShowCropGrid(intent.getBooleanExtra(UCrop.C13523a.f39813m, true));
        this.f39706o.setCropGridRowCount(intent.getIntExtra(UCrop.C13523a.f39814n, 2));
        this.f39706o.setCropGridColumnCount(intent.getIntExtra(UCrop.C13523a.f39815o, 2));
        this.f39706o.setCropGridColor(intent.getIntExtra(UCrop.C13523a.f39816p, getResources().getColor(C13495R.C13497color.ucrop_color_default_crop_grid)));
        this.f39706o.setCropGridStrokeWidth(intent.getIntExtra(UCrop.C13523a.f39817q, getResources().getDimensionPixelSize(C13495R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(UCrop.f39791o, 0.0f);
        float floatExtra2 = intent.getFloatExtra(UCrop.f39792p, 0.0f);
        int intExtra = intent.getIntExtra(UCrop.C13523a.f39799C, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.C13523a.f39800D);
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup = this.f39707p;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.f39705n.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra != null && intExtra < parcelableArrayListExtra.size()) {
            this.f39705n.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra)).m13051b() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).m13050c());
        } else {
            this.f39705n.setTargetAspectRatio(0.0f);
        }
        int intExtra2 = intent.getIntExtra(UCrop.f39793q, 0);
        int intExtra3 = intent.getIntExtra(UCrop.f39794r, 0);
        if (intExtra2 <= 0 || intExtra3 <= 0) {
            return;
        }
        this.f39705n.setMaxResultImageSizeX(intExtra2);
        this.f39705n.setMaxResultImageSizeY(intExtra3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public void m13167S() {
        GestureCropImageView gestureCropImageView = this.f39705n;
        gestureCropImageView.m12961w(-gestureCropImageView.getCurrentAngle());
        this.f39705n.m12959y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public void m13166T(int i) {
        this.f39705n.m12961w(i);
        this.f39705n.m12959y();
    }

    /* renamed from: U */
    private void m13165U(int i) {
        GestureCropImageView gestureCropImageView = this.f39705n;
        int[] iArr = this.f39689C;
        boolean z = false;
        gestureCropImageView.setScaleEnabled(iArr[i] == 3 || iArr[i] == 1);
        GestureCropImageView gestureCropImageView2 = this.f39705n;
        int[] iArr2 = this.f39689C;
        gestureCropImageView2.setRotateEnabled((iArr2[i] == 3 || iArr2[i] == 2) ? true : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m13164V(float f) {
        TextView textView = this.f39714w;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f)));
        }
    }

    /* renamed from: W */
    private void m13163W(@NonNull Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.f39783g);
        Uri uri2 = (Uri) intent.getParcelableExtra(UCrop.f39784h);
        m13168R(intent);
        if (uri != null && uri2 != null) {
            try {
                this.f39705n.m12928m(uri, uri2);
                return;
            } catch (Exception e) {
                m13161Y(e);
                finish();
                return;
            }
        }
        m13161Y(new NullPointerException(getString(C13495R.C13503string.ucrop_error_input_data_is_absent)));
        finish();
    }

    /* renamed from: X */
    private void m13162X() {
        if (this.f39702k) {
            if (this.f39707p.getVisibility() == 0) {
                m13156c0(C13495R.C13499id.state_aspect_ratio);
                return;
            } else {
                m13156c0(C13495R.C13499id.state_scale);
                return;
            }
        }
        m13165U(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public void m13159a0(float f) {
        TextView textView = this.f39715x;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f * 100.0f))));
        }
    }

    @TargetApi(21)
    /* renamed from: b0 */
    private void m13158b0(@ColorInt int i) {
        Window window;
        if (Build.VERSION.SDK_INT < 21 || (window = getWindow()) == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public void m13156c0(@IdRes int i) {
        if (this.f39702k) {
            ViewGroup viewGroup = this.f39707p;
            int i2 = C13495R.C13499id.state_aspect_ratio;
            viewGroup.setSelected(i == i2);
            ViewGroup viewGroup2 = this.f39708q;
            int i3 = C13495R.C13499id.state_rotate;
            viewGroup2.setSelected(i == i3);
            ViewGroup viewGroup3 = this.f39709r;
            int i4 = C13495R.C13499id.state_scale;
            viewGroup3.setSelected(i == i4);
            this.f39710s.setVisibility(i == i2 ? 0 : 8);
            this.f39711t.setVisibility(i == i3 ? 0 : 8);
            this.f39712u.setVisibility(i == i4 ? 0 : 8);
            m13171O(i);
            if (i == i4) {
                m13165U(0);
            } else if (i == i3) {
                m13165U(1);
            } else {
                m13165U(2);
            }
        }
    }

    /* renamed from: d0 */
    private void m13154d0() {
        m13158b0(this.f39694c);
        Toolbar toolbar = (Toolbar) findViewById(C13495R.C13499id.toolbar);
        toolbar.setBackgroundColor(this.f39693b);
        toolbar.setTitleTextColor(this.f39697f);
        TextView textView = (TextView) toolbar.findViewById(C13495R.C13499id.toolbar_title);
        textView.setTextColor(this.f39697f);
        textView.setText(this.f39692a);
        Drawable mutate = ContextCompat.getDrawable(this, this.f39699h).mutate();
        mutate.setColorFilter(this.f39697f, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    /* renamed from: e0 */
    private void m13152e0(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.C13523a.f39799C, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.C13523a.f39800D);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            intExtra = 2;
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(C13495R.C13503string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(C13495R.C13499id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(C13495R.C13501layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f39695d);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.f39713v.add(frameLayout);
        }
        this.f39713v.get(intExtra).setSelected(true);
        for (ViewGroup viewGroup : this.f39713v) {
            viewGroup.setOnClickListener(new View$OnClickListenerC13506b());
        }
    }

    /* renamed from: f0 */
    private void m13150f0() {
        this.f39714w = (TextView) findViewById(C13495R.C13499id.text_view_rotate);
        int i = C13495R.C13499id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i)).setScrollingListener(new C13507c());
        ((HorizontalProgressWheelView) findViewById(i)).setMiddleLineColor(this.f39695d);
        findViewById(C13495R.C13499id.wrapper_reset_rotate).setOnClickListener(new View$OnClickListenerC13508d());
        findViewById(C13495R.C13499id.wrapper_rotate_by_angle).setOnClickListener(new View$OnClickListenerC13509e());
    }

    /* renamed from: g0 */
    private void m13148g0() {
        this.f39715x = (TextView) findViewById(C13495R.C13499id.text_view_scale);
        int i = C13495R.C13499id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i)).setScrollingListener(new C13510f());
        ((HorizontalProgressWheelView) findViewById(i)).setMiddleLineColor(this.f39695d);
    }

    /* renamed from: h0 */
    private void m13146h0() {
        ImageView imageView = (ImageView) findViewById(C13495R.C13499id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(C13495R.C13499id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(C13495R.C13499id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.f39696e));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.f39696e));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.f39696e));
    }

    /* renamed from: i0 */
    private void m13144i0(@NonNull Intent intent) {
        this.f39694c = intent.getIntExtra(UCrop.C13523a.f39819s, ContextCompat.getColor(this, C13495R.C13497color.ucrop_color_statusbar));
        this.f39693b = intent.getIntExtra(UCrop.C13523a.f39818r, ContextCompat.getColor(this, C13495R.C13497color.ucrop_color_toolbar));
        this.f39695d = intent.getIntExtra(UCrop.C13523a.f39820t, ContextCompat.getColor(this, C13495R.C13497color.ucrop_color_widget_background));
        this.f39696e = intent.getIntExtra(UCrop.C13523a.f39821u, ContextCompat.getColor(this, C13495R.C13497color.ucrop_color_active_controls_color));
        this.f39697f = intent.getIntExtra(UCrop.C13523a.f39822v, ContextCompat.getColor(this, C13495R.C13497color.ucrop_color_toolbar_widget));
        this.f39699h = intent.getIntExtra(UCrop.C13523a.f39824x, C13495R.C13498drawable.ucrop_ic_cross);
        this.f39700i = intent.getIntExtra(UCrop.C13523a.f39825y, C13495R.C13498drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra(UCrop.C13523a.f39823w);
        this.f39692a = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(C13495R.C13503string.ucrop_label_edit_photo);
        }
        this.f39692a = stringExtra;
        this.f39701j = intent.getIntExtra(UCrop.C13523a.f39826z, ContextCompat.getColor(this, C13495R.C13497color.ucrop_color_default_logo));
        this.f39702k = !intent.getBooleanExtra(UCrop.C13523a.f39797A, false);
        this.f39698g = intent.getIntExtra(UCrop.C13523a.f39801E, ContextCompat.getColor(this, C13495R.C13497color.ucrop_color_crop_background));
        m13154d0();
        m13169Q();
        if (this.f39702k) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(C13495R.C13499id.ucrop_photobox)).findViewById(C13495R.C13499id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.f39698g);
            LayoutInflater.from(this).inflate(C13495R.C13501layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.f39717z = autoTransition;
            autoTransition.setDuration(f39683M);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(C13495R.C13499id.state_aspect_ratio);
            this.f39707p = viewGroup2;
            viewGroup2.setOnClickListener(this.f39691E);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(C13495R.C13499id.state_rotate);
            this.f39708q = viewGroup3;
            viewGroup3.setOnClickListener(this.f39691E);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(C13495R.C13499id.state_scale);
            this.f39709r = viewGroup4;
            viewGroup4.setOnClickListener(this.f39691E);
            this.f39710s = (ViewGroup) findViewById(C13495R.C13499id.layout_aspect_ratio);
            this.f39711t = (ViewGroup) findViewById(C13495R.C13499id.layout_rotate_wheel);
            this.f39712u = (ViewGroup) findViewById(C13495R.C13499id.layout_scale_wheel);
            m13152e0(intent);
            m13150f0();
            m13148g0();
            m13146h0();
        }
    }

    /* renamed from: P */
    protected void m13170P() {
        this.f39716y.setClickable(true);
        this.f39703l = true;
        supportInvalidateOptionsMenu();
        this.f39705n.m12964t(this.f39687A, this.f39688B, new C13512h());
    }

    /* renamed from: Y */
    protected void m13161Y(Throwable th) {
        setResult(96, new Intent().putExtra(UCrop.f39790n, th));
    }

    /* renamed from: Z */
    protected void m13160Z(Uri uri, float f, int i, int i2, int i3, int i4) {
        setResult(-1, new Intent().putExtra(UCrop.f39784h, uri).putExtra(UCrop.f39785i, f).putExtra(UCrop.f39786j, i3).putExtra(UCrop.f39787k, i4).putExtra(UCrop.f39788l, i).putExtra(UCrop.f39789m, i2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C13495R.C13502menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(C13495R.C13499id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.f39697f, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e) {
                Log.i(f39682L, String.format("%s - %s", e.getMessage(), getString(C13495R.C13503string.ucrop_mutate_exception_hint)));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(C13495R.C13499id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.f39700i);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(this.f39697f, PorterDuff.Mode.SRC_ATOP);
            findItem2.setIcon(drawable);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C13495R.C13499id.menu_crop) {
            m13170P();
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(C13495R.C13499id.menu_crop).setVisible(!this.f39703l);
        menu.findItem(C13495R.C13499id.menu_loader).setVisible(this.f39703l);
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.f39705n;
        if (gestureCropImageView != null) {
            gestureCropImageView.m12965s();
        }
    }
}
