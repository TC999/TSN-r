package com.bxkj.student.v2.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.q;
import kotlin.text.w;
import kotlin.text.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.q0;
import l1.p;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MainViewModel.kt */
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b@\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bm\u0010nJ\"\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0002J1\u0010\f\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJg\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n2\u0006\u0010\t\u001a\u00020\u00042 \u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020#H\u0002J\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0007J\u000e\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0004R<\u00107\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R<\u0010;\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106R(\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u00102\u001a\u0004\b=\u00104\"\u0004\b>\u00106R(\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u00102\u001a\u0004\bA\u00104\"\u0004\bB\u00106R(\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u00102\u001a\u0004\bE\u00104\"\u0004\bF\u00106R6\u0010K\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u00102\u001a\u0004\bI\u00104\"\u0004\bJ\u00106R<\u0010O\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u00102\u001a\u0004\bM\u00104\"\u0004\bN\u00106R<\u0010S\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u00102\u001a\u0004\bQ\u00104\"\u0004\bR\u00106R<\u0010W\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u00102\u001a\u0004\bU\u00104\"\u0004\bV\u00106R6\u0010[\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u00102\u001a\u0004\bY\u00104\"\u0004\bZ\u00106R6\u0010_\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u00102\u001a\u0004\b]\u00104\"\u0004\b^\u00106R(\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u00102\u001a\u0004\ba\u00104\"\u0004\bb\u00106R\u001b\u0010i\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0014\u0010l\u001a\u00020j8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bk\u00103\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006o"}, d2 = {"Lcom/bxkj/student/v2/vm/MainViewModel;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "", "", "", "menuListMap", "Lkotlin/f1;", "G", "menuType", "", "", "U", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "onlineMenus", "Landroidx/lifecycle/MutableLiveData;", "refreshLiveData", "", "forceUpdate", "s0", "(Ljava/util/List;Ljava/lang/String;Landroidx/lifecycle/MutableLiveData;Ljava/lang/Boolean;Lkotlin/coroutines/c;)Ljava/lang/Object;", "iconUrl", DomainCampaignEx.LOOPBACK_KEY, "E", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "F", "url", "name", "Ljava/io/File;", "B", "D", "C", "contentType", "R", "imageName", "", "Y", "resourceId", "Q", "N", "K", "a0", "W", "f0", "H", "d0", "T", "id", "A", "h", "Landroidx/lifecycle/MutableLiveData;", "J", "()Landroidx/lifecycle/MutableLiveData;", "h0", "(Landroidx/lifecycle/MutableLiveData;)V", "bottomNavigationMenu", "i", "O", "l0", "homeMenuList", "j", "P", "m0", "homeNewsLinkUrl", "k", "M", "k0", "discoveryLinkUrl", "l", "Z", "p0", "msgLinkUrl", "m", "c0", "r0", "userInfoMap", "n", "L", "i0", "classifyMenuList", "o", "b0", "q0", "myMenuList", "p", "I", "g0", "bannerList", CampaignEx.JSON_KEY_AD_Q, "e0", "j0", "isDefaultPassword", "r", "S", "n0", "latestUnreadNotice", "s", "V", "o0", "logOutLiveData", "Lcom/bxkj/student/v2/repository/b;", "t", "Lkotlin/o;", "X", "()Lcom/bxkj/student/v2/repository/b;", "mainRepository", "", "u", "buildTimeStamp", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class MainViewModel extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private MutableLiveData<List<Map<String, Object>>> f24340h = new MutableLiveData<>();
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private MutableLiveData<List<Map<String, Object>>> f24341i = new MutableLiveData<>();
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private MutableLiveData<String> f24342j = new MutableLiveData<>();
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private MutableLiveData<String> f24343k = new MutableLiveData<>();
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private MutableLiveData<String> f24344l = new MutableLiveData<>();
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24345m = new MutableLiveData<>();
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private MutableLiveData<List<Map<String, Object>>> f24346n = new MutableLiveData<>();
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private MutableLiveData<List<Map<String, Object>>> f24347o = new MutableLiveData<>();
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private MutableLiveData<List<Map<String, Object>>> f24348p = new MutableLiveData<>();
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24349q = new MutableLiveData<>();
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24350r = new MutableLiveData<>();
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private MutableLiveData<Boolean> f24351s = new MutableLiveData<>();
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final o f24352t = q.c(m.f24399a);

    /* renamed from: u  reason: collision with root package name */
    private final long f24353u = 1708917797352L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$clickArticle$1", f = "MainViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24354a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24356c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f24356c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f24356c, cVar);
        }

        @Override // l1.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24354a;
            try {
                if (i4 == 0) {
                    d0.n(obj);
                    com.bxkj.student.v2.repository.b X = MainViewModel.this.X();
                    String str = this.f24356c;
                    this.f24354a = 1;
                    if (X.a(str, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    d0.n(obj);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$downloadMenuIcon$2", f = "MainViewModel.kt", i = {}, l = {446}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24357a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24359c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24360d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f24359c = str;
            this.f24360d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new b(this.f24359c, this.f24360d, cVar);
        }

        @Override // l1.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24357a;
            if (i4 == 0) {
                d0.n(obj);
                File B = MainViewModel.this.B(this.f24359c, this.f24360d);
                if (B == null) {
                    return null;
                }
                if (!B.exists()) {
                    B = null;
                }
                if (B == null) {
                    return null;
                }
                String str = this.f24360d;
                com.bxkj.student.v2.common.db.dao.c k4 = AppDatabase.f23168a.a().k();
                if (k4 == null) {
                    return null;
                }
                String path = B.getPath();
                f0.o(path, "it.path");
                this.f24357a = 1;
                if (k4.b(path, str, this) == h4) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$downloadMenuIconS$2", f = "MainViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24361a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24363c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24364d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f24363c = str;
            this.f24364d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new c(this.f24363c, this.f24364d, cVar);
        }

        @Override // l1.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24361a;
            if (i4 == 0) {
                d0.n(obj);
                File B = MainViewModel.this.B(this.f24363c, f0.C(this.f24364d, "s"));
                if (B == null) {
                    return null;
                }
                if (!B.exists()) {
                    B = null;
                }
                if (B == null) {
                    return null;
                }
                String str = this.f24364d;
                com.bxkj.student.v2.common.db.dao.c k4 = AppDatabase.f23168a.a().k();
                if (k4 == null) {
                    return null;
                }
                String path = B.getPath();
                f0.o(path, "it.path");
                this.f24361a = 1;
                if (k4.c(path, str, this) == h4) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getBanner$1", f = "MainViewModel.kt", i = {}, l = {591}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24365a;

        d(kotlin.coroutines.c<? super d> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new d(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((d) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24365a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.b X = MainViewModel.this.X();
                this.f24365a = 1;
                obj = X.b(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            List<Map<String, Object>> list = (List) obj;
            if (list != null) {
                MainViewModel.this.I().postValue(list);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getClassifyMenu$1", f = "MainViewModel.kt", i = {1, 1, 2, 3, 3}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 200, 206}, m = "invokeSuspend", n = {"destination$iv$iv", "mutableMapOf", "localClassifyMenu", "it", "needUpdate"}, s = {"L$1", "L$3", "L$0", "L$1", "L$2"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24367a;

        /* renamed from: b  reason: collision with root package name */
        Object f24368b;

        /* renamed from: c  reason: collision with root package name */
        Object f24369c;

        /* renamed from: d  reason: collision with root package name */
        Object f24370d;

        /* renamed from: e  reason: collision with root package name */
        Object f24371e;

        /* renamed from: f  reason: collision with root package name */
        Object f24372f;

        /* renamed from: g  reason: collision with root package name */
        Object f24373g;

        /* renamed from: h  reason: collision with root package name */
        int f24374h;

        e(kotlin.coroutines.c<? super e> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new e(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((e) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0121  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0148 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0190 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01a0  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0200  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x023d  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0240  */
        /* JADX WARN: Type inference failed for: r2v27, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v26, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r8v10, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r9v12, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00fc -> B:29:0x0104). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x022d -> B:70:0x0230). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r27) {
            /*
                Method dump skipped, instructions count: 610
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getHomeMenu$1", f = "MainViewModel.kt", i = {1, 2, 3}, l = {53, 65, 70, 98, 100}, m = "invokeSuspend", n = {"localNavMenu", "localNavMenu", "commonMenus"}, s = {"L$0", "L$0", "L$0"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class f extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24376a;

        /* renamed from: b  reason: collision with root package name */
        int f24377b;

        f(kotlin.coroutines.c<? super f> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new f(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((f) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0203 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0204  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x021e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0177 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:109:0x01aa A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x011f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x017d  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01b0  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01d2  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01db  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 546
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getLatestUnreadNotice$1", f = "MainViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVREAGE_BITRATE_DIFF}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class g extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24379a;

        g(kotlin.coroutines.c<? super g> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new g(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((g) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24379a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.b X = MainViewModel.this.X();
                this.f24379a = 1;
                obj = X.e(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                MainViewModel.this.S().postValue(map);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel", f = "MainViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC}, m = "getLocalMenu", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class h extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f24381a;

        /* renamed from: c  reason: collision with root package name */
        int f24383c;

        h(kotlin.coroutines.c<? super h> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f24381a = obj;
            this.f24383c |= Integer.MIN_VALUE;
            return MainViewModel.this.U(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getLoginUserInfo$1", f = "MainViewModel.kt", i = {}, l = {574}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class i extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24384a;

        i(kotlin.coroutines.c<? super i> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new i(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((i) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24384a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.b X = MainViewModel.this.X();
                this.f24384a = 1;
                obj = X.f(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                MainViewModel.this.c0().postValue(map);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getMyMenu$1", f = "MainViewModel.kt", i = {1, 1, 2, 3, 3}, l = {219, 225, 232, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME}, m = "invokeSuspend", n = {"destination$iv$iv", "mutableMapOf", "localMyMenu", "it", "needUpdate"}, s = {"L$1", "L$3", "L$0", "L$1", "L$2"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class j extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24386a;

        /* renamed from: b  reason: collision with root package name */
        Object f24387b;

        /* renamed from: c  reason: collision with root package name */
        Object f24388c;

        /* renamed from: d  reason: collision with root package name */
        Object f24389d;

        /* renamed from: e  reason: collision with root package name */
        Object f24390e;

        /* renamed from: f  reason: collision with root package name */
        Object f24391f;

        /* renamed from: g  reason: collision with root package name */
        Object f24392g;

        /* renamed from: h  reason: collision with root package name */
        int f24393h;

        j(kotlin.coroutines.c<? super j> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new j(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((j) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x010b  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0143 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x018c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x019c  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01fa  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0237  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x023a  */
        /* JADX WARN: Type inference failed for: r12v11, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r2v27, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v27, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r8v14, types: [java.util.Map] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00f4 -> B:29:0x00fd). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0227 -> B:70:0x022a). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r29) {
            /*
                Method dump skipped, instructions count: 604
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$isDefaultPass$1", f = "MainViewModel.kt", i = {}, l = {600}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class k extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24395a;

        k(kotlin.coroutines.c<? super k> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new k(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((k) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24395a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.b X = MainViewModel.this.X();
                this.f24395a = 1;
                obj = X.i(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                MainViewModel.this.e0().postValue(map);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$logout$1", f = "MainViewModel.kt", i = {}, l = {583}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class l extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24397a;

        l(kotlin.coroutines.c<? super l> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new l(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((l) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24397a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.b X = MainViewModel.this.X();
                this.f24397a = 1;
                if (X.j(this) == h4) {
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class m extends Lambda implements l1.a<com.bxkj.student.v2.repository.b> {

        /* renamed from: a  reason: collision with root package name */
        public static final m f24399a = new m();

        m() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.b invoke() {
            return new com.bxkj.student.v2.repository.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MainViewModel.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel", f = "MainViewModel.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 404, 412, 424}, m = "updateLocalData", n = {"this", "onlineMenus", "menuType", "refreshLiveData", "needUpdate", "this", "onlineMenus", "menuType", "refreshLiveData", "needUpdate", "localMenu", "this", "menuType", "refreshLiveData", "needUpdate", "map", DomainCampaignEx.LOOPBACK_KEY, "lastUploadTime", "name", "sort", "isShow", "isEnabled", "linkUrl", "isShowIndex", "index$iv", "index", "isLogin", "this", "menuType", "refreshLiveData", "needUpdate", "map", DomainCampaignEx.LOOPBACK_KEY, "navMenu", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", DomainCampaignEx.LOOPBACK_KEY, "iconSUrl", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "map", DomainCampaignEx.LOOPBACK_KEY, "localMenuInfo", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "map", DomainCampaignEx.LOOPBACK_KEY, "localMenuInfo", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "this", "refreshLiveData", "needUpdate", "destination$iv$iv", "mutableMapOf"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "I$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$6"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class n extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        Object f24400a;

        /* renamed from: b  reason: collision with root package name */
        Object f24401b;

        /* renamed from: c  reason: collision with root package name */
        Object f24402c;

        /* renamed from: d  reason: collision with root package name */
        Object f24403d;

        /* renamed from: e  reason: collision with root package name */
        Object f24404e;

        /* renamed from: f  reason: collision with root package name */
        Object f24405f;

        /* renamed from: g  reason: collision with root package name */
        Object f24406g;

        /* renamed from: h  reason: collision with root package name */
        Object f24407h;

        /* renamed from: i  reason: collision with root package name */
        Object f24408i;

        /* renamed from: j  reason: collision with root package name */
        Object f24409j;

        /* renamed from: k  reason: collision with root package name */
        Object f24410k;

        /* renamed from: l  reason: collision with root package name */
        Object f24411l;

        /* renamed from: m  reason: collision with root package name */
        Object f24412m;

        /* renamed from: n  reason: collision with root package name */
        Object f24413n;

        /* renamed from: o  reason: collision with root package name */
        int f24414o;

        /* renamed from: p  reason: collision with root package name */
        int f24415p;

        /* renamed from: q  reason: collision with root package name */
        boolean f24416q;

        /* renamed from: r  reason: collision with root package name */
        /* synthetic */ Object f24417r;

        /* renamed from: t  reason: collision with root package name */
        int f24419t;

        n(kotlin.coroutines.c<? super n> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f24417r = obj;
            this.f24419t |= Integer.MIN_VALUE;
            return MainViewModel.this.s0(null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File B(String str, String str2) {
        boolean u22;
        u22 = w.u2(str, "http", false, 2, null);
        if (u22) {
            com.orhanobut.logger.j.m("\u4ece\u7f51\u7edc\u4e0b\u8f7d\u56fe\u7247 url = " + str + " name = " + str2, new Object[0]);
            return C(str, str2);
        }
        com.orhanobut.logger.j.d("\u4ecemipmap\u4e0b\u8f7d\u56fe\u7247 url = " + str + " name = " + str2, new Object[0]);
        return D(str, str2);
    }

    private final File C(String str, String str2) {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            SSLSocketFactory b4 = com.bxkj.base.v2.http.a.b();
            f0.o(b4, "getSSLSocketFactory()");
            TrustManager trustManager = com.bxkj.base.v2.http.a.c()[0];
            if (trustManager != null) {
                OkHttpClient.Builder sslSocketFactory = builder.sslSocketFactory(b4, (X509TrustManager) trustManager);
                HostnameVerifier a4 = com.bxkj.base.v2.http.a.a();
                f0.o(a4, "getHostnameVerifier()");
                Response execute = sslSocketFactory.hostnameVerifier(a4).build().newCall(new Request.Builder().url(str).build()).execute();
                String R = R(Response.header$default(execute, "Content-Type", null, 2, null));
                ResponseBody body = execute.body();
                if (body != null) {
                    File file = new File(BaseApp.b().getFilesDir().getPath(), RewardPlus.ICON);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(file, str2 + '.' + R);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    InputStream byteStream = body.byteStream();
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = byteStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                f1 f1Var = f1.f55527a;
                                kotlin.io.b.a(byteStream, null);
                                kotlin.io.b.a(fileOutputStream, null);
                                kotlin.io.b.a(execute, null);
                                return file2;
                            }
                        }
                    } finally {
                    }
                } else {
                    kotlin.io.b.a(execute, null);
                    return null;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
        } catch (Exception e4) {
            com.orhanobut.logger.j.c(e4.getMessage());
            return null;
        }
    }

    private final File D(String str, String str2) {
        try {
            File file = new File(BaseApp.b().getFilesDir().getPath(), RewardPlus.ICON);
            if (!file.exists()) {
                file.mkdir();
            }
            Locale locale = Locale.getDefault();
            f0.o(locale, "getDefault()");
            if (str2 != null) {
                String lowerCase = str2.toLowerCase(locale);
                f0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                int Y = Y(lowerCase);
                File file2 = new File(file, str2 + '.' + Q(Y));
                InputStream openRawResource = BaseApp.b().getResources().openRawResource(Y);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = openRawResource.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        f1 f1Var = f1.f55527a;
                        kotlin.io.b.a(fileOutputStream, null);
                        kotlin.io.b.a(openRawResource, null);
                        return file2;
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } catch (Exception e4) {
            com.orhanobut.logger.j.c(e4.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object E(String str, String str2, kotlin.coroutines.c<? super f1> cVar) {
        return kotlinx.coroutines.h.i(kotlinx.coroutines.f1.c(), new b(str, str2, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object F(String str, String str2, kotlin.coroutines.c<? super f1> cVar) {
        return kotlinx.coroutines.h.i(kotlinx.coroutines.f1.c(), new c(str, str2, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void G(java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r27) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.G(java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
        r5 = kotlin.text.x.t5(r5, com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst.sSeparator, null, 2, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String Q(int r5) {
        /*
            r4 = this;
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            com.bxkj.base.BaseApp r1 = com.bxkj.base.BaseApp.b()
            android.content.res.Resources r1 = r1.getResources()
            android.graphics.BitmapFactory.decodeResource(r1, r5, r0)
            java.lang.String r5 = r0.outMimeType
            java.lang.String r0 = "png"
            if (r5 != 0) goto L1a
            goto L26
        L1a:
            r1 = 2
            java.lang.String r2 = "/"
            r3 = 0
            java.lang.String r5 = kotlin.text.n.t5(r5, r2, r3, r1, r3)
            if (r5 != 0) goto L25
            goto L26
        L25:
            r0 = r5
        L26:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.Q(int):java.lang.String");
    }

    private final String R(String str) {
        boolean V2;
        if (str != null) {
            V2 = x.V2(str, "image/jpeg", false, 2, null);
            if (V2) {
                return "jpg";
            }
            x.V2(str, "image/png", false, 2, null);
            return "png";
        }
        return "png";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object U(java.lang.String r7, kotlin.coroutines.c<? super java.util.List<? extends java.util.Map<java.lang.String, java.lang.Object>>> r8) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.U(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.b X() {
        return (com.bxkj.student.v2.repository.b) this.f24352t.getValue();
    }

    private final int Y(String str) {
        return BaseApp.b().getResources().getIdentifier(f0.C("mipmap/", str), null, BaseApp.b().getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x091c, code lost:
        if (r10.equals(r43) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0923, code lost:
        if (r10.equals(r0) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x092a, code lost:
        if (r10.equals(r2) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x092d, code lost:
        if (r3 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0931, code lost:
        r5.postValue(r3);
        r0 = kotlin.f1.f55527a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x093e, code lost:
        if (r10.equals(r42) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0944, code lost:
        if (r3 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0946, code lost:
        r10 = r6;
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x094a, code lost:
        r7 = new java.util.ArrayList(kotlin.collections.v.Y(r3, 10));
        r8 = r3.iterator();
        r10 = r6;
        r14 = r11;
        r3 = r13;
        r11 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x07bd  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x07ca  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0829  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x082b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x082e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0871  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0873  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0877  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0912  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0938  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0965  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x09bb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0503  */
    /* JADX WARN: Type inference failed for: r2v38, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r50v0, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r5v52, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r7v33, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r7v53, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r7v73, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r8v7, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r9v43, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:154:0x06e9 -> B:166:0x073c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:159:0x06ff -> B:166:0x073c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x0732 -> B:165:0x0733). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:203:0x08aa -> B:204:0x08ae). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:242:0x09a7 -> B:243:0x09ac). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x039a -> B:52:0x03e9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x03a8 -> B:51:0x03d1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x03c2 -> B:50:0x03c8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s0(java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r47, java.lang.String r48, androidx.lifecycle.MutableLiveData<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r49, java.lang.Boolean r50, kotlin.coroutines.c<? super java.lang.Boolean> r51) {
        /*
            Method dump skipped, instructions count: 2560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.s0(java.util.List, java.lang.String, androidx.lifecycle.MutableLiveData, java.lang.Boolean, kotlin.coroutines.c):java.lang.Object");
    }

    static /* synthetic */ Object t0(MainViewModel mainViewModel, List list, String str, MutableLiveData mutableLiveData, Boolean bool, kotlin.coroutines.c cVar, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            bool = Boolean.FALSE;
        }
        return mainViewModel.s0(list, str, mutableLiveData, bool, cVar);
    }

    public final void A(@NotNull String id) {
        f0.p(id, "id");
        kotlinx.coroutines.h.f(ViewModelKt.getViewModelScope(this), (kotlin.coroutines.f) null, (CoroutineStart) null, new a(id, null), 3, (Object) null);
    }

    public final void H() {
        BaseViewModel.j(this, new d(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> I() {
        return this.f24348p;
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> J() {
        return this.f24340h;
    }

    public final void K() {
        BaseViewModel.j(this, new e(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> L() {
        return this.f24346n;
    }

    @NotNull
    public final MutableLiveData<String> M() {
        return this.f24343k;
    }

    public final void N() {
        BaseViewModel.j(this, new f(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> O() {
        return this.f24341i;
    }

    @NotNull
    public final MutableLiveData<String> P() {
        return this.f24342j;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> S() {
        return this.f24350r;
    }

    public final void T() {
        if (com.bxkj.base.v2.data.a.b.a().y()) {
            BaseViewModel.j(this, new g(null), null, null, null, null, null, null, null, 254, null);
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> V() {
        return this.f24351s;
    }

    public final void W() {
        BaseViewModel.j(this, new i(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<String> Z() {
        return this.f24344l;
    }

    public final void a0() {
        BaseViewModel.j(this, new j(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> b0() {
        return this.f24347o;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> c0() {
        return this.f24345m;
    }

    public final void d0() {
        BaseViewModel.j(this, new k(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> e0() {
        return this.f24349q;
    }

    public final void f0() {
        BaseViewModel.j(this, new l(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void g0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24348p = mutableLiveData;
    }

    public final void h0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24340h = mutableLiveData;
    }

    public final void i0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24346n = mutableLiveData;
    }

    public final void j0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24349q = mutableLiveData;
    }

    public final void k0(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24343k = mutableLiveData;
    }

    public final void l0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24341i = mutableLiveData;
    }

    public final void m0(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24342j = mutableLiveData;
    }

    public final void n0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24350r = mutableLiveData;
    }

    public final void o0(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24351s = mutableLiveData;
    }

    public final void p0(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24344l = mutableLiveData;
    }

    public final void q0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24347o = mutableLiveData;
    }

    public final void r0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24345m = mutableLiveData;
    }
}
