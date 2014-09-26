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

    static  VerticalPanel window1   = new VerticalPanel();
    static  HorizontalPanel window2 = new HorizontalPanel();
    
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
        
        DockLayoutPanel panel = new DockLayoutPanel(Style.Unit.PX);
        panel.setWidth("100%");
        panel.setHeight("100%");
        
        panel.add(textArea);

       window1.getElement().setId("window1");
        window2.getElement().setId("window2");

        window1.getElement().setClassName("window");
        window2.getElement().setClassName("window");
        window2.setPixelSize(1350, 1000);
        window2.getElement().getStyle().setProperty("position", "relative");
        window1.getElement().getStyle().setProperty("position", "relative");

        callimage.getElement().setId("callMediator");
        callimage.setResource(CallImage);
        callimage.addClickHandler(clickHandler);
        window1.add(callimage);

        dropimage.getElement().setId("dropMediator");
        dropimage.setResource(DropImage);
        dropimage.addClickHandler(clickHandler);
        window1.add(dropimage);

        calltempimage.getElement().setId("callTemplateMediator");
        calltempimage.setResource(CallTempImage);
        calltempimage.addClickHandler(clickHandler);
        window1.add(calltempimage);

        logimage.getElement().setId("logMediator");
        logimage.setResource(LogImage);
        logimage.addClickHandler(clickHandler);
        window1.add(logimage);

        storeimage.getElement().setId("storeMediator");
        storeimage.setResource(StoreImage);
        storeimage.addClickHandler(clickHandler);
        window1.add(storeimage);

        sendimage.getElement().setId("sendMediator");
        sendimage.setResource(SendImage);
        sendimage.addClickHandler(clickHandler);
        //sendimage.addAttachHandler( (Handler) keyPressHandler);
        window1.add(sendimage);

        throttleimage.getElement().setId("throttleMediator");
        throttleimage.setResource(ThrottleImage);
        throttleimage.addClickHandler(clickHandler);
        //throttleimage.addAttachHandler( (Handler) keyPressHandler);
        window1.add(throttleimage);

        payloadfactoryimage.getElement().setId("paylfacMediator");
        payloadfactoryimage.setResource(PayloadFactoryImage);
        payloadfactoryimage.addClickHandler(clickHandler);
        //payloadfactoryimage.addAttachHandler( (Handler) keyPressHandler);
        window1.add(payloadfactoryimage);

        respondimage.getElement().setId("respondMediator");
        respondimage.setResource(RespondImage);
        respondimage.addClickHandler(clickHandler);
        //respondimage.addAttachHandler( (Handler) keyPressHandler);
        window1.add(respondimage);

        cloneimage.getElement().setId("cloneMediator");
        cloneimage.setResource(CloneImage);
        cloneimage.addClickHandler(clickHandler);
        window1.add(cloneimage);
        
        //window2.addKeyDownHandler(handler);
        propertyimage.getElement().setId("propertyMediator");
        propertyimage.setResource(PropertyImage);
        propertyimage.addClickHandler(clickHandler);
        window1.add(propertyimage);

        panel.add(window1);
        panel.add(window2);

        panel.setPixelSize(1600, 1600);
        
        container.setWidget(panel);
        //container.setWidget(window2);
    }

    @Override
    public String getTitleToolTip() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void minimize() {
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
}
