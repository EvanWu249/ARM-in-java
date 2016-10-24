import java.util.*;

public class field_test {
	/*
	 * Made by Hsin Han Wu
	 * This file is for creating a field and generate nodes for further use.
	 */
	
	// Creating elements
	ArrayList<String> nodePosX = new ArrayList<String>();// for nodes' coordinate X
	ArrayList<String> nodePosY = new ArrayList<String>();// for nodes' coordinate Y
	int nodeCurNumX = 0, nodeCurNumY = 0, CurIndex = 0;;
	Random ran = new Random();
	
	// Simulates a field
	public field_test(int NumOfNodes){
		
		// generate 100 nodes
		while(CurIndex<NumOfNodes){
			generateNodes();
		}
	}// end of field_test
	
	// Generating nodes by random
	public void generateNodes(){
		try{
			// will generate numbers between 1 to 100
			int _x = (int)(ran.nextInt(100))+1;
			int _y = (int)(ran.nextInt(100))+1;
			// Check if coordinates are already filled with a node
			ChkAvail(_x, _y);
			// add new node's coordinate into arraylist
			nodePosX.add(String.valueOf(_x));
			nodePosY.add(String.valueOf(_y));
			CurIndex++; // Index will be added after generating a new node
			System.out.printf("New Node: "+CurIndex+" ("+_x+","+_y+")\n");
			
		}catch(Exception ex){
			System.out.println("Exception caught at generateNodes.");
			System.exit(0);
		}
		
	}// end of generateNodes()
	
	// check availability
	public void ChkAvail(int x, int y){
		for(int i=0;i<CurIndex-1;i++){
			if(nodePosX.get(i).equals(String.valueOf(x))){
				// found same X, continue on Y
				if(nodePosY.get(i).equals(String.valueOf(y))){
					// found same X and Y, return true for if-loop to run
					generateNodes();
				}
			}// end if
		}// end for-loop
	}// end of ChkAvail
	
	// returns array list of nodes' X
	public ArrayList<String> getNodePosX(){
		return nodePosX;
	}// end of getNodePosX
	
	//returns array list of nodes' Y
	public ArrayList<String> getNodePosY(){
		return nodePosY;
	}// end of getNodePosY
}
