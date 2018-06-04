package com.jojonarte.ournews.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

public interface ScreenNavigator {
    void initWithRouter(Router router, Controller controller);

    boolean pop();

    void clear();
}
