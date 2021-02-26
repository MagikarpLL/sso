package cn.magikarpll.sso.server.cas;

import cn.magikarpll.sso.server.constants.LoginEnums;
import org.apereo.cas.authentication.Credential;
import org.apereo.cas.authentication.credential.UsernamePasswordCredential;

import java.io.Serializable;

public class UserLoginCredentials extends UsernamePasswordCredential implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;

    private String password;

    private String text;

    private String code;

    private String loginType;

    private String receiverType;

    private String appSourceId;

    @Override
    public String getId() {
        return account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public String getAppSourceId() {
        return appSourceId;
    }

    public void setAppSourceId(String appSourceId) {
        this.appSourceId = appSourceId;
    }

    @Override
    public String toString() {
        return "UserLoginCredentials{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", text='" + text + '\'' +
                ", code='" + code + '\'' +
                ", loginType=" + loginType +
                ", receiverType=" + receiverType +
                ", appSourceId=" + appSourceId +
                '}';
    }
}
