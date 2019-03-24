package com.aska.store.util;

import com.aska.store.model.Error;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

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

    public static Set<Error> getErrorResponse(final BindingResult bindingResult){
        Set<Error> errors = new HashSet<>();
        return errors;
    }

    public static Error getErrorObject(final String field, final String message){
        return new Error(field,message);
    }
    public static Error getErrorObject(final String message){
        return new Error(message);
    }


}
