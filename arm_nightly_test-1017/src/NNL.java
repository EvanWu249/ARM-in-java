import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class NNL {
	/*
	 * Made by Hsin Han Wu
	 * This file is for nodes to create NNL, update NNL, and control TTL(in every _ seconds)
	 */
	
	// create elements
	// collects every node's NNL into a big array list
	ArrayList<String> _allNNL = new ArrayList<String>();
	
	public NNL(){
		
	}
	
	// calculates a node's neighbor nodes
	public void calculateNNL(ArrayList<String> _corX, ArrayList<String> _corY, int NumOfNodes){
		// Starts from 1 to 100
		try{
			for(int j = 0;j<NumOfNodes;j++){
				System.out.println("j is "+j);
				// save into an arraylist
				_allNNL.add(String.valueOf(j));
				_allNNL.add(fetchNei(_corX, _corY, _corX.get(j), _corY.get(j), NumOfNodes));
				System.out.println("found at "+j+"th node.");
			}// end for-loop
			
			File f = new File("testNNL.txt");
			FileWriter fw = new FileWriter(f);
			for(int j2 = 0;j2<NumOfNodes;j2++){
				
				fw.write(_allNNL.get(j2));
				fw.write(System.getProperty("line.separator"));
			}
			fw.close();
		}catch(Exception ex){
			System.out.println("Exception at calculateNNL: "+ex.getMessage());
		}
	}
	
	/*
	 *  Neighbor nodes are considered a max distance of 2 units,
	 *  which means that theoretically a node's(x,y) neighbor nodes are:
	 *  <From the view of X>
	 *  X+2: y
	 *  X+1: y+-1
	 *  X:   y+-2, y+-1
	 *  X-1: y+-1
	 *  X-2: y
	 */
	public String fetchNei(ArrayList<String> _corX, ArrayList<String> _corY, String _tarX, String _tarY, int NumOfNodes){
		// lookup
		String _neighbor = " ";
		System.out.println("into fetch");
		// Conversion ("a" is for addition, and "m" is for minus)
		String _tarX1a = String.valueOf(Integer.valueOf(_tarX)+1);
		String _tarX1m = String.valueOf(Integer.valueOf(_tarX)-1);
		String _tarX2a = String.valueOf(Integer.valueOf(_tarX)+2);
		String _tarX2m = String.valueOf(Integer.valueOf(_tarX)-2);
		
		String _tarY1a = String.valueOf(Integer.valueOf(_tarY)+1);
		String _tarY1m = String.valueOf(Integer.valueOf(_tarY)-1);
		String _tarY2a = String.valueOf(Integer.valueOf(_tarX)+2);
		String _tarY2m = String.valueOf(Integer.valueOf(_tarX)-2);
		System.out.println("nums = "+_tarX1a+" "+_tarX1m+" "+_tarX2a);
		
		try{
			for(int i = 0;i<NumOfNodes;i++){
				String _atX = _corX.get(i);
				String _atY = _corY.get(i);
				System.out.println("at i= "+i+" inside for "+_atX+","+_atY);
				if(_atX==_tarX2a){
					// lookup y
					if(_atY.equals(_tarY)){
						_neighbor += i+",";
					}
				}else if(_atX.equals(_tarX1a)){
					// lookup y+-1
					if(_atY.equals(_tarY1a)){
						_neighbor += i+",";
					}else if(_atY.equals(_tarY1m)){
						_neighbor += i+",";
					}
				}else if(_atX.equals(_tarX)){
					// lookup y+-2, y+-1
					if(_atY.equals(_tarY1a)){
						_neighbor += i+",";
					}else if(_atY.equals(_tarY1m)){
						_neighbor += i+",";
					}else if(_atY.equals(_tarY2a)){
						_neighbor += i+",";
					}else if(_atY.equals(_tarY2m)){
						_neighbor += i+",";
					}
				}else if(_atX.equals(_tarX1m)){
					// lookup y+-1
					if(_atY.equals(_tarY1a)){
						_neighbor += i+",";
					}else if(_atY.equals(_tarY1m)){
						_neighbor += i+",";
					}
				}else if(_atX.equals(_tarX2m)){
					// lookup y
					if(_atY.equals(_tarY)){
						_neighbor += i+",";
					}
				}// end if-else
			}// end for-loop
			/*
			if(_neighbor.length()>=2){
				_neighbor = _neighbor.replace(_neighbor.substring(_neighbor.length()-1), "");
			}
			*/
		}catch(Exception ex){
			System.out.println("Exception at fetchNei");
		}
		System.out.println("NNL_ = "+_neighbor);
		return _neighbor;
	}
	
}
