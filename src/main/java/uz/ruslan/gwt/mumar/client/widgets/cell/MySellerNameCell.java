package uz.ruslan.gwt.mumar.client.widgets.cell;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * User: User
 * Date: 08.12.2017 15:38
 */
public class MySellerNameCell<T> extends AbstractCell<T> {

    public MySellerNameCell() {
        super("click", "keydown");
    }

    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context, T value, SafeHtmlBuilder sb) {
        if (value != null) {
            sb.appendHtmlConstant("<a href='javascript:;'>");
//            sb.appendEscaped();
            sb.appendHtmlConstant("</a>");
        }
    }

    @Override
    public void onBrowserEvent(Context context, Element parent, T value, NativeEvent event, ValueUpdater<T> valueUpdater) {
        if (value == null)
            return;

        super.onBrowserEvent(context, parent, value, event, valueUpdater);
        if ("click".equals(event.getType())) {
            // TODO: 08.12.2017 logic here
        }
    }
}