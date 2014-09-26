package com.codenvy.ide;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.workspace.WorkspaceAgent;
import com.codenvy.ide.client.Editor.ESBEditor;

import com.google.gwt.core.client.ScriptInjector;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import com.codenvy.ide.client.inject.JSBundle;
import static com.codenvy.ide.api.ui.workspace.PartStackType.EDITING;

/** The skeleton of empty Codenvy extension. */
@Singleton
@Extension(title = "Empty extension", version = "1.0.0")
public class MyExtension {



        @Inject
        public MyExtension(WorkspaceAgent workspaceAgent,
                ESBEditor graphicalEditor,
                JSBundle bundle) {

            
             ScriptInjector
                .fromString(JSBundle.INSTANCE.jquerysource().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector
                .fromString(JSBundle.INSTANCE.jqueryuimin().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector
                .fromString(JSBundle.INSTANCE.jsplumbsource().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector
                .fromString(JSBundle.INSTANCE.gwtresource().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

      workspaceAgent.openPart(graphicalEditor, EDITING);


        }

    }
