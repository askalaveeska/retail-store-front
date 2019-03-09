package com.aska.store.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ppalpandi on 3/8/2019.
 */
public class StoreUtil {

    public static Object getHttpServletRequestObject(HttpServletRequest request,String name){
        return request.getAttribute(name);
    }
    public static Object getHttpSessiontObject(HttpSession session, String name){
        return session.getAttribute(name);
    }

}
