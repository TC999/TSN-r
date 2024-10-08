package androidx.core.p018os;

import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

@RequiresApi(24)
/* renamed from: androidx.core.os.LocaleListPlatformWrapper */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList mLocaleList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleListPlatformWrapper(LocaleList localeList) {
        this.mLocaleList = localeList;
    }

    public boolean equals(Object obj) {
        return this.mLocaleList.equals(((LocaleListInterface) obj).getLocaleList());
    }

    @Override // androidx.core.p018os.LocaleListInterface
    public Locale get(int i) {
        return this.mLocaleList.get(i);
    }

    @Override // androidx.core.p018os.LocaleListInterface
    @Nullable
    public Locale getFirstMatch(@NonNull String[] strArr) {
        return this.mLocaleList.getFirstMatch(strArr);
    }

    @Override // androidx.core.p018os.LocaleListInterface
    public Object getLocaleList() {
        return this.mLocaleList;
    }

    public int hashCode() {
        return this.mLocaleList.hashCode();
    }

    @Override // androidx.core.p018os.LocaleListInterface
    public int indexOf(Locale locale) {
        return this.mLocaleList.indexOf(locale);
    }

    @Override // androidx.core.p018os.LocaleListInterface
    public boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    @Override // androidx.core.p018os.LocaleListInterface
    public int size() {
        return this.mLocaleList.size();
    }

    @Override // androidx.core.p018os.LocaleListInterface
    public String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    public String toString() {
        return this.mLocaleList.toString();
    }
}
