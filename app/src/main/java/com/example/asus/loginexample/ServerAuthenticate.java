package com.example.asus.loginexample;

/**
 * Created by ASUS on 2015-05-30.
 */
public interface ServerAuthenticate {
    public String userSignUp(final String name, final String email, final String pass, String authType) throws Exception;
    public String userSignIn(final String user, final String pass, String authType) throws Exception;
}
