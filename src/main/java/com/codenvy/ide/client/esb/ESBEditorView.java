package com.codenvy.ide.client.esb;

import com.codenvy.ide.api.mvp.View;
import com.codenvy.ide.api.parts.base.BaseActionDelegate;
import com.google.inject.ImplementedBy;

/**
 * Created by root on 9/10/14.
 */

@ImplementedBy(ESBEditorViewImpl.class)
public interface ESBEditorView extends View<ESBEditorView.ActionDelegate> {

public interface ActionDelegate extends BaseActionDelegate {
    /** Performs some actions in response to a user's clicking on Button */

}

}
