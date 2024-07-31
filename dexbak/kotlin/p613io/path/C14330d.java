package kotlin.p613io.path;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.ccg.CcgConstant;
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
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections._Collections;
import kotlin.internal.C14307b;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.p613io.Closeable;
import kotlin.sequences.Sequence;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: PathUtils.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\r\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0000H\u0087\b\u001a\u0014\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007\u001a\u001f\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH\u0087\b\u001a0\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\rH\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a(\u0010\u0012\u001a\u00020\t*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0014\u001a\u00020\t*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0013\u001a(\u0010\u0015\u001a\u00020\t*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\b\u0015\u0010\u0013\u001a(\u0010\u0016\u001a\u00020\t*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0013\u001a\r\u0010\u0017\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u001d\u001a\u00020\t*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\b\u001a\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00000\u001f*\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u0002H\u0007\u001aA\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010!*\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000#\u0012\u0004\u0012\u00028\u00000\"H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a.\u0010)\u001a\u00020'*\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020'0\"H\u0087\bø\u0001\u0000\u001a\r\u0010+\u001a\u00020**\u00020\u0000H\u0087\b\u001a\r\u0010,\u001a\u00020'*\u00020\u0000H\u0087\b\u001a\r\u0010-\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a0\u00100\u001a\u00020\u0000*\u00020\u00002\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b¢\u0006\u0004\b0\u00101\u001a0\u00102\u001a\u00020\u0000*\u00020\u00002\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b¢\u0006\u0004\b2\u00101\u001a0\u00103\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\rH\u0087\b¢\u0006\u0004\b3\u0010\u0010\u001a\u001f\u00104\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH\u0087\b\u001a\r\u00106\u001a\u000205*\u00020\u0000H\u0087\b\u001a2\u00109\u001a\u0004\u0018\u000108*\u00020\u00002\u0006\u00107\u001a\u00020\u00022\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\b9\u0010:\u001a:\u0010<\u001a\u00020\u0000*\u00020\u00002\u0006\u00107\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u0001082\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\b<\u0010=\u001a6\u0010@\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010?\u0018\u0001*\u00020>*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\b@\u0010A\u001a4\u0010B\u001a\u00028\u0000\"\n\b\u0000\u0010?\u0018\u0001*\u00020>*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\bB\u0010A\u001a\u001c\u0010G\u001a\u00020F2\u0006\u0010C\u001a\u00020\u00002\n\u0010E\u001a\u0006\u0012\u0002\b\u00030DH\u0001\u001a4\u0010J\u001a\u00028\u0000\"\n\b\u0000\u0010I\u0018\u0001*\u00020H*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\bJ\u0010K\u001a>\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001080L*\u00020\u00002\u0006\u0010/\u001a\u00020\u00022\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\bM\u0010N\u001a(\u0010P\u001a\u00020O*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\bP\u0010Q\u001a\u0015\u0010R\u001a\u00020\u0000*\u00020\u00002\u0006\u0010;\u001a\u00020OH\u0087\b\u001a*\u0010T\u001a\u0004\u0018\u00010S*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\bT\u0010U\u001a\u0015\u0010V\u001a\u00020\u0000*\u00020\u00002\u0006\u0010;\u001a\u00020SH\u0087\b\u001a.\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0W*\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\f\"\u00020\u0011H\u0087\b¢\u0006\u0004\bY\u0010Z\u001a\u001b\u0010[\u001a\u00020\u0000*\u00020\u00002\f\u0010;\u001a\b\u0012\u0004\u0012\u00020X0WH\u0087\b\u001a\u0015\u0010\\\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0087\b\u001a8\u0010]\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b¢\u0006\u0004\b]\u0010^\u001a\r\u0010_\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a0\u0010`\u001a\u00020\u0000*\u00020\u00002\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b¢\u0006\u0004\b`\u00101\u001aD\u0010c\u001a\u00020\u00002\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00022\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b¢\u0006\u0004\bc\u0010d\u001aM\u0010f\u001a\u00020\u00002\b\u0010e\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00022\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0007¢\u0006\u0004\bf\u0010g\u001a8\u0010!\u001a\u00020\u00002\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0087\b¢\u0006\u0004\b!\u0010h\u001aA\u0010i\u001a\u00020\u00002\b\u0010e\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030.0\f\"\u0006\u0012\u0002\b\u00030.H\u0007¢\u0006\u0004\bi\u0010j\u001a\u0015\u0010k\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010l\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0002H\u0087\n\u001a\u0011\u0010m\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0002H\u0087\b\u001a,\u0010o\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\f\"\u00020\u0002H\u0087\b¢\u0006\u0004\bo\u0010p\u001a\r\u0010r\u001a\u00020\u0000*\u00020qH\u0087\b\"\u001e\u0010w\u001a\u00020\u0002*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\bu\u0010v\u001a\u0004\bs\u0010t\"\u001e\u0010z\u001a\u00020\u0002*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\by\u0010v\u001a\u0004\bx\u0010t\"\u001e\u0010}\u001a\u00020\u0002*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b|\u0010v\u001a\u0004\b{\u0010t\" \u0010\u0080\u0001\u001a\u00020\u0002*\u00020\u00008Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u007f\u0010v\u001a\u0004\b~\u0010t\"!\u0010\u0083\u0001\u001a\u00020\u0002*\u00020\u00008FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0082\u0001\u0010v\u001a\u0005\b\u0081\u0001\u0010t\"\"\u0010\u0086\u0001\u001a\u00020\u0002*\u00020\u00008Æ\u0002X\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0085\u0001\u0010v\u001a\u0005\b\u0084\u0001\u0010t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0087\u0001"}, m12616d2 = {"Ljava/nio/file/Path;", "J", "", "K", "base", "U0", "W0", "V0", "target", "", "overwrite", "L", "", "Ljava/nio/file/CopyOption;", "options", "M", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "Ljava/nio/file/LinkOption;", "f0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "Q0", "H0", "D0", "J0", "E0", "F0", "G0", "K0", AdnName.OTHER, "I0", "glob", "", "L0", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/sequences/m;", "block", "c1", "(Ljava/nio/file/Path;Ljava/lang/String;Ll1/l;)Ljava/lang/Object;", "Lkotlin/f1;", CcgConstant.f38549t, "l0", "", "j0", "b0", "c0", "Ljava/nio/file/attribute/FileAttribute;", "attributes", "P", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "O", "O0", "N0", "Ljava/nio/file/FileStore;", "k0", "attribute", "", "n0", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "X0", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "Ljava/nio/file/attribute/FileAttributeView;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "i0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "h0", "path", "Ljava/lang/Class;", "attributeViewClass", "", "g0", "Ljava/nio/file/attribute/BasicFileAttributes;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "R0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "S0", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "Ljava/nio/file/attribute/FileTime;", "u0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "Y0", "Ljava/nio/file/attribute/UserPrincipal;", "z0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "Z0", "", "Ljava/nio/file/attribute/PosixFilePermission;", "C0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "a1", "R", ExifInterface.LATITUDE_SOUTH, "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "T0", "Q", "prefix", "suffix", "X", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "directory", "Y", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "U", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "e0", "d0", "H", "subpaths", "I", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "Ljava/net/URI;", "b1", "v0", "(Ljava/nio/file/Path;)Ljava/lang/String;", "getName$annotations", "(Ljava/nio/file/Path;)V", "name", "x0", "getNameWithoutExtension$annotations", "nameWithoutExtension", "o0", "getExtension$annotations", "extension", "A0", "getPathString$annotations", "pathString", "s0", "getInvariantSeparatorsPathString$annotations", "invariantSeparatorsPathString", "q0", "getInvariantSeparatorsPath$annotations", "invariantSeparatorsPath", "kotlin-stdlib-jdk7"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/io/path/PathsKt")
/* renamed from: kotlin.io.path.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class C14330d extends PathReadWrite {
    /* renamed from: A0 */
    private static final String m8328A0(Path path) {
        return path.toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: B0 */
    public static /* synthetic */ void m8327B0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: C0 */
    private static final Set<PosixFilePermission> m8326C0(Path path, LinkOption... linkOptionArr) throws IOException {
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        C14342f0.m8185o(posixFilePermissions, "Files.getPosixFilePermissions(this, *options)");
        return posixFilePermissions;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: D0 */
    private static final boolean m8325D0(Path path, LinkOption... linkOptionArr) {
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: E0 */
    private static final boolean m8324E0(Path path) {
        return Files.isExecutable(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: F0 */
    private static final boolean m8323F0(Path path) throws IOException {
        return Files.isHidden(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: G0 */
    private static final boolean m8322G0(Path path) {
        return Files.isReadable(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: H */
    private static final Path m8321H(String str) {
        Path path = Paths.get(str, new String[0]);
        C14342f0.m8185o(path, "Paths.get(path)");
        return path;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: H0 */
    private static final boolean m8320H0(Path path, LinkOption... linkOptionArr) {
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: I */
    private static final Path m8319I(String str, String... strArr) {
        Path path = Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        C14342f0.m8185o(path, "Paths.get(base, *subpaths)");
        return path;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: I0 */
    private static final boolean m8318I0(Path path, Path path2) throws IOException {
        return Files.isSameFile(path, path2);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: J */
    private static final Path m8317J(Path path) {
        Path absolutePath = path.toAbsolutePath();
        C14342f0.m8185o(absolutePath, "toAbsolutePath()");
        return absolutePath;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: J0 */
    private static final boolean m8316J0(Path path) {
        return Files.isSymbolicLink(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: K */
    private static final String m8315K(Path path) {
        return path.toAbsolutePath().toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: K0 */
    private static final boolean m8314K0(Path path) {
        return Files.isWritable(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: L */
    private static final Path m8313L(Path path, Path path2, boolean z) throws IOException {
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        C14342f0.m8185o(copy, "Files.copy(this, target, *options)");
        return copy;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: L0 */
    public static final List<Path> m8312L0(@NotNull Path listDirectoryEntries, @NotNull String glob) throws IOException {
        List<Path> m12233I5;
        C14342f0.m8184p(listDirectoryEntries, "$this$listDirectoryEntries");
        C14342f0.m8184p(glob, "glob");
        DirectoryStream<Path> it = Files.newDirectoryStream(listDirectoryEntries, glob);
        try {
            C14342f0.m8185o(it, "it");
            m12233I5 = _Collections.m12233I5(it);
            Closeable.m8492a(it, null);
            return m12233I5;
        } finally {
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: M */
    private static final Path m8311M(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        C14342f0.m8185o(copy, "Files.copy(this, target, *options)");
        return copy;
    }

    /* renamed from: M0 */
    public static /* synthetic */ List m8310M0(Path path, String str, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = "*";
        }
        return m8312L0(path, str);
    }

    /* renamed from: N */
    static /* synthetic */ Path m8309N(Path path, Path path2, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        C14342f0.m8185o(copy, "Files.copy(this, target, *options)");
        return copy;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: N0 */
    private static final Path m8308N0(Path path, Path path2, boolean z) throws IOException {
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        C14342f0.m8185o(move, "Files.move(this, target, *options)");
        return move;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: O */
    private static final Path m8307O(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        C14342f0.m8185o(createDirectories, "Files.createDirectories(this, *attributes)");
        return createDirectories;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: O0 */
    private static final Path m8306O0(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        C14342f0.m8185o(move, "Files.move(this, target, *options)");
        return move;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: P */
    private static final Path m8305P(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        C14342f0.m8185o(createDirectory, "Files.createDirectory(this, *attributes)");
        return createDirectory;
    }

    /* renamed from: P0 */
    static /* synthetic */ Path m8304P0(Path path, Path path2, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        C14342f0.m8185o(move, "Files.move(this, target, *options)");
        return move;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: Q */
    private static final Path m8303Q(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        C14342f0.m8185o(createFile, "Files.createFile(this, *attributes)");
        return createFile;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: Q0 */
    private static final boolean m8302Q0(Path path, LinkOption... linkOptionArr) {
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: R */
    private static final Path m8301R(Path path, Path path2) throws IOException {
        Path createLink = Files.createLink(path, path2);
        C14342f0.m8185o(createLink, "Files.createLink(this, target)");
        return createLink;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: R0 */
    private static final /* synthetic */ <A extends BasicFileAttributes> A m8300R0(Path path, LinkOption... linkOptionArr) throws IOException {
        C14342f0.m8175y(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        A a = (A) Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        C14342f0.m8185o(a, "Files.readAttributes(thi… A::class.java, *options)");
        return a;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: S */
    private static final Path m8299S(Path path, Path path2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createSymbolicLink = Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        C14342f0.m8185o(createSymbolicLink, "Files.createSymbolicLink…his, target, *attributes)");
        return createSymbolicLink;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: S0 */
    private static final Map<String, Object> m8298S0(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Map<String, Object> readAttributes = Files.readAttributes(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        C14342f0.m8185o(readAttributes, "Files.readAttributes(this, attributes, *options)");
        return readAttributes;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: T */
    private static final Path m8297T(String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        C14342f0.m8185o(createTempDirectory, "Files.createTempDirectory(prefix, *attributes)");
        return createTempDirectory;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: T0 */
    private static final Path m8296T0(Path path) throws IOException {
        Path readSymbolicLink = Files.readSymbolicLink(path);
        C14342f0.m8185o(readSymbolicLink, "Files.readSymbolicLink(this)");
        return readSymbolicLink;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: U */
    public static final Path m8295U(@Nullable Path path, @Nullable String str, @NotNull FileAttribute<?>... attributes) throws IOException {
        C14342f0.m8184p(attributes, "attributes");
        if (path != null) {
            Path createTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            C14342f0.m8185o(createTempDirectory, "Files.createTempDirector…ory, prefix, *attributes)");
            return createTempDirectory;
        }
        Path createTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        C14342f0.m8185o(createTempDirectory2, "Files.createTempDirectory(prefix, *attributes)");
        return createTempDirectory2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    /* renamed from: U0 */
    public static final Path m8294U0(@NotNull Path relativeTo, @NotNull Path base) {
        C14342f0.m8184p(relativeTo, "$this$relativeTo");
        C14342f0.m8184p(base, "base");
        try {
            return PathUtils.f41107c.m8362a(relativeTo, base);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            throw new IllegalArgumentException(C14342f0.m8216C(message, "\nthis path: " + relativeTo + "\nbase path: " + base), e);
        }
    }

    /* renamed from: V */
    static /* synthetic */ Path m8293V(String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        Path createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        C14342f0.m8185o(createTempDirectory, "Files.createTempDirectory(prefix, *attributes)");
        return createTempDirectory;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @Nullable
    /* renamed from: V0 */
    public static final Path m8292V0(@NotNull Path relativeToOrNull, @NotNull Path base) {
        C14342f0.m8184p(relativeToOrNull, "$this$relativeToOrNull");
        C14342f0.m8184p(base, "base");
        try {
            return PathUtils.f41107c.m8362a(relativeToOrNull, base);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: W */
    public static /* synthetic */ Path m8291W(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        return m8295U(path, str, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    /* renamed from: W0 */
    public static final Path m8290W0(@NotNull Path relativeToOrSelf, @NotNull Path base) {
        C14342f0.m8184p(relativeToOrSelf, "$this$relativeToOrSelf");
        C14342f0.m8184p(base, "base");
        Path m8292V0 = m8292V0(relativeToOrSelf, base);
        return m8292V0 != null ? m8292V0 : relativeToOrSelf;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: X */
    private static final Path m8289X(String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        C14342f0.m8185o(createTempFile, "Files.createTempFile(prefix, suffix, *attributes)");
        return createTempFile;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: X0 */
    private static final Path m8288X0(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException {
        Path attribute = Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        C14342f0.m8185o(attribute, "Files.setAttribute(this,…tribute, value, *options)");
        return attribute;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: Y */
    public static final Path m8287Y(@Nullable Path path, @Nullable String str, @Nullable String str2, @NotNull FileAttribute<?>... attributes) throws IOException {
        C14342f0.m8184p(attributes, "attributes");
        if (path != null) {
            Path createTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            C14342f0.m8185o(createTempFile, "Files.createTempFile(dir…fix, suffix, *attributes)");
            return createTempFile;
        }
        Path createTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        C14342f0.m8185o(createTempFile2, "Files.createTempFile(prefix, suffix, *attributes)");
        return createTempFile2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: Y0 */
    private static final Path m8286Y0(Path path, FileTime fileTime) throws IOException {
        Path lastModifiedTime = Files.setLastModifiedTime(path, fileTime);
        C14342f0.m8185o(lastModifiedTime, "Files.setLastModifiedTime(this, value)");
        return lastModifiedTime;
    }

    /* renamed from: Z */
    static /* synthetic */ Path m8285Z(String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        Path createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        C14342f0.m8185o(createTempFile, "Files.createTempFile(prefix, suffix, *attributes)");
        return createTempFile;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: Z0 */
    private static final Path m8284Z0(Path path, UserPrincipal userPrincipal) throws IOException {
        Path owner = Files.setOwner(path, userPrincipal);
        C14342f0.m8185o(owner, "Files.setOwner(this, value)");
        return owner;
    }

    /* renamed from: a0 */
    public static /* synthetic */ Path m8283a0(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return m8287Y(path, str, str2, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: a1 */
    private static final Path m8282a1(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        Path posixFilePermissions = Files.setPosixFilePermissions(path, set);
        C14342f0.m8185o(posixFilePermissions, "Files.setPosixFilePermissions(this, value)");
        return posixFilePermissions;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: b0 */
    private static final void m8281b0(Path path) throws IOException {
        Files.delete(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: b1 */
    private static final Path m8280b1(URI uri) {
        Path path = Paths.get(uri);
        C14342f0.m8185o(path, "Paths.get(this)");
        return path;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: c0 */
    private static final boolean m8279c0(Path path) throws IOException {
        return Files.deleteIfExists(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: c1 */
    private static final <T> T m8278c1(Path path, String str, InterfaceC15280l<? super Sequence<? extends Path>, ? extends T> interfaceC15280l) throws IOException {
        Sequence m12090n1;
        DirectoryStream<Path> it = Files.newDirectoryStream(path, str);
        try {
            C14342f0.m8185o(it, "it");
            m12090n1 = _Collections.m12090n1(it);
            T invoke = interfaceC15280l.invoke(m12090n1);
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(it, null);
            } else if (it != null) {
                it.close();
            }
            InlineMarker.m8229c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: d0 */
    private static final Path m8277d0(Path div, String str) {
        C14342f0.m8184p(div, "$this$div");
        Path resolve = div.resolve(str);
        C14342f0.m8185o(resolve, "this.resolve(other)");
        return resolve;
    }

    /* renamed from: d1 */
    static /* synthetic */ Object m8276d1(Path path, String str, InterfaceC15280l interfaceC15280l, int i, Object obj) throws IOException {
        Sequence m12090n1;
        if ((i & 1) != 0) {
            str = "*";
        }
        DirectoryStream<Path> it = Files.newDirectoryStream(path, str);
        try {
            C14342f0.m8185o(it, "it");
            m12090n1 = _Collections.m12090n1(it);
            Object invoke = interfaceC15280l.invoke(m12090n1);
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(it, null);
            } else if (it != null) {
                it.close();
            }
            InlineMarker.m8229c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: e0 */
    private static final Path m8275e0(Path div, Path path) {
        C14342f0.m8184p(div, "$this$div");
        Path resolve = div.resolve(path);
        C14342f0.m8185o(resolve, "this.resolve(other)");
        return resolve;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: f0 */
    private static final boolean m8274f0(Path path, LinkOption... linkOptionArr) {
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @PublishedApi
    @NotNull
    /* renamed from: g0 */
    public static final Void m8273g0(@NotNull Path path, @NotNull Class<?> attributeViewClass) {
        C14342f0.m8184p(path, "path");
        C14342f0.m8184p(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: h0 */
    private static final /* synthetic */ <V extends FileAttributeView> V m8272h0(Path path, LinkOption... linkOptionArr) {
        C14342f0.m8175y(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        V v = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (v != null) {
            return v;
        }
        C14342f0.m8175y(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        m8273g0(path, FileAttributeView.class);
        throw new ExceptionsH();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: i0 */
    private static final /* synthetic */ <V extends FileAttributeView> V m8271i0(Path path, LinkOption... linkOptionArr) {
        C14342f0.m8175y(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: j0 */
    private static final long m8270j0(Path path) throws IOException {
        return Files.size(path);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: k0 */
    private static final FileStore m8269k0(Path path) throws IOException {
        FileStore fileStore = Files.getFileStore(path);
        C14342f0.m8185o(fileStore, "Files.getFileStore(this)");
        return fileStore;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: l0 */
    private static final void m8268l0(Path path, String str, InterfaceC15280l<? super Path, Unit> interfaceC15280l) throws IOException {
        DirectoryStream<Path> it = Files.newDirectoryStream(path, str);
        try {
            C14342f0.m8185o(it, "it");
            for (Path path2 : it) {
                interfaceC15280l.invoke(path2);
            }
            Unit unit = Unit.f41048a;
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(it, null);
            } else if (it != null) {
                it.close();
            }
            InlineMarker.m8229c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }

    /* renamed from: m0 */
    static /* synthetic */ void m8267m0(Path path, String str, InterfaceC15280l interfaceC15280l, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = "*";
        }
        DirectoryStream<Path> it = Files.newDirectoryStream(path, str);
        try {
            C14342f0.m8185o(it, "it");
            for (Path path2 : it) {
                interfaceC15280l.invoke(path2);
            }
            Unit unit = Unit.f41048a;
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(it, null);
            } else if (it != null) {
                it.close();
            }
            InlineMarker.m8229c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: n0 */
    private static final Object m8266n0(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        return Files.getAttribute(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
        r2 = kotlin.text.C14579x.m6399q5(r2, '.', "");
     */
    @org.jetbrains.annotations.NotNull
    /* renamed from: o0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String m8265o0(@org.jetbrains.annotations.NotNull java.nio.file.Path r2) {
        /*
            java.lang.String r0 = "$this$extension"
            kotlin.jvm.internal.C14342f0.m8184p(r2, r0)
            java.nio.file.Path r2 = r2.getFileName()
            java.lang.String r0 = ""
            if (r2 == 0) goto L1c
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L1c
            r1 = 46
            java.lang.String r2 = kotlin.text.C14573n.m6747q5(r2, r1, r0)
            if (r2 == 0) goto L1c
            r0 = r2
        L1c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p613io.path.C14330d.m8265o0(java.nio.file.Path):java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: p0 */
    public static /* synthetic */ void m8264p0(Path path) {
    }

    /* renamed from: q0 */
    private static final String m8263q0(Path path) {
        return m8261s0(path);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @Annotations(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @ExperimentalPathApi
    /* renamed from: r0 */
    public static /* synthetic */ void m8262r0(Path path) {
    }

    @NotNull
    /* renamed from: s0 */
    public static final String m8261s0(@NotNull Path invariantSeparatorsPathString) {
        String m6568k2;
        C14342f0.m8184p(invariantSeparatorsPathString, "$this$invariantSeparatorsPathString");
        FileSystem fileSystem = invariantSeparatorsPathString.getFileSystem();
        C14342f0.m8185o(fileSystem, "fileSystem");
        String separator = fileSystem.getSeparator();
        if (!C14342f0.m8193g(separator, "/")) {
            String obj = invariantSeparatorsPathString.toString();
            C14342f0.m8185o(separator, "separator");
            m6568k2 = StringsJVM.m6568k2(obj, separator, "/", false, 4, null);
            return m6568k2;
        }
        return invariantSeparatorsPathString.toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: t0 */
    public static /* synthetic */ void m8260t0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: u0 */
    private static final FileTime m8259u0(Path path, LinkOption... linkOptionArr) throws IOException {
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        C14342f0.m8185o(lastModifiedTime, "Files.getLastModifiedTime(this, *options)");
        return lastModifiedTime;
    }

    @NotNull
    /* renamed from: v0 */
    public static final String m8258v0(@NotNull Path name) {
        C14342f0.m8184p(name, "$this$name");
        Path fileName = name.getFileName();
        String obj = fileName != null ? fileName.toString() : null;
        return obj != null ? obj : "";
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: w0 */
    public static /* synthetic */ void m8257w0(Path path) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
        r3 = kotlin.text.C14579x.m6532B5(r3, ".", null, 2, null);
     */
    @org.jetbrains.annotations.NotNull
    /* renamed from: x0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String m8256x0(@org.jetbrains.annotations.NotNull java.nio.file.Path r3) {
        /*
            java.lang.String r0 = "$this$nameWithoutExtension"
            kotlin.jvm.internal.C14342f0.m8184p(r3, r0)
            java.nio.file.Path r3 = r3.getFileName()
            if (r3 == 0) goto L1c
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L1c
            r0 = 2
            java.lang.String r1 = "."
            r2 = 0
            java.lang.String r3 = kotlin.text.C14573n.m6781B5(r3, r1, r2, r0, r2)
            if (r3 == 0) goto L1c
            goto L1e
        L1c:
            java.lang.String r3 = ""
        L1e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p613io.path.C14330d.m8256x0(java.nio.file.Path):java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: y0 */
    public static /* synthetic */ void m8255y0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: z0 */
    private static final UserPrincipal m8254z0(Path path, LinkOption... linkOptionArr) throws IOException {
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }
}
