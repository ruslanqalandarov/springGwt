package uz.ruslan.gwt.mumar.client.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import uz.ruslan.gwt.mumar.client.Mumar;
import uz.ruslan.gwt.mumar.client.events.MenuChangeEvent;

/**
 * User: User
 * Date: 10.12.2017 12:04
 */
public class MainPageForm extends Composite {
    interface MainPageFormUiBinder extends UiBinder<HTMLPanel, MainPageForm> {
    }

    private static MainPageFormUiBinder ourUiBinder = GWT.create(MainPageFormUiBinder.class);

    @UiField
    Button backButton;
    @UiField
    TextBox headText;
    @UiField
    Anchor saveAnchor;
    @UiField
    TextArea myTextArea;
    @UiField
    Button changeMenuButton;

    public MainPageForm() {
        this.initWidget(ourUiBinder.createAndBindUi(this));
        this.registerEventHandler();
    }

    private void registerEventHandler() {
        backButton.addClickHandler(new BackButtonHandler());

        saveAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String headTextValue = headText.getValue();

                Window.alert("Head text: " + headTextValue + "\n TextArea Value: " + myTextArea.getValue());
            }
        });

        changeMenuButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                final String value = headText.getValue();

                if (value == null || value.isEmpty()) {
                    Window.alert("Please fill data");
                    headText.getElement().getStyle().setBorderColor("red");
                    return;
                } else {
                    headText.getElement().getStyle().setBorderColor(null);
                }
                Mumar.EVENT_BUS.fireEvent(new MenuChangeEvent(value));
            }
        });
    }


    private class BackButtonHandler implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            History.back();
        }
    }
}
