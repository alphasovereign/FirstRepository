package com.algorithms.arrays;


import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.io.InputStream;


public class AlgorithmCrush {
	
	public static void main(String[] args) {
		
		int a[] = { 1,2,3,4,5,6,7,8,9,10 };
		int size = 10;
		int rotations = 5 ;
		int limit = (size - rotations) ;
		int temp;
		int i;
		for(   i = 0 ; i < limit ; i ++){
			
			temp = a[i];
			a[ i ] = a[  i + rotations] ;
			a[ i + rotations] = temp;
			
		}
		
		int rr = i ;
		for(    ; i < size-1 ; i ++){
			
			temp = a[i];
			a[ i ] = a[  i + 1] ;
			a[ i + 1] = temp;
			
		}
		
		if( size%2 == 0 ){
			i = rr;
			for(    ; i < size-1 ; i ++){
				
				temp = a[i];
				a[ i ] = a[  i + 1] ;
				a[ i + 1] = temp;
				
			}
			
		}

		
		for( int u : a )
		System.out.print(    u + ","  );
		
		
	}
	
	public static void main(int[] args) {
//		InputStream inputStream = System.in;
//		OutputStream outputStream = System.out;
//		FastScanner in = new FastScanner(inputStream);
//		FastPrinter out = new FastPrinter(outputStream);
//		Task2 solver = new Task2();
//		solver.solve(1, in, out);
//		out.close();
		
		
		// 1 2 100
		// 2 3 100
		// 3 4 100
		
		int aa[][] = {
				{1,2,100},
				{2,5,100},
				{3,4,100}
		};
		
		int a[] = new int[7]; 
		for( int i = 0; i< 3 ; i ++  ){
			
			a[  aa[i][ 0 ] ] += aa[i][2];
			a[  aa[i][ 1 ]+1 ] -= aa[i][2];
		}
		
		for(int j = 1; j< 6; j++){
			System.out.println( a[j] );;
		}
		
		for(int j = 1; j< 6; j++){
			a[j+1] = a[j] + a[j+1];
		}
		
		for(int j = 0; j< 6; j++){
			System.out.println( a[j]  );
		}
		
		
	}
}

class Task2 {
    /////////////////////////////////////////////////////////////

    public void solve(int testNumber, FastScanner in, FastPrinter out) {
    int n=in.nextInt(),m=in.nextInt();
    long[] A= new long[n+2];
        for (int i = 0; i < m; i++) {
            int a=in.nextInt(),b=in.nextInt();
            long k=in.nextLong();
            A[a]+=k;
            A[b+1]-=k;
        }
    long ans=0,cur=0;
        for (int i = 0; i <= n+1 ; i++) {
           cur+=A[i];
           ans=Math.max(cur,ans);
        }
        out.println(ans);
    }
}

class FastScanner extends BufferedReader {

    public FastScanner(InputStream is) {
        super(new InputStreamReader(is));
    }

    public int read() {
        try {
            int ret = super.read();
//            if (isEOF && ret < 0) {
//                throw new InputMismatchException();
//            }
//            isEOF = ret == -1;
            return ret;
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        if (c < 0) {
            return null;
        }
        while (c >= 0 && !isWhiteSpace(c)) {
            sb.appendCodePoint(c);
            c = read();
        }
        return sb.toString();
    }

    static boolean isWhiteSpace(int c) {
        return c >= 0 && c <= 32;
    }

    public int nextInt() {
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int ret = 0;
        while (c >= 0 && !isWhiteSpace(c)) {
            if (c < '0' || c > '9') {
                throw new NumberFormatException("digit expected " + (char) c
                        + " found");
            }
            ret = ret * 10 + c - '0';
            c = read();
        }
        return ret * sgn;
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    }

class FastPrinter extends PrintWriter {

    public FastPrinter(OutputStream out) {
        super(out);
    }

    public FastPrinter(Writer out) {
        super(out);
    }


}

