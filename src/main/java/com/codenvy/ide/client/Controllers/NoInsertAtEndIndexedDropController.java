package com.codenvy.ide.client.Controllers;

import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.codenvy.ide.client.inject.JSBundle;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import  com.codenvy.ide.client.Editor.ESBEditor;


import com.allen_sauer.gwt.dnd.client.DragContext;

/**
 * Created by root on 9/10/14.*/
public class NoInsertAtEndIndexedDropController extends SimpleDropController {

    private Widget dropTarget;
    private EntryPoint mainEntryPOint;

    static MouseMoveEvent mouseEvent;
    static int mouseX =0;
    static int mouseY=0;
    // DroppableOptions options = new DroppableOptions();

    // String id1 = null;
    // String id2 = null;

    private ImageResource DropCallImage = JSBundle.INSTANCE.CallImage();
    private ImageResource DropCallTempImage = JSBundle.INSTANCE
            .CalleTempImage();
    private ImageResource DropLogImage = JSBundle.INSTANCE.LogImage();
    private ImageResource DropDropImage = JSBundle.INSTANCE.DropImage();
    private ImageResource DropStoreImage = JSBundle.INSTANCE.StoreImage();
    private ImageResource DropThrottleImage = JSBundle.INSTANCE
            .ThrottleImage();
    private ImageResource DropSendImage = JSBundle.INSTANCE.SendImage();
    private ImageResource DropPayloadFactoryImage = JSBundle.INSTANCE
            .PayloadFactoryImage();
    private ImageResource DropRespondImage = JSBundle.INSTANCE
            .RespondImage();
    private ImageResource DropCloneImage = JSBundle.INSTANCE.CloneImage();
    private ImageResource DropPropertyImage = JSBundle.INSTANCE
            .PropertyImage();

    int ElementCount = 0;
    int x = 50;
    int y = 200;



    public NoInsertAtEndIndexedDropController(HorizontalPanel dropTarget) {
        super(dropTarget);
        this.dropTarget = dropTarget;
        // this.mainEntryPOint = newEntrypoint;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onDrop(DragContext context) {
        ElementCount++;
        x = x + 100;
        for (Widget widget : context.selectedWidgets) {
            //SimplePanel newDroppedPanel = new SimplePanel();
            Image newDroppedElem = new Image();
            newDroppedElem.getElement().setId("dragged" + ElementCount);
            newDroppedElem.getElement().setPropertyBoolean("draggable", false);
            newDroppedElem.addClickHandler(ESBEditor.clickHandler);
            //newDroppedElem.si//addKeyDownHandler(Gwtjsplumbtest.keyDownHandler);
            widget.removeStyleName("gwt-Image dragdrop-draggable dragdrop-handle dragdrop-dragging");
            widget.addStyleName("gwt-Image dragdrop-draggable dragdrop-handle");
            RootPanel.get("window1").add(widget);
            RootPanel.get("window2").remove(widget);

            String thisId = widget.getElement().getId();

            if (thisId.equalsIgnoreCase("callMediator")) {
                newDroppedElem.setResource(DropCallImage);
            }
            if (thisId.equalsIgnoreCase("callTemplateMediator")) {
                newDroppedElem.setResource(DropCallTempImage);
            }
            if (thisId.equalsIgnoreCase("logMediator")) {
                newDroppedElem.setResource(DropLogImage);
            }
            if (thisId.equalsIgnoreCase("dropMediator")) {
                newDroppedElem.setResource(DropDropImage);
            }
            if (thisId.equalsIgnoreCase("storeMediator")) {
                newDroppedElem.setResource(DropStoreImage);
            }
            if (thisId.equalsIgnoreCase("sendMediator")) {
                newDroppedElem.setResource(DropSendImage);
            }
            if (thisId.equalsIgnoreCase("cloneMediator")) {
                newDroppedElem.setResource(DropCloneImage);
            }
            if (thisId.equalsIgnoreCase("throttleMediator")) {
                newDroppedElem.setResource(DropThrottleImage);
            }
            if (thisId.equalsIgnoreCase("respondMediator")) {
                newDroppedElem.setResource(DropRespondImage);
            }
            if (thisId.equalsIgnoreCase("propertyMediator")) {
                newDroppedElem.setResource(DropPropertyImage);
            }
            if (thisId.equalsIgnoreCase("paylfacMediator")) {
                newDroppedElem.setResource(DropPayloadFactoryImage);
            }

            //ESBEditor.WidgetMap.put(ElementCount, newDroppedElem.getElement().getId());
            RootPanel.get("window2").add(newDroppedElem);
            RootPanel.get("window2").setWidgetPosition(newDroppedElem, x, y);
            newDroppedElem = null;
            RootPanel.get("window2").getAbsoluteLeft();

        }
        //setMouseEvent(null);
         /*
        int PrevCount = ElementCount - 1;
        String prevElem = "dragged" + PrevCount;
        String currElem = "dragged" + ElementCount;
        //ESBEditor.gwtjsPlumbDemo(prevElem, currElem, ElementCount);*/
        super.onDrop(context);

    }

 /*
  * public String idval(String i){
  *
  * return "dragged"+i; }
 */

    @Override
    public void onEnter(DragContext context) {
        super.onEnter(context);
        for (Widget widget : context.selectedWidgets) {
            // widget.addStyleName(CSS_DEMO_BIN_DRAGGABLE_ENGAGE);
        }
        // bin.setEngaged(true);
    }

    @Override
    public void onLeave(DragContext context) {
        for (Widget widget : context.selectedWidgets) {
            // widget.removeStyleName(CSS_DEMO_BIN_DRAGGABLE_ENGAGE);
        }
        // bin.setEngaged(false);
        super.onLeave(context);

    }

    public static void setMouseEvent(MouseMoveEvent e){
        mouseEvent = e;
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();

    }

    // var val1 =
    // this.@com.wso2.jsplumb.client.NoInsertAtEndIndexedDropController::idval(Ljava/lang/String;)(a);
    // var val2 =
    // this.@com.wso2.jsplumb.client.NoInsertAtEndIndexedDropController::idval(Ljava/lang/String;)(b);

}
