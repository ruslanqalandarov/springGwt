package uz.ruslan.gwt.mumar.client.views;

import com.google.gwt.user.client.ui.Widget;
import uz.ruslan.gwt.mumar.client.forms.MainPageForm;

/**
 * User: User
 * Date: 08.12.2017 15:58
 */
public class MainPageView extends View {
    private MainPageForm pageForm;

    public MainPageView() {
        pageForm = new MainPageForm();
    }

    @Override
    public Widget onInitialize() {
        return pageForm;
    }
}