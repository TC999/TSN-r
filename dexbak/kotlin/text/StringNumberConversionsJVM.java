package kotlin.text;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, m12616d2 = {"Lkotlin/text/m;", "", "Lkotlin/text/Regex;", "a", "Lkotlin/text/Regex;", DomainCampaignEx.LOOPBACK_VALUE, "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.text.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class StringNumberConversionsJVM {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: a */
    public static final Regex f41621a;
    @NotNull

    /* renamed from: b */
    public static final StringNumberConversionsJVM f41622b = new StringNumberConversionsJVM();

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f41621a = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private StringNumberConversionsJVM() {
    }
}
