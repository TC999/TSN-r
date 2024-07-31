package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.connect.common.Constants;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.MutableCollections;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.C14413k;
import kotlin.ranges._Ranges;
import p617l1.InterfaceC15280l;

/* compiled from: Regex.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0014\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0082\b\u001a\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002\u001a\u0016\u0010\u000f\u001a\u0004\u0018\u00010\r*\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002\u001a\f\u0010\u0012\u001a\u00020\u0011*\u00020\u0010H\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0011*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¨\u0006\u0015"}, m12616d2 = {"", "Lkotlin/text/g;", "", C7304t.f25048d, "", ExifInterface.GPS_DIRECTION_TRUE, DomainCampaignEx.LOOPBACK_VALUE, "", "h", "Ljava/util/regex/Matcher;", Constants.FROM, "", "input", "Lkotlin/text/k;", "g", "i", "Ljava/util/regex/MatchResult;", "Lkotlin/ranges/k;", "j", "groupIndex", "k", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class RegexKt {
    /* renamed from: a */
    public static final /* synthetic */ InterfaceC14566k m6909a(Matcher matcher, int i, CharSequence charSequence) {
        return m6903g(matcher, i, charSequence);
    }

    /* renamed from: c */
    public static final /* synthetic */ InterfaceC14566k m6907c(Matcher matcher, CharSequence charSequence) {
        return m6901i(matcher, charSequence);
    }

    /* renamed from: f */
    public static final /* synthetic */ int m6904f(Iterable iterable) {
        return m6898l(iterable);
    }

    /* renamed from: g */
    public static final InterfaceC14566k m6903g(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new C14569l(matcher, charSequence);
        }
        return null;
    }

    /* renamed from: h */
    public static final /* synthetic */ <T extends Enum<T> & InterfaceC14563g> Set<T> m6902h(final int i) {
        C14342f0.m8175y(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet allOf = EnumSet.allOf(Enum.class);
        MutableCollections.m12423P0(allOf, new InterfaceC15280l<T, Boolean>() { // from class: kotlin.text.RegexKt$fromInt$$inlined$apply$lambda$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke((Enum) obj));
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            public final boolean invoke(Enum r3) {
                InterfaceC14563g interfaceC14563g = (InterfaceC14563g) r3;
                return (i & interfaceC14563g.getMask()) == interfaceC14563g.getValue();
            }
        });
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        C14342f0.m8185o(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        return unmodifiableSet;
    }

    /* renamed from: i */
    public static final InterfaceC14566k m6901i(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new C14569l(matcher, charSequence);
        }
        return null;
    }

    /* renamed from: j */
    public static final C14413k m6900j(MatchResult matchResult) {
        C14413k m7479n1;
        m7479n1 = _Ranges.m7479n1(matchResult.start(), matchResult.end());
        return m7479n1;
    }

    /* renamed from: k */
    public static final C14413k m6899k(MatchResult matchResult, int i) {
        C14413k m7479n1;
        m7479n1 = _Ranges.m7479n1(matchResult.start(i), matchResult.end(i));
        return m7479n1;
    }

    /* renamed from: l */
    public static final int m6898l(Iterable<? extends InterfaceC14563g> iterable) {
        int i = 0;
        for (InterfaceC14563g interfaceC14563g : iterable) {
            i |= interfaceC14563g.getValue();
        }
        return i;
    }
}
