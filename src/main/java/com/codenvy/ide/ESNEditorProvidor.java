package com.codenvy.ide;

import com.codenvy.ide.api.editor.EditorProvider;
import com.codenvy.ide.api.editor.EditorPartPresenter;
import com.codenvy.ide.client.Editor.ESBEditor;

public class ESNEditorProvidor implements EditorProvider
{
    
     

    /** {@inheritDoc} */
    @Override
    public EditorPartPresenter getEditor() {
        return new ESBEditor();
    }
}