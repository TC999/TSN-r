package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    private final FragmentManager mFragmentManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.mFragmentManager);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(R.styleable.Fragment_android_name);
            }
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
            String string = obtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
            obtainStyledAttributes.recycle();
            if (attributeValue == null || !FragmentFactory.isFragmentClass(context.getClassLoader(), attributeValue)) {
                return null;
            }
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
            }
            Fragment findFragmentById = resourceId != -1 ? this.mFragmentManager.findFragmentById(resourceId) : null;
            if (findFragmentById == null && string != null) {
                findFragmentById = this.mFragmentManager.findFragmentByTag(string);
            }
            if (findFragmentById == null && id != -1) {
                findFragmentById = this.mFragmentManager.findFragmentById(id);
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + findFragmentById);
            }
            if (findFragmentById == null) {
                findFragmentById = this.mFragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
                findFragmentById.mFromLayout = true;
                findFragmentById.mFragmentId = resourceId != 0 ? resourceId : id;
                findFragmentById.mContainerId = id;
                findFragmentById.mTag = string;
                findFragmentById.mInLayout = true;
                FragmentManager fragmentManager = this.mFragmentManager;
                findFragmentById.mFragmentManager = fragmentManager;
                FragmentHostCallback<?> fragmentHostCallback = fragmentManager.mHost;
                findFragmentById.mHost = fragmentHostCallback;
                findFragmentById.onInflate(fragmentHostCallback.getContext(), attributeSet, findFragmentById.mSavedFragmentState);
                this.mFragmentManager.addFragment(findFragmentById);
                this.mFragmentManager.moveToState(findFragmentById);
            } else if (!findFragmentById.mInLayout) {
                findFragmentById.mInLayout = true;
                FragmentHostCallback<?> fragmentHostCallback2 = this.mFragmentManager.mHost;
                findFragmentById.mHost = fragmentHostCallback2;
                findFragmentById.onInflate(fragmentHostCallback2.getContext(), attributeSet, findFragmentById.mSavedFragmentState);
            } else {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            FragmentManager fragmentManager2 = this.mFragmentManager;
            if (fragmentManager2.mCurState < 1 && findFragmentById.mFromLayout) {
                fragmentManager2.moveToState(findFragmentById, 1);
            } else {
                fragmentManager2.moveToState(findFragmentById);
            }
            View view2 = findFragmentById.mView;
            if (view2 != null) {
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (findFragmentById.mView.getTag() == null) {
                    findFragmentById.mView.setTag(string);
                }
                return findFragmentById.mView;
            }
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        return null;
    }
}
