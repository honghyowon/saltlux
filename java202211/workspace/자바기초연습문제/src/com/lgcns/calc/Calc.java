package com.lgcns.calc;
//
//public class Calc {
//
//
//	public int sum(int a, int b) {
//
//		return a+b;
//	}
//	
//	public int divide(int a, int b) {
//
//		return a/b;
//	}
//
//}//

import java.util.*;

class Calc {
  public Calc(){
  }
  public int sum(int a, int b){
    return a+b;
  }
  public int subtract(int a, int b){
    return a-b;
  }
  public int multiply(int a, int b){
    return a*b;
  }
  public int divide(int a, int b){
    if(b == 0 || b < 0) {
      return 0;
    } else {
      return a/b;
    }
  }
  
  
}

