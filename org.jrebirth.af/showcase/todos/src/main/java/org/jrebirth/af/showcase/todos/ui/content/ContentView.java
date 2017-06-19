package org.jrebirth.af.showcase.todos.ui.content;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.BorderPane;

import org.jrebirth.af.core.ui.DefaultView;

import bean.Todo;

public class ContentView extends DefaultView<ContentModel, BorderPane, ContentController> {

    private static final String DONE_COLUMN = "DoneColumn";

    private static final String TEXT_COLUMN = "TextColumn";

    private TableView<Todo> table;

    public ContentView(final ContentModel model) {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void initView() {
        super.initView();

        this.table = new TableView<>();

        final TableColumn<Todo, Boolean> doneColumn = new TableColumn<>("Done");
        doneColumn.setId(DONE_COLUMN);
        doneColumn.setMaxWidth(40);
        doneColumn.setMinWidth(40);
        doneColumn.setCellValueFactory(cdf -> cdf.getValue().pDone());
        doneColumn.setCellFactory(tc -> new CheckBoxTableCell<>());

        final TableColumn<Todo, String> textColumn = new TableColumn<>("Text");
        textColumn.setId(TEXT_COLUMN);
        textColumn.setPrefWidth(200);
        textColumn.setMinWidth(100);
        textColumn.setCellValueFactory(this::getColumnContent);
        // sourceVersionColumn.setCellFactory(this::getTableCell);

        this.table.getColumns().setAll(doneColumn, textColumn);

        this.table.setPrefWidth(450);

        this.table.setPrefHeight(300);

        this.table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.table.setEditable(true);

        node().setCenter(this.table);
    }

    private ObservableValue<String> getColumnContent(final CellDataFeatures<Todo, String> cell) {
        String res = null;

        switch (cell.getTableColumn().getId()) {
            case DONE_COLUMN:
                res = "";// cell.getValue().done();
                break;
            case TEXT_COLUMN:
                res = cell.getValue().text();
                break;
        }
        return new SimpleStringProperty(res);
    }

    public TableView<Todo> getTable() {
        return this.table;
    }

}
