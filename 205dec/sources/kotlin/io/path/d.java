package kotlin.io.path;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import d2.l;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.sequences.m;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PathUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\r\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0000H\u0087\b\u001a\u0014\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007\u001a\u001f\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH\u0087\b\u001a0\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\rH\u0087\b\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a(\u0010\u0012\u001a\u00020\t*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0014\u001a\u00020\t*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\b\u0014\u0010\u0013\u001a(\u0010\u0015\u001a\u00020\t*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\b\u0015\u0010\u0013\u001a(\u0010\u0016\u001a\u00020\t*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\b\u0016\u0010\u0013\u001a\r\u0010\u0017\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u001d\u001a\u00020\t*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\b\u001a\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00000\u001f*\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u0002H\u0007\u001aA\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010!*\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000#\u0012\u0004\u0012\u00028\u00000\"H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u001a.\u0010)\u001a\u00020'*\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020'0\"H\u0087\b\u00f8\u0001\u0000\u001a\r\u0010+\u001a\u00020**\u00020\u0000H\u0087\b\u001a\r\u0010,\u001a\u00020'*\u00020\u0000H\u0087\b\u001a\r\u0010-\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a0\u00100\u001a\u00020\u0000*\u00020\u00002\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b\u00a2\u0006\u0004\b0\u00101\u001a0\u00102\u001a\u00020\u0000*\u00020\u00002\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b\u00a2\u0006\u0004\b2\u00101\u001a0\u00103\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\rH\u0087\b\u00a2\u0006\u0004\b3\u0010\u0010\u001a\u001f\u00104\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH\u0087\b\u001a\r\u00106\u001a\u000205*\u00020\u0000H\u0087\b\u001a2\u00109\u001a\u0004\u0018\u000108*\u00020\u00002\u0006\u00107\u001a\u00020\u00022\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\b9\u0010:\u001a:\u0010<\u001a\u00020\u0000*\u00020\u00002\u0006\u00107\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u0001082\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\b<\u0010=\u001a6\u0010@\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010?\u0018\u0001*\u00020>*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\b@\u0010A\u001a4\u0010B\u001a\u00028\u0000\"\n\b\u0000\u0010?\u0018\u0001*\u00020>*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\bB\u0010A\u001a\u001c\u0010G\u001a\u00020F2\u0006\u0010C\u001a\u00020\u00002\n\u0010E\u001a\u0006\u0012\u0002\b\u00030DH\u0001\u001a4\u0010J\u001a\u00028\u0000\"\n\b\u0000\u0010I\u0018\u0001*\u00020H*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\bJ\u0010K\u001a>\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001080L*\u00020\u00002\u0006\u0010/\u001a\u00020\u00022\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\bM\u0010N\u001a(\u0010P\u001a\u00020O*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\bP\u0010Q\u001a\u0015\u0010R\u001a\u00020\u0000*\u00020\u00002\u0006\u0010;\u001a\u00020OH\u0087\b\u001a*\u0010T\u001a\u0004\u0018\u00010S*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\bT\u0010U\u001a\u0015\u0010V\u001a\u00020\u0000*\u00020\u00002\u0006\u0010;\u001a\u00020SH\u0087\b\u001a.\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0W*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b\u00a2\u0006\u0004\bY\u0010Z\u001a\u001b\u0010[\u001a\u00020\u0000*\u00020\u00002\f\u0010;\u001a\b\u0012\u0004\u0012\u00020X0WH\u0087\b\u001a\u0015\u0010\\\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0087\b\u001a8\u0010]\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b\u00a2\u0006\u0004\b]\u0010^\u001a\r\u0010_\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a0\u0010`\u001a\u00020\u0000*\u00020\u00002\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b\u00a2\u0006\u0004\b`\u00101\u001aD\u0010c\u001a\u00020\u00002\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00022\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b\u00a2\u0006\u0004\bc\u0010d\u001aM\u0010f\u001a\u00020\u00002\b\u0010e\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00022\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0007\u00a2\u0006\u0004\bf\u0010g\u001a8\u0010!\u001a\u00020\u00002\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b\u00a2\u0006\u0004\b!\u0010h\u001aA\u0010i\u001a\u00020\u00002\b\u0010e\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0007\u00a2\u0006\u0004\bi\u0010j\u001a\u0015\u0010k\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010l\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0002H\u0087\n\u001a\u0011\u0010m\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0002H\u0087\b\u001a,\u0010o\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\f\"\u00020\u0002H\u0087\b\u00a2\u0006\u0004\bo\u0010p\u001a\r\u0010r\u001a\u00020\u0000*\u00020qH\u0087\b\"\u001e\u0010w\u001a\u00020\u0002*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bu\u0010v\u001a\u0004\bs\u0010t\"\u001e\u0010z\u001a\u00020\u0002*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\by\u0010v\u001a\u0004\bx\u0010t\"\u001e\u0010}\u001a\u00020\u0002*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b|\u0010v\u001a\u0004\b{\u0010t\" \u0010\u0080\u0001\u001a\u00020\u0002*\u00020\u00008\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u007f\u0010v\u001a\u0004\b~\u0010t\"!\u0010\u0083\u0001\u001a\u00020\u0002*\u00020\u00008FX\u0087\u0004\u00a2\u0006\u000e\u0012\u0005\b\u0082\u0001\u0010v\u001a\u0005\b\u0081\u0001\u0010t\"\"\u0010\u0086\u0001\u001a\u00020\u0002*\u00020\u00008\u00c6\u0002X\u0087\u0004\u00a2\u0006\u000e\u0012\u0005\b\u0085\u0001\u0010v\u001a\u0005\b\u0084\u0001\u0010t\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0087\u0001"}, d2 = {"Ljava/nio/file/Path;", "J", "", "K", "base", "U0", "W0", "V0", "target", "", "overwrite", "L", "", "Ljava/nio/file/CopyOption;", "options", "M", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "Ljava/nio/file/LinkOption;", "f0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "Q0", "H0", "D0", "J0", "E0", "F0", "G0", "K0", "other", "I0", "glob", "", "L0", "T", "Lkotlin/Function1;", "Lkotlin/sequences/m;", "block", "c1", "(Ljava/nio/file/Path;Ljava/lang/String;Ld2/l;)Ljava/lang/Object;", "Lkotlin/f1;", "action", "l0", "", "j0", "b0", "c0", "Ljava/nio/file/attribute/FileAttribute;", "attributes", "P", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "O", "O0", "N0", "Ljava/nio/file/FileStore;", "k0", "attribute", "", "n0", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "value", "X0", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "Ljava/nio/file/attribute/FileAttributeView;", "V", "i0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "h0", "path", "Ljava/lang/Class;", "attributeViewClass", "", "g0", "Ljava/nio/file/attribute/BasicFileAttributes;", "A", "R0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "S0", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "Ljava/nio/file/attribute/FileTime;", "u0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "Y0", "Ljava/nio/file/attribute/UserPrincipal;", "z0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "Z0", "", "Ljava/nio/file/attribute/PosixFilePermission;", "C0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "a1", "R", "S", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "T0", "Q", "prefix", "suffix", "X", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "directory", "Y", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "U", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "e0", "d0", "H", "subpaths", "I", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "Ljava/net/URI;", "b1", "v0", "(Ljava/nio/file/Path;)Ljava/lang/String;", "getName$annotations", "(Ljava/nio/file/Path;)V", "name", "x0", "getNameWithoutExtension$annotations", "nameWithoutExtension", "o0", "getExtension$annotations", "extension", "A0", "getPathString$annotations", "pathString", "s0", "getInvariantSeparatorsPathString$annotations", "invariantSeparatorsPathString", "q0", "getInvariantSeparatorsPath$annotations", "invariantSeparatorsPath", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 5, 1}, xs = "kotlin/io/path/PathsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class d extends c {
    private static final String A0(Path path) {
        return path.toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    public static /* synthetic */ void B0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Set<PosixFilePermission> C0(Path path, LinkOption... linkOptionArr) throws IOException {
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        f0.o(posixFilePermissions, "Files.getPosixFilePermissions(this, *options)");
        return posixFilePermissions;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean D0(Path path, LinkOption... linkOptionArr) {
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean E0(Path path) {
        return Files.isExecutable(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean F0(Path path) throws IOException {
        return Files.isHidden(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean G0(Path path) {
        return Files.isReadable(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path H(String str) {
        Path path = Paths.get(str, new String[0]);
        f0.o(path, "Paths.get(path)");
        return path;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean H0(Path path, LinkOption... linkOptionArr) {
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path I(String str, String... strArr) {
        Path path = Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        f0.o(path, "Paths.get(base, *subpaths)");
        return path;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean I0(Path path, Path path2) throws IOException {
        return Files.isSameFile(path, path2);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path J(Path path) {
        Path absolutePath = path.toAbsolutePath();
        f0.o(absolutePath, "toAbsolutePath()");
        return absolutePath;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean J0(Path path) {
        return Files.isSymbolicLink(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final String K(Path path) {
        return path.toAbsolutePath().toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean K0(Path path) {
        return Files.isWritable(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path L(Path path, Path path2, boolean z3) throws IOException {
        CopyOption[] copyOptionArr = z3 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(copy, "Files.copy(this, target, *options)");
        return copy;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final List<Path> L0(@NotNull Path listDirectoryEntries, @NotNull String glob) throws IOException {
        List<Path> G5;
        f0.p(listDirectoryEntries, "$this$listDirectoryEntries");
        f0.p(glob, "glob");
        DirectoryStream<Path> it = Files.newDirectoryStream(listDirectoryEntries, glob);
        try {
            f0.o(it, "it");
            G5 = kotlin.collections.f0.G5(it);
            kotlin.io.b.a(it, null);
            return G5;
        } finally {
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path M(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(copy, "Files.copy(this, target, *options)");
        return copy;
    }

    public static /* synthetic */ List M0(Path path, String str, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            str = "*";
        }
        return L0(path, str);
    }

    static /* synthetic */ Path N(Path path, Path path2, boolean z3, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        CopyOption[] copyOptionArr = z3 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(copy, "Files.copy(this, target, *options)");
        return copy;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path N0(Path path, Path path2, boolean z3) throws IOException {
        CopyOption[] copyOptionArr = z3 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(move, "Files.move(this, target, *options)");
        return move;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path O(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        f0.o(createDirectories, "Files.createDirectories(this, *attributes)");
        return createDirectories;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path O0(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(move, "Files.move(this, target, *options)");
        return move;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path P(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        f0.o(createDirectory, "Files.createDirectory(this, *attributes)");
        return createDirectory;
    }

    static /* synthetic */ Path P0(Path path, Path path2, boolean z3, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        CopyOption[] copyOptionArr = z3 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(move, "Files.move(this, target, *options)");
        return move;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path Q(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        f0.o(createFile, "Files.createFile(this, *attributes)");
        return createFile;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean Q0(Path path, LinkOption... linkOptionArr) {
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path R(Path path, Path path2) throws IOException {
        Path createLink = Files.createLink(path, path2);
        f0.o(createLink, "Files.createLink(this, target)");
        return createLink;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final /* synthetic */ <A extends BasicFileAttributes> A R0(Path path, LinkOption... linkOptionArr) throws IOException {
        f0.y(4, "A");
        A a4 = (A) Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        f0.o(a4, "Files.readAttributes(thi\u2026 A::class.java, *options)");
        return a4;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path S(Path path, Path path2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createSymbolicLink = Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        f0.o(createSymbolicLink, "Files.createSymbolicLink\u2026his, target, *attributes)");
        return createSymbolicLink;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Map<String, Object> S0(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Map<String, Object> readAttributes = Files.readAttributes(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        f0.o(readAttributes, "Files.readAttributes(this, attributes, *options)");
        return readAttributes;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path T(String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        f0.o(createTempDirectory, "Files.createTempDirectory(prefix, *attributes)");
        return createTempDirectory;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path T0(Path path) throws IOException {
        Path readSymbolicLink = Files.readSymbolicLink(path);
        f0.o(readSymbolicLink, "Files.readSymbolicLink(this)");
        return readSymbolicLink;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path U(@Nullable Path path, @Nullable String str, @NotNull FileAttribute<?>... attributes) throws IOException {
        f0.p(attributes, "attributes");
        if (path != null) {
            Path createTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            f0.o(createTempDirectory, "Files.createTempDirector\u2026ory, prefix, *attributes)");
            return createTempDirectory;
        }
        Path createTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(createTempDirectory2, "Files.createTempDirectory(prefix, *attributes)");
        return createTempDirectory2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final Path U0(@NotNull Path relativeTo, @NotNull Path base) {
        f0.p(relativeTo, "$this$relativeTo");
        f0.p(base, "base");
        try {
            return a.f55597c.a(relativeTo, base);
        } catch (IllegalArgumentException e4) {
            String message = e4.getMessage();
            throw new IllegalArgumentException(f0.C(message, "\nthis path: " + relativeTo + "\nbase path: " + base), e4);
        }
    }

    static /* synthetic */ Path V(String str, FileAttribute[] fileAttributeArr, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            str = null;
        }
        Path createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        f0.o(createTempDirectory, "Files.createTempDirectory(prefix, *attributes)");
        return createTempDirectory;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @Nullable
    public static final Path V0(@NotNull Path relativeToOrNull, @NotNull Path base) {
        f0.p(relativeToOrNull, "$this$relativeToOrNull");
        f0.p(base, "base");
        try {
            return a.f55597c.a(relativeToOrNull, base);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static /* synthetic */ Path W(Path path, String str, FileAttribute[] fileAttributeArr, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            str = null;
        }
        return U(path, str, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final Path W0(@NotNull Path relativeToOrSelf, @NotNull Path base) {
        f0.p(relativeToOrSelf, "$this$relativeToOrSelf");
        f0.p(base, "base");
        Path V0 = V0(relativeToOrSelf, base);
        return V0 != null ? V0 : relativeToOrSelf;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path X(String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        f0.o(createTempFile, "Files.createTempFile(prefix, suffix, *attributes)");
        return createTempFile;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path X0(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException {
        Path attribute = Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        f0.o(attribute, "Files.setAttribute(this,\u2026tribute, value, *options)");
        return attribute;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path Y(@Nullable Path path, @Nullable String str, @Nullable String str2, @NotNull FileAttribute<?>... attributes) throws IOException {
        f0.p(attributes, "attributes");
        if (path != null) {
            Path createTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            f0.o(createTempFile, "Files.createTempFile(dir\u2026fix, suffix, *attributes)");
            return createTempFile;
        }
        Path createTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(createTempFile2, "Files.createTempFile(prefix, suffix, *attributes)");
        return createTempFile2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path Y0(Path path, FileTime fileTime) throws IOException {
        Path lastModifiedTime = Files.setLastModifiedTime(path, fileTime);
        f0.o(lastModifiedTime, "Files.setLastModifiedTime(this, value)");
        return lastModifiedTime;
    }

    static /* synthetic */ Path Z(String str, String str2, FileAttribute[] fileAttributeArr, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            str = null;
        }
        if ((i4 & 2) != 0) {
            str2 = null;
        }
        Path createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        f0.o(createTempFile, "Files.createTempFile(prefix, suffix, *attributes)");
        return createTempFile;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path Z0(Path path, UserPrincipal userPrincipal) throws IOException {
        Path owner = Files.setOwner(path, userPrincipal);
        f0.o(owner, "Files.setOwner(this, value)");
        return owner;
    }

    public static /* synthetic */ Path a0(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            str = null;
        }
        if ((i4 & 4) != 0) {
            str2 = null;
        }
        return Y(path, str, str2, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path a1(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        Path posixFilePermissions = Files.setPosixFilePermissions(path, set);
        f0.o(posixFilePermissions, "Files.setPosixFilePermissions(this, value)");
        return posixFilePermissions;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void b0(Path path) throws IOException {
        Files.delete(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path b1(URI uri) {
        Path path = Paths.get(uri);
        f0.o(path, "Paths.get(this)");
        return path;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean c0(Path path) throws IOException {
        return Files.deleteIfExists(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final <T> T c1(Path path, String str, l<? super m<? extends Path>, ? extends T> lVar) throws IOException {
        m l12;
        DirectoryStream<Path> it = Files.newDirectoryStream(path, str);
        try {
            f0.o(it, "it");
            l12 = kotlin.collections.f0.l1(it);
            T invoke = lVar.invoke(l12);
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                kotlin.io.b.a(it, null);
            } else if (it != null) {
                it.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    kotlin.io.b.a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path d0(Path div, String str) {
        f0.p(div, "$this$div");
        Path resolve = div.resolve(str);
        f0.o(resolve, "this.resolve(other)");
        return resolve;
    }

    static /* synthetic */ Object d1(Path path, String str, l lVar, int i4, Object obj) throws IOException {
        m l12;
        if ((i4 & 1) != 0) {
            str = "*";
        }
        DirectoryStream<Path> it = Files.newDirectoryStream(path, str);
        try {
            f0.o(it, "it");
            l12 = kotlin.collections.f0.l1(it);
            Object invoke = lVar.invoke(l12);
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                kotlin.io.b.a(it, null);
            } else if (it != null) {
                it.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    kotlin.io.b.a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path e0(Path div, Path path) {
        f0.p(div, "$this$div");
        Path resolve = div.resolve(path);
        f0.o(resolve, "this.resolve(other)");
        return resolve;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean f0(Path path, LinkOption... linkOptionArr) {
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @PublishedApi
    @NotNull
    public static final Void g0(@NotNull Path path, @NotNull Class<?> attributeViewClass) {
        f0.p(path, "path");
        f0.p(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V h0(Path path, LinkOption... linkOptionArr) {
        f0.y(4, "V");
        V v3 = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (v3 != null) {
            return v3;
        }
        f0.y(4, "V");
        g0(path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V i0(Path path, LinkOption... linkOptionArr) {
        f0.y(4, "V");
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final long j0(Path path) throws IOException {
        return Files.size(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final FileStore k0(Path path) throws IOException {
        FileStore fileStore = Files.getFileStore(path);
        f0.o(fileStore, "Files.getFileStore(this)");
        return fileStore;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void l0(Path path, String str, l<? super Path, f1> lVar) throws IOException {
        DirectoryStream<Path> it = Files.newDirectoryStream(path, str);
        try {
            f0.o(it, "it");
            for (Path path2 : it) {
                lVar.invoke(path2);
            }
            f1 f1Var = f1.f55527a;
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                kotlin.io.b.a(it, null);
            } else if (it != null) {
                it.close();
            }
            c0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    kotlin.io.b.a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    static /* synthetic */ void m0(Path path, String str, l lVar, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            str = "*";
        }
        DirectoryStream<Path> it = Files.newDirectoryStream(path, str);
        try {
            f0.o(it, "it");
            for (Path path2 : it) {
                lVar.invoke(path2);
            }
            f1 f1Var = f1.f55527a;
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                kotlin.io.b.a(it, null);
            } else if (it != null) {
                it.close();
            }
            c0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    kotlin.io.b.a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Object n0(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        return Files.getAttribute(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
        r2 = kotlin.text.x.q5(r2, '.', "");
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String o0(@org.jetbrains.annotations.NotNull java.nio.file.Path r2) {
        /*
            java.lang.String r0 = "$this$extension"
            kotlin.jvm.internal.f0.p(r2, r0)
            java.nio.file.Path r2 = r2.getFileName()
            java.lang.String r0 = ""
            if (r2 == 0) goto L1c
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L1c
            r1 = 46
            java.lang.String r2 = kotlin.text.n.q5(r2, r1, r0)
            if (r2 == 0) goto L1c
            r0 = r2
        L1c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.d.o0(java.nio.file.Path):java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void p0(Path path) {
    }

    private static final String q0(Path path) {
        return s0(path);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @ExperimentalPathApi
    public static /* synthetic */ void r0(Path path) {
    }

    @NotNull
    public static final String s0(@NotNull Path invariantSeparatorsPathString) {
        String k22;
        f0.p(invariantSeparatorsPathString, "$this$invariantSeparatorsPathString");
        FileSystem fileSystem = invariantSeparatorsPathString.getFileSystem();
        f0.o(fileSystem, "fileSystem");
        String separator = fileSystem.getSeparator();
        if (!f0.g(separator, TTPathConst.sSeparator)) {
            String obj = invariantSeparatorsPathString.toString();
            f0.o(separator, "separator");
            k22 = w.k2(obj, separator, TTPathConst.sSeparator, false, 4, null);
            return k22;
        }
        return invariantSeparatorsPathString.toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void t0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final FileTime u0(Path path, LinkOption... linkOptionArr) throws IOException {
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        f0.o(lastModifiedTime, "Files.getLastModifiedTime(this, *options)");
        return lastModifiedTime;
    }

    @NotNull
    public static final String v0(@NotNull Path name) {
        f0.p(name, "$this$name");
        Path fileName = name.getFileName();
        String obj = fileName != null ? fileName.toString() : null;
        return obj != null ? obj : "";
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void w0(Path path) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
        r3 = kotlin.text.x.B5(r3, ".", null, 2, null);
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String x0(@org.jetbrains.annotations.NotNull java.nio.file.Path r3) {
        /*
            java.lang.String r0 = "$this$nameWithoutExtension"
            kotlin.jvm.internal.f0.p(r3, r0)
            java.nio.file.Path r3 = r3.getFileName()
            if (r3 == 0) goto L1c
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L1c
            r0 = 2
            java.lang.String r1 = "."
            r2 = 0
            java.lang.String r3 = kotlin.text.n.B5(r3, r1, r2, r0, r2)
            if (r3 == 0) goto L1c
            goto L1e
        L1c:
            java.lang.String r3 = ""
        L1e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.d.x0(java.nio.file.Path):java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void y0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final UserPrincipal z0(Path path, LinkOption... linkOptionArr) throws IOException {
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }
}
