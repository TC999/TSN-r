package com.bxkj.base.v2.common.utils;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.File;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: JsonGet.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tJ$\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\r2\b\u0010\n\u001a\u0004\u0018\u00010\tJ*\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\r0\r2\b\u0010\n\u001a\u0004\u0018\u00010\tJ0\u0010\u0013\u001a\u00028\u0000\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00012\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011\"\u00020\u0001H\u0086\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0086\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\u0019\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010\u001b\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\tJ(\u0010\u001c\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010\u001d\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u0005J(\u0010\u001f\u001a\u00020\u001e2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010 \u001a\u00020\u001e2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u001eJ(\u0010\"\u001a\u00020!2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010#\u001a\u00020!2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020!J(\u0010%\u001a\u00020$2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010&\u001a\u00020$2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020$J(\u0010(\u001a\u00020'2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010)\u001a\u00020'2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020'J(\u0010*\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ8\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ:\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000b0\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ<\u0010/\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010-0.2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010-2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ.\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ.\u00102\u001a\b\u0012\u0004\u0012\u00020'0\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u000e\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020'J\u0010\u00105\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\tJ\u0010\u00106\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\tJ\u0010\u00108\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\t\u00a8\u0006;"}, d2 = {"Lcom/bxkj/base/v2/common/utils/l;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "", "indent", "Lkotlin/f1;", "a", "", "json", "", "A", "", "z", "y", "T", "", EventMonitor.V3_PARAMS, "C", "([Ljava/lang/Object;)Ljava/lang/Object;", "B", "(Ljava/lang/String;)Ljava/lang/Object;", "map", DomainCampaignEx.LOOPBACK_KEY, "t", "defaultValue", "u", "k", "l", "", "o", "p", "", "d", "e", "", "i", "j", "", "f", "g", "r", CampaignEx.JSON_KEY_AD_Q, "n", "", "", "s", "v", "m", "h", "money", "c", "w", "x", "jsonStr", "b", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final l f18624a = new l();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: JsonGet.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"com/bxkj/base/v2/common/utils/l$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends TypeToken<List<? extends List<? extends Map<String, ? extends Object>>>> {
        a() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: JsonGet.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"com/bxkj/base/v2/common/utils/l$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends TypeToken<List<? extends Map<String, ? extends Object>>> {
        b() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: JsonGet.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"com/bxkj/base/v2/common/utils/l$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends TypeToken<Map<String, ? extends Object>> {
        c() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: JsonGet.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0002"}, d2 = {"com/bxkj/base/v2/common/utils/l$d", "Lcom/google/gson/reflect/TypeToken;", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d<T> extends TypeToken<T> {
    }

    /* compiled from: ImageSelectUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class e extends Lambda implements d2.a<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18625a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d2.l<File, f1> f18626b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(FragmentActivity fragmentActivity, d2.l<? super File, f1> lVar) {
            super(0);
            this.f18625a = fragmentActivity;
            this.f18626b = lVar;
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            l.f18624a.m(this.f18625a, this.f18626b);
        }
    }

    private l() {
    }

    private final void a(StringBuilder sb, int i4) {
        if (i4 > 0) {
            int i5 = 0;
            do {
                i5++;
                sb.append('\t');
            } while (i5 < i4);
        }
    }

    @NotNull
    public final Map<String, Object> A(@Nullable String str) {
        Object fromJson = new Gson().fromJson(str, new c().getType());
        f0.o(fromJson, "gson.fromJson(json, type)");
        return (Map) fromJson;
    }

    public final /* synthetic */ <T> T B(String str) {
        try {
            Gson gson = new Gson();
            f0.w();
            return (T) gson.fromJson(str, new d().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public final /* synthetic */ <T> T C(Object... params) {
        f0.p(params, "params");
        f0.y(4, "T");
        ArrayList arrayList = new ArrayList(params.length);
        for (Object obj : params) {
            arrayList.add(obj.getClass());
        }
        Object[] array = arrayList.toArray(new Class[0]);
        if (array != null) {
            Class[] clsArr = (Class[]) array;
            Constructor declaredConstructor = Object.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            declaredConstructor.setAccessible(true);
            T t3 = (T) declaredConstructor.newInstance(Arrays.copyOf(params, params.length));
            f0.o(t3, "T::class.java.getDeclare\u2026ue }.newInstance(*params)");
            return t3;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final String b(@Nullable String str) {
        if (str == null || f0.g("", str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (length > 0) {
            int i4 = 0;
            char c4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i4 + 1;
                char charAt = str.charAt(i4);
                boolean z3 = true;
                if (charAt == '{' || charAt == '[') {
                    sb.append(charAt);
                    sb.append('\n');
                    i5++;
                    a(sb, i5);
                } else {
                    if (charAt != '}' && charAt != ']') {
                        z3 = false;
                    }
                    if (z3) {
                        sb.append('\n');
                        i5--;
                        a(sb, i5);
                        sb.append(charAt);
                    } else if (charAt == ',') {
                        sb.append(charAt);
                        if (c4 != '\\') {
                            sb.append('\n');
                            a(sb, i5);
                        }
                    } else {
                        sb.append(charAt);
                    }
                }
                if (i6 >= length) {
                    break;
                }
                c4 = charAt;
                i4 = i6;
            }
        }
        String sb2 = sb.toString();
        f0.o(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    public final String c(double d4) {
        String format = new DecimalFormat("0.00").format(d4);
        f0.o(format, "DecimalFormat(\"0.00\").format(money)");
        return format;
    }

    public final boolean d(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return e(map, str, false);
    }

    public final boolean e(@Nullable Map<String, ? extends Object> map, @Nullable String str, boolean z3) {
        try {
            return Boolean.parseBoolean(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return z3;
        }
    }

    public final double f(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return g(map, str, 0.0d);
    }

    public final double g(@Nullable Map<String, ? extends Object> map, @Nullable String str, double d4) {
        try {
            return Double.parseDouble(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return d4;
        }
    }

    @NotNull
    public final List<Double> h(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (map == null || map.isEmpty() || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null) {
            return arrayList;
        }
        if (obj instanceof List) {
            return (List) obj;
        }
        if (obj instanceof double[]) {
            return kotlin.collections.m.ay((double[]) obj);
        }
        if (obj instanceof String) {
            Object fromJson = new Gson().fromJson((String) obj, (Class<Object>) double[].class);
            f0.o(fromJson, "Gson().fromJson(data.toS\u2026 DoubleArray::class.java)");
            return kotlin.collections.m.ay((double[]) fromJson);
        }
        return arrayList;
    }

    public final float i(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return j(map, str, 0.0f);
    }

    public final float j(@Nullable Map<String, ? extends Object> map, @Nullable String str, float f4) {
        try {
            return Float.parseFloat(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return 0.0f;
        }
    }

    public final int k(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return l(map, str, 0);
    }

    public final int l(@Nullable Map<String, ? extends Object> map, @Nullable String str, int i4) {
        try {
            return Integer.parseInt(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return i4;
        }
    }

    @NotNull
    public final List<Integer> m(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (map == null || map.isEmpty() || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null) {
            return arrayList;
        }
        if (obj instanceof List) {
            return (List) obj;
        }
        if (obj instanceof int[]) {
            return kotlin.collections.m.cy((int[]) obj);
        }
        if (obj instanceof String) {
            Object fromJson = new Gson().fromJson((String) obj, (Class<Object>) int[].class);
            f0.o(fromJson, "Gson().fromJson(data.toS\u2026(), IntArray::class.java)");
            return kotlin.collections.m.cy((int[]) fromJson);
        }
        return arrayList;
    }

    @NotNull
    public final List<Map<String, Object>> n(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        return (map == null || map.isEmpty() || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof List)) ? arrayList : (List) obj;
    }

    public final long o(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return p(map, str, 0L);
    }

    public final long p(@Nullable Map<String, ? extends Object> map, @Nullable String str, long j4) {
        try {
            return Long.parseLong(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return j4;
        }
    }

    @NotNull
    public final Map<String, Object> q(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        HashMap hashMap = new HashMap();
        return (map == null || map.size() == 0 || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Map)) ? hashMap : (Map) obj;
    }

    @NotNull
    public final String r(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        try {
            return c(f(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return "0.00";
        }
    }

    @NotNull
    public final List<Map<String, Object>> s(@Nullable Map<String, Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        return (map == null || map.isEmpty() || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !t0.F(obj)) ? arrayList : t0.g(obj);
    }

    @NotNull
    public final String t(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return u(map, str, "");
    }

    @NotNull
    public final String u(@Nullable Map<String, ? extends Object> map, @Nullable String str, @NotNull String defaultValue) {
        f0.p(defaultValue, "defaultValue");
        if (map == null || map.isEmpty() || w(str) || !map.containsKey(str)) {
            return defaultValue;
        }
        Object obj = map.get(str);
        if (obj == null) {
            return "";
        }
        String obj2 = obj.toString();
        if (obj instanceof Float) {
            Number number = (Number) obj;
            if (number.floatValue() == ((float) ((long) number.floatValue()))) {
                obj2 = String.valueOf(number.floatValue());
            }
        } else if (obj instanceof Double) {
            Number number2 = (Number) obj;
            if (number2.doubleValue() == ((double) ((long) number2.doubleValue()))) {
                obj2 = String.valueOf((long) number2.doubleValue());
            }
        } else if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            if (bigDecimal.compareTo(new BigDecimal((long) bigDecimal.doubleValue())) == 0) {
                obj2 = String.valueOf(bigDecimal.longValue());
            }
        }
        return w(obj2) ? defaultValue : obj2;
    }

    @NotNull
    public final List<String> v(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        return (map == null || map.size() == 0 || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof List)) ? arrayList : (List) obj;
    }

    public final boolean w(@Nullable String str) {
        boolean K1;
        if (str == null || f0.g(str, "")) {
            return true;
        }
        K1 = w.K1(str, "null", true);
        return K1;
    }

    public final boolean x(@Nullable String str) {
        return str == null || f0.g(str, "");
    }

    @NotNull
    public final List<List<Map<String, Object>>> y(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Object fromJson = new Gson().fromJson(str, new a().getType());
        f0.o(fromJson, "gson.fromJson(json, type)");
        return (List) fromJson;
    }

    @NotNull
    public final List<Map<String, Object>> z(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Object fromJson = new Gson().fromJson(str, new b().getType());
        f0.o(fromJson, "gson.fromJson(json, type)");
        return (List) fromJson;
    }
}
