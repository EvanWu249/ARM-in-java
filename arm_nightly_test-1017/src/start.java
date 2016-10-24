import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class start {
	/*
	 * Made by Hsin Han Wu
	 * This file is an entry for the program
	 */
	// Starting process from field_test.java
	public static void main(String args[]){
		int NumOfNodes = 6000;
		field_test ft = new field_test(NumOfNodes);
		// now output nodes' info
		nodeinfoWriter(ft.getNodePosX(), ft.getNodePosY(), NumOfNodes);
		//rmnSelect rs = new rmnSelect();
		NNL nl = new NNL();
		nl.calculateNNL(ft.getNodePosX(), ft.getNodePosY(), NumOfNodes);
		
	}// end main
	
	public static void nodeinfoWriter(ArrayList<String> _InfoAtX, ArrayList<String> _InfoAtY, int _nodenum){
		// _limit is for limit line number for each file;_pversion is for which row of files it has generated
		int _limit = 0, _pversion = 1;
		try {
			// TODO: fix when numofnodes > 6000
			FileWriter newfw =  new FileWriter("i.txt");
			for(int i=0;i<_nodenum;i++){
				if(_limit == 0){
					newfw = new FileWriter(new File("nodesinfo_from"+i+"_"+_pversion+".html"));
					newfw.write("<html><body><table border=1px><tr><td>Node No.</td><td>Coordinate</td></tr>");
				}else if(_limit == 5000){
					newfw.write("</table></body></html>");
					newfw.close();
					newfw = new FileWriter(new File("nodesinfo_from"+i+"_"+_pversion+".html"));
					_limit = 0;
					_pversion++;
					newfw.write("<html><body><table border=1px><tr><td>Node No.</td><td>Coordinate</td></tr>");
				}
				_limit++;// Add by 1 when a data was stored into txt file
				newfw.write("<tr><td>Node "+i+"</td><td>"+" ("+_InfoAtX.get(i)+", "+_InfoAtY.get(i)+")</td></tr>");
				newfw.write(System.getProperty("line.separator"));
			}
			newfw.write("</table></body></html>");
			newfw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
