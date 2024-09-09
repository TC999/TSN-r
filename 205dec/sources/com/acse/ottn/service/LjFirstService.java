package com.acse.ottn.service;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.f0;
import com.acse.ottn.i2;
import com.acse.ottn.j0;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.q0;
import com.acse.ottn.s0;
import com.acse.ottn.service.C1391a;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.w1;
import com.acse.ottn.z1;
import com.google.gson.Gson;
import com.stub.StubApp;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class LjFirstService extends Service {

    /* renamed from: c  reason: collision with root package name */
    public static View f6342c = null;

    /* renamed from: d  reason: collision with root package name */
    public static WindowManager f6343d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f6344e = "MainService";

    /* renamed from: a  reason: collision with root package name */
    public WindowManager.LayoutParams f6345a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f6346b;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i2.a().a("tb_lj_bannner_close");
            j0.f5764f = false;
            LjFirstService.this.b();
            w1.b().a();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6348a;

        public b(AccessiblityModel accessiblityModel) {
            this.f6348a = accessiblityModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j0.f5764f = false;
            LjFirstService.this.b();
            i2.a().a("tb_lj_bannner_click");
            C1391a.b().a(LjFirstService.this, this.f6348a, (C1391a.m0) null);
            w1.b().a();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f6350a;

        public c(RelativeLayout relativeLayout) {
            this.f6350a = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            LjFirstService.this.a(this.f6350a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f6352a;

        public d(RelativeLayout relativeLayout) {
            this.f6352a = relativeLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f6352a.setScaleX(floatValue);
            this.f6352a.setScaleY(floatValue);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f6354a;

        public e(RelativeLayout relativeLayout) {
            this.f6354a = relativeLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Log.d("samon-->", "addUpdateListener");
            this.f6354a.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements Consumer<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6356a;

        public f(String str) {
            this.f6356a = str;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("r") == 1) {
                if (jSONObject.getInt("code") == 1) {
                    j0.f5764f = false;
                    LjFirstService.this.b(this.f6356a);
                    return;
                }
                j0.f5764f = false;
                LjFirstService.this.b();
                return;
            }
            j0.f5764f = false;
            LjFirstService.this.b();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements Consumer<Throwable> {
        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6360a;

        public i(String str) {
            this.f6360a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j0.f5764f = false;
            i2.a().a("tb_lj_bannner_setting");
            LjFirstService.this.a(this.f6360a);
        }
    }

    static {
        StubApp.interface11(5037);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra("model");
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                a(accessiblityModel);
            }
        } catch (Exception e4) {
            try {
                String str = f6344e;
                z1.a(str, "Exception =" + e4.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i4, i5);
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class h implements C1391a.m0 {
        public h() {
        }

        @Override // com.acse.ottn.service.C1391a.m0
        public void a() {
            j0.f5764f = false;
            LjFirstService.this.b();
        }

        @Override // com.acse.ottn.service.C1391a.m0
        public void a(String str) {
            j0.f5764f = false;
            LjFirstService.this.b();
        }
    }

    public void b() {
        try {
            View view = f6342c;
            if (view != null) {
                view.setVisibility(8);
            }
            f6343d.removeView(f6342c);
            stopSelf();
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a() {
        this.f6345a = new WindowManager.LayoutParams();
        f6343d = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6345a.type = 2038;
        } else {
            this.f6345a.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.f6345a;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.windowAnimations = 16973827;
        layoutParams.gravity = 85;
        layoutParams.x = 0;
        layoutParams.y = 690;
        layoutParams.width = -1;
    }

    public final void b(String str) {
        z1.c(f6344e, "noShowCoupon ");
        try {
            f6343d.removeView(f6342c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(R.layout.coupon_no_showbackground);
            C1391a.b().a(f6342c, str, false, (C1391a.m0) new h());
            WindowManager.LayoutParams layoutParams = this.f6345a;
            layoutParams.height = -2;
            f6343d.addView(f6342c, layoutParams);
        } catch (Exception e4) {
            String str2 = f6344e;
            z1.c(str2, "noShowCoupon e=" + e4.getMessage());
        }
    }

    public final void a(int i4) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i4, (ViewGroup) null);
            f6342c = inflate;
            inflate.measure(0, 0);
        } catch (Exception unused) {
        }
    }

    public void a(AccessiblityModel accessiblityModel) {
        a(R.layout.lj_first_background);
        this.f6345a.height = s0.a((Context) this, 100.0f);
        View view = f6342c;
        int i4 = R.id.beijing;
        a((ImageView) f6342c.findViewById(R.id.iv_setting2), accessiblityModel.getData().getPackage_name());
        ((ImageView) f6342c.findViewById(R.id.iv_didi_setting)).setOnClickListener(new a());
        ((RelativeLayout) view.findViewById(i4)).setOnClickListener(new b(accessiblityModel));
        ((TextView) f6342c.findViewById(R.id.firs_lj)).setText(accessiblityModel.getData().getNew_time_remaining());
        f6343d.addView(f6342c, this.f6345a);
        new Handler(Looper.getMainLooper()).postDelayed(new c((RelativeLayout) f6342c.findViewById(i4)), accessiblityModel.getData().getSecond_price());
    }

    public final void a(RelativeLayout relativeLayout) {
        relativeLayout.setPivotX(relativeLayout.getWidth());
        relativeLayout.setPivotY((relativeLayout.getHeight() * 2) / 3);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new d(relativeLayout));
        ofFloat.setDuration(300L);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(100.0f, 0.0f);
        ofFloat2.addUpdateListener(new e(relativeLayout));
        ofFloat2.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public final void a(String str) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("limitType", "lj");
        treeMap.put("is_snt", "0");
        treeMap.put("package_name", str);
        new f0().i(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new f(str), new g());
    }

    public final void a(ImageView imageView, String str) {
        imageView.setOnClickListener(new i(str));
    }
}
