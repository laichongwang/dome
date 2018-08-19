package com.cn.agr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class Config {


    @Component
    @ConfigurationProperties("print")
    public class CommonPrint {

        private String userName;
        private String pswd;
        private Integer post;

        public CommonPrint() {

        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPswd() {
            return pswd;
        }

        public void setPswd(String pswd) {
            this.pswd = pswd;
        }

        public Integer getPost() {
            return post;
        }

        public void setPost(Integer post) {
            this.post = post;
        }
    }


}
