package com.github.aachartmodel.aainfographics.aatools;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.z0;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAGradientColor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J-\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u0002082\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010C\u00a2\u0006\u0002\u0010DJ*\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u0002082\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0005J\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0005J\u001c\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020H0\u00042\u0006\u00107\u001a\u000208H\u0002J\u0014\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208J\u0014\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u00107\u001a\u000208R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u001d\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u001d\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u001d\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u001d\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u001d\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u001d\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007\u00a8\u0006X"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AAGradientColor;", "", "()V", "BerrySmoothie", "", "", "getBerrySmoothie", "()Ljava/util/Map;", "CoastalBreeze", "getCoastalBreeze", "CottonCandy", "getCottonCandy", "DeepSea", "getDeepSea", "EveningDelight", "getEveningDelight", "Firebrick", "getFirebrick", "FizzyPeach", "getFizzyPeach", "FreshPapaya", "getFreshPapaya", "LemonDrizzle", "getLemonDrizzle", "LusciousLime", "getLusciousLime", "MysticMauve", "getMysticMauve", "NeonGlow", "getNeonGlow", "NewLeaf", "getNewLeaf", "OceanBlue", "getOceanBlue", "PinkSugar", "getPinkSugar", "PixieDust", "getPixieDust", "PurpleLake", "getPurpleLake", "ReflexSilver", "getReflexSilver", "Sanguine", "getSanguine", "SpringGreens", "getSpringGreens", "SweetDream", "getSweetDream", "Ultramarine", "getUltramarine", "VictoriaPurple", "getVictoriaPurple", "WroughtIron", "getWroughtIron", "berrySmoothieColor", "direction", "Lcom/github/aachartmodel/aainfographics/aatools/AALinearGradientDirection;", "coastalBreezeColor", "cottonCandyColor", "deepSeaColor", "eveningDelightColor", "firebrickColor", "fizzyPeachColor", "freshPapayaColor", "lemonDrizzleColor", "linearGradient", "stopsArr", "", "(Lcom/github/aachartmodel/aainfographics/aatools/AALinearGradientDirection;[Ljava/lang/Object;)Ljava/util/Map;", "startColor", "endColor", "linearGradientMap", "", "lusciousLimeColor", "mysticMauveColor", "neonGlowColor", "newLeafColor", "oceanBlueColor", "pinkSugarColor", "pixieDustColor", "purpleLakeColor", "reflexSilverColor", "sanguineColor", "springGreensColor", "sweetDreamColor", "ultramarineColor", "victoriaPurpleColor", "wroughtIronColor", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAGradientColor {
    @NotNull
    private static final Map<String, Object> BerrySmoothie;
    @NotNull
    private static final Map<String, Object> CoastalBreeze;
    @NotNull
    private static final Map<String, Object> CottonCandy;
    @NotNull
    private static final Map<String, Object> DeepSea;
    @NotNull
    private static final Map<String, Object> EveningDelight;
    @NotNull
    private static final Map<String, Object> Firebrick;
    @NotNull
    private static final Map<String, Object> FizzyPeach;
    @NotNull
    private static final Map<String, Object> FreshPapaya;
    public static final AAGradientColor INSTANCE;
    @NotNull
    private static final Map<String, Object> LemonDrizzle;
    @NotNull
    private static final Map<String, Object> LusciousLime;
    @NotNull
    private static final Map<String, Object> MysticMauve;
    @NotNull
    private static final Map<String, Object> NeonGlow;
    @NotNull
    private static final Map<String, Object> NewLeaf;
    @NotNull
    private static final Map<String, Object> OceanBlue;
    @NotNull
    private static final Map<String, Object> PinkSugar;
    @NotNull
    private static final Map<String, Object> PixieDust;
    @NotNull
    private static final Map<String, Object> PurpleLake;
    @NotNull
    private static final Map<String, Object> ReflexSilver;
    @NotNull
    private static final Map<String, Object> Sanguine;
    @NotNull
    private static final Map<String, Object> SpringGreens;
    @NotNull
    private static final Map<String, Object> SweetDream;
    @NotNull
    private static final Map<String, Object> Ultramarine;
    @NotNull
    private static final Map<String, Object> VictoriaPurple;
    @NotNull
    private static final Map<String, Object> WroughtIron;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AALinearGradientDirection.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AALinearGradientDirection.ToTop.ordinal()] = 1;
            iArr[AALinearGradientDirection.ToBottom.ordinal()] = 2;
            iArr[AALinearGradientDirection.ToLeft.ordinal()] = 3;
            iArr[AALinearGradientDirection.ToRight.ordinal()] = 4;
            iArr[AALinearGradientDirection.ToTopLeft.ordinal()] = 5;
            iArr[AALinearGradientDirection.ToTopRight.ordinal()] = 6;
            iArr[AALinearGradientDirection.ToBottomLeft.ordinal()] = 7;
            iArr[AALinearGradientDirection.ToBottomRight.ordinal()] = 8;
        }
    }

    static {
        AAGradientColor aAGradientColor = new AAGradientColor();
        INSTANCE = aAGradientColor;
        OceanBlue = aAGradientColor.oceanBlueColor();
        Sanguine = aAGradientColor.sanguineColor();
        LusciousLime = aAGradientColor.lusciousLimeColor();
        PurpleLake = aAGradientColor.purpleLakeColor();
        FreshPapaya = aAGradientColor.freshPapayaColor();
        Ultramarine = aAGradientColor.ultramarineColor();
        PinkSugar = aAGradientColor.pinkSugarColor();
        LemonDrizzle = aAGradientColor.lemonDrizzleColor();
        VictoriaPurple = aAGradientColor.victoriaPurpleColor();
        SpringGreens = aAGradientColor.springGreensColor();
        MysticMauve = aAGradientColor.mysticMauveColor();
        ReflexSilver = aAGradientColor.reflexSilverColor();
        NeonGlow = aAGradientColor.neonGlowColor();
        BerrySmoothie = aAGradientColor.berrySmoothieColor();
        NewLeaf = aAGradientColor.newLeafColor();
        CottonCandy = aAGradientColor.cottonCandyColor();
        PixieDust = aAGradientColor.pixieDustColor();
        FizzyPeach = aAGradientColor.fizzyPeachColor();
        SweetDream = aAGradientColor.sweetDreamColor();
        Firebrick = aAGradientColor.firebrickColor();
        WroughtIron = aAGradientColor.wroughtIronColor();
        DeepSea = aAGradientColor.deepSeaColor();
        CoastalBreeze = aAGradientColor.coastalBreezeColor();
        EveningDelight = aAGradientColor.eveningDelightColor();
    }

    private AAGradientColor() {
    }

    private final Map<String, Object> berrySmoothieColor() {
        return berrySmoothieColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> coastalBreezeColor() {
        return coastalBreezeColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> cottonCandyColor() {
        return cottonCandyColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> deepSeaColor() {
        return deepSeaColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> eveningDelightColor() {
        return eveningDelightColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> firebrickColor() {
        return firebrickColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> fizzyPeachColor() {
        return fizzyPeachColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> freshPapayaColor() {
        return freshPapayaColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> lemonDrizzleColor() {
        return lemonDrizzleColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Integer> linearGradientMap(AALinearGradientDirection aALinearGradientDirection) {
        Map<String, Integer> W;
        Map<String, Integer> W2;
        Map<String, Integer> W3;
        Map<String, Integer> W4;
        Map<String, Integer> W5;
        Map<String, Integer> W6;
        Map<String, Integer> W7;
        Map<String, Integer> W8;
        switch (WhenMappings.$EnumSwitchMapping$0[aALinearGradientDirection.ordinal()]) {
            case 1:
                W = z0.W(l0.a("x1", 0), l0.a("y1", 1), l0.a("x2", 0), l0.a("y2", 0));
                return W;
            case 2:
                W2 = z0.W(l0.a("x1", 0), l0.a("y1", 0), l0.a("x2", 0), l0.a("y2", 1));
                return W2;
            case 3:
                W3 = z0.W(l0.a("x1", 1), l0.a("y1", 0), l0.a("x2", 0), l0.a("y2", 0));
                return W3;
            case 4:
                W4 = z0.W(l0.a("x1", 0), l0.a("y1", 0), l0.a("x2", 1), l0.a("y2", 0));
                return W4;
            case 5:
                W5 = z0.W(l0.a("x1", 1), l0.a("y1", 1), l0.a("x2", 0), l0.a("y2", 0));
                return W5;
            case 6:
                W6 = z0.W(l0.a("x1", 0), l0.a("y1", 1), l0.a("x2", 1), l0.a("y2", 0));
                return W6;
            case 7:
                W7 = z0.W(l0.a("x1", 1), l0.a("y1", 0), l0.a("x2", 0), l0.a("y2", 1));
                return W7;
            case 8:
                W8 = z0.W(l0.a("x1", 0), l0.a("y1", 0), l0.a("x2", 1), l0.a("y2", 1));
                return W8;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final Map<String, Object> lusciousLimeColor() {
        return lusciousLimeColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> mysticMauveColor() {
        return mysticMauveColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> neonGlowColor() {
        return neonGlowColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> newLeafColor() {
        return newLeafColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> oceanBlueColor() {
        return oceanBlueColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> pinkSugarColor() {
        return pinkSugarColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> pixieDustColor() {
        return pixieDustColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> purpleLakeColor() {
        return purpleLakeColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> reflexSilverColor() {
        return reflexSilverColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> sanguineColor() {
        return sanguineColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> springGreensColor() {
        return springGreensColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> sweetDreamColor() {
        return sweetDreamColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> ultramarineColor() {
        return ultramarineColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> victoriaPurpleColor() {
        return victoriaPurpleColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> wroughtIronColor() {
        return wroughtIronColor(AALinearGradientDirection.ToTop);
    }

    @NotNull
    public final Map<String, Object> getBerrySmoothie() {
        return BerrySmoothie;
    }

    @NotNull
    public final Map<String, Object> getCoastalBreeze() {
        return CoastalBreeze;
    }

    @NotNull
    public final Map<String, Object> getCottonCandy() {
        return CottonCandy;
    }

    @NotNull
    public final Map<String, Object> getDeepSea() {
        return DeepSea;
    }

    @NotNull
    public final Map<String, Object> getEveningDelight() {
        return EveningDelight;
    }

    @NotNull
    public final Map<String, Object> getFirebrick() {
        return Firebrick;
    }

    @NotNull
    public final Map<String, Object> getFizzyPeach() {
        return FizzyPeach;
    }

    @NotNull
    public final Map<String, Object> getFreshPapaya() {
        return FreshPapaya;
    }

    @NotNull
    public final Map<String, Object> getLemonDrizzle() {
        return LemonDrizzle;
    }

    @NotNull
    public final Map<String, Object> getLusciousLime() {
        return LusciousLime;
    }

    @NotNull
    public final Map<String, Object> getMysticMauve() {
        return MysticMauve;
    }

    @NotNull
    public final Map<String, Object> getNeonGlow() {
        return NeonGlow;
    }

    @NotNull
    public final Map<String, Object> getNewLeaf() {
        return NewLeaf;
    }

    @NotNull
    public final Map<String, Object> getOceanBlue() {
        return OceanBlue;
    }

    @NotNull
    public final Map<String, Object> getPinkSugar() {
        return PinkSugar;
    }

    @NotNull
    public final Map<String, Object> getPixieDust() {
        return PixieDust;
    }

    @NotNull
    public final Map<String, Object> getPurpleLake() {
        return PurpleLake;
    }

    @NotNull
    public final Map<String, Object> getReflexSilver() {
        return ReflexSilver;
    }

    @NotNull
    public final Map<String, Object> getSanguine() {
        return Sanguine;
    }

    @NotNull
    public final Map<String, Object> getSpringGreens() {
        return SpringGreens;
    }

    @NotNull
    public final Map<String, Object> getSweetDream() {
        return SweetDream;
    }

    @NotNull
    public final Map<String, Object> getUltramarine() {
        return Ultramarine;
    }

    @NotNull
    public final Map<String, Object> getVictoriaPurple() {
        return VictoriaPurple;
    }

    @NotNull
    public final Map<String, Object> getWroughtIron() {
        return WroughtIron;
    }

    @NotNull
    public final Map<String, Object> linearGradient(@NotNull String startColor, @NotNull String endColor) {
        f0.p(startColor, "startColor");
        f0.p(endColor, "endColor");
        return linearGradient(AALinearGradientDirection.ToTop, startColor, endColor);
    }

    @NotNull
    public final Map<String, Object> berrySmoothieColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#8E78FF", "#FC7D7B");
    }

    @NotNull
    public final Map<String, Object> coastalBreezeColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#00B7FF", "#FFFFC7");
    }

    @NotNull
    public final Map<String, Object> cottonCandyColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#FCA5F1", "#B5FFFF");
    }

    @NotNull
    public final Map<String, Object> deepSeaColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#4F00BC", "#29ABE2");
    }

    @NotNull
    public final Map<String, Object> eveningDelightColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#93278F", "#00A99D");
    }

    @NotNull
    public final Map<String, Object> firebrickColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#45145A", "#FF5300");
    }

    @NotNull
    public final Map<String, Object> fizzyPeachColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#F24645", "#EBC08D");
    }

    @NotNull
    public final Map<String, Object> freshPapayaColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#ED1C24", "#FCEE21");
    }

    @NotNull
    public final Map<String, Object> lemonDrizzleColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#FB872B", "#D9E021");
    }

    @NotNull
    public final Map<String, Object> lusciousLimeColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#009245", "#FCEE21");
    }

    @NotNull
    public final Map<String, Object> mysticMauveColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#B066FE", "#63E2FF");
    }

    @NotNull
    public final Map<String, Object> neonGlowColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#00FFA1", "#00FFFF");
    }

    @NotNull
    public final Map<String, Object> newLeafColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#00537E", "#3AA17E");
    }

    @NotNull
    public final Map<String, Object> oceanBlueColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#2E3192", "#1BFFFF");
    }

    @NotNull
    public final Map<String, Object> pinkSugarColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#D74177", "#FFE98A");
    }

    @NotNull
    public final Map<String, Object> pixieDustColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#D585FF", "#00FFEE");
    }

    @NotNull
    public final Map<String, Object> purpleLakeColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#662D8C", "#ED1E79");
    }

    @NotNull
    public final Map<String, Object> reflexSilverColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#808080", "#E6E6E6");
    }

    @NotNull
    public final Map<String, Object> sanguineColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#D4145A", "#FBB03B");
    }

    @NotNull
    public final Map<String, Object> springGreensColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#009E00", "#FFFF96");
    }

    @NotNull
    public final Map<String, Object> sweetDreamColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#3A3897", "#A3A1FF");
    }

    @NotNull
    public final Map<String, Object> ultramarineColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#00A8C5", "#FFFF7E");
    }

    @NotNull
    public final Map<String, Object> victoriaPurpleColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#312A6C", "#852D91");
    }

    @NotNull
    public final Map<String, Object> wroughtIronColor(@NotNull AALinearGradientDirection direction) {
        f0.p(direction, "direction");
        return linearGradient(direction, "#333333", "#5A5454");
    }

    @NotNull
    public final Map<String, Object> linearGradient(@NotNull AALinearGradientDirection direction, @NotNull String startColor, @NotNull String endColor) {
        f0.p(direction, "direction");
        f0.p(startColor, "startColor");
        f0.p(endColor, "endColor");
        return linearGradient(direction, new Object[]{new Object[]{0, startColor}, new Object[]{1, endColor}});
    }

    @NotNull
    public final Map<String, Object> linearGradient(@NotNull AALinearGradientDirection direction, @NotNull Object[] stopsArr) {
        Map<String, Object> W;
        f0.p(direction, "direction");
        f0.p(stopsArr, "stopsArr");
        W = z0.W(l0.a("linearGradient", linearGradientMap(direction)), l0.a("stops", stopsArr));
        return W;
    }
}
