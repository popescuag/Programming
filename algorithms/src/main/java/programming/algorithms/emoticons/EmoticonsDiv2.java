package programming.algorithms.emoticons;

import java.util.ArrayList;
import java.util.List;

public class EmoticonsDiv2 {
    private class Iteration {
        private int s = 0;
        private int c = 0;
        private boolean copyTried;
        private boolean pasteTried;

        public Iteration(int s, int c) {
            super();
            this.s = s;
            this.c = c;
        }

        public boolean isValid(int n) {
            return s == n;
        }

        public boolean canContinue(int n) {
            if (n >= s + c) {
                return true;
            }
            if (n % 2 == 1) {
                return (s < n/2 && c < n/2);
            }
            return false;
        }

        public Iteration chooseNext(int n) {
            if (! copyTried && ! pasteTried) {
                if (s*2 <= n && s > c) {
                    return copy();
                } else {
                    return paste();
                }
            }
            if (copyTried) {
                return paste();
            } else {
                return copy();
            }
        }

        public Iteration copy() {
            //paste was already tried. copy will not work here
            if (pasteTried && (s == c)) {
                return null;
            }
            copyTried = true;
System.out.println("copy: [s=" + s + ", c=" + s + "]");
            return new Iteration(s, s);
        }

        public Iteration paste() {
            pasteTried = true;
System.out.println("paste: [s=" + (s + c) + ", c=" + c + "]");
            return new Iteration(s + c, c);
        }

        public boolean isDone() {
            return copyTried && pasteTried;
        }
    }
    
    public EmoticonsDiv2() {
        iterations = new ArrayList<Iteration>();
        iterations.add(new Iteration(1, 0));
    }
    
    private List<Iteration> iterations;
    
    private Iteration getLastIteration() {
    	return iterations.get(iterations.size() - 1);
    }
    
    public int printSmiles(int n) {
	//start building iterations
        for (;;) {
            Iteration lastIteration = getLastIteration();
            //get last iteration and validate it
            if (lastIteration.isValid(n)) {
                return iterations.size() - 1;
            }
            if (! lastIteration.canContinue(n)) {
                //go back one iteration
                iterations.remove(lastIteration);
                lastIteration = getLastIteration();
            }
            while (lastIteration.isDone()) {
                iterations.remove(lastIteration);
                lastIteration = getLastIteration();
            }
            //choose another operation
            Iteration nextIteration = getLastIteration().chooseNext(n);
            if (nextIteration != null) {
                iterations.add(nextIteration);
            } else {
                //nothing to do with lastIteration. remove it
                iterations.remove(lastIteration);
            }
        }
    }
}
