package com.bean;

import java.util.Scanner;

public class Test1 {

	public static void main(String aman[]){
	Scanner sc=new Scanner (System.in);
	int n;
	int numb=sc.nextInt();
	n=sc.nextInt();
	int a[]=new int[n];
	for(int i=0;i<n;i++){
	a[i]=sc.nextInt();
	}

	for(int i=0;i<n;i++){
	if(numb==i+1){
	System.out.println(a[i]);
	}
	}


	}}
	


