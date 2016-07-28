package programming.algorithms.interview.treenode;
import java.util.ArrayList;

import com.google.common.base.Function;

/**
 * Created by zhengwia on 19/12/2014.
 */
public interface ITreeNode<TData>
{
    /// <summary>
    /// Gets the data associated with this tree node.
    /// </summary>
    TData getData();

    /// <summary>
    /// Gets the child nodes of this tree node.
    /// </summary>
    ArrayList<ITreeNode<TData>> getChildren();

    /// <summary>
    /// add child node with childData, return child node added.
    /// </summary>
    ITreeNode<TData> addChild(TData childData);

    /// <summary>
    /// Gets the height of the subtree where this node is the root of the subtree.
    /// The height is the maximum number of levels existing in this tree of this node and its descendents.
    /// If this node has no children its height is 1. If this node has children but none of those have
    /// children themselves then the height is 2, etc.
    /// </summary>
    int getHeight();

    /// <summary>
    /// Finds all nodes where the data associated the node matches the predicate,
    /// searching the tree, of this node and all those beneath, visiting in depth first order
    /// (as deep as possible before going along a level).
    /// </summary>
    /// <param name="predicate">Predicate used to test whether a node is a successful match for the search.</param>
    /// <returns>IEnumerable of the tree nodes that match the predicate.
    /// Throws <exception cref="System.ArgumentNullException"></exception> if predicate is null.
    /// </returns>
    ArrayList<ITreeNode<TData>> FindDepthFirst(Function<TData, Boolean> predicate);
}
