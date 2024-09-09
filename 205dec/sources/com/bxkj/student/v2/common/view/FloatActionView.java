package com.bxkj.student.v2.common.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.jpush.android.service.JNotifyActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.base.v2.http.result.ApiResult;
import com.bxkj.student.App;
import com.bxkj.student.splash.OpenPrivacyAgreementActivity;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.bxkj.student.splash.SplashActivity;
import com.bxkj.student.splash.WelcomeActivity;
import com.bxkj.student.v2.common.utils.i;
import com.bxkj.student.v2.common.view.a;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.j;
import d2.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.p;
import kotlin.r;
import kotlinx.coroutines.flow.x;
import kotlinx.coroutines.h3;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatActionView.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b#\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/bxkj/student/v2/common/view/FloatActionView;", "", "Lkotlin/f1;", "w", "s", "t", "n", "", "isShow", "v", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", CampaignEx.JSON_KEY_AD_Q, "()Landroid/app/Activity;", "u", "(Landroid/app/Activity;)V", "mActivity", "b", "Z", "isMove", "Lcom/bxkj/student/v2/repository/a;", "c", "Lkotlin/p;", "r", "()Lcom/bxkj/student/v2/repository/a;", "mFloatActionRepository", "Landroid/view/View;", "d", "Landroid/view/View;", "mFloatView", "Lkotlinx/coroutines/q0;", "e", "Lkotlinx/coroutines/q0;", "coroutineScope", "<init>", "f", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FloatActionView {

    /* renamed from: g  reason: collision with root package name */
    private static int f23443g;

    /* renamed from: h  reason: collision with root package name */
    private static int f23444h;

    /* renamed from: k  reason: collision with root package name */
    private static float f23447k;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private Activity f23448a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23449b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final p f23450c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private View f23451d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final q0 f23452e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final a f23442f = new a(null);

    /* renamed from: i  reason: collision with root package name */
    private static final float f23445i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private static final float f23446j = 0.2f;

    /* compiled from: FloatActionView.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/bxkj/student/v2/common/view/FloatActionView$a;", "", "", "DIMMED_OPACITY", "F", "FULL_OPACITY", "currentOpacity", "", "x", "I", "y", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* compiled from: FloatActionView.kt */
    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0012"}, d2 = {"com/bxkj/student/v2/common/view/FloatActionView$b", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "", "a", "F", "initialX", "b", "initialY", "c", "moveX", "d", "moveY", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private float f23453a;

        /* renamed from: b  reason: collision with root package name */
        private float f23454b;

        /* renamed from: c  reason: collision with root package name */
        private float f23455c;

        /* renamed from: d  reason: collision with root package name */
        private float f23456d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f23457e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ FloatActionView f23458f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ViewGroup f23459g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ WindowManager.LayoutParams f23460h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ WindowManager f23461i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ int f23462j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ int f23463k;

        b(View view, FloatActionView floatActionView, ViewGroup viewGroup, WindowManager.LayoutParams layoutParams, WindowManager windowManager, int i4, int i5) {
            this.f23457e = view;
            this.f23458f = floatActionView;
            this.f23459g = viewGroup;
            this.f23460h = layoutParams;
            this.f23461i = windowManager;
            this.f23462j = i4;
            this.f23463k = i5;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            float width;
            f0.p(v3, "v");
            f0.p(event, "event");
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                com.bxkj.student.v2.common.view.a.f23523a.c();
                a aVar = FloatActionView.f23442f;
                FloatActionView.f23447k = FloatActionView.f23445i;
                this.f23457e.animate().alpha(FloatActionView.f23447k).setDuration(300L).start();
                this.f23458f.f23449b = false;
                this.f23453a = event.getRawX();
                this.f23454b = event.getRawY();
                this.f23455c = 0.0f;
                this.f23456d = 0.0f;
            } else if (actionMasked == 1) {
                com.bxkj.student.v2.common.view.a.f23523a.f();
                if (((double) this.f23455c) == 0.0d) {
                    if (((double) this.f23456d) == 0.0d) {
                        j.d("\u79fb\u52a8\u7ed3\u675f\uff0c\u6ca1\u6709\u4f4d\u7f6e\u79fb\u52a8,\u53ef\u4ee5\u54cd\u5e94\u5176\u4ed6\u4e8b\u4ef6", new Object[0]);
                        this.f23458f.f23449b = false;
                        return false;
                    }
                }
                j.d("\u79fb\u52a8\u7ed3\u675f\uff0c\u6709\u4f4d\u7f6e\u79fb\u52a8,\u4e0d\u8981\u76f8\u5e94\u957f\u6309\u4e8b\u4ef6", new Object[0]);
                this.f23458f.f23449b = true;
                v3.getX();
                if (((int) event.getRawX()) < this.f23462j) {
                    width = cn.bluemobi.dylan.base.utils.u.a(10.0f, this.f23458f.q());
                } else {
                    width = (this.f23463k - v3.getWidth()) - cn.bluemobi.dylan.base.utils.u.a(10.0f, this.f23458f.q());
                }
                a aVar2 = FloatActionView.f23442f;
                FloatActionView.f23443g = (int) width;
                FloatActionView.f23444h = ((int) event.getRawY()) - this.f23459g.getHeight();
                this.f23460h.x = FloatActionView.f23443g;
                this.f23460h.y = FloatActionView.f23444h;
                this.f23461i.updateViewLayout(this.f23459g, this.f23460h);
                return true;
            } else if (actionMasked == 2) {
                a aVar3 = FloatActionView.f23442f;
                FloatActionView.f23443g = ((int) event.getRawX()) - (this.f23459g.getWidth() / 2);
                FloatActionView.f23444h = ((int) event.getRawY()) - this.f23459g.getHeight();
                this.f23460h.x = FloatActionView.f23443g;
                this.f23460h.y = FloatActionView.f23444h;
                this.f23455c = event.getRawX() - this.f23453a;
                this.f23456d = event.getRawY() - this.f23454b;
                if (Math.abs(this.f23455c) > 0.0d || Math.abs(this.f23456d) > 0.0d) {
                    this.f23461i.updateViewLayout(this.f23459g, this.f23460h);
                    this.f23458f.f23449b = true;
                    j.d("\u79fb\u52a8\u8fc7\u7a0b\u4e2d,\u4e0d\u8981\u76f8\u5e94\u957f\u6309\u4e8b\u4ef6", new Object[0]);
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatActionView.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.common.view.FloatActionView$createFloatView$2$3$1", f = "FloatActionView.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class c extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23464a;

        c(kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new c(cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f23464a;
            try {
                if (i4 == 0) {
                    d0.n(obj);
                    com.bxkj.student.v2.repository.a r3 = FloatActionView.this.r();
                    this.f23464a = 1;
                    obj = r3.a(this);
                    if (obj == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    d0.n(obj);
                }
                ApiResult apiResult = (ApiResult) obj;
                Map map = apiResult == null ? null : (Map) apiResult.apiData();
                m mVar = m.a;
                String t3 = mVar.t(map, "name");
                String t4 = mVar.t(map, "linkUrl");
                i iVar = i.f23368a;
                Activity q3 = FloatActionView.this.q();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("name", t3);
                linkedHashMap.put("linkUrl", t4);
                f1 f1Var = f1.f55527a;
                iVar.b(q3, linkedHashMap);
            } catch (Exception e4) {
                j.c(e4.getMessage());
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatActionView.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class d extends Lambda implements l<iOSTwoButtonDialog, f1> {
        d() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            com.bxkj.base.v2.data.a.f18673h.a().R(false);
            LocalBroadcastManager.getInstance(FloatActionView.this.q()).sendBroadcast(new Intent(f0.C(App.n().getPackageName(), ".FloatActionView")).putExtra("isShow", false));
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* compiled from: FloatActionView.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class e extends Lambda implements d2.a<com.bxkj.student.v2.repository.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f23474a = new e();

        e() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.a invoke() {
            return new com.bxkj.student.v2.repository.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatActionView.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.common.view.FloatActionView$subscribeToCountdownEvents$1", f = "FloatActionView.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class f extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23475a;

        /* compiled from: FloatActionView.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FloatActionView f23477a;

            a(FloatActionView floatActionView) {
                this.f23477a = floatActionView;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f23477a.s();
            }
        }

        /* compiled from: Collect.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class b implements kotlinx.coroutines.flow.i<a.AbstractC0294a> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FloatActionView f23478a;

            public b(FloatActionView floatActionView) {
                this.f23478a = floatActionView;
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object emit(a.AbstractC0294a abstractC0294a, @NotNull kotlin.coroutines.c cVar) {
                a.AbstractC0294a abstractC0294a2 = abstractC0294a;
                if (abstractC0294a2 instanceof a.AbstractC0294a.c) {
                    j.d("\u5012\u8ba1\u65f6\u5f00\u59cb", new Object[0]);
                } else if (abstractC0294a2 instanceof a.AbstractC0294a.b) {
                    j.d("\u5012\u8ba1\u65f6\u7ed3\u675f", new Object[0]);
                    this.f23478a.q().runOnUiThread(new a(this.f23478a));
                } else if (abstractC0294a2 instanceof a.AbstractC0294a.C0295a) {
                    j.d("\u5012\u8ba1\u65f6\u53d6\u6d88", new Object[0]);
                }
                return f1.f55527a;
            }
        }

        f(kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new f(cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((f) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f23475a;
            if (i4 == 0) {
                d0.n(obj);
                x<a.AbstractC0294a> d4 = com.bxkj.student.v2.common.view.a.f23523a.d();
                b bVar = new b(FloatActionView.this);
                this.f23475a = 1;
                if (d4.e(bVar, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    public FloatActionView(@NotNull Activity mActivity) {
        p a4;
        f0.p(mActivity, "mActivity");
        this.f23448a = mActivity;
        a4 = r.a(e.f23474a);
        this.f23450c = a4;
        this.f23452e = r0.a(kotlinx.coroutines.f1.a().plus(h3.c(null, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FloatActionView this$0, View view) {
        ComponentActivity componentActivity;
        f0.p(this$0, "this$0");
        Activity q3 = this$0.q();
        if (!(this$0.q() instanceof ComponentActivity)) {
            q3 = null;
        }
        if (q3 == null || (componentActivity = (ComponentActivity) this$0.q()) == null) {
            return;
        }
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(componentActivity), kotlinx.coroutines.f1.c(), null, new c(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(FloatActionView this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.f23449b) {
            return true;
        }
        j.d("\u957f\u6309\u4e86,\u4e0d\u8981\u76f8\u5e94\u79fb\u52a8\u4e8b\u4ef6", new Object[0]);
        ContextExtKt.h(this$0.q(), "\u662f\u5426\u5173\u95ed\u60ac\u6d6e\u6309\u94ae?", "\u5173\u95ed\u540e\u53ef\u5728\u3010\u6211\u7684\u3011->\u3010\u5173\u4e8e\u3011->\u3010\u60ac\u6d6e\u5f00\u5173\u3011\u4e2d\u518d\u6b21\u5f00\u542f\u548c\u5173\u95ed", new d(), (l) null, "\u663e\u793a", "\u5173\u95ed", 8, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.a r() {
        return (com.bxkj.student.v2.repository.a) this.f23450c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        f23447k = f23446j;
        View view = this.f23451d;
        if (view == null || (animate = view.animate()) == null || (alpha = animate.alpha(f23447k)) == null || (duration = alpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        View view = this.f23451d;
        if (view == null || (animate = view.animate()) == null || (alpha = animate.alpha(f23447k)) == null || (duration = alpha.setDuration(0L)) == null) {
            return;
        }
        duration.start();
    }

    private final void w() {
        kotlinx.coroutines.j.f(this.f23452e, null, null, new f(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.bxkj.student.v2.common.view.FloatActionView$createFloatView$showHideBroadCast$1, android.content.BroadcastReceiver] */
    public final void n() {
        Activity activity = this.f23448a;
        if ((activity instanceof SplashActivity) || (activity instanceof SelectSchoolV2Activity) || (activity instanceof WelcomeActivity) || (activity instanceof OpenPrivacyAgreementActivity) || (activity instanceof JNotifyActivity)) {
            return;
        }
        if (!((activity instanceof H5AppActivity) && activity.getIntent().hasExtra("title") && f0.g(this.f23448a.getIntent().getStringExtra("title"), "\u5e2e\u52a9\u4e0e\u5ba2\u670d")) && LoginUser.getLoginUser().getSysType() == 2) {
            final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            final WindowManager windowManager = this.f23448a.getWindowManager();
            layoutParams.type = 2;
            layoutParams.format = 1;
            layoutParams.flags = 8;
            layoutParams.gravity = 51;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f23448a.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i4 = displayMetrics.widthPixels;
            int i5 = displayMetrics.heightPixels;
            int i6 = i4 / 2;
            if (f23443g == 0) {
                f23443g = (int) (i4 - cn.bluemobi.dylan.base.utils.u.a(60.0f, this.f23448a));
            }
            if (f23444h == 0) {
                f23444h = i5 / 2;
            }
            layoutParams.x = f23443g;
            layoutParams.y = f23444h;
            j.d("x=" + f23443g + ",y=" + f23444h, new Object[0]);
            layoutParams.width = cn.bluemobi.dylan.base.utils.u.a(50.0f, this.f23448a);
            layoutParams.height = cn.bluemobi.dylan.base.utils.u.a(50.0f, this.f23448a);
            LayoutInflater layoutInflater = this.f23448a.getLayoutInflater();
            f0.o(layoutInflater, "mActivity.layoutInflater");
            View inflate = layoutInflater.inflate(2131427638, (ViewGroup) null);
            if (inflate != null) {
                final ViewGroup viewGroup = (ViewGroup) inflate;
                final View findViewById = viewGroup.findViewById(2131232322);
                this.f23451d = findViewById;
                windowManager.addView(viewGroup, layoutParams);
                if (f23447k == 0.0f) {
                    f23447k = f23445i;
                    com.bxkj.student.v2.common.view.a.f23523a.f();
                }
                t();
                w();
                findViewById.setOnTouchListener(new b(findViewById, this, viewGroup, layoutParams, windowManager, i6, i4));
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.common.view.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FloatActionView.o(FloatActionView.this, view);
                    }
                });
                findViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bxkj.student.v2.common.view.e
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean p3;
                        p3 = FloatActionView.p(FloatActionView.this, view);
                        return p3;
                    }
                });
                final ?? r7 = new BroadcastReceiver() { // from class: com.bxkj.student.v2.common.view.FloatActionView$createFloatView$showHideBroadCast$1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                        if (intent == null) {
                            return;
                        }
                        if (!intent.hasExtra("isShow")) {
                            intent = null;
                        }
                        if (intent == null) {
                            return;
                        }
                        FloatActionView.this.v(intent.getBooleanExtra("isShow", true));
                    }
                };
                LocalBroadcastManager.getInstance(this.f23448a).registerReceiver(r7, new IntentFilter(f0.C(App.n().getPackageName(), ".FloatActionView")));
                Activity activity2 = this.f23448a;
                if (activity2 instanceof ComponentActivity) {
                    ((ComponentActivity) activity2).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.v2.common.view.FloatActionView$createFloatView$4
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            LocalBroadcastManager.getInstance(this.q()).unregisterReceiver(r7);
                            windowManager.removeViewImmediate(findViewById);
                        }

                        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                        public final void onResume() {
                            layoutParams.x = FloatActionView.f23443g;
                            layoutParams.y = FloatActionView.f23444h;
                            windowManager.updateViewLayout(viewGroup, layoutParams);
                            this.t();
                        }
                    });
                }
                v(com.bxkj.base.v2.data.a.f18673h.a().i());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    @NotNull
    public final Activity q() {
        return this.f23448a;
    }

    public final void u(@NotNull Activity activity) {
        f0.p(activity, "<set-?>");
        this.f23448a = activity;
    }

    public final void v(boolean z3) {
        View view = this.f23451d;
        if (view == null) {
            return;
        }
        view.setVisibility(z3 ? 0 : 8);
    }
}
