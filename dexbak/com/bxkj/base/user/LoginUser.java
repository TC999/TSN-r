package com.bxkj.base.user;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import cn.bluemobi.dylan.base.utils.SharedPreferencesUtils;
import com.bxkj.base.BaseApp;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LoginUser {
    private static LoginUser loginUser = new LoginUser();
    private String QR_Code;
    private String accessToken;
    private String account;
    private String achieveTime;
    private String address;
    private boolean agreement;
    private String appId;
    private String birthday;
    private String city_id;
    private String clearDataPassword;
    private String currentCity;
    private String email;
    private String energy_QTY;
    private int frequency;
    private String gender;
    private String gold;
    private String headImageUrl;
    private String idcard;
    private boolean isCheckIgnoreRunSet;
    private String isOpenEncry;
    private int isOpenKeep;
    private int isOpenLive;
    private boolean isOpenModel;
    private String is_sign;
    private String is_verify;
    private String keepToken;
    private long lastHeartCallBackTime;
    private String levels;
    private String location;
    private String marryDate;
    private String nickName;
    private String openId;
    private String password;
    private String phone;
    private String planWalk_QTY;
    private String point;
    private String province_id;
    private String realName;
    private String region_id;
    private String remind;
    private String roleName;
    private String schoolCode;
    private String schoolId;
    private String schoolName;
    private String serverUrl;
    private String sex;
    private String sumEnergy_QTY;
    private String synTime;
    private int sysType;
    private String tempUserId;
    private String tempUserName;
    private String tempUserNumber;
    private String tempUserPhone;
    private String token;
    private String uploadTime;
    private String userId;
    private int userPreferenceMode;
    private int userType;
    private String user_specialty;
    private String usersignature;
    private boolean voiceOpen;
    private String wallet;
    private int nfcCardType = 0;
    private List<Bitmap> bitmapList = new ArrayList();
    private String msg_QTY = "0";
    private boolean isFirst = true;
    private int lastVersionCode = 0;
    private long lastLoginTime = 0;
    private boolean isFirstUserSQJL = true;
    private boolean noPrompt = false;

    /* renamed from: sp */
    private SharedPreferencesUtils f14837sp = new SharedPreferencesUtils(BaseApp.m44341b());
    private boolean isAuthorizationInMall = false;
    private boolean isAuthorizationInLost = false;
    private boolean isAuthorizationInSecondHand = false;
    private boolean isAuthorizationInJob = false;
    private boolean isAuthorizationInRuner = false;
    private boolean isAuthorizationDonation = false;
    private boolean isLogin = false;
    private List<LoginListener> loginListenerList = new ArrayList();
    private boolean chatConnectStatus = false;
    private List<ChatConnectListener> chatConnectListenerList = new ArrayList();

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface ChatConnectListener {
        void connectStatusChange(boolean z);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface LoginListener {
        void loginStatusChange(boolean z);
    }

    private LoginUser() {
    }

    public static LoginUser getLoginUser() {
        return loginUser;
    }

    public void addChatConnectListener(ChatConnectListener chatConnectListener) {
        this.chatConnectListenerList.add(chatConnectListener);
    }

    public void addLoginListener(LoginListener loginListener) {
        this.loginListenerList.add(loginListener);
    }

    public String getAccessToken() {
        String str = (String) this.f14837sp.m57697b("accessToken", "e34e6ce9-d599-4d2c-8f15-d475849d3e4d");
        this.accessToken = str;
        return str;
    }

    public String getAccount() {
        String str = (String) this.f14837sp.m57697b("account", "");
        this.account = str;
        return str;
    }

    public String getAchieveTime() {
        String str = (String) this.f14837sp.m57697b("achieveTime", "21:00");
        this.achieveTime = str;
        return str;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAppId() {
        String str = (String) this.f14837sp.m57697b("appId", "move");
        this.appId = str;
        return str;
    }

    public String getBirthday() {
        String str = (String) this.f14837sp.m57697b("birthday", "");
        this.birthday = str;
        return str;
    }

    public List<Bitmap> getBitmapList() {
        return this.bitmapList;
    }

    public String getCity_id() {
        return this.city_id;
    }

    public String getClearDataPassword() {
        String str = (String) this.f14837sp.m57697b("clearDataPassword", "");
        this.clearDataPassword = str;
        return str;
    }

    public String getCurrentCity() {
        return this.currentCity;
    }

    public String getEmail() {
        String str = (String) this.f14837sp.m57697b(NotificationCompat.CATEGORY_EMAIL, "");
        this.email = str;
        return str;
    }

    public String getEnergy_QTY() {
        String str = (String) this.f14837sp.m57697b("energy_QTY", "0");
        this.energy_QTY = str;
        return str;
    }

    public int getFrequency() {
        int intValue = ((Integer) this.f14837sp.m57697b("frequency", 0)).intValue();
        this.frequency = intValue;
        return intValue;
    }

    public String getGender() {
        String str = (String) this.f14837sp.m57697b("gender", "");
        this.gender = str;
        return str;
    }

    public String getGold() {
        return this.gold;
    }

    public String getHeadImageUrl() {
        String str = (String) this.f14837sp.m57697b("headImageUrl", "");
        this.headImageUrl = str;
        return str;
    }

    public String getIdcard() {
        String str = (String) this.f14837sp.m57697b("idcard", "");
        this.idcard = str;
        return str;
    }

    public boolean getIsFirst() {
        boolean booleanValue = ((Boolean) this.f14837sp.m57697b("QR_Code", Boolean.TRUE)).booleanValue();
        this.isFirst = booleanValue;
        return booleanValue;
    }

    public String getIsOpenEncry() {
        String str = (String) this.f14837sp.m57697b("isOpenEncry", "0");
        this.isOpenEncry = str;
        return str;
    }

    public int getIsOpenKeep() {
        int intValue = ((Integer) this.f14837sp.m57697b("isOpenKeep", 0)).intValue();
        this.isOpenKeep = intValue;
        return intValue;
    }

    public int getIsOpenLive() {
        int intValue = ((Integer) this.f14837sp.m57697b("isOpenLive", 1)).intValue();
        this.isOpenLive = intValue;
        return intValue;
    }

    public String getIs_sign() {
        return this.is_sign;
    }

    public String getIs_verify() {
        return this.is_verify;
    }

    public String getKeepToken() {
        String str = (String) this.f14837sp.m57697b("keepToken", "");
        this.keepToken = str;
        return str;
    }

    public long getLastHeartCallBackTime() {
        return this.lastHeartCallBackTime;
    }

    public long getLastLoginTime() {
        long longValue = ((Long) this.f14837sp.m57697b("lastLoginTime", 0L)).longValue();
        this.lastLoginTime = longValue;
        return longValue;
    }

    public int getLastVersionCode() {
        int intValue = ((Integer) this.f14837sp.m57697b("lastVersionCode", 0)).intValue();
        this.lastVersionCode = intValue;
        return intValue;
    }

    public String getLevels() {
        String str = (String) this.f14837sp.m57697b("levels", "");
        this.levels = str;
        return str;
    }

    public String getLocation() {
        String str = (String) this.f14837sp.m57697b(SocializeConstants.KEY_LOCATION, "");
        this.location = str;
        return str;
    }

    public String getMarryDate() {
        String str = (String) this.f14837sp.m57697b("marryDate", "");
        this.marryDate = str;
        return str;
    }

    public String getMsg_QTY() {
        return this.msg_QTY;
    }

    public int getNfcCardType() {
        int intValue = ((Integer) this.f14837sp.m57697b("nfcCardType", 0)).intValue();
        this.nfcCardType = intValue;
        return intValue;
    }

    public String getNickName() {
        String str = (String) this.f14837sp.m57697b("nickName", "");
        this.nickName = str;
        return str;
    }

    public String getOpenId() {
        this.openId = (String) this.f14837sp.m57697b("openId", "");
        String str = getLoginUser().getSchoolId() + "_" + getLoginUser().getUserId();
        this.openId = str;
        return str;
    }

    public String getPassword() {
        String str = (String) this.f14837sp.m57697b("password", "");
        this.password = str;
        return str;
    }

    public String getPhone() {
        String str = (String) this.f14837sp.m57697b("phone", "");
        this.phone = str;
        return str;
    }

    public String getPlanWalk_QTY() {
        String str = (String) this.f14837sp.m57697b("planWalk_QTY", "7000");
        this.planWalk_QTY = str;
        return str;
    }

    public String getPoint() {
        return this.point;
    }

    public String getProvince_id() {
        return this.province_id;
    }

    public String getQR_Code() {
        String str = (String) this.f14837sp.m57697b("QR_Code", "");
        this.QR_Code = str;
        return str;
    }

    public String getRealName() {
        String str = (String) this.f14837sp.m57697b("realName", "");
        this.realName = str;
        return str;
    }

    public String getRegion_id() {
        return this.region_id;
    }

    public String getRemind() {
        String str = (String) this.f14837sp.m57697b("remind", "1");
        this.remind = str;
        return str;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getSchoolCode() {
        String str = (String) this.f14837sp.m57697b("schoolCode", "");
        this.schoolCode = str;
        return str;
    }

    public String getSchoolId() {
        String str = (String) this.f14837sp.m57697b("schoolId", "");
        this.schoolId = str;
        return str;
    }

    public String getSchoolName() {
        String str = (String) this.f14837sp.m57697b("schoolName", "");
        this.schoolName = str;
        return str;
    }

    public String getServerUrl() {
        String str = (String) this.f14837sp.m57697b("serverUrl", "https://m.boxkj.com/");
        this.serverUrl = str;
        if (!str.startsWith("http://") && !this.serverUrl.startsWith("https://")) {
            this.serverUrl = "https://tsncs.boxkj.com/";
        }
        if (!this.serverUrl.endsWith("/")) {
            this.serverUrl += "/";
        }
        return this.serverUrl;
    }

    public String getSex() {
        String str = (String) this.f14837sp.m57697b("sex", "");
        this.sex = str;
        return str;
    }

    public String getSumEnergy_QTY() {
        String str = (String) this.f14837sp.m57697b("sumEnergy_QTY", "0");
        this.sumEnergy_QTY = str;
        return str;
    }

    public String getSynTime() {
        String str = (String) this.f14837sp.m57697b("synTime", "");
        this.synTime = str;
        return str;
    }

    public int getSysType() {
        int intValue = ((Integer) this.f14837sp.m57697b("sysType", 1)).intValue();
        this.sysType = intValue;
        return intValue;
    }

    public String getTempUserId() {
        String str = (String) this.f14837sp.m57697b("tempUserId", "");
        this.tempUserId = str;
        return str;
    }

    public String getTempUserName() {
        String str = (String) this.f14837sp.m57697b("tempUserName", "");
        this.tempUserName = str;
        return str;
    }

    public String getTempUserNumber() {
        String str = (String) this.f14837sp.m57697b("tempUserNumber", "");
        this.tempUserNumber = str;
        return str;
    }

    public String getTempUserPhone() {
        String str = (String) this.f14837sp.m57697b("tempUserPhone", "");
        this.tempUserPhone = str;
        return str;
    }

    public String getToken() {
        String str = (String) this.f14837sp.m57697b(BidResponsed.KEY_TOKEN, "");
        this.token = str;
        return str;
    }

    public String getUploadTime() {
        String str = (String) this.f14837sp.m57697b("uploadTime", "");
        this.uploadTime = str;
        return str;
    }

    public String getUserId() {
        String str = (String) this.f14837sp.m57697b("userId", "");
        this.userId = str;
        return str;
    }

    public int getUserPreferenceMode() {
        int intValue = ((Integer) this.f14837sp.m57697b("userPreferenceMode", 1)).intValue();
        this.userPreferenceMode = intValue;
        return intValue;
    }

    public int getUserType() {
        String str = (String) this.f14837sp.m57697b("userType", "");
        if (!str.trim().isEmpty()) {
            if ("1".equals(str)) {
                this.userType = 1;
            } else {
                this.userType = 2;
            }
        } else {
            this.userType = 1;
        }
        return this.userType;
    }

    public String getUser_specialty() {
        return this.user_specialty;
    }

    public String getUsersignature() {
        return this.usersignature;
    }

    public String getViewAfterLabelName() {
        return getSchoolName().equals("西安电子科技大学") ? "俱乐部" : "选课";
    }

    public String getWallet() {
        return this.wallet;
    }

    public String getXuanAfterLabelName() {
        return getSchoolName().equals("西安电子科技大学") ? "俱乐部" : "课";
    }

    public String getXuanZeAfterLabelName() {
        return getSchoolName().equals("西安电子科技大学") ? "俱乐部" : "课程";
    }

    public boolean isAgreement() {
        boolean booleanValue = ((Boolean) this.f14837sp.m57697b("agreement", Boolean.FALSE)).booleanValue();
        this.agreement = booleanValue;
        return booleanValue;
    }

    public boolean isAuthorizationDonation() {
        return this.isAuthorizationDonation;
    }

    public boolean isAuthorizationInJob() {
        return this.isAuthorizationInJob;
    }

    public boolean isAuthorizationInLost() {
        return this.isAuthorizationInLost;
    }

    public boolean isAuthorizationInMall() {
        return this.isAuthorizationInMall;
    }

    public boolean isAuthorizationInRuner() {
        return this.isAuthorizationInRuner;
    }

    public boolean isAuthorizationInSecondHand() {
        return this.isAuthorizationInSecondHand;
    }

    public boolean isChatConnectStatus() {
        return this.chatConnectStatus;
    }

    public boolean isCheckIgnoreRunSet() {
        boolean booleanValue = ((Boolean) this.f14837sp.m57697b("isCheckIgnoreRunSet", Boolean.FALSE)).booleanValue();
        this.isCheckIgnoreRunSet = booleanValue;
        return booleanValue;
    }

    public boolean isFirstUserSQJL() {
        boolean booleanValue = ((Boolean) this.f14837sp.m57697b("isFirstUserSQJL", Boolean.TRUE)).booleanValue();
        this.isFirstUserSQJL = booleanValue;
        return booleanValue;
    }

    public boolean isLogin() {
        boolean booleanValue = ((Boolean) this.f14837sp.m57697b("login", Boolean.FALSE)).booleanValue();
        this.isLogin = booleanValue;
        return booleanValue;
    }

    public boolean isNoPrompt() {
        boolean booleanValue = ((Boolean) this.f14837sp.m57697b("noPrompt", Boolean.FALSE)).booleanValue();
        this.noPrompt = booleanValue;
        return booleanValue;
    }

    public boolean isOpenModel() {
        boolean booleanValue = ((Boolean) this.f14837sp.m57697b("openModel", Boolean.FALSE)).booleanValue();
        this.isOpenModel = booleanValue;
        return booleanValue;
    }

    public boolean isVoiceOpen() {
        boolean booleanValue = ((Boolean) this.f14837sp.m57697b("voiceOpen", Boolean.FALSE)).booleanValue();
        this.voiceOpen = booleanValue;
        return booleanValue;
    }

    public LoginUser setAccessToken(String str) {
        this.f14837sp.m57695d("accessToken", str);
        this.accessToken = str;
        return this;
    }

    public void setAccount(String str) {
        this.f14837sp.m57695d("account", str);
        this.account = str;
    }

    public void setAchieveTime(String str) {
        if (str.isEmpty()) {
            this.f14837sp.m57695d("achieveTime", "21:00");
            this.achieveTime = "21:00";
            return;
        }
        this.f14837sp.m57695d("achieveTime", str);
        this.achieveTime = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public LoginUser setAgreement(boolean z) {
        this.f14837sp.m57695d("agreement", Boolean.valueOf(z));
        this.agreement = z;
        return this;
    }

    public void setAppId(String str) {
        this.f14837sp.m57695d("appId", str);
        this.appId = str;
    }

    public LoginUser setAuthorizationDonation(boolean z) {
        this.isAuthorizationDonation = z;
        return this;
    }

    public LoginUser setAuthorizationInJob(boolean z) {
        this.isAuthorizationInJob = z;
        return this;
    }

    public LoginUser setAuthorizationInLost(boolean z) {
        this.isAuthorizationInLost = z;
        return this;
    }

    public LoginUser setAuthorizationInMall(boolean z) {
        this.isAuthorizationInMall = z;
        return this;
    }

    public LoginUser setAuthorizationInRuner(boolean z) {
        this.isAuthorizationInRuner = z;
        return this;
    }

    public LoginUser setAuthorizationInSecondHand(boolean z) {
        this.isAuthorizationInSecondHand = z;
        return this;
    }

    public void setBirthday(String str) {
        this.f14837sp.m57695d("birthday", str);
        this.birthday = str;
    }

    public LoginUser setBitmapList(List<Bitmap> list) {
        this.bitmapList = list;
        return this;
    }

    public void setChatConnectStatus(boolean z) {
        this.chatConnectStatus = z;
        List<ChatConnectListener> list = this.chatConnectListenerList;
        if (list != null) {
            for (ChatConnectListener chatConnectListener : list) {
                chatConnectListener.connectStatusChange(z);
            }
        }
    }

    public void setCheckIgnoreRunSet(boolean z) {
        this.f14837sp.m57695d("isCheckIgnoreRunSet", Boolean.valueOf(z));
        this.isCheckIgnoreRunSet = z;
    }

    public void setCity_id(String str) {
        this.city_id = str;
    }

    public LoginUser setClearDataPassword(String str) {
        this.f14837sp.m57695d("clearDataPassword", str);
        this.clearDataPassword = str;
        return this;
    }

    public void setCurrentCity(String str) {
        this.currentCity = str;
    }

    public void setEmail(String str) {
        this.f14837sp.m57695d(NotificationCompat.CATEGORY_EMAIL, str);
        this.email = str;
    }

    public void setEnergy_QTY(String str) {
        this.f14837sp.m57695d("energy_QTY", str);
        this.energy_QTY = str;
    }

    public LoginUser setFirstUserSQJL(boolean z) {
        this.f14837sp.m57695d("isFirstUserSQJL", Boolean.valueOf(z));
        this.isFirstUserSQJL = z;
        return this;
    }

    public LoginUser setFrequency(int i) {
        this.f14837sp.m57695d("frequency", Integer.valueOf(i));
        this.frequency = i;
        return this;
    }

    public void setGender(String str) {
        this.f14837sp.m57695d("gender", str);
        this.gender = str;
    }

    public void setGold(String str) {
        this.gold = str;
    }

    public void setHeadImageUrl(String str) {
        this.f14837sp.m57695d("headImageUrl", str);
        this.headImageUrl = str;
    }

    public void setIdcard(String str) {
        this.f14837sp.m57695d("idcard", str);
        this.idcard = str;
    }

    public void setIsFirst(boolean z) {
        this.f14837sp.m57695d("isFirst", Boolean.valueOf(z));
        this.isFirst = z;
    }

    public LoginUser setIsOpenEncry(String str) {
        this.f14837sp.m57695d("isOpenEncry", str);
        this.isOpenEncry = str;
        return this;
    }

    public LoginUser setIsOpenKeep(int i) {
        this.f14837sp.m57695d("isOpenKeep", Integer.valueOf(i));
        this.isOpenKeep = i;
        return this;
    }

    public LoginUser setIsOpenLive(int i) {
        this.f14837sp.m57695d("isOpenLive", Integer.valueOf(i));
        this.isOpenLive = i;
        return this;
    }

    public void setIs_sign(String str) {
        this.is_sign = str;
    }

    public void setIs_verify(String str) {
        this.is_verify = str;
    }

    public LoginUser setKeepToken(String str) {
        this.f14837sp.m57695d("keepToken", str);
        this.keepToken = str;
        return this;
    }

    public void setLastHeartCallBackTime(long j) {
        this.lastHeartCallBackTime = j;
    }

    public void setLastLoginTime(long j) {
        this.f14837sp.m57695d("lastLoginTime", Long.valueOf(j));
        this.lastLoginTime = j;
    }

    public void setLastVersionCode(int i) {
        this.f14837sp.m57695d("lastVersionCode", Integer.valueOf(i));
        this.lastVersionCode = i;
    }

    public void setLevels(String str) {
        this.f14837sp.m57695d("levels", str);
        this.levels = str;
    }

    public void setLocation(String str) {
        this.f14837sp.m57695d(SocializeConstants.KEY_LOCATION, str);
        this.location = str;
    }

    public LoginUser setLogin(boolean z) {
        this.f14837sp.m57695d("login", Boolean.valueOf(z));
        this.isLogin = z;
        List<LoginListener> list = this.loginListenerList;
        if (list != null) {
            for (LoginListener loginListener : list) {
                loginListener.loginStatusChange(this.isLogin);
            }
        }
        return this;
    }

    public void setMarryDate(String str) {
        this.f14837sp.m57695d("marryDate", str);
        this.marryDate = str;
    }

    public void setMsg_QTY(String str) {
        this.msg_QTY = str;
    }

    public LoginUser setNfcCardType(int i) {
        this.f14837sp.m57695d("nfcCardType", Integer.valueOf(i));
        this.nfcCardType = i;
        return this;
    }

    public void setNickName(String str) {
        this.f14837sp.m57695d("nickName", str);
        this.nickName = str;
    }

    public LoginUser setNoPrompt(boolean z) {
        this.f14837sp.m57695d("noPrompt", Boolean.valueOf(z));
        this.noPrompt = z;
        return this;
    }

    public void setOpen(String str) {
        this.f14837sp.m57695d("openId", str);
        this.openId = str;
    }

    public LoginUser setOpenModel(boolean z) {
        this.f14837sp.m57695d("openModel", Boolean.valueOf(z));
        this.isOpenModel = z;
        return this;
    }

    public void setPassword(String str) {
        this.f14837sp.m57695d("password", str);
        this.password = str;
    }

    public void setPhone(String str) {
        this.f14837sp.m57695d("phone", str);
        this.phone = str;
    }

    public void setPlanWalk_QTY(String str) {
        if (!str.isEmpty() && !"0".equals(str)) {
            this.f14837sp.m57695d("planWalk_QTY", str);
        } else {
            this.f14837sp.m57695d("planWalk_QTY", "7000");
        }
        this.planWalk_QTY = str;
    }

    public void setPoint(String str) {
        this.point = str;
    }

    public void setProvince_id(String str) {
        this.province_id = str;
    }

    public void setQR_Code(String str) {
        this.f14837sp.m57695d("QR_Code", str);
        this.QR_Code = str;
    }

    public void setRealName(String str) {
        this.f14837sp.m57695d("realName", str);
        this.realName = str;
    }

    public void setRegion_id(String str) {
        this.region_id = str;
    }

    public void setRemind(String str) {
        this.f14837sp.m57695d("remind", str);
        this.remind = str;
    }

    public LoginUser setRoleName(String str) {
        this.roleName = str;
        return this;
    }

    public void setSchoolCode(String str) {
        this.f14837sp.m57695d("schoolCode", str);
        this.schoolCode = str;
    }

    public void setSchoolId(String str) {
        this.f14837sp.m57695d("schoolId", str);
        this.schoolId = str;
    }

    public void setSchoolName(String str) {
        this.f14837sp.m57695d("schoolName", str);
        this.schoolName = str;
    }

    public void setServerUrl(String str) {
        this.f14837sp.m57695d("serverUrl", str);
        this.serverUrl = str;
    }

    public void setSex(String str) {
        this.f14837sp.m57695d("sex", str);
        this.sex = str;
    }

    public void setSumEnergy_QTY(String str) {
        this.f14837sp.m57695d("sumEnergy_QTY", str);
        this.sumEnergy_QTY = str;
    }

    public void setSynTime(String str) {
        this.f14837sp.m57695d("synTime", str);
        this.synTime = str;
    }

    public LoginUser setSysType(int i) {
        this.f14837sp.m57695d("sysType", Integer.valueOf(i));
        this.sysType = i;
        return this;
    }

    public void setTempUserId(String str) {
        this.f14837sp.m57695d("tempUserId", str);
        this.tempUserId = str;
    }

    public void setTempUserName(String str) {
        this.f14837sp.m57695d("tempUserName", str);
        this.tempUserName = str;
    }

    public void setTempUserNumber(String str) {
        this.f14837sp.m57695d("tempUserNumber", str);
        this.tempUserNumber = str;
    }

    public void setTempUserPhone(String str) {
        this.f14837sp.m57695d("tempUserPhone", str);
        this.tempUserPhone = str;
    }

    public void setToken(String str) {
        this.f14837sp.m57695d(BidResponsed.KEY_TOKEN, str);
        this.token = str;
    }

    public void setUploadTime(String str) {
        this.f14837sp.m57695d("uploadTime", str);
        this.uploadTime = str;
    }

    public void setUserId(String str) {
        this.f14837sp.m57695d("userId", str);
        this.userId = str;
    }

    public void setUserPreferenceMode(int i) {
        this.f14837sp.m57695d("userPreferenceMode", Integer.valueOf(i));
        this.userPreferenceMode = i;
    }

    public void setUserType(int i) {
        if (i == 1) {
            this.f14837sp.m57695d("userType", "1");
        } else {
            this.f14837sp.m57695d("userType", "2");
        }
        this.userType = i;
    }

    public void setUser_specialty(String str) {
        this.user_specialty = str;
    }

    public void setUsersignature(String str) {
        this.usersignature = str;
    }

    public LoginUser setVoiceOpen(boolean z) {
        this.f14837sp.m57695d("voiceOpen", Boolean.valueOf(z));
        this.voiceOpen = z;
        return this;
    }

    public void setWallet(String str) {
        this.wallet = str;
    }
}
