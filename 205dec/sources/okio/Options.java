package okio;

import com.acse.ottn.f3;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.c;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Options.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u000b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0017B!\b\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002R\"\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lokio/Options;", "Lkotlin/collections/c;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", f3.f5657f, "", "byteStrings", "[Lokio/ByteString;", "getByteStrings$okio", "()[Lokio/ByteString;", "", "trie", "[I", "getTrie$okio", "()[I", "getSize", "()I", "size", "<init>", "([Lokio/ByteString;[I)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Options extends c<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ByteString[] byteStrings;
    @NotNull
    private final int[] trie;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Options.kt */
    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J#\u0010\u0012\u001a\u00020\u00112\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0010\"\u00020\tH\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lokio/Options$Companion;", "", "", "nodeOffset", "Lokio/Buffer;", "node", "", "byteStringOffset", "", "Lokio/ByteString;", "byteStrings", "fromIndex", "toIndex", "indexes", "Lkotlin/f1;", "buildTrieRecursive", "", "Lokio/Options;", "of", "([Lokio/ByteString;)Lokio/Options;", "getIntCount", "(Lokio/Buffer;)J", "intCount", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Companion {
        private Companion() {
        }

        private final void buildTrieRecursive(long j4, Buffer buffer, int i4, List<? extends ByteString> list, int i5, int i6, List<Integer> list2) {
            int i7;
            int i8;
            int i9;
            int i10;
            Buffer buffer2;
            int i11 = i4;
            if (i5 < i6) {
                for (int i12 = i5; i12 < i6; i12++) {
                    if (!(list.get(i12).size() >= i11)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = list.get(i5);
                ByteString byteString2 = list.get(i6 - 1);
                if (i11 == byteString.size()) {
                    int i13 = i5 + 1;
                    i7 = i13;
                    i8 = list2.get(i5).intValue();
                    byteString = list.get(i13);
                } else {
                    i7 = i5;
                    i8 = -1;
                }
                if (byteString.getByte(i11) != byteString2.getByte(i11)) {
                    int i14 = 1;
                    for (int i15 = i7 + 1; i15 < i6; i15++) {
                        if (list.get(i15 - 1).getByte(i11) != list.get(i15).getByte(i11)) {
                            i14++;
                        }
                    }
                    long intCount = j4 + getIntCount(buffer) + 2 + (i14 * 2);
                    buffer.writeInt(i14);
                    buffer.writeInt(i8);
                    for (int i16 = i7; i16 < i6; i16++) {
                        byte b4 = list.get(i16).getByte(i11);
                        if (i16 == i7 || b4 != list.get(i16 - 1).getByte(i11)) {
                            buffer.writeInt(b4 & 255);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    while (i7 < i6) {
                        byte b5 = list.get(i7).getByte(i11);
                        int i17 = i7 + 1;
                        int i18 = i17;
                        while (true) {
                            if (i18 >= i6) {
                                i9 = i6;
                                break;
                            } else if (b5 != list.get(i18).getByte(i11)) {
                                i9 = i18;
                                break;
                            } else {
                                i18++;
                            }
                        }
                        if (i17 == i9 && i11 + 1 == list.get(i7).size()) {
                            buffer.writeInt(list2.get(i7).intValue());
                            i10 = i9;
                            buffer2 = buffer3;
                        } else {
                            buffer.writeInt(((int) (intCount + getIntCount(buffer3))) * (-1));
                            i10 = i9;
                            buffer2 = buffer3;
                            buildTrieRecursive(intCount, buffer3, i11 + 1, list, i7, i9, list2);
                        }
                        buffer3 = buffer2;
                        i7 = i10;
                    }
                    buffer.writeAll(buffer3);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i19 = 0;
                for (int i20 = i11; i20 < min && byteString.getByte(i20) == byteString2.getByte(i20); i20++) {
                    i19++;
                }
                long intCount2 = j4 + getIntCount(buffer) + 2 + i19 + 1;
                buffer.writeInt(-i19);
                buffer.writeInt(i8);
                int i21 = i11 + i19;
                while (i11 < i21) {
                    buffer.writeInt(byteString.getByte(i11) & 255);
                    i11++;
                }
                if (i7 + 1 == i6) {
                    if (i21 == list.get(i7).size()) {
                        buffer.writeInt(list2.get(i7).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer4 = new Buffer();
                buffer.writeInt(((int) (getIntCount(buffer4) + intCount2)) * (-1));
                buildTrieRecursive(intCount2, buffer4, i21, list, i7, i6, list2);
                buffer.writeAll(buffer4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j4, Buffer buffer, int i4, List list, int i5, int i6, List list2, int i7, Object obj) {
            companion.buildTrieRecursive((i7 & 1) != 0 ? 0L : j4, buffer, (i7 & 4) != 0 ? 0 : i4, list, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) != 0 ? list.size() : i6, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x00ee, code lost:
            continue;
         */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options of(@org.jetbrains.annotations.NotNull okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 338
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, u uVar) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    @NotNull
    public static final Options of(@NotNull ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    @Override // kotlin.collections.a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @NotNull
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.byteStrings.length;
    }

    @NotNull
    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override // kotlin.collections.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Options) byteString);
    }

    @Override // kotlin.collections.c, java.util.List
    @NotNull
    public ByteString get(int i4) {
        return this.byteStrings[i4];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Options) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Options) byteString);
    }
}
