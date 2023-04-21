package org.example.frontcontroller.mvc;

import org.example.frontcontroller.mvc.controller.Controller;

public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}
