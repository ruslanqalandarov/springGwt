package uz.ruslan.gwt.mumar.client.views;

import com.google.gwt.user.client.ui.Widget;
import uz.ruslan.gwt.mumar.client.forms.AboutPageForm;

/**
 * User: User
 * Date: 08.12.2017 15:58
 */
public class AboutPageView extends View {
    private AboutPageForm pageForm;

    public AboutPageView() {
        pageForm = new AboutPageForm();
    }

    @Override
    public Widget onInitialize() {
        return pageForm;
    }
}