package lefthanded1;

public class LeftAndRightHandedDiv1 {
    public long countSwaps(String Y, int A, int B, int C, int D, int N) {
	//build initial String
	//Let T[0]=A, and for each i from 1 to N-1 let T[i] = (T[i-1] * B + C) % D, where % is the modulo operator. Now, for each i from 0 to N-1, let P[i] = Y[ T[i] % length(Y) ]. 
	long[] T = new long[N];
	String P = null;
	int yLen = Y.length();
	T[0] = A;
	StringBuilder strBuilder = new StringBuilder();
	for (int i = 1; i < N; i++) {
	    T[i] = (T[i - 1] * B + C) % D;
	}
	long collisionsCount = 0;
	char prevChar = 'Z';
	for (int i = 0; i < N; i++) {
	    char currentChar = Y.charAt((int) (T[i] % yLen));
	    if (currentChar == 'L' && prevChar == 'R') {
		 collisionsCount ++;
	    }
	    prevChar = currentChar;
	    strBuilder.append(currentChar);
	}
	P = strBuilder.toString();
	//check last-first collision
	if (P.charAt(0) == 'L' && P.charAt(N - 1) == 'R') {
	    collisionsCount++;
	}
System.out.println(strBuilder.length() + " " + collisionsCount);
//System.out.println(P);
//System.out.println(P.substring(0,10));
	long swaps = 0;
	int idx = 0;
	//while (collisionsCount > 1) {
	while (collisionsCount > 1) {
	    collisionsCount = count(strBuilder.toString());
System.out.println(collisionsCount);
	    int pLength = strBuilder.length();
	    idx = getNextCollision(strBuilder, idx, pLength);
	    if (idx == -1) {
		break;
	    }
	    if (collisionsCount == 243541) {
		int h = 0;
		h++;
	    }
	    
	    //move the L to the left until LL
	    do {
		if (idx == 0) {
		    strBuilder.setCharAt(0, 'L');
		    strBuilder.setCharAt(pLength - 1, 'R');
		    //collisionsCount--;    
		} else {
		    strBuilder.setCharAt(idx, 'L');
		    strBuilder.setCharAt(idx+1, 'R');
    		    if (strBuilder.charAt(idx + 2) != 'L') {
    			//collisionsCount--;
    			idx--;
    		    } else {
    			idx++;
    		    }
		}
		
		swaps++;
	    } while (idx > 0 && strBuilder.charAt(idx) == 'R');

	    idx = 0;
	    /*
	    //check for special RRLL case and solve the collision
	    int[] swapData = chooseSwapIdx(strBuilder, idx);
	    if (swapData[0] == -1) {
		continue;
	    }
	    if (swapData[2] == 0) {
		idx -= 2;
	    } else {
		idx++;
	    }
	    char tmpChar = strBuilder.charAt(swapData[0]);
	    strBuilder.setCharAt(swapData[0], strBuilder.charAt(swapData[1]));
	    strBuilder.setCharAt(swapData[1], tmpChar);
	    swaps++;
	    collisionsCount -= swapData[2];
	    if (collisionsCount == 143315) {
		int j = 0;
		j++;
	    }
	    */
//System.out.println(collisionsCount);
	}
System.out.println(count(strBuilder.toString()));	
	return swaps;
    }
    
