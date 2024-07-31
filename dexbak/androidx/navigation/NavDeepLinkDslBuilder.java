package androidx.navigation;

import androidx.navigation.NavDeepLink;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NavDeepLinkDslBuilder.kt */
@NavDeepLinkDsl
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\t¨\u0006\u0015"}, m12616d2 = {"Landroidx/navigation/NavDeepLinkDslBuilder;", "", "()V", "p", "", CcgConstant.f38549t, "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "builder", "Landroidx/navigation/NavDeepLink$Builder;", TTDownloadField.TT_MIME_TYPE, "getMimeType", "setMimeType", "uriPattern", "getUriPattern", "setUriPattern", "build", "Landroidx/navigation/NavDeepLink;", "build$navigation_common_ktx_release", "navigation-common-ktx_release"}, m12615k = 1, m12614mv = {1, 1, 16})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NavDeepLinkDslBuilder {
    @Nullable
    private String action;
    private final NavDeepLink.Builder builder = new NavDeepLink.Builder();
    @Nullable
    private String mimeType;
    @Nullable
    private String uriPattern;

    @NotNull
    public final NavDeepLink build$navigation_common_ktx_release() {
        NavDeepLink.Builder builder = this.builder;
        String str = this.uriPattern;
        if ((str == null && this.action == null && this.mimeType == null) ? false : true) {
            if (str != null) {
                builder.setUriPattern(str);
            }
            String str2 = this.action;
            if (str2 != null) {
                builder.setAction(str2);
            }
            String str3 = this.mimeType;
            if (str3 != null) {
                builder.setMimeType(str3);
            }
            NavDeepLink build = builder.build();
            C14342f0.m8192h(build, "builder.apply {\n        …eType(it) }\n    }.build()");
            return build;
        }
        throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.".toString());
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final String getMimeType() {
        return this.mimeType;
    }

    @Nullable
    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final void setAction(@Nullable String str) {
        if (str != null) {
            if (str.length() == 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
        }
        this.action = str;
    }

    public final void setMimeType(@Nullable String str) {
        this.mimeType = str;
    }

    public final void setUriPattern(@Nullable String str) {
        this.uriPattern = str;
    }
}
