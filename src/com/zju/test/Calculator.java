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
		//��Ƭֱ��
		double D2 = 20*Math.pow(10, -3);//m----��Ƶ��Ƭֱ��
		//double h = 17*Math.pow(10, -2);//m
		//������Чλ��
		DecimalFormat df = new DecimalFormat("0.00");
		//��λת��
		h = h*Math.pow(10, -2);
		f=f*Math.pow(10, 6);//hz
		D=D*Math.pow(10, -3);//m
		//�����������ɢ��
		N=D*D*f/(4*v);
		System.out.println("��        ����"+df.format(100*N)+"cm");
		angle=360*Math.asin(1.22*v/(f*D))/(2*Math.PI);
		System.out.println("����ɢ�ǣ�"+df.format(angle)+"��");
		//�Ƕȵĵ�λת��
		double angle_N = 2*Math.PI*angle/360;
		//�����ھ�
		double innerD;
		innerD=2*N*Math.tan(angle_N);
		System.out.println("�����ھ���"+df.format(100*innerD)+"cm");
		//�����⾶
		double h1 = N*Math.cos(angle_N);
		double h2 = h-h1;
		//�������
		//System.out.println(h+"--"+h2+"--"+h1);
		double wide = 2*h2*Math.sin(angle_N)+D;
		//�������
		//System.out.println(wide);
		double x1 = wide*Math.cos(angle_N);
		double h3 = wide*Math.sin(angle_N);
		double x2 = h3*Math.tan(2*angle_N);
		double outerD = 2*(x2+x1)+innerD+D2;
		System.out.println("�����⾶��"+df.format(100*outerD)+"cm");
		
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
