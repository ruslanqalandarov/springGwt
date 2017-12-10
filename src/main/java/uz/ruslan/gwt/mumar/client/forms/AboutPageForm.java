package uz.ruslan.gwt.mumar.client.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * User: User
 * Date: 10.12.2017 12:35
 */
public class AboutPageForm extends Composite {
    interface AboutPageFormUiBinder extends UiBinder<HTMLPanel, AboutPageForm> {
    }

    private static AboutPageFormUiBinder ourUiBinder = GWT.create(AboutPageFormUiBinder.class);

    @UiField
    Button backButton;
    @UiField
    TextBox headText;
    @UiField
    Anchor saveAnchor;
    @UiField
    TextArea myTextArea;

    public AboutPageForm() {
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
    }


    private class BackButtonHandler implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            History.back();
        }
    }
}
