package cn.magikarpll.sso.server.constants;

import lombok.extern.java.Log;

public class LoginEnums {

    public enum LoginTypeEnums{
        APCL("APCL"),
        APL("APL"),
        ACL("ACL");

        private String code;

        LoginTypeEnums(String code){
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static LoginTypeEnums getLoginTypeEnumsByCode(String code) throws Exception {
            switch (code){
                case "APCL":
                    return LoginTypeEnums.APCL;
                case "APL":
                    return LoginTypeEnums.APL;
                case "ACL":
                    return LoginTypeEnums.ACL;
                default:
                    throw new Exception();
            }
        }
    }

    public enum ReceiverTypeEnums{
        ACCOUNT("ACCOUNT"),
        MOBILE("MOBILE"),
        EMAIL("EMAIL");

        private String code;

        ReceiverTypeEnums(String cde){
            this.code = code;
        }

        public static ReceiverTypeEnums getReceiverTypeEnumsByCode(String code) throws Exception {
            switch (code){
                case "ACCOUNT":
                    return ReceiverTypeEnums.ACCOUNT;
                case "MOBILE":
                    return ReceiverTypeEnums.MOBILE;
                case "EMAIL":
                    return ReceiverTypeEnums.EMAIL;
                default:
                    throw new Exception();
            }
        }
    }



}
