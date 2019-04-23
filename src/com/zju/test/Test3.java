package com.zju.test;

import java.util.ArrayList;

public class Test3 {
		ArrayList<Integer> list = new ArrayList<>();
	
		public static void main(String[] args) {
			Test3 t = new Test3();
			int[][] mat = {{1,2,3},{4,5,6,},{7,8,9}} ;
			ArrayList<Integer> li = t.printMatrix(mat);
			for(int i:li) {
				System.out.print(i+" ");
			}
		}
			
		
	    public ArrayList<Integer> printMatrix(int [][] matrix) {
	        if(null == matrix){
	            return list;
	        }
	       int tR = 0;
	       int tC = 0;
	       int dR = matrix.length-1;
	       int dC = matrix[0].length-1;
	       while(tR<=dR && tC<=dC){
	           printEdge(matrix,tR++,tC++,dR--,dC--);
	       }
	        return list;
	    }
	    public void printEdge(int[][] matrix,int tR,int tC,int dR,int dC){
	        //只有一行的情况
	        if(tR == dR){
	            for(int i=tC;i<=dC;i++){
	                list.add(matrix[tR][i]);
	            }
	           
	        }else if(tC == dC){
	        		//只有一列
		            for(int i=tR;i<=dR;i++){
		                list.add(matrix[i][tC]);
		            }
		           
		    }else {
		    	//正常情况下的外圈打印
		        int curR = tR;
		        int curC = tC;
		        //上边
		        while(curC != dC){
		            list.add(matrix[curR][curC++]);
		        }
		        //右边
		        while(curR != dR){
		            list.add(matrix[curR++][curC]);
		        }
		        //下边
		        while(curC != tC){
		            list.add(matrix[curR][curC--]);
		        }
		        //左边
		        while(curR != tR){
		            list.add(matrix[curR--][curC]);
		        }
		    }
	      
	       
	    }
}
