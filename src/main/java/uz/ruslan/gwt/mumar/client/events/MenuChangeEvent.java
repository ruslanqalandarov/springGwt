package uz.ruslan.gwt.mumar.client.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * User: User
 * Date: 10.12.2017 12:58
 */
public class MenuChangeEvent extends GwtEvent<MenuChangeEventHandler> {
    private final String menuName;
    public static Type<MenuChangeEventHandler> TYPE = new Type<MenuChangeEventHandler>();

    public MenuChangeEvent(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public Type<MenuChangeEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(MenuChangeEventHandler handler) {
        handler.onMenuChange(this);
    }
}
