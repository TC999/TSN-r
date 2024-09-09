package com.github.aachartmodel.aainfographics.aachartcreator;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.github.aachartmodel.aainfographics.aatools.AABuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAChartModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0003\b\u0088\u0001\u0018\u0000 \u00c2\u00012\u00020\u0001:\u0002\u00c2\u0001B\u00ad\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010$\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010$\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010$\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u00a2\u0006\u0002\u0010<J\u0017\u0010\u0004\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0003\u0010\u00bd\u0001J\u000f\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0003J\u000f\u0010\u000e\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0007J\u000f\u00106\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0001J\u0011\u00107\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0014J\u001b\u0010)\u001a\u00020\u00002\r\u0010\u00bc\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070$\u00a2\u0006\u0003\u0010\u00be\u0001J\u000f\u0010\u000f\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0010J\u001b\u00104\u001a\u00020\u00002\r\u0010\u00bc\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010$\u00a2\u0006\u0003\u0010\u00bf\u0001J\u0017\u0010%\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u000f\u0010&\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\tJ\u0017\u0010!\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u0017\u0010\u001b\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u0017\u00105\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u001d\u0010#\u001a\u00020\u00002\u000f\u0010\u00bc\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010$\u00a2\u0006\u0003\u0010\u00c1\u0001J\u0011\u0010\u0013\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0014J\u000f\u0010\u0015\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0016J\u000f\u0010\u0017\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0018J\u0017\u0010\"\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u000f\u0010:\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020;J\u001b\u00108\u001a\u00020\u00002\r\u0010\u00bc\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010$\u00a2\u0006\u0003\u0010\u00bf\u0001J\u000f\u0010\u0011\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0012J\u000f\u0010\n\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0007J\u000f\u0010\u000b\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\fJ\u000f\u0010\r\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\tJ\u000f\u0010\u0006\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0007J\u000f\u0010\b\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\tJ\u0017\u0010\u001f\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u0011\u0010 \u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0007J\u0017\u00109\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u0011\u0010*\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0014J\u0017\u0010'\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u0017\u0010\u001d\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u0017\u0010(\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0003\u0010\u00bd\u0001J\u0017\u0010+\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u0017\u00102\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u0011\u00103\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0014J\u0017\u0010-\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u0011\u0010/\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0014J\u0011\u00101\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0014J\u0011\u00100\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0014J\u0017\u0010\u001e\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u000f\u0010.\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u0007J\u0017\u0010,\u001a\u00020\u00002\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0003\u0010\u00c0\u0001J\u000f\u0010\u0019\u001a\u00020\u00002\u0007\u0010\u00bc\u0001\u001a\u00020\u001aR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u00106\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u00107\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010$X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010V\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u00104\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010$X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010_\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001e\u0010%\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010d\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001c\u0010&\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001e\u0010!\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010d\u001a\u0004\bi\u0010a\"\u0004\bj\u0010cR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010d\u001a\u0004\bk\u0010a\"\u0004\bl\u0010cR\u001e\u00105\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010d\u001a\u0004\bm\u0010a\"\u0004\bn\u0010cR$\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010$X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010s\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010O\"\u0004\bu\u0010QR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001e\u0010\"\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010d\u001a\u0004\b~\u0010a\"\u0004\b\u007f\u0010cR \u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R&\u00108\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010$X\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010_\u001a\u0005\b\u0084\u0001\u0010\\\"\u0005\b\u0085\u0001\u0010^R \u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010G\"\u0005\b\u008b\u0001\u0010IR \u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001e\u0010\r\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010f\"\u0005\b\u0091\u0001\u0010hR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010G\"\u0005\b\u0093\u0001\u0010IR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010f\"\u0005\b\u0095\u0001\u0010hR \u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010d\u001a\u0005\b\u0096\u0001\u0010a\"\u0005\b\u0097\u0001\u0010cR\u001e\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010G\"\u0005\b\u0099\u0001\u0010IR \u00109\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010d\u001a\u0005\b\u009a\u0001\u0010a\"\u0005\b\u009b\u0001\u0010cR\u001e\u0010*\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010O\"\u0005\b\u009d\u0001\u0010QR \u0010'\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010d\u001a\u0005\b\u009e\u0001\u0010a\"\u0005\b\u009f\u0001\u0010cR \u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010d\u001a\u0005\b\u00a0\u0001\u0010a\"\u0005\b\u00a1\u0001\u0010cR \u0010(\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010A\u001a\u0005\b\u00a2\u0001\u0010>\"\u0005\b\u00a3\u0001\u0010@R \u0010+\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010d\u001a\u0005\b\u00a4\u0001\u0010a\"\u0005\b\u00a5\u0001\u0010cR \u00102\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010d\u001a\u0005\b\u00a6\u0001\u0010a\"\u0005\b\u00a7\u0001\u0010cR\u001e\u00103\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a8\u0001\u0010O\"\u0005\b\u00a9\u0001\u0010QR \u0010-\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010d\u001a\u0005\b\u00aa\u0001\u0010a\"\u0005\b\u00ab\u0001\u0010cR\u001e\u0010/\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ac\u0001\u0010O\"\u0005\b\u00ad\u0001\u0010QR\u001e\u00101\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ae\u0001\u0010O\"\u0005\b\u00af\u0001\u0010QR\u001e\u00100\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b0\u0001\u0010O\"\u0005\b\u00b1\u0001\u0010QR \u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010d\u001a\u0005\b\u00b2\u0001\u0010a\"\u0005\b\u00b3\u0001\u0010cR\u001e\u0010.\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b4\u0001\u0010G\"\u0005\b\u00b5\u0001\u0010IR \u0010,\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0012\n\u0002\u0010d\u001a\u0005\b\u00b6\u0001\u0010a\"\u0005\b\u00b7\u0001\u0010cR \u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001\"\u0006\b\u00ba\u0001\u0010\u00bb\u0001\u00a8\u0006\u00c3\u0001"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "", "animationType", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "animationDuration", "", "title", "", "titleStyle", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", MediaFormat.KEY_SUBTITLE, "subtitleAlign", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "subtitleStyle", "axesTextColor", "chartType", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "stacking", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", "markerRadius", "", "markerSymbol", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;", "markerSymbolStyle", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;", "zoomType", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "inverted", "", "xAxisReversed", "yAxisReversed", "tooltipEnabled", "tooltipValueSuffix", "gradientColorEnable", "polar", "margin", "", "dataLabelsEnabled", "dataLabelsStyle", "xAxisLabelsEnabled", "xAxisTickInterval", "categories", "xAxisGridLineWidth", "xAxisVisible", "yAxisVisible", "yAxisLabelsEnabled", "yAxisTitle", "yAxisLineWidth", "yAxisMin", "yAxisMax", "yAxisAllowDecimals", "yAxisGridLineWidth", "colorsTheme", "legendEnabled", "backgroundColor", "borderRadius", "series", "touchEventEnabled", "scrollablePlotArea", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;Ljava/lang/Integer;Ljava/lang/String;Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;Ljava/lang/String;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;Ljava/lang/String;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;Ljava/lang/Number;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/Number;Ljava/lang/Boolean;Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;Ljava/lang/Boolean;Ljava/lang/Integer;[Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Number;[Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Object;Ljava/lang/Number;[Ljava/lang/Object;Ljava/lang/Boolean;Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;)V", "getAnimationDuration", "()Ljava/lang/Integer;", "setAnimationDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAnimationType", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "setAnimationType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;)V", "getAxesTextColor", "()Ljava/lang/String;", "setAxesTextColor", "(Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/Object;", "setBackgroundColor", "(Ljava/lang/Object;)V", "getBorderRadius", "()Ljava/lang/Number;", "setBorderRadius", "(Ljava/lang/Number;)V", "getCategories", "()[Ljava/lang/String;", "setCategories", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getChartType", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "setChartType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;)V", "getColorsTheme", "()[Ljava/lang/Object;", "setColorsTheme", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getDataLabelsEnabled", "()Ljava/lang/Boolean;", "setDataLabelsEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDataLabelsStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setDataLabelsStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)V", "getGradientColorEnable", "setGradientColorEnable", "getInverted", "setInverted", "getLegendEnabled", "setLegendEnabled", "getMargin", "()[Ljava/lang/Number;", "setMargin", "([Ljava/lang/Number;)V", "[Ljava/lang/Number;", "getMarkerRadius", "setMarkerRadius", "getMarkerSymbol", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;", "setMarkerSymbol", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;)V", "getMarkerSymbolStyle", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;", "setMarkerSymbolStyle", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;)V", "getPolar", "setPolar", "getScrollablePlotArea", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "setScrollablePlotArea", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;)V", "getSeries", "setSeries", "getStacking", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", "setStacking", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;)V", "getSubtitle", "setSubtitle", "getSubtitleAlign", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "setSubtitleAlign", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;)V", "getSubtitleStyle", "setSubtitleStyle", "getTitle", "setTitle", "getTitleStyle", "setTitleStyle", "getTooltipEnabled", "setTooltipEnabled", "getTooltipValueSuffix", "setTooltipValueSuffix", "getTouchEventEnabled", "setTouchEventEnabled", "getXAxisGridLineWidth", "setXAxisGridLineWidth", "getXAxisLabelsEnabled", "setXAxisLabelsEnabled", "getXAxisReversed", "setXAxisReversed", "getXAxisTickInterval", "setXAxisTickInterval", "getXAxisVisible", "setXAxisVisible", "getYAxisAllowDecimals", "setYAxisAllowDecimals", "getYAxisGridLineWidth", "setYAxisGridLineWidth", "getYAxisLabelsEnabled", "setYAxisLabelsEnabled", "getYAxisLineWidth", "setYAxisLineWidth", "getYAxisMax", "setYAxisMax", "getYAxisMin", "setYAxisMin", "getYAxisReversed", "setYAxisReversed", "getYAxisTitle", "setYAxisTitle", "getYAxisVisible", "setYAxisVisible", "getZoomType", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "setZoomType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;)V", "prop", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "([Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "([Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "Companion", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAChartModel {
    public static final Companion Companion = new Companion(null);
    @Nullable
    private Integer animationDuration;
    @Nullable
    private AAChartAnimationType animationType;
    @Nullable
    private String axesTextColor;
    @Nullable
    private Object backgroundColor;
    @Nullable
    private Number borderRadius;
    @Nullable
    private String[] categories;
    @Nullable
    private AAChartType chartType;
    @Nullable
    private Object[] colorsTheme;
    @Nullable
    private Boolean dataLabelsEnabled;
    @Nullable
    private AAStyle dataLabelsStyle;
    @Nullable
    private Boolean gradientColorEnable;
    @Nullable
    private Boolean inverted;
    @Nullable
    private Boolean legendEnabled;
    @Nullable
    private Number[] margin;
    @Nullable
    private Number markerRadius;
    @Nullable
    private AAChartSymbolType markerSymbol;
    @Nullable
    private AAChartSymbolStyleType markerSymbolStyle;
    @Nullable
    private Boolean polar;
    @Nullable
    private AAScrollablePlotArea scrollablePlotArea;
    @Nullable
    private Object[] series;
    @Nullable
    private AAChartStackingType stacking;
    @Nullable
    private String subtitle;
    @Nullable
    private AAChartAlignType subtitleAlign;
    @Nullable
    private AAStyle subtitleStyle;
    @Nullable
    private String title;
    @Nullable
    private AAStyle titleStyle;
    @Nullable
    private Boolean tooltipEnabled;
    @Nullable
    private String tooltipValueSuffix;
    @Nullable
    private Boolean touchEventEnabled;
    @Nullable
    private Number xAxisGridLineWidth;
    @Nullable
    private Boolean xAxisLabelsEnabled;
    @Nullable
    private Boolean xAxisReversed;
    @Nullable
    private Integer xAxisTickInterval;
    @Nullable
    private Boolean xAxisVisible;
    @Nullable
    private Boolean yAxisAllowDecimals;
    @Nullable
    private Number yAxisGridLineWidth;
    @Nullable
    private Boolean yAxisLabelsEnabled;
    @Nullable
    private Number yAxisLineWidth;
    @Nullable
    private Number yAxisMax;
    @Nullable
    private Number yAxisMin;
    @Nullable
    private Boolean yAxisReversed;
    @Nullable
    private String yAxisTitle;
    @Nullable
    private Boolean yAxisVisible;
    @Nullable
    private AAChartZoomType zoomType;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: AAChartModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel$Companion;", "", "()V", "Builder", "Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "context", "Landroid/content/Context;", "charts_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AABuilder Builder(@NotNull Context context) {
            f0.p(context, "context");
            return new AABuilder(context);
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public AAChartModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null);
    }

    public AAChartModel(@Nullable AAChartAnimationType aAChartAnimationType, @Nullable Integer num, @Nullable String str, @Nullable AAStyle aAStyle, @Nullable String str2, @Nullable AAChartAlignType aAChartAlignType, @Nullable AAStyle aAStyle2, @Nullable String str3, @Nullable AAChartType aAChartType, @Nullable AAChartStackingType aAChartStackingType, @Nullable Number number, @Nullable AAChartSymbolType aAChartSymbolType, @Nullable AAChartSymbolStyleType aAChartSymbolStyleType, @Nullable AAChartZoomType aAChartZoomType, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Number[] numberArr, @Nullable Boolean bool7, @Nullable AAStyle aAStyle3, @Nullable Boolean bool8, @Nullable Integer num2, @Nullable String[] strArr, @Nullable Number number2, @Nullable Boolean bool9, @Nullable Boolean bool10, @Nullable Boolean bool11, @Nullable String str5, @Nullable Number number3, @Nullable Number number4, @Nullable Number number5, @Nullable Boolean bool12, @Nullable Number number6, @Nullable Object[] objArr, @Nullable Boolean bool13, @Nullable Object obj, @Nullable Number number7, @Nullable Object[] objArr2, @Nullable Boolean bool14, @Nullable AAScrollablePlotArea aAScrollablePlotArea) {
        this.animationType = aAChartAnimationType;
        this.animationDuration = num;
        this.title = str;
        this.titleStyle = aAStyle;
        this.subtitle = str2;
        this.subtitleAlign = aAChartAlignType;
        this.subtitleStyle = aAStyle2;
        this.axesTextColor = str3;
        this.chartType = aAChartType;
        this.stacking = aAChartStackingType;
        this.markerRadius = number;
        this.markerSymbol = aAChartSymbolType;
        this.markerSymbolStyle = aAChartSymbolStyleType;
        this.zoomType = aAChartZoomType;
        this.inverted = bool;
        this.xAxisReversed = bool2;
        this.yAxisReversed = bool3;
        this.tooltipEnabled = bool4;
        this.tooltipValueSuffix = str4;
        this.gradientColorEnable = bool5;
        this.polar = bool6;
        this.margin = numberArr;
        this.dataLabelsEnabled = bool7;
        this.dataLabelsStyle = aAStyle3;
        this.xAxisLabelsEnabled = bool8;
        this.xAxisTickInterval = num2;
        this.categories = strArr;
        this.xAxisGridLineWidth = number2;
        this.xAxisVisible = bool9;
        this.yAxisVisible = bool10;
        this.yAxisLabelsEnabled = bool11;
        this.yAxisTitle = str5;
        this.yAxisLineWidth = number3;
        this.yAxisMin = number4;
        this.yAxisMax = number5;
        this.yAxisAllowDecimals = bool12;
        this.yAxisGridLineWidth = number6;
        this.colorsTheme = objArr;
        this.legendEnabled = bool13;
        this.backgroundColor = obj;
        this.borderRadius = number7;
        this.series = objArr2;
        this.touchEventEnabled = bool14;
        this.scrollablePlotArea = aAScrollablePlotArea;
    }

    @NotNull
    public final AAChartModel animationDuration(@Nullable Integer num) {
        this.animationDuration = num;
        return this;
    }

    @NotNull
    public final AAChartModel animationType(@NotNull AAChartAnimationType prop) {
        f0.p(prop, "prop");
        this.animationType = prop;
        return this;
    }

    @NotNull
    public final AAChartModel axesTextColor(@NotNull String prop) {
        f0.p(prop, "prop");
        this.axesTextColor = prop;
        return this;
    }

    @NotNull
    public final AAChartModel backgroundColor(@NotNull Object prop) {
        f0.p(prop, "prop");
        this.backgroundColor = prop;
        return this;
    }

    @NotNull
    public final AAChartModel borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AAChartModel categories(@NotNull String[] prop) {
        f0.p(prop, "prop");
        this.categories = prop;
        return this;
    }

    @NotNull
    public final AAChartModel chartType(@NotNull AAChartType prop) {
        f0.p(prop, "prop");
        this.chartType = prop;
        return this;
    }

    @NotNull
    public final AAChartModel colorsTheme(@NotNull Object[] prop) {
        f0.p(prop, "prop");
        this.colorsTheme = prop;
        return this;
    }

    @NotNull
    public final AAChartModel dataLabelsEnabled(@Nullable Boolean bool) {
        this.dataLabelsEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel dataLabelsStyle(@NotNull AAStyle prop) {
        f0.p(prop, "prop");
        this.dataLabelsStyle = prop;
        return this;
    }

    @Nullable
    public final Integer getAnimationDuration() {
        return this.animationDuration;
    }

    @Nullable
    public final AAChartAnimationType getAnimationType() {
        return this.animationType;
    }

    @Nullable
    public final String getAxesTextColor() {
        return this.axesTextColor;
    }

    @Nullable
    public final Object getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @Nullable
    public final String[] getCategories() {
        return this.categories;
    }

    @Nullable
    public final AAChartType getChartType() {
        return this.chartType;
    }

    @Nullable
    public final Object[] getColorsTheme() {
        return this.colorsTheme;
    }

    @Nullable
    public final Boolean getDataLabelsEnabled() {
        return this.dataLabelsEnabled;
    }

    @Nullable
    public final AAStyle getDataLabelsStyle() {
        return this.dataLabelsStyle;
    }

    @Nullable
    public final Boolean getGradientColorEnable() {
        return this.gradientColorEnable;
    }

    @Nullable
    public final Boolean getInverted() {
        return this.inverted;
    }

    @Nullable
    public final Boolean getLegendEnabled() {
        return this.legendEnabled;
    }

    @Nullable
    public final Number[] getMargin() {
        return this.margin;
    }

    @Nullable
    public final Number getMarkerRadius() {
        return this.markerRadius;
    }

    @Nullable
    public final AAChartSymbolType getMarkerSymbol() {
        return this.markerSymbol;
    }

    @Nullable
    public final AAChartSymbolStyleType getMarkerSymbolStyle() {
        return this.markerSymbolStyle;
    }

    @Nullable
    public final Boolean getPolar() {
        return this.polar;
    }

    @Nullable
    public final AAScrollablePlotArea getScrollablePlotArea() {
        return this.scrollablePlotArea;
    }

    @Nullable
    public final Object[] getSeries() {
        return this.series;
    }

    @Nullable
    public final AAChartStackingType getStacking() {
        return this.stacking;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final AAChartAlignType getSubtitleAlign() {
        return this.subtitleAlign;
    }

    @Nullable
    public final AAStyle getSubtitleStyle() {
        return this.subtitleStyle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final AAStyle getTitleStyle() {
        return this.titleStyle;
    }

    @Nullable
    public final Boolean getTooltipEnabled() {
        return this.tooltipEnabled;
    }

    @Nullable
    public final String getTooltipValueSuffix() {
        return this.tooltipValueSuffix;
    }

    @Nullable
    public final Boolean getTouchEventEnabled() {
        return this.touchEventEnabled;
    }

    @Nullable
    public final Number getXAxisGridLineWidth() {
        return this.xAxisGridLineWidth;
    }

    @Nullable
    public final Boolean getXAxisLabelsEnabled() {
        return this.xAxisLabelsEnabled;
    }

    @Nullable
    public final Boolean getXAxisReversed() {
        return this.xAxisReversed;
    }

    @Nullable
    public final Integer getXAxisTickInterval() {
        return this.xAxisTickInterval;
    }

    @Nullable
    public final Boolean getXAxisVisible() {
        return this.xAxisVisible;
    }

    @Nullable
    public final Boolean getYAxisAllowDecimals() {
        return this.yAxisAllowDecimals;
    }

    @Nullable
    public final Number getYAxisGridLineWidth() {
        return this.yAxisGridLineWidth;
    }

    @Nullable
    public final Boolean getYAxisLabelsEnabled() {
        return this.yAxisLabelsEnabled;
    }

    @Nullable
    public final Number getYAxisLineWidth() {
        return this.yAxisLineWidth;
    }

    @Nullable
    public final Number getYAxisMax() {
        return this.yAxisMax;
    }

    @Nullable
    public final Number getYAxisMin() {
        return this.yAxisMin;
    }

    @Nullable
    public final Boolean getYAxisReversed() {
        return this.yAxisReversed;
    }

    @Nullable
    public final String getYAxisTitle() {
        return this.yAxisTitle;
    }

    @Nullable
    public final Boolean getYAxisVisible() {
        return this.yAxisVisible;
    }

    @Nullable
    public final AAChartZoomType getZoomType() {
        return this.zoomType;
    }

    @NotNull
    public final AAChartModel gradientColorEnable(@Nullable Boolean bool) {
        this.gradientColorEnable = bool;
        return this;
    }

    @NotNull
    public final AAChartModel inverted(@Nullable Boolean bool) {
        this.inverted = bool;
        return this;
    }

    @NotNull
    public final AAChartModel legendEnabled(@Nullable Boolean bool) {
        this.legendEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel margin(@Nullable Number[] numberArr) {
        this.margin = numberArr;
        return this;
    }

    @NotNull
    public final AAChartModel markerRadius(@Nullable Number number) {
        this.markerRadius = number;
        return this;
    }

    @NotNull
    public final AAChartModel markerSymbol(@NotNull AAChartSymbolType prop) {
        f0.p(prop, "prop");
        this.markerSymbol = prop;
        return this;
    }

    @NotNull
    public final AAChartModel markerSymbolStyle(@NotNull AAChartSymbolStyleType prop) {
        f0.p(prop, "prop");
        this.markerSymbolStyle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel polar(@Nullable Boolean bool) {
        this.polar = bool;
        return this;
    }

    @NotNull
    public final AAChartModel scrollablePlotArea(@NotNull AAScrollablePlotArea prop) {
        f0.p(prop, "prop");
        this.scrollablePlotArea = prop;
        return this;
    }

    @NotNull
    public final AAChartModel series(@NotNull Object[] prop) {
        f0.p(prop, "prop");
        this.series = prop;
        return this;
    }

    public final void setAnimationDuration(@Nullable Integer num) {
        this.animationDuration = num;
    }

    public final void setAnimationType(@Nullable AAChartAnimationType aAChartAnimationType) {
        this.animationType = aAChartAnimationType;
    }

    public final void setAxesTextColor(@Nullable String str) {
        this.axesTextColor = str;
    }

    public final void setBackgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
    }

    public final void setBorderRadius(@Nullable Number number) {
        this.borderRadius = number;
    }

    public final void setCategories(@Nullable String[] strArr) {
        this.categories = strArr;
    }

    public final void setChartType(@Nullable AAChartType aAChartType) {
        this.chartType = aAChartType;
    }

    public final void setColorsTheme(@Nullable Object[] objArr) {
        this.colorsTheme = objArr;
    }

    public final void setDataLabelsEnabled(@Nullable Boolean bool) {
        this.dataLabelsEnabled = bool;
    }

    public final void setDataLabelsStyle(@Nullable AAStyle aAStyle) {
        this.dataLabelsStyle = aAStyle;
    }

    public final void setGradientColorEnable(@Nullable Boolean bool) {
        this.gradientColorEnable = bool;
    }

    public final void setInverted(@Nullable Boolean bool) {
        this.inverted = bool;
    }

    public final void setLegendEnabled(@Nullable Boolean bool) {
        this.legendEnabled = bool;
    }

    public final void setMargin(@Nullable Number[] numberArr) {
        this.margin = numberArr;
    }

    public final void setMarkerRadius(@Nullable Number number) {
        this.markerRadius = number;
    }

    public final void setMarkerSymbol(@Nullable AAChartSymbolType aAChartSymbolType) {
        this.markerSymbol = aAChartSymbolType;
    }

    public final void setMarkerSymbolStyle(@Nullable AAChartSymbolStyleType aAChartSymbolStyleType) {
        this.markerSymbolStyle = aAChartSymbolStyleType;
    }

    public final void setPolar(@Nullable Boolean bool) {
        this.polar = bool;
    }

    public final void setScrollablePlotArea(@Nullable AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
    }

    public final void setSeries(@Nullable Object[] objArr) {
        this.series = objArr;
    }

    public final void setStacking(@Nullable AAChartStackingType aAChartStackingType) {
        this.stacking = aAChartStackingType;
    }

    public final void setSubtitle(@Nullable String str) {
        this.subtitle = str;
    }

    public final void setSubtitleAlign(@Nullable AAChartAlignType aAChartAlignType) {
        this.subtitleAlign = aAChartAlignType;
    }

    public final void setSubtitleStyle(@Nullable AAStyle aAStyle) {
        this.subtitleStyle = aAStyle;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setTitleStyle(@Nullable AAStyle aAStyle) {
        this.titleStyle = aAStyle;
    }

    public final void setTooltipEnabled(@Nullable Boolean bool) {
        this.tooltipEnabled = bool;
    }

    public final void setTooltipValueSuffix(@Nullable String str) {
        this.tooltipValueSuffix = str;
    }

    public final void setTouchEventEnabled(@Nullable Boolean bool) {
        this.touchEventEnabled = bool;
    }

    public final void setXAxisGridLineWidth(@Nullable Number number) {
        this.xAxisGridLineWidth = number;
    }

    public final void setXAxisLabelsEnabled(@Nullable Boolean bool) {
        this.xAxisLabelsEnabled = bool;
    }

    public final void setXAxisReversed(@Nullable Boolean bool) {
        this.xAxisReversed = bool;
    }

    public final void setXAxisTickInterval(@Nullable Integer num) {
        this.xAxisTickInterval = num;
    }

    public final void setXAxisVisible(@Nullable Boolean bool) {
        this.xAxisVisible = bool;
    }

    public final void setYAxisAllowDecimals(@Nullable Boolean bool) {
        this.yAxisAllowDecimals = bool;
    }

    public final void setYAxisGridLineWidth(@Nullable Number number) {
        this.yAxisGridLineWidth = number;
    }

    public final void setYAxisLabelsEnabled(@Nullable Boolean bool) {
        this.yAxisLabelsEnabled = bool;
    }

    public final void setYAxisLineWidth(@Nullable Number number) {
        this.yAxisLineWidth = number;
    }

    public final void setYAxisMax(@Nullable Number number) {
        this.yAxisMax = number;
    }

    public final void setYAxisMin(@Nullable Number number) {
        this.yAxisMin = number;
    }

    public final void setYAxisReversed(@Nullable Boolean bool) {
        this.yAxisReversed = bool;
    }

    public final void setYAxisTitle(@Nullable String str) {
        this.yAxisTitle = str;
    }

    public final void setYAxisVisible(@Nullable Boolean bool) {
        this.yAxisVisible = bool;
    }

    public final void setZoomType(@Nullable AAChartZoomType aAChartZoomType) {
        this.zoomType = aAChartZoomType;
    }

    @NotNull
    public final AAChartModel stacking(@NotNull AAChartStackingType prop) {
        f0.p(prop, "prop");
        this.stacking = prop;
        return this;
    }

    @NotNull
    public final AAChartModel subtitle(@NotNull String prop) {
        f0.p(prop, "prop");
        this.subtitle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel subtitleAlign(@NotNull AAChartAlignType prop) {
        f0.p(prop, "prop");
        this.subtitleAlign = prop;
        return this;
    }

    @NotNull
    public final AAChartModel subtitleStyle(@NotNull AAStyle prop) {
        f0.p(prop, "prop");
        this.subtitleStyle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel title(@NotNull String prop) {
        f0.p(prop, "prop");
        this.title = prop;
        return this;
    }

    @NotNull
    public final AAChartModel titleStyle(@NotNull AAStyle prop) {
        f0.p(prop, "prop");
        this.titleStyle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel tooltipEnabled(@Nullable Boolean bool) {
        this.tooltipEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel tooltipValueSuffix(@Nullable String str) {
        this.tooltipValueSuffix = str;
        return this;
    }

    @NotNull
    public final AAChartModel touchEventEnabled(@Nullable Boolean bool) {
        this.touchEventEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisGridLineWidth(@Nullable Number number) {
        this.xAxisGridLineWidth = number;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisLabelsEnabled(@Nullable Boolean bool) {
        this.xAxisLabelsEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisReversed(@Nullable Boolean bool) {
        this.xAxisReversed = bool;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisTickInterval(@Nullable Integer num) {
        this.xAxisTickInterval = num;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisVisible(@Nullable Boolean bool) {
        this.xAxisVisible = bool;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisAllowDecimals(@Nullable Boolean bool) {
        this.yAxisAllowDecimals = bool;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisGridLineWidth(@Nullable Number number) {
        this.yAxisGridLineWidth = number;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisLabelsEnabled(@Nullable Boolean bool) {
        this.yAxisLabelsEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisLineWidth(@Nullable Number number) {
        this.yAxisLineWidth = number;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisMax(@Nullable Number number) {
        this.yAxisMax = number;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisMin(@Nullable Number number) {
        this.yAxisMin = number;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisReversed(@Nullable Boolean bool) {
        this.yAxisReversed = bool;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisTitle(@NotNull String prop) {
        f0.p(prop, "prop");
        this.yAxisTitle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisVisible(@Nullable Boolean bool) {
        this.yAxisVisible = bool;
        return this;
    }

    @NotNull
    public final AAChartModel zoomType(@NotNull AAChartZoomType prop) {
        f0.p(prop, "prop");
        this.zoomType = prop;
        return this;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AAChartModel(com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType r43, java.lang.Integer r44, java.lang.String r45, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle r46, java.lang.String r47, com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType r48, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle r49, java.lang.String r50, com.github.aachartmodel.aainfographics.aachartcreator.AAChartType r51, com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType r52, java.lang.Number r53, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolType r54, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolStyleType r55, com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType r56, java.lang.Boolean r57, java.lang.Boolean r58, java.lang.Boolean r59, java.lang.Boolean r60, java.lang.String r61, java.lang.Boolean r62, java.lang.Boolean r63, java.lang.Number[] r64, java.lang.Boolean r65, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle r66, java.lang.Boolean r67, java.lang.Integer r68, java.lang.String[] r69, java.lang.Number r70, java.lang.Boolean r71, java.lang.Boolean r72, java.lang.Boolean r73, java.lang.String r74, java.lang.Number r75, java.lang.Number r76, java.lang.Number r77, java.lang.Boolean r78, java.lang.Number r79, java.lang.Object[] r80, java.lang.Boolean r81, java.lang.Object r82, java.lang.Number r83, java.lang.Object[] r84, java.lang.Boolean r85, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea r86, int r87, int r88, kotlin.jvm.internal.u r89) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel.<init>(com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType, java.lang.Integer, java.lang.String, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle, java.lang.String, com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle, java.lang.String, com.github.aachartmodel.aainfographics.aachartcreator.AAChartType, com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType, java.lang.Number, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolType, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolStyleType, com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Number[], java.lang.Boolean, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle, java.lang.Boolean, java.lang.Integer, java.lang.String[], java.lang.Number, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Number, java.lang.Number, java.lang.Number, java.lang.Boolean, java.lang.Number, java.lang.Object[], java.lang.Boolean, java.lang.Object, java.lang.Number, java.lang.Object[], java.lang.Boolean, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea, int, int, kotlin.jvm.internal.u):void");
    }
}
