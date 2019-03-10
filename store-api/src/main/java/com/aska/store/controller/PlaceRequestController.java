package com.aska.store.controller;

import com.aska.store.common.RedirectPages;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by ppalpandi on 3/9/2019.
 */
public class PlaceRequestController {


    @PostMapping("/placeRequest.action")
    public String placeRequest(){

        return RedirectPages.CONFIRMATION_PAGE;
    }
}
