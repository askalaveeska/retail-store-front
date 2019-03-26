package com.aska.store.util;

import com.aska.store.model.Error;
import com.aska.store.model.Message;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static List<Error> getErrorResponse(final BindingResult bindingResult){
        List<Error> errors = new ArrayList<>();
        bindingResult.getFieldErrors().stream().forEach(
                fieldError -> {
                    Error error = new Error(fieldError.getField(),fieldError.getDefaultMessage());
                    errors.add(error);
                }
        );
        return errors;
    }
    public static Message getMessageResponse(final String field, final String message){
        return new Message(field,message);
    }

    public static Error getErrorObject(final String field, final String message){
        return new Error(field,message);
    }
    public static Error getErrorObject(final String message){
        return new Error(message);
    }


}
