package uz.ruslan.gwt.mumar.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.*;
import uz.ruslan.gwt.mumar.client.events.MenuChangeEvent;
import uz.ruslan.gwt.mumar.client.events.MenuChangeEventHandler;
import uz.ruslan.gwt.mumar.client.views.*;

import java.util.HashMap;
import java.util.Map;

/**
 * User: User
 * Date: 08.12.2017 15:53
 */
public class Mumar implements EntryPoint {
    private FlowPanel mainPanel;
    private FlowPanel contentPanel;
    private HorizontalPanel menuPanel;

    private Anchor mainPageAnchor;
    private Anchor userPageAnchor;
    private Anchor aboutPageAnchor;
    private Anchor walletPageAnchor;
    private Anchor orderPageAnchor;

    public static EventBus EVENT_BUS = GWT.create(SimpleEventBus.class);


    private Map<String, View> viewMap = new HashMap<String, View>();

    @Override
    public void onModuleLoad() {
        mainPanel = new FlowPanel();
        contentPanel = new FlowPanel();
        menuPanel = new HorizontalPanel();

        mainPageAnchor = new Anchor("Главная");
        userPageAnchor = new Anchor("Пользователи");
        aboutPageAnchor = new Anchor("О нас");
        walletPageAnchor = new Anchor("О кошельке");
        orderPageAnchor = new Anchor("О заказе");



        menuPanel.add(this.getPanel(mainPageAnchor));
        menuPanel.add(this.getPanel(userPageAnchor));
        menuPanel.add(this.getPanel(aboutPageAnchor));
        menuPanel.add(this.getPanel(orderPageAnchor));
        menuPanel.add(this.getPanel(walletPageAnchor));

        mainPanel.add(menuPanel);
        mainPanel.add(contentPanel);

        viewMap.put("main", new MainPageView());
        viewMap.put("users", new UserPageView());
        viewMap.put("about", new AboutPageView());
        viewMap.put("order", new OrderPageView());
        viewMap.put("wallet", new WalletPageView());

        contentPanel.add(this.getPanel(viewMap.get("main").onInitialize()));
        this.registerEventHadlers();
        RootPanel.get("ruslanbek").add(mainPanel);
    }

    private FlowPanel getPanel(Widget widget) {
        FlowPanel mainPageAnchorPanel = new FlowPanel();

        mainPageAnchorPanel.add(widget);
        mainPageAnchorPanel.getElement().getStyle().setMargin(100d , Style.Unit.PX);
        return mainPageAnchorPanel;
    }



    private void registerEventHadlers() {
        mainPageAnchor.addClickHandler(this.getClickHistoryHandler("main"));
        userPageAnchor.addClickHandler(this.getClickHistoryHandler("users"));
        aboutPageAnchor.addClickHandler(this.getClickHistoryHandler("about"));
        orderPageAnchor.addClickHandler(this.getClickHistoryHandler("order"));
        walletPageAnchor.addClickHandler(this.getClickHistoryHandler("wallet"));

        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            public void onValueChange(ValueChangeEvent<String> event) {
                String historyToken = event.getValue();
                contentPanel.clear();

                if (historyToken == null || historyToken.isEmpty()) {
                    View view = viewMap.get("main");

                    if (view != null) {
                        contentPanel.add(view.onInitialize());
                    }
                    return;
                }
                View view = viewMap.get(historyToken);

                if (view != null) {
                    contentPanel.add(view.onInitialize());
                } else {
                    view = viewMap.get("main");
                    if (view != null) {
                        contentPanel.add(view.onInitialize());
                    }
                }
            }
        });

        EVENT_BUS.addHandler(MenuChangeEvent.TYPE, new MenuChangeEventHandler() {
            @Override
            public void onMenuChange(MenuChangeEvent event) {
                mainPageAnchor.setHTML(event.getMenuName());
            }
        });
    }

    private ClickHandler getClickHistoryHandler(final String historyToken) {
        return new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                History.newItem(historyToken);
            }
        };
    }
}
