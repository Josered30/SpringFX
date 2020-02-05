package com.springfxsecurity.springfxsecurity.emuns;

import java.util.ResourceBundle;

public enum FxmlView {


    LOGIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    };




    public abstract String getTitle();
    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("bundle").getString(key);
    }
}
