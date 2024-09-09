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
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.i;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UCropActivity extends AppCompatActivity {
    public static final int F = 90;
    public static final Bitmap.CompressFormat G;
    public static final int H = 0;
    public static final int I = 1;
    public static final int J = 2;
    public static final int K = 3;

    /* renamed from: L  reason: collision with root package name */
    private static final String f54242L = "UCropActivity";
    private static final long M = 50;
    private static final int N = 3;
    private static final int O = 15000;
    private static final int P = 42;

    /* renamed from: a  reason: collision with root package name */
    private String f54243a;

    /* renamed from: b  reason: collision with root package name */
    private int f54244b;

    /* renamed from: c  reason: collision with root package name */
    private int f54245c;

    /* renamed from: d  reason: collision with root package name */
    private int f54246d;

    /* renamed from: e  reason: collision with root package name */
    private int f54247e;

    /* renamed from: f  reason: collision with root package name */
    private int f54248f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    private int f54249g;
    @DrawableRes

    /* renamed from: h  reason: collision with root package name */
    private int f54250h;
    @DrawableRes

    /* renamed from: i  reason: collision with root package name */
    private int f54251i;

    /* renamed from: j  reason: collision with root package name */
    private int f54252j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f54253k;

    /* renamed from: m  reason: collision with root package name */
    private UCropView f54255m;

    /* renamed from: n  reason: collision with root package name */
    private GestureCropImageView f54256n;

    /* renamed from: o  reason: collision with root package name */
    private OverlayView f54257o;

    /* renamed from: p  reason: collision with root package name */
    private ViewGroup f54258p;

    /* renamed from: q  reason: collision with root package name */
    private ViewGroup f54259q;

    /* renamed from: r  reason: collision with root package name */
    private ViewGroup f54260r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f54261s;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup f54262t;

    /* renamed from: u  reason: collision with root package name */
    private ViewGroup f54263u;

    /* renamed from: w  reason: collision with root package name */
    private TextView f54265w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f54266x;

    /* renamed from: y  reason: collision with root package name */
    private View f54267y;

    /* renamed from: z  reason: collision with root package name */
    private Transition f54268z;

    /* renamed from: l  reason: collision with root package name */
    private boolean f54254l = true;

    /* renamed from: v  reason: collision with root package name */
    private List<ViewGroup> f54264v = new ArrayList();
    private Bitmap.CompressFormat A = G;
    private int B = 90;
    private int[] C = {1, 2, 3};
    private TransformImageView.b D = new a();
    private final View.OnClickListener E = new g();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface GestureTypes {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements TransformImageView.b {
        a() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void a() {
            UCropActivity.this.f54255m.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.f54267y.setClickable(false);
            UCropActivity.this.f54254l = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void b(@NonNull Exception exc) {
            UCropActivity.this.Y(exc);
            UCropActivity.this.finish();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void c(float f4) {
            UCropActivity.this.a0(f4);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void d(float f4) {
            UCropActivity.this.V(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.f54256n.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).b(view.isSelected()));
            UCropActivity.this.f54256n.y();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropActivity.this.f54264v) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c implements HorizontalProgressWheelView.a {
        c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.f54256n.y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b() {
            UCropActivity.this.f54256n.s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void onScroll(float f4, float f5) {
            UCropActivity.this.f54256n.w(f4 / 42.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.T(90);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class f implements HorizontalProgressWheelView.a {
        f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.f54256n.y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b() {
            UCropActivity.this.f54256n.s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void onScroll(float f4, float f5) {
            if (f4 > 0.0f) {
                UCropActivity.this.f54256n.B(UCropActivity.this.f54256n.getCurrentScale() + (f4 * ((UCropActivity.this.f54256n.getMaxScale() - UCropActivity.this.f54256n.getMinScale()) / 15000.0f)));
            } else {
                UCropActivity.this.f54256n.D(UCropActivity.this.f54256n.getCurrentScale() + (f4 * ((UCropActivity.this.f54256n.getMaxScale() - UCropActivity.this.f54256n.getMinScale()) / 15000.0f)));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropActivity.this.c0(view.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class h implements c1.a {
        h() {
        }

        @Override // c1.a
        public void a(@NonNull Uri uri, int i4, int i5, int i6, int i7) {
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.Z(uri, uCropActivity.f54256n.getTargetAspectRatio(), i4, i5, i6, i7);
            UCropActivity.this.finish();
        }

        @Override // c1.a
        public void b(@NonNull Throwable th) {
            UCropActivity.this.Y(th);
            UCropActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(24972);
        G = Bitmap.CompressFormat.JPEG;
    }

    private void N() {
        if (this.f54267y == null) {
            this.f54267y = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.f54267y.setLayoutParams(layoutParams);
            this.f54267y.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.f54267y);
    }

    private void O(int i4) {
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.ucrop_photobox), this.f54268z);
        this.f54260r.findViewById(R.id.text_view_scale).setVisibility(i4 == R.id.state_scale ? 0 : 8);
        this.f54258p.findViewById(R.id.text_view_crop).setVisibility(i4 == R.id.state_aspect_ratio ? 0 : 8);
        this.f54259q.findViewById(R.id.text_view_rotate).setVisibility(i4 != R.id.state_rotate ? 8 : 0);
    }

    private void Q() {
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.f54255m = uCropView;
        this.f54256n = uCropView.getCropImageView();
        this.f54257o = this.f54255m.getOverlayView();
        this.f54256n.setTransformImageListener(this.D);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.f54252j, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.f54249g);
    }

    private void R(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (valueOf == null) {
            valueOf = G;
        }
        this.A = valueOf;
        this.B = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        int[] intArrayExtra = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.C = intArrayExtra;
        }
        this.f54256n.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.f54256n.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.f54256n.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.f54257o.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.f54257o.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.f54257o.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.f54257o.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.f54257o.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.f54257o.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f54257o.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.f54257o.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.f54257o.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.f54257o.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.f54257o.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float floatExtra2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup = this.f54258p;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.f54256n.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra != null && intExtra < parcelableArrayListExtra.size()) {
            this.f54256n.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra)).b() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).c());
        } else {
            this.f54256n.setTargetAspectRatio(0.0f);
        }
        int intExtra2 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int intExtra3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (intExtra2 <= 0 || intExtra3 <= 0) {
            return;
        }
        this.f54256n.setMaxResultImageSizeX(intExtra2);
        this.f54256n.setMaxResultImageSizeY(intExtra3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        GestureCropImageView gestureCropImageView = this.f54256n;
        gestureCropImageView.w(-gestureCropImageView.getCurrentAngle());
        this.f54256n.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i4) {
        this.f54256n.w(i4);
        this.f54256n.y();
    }

    private void U(int i4) {
        GestureCropImageView gestureCropImageView = this.f54256n;
        int[] iArr = this.C;
        boolean z3 = false;
        gestureCropImageView.setScaleEnabled(iArr[i4] == 3 || iArr[i4] == 1);
        GestureCropImageView gestureCropImageView2 = this.f54256n;
        int[] iArr2 = this.C;
        gestureCropImageView2.setRotateEnabled((iArr2[i4] == 3 || iArr2[i4] == 2) ? true : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(float f4) {
        TextView textView = this.f54265w;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f\u00b0", Float.valueOf(f4)));
        }
    }

    private void W(@NonNull Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        R(intent);
        if (uri != null && uri2 != null) {
            try {
                this.f54256n.m(uri, uri2);
                return;
            } catch (Exception e4) {
                Y(e4);
                finish();
                return;
            }
        }
        Y(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
        finish();
    }

    private void X() {
        if (this.f54253k) {
            if (this.f54258p.getVisibility() == 0) {
                c0(R.id.state_aspect_ratio);
                return;
            } else {
                c0(R.id.state_scale);
                return;
            }
        }
        U(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(float f4) {
        TextView textView = this.f54266x;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f4 * 100.0f))));
        }
    }

    @TargetApi(21)
    private void b0(@ColorInt int i4) {
        Window window;
        if (Build.VERSION.SDK_INT < 21 || (window = getWindow()) == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(@IdRes int i4) {
        if (this.f54253k) {
            ViewGroup viewGroup = this.f54258p;
            int i5 = R.id.state_aspect_ratio;
            viewGroup.setSelected(i4 == i5);
            ViewGroup viewGroup2 = this.f54259q;
            int i6 = R.id.state_rotate;
            viewGroup2.setSelected(i4 == i6);
            ViewGroup viewGroup3 = this.f54260r;
            int i7 = R.id.state_scale;
            viewGroup3.setSelected(i4 == i7);
            this.f54261s.setVisibility(i4 == i5 ? 0 : 8);
            this.f54262t.setVisibility(i4 == i6 ? 0 : 8);
            this.f54263u.setVisibility(i4 == i7 ? 0 : 8);
            O(i4);
            if (i4 == i7) {
                U(0);
            } else if (i4 == i6) {
                U(1);
            } else {
                U(2);
            }
        }
    }

    private void d0() {
        b0(this.f54245c);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.f54244b);
        toolbar.setTitleTextColor(this.f54248f);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.f54248f);
        textView.setText(this.f54243a);
        Drawable mutate = ContextCompat.getDrawable(this, this.f54250h).mutate();
        mutate.setColorFilter(this.f54248f, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void e0(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            intExtra = 2;
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f54246d);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.f54264v.add(frameLayout);
        }
        this.f54264v.get(intExtra).setSelected(true);
        for (ViewGroup viewGroup : this.f54264v) {
            viewGroup.setOnClickListener(new b());
        }
    }

    private void f0() {
        this.f54265w = (TextView) findViewById(R.id.text_view_rotate);
        int i4 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i4)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) findViewById(i4)).setMiddleLineColor(this.f54246d);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new d());
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new e());
    }

    private void g0() {
        this.f54266x = (TextView) findViewById(R.id.text_view_scale);
        int i4 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i4)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) findViewById(i4)).setMiddleLineColor(this.f54246d);
    }

    private void h0() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new i(imageView.getDrawable(), this.f54247e));
        imageView2.setImageDrawable(new i(imageView2.getDrawable(), this.f54247e));
        imageView3.setImageDrawable(new i(imageView3.getDrawable(), this.f54247e));
    }

    private void i0(@NonNull Intent intent) {
        this.f54245c = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.f54244b = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.f54246d = intent.getIntExtra("com.yalantis.ucrop.UcropColorWidgetActive", ContextCompat.getColor(this, R.color.ucrop_color_widget_background));
        this.f54247e = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", ContextCompat.getColor(this, R.color.ucrop_color_active_controls_color));
        this.f54248f = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.f54250h = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R.drawable.ucrop_ic_cross);
        this.f54251i = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.f54243a = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.f54243a = stringExtra;
        this.f54252j = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.f54253k = !intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.f54249g = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(this, R.color.ucrop_color_crop_background));
        d0();
        Q();
        if (this.f54253k) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.f54249g);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.f54268z = autoTransition;
            autoTransition.setDuration(50L);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.f54258p = viewGroup2;
            viewGroup2.setOnClickListener(this.E);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.f54259q = viewGroup3;
            viewGroup3.setOnClickListener(this.E);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.f54260r = viewGroup4;
            viewGroup4.setOnClickListener(this.E);
            this.f54261s = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.f54262t = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.f54263u = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            e0(intent);
            f0();
            g0();
            h0();
        }
    }

    protected void P() {
        this.f54267y.setClickable(true);
        this.f54254l = true;
        supportInvalidateOptionsMenu();
        this.f54256n.t(this.A, this.B, new h());
    }

    protected void Y(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    protected void Z(Uri uri, float f4, int i4, int i5, int i6, int i7) {
        setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f4).putExtra("com.yalantis.ucrop.ImageWidth", i6).putExtra("com.yalantis.ucrop.ImageHeight", i7).putExtra("com.yalantis.ucrop.OffsetX", i4).putExtra("com.yalantis.ucrop.OffsetY", i5));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.f54248f, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e4) {
                Log.i("UCropActivity", String.format("%s - %s", e4.getMessage(), getString(R.string.ucrop_mutate_exception_hint)));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.f54251i);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(this.f54248f, PorterDuff.Mode.SRC_ATOP);
            findItem2.setIcon(drawable);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            P();
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
        menu.findItem(R.id.menu_crop).setVisible(!this.f54254l);
        menu.findItem(R.id.menu_loader).setVisible(this.f54254l);
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.f54256n;
        if (gestureCropImageView != null) {
            gestureCropImageView.s();
        }
    }
}
