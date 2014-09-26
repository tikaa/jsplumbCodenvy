package com.codenvy.ide.client.esb;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Composite;
import com.google.inject.Inject;

/**
 * Created by root on 9/10/14.
 */
public class ESBEditorViewImpl extends Composite implements ESBEditorView {
    interface ESBEditorViewImplUiBinder extends UiBinder<Widget, ESBEditorViewImpl> {
    }

    @Inject
    public ESBEditorViewImpl(ESBEditorViewImplUiBinder ourUiBinder) {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    /** {@inheritDoc} */
    @Override
    public void setDelegate(ESBEditorView.ActionDelegate delegate) {
        // do nothing
    }
}
