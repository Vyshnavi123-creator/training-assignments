package Lambda_Problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenAndSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter the size of ArrayList");
        int size=sc.nextInt();
        System.out.println("Enter the ArrayList Elements");
        for(int i=0;i<size;i++) {
        	list.add(sc.nextInt());
        }
        System.out.println("Enter the element to be sqaured");
        int N=sc.nextInt();
        List<Integer> evenList=list.stream().filter((i)->i%2==0).collect(Collectors.toList());
        System.out.println(evenList);
        Square sq=new Square() {

			@Override
			public void square(int n) {
				// TODO Auto-generated method stub
				System.out.println(n*n);
			}
        	
        };
        sq.square(N);
	}

}
