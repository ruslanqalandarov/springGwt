/*
package uz.murad.gwt.mumar.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import uz.murad.gwt.mumar.client.dto.AddressTO;

import java.util.Arrays;
import java.util.List;


*/
/**
 * User: User
 * Date: 07.12.2017 19:32
 *//*

public class Mumar implements EntryPoint {
    
    private HTMLPanel mainPanel;
    private VerticalPanel vPanel;

    private static final List<AddressTO> ADDRESS = Arrays.asList(
            new AddressTO("123", "Lloyds Road", "Middlesex", "TE0 6NB", "United Kingdom"),
            new AddressTO("456", "Oxford Street", "Oxford", "LK9 0CV", "United Kingdom"));


    public void onModuleLoad() {
        DataGrid<AddressTO> table = new DataGrid<AddressTO>();
        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        HTML htmlElement = new HTML("<h1>Bu endi Ruslanning projecti</h1>");
        mainPanel = new HTMLPanel("");
        mainPanel.add(htmlElement);
        this.initTableColumns(table);

        final SingleSelectionModel<AddressTO> selectionModel = new SingleSelectionModel<AddressTO>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            public void onSelectionChange(SelectionChangeEvent event) {
                AddressTO selected = selectionModel.getSelectedObject();
                if (selected != null) {
                    Window.alert("You selected: " + selected.getHouseNumber() + " " + selected.getStreetName() + " " +
                            selected.getCounty() + " " + selected.getPostCode() + " " + selected.getCountry());
                }
            }
        });
        table.setRowCount(ADDRESS.size(), true);
        table.setRowData(0, ADDRESS);
        table.setWidth("100%");
        SimpleLayoutPanel slp = new SimpleLayoutPanel();
        slp.add(table);
        RootLayoutPanel.get().add(slp);
        RootPanel.get("ruslanbek").add(mainPanel);
    }

    private void initTableColumns(DataGrid<AddressTO> table) {
        TextColumn<AddressTO> action = new TextColumn<AddressTO>() {
            @Override
            public String getValue(AddressTO object) {
                return "Ruslan";
            }

        };
        table.addColumn(action, "Action");
        table.addCellPreviewHandler(new CellPreviewEvent.Handler<AddressTO>() {

            @Override
            public void onCellPreview(CellPreviewEvent<AddressTO> event) {
                if (event.getNativeEvent().getButton() == NativeEvent.BUTTON_RIGHT) {
                    event.getNativeEvent().stopPropagation();
                    // do something instead with myObject (event.getValue()) or
                    // with this row (event.getIndex())
                }
            }

        });
        TextColumn<AddressTO> houseNumber = new TextColumn<AddressTO>() {
            @Override
            public String getValue(AddressTO object) {
                return object.getHouseNumber();
            }

        };
        table.addColumn(houseNumber, "House Number");

        TextColumn<AddressTO> streetName = new TextColumn<AddressTO>() {
            @Override
            public String getValue(AddressTO object) {
                return object.getStreetName();
            }
        };
        table.addColumn(streetName, "Street Name");

        TextColumn<AddressTO> county = new TextColumn<AddressTO>() {
            @Override
            public String getValue(AddressTO object) {
                return object.getCounty();
            }
        };
        table.addColumn(county, "County");

        TextColumn<AddressTO> postCode = new TextColumn<AddressTO>() {
            @Override
            public String getValue(AddressTO object) {
                return object.getPostCode();
            }
        };
        table.addColumn(postCode, "Post Code");

        TextColumn<AddressTO> country = new TextColumn<AddressTO>() {
            @Override
            public String getValue(AddressTO object) {
                return object.getCounty();
            }
        };
        table.addColumn(country, "Country");
    }
}*/
