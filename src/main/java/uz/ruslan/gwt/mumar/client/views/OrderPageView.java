package uz.ruslan.gwt.mumar.client.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * User: User
 * Date: 08.12.2017 16:50
 */
public class OrderPageView extends View  {
    private FlowPanel mainPanel;

    public OrderPageView() {
        mainPanel = new FlowPanel();
        Button myButtonR = new Button("Это страница о заказе");
        myButtonR.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {

                Window.alert("Это страница о заказе");
            }


        } );
        mainPanel.add(myButtonR);
    }
    @Override
    public Widget onInitialize() {
        return mainPanel;
    }
}
