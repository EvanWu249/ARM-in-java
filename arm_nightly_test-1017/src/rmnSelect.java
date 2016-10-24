import java.util.ArrayList;


public class rmnSelect {
	/*
	 * Made by Hsin Han Wu
	 * This file is for RMN selection
	 */
	
	// Create elements
	int _RanSel;// integer for random
	int CurIndex = 0;
	// Note: let's suppose that node:rmn = 6:4
	int _RmnNumber = (int)Math.floor(CurIndex*0.4);
	ArrayList<String> RmnList = new ArrayList<String>();// List of RMNs
	// ArrayList<String> (RMN's No.)_NNL = new ArayList<String>();
	
	public rmnSelect(){
		while(CurIndex<=_RmnNumber){
			SelRmn();
		}
	}
	
	// randomly select nodes as RMN
	public void SelRmn(){
		_RanSel = (int)(Math.random()*100)+1;
		while(RmnList.contains(String.valueOf(_RanSel))){
			// loops when node is already exists
			_RanSel = (int)(Math.random()*100)+1;
		}
		// Store into arraylist
		CurIndex++;
		RmnList.add(String.valueOf(_RanSel));// node's index number
		System.out.println("RMN Selected: "+_RanSel);
	}
	
	// RMN handles a NNL, which needs to create NNL
	public void generateNNL(){
		
	}
	
	// returns the number of rmns selected
	public int getRmnNum(){
		return _RmnNumber;
	}// end og getRmnNum
}
