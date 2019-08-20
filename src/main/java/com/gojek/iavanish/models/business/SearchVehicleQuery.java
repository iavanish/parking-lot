package com.gojek.iavanish.models.business;

import com.gojek.iavanish.models.business.validations.SearchVehicleFields;

import java.util.Map;
import java.util.Set;

/**
 * Created by iavanish on 2019-08-20
 */
public class SearchVehicleQuery {

    private Map<SearchVehicleFields, Set<String>> searchVehicleFields;

    public SearchVehicleQuery(Map<SearchVehicleFields, Set<String>> searchVehicleFields) {
        this.searchVehicleFields = searchVehicleFields;
    }

    public Map<SearchVehicleFields, Set<String>> getSearchVehicleFields() {
        return searchVehicleFields;
    }

    public void setSearchVehicleFields(Map<SearchVehicleFields, Set<String>> searchVehicleFields) {
        this.searchVehicleFields = searchVehicleFields;
    }

}
