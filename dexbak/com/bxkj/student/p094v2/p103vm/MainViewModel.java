package com.bxkj.student.p094v2.p103vm;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.p085v2.http.SSLSocketClient;
import com.bxkj.student.p094v2.common.p095db.AppDatabase;
import com.bxkj.student.p094v2.common.p095db.dao.MenuDao;
import com.bxkj.student.p094v2.repository.MainRepository;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.orhanobut.logger.C11792j;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.dns.DnsRecord;
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
import kotlin.C14294d0;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.p613io.Closeable;
import kotlin.text.C14579x;
import kotlin.text.StringsJVM;
import kotlinx.coroutines.C15057h;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import master.flame.danmaku.danmaku.parser.IDataSource;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: MainViewModel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b@\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bm\u0010nJ\"\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0002J1\u0010\f\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJg\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n2\u0006\u0010\t\u001a\u00020\u00042 \u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020#H\u0002J\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0007J\u000e\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0004R<\u00107\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R<\u0010;\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106R(\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00102\u001a\u0004\b=\u00104\"\u0004\b>\u00106R(\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u00102\u001a\u0004\bA\u00104\"\u0004\bB\u00106R(\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u00102\u001a\u0004\bE\u00104\"\u0004\bF\u00106R6\u0010K\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u00102\u001a\u0004\bI\u00104\"\u0004\bJ\u00106R<\u0010O\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u00102\u001a\u0004\bM\u00104\"\u0004\bN\u00106R<\u0010S\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\n0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u00102\u001a\u0004\bQ\u00104\"\u0004\bR\u00106R<\u0010W\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u00102\u001a\u0004\bU\u00104\"\u0004\bV\u00106R6\u0010[\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u00102\u001a\u0004\bY\u00104\"\u0004\bZ\u00106R6\u0010_\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u00102\u001a\u0004\b]\u00104\"\u0004\b^\u00106R(\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u00102\u001a\u0004\ba\u00104\"\u0004\bb\u00106R\u001b\u0010i\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0014\u0010l\u001a\u00020j8\u0002X\u0082D¢\u0006\u0006\n\u0004\bk\u00103\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006o"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/MainViewModel;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "", "", "", "menuListMap", "Lkotlin/f1;", "G", "menuType", "", "", "U", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "onlineMenus", "Landroidx/lifecycle/MutableLiveData;", "refreshLiveData", "", "forceUpdate", "s0", "(Ljava/util/List;Ljava/lang/String;Landroidx/lifecycle/MutableLiveData;Ljava/lang/Boolean;Lkotlin/coroutines/c;)Ljava/lang/Object;", "iconUrl", DomainCampaignEx.LOOPBACK_KEY, ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "F", "url", "name", "Ljava/io/File;", "B", "D", "C", "contentType", "R", "imageName", "", "Y", "resourceId", "Q", "N", "K", "a0", ExifInterface.LONGITUDE_WEST, "f0", "H", "d0", ExifInterface.GPS_DIRECTION_TRUE, "id", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "h", "Landroidx/lifecycle/MutableLiveData;", "J", "()Landroidx/lifecycle/MutableLiveData;", "h0", "(Landroidx/lifecycle/MutableLiveData;)V", "bottomNavigationMenu", "i", "O", "l0", "homeMenuList", "j", "P", "m0", "homeNewsLinkUrl", "k", "M", "k0", "discoveryLinkUrl", C7304t.f25048d, "Z", C7202bq.f24604g, "msgLinkUrl", "m", "c0", "r0", "userInfoMap", "n", "L", "i0", "classifyMenuList", "o", "b0", "q0", "myMenuList", "p", "I", "g0", "bannerList", CampaignEx.JSON_KEY_AD_Q, "e0", "j0", "isDefaultPassword", "r", ExifInterface.LATITUDE_SOUTH, "n0", "latestUnreadNotice", "s", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "o0", "logOutLiveData", "Lcom/bxkj/student/v2/repository/b;", UMCommonContent.f37782aL, "Lkotlin/o;", "X", "()Lcom/bxkj/student/v2/repository/b;", "mainRepository", "", "u", "buildTimeStamp", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.MainViewModel */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MainViewModel extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private MutableLiveData<List<Map<String, Object>>> f20920h = new MutableLiveData<>();
    @NotNull

    /* renamed from: i */
    private MutableLiveData<List<Map<String, Object>>> f20921i = new MutableLiveData<>();
    @NotNull

    /* renamed from: j */
    private MutableLiveData<String> f20922j = new MutableLiveData<>();
    @NotNull

    /* renamed from: k */
    private MutableLiveData<String> f20923k = new MutableLiveData<>();
    @NotNull

    /* renamed from: l */
    private MutableLiveData<String> f20924l = new MutableLiveData<>();
    @NotNull

    /* renamed from: m */
    private MutableLiveData<Map<String, Object>> f20925m = new MutableLiveData<>();
    @NotNull

    /* renamed from: n */
    private MutableLiveData<List<Map<String, Object>>> f20926n = new MutableLiveData<>();
    @NotNull

    /* renamed from: o */
    private MutableLiveData<List<Map<String, Object>>> f20927o = new MutableLiveData<>();
    @NotNull

    /* renamed from: p */
    private MutableLiveData<List<Map<String, Object>>> f20928p = new MutableLiveData<>();
    @NotNull

    /* renamed from: q */
    private MutableLiveData<Map<String, Object>> f20929q = new MutableLiveData<>();
    @NotNull

    /* renamed from: r */
    private MutableLiveData<Map<String, Object>> f20930r = new MutableLiveData<>();
    @NotNull

    /* renamed from: s */
    private MutableLiveData<Boolean> f20931s = new MutableLiveData<>();
    @NotNull

    /* renamed from: t */
    private final InterfaceC14378o f20932t;

    /* renamed from: u */
    private final long f20933u;

    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$clickArticle$1", m8638f = "MainViewModel.kt", m8637i = {}, m8636l = {620}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5839a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20934a;

        /* renamed from: c */
        final /* synthetic */ String f20936c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5839a(String str, InterfaceC14268c<? super C5839a> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f20936c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5839a(this.f20936c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5839a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20934a;
            try {
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    MainRepository m38162X = MainViewModel.this.m38162X();
                    String str = this.f20936c;
                    this.f20934a = 1;
                    if (m38162X.m39004a(str, this) == m8642h) {
                        return m8642h;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    C14294d0.m8596n(obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$downloadMenuIcon$2", m8638f = "MainViewModel.kt", m8637i = {}, m8636l = {446}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5840b extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20937a;

        /* renamed from: c */
        final /* synthetic */ String f20939c;

        /* renamed from: d */
        final /* synthetic */ String f20940d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5840b(String str, String str2, InterfaceC14268c<? super C5840b> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f20939c = str;
            this.f20940d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5840b(this.f20939c, this.f20940d, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5840b) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20937a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                File m38184B = MainViewModel.this.m38184B(this.f20939c, this.f20940d);
                if (m38184B == null) {
                    return null;
                }
                if (!m38184B.exists()) {
                    m38184B = null;
                }
                if (m38184B == null) {
                    return null;
                }
                String str = this.f20940d;
                MenuDao mo39226k = AppDatabase.f19934a.m39228a().mo39226k();
                if (mo39226k == null) {
                    return null;
                }
                String path = m38184B.getPath();
                C14342f0.m8185o(path, "it.path");
                this.f20937a = 1;
                if (mo39226k.mo39203b(path, str, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$downloadMenuIconS$2", m8638f = "MainViewModel.kt", m8637i = {}, m8636l = {458}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5841c extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20941a;

        /* renamed from: c */
        final /* synthetic */ String f20943c;

        /* renamed from: d */
        final /* synthetic */ String f20944d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5841c(String str, String str2, InterfaceC14268c<? super C5841c> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f20943c = str;
            this.f20944d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5841c(this.f20943c, this.f20944d, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5841c) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20941a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                File m38184B = MainViewModel.this.m38184B(this.f20943c, C14342f0.m8216C(this.f20944d, "s"));
                if (m38184B == null) {
                    return null;
                }
                if (!m38184B.exists()) {
                    m38184B = null;
                }
                if (m38184B == null) {
                    return null;
                }
                String str = this.f20944d;
                MenuDao mo39226k = AppDatabase.f19934a.m39228a().mo39226k();
                if (mo39226k == null) {
                    return null;
                }
                String path = m38184B.getPath();
                C14342f0.m8185o(path, "it.path");
                this.f20941a = 1;
                if (mo39226k.mo39202c(path, str, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$getBanner$1", m8638f = "MainViewModel.kt", m8637i = {}, m8636l = {591}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5842d extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20945a;

        C5842d(InterfaceC14268c<? super C5842d> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5842d(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5842d) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20945a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                MainRepository m38162X = MainViewModel.this.m38162X();
                this.f20945a = 1;
                obj = m38162X.m39003b(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            List<Map<String, Object>> list = (List) obj;
            if (list != null) {
                MainViewModel.this.m38177I().postValue(list);
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$getClassifyMenu$1", m8638f = "MainViewModel.kt", m8637i = {1, 1, 2, 3, 3}, m8636l = {157, 164, 171, 200, AdEventType.VIDEO_COMPLETE}, m8635m = "invokeSuspend", m8634n = {"destination$iv$iv", "mutableMapOf", "localClassifyMenu", "it", "needUpdate"}, m8633s = {"L$1", "L$3", "L$0", "L$1", "L$2"})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5843e extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f20947a;

        /* renamed from: b */
        Object f20948b;

        /* renamed from: c */
        Object f20949c;

        /* renamed from: d */
        Object f20950d;

        /* renamed from: e */
        Object f20951e;

        /* renamed from: f */
        Object f20952f;

        /* renamed from: g */
        Object f20953g;

        /* renamed from: h */
        int f20954h;

        C5843e(InterfaceC14268c<? super C5843e> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5843e(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5843e) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
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
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.MainViewModel.C5843e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$getHomeMenu$1", m8638f = "MainViewModel.kt", m8637i = {1, 2, 3}, m8636l = {53, 65, 70, 98, 100}, m8635m = "invokeSuspend", m8634n = {"localNavMenu", "localNavMenu", "commonMenus"}, m8633s = {"L$0", "L$0", "L$0"})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5844f extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f20956a;

        /* renamed from: b */
        int f20957b;

        C5844f(InterfaceC14268c<? super C5844f> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5844f(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5844f) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
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
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.MainViewModel.C5844f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$getLatestUnreadNotice$1", m8638f = "MainViewModel.kt", m8637i = {}, m8636l = {610}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5845g extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20959a;

        C5845g(InterfaceC14268c<? super C5845g> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5845g(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5845g) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20959a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                MainRepository m38162X = MainViewModel.this.m38162X();
                this.f20959a = 1;
                obj = m38162X.m39000e(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                MainViewModel.this.m38167S().postValue(map);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainViewModel.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel", m8638f = "MainViewModel.kt", m8637i = {}, m8636l = {277, 278}, m8635m = "getLocalMenu", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5846h extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20961a;

        /* renamed from: c */
        int f20963c;

        C5846h(InterfaceC14268c<? super C5846h> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20961a = obj;
            this.f20963c |= Integer.MIN_VALUE;
            return MainViewModel.this.m38165U(null, this);
        }
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$getLoginUserInfo$1", m8638f = "MainViewModel.kt", m8637i = {}, m8636l = {574}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5847i extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20964a;

        C5847i(InterfaceC14268c<? super C5847i> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5847i(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5847i) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20964a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                MainRepository m38162X = MainViewModel.this.m38162X();
                this.f20964a = 1;
                obj = m38162X.m38999f(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                MainViewModel.this.m38157c0().postValue(map);
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$getMyMenu$1", m8638f = "MainViewModel.kt", m8637i = {1, 1, 2, 3, 3}, m8636l = {219, 225, 232, 260, 266}, m8635m = "invokeSuspend", m8634n = {"destination$iv$iv", "mutableMapOf", "localMyMenu", "it", "needUpdate"}, m8633s = {"L$1", "L$3", "L$0", "L$1", "L$2"})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5848j extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f20966a;

        /* renamed from: b */
        Object f20967b;

        /* renamed from: c */
        Object f20968c;

        /* renamed from: d */
        Object f20969d;

        /* renamed from: e */
        Object f20970e;

        /* renamed from: f */
        Object f20971f;

        /* renamed from: g */
        Object f20972g;

        /* renamed from: h */
        int f20973h;

        C5848j(InterfaceC14268c<? super C5848j> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5848j(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5848j) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
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
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.MainViewModel.C5848j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$isDefaultPass$1", m8638f = "MainViewModel.kt", m8637i = {}, m8636l = {600}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5849k extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20975a;

        C5849k(InterfaceC14268c<? super C5849k> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5849k(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5849k) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20975a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                MainRepository m38162X = MainViewModel.this.m38162X();
                this.f20975a = 1;
                obj = m38162X.m38996i(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                MainViewModel.this.m38155e0().postValue(map);
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel$logout$1", m8638f = "MainViewModel.kt", m8637i = {}, m8636l = {583}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5850l extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20977a;

        C5850l(InterfaceC14268c<? super C5850l> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5850l(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5850l) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20977a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                MainRepository m38162X = MainViewModel.this.m38162X();
                this.f20977a = 1;
                if (m38162X.m38995j(this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/b;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5851m extends Lambda implements InterfaceC15269a<MainRepository> {

        /* renamed from: a */
        public static final C5851m f20979a = new C5851m();

        C5851m() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final MainRepository invoke() {
            return new MainRepository();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainViewModel.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.MainViewModel", m8638f = "MainViewModel.kt", m8637i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10}, m8636l = {310, 315, 335, 364, 370, 374, 387, 395, 404, TTAdConstant.IMAGE_URL_CODE, 424}, m8635m = "updateLocalData", m8634n = {"this", "onlineMenus", "menuType", "refreshLiveData", "needUpdate", "this", "onlineMenus", "menuType", "refreshLiveData", "needUpdate", "localMenu", "this", "menuType", "refreshLiveData", "needUpdate", "map", DomainCampaignEx.LOOPBACK_KEY, "lastUploadTime", "name", "sort", "isShow", "isEnabled", "linkUrl", "isShowIndex", "index$iv", "index", "isLogin", "this", "menuType", "refreshLiveData", "needUpdate", "map", DomainCampaignEx.LOOPBACK_KEY, "navMenu", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", DomainCampaignEx.LOOPBACK_KEY, "iconSUrl", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "map", DomainCampaignEx.LOOPBACK_KEY, "localMenuInfo", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "map", DomainCampaignEx.LOOPBACK_KEY, "localMenuInfo", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "index$iv", "this", "menuType", "refreshLiveData", "needUpdate", "this", "refreshLiveData", "needUpdate", "destination$iv$iv", "mutableMapOf"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "I$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$6"})
    /* renamed from: com.bxkj.student.v2.vm.MainViewModel$n */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5852n extends ContinuationImpl {

        /* renamed from: a */
        Object f20980a;

        /* renamed from: b */
        Object f20981b;

        /* renamed from: c */
        Object f20982c;

        /* renamed from: d */
        Object f20983d;

        /* renamed from: e */
        Object f20984e;

        /* renamed from: f */
        Object f20985f;

        /* renamed from: g */
        Object f20986g;

        /* renamed from: h */
        Object f20987h;

        /* renamed from: i */
        Object f20988i;

        /* renamed from: j */
        Object f20989j;

        /* renamed from: k */
        Object f20990k;

        /* renamed from: l */
        Object f20991l;

        /* renamed from: m */
        Object f20992m;

        /* renamed from: n */
        Object f20993n;

        /* renamed from: o */
        int f20994o;

        /* renamed from: p */
        int f20995p;

        /* renamed from: q */
        boolean f20996q;

        /* renamed from: r */
        /* synthetic */ Object f20997r;

        /* renamed from: t */
        int f20999t;

        C5852n(InterfaceC14268c<? super C5852n> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20997r = obj;
            this.f20999t |= Integer.MIN_VALUE;
            return MainViewModel.this.m38141s0(null, null, null, null, this);
        }
    }

    public MainViewModel() {
        InterfaceC14378o m7719c;
        m7719c = C14389r.m7719c(C5851m.f20979a);
        this.f20932t = m7719c;
        this.f20933u = 1708917797352L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public final File m38184B(String str, String str2) {
        boolean m6548u2;
        m6548u2 = StringsJVM.m6548u2(str, IDataSource.f43971a, false, 2, null);
        if (m6548u2) {
            C11792j.m20460m("从网络下载图片 url = " + str + " name = " + str2, new Object[0]);
            return m38183C(str, str2);
        }
        C11792j.m20469d("从mipmap下载图片 url = " + str + " name = " + str2, new Object[0]);
        return m38182D(str, str2);
    }

    /* renamed from: C */
    private final File m38183C(String str, String str2) {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            SSLSocketFactory m43539b = SSLSocketClient.m43539b();
            C14342f0.m8185o(m43539b, "getSSLSocketFactory()");
            TrustManager trustManager = SSLSocketClient.m43538c()[0];
            if (trustManager != null) {
                OkHttpClient.Builder sslSocketFactory = builder.sslSocketFactory(m43539b, (X509TrustManager) trustManager);
                HostnameVerifier m43540a = SSLSocketClient.m43540a();
                C14342f0.m8185o(m43540a, "getHostnameVerifier()");
                Response execute = sslSocketFactory.hostnameVerifier(m43540a).build().newCall(new Request.Builder().url(str).build()).execute();
                String m38168R = m38168R(Response.header$default(execute, "Content-Type", null, 2, null));
                ResponseBody body = execute.body();
                if (body != null) {
                    File file = new File(BaseApp.m44341b().getFilesDir().getPath(), RewardPlus.ICON);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(file, str2 + '.' + m38168R);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    InputStream byteStream = body.byteStream();
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = byteStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                Unit unit = Unit.f41048a;
                                Closeable.m8492a(byteStream, null);
                                Closeable.m8492a(fileOutputStream, null);
                                Closeable.m8492a(execute, null);
                                return file2;
                            }
                        }
                    } finally {
                    }
                } else {
                    Closeable.m8492a(execute, null);
                    return null;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
        } catch (Exception e) {
            C11792j.m20470c(e.getMessage());
            return null;
        }
    }

    /* renamed from: D */
    private final File m38182D(String str, String str2) {
        try {
            File file = new File(BaseApp.m44341b().getFilesDir().getPath(), RewardPlus.ICON);
            if (!file.exists()) {
                file.mkdir();
            }
            Locale locale = Locale.getDefault();
            C14342f0.m8185o(locale, "getDefault()");
            if (str2 != null) {
                String lowerCase = str2.toLowerCase(locale);
                C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                int m38161Y = m38161Y(lowerCase);
                File file2 = new File(file, str2 + '.' + m38169Q(m38161Y));
                InputStream openRawResource = BaseApp.m44341b().getResources().openRawResource(m38161Y);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = openRawResource.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        Unit unit = Unit.f41048a;
                        Closeable.m8492a(fileOutputStream, null);
                        Closeable.m8492a(openRawResource, null);
                        return file2;
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } catch (Exception e) {
            C11792j.m20470c(e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public final Object m38181E(String str, String str2, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return C15057h.m4445i(Dispatchers.m5036c(), new C5840b(str, str2, null), interfaceC14268c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public final Object m38180F(String str, String str2, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return C15057h.m4445i(Dispatchers.m5036c(), new C5841c(str, str2, null), interfaceC14268c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0111  */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m38179G(java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r27) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.MainViewModel.m38179G(java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
        r5 = kotlin.text.C14579x.m6390t5(r5, "/", null, 2, null);
     */
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String m38169Q(int r5) {
        /*
            r4 = this;
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            com.bxkj.base.BaseApp r1 = com.bxkj.base.BaseApp.m44341b()
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
            java.lang.String r5 = kotlin.text.C14573n.m6740t5(r5, r2, r3, r1, r3)
            if (r5 != 0) goto L25
            goto L26
        L25:
            r0 = r5
        L26:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.MainViewModel.m38169Q(int):java.lang.String");
    }

    /* renamed from: R */
    private final String m38168R(String str) {
        boolean m6465V2;
        if (str != null) {
            m6465V2 = C14579x.m6465V2(str, "image/jpeg", false, 2, null);
            if (m6465V2) {
                return "jpg";
            }
            C14579x.m6465V2(str, "image/png", false, 2, null);
            return "png";
        }
        return "png";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* renamed from: U */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38165U(java.lang.String r7, kotlin.coroutines.InterfaceC14268c<? super java.util.List<? extends java.util.Map<java.lang.String, java.lang.Object>>> r8) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.MainViewModel.m38165U(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public final MainRepository m38162X() {
        return (MainRepository) this.f20932t.getValue();
    }

    /* renamed from: Y */
    private final int m38161Y(String str) {
        return BaseApp.m44341b().getResources().getIdentifier(C14342f0.m8216C("mipmap/", str), null, BaseApp.m44341b().getPackageName());
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
        r0 = kotlin.Unit.f41048a;
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
        r1 = kotlin.collections.C14236x.m8957Y(r3, 10);
        r7 = new java.util.ArrayList(r1);
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
    /* renamed from: s0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38141s0(java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r47, java.lang.String r48, androidx.lifecycle.MutableLiveData<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r49, java.lang.Boolean r50, kotlin.coroutines.InterfaceC14268c<? super java.lang.Boolean> r51) {
        /*
            Method dump skipped, instructions count: 2560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.MainViewModel.m38141s0(java.util.List, java.lang.String, androidx.lifecycle.MutableLiveData, java.lang.Boolean, kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: t0 */
    static /* synthetic */ Object m38139t0(MainViewModel mainViewModel, List list, String str, MutableLiveData mutableLiveData, Boolean bool, InterfaceC14268c interfaceC14268c, int i, Object obj) {
        if ((i & 8) != 0) {
            bool = Boolean.FALSE;
        }
        return mainViewModel.m38141s0(list, str, mutableLiveData, bool, interfaceC14268c);
    }

    /* renamed from: A */
    public final void m38185A(@NotNull String id) {
        C14342f0.m8184p(id, "id");
        C15111j.m4126f(ViewModelKt.getViewModelScope(this), null, null, new C5839a(id, null), 3, null);
    }

    /* renamed from: H */
    public final void m38178H() {
        BaseViewModel.m43949j(this, new C5842d(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @NotNull
    /* renamed from: I */
    public final MutableLiveData<List<Map<String, Object>>> m38177I() {
        return this.f20928p;
    }

    @NotNull
    /* renamed from: J */
    public final MutableLiveData<List<Map<String, Object>>> m38176J() {
        return this.f20920h;
    }

    /* renamed from: K */
    public final void m38175K() {
        BaseViewModel.m43949j(this, new C5843e(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @NotNull
    /* renamed from: L */
    public final MutableLiveData<List<Map<String, Object>>> m38174L() {
        return this.f20926n;
    }

    @NotNull
    /* renamed from: M */
    public final MutableLiveData<String> m38173M() {
        return this.f20923k;
    }

    /* renamed from: N */
    public final void m38172N() {
        BaseViewModel.m43949j(this, new C5844f(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @NotNull
    /* renamed from: O */
    public final MutableLiveData<List<Map<String, Object>>> m38171O() {
        return this.f20921i;
    }

    @NotNull
    /* renamed from: P */
    public final MutableLiveData<String> m38170P() {
        return this.f20922j;
    }

    @NotNull
    /* renamed from: S */
    public final MutableLiveData<Map<String, Object>> m38167S() {
        return this.f20930r;
    }

    /* renamed from: T */
    public final void m38166T() {
        if (LoggedInUser.f15182b.m43634a().m43637y()) {
            BaseViewModel.m43949j(this, new C5845g(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
        }
    }

    @NotNull
    /* renamed from: V */
    public final MutableLiveData<Boolean> m38164V() {
        return this.f20931s;
    }

    /* renamed from: W */
    public final void m38163W() {
        BaseViewModel.m43949j(this, new C5847i(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @NotNull
    /* renamed from: Z */
    public final MutableLiveData<String> m38160Z() {
        return this.f20924l;
    }

    /* renamed from: a0 */
    public final void m38159a0() {
        BaseViewModel.m43949j(this, new C5848j(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @NotNull
    /* renamed from: b0 */
    public final MutableLiveData<List<Map<String, Object>>> m38158b0() {
        return this.f20927o;
    }

    @NotNull
    /* renamed from: c0 */
    public final MutableLiveData<Map<String, Object>> m38157c0() {
        return this.f20925m;
    }

    /* renamed from: d0 */
    public final void m38156d0() {
        BaseViewModel.m43949j(this, new C5849k(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @NotNull
    /* renamed from: e0 */
    public final MutableLiveData<Map<String, Object>> m38155e0() {
        return this.f20929q;
    }

    /* renamed from: f0 */
    public final void m38154f0() {
        BaseViewModel.m43949j(this, new C5850l(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: g0 */
    public final void m38153g0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20928p = mutableLiveData;
    }

    /* renamed from: h0 */
    public final void m38152h0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20920h = mutableLiveData;
    }

    /* renamed from: i0 */
    public final void m38151i0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20926n = mutableLiveData;
    }

    /* renamed from: j0 */
    public final void m38150j0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20929q = mutableLiveData;
    }

    /* renamed from: k0 */
    public final void m38149k0(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20923k = mutableLiveData;
    }

    /* renamed from: l0 */
    public final void m38148l0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20921i = mutableLiveData;
    }

    /* renamed from: m0 */
    public final void m38147m0(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20922j = mutableLiveData;
    }

    /* renamed from: n0 */
    public final void m38146n0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20930r = mutableLiveData;
    }

    /* renamed from: o0 */
    public final void m38145o0(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20931s = mutableLiveData;
    }

    /* renamed from: p0 */
    public final void m38144p0(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20924l = mutableLiveData;
    }

    /* renamed from: q0 */
    public final void m38143q0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20927o = mutableLiveData;
    }

    /* renamed from: r0 */
    public final void m38142r0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20925m = mutableLiveData;
    }
}
