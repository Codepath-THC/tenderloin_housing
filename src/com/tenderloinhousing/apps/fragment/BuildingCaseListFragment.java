package com.tenderloinhousing.apps.fragment;

import android.os.Bundle;

import com.parse.FindCallback;
import com.tenderloinhousing.apps.dao.ParseDAO;
import com.tenderloinhousing.apps.model.Building;
import com.tenderloinhousing.apps.model.Case;

public class BuildingCaseListFragment extends CaseListBaseFragment
{
   
   @Override
    public void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);	
	
    }  

    @Override
    public void loadCases(FindCallback<Case> callback)
    {
	ParseDAO.getCaseByBuilding(getBuilding(), callback);
    }

    private Building getBuilding()
    {
	return (Building) getArguments().getSerializable(BUILDING_OBJ_KEY);
    }
    public static BuildingCaseListFragment newInstance(Building building)
    {
	BuildingCaseListFragment fragment = new BuildingCaseListFragment();
	Bundle bundle = new Bundle();
	bundle.putSerializable(BUILDING_OBJ_KEY, building);
	fragment.setArguments(bundle);

	return fragment;
    }
 
}