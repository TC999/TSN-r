package com.acse.ottn.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.acse.ottn.R;
import com.acse.ottn.a4;
import com.acse.ottn.e1;
import com.acse.ottn.g1;
import com.acse.ottn.i2;
import com.acse.ottn.l0;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.q0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.widget.RoundRectImageView;
import com.acse.ottn.z1;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.TimerTask;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* renamed from: com.acse.ottn.service.a  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class C1391a {

    /* renamed from: c  reason: collision with root package name */
    public static String f6421c = "ViewUtil";

    /* renamed from: d  reason: collision with root package name */
    public static C1391a f6422d;

    /* renamed from: e  reason: collision with root package name */
    public static TimerTask f6423e;

    /* renamed from: a  reason: collision with root package name */
    public float f6424a;

    /* renamed from: b  reason: collision with root package name */
    public float f6425b;

    /* renamed from: com.acse.ottn.service.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class C0095a implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6426a;

        /* renamed from: com.acse.ottn.service.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class RunnableC0096a implements Runnable {
            public RunnableC0096a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.acse.ottn.j0.f5763e) {
                    return;
                }
                C1391a.a(C0095a.this.f6426a);
            }
        }

        /* renamed from: com.acse.ottn.service.a$a$b */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1391a.a(C0095a.this.f6426a);
            }
        }

        public C0095a(m0 m0Var) {
            this.f6426a = m0Var;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0096a(), 0L);
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(C1391a.f6421c, "\u7ed3\u675f\u4e86");
            new Handler(Looper.getMainLooper()).postDelayed(new b(), 0L);
        }
    }

    /* renamed from: com.acse.ottn.service.a$a0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6429a;

        public a0(m0 m0Var) {
            this.f6429a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6429a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$b */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6431a;

        public b(m0 m0Var) {
            this.f6431a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6431a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$b0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6435c;

        public b0(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6433a = context;
            this.f6434b = accessiblityModel;
            this.f6435c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6433a, this.f6434b, this.f6435c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$c */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6437a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6438b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6439c;

        public c(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6437a = context;
            this.f6438b = accessiblityModel;
            this.f6439c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6437a, this.f6438b, this.f6439c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$c0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c0 implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f6441a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f6442b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f6443c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ m0 f6444d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6445e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f6446f;

        public c0(RelativeLayout relativeLayout, float f4, float f5, m0 m0Var, AccessiblityModel accessiblityModel, Context context) {
            this.f6441a = relativeLayout;
            this.f6442b = f4;
            this.f6443c = f5;
            this.f6444d = m0Var;
            this.f6445e = accessiblityModel;
            this.f6446f = context;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            C1391a.d();
            int action = motionEvent.getAction();
            if (action == 0) {
                C1391a.this.f6424a = motionEvent.getX();
                C1391a.this.f6425b = motionEvent.getY();
            } else if (action == 1) {
                C1391a.b(4000, this.f6444d);
                if (C1391a.this.f6425b - motionEvent.getY() > 100.0f) {
                    this.f6441a.scrollTo(-((int) this.f6443c), 300);
                    i2.a().a("close_coupon_window");
                    C1391a.a(this.f6444d);
                } else if (motionEvent.getX() - C1391a.this.f6424a > g1.a().b("screenWidth") / 3) {
                    this.f6441a.scrollTo(g1.a().b("screenWidth"), (int) this.f6442b);
                    i2.a().a("close_coupon_window");
                    C1391a.a(this.f6444d);
                } else {
                    this.f6441a.scrollTo(0, 0);
                    if (Math.abs(C1391a.this.f6425b - motionEvent.getY()) < 100.0f && Math.abs(C1391a.this.f6424a - motionEvent.getX()) < 100.0f) {
                        z1.c(C1391a.f6421c, "\u70b9\u51fb\u4e86");
                        if (this.f6445e == null) {
                            return false;
                        }
                        C1391a.d();
                        C1391a.a(this.f6444d);
                        C1391a.this.a(this.f6446f, this.f6445e, this.f6444d);
                    }
                    return false;
                }
            } else if (action == 2) {
                if (Math.abs(motionEvent.getX() - C1391a.this.f6424a) > Math.abs(motionEvent.getY() - C1391a.this.f6425b)) {
                    if (motionEvent.getX() - C1391a.this.f6424a < 0.0f) {
                        return false;
                    }
                    this.f6441a.scrollTo(-((int) (motionEvent.getX() - C1391a.this.f6424a)), -((int) this.f6442b));
                } else if (motionEvent.getY() - C1391a.this.f6425b > 0.0f) {
                    return false;
                } else {
                    this.f6441a.scrollTo(-((int) this.f6443c), -((int) (motionEvent.getY() - C1391a.this.f6425b)));
                }
            }
            return true;
        }
    }

    /* renamed from: com.acse.ottn.service.a$d */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6448a;

        public d(m0 m0Var) {
            this.f6448a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6448a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$d0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d0 implements Consumer<String> {
        public d0() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            z1.b("ShopHelperService", "cutdown=" + str);
        }
    }

    /* renamed from: com.acse.ottn.service.a$e */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6451a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6452b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6453c;

        public e(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6451a = context;
            this.f6452b = accessiblityModel;
            this.f6453c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6451a, this.f6452b, this.f6453c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$e0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e0 implements Consumer<Throwable> {
        public e0() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* renamed from: com.acse.ottn.service.a$f */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6456a;

        public f(m0 m0Var) {
            this.f6456a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6456a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$f0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f0 implements Consumer<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6458a;

        public f0(m0 m0Var) {
            this.f6458a = m0Var;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            String str = C1391a.f6421c;
            z1.b(str, "\u62a5\u9519\u4e86=" + th.getMessage());
            C1391a.a(this.f6458a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$g */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6460a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6461b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6462c;

        public g(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6460a = context;
            this.f6461b = accessiblityModel;
            this.f6462c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6460a, this.f6461b, this.f6462c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$g0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6464a;

        public g0(m0 m0Var) {
            this.f6464a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6464a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$h */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6466a;

        public h(m0 m0Var) {
            this.f6466a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6466a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$h0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class h0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6468a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6469b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6470c;

        public h0(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6468a = context;
            this.f6469b = accessiblityModel;
            this.f6470c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6468a, this.f6469b, this.f6470c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$i */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6472a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6473b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6474c;

        public i(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6472a = context;
            this.f6473b = accessiblityModel;
            this.f6474c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6472a, this.f6473b, this.f6474c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$i0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class i0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6476a;

        public i0(m0 m0Var) {
            this.f6476a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6476a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$j */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6478a;

        public j(m0 m0Var) {
            this.f6478a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6478a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$j0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class j0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6480a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6481b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6482c;

        public j0(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6480a = context;
            this.f6481b = accessiblityModel;
            this.f6482c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6480a, this.f6481b, this.f6482c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$k */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6484a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6485b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6486c;

        public k(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6484a = context;
            this.f6485b = accessiblityModel;
            this.f6486c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6484a, this.f6485b, this.f6486c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$k0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class k0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6488a;

        public k0(m0 m0Var) {
            this.f6488a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6488a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$l */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6490a;

        public l(m0 m0Var) {
            this.f6490a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6490a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$l0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class l0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6492a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6493b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6494c;

        public l0(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6492a = context;
            this.f6493b = accessiblityModel;
            this.f6494c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6492a, this.f6493b, this.f6494c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$m */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6496a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6497b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6498c;

        public m(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6496a = context;
            this.f6497b = accessiblityModel;
            this.f6498c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6496a, this.f6497b, this.f6498c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$m0 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface m0 {
        void a();

        void a(String str);
    }

    /* renamed from: com.acse.ottn.service.a$n */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6500a;

        public n(m0 m0Var) {
            this.f6500a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6500a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$o */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6502a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6503b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6504c;

        public o(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6502a = context;
            this.f6503b = accessiblityModel;
            this.f6504c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6502a, this.f6503b, this.f6504c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$p */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6506a;

        public p(m0 m0Var) {
            this.f6506a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6506a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$q */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6508a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6509b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6510c;

        public q(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6508a = context;
            this.f6509b = accessiblityModel;
            this.f6510c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6508a, this.f6509b, this.f6510c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$r */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6512a;

        public r(m0 m0Var) {
            this.f6512a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i2.a().a("close_coupon_window");
            C1391a.a(this.f6512a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$s */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6514a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m0 f6515b;

        public s(String str, m0 m0Var) {
            this.f6514a = str;
            this.f6515b = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6514a, this.f6515b);
        }
    }

    /* renamed from: com.acse.ottn.service.a$t */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class t implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6517a;

        public t(m0 m0Var) {
            this.f6517a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6517a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$u */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class u implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6519a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6520b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6521c;

        public u(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6519a = context;
            this.f6520b = accessiblityModel;
            this.f6521c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6519a, this.f6520b, this.f6521c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$v */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class v implements Consumer<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6523a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6524b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f6525c;

        public v(m0 m0Var, AccessiblityModel accessiblityModel, Context context) {
            this.f6523a = m0Var;
            this.f6524b = accessiblityModel;
            this.f6525c = context;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("r") == 0) {
                C1391a.a(this.f6523a);
                return;
            }
            String string = jSONObject.getString("gwc_link");
            this.f6524b.getData().setSpop_deeplink(jSONObject.getString("gwc_deeplink"));
            this.f6524b.getData().setSpop_link(string);
            a4.b().b(this.f6525c, this.f6524b);
            C1391a.a(this.f6523a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$w */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class w implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6527a;

        public w(m0 m0Var) {
            this.f6527a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6527a);
        }
    }

    /* renamed from: com.acse.ottn.service.a$x */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class x implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6529a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6530b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m0 f6531c;

        public x(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
            this.f6529a = context;
            this.f6530b = accessiblityModel;
            this.f6531c = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.this.a(this.f6529a, this.f6530b, this.f6531c);
        }
    }

    /* renamed from: com.acse.ottn.service.a$y */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class y implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6533a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6534b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f6535c;

        public y(m0 m0Var, String str, boolean z3) {
            this.f6533a = m0Var;
            this.f6534b = str;
            this.f6535c = z3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f6533a != null) {
                C1391a.this.a(this.f6534b, this.f6535c);
                C1391a.a(this.f6533a);
            }
        }
    }

    /* renamed from: com.acse.ottn.service.a$z */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class z implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f6537a;

        public z(m0 m0Var) {
            this.f6537a = m0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1391a.a(this.f6537a);
        }
    }

    public static C1391a b() {
        if (f6422d == null) {
            synchronized (C1391a.class) {
                if (f6422d == null) {
                    f6422d = new C1391a();
                }
            }
        }
        return f6422d;
    }

    public final Object c() throws ObjectStreamException {
        return f6422d;
    }

    public void d(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.aiqiyi_close).setOnClickListener(new g0(m0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_aiqiyi);
        linearLayout.setOnClickListener(new h0(context, accessiblityModel, m0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getNew_time_remaining()) || a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getOriginal_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.aiqiyi_monery)).setText(accessiblityModel.getData().getSpop_coupon_price());
        TextView textView = (TextView) view.findViewById(R.id.aiqiyi_all_monery);
        textView.setText(accessiblityModel.getData().getOriginal_price());
        textView.getPaint().setFlags(16);
        ((TextView) view.findViewById(R.id.aiqiyi_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, m0Var);
    }

    public void e(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.youku_close).setOnClickListener(new b(m0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.youku_wp);
        linearLayout.setOnClickListener(new c(context, accessiblityModel, m0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.youku_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.youku_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, m0Var);
    }

    public void f(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.didi_close).setOnClickListener(new p(m0Var));
        ((LinearLayout) view.findViewById(R.id.didi_big)).setOnClickListener(new q(context, accessiblityModel, m0Var));
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void g(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        TextView textView = (TextView) view.findViewById(R.id.didi_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.didi_small_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.didi_small);
        a((ImageView) view.findViewById(R.id.iv_didi_close), m0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_didi_setting), accessiblityModel.getData().getPackage_name(), m0Var);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, m0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void h(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        TextView textView = (TextView) view.findViewById(R.id.meituan_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.meituan_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.meituan_small_layout);
        a((ImageView) view.findViewById(R.id.iv_meituan_smile_close), m0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_meituan_smile_setting), accessiblityModel.getData().getPackage_name(), m0Var);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, m0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void i(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.meituan_close).setOnClickListener(new t(m0Var));
        view.setOnClickListener(new u(context, accessiblityModel, m0Var));
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void j(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.iv_close).setOnClickListener(new d(m0Var));
        ((ImageView) view.findViewById(R.id.taobao_treasure_box)).setOnClickListener(new e(context, accessiblityModel, m0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(R.id.tb_coupon_price)).setText("\u00a5" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.tb_textview)).setText(accessiblityModel.getData().getSpop_coupon_title());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void k(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_tb_big_recommend_icon);
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            com.bumptech.glide.d.C(context).a(accessiblityModel.getData().getSpop_pic()).j1(roundRectImageView);
        }
        TextView textView = (TextView) view.findViewById(R.id.tb_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tb_small);
        a((ImageView) view.findViewById(R.id.iv_smill_close), m0Var);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_setting);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a(imageView, accessiblityModel.getData().getPackage_name(), m0Var);
        a(context, relativeLayout, accessiblityModel, m0Var);
        textView.setText(accessiblityModel.getData().getSpop_title());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void l(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.jd_lijin_close).setOnClickListener(new l(m0Var));
        ((LinearLayout) view.findViewById(R.id.jd_lijin_big)).setOnClickListener(new m(context, accessiblityModel, m0Var));
        com.bumptech.glide.d.C(context).p(Integer.valueOf(R.mipmap.cash)).j1((ImageView) view.findViewById(R.id.jd_lijin_coupon_price));
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void m(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_tb_big_recommend_icon);
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            com.bumptech.glide.d.C(context).a(accessiblityModel.getData().getSpop_pic()).j1(roundRectImageView);
        }
        TextView textView = (TextView) view.findViewById(R.id.tb_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.tb_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tb_small);
        a((ImageView) view.findViewById(R.id.iv_smill_close), m0Var);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_setting);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a(imageView, accessiblityModel.getData().getPackage_name(), m0Var);
        a(context, relativeLayout, accessiblityModel, m0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void n(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.xbk_close).setOnClickListener(new w(m0Var));
        view.setOnClickListener(new x(context, accessiblityModel, m0Var));
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void o(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.eleme_close).setOnClickListener(new n(m0Var));
        view.setOnClickListener(new o(context, accessiblityModel, m0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.eleme_coupon_price)).setText("\u00a5" + accessiblityModel.getData().getSpop_coupon_price());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void p(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        TextView textView = (TextView) view.findViewById(R.id.eleme_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.eleme_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.eleme_small_layout);
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_close), m0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_setting), accessiblityModel.getData().getPackage_name(), m0Var);
        a(context, relativeLayout, accessiblityModel, m0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void q(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.hxz_close).setOnClickListener(new f(m0Var));
        ((LinearLayout) view.findViewById(R.id.hxz_big)).setOnClickListener(new g(context, accessiblityModel, m0Var));
        if (a(accessiblityModel.getData().getNew_time_remaining()) || a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(R.id.hxz_content_info)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void r(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.jd_close).setOnClickListener(new h(m0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.jd_big);
        linearLayout.setOnClickListener(new i(context, accessiblityModel, m0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.jd_coupon_price)).setText("\u00a5" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.jd_action_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void s(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.jd_lijin_close).setOnClickListener(new j(m0Var));
        ((LinearLayout) view.findViewById(R.id.jd_lijin_big)).setOnClickListener(new k(context, accessiblityModel, m0Var));
        com.bumptech.glide.d.C(context).p(Integer.valueOf(R.mipmap.cash)).j1((ImageView) view.findViewById(R.id.jd_lijin_coupon_price));
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void t(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_jd_recommend_icon);
        TextView textView = (TextView) view.findViewById(R.id.jd_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.jd_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.jd_small);
        a((ImageView) view.findViewById(R.id.iv_jd_smill_close), m0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_pic()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_jd_smill_setting), accessiblityModel.getData().getPackage_name(), m0Var);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, m0Var);
        com.bumptech.glide.d.C(context).a(accessiblityModel.getData().getSpop_pic()).j1(roundRectImageView);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, m0Var);
    }

    public void c(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.tencent_close).setOnClickListener(new k0(m0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.tencent_wp);
        linearLayout.setOnClickListener(new l0(context, accessiblityModel, m0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.tencent_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.tencent_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, m0Var);
    }

    public static void a(String str, m0 m0Var) {
        d();
        if (m0Var != null) {
            m0Var.a(str);
        }
    }

    public static void a(m0 m0Var) {
        TimerTask timerTask = f6423e;
        if (timerTask != null) {
            timerTask.cancel();
            f6423e = null;
        }
        d();
        if (m0Var != null) {
            m0Var.a();
        }
    }

    public static void b(int i4, m0 m0Var) {
        f6423e = com.acse.ottn.l0.a().b(i4, 500, new C0095a(m0Var));
    }

    public void b(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.taobao_close).setOnClickListener(new a0(m0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_taobao_man);
        ImageView imageView = (ImageView) view.findViewById(R.id.taobao_main_box);
        imageView.setOnClickListener(new b0(context, accessiblityModel, m0Var));
        if (TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            return;
        }
        com.bumptech.glide.d.C(context).a(accessiblityModel.getData().getSpop_pic()).j1(imageView);
        linearLayout.setVisibility(0);
        b(10000, m0Var);
    }

    public void a(Context context, AccessiblityModel accessiblityModel, m0 m0Var) {
        if (!TextUtils.isEmpty(accessiblityModel.getData().getTkl_url())) {
            Intent intent = new Intent(context, DemoService.class);
            intent.putExtra("tkl_url", accessiblityModel.getData().getTkl_url());
            context.startService(intent);
        }
        if (com.acse.ottn.j0.f5762d) {
            HelpShopAppUtil.getInstance();
            Toast.makeText(context, HelpShopAppUtil.sessionNewID(), 1).show();
        }
        z1.c(f6421c, "\u5f00\u59cb\u70b9\u51fb");
        if (a(accessiblityModel.getData().getSpop_link()) || a(accessiblityModel.getData().getSpop_deeplink())) {
            return;
        }
        if (!"1".equals(accessiblityModel.getData().getPic_type()) && !"1".equals(accessiblityModel.getData().getShort_link())) {
            a4.b().b(context, accessiblityModel);
            a(m0Var);
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("spop_coupon_price", accessiblityModel.getData().getSpop_coupon_price());
        treeMap.put("app", accessiblityModel.getData().getPackage_name());
        treeMap.put("spop_link", accessiblityModel.getData().getSpop_link());
        new e1().b(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new v(m0Var, accessiblityModel, context), new f0(m0Var));
    }

    public static void d() {
        try {
            if (f6423e != null) {
                z1.a(f6421c, "timer is not null");
                f6423e.cancel();
                f6423e = null;
            }
        } catch (Exception unused) {
            z1.a(f6421c, "current window is Destroy");
        }
    }

    public void a(Context context, View view, AccessiblityModel accessiblityModel, m0 m0Var) {
        view.findViewById(R.id.baidu_wp_close).setOnClickListener(new i0(m0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.baidu_wp);
        linearLayout.setOnClickListener(new j0(context, accessiblityModel, m0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.baidu_wp_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.baidu_wp_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, m0Var);
    }

    public final void a(ImageView imageView, m0 m0Var) {
        imageView.setOnClickListener(new r(m0Var));
    }

    public final void a(ImageView imageView, String str, m0 m0Var) {
        imageView.setOnClickListener(new s(str, m0Var));
    }

    public void a(View view, String str, boolean z3, m0 m0Var) {
        ((TextView) view.findViewById(R.id.tv_close)).setOnClickListener(new y(m0Var, str, z3));
        ((ImageView) view.findViewById(R.id.iv_no_show_smill_close)).setOnClickListener(new z(m0Var));
        b(4000, m0Var);
    }

    public final void a(Context context, RelativeLayout relativeLayout, AccessiblityModel accessiblityModel, m0 m0Var) {
        relativeLayout.setOnTouchListener(new c0(relativeLayout, relativeLayout.getY(), relativeLayout.getX(), m0Var, accessiblityModel, context));
    }

    public final void a(String str, boolean z3) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("limitType", z3 ? PangleAdapterUtils.MEDIA_EXTRA_COUPON : "lj");
        treeMap.put("is_snt", "0");
        treeMap.put("package_name", str);
        new com.acse.ottn.f0().o(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new d0(), new e0());
    }

    public final boolean a(String str) {
        return TextUtils.isEmpty(str);
    }
}
