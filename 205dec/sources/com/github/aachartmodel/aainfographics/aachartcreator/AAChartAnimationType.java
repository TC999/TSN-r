package com.github.aachartmodel.aainfographics.aachartcreator;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAChartModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)\u00a8\u0006*"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Linear", "EaseInQuad", "EaseOutQuad", "EaseInOutQuad", "EaseInCubic", "EaseOutCubic", "EaseInOutCubic", "EaseInQuart", "EaseOutQuart", "EaseInOutQuart", "EaseInQuint", "EaseOutQuint", "EaseInOutQuint", "EaseInSine", "EaseOutSine", "EaseInOutSine", "EaseInExpo", "EaseOutExpo", "EaseInOutExpo", "EaseInCirc", "EaseOutCirc", "EaseInOutCirc", "EaseOutBounce", "EaseInBack", "EaseOutBack", "EaseInOutBack", "Elastic", "SwingFromTo", "SwingFrom", "SwingTo", "Bounce", "BouncePast", "EaseFromTo", "EaseFrom", "EaseTo", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public enum AAChartAnimationType {
    Linear("Linear"),
    EaseInQuad("easeInQuad"),
    EaseOutQuad("easeOutQuad"),
    EaseInOutQuad("easeInOutQuad"),
    EaseInCubic("easeInCubic"),
    EaseOutCubic("easeOutCubic"),
    EaseInOutCubic("easeInOutCubic"),
    EaseInQuart("easeInQuart"),
    EaseOutQuart("easeOutQuart"),
    EaseInOutQuart("easeInOutQuart"),
    EaseInQuint("easeInQuint"),
    EaseOutQuint("easeOutQuint"),
    EaseInOutQuint("easeInOutQuint"),
    EaseInSine("easeInSine"),
    EaseOutSine("easeOutSine"),
    EaseInOutSine("easeInOutSine"),
    EaseInExpo("easeInExpo"),
    EaseOutExpo("easeOutExpo"),
    EaseInOutExpo("easeInOutExpo"),
    EaseInCirc("easeInCirc"),
    EaseOutCirc("easeOutCirc"),
    EaseInOutCirc("easeInOutCirc"),
    EaseOutBounce("easeOutBounce"),
    EaseInBack("easeInBack"),
    EaseOutBack("easeOutBack"),
    EaseInOutBack("easeInOutBack"),
    Elastic("elastic"),
    SwingFromTo("swingFromTo"),
    SwingFrom("swingFrom"),
    SwingTo("swingTo"),
    Bounce("bounce"),
    BouncePast("bouncePast"),
    EaseFromTo("easeFromTo"),
    EaseFrom("easeFrom"),
    EaseTo("easeTo");
    
    @NotNull
    private final String value;

    AAChartAnimationType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
