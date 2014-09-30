/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codenvy.ide.client.Editor;

import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.*;

public class ExtendedHorizontalPanel extends Composite implements HasWidgets, HasAllKeyHandlers {

    private VerticalPanel fVerticalPanel;
    private FocusPanel fFocusPanel;

    public ExtendedHorizontalPanel() {
        fVerticalPanel = new VerticalPanel();
        fFocusPanel = new FocusPanel();
        fFocusPanel.setWidget(fVerticalPanel);
        initWidget(fFocusPanel);
    }

    @Override
    public void add(Widget w) {
        fVerticalPanel.add(w);
    }

    @Override
    public void clear() {
        fVerticalPanel.clear();
    }


    @Override
    public boolean remove(Widget w) {
        return fVerticalPanel.remove(w);
    }


    @Override
    public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
        return fFocusPanel.addKeyDownHandler(handler);
    }

    @Override
    public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
        return fFocusPanel.addKeyPressHandler(handler);
    }

    @Override
    public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        // TODO Auto-generated method stub

    }

    @Override
    public java.util.Iterator<Widget> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
