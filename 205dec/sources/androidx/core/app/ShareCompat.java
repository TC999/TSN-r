package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class IntentBuilder {
        @Nullable
        private ArrayList<String> mBccAddresses;
        @Nullable
        private ArrayList<String> mCcAddresses;
        @Nullable
        private CharSequence mChooserTitle;
        @NonNull
        private final Context mContext;
        @NonNull
        private final Intent mIntent;
        @Nullable
        private ArrayList<Uri> mStreams;
        @Nullable
        private ArrayList<String> mToAddresses;

        private IntentBuilder(@NonNull Context context, @Nullable ComponentName componentName) {
            this.mContext = (Context) Preconditions.checkNotNull(context);
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.mIntent = action;
            action.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            action.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            action.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
            action.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
            action.addFlags(524288);
        }

        private void combineArrayExtra(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.mIntent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[arrayList.size() + length];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.mIntent.putExtra(str, strArr);
        }

        @NonNull
        public static IntentBuilder from(@NonNull Activity activity) {
            return from((Context) Preconditions.checkNotNull(activity), activity.getComponentName());
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String str) {
            if (this.mBccAddresses == null) {
                this.mBccAddresses = new ArrayList<>();
            }
            this.mBccAddresses.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String str) {
            if (this.mCcAddresses == null) {
                this.mCcAddresses = new ArrayList<>();
            }
            this.mCcAddresses.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String str) {
            if (this.mToAddresses == null) {
                this.mToAddresses = new ArrayList<>();
            }
            this.mToAddresses.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addStream(@NonNull Uri uri) {
            Uri uri2 = (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            ArrayList<Uri> arrayList = this.mStreams;
            if (arrayList == null && uri2 == null) {
                return setStream(uri);
            }
            if (arrayList == null) {
                this.mStreams = new ArrayList<>();
            }
            if (uri2 != null) {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
                this.mStreams.add(uri2);
            }
            this.mStreams.add(uri);
            return this;
        }

        @NonNull
        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        @NonNull
        Context getContext() {
            return this.mContext;
        }

        @NonNull
        public Intent getIntent() {
            ArrayList<String> arrayList = this.mToAddresses;
            if (arrayList != null) {
                combineArrayExtra("android.intent.extra.EMAIL", arrayList);
                this.mToAddresses = null;
            }
            ArrayList<String> arrayList2 = this.mCcAddresses;
            if (arrayList2 != null) {
                combineArrayExtra("android.intent.extra.CC", arrayList2);
                this.mCcAddresses = null;
            }
            ArrayList<String> arrayList3 = this.mBccAddresses;
            if (arrayList3 != null) {
                combineArrayExtra("android.intent.extra.BCC", arrayList3);
                this.mBccAddresses = null;
            }
            ArrayList<Uri> arrayList4 = this.mStreams;
            boolean z3 = true;
            z3 = (arrayList4 == null || arrayList4.size() <= 1) ? false : false;
            boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
            if (!z3 && equals) {
                this.mIntent.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList5 = this.mStreams;
                if (arrayList5 != null && !arrayList5.isEmpty()) {
                    this.mIntent.putExtra("android.intent.extra.STREAM", this.mStreams.get(0));
                } else {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                }
                this.mStreams = null;
            }
            if (z3 && !equals) {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                ArrayList<Uri> arrayList6 = this.mStreams;
                if (arrayList6 != null && !arrayList6.isEmpty()) {
                    this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
                } else {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                }
            }
            return this.mIntent;
        }

        @NonNull
        public IntentBuilder setChooserTitle(@Nullable CharSequence charSequence) {
            this.mChooserTitle = charSequence;
            return this;
        }

        @NonNull
        public IntentBuilder setEmailBcc(@Nullable String[] strArr) {
            this.mIntent.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailCc(@Nullable String[] strArr) {
            this.mIntent.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailTo(@Nullable String[] strArr) {
            if (this.mToAddresses != null) {
                this.mToAddresses = null;
            }
            this.mIntent.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setHtmlText(@Nullable String str) {
            this.mIntent.putExtra("android.intent.extra.HTML_TEXT", str);
            if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        @NonNull
        public IntentBuilder setStream(@Nullable Uri uri) {
            if (!"android.intent.action.SEND".equals(this.mIntent.getAction())) {
                this.mIntent.setAction("android.intent.action.SEND");
            }
            this.mStreams = null;
            this.mIntent.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        @NonNull
        public IntentBuilder setSubject(@Nullable String str) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        @NonNull
        public IntentBuilder setText(@Nullable CharSequence charSequence) {
            this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @NonNull
        public IntentBuilder setType(@Nullable String str) {
            this.mIntent.setType(str);
            return this;
        }

        public void startChooser() {
            this.mContext.startActivity(createChooserIntent());
        }

        @NonNull
        private static IntentBuilder from(@NonNull Context context, @Nullable ComponentName componentName) {
            return new IntentBuilder(context, componentName);
        }

        @NonNull
        public IntentBuilder setChooserTitle(@StringRes int i4) {
            return setChooserTitle(this.mContext.getText(i4));
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String[] strArr) {
            combineArrayExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String[] strArr) {
            combineArrayExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String[] strArr) {
            combineArrayExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        private void combineArrayExtra(@Nullable String str, @NonNull String[] strArr) {
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[strArr.length + length];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intent.putExtra(str, strArr2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class IntentReader {
        private static final String TAG = "IntentReader";
        @Nullable
        private final ComponentName mCallingActivity;
        @Nullable
        private final String mCallingPackage;
        @NonNull
        private final Context mContext;
        @NonNull
        private final Intent mIntent;
        @Nullable
        private ArrayList<Uri> mStreams;

        private IntentReader(@NonNull Context context, @NonNull Intent intent) {
            this.mContext = (Context) Preconditions.checkNotNull(context);
            this.mIntent = (Intent) Preconditions.checkNotNull(intent);
            this.mCallingPackage = ShareCompat.getCallingPackage(intent);
            this.mCallingActivity = ShareCompat.getCallingActivity(intent);
        }

        @NonNull
        public static IntentReader from(@NonNull Activity activity) {
            return from((Context) Preconditions.checkNotNull(activity), activity.getIntent());
        }

        private static void withinStyle(StringBuilder sb, CharSequence charSequence, int i4, int i5) {
            while (i4 < i5) {
                char charAt = charSequence.charAt(i4);
                if (charAt == '<') {
                    sb.append("&lt;");
                } else if (charAt == '>') {
                    sb.append("&gt;");
                } else if (charAt == '&') {
                    sb.append("&amp;");
                } else if (charAt > '~' || charAt < ' ') {
                    sb.append("&#");
                    sb.append((int) charAt);
                    sb.append(";");
                } else if (charAt == ' ') {
                    while (true) {
                        int i6 = i4 + 1;
                        if (i6 >= i5 || charSequence.charAt(i6) != ' ') {
                            break;
                        }
                        sb.append("&nbsp;");
                        i4 = i6;
                    }
                    sb.append(' ');
                } else {
                    sb.append(charAt);
                }
                i4++;
            }
        }

        @Nullable
        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        @Nullable
        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity == null) {
                return null;
            }
            try {
                return this.mContext.getPackageManager().getActivityIcon(this.mCallingActivity);
            } catch (PackageManager.NameNotFoundException e4) {
                Log.e("IntentReader", "Could not retrieve icon for calling activity", e4);
                return null;
            }
        }

        @Nullable
        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage == null) {
                return null;
            }
            try {
                return this.mContext.getPackageManager().getApplicationIcon(this.mCallingPackage);
            } catch (PackageManager.NameNotFoundException e4) {
                Log.e("IntentReader", "Could not retrieve icon for calling application", e4);
                return null;
            }
        }

        @Nullable
        public CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage == null) {
                return null;
            }
            PackageManager packageManager = this.mContext.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mCallingPackage, 0));
            } catch (PackageManager.NameNotFoundException e4) {
                Log.e("IntentReader", "Could not retrieve label for calling application", e4);
                return null;
            }
        }

        @Nullable
        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        @Nullable
        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        @Nullable
        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        @Nullable
        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @Nullable
        public String getHtmlText() {
            String stringExtra = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
            if (stringExtra == null) {
                CharSequence text = getText();
                if (text instanceof Spanned) {
                    return Html.toHtml((Spanned) text);
                }
                return text != null ? Html.escapeHtml(text) : stringExtra;
            }
            return stringExtra;
        }

        @Nullable
        public Uri getStream() {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public int getStreamCount() {
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.mStreams;
            if (arrayList != null) {
                return arrayList.size();
            }
            return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        @Nullable
        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        @Nullable
        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @Nullable
        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String action = this.mIntent.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }

        @NonNull
        private static IntentReader from(@NonNull Context context, @NonNull Intent intent) {
            return new IntentReader(context, intent);
        }

        @Nullable
        public Uri getStream(int i4) {
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.mStreams;
            if (arrayList != null) {
                return arrayList.get(i4);
            }
            if (i4 == 0) {
                return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i4);
        }
    }

    private ShareCompat() {
    }

    public static void configureMenuItem(@NonNull MenuItem menuItem, @NonNull IntentBuilder intentBuilder) {
        ShareActionProvider shareActionProvider;
        ActionProvider actionProvider = menuItem.getActionProvider();
        if (!(actionProvider instanceof ShareActionProvider)) {
            shareActionProvider = new ShareActionProvider(intentBuilder.getContext());
        } else {
            shareActionProvider = (ShareActionProvider) actionProvider;
        }
        shareActionProvider.setShareHistoryFileName(".sharecompat_" + intentBuilder.getContext().getClass().getName());
        shareActionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(shareActionProvider);
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? getCallingActivity(intent) : callingActivity;
    }

    @Nullable
    public static String getCallingPackage(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        String callingPackage = activity.getCallingPackage();
        return (callingPackage != null || intent == null) ? callingPackage : getCallingPackage(intent);
    }

    @Nullable
    static ComponentName getCallingActivity(@NonNull Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY");
        return componentName == null ? (ComponentName) intent.getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY") : componentName;
    }

    @Nullable
    static String getCallingPackage(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra("androidx.core.app.EXTRA_CALLING_PACKAGE");
        return stringExtra == null ? intent.getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE") : stringExtra;
    }

    public static void configureMenuItem(@NonNull Menu menu, @IdRes int i4, @NonNull IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i4);
        if (findItem != null) {
            configureMenuItem(findItem, intentBuilder);
            return;
        }
        throw new IllegalArgumentException("Could not find menu item with id " + i4 + " in the supplied menu");
    }
}
