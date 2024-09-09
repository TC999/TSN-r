package com.github.aachartmodel.aainfographics.aatools;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import com.acse.ottn.f3;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolStyleType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AABuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u0015\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010K\u001a\u00020\u0005J\u0010\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\tH\u0002J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\tH\u0002J-\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\t2\u0016\u0010S\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0015\"\u0004\u0018\u00010\u0001H\u0002\u00a2\u0006\u0002\u0010TJ\u000e\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0005J\u000e\u0010W\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\tJ\u000e\u0010X\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\fJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0010J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\tJ\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\tJ\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0010J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\tJ\u000e\u0010]\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u001f\u0010^\u001a\u00020\u00002\u0012\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0015\"\u00020\u0010\u00a2\u0006\u0002\u0010_J\u0012\u0010^\u001a\u00020\u00002\n\u0010`\u001a\u00020a\"\u00020\tJ\u000e\u0010b\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0018J\u0019\u0010c\u001a\u00020\u00002\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015\u00a2\u0006\u0002\u0010dJ\u001f\u0010c\u001a\u00020\u00002\u0012\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0015\"\u00020\u0010\u00a2\u0006\u0002\u0010_J\u0012\u0010c\u001a\u00020\u00002\n\u0010e\u001a\u00020a\"\u00020\tJ\u000e\u0010f\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000e\u0010g\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001fJ\u000e\u0010h\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000e\u0010i\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u001f\u0010k\u001a\u00020\u00002\u0012\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015\"\u00020\u0013\u00a2\u0006\u0002\u0010lJ&\u0010k\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\t2\u0006\u0010p\u001a\u00020\tJ&\u0010k\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u00132\u0006\u0010r\u001a\u00020\u00132\u0006\u0010s\u001a\u00020\u00132\u0006\u0010t\u001a\u00020\u0013J\u000e\u0010u\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u000e\u0010v\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\tJ\u000e\u0010w\u001a\u00020\u00002\u0006\u0010V\u001a\u00020'J\u000e\u0010x\u001a\u00020\u00002\u0006\u0010V\u001a\u00020)J\u000e\u0010y\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000e\u0010z\u001a\u00020\u00002\u0006\u0010V\u001a\u00020.J\u001f\u0010{\u001a\u00020\u00002\u0012\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020|0\u0015\"\u00020|\u00a2\u0006\u0002\u0010}J\u000e\u0010~\u001a\u00020\u00002\u0006\u0010V\u001a\u000201J,\u0010\u007f\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\t2\u0016\u0010S\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0015\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0003\u0010\u0080\u0001J\u000e\u0010\u007f\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0010J\u000f\u0010\u0081\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u000204J\u000f\u0010\u0082\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001fJ-\u0010\u0083\u0001\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\t2\u0016\u0010S\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0015\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0003\u0010\u0080\u0001J\u000f\u0010\u0083\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0010J\u000f\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001fJ\u000f\u0010\u0085\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ.\u0010\u0086\u0001\u001a\u00020\u00002\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0016\u0010S\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0015\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0003\u0010\u0080\u0001J\u000f\u0010\u0086\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0010J\u000f\u0010\u0088\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000f\u0010\u0089\u0001\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\tJ\u000f\u0010\u0089\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u000f\u0010\u008a\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000f\u0010\u008b\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000f\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\tJ\u000f\u0010\u008d\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000f\u0010\u008e\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000f\u0010\u008f\u0001\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\tJ\u000f\u0010\u008f\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u000f\u0010\u0090\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000f\u0010\u0091\u0001\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\tJ\u000f\u0010\u0091\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u000f\u0010\u0092\u0001\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\tJ\u0011\u0010\u0092\u0001\u001a\u00020\u00002\b\u0010V\u001a\u0004\u0018\u00010\u0013J\u000f\u0010\u0093\u0001\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\tJ\u0011\u0010\u0093\u0001\u001a\u00020\u00002\b\u0010V\u001a\u0004\u0018\u00010\u0013J\u000f\u0010\u0094\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ.\u0010\u0095\u0001\u001a\u00020\u00002\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0016\u0010S\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0015\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0003\u0010\u0080\u0001J\u000f\u0010\u0095\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0010J\u000f\u0010\u0096\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u001cJ\u000f\u0010\u0097\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020JJ\r\u0010\u0098\u0001\u001a\u00020\u0010*\u00020\tH\u0002R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010!\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010\"\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0016\u0010+\u001a\n \u000e*\u0004\u0018\u00010,0,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0010\u00109\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010;\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010=\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010>\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0012\u0010?\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010@\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010A\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010C\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010F\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010G\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0099\u0001"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "", "context", "Landroid/content/Context;", "source", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "(Landroid/content/Context;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;)V", "(Landroid/content/Context;)V", "animationDuration", "", "Ljava/lang/Integer;", "animationType", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "applicationContext", "kotlin.jvm.PlatformType", "axesTextColor", "", "backgroundColor", "borderRadius", "", "categories", "", "[Ljava/lang/String;", "chartType", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "colorsTheme", "[Ljava/lang/Object;", "dataLabelsEnabled", "", "Ljava/lang/Boolean;", "dataLabelsStyle", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "gradientColorEnable", "inverted", "legendEnabled", "margin", "[Ljava/lang/Number;", "markerRadius", "markerSymbol", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;", "markerSymbolStyle", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;", "polar", "resources", "Landroid/content/res/Resources;", "scrollablePlotArea", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "series", "stacking", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", MediaFormat.KEY_SUBTITLE, "subtitleAlign", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "subtitleStyle", "title", "titleStyle", "tooltipEnabled", "tooltipValueSuffix", "touchEventEnabled", "xAxisGridLineWidth", "xAxisLabelsEnabled", "xAxisReversed", "xAxisTickInterval", "xAxisVisible", "yAxisAllowDecimals", "yAxisGridLineWidth", "yAxisLabelsEnabled", "yAxisLineWidth", "yAxisMax", "yAxisMin", "yAxisReversed", "yAxisTitle", "yAxisVisible", "zoomType", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "build", "getColor", "colorResId", "getDimen", "", "dimenResId", "getString", "id", "formatArgs", "(I[Ljava/lang/Object;)Ljava/lang/String;", f3.f5659h, "prop", "setAnimationDuration", "setAnimationType", "setAxesTextColor", "color", "setAxesTextColorRes", "setBackgroundColor", "setBorderRadius", "setCategories", "([Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "stringResIds", "", "setChartType", "setColorsTheme", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "colorResIds", "setDataLabelsEnabled", "setDataLabelsStyle", "setGradientColorEnable", "setInverted", "setLegendEnabled", "setMargin", "([Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "topResId", "leftResId", "bottomResId", "rightResId", "top", "left", "bottom", "right", "setMarkerRadius", "setMarkerRadiusRes", "setMarkerSymbol", "setMarkerSymbolStyle", "setPolar", "setScrollablePlotArea", "setSeries", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "([Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setStacking", "setSubtitle", "(I[Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setSubtitleAlign", "setSubtitleStyle", "setTitle", "setTitleStyle", "setTooltipEnabled", "setTooltipValueSuffix", "stringResId", "setTouchEventEnabled", "setXAxisGridLineWidth", "setXAxisLabelsEnabled", "setXAxisReversed", "setXAxisTickInterval", "setXAxisVisible", "setYAxisAllowDecimals", "setYAxisGridLineWidth", "setYAxisLabelsEnabled", "setYAxisLineWidth", "setYAxisMax", "setYAxisMin", "setYAxisReversed", "setYAxisTitle", "setYAxisVisible", "setZoomType", "toColorString", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AABuilder {
    private Integer animationDuration;
    private AAChartAnimationType animationType;
    private final Context applicationContext;
    private String axesTextColor;
    private Object backgroundColor;
    private Number borderRadius;
    private String[] categories;
    private AAChartType chartType;
    private Object[] colorsTheme;
    private Boolean dataLabelsEnabled;
    private AAStyle dataLabelsStyle;
    private Boolean gradientColorEnable;
    private Boolean inverted;
    private Boolean legendEnabled;
    private Number[] margin;
    private Number markerRadius;
    private AAChartSymbolType markerSymbol;
    private AAChartSymbolStyleType markerSymbolStyle;
    private Boolean polar;
    private final Resources resources;
    private AAScrollablePlotArea scrollablePlotArea;
    private Object[] series;
    private AAChartStackingType stacking;
    private String subtitle;
    private AAChartAlignType subtitleAlign;
    private AAStyle subtitleStyle;
    private String title;
    private AAStyle titleStyle;
    private Boolean tooltipEnabled;
    private String tooltipValueSuffix;
    private Boolean touchEventEnabled;
    private Number xAxisGridLineWidth;
    private Boolean xAxisLabelsEnabled;
    private Boolean xAxisReversed;
    private Integer xAxisTickInterval;
    private Boolean xAxisVisible;
    private Boolean yAxisAllowDecimals;
    private Number yAxisGridLineWidth;
    private Boolean yAxisLabelsEnabled;
    private Number yAxisLineWidth;
    private Number yAxisMax;
    private Number yAxisMin;
    private Boolean yAxisReversed;
    private String yAxisTitle;
    private Boolean yAxisVisible;
    private AAChartZoomType zoomType;

    public AABuilder(@NotNull Context context) {
        f0.p(context, "context");
        Context applicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.applicationContext = applicationContext;
        f0.o(applicationContext, "applicationContext");
        this.resources = applicationContext.getResources();
        this.animationType = AAChartAnimationType.Linear;
        this.animationDuration = 500;
        this.title = "";
        this.subtitle = "";
        this.chartType = AAChartType.Line;
        this.stacking = AAChartStackingType.False;
        this.markerRadius = Float.valueOf(6.0f);
        this.markerSymbolStyle = AAChartSymbolStyleType.Normal;
        this.zoomType = AAChartZoomType.None;
        Boolean bool = Boolean.FALSE;
        this.inverted = bool;
        this.xAxisReversed = bool;
        this.yAxisReversed = bool;
        this.gradientColorEnable = bool;
        this.polar = bool;
        this.dataLabelsEnabled = bool;
        Boolean bool2 = Boolean.TRUE;
        this.xAxisLabelsEnabled = bool2;
        Float valueOf = Float.valueOf(0.0f);
        this.xAxisGridLineWidth = valueOf;
        this.yAxisLabelsEnabled = bool2;
        this.yAxisGridLineWidth = Float.valueOf(1.0f);
        this.colorsTheme = new Object[]{"#fe117c", "#ffc069", "#06caf4", "#7dffc0"};
        this.legendEnabled = bool2;
        this.backgroundColor = "#ffffff";
        this.borderRadius = valueOf;
    }

    private final int getColor(int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.applicationContext.getColor(i4);
        }
        return this.resources.getColor(i4);
    }

    private final float getDimen(int i4) {
        return this.resources.getDimension(i4);
    }

    private final String getString(int i4, Object... objArr) {
        String string = this.resources.getString(i4, objArr);
        f0.o(string, "resources.getString(id, formatArgs)");
        return string;
    }

    private final String toColorString(int i4) {
        s0 s0Var = s0.f55680a;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(i4 & 16777215)}, 1));
        f0.o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @NotNull
    public final AAChartModel build() {
        return new AAChartModel(this.animationType, this.animationDuration, this.title, this.titleStyle, this.subtitle, this.subtitleAlign, this.subtitleStyle, this.axesTextColor, this.chartType, this.stacking, this.markerRadius, this.markerSymbol, this.markerSymbolStyle, this.zoomType, this.inverted, this.xAxisReversed, this.yAxisReversed, this.tooltipEnabled, this.tooltipValueSuffix, this.gradientColorEnable, this.polar, this.margin, this.dataLabelsEnabled, this.dataLabelsStyle, this.xAxisLabelsEnabled, this.xAxisTickInterval, this.categories, this.xAxisGridLineWidth, this.xAxisVisible, this.yAxisVisible, this.yAxisLabelsEnabled, this.yAxisTitle, this.yAxisLineWidth, this.yAxisMin, this.yAxisMax, this.yAxisAllowDecimals, this.yAxisGridLineWidth, this.colorsTheme, this.legendEnabled, this.backgroundColor, this.borderRadius, this.series, this.touchEventEnabled, this.scrollablePlotArea);
    }

    @NotNull
    public final AABuilder set(@NotNull AAChartModel prop) {
        f0.p(prop, "prop");
        this.animationType = prop.getAnimationType();
        this.animationDuration = prop.getAnimationDuration();
        this.title = prop.getTitle();
        this.titleStyle = prop.getTitleStyle();
        this.subtitle = prop.getSubtitle();
        this.subtitleAlign = prop.getSubtitleAlign();
        this.subtitleStyle = prop.getSubtitleStyle();
        this.axesTextColor = prop.getAxesTextColor();
        this.chartType = prop.getChartType();
        this.stacking = prop.getStacking();
        this.markerRadius = prop.getMarkerRadius();
        this.markerSymbol = prop.getMarkerSymbol();
        this.markerSymbolStyle = prop.getMarkerSymbolStyle();
        this.zoomType = prop.getZoomType();
        this.inverted = prop.getInverted();
        this.xAxisReversed = prop.getXAxisReversed();
        this.yAxisReversed = prop.getYAxisReversed();
        this.tooltipEnabled = prop.getTooltipEnabled();
        this.tooltipValueSuffix = prop.getTooltipValueSuffix();
        this.gradientColorEnable = prop.getGradientColorEnable();
        this.polar = prop.getPolar();
        this.margin = prop.getMargin();
        this.dataLabelsEnabled = prop.getDataLabelsEnabled();
        this.dataLabelsStyle = prop.getDataLabelsStyle();
        this.xAxisLabelsEnabled = prop.getXAxisLabelsEnabled();
        this.xAxisTickInterval = prop.getXAxisTickInterval();
        this.categories = prop.getCategories();
        this.xAxisGridLineWidth = prop.getXAxisGridLineWidth();
        this.xAxisVisible = prop.getXAxisVisible();
        this.yAxisVisible = prop.getYAxisVisible();
        this.yAxisLabelsEnabled = prop.getYAxisLabelsEnabled();
        this.yAxisTitle = prop.getYAxisTitle();
        this.yAxisLineWidth = prop.getYAxisLineWidth();
        this.yAxisMin = prop.getYAxisMin();
        this.yAxisMax = prop.getYAxisMax();
        this.yAxisAllowDecimals = prop.getYAxisAllowDecimals();
        this.yAxisGridLineWidth = prop.getYAxisGridLineWidth();
        this.colorsTheme = prop.getColorsTheme();
        this.legendEnabled = prop.getLegendEnabled();
        this.backgroundColor = prop.getBackgroundColor();
        this.borderRadius = prop.getBorderRadius();
        this.series = prop.getSeries();
        this.touchEventEnabled = prop.getTouchEventEnabled();
        this.scrollablePlotArea = prop.getScrollablePlotArea();
        return this;
    }

    @NotNull
    public final AABuilder setAnimationDuration(int i4) {
        this.animationDuration = Integer.valueOf(i4);
        return this;
    }

    @NotNull
    public final AABuilder setAnimationType(@NotNull AAChartAnimationType prop) {
        f0.p(prop, "prop");
        this.animationType = prop;
        return this;
    }

    @NotNull
    public final AABuilder setAxesTextColor(@NotNull String prop) {
        f0.p(prop, "prop");
        this.axesTextColor = prop;
        return this;
    }

    @NotNull
    public final AABuilder setAxesTextColorRes(int i4) {
        return setAxesTextColor(toColorString(getColor(i4)));
    }

    @NotNull
    public final AABuilder setBackgroundColor(@NotNull String prop) {
        f0.p(prop, "prop");
        this.backgroundColor = prop;
        return this;
    }

    @NotNull
    public final AABuilder setBorderRadius(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.borderRadius = prop;
        return this;
    }

    @NotNull
    public final AABuilder setCategories(@NotNull String... prop) {
        f0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (String str : prop) {
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            this.categories = (String[]) array;
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final AABuilder setChartType(@NotNull AAChartType prop) {
        f0.p(prop, "prop");
        this.chartType = prop;
        return this;
    }

    @NotNull
    public final AABuilder setColorsTheme(@NotNull Object[] prop) {
        f0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (Object obj : prop) {
            arrayList.add(obj);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        if (array != null) {
            this.colorsTheme = array;
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final AABuilder setDataLabelsEnabled(boolean z3) {
        this.dataLabelsEnabled = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setDataLabelsStyle(@NotNull AAStyle prop) {
        f0.p(prop, "prop");
        this.dataLabelsStyle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setGradientColorEnable(boolean z3) {
        this.gradientColorEnable = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setInverted(boolean z3) {
        this.inverted = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setLegendEnabled(boolean z3) {
        this.legendEnabled = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setMargin(@NotNull Number top2, @NotNull Number left, @NotNull Number bottom, @NotNull Number right) {
        f0.p(top2, "top");
        f0.p(left, "left");
        f0.p(bottom, "bottom");
        f0.p(right, "right");
        return setMargin(top2, left, bottom, right);
    }

    @NotNull
    public final AABuilder setMarkerRadius(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.markerRadius = prop;
        return this;
    }

    @NotNull
    public final AABuilder setMarkerRadiusRes(int i4) {
        return setMarkerRadius(Float.valueOf(getDimen(i4)));
    }

    @NotNull
    public final AABuilder setMarkerSymbol(@NotNull AAChartSymbolType prop) {
        f0.p(prop, "prop");
        this.markerSymbol = prop;
        return this;
    }

    @NotNull
    public final AABuilder setMarkerSymbolStyle(@NotNull AAChartSymbolStyleType prop) {
        f0.p(prop, "prop");
        this.markerSymbolStyle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setPolar(boolean z3) {
        this.polar = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setScrollablePlotArea(@NotNull AAScrollablePlotArea prop) {
        f0.p(prop, "prop");
        this.scrollablePlotArea = prop;
        return this;
    }

    @NotNull
    public final AABuilder setSeries(@NotNull AASeriesElement... prop) {
        f0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (AASeriesElement aASeriesElement : prop) {
            arrayList.add(aASeriesElement);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        if (array != null) {
            this.series = array;
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final AABuilder setStacking(@NotNull AAChartStackingType prop) {
        f0.p(prop, "prop");
        this.stacking = prop;
        return this;
    }

    @NotNull
    public final AABuilder setSubtitle(@NotNull String prop) {
        f0.p(prop, "prop");
        this.subtitle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setSubtitleAlign(@NotNull AAChartAlignType prop) {
        f0.p(prop, "prop");
        this.subtitleAlign = prop;
        return this;
    }

    @NotNull
    public final AABuilder setSubtitleStyle(@NotNull AAStyle prop) {
        f0.p(prop, "prop");
        this.subtitleStyle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setTitle(@NotNull String prop) {
        f0.p(prop, "prop");
        this.title = prop;
        return this;
    }

    @NotNull
    public final AABuilder setTitleStyle(@NotNull AAStyle prop) {
        f0.p(prop, "prop");
        this.titleStyle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setTooltipEnabled(boolean z3) {
        this.tooltipEnabled = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setTooltipValueSuffix(@NotNull String prop) {
        f0.p(prop, "prop");
        this.tooltipValueSuffix = prop;
        return this;
    }

    @NotNull
    public final AABuilder setTouchEventEnabled(boolean z3) {
        this.touchEventEnabled = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setXAxisGridLineWidth(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.xAxisGridLineWidth = prop;
        return this;
    }

    @NotNull
    public final AABuilder setXAxisLabelsEnabled(boolean z3) {
        this.xAxisLabelsEnabled = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setXAxisReversed(boolean z3) {
        this.xAxisReversed = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setXAxisTickInterval(int i4) {
        this.xAxisTickInterval = Integer.valueOf(i4);
        return this;
    }

    @NotNull
    public final AABuilder setXAxisVisible(boolean z3) {
        this.xAxisVisible = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setYAxisAllowDecimals(boolean z3) {
        this.yAxisAllowDecimals = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setYAxisGridLineWidth(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.yAxisGridLineWidth = prop;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisLabelsEnabled(boolean z3) {
        this.yAxisLabelsEnabled = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setYAxisLineWidth(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.yAxisLineWidth = prop;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisMax(@Nullable Number number) {
        this.yAxisMax = number;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisMin(@Nullable Number number) {
        this.yAxisMin = number;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisReversed(boolean z3) {
        this.yAxisReversed = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setYAxisTitle(@NotNull String prop) {
        f0.p(prop, "prop");
        this.yAxisTitle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisVisible(boolean z3) {
        this.yAxisVisible = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AABuilder setZoomType(@NotNull AAChartZoomType prop) {
        f0.p(prop, "prop");
        this.zoomType = prop;
        return this;
    }

    @NotNull
    public final AABuilder setAxesTextColor(int i4) {
        return setAxesTextColor(toColorString(i4));
    }

    @NotNull
    public final AABuilder setBackgroundColor(int i4) {
        return setBackgroundColor(toColorString(getColor(i4)));
    }

    @NotNull
    public final AABuilder setBorderRadius(int i4) {
        return setBorderRadius(Float.valueOf(getDimen(i4)));
    }

    @NotNull
    public final AABuilder setMargin(int i4, int i5, int i6, int i7) {
        return setMargin(Float.valueOf(getDimen(i4)), Float.valueOf(getDimen(i5)), Float.valueOf(getDimen(i6)), Float.valueOf(getDimen(i7)));
    }

    @NotNull
    public final AABuilder setSubtitle(int i4, @NotNull Object... formatArgs) {
        f0.p(formatArgs, "formatArgs");
        return setSubtitle(getString(i4, formatArgs));
    }

    @NotNull
    public final AABuilder setTitle(int i4, @NotNull Object... formatArgs) {
        f0.p(formatArgs, "formatArgs");
        return setTitle(getString(i4, formatArgs));
    }

    @NotNull
    public final AABuilder setTooltipValueSuffix(int i4, @NotNull Object... formatArgs) {
        f0.p(formatArgs, "formatArgs");
        return setTooltipValueSuffix(getString(i4, formatArgs));
    }

    @NotNull
    public final AABuilder setXAxisGridLineWidth(int i4) {
        return setXAxisGridLineWidth(Float.valueOf(getDimen(i4)));
    }

    @NotNull
    public final AABuilder setYAxisGridLineWidth(int i4) {
        return setYAxisGridLineWidth(Float.valueOf(getDimen(i4)));
    }

    @NotNull
    public final AABuilder setYAxisLineWidth(int i4) {
        return setYAxisLineWidth(Float.valueOf(getDimen(i4)));
    }

    @NotNull
    public final AABuilder setYAxisMax(int i4) {
        return setYAxisMax(Float.valueOf(getDimen(i4)));
    }

    @NotNull
    public final AABuilder setYAxisMin(int i4) {
        return setYAxisMin(Float.valueOf(getDimen(i4)));
    }

    @NotNull
    public final AABuilder setYAxisTitle(int i4, @NotNull Object... formatArgs) {
        f0.p(formatArgs, "formatArgs");
        return setYAxisTitle(getString(i4, formatArgs));
    }

    @NotNull
    public final AABuilder setCategories(@NotNull int... stringResIds) {
        f0.p(stringResIds, "stringResIds");
        ArrayList arrayList = new ArrayList(stringResIds.length);
        for (int i4 : stringResIds) {
            arrayList.add(getString(i4, new Object[0]));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            return setCategories((String[]) Arrays.copyOf(strArr, strArr.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final AABuilder setColorsTheme(@NotNull String... prop) {
        f0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (String str : prop) {
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        if (array != null) {
            this.colorsTheme = array;
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final AABuilder setMargin(@NotNull Number... prop) {
        f0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (Number number : prop) {
            arrayList.add(number);
        }
        Object[] array = arrayList.toArray(new Number[0]);
        if (array != null) {
            this.margin = (Number[]) array;
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final AABuilder setColorsTheme(@NotNull int... colorResIds) {
        f0.p(colorResIds, "colorResIds");
        ArrayList arrayList = new ArrayList(colorResIds.length);
        for (int i4 : colorResIds) {
            arrayList.add(toColorString(getColor(i4)));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            return setColorsTheme((String[]) Arrays.copyOf(strArr, strArr.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AABuilder(@NotNull Context context, @NotNull AAChartModel source) {
        this(context);
        f0.p(context, "context");
        f0.p(source, "source");
        set(source);
    }
}
