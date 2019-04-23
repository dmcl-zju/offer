package com.zju.test;

import java.text.DecimalFormat;

public class Calculator {
	private static double h;
	private static double f;
	private static double D;
	private static double v;
	private static double N;
	private static double angle;
	public static void calculator(double f,double D,double v,double h) {
		//晶片直径
		double D2 = 20*Math.pow(10, -3);//m----高频晶片直径
		//double h = 17*Math.pow(10, -2);//m
		//保留有效位数
		DecimalFormat df = new DecimalFormat("0.00");
		//单位转换
		h = h*Math.pow(10, -2);
		f=f*Math.pow(10, 6);//hz
		D=D*Math.pow(10, -3);//m
		//计算近场和扩散角
		N=D*D*f/(4*v);
		System.out.println("近        场："+df.format(100*N)+"cm");
		angle=360*Math.asin(1.22*v/(f*D))/(2*Math.PI);
		System.out.println("半扩散角："+df.format(angle)+"度");
		//角度的单位转换
		double angle_N = 2*Math.PI*angle/360;
		//计算内径
		double innerD;
		innerD=2*N*Math.tan(angle_N);
		System.out.println("声场内径："+df.format(100*innerD)+"cm");
		//计算外径
		double h1 = N*Math.cos(angle_N);
		double h2 = h-h1;
		//输出测试
		//System.out.println(h+"--"+h2+"--"+h1);
		double wide = 2*h2*Math.sin(angle_N)+D;
		//输出测试
		//System.out.println(wide);
		double x1 = wide*Math.cos(angle_N);
		double h3 = wide*Math.sin(angle_N);
		double x2 = h3*Math.tan(2*angle_N);
		double outerD = 2*(x2+x1)+innerD+D2;
		System.out.println("声场外径："+df.format(100*outerD)+"cm");
		
	}
	
	public static void main(String[] args) {
		//System.out.println(360*Math.asin(1)/(2*Math.PI));
		f=0.5;
		D=10;
		v=1540;
		h=15;
		calculator(f,D,v,h);
	}
}
