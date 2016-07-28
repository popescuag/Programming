package technical.interview.treenode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

import com.google.common.base.Function;

/**
 * Created by zhengwia on 19/12/2014.
 */
public class TreeNode<TData> implements ITreeNode<TData> {

  public TData data;
  public ArrayList<ITreeNode<TData>> children;

  public TreeNode(TData data) {
    this.data = data;
    this.children = new ArrayList<ITreeNode<TData>>();
  }

  public TData getData() {
    return this.data;
  }

  public ArrayList<ITreeNode<TData>> getChildren() {

    return this.children;
  }

  public ITreeNode<TData> addChild(TData childData) {
    TreeNode<TData> childNode = new TreeNode<TData>(childData);
    this.children.add(childNode);
    return childNode;
  }

  /**
   * DFS iterative implementation. It uses a stack for tree traversal. The nodes
   * are added to result list without being processed. The result list is then
   * reversed and filtered so only the nodes that match the predicate remain.
   */
  public ArrayList<ITreeNode<TData>> FindDepthFirst(Function<TData, Boolean> predicate) {
    ArrayList<ITreeNode<TData>> result = new ArrayList<ITreeNode<TData>>();
    final Stack<ITreeNode<TData>> nodeStack = new Stack<ITreeNode<TData>>();

    if (predicate == null) {
      throw new IllegalArgumentException("Predicate cannot be null");
    }

    ITreeNode<TData> currentNode = this;
    nodeStack.push(currentNode);

    while (!nodeStack.isEmpty()) {
      currentNode = nodeStack.pop();
      // add the node to result list without processing it
      result.add(currentNode);
      for (ITreeNode<TData> childNode : currentNode.getChildren()) {
        nodeStack.push(childNode);
      }
    }
    // reverse result list
    Collections.reverse(result);
    // filter out nodes that don't match predicate
    return (ArrayList<ITreeNode<TData>>) result.stream().filter(p -> predicate.apply(p.getData()))
        .collect(Collectors.toList());
  }

  /*
   * BreathFirstSearch non-recursive implementation. 
   * 3 differences from DFS 
   * 1. It uses a queue to store the result 
   * 2. It processes the node right after it is extracted from the queue 
   * 3. When the queue is empty the algorithm is over
   */
  public ArrayList<ITreeNode<TData>> FindDepthFirstBFSNonRecursive(Function<TData, Boolean> predicate) {
    ArrayList<ITreeNode<TData>> result = new ArrayList<ITreeNode<TData>>();
    final Queue<ITreeNode<TData>> nodeQueue = new ArrayDeque<ITreeNode<TData>>();

    if (predicate == null) {
      throw new IllegalArgumentException("Predicate cannot be null");
    }

    ITreeNode<TData> currentNode = this;
    nodeQueue.add(currentNode);
    while (!nodeQueue.isEmpty()) {
      currentNode = nodeQueue.poll();
      if (predicate.apply(currentNode.getData())) {
        result.add(currentNode);
      }
      for (ITreeNode<TData> childNode : currentNode.getChildren()) {
        nodeQueue.add(childNode);
      }
    }
    return result;
  }

  /**
   * This method computes the height of each tree node recursively and returns
   * the maximum height.
   */
  public int getHeight() {
    if (getChildren().size() == 0) {
      return 1;
    }
    List<Integer> maxHeight = new ArrayList<Integer>(1);
    for (ITreeNode<TData> childNode : getChildren()) {
      int nodeHeight = 1 + childNode.getHeight();
      if (maxHeight.size() == 0) {
        maxHeight.add(nodeHeight);
      } else {
        if (nodeHeight > maxHeight.get(0)) {
          maxHeight.set(0, nodeHeight);
        }
      }
    }
    return maxHeight.get(0);
  }
}
