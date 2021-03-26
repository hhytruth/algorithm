package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
	String name;
	int korean;
	int english;
	int math;
	public Student(int k,int e,int m,String n) {
		korean=k;
		english=e;
		math=m;
		name=n;
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.korean<o.korean)return 1;
		else if(this.korean==o.korean) {
			if(this.english>o.english)return 1;
			else if(this.english==o.english) {
				if(this.math<o.math)return 1;
				else if(this.math==o.math) {
					if(this.name.compareTo(o.name)>0)return 1;
				}
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return (name+" "+korean+" "+english+" "+math);
	}
	
	
	
}

public class boj_10825_국영수 {

	public static void main(String[] args) {
		int N,korean,english,math;
		String name;
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		Student[] list=new Student[N];
		for(int i=0;i<N;i++) {
			name=sc.next();
			korean=sc.nextInt();
			english=sc.nextInt();
			math=sc.nextInt();
			Student s=new Student(korean,english,math,name);
			list[i]=s;
			
		}
		Arrays.sort(list);
		
		for(Student s: list) {
			System.out.println(s.name);
		}
	}
	
	
	
}
