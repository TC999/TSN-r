package com.bxkj.base.p085v2.common.utils;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.github.mikephil.charting.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections._Arrays;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b9\u0010:J\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tJ$\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\r2\b\u0010\n\u001a\u0004\u0018\u00010\tJ*\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\r0\r2\b\u0010\n\u001a\u0004\u0018\u00010\tJ0\u0010\u0013\u001a\u00028\u0000\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00012\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011\"\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J(\u0010\u0019\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010\u001b\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\tJ(\u0010\u001c\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010\u001d\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u0005J(\u0010\u001f\u001a\u00020\u001e2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010 \u001a\u00020\u001e2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u001eJ(\u0010\"\u001a\u00020!2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010#\u001a\u00020!2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020!J(\u0010%\u001a\u00020$2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010&\u001a\u00020$2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020$J(\u0010(\u001a\u00020'2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u0010)\u001a\u00020'2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020'J(\u0010*\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ8\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ:\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000b0\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ<\u0010/\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010-0.2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010-2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ0\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ.\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ.\u00102\u001a\b\u0012\u0004\u0012\u00020'0\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u000e\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020'J\u0010\u00105\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\tJ\u0010\u00106\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\tJ\u0010\u00108\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\t¨\u0006;"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/l;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "", "indent", "Lkotlin/f1;", "a", "", "json", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", UMCommonContent.f37777aG, "y", ExifInterface.GPS_DIRECTION_TRUE, "", "params", "C", "([Ljava/lang/Object;)Ljava/lang/Object;", "B", "(Ljava/lang/String;)Ljava/lang/Object;", "map", DomainCampaignEx.LOOPBACK_KEY, UMCommonContent.f37782aL, "defaultValue", "u", "k", C7304t.f25048d, "", "o", "p", "", "d", "e", "", "i", "j", "", "f", "g", "r", CampaignEx.JSON_KEY_AD_Q, "n", "", "", "s", "v", "m", "h", "money", "c", IAdInterListener.AdReqParam.WIDTH, "x", "jsonStr", "b", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.l */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class JsonGet {
    @NotNull

    /* renamed from: a */
    public static final JsonGet f15134a = new JsonGet();

    /* compiled from: JsonGet.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u00020\u0001¨\u0006\u0006"}, m12616d2 = {"com/bxkj/base/v2/common/utils/l$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.l$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3971a extends TypeToken<List<? extends List<? extends Map<String, ? extends Object>>>> {
        C3971a() {
        }
    }

    /* compiled from: JsonGet.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u0001¨\u0006\u0006"}, m12616d2 = {"com/bxkj/base/v2/common/utils/l$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.l$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3972b extends TypeToken<List<? extends Map<String, ? extends Object>>> {
        C3972b() {
        }
    }

    /* compiled from: JsonGet.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001¨\u0006\u0005"}, m12616d2 = {"com/bxkj/base/v2/common/utils/l$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.l$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3973c extends TypeToken<Map<String, ? extends Object>> {
        C3973c() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: JsonGet.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, m12616d2 = {"com/bxkj/base/v2/common/utils/l$d", "Lcom/google/gson/reflect/TypeToken;", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.l$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3974d<T> extends TypeToken<T> {
    }

    private JsonGet() {
    }

    /* renamed from: a */
    private final void m43779a(StringBuilder sb, int i) {
        if (i > 0) {
            int i2 = 0;
            do {
                i2++;
                sb.append('\t');
            } while (i2 < i);
        }
    }

    @NotNull
    /* renamed from: A */
    public final Map<String, Object> m43782A(@Nullable String str) {
        Object fromJson = new Gson().fromJson(str, new C3973c().getType());
        C14342f0.m8185o(fromJson, "gson.fromJson(json, type)");
        return (Map) fromJson;
    }

    /* renamed from: B */
    public final /* synthetic */ <T> T m43781B(String str) {
        try {
            Gson gson = new Gson();
            C14342f0.m8177w();
            return (T) gson.fromJson(str, new C3974d().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: C */
    public final /* synthetic */ <T> T m43780C(Object... params) {
        C14342f0.m8184p(params, "params");
        C14342f0.m8175y(4, ExifInterface.GPS_DIRECTION_TRUE);
        ArrayList arrayList = new ArrayList(params.length);
        for (Object obj : params) {
            arrayList.add(obj.getClass());
        }
        Object[] array = arrayList.toArray(new Class[0]);
        if (array != null) {
            Class[] clsArr = (Class[]) array;
            Constructor declaredConstructor = Object.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            declaredConstructor.setAccessible(true);
            T t = (T) declaredConstructor.newInstance(Arrays.copyOf(params, params.length));
            C14342f0.m8185o(t, "T::class.java.getDeclare…ue }.newInstance(*params)");
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    /* renamed from: b */
    public final String m43778b(@Nullable String str) {
        if (str == null || C14342f0.m8193g("", str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (length > 0) {
            int i = 0;
            char c = 0;
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                char charAt = str.charAt(i);
                boolean z = true;
                if (charAt == '{' || charAt == '[') {
                    sb.append(charAt);
                    sb.append('\n');
                    i2++;
                    m43779a(sb, i2);
                } else {
                    if (charAt != '}' && charAt != ']') {
                        z = false;
                    }
                    if (z) {
                        sb.append('\n');
                        i2--;
                        m43779a(sb, i2);
                        sb.append(charAt);
                    } else if (charAt == ',') {
                        sb.append(charAt);
                        if (c != '\\') {
                            sb.append('\n');
                            m43779a(sb, i2);
                        }
                    } else {
                        sb.append(charAt);
                    }
                }
                if (i3 >= length) {
                    break;
                }
                c = charAt;
                i = i3;
            }
        }
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    /* renamed from: c */
    public final String m43777c(double d) {
        String format = new DecimalFormat("0.00").format(d);
        C14342f0.m8185o(format, "DecimalFormat(\"0.00\").format(money)");
        return format;
    }

    /* renamed from: d */
    public final boolean m43776d(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return m43775e(map, str, false);
    }

    /* renamed from: e */
    public final boolean m43775e(@Nullable Map<String, ? extends Object> map, @Nullable String str, boolean z) {
        try {
            return Boolean.parseBoolean(m43760t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return z;
        }
    }

    /* renamed from: f */
    public final double m43774f(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return m43773g(map, str, Utils.DOUBLE_EPSILON);
    }

    /* renamed from: g */
    public final double m43773g(@Nullable Map<String, ? extends Object> map, @Nullable String str, double d) {
        try {
            return Double.parseDouble(m43760t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return d;
        }
    }

    @NotNull
    /* renamed from: h */
    public final List<Double> m43772h(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        List<Double> m10606ay;
        List<Double> m10606ay2;
        ArrayList arrayList = new ArrayList();
        if (map == null || map.isEmpty() || m43757w(str) || !map.containsKey(str) || (obj = map.get(str)) == null) {
            return arrayList;
        }
        if (obj instanceof List) {
            return (List) obj;
        }
        if (obj instanceof double[]) {
            m10606ay2 = _Arrays.m10606ay((double[]) obj);
            return m10606ay2;
        } else if (obj instanceof String) {
            Object fromJson = new Gson().fromJson((String) obj, (Class<Object>) double[].class);
            C14342f0.m8185o(fromJson, "Gson().fromJson(data.toS… DoubleArray::class.java)");
            m10606ay = _Arrays.m10606ay((double[]) fromJson);
            return m10606ay;
        } else {
            return arrayList;
        }
    }

    /* renamed from: i */
    public final float m43771i(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return m43770j(map, str, 0.0f);
    }

    /* renamed from: j */
    public final float m43770j(@Nullable Map<String, ? extends Object> map, @Nullable String str, float f) {
        try {
            return Float.parseFloat(m43760t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return 0.0f;
        }
    }

    /* renamed from: k */
    public final int m43769k(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return m43768l(map, str, 0);
    }

    /* renamed from: l */
    public final int m43768l(@Nullable Map<String, ? extends Object> map, @Nullable String str, int i) {
        try {
            return Integer.parseInt(m43760t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return i;
        }
    }

    @NotNull
    /* renamed from: m */
    public final List<Integer> m43767m(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        List<Integer> m10543cy;
        List<Integer> m10543cy2;
        ArrayList arrayList = new ArrayList();
        if (map == null || map.isEmpty() || m43757w(str) || !map.containsKey(str) || (obj = map.get(str)) == null) {
            return arrayList;
        }
        if (obj instanceof List) {
            return (List) obj;
        }
        if (obj instanceof int[]) {
            m10543cy2 = _Arrays.m10543cy((int[]) obj);
            return m10543cy2;
        } else if (obj instanceof String) {
            Object fromJson = new Gson().fromJson((String) obj, (Class<Object>) int[].class);
            C14342f0.m8185o(fromJson, "Gson().fromJson(data.toS…(), IntArray::class.java)");
            m10543cy = _Arrays.m10543cy((int[]) fromJson);
            return m10543cy;
        } else {
            return arrayList;
        }
    }

    @NotNull
    /* renamed from: n */
    public final List<Map<String, Object>> m43766n(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        return (map == null || map.isEmpty() || m43757w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof List)) ? arrayList : (List) obj;
    }

    /* renamed from: o */
    public final long m43765o(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return m43764p(map, str, 0L);
    }

    /* renamed from: p */
    public final long m43764p(@Nullable Map<String, ? extends Object> map, @Nullable String str, long j) {
        try {
            return Long.parseLong(m43760t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return j;
        }
    }

    @NotNull
    /* renamed from: q */
    public final Map<String, Object> m43763q(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        HashMap hashMap = new HashMap();
        return (map == null || map.size() == 0 || m43757w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Map)) ? hashMap : (Map) obj;
    }

    @NotNull
    /* renamed from: r */
    public final String m43762r(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        try {
            return m43777c(m43774f(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return "0.00";
        }
    }

    @NotNull
    /* renamed from: s */
    public final List<Map<String, Object>> m43761s(@Nullable Map<String, Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        return (map == null || map.isEmpty() || m43757w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !TypeIntrinsics.m8035F(obj)) ? arrayList : TypeIntrinsics.m8020g(obj);
    }

    @NotNull
    /* renamed from: t */
    public final String m43760t(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return m43759u(map, str, "");
    }

    @NotNull
    /* renamed from: u */
    public final String m43759u(@Nullable Map<String, ? extends Object> map, @Nullable String str, @NotNull String defaultValue) {
        C14342f0.m8184p(defaultValue, "defaultValue");
        if (map == null || map.isEmpty() || m43757w(str) || !map.containsKey(str)) {
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
        return m43757w(obj2) ? defaultValue : obj2;
    }

    @NotNull
    /* renamed from: v */
    public final List<String> m43758v(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        return (map == null || map.size() == 0 || m43757w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof List)) ? arrayList : (List) obj;
    }

    /* renamed from: w */
    public final boolean m43757w(@Nullable String str) {
        boolean m6604K1;
        if (str == null || C14342f0.m8193g(str, "")) {
            return true;
        }
        m6604K1 = StringsJVM.m6604K1(str, "null", true);
        return m6604K1;
    }

    /* renamed from: x */
    public final boolean m43756x(@Nullable String str) {
        return str == null || C14342f0.m8193g(str, "");
    }

    @NotNull
    /* renamed from: y */
    public final List<List<Map<String, Object>>> m43755y(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Object fromJson = new Gson().fromJson(str, new C3971a().getType());
        C14342f0.m8185o(fromJson, "gson.fromJson(json, type)");
        return (List) fromJson;
    }

    @NotNull
    /* renamed from: z */
    public final List<Map<String, Object>> m43754z(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Object fromJson = new Gson().fromJson(str, new C3972b().getType());
        C14342f0.m8185o(fromJson, "gson.fromJson(json, type)");
        return (List) fromJson;
    }
}
