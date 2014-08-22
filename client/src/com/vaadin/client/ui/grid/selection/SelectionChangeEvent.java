/*
 * Copyright 2000-2014 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.client.ui.grid.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.vaadin.client.ui.grid.Grid;

/**
 * Event object describing a change in Grid row selection state.
 * 
 * @since
 * @author Vaadin Ltd
 */
@SuppressWarnings("rawtypes")
public class SelectionChangeEvent<T> extends GwtEvent<SelectionChangeHandler> {

    private static final Type<SelectionChangeHandler> eventType = new Type<SelectionChangeHandler>();

    private final Grid<T> grid;
    private final List<T> added;
    private final List<T> removed;
    private final boolean batched;

    /**
     * Creates an event with a single added or removed row.
     * 
     * @param grid
     *            grid reference, used for getSource
     * @param added
     *            the added row, or <code>null</code> if a row was not added
     * @param removed
     *            the removed row, or <code>null</code> if a row was not removed
     * @param batched
     *            whether or not this selection change event is triggered during
     *            a batched selection/deselection action
     * @see SelectionModel.Multi.Batched
     */
    public SelectionChangeEvent(Grid<T> grid, T added, T removed,
            boolean batched) {
        this.grid = grid;
        this.batched = batched;

        if (added != null) {
            this.added = Collections.singletonList(added);
        } else {
            this.added = Collections.emptyList();
        }

        if (removed != null) {
            this.removed = Collections.singletonList(removed);
        } else {
            this.removed = Collections.emptyList();
        }
    }

    /**
     * Creates an event where several rows have been added or removed.
     * 
     * @param grid
     *            Grid reference, used for getSource
     * @param added
     *            a collection of added rows, or <code>null</code> if no rows
     *            were added
     * @param removed
     *            a collection of removed rows, or <code>null</code> if no rows
     *            were removed
     * @param batched
     *            whether or not this selection change event is triggered during
     *            a batched selection/deselection action
     * @see SelectionModel.Multi.Batched
     */
    public SelectionChangeEvent(Grid<T> grid, Collection<T> added,
            Collection<T> removed, boolean batched) {
        this.grid = grid;
        this.batched = batched;

        if (added != null) {
            this.added = new ArrayList<T>(added);
        } else {
            this.added = Collections.emptyList();
        }

        if (removed != null) {
            this.removed = new ArrayList<T>(removed);
        } else {
            this.removed = Collections.emptyList();
        }
    }

    /**
     * Get a reference to the Grid object that fired this event.
     * 
     * @return a grid reference
     */
    @Override
    public Grid<T> getSource() {
        return grid;
    }

    /**
     * Get all rows added to the selection since the last
     * {@link SelectionChangeEvent}.
     * 
     * @return a collection of added rows. Empty collection if no rows were
     *         added.
     */
    public Collection<T> getAdded() {
        return Collections.unmodifiableCollection(added);
    }

    /**
     * Get all rows removed from the selection since the last
     * {@link SelectionChangeEvent}.
     * 
     * @return a collection of removed rows. Empty collection if no rows were
     *         removed.
     */
    public Collection<T> getRemoved() {
        return Collections.unmodifiableCollection(removed);
    }

    /**
     * Gets a type identifier for this event.
     * 
     * @return a {@link Type} identifier.
     */
    public static Type<SelectionChangeHandler> getType() {
        return eventType;
    }

    @Override
    public Type<SelectionChangeHandler> getAssociatedType() {
        return eventType;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void dispatch(SelectionChangeHandler handler) {
        handler.onSelectionChange(this);
    }

    /**
     * Checks if this selection change event is fired during a batched
     * selection/deselection operation.
     * 
     * @return <code>true</code> iff this event is fired during a batched
     *         selection/deselection operation
     */
    public boolean isBatchedSelection() {
        return batched;
    }
}
