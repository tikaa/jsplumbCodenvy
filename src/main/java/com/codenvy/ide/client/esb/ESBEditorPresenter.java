package com.codenvy.ide.client.esb;


import java.util.HashMap;

import com.codenvy.ide.api.editor.AbstractEditorPresenter;
import com.codenvy.ide.api.resources.model.File;
import com.codenvy.ide.api.ui.workspace.AbstractPartPresenter;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.codenvy.ide.client.inject.JSBundle;
import com.google.gwt.user.client.ui.*;

import javax.annotation.Nullable;

/**
 * Created by root on 9/10/14.
 */
public class ESBEditorPresenter extends AbstractEditorPresenter implements ESBEditorView.ActionDelegate {
 private ImageResource CallImage = JSBundle.INSTANCE.CallImage();
    private ImageResource CallTempImage = JSBundle.INSTANCE
            .CalleTempImage();
    private ImageResource LogImage = JSBundle.INSTANCE.LogImage();
    private ImageResource DropImage = JSBundle.INSTANCE.DropImage();
    private ImageResource StoreImage = JSBundle.INSTANCE.StoreImage();
    private ImageResource ThrottleImage = JSBundle.INSTANCE
            .ThrottleImage();
    private ImageResource SendImage = JSBundle.INSTANCE.SendImage();
    private ImageResource PayloadFactoryImage = JSBundle.INSTANCE
            .PayloadFactoryImage();
    private ImageResource RespondImage = JSBundle.INSTANCE.RespondImage();
    private ImageResource CloneImage = JSBundle.INSTANCE.CloneImage();
    private ImageResource PropertyImage = JSBundle.INSTANCE
            .PropertyImage();

    static  VerticalPanel draggablePanel = new VerticalPanel();
    static  HorizontalPanel droppablePanel = new HorizontalPanel();
    
    static Widget selectedWidget = new Widget();

    static String deletingWidgetId = "";
    static String widgetbeforeDeletingWidget ="";
    static String WidgetafterDeletingWdget = "";

    public static HashMap<Integer, String> WidgetMap = new HashMap<>();

    private Image callimage = new Image();
    private Image dropimage = new Image();
    private Image calltempimage = new Image();
    private Image logimage = new Image();
    private Image storeimage = new Image();
    private Image throttleimage = new Image();
    private Image sendimage = new Image();
    private Image payloadfactoryimage = new Image();
    private Image respondimage = new Image();
    private Image cloneimage = new Image();
    private Image propertyimage = new Image();        
RichTextArea textArea;
        private ESBEditorView view;
    @Inject
    public ESBEditorPresenter(ESBEditorView view) {
        this.view = view;
        this.view.setDelegate(this);
    }
    




    /** {@inheritDoc} */
    @Override
    public void go(AcceptsOneWidget container) {
        textArea.setSize("100%", "100%");
        

        
 
        DockLayoutPanel panel = new DockLayoutPanel(Style.Unit.PX);
        panel.setWidth("100%");
        panel.setHeight("100%");
        
        callimage.getElement().setId("callMediator");
        callimage.setResource(CallImage);
        callimage.addClickHandler(clickHandler);
        panel.add(callimage);
        
        Label myLabel = new Label();
        myLabel.setText("Sample GWT Label");
        
        panel.add(myLabel);
        panel.add(textArea);
 
        // Add the components to a panel
       // container.setWidget(panel);
        container.setWidget(myLabel);

    }

   


    @Override
    protected void initializeEditor() {
        //create editor
        textArea = new RichTextArea();
 
        //use or load content of the file
        if(input.getFile().getContent() == null){
            input.getFile().getProject().getContent(input.getFile(), new AsyncCallback<File>() {
                @Override
                public void onFailure(Throwable caught) {
                    //Log.error(WysiwygEditor.class, caught);
                }
 
                @Override
                public void onSuccess(File result) {
                    textArea.setHTML(input.getFile().getContent());
                }
            });
        }
        else{
           textArea.setHTML(input.getFile().getContent());
        }

        
    }
    
     public static final ClickHandler clickHandler = new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            event.preventDefault();
            selectedWidget = (Widget) event.getSource();
           // myecho(selectedWidget.getElement().getId());

        }
    };

    public static native void gwtjsPlumbDemo(String prevElem, String currElem,
                                             int ElemCount) /*-{
        //var countElem =this.@com.wso2.jsplumb.client.NoInsertAtEndIndexedDropController::ElementCount;
        //$wnd.alert(prevElem);
        //$wnd.alert(currElem);
        if (ElemCount > 1) {
            $wnd.gwtjsplumbdemo(prevElem, currElem);
        }
    }-*/;

    public static native void myecho(String selectedWid) /*-{
        $wnd.alert(selectedWid);
        //$wnd.alert(currElem);

    }-*/;





    @Override
    public void minimize() {
        // TODO Auto-generated method stub
        
    }





    @Override
    public void activate() {
        // TODO Auto-generated method stub
        
    }





    @Override
    public void doSave() {
        // TODO Auto-generated method stub
        
    }





    @Override
    public void doSaveAs() {
        // TODO Auto-generated method stub
        
    }





    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return null;
    }





    @Override
    public ImageResource getTitleImage() {
        // TODO Auto-generated method stub
        return null;
    }





    @Override
    public String getTitleToolTip() {
        // TODO Auto-generated method stub
        return null;
    }
}
