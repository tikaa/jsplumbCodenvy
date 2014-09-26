package com.codenvy.ide.client.Editor;

import java.util.HashMap;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.codenvy.ide.api.editor.AbstractEditorPresenter;
import com.codenvy.ide.client.inject.JSBundle;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.*;
import com.codenvy.ide.api.resources.model.File;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ESBEditor extends AbstractEditorPresenter 
{
    
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
    
    static  VerticalPanel backgroundPanel;
    public static DockLayoutPanel dockPanel ;

    static  VerticalPanel draggablePanel = new VerticalPanel();
    static  HorizontalPanel droppablePanel = new HorizontalPanel();
    static RootPanel rootPanel;
    
    static Widget selectedWidget = new Widget();

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
    
    public ESBEditor(){  
    
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

    @Override
    public void go(AcceptsOneWidget container) {

        dockPanel = new DockLayoutPanel(Style.Unit.PX);
        dockPanel.setWidth("100%"); //set full width and height for the main dock panel
        dockPanel.setHeight("100%");
        
        draggablePanel.getElement().setId("draggablePanel");
        droppablePanel.getElement().setId("droppablePanel");

        draggablePanel.getElement().setClassName("window");
        droppablePanel.getElement().setClassName("window");
        droppablePanel.setPixelSize(1350, 1000); // numerical values needs to be alrtered to a dynamic value after testing
        droppablePanel.getElement().getStyle().setProperty("position", "relative");
        draggablePanel.getElement().getStyle().setProperty("position", "relative");

        callimage.getElement().setId("callMediator");
        callimage.setResource(CallImage);
        callimage.addClickHandler(clickHandler);
        draggablePanel.add(callimage);

        dropimage.getElement().setId("dropMediator");
        dropimage.setResource(DropImage);
        dropimage.addClickHandler(clickHandler);
        draggablePanel.add(dropimage);

        calltempimage.getElement().setId("callTemplateMediator");
        calltempimage.setResource(CallTempImage);
        calltempimage.addClickHandler(clickHandler);
        draggablePanel.add(calltempimage);

        logimage.getElement().setId("logMediator");
        logimage.setResource(LogImage);
        logimage.addClickHandler(clickHandler);
        draggablePanel.add(logimage);

        storeimage.getElement().setId("storeMediator");
        storeimage.setResource(StoreImage);
        storeimage.addClickHandler(clickHandler);
        draggablePanel.add(storeimage);

        sendimage.getElement().setId("sendMediator");
        sendimage.setResource(SendImage);
        sendimage.addClickHandler(clickHandler);

        draggablePanel.add(sendimage);

        throttleimage.getElement().setId("throttleMediator");
        throttleimage.setResource(ThrottleImage);
        throttleimage.addClickHandler(clickHandler);

        draggablePanel.add(throttleimage);

        payloadfactoryimage.getElement().setId("paylfacMediator");
        payloadfactoryimage.setResource(PayloadFactoryImage);
        payloadfactoryimage.addClickHandler(clickHandler);

        draggablePanel.add(payloadfactoryimage);

        respondimage.getElement().setId("respondMediator");
        respondimage.setResource(RespondImage);
        respondimage.addClickHandler(clickHandler);

        draggablePanel.add(respondimage);

        cloneimage.getElement().setId("cloneMediator");
        cloneimage.setResource(CloneImage);
        cloneimage.addClickHandler(clickHandler);
        draggablePanel.add(cloneimage);
        

        propertyimage.getElement().setId("propertyMediator");
        propertyimage.setResource(PropertyImage);
        propertyimage.addClickHandler(clickHandler);
        draggablePanel.add(propertyimage);
        


        dockPanel.add(draggablePanel);
        dockPanel.add(droppablePanel);
        
        RootPanel.get().add(dockPanel);
        dockPanel.setPixelSize(1600, 1600); //numerical values- needs to be changed after testing
        container.setWidget(dockPanel);
        
    }

    @Override
    protected void initializeEditor() {
      backgroundPanel = new VerticalPanel();

        //use or load content of the file
        if(input.getFile().getContent() == null){
            input.getFile().getProject().getContent(input.getFile(), new AsyncCallback<File>() {
                @Override
                public void onFailure(Throwable caught) {
                    
                }

                @Override
                public void onSuccess(File result) {
                   backgroundPanel.add(rootPanel);
                }
            });
        }
        else{
           
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