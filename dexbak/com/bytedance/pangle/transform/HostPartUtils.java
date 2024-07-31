package com.bytedance.pangle.transform;

import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HostPartUtils {
    private Class fragmentActivityClazz;

    /* renamed from: com.bytedance.pangle.transform.HostPartUtils$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6232a {

        /* renamed from: a */
        private static final HostPartUtils f22209a = new HostPartUtils();
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable unused) {
        }
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }

    public static final Class getFragmentActivityClass() {
        return C6232a.f22209a.fragmentActivityClazz;
    }
}