    /**
     * 
     * @param strBuilder
     * @param rIdx
     * @return arr[0] = sourceIdx, arr[1] = destIdx, arr[2] = number of collision solved
     */
    private int[] chooseSwapIdx(StringBuilder strBuilder, int rIdx) {
	int[] swapData = new int[3];
	int pLength = strBuilder.length();
	
	//we need to look at 4 consecutive chars.
	//special cases: R position is 0, 1, next to last, last
	if (rIdx == 0) {
	    //RL...
	    //move R to the back. swap with the latest char if it is L
	    if (strBuilder.charAt(pLength - 1) == 'L') {
		swapData[0] = 0;
		swapData[1] = pLength - 1;
		swapData[2] = 1; 
	    } else {
		//last char is R
		swapData[0] = 0;
		swapData[1] = 1;
		swapData[2] = strBuilder.charAt(2) == 'L' ? 0 : 1;
	    }
	} else if (rIdx == 1) {
	    //.RL...
	    swapData[0] = 1;
	    swapData[1] = 2;
	    //4 cases: LRLL, LRLR, RRLL, RRLR
	    if (strBuilder.charAt(0) == 'L') {
		if (strBuilder.charAt(3) == 'L') {
		    swapData[2] = 0;
		} else {
		    swapData[2] = 1;
		}
	    } else {
		if (strBuilder.charAt(3) == 'L') {
		    swapData[2] = -1;
		} else {
		    swapData[2] = 0;
		}
	    }
	} else if (rIdx == pLength - 1) {
	    //....RL
	    swapData[0] = pLength - 1;
	    swapData[1] = pLength - 2;
	    //4 cases: LRLL, LRLR, RRLL, RRLR
	    if (strBuilder.charAt(pLength - 3) == 'L') {
		if (strBuilder.charAt(0) == 'L') {
		    swapData[2] = 0;
		} else {
		    swapData[2] = 1;
		}
	    } else {
		if (strBuilder.charAt(0) == 'L') {
		    swapData[2] = -1;
		} else {
		    swapData[2] = 0;
		}
	    }
	} else if (rIdx == pLength) {
	    //L...R
	    //do nothing, L and R are in perfect locations
	    swapData[0] = -1;
	    swapData[1] = -1;
	    swapData[2] = 0;
	} else {
	    //...RL...
	    swapData[0] = rIdx;
	    swapData[1] = rIdx + 1;
	    //4 cases: LRLL, LRLR, RRLL, RRLR
	    try {
    	    	if (strBuilder.charAt(rIdx - 1) == 'L') {
    	    	    if (strBuilder.charAt(getNextIdxWrap(rIdx, 2, pLength)) == 'L') {
    	    		swapData[2] = 0;
    	    	    } else {
    	    		swapData[2] = 1;
    	    	    }
    	    	} else {
    	    	    if (strBuilder.charAt(getNextIdxWrap(rIdx, 2, pLength)) == 'L') {
    	    		swapData[2] = -1;
    	    	    } else {
    	    		swapData[2] = 0;
    	    	    }
    	    	}
	    } catch (Exception e) {
		e.printStackTrace();
System.out.println(rIdx + " " + pLength + " " + strBuilder.charAt(rIdx) + strBuilder.charAt(rIdx + 1));
		throw (e);
	    }
	}
	return swapData;
    }
    
    private int getNextIdxWrap(int idx, int offset, int length) {
	if (idx + offset >= length) {
	    return 0;
	}
	return idx + offset;
    }
    
    //Returns R index
    private int getNextCollision(StringBuilder P, int startIdx, int pLength) {
	int collisionIdx = -1;
	
	if (startIdx == 0 && P.charAt(0) == 'L' && P.charAt(pLength - 1) == 'R') {
	    return 0;
	}
	
	for (int i = startIdx; i < pLength; i++) {
	    if ((i == pLength - 1 && (P.charAt(i) == 'R' && P.charAt(0) == 'L')) || (P.charAt(i) == 'R' && P.charAt(i + 1) == 'L')) {
		collisionIdx = i;
		break;
	    }
	}
	if (collisionIdx == -1) {
	    //go around
	    for (int i = 0; i < startIdx; i++) {
		if ((i == pLength - 1 && (P.charAt(i) == 'R' && P.charAt(0) == 'L')) || (P.charAt(i) == 'R' && P.charAt(i + 1) == 'L')) {
		    collisionIdx = i;
		    break;
		}
	    }
	}
	return collisionIdx;
    }
    
    public int count(String S) {
   	int count = 0;
   	
   	for (int i = 0; i < S.length(); i++) {
   	    if (i != S.length() - 1 && (S.charAt(i) == 'R' && S.charAt(i + 1) == 'L')) {
   		count ++;
   	    }
   	}
   	return count;
       }
}
